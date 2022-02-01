package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "deviceName", "", "loginUrl", "okSessionList", "doLoginConfirmGet", "", "finish", "getForceOrientation", "", "getLayoutId", "initView", "isFriendOrChatRoomContact", "", "usr", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchEntranceUI
  extends MMActivity
  implements i
{
  public static final KidsWatchEntranceUI.a Ecq;
  private String Ecp;
  private HashMap _$_findViewCache;
  private String deviceName;
  private String fTQ;
  
  static
  {
    AppMethodBeat.i(252040);
    Ecq = new KidsWatchEntranceUI.a((byte)0);
    AppMethodBeat.o(252040);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252042);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252042);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252041);
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
    AppMethodBeat.o(252041);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252031);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(252031);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebi;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252029);
    Log.i("MicroMsg.KidsWatchEntranceUI", "initView");
    setMMTitle("");
    this.fTQ = getIntent().getStringExtra("intent.key.login.url");
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    Object localObject = (KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG);
    String str = getString(b.h.Eby);
    p.j(str, "getString(R.string.kids_…ogin_enter_loading_title)");
    ((KidsWatchHeadComponent)localObject).setTitle(str);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).eKU();
    localObject = (ProgressBar)_$_findCachedViewById(b.e.EaY);
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(0);
    }
    Log.i("MicroMsg.KidsWatchEntranceUI", "doLoginConfirmGet, url:" + this.fTQ + ", device:" + this.deviceName);
    h.aGY().a(5218, (i)this);
    localObject = new f(this.fTQ, this.deviceName);
    h.aGY().b((com.tencent.mm.an.q)localObject);
    AppMethodBeat.o(252029);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252026);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.Eap));
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(b.b.Eap));
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    paramBundle = (ProgressBar)_$_findCachedViewById(b.e.EaY);
    p.j(paramBundle, "processBar");
    paramBundle.setVisibility(0);
    AppMethodBeat.o(252026);
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    // Byte code:
    //   0: ldc_w 307
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 132
    //   8: new 212	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 309
    //   15: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 314
    //   25: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 316
    //   35: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload 4
    //   50: instanceof 240
    //   53: ifeq +2246 -> 2299
    //   56: ldc 132
    //   58: ldc_w 318
    //   61: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: invokestatic 232	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   67: sipush 5218
    //   70: aload_0
    //   71: checkcast 6	com/tencent/mm/an/i
    //   74: invokevirtual 320	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
    //   77: aload_0
    //   78: getstatic 205	com/tencent/mm/plugin/kidswatch/b$e:EaY	I
    //   81: invokevirtual 168	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:_$_findCachedViewById	(I)Landroid/view/View;
    //   84: checkcast 207	android/widget/ProgressBar
    //   87: astore 11
    //   89: aload 11
    //   91: ldc_w 303
    //   94: invokestatic 187	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   97: aload 11
    //   99: iconst_4
    //   100: invokevirtual 210	android/widget/ProgressBar:setVisibility	(I)V
    //   103: iload_1
    //   104: ifne +2166 -> 2270
    //   107: iload_2
    //   108: ifne +2162 -> 2270
    //   111: aload 4
    //   113: checkcast 240	com/tencent/mm/plugin/kidswatch/model/f
    //   116: invokevirtual 324	com/tencent/mm/plugin/kidswatch/model/f:eKS	()Lcom/tencent/mm/protocal/protobuf/cpm;
    //   119: astore 12
    //   121: new 212	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   128: astore 11
    //   130: aconst_null
    //   131: astore 4
    //   133: aload 4
    //   135: astore_3
    //   136: ldc_w 327
    //   139: invokestatic 331	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   142: astore 13
    //   144: aload 4
    //   146: astore_3
    //   147: aload 13
    //   149: ldc_w 333
    //   152: invokestatic 187	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   155: aload 4
    //   157: astore_3
    //   158: aload 13
    //   160: checkcast 327	com/tencent/mm/plugin/messenger/foundation/a/n
    //   163: invokeinterface 337 1 0
    //   168: aconst_null
    //   169: getstatic 342	com/tencent/mm/o/a:jxD	Ljava/lang/String;
    //   172: iconst_1
    //   173: invokeinterface 348 4 0
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +350 -> 532
    //   185: aload 4
    //   187: astore_3
    //   188: aload 12
    //   190: getfield 353	com/tencent/mm/protocal/protobuf/cpm:Swo	I
    //   193: ifne +183 -> 376
    //   196: sipush 200
    //   199: istore_2
    //   200: aload 4
    //   202: astore_3
    //   203: aload 4
    //   205: ldc_w 355
    //   208: invokeinterface 361 2 0
    //   213: istore 9
    //   215: iconst_0
    //   216: istore 6
    //   218: iconst_0
    //   219: istore 5
    //   221: iload 6
    //   223: iload_2
    //   224: if_icmpge +308 -> 532
    //   227: aload 4
    //   229: astore_3
    //   230: iload 5
    //   232: aload 4
    //   234: invokeinterface 364 1 0
    //   239: if_icmpge +293 -> 532
    //   242: aload 4
    //   244: astore_3
    //   245: aload 4
    //   247: iload 5
    //   249: invokeinterface 368 2 0
    //   254: ifeq +278 -> 532
    //   257: aload 4
    //   259: astore_3
    //   260: aload 4
    //   262: iload 9
    //   264: invokeinterface 369 2 0
    //   269: astore 13
    //   271: aload 4
    //   273: astore_3
    //   274: aload 13
    //   276: ldc_w 355
    //   279: invokestatic 187	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   282: aload 4
    //   284: astore_3
    //   285: aload 13
    //   287: invokestatic 375	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   290: ifeq +98 -> 388
    //   293: bipush 8
    //   295: istore_1
    //   296: goto +2027 -> 2323
    //   299: iload 6
    //   301: istore_1
    //   302: iload 8
    //   304: iload 7
    //   306: ior
    //   307: ifeq +2035 -> 2342
    //   310: iload 6
    //   312: iconst_1
    //   313: iadd
    //   314: istore 6
    //   316: aload 4
    //   318: astore_3
    //   319: aload 11
    //   321: aload 13
    //   323: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: iload 6
    //   329: istore_1
    //   330: iload 6
    //   332: iload_2
    //   333: iconst_1
    //   334: isub
    //   335: if_icmpge +2007 -> 2342
    //   338: aload 4
    //   340: astore_3
    //   341: iload 6
    //   343: istore_1
    //   344: iload 5
    //   346: aload 4
    //   348: invokeinterface 364 1 0
    //   353: iconst_1
    //   354: isub
    //   355: if_icmpge +1987 -> 2342
    //   358: aload 4
    //   360: astore_3
    //   361: aload 11
    //   363: ldc_w 377
    //   366: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: iload 6
    //   372: istore_1
    //   373: goto +1969 -> 2342
    //   376: aload 4
    //   378: astore_3
    //   379: aload 12
    //   381: getfield 353	com/tencent/mm/protocal/protobuf/cpm:Swo	I
    //   384: istore_2
    //   385: goto -185 -> 200
    //   388: aload 4
    //   390: astore_3
    //   391: aload 13
    //   393: invokestatic 382	com/tencent/mm/model/ab:QL	(Ljava/lang/String;)Z
    //   396: ifeq +8 -> 404
    //   399: iconst_3
    //   400: istore_1
    //   401: goto +1922 -> 2323
    //   404: aload 4
    //   406: astore_3
    //   407: aload 13
    //   409: invokestatic 385	com/tencent/mm/model/ab:QQ	(Ljava/lang/String;)Z
    //   412: ifeq +8 -> 420
    //   415: iconst_5
    //   416: istore_1
    //   417: goto +1906 -> 2323
    //   420: aload 4
    //   422: astore_3
    //   423: aload 13
    //   425: invokestatic 388	com/tencent/mm/model/ab:QY	(Ljava/lang/String;)Z
    //   428: ifne +1926 -> 2354
    //   431: aload 4
    //   433: astore_3
    //   434: aload 13
    //   436: invokestatic 391	com/tencent/mm/model/ab:Qb	(Ljava/lang/String;)Z
    //   439: ifne +1915 -> 2354
    //   442: aload 4
    //   444: astore_3
    //   445: aload 13
    //   447: invokestatic 394	com/tencent/mm/model/ab:Qc	(Ljava/lang/String;)Z
    //   450: ifne +1904 -> 2354
    //   453: aload 4
    //   455: astore_3
    //   456: aload 13
    //   458: invokestatic 397	com/tencent/mm/model/ab:Qe	(Ljava/lang/String;)Z
    //   461: ifne +1893 -> 2354
    //   464: aload 4
    //   466: astore_3
    //   467: aload 13
    //   469: invokestatic 400	com/tencent/mm/model/ab:Qd	(Ljava/lang/String;)Z
    //   472: ifeq +6 -> 478
    //   475: goto +1879 -> 2354
    //   478: aload 4
    //   480: astore_3
    //   481: aload 13
    //   483: invokestatic 403	com/tencent/mm/model/ab:QV	(Ljava/lang/String;)Z
    //   486: ifeq +9 -> 495
    //   489: bipush 6
    //   491: istore_1
    //   492: goto +1831 -> 2323
    //   495: aload 4
    //   497: astore_3
    //   498: aload 13
    //   500: ldc_w 405
    //   503: iconst_0
    //   504: invokestatic 411	kotlin/n/n:M	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   507: ifeq +9 -> 516
    //   510: bipush 7
    //   512: istore_1
    //   513: goto +1810 -> 2323
    //   516: aload 4
    //   518: astore_3
    //   519: aload 13
    //   521: invokestatic 414	com/tencent/mm/model/ab:Lj	(Ljava/lang/String;)Z
    //   524: ifeq +1835 -> 2359
    //   527: iconst_2
    //   528: istore_1
    //   529: goto +1794 -> 2323
    //   532: aload 4
    //   534: astore_3
    //   535: aload 11
    //   537: checkcast 416	java/lang/CharSequence
    //   540: invokeinterface 419 1 0
    //   545: ifle +283 -> 828
    //   548: iconst_1
    //   549: istore_1
    //   550: iload_1
    //   551: ifeq +282 -> 833
    //   554: aload 4
    //   556: astore_3
    //   557: aload 11
    //   559: iconst_0
    //   560: aload 11
    //   562: invokevirtual 420	java/lang/StringBuilder:length	()I
    //   565: invokevirtual 424	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   568: invokevirtual 427	java/lang/String:toString	()Ljava/lang/String;
    //   571: astore 11
    //   573: aload 4
    //   575: astore_3
    //   576: aload_0
    //   577: aload 11
    //   579: putfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   582: aload 4
    //   584: astore_3
    //   585: ldc 132
    //   587: new 212	java/lang/StringBuilder
    //   590: dup
    //   591: ldc_w 431
    //   594: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   597: aload_0
    //   598: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   601: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 433
    //   607: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 12
    //   612: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   615: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 4
    //   626: ifnull +10 -> 636
    //   629: aload 4
    //   631: invokeinterface 441 1 0
    //   636: aload 12
    //   638: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   641: invokevirtual 450	java/util/LinkedList:size	()I
    //   644: ifle +334 -> 978
    //   647: ldc 132
    //   649: new 212	java/lang/StringBuilder
    //   652: dup
    //   653: ldc_w 452
    //   656: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   659: aload 12
    //   661: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   664: invokevirtual 450	java/util/LinkedList:size	()I
    //   667: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload_0
    //   677: invokevirtual 453	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   680: new 151	android/content/Intent
    //   683: dup
    //   684: invokespecial 454	android/content/Intent:<init>	()V
    //   687: astore_3
    //   688: aload_3
    //   689: ldc 149
    //   691: aload_0
    //   692: getfield 157	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:fTQ	Ljava/lang/String;
    //   695: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   698: pop
    //   699: aload_3
    //   700: ldc 159
    //   702: aload_0
    //   703: getfield 161	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   706: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   709: pop
    //   710: aload_3
    //   711: ldc_w 460
    //   714: aload_0
    //   715: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   718: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   721: pop
    //   722: aload 12
    //   724: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   727: iconst_1
    //   728: if_icmpne +112 -> 840
    //   731: iconst_1
    //   732: istore 10
    //   734: aload_3
    //   735: ldc_w 462
    //   738: iload 10
    //   740: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   743: pop
    //   744: new 467	java/util/ArrayList
    //   747: dup
    //   748: invokespecial 468	java/util/ArrayList:<init>	()V
    //   751: astore 4
    //   753: aload 12
    //   755: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   758: invokevirtual 450	java/util/LinkedList:size	()I
    //   761: istore_2
    //   762: iconst_0
    //   763: istore_1
    //   764: iload_1
    //   765: iload_2
    //   766: if_icmpge +80 -> 846
    //   769: aload 12
    //   771: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   774: iload_1
    //   775: invokevirtual 471	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   778: checkcast 473	com/tencent/mm/protocal/protobuf/cpi
    //   781: astore 11
    //   783: aload 4
    //   785: new 475	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   788: dup
    //   789: aload 11
    //   791: getfield 478	com/tencent/mm/protocal/protobuf/cpi:UserName	Ljava/lang/String;
    //   794: aload 11
    //   796: getfield 481	com/tencent/mm/protocal/protobuf/cpi:rWI	Ljava/lang/String;
    //   799: aload 11
    //   801: getfield 484	com/tencent/mm/protocal/protobuf/cpi:CNM	Ljava/lang/String;
    //   804: aload 11
    //   806: getfield 487	com/tencent/mm/protocal/protobuf/cpi:rVG	Ljava/lang/String;
    //   809: aload 11
    //   811: getfield 490	com/tencent/mm/protocal/protobuf/cpi:TwP	I
    //   814: invokespecial 493	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   817: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   820: pop
    //   821: iload_1
    //   822: iconst_1
    //   823: iadd
    //   824: istore_1
    //   825: goto -61 -> 764
    //   828: iconst_0
    //   829: istore_1
    //   830: goto -280 -> 550
    //   833: ldc 139
    //   835: astore 11
    //   837: goto -264 -> 573
    //   840: iconst_0
    //   841: istore 10
    //   843: goto -109 -> 734
    //   846: new 499	android/os/Bundle
    //   849: dup
    //   850: invokespecial 500	android/os/Bundle:<init>	()V
    //   853: astore 11
    //   855: aload 11
    //   857: ldc_w 502
    //   860: aload 4
    //   862: invokevirtual 506	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   865: aload_3
    //   866: aload 11
    //   868: invokevirtual 510	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   871: pop
    //   872: aload_3
    //   873: ldc_w 511
    //   876: invokevirtual 515	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   879: pop
    //   880: aload_3
    //   881: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   884: ldc_w 522
    //   887: invokevirtual 526	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   890: pop
    //   891: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   894: astore 4
    //   896: new 528	com/tencent/mm/hellhoundlib/b/a
    //   899: dup
    //   900: invokespecial 529	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   903: aload_3
    //   904: invokevirtual 533	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   907: astore_3
    //   908: aload 4
    //   910: aload_3
    //   911: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   914: ldc_w 538
    //   917: ldc_w 539
    //   920: ldc_w 541
    //   923: ldc_w 543
    //   926: ldc_w 545
    //   929: ldc_w 547
    //   932: invokestatic 552	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   935: aload 4
    //   937: aload_3
    //   938: iconst_0
    //   939: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   942: checkcast 151	android/content/Intent
    //   945: invokevirtual 559	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   948: aload 4
    //   950: ldc_w 538
    //   953: ldc_w 539
    //   956: ldc_w 541
    //   959: ldc_w 543
    //   962: ldc_w 545
    //   965: ldc_w 547
    //   968: invokestatic 563	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   971: ldc_w 307
    //   974: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   977: return
    //   978: ldc 132
    //   980: ldc_w 565
    //   983: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   986: aload_0
    //   987: invokevirtual 453	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   990: new 151	android/content/Intent
    //   993: dup
    //   994: invokespecial 454	android/content/Intent:<init>	()V
    //   997: astore_3
    //   998: aload_3
    //   999: ldc 149
    //   1001: aload_0
    //   1002: getfield 157	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:fTQ	Ljava/lang/String;
    //   1005: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1008: pop
    //   1009: aload_3
    //   1010: ldc 159
    //   1012: aload_0
    //   1013: getfield 161	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1016: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1019: pop
    //   1020: aload_3
    //   1021: ldc_w 460
    //   1024: aload_0
    //   1025: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   1028: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1031: pop
    //   1032: aload 12
    //   1034: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   1037: iconst_1
    //   1038: if_icmpne +131 -> 1169
    //   1041: iconst_1
    //   1042: istore 10
    //   1044: aload_3
    //   1045: ldc_w 462
    //   1048: iload 10
    //   1050: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1053: pop
    //   1054: aload_3
    //   1055: ldc_w 567
    //   1058: iconst_1
    //   1059: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1062: pop
    //   1063: aload_3
    //   1064: ldc_w 511
    //   1067: invokevirtual 515	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1070: pop
    //   1071: aload_3
    //   1072: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1075: ldc_w 572
    //   1078: invokevirtual 526	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1081: pop
    //   1082: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1085: astore 4
    //   1087: new 528	com/tencent/mm/hellhoundlib/b/a
    //   1090: dup
    //   1091: invokespecial 529	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1094: aload_3
    //   1095: invokevirtual 533	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1098: astore_3
    //   1099: aload 4
    //   1101: aload_3
    //   1102: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   1105: ldc_w 538
    //   1108: ldc_w 539
    //   1111: ldc_w 541
    //   1114: ldc_w 543
    //   1117: ldc_w 545
    //   1120: ldc_w 547
    //   1123: invokestatic 552	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload 4
    //   1128: aload_3
    //   1129: iconst_0
    //   1130: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   1133: checkcast 151	android/content/Intent
    //   1136: invokevirtual 559	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1139: aload 4
    //   1141: ldc_w 538
    //   1144: ldc_w 539
    //   1147: ldc_w 541
    //   1150: ldc_w 543
    //   1153: ldc_w 545
    //   1156: ldc_w 547
    //   1159: invokestatic 563	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1162: ldc_w 307
    //   1165: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1168: return
    //   1169: iconst_0
    //   1170: istore 10
    //   1172: goto -128 -> 1044
    //   1175: astore 4
    //   1177: aconst_null
    //   1178: astore_3
    //   1179: ldc 132
    //   1181: aload 4
    //   1183: checkcast 574	java/lang/Throwable
    //   1186: ldc_w 576
    //   1189: iconst_0
    //   1190: anewarray 578	java/lang/Object
    //   1193: invokestatic 582	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1196: aload_3
    //   1197: ifnull +9 -> 1206
    //   1200: aload_3
    //   1201: invokeinterface 441 1 0
    //   1206: aload 12
    //   1208: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1211: invokevirtual 450	java/util/LinkedList:size	()I
    //   1214: ifle +322 -> 1536
    //   1217: ldc 132
    //   1219: new 212	java/lang/StringBuilder
    //   1222: dup
    //   1223: ldc_w 452
    //   1226: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1229: aload 12
    //   1231: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1234: invokevirtual 450	java/util/LinkedList:size	()I
    //   1237: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1246: aload_0
    //   1247: invokevirtual 453	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   1250: new 151	android/content/Intent
    //   1253: dup
    //   1254: invokespecial 454	android/content/Intent:<init>	()V
    //   1257: astore_3
    //   1258: aload_3
    //   1259: ldc 149
    //   1261: aload_0
    //   1262: getfield 157	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:fTQ	Ljava/lang/String;
    //   1265: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload_3
    //   1270: ldc 159
    //   1272: aload_0
    //   1273: getfield 161	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1276: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload_3
    //   1281: ldc_w 460
    //   1284: aload_0
    //   1285: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   1288: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1291: pop
    //   1292: aload 12
    //   1294: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   1297: iconst_1
    //   1298: if_icmpne +100 -> 1398
    //   1301: iconst_1
    //   1302: istore 10
    //   1304: aload_3
    //   1305: ldc_w 462
    //   1308: iload 10
    //   1310: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1313: pop
    //   1314: new 467	java/util/ArrayList
    //   1317: dup
    //   1318: invokespecial 468	java/util/ArrayList:<init>	()V
    //   1321: astore 4
    //   1323: aload 12
    //   1325: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1328: invokevirtual 450	java/util/LinkedList:size	()I
    //   1331: istore_2
    //   1332: iconst_0
    //   1333: istore_1
    //   1334: iload_1
    //   1335: iload_2
    //   1336: if_icmpge +68 -> 1404
    //   1339: aload 12
    //   1341: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1344: iload_1
    //   1345: invokevirtual 471	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   1348: checkcast 473	com/tencent/mm/protocal/protobuf/cpi
    //   1351: astore 11
    //   1353: aload 4
    //   1355: new 475	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   1358: dup
    //   1359: aload 11
    //   1361: getfield 478	com/tencent/mm/protocal/protobuf/cpi:UserName	Ljava/lang/String;
    //   1364: aload 11
    //   1366: getfield 481	com/tencent/mm/protocal/protobuf/cpi:rWI	Ljava/lang/String;
    //   1369: aload 11
    //   1371: getfield 484	com/tencent/mm/protocal/protobuf/cpi:CNM	Ljava/lang/String;
    //   1374: aload 11
    //   1376: getfield 487	com/tencent/mm/protocal/protobuf/cpi:rVG	Ljava/lang/String;
    //   1379: aload 11
    //   1381: getfield 490	com/tencent/mm/protocal/protobuf/cpi:TwP	I
    //   1384: invokespecial 493	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1387: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1390: pop
    //   1391: iload_1
    //   1392: iconst_1
    //   1393: iadd
    //   1394: istore_1
    //   1395: goto -61 -> 1334
    //   1398: iconst_0
    //   1399: istore 10
    //   1401: goto -97 -> 1304
    //   1404: new 499	android/os/Bundle
    //   1407: dup
    //   1408: invokespecial 500	android/os/Bundle:<init>	()V
    //   1411: astore 11
    //   1413: aload 11
    //   1415: ldc_w 502
    //   1418: aload 4
    //   1420: invokevirtual 506	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1423: aload_3
    //   1424: aload 11
    //   1426: invokevirtual 510	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1429: pop
    //   1430: aload_3
    //   1431: ldc_w 511
    //   1434: invokevirtual 515	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1437: pop
    //   1438: aload_3
    //   1439: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1442: ldc_w 522
    //   1445: invokevirtual 526	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1448: pop
    //   1449: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1452: astore 4
    //   1454: new 528	com/tencent/mm/hellhoundlib/b/a
    //   1457: dup
    //   1458: invokespecial 529	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1461: aload_3
    //   1462: invokevirtual 533	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1465: astore_3
    //   1466: aload 4
    //   1468: aload_3
    //   1469: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   1472: ldc_w 538
    //   1475: ldc_w 539
    //   1478: ldc_w 541
    //   1481: ldc_w 543
    //   1484: ldc_w 545
    //   1487: ldc_w 547
    //   1490: invokestatic 552	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1493: aload 4
    //   1495: aload_3
    //   1496: iconst_0
    //   1497: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   1500: checkcast 151	android/content/Intent
    //   1503: invokevirtual 559	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1506: aload 4
    //   1508: ldc_w 538
    //   1511: ldc_w 539
    //   1514: ldc_w 541
    //   1517: ldc_w 543
    //   1520: ldc_w 545
    //   1523: ldc_w 547
    //   1526: invokestatic 563	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1529: ldc_w 307
    //   1532: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1535: return
    //   1536: ldc 132
    //   1538: ldc_w 565
    //   1541: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1544: aload_0
    //   1545: invokevirtual 453	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   1548: new 151	android/content/Intent
    //   1551: dup
    //   1552: invokespecial 454	android/content/Intent:<init>	()V
    //   1555: astore_3
    //   1556: aload_3
    //   1557: ldc 149
    //   1559: aload_0
    //   1560: getfield 157	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:fTQ	Ljava/lang/String;
    //   1563: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1566: pop
    //   1567: aload_3
    //   1568: ldc 159
    //   1570: aload_0
    //   1571: getfield 161	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1574: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1577: pop
    //   1578: aload_3
    //   1579: ldc_w 460
    //   1582: aload_0
    //   1583: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   1586: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1589: pop
    //   1590: aload 12
    //   1592: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   1595: iconst_1
    //   1596: if_icmpne +131 -> 1727
    //   1599: iconst_1
    //   1600: istore 10
    //   1602: aload_3
    //   1603: ldc_w 462
    //   1606: iload 10
    //   1608: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1611: pop
    //   1612: aload_3
    //   1613: ldc_w 567
    //   1616: iconst_1
    //   1617: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1620: pop
    //   1621: aload_3
    //   1622: ldc_w 511
    //   1625: invokevirtual 515	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1628: pop
    //   1629: aload_3
    //   1630: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1633: ldc_w 572
    //   1636: invokevirtual 526	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1639: pop
    //   1640: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1643: astore 4
    //   1645: new 528	com/tencent/mm/hellhoundlib/b/a
    //   1648: dup
    //   1649: invokespecial 529	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1652: aload_3
    //   1653: invokevirtual 533	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1656: astore_3
    //   1657: aload 4
    //   1659: aload_3
    //   1660: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   1663: ldc_w 538
    //   1666: ldc_w 539
    //   1669: ldc_w 541
    //   1672: ldc_w 543
    //   1675: ldc_w 545
    //   1678: ldc_w 547
    //   1681: invokestatic 552	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1684: aload 4
    //   1686: aload_3
    //   1687: iconst_0
    //   1688: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   1691: checkcast 151	android/content/Intent
    //   1694: invokevirtual 559	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1697: aload 4
    //   1699: ldc_w 538
    //   1702: ldc_w 539
    //   1705: ldc_w 541
    //   1708: ldc_w 543
    //   1711: ldc_w 545
    //   1714: ldc_w 547
    //   1717: invokestatic 563	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1720: ldc_w 307
    //   1723: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1726: return
    //   1727: iconst_0
    //   1728: istore 10
    //   1730: goto -128 -> 1602
    //   1733: astore 4
    //   1735: aload_3
    //   1736: ifnull +9 -> 1745
    //   1739: aload_3
    //   1740: invokeinterface 441 1 0
    //   1745: aload 12
    //   1747: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1750: invokevirtual 450	java/util/LinkedList:size	()I
    //   1753: ifle +324 -> 2077
    //   1756: ldc 132
    //   1758: new 212	java/lang/StringBuilder
    //   1761: dup
    //   1762: ldc_w 452
    //   1765: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1768: aload 12
    //   1770: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1773: invokevirtual 450	java/util/LinkedList:size	()I
    //   1776: invokevirtual 312	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1779: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1782: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1785: aload_0
    //   1786: invokevirtual 453	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   1789: new 151	android/content/Intent
    //   1792: dup
    //   1793: invokespecial 454	android/content/Intent:<init>	()V
    //   1796: astore_3
    //   1797: aload_3
    //   1798: ldc 149
    //   1800: aload_0
    //   1801: getfield 157	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:fTQ	Ljava/lang/String;
    //   1804: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1807: pop
    //   1808: aload_3
    //   1809: ldc 159
    //   1811: aload_0
    //   1812: getfield 161	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   1815: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1818: pop
    //   1819: aload_3
    //   1820: ldc_w 460
    //   1823: aload_0
    //   1824: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   1827: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1830: pop
    //   1831: aload 12
    //   1833: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   1836: iconst_1
    //   1837: if_icmpne +100 -> 1937
    //   1840: iconst_1
    //   1841: istore 10
    //   1843: aload_3
    //   1844: ldc_w 462
    //   1847: iload 10
    //   1849: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1852: pop
    //   1853: new 467	java/util/ArrayList
    //   1856: dup
    //   1857: invokespecial 468	java/util/ArrayList:<init>	()V
    //   1860: astore 11
    //   1862: aload 12
    //   1864: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1867: invokevirtual 450	java/util/LinkedList:size	()I
    //   1870: istore_2
    //   1871: iconst_0
    //   1872: istore_1
    //   1873: iload_1
    //   1874: iload_2
    //   1875: if_icmpge +68 -> 1943
    //   1878: aload 12
    //   1880: getfield 445	com/tencent/mm/protocal/protobuf/cpm:TwQ	Ljava/util/LinkedList;
    //   1883: iload_1
    //   1884: invokevirtual 471	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   1887: checkcast 473	com/tencent/mm/protocal/protobuf/cpi
    //   1890: astore 13
    //   1892: aload 11
    //   1894: new 475	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo
    //   1897: dup
    //   1898: aload 13
    //   1900: getfield 478	com/tencent/mm/protocal/protobuf/cpi:UserName	Ljava/lang/String;
    //   1903: aload 13
    //   1905: getfield 481	com/tencent/mm/protocal/protobuf/cpi:rWI	Ljava/lang/String;
    //   1908: aload 13
    //   1910: getfield 484	com/tencent/mm/protocal/protobuf/cpi:CNM	Ljava/lang/String;
    //   1913: aload 13
    //   1915: getfield 487	com/tencent/mm/protocal/protobuf/cpi:rVG	Ljava/lang/String;
    //   1918: aload 13
    //   1920: getfield 490	com/tencent/mm/protocal/protobuf/cpi:TwP	I
    //   1923: invokespecial 493	com/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1926: invokevirtual 497	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1929: pop
    //   1930: iload_1
    //   1931: iconst_1
    //   1932: iadd
    //   1933: istore_1
    //   1934: goto -61 -> 1873
    //   1937: iconst_0
    //   1938: istore 10
    //   1940: goto -97 -> 1843
    //   1943: new 499	android/os/Bundle
    //   1946: dup
    //   1947: invokespecial 500	android/os/Bundle:<init>	()V
    //   1950: astore 12
    //   1952: aload 12
    //   1954: ldc_w 502
    //   1957: aload 11
    //   1959: invokevirtual 506	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1962: aload_3
    //   1963: aload 12
    //   1965: invokevirtual 510	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1968: pop
    //   1969: aload_3
    //   1970: ldc_w 511
    //   1973: invokevirtual 515	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1976: pop
    //   1977: aload_3
    //   1978: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1981: ldc_w 522
    //   1984: invokevirtual 526	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1987: pop
    //   1988: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1991: astore 11
    //   1993: new 528	com/tencent/mm/hellhoundlib/b/a
    //   1996: dup
    //   1997: invokespecial 529	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2000: aload_3
    //   2001: invokevirtual 533	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2004: astore_3
    //   2005: aload 11
    //   2007: aload_3
    //   2008: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   2011: ldc_w 538
    //   2014: ldc_w 539
    //   2017: ldc_w 541
    //   2020: ldc_w 543
    //   2023: ldc_w 545
    //   2026: ldc_w 547
    //   2029: invokestatic 552	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2032: aload 11
    //   2034: aload_3
    //   2035: iconst_0
    //   2036: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   2039: checkcast 151	android/content/Intent
    //   2042: invokevirtual 559	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2045: aload 11
    //   2047: ldc_w 538
    //   2050: ldc_w 539
    //   2053: ldc_w 541
    //   2056: ldc_w 543
    //   2059: ldc_w 545
    //   2062: ldc_w 547
    //   2065: invokestatic 563	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2068: ldc_w 307
    //   2071: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2074: aload 4
    //   2076: athrow
    //   2077: ldc 132
    //   2079: ldc_w 565
    //   2082: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2085: aload_0
    //   2086: invokevirtual 453	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:finish	()V
    //   2089: new 151	android/content/Intent
    //   2092: dup
    //   2093: invokespecial 454	android/content/Intent:<init>	()V
    //   2096: astore_3
    //   2097: aload_3
    //   2098: ldc 149
    //   2100: aload_0
    //   2101: getfield 157	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:fTQ	Ljava/lang/String;
    //   2104: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2107: pop
    //   2108: aload_3
    //   2109: ldc 159
    //   2111: aload_0
    //   2112: getfield 161	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:deviceName	Ljava/lang/String;
    //   2115: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2118: pop
    //   2119: aload_3
    //   2120: ldc_w 460
    //   2123: aload_0
    //   2124: getfield 429	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:Ecp	Ljava/lang/String;
    //   2127: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2130: pop
    //   2131: aload 12
    //   2133: getfield 436	com/tencent/mm/protocal/protobuf/cpm:TwR	I
    //   2136: iconst_1
    //   2137: if_icmpne +127 -> 2264
    //   2140: iconst_1
    //   2141: istore 10
    //   2143: aload_3
    //   2144: ldc_w 462
    //   2147: iload 10
    //   2149: invokevirtual 465	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2152: pop
    //   2153: aload_3
    //   2154: ldc_w 567
    //   2157: iconst_1
    //   2158: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2161: pop
    //   2162: aload_3
    //   2163: ldc_w 511
    //   2166: invokevirtual 515	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   2169: pop
    //   2170: aload_3
    //   2171: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2174: ldc_w 572
    //   2177: invokevirtual 526	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   2180: pop
    //   2181: invokestatic 520	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2184: astore 11
    //   2186: new 528	com/tencent/mm/hellhoundlib/b/a
    //   2189: dup
    //   2190: invokespecial 529	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   2193: aload_3
    //   2194: invokevirtual 533	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   2197: astore_3
    //   2198: aload 11
    //   2200: aload_3
    //   2201: invokevirtual 537	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   2204: ldc_w 538
    //   2207: ldc_w 539
    //   2210: ldc_w 541
    //   2213: ldc_w 543
    //   2216: ldc_w 545
    //   2219: ldc_w 547
    //   2222: invokestatic 552	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2225: aload 11
    //   2227: aload_3
    //   2228: iconst_0
    //   2229: invokevirtual 555	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   2232: checkcast 151	android/content/Intent
    //   2235: invokevirtual 559	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2238: aload 11
    //   2240: ldc_w 538
    //   2243: ldc_w 539
    //   2246: ldc_w 541
    //   2249: ldc_w 543
    //   2252: ldc_w 545
    //   2255: ldc_w 547
    //   2258: invokestatic 563	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2261: goto -193 -> 2068
    //   2264: iconst_0
    //   2265: istore 10
    //   2267: goto -124 -> 2143
    //   2270: getstatic 588	com/tencent/mm/plugin/kidswatch/b/a:Edb	Lcom/tencent/mm/plugin/kidswatch/b/a;
    //   2273: astore 4
    //   2275: aload_0
    //   2276: invokevirtual 271	com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchEntranceUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   2279: astore 4
    //   2281: aload 4
    //   2283: ldc_w 273
    //   2286: invokestatic 187	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2289: aload 4
    //   2291: checkcast 557	android/content/Context
    //   2294: iload_2
    //   2295: aload_3
    //   2296: invokestatic 592	com/tencent/mm/plugin/kidswatch/b/a:e	(Landroid/content/Context;ILjava/lang/String;)V
    //   2299: ldc_w 307
    //   2302: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2305: return
    //   2306: astore 4
    //   2308: goto -573 -> 1735
    //   2311: astore 11
    //   2313: aload 4
    //   2315: astore_3
    //   2316: aload 11
    //   2318: astore 4
    //   2320: goto -1141 -> 1179
    //   2323: iconst_1
    //   2324: iload_1
    //   2325: if_icmpne +39 -> 2364
    //   2328: iconst_1
    //   2329: istore 7
    //   2331: iconst_2
    //   2332: iload_1
    //   2333: if_icmpne +37 -> 2370
    //   2336: iconst_1
    //   2337: istore 8
    //   2339: goto -2040 -> 299
    //   2342: iload 5
    //   2344: iconst_1
    //   2345: iadd
    //   2346: istore 5
    //   2348: iload_1
    //   2349: istore 6
    //   2351: goto -2130 -> 221
    //   2354: iconst_4
    //   2355: istore_1
    //   2356: goto -33 -> 2323
    //   2359: iconst_1
    //   2360: istore_1
    //   2361: goto -38 -> 2323
    //   2364: iconst_0
    //   2365: istore 7
    //   2367: goto -36 -> 2331
    //   2370: iconst_0
    //   2371: istore 8
    //   2373: goto -2074 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2376	0	this	KidsWatchEntranceUI
    //   0	2376	1	paramInt1	int
    //   0	2376	2	paramInt2	int
    //   0	2376	3	paramString	String
    //   0	2376	4	paramq	com.tencent.mm.an.q
    //   219	2128	5	i	int
    //   216	2134	6	j	int
    //   304	2062	7	k	int
    //   302	2070	8	m	int
    //   213	50	9	n	int
    //   732	1534	10	bool	boolean
    //   87	2152	11	localObject1	Object
    //   2311	6	11	localException	java.lang.Exception
    //   119	2013	12	localObject2	Object
    //   142	1777	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   136	144	1175	java/lang/Exception
    //   147	155	1175	java/lang/Exception
    //   158	180	1175	java/lang/Exception
    //   136	144	1733	finally
    //   147	155	1733	finally
    //   158	180	1733	finally
    //   188	196	1733	finally
    //   203	215	1733	finally
    //   230	242	1733	finally
    //   245	257	1733	finally
    //   260	271	1733	finally
    //   274	282	1733	finally
    //   285	293	1733	finally
    //   319	327	1733	finally
    //   344	358	1733	finally
    //   361	370	1733	finally
    //   379	385	1733	finally
    //   391	399	1733	finally
    //   407	415	1733	finally
    //   423	431	1733	finally
    //   434	442	1733	finally
    //   445	453	1733	finally
    //   456	464	1733	finally
    //   467	475	1733	finally
    //   481	489	1733	finally
    //   498	510	1733	finally
    //   519	527	1733	finally
    //   535	548	1733	finally
    //   557	573	1733	finally
    //   576	582	1733	finally
    //   585	624	1733	finally
    //   1179	1196	2306	finally
    //   188	196	2311	java/lang/Exception
    //   203	215	2311	java/lang/Exception
    //   230	242	2311	java/lang/Exception
    //   245	257	2311	java/lang/Exception
    //   260	271	2311	java/lang/Exception
    //   274	282	2311	java/lang/Exception
    //   285	293	2311	java/lang/Exception
    //   319	327	2311	java/lang/Exception
    //   344	358	2311	java/lang/Exception
    //   361	370	2311	java/lang/Exception
    //   379	385	2311	java/lang/Exception
    //   391	399	2311	java/lang/Exception
    //   407	415	2311	java/lang/Exception
    //   423	431	2311	java/lang/Exception
    //   434	442	2311	java/lang/Exception
    //   445	453	2311	java/lang/Exception
    //   456	464	2311	java/lang/Exception
    //   467	475	2311	java/lang/Exception
    //   481	489	2311	java/lang/Exception
    //   498	510	2311	java/lang/Exception
    //   519	527	2311	java/lang/Exception
    //   535	548	2311	java/lang/Exception
    //   557	573	2311	java/lang/Exception
    //   576	582	2311	java/lang/Exception
    //   585	624	2311	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchEntranceUI
 * JD-Core Version:    0.7.0.1
 */