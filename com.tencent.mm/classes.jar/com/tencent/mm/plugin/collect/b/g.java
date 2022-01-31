package com.tencent.mm.plugin.collect.b;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.bv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  extends c<bv>
  implements com.tencent.mm.ah.f
{
  private static final String iGQ = com.tencent.mm.compatible.util.e.bkH + "wallet/voice/";
  private static final com.tencent.mm.bv.b iGR = com.tencent.mm.bv.b.Xp("元");
  private MediaPlayer iGS;
  private MediaPlayer iGT;
  public ConcurrentLinkedQueue<g.b> iGU;
  private int iGV;
  private int iGW;
  private long iGX;
  private WeakReference<ArrayList<String>> iGY;
  private boolean isPlaying = false;
  
  public g()
  {
    this.udX = bv.class.getName().hashCode();
  }
  
  private List<String> aEu()
  {
    if ((this.iGY == null) || (this.iGY.get() == null))
    {
      y.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.iGY = new WeakReference(new ArrayList(bk.gg((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyX, ""), ",")));
    }
    return (List)this.iGY.get();
  }
  
  public static boolean aEv()
  {
    y.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    return com.tencent.mm.vfs.e.K(iGQ, true);
  }
  
  private void aEw()
  {
    for (;;)
    {
      final g.b localb;
      int i;
      try
      {
        if (System.currentTimeMillis() - this.iGX > 10000L)
        {
          y.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.iGX) });
          this.isPlaying = false;
        }
        if (this.isPlaying)
        {
          y.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          return;
        }
        this.isPlaying = true;
        this.iGX = System.currentTimeMillis();
        localb = (g.b)this.iGU.poll();
        com.tencent.mm.compatible.b.f localf = com.tencent.mm.compatible.b.f.yi();
        i = localf.getStreamMaxVolume(3);
        this.iGV = localf.getStreamVolume(3);
        this.iGW = Math.round(i * 0.5F);
        y.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.iGV), Integer.valueOf(i), Integer.valueOf(this.iGW) });
        if (Build.VERSION.SDK_INT < 23) {
          break label528;
        }
        bool = localf.dui.isStreamMute(3);
        y.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.iGV == 0) || (bool))
        {
          y.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localb != null)
          {
            i = localb.iHf;
            h localh = h.nFQ;
            if (localb == null) {
              break label465;
            }
            String str1 = localb.bHZ;
            localh.f(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.iGV > 0) && (this.iGV < this.iGW) && (!bool)) {
            localf.aX(3, this.iGW);
          }
          if (localb == null) {
            break label520;
          }
          i = a.i.collect_prefix_voice;
          int j = localb.iHf;
          if (j == 2) {
            i = a.i.md_prefix_voice;
          }
          if (bk.bl(localb.fileName)) {
            break label472;
          }
          y.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(j) });
          this.iGS = a.a(ae.getContext(), i, new g.1(this, localb), new g.2(this, localb));
          if (this.iGS == null) {
            continue;
          }
          i = this.iGS.getDuration();
          y.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          ai.l(new g.3(this), i + 1000);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label465:
      String str2 = "";
      continue;
      label472:
      this.iGS = a.a(ae.getContext(), i, new g.4(this, localb), new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          y.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
          g.e(g.this);
          g.d(g.this);
          g.h(g.this);
          h.nFQ.f(14404, new Object[] { Integer.valueOf(3), localb.bHZ, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localb.iHf) });
          return false;
        }
      });
      h.nFQ.a(699L, 2L, 1L, false);
      continue;
      label520:
      this.isPlaying = false;
      continue;
      label528:
      boolean bool = false;
    }
  }
  
  private static int aEx()
  {
    if (com.tencent.mm.compatible.b.f.yi().yn()) {
      return 1;
    }
    return 0;
  }
  
  private static boolean m(String paramString, byte[] paramArrayOfByte)
  {
    com.tencent.mm.kernel.g.DQ();
    if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable()) {
      y.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
    }
    while (com.tencent.mm.vfs.e.b(paramString, paramArrayOfByte, paramArrayOfByte.length) != 0) {
      return false;
    }
    return true;
  }
  
  private static int py(int paramInt)
  {
    int i = 2;
    if (paramInt == 1) {
      i = 3;
    }
    return i;
  }
  
  private boolean zx(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (bk.bl(paramString))
        {
          y.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[] { paramString });
          bool = true;
          return bool;
        }
        List localList = aEu();
        Iterator localIterator = aEu().iterator();
        if (localIterator.hasNext())
        {
          if (((String)localIterator.next()).equals(paramString))
          {
            y.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[] { paramString });
            bool = true;
          }
        }
        else
        {
          localList.add(paramString);
          if (localList.size() > 10)
          {
            y.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
            int i = localList.size();
            paramString = localList.subList(i - 10, i);
            com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyX, bk.c(paramString, ","));
            bool = false;
          }
          else
          {
            paramString = localList;
          }
        }
      }
      finally {}
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof i))
    {
      paramString = (i)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s", new Object[] { Integer.valueOf(paramString.iHk.sKD) });
        if (paramString.iHk.sKD == 1)
        {
          y.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramString.brn) });
          h.nFQ.f(14404, new Object[] { Integer.valueOf(3), paramString.bHZ, Integer.valueOf(1), "", Integer.valueOf(1) });
        }
      }
    }
    g.b localb;
    while (!(paramm instanceof n))
    {
      return;
      if (paramString.iHk.iHq == 0)
      {
        paramm = new com.tencent.mm.vfs.b(iGQ);
        if ((!paramm.exists()) && (!paramm.mkdirs()))
        {
          y.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
          return;
        }
        paramm = iGQ + UUID.randomUUID().toString() + ".tmp";
        y.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramm });
        if (m(paramm, paramString.iHk.sKC.oY))
        {
          localb = new g.b(this, (byte)0);
          localb.fileName = paramm;
          localb.bNM = paramString.iHk.sKB;
          localb.iHf = 1;
          localb.bHZ = paramString.bHZ;
          localb.iHg = paramString.iHk.sKD;
          this.iGU.add(localb);
          aEw();
        }
        for (;;)
        {
          h.nFQ.f(15763, new Object[] { paramString.bHZ, Integer.valueOf(1), Integer.valueOf(py(paramString.source)), Long.valueOf(paramString.iHl), Integer.valueOf(aEx()) });
          return;
          y.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
        }
      }
      if (paramString.iHk.iHq <= 100)
      {
        y.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
        paramm = new g.b(this, (byte)0);
        paramm.iHf = 1;
        paramm.bHZ = paramString.bHZ;
        this.iGU.add(paramm);
        aEw();
        h.nFQ.f(15763, new Object[] { paramString.bHZ, Integer.valueOf(2), Integer.valueOf(py(paramString.source)), Long.valueOf(paramString.iHl), Integer.valueOf(aEx()) });
        return;
      }
      y.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
      h.nFQ.f(14404, new Object[] { Integer.valueOf(3), paramString.bHZ, Integer.valueOf(2), "", Integer.valueOf(1) });
      h.nFQ.f(15763, new Object[] { paramString.bHZ, Integer.valueOf(2), Integer.valueOf(py(paramString.source)), Long.valueOf(paramString.iHl), Integer.valueOf(aEx()) });
      return;
      y.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      paramm = new g.b(this, (byte)0);
      paramm.iHf = 1;
      paramm.bHZ = paramString.bHZ;
      this.iGU.add(paramm);
      aEw();
      h.nFQ.f(15763, new Object[] { paramString.bHZ, Integer.valueOf(2), Integer.valueOf(py(paramString.source)), Long.valueOf(paramString.iHl), Integer.valueOf(aEx()) });
      h.nFQ.f(14404, new Object[] { Integer.valueOf(3), paramString.bHZ, Integer.valueOf(3), "", Integer.valueOf(1) });
      return;
    }
    paramString = (n)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramString.iHG.iHq == 0)
      {
        paramm = new com.tencent.mm.vfs.b(iGQ);
        if ((!paramm.exists()) && (!paramm.mkdirs()))
        {
          y.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
          return;
        }
        paramm = iGQ + UUID.randomUUID().toString() + ".tmp";
        y.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramm });
        if (m(paramm, paramString.iHG.sKC.oY))
        {
          localb = new g.b(this, (byte)0);
          localb.fileName = paramm;
          localb.bNM = paramString.iHG.sKB;
          localb.iHf = 2;
          this.iGU.add(localb);
          aEw();
          return;
        }
        y.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
        return;
      }
      h.nFQ.f(14404, new Object[] { Integer.valueOf(3), paramString.bHZ, Integer.valueOf(2), "", Integer.valueOf(2) });
      return;
    }
    y.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
    h.nFQ.f(14404, new Object[] { Integer.valueOf(3), paramString.bHZ, Integer.valueOf(3), "", Integer.valueOf(2) });
  }
  
  private static final class a
  {
    /* Error */
    public static MediaPlayer a(android.content.Context paramContext, int paramInt, MediaPlayer.OnCompletionListener paramOnCompletionListener, MediaPlayer.OnErrorListener paramOnErrorListener)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +29 -> 30
      //   4: ldc 14
      //   6: ldc 16
      //   8: iconst_2
      //   9: anewarray 4	java/lang/Object
      //   12: dup
      //   13: iconst_0
      //   14: aload_0
      //   15: aastore
      //   16: dup
      //   17: iconst_1
      //   18: iload_1
      //   19: invokestatic 22	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   22: aastore
      //   23: invokestatic 28	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   26: aconst_null
      //   27: astore_2
      //   28: aload_2
      //   29: areturn
      //   30: aload_0
      //   31: iload_1
      //   32: invokevirtual 34	android/content/Context:getString	(I)Ljava/lang/String;
      //   35: astore 8
      //   37: new 36	android/media/MediaPlayer
      //   40: dup
      //   41: invokespecial 40	android/media/MediaPlayer:<init>	()V
      //   44: astore 7
      //   46: aload 7
      //   48: iconst_3
      //   49: invokevirtual 44	android/media/MediaPlayer:setAudioStreamType	(I)V
      //   52: ldc 14
      //   54: ldc 46
      //   56: iconst_4
      //   57: anewarray 4	java/lang/Object
      //   60: dup
      //   61: iconst_0
      //   62: aload 7
      //   64: invokevirtual 50	java/lang/Object:hashCode	()I
      //   67: invokestatic 22	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   70: aastore
      //   71: dup
      //   72: iconst_1
      //   73: aload 8
      //   75: aastore
      //   76: dup
      //   77: iconst_2
      //   78: aload_0
      //   79: aastore
      //   80: dup
      //   81: iconst_3
      //   82: iload_1
      //   83: invokestatic 22	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   86: aastore
      //   87: invokestatic 53	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   90: aload_0
      //   91: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   94: aload 8
      //   96: invokevirtual 63	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
      //   99: astore_0
      //   100: aload 7
      //   102: aload_0
      //   103: invokevirtual 69	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   106: aload_0
      //   107: invokevirtual 73	android/content/res/AssetFileDescriptor:getStartOffset	()J
      //   110: aload_0
      //   111: invokevirtual 76	android/content/res/AssetFileDescriptor:getLength	()J
      //   114: invokevirtual 80	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
      //   117: aload 7
      //   119: iconst_0
      //   120: invokevirtual 84	android/media/MediaPlayer:setLooping	(Z)V
      //   123: aload 7
      //   125: new 86	com/tencent/mm/plugin/collect/b/g$a$1
      //   128: dup
      //   129: aload 7
      //   131: aload_3
      //   132: invokespecial 89	com/tencent/mm/plugin/collect/b/g$a$1:<init>	(Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnErrorListener;)V
      //   135: invokevirtual 93	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
      //   138: aload 7
      //   140: new 95	com/tencent/mm/plugin/collect/b/g$a$2
      //   143: dup
      //   144: aload 8
      //   146: aload 7
      //   148: aload_2
      //   149: invokespecial 98	com/tencent/mm/plugin/collect/b/g$a$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnCompletionListener;)V
      //   152: invokevirtual 102	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
      //   155: aload 7
      //   157: invokevirtual 105	android/media/MediaPlayer:prepare	()V
      //   160: aload 7
      //   162: invokevirtual 108	android/media/MediaPlayer:start	()V
      //   165: aload 7
      //   167: invokevirtual 50	java/lang/Object:hashCode	()I
      //   170: istore 4
      //   172: invokestatic 114	android/os/Looper:myLooper	()Landroid/os/Looper;
      //   175: ifnull +80 -> 255
      //   178: iconst_1
      //   179: istore 5
      //   181: invokestatic 117	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   184: ifnull +77 -> 261
      //   187: iconst_1
      //   188: istore 6
      //   190: ldc 14
      //   192: ldc 119
      //   194: iconst_3
      //   195: anewarray 4	java/lang/Object
      //   198: dup
      //   199: iconst_0
      //   200: iload 4
      //   202: invokestatic 22	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   205: aastore
      //   206: dup
      //   207: iconst_1
      //   208: iload 5
      //   210: invokestatic 124	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   213: aastore
      //   214: dup
      //   215: iconst_2
      //   216: iload 6
      //   218: invokestatic 124	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   221: aastore
      //   222: invokestatic 53	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   225: aload 7
      //   227: astore_2
      //   228: aload_0
      //   229: ifnull -201 -> 28
      //   232: aload_0
      //   233: invokevirtual 127	android/content/res/AssetFileDescriptor:close	()V
      //   236: aload 7
      //   238: areturn
      //   239: astore_0
      //   240: ldc 14
      //   242: aload_0
      //   243: ldc 129
      //   245: iconst_0
      //   246: anewarray 4	java/lang/Object
      //   249: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   252: aload 7
      //   254: areturn
      //   255: iconst_0
      //   256: istore 5
      //   258: goto -77 -> 181
      //   261: iconst_0
      //   262: istore 6
      //   264: goto -74 -> 190
      //   267: astore_2
      //   268: aconst_null
      //   269: astore_0
      //   270: ldc 14
      //   272: ldc 135
      //   274: iconst_2
      //   275: anewarray 4	java/lang/Object
      //   278: dup
      //   279: iconst_0
      //   280: iload_1
      //   281: invokestatic 22	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   284: aastore
      //   285: dup
      //   286: iconst_1
      //   287: aload_2
      //   288: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   291: aastore
      //   292: invokestatic 28	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   295: ldc 14
      //   297: aload_2
      //   298: ldc 129
      //   300: iconst_0
      //   301: anewarray 4	java/lang/Object
      //   304: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   307: aload 7
      //   309: invokevirtual 142	android/media/MediaPlayer:release	()V
      //   312: aload_0
      //   313: ifnull +7 -> 320
      //   316: aload_0
      //   317: invokevirtual 127	android/content/res/AssetFileDescriptor:close	()V
      //   320: aconst_null
      //   321: areturn
      //   322: astore_0
      //   323: ldc 14
      //   325: aload_0
      //   326: ldc 129
      //   328: iconst_0
      //   329: anewarray 4	java/lang/Object
      //   332: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   335: goto -15 -> 320
      //   338: astore_2
      //   339: aconst_null
      //   340: astore_0
      //   341: aload_0
      //   342: ifnull +7 -> 349
      //   345: aload_0
      //   346: invokevirtual 127	android/content/res/AssetFileDescriptor:close	()V
      //   349: aload_2
      //   350: athrow
      //   351: astore_0
      //   352: ldc 14
      //   354: aload_0
      //   355: ldc 129
      //   357: iconst_0
      //   358: anewarray 4	java/lang/Object
      //   361: invokestatic 133	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   364: goto -15 -> 349
      //   367: astore_2
      //   368: goto -27 -> 341
      //   371: astore_2
      //   372: goto -31 -> 341
      //   375: astore_2
      //   376: goto -106 -> 270
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	379	0	paramContext	android.content.Context
      //   0	379	1	paramInt	int
      //   0	379	2	paramOnCompletionListener	MediaPlayer.OnCompletionListener
      //   0	379	3	paramOnErrorListener	MediaPlayer.OnErrorListener
      //   170	31	4	i	int
      //   179	78	5	bool1	boolean
      //   188	75	6	bool2	boolean
      //   44	264	7	localMediaPlayer	MediaPlayer
      //   35	110	8	str	String
      // Exception table:
      //   from	to	target	type
      //   232	236	239	java/io/IOException
      //   90	100	267	java/lang/Exception
      //   316	320	322	java/io/IOException
      //   90	100	338	finally
      //   345	349	351	java/io/IOException
      //   100	178	367	finally
      //   181	187	367	finally
      //   190	225	367	finally
      //   270	312	371	finally
      //   100	178	375	java/lang/Exception
      //   181	187	375	java/lang/Exception
      //   190	225	375	java/lang/Exception
    }
    
    public static MediaPlayer a(String paramString, MediaPlayer.OnCompletionListener paramOnCompletionListener, MediaPlayer.OnErrorListener paramOnErrorListener)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      localMediaPlayer.setAudioStreamType(3);
      y.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
      try
      {
        localMediaPlayer.setDataSource(paramString);
        localMediaPlayer.setLooping(false);
        localMediaPlayer.setOnErrorListener(new g.a.3(localMediaPlayer, paramOnErrorListener));
        localMediaPlayer.setOnCompletionListener(new g.a.4(paramString, localMediaPlayer, paramOnCompletionListener));
        localMediaPlayer.prepare();
        localMediaPlayer.start();
        int i = localMediaPlayer.hashCode();
        boolean bool1;
        if (Looper.myLooper() != null)
        {
          bool1 = true;
          if (Looper.getMainLooper() == null) {
            break label161;
          }
        }
        label161:
        for (boolean bool2 = true;; bool2 = false)
        {
          y.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return localMediaPlayer;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramOnCompletionListener)
      {
        y.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
        y.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
        localMediaPlayer.release();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g
 * JD-Core Version:    0.7.0.1
 */