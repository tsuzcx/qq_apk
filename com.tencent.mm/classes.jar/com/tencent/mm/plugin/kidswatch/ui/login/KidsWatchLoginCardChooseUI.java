package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.plugin.kidswatch.model.c.a;
import com.tencent.mm.plugin.kidswatch.model.c.b;
import com.tencent.mm.plugin.kidswatch.model.c.c;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "curKidsAcctInfo", "Lcom/tencent/mm/protocal/protobuf/KidsAcctInfo;", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "convertTo", "kidsWatchAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLogin", "acctInfo", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginCardChooseUI
  extends MMActivity
  implements i
{
  public static final KidsWatchLoginCardChooseUI.a yBj;
  private HashMap _$_findViewCache;
  private String dZW;
  private String deviceName;
  private String yBa;
  private boolean yBg;
  private int yBh;
  private cgm yBi;
  
  static
  {
    AppMethodBeat.i(256241);
    yBj = new KidsWatchLoginCardChooseUI.a((byte)0);
    AppMethodBeat.o(256241);
  }
  
  private final void a(cgm paramcgm)
  {
    AppMethodBeat.i(256238);
    Log.i("KidsWatchLoginCardChooseUI", "reLogin:" + paramcgm + ", userName:" + paramcgm.UserName);
    com.tencent.mm.kernel.g.azz().a(972, (i)this);
    String str = this.dZW;
    if (str == null) {
      p.btv("loginUrl");
    }
    paramcgm = new com.tencent.mm.plugin.kidswatch.model.g(str, this.yBa, 2, paramcgm);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramcgm);
    AppMethodBeat.o(256238);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256246);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256246);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256245);
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
    AppMethodBeat.o(256245);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256235);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256235);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495131;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256239);
    Log.i("KidsWatchLoginCardChooseUI", "initView");
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(2131302263);
    Object localObject2 = getString(2131762068);
    p.g(localObject2, "getString(R.string.kids_…_login_card_choose_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.g(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.dZW = ((String)localObject1);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.yBg = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
    this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
    localObject1 = getIntent().getParcelableArrayListExtra("intent.key.kids.list");
    this.yBh = ((ArrayList)localObject1).size();
    localObject2 = new StringBuilder("intent:<");
    Object localObject3 = this.dZW;
    if (localObject3 == null) {
      p.btv("loginUrl");
    }
    Log.i("KidsWatchLoginCardChooseUI", (String)localObject3 + ", " + this.deviceName + ", " + this.yBg + ", " + this.yBa + ", " + this.yBh + '>');
    int k = this.yBh;
    final int i = 0;
    while (i < k)
    {
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = new KidsWatchCardLayout((Context)localObject2);
      ((KidsWatchCardLayout)localObject2).setId(i);
      localObject3 = ((ArrayList)localObject1).get(i);
      p.g(localObject3, "kidsList[i]");
      ((KidsWatchCardLayout)localObject2).setData((KidsWatchAcctInfo)localObject3);
      if (i == this.yBh - 1)
      {
        localObject3 = (LinearLayout)((KidsWatchCardLayout)localObject2)._$_findCachedViewById(2131298011);
        p.g(localObject3, "cardLL");
        localObject3 = ((LinearLayout)localObject3).getLayoutParams();
        if (localObject3 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(256239);
          throw ((Throwable)localObject1);
        }
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        int j = com.tencent.h.c.c.getScreenWidth(((KidsWatchCardLayout)localObject2).getContext());
        int m = at.E(((KidsWatchCardLayout)localObject2).getContext(), j);
        j = at.fromDPToPix(((KidsWatchCardLayout)localObject2).getContext(), 8);
        if (m >= 375) {
          j = at.fromDPToPix(((KidsWatchCardLayout)localObject2).getContext(), 24);
        }
        ((LinearLayout.LayoutParams)localObject3).setMargins(j, 0, j, 0);
        LinearLayout localLinearLayout = (LinearLayout)((KidsWatchCardLayout)localObject2)._$_findCachedViewById(2131298011);
        p.g(localLinearLayout, "cardLL");
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      ((KidsWatchCardLayout)localObject2).setOnClickListener((View.OnClickListener)new c(this, (ArrayList)localObject1, i));
      ((LinearLayout)_$_findCachedViewById(2131298013)).addView((View)localObject2);
      i += 1;
    }
    ((TextView)_$_findCachedViewById(2131308787)).setOnClickListener((View.OnClickListener)new d(this));
    ((ScrollView)_$_findCachedViewById(2131307332)).post((Runnable)new e(this));
    AppMethodBeat.o(256239);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256237);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      Log.i("KidsWatchLoginCardChooseUI", "onActivityResult, " + paramInt1 + ", " + paramInt2);
      if (paramInt2 == -1)
      {
        if (this.yBi == null)
        {
          AppMethodBeat.o(256237);
          return;
        }
        paramIntent = this.yBi;
        if (paramIntent == null) {
          p.hyc();
        }
        a(paramIntent);
      }
    }
    AppMethodBeat.o(256237);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(256236);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(256236);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256234);
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
    AppMethodBeat.o(256234);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(256240);
    Log.i("KidsWatchLoginCardChooseUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramq instanceof com.tencent.mm.plugin.kidswatch.model.g))
    {
      com.tencent.mm.kernel.g.azz().b(972, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == a.b.yAi.value))
      {
        u.cG((Context)getContext(), getContext().getString(2131762085));
        paramString = com.tencent.mm.plugin.kidswatch.model.c.yAF;
        paramString = c.a.yAH;
        paramq = this.dZW;
        if (paramq == null) {
          p.btv("loginUrl");
        }
        com.tencent.mm.plugin.kidswatch.model.c.a(paramString, paramq, c.c.yAO, c.b.yAJ, this.yBh, paramInt2);
        paramString = com.tencent.mm.plugin.kidswatch.b.a.yBL;
        paramString = getContext();
        p.g(paramString, "context");
        com.tencent.mm.plugin.kidswatch.b.a.h((Context)paramString, "", true);
        AppMethodBeat.o(256240);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == a.b.yAr.value))
      {
        Log.i("KidsWatchLoginCardChooseUI", paramInt1 + ", " + paramInt2 + ", showBlockBySpam");
        y.g((Context)this, paramString, 30846);
        AppMethodBeat.o(256240);
        return;
      }
      paramq = com.tencent.mm.plugin.kidswatch.model.c.yAF;
      paramq = c.a.yAH;
      String str = this.dZW;
      if (str == null) {
        p.btv("loginUrl");
      }
      com.tencent.mm.plugin.kidswatch.model.c.a(paramq, str, c.c.yAO, c.b.yAM, this.yBh, paramInt2);
      Log.i("KidsWatchLoginCardChooseUI", paramInt1 + ", " + paramInt2 + ", showAlertWhenError");
      paramq = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      paramq = getContext();
      p.g(paramq, "context");
      com.tencent.mm.plugin.kidswatch.b.a.c((Context)paramq, paramInt2, paramString);
    }
    AppMethodBeat.o(256240);
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
    b(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI, ArrayList paramArrayList, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256231);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      localObject1 = this.yBk;
      Object localObject2 = this.yBl.get(i);
      p.g(localObject2, "kidsList[i]");
      KidsWatchLoginCardChooseUI.a((KidsWatchLoginCardChooseUI)localObject1, KidsWatchLoginCardChooseUI.a((KidsWatchAcctInfo)localObject2));
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout");
        AppMethodBeat.o(256231);
        throw paramView;
      }
      if (((KidsWatchCardLayout)paramView).sPq) {
        h.c((Context)this.yBk.getContext(), this.yBk.getString(2131762065), "", this.yBk.getString(2131762064), this.yBk.getString(2131762063), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(256230);
            paramAnonymousDialogInterface = this.yBm.yBk;
            cgm localcgm = KidsWatchLoginCardChooseUI.c(this.yBm.yBk);
            if (localcgm == null) {
              p.hyc();
            }
            KidsWatchLoginCardChooseUI.b(paramAnonymousDialogInterface, localcgm);
            AppMethodBeat.o(256230);
          }
        }, null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256231);
        return;
        paramView = this.yBk;
        localObject1 = KidsWatchLoginCardChooseUI.c(this.yBk);
        if (localObject1 == null) {
          p.hyc();
        }
        KidsWatchLoginCardChooseUI.b(paramView, (cgm)localObject1);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256232);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      Log.i("KidsWatchLoginCardChooseUI", "click switch count button");
      localObject = new Intent();
      ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchLoginCardChooseUI.a(this.yBk));
      ((Intent)localObject).putExtra("intent.key.device.name", KidsWatchLoginCardChooseUI.d(this.yBk));
      ((Intent)localObject).putExtra("intent.key.ok.session.list", KidsWatchLoginCardChooseUI.e(this.yBk));
      ((Intent)localObject).putExtra("intent.key.ok.reg.btn", KidsWatchLoginCardChooseUI.f(this.yBk));
      ((Intent)localObject).putExtra("intent.key.kids.cnt", KidsWatchLoginCardChooseUI.b(this.yBk));
      ((Intent)localObject).putExtra("intent.key.enter.login.first", 2);
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), KidsWatchLoginFirst.class);
      paramView = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256232);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(256233);
      ((ScrollView)this.yBk._$_findCachedViewById(2131307332)).fullScroll(130);
      AppMethodBeat.o(256233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginCardChooseUI
 * JD-Core Version:    0.7.0.1
 */