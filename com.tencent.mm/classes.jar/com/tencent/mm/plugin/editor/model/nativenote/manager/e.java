package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bz;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  extends Thread
{
  private static HashMap<String, b> usO;
  private static Object usP;
  private static QueueWorkerThread usQ;
  public boolean isStop;
  private List<String> usE;
  private List<Integer> usF;
  private List<String> usG;
  private List<String> usH;
  private List<Integer> usI;
  private a usJ;
  private l usK;
  private String usL;
  private String usM;
  private boolean usN;
  
  static
  {
    AppMethodBeat.i(181778);
    usO = new HashMap();
    usP = new byte[0];
    AppMethodBeat.o(181778);
  }
  
  public e(List<String> paramList, String paramString1, String paramString2, l paraml, a parama)
  {
    AppMethodBeat.i(181771);
    this.usN = false;
    this.usE = paramList;
    this.usF = new ArrayList();
    this.usG = new ArrayList();
    this.usI = new ArrayList();
    this.usH = new ArrayList();
    this.usJ = parama;
    this.usK = paraml;
    this.usM = paramString2;
    this.usL = paramString1;
    AppMethodBeat.o(181771);
  }
  
  private void a(final int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, final String paramString3)
  {
    AppMethodBeat.i(181773);
    Log.i("MicroMsg.EditorVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      aw(???, ???.getString(d.h.video_export_file_too_big));
    }
    for (;;)
    {
      if ((this.usJ != null) && (!this.isStop)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181767);
            e.b(e.this).a(paramString3, e.a(e.this));
            if ((e.c(e.this)) || (paramInt1 != -50006)) {
              h.aHJ().postToWorkerDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(181766);
                  e.b(e.this).b(e.d(e.this), e.a(e.this));
                  AppMethodBeat.o(181766);
                }
              }, 80L);
            }
            AppMethodBeat.o(181767);
          }
        });
      }
      AppMethodBeat.o(181773);
      return;
      if (paramInt1 == -50008)
      {
        aw(???, ???.getString(d.h.video_export_duration_too_long));
      }
      else
      {
        b localb;
        if (paramInt1 == -50006)
        {
          fZ(paramString1, paramString2);
          if (usQ == null) {
            usQ = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
          }
          localb = new b((byte)0);
        }
        synchronized (usP)
        {
          usO.put(paramString1, localb);
          localb.fileName = paramString1;
          localb.mfq = paramString2;
          localb.oxH = this.usM;
          localb.mhG = paramVideoTransPara;
          b.a(localb, this.usJ);
          localb.usK = this.usK;
          usQ.add(localb);
        }
        continue;
        this.usN = true;
      }
    }
  }
  
  private void aw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(181774);
    MMHandlerThread.postToMainThread(new e.2(this, paramContext, paramString));
    AppMethodBeat.o(181774);
  }
  
  /* Error */
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: ldc 229
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 231	com/tencent/mm/compatible/i/d
    //   8: dup
    //   9: invokespecial 232	com/tencent/mm/compatible/i/d:<init>	()V
    //   12: astore 6
    //   14: aload 6
    //   16: astore 5
    //   18: aload 6
    //   20: aload_0
    //   21: invokevirtual 237	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   24: aload 6
    //   26: astore 5
    //   28: aload 6
    //   30: bipush 18
    //   32: invokevirtual 240	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   35: iconst_0
    //   36: invokestatic 246	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   39: istore_2
    //   40: aload 6
    //   42: astore 5
    //   44: aload 6
    //   46: bipush 19
    //   48: invokevirtual 240	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: iconst_0
    //   52: invokestatic 246	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   55: istore_3
    //   56: aload 6
    //   58: invokevirtual 249	android/media/MediaMetadataRetriever:release	()V
    //   61: aload_1
    //   62: iconst_0
    //   63: iload_2
    //   64: iastore
    //   65: aload_1
    //   66: iconst_1
    //   67: iload_3
    //   68: iastore
    //   69: iconst_0
    //   70: istore 4
    //   72: iload 4
    //   74: iconst_3
    //   75: if_icmpge +117 -> 192
    //   78: iload_2
    //   79: iconst_2
    //   80: irem
    //   81: ifne +9 -> 90
    //   84: iload_3
    //   85: iconst_2
    //   86: irem
    //   87: ifeq +67 -> 154
    //   90: ldc 229
    //   92: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: astore_0
    //   97: iconst_0
    //   98: istore_2
    //   99: aconst_null
    //   100: astore 6
    //   102: aload 6
    //   104: astore 5
    //   106: ldc 94
    //   108: aload_0
    //   109: ldc 251
    //   111: iconst_0
    //   112: anewarray 98	java/lang/Object
    //   115: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload 6
    //   120: ifnull +8 -> 128
    //   123: aload 6
    //   125: invokevirtual 249	android/media/MediaMetadataRetriever:release	()V
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -69 -> 61
    //   133: astore_0
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +8 -> 147
    //   142: aload 5
    //   144: invokevirtual 249	android/media/MediaMetadataRetriever:release	()V
    //   147: ldc 229
    //   149: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: iload_2
    //   155: iload_3
    //   156: if_icmplt +17 -> 173
    //   159: iload_2
    //   160: sipush 640
    //   163: if_icmple +29 -> 192
    //   166: iload_3
    //   167: sipush 480
    //   170: if_icmple +22 -> 192
    //   173: iload_2
    //   174: iload_3
    //   175: if_icmpgt +31 -> 206
    //   178: iload_2
    //   179: sipush 480
    //   182: if_icmple +10 -> 192
    //   185: iload_3
    //   186: sipush 640
    //   189: if_icmpgt +17 -> 206
    //   192: aload_1
    //   193: iconst_0
    //   194: iload_2
    //   195: iastore
    //   196: aload_1
    //   197: iconst_1
    //   198: iload_3
    //   199: iastore
    //   200: ldc 229
    //   202: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: return
    //   206: iload_2
    //   207: iconst_2
    //   208: idiv
    //   209: istore_2
    //   210: iload_3
    //   211: iconst_2
    //   212: idiv
    //   213: istore_3
    //   214: iload 4
    //   216: iconst_1
    //   217: iadd
    //   218: istore 4
    //   220: goto -148 -> 72
    //   223: astore_0
    //   224: goto -87 -> 137
    //   227: astore_0
    //   228: iconst_0
    //   229: istore_2
    //   230: goto -128 -> 102
    //   233: astore_0
    //   234: goto -132 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   0	237	1	paramArrayOfInt	int[]
    //   39	191	2	i	int
    //   55	159	3	j	int
    //   70	149	4	k	int
    //   16	127	5	locald1	com.tencent.mm.compatible.i.d
    //   12	112	6	locald2	com.tencent.mm.compatible.i.d
    // Exception table:
    //   from	to	target	type
    //   5	14	96	java/lang/Exception
    //   5	14	133	finally
    //   18	24	223	finally
    //   28	40	223	finally
    //   44	56	223	finally
    //   106	118	223	finally
    //   18	24	227	java/lang/Exception
    //   28	40	227	java/lang/Exception
    //   44	56	233	java/lang/Exception
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(181777);
      this.usF.add(Integer.valueOf(paramInt1));
      this.usG.add(paramString1);
      this.usH.add(paramString2);
      this.usI.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(181777);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private static void fZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(181775);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.EditorVideoCompress", "do insertVideoStorage, but file name is null");
      AppMethodBeat.o(181775);
      return;
    }
    w localw = new w();
    localw.fileName = paramString1;
    localw.lvw = 1;
    localw.fPV = null;
    localw.mhK = ((String)h.aHG().aHp().b(2, ""));
    localw.createTime = Util.nowSecond();
    localw.mhP = Util.nowSecond();
    localw.mhW = null;
    localw.mfq = paramString2;
    if (!Util.isNullOrNil(paramString2)) {
      localw.mhU = 1;
    }
    localw.lAW = 0;
    s.bqB().b(localw);
    AppMethodBeat.o(181775);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 342
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 68	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usE	Ljava/util/List;
    //   10: ifnull +1255 -> 1265
    //   13: aload_0
    //   14: getfield 68	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usE	Ljava/util/List;
    //   17: invokeinterface 346 1 0
    //   22: ifle +1243 -> 1265
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: aload_0
    //   31: getfield 68	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usE	Ljava/util/List;
    //   34: invokeinterface 346 1 0
    //   39: if_icmpge +1226 -> 1265
    //   42: aload_0
    //   43: getfield 132	com/tencent/mm/plugin/editor/model/nativenote/manager/e:isStop	Z
    //   46: ifne +1219 -> 1265
    //   49: ldc 94
    //   51: ldc_w 348
    //   54: iconst_1
    //   55: anewarray 98	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 68	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usE	Ljava/util/List;
    //   64: invokevirtual 349	java/lang/Object:toString	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 351	android/content/Intent
    //   74: dup
    //   75: invokespecial 352	android/content/Intent:<init>	()V
    //   78: astore 16
    //   80: aload 16
    //   82: new 156	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 354
    //   89: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 68	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usE	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 358 2 0
    //   103: checkcast 306	java/lang/String
    //   106: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 367	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   115: invokevirtual 371	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   118: pop
    //   119: invokestatic 377	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   122: astore 17
    //   124: new 156	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 379
    //   131: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: invokestatic 291	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   137: invokevirtual 297	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   140: iconst_2
    //   141: ldc_w 299
    //   144: invokevirtual 304	com/tencent/mm/storage/ao:b	(ILjava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 306	java/lang/String
    //   150: invokestatic 383	com/tencent/mm/modelvideo/x:XR	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 13
    //   161: aload_0
    //   162: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usL	Ljava/lang/String;
    //   165: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   168: ifne +13 -> 181
    //   171: aload_0
    //   172: getfield 85	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usM	Ljava/lang/String;
    //   175: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   178: ifeq +83 -> 261
    //   181: invokestatic 335	com/tencent/mm/modelvideo/s:bqB	()Lcom/tencent/mm/modelvideo/x;
    //   184: pop
    //   185: aload 13
    //   187: invokestatic 386	com/tencent/mm/modelvideo/x:XU	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 15
    //   192: invokestatic 335	com/tencent/mm/modelvideo/s:bqB	()Lcom/tencent/mm/modelvideo/x;
    //   195: pop
    //   196: aload 13
    //   198: invokestatic 389	com/tencent/mm/modelvideo/x:XT	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 14
    //   203: invokestatic 377	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   206: invokestatic 395	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   209: istore 9
    //   211: aload 17
    //   213: aload 16
    //   215: invokestatic 400	com/tencent/mm/compatible/i/a:i	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   218: astore 18
    //   220: aload 18
    //   222: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   225: ifeq +79 -> 304
    //   228: ldc 94
    //   230: ldc_w 402
    //   233: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: ldc_w 406
    //   240: aload 13
    //   242: aload 18
    //   244: iconst_0
    //   245: aconst_null
    //   246: aload 17
    //   248: aconst_null
    //   249: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   252: iload 6
    //   254: iconst_1
    //   255: iadd
    //   256: istore 6
    //   258: goto -230 -> 28
    //   261: aload_0
    //   262: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usL	Ljava/lang/String;
    //   265: astore 15
    //   267: aload_0
    //   268: getfield 85	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usM	Ljava/lang/String;
    //   271: aload_0
    //   272: getfield 85	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usM	Ljava/lang/String;
    //   275: ldc_w 410
    //   278: invokevirtual 414	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   281: iconst_1
    //   282: iadd
    //   283: aload_0
    //   284: getfield 85	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usM	Ljava/lang/String;
    //   287: invokevirtual 417	java/lang/String:length	()I
    //   290: invokevirtual 421	java/lang/String:substring	(II)Ljava/lang/String;
    //   293: astore 13
    //   295: aload_0
    //   296: getfield 85	com/tencent/mm/plugin/editor/model/nativenote/manager/e:usM	Ljava/lang/String;
    //   299: astore 14
    //   301: goto -98 -> 203
    //   304: aload 18
    //   306: invokestatic 426	com/tencent/mm/plugin/a/c:ZZ	(Ljava/lang/String;)Z
    //   309: istore 8
    //   311: aload 18
    //   313: invokestatic 432	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   316: lstore 10
    //   318: iload 8
    //   320: ifeq +554 -> 874
    //   323: new 434	com/tencent/mm/pointers/PInt
    //   326: dup
    //   327: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   330: astore 19
    //   332: invokestatic 441	com/tencent/mm/modelcontrol/e:bkp	()Lcom/tencent/mm/modelcontrol/e;
    //   335: aload 18
    //   337: invokevirtual 444	com/tencent/mm/modelcontrol/e:VE	(Ljava/lang/String;)Z
    //   340: ifeq +159 -> 499
    //   343: ldc 94
    //   345: ldc_w 446
    //   348: iconst_1
    //   349: anewarray 98	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload 18
    //   356: aastore
    //   357: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload 19
    //   362: iconst_1
    //   363: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   366: aconst_null
    //   367: astore 12
    //   369: aload 19
    //   371: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   374: istore_3
    //   375: ldc 94
    //   377: ldc_w 451
    //   380: iconst_3
    //   381: anewarray 98	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: iload_3
    //   387: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: iload 8
    //   395: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: aastore
    //   399: dup
    //   400: iconst_2
    //   401: lload 10
    //   403: invokestatic 461	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   406: aastore
    //   407: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: iload_3
    //   411: tableswitch	default:+61 -> 472, -6:+610->1021, -5:+628->1039, -4:+610->1021, -3:+610->1021, -2:+610->1021, -1:+591->1002, 0:+583->994, 1:+504->915, 2:+504->915, 3:+504->915, 4:+504->915, 5:+504->915
    //   473: dup2_x2
    //   474: ldc_w 463
    //   477: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: ldc_w 464
    //   484: aload 13
    //   486: aload 18
    //   488: iconst_0
    //   489: aconst_null
    //   490: aload 17
    //   492: aconst_null
    //   493: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   496: goto -244 -> 252
    //   499: new 466	com/tencent/mm/modelcontrol/VideoTransPara
    //   502: dup
    //   503: invokespecial 467	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   506: astore 20
    //   508: new 434	com/tencent/mm/pointers/PInt
    //   511: dup
    //   512: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   515: astore 12
    //   517: new 434	com/tencent/mm/pointers/PInt
    //   520: dup
    //   521: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   524: astore 21
    //   526: new 434	com/tencent/mm/pointers/PInt
    //   529: dup
    //   530: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   533: astore 22
    //   535: new 434	com/tencent/mm/pointers/PInt
    //   538: dup
    //   539: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   542: astore 23
    //   544: new 434	com/tencent/mm/pointers/PInt
    //   547: dup
    //   548: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   551: astore 24
    //   553: aload 18
    //   555: aload 12
    //   557: aload 21
    //   559: aload 22
    //   561: aload 23
    //   563: aload 24
    //   565: invokestatic 472	com/tencent/mm/plugin/sight/base/f:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   568: pop
    //   569: aload 20
    //   571: aload 12
    //   573: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   576: sipush 1000
    //   579: idiv
    //   580: putfield 475	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   583: aload 20
    //   585: aload 21
    //   587: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   590: putfield 478	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   593: aload 20
    //   595: aload 22
    //   597: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   600: putfield 481	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   603: aload 20
    //   605: aload 23
    //   607: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   610: putfield 484	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   613: aload 20
    //   615: aload 24
    //   617: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   620: putfield 487	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   623: ldc 94
    //   625: ldc_w 489
    //   628: iconst_1
    //   629: anewarray 98	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload 20
    //   636: aastore
    //   637: invokestatic 491	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: invokestatic 441	com/tencent/mm/modelcontrol/e:bkp	()Lcom/tencent/mm/modelcontrol/e;
    //   643: aload 20
    //   645: invokevirtual 494	com/tencent/mm/modelcontrol/e:c	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   648: astore 12
    //   650: aload 12
    //   652: ifnonnull +33 -> 685
    //   655: ldc 94
    //   657: ldc_w 496
    //   660: iconst_1
    //   661: anewarray 98	java/lang/Object
    //   664: dup
    //   665: iconst_0
    //   666: aload 20
    //   668: aastore
    //   669: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload 19
    //   674: bipush 251
    //   676: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   679: aconst_null
    //   680: astore 12
    //   682: goto -313 -> 369
    //   685: ldc 94
    //   687: ldc_w 498
    //   690: iconst_1
    //   691: anewarray 98	java/lang/Object
    //   694: dup
    //   695: iconst_0
    //   696: aload 12
    //   698: aastore
    //   699: invokestatic 491	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: aload 20
    //   704: getfield 487	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   707: ldc_w 499
    //   710: if_icmple +16 -> 726
    //   713: aload 12
    //   715: getfield 487	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   718: aload 20
    //   720: getfield 487	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   723: if_icmple +37 -> 760
    //   726: ldc 94
    //   728: ldc_w 501
    //   731: iconst_2
    //   732: anewarray 98	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload 12
    //   739: aastore
    //   740: dup
    //   741: iconst_1
    //   742: aload 20
    //   744: aastore
    //   745: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   748: aload 19
    //   750: iconst_1
    //   751: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   754: aconst_null
    //   755: astore 12
    //   757: goto -388 -> 369
    //   760: aload 20
    //   762: getfield 484	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   765: bipush 45
    //   767: if_icmplt +31 -> 798
    //   770: aload 20
    //   772: getfield 475	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   775: sipush 1000
    //   778: imul
    //   779: ldc_w 502
    //   782: if_icmplt +16 -> 798
    //   785: aload 19
    //   787: bipush 250
    //   789: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   792: aconst_null
    //   793: astore 12
    //   795: goto -426 -> 369
    //   798: invokestatic 377	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   801: invokestatic 395	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   804: istore 9
    //   806: aload 12
    //   808: getfield 478	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   811: istore 4
    //   813: aload 12
    //   815: getfield 481	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   818: istore 5
    //   820: iload 9
    //   822: ifeq +38 -> 860
    //   825: ldc_w 503
    //   828: istore_3
    //   829: iload 9
    //   831: ifeq +36 -> 867
    //   834: ldc2_w 504
    //   837: dstore_1
    //   838: aload 19
    //   840: aload 18
    //   842: iload 4
    //   844: iload 5
    //   846: iload_3
    //   847: dload_1
    //   848: ldc_w 506
    //   851: invokestatic 512	com/tencent/mm/plugin/sight/base/SightVideoJNI:shouldRemuxingVFS	(Ljava/lang/String;IIIDI)I
    //   854: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   857: goto -488 -> 369
    //   860: ldc_w 513
    //   863: istore_3
    //   864: goto -35 -> 829
    //   867: ldc2_w 514
    //   870: dstore_1
    //   871: goto -33 -> 838
    //   874: iload 9
    //   876: ifeq +24 -> 900
    //   879: ldc_w 503
    //   882: istore_3
    //   883: lload 10
    //   885: iload_3
    //   886: i2l
    //   887: lcmp
    //   888: ifle +19 -> 907
    //   891: bipush 251
    //   893: istore_3
    //   894: aconst_null
    //   895: astore 12
    //   897: goto -522 -> 375
    //   900: ldc_w 513
    //   903: istore_3
    //   904: goto -21 -> 883
    //   907: iconst_1
    //   908: istore_3
    //   909: aconst_null
    //   910: astore 12
    //   912: goto -537 -> 375
    //   915: lload 10
    //   917: ldc2_w 516
    //   920: lcmp
    //   921: ifle +65 -> 986
    //   924: aload_0
    //   925: ldc 114
    //   927: aload 13
    //   929: aload 18
    //   931: iconst_0
    //   932: aconst_null
    //   933: aload 17
    //   935: aconst_null
    //   936: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   939: iconst_0
    //   940: istore 4
    //   942: ldc 114
    //   944: istore_3
    //   945: aload 17
    //   947: aload 16
    //   949: invokestatic 521	com/tencent/mm/compatible/i/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/i/a$a;
    //   952: astore 16
    //   954: aload 16
    //   956: ifnonnull +123 -> 1079
    //   959: ldc 94
    //   961: ldc_w 402
    //   964: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: aload_0
    //   968: ldc_w 406
    //   971: aload 13
    //   973: aload 18
    //   975: iconst_0
    //   976: aconst_null
    //   977: aload 17
    //   979: aconst_null
    //   980: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   983: goto -731 -> 252
    //   986: iconst_0
    //   987: istore 4
    //   989: iconst_0
    //   990: istore_3
    //   991: goto -46 -> 945
    //   994: iconst_1
    //   995: istore 4
    //   997: iconst_0
    //   998: istore_3
    //   999: goto -54 -> 945
    //   1002: aload_0
    //   1003: ldc_w 522
    //   1006: aload 13
    //   1008: aload 18
    //   1010: iconst_0
    //   1011: aconst_null
    //   1012: aload 17
    //   1014: aconst_null
    //   1015: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1018: goto -766 -> 252
    //   1021: aload_0
    //   1022: ldc 114
    //   1024: aload 13
    //   1026: aload 18
    //   1028: iconst_0
    //   1029: aconst_null
    //   1030: aload 17
    //   1032: aconst_null
    //   1033: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1036: goto -784 -> 252
    //   1039: aload_0
    //   1040: ldc 142
    //   1042: aload 13
    //   1044: aload 18
    //   1046: iconst_0
    //   1047: aconst_null
    //   1048: aload 17
    //   1050: aconst_null
    //   1051: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1054: goto -802 -> 252
    //   1057: astore 16
    //   1059: ldc 94
    //   1061: aload 16
    //   1063: ldc_w 299
    //   1066: iconst_0
    //   1067: anewarray 98	java/lang/Object
    //   1070: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aconst_null
    //   1074: astore 16
    //   1076: goto -122 -> 954
    //   1079: iload 4
    //   1081: ifne +137 -> 1218
    //   1084: aload 18
    //   1086: aload 14
    //   1088: invokestatic 526	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1091: pop2
    //   1092: aload 16
    //   1094: getfield 529	com/tencent/mm/compatible/i/a$a:duration	I
    //   1097: i2l
    //   1098: invokestatic 533	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   1101: istore 7
    //   1103: aload 16
    //   1105: getfield 537	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1108: ifnull +132 -> 1240
    //   1111: aload 16
    //   1113: getfield 537	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1116: bipush 60
    //   1118: getstatic 543	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1121: aload 15
    //   1123: iconst_1
    //   1124: invokestatic 549	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1127: pop
    //   1128: iconst_0
    //   1129: istore 5
    //   1131: iload 5
    //   1133: ifeq +27 -> 1160
    //   1136: ldc_w 550
    //   1139: sipush 320
    //   1142: sipush 480
    //   1145: invokestatic 554	com/tencent/mm/sdk/platformtools/BitmapUtil:createColorBitmap	(III)Landroid/graphics/Bitmap;
    //   1148: bipush 60
    //   1150: getstatic 543	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1153: aload 15
    //   1155: iconst_1
    //   1156: invokestatic 549	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1159: pop
    //   1160: iload_3
    //   1161: istore 5
    //   1163: iload 4
    //   1165: ifne +19 -> 1184
    //   1168: iload_3
    //   1169: istore 5
    //   1171: aload 14
    //   1173: invokestatic 557	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   1176: ifne +8 -> 1184
    //   1179: ldc_w 558
    //   1182: istore 5
    //   1184: aload 15
    //   1186: invokestatic 557	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   1189: ifne +8 -> 1197
    //   1192: ldc_w 559
    //   1195: istore 5
    //   1197: aload_0
    //   1198: iload 5
    //   1200: aload 13
    //   1202: aload 18
    //   1204: iload 7
    //   1206: aload 12
    //   1208: aload 17
    //   1210: aload 15
    //   1212: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1215: goto -963 -> 252
    //   1218: ldc 146
    //   1220: istore_3
    //   1221: goto -129 -> 1092
    //   1224: astore 16
    //   1226: ldc 94
    //   1228: aload 16
    //   1230: ldc_w 299
    //   1233: iconst_0
    //   1234: anewarray 98	java/lang/Object
    //   1237: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1240: iconst_1
    //   1241: istore 5
    //   1243: goto -112 -> 1131
    //   1246: astore 16
    //   1248: ldc 94
    //   1250: aload 16
    //   1252: ldc_w 299
    //   1255: iconst_0
    //   1256: anewarray 98	java/lang/Object
    //   1259: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1262: goto -102 -> 1160
    //   1265: ldc_w 342
    //   1268: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1271: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1272	0	this	e
    //   837	34	1	d	double
    //   374	847	3	i	int
    //   811	353	4	j	int
    //   818	424	5	k	int
    //   26	231	6	m	int
    //   1101	104	7	n	int
    //   309	85	8	bool1	boolean
    //   209	666	9	bool2	boolean
    //   316	600	10	l	long
    //   367	840	12	localObject1	Object
    //   159	1042	13	str1	String
    //   201	971	14	str2	String
    //   190	1021	15	str3	String
    //   78	877	16	localObject2	Object
    //   1057	5	16	localException1	Exception
    //   1074	38	16	localObject3	Object
    //   1224	5	16	localException2	Exception
    //   1246	5	16	localException3	Exception
    //   122	1087	17	localContext	Context
    //   218	985	18	str4	String
    //   330	509	19	localPInt1	PInt
    //   506	265	20	localVideoTransPara	VideoTransPara
    //   524	62	21	localPInt2	PInt
    //   533	63	22	localPInt3	PInt
    //   542	64	23	localPInt4	PInt
    //   551	65	24	localPInt5	PInt
    // Exception table:
    //   from	to	target	type
    //   945	954	1057	java/lang/Exception
    //   1111	1128	1224	java/lang/Exception
    //   1136	1160	1246	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, l paraml);
    
    public abstract void b(String paramString, l paraml);
  }
  
  static final class b
    implements QueueWorkerThread.ThreadObject
  {
    String fileName;
    String mfq;
    VideoTransPara mhG;
    private int outputHeight;
    private int outputWidth;
    String oxH;
    private e.a usJ;
    l usK;
    int usV;
    private boolean usW;
    private int usX = 0;
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(181769);
      for (;;)
      {
        synchronized (e.usP)
        {
          int i;
          if (!e.cSg().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (y.Yk(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              Log.w("MicroMsg.EditorVideoCompress", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
              AppMethodBeat.o(181769);
              return true;
            }
          }
          else
          {
            i = 0;
          }
        }
        int j = 0;
      }
      if ((this.mhG != null) && (!this.mhG.lJx)) {
        this.outputWidth = this.mhG.width;
      }
      Object localObject3;
      for (this.outputHeight = this.mhG.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((a)h.ae(a.class)).bbT().a(this.mfq, (PString)???, (PInt)localObject3)) || (u.on(((PString)???).value, this.oxH) < 0L)) {
          break;
        }
        Log.i("MicroMsg.EditorVideoCompress", "copy remuxing file success, do not remuxing again.");
        this.usV = ((PInt)localObject3).value;
        this.usW = true;
        AppMethodBeat.o(181769);
        return true;
        ??? = new int[2];
        e.c(this.mfq, (int[])???);
        this.outputWidth = ???[0];
      }
      long l = Util.currentTicks();
      if (this.mhG != null)
      {
        Log.i("MicroMsg.EditorVideoCompress", "remuxing new para %s", new Object[] { this.mhG });
        this.usV = SightVideoJNI.remuxingVFS(this.mfq, this.oxH, this.outputWidth, this.outputHeight, this.mhG.videoBitrate, this.mhG.lJn, 8, this.mhG.lJm, 25.0F, this.mhG.fps, null, 0, false, 0, 51);
        this.usX = ((int)Util.ticksToNow(l));
        Log.i("MicroMsg.EditorVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.mfq, this.oxH, Integer.valueOf(this.usV), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
        if (this.usV < 0) {
          break label580;
        }
      }
      label580:
      for (boolean bool = true;; bool = false)
      {
        this.usW = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (y.a(this.oxH, (PInt)???, (PInt)localObject3)) {
          this.usV = ((PInt)???).value;
        }
        if (this.usW) {
          break label586;
        }
        Log.w("MicroMsg.EditorVideoCompress", "remuxing video error, copy source video to send.");
        u.deleteFile(this.oxH);
        u.on(this.mfq, this.oxH);
        AppMethodBeat.o(181769);
        return true;
        Log.w("MicroMsg.EditorVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
        this.usV = SightVideoJNI.remuxingVFS(this.mfq, this.oxH, this.outputWidth, this.outputHeight, d.JrI, d.JrH, 8, 2, 25.0F, d.JrJ, null, 0, false, 0, 51);
        break;
      }
      label586:
      Log.i("MicroMsg.EditorVideoCompress", "remuxing video sucess,insert to media duplication storage");
      for (;;)
      {
        PInt localPInt;
        try
        {
          localObject3 = new q(this.oxH);
          ??? = ((q)localObject3).getName();
          String str = this.oxH + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.oxH, str, localPInt)) {
            break label810;
          }
          bool = ((q)localObject3).cFq();
          localObject3 = new q(str);
          Log.i("MicroMsg.EditorVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(u.bj(((q)localObject3).ifA() + "/", ((q)localObject3).getName(), (String)???)), ((q)localObject3).bOF(), this.oxH });
          ((a)h.ae(a.class)).bbT().aB(this.mfq, this.oxH, this.usV);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.EditorVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
        }
        break;
        label810:
        Log.i("MicroMsg.EditorVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.mfq, this.oxH });
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(181770);
      synchronized (e.usP)
      {
        e.cSg().remove(this.fileName);
        if (this.usJ != null) {
          this.usJ.b(this.oxH, this.usK);
        }
        AppMethodBeat.o(181770);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */