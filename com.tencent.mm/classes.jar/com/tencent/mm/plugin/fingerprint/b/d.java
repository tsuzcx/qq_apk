package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.File;

public final class d
{
  private static boolean skd = false;
  
  public static boolean cHi()
  {
    AppMethodBeat.i(64314);
    boolean bool = ((i)g.ab(i.class)).cHB();
    AppMethodBeat.o(64314);
    return bool;
  }
  
  public static String cHo()
  {
    AppMethodBeat.i(64306);
    String str = m.dTv();
    AppMethodBeat.o(64306);
    return str;
  }
  
  public static void cHp()
  {
    AppMethodBeat.i(64307);
    g.agS();
    g.agR().agA().set(ah.a.GFB, Boolean.TRUE);
    AppMethodBeat.o(64307);
  }
  
  public static boolean cHq()
  {
    AppMethodBeat.i(64308);
    g.agS();
    Object localObject = g.agR().agA().get(ah.a.GFB, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64308);
      return bool;
    }
  }
  
  public static void cHr()
  {
    AppMethodBeat.i(64309);
    g.agS();
    g.agR().agA().set(ah.a.GFC, Boolean.TRUE);
    AppMethodBeat.o(64309);
  }
  
  public static boolean cHs()
  {
    AppMethodBeat.i(64311);
    g.agS();
    Object localObject = g.agR().agA().get(ah.a.GFE, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64311);
      return bool;
    }
  }
  
  public static boolean cHt()
  {
    AppMethodBeat.i(64313);
    g.agS();
    Object localObject = g.agR().agA().get(ah.a.GFF, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64313);
      return bool;
    }
  }
  
  public static boolean cHu()
  {
    return skd;
  }
  
  public static boolean cHv()
  {
    AppMethodBeat.i(64315);
    ac.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
    if (cHs())
    {
      ac.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
      AppMethodBeat.o(64315);
      return false;
    }
    Object localObject = (i)g.ab(i.class);
    if ((((i)localObject).cHF() == 1) && (((i)localObject).cHB()))
    {
      ac.e("MicroMsg.FingerPrintUtil", "device is not support");
      AppMethodBeat.o(64315);
      return false;
    }
    if ((s.ery().esc()) || (s.ery().esb()))
    {
      ac.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
      AppMethodBeat.o(64315);
      return false;
    }
    if (!s.ery().esi().erQ())
    {
      ac.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
      AppMethodBeat.o(64315);
      return false;
    }
    if (!((i)g.ab(i.class)).cHC())
    {
      g.agS();
      localObject = g.agR().agA().get(ah.a.GFC, Boolean.FALSE);
      if (localObject == null) {
        break label205;
      }
    }
    label205:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (!bool)
      {
        ac.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
        AppMethodBeat.o(64315);
        return true;
      }
      AppMethodBeat.o(64315);
      return false;
    }
  }
  
  public static final String eZ(Context paramContext)
  {
    AppMethodBeat.i(64316);
    paramContext = paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    AppMethodBeat.o(64316);
    return paramContext;
  }
  
  /* Error */
  public static int fa(Context paramContext)
  {
    // Byte code:
    //   0: ldc 199
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: invokestatic 201	com/tencent/mm/plugin/fingerprint/b/d:eZ	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 7
    //   15: new 203	com/tencent/mm/vfs/e
    //   18: dup
    //   19: aload 7
    //   21: invokespecial 206	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 209	com/tencent/mm/vfs/e:exists	()Z
    //   31: ifne +188 -> 219
    //   34: iconst_1
    //   35: istore_1
    //   36: aconst_null
    //   37: astore_2
    //   38: iload_1
    //   39: ifeq +809 -> 848
    //   42: aload_2
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 213	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc 215
    //   50: invokevirtual 221	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_0
    //   54: aload_0
    //   55: astore_3
    //   56: aload_0
    //   57: astore_2
    //   58: aload 8
    //   60: invokestatic 227	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   63: astore 4
    //   65: aload 4
    //   67: astore_3
    //   68: aload_0
    //   69: astore_2
    //   70: sipush 1024
    //   73: newarray byte
    //   75: astore 5
    //   77: aload 4
    //   79: astore_3
    //   80: aload_0
    //   81: astore_2
    //   82: aload_0
    //   83: aload 5
    //   85: invokevirtual 233	java/io/InputStream:read	([B)I
    //   88: istore_1
    //   89: iload_1
    //   90: iconst_m1
    //   91: if_icmpeq +378 -> 469
    //   94: aload 4
    //   96: astore_3
    //   97: aload_0
    //   98: astore_2
    //   99: aload 4
    //   101: aload 5
    //   103: iconst_0
    //   104: iload_1
    //   105: invokevirtual 239	java/io/OutputStream:write	([BII)V
    //   108: goto -31 -> 77
    //   111: astore 5
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: astore_2
    //   118: ldc 108
    //   120: aload 5
    //   122: ldc 241
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload 4
    //   133: astore_3
    //   134: aload_0
    //   135: astore_2
    //   136: ldc 108
    //   138: new 165	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 247
    //   144: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload 5
    //   149: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 254	java/io/InputStream:close	()V
    //   169: aload 4
    //   171: ifnull +667 -> 838
    //   174: aload 4
    //   176: invokevirtual 255	java/io/OutputStream:close	()V
    //   179: iconst_m1
    //   180: istore_1
    //   181: invokestatic 261	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   184: ldc_w 263
    //   187: aload 7
    //   189: invokestatic 269	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   192: invokevirtual 273	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokevirtual 277	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   198: invokevirtual 282	java/lang/Process:waitFor	()I
    //   201: ifne +583 -> 784
    //   204: ldc 108
    //   206: ldc_w 284
    //   209: invokestatic 115	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: ldc 199
    //   214: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: iload_1
    //   218: ireturn
    //   219: aload 8
    //   221: getfield 288	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   224: invokestatic 294	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   227: invokestatic 297	com/tencent/mm/vfs/i:aKe	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 9
    //   232: ldc 241
    //   234: astore 5
    //   236: aload_0
    //   237: invokevirtual 213	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   240: ldc 215
    //   242: invokevirtual 221	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   245: astore 4
    //   247: aload 5
    //   249: astore_3
    //   250: aload 4
    //   252: ifnull +22 -> 274
    //   255: aload 4
    //   257: astore_3
    //   258: aload 4
    //   260: astore_2
    //   261: aload 4
    //   263: sipush 1024
    //   266: invokestatic 303	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   269: astore 6
    //   271: aload 6
    //   273: astore_3
    //   274: aload_3
    //   275: astore 6
    //   277: aload 4
    //   279: astore_2
    //   280: aload 4
    //   282: ifnull +14 -> 296
    //   285: aload 4
    //   287: invokevirtual 254	java/io/InputStream:close	()V
    //   290: aload 4
    //   292: astore_2
    //   293: aload_3
    //   294: astore 6
    //   296: aload 9
    //   298: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: ifne +142 -> 443
    //   304: aload 6
    //   306: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifne +134 -> 443
    //   312: aload 9
    //   314: aload 6
    //   316: invokevirtual 313	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifeq +124 -> 443
    //   322: iconst_0
    //   323: istore_1
    //   324: goto -286 -> 38
    //   327: astore_2
    //   328: ldc 108
    //   330: aload_2
    //   331: ldc 241
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload_3
    //   341: astore 6
    //   343: aload 4
    //   345: astore_2
    //   346: goto -50 -> 296
    //   349: astore 4
    //   351: aload_3
    //   352: astore_2
    //   353: ldc 108
    //   355: aload 4
    //   357: ldc 241
    //   359: iconst_0
    //   360: anewarray 4	java/lang/Object
    //   363: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: aload 5
    //   368: astore 6
    //   370: aload_3
    //   371: astore_2
    //   372: aload_3
    //   373: ifnull -77 -> 296
    //   376: aload_3
    //   377: invokevirtual 254	java/io/InputStream:close	()V
    //   380: aload 5
    //   382: astore 6
    //   384: aload_3
    //   385: astore_2
    //   386: goto -90 -> 296
    //   389: astore_2
    //   390: ldc 108
    //   392: aload_2
    //   393: ldc 241
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload 5
    //   404: astore 6
    //   406: aload_3
    //   407: astore_2
    //   408: goto -112 -> 296
    //   411: astore_0
    //   412: aload_2
    //   413: ifnull +7 -> 420
    //   416: aload_2
    //   417: invokevirtual 254	java/io/InputStream:close	()V
    //   420: ldc 199
    //   422: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: aload_0
    //   426: athrow
    //   427: astore_2
    //   428: ldc 108
    //   430: aload_2
    //   431: ldc 241
    //   433: iconst_0
    //   434: anewarray 4	java/lang/Object
    //   437: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   440: goto -20 -> 420
    //   443: aload 9
    //   445: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifne +16 -> 464
    //   451: aload 6
    //   453: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   456: ifeq +8 -> 464
    //   459: iconst_0
    //   460: istore_1
    //   461: goto -423 -> 38
    //   464: iconst_1
    //   465: istore_1
    //   466: goto -428 -> 38
    //   469: aload 4
    //   471: astore_3
    //   472: aload_0
    //   473: astore_2
    //   474: aload 4
    //   476: invokevirtual 316	java/io/OutputStream:flush	()V
    //   479: aload_0
    //   480: ifnull +7 -> 487
    //   483: aload_0
    //   484: invokevirtual 254	java/io/InputStream:close	()V
    //   487: aload 4
    //   489: ifnull +354 -> 843
    //   492: aload 4
    //   494: invokevirtual 255	java/io/OutputStream:close	()V
    //   497: iconst_0
    //   498: istore_1
    //   499: goto -318 -> 181
    //   502: astore_0
    //   503: ldc 108
    //   505: aload_0
    //   506: ldc 241
    //   508: iconst_0
    //   509: anewarray 4	java/lang/Object
    //   512: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: ldc 108
    //   517: new 165	java/lang/StringBuilder
    //   520: dup
    //   521: ldc_w 318
    //   524: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   527: aload_0
    //   528: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   531: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: goto -53 -> 487
    //   543: astore_0
    //   544: ldc 108
    //   546: aload_0
    //   547: ldc 241
    //   549: iconst_0
    //   550: anewarray 4	java/lang/Object
    //   553: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: ldc 108
    //   558: new 165	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 321
    //   565: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload_0
    //   569: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   572: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: iconst_0
    //   582: istore_1
    //   583: goto -402 -> 181
    //   586: astore_0
    //   587: ldc 108
    //   589: aload_0
    //   590: ldc 241
    //   592: iconst_0
    //   593: anewarray 4	java/lang/Object
    //   596: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   599: ldc 108
    //   601: new 165	java/lang/StringBuilder
    //   604: dup
    //   605: ldc_w 318
    //   608: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   611: aload_0
    //   612: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   615: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: goto -455 -> 169
    //   627: astore_0
    //   628: ldc 108
    //   630: aload_0
    //   631: ldc 241
    //   633: iconst_0
    //   634: anewarray 4	java/lang/Object
    //   637: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: ldc 108
    //   642: new 165	java/lang/StringBuilder
    //   645: dup
    //   646: ldc_w 321
    //   649: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   652: aload_0
    //   653: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   656: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: iconst_m1
    //   666: istore_1
    //   667: goto -486 -> 181
    //   670: astore_0
    //   671: aconst_null
    //   672: astore 4
    //   674: aload_3
    //   675: astore_2
    //   676: aload 4
    //   678: astore_3
    //   679: aload_2
    //   680: ifnull +7 -> 687
    //   683: aload_2
    //   684: invokevirtual 254	java/io/InputStream:close	()V
    //   687: aload_3
    //   688: ifnull +7 -> 695
    //   691: aload_3
    //   692: invokevirtual 255	java/io/OutputStream:close	()V
    //   695: ldc 199
    //   697: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   700: aload_0
    //   701: athrow
    //   702: astore_2
    //   703: ldc 108
    //   705: aload_2
    //   706: ldc 241
    //   708: iconst_0
    //   709: anewarray 4	java/lang/Object
    //   712: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   715: ldc 108
    //   717: new 165	java/lang/StringBuilder
    //   720: dup
    //   721: ldc_w 318
    //   724: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   727: aload_2
    //   728: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   731: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: goto -53 -> 687
    //   743: astore_2
    //   744: ldc 108
    //   746: aload_2
    //   747: ldc 241
    //   749: iconst_0
    //   750: anewarray 4	java/lang/Object
    //   753: invokestatic 245	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: ldc 108
    //   758: new 165	java/lang/StringBuilder
    //   761: dup
    //   762: ldc_w 321
    //   765: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   768: aload_2
    //   769: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   772: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: goto -86 -> 695
    //   784: ldc 108
    //   786: ldc_w 323
    //   789: invokestatic 122	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: goto -580 -> 212
    //   795: astore_0
    //   796: ldc 108
    //   798: new 165	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 325
    //   805: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload_0
    //   809: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   812: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 115	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: goto -609 -> 212
    //   824: astore_0
    //   825: goto -146 -> 679
    //   828: astore 5
    //   830: aconst_null
    //   831: astore 4
    //   833: aload_2
    //   834: astore_0
    //   835: goto -722 -> 113
    //   838: iconst_m1
    //   839: istore_1
    //   840: goto -659 -> 181
    //   843: iconst_0
    //   844: istore_1
    //   845: goto -664 -> 181
    //   848: iconst_0
    //   849: istore_1
    //   850: goto -638 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	853	0	paramContext	Context
    //   35	815	1	i	int
    //   6	287	2	localObject1	Object
    //   327	4	2	localIOException1	java.io.IOException
    //   345	41	2	localObject2	Object
    //   389	4	2	localIOException2	java.io.IOException
    //   407	10	2	localObject3	Object
    //   427	4	2	localIOException3	java.io.IOException
    //   473	211	2	localObject4	Object
    //   702	26	2	localIOException4	java.io.IOException
    //   743	91	2	localIOException5	java.io.IOException
    //   8	684	3	localObject5	Object
    //   63	281	4	localObject6	Object
    //   349	144	4	localIOException6	java.io.IOException
    //   672	160	4	localObject7	Object
    //   75	27	5	arrayOfByte	byte[]
    //   111	37	5	localException1	java.lang.Exception
    //   234	169	5	str1	String
    //   828	1	5	localException2	java.lang.Exception
    //   269	183	6	localObject8	Object
    //   13	175	7	str2	String
    //   24	196	8	locale	com.tencent.mm.vfs.e
    //   230	214	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	77	111	java/lang/Exception
    //   82	89	111	java/lang/Exception
    //   99	108	111	java/lang/Exception
    //   474	479	111	java/lang/Exception
    //   285	290	327	java/io/IOException
    //   236	247	349	java/io/IOException
    //   261	271	349	java/io/IOException
    //   376	380	389	java/io/IOException
    //   236	247	411	finally
    //   261	271	411	finally
    //   353	366	411	finally
    //   416	420	427	java/io/IOException
    //   483	487	502	java/io/IOException
    //   492	497	543	java/io/IOException
    //   165	169	586	java/io/IOException
    //   174	179	627	java/io/IOException
    //   44	54	670	finally
    //   58	65	670	finally
    //   683	687	702	java/io/IOException
    //   691	695	743	java/io/IOException
    //   181	212	795	java/lang/Exception
    //   784	792	795	java/lang/Exception
    //   70	77	824	finally
    //   82	89	824	finally
    //   99	108	824	finally
    //   118	131	824	finally
    //   136	161	824	finally
    //   474	479	824	finally
    //   44	54	828	java/lang/Exception
    //   58	65	828	java/lang/Exception
  }
  
  public static String getUserId()
  {
    AppMethodBeat.i(64305);
    String str = com.tencent.mm.wallet_core.ui.e.getUsername();
    str = ah.dg(ah.dg(str) + ah.dg(q.XX()));
    AppMethodBeat.o(64305);
    return str;
  }
  
  public static void mj(boolean paramBoolean)
  {
    AppMethodBeat.i(64310);
    g.agS();
    g.agR().agA().set(ah.a.GFE, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(64310);
  }
  
  public static void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(64312);
    g.agS();
    g.agR().agA().set(ah.a.GFF, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(64312);
  }
  
  public static void ml(boolean paramBoolean)
  {
    skd = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d
 * JD-Core Version:    0.7.0.1
 */