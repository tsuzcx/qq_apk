package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "deviceName", "", "loginUrl", "okSessionList", "doLoginConfirmGet", "", "finish", "getForceOrientation", "", "getLayoutId", "initView", "isFriendOrChatRoomContact", "", "usr", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchEntranceUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static final KidsWatchEntranceUI.a JTt;
  private String JTu;
  private String deviceName;
  private String hZO;
  
  static
  {
    AppMethodBeat.i(262190);
    JTt = new KidsWatchEntranceUI.a((byte)0);
    AppMethodBeat.o(262190);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262232);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(262232);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSq;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262219);
    Log.i("MicroMsg.KidsWatchEntranceUI", "initView");
    setMMTitle("");
    this.hZO = getIntent().getStringExtra("intent.key.login.url");
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    Object localObject = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    String str = getString(b.h.JSG);
    kotlin.g.b.s.s(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).fSR();
    localObject = (ProgressBar)findViewById(b.e.JSg);
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(0);
    }
    Log.i("MicroMsg.KidsWatchEntranceUI", "doLoginConfirmGet, url:" + this.hZO + ", device:" + this.deviceName);
    com.tencent.mm.kernel.h.aZW().a(5218, (com.tencent.mm.am.h)this);
    localObject = new e(this.hZO, this.deviceName);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(262219);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262202);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(b.b.JRx));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    ((ProgressBar)findViewById(b.e.JSg)).setVisibility(0);
    AppMethodBeat.o(262202);
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 100
    //   8: new 182	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 278
    //   15: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 283
    //   25: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 285
    //   35: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload 4
    //   50: instanceof 213
    //   53: ifeq +2190 -> 2243
    //   56: ldc 100
    //   58: ldc_w 287
    //   61: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: invokestatic 205	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   67: sipush 5218
    //   70: aload_0
    //   71: checkcast 6	com/tencent/mm/am/h
    //   74: invokevirtual 290	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   77: aload_0
    //   78: getstatic 175	com/tencent/mm/plugin/kidswatch/b$e:JSg	I
    //   81: invokevirtual 138	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:findViewById	(I)Landroid/view/View;
    //   84: checkcast 177	android/widget/ProgressBar
    //   87: iconst_4
    //   88: invokevirtual 180	android/widget/ProgressBar:setVisibility	(I)V
    //   91: iload_1
    //   92: ifne +2122 -> 2214
    //   95: iload_2
    //   96: ifne +2118 -> 2214
    //   99: aload 4
    //   101: checkcast 213	com/tencent/mm/plugin/kidswatch/model/e
    //   104: getfield 294	com/tencent/mm/plugin/kidswatch/model/e:oDw	Lcom/tencent/mm/am/c;
    //   107: getfield 300	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
    //   110: invokestatic 305	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
    //   113: checkcast 307	com/tencent/mm/protocal/protobuf/dgg
    //   116: astore 12
    //   118: new 182	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   125: astore 11
    //   127: aconst_null
    //   128: astore_3
    //   129: ldc_w 310
    //   132: invokestatic 314	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   135: checkcast 310	com/tencent/mm/plugin/messenger/foundation/a/n
    //   138: invokeinterface 318 1 0
    //   143: aconst_null
    //   144: getstatic 323	com/tencent/mm/l/a:maX	Ljava/lang/String;
    //   147: iconst_1
    //   148: invokeinterface 329 4 0
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +328 -> 485
    //   160: aload 4
    //   162: astore_3
    //   163: aload 12
    //   165: getfield 332	com/tencent/mm/protocal/protobuf/dgg:ZwC	I
    //   168: ifne +183 -> 351
    //   171: sipush 200
    //   174: istore_2
    //   175: aload 4
    //   177: astore_3
    //   178: aload 4
    //   180: ldc_w 334
    //   183: invokeinterface 340 2 0
    //   188: istore 9
    //   190: iconst_0
    //   191: istore 6
    //   193: iconst_0
    //   194: istore 5
    //   196: iload 6
    //   198: iload_2
    //   199: if_icmpge +286 -> 485
    //   202: aload 4
    //   204: astore_3
    //   205: iload 5
    //   207: aload 4
    //   209: invokeinterface 343 1 0
    //   214: if_icmpge +271 -> 485
    //   217: aload 4
    //   219: astore_3
    //   220: aload 4
    //   222: iload 5
    //   224: invokeinterface 347 2 0
    //   229: ifeq +256 -> 485
    //   232: aload 4
    //   234: astore_3
    //   235: aload 4
    //   237: iload 9
    //   239: invokeinterface 348 2 0
    //   244: astore 13
    //   246: aload 4
    //   248: astore_3
    //   249: aload 13
    //   251: ldc_w 334
    //   254: invokestatic 157	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   257: aload 4
    //   259: astore_3
    //   260: aload 13
    //   262: invokestatic 354	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   265: ifeq +98 -> 363
    //   268: bipush 8
    //   270: istore_1
    //   271: goto +2011 -> 2282
    //   274: iload 6
    //   276: istore_1
    //   277: iload 8
    //   279: iload 7
    //   281: ior
    //   282: ifeq +2019 -> 2301
    //   285: iload 6
    //   287: iconst_1
    //   288: iadd
    //   289: istore 6
    //   291: aload 4
    //   293: astore_3
    //   294: aload 11
    //   296: aload 13
    //   298: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: iload 6
    //   304: istore_1
    //   305: iload 6
    //   307: iload_2
    //   308: iconst_1
    //   309: isub
    //   310: if_icmpge +1991 -> 2301
    //   313: aload 4
    //   315: astore_3
    //   316: iload 6
    //   318: istore_1
    //   319: iload 5
    //   321: aload 4
    //   323: invokeinterface 343 1 0
    //   328: iconst_1
    //   329: isub
    //   330: if_icmpge +1971 -> 2301
    //   333: aload 4
    //   335: astore_3
    //   336: aload 11
    //   338: ldc_w 356
    //   341: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: iload 6
    //   347: istore_1
    //   348: goto +1953 -> 2301
    //   351: aload 4
    //   353: astore_3
    //   354: aload 12
    //   356: getfield 332	com/tencent/mm/protocal/protobuf/dgg:ZwC	I
    //   359: istore_2
    //   360: goto -185 -> 175
    //   363: aload 4
    //   365: astore_3
    //   366: aload 13
    //   368: invokestatic 361	com/tencent/mm/storage/au:bwp	(Ljava/lang/String;)Z
    //   371: ifeq +8 -> 379
    //   374: iconst_3
    //   375: istore_1
    //   376: goto +1906 -> 2282
    //   379: aload 4
    //   381: astore_3
    //   382: aload 13
    //   384: invokestatic 364	com/tencent/mm/storage/au:bwu	(Ljava/lang/String;)Z
    //   387: ifeq +8 -> 395
    //   390: iconst_5
    //   391: istore_1
    //   392: goto +1890 -> 2282
    //   395: aload 4
    //   397: astore_3
    //   398: aload 13
    //   400: invokestatic 369	com/tencent/mm/model/ab:IW	(Ljava/lang/String;)Z
    //   403: ifne +1910 -> 2313
    //   406: aload 4
    //   408: astore_3
    //   409: aload 13
    //   411: invokestatic 372	com/tencent/mm/storage/au:bxe	(Ljava/lang/String;)Z
    //   414: ifne +1899 -> 2313
    //   417: aload 4
    //   419: astore_3
    //   420: aload 13
    //   422: invokestatic 375	com/tencent/mm/storage/au:bxj	(Ljava/lang/String;)Z
    //   425: ifeq +6 -> 431
    //   428: goto +1885 -> 2313
    //   431: aload 4
    //   433: astore_3
    //   434: aload 13
    //   436: invokestatic 378	com/tencent/mm/storage/au:bwA	(Ljava/lang/String;)Z
    //   439: ifeq +9 -> 448
    //   442: bipush 6
    //   444: istore_1
    //   445: goto +1837 -> 2282
    //   448: aload 4
    //   450: astore_3
    //   451: aload 13
    //   453: ldc_w 380
    //   456: iconst_0
    //   457: invokestatic 386	kotlin/n/n:U	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   460: ifeq +9 -> 469
    //   463: bipush 7
    //   465: istore_1
    //   466: goto +1816 -> 2282
    //   469: aload 4
    //   471: astore_3
    //   472: aload 13
    //   474: invokestatic 389	com/tencent/mm/storage/au:bwE	(Ljava/lang/String;)Z
    //   477: ifeq +1841 -> 2318
    //   480: iconst_2
    //   481: istore_1
    //   482: goto +1800 -> 2282
    //   485: aload 4
    //   487: astore_3
    //   488: aload 11
    //   490: checkcast 391	java/lang/CharSequence
    //   493: invokeinterface 394 1 0
    //   498: ifle +412 -> 910
    //   501: iconst_1
    //   502: istore_1
    //   503: iload_1
    //   504: ifeq +411 -> 915
    //   507: aload 4
    //   509: astore_3
    //   510: aload 11
    //   512: iconst_0
    //   513: aload 11
    //   515: invokevirtual 395	java/lang/StringBuilder:length	()I
    //   518: invokevirtual 399	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   521: invokevirtual 402	java/lang/String:toString	()Ljava/lang/String;
    //   524: astore 11
    //   526: aload 4
    //   528: astore_3
    //   529: aload_0
    //   530: aload 11
    //   532: putfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   535: aload 4
    //   537: astore_3
    //   538: ldc 100
    //   540: new 182	java/lang/StringBuilder
    //   543: dup
    //   544: ldc_w 406
    //   547: invokespecial 186	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   550: aload_0
    //   551: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   554: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: ldc_w 408
    //   560: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 12
    //   565: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   568: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 413	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload 4
    //   579: ifnull +10 -> 589
    //   582: aload 4
    //   584: invokeinterface 416 1 0
    //   589: aload 12
    //   591: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   594: invokevirtual 425	java/util/LinkedList:size	()I
    //   597: ifle +331 -> 928
    //   600: ldc 100
    //   602: ldc_w 427
    //   605: aload 12
    //   607: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   610: invokevirtual 425	java/util/LinkedList:size	()I
    //   613: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: invokestatic 437	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   619: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: aload_0
    //   623: invokevirtual 438	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   626: new 119	android/content/Intent
    //   629: dup
    //   630: invokespecial 439	android/content/Intent:<init>	()V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc 117
    //   637: aload_0
    //   638: getfield 125	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:hZO	Ljava/lang/String;
    //   641: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   644: pop
    //   645: aload_3
    //   646: ldc 127
    //   648: aload_0
    //   649: getfield 129	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   652: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   655: pop
    //   656: aload_3
    //   657: ldc_w 445
    //   660: aload_0
    //   661: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   664: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   667: pop
    //   668: aload 12
    //   670: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   673: iconst_1
    //   674: if_icmpne +248 -> 922
    //   677: iconst_1
    //   678: istore 10
    //   680: aload_3
    //   681: ldc_w 447
    //   684: iload 10
    //   686: invokevirtual 450	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   689: pop
    //   690: new 452	java/util/ArrayList
    //   693: dup
    //   694: invokespecial 453	java/util/ArrayList:<init>	()V
    //   697: astore 4
    //   699: iconst_0
    //   700: istore_1
    //   701: aload 12
    //   703: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   706: invokevirtual 425	java/util/LinkedList:size	()I
    //   709: istore 5
    //   711: iload 5
    //   713: ifle +65 -> 778
    //   716: iload_1
    //   717: iconst_1
    //   718: iadd
    //   719: istore_2
    //   720: aload 12
    //   722: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   725: iload_1
    //   726: invokevirtual 457	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   729: checkcast 459	com/tencent/mm/protocal/protobuf/dgc
    //   732: astore 11
    //   734: aload 4
    //   736: new 461	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   739: dup
    //   740: aload 11
    //   742: getfield 464	com/tencent/mm/protocal/protobuf/dgc:UserName	Ljava/lang/String;
    //   745: aload 11
    //   747: getfield 467	com/tencent/mm/protocal/protobuf/dgc:vhX	Ljava/lang/String;
    //   750: aload 11
    //   752: getfield 470	com/tencent/mm/protocal/protobuf/dgc:IHW	Ljava/lang/String;
    //   755: aload 11
    //   757: getfield 473	com/tencent/mm/protocal/protobuf/dgc:vgW	Ljava/lang/String;
    //   760: aload 11
    //   762: getfield 476	com/tencent/mm/protocal/protobuf/dgc:aaLw	I
    //   765: invokespecial 479	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   768: invokevirtual 483	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   771: pop
    //   772: iload_2
    //   773: iload 5
    //   775: if_icmplt +1502 -> 2277
    //   778: new 485	android/os/Bundle
    //   781: dup
    //   782: invokespecial 486	android/os/Bundle:<init>	()V
    //   785: astore 11
    //   787: aload 11
    //   789: ldc_w 488
    //   792: aload 4
    //   794: invokevirtual 492	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   797: aload_3
    //   798: aload 11
    //   800: invokevirtual 496	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   803: pop
    //   804: aload_3
    //   805: ldc_w 497
    //   808: invokevirtual 501	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   811: pop
    //   812: aload_3
    //   813: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   816: ldc_w 508
    //   819: invokevirtual 512	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   822: pop
    //   823: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   826: astore 4
    //   828: new 514	com/tencent/mm/hellhoundlib/b/a
    //   831: dup
    //   832: invokespecial 515	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   835: aload_3
    //   836: invokevirtual 519	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   839: astore_3
    //   840: aload 4
    //   842: aload_3
    //   843: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   846: ldc_w 524
    //   849: ldc_w 525
    //   852: ldc_w 527
    //   855: ldc_w 529
    //   858: ldc_w 531
    //   861: ldc_w 533
    //   864: invokestatic 538	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload 4
    //   869: aload_3
    //   870: iconst_0
    //   871: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   874: checkcast 119	android/content/Intent
    //   877: invokevirtual 545	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   880: aload 4
    //   882: ldc_w 524
    //   885: ldc_w 525
    //   888: ldc_w 527
    //   891: ldc_w 529
    //   894: ldc_w 531
    //   897: ldc_w 533
    //   900: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   903: ldc_w 276
    //   906: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   909: return
    //   910: iconst_0
    //   911: istore_1
    //   912: goto -409 -> 503
    //   915: ldc 107
    //   917: astore 11
    //   919: goto -393 -> 526
    //   922: iconst_0
    //   923: istore 10
    //   925: goto -245 -> 680
    //   928: ldc 100
    //   930: ldc_w 551
    //   933: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: aload_0
    //   937: invokevirtual 438	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   940: new 119	android/content/Intent
    //   943: dup
    //   944: invokespecial 439	android/content/Intent:<init>	()V
    //   947: astore_3
    //   948: aload_3
    //   949: ldc 117
    //   951: aload_0
    //   952: getfield 125	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:hZO	Ljava/lang/String;
    //   955: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   958: pop
    //   959: aload_3
    //   960: ldc 127
    //   962: aload_0
    //   963: getfield 129	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   966: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   969: pop
    //   970: aload_3
    //   971: ldc_w 445
    //   974: aload_0
    //   975: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   978: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   981: pop
    //   982: aload 12
    //   984: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   987: iconst_1
    //   988: if_icmpne +131 -> 1119
    //   991: iconst_1
    //   992: istore 10
    //   994: aload_3
    //   995: ldc_w 447
    //   998: iload 10
    //   1000: invokevirtual 450	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1003: pop
    //   1004: aload_3
    //   1005: ldc_w 553
    //   1008: iconst_1
    //   1009: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1012: pop
    //   1013: aload_3
    //   1014: ldc_w 497
    //   1017: invokevirtual 501	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1020: pop
    //   1021: aload_3
    //   1022: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1025: ldc_w 558
    //   1028: invokevirtual 512	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1031: pop
    //   1032: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1035: astore 4
    //   1037: new 514	com/tencent/mm/hellhoundlib/b/a
    //   1040: dup
    //   1041: invokespecial 515	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1044: aload_3
    //   1045: invokevirtual 519	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1048: astore_3
    //   1049: aload 4
    //   1051: aload_3
    //   1052: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1055: ldc_w 524
    //   1058: ldc_w 525
    //   1061: ldc_w 527
    //   1064: ldc_w 529
    //   1067: ldc_w 531
    //   1070: ldc_w 533
    //   1073: invokestatic 538	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1076: aload 4
    //   1078: aload_3
    //   1079: iconst_0
    //   1080: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   1083: checkcast 119	android/content/Intent
    //   1086: invokevirtual 545	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1089: aload 4
    //   1091: ldc_w 524
    //   1094: ldc_w 525
    //   1097: ldc_w 527
    //   1100: ldc_w 529
    //   1103: ldc_w 531
    //   1106: ldc_w 533
    //   1109: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1112: ldc_w 276
    //   1115: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1118: return
    //   1119: iconst_0
    //   1120: istore 10
    //   1122: goto -128 -> 994
    //   1125: astore 4
    //   1127: aconst_null
    //   1128: astore_3
    //   1129: ldc 100
    //   1131: aload 4
    //   1133: checkcast 560	java/lang/Throwable
    //   1136: ldc_w 562
    //   1139: iconst_0
    //   1140: anewarray 564	java/lang/Object
    //   1143: invokestatic 568	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1146: aload_3
    //   1147: ifnull +9 -> 1156
    //   1150: aload_3
    //   1151: invokeinterface 416 1 0
    //   1156: aload 12
    //   1158: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1161: invokevirtual 425	java/util/LinkedList:size	()I
    //   1164: ifle +319 -> 1483
    //   1167: ldc 100
    //   1169: ldc_w 427
    //   1172: aload 12
    //   1174: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1177: invokevirtual 425	java/util/LinkedList:size	()I
    //   1180: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1183: invokestatic 437	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1186: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1189: aload_0
    //   1190: invokevirtual 438	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   1193: new 119	android/content/Intent
    //   1196: dup
    //   1197: invokespecial 439	android/content/Intent:<init>	()V
    //   1200: astore_3
    //   1201: aload_3
    //   1202: ldc 117
    //   1204: aload_0
    //   1205: getfield 125	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:hZO	Ljava/lang/String;
    //   1208: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1211: pop
    //   1212: aload_3
    //   1213: ldc 127
    //   1215: aload_0
    //   1216: getfield 129	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1219: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1222: pop
    //   1223: aload_3
    //   1224: ldc_w 445
    //   1227: aload_0
    //   1228: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   1231: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1234: pop
    //   1235: aload 12
    //   1237: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   1240: iconst_1
    //   1241: if_icmpne +236 -> 1477
    //   1244: iconst_1
    //   1245: istore 10
    //   1247: aload_3
    //   1248: ldc_w 447
    //   1251: iload 10
    //   1253: invokevirtual 450	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1256: pop
    //   1257: new 452	java/util/ArrayList
    //   1260: dup
    //   1261: invokespecial 453	java/util/ArrayList:<init>	()V
    //   1264: astore 4
    //   1266: iconst_0
    //   1267: istore_1
    //   1268: aload 12
    //   1270: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1273: invokevirtual 425	java/util/LinkedList:size	()I
    //   1276: istore 5
    //   1278: iload 5
    //   1280: ifle +65 -> 1345
    //   1283: iload_1
    //   1284: iconst_1
    //   1285: iadd
    //   1286: istore_2
    //   1287: aload 12
    //   1289: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1292: iload_1
    //   1293: invokevirtual 457	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   1296: checkcast 459	com/tencent/mm/protocal/protobuf/dgc
    //   1299: astore 11
    //   1301: aload 4
    //   1303: new 461	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   1306: dup
    //   1307: aload 11
    //   1309: getfield 464	com/tencent/mm/protocal/protobuf/dgc:UserName	Ljava/lang/String;
    //   1312: aload 11
    //   1314: getfield 467	com/tencent/mm/protocal/protobuf/dgc:vhX	Ljava/lang/String;
    //   1317: aload 11
    //   1319: getfield 470	com/tencent/mm/protocal/protobuf/dgc:IHW	Ljava/lang/String;
    //   1322: aload 11
    //   1324: getfield 473	com/tencent/mm/protocal/protobuf/dgc:vgW	Ljava/lang/String;
    //   1327: aload 11
    //   1329: getfield 476	com/tencent/mm/protocal/protobuf/dgc:aaLw	I
    //   1332: invokespecial 479	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1335: invokevirtual 483	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1338: pop
    //   1339: iload_2
    //   1340: iload 5
    //   1342: if_icmplt +930 -> 2272
    //   1345: new 485	android/os/Bundle
    //   1348: dup
    //   1349: invokespecial 486	android/os/Bundle:<init>	()V
    //   1352: astore 11
    //   1354: aload 11
    //   1356: ldc_w 488
    //   1359: aload 4
    //   1361: invokevirtual 492	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1364: aload_3
    //   1365: aload 11
    //   1367: invokevirtual 496	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1370: pop
    //   1371: aload_3
    //   1372: ldc_w 497
    //   1375: invokevirtual 501	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1378: pop
    //   1379: aload_3
    //   1380: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1383: ldc_w 508
    //   1386: invokevirtual 512	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1389: pop
    //   1390: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1393: astore 4
    //   1395: new 514	com/tencent/mm/hellhoundlib/b/a
    //   1398: dup
    //   1399: invokespecial 515	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1402: aload_3
    //   1403: invokevirtual 519	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1406: astore_3
    //   1407: aload 4
    //   1409: aload_3
    //   1410: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1413: ldc_w 524
    //   1416: ldc_w 525
    //   1419: ldc_w 527
    //   1422: ldc_w 529
    //   1425: ldc_w 531
    //   1428: ldc_w 533
    //   1431: invokestatic 538	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1434: aload 4
    //   1436: aload_3
    //   1437: iconst_0
    //   1438: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   1441: checkcast 119	android/content/Intent
    //   1444: invokevirtual 545	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1447: aload 4
    //   1449: ldc_w 524
    //   1452: ldc_w 525
    //   1455: ldc_w 527
    //   1458: ldc_w 529
    //   1461: ldc_w 531
    //   1464: ldc_w 533
    //   1467: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1470: ldc_w 276
    //   1473: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1476: return
    //   1477: iconst_0
    //   1478: istore 10
    //   1480: goto -233 -> 1247
    //   1483: ldc 100
    //   1485: ldc_w 551
    //   1488: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1491: aload_0
    //   1492: invokevirtual 438	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   1495: new 119	android/content/Intent
    //   1498: dup
    //   1499: invokespecial 439	android/content/Intent:<init>	()V
    //   1502: astore_3
    //   1503: aload_3
    //   1504: ldc 117
    //   1506: aload_0
    //   1507: getfield 125	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:hZO	Ljava/lang/String;
    //   1510: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1513: pop
    //   1514: aload_3
    //   1515: ldc 127
    //   1517: aload_0
    //   1518: getfield 129	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1521: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1524: pop
    //   1525: aload_3
    //   1526: ldc_w 445
    //   1529: aload_0
    //   1530: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   1533: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1536: pop
    //   1537: aload 12
    //   1539: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   1542: iconst_1
    //   1543: if_icmpne +131 -> 1674
    //   1546: iconst_1
    //   1547: istore 10
    //   1549: aload_3
    //   1550: ldc_w 447
    //   1553: iload 10
    //   1555: invokevirtual 450	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1558: pop
    //   1559: aload_3
    //   1560: ldc_w 553
    //   1563: iconst_1
    //   1564: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1567: pop
    //   1568: aload_3
    //   1569: ldc_w 497
    //   1572: invokevirtual 501	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1575: pop
    //   1576: aload_3
    //   1577: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1580: ldc_w 558
    //   1583: invokevirtual 512	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1586: pop
    //   1587: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1590: astore 4
    //   1592: new 514	com/tencent/mm/hellhoundlib/b/a
    //   1595: dup
    //   1596: invokespecial 515	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1599: aload_3
    //   1600: invokevirtual 519	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1603: astore_3
    //   1604: aload 4
    //   1606: aload_3
    //   1607: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1610: ldc_w 524
    //   1613: ldc_w 525
    //   1616: ldc_w 527
    //   1619: ldc_w 529
    //   1622: ldc_w 531
    //   1625: ldc_w 533
    //   1628: invokestatic 538	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1631: aload 4
    //   1633: aload_3
    //   1634: iconst_0
    //   1635: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   1638: checkcast 119	android/content/Intent
    //   1641: invokevirtual 545	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1644: aload 4
    //   1646: ldc_w 524
    //   1649: ldc_w 525
    //   1652: ldc_w 527
    //   1655: ldc_w 529
    //   1658: ldc_w 531
    //   1661: ldc_w 533
    //   1664: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1667: ldc_w 276
    //   1670: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1673: return
    //   1674: iconst_0
    //   1675: istore 10
    //   1677: goto -128 -> 1549
    //   1680: astore 4
    //   1682: aload_3
    //   1683: ifnull +9 -> 1692
    //   1686: aload_3
    //   1687: invokeinterface 416 1 0
    //   1692: aload 12
    //   1694: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1697: invokevirtual 425	java/util/LinkedList:size	()I
    //   1700: ifle +321 -> 2021
    //   1703: ldc 100
    //   1705: ldc_w 427
    //   1708: aload 12
    //   1710: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1713: invokevirtual 425	java/util/LinkedList:size	()I
    //   1716: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1719: invokestatic 437	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1722: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1725: aload_0
    //   1726: invokevirtual 438	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   1729: new 119	android/content/Intent
    //   1732: dup
    //   1733: invokespecial 439	android/content/Intent:<init>	()V
    //   1736: astore_3
    //   1737: aload_3
    //   1738: ldc 117
    //   1740: aload_0
    //   1741: getfield 125	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:hZO	Ljava/lang/String;
    //   1744: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1747: pop
    //   1748: aload_3
    //   1749: ldc 127
    //   1751: aload_0
    //   1752: getfield 129	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1755: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1758: pop
    //   1759: aload_3
    //   1760: ldc_w 445
    //   1763: aload_0
    //   1764: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   1767: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1770: pop
    //   1771: aload 12
    //   1773: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   1776: iconst_1
    //   1777: if_icmpne +238 -> 2015
    //   1780: iconst_1
    //   1781: istore 10
    //   1783: aload_3
    //   1784: ldc_w 447
    //   1787: iload 10
    //   1789: invokevirtual 450	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1792: pop
    //   1793: new 452	java/util/ArrayList
    //   1796: dup
    //   1797: invokespecial 453	java/util/ArrayList:<init>	()V
    //   1800: astore 11
    //   1802: iconst_0
    //   1803: istore_1
    //   1804: aload 12
    //   1806: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1809: invokevirtual 425	java/util/LinkedList:size	()I
    //   1812: istore 5
    //   1814: iload 5
    //   1816: ifle +65 -> 1881
    //   1819: iload_1
    //   1820: iconst_1
    //   1821: iadd
    //   1822: istore_2
    //   1823: aload 12
    //   1825: getfield 420	com/tencent/mm/protocal/protobuf/dgg:aaLx	Ljava/util/LinkedList;
    //   1828: iload_1
    //   1829: invokevirtual 457	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   1832: checkcast 459	com/tencent/mm/protocal/protobuf/dgc
    //   1835: astore 13
    //   1837: aload 11
    //   1839: new 461	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   1842: dup
    //   1843: aload 13
    //   1845: getfield 464	com/tencent/mm/protocal/protobuf/dgc:UserName	Ljava/lang/String;
    //   1848: aload 13
    //   1850: getfield 467	com/tencent/mm/protocal/protobuf/dgc:vhX	Ljava/lang/String;
    //   1853: aload 13
    //   1855: getfield 470	com/tencent/mm/protocal/protobuf/dgc:IHW	Ljava/lang/String;
    //   1858: aload 13
    //   1860: getfield 473	com/tencent/mm/protocal/protobuf/dgc:vgW	Ljava/lang/String;
    //   1863: aload 13
    //   1865: getfield 476	com/tencent/mm/protocal/protobuf/dgc:aaLw	I
    //   1868: invokespecial 479	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1871: invokevirtual 483	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1874: pop
    //   1875: iload_2
    //   1876: iload 5
    //   1878: if_icmplt +389 -> 2267
    //   1881: new 485	android/os/Bundle
    //   1884: dup
    //   1885: invokespecial 486	android/os/Bundle:<init>	()V
    //   1888: astore 12
    //   1890: aload 12
    //   1892: ldc_w 488
    //   1895: aload 11
    //   1897: invokevirtual 492	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1900: aload_3
    //   1901: aload 12
    //   1903: invokevirtual 496	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1906: pop
    //   1907: aload_3
    //   1908: ldc_w 497
    //   1911: invokevirtual 501	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1914: pop
    //   1915: aload_3
    //   1916: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1919: ldc_w 508
    //   1922: invokevirtual 512	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1925: pop
    //   1926: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1929: astore 11
    //   1931: new 514	com/tencent/mm/hellhoundlib/b/a
    //   1934: dup
    //   1935: invokespecial 515	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1938: aload_3
    //   1939: invokevirtual 519	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1942: astore_3
    //   1943: aload 11
    //   1945: aload_3
    //   1946: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   1949: ldc_w 524
    //   1952: ldc_w 525
    //   1955: ldc_w 527
    //   1958: ldc_w 529
    //   1961: ldc_w 531
    //   1964: ldc_w 533
    //   1967: invokestatic 538	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1970: aload 11
    //   1972: aload_3
    //   1973: iconst_0
    //   1974: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   1977: checkcast 119	android/content/Intent
    //   1980: invokevirtual 545	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1983: aload 11
    //   1985: ldc_w 524
    //   1988: ldc_w 525
    //   1991: ldc_w 527
    //   1994: ldc_w 529
    //   1997: ldc_w 531
    //   2000: ldc_w 533
    //   2003: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2006: ldc_w 276
    //   2009: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2012: aload 4
    //   2014: athrow
    //   2015: iconst_0
    //   2016: istore 10
    //   2018: goto -235 -> 1783
    //   2021: ldc 100
    //   2023: ldc_w 551
    //   2026: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2029: aload_0
    //   2030: invokevirtual 438	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   2033: new 119	android/content/Intent
    //   2036: dup
    //   2037: invokespecial 439	android/content/Intent:<init>	()V
    //   2040: astore_3
    //   2041: aload_3
    //   2042: ldc 117
    //   2044: aload_0
    //   2045: getfield 125	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:hZO	Ljava/lang/String;
    //   2048: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2051: pop
    //   2052: aload_3
    //   2053: ldc 127
    //   2055: aload_0
    //   2056: getfield 129	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   2059: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2062: pop
    //   2063: aload_3
    //   2064: ldc_w 445
    //   2067: aload_0
    //   2068: getfield 404	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:JTu	Ljava/lang/String;
    //   2071: invokevirtual 443	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2074: pop
    //   2075: aload 12
    //   2077: getfield 411	com/tencent/mm/protocal/protobuf/dgg:aaLy	I
    //   2080: iconst_1
    //   2081: if_icmpne +127 -> 2208
    //   2084: iconst_1
    //   2085: istore 10
    //   2087: aload_3
    //   2088: ldc_w 447
    //   2091: iload 10
    //   2093: invokevirtual 450	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2096: pop
    //   2097: aload_3
    //   2098: ldc_w 553
    //   2101: iconst_1
    //   2102: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2105: pop
    //   2106: aload_3
    //   2107: ldc_w 497
    //   2110: invokevirtual 501	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   2113: pop
    //   2114: aload_3
    //   2115: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2118: ldc_w 558
    //   2121: invokevirtual 512	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   2124: pop
    //   2125: invokestatic 506	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2128: astore 11
    //   2130: new 514	com/tencent/mm/hellhoundlib/b/a
    //   2133: dup
    //   2134: invokespecial 515	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2137: aload_3
    //   2138: invokevirtual 519	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2141: astore_3
    //   2142: aload 11
    //   2144: aload_3
    //   2145: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   2148: ldc_w 524
    //   2151: ldc_w 525
    //   2154: ldc_w 527
    //   2157: ldc_w 529
    //   2160: ldc_w 531
    //   2163: ldc_w 533
    //   2166: invokestatic 538	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2169: aload 11
    //   2171: aload_3
    //   2172: iconst_0
    //   2173: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   2176: checkcast 119	android/content/Intent
    //   2179: invokevirtual 545	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2182: aload 11
    //   2184: ldc_w 524
    //   2187: ldc_w 525
    //   2190: ldc_w 527
    //   2193: ldc_w 529
    //   2196: ldc_w 531
    //   2199: ldc_w 533
    //   2202: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2205: goto -199 -> 2006
    //   2208: iconst_0
    //   2209: istore 10
    //   2211: goto -124 -> 2087
    //   2214: getstatic 574	com/tencent/mm/plugin/kidswatch/b/a:JTW	Lcom/tencent/mm/plugin/kidswatch/b/a;
    //   2217: astore 4
    //   2219: aload_0
    //   2220: invokevirtual 244	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   2223: astore 4
    //   2225: aload 4
    //   2227: ldc_w 576
    //   2230: invokestatic 157	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2233: aload 4
    //   2235: checkcast 543	android/content/Context
    //   2238: iload_2
    //   2239: aload_3
    //   2240: invokestatic 579	com/tencent/mm/plugin/kidswatch/b/a:i	(Landroid/content/Context;ILjava/lang/String;)V
    //   2243: ldc_w 276
    //   2246: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2249: return
    //   2250: astore 4
    //   2252: goto -570 -> 1682
    //   2255: astore 11
    //   2257: aload 4
    //   2259: astore_3
    //   2260: aload 11
    //   2262: astore 4
    //   2264: goto -1135 -> 1129
    //   2267: iload_2
    //   2268: istore_1
    //   2269: goto -450 -> 1819
    //   2272: iload_2
    //   2273: istore_1
    //   2274: goto -991 -> 1283
    //   2277: iload_2
    //   2278: istore_1
    //   2279: goto -1563 -> 716
    //   2282: iconst_1
    //   2283: iload_1
    //   2284: if_icmpne +39 -> 2323
    //   2287: iconst_1
    //   2288: istore 7
    //   2290: iconst_2
    //   2291: iload_1
    //   2292: if_icmpne +37 -> 2329
    //   2295: iconst_1
    //   2296: istore 8
    //   2298: goto -2024 -> 274
    //   2301: iload 5
    //   2303: iconst_1
    //   2304: iadd
    //   2305: istore 5
    //   2307: iload_1
    //   2308: istore 6
    //   2310: goto -2114 -> 196
    //   2313: iconst_4
    //   2314: istore_1
    //   2315: goto -33 -> 2282
    //   2318: iconst_1
    //   2319: istore_1
    //   2320: goto -38 -> 2282
    //   2323: iconst_0
    //   2324: istore 7
    //   2326: goto -36 -> 2290
    //   2329: iconst_0
    //   2330: istore 8
    //   2332: goto -2058 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2335	0	this	KidsWatchEntranceUI
    //   0	2335	1	paramInt1	int
    //   0	2335	2	paramInt2	int
    //   0	2335	3	paramString	String
    //   0	2335	4	paramp	p
    //   194	2112	5	i	int
    //   191	2118	6	j	int
    //   279	2046	7	k	int
    //   277	2054	8	m	int
    //   188	50	9	n	int
    //   678	1532	10	bool	boolean
    //   125	2058	11	localObject1	Object
    //   2255	6	11	localException	java.lang.Exception
    //   116	1960	12	localObject2	Object
    //   244	1620	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   129	155	1125	java/lang/Exception
    //   129	155	1680	finally
    //   163	171	1680	finally
    //   178	190	1680	finally
    //   205	217	1680	finally
    //   220	232	1680	finally
    //   235	246	1680	finally
    //   249	257	1680	finally
    //   260	268	1680	finally
    //   294	302	1680	finally
    //   319	333	1680	finally
    //   336	345	1680	finally
    //   354	360	1680	finally
    //   366	374	1680	finally
    //   382	390	1680	finally
    //   398	406	1680	finally
    //   409	417	1680	finally
    //   420	428	1680	finally
    //   434	442	1680	finally
    //   451	463	1680	finally
    //   472	480	1680	finally
    //   488	501	1680	finally
    //   510	526	1680	finally
    //   529	535	1680	finally
    //   538	577	1680	finally
    //   1129	1146	2250	finally
    //   163	171	2255	java/lang/Exception
    //   178	190	2255	java/lang/Exception
    //   205	217	2255	java/lang/Exception
    //   220	232	2255	java/lang/Exception
    //   235	246	2255	java/lang/Exception
    //   249	257	2255	java/lang/Exception
    //   260	268	2255	java/lang/Exception
    //   294	302	2255	java/lang/Exception
    //   319	333	2255	java/lang/Exception
    //   336	345	2255	java/lang/Exception
    //   354	360	2255	java/lang/Exception
    //   366	374	2255	java/lang/Exception
    //   382	390	2255	java/lang/Exception
    //   398	406	2255	java/lang/Exception
    //   409	417	2255	java/lang/Exception
    //   420	428	2255	java/lang/Exception
    //   434	442	2255	java/lang/Exception
    //   451	463	2255	java/lang/Exception
    //   472	480	2255	java/lang/Exception
    //   488	501	2255	java/lang/Exception
    //   510	526	2255	java/lang/Exception
    //   529	535	2255	java/lang/Exception
    //   538	577	2255	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(KidsWatchEntranceUI paramKidsWatchEntranceUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchEntranceUI
 * JD-Core Version:    0.7.0.1
 */