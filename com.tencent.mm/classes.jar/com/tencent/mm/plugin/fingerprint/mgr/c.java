package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.soter.model.j;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.File;

public final class c
{
  private static boolean isSoLoaded = false;
  
  public static String ftF()
  {
    AppMethodBeat.i(64306);
    String str = j.htE();
    AppMethodBeat.o(64306);
    return str;
  }
  
  public static void ftG()
  {
    AppMethodBeat.i(64307);
    h.baF();
    h.baE().ban().set(at.a.acJL, Boolean.TRUE);
    AppMethodBeat.o(64307);
  }
  
  public static boolean ftH()
  {
    AppMethodBeat.i(64308);
    h.baF();
    Object localObject = h.baE().ban().get(at.a.acJL, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64308);
      return bool;
    }
  }
  
  public static void ftI()
  {
    AppMethodBeat.i(64309);
    h.baF();
    h.baE().ban().set(at.a.acJM, Boolean.TRUE);
    AppMethodBeat.o(64309);
  }
  
  public static boolean ftJ()
  {
    AppMethodBeat.i(64311);
    h.baF();
    Object localObject = h.baE().ban().get(at.a.acJO, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64311);
      return bool;
    }
  }
  
  public static boolean ftK()
  {
    AppMethodBeat.i(64313);
    h.baF();
    Object localObject = h.baE().ban().get(at.a.acJP, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64313);
      return bool;
    }
  }
  
  public static boolean ftL()
  {
    return isSoLoaded;
  }
  
  public static boolean ftM()
  {
    AppMethodBeat.i(64315);
    Log.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
    if (ftJ())
    {
      Log.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
      AppMethodBeat.o(64315);
      return false;
    }
    Object localObject = (com.tencent.mm.plugin.fingerprint.mgr.a.i)h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class);
    if ((((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject).ftV() == 1) && (((com.tencent.mm.plugin.fingerprint.mgr.a.i)localObject).ftR()))
    {
      Log.e("MicroMsg.FingerPrintUtil", "device is not support");
      AppMethodBeat.o(64315);
      return false;
    }
    if ((u.iiC().ijh()) || (u.iiC().ijg()))
    {
      Log.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
      AppMethodBeat.o(64315);
      return false;
    }
    if (!u.iiC().ijp().iiU())
    {
      Log.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
      AppMethodBeat.o(64315);
      return false;
    }
    if (!((com.tencent.mm.plugin.fingerprint.mgr.a.i)h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class)).ftS())
    {
      h.baF();
      localObject = h.baE().ban().get(at.a.acJM, Boolean.FALSE);
      if (localObject == null) {
        break label205;
      }
    }
    label205:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (!bool)
      {
        Log.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
        AppMethodBeat.o(64315);
        return true;
      }
      AppMethodBeat.o(64315);
      return false;
    }
  }
  
  public static boolean ftz()
  {
    AppMethodBeat.i(64314);
    boolean bool = ((com.tencent.mm.plugin.fingerprint.mgr.a.i)h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class)).ftR();
    AppMethodBeat.o(64314);
    return bool;
  }
  
  public static String getUserId()
  {
    AppMethodBeat.i(64305);
    String str = com.tencent.mm.wallet_core.ui.i.getUsername();
    str = MD5Util.getMD5String(MD5Util.getMD5String(str) + MD5Util.getMD5String(q.aPg()));
    AppMethodBeat.o(64305);
    return str;
  }
  
  public static final String hA(Context paramContext)
  {
    AppMethodBeat.i(64316);
    paramContext = paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    AppMethodBeat.o(64316);
    return paramContext;
  }
  
  /* Error */
  public static int hB(Context paramContext)
  {
    // Byte code:
    //   0: ldc 217
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: invokestatic 219	com/tencent/mm/plugin/fingerprint/mgr/c:hA	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 7
    //   15: new 221	com/tencent/mm/vfs/u
    //   18: dup
    //   19: aload 7
    //   21: invokespecial 224	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 227	com/tencent/mm/vfs/u:jKS	()Z
    //   31: ifne +190 -> 221
    //   34: iconst_1
    //   35: istore_1
    //   36: aconst_null
    //   37: astore_2
    //   38: iload_1
    //   39: ifeq +822 -> 861
    //   42: aload_2
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 231	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc 233
    //   50: invokevirtual 239	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_0
    //   54: aload_0
    //   55: astore_3
    //   56: aload_0
    //   57: astore_2
    //   58: aload 8
    //   60: invokestatic 245	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
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
    //   85: invokevirtual 251	java/io/InputStream:read	([B)I
    //   88: istore_1
    //   89: iload_1
    //   90: iconst_m1
    //   91: if_icmpeq +385 -> 476
    //   94: aload 4
    //   96: astore_3
    //   97: aload_0
    //   98: astore_2
    //   99: aload 4
    //   101: aload 5
    //   103: iconst_0
    //   104: iload_1
    //   105: invokevirtual 257	java/io/OutputStream:write	([BII)V
    //   108: goto -31 -> 77
    //   111: astore 5
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: astore_2
    //   118: ldc 97
    //   120: aload 5
    //   122: ldc_w 259
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 4
    //   134: astore_3
    //   135: aload_0
    //   136: astore_2
    //   137: ldc 97
    //   139: new 169	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 265
    //   146: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload 5
    //   151: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 272	java/io/InputStream:close	()V
    //   171: aload 4
    //   173: ifnull +678 -> 851
    //   176: aload 4
    //   178: invokevirtual 273	java/io/OutputStream:close	()V
    //   181: iconst_m1
    //   182: istore_1
    //   183: invokestatic 279	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   186: ldc_w 281
    //   189: aload 7
    //   191: invokestatic 287	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokevirtual 294	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   200: invokevirtual 299	java/lang/Process:waitFor	()I
    //   203: ifne +594 -> 797
    //   206: ldc 97
    //   208: ldc_w 301
    //   211: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: ldc 217
    //   216: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: iload_1
    //   220: ireturn
    //   221: aload 8
    //   223: getfield 305	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   226: invokestatic 311	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   229: invokestatic 314	com/tencent/mm/vfs/y:bub	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 9
    //   234: ldc_w 259
    //   237: astore 5
    //   239: aload_0
    //   240: invokevirtual 231	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   243: ldc 233
    //   245: invokevirtual 239	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   248: astore 4
    //   250: aload 5
    //   252: astore_3
    //   253: aload 4
    //   255: ifnull +22 -> 277
    //   258: aload 4
    //   260: astore_3
    //   261: aload 4
    //   263: astore_2
    //   264: aload 4
    //   266: sipush 1024
    //   269: invokestatic 319	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   272: astore 6
    //   274: aload 6
    //   276: astore_3
    //   277: aload_3
    //   278: astore 6
    //   280: aload 4
    //   282: astore_2
    //   283: aload 4
    //   285: ifnull +14 -> 299
    //   288: aload 4
    //   290: invokevirtual 272	java/io/InputStream:close	()V
    //   293: aload 4
    //   295: astore_2
    //   296: aload_3
    //   297: astore 6
    //   299: aload 9
    //   301: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   304: ifne +146 -> 450
    //   307: aload 6
    //   309: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   312: ifne +138 -> 450
    //   315: aload 9
    //   317: aload 6
    //   319: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +128 -> 450
    //   325: iconst_0
    //   326: istore_1
    //   327: goto -289 -> 38
    //   330: astore_2
    //   331: ldc 97
    //   333: aload_2
    //   334: ldc_w 259
    //   337: iconst_0
    //   338: anewarray 4	java/lang/Object
    //   341: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: aload_3
    //   345: astore 6
    //   347: aload 4
    //   349: astore_2
    //   350: goto -51 -> 299
    //   353: astore 4
    //   355: aload_3
    //   356: astore_2
    //   357: ldc 97
    //   359: aload 4
    //   361: ldc_w 259
    //   364: iconst_0
    //   365: anewarray 4	java/lang/Object
    //   368: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload 5
    //   373: astore 6
    //   375: aload_3
    //   376: astore_2
    //   377: aload_3
    //   378: ifnull -79 -> 299
    //   381: aload_3
    //   382: invokevirtual 272	java/io/InputStream:close	()V
    //   385: aload 5
    //   387: astore 6
    //   389: aload_3
    //   390: astore_2
    //   391: goto -92 -> 299
    //   394: astore_2
    //   395: ldc 97
    //   397: aload_2
    //   398: ldc_w 259
    //   401: iconst_0
    //   402: anewarray 4	java/lang/Object
    //   405: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aload 5
    //   410: astore 6
    //   412: aload_3
    //   413: astore_2
    //   414: goto -115 -> 299
    //   417: astore_0
    //   418: aload_2
    //   419: ifnull +7 -> 426
    //   422: aload_2
    //   423: invokevirtual 272	java/io/InputStream:close	()V
    //   426: ldc 217
    //   428: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: aload_0
    //   432: athrow
    //   433: astore_2
    //   434: ldc 97
    //   436: aload_2
    //   437: ldc_w 259
    //   440: iconst_0
    //   441: anewarray 4	java/lang/Object
    //   444: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: goto -21 -> 426
    //   450: aload 9
    //   452: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   455: ifne +16 -> 471
    //   458: aload 6
    //   460: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   463: ifeq +8 -> 471
    //   466: iconst_0
    //   467: istore_1
    //   468: goto -430 -> 38
    //   471: iconst_1
    //   472: istore_1
    //   473: goto -435 -> 38
    //   476: aload 4
    //   478: astore_3
    //   479: aload_0
    //   480: astore_2
    //   481: aload 4
    //   483: invokevirtual 332	java/io/OutputStream:flush	()V
    //   486: aload_0
    //   487: ifnull +7 -> 494
    //   490: aload_0
    //   491: invokevirtual 272	java/io/InputStream:close	()V
    //   494: aload 4
    //   496: ifnull +360 -> 856
    //   499: aload 4
    //   501: invokevirtual 273	java/io/OutputStream:close	()V
    //   504: iconst_0
    //   505: istore_1
    //   506: goto -323 -> 183
    //   509: astore_0
    //   510: ldc 97
    //   512: aload_0
    //   513: ldc_w 259
    //   516: iconst_0
    //   517: anewarray 4	java/lang/Object
    //   520: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   523: ldc 97
    //   525: new 169	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 334
    //   532: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: aload_0
    //   536: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   539: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: goto -54 -> 494
    //   551: astore_0
    //   552: ldc 97
    //   554: aload_0
    //   555: ldc_w 259
    //   558: iconst_0
    //   559: anewarray 4	java/lang/Object
    //   562: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: ldc 97
    //   567: new 169	java/lang/StringBuilder
    //   570: dup
    //   571: ldc_w 337
    //   574: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   577: aload_0
    //   578: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   581: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: iconst_0
    //   591: istore_1
    //   592: goto -409 -> 183
    //   595: astore_0
    //   596: ldc 97
    //   598: aload_0
    //   599: ldc_w 259
    //   602: iconst_0
    //   603: anewarray 4	java/lang/Object
    //   606: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   609: ldc 97
    //   611: new 169	java/lang/StringBuilder
    //   614: dup
    //   615: ldc_w 334
    //   618: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   621: aload_0
    //   622: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   625: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: goto -463 -> 171
    //   637: astore_0
    //   638: ldc 97
    //   640: aload_0
    //   641: ldc_w 259
    //   644: iconst_0
    //   645: anewarray 4	java/lang/Object
    //   648: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   651: ldc 97
    //   653: new 169	java/lang/StringBuilder
    //   656: dup
    //   657: ldc_w 337
    //   660: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   663: aload_0
    //   664: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   667: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: iconst_m1
    //   677: istore_1
    //   678: goto -495 -> 183
    //   681: astore_0
    //   682: aconst_null
    //   683: astore 4
    //   685: aload_3
    //   686: astore_2
    //   687: aload 4
    //   689: astore_3
    //   690: aload_2
    //   691: ifnull +7 -> 698
    //   694: aload_2
    //   695: invokevirtual 272	java/io/InputStream:close	()V
    //   698: aload_3
    //   699: ifnull +7 -> 706
    //   702: aload_3
    //   703: invokevirtual 273	java/io/OutputStream:close	()V
    //   706: ldc 217
    //   708: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: aload_0
    //   712: athrow
    //   713: astore_2
    //   714: ldc 97
    //   716: aload_2
    //   717: ldc_w 259
    //   720: iconst_0
    //   721: anewarray 4	java/lang/Object
    //   724: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   727: ldc 97
    //   729: new 169	java/lang/StringBuilder
    //   732: dup
    //   733: ldc_w 334
    //   736: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   739: aload_2
    //   740: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   743: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: goto -54 -> 698
    //   755: astore_2
    //   756: ldc 97
    //   758: aload_2
    //   759: ldc_w 259
    //   762: iconst_0
    //   763: anewarray 4	java/lang/Object
    //   766: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   769: ldc 97
    //   771: new 169	java/lang/StringBuilder
    //   774: dup
    //   775: ldc_w 337
    //   778: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   781: aload_2
    //   782: invokevirtual 335	java/io/IOException:getMessage	()Ljava/lang/String;
    //   785: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: goto -88 -> 706
    //   797: ldc 97
    //   799: ldc_w 339
    //   802: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: goto -591 -> 214
    //   808: astore_0
    //   809: ldc 97
    //   811: new 169	java/lang/StringBuilder
    //   814: dup
    //   815: ldc_w 341
    //   818: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   821: aload_0
    //   822: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   825: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: goto -620 -> 214
    //   837: astore_0
    //   838: goto -148 -> 690
    //   841: astore 5
    //   843: aconst_null
    //   844: astore 4
    //   846: aload_2
    //   847: astore_0
    //   848: goto -735 -> 113
    //   851: iconst_m1
    //   852: istore_1
    //   853: goto -670 -> 183
    //   856: iconst_0
    //   857: istore_1
    //   858: goto -675 -> 183
    //   861: iconst_0
    //   862: istore_1
    //   863: goto -649 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	paramContext	Context
    //   35	828	1	i	int
    //   6	290	2	localObject1	Object
    //   330	4	2	localIOException1	java.io.IOException
    //   349	42	2	localObject2	Object
    //   394	4	2	localIOException2	java.io.IOException
    //   413	10	2	localObject3	Object
    //   433	4	2	localIOException3	java.io.IOException
    //   480	215	2	localObject4	Object
    //   713	27	2	localIOException4	java.io.IOException
    //   755	92	2	localIOException5	java.io.IOException
    //   8	695	3	localObject5	Object
    //   63	285	4	localObject6	Object
    //   353	147	4	localIOException6	java.io.IOException
    //   683	162	4	localObject7	Object
    //   75	27	5	arrayOfByte	byte[]
    //   111	39	5	localException1	java.lang.Exception
    //   237	172	5	str1	String
    //   841	1	5	localException2	java.lang.Exception
    //   272	187	6	localObject8	Object
    //   13	177	7	str2	String
    //   24	198	8	localu	com.tencent.mm.vfs.u
    //   232	219	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	77	111	java/lang/Exception
    //   82	89	111	java/lang/Exception
    //   99	108	111	java/lang/Exception
    //   481	486	111	java/lang/Exception
    //   288	293	330	java/io/IOException
    //   239	250	353	java/io/IOException
    //   264	274	353	java/io/IOException
    //   381	385	394	java/io/IOException
    //   239	250	417	finally
    //   264	274	417	finally
    //   357	371	417	finally
    //   422	426	433	java/io/IOException
    //   490	494	509	java/io/IOException
    //   499	504	551	java/io/IOException
    //   167	171	595	java/io/IOException
    //   176	181	637	java/io/IOException
    //   44	54	681	finally
    //   58	65	681	finally
    //   694	698	713	java/io/IOException
    //   702	706	755	java/io/IOException
    //   183	214	808	java/lang/Exception
    //   797	805	808	java/lang/Exception
    //   70	77	837	finally
    //   82	89	837	finally
    //   99	108	837	finally
    //   118	132	837	finally
    //   137	163	837	finally
    //   481	486	837	finally
    //   44	54	841	java/lang/Exception
    //   58	65	841	java/lang/Exception
  }
  
  public static void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(64310);
    h.baF();
    h.baE().ban().set(at.a.acJO, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(64310);
  }
  
  public static void vx(boolean paramBoolean)
  {
    AppMethodBeat.i(64312);
    h.baF();
    h.baE().ban().set(at.a.acJP, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(64312);
  }
  
  public static void vy(boolean paramBoolean)
  {
    isSoLoaded = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.c
 * JD-Core Version:    0.7.0.1
 */