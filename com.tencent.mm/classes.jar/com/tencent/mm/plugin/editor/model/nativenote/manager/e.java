package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bn;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
  extends Thread
{
  private static HashMap<String, b> oRd;
  private static Object oRe;
  private static bd oRf;
  public boolean isStop;
  private List<String> oQT;
  private List<Integer> oQU;
  private List<String> oQV;
  private List<String> oQW;
  private List<Integer> oQX;
  private a oQY;
  private l oQZ;
  private String oRa;
  private String oRb;
  private boolean oRc;
  
  static
  {
    AppMethodBeat.i(181778);
    oRd = new HashMap();
    oRe = new byte[0];
    AppMethodBeat.o(181778);
  }
  
  public e(List<String> paramList, String paramString1, String paramString2, l paraml, a parama)
  {
    AppMethodBeat.i(181771);
    this.oRc = false;
    this.oQT = paramList;
    this.oQU = new ArrayList();
    this.oQV = new ArrayList();
    this.oQX = new ArrayList();
    this.oQW = new ArrayList();
    this.oQY = parama;
    this.oQZ = paraml;
    this.oRb = paramString2;
    this.oRa = paramString1;
    AppMethodBeat.o(181771);
  }
  
  private void a(final int paramInt1, String paramString1, String paramString2, int paramInt2, VideoTransPara paramVideoTransPara, Context arg6, final String paramString3)
  {
    AppMethodBeat.i(181773);
    ac.i("MicroMsg.EditorVideoCompress", "finish to import %s to %s | ret %d | duration %d", new Object[] { paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    d(paramInt1, paramString1, paramString2, paramInt2);
    if (paramInt1 == -50002) {
      am(???, ???.getString(2131764675));
    }
    for (;;)
    {
      if ((this.oQY != null) && (!this.isStop)) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(181767);
            e.b(e.this).a(paramString3, e.a(e.this));
            if ((e.c(e.this)) || (paramInt1 != -50006)) {
              g.agU().m(new Runnable()
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
        am(???, ???.getString(2131764673));
      }
      else
      {
        if (paramInt1 == -50006)
        {
          fg(paramString1, paramString2);
          if (oRf == null) {
            oRf = new bd(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
          }
          b localb = new b((byte)0);
          synchronized (oRe)
          {
            oRd.put(paramString1, localb);
            localb.fileName = paramString1;
            localb.hYm = paramString2;
            localb.jtV = this.oRb;
            localb.iay = paramVideoTransPara;
            localb.oQY = this.oQY;
            localb.oQZ = this.oQZ;
            oRf.c(localb);
          }
        }
        if (paramInt1 < 0) {
          am(???, ???.getString(2131764674));
        } else {
          this.oRc = true;
        }
      }
    }
  }
  
  private void am(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(181774);
    ap.f(new Runnable()
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
  
  private void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(181777);
      this.oQU.add(Integer.valueOf(paramInt1));
      this.oQV.add(paramString1);
      this.oQW.add(paramString2);
      this.oQX.add(Integer.valueOf(paramInt2));
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
  public static void d(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 230	com/tencent/mm/compatible/h/d
    //   8: dup
    //   9: invokespecial 231	com/tencent/mm/compatible/h/d:<init>	()V
    //   12: astore 6
    //   14: aload 6
    //   16: astore 5
    //   18: aload 6
    //   20: aload_0
    //   21: invokevirtual 236	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   24: aload 6
    //   26: astore 5
    //   28: aload 6
    //   30: bipush 18
    //   32: invokevirtual 239	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   35: iconst_0
    //   36: invokestatic 245	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   39: istore_2
    //   40: aload 6
    //   42: astore 5
    //   44: aload 6
    //   46: bipush 19
    //   48: invokevirtual 239	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: iconst_0
    //   52: invokestatic 245	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   55: istore_3
    //   56: aload 6
    //   58: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
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
    //   90: ldc 228
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
    //   109: ldc 250
    //   111: iconst_0
    //   112: anewarray 100	java/lang/Object
    //   115: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload 6
    //   120: ifnull +8 -> 128
    //   123: aload 6
    //   125: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -69 -> 61
    //   133: astore_0
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +8 -> 147
    //   142: aload 5
    //   144: invokevirtual 248	android/media/MediaMetadataRetriever:release	()V
    //   147: ldc 228
    //   149: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   200: ldc 228
    //   202: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   16	127	5	locald1	com.tencent.mm.compatible.h.d
    //   12	112	6	locald2	com.tencent.mm.compatible.h.d
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
  
  private static void fg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(181775);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.EditorVideoCompress", "do insertVideoStorage, but file name is null");
      AppMethodBeat.o(181775);
      return;
    }
    s locals = new s();
    locals.fileName = paramString1;
    locals.hpy = 1;
    locals.drG = null;
    locals.iaC = ((String)g.agR().agA().get(2, ""));
    locals.createTime = bs.aNx();
    locals.iaH = bs.aNx();
    locals.iaO = null;
    locals.hYm = paramString2;
    if (!bs.isNullOrNil(paramString2)) {
      locals.iaM = 1;
    }
    locals.hux = 0;
    o.aJy().b(locals);
    AppMethodBeat.o(181775);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 333
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oQT	Ljava/util/List;
    //   10: ifnull +1255 -> 1265
    //   13: aload_0
    //   14: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oQT	Ljava/util/List;
    //   17: invokeinterface 337 1 0
    //   22: ifle +1243 -> 1265
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: aload_0
    //   31: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oQT	Ljava/util/List;
    //   34: invokeinterface 337 1 0
    //   39: if_icmpge +1226 -> 1265
    //   42: aload_0
    //   43: getfield 129	com/tencent/mm/plugin/editor/model/nativenote/manager/e:isStop	Z
    //   46: ifne +1219 -> 1265
    //   49: ldc 96
    //   51: ldc_w 339
    //   54: iconst_1
    //   55: anewarray 100	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oQT	Ljava/util/List;
    //   64: invokevirtual 340	java/lang/Object:toString	()Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 342	android/content/Intent
    //   74: dup
    //   75: invokespecial 343	android/content/Intent:<init>	()V
    //   78: astore 16
    //   80: aload 16
    //   82: new 151	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 345
    //   89: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 70	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oQT	Ljava/util/List;
    //   96: iload 6
    //   98: invokeinterface 348 2 0
    //   103: checkcast 297	java/lang/String
    //   106: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 357	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   115: invokevirtual 361	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   118: pop
    //   119: invokestatic 367	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   122: astore 17
    //   124: new 151	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 369
    //   131: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: invokestatic 281	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   137: invokevirtual 287	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   140: iconst_2
    //   141: ldc_w 289
    //   144: invokevirtual 295	com/tencent/mm/storage/ae:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 297	java/lang/String
    //   150: invokestatic 373	com/tencent/mm/modelvideo/t:DU	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 13
    //   161: aload_0
    //   162: getfield 89	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRa	Ljava/lang/String;
    //   165: invokestatic 259	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   168: ifne +13 -> 181
    //   171: aload_0
    //   172: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRb	Ljava/lang/String;
    //   175: invokestatic 259	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   178: ifeq +83 -> 261
    //   181: invokestatic 326	com/tencent/mm/modelvideo/o:aJy	()Lcom/tencent/mm/modelvideo/t;
    //   184: pop
    //   185: aload 13
    //   187: invokestatic 376	com/tencent/mm/modelvideo/t:DW	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 15
    //   192: invokestatic 326	com/tencent/mm/modelvideo/o:aJy	()Lcom/tencent/mm/modelvideo/t;
    //   195: pop
    //   196: aload 13
    //   198: invokestatic 379	com/tencent/mm/modelvideo/t:DV	(Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 14
    //   203: invokestatic 367	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   206: invokestatic 385	com/tencent/mm/sdk/platformtools/ax:is2G	(Landroid/content/Context;)Z
    //   209: istore 9
    //   211: aload 17
    //   213: aload 16
    //   215: invokestatic 390	com/tencent/mm/compatible/h/a:i	(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;
    //   218: astore 18
    //   220: aload 18
    //   222: invokestatic 259	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   225: ifeq +79 -> 304
    //   228: ldc 96
    //   230: ldc_w 392
    //   233: invokestatic 395	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: ldc_w 396
    //   240: aload 13
    //   242: aload 18
    //   244: iconst_0
    //   245: aconst_null
    //   246: aload 17
    //   248: aconst_null
    //   249: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   252: iload 6
    //   254: iconst_1
    //   255: iadd
    //   256: istore 6
    //   258: goto -230 -> 28
    //   261: aload_0
    //   262: getfield 89	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRa	Ljava/lang/String;
    //   265: astore 15
    //   267: aload_0
    //   268: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRb	Ljava/lang/String;
    //   271: aload_0
    //   272: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRb	Ljava/lang/String;
    //   275: ldc_w 400
    //   278: invokevirtual 404	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   281: iconst_1
    //   282: iadd
    //   283: aload_0
    //   284: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRb	Ljava/lang/String;
    //   287: invokevirtual 407	java/lang/String:length	()I
    //   290: invokevirtual 411	java/lang/String:substring	(II)Ljava/lang/String;
    //   293: astore 13
    //   295: aload_0
    //   296: getfield 87	com/tencent/mm/plugin/editor/model/nativenote/manager/e:oRb	Ljava/lang/String;
    //   299: astore 14
    //   301: goto -98 -> 203
    //   304: aload 18
    //   306: invokestatic 416	com/tencent/mm/plugin/a/c:FL	(Ljava/lang/String;)Z
    //   309: istore 8
    //   311: aload 18
    //   313: invokestatic 422	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   316: lstore 10
    //   318: iload 8
    //   320: ifeq +554 -> 874
    //   323: new 424	com/tencent/mm/pointers/PInt
    //   326: dup
    //   327: invokespecial 425	com/tencent/mm/pointers/PInt:<init>	()V
    //   330: astore 19
    //   332: invokestatic 431	com/tencent/mm/modelcontrol/d:aDL	()Lcom/tencent/mm/modelcontrol/d;
    //   335: aload 18
    //   337: invokevirtual 434	com/tencent/mm/modelcontrol/d:BW	(Ljava/lang/String;)Z
    //   340: ifeq +159 -> 499
    //   343: ldc 96
    //   345: ldc_w 436
    //   348: iconst_1
    //   349: anewarray 100	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload 18
    //   356: aastore
    //   357: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload 19
    //   362: iconst_1
    //   363: putfield 439	com/tencent/mm/pointers/PInt:value	I
    //   366: aconst_null
    //   367: astore 12
    //   369: aload 19
    //   371: getfield 439	com/tencent/mm/pointers/PInt:value	I
    //   374: istore_3
    //   375: ldc 96
    //   377: ldc_w 441
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
    //   395: invokestatic 446	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: aastore
    //   399: dup
    //   400: iconst_2
    //   401: lload 10
    //   403: invokestatic 451	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   406: aastore
    //   407: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: iload_3
    //   411: tableswitch	default:+61 -> 472, -6:+610->1021, -5:+628->1039, -4:+610->1021, -3:+610->1021, -2:+610->1021, -1:+591->1002, 0:+583->994, 1:+504->915, 2:+504->915, 3:+504->915, 4:+504->915, 5:+504->915
    //   473: iadd
    //   474: ldc_w 453
    //   477: invokestatic 395	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: ldc_w 454
    //   484: aload 13
    //   486: aload 18
    //   488: iconst_0
    //   489: aconst_null
    //   490: aload 17
    //   492: aconst_null
    //   493: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   496: goto -244 -> 252
    //   499: new 456	com/tencent/mm/modelcontrol/VideoTransPara
    //   502: dup
    //   503: invokespecial 457	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   506: astore 20
    //   508: new 424	com/tencent/mm/pointers/PInt
    //   511: dup
    //   512: invokespecial 425	com/tencent/mm/pointers/PInt:<init>	()V
    //   515: astore 12
    //   517: new 424	com/tencent/mm/pointers/PInt
    //   520: dup
    //   521: invokespecial 425	com/tencent/mm/pointers/PInt:<init>	()V
    //   524: astore 21
    //   526: new 424	com/tencent/mm/pointers/PInt
    //   529: dup
    //   530: invokespecial 425	com/tencent/mm/pointers/PInt:<init>	()V
    //   533: astore 22
    //   535: new 424	com/tencent/mm/pointers/PInt
    //   538: dup
    //   539: invokespecial 425	com/tencent/mm/pointers/PInt:<init>	()V
    //   542: astore 23
    //   544: new 424	com/tencent/mm/pointers/PInt
    //   547: dup
    //   548: invokespecial 425	com/tencent/mm/pointers/PInt:<init>	()V
    //   551: astore 24
    //   553: aload 18
    //   555: aload 12
    //   557: aload 21
    //   559: aload 22
    //   561: aload 23
    //   563: aload 24
    //   565: invokestatic 462	com/tencent/mm/plugin/sight/base/e:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   568: pop
    //   569: aload 20
    //   571: aload 12
    //   573: getfield 439	com/tencent/mm/pointers/PInt:value	I
    //   576: sipush 1000
    //   579: idiv
    //   580: putfield 465	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   583: aload 20
    //   585: aload 21
    //   587: getfield 439	com/tencent/mm/pointers/PInt:value	I
    //   590: putfield 468	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   593: aload 20
    //   595: aload 22
    //   597: getfield 439	com/tencent/mm/pointers/PInt:value	I
    //   600: putfield 471	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   603: aload 20
    //   605: aload 23
    //   607: getfield 439	com/tencent/mm/pointers/PInt:value	I
    //   610: putfield 474	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   613: aload 20
    //   615: aload 24
    //   617: getfield 439	com/tencent/mm/pointers/PInt:value	I
    //   620: putfield 477	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   623: ldc 96
    //   625: ldc_w 479
    //   628: iconst_1
    //   629: anewarray 100	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload 20
    //   636: aastore
    //   637: invokestatic 481	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: invokestatic 431	com/tencent/mm/modelcontrol/d:aDL	()Lcom/tencent/mm/modelcontrol/d;
    //   643: aload 20
    //   645: invokevirtual 484	com/tencent/mm/modelcontrol/d:c	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   648: astore 12
    //   650: aload 12
    //   652: ifnonnull +33 -> 685
    //   655: ldc 96
    //   657: ldc_w 486
    //   660: iconst_1
    //   661: anewarray 100	java/lang/Object
    //   664: dup
    //   665: iconst_0
    //   666: aload 20
    //   668: aastore
    //   669: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload 19
    //   674: bipush 251
    //   676: putfield 439	com/tencent/mm/pointers/PInt:value	I
    //   679: aconst_null
    //   680: astore 12
    //   682: goto -313 -> 369
    //   685: ldc 96
    //   687: ldc_w 488
    //   690: iconst_1
    //   691: anewarray 100	java/lang/Object
    //   694: dup
    //   695: iconst_0
    //   696: aload 12
    //   698: aastore
    //   699: invokestatic 481	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: aload 20
    //   704: getfield 477	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   707: ldc_w 489
    //   710: if_icmple +16 -> 726
    //   713: aload 12
    //   715: getfield 477	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   718: aload 20
    //   720: getfield 477	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   723: if_icmple +37 -> 760
    //   726: ldc 96
    //   728: ldc_w 491
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
    //   745: invokestatic 111	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   748: aload 19
    //   750: iconst_1
    //   751: putfield 439	com/tencent/mm/pointers/PInt:value	I
    //   754: aconst_null
    //   755: astore 12
    //   757: goto -388 -> 369
    //   760: aload 20
    //   762: getfield 474	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   765: bipush 45
    //   767: if_icmplt +31 -> 798
    //   770: aload 20
    //   772: getfield 465	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   775: sipush 1000
    //   778: imul
    //   779: ldc_w 492
    //   782: if_icmplt +16 -> 798
    //   785: aload 19
    //   787: bipush 250
    //   789: putfield 439	com/tencent/mm/pointers/PInt:value	I
    //   792: aconst_null
    //   793: astore 12
    //   795: goto -426 -> 369
    //   798: invokestatic 367	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   801: invokestatic 385	com/tencent/mm/sdk/platformtools/ax:is2G	(Landroid/content/Context;)Z
    //   804: istore 9
    //   806: aload 12
    //   808: getfield 468	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   811: istore 4
    //   813: aload 12
    //   815: getfield 471	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   818: istore 5
    //   820: iload 9
    //   822: ifeq +38 -> 860
    //   825: ldc_w 493
    //   828: istore_3
    //   829: iload 9
    //   831: ifeq +36 -> 867
    //   834: ldc2_w 494
    //   837: dstore_1
    //   838: aload 19
    //   840: aload 18
    //   842: iload 4
    //   844: iload 5
    //   846: iload_3
    //   847: dload_1
    //   848: ldc_w 496
    //   851: invokestatic 502	com/tencent/mm/plugin/sight/base/SightVideoJNI:shouldRemuxingVFS	(Ljava/lang/String;IIIDI)I
    //   854: putfield 439	com/tencent/mm/pointers/PInt:value	I
    //   857: goto -488 -> 369
    //   860: ldc_w 503
    //   863: istore_3
    //   864: goto -35 -> 829
    //   867: ldc2_w 504
    //   870: dstore_1
    //   871: goto -33 -> 838
    //   874: iload 9
    //   876: ifeq +24 -> 900
    //   879: ldc_w 493
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
    //   900: ldc_w 503
    //   903: istore_3
    //   904: goto -21 -> 883
    //   907: iconst_1
    //   908: istore_3
    //   909: aconst_null
    //   910: astore 12
    //   912: goto -537 -> 375
    //   915: lload 10
    //   917: ldc2_w 506
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
    //   936: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   939: iconst_0
    //   940: istore 4
    //   942: ldc 116
    //   944: istore_3
    //   945: aload 17
    //   947: aload 16
    //   949: invokestatic 511	com/tencent/mm/compatible/h/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/h/a$a;
    //   952: astore 16
    //   954: aload 16
    //   956: ifnonnull +123 -> 1079
    //   959: ldc 96
    //   961: ldc_w 392
    //   964: invokestatic 395	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: aload_0
    //   968: ldc_w 396
    //   971: aload 13
    //   973: aload 18
    //   975: iconst_0
    //   976: aconst_null
    //   977: aload 17
    //   979: aconst_null
    //   980: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
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
    //   1003: ldc_w 512
    //   1006: aload 13
    //   1008: aload 18
    //   1010: iconst_0
    //   1011: aconst_null
    //   1012: aload 17
    //   1014: aconst_null
    //   1015: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1018: goto -766 -> 252
    //   1021: aload_0
    //   1022: ldc 116
    //   1024: aload 13
    //   1026: aload 18
    //   1028: iconst_0
    //   1029: aconst_null
    //   1030: aload 17
    //   1032: aconst_null
    //   1033: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1036: goto -784 -> 252
    //   1039: aload_0
    //   1040: ldc 139
    //   1042: aload 13
    //   1044: aload 18
    //   1046: iconst_0
    //   1047: aconst_null
    //   1048: aload 17
    //   1050: aconst_null
    //   1051: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1054: goto -802 -> 252
    //   1057: astore 16
    //   1059: ldc 96
    //   1061: aload 16
    //   1063: ldc_w 289
    //   1066: iconst_0
    //   1067: anewarray 100	java/lang/Object
    //   1070: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aconst_null
    //   1074: astore 16
    //   1076: goto -122 -> 954
    //   1079: iload 4
    //   1081: ifne +137 -> 1218
    //   1084: aload 18
    //   1086: aload 14
    //   1088: invokestatic 516	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   1091: pop2
    //   1092: aload 16
    //   1094: getfield 519	com/tencent/mm/compatible/h/a$a:duration	I
    //   1097: i2l
    //   1098: invokestatic 523	com/tencent/mm/sdk/platformtools/bs:Aq	(J)I
    //   1101: istore 7
    //   1103: aload 16
    //   1105: getfield 527	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1108: ifnull +132 -> 1240
    //   1111: aload 16
    //   1113: getfield 527	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
    //   1116: bipush 60
    //   1118: getstatic 533	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1121: aload 15
    //   1123: iconst_1
    //   1124: invokestatic 538	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1127: pop
    //   1128: iconst_0
    //   1129: istore 5
    //   1131: iload 5
    //   1133: ifeq +27 -> 1160
    //   1136: ldc_w 539
    //   1139: sipush 320
    //   1142: sipush 480
    //   1145: invokestatic 543	com/tencent/mm/sdk/platformtools/f:aH	(III)Landroid/graphics/Bitmap;
    //   1148: bipush 60
    //   1150: getstatic 533	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1153: aload 15
    //   1155: iconst_1
    //   1156: invokestatic 538	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1159: pop
    //   1160: iload_3
    //   1161: istore 5
    //   1163: iload 4
    //   1165: ifne +19 -> 1184
    //   1168: iload_3
    //   1169: istore 5
    //   1171: aload 14
    //   1173: invokestatic 546	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   1176: ifne +8 -> 1184
    //   1179: ldc_w 547
    //   1182: istore 5
    //   1184: aload 15
    //   1186: invokestatic 546	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   1189: ifne +8 -> 1197
    //   1192: ldc_w 548
    //   1195: istore 5
    //   1197: aload_0
    //   1198: iload 5
    //   1200: aload 13
    //   1202: aload 18
    //   1204: iload 7
    //   1206: aload 12
    //   1208: aload 17
    //   1210: aload 15
    //   1212: invokespecial 398	com/tencent/mm/plugin/editor/model/nativenote/manager/e:a	(ILjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/modelcontrol/VideoTransPara;Landroid/content/Context;Ljava/lang/String;)V
    //   1215: goto -963 -> 252
    //   1218: ldc 141
    //   1220: istore_3
    //   1221: goto -129 -> 1092
    //   1224: astore 16
    //   1226: ldc 96
    //   1228: aload 16
    //   1230: ldc_w 289
    //   1233: iconst_0
    //   1234: anewarray 100	java/lang/Object
    //   1237: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1240: iconst_1
    //   1241: istore 5
    //   1243: goto -112 -> 1131
    //   1246: astore 16
    //   1248: ldc 96
    //   1250: aload 16
    //   1252: ldc_w 289
    //   1255: iconst_0
    //   1256: anewarray 100	java/lang/Object
    //   1259: invokestatic 254	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1262: goto -102 -> 1160
    //   1265: ldc_w 333
    //   1268: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    implements bd.a
  {
    String fileName;
    private int grA;
    private int grB;
    String hYm;
    VideoTransPara iay;
    String jtV;
    e.a oQY;
    l oQZ;
    int oRj;
    private boolean oRk;
    private int oRl = 0;
    
    public final boolean aBj()
    {
      AppMethodBeat.i(181769);
      for (;;)
      {
        synchronized (e.oRe)
        {
          int i;
          if (!e.bZS().containsKey(this.fileName))
          {
            i = 1;
            j = i;
            if (i == 0)
            {
              if (u.Ej(this.fileName) == null) {
                j = 1;
              }
            }
            else
            {
              if (j == 0) {
                break;
              }
              ac.w("MicroMsg.EditorVideoCompress", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
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
      if ((this.iay != null) && (!this.iay.isDefault)) {
        this.grA = this.iay.width;
      }
      Object localObject3;
      for (this.grB = this.iay.height;; this.grB = ???[1])
      {
        ??? = new PString();
        localObject3 = new PInt();
        if ((!((a)g.ab(a.class)).awI().a(this.hYm, (PString)???, (PInt)localObject3)) || (i.lZ(((PString)???).value, this.jtV) < 0L)) {
          break;
        }
        ac.i("MicroMsg.EditorVideoCompress", "copy remuxing file success, do not remuxing again.");
        this.oRj = ((PInt)localObject3).value;
        this.oRk = true;
        AppMethodBeat.o(181769);
        return true;
        ??? = new int[2];
        e.d(this.hYm, (int[])???);
        this.grA = ???[0];
      }
      long l = bs.Gn();
      if (this.iay != null)
      {
        ac.i("MicroMsg.EditorVideoCompress", "remuxing new para %s", new Object[] { this.iay });
        this.oRj = SightVideoJNI.remuxingVFS(this.hYm, this.jtV, this.grA, this.grB, this.iay.videoBitrate, this.iay.hCA, 8, this.iay.hCz, 25.0F, this.iay.fps, null, 0, false, 0, 51);
        this.oRl = ((int)bs.aO(l));
        ac.i("MicroMsg.EditorVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.hYm, this.jtV, Integer.valueOf(this.oRj), Integer.valueOf(this.grA), Integer.valueOf(this.grB) });
        if (this.oRj < 0) {
          break label580;
        }
      }
      label580:
      for (boolean bool = true;; bool = false)
      {
        this.oRk = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (u.a(this.jtV, (PInt)???, (PInt)localObject3)) {
          this.oRj = ((PInt)???).value;
        }
        if (this.oRk) {
          break label586;
        }
        ac.w("MicroMsg.EditorVideoCompress", "remuxing video error, copy source video to send.");
        i.deleteFile(this.jtV);
        i.lZ(this.hYm, this.jtV);
        AppMethodBeat.o(181769);
        return true;
        ac.w("MicroMsg.EditorVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
        this.oRj = SightVideoJNI.remuxingVFS(this.hYm, this.jtV, this.grA, this.grB, c.xCs, c.xCr, 8, 2, 25.0F, c.xCt, null, 0, false, 0, 51);
        break;
      }
      label586:
      ac.i("MicroMsg.EditorVideoCompress", "remuxing video sucess,insert to media duplication storage");
      for (;;)
      {
        PInt localPInt;
        try
        {
          localObject3 = new com.tencent.mm.vfs.e(this.jtV);
          ??? = ((com.tencent.mm.vfs.e)localObject3).getName();
          String str = this.jtV + ".tmp";
          localPInt = new PInt(0);
          if (!com.tencent.mm.plugin.a.e.b(this.jtV, str, localPInt)) {
            break label813;
          }
          bool = ((com.tencent.mm.vfs.e)localObject3).delete();
          localObject3 = new com.tencent.mm.vfs.e(str);
          ac.i("MicroMsg.EditorVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(i.aT(((com.tencent.mm.vfs.e)localObject3).getParent() + "/", ((com.tencent.mm.vfs.e)localObject3).getName(), (String)???)), q.B(((com.tencent.mm.vfs.e)localObject3).fxV()), this.jtV });
          ((a)g.ab(a.class)).awI().ah(this.hYm, this.jtV, this.oRj);
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.EditorVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
        }
        break;
        label813:
        ac.i("MicroMsg.EditorVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.hYm, this.jtV });
      }
    }
    
    public final boolean aBk()
    {
      AppMethodBeat.i(181770);
      synchronized (e.oRe)
      {
        e.bZS().remove(this.fileName);
        if (this.oQY != null) {
          this.oQY.b(this.jtV, this.oQZ);
        }
        AppMethodBeat.o(181770);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.e
 * JD-Core Version:    0.7.0.1
 */