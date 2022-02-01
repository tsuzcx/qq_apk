package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.kidswatch.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "deviceName", "", "loginUrl", "okSessionList", "doLoginConfirmGet", "", "finish", "getForceOrientation", "", "getLayoutId", "initView", "isFriendOrChatRoomContact", "", "usr", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchEntranceUI
  extends MMActivity
  implements i
{
  public static final KidsWatchEntranceUI.a yBb;
  private HashMap _$_findViewCache;
  private String dZW;
  private String deviceName;
  private String yBa;
  
  static
  {
    AppMethodBeat.i(256217);
    yBb = new KidsWatchEntranceUI.a((byte)0);
    AppMethodBeat.o(256217);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256219);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256219);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256218);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(256218);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256215);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256215);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495132;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256214);
    Log.i("MicroMsg.KidsWatchEntranceUI", "initView");
    setMMTitle("");
    this.dZW = getIntent().getStringExtra("intent.key.login.url");
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    Object localObject = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    String str = getString(2131762070);
    p.g(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).ebW();
    localObject = (ProgressBar)_$_findCachedViewById(2131306147);
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(0);
    }
    Log.i("MicroMsg.KidsWatchEntranceUI", "doLoginConfirmGet, url:" + this.dZW + ", device:" + this.deviceName);
    g.azz().a(5218, (i)this);
    localObject = new f(this.dZW, this.deviceName);
    g.azz().b((com.tencent.mm.ak.q)localObject);
    AppMethodBeat.o(256214);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256213);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131099846));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(2131099846));
    initView();
    overridePendingTransition(2130772132, 2130771986);
    paramBundle = (ProgressBar)_$_findCachedViewById(2131306147);
    p.g(paramBundle, "processBar");
    paramBundle.setVisibility(0);
    AppMethodBeat.o(256213);
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    // Byte code:
    //   0: ldc_w 280
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 121
    //   8: new 191	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 282
    //   15: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 287
    //   25: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 289
    //   35: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload 4
    //   50: instanceof 219
    //   53: ifeq +1108 -> 1161
    //   56: ldc 121
    //   58: ldc_w 291
    //   61: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: invokestatic 211	com/tencent/mm/kernel/g:azz	()Lcom/tencent/mm/ak/t;
    //   67: sipush 5218
    //   70: aload_0
    //   71: checkcast 6	com/tencent/mm/ak/i
    //   74: invokevirtual 293	com/tencent/mm/ak/t:b	(ILcom/tencent/mm/ak/i;)V
    //   77: aload_0
    //   78: ldc 184
    //   80: invokevirtual 153	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:_$_findCachedViewById	(I)Landroid/view/View;
    //   83: checkcast 186	android/widget/ProgressBar
    //   86: astore 11
    //   88: aload 11
    //   90: ldc_w 276
    //   93: invokestatic 168	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 11
    //   98: iconst_4
    //   99: invokevirtual 189	android/widget/ProgressBar:setVisibility	(I)V
    //   102: iload_1
    //   103: ifne +1030 -> 1133
    //   106: iload_2
    //   107: ifne +1026 -> 1133
    //   110: aload 4
    //   112: checkcast 219	com/tencent/mm/plugin/kidswatch/model/f
    //   115: invokevirtual 297	com/tencent/mm/plugin/kidswatch/model/f:ebU	()Lcom/tencent/mm/protocal/protobuf/cgq;
    //   118: astore 11
    //   120: new 191	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   127: astore 12
    //   129: aconst_null
    //   130: astore_3
    //   131: ldc_w 300
    //   134: invokestatic 304	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   137: astore 4
    //   139: aload 4
    //   141: ldc_w 306
    //   144: invokestatic 168	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   147: aload 4
    //   149: checkcast 300	com/tencent/mm/plugin/messenger/foundation/a/l
    //   152: invokeinterface 310 1 0
    //   157: getstatic 315	com/tencent/mm/model/ab:iCF	Ljava/lang/String;
    //   160: aconst_null
    //   161: getstatic 320	com/tencent/mm/o/a:gNj	Ljava/lang/String;
    //   164: iconst_1
    //   165: invokeinterface 325 5 0
    //   170: astore 4
    //   172: aload 4
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull +274 -> 450
    //   179: aload 11
    //   181: getfield 331	com/tencent/mm/protocal/protobuf/cgq:LtR	I
    //   184: ifne +151 -> 335
    //   187: sipush 200
    //   190: istore_2
    //   191: aload_3
    //   192: ldc_w 333
    //   195: invokeinterface 339 2 0
    //   200: istore 9
    //   202: iconst_0
    //   203: istore 6
    //   205: iconst_0
    //   206: istore 5
    //   208: iload 6
    //   210: iload_2
    //   211: if_icmpge +239 -> 450
    //   214: iload 5
    //   216: aload_3
    //   217: invokeinterface 342 1 0
    //   222: if_icmpge +228 -> 450
    //   225: aload_3
    //   226: iload 5
    //   228: invokeinterface 346 2 0
    //   233: ifeq +217 -> 450
    //   236: aload_3
    //   237: iload 9
    //   239: invokeinterface 347 2 0
    //   244: astore 4
    //   246: aload 4
    //   248: ldc_w 333
    //   251: invokestatic 168	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   254: aload 4
    //   256: invokestatic 353	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   259: ifeq +85 -> 344
    //   262: bipush 8
    //   264: istore_1
    //   265: goto +918 -> 1183
    //   268: iload 6
    //   270: istore_1
    //   271: iload 8
    //   273: iload 7
    //   275: ior
    //   276: ifeq +926 -> 1202
    //   279: iload 6
    //   281: iconst_1
    //   282: iadd
    //   283: istore 6
    //   285: aload 12
    //   287: aload 4
    //   289: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: iload 6
    //   295: istore_1
    //   296: iload 6
    //   298: iload_2
    //   299: iconst_1
    //   300: isub
    //   301: if_icmpge +901 -> 1202
    //   304: iload 6
    //   306: istore_1
    //   307: iload 5
    //   309: aload_3
    //   310: invokeinterface 342 1 0
    //   315: iconst_1
    //   316: isub
    //   317: if_icmpge +885 -> 1202
    //   320: aload 12
    //   322: ldc_w 355
    //   325: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: iload 6
    //   331: istore_1
    //   332: goto +870 -> 1202
    //   335: aload 11
    //   337: getfield 331	com/tencent/mm/protocal/protobuf/cgq:LtR	I
    //   340: istore_2
    //   341: goto -150 -> 191
    //   344: aload 4
    //   346: invokestatic 358	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   349: ifeq +8 -> 357
    //   352: iconst_3
    //   353: istore_1
    //   354: goto +829 -> 1183
    //   357: aload 4
    //   359: invokestatic 361	com/tencent/mm/model/ab:Jx	(Ljava/lang/String;)Z
    //   362: ifeq +8 -> 370
    //   365: iconst_5
    //   366: istore_1
    //   367: goto +816 -> 1183
    //   370: aload 4
    //   372: invokestatic 364	com/tencent/mm/model/ab:JF	(Ljava/lang/String;)Z
    //   375: ifne +839 -> 1214
    //   378: aload 4
    //   380: invokestatic 367	com/tencent/mm/model/ab:IJ	(Ljava/lang/String;)Z
    //   383: ifne +831 -> 1214
    //   386: aload 4
    //   388: invokestatic 370	com/tencent/mm/model/ab:IK	(Ljava/lang/String;)Z
    //   391: ifne +823 -> 1214
    //   394: aload 4
    //   396: invokestatic 373	com/tencent/mm/model/ab:IL	(Ljava/lang/String;)Z
    //   399: ifeq +6 -> 405
    //   402: goto +812 -> 1214
    //   405: aload 4
    //   407: invokestatic 376	com/tencent/mm/model/ab:JC	(Ljava/lang/String;)Z
    //   410: ifeq +9 -> 419
    //   413: bipush 6
    //   415: istore_1
    //   416: goto +767 -> 1183
    //   419: aload 4
    //   421: ldc_w 378
    //   424: iconst_0
    //   425: invokestatic 384	kotlin/n/n:J	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   428: ifeq +9 -> 437
    //   431: bipush 7
    //   433: istore_1
    //   434: goto +749 -> 1183
    //   437: aload 4
    //   439: invokestatic 387	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   442: ifeq +777 -> 1219
    //   445: iconst_2
    //   446: istore_1
    //   447: goto +736 -> 1183
    //   450: aload_0
    //   451: aload 12
    //   453: iconst_0
    //   454: aload 12
    //   456: invokevirtual 390	java/lang/StringBuilder:length	()I
    //   459: iconst_1
    //   460: isub
    //   461: invokevirtual 394	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   464: invokevirtual 397	java/lang/String:toString	()Ljava/lang/String;
    //   467: putfield 399	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:yBa	Ljava/lang/String;
    //   470: ldc 121
    //   472: new 191	java/lang/StringBuilder
    //   475: dup
    //   476: ldc_w 401
    //   479: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload_0
    //   483: getfield 399	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:yBa	Ljava/lang/String;
    //   486: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc_w 403
    //   492: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 11
    //   497: getfield 406	com/tencent/mm/protocal/protobuf/cgq:MlX	I
    //   500: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 409	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload 11
    //   511: getfield 413	com/tencent/mm/protocal/protobuf/cgq:MlW	Ljava/util/LinkedList;
    //   514: invokevirtual 418	java/util/LinkedList:size	()I
    //   517: ifle +338 -> 855
    //   520: ldc 121
    //   522: new 191	java/lang/StringBuilder
    //   525: dup
    //   526: ldc_w 420
    //   529: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload 11
    //   534: getfield 413	com/tencent/mm/protocal/protobuf/cgq:MlW	Ljava/util/LinkedList;
    //   537: invokevirtual 418	java/util/LinkedList:size	()I
    //   540: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_0
    //   550: invokevirtual 421	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   553: new 140	android/content/Intent
    //   556: dup
    //   557: invokespecial 422	android/content/Intent:<init>	()V
    //   560: astore 4
    //   562: aload 4
    //   564: ldc 138
    //   566: aload_0
    //   567: getfield 146	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:dZW	Ljava/lang/String;
    //   570: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   573: pop
    //   574: aload 4
    //   576: ldc 148
    //   578: aload_0
    //   579: getfield 150	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   582: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   585: pop
    //   586: aload 4
    //   588: ldc_w 428
    //   591: aload_0
    //   592: getfield 399	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:yBa	Ljava/lang/String;
    //   595: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   598: pop
    //   599: aload 11
    //   601: getfield 406	com/tencent/mm/protocal/protobuf/cgq:MlX	I
    //   604: iconst_1
    //   605: if_icmpne +631 -> 1236
    //   608: iconst_1
    //   609: istore 10
    //   611: aload 4
    //   613: ldc_w 430
    //   616: iload 10
    //   618: invokevirtual 433	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   621: pop
    //   622: new 435	java/util/ArrayList
    //   625: dup
    //   626: invokespecial 436	java/util/ArrayList:<init>	()V
    //   629: astore 12
    //   631: aload 11
    //   633: getfield 413	com/tencent/mm/protocal/protobuf/cgq:MlW	Ljava/util/LinkedList;
    //   636: invokevirtual 418	java/util/LinkedList:size	()I
    //   639: istore_2
    //   640: iconst_0
    //   641: istore_1
    //   642: iload_1
    //   643: iload_2
    //   644: if_icmpge +62 -> 706
    //   647: aload 11
    //   649: getfield 413	com/tencent/mm/protocal/protobuf/cgq:MlW	Ljava/util/LinkedList;
    //   652: iload_1
    //   653: invokevirtual 439	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   656: checkcast 441	com/tencent/mm/protocal/protobuf/cgm
    //   659: astore 13
    //   661: aload 12
    //   663: new 443	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   666: dup
    //   667: aload 13
    //   669: getfield 446	com/tencent/mm/protocal/protobuf/cgm:UserName	Ljava/lang/String;
    //   672: aload 13
    //   674: getfield 449	com/tencent/mm/protocal/protobuf/cgm:oUJ	Ljava/lang/String;
    //   677: aload 13
    //   679: getfield 452	com/tencent/mm/protocal/protobuf/cgm:xJE	Ljava/lang/String;
    //   682: aload 13
    //   684: getfield 455	com/tencent/mm/protocal/protobuf/cgm:oTI	Ljava/lang/String;
    //   687: aload 13
    //   689: getfield 458	com/tencent/mm/protocal/protobuf/cgm:MlV	I
    //   692: invokespecial 461	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   695: invokevirtual 465	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   698: pop
    //   699: iload_1
    //   700: iconst_1
    //   701: iadd
    //   702: istore_1
    //   703: goto -61 -> 642
    //   706: new 467	android/os/Bundle
    //   709: dup
    //   710: invokespecial 468	android/os/Bundle:<init>	()V
    //   713: astore 11
    //   715: aload 11
    //   717: ldc_w 470
    //   720: aload 12
    //   722: invokevirtual 474	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   725: aload 4
    //   727: aload 11
    //   729: invokevirtual 478	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   732: pop
    //   733: aload 4
    //   735: ldc_w 479
    //   738: invokevirtual 483	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   741: pop
    //   742: aload 4
    //   744: invokestatic 488	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   747: ldc_w 490
    //   750: invokevirtual 494	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   753: pop
    //   754: invokestatic 488	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   757: astore 11
    //   759: new 496	com/tencent/mm/hellhoundlib/b/a
    //   762: dup
    //   763: invokespecial 497	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   766: aload 4
    //   768: invokevirtual 501	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   771: astore 4
    //   773: aload 11
    //   775: aload 4
    //   777: invokevirtual 505	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   780: ldc_w 506
    //   783: ldc_w 507
    //   786: ldc_w 509
    //   789: ldc_w 511
    //   792: ldc_w 513
    //   795: ldc_w 515
    //   798: invokestatic 520	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   801: aload 11
    //   803: aload 4
    //   805: iconst_0
    //   806: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   809: checkcast 140	android/content/Intent
    //   812: invokevirtual 527	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   815: aload 11
    //   817: ldc_w 506
    //   820: ldc_w 507
    //   823: ldc_w 509
    //   826: ldc_w 511
    //   829: ldc_w 513
    //   832: ldc_w 515
    //   835: invokestatic 530	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   838: aload_3
    //   839: ifnull +257 -> 1096
    //   842: aload_3
    //   843: invokeinterface 533 1 0
    //   848: ldc_w 280
    //   851: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: return
    //   855: ldc 121
    //   857: ldc_w 535
    //   860: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   863: aload_0
    //   864: invokevirtual 421	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   867: new 140	android/content/Intent
    //   870: dup
    //   871: invokespecial 422	android/content/Intent:<init>	()V
    //   874: astore 4
    //   876: aload 4
    //   878: ldc 138
    //   880: aload_0
    //   881: getfield 146	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:dZW	Ljava/lang/String;
    //   884: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   887: pop
    //   888: aload 4
    //   890: ldc 148
    //   892: aload_0
    //   893: getfield 150	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   896: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   899: pop
    //   900: aload 4
    //   902: ldc_w 428
    //   905: aload_0
    //   906: getfield 399	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:yBa	Ljava/lang/String;
    //   909: invokevirtual 426	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   912: pop
    //   913: aload 11
    //   915: getfield 406	com/tencent/mm/protocal/protobuf/cgq:MlX	I
    //   918: iconst_1
    //   919: if_icmpne +171 -> 1090
    //   922: iconst_1
    //   923: istore 10
    //   925: aload 4
    //   927: ldc_w 430
    //   930: iload 10
    //   932: invokevirtual 433	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   935: pop
    //   936: aload 4
    //   938: ldc_w 537
    //   941: iconst_1
    //   942: invokevirtual 540	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   945: pop
    //   946: aload 4
    //   948: ldc_w 479
    //   951: invokevirtual 483	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   954: pop
    //   955: aload 4
    //   957: invokestatic 488	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   960: ldc_w 542
    //   963: invokevirtual 494	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   966: pop
    //   967: invokestatic 488	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   970: astore 11
    //   972: new 496	com/tencent/mm/hellhoundlib/b/a
    //   975: dup
    //   976: invokespecial 497	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   979: aload 4
    //   981: invokevirtual 501	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   984: astore 4
    //   986: aload 11
    //   988: aload 4
    //   990: invokevirtual 505	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   993: ldc_w 506
    //   996: ldc_w 507
    //   999: ldc_w 509
    //   1002: ldc_w 511
    //   1005: ldc_w 513
    //   1008: ldc_w 515
    //   1011: invokestatic 520	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1014: aload 11
    //   1016: aload 4
    //   1018: iconst_0
    //   1019: invokevirtual 523	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   1022: checkcast 140	android/content/Intent
    //   1025: invokevirtual 527	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1028: aload 11
    //   1030: ldc_w 506
    //   1033: ldc_w 507
    //   1036: ldc_w 509
    //   1039: ldc_w 511
    //   1042: ldc_w 513
    //   1045: ldc_w 515
    //   1048: invokestatic 530	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1051: goto -213 -> 838
    //   1054: astore 4
    //   1056: ldc 121
    //   1058: aload 4
    //   1060: checkcast 544	java/lang/Throwable
    //   1063: ldc_w 546
    //   1066: iconst_0
    //   1067: anewarray 548	java/lang/Object
    //   1070: invokestatic 552	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aload_3
    //   1074: ifnull +29 -> 1103
    //   1077: aload_3
    //   1078: invokeinterface 533 1 0
    //   1083: ldc_w 280
    //   1086: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1089: return
    //   1090: iconst_0
    //   1091: istore 10
    //   1093: goto -168 -> 925
    //   1096: ldc_w 280
    //   1099: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1102: return
    //   1103: ldc_w 280
    //   1106: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1109: return
    //   1110: astore 4
    //   1112: aconst_null
    //   1113: astore_3
    //   1114: aload_3
    //   1115: ifnull +9 -> 1124
    //   1118: aload_3
    //   1119: invokeinterface 533 1 0
    //   1124: ldc_w 280
    //   1127: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1130: aload 4
    //   1132: athrow
    //   1133: getstatic 558	com/tencent/mm/plugin/kidswatch/b/a:yBL	Lcom/tencent/mm/plugin/kidswatch/b/a;
    //   1136: astore 4
    //   1138: aload_0
    //   1139: invokevirtual 250	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   1142: astore 4
    //   1144: aload 4
    //   1146: ldc 252
    //   1148: invokestatic 168	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1151: aload 4
    //   1153: checkcast 525	android/content/Context
    //   1156: iload_2
    //   1157: aload_3
    //   1158: invokestatic 562	com/tencent/mm/plugin/kidswatch/b/a:c	(Landroid/content/Context;ILjava/lang/String;)V
    //   1161: ldc_w 280
    //   1164: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1167: return
    //   1168: astore 4
    //   1170: goto -56 -> 1114
    //   1173: astore 4
    //   1175: goto -61 -> 1114
    //   1178: astore 4
    //   1180: goto -124 -> 1056
    //   1183: iconst_1
    //   1184: iload_1
    //   1185: if_icmpne +39 -> 1224
    //   1188: iconst_1
    //   1189: istore 7
    //   1191: iconst_2
    //   1192: iload_1
    //   1193: if_icmpne +37 -> 1230
    //   1196: iconst_1
    //   1197: istore 8
    //   1199: goto -931 -> 268
    //   1202: iload 5
    //   1204: iconst_1
    //   1205: iadd
    //   1206: istore 5
    //   1208: iload_1
    //   1209: istore 6
    //   1211: goto -1003 -> 208
    //   1214: iconst_4
    //   1215: istore_1
    //   1216: goto -33 -> 1183
    //   1219: iconst_1
    //   1220: istore_1
    //   1221: goto -38 -> 1183
    //   1224: iconst_0
    //   1225: istore 7
    //   1227: goto -36 -> 1191
    //   1230: iconst_0
    //   1231: istore 8
    //   1233: goto -965 -> 268
    //   1236: iconst_0
    //   1237: istore 10
    //   1239: goto -628 -> 611
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1242	0	this	KidsWatchEntranceUI
    //   0	1242	1	paramInt1	int
    //   0	1242	2	paramInt2	int
    //   0	1242	3	paramString	String
    //   0	1242	4	paramq	com.tencent.mm.ak.q
    //   206	1001	5	i	int
    //   203	1007	6	j	int
    //   273	953	7	k	int
    //   271	961	8	m	int
    //   200	38	9	n	int
    //   609	629	10	bool	boolean
    //   86	943	11	localObject1	Object
    //   127	594	12	localObject2	Object
    //   659	29	13	localcgm	com.tencent.mm.protocal.protobuf.cgm
    // Exception table:
    //   from	to	target	type
    //   179	187	1054	java/lang/Exception
    //   191	202	1054	java/lang/Exception
    //   214	262	1054	java/lang/Exception
    //   285	293	1054	java/lang/Exception
    //   307	329	1054	java/lang/Exception
    //   335	341	1054	java/lang/Exception
    //   344	352	1054	java/lang/Exception
    //   357	365	1054	java/lang/Exception
    //   370	402	1054	java/lang/Exception
    //   405	413	1054	java/lang/Exception
    //   419	431	1054	java/lang/Exception
    //   437	445	1054	java/lang/Exception
    //   450	608	1054	java/lang/Exception
    //   611	640	1054	java/lang/Exception
    //   647	699	1054	java/lang/Exception
    //   706	838	1054	java/lang/Exception
    //   855	922	1054	java/lang/Exception
    //   925	1051	1054	java/lang/Exception
    //   131	172	1110	finally
    //   179	187	1168	finally
    //   191	202	1168	finally
    //   214	262	1168	finally
    //   285	293	1168	finally
    //   307	329	1168	finally
    //   335	341	1168	finally
    //   344	352	1168	finally
    //   357	365	1168	finally
    //   370	402	1168	finally
    //   405	413	1168	finally
    //   419	431	1168	finally
    //   437	445	1168	finally
    //   450	608	1168	finally
    //   611	640	1168	finally
    //   647	699	1168	finally
    //   706	838	1168	finally
    //   855	922	1168	finally
    //   925	1051	1168	finally
    //   1056	1073	1173	finally
    //   131	172	1178	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
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