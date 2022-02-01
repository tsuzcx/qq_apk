package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cb;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  extends Thread
{
  private static HashMap<String, b> xzl;
  private static Object xzm;
  private static QueueWorkerThread xzn;
  public boolean isStop;
  private List<String> xzb;
  private List<Integer> xzc;
  private List<String> xzd;
  private List<String> xze;
  private List<Integer> xzf;
  private a xzg;
  private l xzh;
  private String xzi;
  private String xzj;
  private boolean xzk;
  
  static
  {
    AppMethodBeat.i(181778);
    xzl = new HashMap();
    xzm = new byte[0];
    AppMethodBeat.o(181778);
  }
  
  public e(List<String> paramList, String paramString1, String paramString2, l paraml, a parama)
  {
    AppMethodBeat.i(181771);
    this.xzk = false;
    this.xzb = paramList;
    this.xzc = new ArrayList();
    this.xzd = new ArrayList();
    this.xzf = new ArrayList();
    this.xze = new ArrayList();
    this.xzg = parama;
    this.xzh = paraml;
    this.xzj = paramString2;
    this.xzi = paramString1;
    AppMethodBeat.o(181771);
  }
  
  private void a(final int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, final String paramString3)
  {
    AppMethodBeat.i(181773);
    Log.i("MicroMsg.EditorVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      ax(???, ???.getString(d.h.video_export_file_too_big));
    }
    for (;;)
    {
      if ((this.xzg != null) && (!this.isStop)) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181767);
            e.b(e.this).a(paramString3, e.a(e.this));
            if ((e.c(e.this)) || (paramInt1 != -50006)) {
              h.baH().postToWorkerDelayed(new Runnable()
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
        ax(???, ???.getString(d.h.video_export_duration_too_long));
      }
      else
      {
        b localb;
        if (paramInt1 == -50006)
        {
          gC(paramString1, paramString2);
          if (xzn == null) {
            xzn = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
          }
          localb = new b((byte)0);
        }
        synchronized (xzm)
        {
          xzl.put(paramString1, localb);
          localb.fileName = paramString1;
          localb.oYj = paramString2;
          localb.rBg = this.xzj;
          localb.paR = paramVideoTransPara;
          b.a(localb, this.xzg);
          localb.xzh = this.xzh;
          xzn.add(localb);
        }
        continue;
        this.xzk = true;
      }
    }
  }
  
  private void ax(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(181774);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(181768);
        Toast.makeText(paramContext, paramString, 0).show();
        AppMethodBeat.o(181768);
      }
    });
    AppMethodBeat.o(181774);
  }
  
  private void c(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(181777);
      this.xzc.add(Integer.valueOf(paramInt1));
      this.xzd.add(paramString1);
      this.xze.add(paramString2);
      this.xzf.add(Integer.valueOf(paramInt2));
      AppMethodBeat.o(181777);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static void c(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: ldc 234
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 236	com/tencent/mm/compatible/i/d
    //   8: dup
    //   9: invokespecial 237	com/tencent/mm/compatible/i/d:<init>	()V
    //   12: astore 6
    //   14: aload 6
    //   16: astore 5
    //   18: aload 6
    //   20: aload_0
    //   21: invokevirtual 242	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   24: aload 6
    //   26: astore 5
    //   28: aload 6
    //   30: bipush 18
    //   32: invokevirtual 245	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   35: iconst_0
    //   36: invokestatic 251	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   39: istore_2
    //   40: aload 6
    //   42: astore 5
    //   44: aload 6
    //   46: bipush 19
    //   48: invokevirtual 245	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: iconst_0
    //   52: invokestatic 251	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   55: istore_3
    //   56: aload 6
    //   58: invokevirtual 254	android/media/MediaMetadataRetriever:release	()V
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
    //   75: if_icmpge +118 -> 193
    //   78: iload_2
    //   79: iconst_2
    //   80: irem
    //   81: ifne +9 -> 90
    //   84: iload_3
    //   85: iconst_2
    //   86: irem
    //   87: ifeq +68 -> 155
    //   90: ldc 234
    //   92: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: astore_0
    //   97: iconst_0
    //   98: istore_2
    //   99: aconst_null
    //   100: astore 6
    //   102: aload 6
    //   104: astore 5
    //   106: ldc 96
    //   108: aload_0
    //   109: ldc_w 256
    //   112: iconst_0
    //   113: anewarray 100	java/lang/Object
    //   116: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload 6
    //   121: ifnull +8 -> 129
    //   124: aload 6
    //   126: invokevirtual 254	android/media/MediaMetadataRetriever:release	()V
    //   129: iconst_0
    //   130: istore_3
    //   131: goto -70 -> 61
    //   134: astore_0
    //   135: aconst_null
    //   136: astore 5
    //   138: aload 5
    //   140: ifnull +8 -> 148
    //   143: aload 5
    //   145: invokevirtual 254	android/media/MediaMetadataRetriever:release	()V
    //   148: ldc 234
    //   150: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_0
    //   154: athrow
    //   155: iload_2
    //   156: iload_3
    //   157: if_icmplt +17 -> 174
    //   160: iload_2
    //   161: sipush 640
    //   164: if_icmple +29 -> 193
    //   167: iload_3
    //   168: sipush 480
    //   171: if_icmple +22 -> 193
    //   174: iload_2
    //   175: iload_3
    //   176: if_icmpgt +31 -> 207
    //   179: iload_2
    //   180: sipush 480
    //   183: if_icmple +10 -> 193
    //   186: iload_3
    //   187: sipush 640
    //   190: if_icmpgt +17 -> 207
    //   193: aload_1
    //   194: iconst_0
    //   195: iload_2
    //   196: iastore
    //   197: aload_1
    //   198: iconst_1
    //   199: iload_3
    //   200: iastore
    //   201: ldc 234
    //   203: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: return
    //   207: iload_2
    //   208: iconst_2
    //   209: idiv
    //   210: istore_2
    //   211: iload_3
    //   212: iconst_2
    //   213: idiv
    //   214: istore_3
    //   215: iload 4
    //   217: iconst_1
    //   218: iadd
    //   219: istore 4
    //   221: goto -149 -> 72
    //   224: astore_0
    //   225: goto -87 -> 138
    //   228: astore_0
    //   229: iconst_0
    //   230: istore_2
    //   231: goto -129 -> 102
    //   234: astore_0
    //   235: goto -133 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramString	String
    //   0	238	1	paramArrayOfInt	int[]
    //   39	192	2	i	int
    //   55	160	3	j	int
    //   70	150	4	k	int
    //   16	128	5	locald1	com.tencent.mm.compatible.i.d
    //   12	113	6	locald2	com.tencent.mm.compatible.i.d
    // Exception table:
    //   from	to	target	type
    //   5	14	96	java/lang/Exception
    //   5	14	134	finally
    //   18	24	224	finally
    //   28	40	224	finally
    //   44	56	224	finally
    //   106	119	224	finally
    //   18	24	228	java/lang/Exception
    //   28	40	228	java/lang/Exception
    //   44	56	234	java/lang/Exception
  }
  
  private static void gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(181775);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.EditorVideoCompress", "do insertVideoStorage, but file name is null");
      AppMethodBeat.o(181775);
      return;
    }
    z localz = new z();
    localz.fileName = paramString1;
    localz.omT = 1;
    localz.hVQ = null;
    localz.paV = ((String)h.baE().ban().d(2, ""));
    localz.createTime = Util.nowSecond();
    localz.pba = Util.nowSecond();
    localz.pbh = null;
    localz.oYj = paramString2;
    if (!Util.isNullOrNil(paramString2)) {
      localz.pbf = 1;
    }
    localz.osy = 0;
    v.bOh().b(localz);
    AppMethodBeat.o(181775);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 342
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzb	Ljava/util/List;
    //   10: ifnull +1256 -> 1266
    //   13: aload_0
    //   14: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzb	Ljava/util/List;
    //   17: invokeinterface 346 1 0
    //   22: ifle +1244 -> 1266
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: aload_0
    //   31: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzb	Ljava/util/List;
    //   34: invokeinterface 346 1 0
    //   39: if_icmpge +1227 -> 1266
    //   42: aload_0
    //   43: getfield 134	com/tencent/mm/plugin/editor/model/nativenote/manager/e:isStop	Z
    //   46: ifne +1220 -> 1266
    //   49: ldc 96
    //   51: ldc_w 348
    //   54: iconst_1
    //   55: anewarray 100	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzb	Ljava/util/List;
    //   64: invokevirtual 349	java/lang/Object:toString	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 351	android/content/Intent
    //   74: dup
    //   75: invokespecial 352	android/content/Intent:<init>	()V
    //   78: astore 16
    //   80: aload 16
    //   82: new 158	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 354
    //   89: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzb	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 358 2 0
    //   103: checkcast 306	java/lang/String
    //   106: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 367	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   115: invokevirtual 371	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   118: pop
    //   119: invokestatic 377	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   122: astore 17
    //   124: new 158	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 379
    //   131: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: invokestatic 291	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   137: invokevirtual 297	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   140: iconst_2
    //   141: ldc_w 299
    //   144: invokevirtual 304	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 306	java/lang/String
    //   150: invokestatic 383	com/tencent/mm/modelvideo/aa:PV	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 13
    //   161: aload_0
    //   162: getfield 89	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzi	Ljava/lang/String;
    //   165: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   168: ifne +13 -> 181
    //   171: aload_0
    //   172: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzj	Ljava/lang/String;
    //   175: invokestatic 270	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   178: ifeq +83 -> 261
    //   181: invokestatic 335	com/tencent/mm/modelvideo/v:bOh	()Lcom/tencent/mm/modelvideo/aa;
    //   184: pop
    //   185: aload 13
    //   187: invokestatic 386	com/tencent/mm/modelvideo/aa:PY	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 15
    //   192: invokestatic 335	com/tencent/mm/modelvideo/v:bOh	()Lcom/tencent/mm/modelvideo/aa;
    //   195: pop
    //   196: aload 13
    //   198: invokestatic 389	com/tencent/mm/modelvideo/aa:PX	(Ljava/lang/String;)Ljava/lang/String;
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
    //   228: ldc 96
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
    //   262: getfield 89	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzi	Ljava/lang/String;
    //   265: astore 15
    //   267: aload_0
    //   268: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzj	Ljava/lang/String;
    //   271: aload_0
    //   272: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzj	Ljava/lang/String;
    //   275: ldc_w 410
    //   278: invokevirtual 414	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   281: iconst_1
    //   282: iadd
    //   283: aload_0
    //   284: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzj	Ljava/lang/String;
    //   287: invokevirtual 417	java/lang/String:length	()I
    //   290: invokevirtual 421	java/lang/String:substring	(II)Ljava/lang/String;
    //   293: astore 13
    //   295: aload_0
    //   296: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:xzj	Ljava/lang/String;
    //   299: astore 14
    //   301: goto -98 -> 203
    //   304: aload 18
    //   306: invokestatic 426	com/tencent/mm/plugin/a/c:Sm	(Ljava/lang/String;)Z
    //   309: istore 8
    //   311: aload 18
    //   313: invokestatic 432	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   316: lstore 10
    //   318: iload 8
    //   320: ifeq +554 -> 874
    //   323: new 434	com/tencent/mm/pointers/PInt
    //   326: dup
    //   327: invokespecial 435	com/tencent/mm/pointers/PInt:<init>	()V
    //   330: astore 19
    //   332: invokestatic 441	com/tencent/mm/modelcontrol/e:bIg	()Lcom/tencent/mm/modelcontrol/e;
    //   335: aload 18
    //   337: invokevirtual 444	com/tencent/mm/modelcontrol/e:NE	(Ljava/lang/String;)Z
    //   340: ifeq +159 -> 499
    //   343: ldc 96
    //   345: ldc_w 446
    //   348: iconst_1
    //   349: anewarray 100	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload 18
    //   356: aastore
    //   357: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload 19
    //   362: iconst_1
    //   363: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   366: aconst_null
    //   367: astore 12
    //   369: aload 19
    //   371: getfield 449	com/tencent/mm/pointers/PInt:value	I
    //   374: istore_3
    //   375: ldc 96
    //   377: ldc_w 451
    //   380: iconst_3
    //   381: anewarray 100	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: iload_3
    //   387: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   407: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: iload_3
    //   411: tableswitch	default:+61 -> 472, -6:+610->1021, -5:+628->1039, -4:+610->1021, -3:+610->1021, -2:+610->1021, -1:+591->1002, 0:+583->994, 1:+504->915, 2:+504->915, 3:+504->915, 4:+504->915, 5:+504->915
    //   473: iadd
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
    //   623: ldc 96
    //   625: ldc_w 489
    //   628: iconst_1
    //   629: anewarray 100	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload 20
    //   636: aastore
    //   637: invokestatic 491	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: invokestatic 441	com/tencent/mm/modelcontrol/e:bIg	()Lcom/tencent/mm/modelcontrol/e;
    //   643: aload 20
    //   645: invokevirtual 494	com/tencent/mm/modelcontrol/e:c	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   648: astore 12
    //   650: aload 12
    //   652: ifnonnull +33 -> 685
    //   655: ldc 96
    //   657: ldc_w 496
    //   660: iconst_1
    //   661: anewarray 100	java/lang/Object
    //   664: dup
    //   665: iconst_0
    //   666: aload 20
    //   668: aastore
    //   669: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload 19
    //   674: bipush 251
    //   676: putfield 449	com/tencent/mm/pointers/PInt:value	I
    //   679: aconst_null
    //   680: astore 12
    //   682: goto -313 -> 369
    //   685: ldc 96
    //   687: ldc_w 498
    //   690: iconst_1
    //   691: anewarray 100	java/lang/Object
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
    //   726: ldc 96
    //   728: ldc_w 501
    //   731: iconst_2
    //   732: anewarray 100	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload 12
    //   739: aastore
    //   740: dup
    //   741: iconst_1
    //   742: aload 20
    //   744: aastore
    //   745: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   925: ldc 116
    //   927: aload 13
    //   929: aload 18
    //   931: iconst_0
    //   932: aconst_null
    //   933: aload 17
    //   935: aconst_null
    //   936: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   939: iconst_0
    //   940: istore 4
    //   942: ldc 116
    //   944: istore_3
    //   945: aload 17
    //   947: aload 16
    //   949: invokestatic 521	com/tencent/mm/compatible/i/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/i/a$a;
    //   952: astore 16
    //   954: aload 16
    //   956: ifnonnull +123 -> 1079
    //   959: ldc 96
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
    //   1022: ldc 116
    //   1024: aload 13
    //   1026: aload 18
    //   1028: iconst_0
    //   1029: aconst_null
    //   1030: aload 17
    //   1032: aconst_null
    //   1033: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1036: goto -784 -> 252
    //   1039: aload_0
    //   1040: ldc 144
    //   1042: aload 13
    //   1044: aload 18
    //   1046: iconst_0
    //   1047: aconst_null
    //   1048: aload 17
    //   1050: aconst_null
    //   1051: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1054: goto -802 -> 252
    //   1057: astore 16
    //   1059: ldc 96
    //   1061: aload 16
    //   1063: ldc_w 299
    //   1066: iconst_0
    //   1067: anewarray 100	java/lang/Object
    //   1070: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aconst_null
    //   1074: astore 16
    //   1076: goto -122 -> 954
    //   1079: iload 4
    //   1081: ifne +138 -> 1219
    //   1084: aload 18
    //   1086: aload 14
    //   1088: iconst_0
    //   1089: invokestatic 526	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1092: pop2
    //   1093: aload 16
    //   1095: getfield 529	com/tencent/mm/compatible/i/a$a:duration	I
    //   1098: i2l
    //   1099: invokestatic 533	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   1102: istore 7
    //   1104: aload 16
    //   1106: getfield 537	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1109: ifnull +132 -> 1241
    //   1112: aload 16
    //   1114: getfield 537	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1117: bipush 60
    //   1119: getstatic 543	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1122: aload 15
    //   1124: iconst_1
    //   1125: invokestatic 549	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1128: pop
    //   1129: iconst_0
    //   1130: istore 5
    //   1132: iload 5
    //   1134: ifeq +27 -> 1161
    //   1137: ldc_w 550
    //   1140: sipush 320
    //   1143: sipush 480
    //   1146: invokestatic 554	com/tencent/mm/sdk/platformtools/BitmapUtil:createColorBitmap	(III)Landroid/graphics/Bitmap;
    //   1149: bipush 60
    //   1151: getstatic 543	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1154: aload 15
    //   1156: iconst_1
    //   1157: invokestatic 549	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1160: pop
    //   1161: iload_3
    //   1162: istore 5
    //   1164: iload 4
    //   1166: ifne +19 -> 1185
    //   1169: iload_3
    //   1170: istore 5
    //   1172: aload 14
    //   1174: invokestatic 557	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1177: ifne +8 -> 1185
    //   1180: ldc_w 558
    //   1183: istore 5
    //   1185: aload 15
    //   1187: invokestatic 557	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1190: ifne +8 -> 1198
    //   1193: ldc_w 559
    //   1196: istore 5
    //   1198: aload_0
    //   1199: iload 5
    //   1201: aload 13
    //   1203: aload 18
    //   1205: iload 7
    //   1207: aload 12
    //   1209: aload 17
    //   1211: aload 15
    //   1213: invokespecial 408	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1216: goto -964 -> 252
    //   1219: ldc 148
    //   1221: istore_3
    //   1222: goto -129 -> 1093
    //   1225: astore 16
    //   1227: ldc 96
    //   1229: aload 16
    //   1231: ldc_w 299
    //   1234: iconst_0
    //   1235: anewarray 100	java/lang/Object
    //   1238: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1241: iconst_1
    //   1242: istore 5
    //   1244: goto -112 -> 1132
    //   1247: astore 16
    //   1249: ldc 96
    //   1251: aload 16
    //   1253: ldc_w 299
    //   1256: iconst_0
    //   1257: anewarray 100	java/lang/Object
    //   1260: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1263: goto -102 -> 1161
    //   1266: ldc_w 342
    //   1269: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1272: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1273	0	this	e
    //   837	34	1	d	double
    //   374	848	3	i	int
    //   811	354	4	j	int
    //   818	425	5	k	int
    //   26	231	6	m	int
    //   1102	104	7	n	int
    //   309	85	8	bool1	boolean
    //   209	666	9	bool2	boolean
    //   316	600	10	l	long
    //   367	841	12	localObject1	Object
    //   159	1043	13	str1	String
    //   201	972	14	str2	String
    //   190	1022	15	str3	String
    //   78	877	16	localObject2	Object
    //   1057	5	16	localException1	Exception
    //   1074	39	16	localObject3	Object
    //   1225	5	16	localException2	Exception
    //   1247	5	16	localException3	Exception
    //   122	1088	17	localContext	Context
    //   218	986	18	str4	String
    //   330	509	19	localPInt1	PInt
    //   506	265	20	localVideoTransPara	VideoTransPara
    //   524	62	21	localPInt2	PInt
    //   533	63	22	localPInt3	PInt
    //   542	64	23	localPInt4	PInt
    //   551	65	24	localPInt5	PInt
    // Exception table:
    //   from	to	target	type
    //   945	954	1057	java/lang/Exception
    //   1112	1129	1225	java/lang/Exception
    //   1137	1161	1247	java/lang/Exception
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
    String oYj;
    private int outputHeight;
    private int outputWidth;
    VideoTransPara paR;
    String rBg;
    private e.a xzg;
    l xzh;
    int xzs;
    private boolean xzt;
    private int xzu = 0;
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(181769);
      for (;;)
      {
        synchronized (e.xzm)
        {
          int i;
          if (!e.dwz().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (ab.Qo(this.fileName) == null) {
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
      if ((this.paR != null) && (!this.paR.oBZ)) {
        this.outputWidth = this.paR.width;
      }
      Object localObject3;
      for (this.outputHeight = this.paR.height;; this.outputHeight = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((a)h.ax(a.class)).bzI().a(this.oYj, (PString)???, (PInt)localObject3)) || (y.O(((PString)???).value, this.rBg, false) < 0L)) {
          break;
        }
        Log.i("MicroMsg.EditorVideoCompress", "copy remuxing file success, do not remuxing again.");
        this.xzs = ((PInt)localObject3).value;
        this.xzt = true;
        AppMethodBeat.o(181769);
        return true;
        ??? = new int[2];
        e.c(this.oYj, (int[])???);
        this.outputWidth = ???[0];
      }
      long l = Util.currentTicks();
      if (this.paR != null)
      {
        Log.i("MicroMsg.EditorVideoCompress", "remuxing new para %s", new Object[] { this.paR });
        this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, this.paR.videoBitrate, this.paR.oBP, 8, this.paR.oBO, 25.0F, this.paR.fps, null, 0, false, 0, 51);
        this.xzu = ((int)Util.ticksToNow(l));
        Log.i("MicroMsg.EditorVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.oYj, this.rBg, Integer.valueOf(this.xzs), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
        if (this.xzs < 0) {
          break label582;
        }
      }
      label582:
      for (boolean bool = true;; bool = false)
      {
        this.xzt = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (ab.a(this.rBg, (PInt)???, (PInt)localObject3)) {
          this.xzs = ((PInt)???).value;
        }
        if (this.xzt) {
          break label588;
        }
        Log.w("MicroMsg.EditorVideoCompress", "remuxing video error, copy source video to send.");
        y.deleteFile(this.rBg);
        y.O(this.oYj, this.rBg, false);
        AppMethodBeat.o(181769);
        return true;
        Log.w("MicroMsg.EditorVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
        this.xzs = SightVideoJNI.remuxingVFS(this.oYj, this.rBg, this.outputWidth, this.outputHeight, d.PFk, d.PFj, 8, 2, 25.0F, d.PFl, null, 0, false, 0, 51);
        break;
      }
      label588:
      Log.i("MicroMsg.EditorVideoCompress", "remuxing video sucess,insert to media duplication storage");
      for (;;)
      {
        PInt localPInt;
        try
        {
          localObject3 = new u(this.rBg);
          ??? = ((u)localObject3).getName();
          String str = this.rBg + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.rBg, str, localPInt)) {
            break label815;
          }
          bool = ((u)localObject3).diJ();
          localObject3 = new u(str);
          Log.i("MicroMsg.EditorVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(y.bF(((u)localObject3).jKO() + "/", ((u)localObject3).getName(), (String)???)), ah.v(((u)localObject3).jKT()), this.rBg });
          ((a)h.ax(a.class)).bzI().aO(this.oYj, this.rBg, this.xzs);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.EditorVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
        }
        break;
        label815:
        Log.i("MicroMsg.EditorVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.oYj, this.rBg });
      }
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(181770);
      synchronized (e.xzm)
      {
        e.dwz().remove(this.fileName);
        if (this.xzg != null) {
          this.xzg.b(this.rBg, this.xzh);
        }
        AppMethodBeat.o(181770);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */