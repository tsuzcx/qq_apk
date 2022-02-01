package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.vj;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.memory.a.a.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c.b.3;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.m;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.ui.VoipViewFragment;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.AndroidOSafety.ISafetyCallback;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.viewitems.l.a;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.database.SQLiteTrace.TraceInfo;
import com.tencent.xweb.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PluginBigBallOfMud
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket
{
  public Application app;
  private com.tencent.mm.compatible.loader.c mFS;
  private final MMAppMgr vte;
  private j vtf;
  
  public PluginBigBallOfMud()
  {
    AppMethodBeat.i(22412);
    this.vte = new MMAppMgr();
    this.vtf = new j();
    AppMethodBeat.o(22412);
  }
  
  /* Error */
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    // Byte code:
    //   0: sipush 22414
    //   3: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 8	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$1
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 125	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$1:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   14: invokestatic 131	com/tencent/mm/ui/e:a	(Lcom/tencent/mm/ui/e$a;)V
    //   17: new 133	com/tencent/mm/booter/e$c
    //   20: dup
    //   21: invokespecial 134	com/tencent/mm/booter/e$c:<init>	()V
    //   24: invokestatic 139	com/tencent/mm/booter/MMReceivers$ToolsProcessReceiver:a	(Lcom/tencent/mm/booter/MMReceivers$a;)V
    //   27: new 141	com/tencent/mm/booter/e$a
    //   30: dup
    //   31: invokespecial 142	com/tencent/mm/booter/e$a:<init>	()V
    //   34: invokestatic 145	com/tencent/mm/booter/MMReceivers$ToolsMpProcessReceiver:a	(Lcom/tencent/mm/booter/MMReceivers$a;)V
    //   37: new 147	com/tencent/mm/booter/e$b
    //   40: dup
    //   41: invokespecial 148	com/tencent/mm/booter/e$b:<init>	()V
    //   44: invokestatic 151	com/tencent/mm/booter/MMReceivers$SandBoxProcessReceiver:a	(Lcom/tencent/mm/booter/MMReceivers$a;)V
    //   47: ldc 153
    //   49: invokestatic 159	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   52: checkcast 153	com/tencent/mm/plugin/zero/a/d
    //   55: astore 10
    //   57: aload 10
    //   59: new 161	com/tencent/mm/plugin/bbom/l
    //   62: dup
    //   63: invokespecial 162	com/tencent/mm/plugin/bbom/l:<init>	()V
    //   66: invokeinterface 166 2 0
    //   71: aload 10
    //   73: new 168	com/tencent/mm/plugin/bbom/q
    //   76: dup
    //   77: invokespecial 169	com/tencent/mm/plugin/bbom/q:<init>	()V
    //   80: invokeinterface 173 2 0
    //   85: pop
    //   86: aload 10
    //   88: new 175	com/tencent/mm/plugin/bbom/g
    //   91: dup
    //   92: invokespecial 176	com/tencent/mm/plugin/bbom/g:<init>	()V
    //   95: invokeinterface 180 2 0
    //   100: pop
    //   101: ldc 182
    //   103: ldc 184
    //   105: iconst_1
    //   106: anewarray 186	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload 10
    //   113: aastore
    //   114: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_0
    //   118: aload_1
    //   119: getfield 196	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
    //   122: putfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   125: ldc 182
    //   127: ldc 200
    //   129: iconst_1
    //   130: anewarray 186	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   139: aastore
    //   140: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   147: invokestatic 206	com/tencent/mm/modelstat/d:j	(Landroid/app/Application;)V
    //   150: ldc 182
    //   152: ldc 208
    //   154: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   160: lstore 4
    //   162: new 219	com/tencent/mm/compatible/loader/d
    //   165: dup
    //   166: invokespecial 220	com/tencent/mm/compatible/loader/d:<init>	()V
    //   169: astore 12
    //   171: aload_0
    //   172: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   175: astore 10
    //   177: aload_1
    //   178: getfield 224	com/tencent/mm/kernel/b/g:mProcessName	Ljava/lang/String;
    //   181: astore 11
    //   183: aload 11
    //   185: ifnull +11 -> 196
    //   188: aload 11
    //   190: invokevirtual 230	java/lang/String:length	()I
    //   193: ifgt +3541 -> 3734
    //   196: ldc 232
    //   198: invokestatic 238	com/tencent/threadpool/j/a:bFV	(Ljava/lang/String;)Lcom/tencent/threadpool/j/a;
    //   201: astore 13
    //   203: new 240	com/tencent/mm/compatible/loader/d$1
    //   206: dup
    //   207: aload 12
    //   209: invokespecial 243	com/tencent/mm/compatible/loader/d$1:<init>	(Lcom/tencent/mm/compatible/loader/d;)V
    //   212: new 245	com/tencent/mm/sdk/platformtools/MMHandler
    //   215: dup
    //   216: aload 13
    //   218: invokespecial 248	com/tencent/mm/sdk/platformtools/MMHandler:<init>	(Lcom/tencent/threadpool/j/a;)V
    //   221: invokevirtual 252	com/tencent/mm/compatible/loader/d$1:exec	(Lcom/tencent/mm/sdk/platformtools/MMHandler;)Ljava/lang/Object;
    //   224: checkcast 226	java/lang/String
    //   227: astore 11
    //   229: aload 13
    //   231: getfield 256	com/tencent/threadpool/j/a:ahCy	Lcom/tencent/threadpool/j/d;
    //   234: invokevirtual 262	com/tencent/threadpool/j/d:quit	()Z
    //   237: pop
    //   238: aload 11
    //   240: ifnonnull +2770 -> 3010
    //   243: ldc_w 264
    //   246: ldc_w 266
    //   249: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aconst_null
    //   253: astore 10
    //   255: aload_0
    //   256: aload 10
    //   258: putfield 271	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:mFS	Lcom/tencent/mm/compatible/loader/c;
    //   261: aload_0
    //   262: getfield 271	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:mFS	Lcom/tencent/mm/compatible/loader/c;
    //   265: ifnull +25 -> 290
    //   268: aload_1
    //   269: invokevirtual 274	com/tencent/mm/kernel/b/g:bbA	()Z
    //   272: ifne +18 -> 290
    //   275: ldc 182
    //   277: ldc_w 276
    //   280: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: getfield 271	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:mFS	Lcom/tencent/mm/compatible/loader/c;
    //   287: invokevirtual 281	com/tencent/mm/compatible/loader/c:onCreate	()V
    //   290: ldc 182
    //   292: ldc_w 283
    //   295: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_0
    //   299: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   302: invokevirtual 289	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   305: invokestatic 295	com/tencent/mm/app/h:cr	(Landroid/content/Context;)V
    //   308: aload_1
    //   309: checkcast 297	com/tencent/mm/kernel/b/h
    //   312: aload_0
    //   313: getfield 271	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:mFS	Lcom/tencent/mm/compatible/loader/c;
    //   316: putfield 298	com/tencent/mm/kernel/b/h:mFS	Lcom/tencent/mm/compatible/loader/c;
    //   319: aload_1
    //   320: getfield 196	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
    //   323: ldc_w 300
    //   326: iconst_0
    //   327: invokevirtual 304	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   330: astore 10
    //   332: aload 10
    //   334: ifnull +3395 -> 3729
    //   337: aload 10
    //   339: ldc_w 306
    //   342: iconst_0
    //   343: invokeinterface 312 3 0
    //   348: istore_2
    //   349: ldc 182
    //   351: ldc_w 314
    //   354: bipush 6
    //   356: anewarray 186	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload_1
    //   362: getfield 224	com/tencent/mm/kernel/b/g:mProcessName	Ljava/lang/String;
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: getstatic 320	com/tencent/mm/app/e:hfJ	J
    //   371: invokestatic 326	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   374: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: aastore
    //   378: dup
    //   379: iconst_2
    //   380: lload 4
    //   382: invokestatic 326	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   385: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   388: aastore
    //   389: dup
    //   390: iconst_3
    //   391: iload_2
    //   392: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_4
    //   398: getstatic 342	com/tencent/mm/storage/at:acHq	Ljava/lang/String;
    //   401: aastore
    //   402: dup
    //   403: iconst_5
    //   404: invokestatic 348	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   407: aastore
    //   408: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: aload_1
    //   412: invokevirtual 274	com/tencent/mm/kernel/b/g:bbA	()Z
    //   415: ifeq +14 -> 429
    //   418: new 14	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$12
    //   421: dup
    //   422: aload_0
    //   423: invokespecial 349	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$12:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   426: invokestatic 354	com/tencent/mm/j/a$a:a	(Lcom/tencent/mm/j/a;)V
    //   429: new 38	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$23
    //   432: dup
    //   433: aload_0
    //   434: invokespecial 355	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$23:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   437: invokestatic 360	com/tencent/mm/compatible/d/a:a	(Lcom/tencent/mm/compatible/d/a$a;)V
    //   440: new 62	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$34
    //   443: dup
    //   444: aload_0
    //   445: invokespecial 361	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$34:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   448: invokestatic 367	com/tencent/mm/sdk/platformtools/AndroidOSafety:setISafetyCallback	(Lcom/tencent/mm/sdk/platformtools/AndroidOSafety$ISafetyCallback;)V
    //   451: aload_1
    //   452: invokevirtual 274	com/tencent/mm/kernel/b/g:bbA	()Z
    //   455: ifeq +2535 -> 2990
    //   458: new 64	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$35
    //   461: dup
    //   462: aload_0
    //   463: invokespecial 368	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$35:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   466: putstatic 374	com/tencent/mm/modelfriend/a:oDC	Lcom/tencent/mm/modelfriend/a$a;
    //   469: new 66	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$36
    //   472: dup
    //   473: aload_0
    //   474: invokespecial 375	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$36:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   477: invokestatic 380	com/tencent/mm/storagebase/f:a	(Lcom/tencent/wcdb/database/SQLiteTrace;)V
    //   480: new 68	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$37
    //   483: dup
    //   484: aload_0
    //   485: invokespecial 381	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$37:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   488: putstatic 387	com/tencent/mm/storage/e:acDF	Lcom/tencent/mm/plugin/messenger/foundation/a/p;
    //   491: new 70	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$38
    //   494: dup
    //   495: aload_0
    //   496: invokespecial 388	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$38:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   499: invokestatic 393	com/tencent/mm/model/ac:a	(Lcom/tencent/mm/model/ac$a;)V
    //   502: new 72	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$39
    //   505: dup
    //   506: aload_0
    //   507: invokespecial 394	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$39:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   510: invokestatic 400	com/tencent/mm/plugin/messenger/foundation/a/af:b	(Lcom/tencent/mm/cp/c;)V
    //   513: new 402	com/tencent/mm/modelmulti/a
    //   516: dup
    //   517: invokespecial 403	com/tencent/mm/modelmulti/a:<init>	()V
    //   520: astore_1
    //   521: bipush 69
    //   523: aload_1
    //   524: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   527: bipush 68
    //   529: aload_1
    //   530: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   533: bipush 22
    //   535: aload_1
    //   536: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   539: bipush 13
    //   541: aload_1
    //   542: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   545: bipush 15
    //   547: aload_1
    //   548: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   551: bipush 23
    //   553: aload_1
    //   554: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   557: bipush 25
    //   559: aload_1
    //   560: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   563: bipush 24
    //   565: aload_1
    //   566: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   569: bipush 33
    //   571: aload_1
    //   572: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   575: bipush 35
    //   577: aload_1
    //   578: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   581: bipush 44
    //   583: aload_1
    //   584: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   587: ldc_w 409
    //   590: aload_1
    //   591: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   594: bipush 53
    //   596: aload_1
    //   597: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   600: sipush 204
    //   603: aload_1
    //   604: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   607: sipush 219
    //   610: aload_1
    //   611: invokestatic 408	com/tencent/mm/plugin/messenger/foundation/a/ab$a:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ab;)V
    //   614: new 411	com/tencent/mm/plugin/bbom/c
    //   617: dup
    //   618: invokespecial 412	com/tencent/mm/plugin/bbom/c:<init>	()V
    //   621: astore_1
    //   622: ldc_w 414
    //   625: invokestatic 418	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   628: checkcast 414	com/tencent/mm/plugin/messenger/foundation/a/g
    //   631: aload_1
    //   632: invokeinterface 422 2 0
    //   637: pop
    //   638: invokestatic 426	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   641: sipush 681
    //   644: aload_1
    //   645: invokevirtual 431	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   648: ldc_w 433
    //   651: aload_0
    //   652: getfield 114	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:vtf	Lcom/tencent/mm/plugin/bbom/j;
    //   655: invokestatic 436	com/tencent/mm/kernel/h:b	(Ljava/lang/Class;Lcom/tencent/mm/kernel/c/a;)V
    //   658: iconst_5
    //   659: new 438	com/tencent/mm/plugin/bbom/n
    //   662: dup
    //   663: invokespecial 439	com/tencent/mm/plugin/bbom/n:<init>	()V
    //   666: invokestatic 442	com/tencent/mm/plugin/messenger/foundation/a/af:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ac;)V
    //   669: iconst_1
    //   670: new 444	com/tencent/mm/plugin/bbom/s
    //   673: dup
    //   674: invokespecial 445	com/tencent/mm/plugin/bbom/s:<init>	()V
    //   677: invokestatic 442	com/tencent/mm/plugin/messenger/foundation/a/af:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ac;)V
    //   680: iconst_4
    //   681: new 447	com/tencent/mm/plugin/bbom/i
    //   684: dup
    //   685: invokespecial 448	com/tencent/mm/plugin/bbom/i:<init>	()V
    //   688: invokestatic 442	com/tencent/mm/plugin/messenger/foundation/a/af:a	(ILcom/tencent/mm/plugin/messenger/foundation/a/ac;)V
    //   691: ldc_w 450
    //   694: invokestatic 159	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   697: checkcast 450	com/tencent/mm/plugin/auth/a/c
    //   700: new 452	com/tencent/mm/plugin/bbom/a
    //   703: dup
    //   704: invokespecial 453	com/tencent/mm/plugin/bbom/a:<init>	()V
    //   707: invokeinterface 457 2 0
    //   712: pop
    //   713: new 459	com/tencent/mm/plugin/bbom/o
    //   716: dup
    //   717: invokespecial 460	com/tencent/mm/plugin/bbom/o:<init>	()V
    //   720: astore_1
    //   721: ldc_w 462
    //   724: invokestatic 418	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   727: checkcast 462	com/tencent/mm/plugin/messenger/foundation/a/aa
    //   730: aload_1
    //   731: invokeinterface 465 2 0
    //   736: ldc_w 462
    //   739: invokestatic 418	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   742: checkcast 462	com/tencent/mm/plugin/messenger/foundation/a/aa
    //   745: aload_1
    //   746: invokeinterface 468 2 0
    //   751: ldc_w 462
    //   754: invokestatic 418	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   757: checkcast 462	com/tencent/mm/plugin/messenger/foundation/a/aa
    //   760: new 470	com/tencent/mm/plugin/bbom/h
    //   763: dup
    //   764: invokespecial 471	com/tencent/mm/plugin/bbom/h:<init>	()V
    //   767: invokeinterface 474 2 0
    //   772: new 476	com/tencent/mm/plugin/bbom/b
    //   775: dup
    //   776: invokespecial 477	com/tencent/mm/plugin/bbom/b:<init>	()V
    //   779: invokestatic 482	com/tencent/mm/model/e:a	(Lcom/tencent/mm/plugin/messenger/foundation/a/c;)V
    //   782: new 484	com/tencent/mm/permission/a
    //   785: dup
    //   786: invokespecial 485	com/tencent/mm/permission/a:<init>	()V
    //   789: pop
    //   790: new 487	com/tencent/mm/plugin/bbom/PostSyncTaskDeprecatedListener
    //   793: dup
    //   794: invokespecial 488	com/tencent/mm/plugin/bbom/PostSyncTaskDeprecatedListener:<init>	()V
    //   797: invokevirtual 491	com/tencent/mm/plugin/bbom/PostSyncTaskDeprecatedListener:alive	()V
    //   800: invokestatic 496	com/tencent/mm/plugin/bbom/p:dax	()V
    //   803: aload_0
    //   804: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   807: invokestatic 501	com/tencent/mm/plugin/bbom/r:fI	(Landroid/content/Context;)V
    //   810: ldc_w 503
    //   813: new 505	com/tencent/mm/model/u$1
    //   816: dup
    //   817: invokespecial 506	com/tencent/mm/model/u$1:<init>	()V
    //   820: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   823: ldc_w 513
    //   826: new 515	com/tencent/mm/model/u$2
    //   829: dup
    //   830: invokespecial 516	com/tencent/mm/model/u$2:<init>	()V
    //   833: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   836: ldc_w 518
    //   839: new 520	com/tencent/mm/model/u$3
    //   842: dup
    //   843: invokespecial 521	com/tencent/mm/model/u$3:<init>	()V
    //   846: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   849: ldc_w 523
    //   852: new 525	com/tencent/mm/model/u$4
    //   855: dup
    //   856: invokespecial 526	com/tencent/mm/model/u$4:<init>	()V
    //   859: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   862: ldc_w 528
    //   865: new 530	com/tencent/mm/model/u$5
    //   868: dup
    //   869: invokespecial 531	com/tencent/mm/model/u$5:<init>	()V
    //   872: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   875: ldc_w 533
    //   878: new 535	com/tencent/mm/model/u$6
    //   881: dup
    //   882: invokespecial 536	com/tencent/mm/model/u$6:<init>	()V
    //   885: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   888: ldc_w 538
    //   891: new 540	com/tencent/mm/model/u$7
    //   894: dup
    //   895: invokespecial 541	com/tencent/mm/model/u$7:<init>	()V
    //   898: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   901: ldc_w 543
    //   904: invokestatic 159	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   907: checkcast 543	com/tencent/mm/plugin/messenger/foundation/a/v
    //   910: invokeinterface 547 1 0
    //   915: ldc_w 549
    //   918: new 551	com/tencent/mm/model/u$8
    //   921: dup
    //   922: invokespecial 552	com/tencent/mm/model/u$8:<init>	()V
    //   925: invokevirtual 557	com/tencent/mm/model/cl:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/messenger/foundation/a/s;)V
    //   928: ldc_w 559
    //   931: new 561	com/tencent/mm/ui/chatting/h/b$1
    //   934: dup
    //   935: invokespecial 562	com/tencent/mm/ui/chatting/h/b$1:<init>	()V
    //   938: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   941: ldc_w 564
    //   944: new 566	com/tencent/mm/ui/chatting/h/b$2
    //   947: dup
    //   948: invokespecial 567	com/tencent/mm/ui/chatting/h/b$2:<init>	()V
    //   951: invokestatic 511	com/tencent/mm/ax/a$a:a	(Ljava/lang/String;Lcom/tencent/mm/ax/a$a;)V
    //   954: invokestatic 572	com/tencent/mm/model/ca:bAp	()V
    //   957: invokestatic 575	com/tencent/mm/model/n:bAp	()V
    //   960: aload_0
    //   961: getfield 109	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:vte	Lcom/tencent/mm/ui/MMAppMgr;
    //   964: astore_1
    //   965: aload_0
    //   966: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   969: astore 10
    //   971: aload_1
    //   972: getfield 579	com/tencent/mm/ui/MMAppMgr:adFe	Lcom/tencent/mm/ui/MMAppMgr$Receiver;
    //   975: ifnonnull +15 -> 990
    //   978: aload_1
    //   979: new 581	com/tencent/mm/ui/MMAppMgr$Receiver
    //   982: dup
    //   983: aload_1
    //   984: invokespecial 584	com/tencent/mm/ui/MMAppMgr$Receiver:<init>	(Lcom/tencent/mm/ui/MMAppMgr;)V
    //   987: putfield 579	com/tencent/mm/ui/MMAppMgr:adFe	Lcom/tencent/mm/ui/MMAppMgr$Receiver;
    //   990: invokestatic 589	com/tencent/mm/ui/MMActivity:setMainProcess	()V
    //   993: new 591	android/content/IntentFilter
    //   996: dup
    //   997: invokespecial 592	android/content/IntentFilter:<init>	()V
    //   1000: astore 11
    //   1002: aload 11
    //   1004: ldc_w 594
    //   1007: invokevirtual 598	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1010: aload 11
    //   1012: ldc_w 600
    //   1015: invokevirtual 598	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1018: aload 11
    //   1020: ldc_w 602
    //   1023: invokevirtual 598	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1026: aload 11
    //   1028: ldc_w 604
    //   1031: invokevirtual 598	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1034: aload 11
    //   1036: ldc_w 606
    //   1039: invokevirtual 598	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1042: aload 10
    //   1044: aload_1
    //   1045: getfield 579	com/tencent/mm/ui/MMAppMgr:adFe	Lcom/tencent/mm/ui/MMAppMgr$Receiver;
    //   1048: aload 11
    //   1050: invokestatic 611	com/tencent/mm/sdk/platformtools/WeChatPermissions:PERMISSION_MM_MESSAGE	()Ljava/lang/String;
    //   1053: aconst_null
    //   1054: invokevirtual 617	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1057: pop
    //   1058: new 619	com/tencent/mm/booter/x
    //   1061: dup
    //   1062: aload_0
    //   1063: getfield 198	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:app	Landroid/app/Application;
    //   1066: invokestatic 625	com/tencent/mm/booter/d:cO	(Landroid/content/Context;)Lcom/tencent/mm/booter/d;
    //   1069: invokespecial 628	com/tencent/mm/booter/x:<init>	(Lcom/tencent/mm/booter/d;)V
    //   1072: astore_1
    //   1073: aload_1
    //   1074: ldc_w 630
    //   1077: invokevirtual 633	com/tencent/mm/booter/x:Ci	(Ljava/lang/String;)V
    //   1080: aload_1
    //   1081: ldc_w 635
    //   1084: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1087: iconst_0
    //   1088: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1091: putstatic 649	com/tencent/mm/platformtools/z:pCs	Z
    //   1094: aload_1
    //   1095: ldc_w 651
    //   1098: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1101: iconst_0
    //   1102: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1105: putstatic 654	com/tencent/mm/platformtools/z:pBz	Z
    //   1108: aload_1
    //   1109: ldc_w 656
    //   1112: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1115: iconst_0
    //   1116: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1119: putstatic 659	com/tencent/mm/platformtools/z:pBA	Z
    //   1122: aload_1
    //   1123: ldc_w 661
    //   1126: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1129: iconst_0
    //   1130: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1133: putstatic 664	com/tencent/mm/platformtools/z:pBB	Z
    //   1136: aload_1
    //   1137: ldc_w 666
    //   1140: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1143: iconst_0
    //   1144: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1147: putstatic 669	com/tencent/mm/platformtools/z:pBC	Z
    //   1150: aload_1
    //   1151: ldc_w 671
    //   1154: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1157: iconst_0
    //   1158: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1161: putstatic 674	com/tencent/mm/platformtools/z:pBD	Z
    //   1164: aload_1
    //   1165: ldc_w 676
    //   1168: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1171: iconst_0
    //   1172: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1175: putstatic 679	com/tencent/mm/platformtools/z:pBE	Z
    //   1178: aload_1
    //   1179: ldc_w 681
    //   1182: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1185: ldc_w 687
    //   1188: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1191: iconst_0
    //   1192: invokestatic 691	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1195: putstatic 695	com/tencent/mm/platformtools/z:pCe	I
    //   1198: aload_1
    //   1199: ldc_w 697
    //   1202: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1205: ldc_w 687
    //   1208: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1211: iconst_0
    //   1212: invokestatic 691	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1215: putstatic 700	com/tencent/mm/platformtools/z:pCf	I
    //   1218: aload_1
    //   1219: ldc_w 702
    //   1222: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1225: iconst_0
    //   1226: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1229: putstatic 705	com/tencent/mm/platformtools/z:pBG	Z
    //   1232: aload_1
    //   1233: ldc_w 707
    //   1236: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1239: iconst_0
    //   1240: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1243: putstatic 710	com/tencent/mm/platformtools/z:pBH	Z
    //   1246: aload_1
    //   1247: ldc_w 712
    //   1250: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1253: iconst_0
    //   1254: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1257: putstatic 715	com/tencent/mm/platformtools/z:pBI	Z
    //   1260: aload_1
    //   1261: ldc_w 717
    //   1264: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1267: iconst_0
    //   1268: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1271: putstatic 720	com/tencent/mm/platformtools/z:pBJ	Z
    //   1274: aload_1
    //   1275: ldc_w 722
    //   1278: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1281: iconst_0
    //   1282: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1285: putstatic 725	com/tencent/mm/platformtools/z:pBM	Z
    //   1288: aload_1
    //   1289: ldc_w 727
    //   1292: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1295: iconst_0
    //   1296: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1299: putstatic 730	com/tencent/mm/platformtools/z:pBN	Z
    //   1302: aload_1
    //   1303: ldc_w 732
    //   1306: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1309: iconst_0
    //   1310: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1313: putstatic 735	com/tencent/mm/platformtools/z:pBO	Z
    //   1316: aload_1
    //   1317: ldc_w 737
    //   1320: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1323: iconst_0
    //   1324: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1327: putstatic 740	com/tencent/mm/platformtools/z:pBP	Z
    //   1330: aload_1
    //   1331: ldc_w 742
    //   1334: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1337: iconst_0
    //   1338: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1341: putstatic 745	com/tencent/mm/platformtools/z:pBS	Z
    //   1344: aload_1
    //   1345: ldc_w 747
    //   1348: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1351: iconst_0
    //   1352: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1355: putstatic 750	com/tencent/mm/platformtools/z:pBT	Z
    //   1358: aload_1
    //   1359: ldc_w 752
    //   1362: invokevirtual 756	com/tencent/mm/booter/x:Cj	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1365: iconst_0
    //   1366: invokestatic 759	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   1369: istore_2
    //   1370: iload_2
    //   1371: putstatic 762	com/tencent/mm/platformtools/z:pBQ	I
    //   1374: iload_2
    //   1375: iconst_4
    //   1376: if_icmpeq +40 -> 1416
    //   1379: getstatic 762	com/tencent/mm/platformtools/z:pBQ	I
    //   1382: ifle +34 -> 1416
    //   1385: getstatic 762	com/tencent/mm/platformtools/z:pBQ	I
    //   1388: putstatic 767	com/tencent/mm/storage/as:acHo	I
    //   1391: ldc_w 769
    //   1394: new 771	java/lang/StringBuilder
    //   1397: dup
    //   1398: ldc_w 773
    //   1401: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1404: getstatic 762	com/tencent/mm/platformtools/z:pBQ	I
    //   1407: invokevirtual 779	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1410: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1413: invokestatic 269	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1416: aload_1
    //   1417: ldc_w 784
    //   1420: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1423: iconst_0
    //   1424: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1427: putstatic 787	com/tencent/mm/platformtools/z:pBR	Z
    //   1430: aload_1
    //   1431: ldc_w 789
    //   1434: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1437: ldc_w 791
    //   1440: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1443: putstatic 794	com/tencent/mm/platformtools/z:pBU	Ljava/lang/String;
    //   1446: aload_1
    //   1447: ldc_w 796
    //   1450: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1453: ldc_w 791
    //   1456: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1459: putstatic 799	com/tencent/mm/platformtools/z:pBV	Ljava/lang/String;
    //   1462: aload_1
    //   1463: ldc_w 801
    //   1466: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1469: iconst_0
    //   1470: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1473: ifeq +7 -> 1480
    //   1476: iconst_1
    //   1477: putstatic 806	com/tencent/mm/sdk/platformtools/ChannelUtil:fullVersionInfo	Z
    //   1480: aload_1
    //   1481: ldc_w 808
    //   1484: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1487: invokestatic 811	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1490: invokevirtual 814	java/lang/Integer:intValue	()I
    //   1493: istore_2
    //   1494: iload_2
    //   1495: invokestatic 819	com/tencent/mm/protocal/d:axo	(I)V
    //   1498: new 771	java/lang/StringBuilder
    //   1501: dup
    //   1502: ldc_w 821
    //   1505: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1508: iload_2
    //   1509: invokestatic 825	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1512: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload_1
    //   1517: ldc_w 830
    //   1520: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1523: astore 10
    //   1525: aload 10
    //   1527: invokestatic 834	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1530: ifne +73 -> 1603
    //   1533: ldc_w 836
    //   1536: aload 10
    //   1538: invokestatic 839	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1541: invokevirtual 842	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1544: putstatic 845	com/tencent/mm/protocal/d:nsC	Ljava/lang/String;
    //   1547: ldc_w 836
    //   1550: aload 10
    //   1552: invokestatic 839	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1555: invokevirtual 842	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1558: putstatic 848	com/tencent/mm/protocal/d:Yxc	Ljava/lang/String;
    //   1561: aload 10
    //   1563: invokestatic 839	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1566: putstatic 851	com/tencent/mm/protocal/d:Yxe	Ljava/lang/String;
    //   1569: aload 10
    //   1571: invokestatic 856	com/tencent/mm/sdk/crash/CrashReportFactory:setDebugerApiLevel	(Ljava/lang/String;)V
    //   1574: new 771	java/lang/StringBuilder
    //   1577: dup
    //   1578: ldc_w 858
    //   1581: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1584: getstatic 845	com/tencent/mm/protocal/d:nsC	Ljava/lang/String;
    //   1587: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: ldc_w 860
    //   1593: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: invokestatic 863	com/tencent/mm/sdk/crash/CrashReportFactory:getDebugerApiLevel	()Ljava/lang/String;
    //   1599: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: aload_1
    //   1604: ldc_w 865
    //   1607: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1610: invokestatic 868	java/lang/Long:decode	(Ljava/lang/String;)Ljava/lang/Long;
    //   1613: invokevirtual 871	java/lang/Long:longValue	()J
    //   1616: lstore 4
    //   1618: new 771	java/lang/StringBuilder
    //   1621: dup
    //   1622: ldc_w 873
    //   1625: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1628: getstatic 876	com/tencent/mm/protocal/d:Yxg	J
    //   1631: invokevirtual 879	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1634: ldc_w 881
    //   1637: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: lload 4
    //   1642: invokevirtual 879	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: lload 4
    //   1648: putstatic 876	com/tencent/mm/protocal/d:Yxg	J
    //   1651: aload_1
    //   1652: ldc_w 883
    //   1655: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1658: invokestatic 811	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1661: invokevirtual 814	java/lang/Integer:intValue	()I
    //   1664: istore_2
    //   1665: aload_1
    //   1666: getfield 889	com/tencent/mm/booter/q:lsS	Lcom/tencent/mm/booter/d;
    //   1669: iload_2
    //   1670: putfield 892	com/tencent/mm/booter/d:lrt	I
    //   1673: aload_1
    //   1674: ldc_w 894
    //   1677: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1680: iconst_0
    //   1681: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1684: istore 6
    //   1686: aload_1
    //   1687: ldc_w 896
    //   1690: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1693: iconst_0
    //   1694: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1697: istore 7
    //   1699: aload_1
    //   1700: ldc_w 898
    //   1703: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1706: iconst_0
    //   1707: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1710: istore 8
    //   1712: aload_1
    //   1713: ldc_w 900
    //   1716: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1719: iconst_0
    //   1720: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1723: istore 9
    //   1725: iload 6
    //   1727: iload 7
    //   1729: iload 8
    //   1731: iload 9
    //   1733: invokestatic 905	com/tencent/mm/plugin/report/a/c:e	(ZZZZ)V
    //   1736: new 771	java/lang/StringBuilder
    //   1739: dup
    //   1740: ldc_w 907
    //   1743: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1746: iload 6
    //   1748: invokevirtual 910	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1751: ldc_w 912
    //   1754: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: iload 7
    //   1759: invokevirtual 910	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1762: ldc_w 914
    //   1765: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: iload 8
    //   1770: invokevirtual 910	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1773: ldc_w 916
    //   1776: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: iload 9
    //   1781: invokevirtual 910	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1784: ldc_w 918
    //   1787: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload_1
    //   1792: ldc_w 920
    //   1795: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1798: iconst_0
    //   1799: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1802: putstatic 923	com/tencent/mm/platformtools/z:pBY	Z
    //   1805: aload_1
    //   1806: ldc_w 925
    //   1809: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1812: iconst_0
    //   1813: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1816: putstatic 928	com/tencent/mm/platformtools/z:pBZ	Z
    //   1819: aload_1
    //   1820: ldc_w 930
    //   1823: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1826: iconst_0
    //   1827: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1830: putstatic 933	com/tencent/mm/platformtools/z:pCa	Z
    //   1833: aload_1
    //   1834: ldc_w 935
    //   1837: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1840: iconst_0
    //   1841: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1844: putstatic 938	com/tencent/mm/platformtools/z:pCc	Z
    //   1847: aload_1
    //   1848: ldc_w 940
    //   1851: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1854: iconst_0
    //   1855: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1858: putstatic 943	com/tencent/mm/platformtools/z:pCd	Z
    //   1861: aload_1
    //   1862: ldc_w 945
    //   1865: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1868: ldc_w 791
    //   1871: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1874: putstatic 948	com/tencent/mm/platformtools/z:pCh	Ljava/lang/String;
    //   1877: ldc_w 769
    //   1880: new 771	java/lang/StringBuilder
    //   1883: dup
    //   1884: ldc_w 950
    //   1887: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1890: getstatic 948	com/tencent/mm/platformtools/z:pCh	Ljava/lang/String;
    //   1893: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1899: invokestatic 953	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1902: aload_1
    //   1903: ldc_w 955
    //   1906: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1909: ldc_w 791
    //   1912: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1915: putstatic 958	com/tencent/mm/platformtools/z:pCw	Ljava/lang/String;
    //   1918: aload_1
    //   1919: ldc_w 960
    //   1922: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1925: ldc_w 791
    //   1928: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1931: putstatic 963	com/tencent/mm/platformtools/z:pCx	Ljava/lang/String;
    //   1934: aload_1
    //   1935: ldc_w 965
    //   1938: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1941: ldc_w 791
    //   1944: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1947: putstatic 968	com/tencent/mm/platformtools/z:pCy	Ljava/lang/String;
    //   1950: aload_1
    //   1951: ldc_w 970
    //   1954: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1957: ldc_w 791
    //   1960: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1963: putstatic 973	com/tencent/mm/platformtools/z:pCz	Ljava/lang/String;
    //   1966: aload_1
    //   1967: ldc_w 975
    //   1970: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1973: ldc_w 791
    //   1976: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1979: putstatic 978	com/tencent/mm/platformtools/z:pCA	Ljava/lang/String;
    //   1982: aload_1
    //   1983: ldc_w 980
    //   1986: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1989: iconst_0
    //   1990: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   1993: putstatic 983	com/tencent/mm/platformtools/z:pCB	Z
    //   1996: aload_1
    //   1997: ldc_w 985
    //   2000: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2003: iconst_0
    //   2004: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2007: putstatic 988	com/tencent/mm/platformtools/z:pCC	Z
    //   2010: aload_1
    //   2011: ldc_w 990
    //   2014: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2017: iconst_0
    //   2018: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2021: putstatic 993	com/tencent/mm/platformtools/z:pCD	Z
    //   2024: aload_1
    //   2025: ldc_w 995
    //   2028: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2031: iconst_0
    //   2032: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2035: putstatic 998	com/tencent/mm/platformtools/z:pCF	Z
    //   2038: aload_1
    //   2039: ldc_w 1000
    //   2042: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2045: iconst_0
    //   2046: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2049: putstatic 1003	com/tencent/mm/platformtools/z:pCG	Z
    //   2052: aload_1
    //   2053: ldc_w 1005
    //   2056: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2059: iconst_0
    //   2060: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2063: putstatic 1008	com/tencent/mm/platformtools/z:pCH	Z
    //   2066: aload_1
    //   2067: ldc_w 1010
    //   2070: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2073: iconst_0
    //   2074: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2077: putstatic 1013	com/tencent/mm/platformtools/z:pCP	Z
    //   2080: ldc_w 769
    //   2083: new 771	java/lang/StringBuilder
    //   2086: dup
    //   2087: ldc_w 1015
    //   2090: invokespecial 775	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2093: getstatic 1013	com/tencent/mm/platformtools/z:pCP	Z
    //   2096: invokevirtual 910	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2099: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2102: invokestatic 953	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2105: aload_1
    //   2106: ldc_w 1017
    //   2109: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2112: ldc_w 791
    //   2115: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2118: putstatic 1020	com/tencent/mm/platformtools/z:pCQ	Ljava/lang/String;
    //   2121: aload_1
    //   2122: ldc_w 1022
    //   2125: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2128: ldc_w 687
    //   2131: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2134: iconst_0
    //   2135: invokestatic 691	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   2138: putstatic 1025	com/tencent/mm/platformtools/z:pCR	I
    //   2141: aload_1
    //   2142: ldc_w 1027
    //   2145: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2148: iconst_1
    //   2149: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2152: putstatic 1030	com/tencent/mm/platformtools/z:pCM	Z
    //   2155: aload_1
    //   2156: ldc_w 1032
    //   2159: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2162: iconst_0
    //   2163: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2166: putstatic 1035	com/tencent/mm/platformtools/z:pDx	Z
    //   2169: aload_1
    //   2170: ldc_w 1037
    //   2173: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2176: iconst_0
    //   2177: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2180: putstatic 1040	com/tencent/mm/platformtools/z:pDy	Z
    //   2183: aload_1
    //   2184: ldc_w 1042
    //   2187: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2190: iconst_0
    //   2191: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2194: putstatic 1045	com/tencent/mm/platformtools/z:pDz	Z
    //   2197: aload_1
    //   2198: ldc_w 1047
    //   2201: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2204: iconst_0
    //   2205: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2208: putstatic 1050	com/tencent/mm/platformtools/z:pDf	Z
    //   2211: aload_1
    //   2212: ldc_w 1052
    //   2215: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2218: ldc_w 791
    //   2221: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2224: putstatic 1055	com/tencent/mm/platformtools/z:pDh	Ljava/lang/String;
    //   2227: aload_1
    //   2228: ldc_w 1057
    //   2231: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2234: iconst_0
    //   2235: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2238: putstatic 1060	com/tencent/mm/platformtools/z:pDg	Z
    //   2241: aload_1
    //   2242: ldc_w 1062
    //   2245: invokevirtual 685	com/tencent/mm/booter/x:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2248: ldc_w 791
    //   2251: invokestatic 690	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2254: putstatic 1065	com/tencent/mm/platformtools/z:pDi	Ljava/lang/String;
    //   2257: aload_1
    //   2258: ldc_w 1067
    //   2261: invokevirtual 639	com/tencent/mm/booter/x:Ck	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   2264: iconst_0
    //   2265: invokestatic 643	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Boolean;Z)Z
    //   2268: putstatic 1070	com/tencent/mm/platformtools/z:pDp	Z
    //   2271: invokestatic 1075	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2274: invokestatic 1079	com/tencent/mm/sdk/platformtools/Util:getTopActivity	(Landroid/content/Context;)Landroid/content/ComponentName;
    //   2277: astore_1
    //   2278: aload_1
    //   2279: ifnull +1322 -> 3601
    //   2282: aload_1
    //   2283: invokevirtual 1084	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   2286: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   2289: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2292: ifeq +1309 -> 3601
    //   2295: aload_1
    //   2296: invokevirtual 1092	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   2299: invokestatic 1095	com/tencent/mm/sdk/platformtools/MMApplicationContext:getLaunchName	()Ljava/lang/String;
    //   2302: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2305: ifeq +1296 -> 3601
    //   2308: invokestatic 1101	com/tencent/mm/app/WorkerProfile:aDF	()Lcom/tencent/mm/app/WorkerProfile;
    //   2311: iconst_1
    //   2312: putfield 1104	com/tencent/mm/app/WorkerProfile:hjJ	Z
    //   2315: invokestatic 1101	com/tencent/mm/app/WorkerProfile:aDF	()Lcom/tencent/mm/app/WorkerProfile;
    //   2318: iconst_1
    //   2319: putfield 1107	com/tencent/mm/app/WorkerProfile:hjK	Z
    //   2322: ldc 182
    //   2324: ldc_w 1109
    //   2327: iconst_2
    //   2328: anewarray 186	java/lang/Object
    //   2331: dup
    //   2332: iconst_0
    //   2333: aload_1
    //   2334: invokevirtual 1084	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   2337: aastore
    //   2338: dup
    //   2339: iconst_1
    //   2340: aload_1
    //   2341: invokevirtual 1092	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   2344: aastore
    //   2345: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2348: invokestatic 1115	com/tencent/mm/model/c/b:bEz	()Lcom/tencent/mm/model/c/b;
    //   2351: pop
    //   2352: invokestatic 1118	com/tencent/mm/model/c/b:setup	()V
    //   2355: new 1120	com/tencent/mars/mm/AppCallBack
    //   2358: dup
    //   2359: invokestatic 1075	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2362: invokespecial 1122	com/tencent/mars/mm/AppCallBack:<init>	(Landroid/content/Context;)V
    //   2365: invokestatic 1128	com/tencent/mars/app/AppLogic:setCallBack	(Lcom/tencent/mars/app/AppLogic$ICallBack;)V
    //   2368: new 1130	com/tencent/mm/plugin/report/service/j
    //   2371: dup
    //   2372: invokespecial 1131	com/tencent/mm/plugin/report/service/j:<init>	()V
    //   2375: invokestatic 1136	com/tencent/mars/smc/SmcLogic:setCallBack	(Lcom/tencent/mars/smc/SmcLogic$ICallBack;)V
    //   2378: aload_0
    //   2379: getfield 271	com/tencent/mm/plugin/bbom/PluginBigBallOfMud:mFS	Lcom/tencent/mm/compatible/loader/c;
    //   2382: checkcast 1097	com/tencent/mm/app/WorkerProfile
    //   2385: putstatic 1140	com/tencent/mm/plugin/report/service/j:OAT	Lcom/tencent/mm/plugin/report/service/IKVReportNotify;
    //   2388: aload_0
    //   2389: invokevirtual 1144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2392: invokevirtual 1150	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   2395: pop
    //   2396: ldc_w 1152
    //   2399: invokestatic 1157	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   2402: getstatic 1162	com/tencent/mm/sdk/CommLibFileName:quic	Ljava/lang/String;
    //   2405: astore_1
    //   2406: aload_0
    //   2407: invokevirtual 1144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2410: invokevirtual 1150	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   2413: pop
    //   2414: aload_1
    //   2415: invokestatic 1157	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   2418: aload_0
    //   2419: invokevirtual 1144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2422: invokevirtual 1150	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   2425: pop
    //   2426: ldc_w 1164
    //   2429: invokestatic 1157	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   2432: invokestatic 1167	com/tencent/mars/Mars:onCreate	()V
    //   2435: invokestatic 1170	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   2438: ifeq +6 -> 2444
    //   2441: invokestatic 1171	com/tencent/mars/smc/SmcLogic:onCreate	()V
    //   2444: getstatic 1174	com/tencent/mm/plugin/report/a/c:Ozj	Z
    //   2447: invokestatic 1178	com/tencent/mars/smc/SmcLogic:SetDebugFlag	(Z)V
    //   2450: aload_0
    //   2451: invokevirtual 1144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2454: invokevirtual 1150	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   2457: ifnonnull +1228 -> 3685
    //   2460: iconst_m1
    //   2461: istore_2
    //   2462: invokestatic 1184	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2465: invokevirtual 1187	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   2468: ifnonnull +1231 -> 3699
    //   2471: iconst_m1
    //   2472: istore_3
    //   2473: ldc 182
    //   2475: ldc_w 1189
    //   2478: iconst_2
    //   2479: anewarray 186	java/lang/Object
    //   2482: dup
    //   2483: iconst_0
    //   2484: iload_2
    //   2485: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2488: aastore
    //   2489: dup
    //   2490: iconst_1
    //   2491: iload_3
    //   2492: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2495: aastore
    //   2496: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2499: bipush 20
    //   2501: invokestatic 1195	com/tencent/mm/compatible/util/d:rc	(I)Z
    //   2504: ifeq +15 -> 2519
    //   2507: ldc 182
    //   2509: ldc_w 1197
    //   2512: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2515: lconst_0
    //   2516: invokestatic 1201	com/tencent/mars/smc/SmcLogic:setUin	(J)V
    //   2519: ldc_w 543
    //   2522: invokestatic 159	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2525: checkcast 543	com/tencent/mm/plugin/messenger/foundation/a/v
    //   2528: astore_1
    //   2529: ldc 153
    //   2531: invokestatic 159	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2534: checkcast 153	com/tencent/mm/plugin/zero/a/d
    //   2537: astore 10
    //   2539: new 1203	com/tencent/mm/plugin/h/d
    //   2542: dup
    //   2543: invokespecial 1204	com/tencent/mm/plugin/h/d:<init>	()V
    //   2546: aload_1
    //   2547: invokevirtual 1208	com/tencent/mm/plugin/h/d:after	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2550: aload_0
    //   2551: invokevirtual 1213	com/tencent/mm/kernel/a/c/a:before	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2554: pop
    //   2555: new 1215	com/tencent/mm/plugin/h/b
    //   2558: dup
    //   2559: invokespecial 1216	com/tencent/mm/plugin/h/b:<init>	()V
    //   2562: aload_1
    //   2563: invokevirtual 1217	com/tencent/mm/plugin/h/b:after	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2566: aload_0
    //   2567: invokevirtual 1213	com/tencent/mm/kernel/a/c/a:before	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2570: checkcast 1215	com/tencent/mm/plugin/h/b
    //   2573: astore 11
    //   2575: new 1219	com/tencent/mm/plugin/h/f
    //   2578: dup
    //   2579: invokespecial 1220	com/tencent/mm/plugin/h/f:<init>	()V
    //   2582: aload 11
    //   2584: invokevirtual 1221	com/tencent/mm/plugin/h/f:after	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2587: aload_0
    //   2588: invokevirtual 1213	com/tencent/mm/kernel/a/c/a:before	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2591: pop
    //   2592: new 1223	com/tencent/mm/plugin/h/c
    //   2595: dup
    //   2596: invokespecial 1224	com/tencent/mm/plugin/h/c:<init>	()V
    //   2599: aload_1
    //   2600: invokevirtual 1225	com/tencent/mm/plugin/h/c:after	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2603: aload_0
    //   2604: invokevirtual 1213	com/tencent/mm/kernel/a/c/a:before	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2607: pop
    //   2608: new 1227	com/tencent/mm/plugin/h/a
    //   2611: dup
    //   2612: invokespecial 1228	com/tencent/mm/plugin/h/a:<init>	()V
    //   2615: aload 10
    //   2617: invokevirtual 1229	com/tencent/mm/plugin/h/a:after	(Lcom/tencent/mm/kernel/b/a;)Lcom/tencent/mm/kernel/a/c/a;
    //   2620: pop
    //   2621: invokestatic 1234	com/tencent/mm/br/c:iPd	()V
    //   2624: invokestatic 1239	com/tencent/mm/ui/chatting/floatball/a:fSy	()V
    //   2627: invokestatic 1242	com/tencent/mm/ui/chatting/multitask/b:fSy	()V
    //   2630: ldc_w 1244
    //   2633: invokestatic 159	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2636: checkcast 1244	com/tencent/mm/plugin/multitask/PluginMultiTask
    //   2639: iconst_4
    //   2640: ldc_w 1246
    //   2643: invokevirtual 1250	com/tencent/mm/plugin/multitask/PluginMultiTask:registerMultiTaskUIC	(ILjava/lang/Class;)V
    //   2646: new 30	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$2
    //   2649: dup
    //   2650: aload_0
    //   2651: invokespecial 1251	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$2:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2654: invokestatic 1256	com/tencent/mm/pluginsdk/res/downloader/checkresupdate/m:a	(Lcom/tencent/mm/pluginsdk/res/downloader/checkresupdate/a/a;)V
    //   2657: new 52	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$3
    //   2660: dup
    //   2661: aload_0
    //   2662: invokespecial 1257	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$3:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2665: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2668: new 74	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$4
    //   2671: dup
    //   2672: aload_0
    //   2673: invokespecial 1262	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$4:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2676: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2679: new 78	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$5
    //   2682: dup
    //   2683: aload_0
    //   2684: invokespecial 1263	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$5:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2687: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2690: new 80	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$6
    //   2693: dup
    //   2694: aload_0
    //   2695: invokespecial 1264	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$6:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2698: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2701: new 82	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$7
    //   2704: dup
    //   2705: aload_0
    //   2706: invokespecial 1265	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$7:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2709: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2712: new 84	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$8
    //   2715: dup
    //   2716: aload_0
    //   2717: invokespecial 1266	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$8:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2720: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2723: new 86	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$9
    //   2726: dup
    //   2727: aload_0
    //   2728: invokespecial 1267	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$9:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2731: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2734: new 10	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$10
    //   2737: dup
    //   2738: aload_0
    //   2739: invokespecial 1268	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$10:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2742: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2745: new 12	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$11
    //   2748: dup
    //   2749: aload_0
    //   2750: invokespecial 1269	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$11:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2753: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2756: new 16	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$13
    //   2759: dup
    //   2760: aload_0
    //   2761: invokespecial 1270	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$13:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2764: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2767: new 18	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$14
    //   2770: dup
    //   2771: aload_0
    //   2772: invokespecial 1271	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$14:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2775: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2778: new 20	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$15
    //   2781: dup
    //   2782: aload_0
    //   2783: invokespecial 1272	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$15:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2786: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2789: new 22	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$16
    //   2792: dup
    //   2793: aload_0
    //   2794: invokespecial 1273	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$16:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2797: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2800: new 24	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$17
    //   2803: dup
    //   2804: aload_0
    //   2805: invokespecial 1274	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$17:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2808: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2811: new 26	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$18
    //   2814: dup
    //   2815: aload_0
    //   2816: invokespecial 1275	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$18:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2819: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2822: new 28	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$19
    //   2825: dup
    //   2826: aload_0
    //   2827: invokespecial 1276	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$19:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2830: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2833: new 32	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$20
    //   2836: dup
    //   2837: aload_0
    //   2838: invokespecial 1277	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$20:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2841: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2844: new 34	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$21
    //   2847: dup
    //   2848: aload_0
    //   2849: invokespecial 1278	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$21:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2852: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2855: new 36	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$22
    //   2858: dup
    //   2859: aload_0
    //   2860: invokespecial 1279	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$22:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2863: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2866: new 40	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$24
    //   2869: dup
    //   2870: aload_0
    //   2871: invokespecial 1280	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$24:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2874: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2877: new 42	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$25
    //   2880: dup
    //   2881: aload_0
    //   2882: invokespecial 1281	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$25:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2885: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2888: new 44	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$26
    //   2891: dup
    //   2892: aload_0
    //   2893: invokespecial 1282	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$26:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2896: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2899: new 46	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$27
    //   2902: dup
    //   2903: aload_0
    //   2904: invokespecial 1283	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$27:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2907: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2910: new 48	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$28
    //   2913: dup
    //   2914: aload_0
    //   2915: invokespecial 1284	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$28:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2918: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2921: new 50	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$29
    //   2924: dup
    //   2925: aload_0
    //   2926: invokespecial 1285	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$29:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2929: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2932: new 54	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$30
    //   2935: dup
    //   2936: aload_0
    //   2937: invokespecial 1286	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$30:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2940: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2943: new 56	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$31
    //   2946: dup
    //   2947: aload_0
    //   2948: invokespecial 1287	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$31:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2951: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2954: new 58	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$32
    //   2957: dup
    //   2958: aload_0
    //   2959: invokespecial 1288	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$32:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2962: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2965: new 60	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$33
    //   2968: dup
    //   2969: aload_0
    //   2970: invokespecial 1289	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$33:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;)V
    //   2973: invokestatic 1261	com/tencent/mm/message/k$c:a	(Lcom/tencent/mm/cp/c;)V
    //   2976: new 76	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$40
    //   2979: dup
    //   2980: aload_0
    //   2981: getstatic 1295	com/tencent/mm/app/f:hfK	Lcom/tencent/mm/app/f;
    //   2984: invokespecial 1298	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$40:<init>	(Lcom/tencent/mm/plugin/bbom/PluginBigBallOfMud;Landroidx/lifecycle/q;)V
    //   2987: invokevirtual 1299	com/tencent/mm/plugin/bbom/PluginBigBallOfMud$40:alive	()V
    //   2990: ldc_w 1301
    //   2993: new 1303	com/tencent/mm/modelsimple/d
    //   2996: dup
    //   2997: invokespecial 1304	com/tencent/mm/modelsimple/d:<init>	()V
    //   3000: invokestatic 436	com/tencent/mm/kernel/h:b	(Ljava/lang/Class;Lcom/tencent/mm/kernel/c/a;)V
    //   3003: sipush 22414
    //   3006: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3009: return
    //   3010: aload 11
    //   3012: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3015: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3018: ifeq +34 -> 3052
    //   3021: aload 10
    //   3023: ldc_w 1306
    //   3026: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3029: astore 10
    //   3031: ldc_w 264
    //   3034: ldc_w 1311
    //   3037: iconst_1
    //   3038: anewarray 186	java/lang/Object
    //   3041: dup
    //   3042: iconst_0
    //   3043: aload 11
    //   3045: aastore
    //   3046: invokestatic 1314	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3049: goto -2794 -> 255
    //   3052: aload 11
    //   3054: new 771	java/lang/StringBuilder
    //   3057: dup
    //   3058: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3061: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3064: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3067: ldc_w 1317
    //   3070: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3076: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3079: ifeq +16 -> 3095
    //   3082: aload 10
    //   3084: ldc_w 1319
    //   3087: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3090: astore 10
    //   3092: goto -61 -> 3031
    //   3095: aload 11
    //   3097: new 771	java/lang/StringBuilder
    //   3100: dup
    //   3101: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3104: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3107: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: ldc_w 1321
    //   3113: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3119: invokevirtual 1324	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3122: ifeq +16 -> 3138
    //   3125: aload 10
    //   3127: ldc_w 1326
    //   3130: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3133: astore 10
    //   3135: goto -104 -> 3031
    //   3138: aload 11
    //   3140: new 771	java/lang/StringBuilder
    //   3143: dup
    //   3144: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3147: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3150: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3153: ldc_w 1328
    //   3156: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3159: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3162: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3165: ifeq +16 -> 3181
    //   3168: aload 10
    //   3170: ldc_w 1330
    //   3173: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3176: astore 10
    //   3178: goto -147 -> 3031
    //   3181: aload 11
    //   3183: new 771	java/lang/StringBuilder
    //   3186: dup
    //   3187: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3190: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3193: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3196: ldc_w 1332
    //   3199: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3202: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3205: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3208: ifeq +16 -> 3224
    //   3211: aload 10
    //   3213: ldc_w 1334
    //   3216: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3219: astore 10
    //   3221: goto -190 -> 3031
    //   3224: aload 11
    //   3226: new 771	java/lang/StringBuilder
    //   3229: dup
    //   3230: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3233: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3236: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3239: ldc_w 1336
    //   3242: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3245: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3248: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3251: ifeq +16 -> 3267
    //   3254: aload 10
    //   3256: ldc_w 1338
    //   3259: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3262: astore 10
    //   3264: goto -233 -> 3031
    //   3267: aload 11
    //   3269: new 771	java/lang/StringBuilder
    //   3272: dup
    //   3273: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3276: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3279: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: ldc_w 1340
    //   3285: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3288: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3291: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3294: ifeq +16 -> 3310
    //   3297: aload 10
    //   3299: ldc_w 1342
    //   3302: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3305: astore 10
    //   3307: goto -276 -> 3031
    //   3310: aload 11
    //   3312: new 771	java/lang/StringBuilder
    //   3315: dup
    //   3316: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3319: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3322: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3325: ldc_w 1344
    //   3328: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3331: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3334: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3337: ifeq +16 -> 3353
    //   3340: aload 10
    //   3342: ldc_w 1346
    //   3345: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3348: astore 10
    //   3350: goto -319 -> 3031
    //   3353: aload 11
    //   3355: new 771	java/lang/StringBuilder
    //   3358: dup
    //   3359: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3362: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3365: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3368: ldc_w 1348
    //   3371: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3374: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3377: invokevirtual 1324	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3380: ifeq +16 -> 3396
    //   3383: aload 10
    //   3385: ldc_w 1350
    //   3388: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3391: astore 10
    //   3393: goto -362 -> 3031
    //   3396: aload 11
    //   3398: new 771	java/lang/StringBuilder
    //   3401: dup
    //   3402: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3405: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3408: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3411: ldc_w 1352
    //   3414: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3417: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3420: invokevirtual 1324	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3423: ifeq +16 -> 3439
    //   3426: aload 10
    //   3428: ldc_w 1354
    //   3431: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3434: astore 10
    //   3436: goto -405 -> 3031
    //   3439: aload 11
    //   3441: new 771	java/lang/StringBuilder
    //   3444: dup
    //   3445: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3448: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3451: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: ldc_w 1356
    //   3457: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3463: invokevirtual 1324	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3466: ifeq +16 -> 3482
    //   3469: aload 10
    //   3471: ldc_w 1358
    //   3474: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3477: astore 10
    //   3479: goto -448 -> 3031
    //   3482: aload 11
    //   3484: new 771	java/lang/StringBuilder
    //   3487: dup
    //   3488: invokespecial 1315	java/lang/StringBuilder:<init>	()V
    //   3491: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3494: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: ldc_w 1360
    //   3500: invokevirtual 828	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3503: invokevirtual 782	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3506: invokevirtual 1324	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3509: ifeq +16 -> 3525
    //   3512: aload 10
    //   3514: ldc_w 1362
    //   3517: invokestatic 1309	com/tencent/mm/compatible/loader/d:b	(Landroid/app/Application;Ljava/lang/String;)Lcom/tencent/mm/compatible/loader/c;
    //   3520: astore 10
    //   3522: goto -491 -> 3031
    //   3525: aconst_null
    //   3526: astore 10
    //   3528: goto -3273 -> 255
    //   3531: astore 10
    //   3533: ldc_w 769
    //   3536: ldc_w 1364
    //   3539: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3542: goto -2026 -> 1516
    //   3545: astore 10
    //   3547: ldc_w 769
    //   3550: ldc_w 1364
    //   3553: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3556: goto -1953 -> 1603
    //   3559: astore 10
    //   3561: ldc_w 769
    //   3564: ldc_w 1364
    //   3567: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3570: goto -1919 -> 1651
    //   3573: astore 10
    //   3575: ldc_w 769
    //   3578: ldc_w 1364
    //   3581: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3584: goto -1911 -> 1673
    //   3587: astore 10
    //   3589: ldc_w 769
    //   3592: ldc_w 1364
    //   3595: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3598: goto -1807 -> 1791
    //   3601: aload_1
    //   3602: ifnull +56 -> 3658
    //   3605: ldc 182
    //   3607: ldc_w 1366
    //   3610: iconst_2
    //   3611: anewarray 186	java/lang/Object
    //   3614: dup
    //   3615: iconst_0
    //   3616: aload_1
    //   3617: invokevirtual 1084	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   3620: aastore
    //   3621: dup
    //   3622: iconst_1
    //   3623: aload_1
    //   3624: invokevirtual 1092	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   3627: aastore
    //   3628: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3631: aload_1
    //   3632: ifnull -1284 -> 2348
    //   3635: aload_1
    //   3636: invokevirtual 1084	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   3639: invokestatic 1085	com/tencent/mm/sdk/platformtools/MMApplicationContext:getPackageName	()Ljava/lang/String;
    //   3642: invokevirtual 1089	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3645: ifne -1297 -> 2348
    //   3648: invokestatic 1101	com/tencent/mm/app/WorkerProfile:aDF	()Lcom/tencent/mm/app/WorkerProfile;
    //   3651: iconst_1
    //   3652: putfield 1104	com/tencent/mm/app/WorkerProfile:hjJ	Z
    //   3655: goto -1307 -> 2348
    //   3658: ldc 182
    //   3660: ldc_w 1368
    //   3663: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3666: goto -35 -> 3631
    //   3669: astore_1
    //   3670: invokestatic 1167	com/tencent/mars/Mars:onCreate	()V
    //   3673: invokestatic 1170	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   3676: ifeq -1232 -> 2444
    //   3679: invokestatic 1171	com/tencent/mars/smc/SmcLogic:onCreate	()V
    //   3682: goto -1238 -> 2444
    //   3685: aload_0
    //   3686: invokevirtual 1144	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3689: invokevirtual 1150	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   3692: invokevirtual 1371	java/lang/Object:hashCode	()I
    //   3695: istore_2
    //   3696: goto -1234 -> 2462
    //   3699: invokestatic 1184	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3702: invokevirtual 1187	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   3705: invokevirtual 1371	java/lang/Object:hashCode	()I
    //   3708: istore_3
    //   3709: goto -1236 -> 2473
    //   3712: astore_1
    //   3713: ldc 182
    //   3715: aload_1
    //   3716: ldc_w 791
    //   3719: iconst_0
    //   3720: anewarray 186	java/lang/Object
    //   3723: invokestatic 1375	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3726: goto -1207 -> 2519
    //   3729: iconst_0
    //   3730: istore_2
    //   3731: goto -3382 -> 349
    //   3734: goto -3496 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3737	0	this	PluginBigBallOfMud
    //   0	3737	1	paramg	com.tencent.mm.kernel.b.g
    //   348	3383	2	i	int
    //   2472	1237	3	j	int
    //   160	1487	4	l	long
    //   1684	63	6	bool1	boolean
    //   1697	61	7	bool2	boolean
    //   1710	59	8	bool3	boolean
    //   1723	57	9	bool4	boolean
    //   55	3472	10	localObject1	Object
    //   3531	1	10	localException1	Exception
    //   3545	1	10	localException2	Exception
    //   3559	1	10	localException3	Exception
    //   3573	1	10	localException4	Exception
    //   3587	1	10	localException5	Exception
    //   181	3302	11	localObject2	Object
    //   169	39	12	locald	com.tencent.mm.compatible.loader.d
    //   201	29	13	locala	com.tencent.threadpool.j.a
    // Exception table:
    //   from	to	target	type
    //   1480	1516	3531	java/lang/Exception
    //   1516	1603	3545	java/lang/Exception
    //   1603	1651	3559	java/lang/Exception
    //   1651	1673	3573	java/lang/Exception
    //   1673	1791	3587	java/lang/Exception
    //   2432	2444	3669	finally
    //   2499	2519	3712	finally
  }
  
  public void dependency()
  {
    AppMethodBeat.i(22413);
    if (MMApplicationContext.isMainProcess())
    {
      dependsOn(com.tencent.mm.plugin.auth.a.c.class);
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.v.class);
    }
    AppMethodBeat.o(22413);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed() {}
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(22416);
    if ((aw.aXo()) && (aw.aXj()))
    {
      ao.setForceDarkMode(aw.j(paramConfiguration));
      MMWebView.Nk(aw.j(paramConfiguration));
      if (MMApplicationContext.isMainProcess())
      {
        if (com.tencent.mm.ce.e.i(paramConfiguration))
        {
          Log.i("MicroMsg.PluginBigBallOfMud", "dancy test uiModeChange true, uimode:%s", new Object[] { Integer.valueOf(paramConfiguration.uiMode) });
          com.tencent.mm.plugin.sns.ui.widget.i.resetConfig();
          com.tencent.mm.modelappbrand.a.b.bEY().clearCache();
          if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class) != null)
          {
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).aZq();
            if (com.tencent.mm.kernel.h.baC().aZN())
            {
              localObject = SubCoreVoip.hVq();
              if (((com.tencent.mm.plugin.voip.ui.j)localObject).UKx != null)
              {
                localObject = ((com.tencent.mm.plugin.voip.ui.j)localObject).UKx;
                BaseSmallView localBaseSmallView = ((VoipViewFragment)localObject).UKS;
                if (localBaseSmallView != null) {
                  localBaseSmallView.ghy();
                }
                localObject = ((VoipViewFragment)localObject).UKR;
                if (localObject != null) {
                  ((BaseSmallView)localObject).ghy();
                }
              }
              localObject = ac.ggT().Lvw;
              if (localObject != null) {
                ((m)localObject).ghy();
              }
            }
          }
        }
        com.tencent.mm.ce.e.a(paramConfiguration, aw.isDarkMode());
        if (MMApplicationContext.getContext().getResources() != null) {
          MMApplicationContext.getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
        }
      }
    }
    Object localObject = MMApplicationContext.getResources();
    if ((localObject instanceof com.tencent.mm.ce.d)) {
      ((com.tencent.mm.ce.d)localObject).onConfigurationChanged(paramConfiguration);
    }
    if (this.mFS != null) {
      this.mFS.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(22416);
  }
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate()
  {
    AppMethodBeat.i(22415);
    Log.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { MMApplicationContext.getProcessName() });
    if (this.mFS != null) {
      this.mFS.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.vte;
    Application localApplication = this.app;
    if (localMMAppMgr.adFe != null) {
      localApplication.unregisterReceiver(localMMAppMgr.adFe);
    }
    AppMethodBeat.o(22415);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(22417);
    Log.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), MMApplicationContext.getProcessName() });
    if (this.mFS != null) {
      this.mFS.onTrimMemory(paramInt);
    }
    Object localObject = com.tencent.mm.memory.a.a.b.bwc();
    Log.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
    localObject = ((com.tencent.mm.memory.a.a.b)localObject).nNB.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).bwd();
    }
    AppMethodBeat.o(22417);
  }
  
  public String toString()
  {
    return "plugin-big-ball-of-mud";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud
 * JD-Core Version:    0.7.0.1
 */