package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.ao;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.c
{
  public static final String PROCESS_NAME;
  private static final String TAG;
  private static Locale locale;
  private int hiY;
  
  static
  {
    AppMethodBeat.i(19501);
    PROCESS_NAME = MMApplicationContext.getProcessName();
    TAG = "MicroMsg." + com.tencent.mm.xwebutil.c.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.hiY = 0;
    AppMethodBeat.o(19498);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19500);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    Log.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      Log.w(TAG, "language changed, restart process");
      paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramConfiguration.aYi(), "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramConfiguration.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    AppMethodBeat.o(19500);
  }
  
  /* Error */
  public final void onCreate()
  {
    // Byte code:
    //   0: sipush 19499
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   9: lstore_2
    //   10: ldc 2
    //   12: invokevirtual 170	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   15: pop
    //   16: new 6	com/tencent/mm/app/ToolsProfile$1
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 173	com/tencent/mm/app/ToolsProfile$1:<init>	(Lcom/tencent/mm/app/ToolsProfile;)V
    //   24: invokestatic 179	com/tencent/mm/app/w:addOnUncaughtExceptionListener	(Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler$IOnUncaughtExceptionListener;)V
    //   27: ldc 181
    //   29: getstatic 33	com/tencent/mm/app/ToolsProfile:PROCESS_NAME	Ljava/lang/String;
    //   32: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iconst_0
    //   36: getstatic 33	com/tencent/mm/app/ToolsProfile:PROCESS_NAME	Ljava/lang/String;
    //   39: invokestatic 187	com/tencent/mm/app/w:f	(ZLjava/lang/String;)Z
    //   42: pop
    //   43: new 189	com/tencent/mars/mm/AppCallBack
    //   46: dup
    //   47: invokestatic 192	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   50: invokespecial 195	com/tencent/mars/mm/AppCallBack:<init>	(Landroid/content/Context;)V
    //   53: invokestatic 201	com/tencent/mars/app/AppLogic:setCallBack	(Lcom/tencent/mars/app/AppLogic$ICallBack;)V
    //   56: new 203	com/tencent/mm/booter/w
    //   59: dup
    //   60: aload_0
    //   61: getfield 76	com/tencent/mm/app/ToolsProfile:app	Landroid/app/Application;
    //   64: invokevirtual 82	android/app/Application:getBaseContext	()Landroid/content/Context;
    //   67: invokestatic 209	com/tencent/mm/booter/d:cO	(Landroid/content/Context;)Lcom/tencent/mm/booter/d;
    //   70: invokespecial 212	com/tencent/mm/booter/w:<init>	(Lcom/tencent/mm/booter/d;)V
    //   73: astore 8
    //   75: aload 8
    //   77: ldc 214
    //   79: invokevirtual 217	com/tencent/mm/booter/w:Ci	(Ljava/lang/String;)V
    //   82: aload 8
    //   84: ldc 219
    //   86: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   89: iconst_0
    //   90: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   93: putstatic 235	com/tencent/mm/platformtools/z:pBz	Z
    //   96: aload 8
    //   98: ldc 237
    //   100: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   103: iconst_0
    //   104: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   107: putstatic 240	com/tencent/mm/platformtools/z:pBA	Z
    //   110: aload 8
    //   112: ldc 242
    //   114: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   117: iconst_0
    //   118: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   121: putstatic 245	com/tencent/mm/platformtools/z:pBB	Z
    //   124: aload 8
    //   126: ldc 247
    //   128: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   131: iconst_0
    //   132: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   135: putstatic 250	com/tencent/mm/platformtools/z:pBC	Z
    //   138: aload 8
    //   140: ldc 252
    //   142: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   145: iconst_0
    //   146: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   149: putstatic 255	com/tencent/mm/platformtools/z:pBD	Z
    //   152: aload 8
    //   154: ldc_w 257
    //   157: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   160: iconst_0
    //   161: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   164: putstatic 260	com/tencent/mm/platformtools/z:pBE	Z
    //   167: aload 8
    //   169: ldc_w 262
    //   172: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   175: iconst_0
    //   176: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   179: putstatic 265	com/tencent/mm/platformtools/z:pBI	Z
    //   182: aload 8
    //   184: ldc_w 267
    //   187: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   190: iconst_0
    //   191: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   194: putstatic 270	com/tencent/mm/platformtools/z:pBJ	Z
    //   197: aload 8
    //   199: ldc_w 272
    //   202: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   205: iconst_0
    //   206: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   209: putstatic 275	com/tencent/mm/platformtools/z:pBM	Z
    //   212: aload 8
    //   214: ldc_w 277
    //   217: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   220: iconst_0
    //   221: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   224: putstatic 280	com/tencent/mm/platformtools/z:pBN	Z
    //   227: aload 8
    //   229: ldc_w 282
    //   232: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   235: iconst_0
    //   236: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   239: putstatic 285	com/tencent/mm/platformtools/z:pBO	Z
    //   242: aload 8
    //   244: ldc_w 287
    //   247: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   250: iconst_0
    //   251: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   254: putstatic 290	com/tencent/mm/platformtools/z:pBP	Z
    //   257: aload 8
    //   259: ldc_w 292
    //   262: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   265: iconst_0
    //   266: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   269: putstatic 295	com/tencent/mm/platformtools/z:pBS	Z
    //   272: aload 8
    //   274: ldc_w 297
    //   277: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   280: iconst_0
    //   281: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   284: putstatic 300	com/tencent/mm/platformtools/z:pBT	Z
    //   287: aload 8
    //   289: ldc_w 302
    //   292: invokevirtual 306	com/tencent/mm/booter/w:Cj	(Ljava/lang/String;)Ljava/lang/Integer;
    //   295: iconst_0
    //   296: invokestatic 309	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   299: istore_1
    //   300: iload_1
    //   301: putstatic 312	com/tencent/mm/platformtools/z:pBQ	I
    //   304: iload_1
    //   305: iconst_4
    //   306: if_icmpeq +40 -> 346
    //   309: getstatic 312	com/tencent/mm/platformtools/z:pBQ	I
    //   312: ifle +34 -> 346
    //   315: getstatic 312	com/tencent/mm/platformtools/z:pBQ	I
    //   318: putstatic 317	com/tencent/mm/storage/as:acHo	I
    //   321: ldc_w 319
    //   324: new 35	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 321
    //   331: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: getstatic 312	com/tencent/mm/platformtools/z:pBQ	I
    //   337: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload 8
    //   348: ldc_w 329
    //   351: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   354: iconst_0
    //   355: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   358: putstatic 332	com/tencent/mm/platformtools/z:pBR	Z
    //   361: aload 8
    //   363: ldc_w 334
    //   366: invokevirtual 338	com/tencent/mm/booter/w:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: invokestatic 341	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   372: invokevirtual 150	java/lang/Integer:intValue	()I
    //   375: istore_1
    //   376: iload_1
    //   377: invokestatic 346	com/tencent/mm/protocal/d:axo	(I)V
    //   380: new 35	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 348
    //   387: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: iload_1
    //   391: invokestatic 352	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   394: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 8
    //   400: ldc_w 354
    //   403: invokevirtual 338	com/tencent/mm/booter/w:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   406: astore 9
    //   408: aload 9
    //   410: invokestatic 358	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   413: ifne +73 -> 486
    //   416: ldc_w 360
    //   419: aload 9
    //   421: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   424: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   427: putstatic 372	com/tencent/mm/protocal/d:nsC	Ljava/lang/String;
    //   430: ldc_w 360
    //   433: aload 9
    //   435: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   438: invokevirtual 369	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   441: putstatic 375	com/tencent/mm/protocal/d:Yxc	Ljava/lang/String;
    //   444: aload 9
    //   446: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   449: putstatic 378	com/tencent/mm/protocal/d:Yxe	Ljava/lang/String;
    //   452: aload 9
    //   454: invokestatic 383	com/tencent/mm/sdk/crash/CrashReportFactory:setDebugerApiLevel	(Ljava/lang/String;)V
    //   457: new 35	java/lang/StringBuilder
    //   460: dup
    //   461: ldc_w 385
    //   464: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   467: getstatic 372	com/tencent/mm/protocal/d:nsC	Ljava/lang/String;
    //   470: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: ldc_w 387
    //   476: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokestatic 390	com/tencent/mm/sdk/crash/CrashReportFactory:getDebugerApiLevel	()Ljava/lang/String;
    //   482: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 8
    //   488: ldc_w 392
    //   491: invokevirtual 338	com/tencent/mm/booter/w:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   494: invokestatic 341	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   497: invokevirtual 150	java/lang/Integer:intValue	()I
    //   500: istore_1
    //   501: new 35	java/lang/StringBuilder
    //   504: dup
    //   505: ldc_w 394
    //   508: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   511: getstatic 398	com/tencent/mm/protocal/d:Yxg	J
    //   514: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   517: ldc_w 403
    //   520: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: iload_1
    //   524: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: iload_1
    //   529: i2l
    //   530: putstatic 398	com/tencent/mm/protocal/d:Yxg	J
    //   533: aload 8
    //   535: ldc_w 405
    //   538: invokevirtual 338	com/tencent/mm/booter/w:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   541: invokestatic 341	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   544: invokevirtual 150	java/lang/Integer:intValue	()I
    //   547: istore_1
    //   548: aload 8
    //   550: getfield 411	com/tencent/mm/booter/q:lsS	Lcom/tencent/mm/booter/d;
    //   553: iload_1
    //   554: putfield 414	com/tencent/mm/booter/d:lrt	I
    //   557: aload 8
    //   559: ldc_w 416
    //   562: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   565: iconst_0
    //   566: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   569: istore 4
    //   571: aload 8
    //   573: ldc_w 418
    //   576: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   579: iconst_0
    //   580: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   583: istore 5
    //   585: aload 8
    //   587: ldc_w 420
    //   590: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   593: iconst_0
    //   594: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   597: istore 6
    //   599: aload 8
    //   601: ldc_w 422
    //   604: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   607: iconst_0
    //   608: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   611: istore 7
    //   613: iload 4
    //   615: iload 5
    //   617: iload 6
    //   619: iload 7
    //   621: invokestatic 427	com/tencent/mm/plugin/report/a/c:e	(ZZZZ)V
    //   624: new 35	java/lang/StringBuilder
    //   627: dup
    //   628: ldc_w 429
    //   631: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   634: iload 4
    //   636: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   639: ldc_w 434
    //   642: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: iload 5
    //   647: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   650: ldc_w 436
    //   653: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: iload 6
    //   658: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   661: ldc_w 438
    //   664: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: iload 7
    //   669: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   672: ldc_w 440
    //   675: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 8
    //   681: ldc_w 442
    //   684: invokevirtual 338	com/tencent/mm/booter/w:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   687: ldc_w 444
    //   690: invokestatic 447	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   693: putstatic 450	com/tencent/mm/platformtools/z:pCh	Ljava/lang/String;
    //   696: ldc_w 319
    //   699: new 35	java/lang/StringBuilder
    //   702: dup
    //   703: ldc_w 452
    //   706: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   709: getstatic 450	com/tencent/mm/platformtools/z:pCh	Ljava/lang/String;
    //   712: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 8
    //   723: ldc_w 454
    //   726: invokevirtual 338	com/tencent/mm/booter/w:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   729: ldc_w 444
    //   732: invokestatic 447	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   735: putstatic 457	com/tencent/mm/platformtools/z:pCi	Ljava/lang/String;
    //   738: ldc_w 319
    //   741: new 35	java/lang/StringBuilder
    //   744: dup
    //   745: ldc_w 459
    //   748: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   751: getstatic 457	com/tencent/mm/platformtools/z:pCi	Ljava/lang/String;
    //   754: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: aload 8
    //   765: ldc_w 461
    //   768: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   771: iconst_0
    //   772: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   775: putstatic 464	com/tencent/mm/platformtools/z:pCj	Z
    //   778: ldc_w 319
    //   781: new 35	java/lang/StringBuilder
    //   784: dup
    //   785: ldc_w 466
    //   788: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   791: getstatic 464	com/tencent/mm/platformtools/z:pCj	Z
    //   794: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   797: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: aload 8
    //   805: ldc_w 468
    //   808: invokevirtual 223	com/tencent/mm/booter/w:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   811: iconst_0
    //   812: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   815: putstatic 471	com/tencent/mm/platformtools/z:pCk	Z
    //   818: ldc_w 319
    //   821: new 35	java/lang/StringBuilder
    //   824: dup
    //   825: ldc_w 473
    //   828: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   831: getstatic 471	com/tencent/mm/platformtools/z:pCk	Z
    //   834: invokevirtual 432	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   837: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: invokestatic 479	com/tencent/mm/kernel/h:baB	()Lcom/tencent/mm/kernel/e;
    //   846: invokevirtual 485	com/tencent/mm/kernel/e:bad	()Lcom/tencent/mm/kernel/b/g;
    //   849: checkcast 487	com/tencent/mm/kernel/b/h
    //   852: getfield 492	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
    //   855: invokestatic 497	com/tencent/mm/app/h:cr	(Landroid/content/Context;)V
    //   858: invokestatic 502	com/tencent/mm/app/a:aBO	()V
    //   861: ldc_w 504
    //   864: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   867: ldc_w 511
    //   870: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   873: ldc_w 513
    //   876: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   879: ldc_w 515
    //   882: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   885: getstatic 520	com/tencent/mm/sdk/CommLibFileName:quic	Ljava/lang/String;
    //   888: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   891: ldc_w 522
    //   894: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   897: ldc_w 524
    //   900: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   903: ldc_w 526
    //   906: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   909: invokestatic 531	com/tencent/mm/compatible/deviceinfo/m:aOK	()I
    //   912: istore_1
    //   913: iload_1
    //   914: sipush 1024
    //   917: iand
    //   918: ifeq +437 -> 1355
    //   921: getstatic 57	com/tencent/mm/app/ToolsProfile:TAG	Ljava/lang/String;
    //   924: ldc_w 533
    //   927: iconst_1
    //   928: anewarray 122	java/lang/Object
    //   931: dup
    //   932: iconst_0
    //   933: iload_1
    //   934: bipush 12
    //   936: ishr
    //   937: invokestatic 536	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   940: aastore
    //   941: invokestatic 539	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   944: ldc_w 541
    //   947: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   950: iload_1
    //   951: bipush 12
    //   953: ishr
    //   954: iconst_4
    //   955: if_icmplt +383 -> 1338
    //   958: iconst_3
    //   959: putstatic 546	com/tencent/mm/plugin/sight/base/d:PFh	I
    //   962: iconst_3
    //   963: putstatic 549	com/tencent/mm/plugin/sight/base/d:PFj	I
    //   966: ldc_w 550
    //   969: putstatic 553	com/tencent/mm/plugin/sight/base/d:PFk	I
    //   972: invokestatic 558	com/tencent/mm/plugin/sight/base/SightVideoJNI:registerALL	()V
    //   975: aload_0
    //   976: getfield 76	com/tencent/mm/app/ToolsProfile:app	Landroid/app/Application;
    //   979: invokevirtual 82	android/app/Application:getBaseContext	()Landroid/content/Context;
    //   982: invokestatic 88	com/tencent/mm/ui/MMActivity:initLanguage	(Landroid/content/Context;)Ljava/util/Locale;
    //   985: putstatic 92	com/tencent/mm/app/ToolsProfile:locale	Ljava/util/Locale;
    //   988: invokestatic 563	com/tencent/mm/app/af:aCS	()V
    //   991: bipush 14
    //   993: invokestatic 569	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   996: ifeq +26 -> 1022
    //   999: getstatic 575	com/tencent/mm/app/e:hfI	Lcom/tencent/tinker/entry/ApplicationLike;
    //   1002: ifnull +20 -> 1022
    //   1005: getstatic 575	com/tencent/mm/app/e:hfI	Lcom/tencent/tinker/entry/ApplicationLike;
    //   1008: invokevirtual 581	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   1011: new 8	com/tencent/mm/app/ToolsProfile$2
    //   1014: dup
    //   1015: aload_0
    //   1016: invokespecial 582	com/tencent/mm/app/ToolsProfile$2:<init>	(Lcom/tencent/mm/app/ToolsProfile;)V
    //   1019: invokevirtual 586	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   1022: getstatic 57	com/tencent/mm/app/ToolsProfile:TAG	Ljava/lang/String;
    //   1025: new 35	java/lang/StringBuilder
    //   1028: dup
    //   1029: ldc_w 588
    //   1032: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1035: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   1038: lload_2
    //   1039: lsub
    //   1040: invokevirtual 401	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1043: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1049: invokestatic 592	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1052: ifeq +112 -> 1164
    //   1055: ldc_w 594
    //   1058: getstatic 600	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1061: invokestatic 606	com/tencent/mm/pluginsdk/model/ad:P	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1064: ldc_w 608
    //   1067: new 610	com/tencent/mm/vfs/u
    //   1070: dup
    //   1071: invokestatic 192	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1074: invokevirtual 616	android/content/Context:getFilesDir	()Ljava/io/File;
    //   1077: new 35	java/lang/StringBuilder
    //   1080: dup
    //   1081: ldc_w 618
    //   1084: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1087: invokestatic 621	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   1090: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: ldc_w 623
    //   1096: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokespecial 626	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1105: invokevirtual 630	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   1108: invokestatic 636	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   1111: invokestatic 606	com/tencent/mm/pluginsdk/model/ad:P	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1114: ldc_w 638
    //   1117: new 610	com/tencent/mm/vfs/u
    //   1120: dup
    //   1121: invokestatic 192	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1124: invokevirtual 616	android/content/Context:getFilesDir	()Ljava/io/File;
    //   1127: new 35	java/lang/StringBuilder
    //   1130: dup
    //   1131: ldc_w 640
    //   1134: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1137: invokestatic 621	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   1140: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: ldc_w 623
    //   1146: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokespecial 626	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1155: invokevirtual 630	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   1158: invokestatic 636	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   1161: invokestatic 606	com/tencent/mm/pluginsdk/model/ad:P	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1164: invokestatic 192	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1167: invokestatic 645	com/tencent/mm/pluginsdk/model/ad$a:lq	(Landroid/content/Context;)V
    //   1170: invokestatic 651	com/tencent/mm/app/plugin/f:aDP	()Lcom/tencent/mm/app/plugin/f;
    //   1173: putstatic 657	com/tencent/mm/pluginsdk/ui/span/d$a:YnY	Lcom/tencent/mm/pluginsdk/ui/span/d;
    //   1176: new 659	com/tencent/mm/app/MediaLeakReporter
    //   1179: dup
    //   1180: bipush 22
    //   1182: bipush 32
    //   1184: invokespecial 662	com/tencent/mm/app/MediaLeakReporter:<init>	(II)V
    //   1187: invokevirtual 665	com/tencent/mm/app/MediaLeakReporter:alive	()V
    //   1190: invokestatic 668	com/tencent/mm/pluginsdk/model/ad$a:iIi	()V
    //   1193: invokestatic 671	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsMpProcess	()Z
    //   1196: ifeq +23 -> 1219
    //   1199: getstatic 677	com/tencent/mm/plugin/appbrand/ag/b/a/c:utd	Lcom/tencent/mm/plugin/appbrand/ag/b/a/c;
    //   1202: astore 8
    //   1204: invokestatic 681	com/tencent/mm/plugin/appbrand/ag/b/a/c:cNY	()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;
    //   1207: invokevirtual 686	com/tencent/mm/sdk/platformtools/MMKVSlotManager:clearAll	()V
    //   1210: ldc_w 688
    //   1213: ldc_w 690
    //   1216: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1219: invokestatic 592	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsProcess	()Z
    //   1222: ifeq +222 -> 1444
    //   1225: ldc_w 692
    //   1228: ldc_w 694
    //   1231: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: invokestatic 700	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   1237: invokevirtual 703	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:isConnected	()Z
    //   1240: ifne +177 -> 1417
    //   1243: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   1246: lstore_2
    //   1247: invokestatic 700	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:getInstance	()Lcom/tencent/mm/plugin/sns/model/AdLandingPagesProxy;
    //   1250: new 705	com/tencent/mm/plugin/sns/ad/landingpage/helper/b$1
    //   1253: dup
    //   1254: lload_2
    //   1255: invokespecial 708	com/tencent/mm/plugin/sns/ad/landingpage/helper/b$1:<init>	(J)V
    //   1258: invokevirtual 712	com/tencent/mm/plugin/sns/model/AdLandingPagesProxy:connect	(Ljava/lang/Runnable;)V
    //   1261: sipush 19499
    //   1264: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1267: return
    //   1268: astore 9
    //   1270: ldc_w 319
    //   1273: ldc_w 714
    //   1276: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1279: goto -881 -> 398
    //   1282: astore 9
    //   1284: ldc_w 319
    //   1287: ldc_w 714
    //   1290: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1293: goto -807 -> 486
    //   1296: astore 9
    //   1298: ldc_w 319
    //   1301: ldc_w 714
    //   1304: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1307: goto -774 -> 533
    //   1310: astore 9
    //   1312: ldc_w 319
    //   1315: ldc_w 714
    //   1318: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1321: goto -764 -> 557
    //   1324: astore 9
    //   1326: ldc_w 319
    //   1329: ldc_w 714
    //   1332: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1335: goto -656 -> 679
    //   1338: iconst_1
    //   1339: putstatic 546	com/tencent/mm/plugin/sight/base/d:PFh	I
    //   1342: iconst_1
    //   1343: putstatic 549	com/tencent/mm/plugin/sight/base/d:PFj	I
    //   1346: ldc_w 715
    //   1349: putstatic 553	com/tencent/mm/plugin/sight/base/d:PFk	I
    //   1352: goto -380 -> 972
    //   1355: getstatic 57	com/tencent/mm/app/ToolsProfile:TAG	Ljava/lang/String;
    //   1358: ldc_w 717
    //   1361: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1364: ldc_w 719
    //   1367: invokestatic 509	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   1370: ldc_w 721
    //   1373: iconst_0
    //   1374: invokestatic 727	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   1377: iconst_1
    //   1378: putstatic 546	com/tencent/mm/plugin/sight/base/d:PFh	I
    //   1381: iconst_1
    //   1382: putstatic 549	com/tencent/mm/plugin/sight/base/d:PFj	I
    //   1385: ldc_w 715
    //   1388: putstatic 553	com/tencent/mm/plugin/sight/base/d:PFk	I
    //   1391: goto -419 -> 972
    //   1394: astore 8
    //   1396: ldc_w 688
    //   1399: aload 8
    //   1401: checkcast 729	java/lang/Throwable
    //   1404: ldc_w 444
    //   1407: iconst_0
    //   1408: anewarray 122	java/lang/Object
    //   1411: invokestatic 733	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1414: goto -195 -> 1219
    //   1417: ldc_w 692
    //   1420: ldc_w 735
    //   1423: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1426: sipush 19499
    //   1429: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1432: return
    //   1433: astore 8
    //   1435: ldc_w 692
    //   1438: ldc_w 737
    //   1441: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: sipush 19499
    //   1447: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1450: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1451	0	this	ToolsProfile
    //   299	655	1	i	int
    //   9	1246	2	l	long
    //   569	66	4	bool1	boolean
    //   583	63	5	bool2	boolean
    //   597	60	6	bool3	boolean
    //   611	57	7	bool4	boolean
    //   73	1130	8	localObject1	Object
    //   1394	6	8	localException1	java.lang.Exception
    //   1433	1	8	localObject2	Object
    //   406	47	9	str	String
    //   1268	1	9	localException2	java.lang.Exception
    //   1282	1	9	localException3	java.lang.Exception
    //   1296	1	9	localException4	java.lang.Exception
    //   1310	1	9	localException5	java.lang.Exception
    //   1324	1	9	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   361	398	1268	java/lang/Exception
    //   398	486	1282	java/lang/Exception
    //   486	533	1296	java/lang/Exception
    //   533	557	1310	java/lang/Exception
    //   557	679	1324	java/lang/Exception
    //   1204	1219	1394	java/lang/Exception
    //   1234	1267	1433	finally
    //   1417	1426	1433	finally
  }
  
  public final String toString()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */