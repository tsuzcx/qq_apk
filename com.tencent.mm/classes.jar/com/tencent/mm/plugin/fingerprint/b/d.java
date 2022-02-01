package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.g;
import java.io.File;

public final class d
{
  private static boolean Byc = false;
  
  public static String eoC()
  {
    AppMethodBeat.i(64306);
    String str = m.gan();
    AppMethodBeat.o(64306);
    return str;
  }
  
  public static void eoD()
  {
    AppMethodBeat.i(64307);
    h.aHH();
    h.aHG().aHp().set(ar.a.Vir, Boolean.TRUE);
    AppMethodBeat.o(64307);
  }
  
  public static boolean eoE()
  {
    AppMethodBeat.i(64308);
    h.aHH();
    Object localObject = h.aHG().aHp().get(ar.a.Vir, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64308);
      return bool;
    }
  }
  
  public static void eoF()
  {
    AppMethodBeat.i(64309);
    h.aHH();
    h.aHG().aHp().set(ar.a.Vis, Boolean.TRUE);
    AppMethodBeat.o(64309);
  }
  
  public static boolean eoG()
  {
    AppMethodBeat.i(64311);
    h.aHH();
    Object localObject = h.aHG().aHp().get(ar.a.Viu, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64311);
      return bool;
    }
  }
  
  public static boolean eoH()
  {
    AppMethodBeat.i(64313);
    h.aHH();
    Object localObject = h.aHG().aHp().get(ar.a.Viv, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(64313);
      return bool;
    }
  }
  
  public static boolean eoI()
  {
    return Byc;
  }
  
  public static boolean eoJ()
  {
    AppMethodBeat.i(64315);
    Log.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
    if (eoG())
    {
      Log.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
      AppMethodBeat.o(64315);
      return false;
    }
    Object localObject = (i)h.ae(i.class);
    if ((((i)localObject).eoT() == 1) && (((i)localObject).eoP()))
    {
      Log.e("MicroMsg.FingerPrintUtil", "device is not support");
      AppMethodBeat.o(64315);
      return false;
    }
    if ((u.gJo().gJS()) || (u.gJo().gJR()))
    {
      Log.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
      AppMethodBeat.o(64315);
      return false;
    }
    if (!u.gJo().gJY().gJG())
    {
      Log.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
      AppMethodBeat.o(64315);
      return false;
    }
    if (!((i)h.ae(i.class)).eoQ())
    {
      h.aHH();
      localObject = h.aHG().aHp().get(ar.a.Vis, Boolean.FALSE);
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
  
  public static boolean eow()
  {
    AppMethodBeat.i(64314);
    boolean bool = ((i)h.ae(i.class)).eoP();
    AppMethodBeat.o(64314);
    return bool;
  }
  
  public static String getUserId()
  {
    AppMethodBeat.i(64305);
    String str = g.getUsername();
    str = MD5Util.getMD5String(MD5Util.getMD5String(str) + MD5Util.getMD5String(q.auM()));
    AppMethodBeat.o(64305);
    return str;
  }
  
  public static final String gf(Context paramContext)
  {
    AppMethodBeat.i(64316);
    paramContext = paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    AppMethodBeat.o(64316);
    return paramContext;
  }
  
  /* Error */
  public static int gg(Context paramContext)
  {
    // Byte code:
    //   0: ldc 217
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: invokestatic 219	com/tencent/mm/plugin/fingerprint/b/d:gf	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 7
    //   15: new 221	com/tencent/mm/vfs/q
    //   18: dup
    //   19: aload 7
    //   21: invokespecial 224	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 227	com/tencent/mm/vfs/q:ifE	()Z
    //   31: ifne +190 -> 221
    //   34: iconst_1
    //   35: istore_1
    //   36: aconst_null
    //   37: astore_2
    //   38: iload_1
    //   39: ifeq +819 -> 858
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
    //   60: invokestatic 245	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
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
    //   91: if_icmpeq +382 -> 473
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
    //   173: ifnull +675 -> 848
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
    //   203: ifne +591 -> 794
    //   206: ldc 97
    //   208: ldc_w 301
    //   211: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: ldc 217
    //   216: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: iload_1
    //   220: ireturn
    //   221: aload 8
    //   223: invokevirtual 304	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   226: invokestatic 307	com/tencent/mm/vfs/u:buc	(Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 9
    //   231: ldc_w 259
    //   234: astore 5
    //   236: aload_0
    //   237: invokevirtual 231	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   240: ldc 233
    //   242: invokevirtual 239	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   266: invokestatic 313	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
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
    //   287: invokevirtual 272	java/io/InputStream:close	()V
    //   290: aload 4
    //   292: astore_2
    //   293: aload_3
    //   294: astore 6
    //   296: aload 9
    //   298: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: ifne +146 -> 447
    //   304: aload 6
    //   306: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifne +138 -> 447
    //   312: aload 9
    //   314: aload 6
    //   316: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   319: ifeq +128 -> 447
    //   322: iconst_0
    //   323: istore_1
    //   324: goto -286 -> 38
    //   327: astore_2
    //   328: ldc 97
    //   330: aload_2
    //   331: ldc_w 259
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: aload_3
    //   342: astore 6
    //   344: aload 4
    //   346: astore_2
    //   347: goto -51 -> 296
    //   350: astore 4
    //   352: aload_3
    //   353: astore_2
    //   354: ldc 97
    //   356: aload 4
    //   358: ldc_w 259
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload 5
    //   370: astore 6
    //   372: aload_3
    //   373: astore_2
    //   374: aload_3
    //   375: ifnull -79 -> 296
    //   378: aload_3
    //   379: invokevirtual 272	java/io/InputStream:close	()V
    //   382: aload 5
    //   384: astore 6
    //   386: aload_3
    //   387: astore_2
    //   388: goto -92 -> 296
    //   391: astore_2
    //   392: ldc 97
    //   394: aload_2
    //   395: ldc_w 259
    //   398: iconst_0
    //   399: anewarray 4	java/lang/Object
    //   402: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: aload 5
    //   407: astore 6
    //   409: aload_3
    //   410: astore_2
    //   411: goto -115 -> 296
    //   414: astore_0
    //   415: aload_2
    //   416: ifnull +7 -> 423
    //   419: aload_2
    //   420: invokevirtual 272	java/io/InputStream:close	()V
    //   423: ldc 217
    //   425: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   428: aload_0
    //   429: athrow
    //   430: astore_2
    //   431: ldc 97
    //   433: aload_2
    //   434: ldc_w 259
    //   437: iconst_0
    //   438: anewarray 4	java/lang/Object
    //   441: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: goto -21 -> 423
    //   447: aload 9
    //   449: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   452: ifne +16 -> 468
    //   455: aload 6
    //   457: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifeq +8 -> 468
    //   463: iconst_0
    //   464: istore_1
    //   465: goto -427 -> 38
    //   468: iconst_1
    //   469: istore_1
    //   470: goto -432 -> 38
    //   473: aload 4
    //   475: astore_3
    //   476: aload_0
    //   477: astore_2
    //   478: aload 4
    //   480: invokevirtual 326	java/io/OutputStream:flush	()V
    //   483: aload_0
    //   484: ifnull +7 -> 491
    //   487: aload_0
    //   488: invokevirtual 272	java/io/InputStream:close	()V
    //   491: aload 4
    //   493: ifnull +360 -> 853
    //   496: aload 4
    //   498: invokevirtual 273	java/io/OutputStream:close	()V
    //   501: iconst_0
    //   502: istore_1
    //   503: goto -320 -> 183
    //   506: astore_0
    //   507: ldc 97
    //   509: aload_0
    //   510: ldc_w 259
    //   513: iconst_0
    //   514: anewarray 4	java/lang/Object
    //   517: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: ldc 97
    //   522: new 169	java/lang/StringBuilder
    //   525: dup
    //   526: ldc_w 328
    //   529: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload_0
    //   533: invokevirtual 329	java/io/IOException:getMessage	()Ljava/lang/String;
    //   536: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: goto -54 -> 491
    //   548: astore_0
    //   549: ldc 97
    //   551: aload_0
    //   552: ldc_w 259
    //   555: iconst_0
    //   556: anewarray 4	java/lang/Object
    //   559: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   562: ldc 97
    //   564: new 169	java/lang/StringBuilder
    //   567: dup
    //   568: ldc_w 331
    //   571: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: aload_0
    //   575: invokevirtual 329	java/io/IOException:getMessage	()Ljava/lang/String;
    //   578: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: iconst_0
    //   588: istore_1
    //   589: goto -406 -> 183
    //   592: astore_0
    //   593: ldc 97
    //   595: aload_0
    //   596: ldc_w 259
    //   599: iconst_0
    //   600: anewarray 4	java/lang/Object
    //   603: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   606: ldc 97
    //   608: new 169	java/lang/StringBuilder
    //   611: dup
    //   612: ldc_w 328
    //   615: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   618: aload_0
    //   619: invokevirtual 329	java/io/IOException:getMessage	()Ljava/lang/String;
    //   622: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: goto -460 -> 171
    //   634: astore_0
    //   635: ldc 97
    //   637: aload_0
    //   638: ldc_w 259
    //   641: iconst_0
    //   642: anewarray 4	java/lang/Object
    //   645: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: ldc 97
    //   650: new 169	java/lang/StringBuilder
    //   653: dup
    //   654: ldc_w 331
    //   657: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: aload_0
    //   661: invokevirtual 329	java/io/IOException:getMessage	()Ljava/lang/String;
    //   664: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: iconst_m1
    //   674: istore_1
    //   675: goto -492 -> 183
    //   678: astore_0
    //   679: aconst_null
    //   680: astore 4
    //   682: aload_3
    //   683: astore_2
    //   684: aload 4
    //   686: astore_3
    //   687: aload_2
    //   688: ifnull +7 -> 695
    //   691: aload_2
    //   692: invokevirtual 272	java/io/InputStream:close	()V
    //   695: aload_3
    //   696: ifnull +7 -> 703
    //   699: aload_3
    //   700: invokevirtual 273	java/io/OutputStream:close	()V
    //   703: ldc 217
    //   705: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   708: aload_0
    //   709: athrow
    //   710: astore_2
    //   711: ldc 97
    //   713: aload_2
    //   714: ldc_w 259
    //   717: iconst_0
    //   718: anewarray 4	java/lang/Object
    //   721: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   724: ldc 97
    //   726: new 169	java/lang/StringBuilder
    //   729: dup
    //   730: ldc_w 328
    //   733: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   736: aload_2
    //   737: invokevirtual 329	java/io/IOException:getMessage	()Ljava/lang/String;
    //   740: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: goto -54 -> 695
    //   752: astore_2
    //   753: ldc 97
    //   755: aload_2
    //   756: ldc_w 259
    //   759: iconst_0
    //   760: anewarray 4	java/lang/Object
    //   763: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: ldc 97
    //   768: new 169	java/lang/StringBuilder
    //   771: dup
    //   772: ldc_w 331
    //   775: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   778: aload_2
    //   779: invokevirtual 329	java/io/IOException:getMessage	()Ljava/lang/String;
    //   782: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: goto -88 -> 703
    //   794: ldc 97
    //   796: ldc_w 333
    //   799: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: goto -588 -> 214
    //   805: astore_0
    //   806: ldc 97
    //   808: new 169	java/lang/StringBuilder
    //   811: dup
    //   812: ldc_w 335
    //   815: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   818: aload_0
    //   819: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   822: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: goto -617 -> 214
    //   834: astore_0
    //   835: goto -148 -> 687
    //   838: astore 5
    //   840: aconst_null
    //   841: astore 4
    //   843: aload_2
    //   844: astore_0
    //   845: goto -732 -> 113
    //   848: iconst_m1
    //   849: istore_1
    //   850: goto -667 -> 183
    //   853: iconst_0
    //   854: istore_1
    //   855: goto -672 -> 183
    //   858: iconst_0
    //   859: istore_1
    //   860: goto -646 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	paramContext	Context
    //   35	825	1	i	int
    //   6	287	2	localObject1	Object
    //   327	4	2	localIOException1	java.io.IOException
    //   346	42	2	localObject2	Object
    //   391	4	2	localIOException2	java.io.IOException
    //   410	10	2	localObject3	Object
    //   430	4	2	localIOException3	java.io.IOException
    //   477	215	2	localObject4	Object
    //   710	27	2	localIOException4	java.io.IOException
    //   752	92	2	localIOException5	java.io.IOException
    //   8	692	3	localObject5	Object
    //   63	282	4	localObject6	Object
    //   350	147	4	localIOException6	java.io.IOException
    //   680	162	4	localObject7	Object
    //   75	27	5	arrayOfByte	byte[]
    //   111	39	5	localException1	java.lang.Exception
    //   234	172	5	str1	String
    //   838	1	5	localException2	java.lang.Exception
    //   269	187	6	localObject8	Object
    //   13	177	7	str2	String
    //   24	198	8	localq	com.tencent.mm.vfs.q
    //   229	219	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   70	77	111	java/lang/Exception
    //   82	89	111	java/lang/Exception
    //   99	108	111	java/lang/Exception
    //   478	483	111	java/lang/Exception
    //   285	290	327	java/io/IOException
    //   236	247	350	java/io/IOException
    //   261	271	350	java/io/IOException
    //   378	382	391	java/io/IOException
    //   236	247	414	finally
    //   261	271	414	finally
    //   354	368	414	finally
    //   419	423	430	java/io/IOException
    //   487	491	506	java/io/IOException
    //   496	501	548	java/io/IOException
    //   167	171	592	java/io/IOException
    //   176	181	634	java/io/IOException
    //   44	54	678	finally
    //   58	65	678	finally
    //   691	695	710	java/io/IOException
    //   699	703	752	java/io/IOException
    //   183	214	805	java/lang/Exception
    //   794	802	805	java/lang/Exception
    //   70	77	834	finally
    //   82	89	834	finally
    //   99	108	834	finally
    //   118	132	834	finally
    //   137	163	834	finally
    //   478	483	834	finally
    //   44	54	838	java/lang/Exception
    //   58	65	838	java/lang/Exception
  }
  
  public static void rF(boolean paramBoolean)
  {
    AppMethodBeat.i(64310);
    h.aHH();
    h.aHG().aHp().set(ar.a.Viu, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(64310);
  }
  
  public static void rG(boolean paramBoolean)
  {
    AppMethodBeat.i(64312);
    h.aHH();
    h.aHG().aHp().set(ar.a.Viv, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(64312);
  }
  
  public static void rH(boolean paramBoolean)
  {
    Byc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d
 * JD-Core Version:    0.7.0.1
 */