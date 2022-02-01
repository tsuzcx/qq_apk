package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.plugin.kidswatch.model.c.a;
import com.tencent.mm.plugin.kidswatch.model.c.b;
import com.tencent.mm.plugin.kidswatch.model.c.c;
import com.tencent.mm.plugin.kidswatch.model.g;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "curKidsAcctInfo", "Lcom/tencent/mm/protocal/protobuf/KidsAcctInfo;", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "convertTo", "kidsWatchAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLogin", "acctInfo", "Companion", "plugin-kidswatch_release"})
public final class KidsWatchLoginCardChooseUI
  extends MMActivity
  implements i
{
  public static final KidsWatchLoginCardChooseUI.a Ecy;
  private String Ecp;
  private boolean Ecv;
  private int Ecw;
  private cpi Ecx;
  private HashMap _$_findViewCache;
  private String deviceName;
  private String fTQ;
  
  static
  {
    AppMethodBeat.i(251882);
    Ecy = new KidsWatchLoginCardChooseUI.a((byte)0);
    AppMethodBeat.o(251882);
  }
  
  private final void a(cpi paramcpi)
  {
    AppMethodBeat.i(251876);
    Log.i("KidsWatchLoginCardChooseUI", "reLogin:" + paramcpi + ", userName:" + paramcpi.UserName);
    com.tencent.mm.kernel.h.aGY().a(972, (i)this);
    String str = this.fTQ;
    if (str == null) {
      p.bGy("loginUrl");
    }
    paramcpi = new g(str, this.Ecp, 2, paramcpi);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramcpi);
    AppMethodBeat.o(251876);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251892);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251892);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251890);
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
    AppMethodBeat.o(251890);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251864);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(251864);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebh;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(251878);
    Log.i("KidsWatchLoginCardChooseUI", "initView");
    Object localObject1 = (KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG);
    Object localObject2 = getString(b.h.Ebx);
    p.j(localObject2, "getString(R.string.kids_…_login_card_choose_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    p.j(localObject1, "intent.getStringExtra(Co…tch.INTENT_KEY_LOGIN_URL)");
    this.fTQ = ((String)localObject1);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.Ecv = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
    this.Ecp = getIntent().getStringExtra("intent.key.ok.session.list");
    localObject1 = getIntent().getParcelableArrayListExtra("intent.key.kids.list");
    this.Ecw = ((ArrayList)localObject1).size();
    localObject2 = new StringBuilder("intent:<");
    Object localObject3 = this.fTQ;
    if (localObject3 == null) {
      p.bGy("loginUrl");
    }
    Log.i("KidsWatchLoginCardChooseUI", (String)localObject3 + ", " + this.deviceName + ", " + this.Ecv + ", " + this.Ecp + ", " + this.Ecw + '>');
    int k = this.Ecw;
    final int i = 0;
    while (i < k)
    {
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = new KidsWatchCardLayout((Context)localObject2);
      ((KidsWatchCardLayout)localObject2).setId(i);
      localObject3 = ((ArrayList)localObject1).get(i);
      p.j(localObject3, "kidsList[i]");
      ((KidsWatchCardLayout)localObject2).setData((KidsWatchAcctInfo)localObject3);
      if (i == this.Ecw - 1)
      {
        localObject3 = (LinearLayout)((KidsWatchCardLayout)localObject2)._$_findCachedViewById(b.e.Eaw);
        p.j(localObject3, "cardLL");
        localObject3 = ((LinearLayout)localObject3).getLayoutParams();
        if (localObject3 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(251878);
          throw ((Throwable)localObject1);
        }
        localObject3 = (LinearLayout.LayoutParams)localObject3;
        int j = com.tencent.g.c.c.getScreenWidth(((KidsWatchCardLayout)localObject2).getContext());
        int m = aw.H(((KidsWatchCardLayout)localObject2).getContext(), j);
        j = aw.fromDPToPix(((KidsWatchCardLayout)localObject2).getContext(), 8);
        if (m >= 375) {
          j = aw.fromDPToPix(((KidsWatchCardLayout)localObject2).getContext(), 24);
        }
        ((LinearLayout.LayoutParams)localObject3).setMargins(j, 0, j, 0);
        LinearLayout localLinearLayout = (LinearLayout)((KidsWatchCardLayout)localObject2)._$_findCachedViewById(b.e.Eaw);
        p.j(localLinearLayout, "cardLL");
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      ((KidsWatchCardLayout)localObject2).setOnClickListener((View.OnClickListener)new c(this, (ArrayList)localObject1, i));
      ((LinearLayout)_$_findCachedViewById(b.e.Eax)).addView((View)localObject2);
      i += 1;
    }
    ((TextView)_$_findCachedViewById(b.e.Ebe)).setOnClickListener((View.OnClickListener)new d(this));
    ((ScrollView)_$_findCachedViewById(b.e.scrollView)).post((Runnable)new e(this));
    AppMethodBeat.o(251878);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(251872);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      Log.i("KidsWatchLoginCardChooseUI", "onActivityResult, " + paramInt1 + ", " + paramInt2);
      if (paramInt2 == -1)
      {
        if (this.Ecx == null)
        {
          AppMethodBeat.o(251872);
          return;
        }
        paramIntent = this.Ecx;
        if (paramIntent == null) {
          p.iCn();
        }
        a(paramIntent);
      }
    }
    AppMethodBeat.o(251872);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(251868);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(251868);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251860);
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
    AppMethodBeat.o(251860);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(251880);
    Log.i("KidsWatchLoginCardChooseUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramq instanceof g))
    {
      com.tencent.mm.kernel.h.aGY().b(972, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == a.b.Eaa.value))
      {
        w.cR((Context)getContext(), getContext().getString(b.h.EbD));
        paramString = com.tencent.mm.plugin.kidswatch.model.c.EbU;
        paramString = c.a.EbW;
        paramq = this.fTQ;
        if (paramq == null) {
          p.bGy("loginUrl");
        }
        com.tencent.mm.plugin.kidswatch.model.c.a(paramString, paramq, c.c.Ecd, c.b.EbY, this.Ecw, paramInt2);
        paramString = com.tencent.mm.plugin.kidswatch.b.a.Edb;
        paramString = getContext();
        p.j(paramString, "context");
        com.tencent.mm.plugin.kidswatch.b.a.h((Context)paramString, "", true);
        AppMethodBeat.o(251880);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == a.b.Eaj.value))
      {
        Log.i("KidsWatchLoginCardChooseUI", paramInt1 + ", " + paramInt2 + ", showBlockBySpam");
        y.f((Context)this, paramString, 30846);
        AppMethodBeat.o(251880);
        return;
      }
      paramq = com.tencent.mm.plugin.kidswatch.model.c.EbU;
      paramq = c.a.EbW;
      String str = this.fTQ;
      if (str == null) {
        p.bGy("loginUrl");
      }
      com.tencent.mm.plugin.kidswatch.model.c.a(paramq, str, c.c.Ecd, c.b.Ecb, this.Ecw, paramInt2);
      Log.i("KidsWatchLoginCardChooseUI", paramInt1 + ", " + paramInt2 + ", showAlertWhenError");
      paramq = com.tencent.mm.plugin.kidswatch.b.a.Edb;
      paramq = getContext();
      p.j(paramq, "context");
      com.tencent.mm.plugin.kidswatch.b.a.e((Context)paramq, paramInt2, paramString);
    }
    AppMethodBeat.o(251880);
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
    b(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI, ArrayList paramArrayList, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251412);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      localObject1 = this.Ecz;
      Object localObject2 = this.EcA.get(i);
      p.j(localObject2, "kidsList[i]");
      KidsWatchLoginCardChooseUI.a((KidsWatchLoginCardChooseUI)localObject1, KidsWatchLoginCardChooseUI.a((KidsWatchAcctInfo)localObject2));
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout");
        AppMethodBeat.o(251412);
        throw paramView;
      }
      if (((KidsWatchCardLayout)paramView).isLogin) {
        com.tencent.mm.ui.base.h.c((Context)this.Ecz.getContext(), this.Ecz.getString(b.h.Ebv), "", this.Ecz.getString(b.h.Ebu), this.Ecz.getString(b.h.Ebt), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(251560);
            paramAnonymousDialogInterface = this.EcB.Ecz;
            cpi localcpi = KidsWatchLoginCardChooseUI.c(this.EcB.Ecz);
            if (localcpi == null) {
              p.iCn();
            }
            KidsWatchLoginCardChooseUI.b(paramAnonymousDialogInterface, localcpi);
            AppMethodBeat.o(251560);
          }
        }, null);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251412);
        return;
        paramView = this.Ecz;
        localObject1 = KidsWatchLoginCardChooseUI.c(this.Ecz);
        if (localObject1 == null) {
          p.iCn();
        }
        KidsWatchLoginCardChooseUI.b(paramView, (cpi)localObject1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252296);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      Log.i("KidsWatchLoginCardChooseUI", "click switch count button");
      localObject = new Intent();
      ((Intent)localObject).putExtra("intent.key.login.url", KidsWatchLoginCardChooseUI.a(this.Ecz));
      ((Intent)localObject).putExtra("intent.key.device.name", KidsWatchLoginCardChooseUI.d(this.Ecz));
      ((Intent)localObject).putExtra("intent.key.ok.session.list", KidsWatchLoginCardChooseUI.e(this.Ecz));
      ((Intent)localObject).putExtra("intent.key.ok.reg.btn", KidsWatchLoginCardChooseUI.f(this.Ecz));
      ((Intent)localObject).putExtra("intent.key.kids.cnt", KidsWatchLoginCardChooseUI.b(this.Ecz));
      ((Intent)localObject).putExtra("intent.key.enter.login.first", 2);
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), KidsWatchLoginFirst.class);
      paramView = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252296);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252242);
      ((ScrollView)this.Ecz._$_findCachedViewById(b.e.scrollView)).fullScroll(130);
      AppMethodBeat.o(252242);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginCardChooseUI
 * JD-Core Version:    0.7.0.1
 */