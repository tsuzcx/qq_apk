package com.tencent.mm.f.b;

import android.media.MediaRecorder;
import com.tencent.mm.be.d;
import com.tencent.mm.be.d.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import java.util.Random;

public final class b
{
  private static Object bBY = new Object();
  private int bBN = 0;
  private String bBO = null;
  private int bBP;
  private final Object bBQ = new Object();
  private com.tencent.mm.f.c.c bBR = null;
  private a bBS;
  private com.tencent.mm.be.c bBT = null;
  private d.a bBU = null;
  private long bBV = 0L;
  private long bBW = 0L;
  private int bBX = 0;
  private int bBZ = 16000;
  private boolean bCa = false;
  public MediaRecorder bCb;
  public c bCc = null;
  public com.tencent.mm.compatible.b.b.a bCd;
  public b.b bCe;
  private volatile boolean bCf = false;
  private g.a bCg = new g.a();
  private int bCh = 0;
  private int bCi = 0;
  private c.a bCj = new b.2(this);
  private boolean bCk = false;
  private int mSampleRate = 8000;
  
  public b(com.tencent.mm.compatible.b.b.a parama)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + parama);
    this.bCd = parama;
    if (!g.b.uw())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
      this.bCd = com.tencent.mm.compatible.b.b.a.dub;
    }
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      this.bBP = 7;
      this.bCb = new MediaRecorder();
    }
    for (;;)
    {
      this.bCf = false;
      return;
      um();
      this.bBP = 1;
    }
  }
  
  public final void a(a parama)
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      if (this.bCb == null) {
        return;
      }
      this.bBS = parama;
      this.bCb.setOnErrorListener(new b.1(this));
      return;
    }
    if (this.bCe == b.b.bCn)
    {
      this.bBS = parama;
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
  }
  
  public final int getMaxAmplitude()
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub) {
      if (this.bCb != null) {}
    }
    while (this.bCe != b.b.bCp)
    {
      return 0;
      return this.bCb.getMaxAmplitude();
    }
    int i = this.bBN;
    this.bBN = 0;
    return i;
  }
  
  public final void prepare()
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      if (this.bCb != null) {
        this.bCb.prepare();
      }
      return;
    }
    if ((this.bCe != b.b.bCn) || (this.bBO == null))
    {
      this.bCe = b.b.bCq;
      release();
      return;
    }
    this.bCe = b.b.bCo;
  }
  
  public final void release()
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      if (this.bCb != null) {
        this.bCb.release();
      }
      return;
    }
    if (this.bCe == b.b.bCp) {
      un();
    }
    for (;;)
    {
      synchronized (bBY)
      {
        if (this.bCc != null)
        {
          this.bCc.uh();
          this.bCc.bCP = null;
          this.bCc = null;
        }
        return;
      }
      ??? = b.b.bCo;
    }
  }
  
  public final void setMaxDuration(int paramInt)
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      if (this.bCb != null) {
        this.bCb.setMaxDuration(paramInt);
      }
      return;
    }
    this.bBV = paramInt;
  }
  
  public final void setOutputFile(String paramString)
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      if (this.bCb == null) {
        return;
      }
      this.bCb.setOutputFile(paramString);
      this.bBO = paramString;
      return;
    }
    if (this.bCe == b.b.bCn)
    {
      this.bBO = paramString;
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
    this.bCe = b.b.bCq;
  }
  
  public final void start()
  {
    if (this.bCd == com.tencent.mm.compatible.b.b.a.dub)
    {
      if (this.bCb != null) {
        this.bCb.start();
      }
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.bCe + " recMode: " + this.bCd);
    if (this.bCe == b.b.bCo)
    {
      this.bBW = System.currentTimeMillis();
      this.bBX = 0;
    }
    for (this.bCe = b.b.bCp;; this.bCe = b.b.bCq)
    {
      synchronized (bBY)
      {
        this.bCc.uq();
        this.bCf = false;
        return;
      }
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().dKo.set(27, Integer.valueOf(1));
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
    }
  }
  
  public final void uj()
  {
    if ((this.bCd == com.tencent.mm.compatible.b.b.a.dub) && (this.bCb != null)) {
      this.bCb.setAudioEncoder(1);
    }
  }
  
  public final void uk()
  {
    if ((this.bCd != com.tencent.mm.compatible.b.b.a.dub) || (this.bCb == null)) {
      return;
    }
    this.bCb.setAudioSource(1);
  }
  
  public final void ul()
  {
    if ((this.bCd != com.tencent.mm.compatible.b.b.a.dub) || (this.bCb == null)) {
      return;
    }
    this.bCb.setOutputFormat(3);
  }
  
  public final void um()
  {
    this.bBU = d.a.Rj();
    boolean bool;
    if (this.bBU != null)
    {
      ??? = this.bBU;
      if (1 != g.r("EnableSpeexVoiceUpload", 0)) {
        break label259;
      }
      bool = true;
    }
    for (;;)
    {
      this.bCa = bool;
      Object localObject2;
      if (this.bCd == com.tencent.mm.compatible.b.b.a.duc)
      {
        ??? = ((a)com.tencent.mm.kernel.g.r(a.class)).AA().getValue("VoiceSamplingRate");
        this.mSampleRate = bk.getInt((String)???, 16000);
        localObject2 = ((a)com.tencent.mm.kernel.g.r(a.class)).AA().getValue("VoiceRate");
        this.bBZ = bk.getInt((String)localObject2, 16000);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[] { ???, Integer.valueOf(this.mSampleRate), localObject2, Integer.valueOf(this.bBZ) });
        this.bBN = 0;
        this.bBO = null;
        synchronized (this.bBQ)
        {
          this.bBT = null;
          this.bBR = null;
          this.bBX = 0;
        }
      }
      try
      {
        synchronized (bBY)
        {
          this.bCc = new c(this.mSampleRate, 1, 0);
          this.bCc.aX(true);
          this.bCc.ey(120);
          this.bCc.bCP = this.bCj;
          this.bCe = b.b.bCn;
          return;
          label259:
          com.tencent.mm.sdk.platformtools.y.d("upload", "type " + d.chatType);
          int j = ((d.a)???).Ri();
          int i = ((d.a)???).Rh();
          com.tencent.mm.kernel.g.DQ();
          localObject2 = Integer.valueOf(bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(16646145, null)));
          com.tencent.mm.sdk.platformtools.y.d("upload", "daycount " + ((d.a)???).Ri() + "  count " + localObject2 + " rate " + i);
          if ((((Integer)localObject2).intValue() <= j) && (i != 0) && (aq.isWifi(ae.getContext())))
          {
            com.tencent.mm.kernel.g.DQ();
            j = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(12290, null), 0);
            if (((d.a)???).sex == 0) {
              bool = true;
            }
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.d("upload", "fitSex " + ((d.a)???).sex + " " + bool + " " + ((d.a)???).sex);
              if ((!bool) || (!((d.a)???).Rg())) {
                break label556;
              }
              j = ((d.a)???).eBr.nextInt(i);
              com.tencent.mm.sdk.platformtools.y.d("upload", "luck " + j);
              if (j != i / 2) {
                break label556;
              }
              bool = true;
              break;
              if (((d.a)???).sex == j) {
                bool = true;
              } else {
                bool = false;
              }
            }
          }
          label556:
          bool = false;
          continue;
          if (this.bCa) {}
          for (this.mSampleRate = 16000;; this.mSampleRate = 8000)
          {
            com.tencent.mm.kernel.g.DQ();
            i = bk.a((Integer)com.tencent.mm.kernel.g.DP().dKo.get(27), 0);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + i);
            if (i != 1) {
              break;
            }
            this.mSampleRate = 8000;
            break;
          }
          localObject3 = finally;
          throw localObject3;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAudioRecorder", localException.getMessage());
      }
      catch (Exception localException)
      {
        if (localException.getMessage() == null) {}
      }
    }
    for (;;)
    {
      this.bCe = b.b.bCq;
      return;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
    }
  }
  
  /* Error */
  public final boolean un()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 129	com/tencent/mm/f/b/b:bCd	Lcom/tencent/mm/compatible/b/b$a;
    //   4: getstatic 142	com/tencent/mm/compatible/b/b$a:dub	Lcom/tencent/mm/compatible/b/b$a;
    //   7: if_acmpne +50 -> 57
    //   10: ldc 106
    //   12: ldc_w 467
    //   15: iconst_1
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield 149	com/tencent/mm/f/b/b:bCb	Landroid/media/MediaRecorder;
    //   25: aastore
    //   26: invokestatic 358	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 149	com/tencent/mm/f/b/b:bCb	Landroid/media/MediaRecorder;
    //   33: ifnull +22 -> 55
    //   36: aload_0
    //   37: getfield 149	com/tencent/mm/f/b/b:bCb	Landroid/media/MediaRecorder;
    //   40: invokevirtual 470	android/media/MediaRecorder:stop	()V
    //   43: aload_0
    //   44: getfield 149	com/tencent/mm/f/b/b:bCb	Landroid/media/MediaRecorder;
    //   47: invokevirtual 230	android/media/MediaRecorder:release	()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 149	com/tencent/mm/f/b/b:bCb	Landroid/media/MediaRecorder;
    //   55: iconst_1
    //   56: ireturn
    //   57: new 88	com/tencent/mm/compatible/util/g$a
    //   60: dup
    //   61: invokespecial 89	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   64: astore 9
    //   66: ldc 106
    //   68: new 108	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 472
    //   75: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 160	com/tencent/mm/f/b/b:bCe	Lcom/tencent/mm/f/b/b$b;
    //   82: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 127	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 160	com/tencent/mm/f/b/b:bCe	Lcom/tencent/mm/f/b/b$b;
    //   95: getstatic 206	com/tencent/mm/f/b/b$b:bCn	Lcom/tencent/mm/f/b/b$b;
    //   98: if_acmpne +43 -> 141
    //   101: getstatic 478	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   104: ldc2_w 479
    //   107: ldc2_w 481
    //   110: lconst_1
    //   111: iconst_1
    //   112: invokevirtual 485	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   115: aload_0
    //   116: getfield 104	com/tencent/mm/f/b/b:bCk	Z
    //   119: ifne +17 -> 136
    //   122: getstatic 478	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   125: ldc2_w 479
    //   128: ldc2_w 486
    //   131: lconst_1
    //   132: iconst_1
    //   133: invokevirtual 485	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   136: aload_0
    //   137: iconst_1
    //   138: putfield 104	com/tencent/mm/f/b/b:bCk	Z
    //   141: aload_0
    //   142: getfield 160	com/tencent/mm/f/b/b:bCe	Lcom/tencent/mm/f/b/b$b;
    //   145: getstatic 217	com/tencent/mm/f/b/b$b:bCp	Lcom/tencent/mm/f/b/b$b;
    //   148: if_acmpeq +20 -> 168
    //   151: ldc 106
    //   153: ldc_w 489
    //   156: invokestatic 210	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: getstatic 223	com/tencent/mm/f/b/b$b:bCq	Lcom/tencent/mm/f/b/b$b;
    //   163: putfield 160	com/tencent/mm/f/b/b:bCe	Lcom/tencent/mm/f/b/b$b;
    //   166: iconst_1
    //   167: ireturn
    //   168: getstatic 56	com/tencent/mm/f/b/b:bBY	Ljava/lang/Object;
    //   171: astore 10
    //   173: aload 10
    //   175: monitorenter
    //   176: aload_0
    //   177: getfield 84	com/tencent/mm/f/b/b:bCc	Lcom/tencent/mm/f/b/c;
    //   180: ifnull +401 -> 581
    //   183: aload_0
    //   184: iconst_1
    //   185: putfield 86	com/tencent/mm/f/b/b:bCf	Z
    //   188: aload 10
    //   190: monitorexit
    //   191: aload 9
    //   193: invokevirtual 492	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   196: lstore_3
    //   197: aload_0
    //   198: getstatic 495	com/tencent/mm/f/b/b$b:bCr	Lcom/tencent/mm/f/b/b$b;
    //   201: putfield 160	com/tencent/mm/f/b/b:bCe	Lcom/tencent/mm/f/b/b$b;
    //   204: aload 9
    //   206: invokevirtual 492	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   209: lstore 5
    //   211: aload_0
    //   212: getfield 86	com/tencent/mm/f/b/b:bCf	Z
    //   215: ifeq +145 -> 360
    //   218: ldc 106
    //   220: ldc_w 497
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_0
    //   230: getfield 86	com/tencent/mm/f/b/b:bCf	Z
    //   233: invokestatic 502	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   236: aastore
    //   237: invokestatic 358	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: iconst_0
    //   241: istore_1
    //   242: iload_1
    //   243: istore_2
    //   244: aload_0
    //   245: getfield 86	com/tencent/mm/f/b/b:bCf	Z
    //   248: ifeq +83 -> 331
    //   251: iload_1
    //   252: iconst_1
    //   253: iadd
    //   254: istore_2
    //   255: ldc2_w 503
    //   258: invokestatic 510	java/lang/Thread:sleep	(J)V
    //   261: iload_2
    //   262: istore_1
    //   263: iload_2
    //   264: bipush 25
    //   266: if_icmplt -24 -> 242
    //   269: getstatic 56	com/tencent/mm/f/b/b:bBY	Ljava/lang/Object;
    //   272: astore 10
    //   274: aload 10
    //   276: monitorenter
    //   277: ldc 106
    //   279: ldc_w 512
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_0
    //   289: getfield 84	com/tencent/mm/f/b/b:bCc	Lcom/tencent/mm/f/b/c;
    //   292: aastore
    //   293: invokestatic 358	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: aload_0
    //   297: getfield 84	com/tencent/mm/f/b/b:bCc	Lcom/tencent/mm/f/b/c;
    //   300: astore 11
    //   302: aload 11
    //   304: ifnull +24 -> 328
    //   307: aload_0
    //   308: getfield 84	com/tencent/mm/f/b/b:bCc	Lcom/tencent/mm/f/b/c;
    //   311: invokevirtual 238	com/tencent/mm/f/b/c:uh	()Z
    //   314: pop
    //   315: aload_0
    //   316: getfield 84	com/tencent/mm/f/b/b:bCc	Lcom/tencent/mm/f/b/c;
    //   319: aconst_null
    //   320: putfield 241	com/tencent/mm/f/b/c:bCP	Lcom/tencent/mm/f/b/c$a;
    //   323: aload_0
    //   324: aconst_null
    //   325: putfield 84	com/tencent/mm/f/b/b:bCc	Lcom/tencent/mm/f/b/c;
    //   328: aload 10
    //   330: monitorexit
    //   331: ldc 106
    //   333: ldc_w 514
    //   336: iconst_2
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload_0
    //   343: getfield 86	com/tencent/mm/f/b/b:bCf	Z
    //   346: invokestatic 502	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: iload_2
    //   353: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: aastore
    //   357: invokestatic 358	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload_0
    //   361: getfield 64	com/tencent/mm/f/b/b:bBQ	Ljava/lang/Object;
    //   364: astore 10
    //   366: aload 10
    //   368: monitorenter
    //   369: aload_0
    //   370: getfield 66	com/tencent/mm/f/b/b:bBR	Lcom/tencent/mm/f/c/c;
    //   373: ifnull +10 -> 383
    //   376: aload_0
    //   377: getfield 66	com/tencent/mm/f/b/b:bBR	Lcom/tencent/mm/f/c/c;
    //   380: invokevirtual 519	com/tencent/mm/f/c/c:uE	()V
    //   383: aload_0
    //   384: getfield 68	com/tencent/mm/f/b/b:bBT	Lcom/tencent/mm/be/c;
    //   387: ifnull +41 -> 428
    //   390: aload_0
    //   391: getfield 68	com/tencent/mm/f/b/b:bBT	Lcom/tencent/mm/be/c;
    //   394: astore 11
    //   396: ldc_w 521
    //   399: ldc_w 523
    //   402: invokestatic 127	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: new 525	com/tencent/mm/sdk/platformtools/ah
    //   408: dup
    //   409: invokestatic 531	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   412: invokespecial 534	com/tencent/mm/sdk/platformtools/ah:<init>	(Landroid/os/Looper;)V
    //   415: new 536	com/tencent/mm/be/c$1
    //   418: dup
    //   419: aload 11
    //   421: invokespecial 539	com/tencent/mm/be/c$1:<init>	(Lcom/tencent/mm/be/c;)V
    //   424: invokevirtual 543	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   427: pop
    //   428: aload 10
    //   430: monitorexit
    //   431: aload_0
    //   432: getfield 74	com/tencent/mm/f/b/b:bBW	J
    //   435: invokestatic 547	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   438: lstore 7
    //   440: ldc 106
    //   442: new 108	java/lang/StringBuilder
    //   445: dup
    //   446: ldc_w 549
    //   449: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: lload 7
    //   454: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: ldc_w 554
    //   460: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: getfield 74	com/tencent/mm/f/b/b:bBW	J
    //   467: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 556
    //   473: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 76	com/tencent/mm/f/b/b:bBX	I
    //   480: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 127	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: lload 7
    //   491: ldc2_w 557
    //   494: lcmp
    //   495: ifle +37 -> 532
    //   498: aload_0
    //   499: getfield 76	com/tencent/mm/f/b/b:bBX	I
    //   502: ifne +30 -> 532
    //   505: invokestatic 275	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   508: pop
    //   509: invokestatic 279	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   512: getfield 285	com/tencent/mm/kernel/e:dKo	Lcom/tencent/mm/storage/y;
    //   515: bipush 27
    //   517: iconst_1
    //   518: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: invokevirtual 297	com/tencent/mm/storage/y:set	(ILjava/lang/Object;)V
    //   524: ldc 106
    //   526: ldc_w 560
    //   529: invokestatic 127	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: ldc 106
    //   534: new 108	java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 562
    //   541: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: lload_3
    //   545: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: ldc_w 564
    //   551: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: lload 5
    //   556: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   559: ldc_w 566
    //   562: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 9
    //   567: invokevirtual 492	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   570: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   573: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 127	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: iconst_0
    //   580: ireturn
    //   581: aload_0
    //   582: iconst_0
    //   583: putfield 86	com/tencent/mm/f/b/b:bCf	Z
    //   586: goto -398 -> 188
    //   589: astore 9
    //   591: aload 10
    //   593: monitorexit
    //   594: aload 9
    //   596: athrow
    //   597: astore 10
    //   599: ldc 106
    //   601: aload 10
    //   603: ldc_w 568
    //   606: iconst_0
    //   607: anewarray 4	java/lang/Object
    //   610: invokestatic 572	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   613: goto -352 -> 261
    //   616: astore 11
    //   618: ldc 106
    //   620: aload 11
    //   622: ldc_w 568
    //   625: iconst_0
    //   626: anewarray 4	java/lang/Object
    //   629: invokestatic 572	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   632: goto -304 -> 328
    //   635: astore 9
    //   637: aload 10
    //   639: monitorexit
    //   640: aload 9
    //   642: athrow
    //   643: astore 9
    //   645: aload 10
    //   647: monitorexit
    //   648: aload 9
    //   650: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	b
    //   241	22	1	i	int
    //   243	110	2	j	int
    //   196	349	3	l1	long
    //   209	346	5	l2	long
    //   438	52	7	l3	long
    //   64	502	9	locala	g.a
    //   589	6	9	localObject1	Object
    //   635	6	9	localObject2	Object
    //   643	6	9	localObject3	Object
    //   597	49	10	localInterruptedException	java.lang.InterruptedException
    //   300	120	11	localObject5	Object
    //   616	5	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   176	188	589	finally
    //   188	191	589	finally
    //   581	586	589	finally
    //   591	594	589	finally
    //   255	261	597	java/lang/InterruptedException
    //   307	328	616	java/lang/Exception
    //   277	302	635	finally
    //   307	328	635	finally
    //   328	331	635	finally
    //   618	632	635	finally
    //   637	640	635	finally
    //   369	383	643	finally
    //   383	428	643	finally
    //   428	431	643	finally
    //   645	648	643	finally
  }
  
  public static abstract interface a
  {
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.b
 * JD-Core Version:    0.7.0.1
 */