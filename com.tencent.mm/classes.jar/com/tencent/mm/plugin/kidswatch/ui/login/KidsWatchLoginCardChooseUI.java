package com.tencent.mm.plugin.kidswatch.ui.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.g.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo;
import com.tencent.mm.plugin.kidswatch.model.b.c;
import com.tencent.mm.plugin.kidswatch.model.f;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(35)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "curKidsAcctInfo", "Lcom/tencent/mm/protocal/protobuf/KidsAcctInfo;", "deviceName", "", "isShowRegBtn", "", "kidsCount", "", "loginUrl", "okSessionList", "convertTo", "kidsWatchAcctInfo", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchAcctInfo;", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLogin", "acctInfo", "Companion", "plugin-kidswatch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KidsWatchLoginCardChooseUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  public static final KidsWatchLoginCardChooseUI.a JTy;
  private int JTA;
  private dgc JTB;
  private String JTu;
  private boolean JTz;
  private String deviceName;
  private String hZO;
  
  static
  {
    AppMethodBeat.i(262236);
    JTy = new KidsWatchLoginCardChooseUI.a((byte)0);
    AppMethodBeat.o(262236);
  }
  
  private static final void a(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI)
  {
    AppMethodBeat.i(262215);
    kotlin.g.b.s.u(paramKidsWatchLoginCardChooseUI, "this$0");
    ((ScrollView)paramKidsWatchLoginCardChooseUI.findViewById(b.e.scrollView)).fullScroll(130);
    AppMethodBeat.o(262215);
  }
  
  private static final void a(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(262179);
    kotlin.g.b.s.u(paramKidsWatchLoginCardChooseUI, "this$0");
    paramDialogInterface = paramKidsWatchLoginCardChooseUI.JTB;
    kotlin.g.b.s.checkNotNull(paramDialogInterface);
    paramKidsWatchLoginCardChooseUI.a(paramDialogInterface);
    AppMethodBeat.o(262179);
  }
  
  private static final void a(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI, View paramView)
  {
    AppMethodBeat.i(262208);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramKidsWatchLoginCardChooseUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramKidsWatchLoginCardChooseUI, "this$0");
    Log.i("KidsWatchLoginCardChooseUI", "click switch count button");
    localObject2 = new Intent();
    localObject1 = paramKidsWatchLoginCardChooseUI.hZO;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      paramView = null;
    }
    ((Intent)localObject2).putExtra("intent.key.login.url", paramView);
    ((Intent)localObject2).putExtra("intent.key.device.name", paramKidsWatchLoginCardChooseUI.deviceName);
    ((Intent)localObject2).putExtra("intent.key.ok.session.list", paramKidsWatchLoginCardChooseUI.JTu);
    ((Intent)localObject2).putExtra("intent.key.ok.reg.btn", paramKidsWatchLoginCardChooseUI.JTz);
    ((Intent)localObject2).putExtra("intent.key.kids.cnt", paramKidsWatchLoginCardChooseUI.JTA);
    ((Intent)localObject2).putExtra("intent.key.enter.login.first", 2);
    ((Intent)localObject2).setFlags(268435456);
    ((Intent)localObject2).setClass(MMApplicationContext.getContext(), KidsWatchLoginFirst.class);
    paramKidsWatchLoginCardChooseUI = MMApplicationContext.getContext();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(paramKidsWatchLoginCardChooseUI, paramView.aYi(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI", "initView$lambda-2", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramKidsWatchLoginCardChooseUI.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramKidsWatchLoginCardChooseUI, "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI", "initView$lambda-2", "(Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(262208);
  }
  
  private static final void a(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI, ArrayList paramArrayList, int paramInt, View paramView)
  {
    AppMethodBeat.i(262194);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramKidsWatchLoginCardChooseUI);
    localb.cH(paramArrayList);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramKidsWatchLoginCardChooseUI, "this$0");
    paramArrayList = paramArrayList.get(paramInt);
    kotlin.g.b.s.s(paramArrayList, "kidsList[i]");
    paramArrayList = (KidsWatchAcctInfo)paramArrayList;
    localObject = new dgc();
    ((dgc)localObject).UserName = paramArrayList.userName;
    ((dgc)localObject).vhX = paramArrayList.nickName;
    ((dgc)localObject).IHW = paramArrayList.nVs;
    ((dgc)localObject).vgW = paramArrayList.deviceName;
    ((dgc)localObject).aaLw = paramArrayList.JSV;
    paramKidsWatchLoginCardChooseUI.JTB = ((dgc)localObject);
    if (paramView == null)
    {
      paramKidsWatchLoginCardChooseUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchCardLayout");
      AppMethodBeat.o(262194);
      throw paramKidsWatchLoginCardChooseUI;
    }
    if (((KidsWatchCardLayout)paramView).isLogin) {
      k.b((Context)paramKidsWatchLoginCardChooseUI.getContext(), paramKidsWatchLoginCardChooseUI.getString(b.h.JSD), "", paramKidsWatchLoginCardChooseUI.getString(b.h.JSC), paramKidsWatchLoginCardChooseUI.getString(b.h.JSB), new KidsWatchLoginCardChooseUI..ExternalSyntheticLambda0(paramKidsWatchLoginCardChooseUI), null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginCardChooseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262194);
      return;
      paramArrayList = paramKidsWatchLoginCardChooseUI.JTB;
      kotlin.g.b.s.checkNotNull(paramArrayList);
      paramKidsWatchLoginCardChooseUI.a(paramArrayList);
    }
  }
  
  private final void a(dgc paramdgc)
  {
    AppMethodBeat.i(262174);
    Log.i("KidsWatchLoginCardChooseUI", "reLogin:" + paramdgc + ", userName:" + paramdgc.UserName);
    com.tencent.mm.kernel.h.aZW().a(972, (com.tencent.mm.am.h)this);
    String str2 = this.hZO;
    String str1 = str2;
    if (str2 == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      str1 = null;
    }
    paramdgc = new f(str1, this.JTu, 2, paramdgc);
    com.tencent.mm.kernel.h.aZW().a((p)paramdgc, 0);
    AppMethodBeat.o(262174);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(262281);
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.kidswatch.b.a.anim_not_change, com.tencent.mm.plugin.kidswatch.b.a.push_down_out);
    AppMethodBeat.o(262281);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.JSp;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(262312);
    Log.i("KidsWatchLoginCardChooseUI", "initView");
    Object localObject1 = (KidsWatchHeadComponent)findViewById(b.e.JRO);
    Object localObject2 = getString(b.h.JSF);
    kotlin.g.b.s.s(localObject2, "getString(R.string.kids_…_login_card_choose_title)");
    ((KidsWatchHeadComponent)localObject1).setTitle((String)localObject2);
    ((KidsWatchHeadComponent)findViewById(b.e.JRO)).setCloseBtnCallBack((kotlin.g.a.a)new b(this));
    localObject1 = getIntent().getStringExtra("intent.key.login.url");
    kotlin.g.b.s.checkNotNull(localObject1);
    kotlin.g.b.s.s(localObject1, "intent.getStringExtra(Co…h.INTENT_KEY_LOGIN_URL)!!");
    this.hZO = ((String)localObject1);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.JTz = getIntent().getBooleanExtra("intent.key.ok.reg.btn", false);
    this.JTu = getIntent().getStringExtra("intent.key.ok.session.list");
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("intent.key.kids.list");
    kotlin.g.b.s.checkNotNull(localArrayList);
    this.JTA = localArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder("intent:<");
    localObject2 = this.hZO;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("loginUrl");
      localObject1 = null;
    }
    Log.i("KidsWatchLoginCardChooseUI", (String)localObject1 + ", " + this.deviceName + ", " + this.JTz + ", " + this.JTu + ", " + this.JTA + '>');
    int m = this.JTA;
    if (m > 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = new KidsWatchCardLayout((Context)localObject1);
      ((KidsWatchCardLayout)localObject1).setId(i);
      localObject2 = localArrayList.get(i);
      kotlin.g.b.s.s(localObject2, "kidsList[i]");
      ((KidsWatchCardLayout)localObject1).setData((KidsWatchAcctInfo)localObject2);
      if (i == this.JTA - 1)
      {
        localObject2 = ((LinearLayout)((KidsWatchCardLayout)localObject1).findViewById(b.e.JRE)).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(262312);
          throw ((Throwable)localObject1);
        }
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        int j = c.getScreenWidth(((KidsWatchCardLayout)localObject1).getContext());
        int n = bd.K(((KidsWatchCardLayout)localObject1).getContext(), j);
        j = bd.fromDPToPix(((KidsWatchCardLayout)localObject1).getContext(), 8);
        if (n >= 375) {
          j = bd.fromDPToPix(((KidsWatchCardLayout)localObject1).getContext(), 24);
        }
        ((LinearLayout.LayoutParams)localObject2).setMargins(j, 0, j, 0);
        ((LinearLayout)((KidsWatchCardLayout)localObject1).findViewById(b.e.JRE)).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((KidsWatchCardLayout)localObject1).setOnClickListener(new KidsWatchLoginCardChooseUI..ExternalSyntheticLambda2(this, localArrayList, i));
      ((LinearLayout)findViewById(b.e.JRF)).addView((View)localObject1);
      if (k >= m)
      {
        ((TextView)findViewById(b.e.JSm)).setOnClickListener(new KidsWatchLoginCardChooseUI..ExternalSyntheticLambda1(this));
        ((ScrollView)findViewById(b.e.scrollView)).post(new KidsWatchLoginCardChooseUI..ExternalSyntheticLambda3(this));
        AppMethodBeat.o(262312);
        return;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(262296);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      Log.i("KidsWatchLoginCardChooseUI", "onActivityResult, " + paramInt1 + ", " + paramInt2);
      if (paramInt2 == -1)
      {
        if (this.JTB == null)
        {
          AppMethodBeat.o(262296);
          return;
        }
        paramIntent = this.JTB;
        kotlin.g.b.s.checkNotNull(paramIntent);
        a(paramIntent);
      }
    }
    AppMethodBeat.o(262296);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(262286);
    finish();
    super.onBackPressed();
    AppMethodBeat.o(262286);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262266);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    setActionbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.kidswatch.b.b.JRx));
    setNavigationbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.kidswatch.b.b.JRx));
    initView();
    overridePendingTransition(com.tencent.mm.plugin.kidswatch.b.a.push_up_in, com.tencent.mm.plugin.kidswatch.b.a.anim_not_change);
    AppMethodBeat.o(262266);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    com.tencent.mm.plugin.kidswatch.model.b.a locala = null;
    AppMethodBeat.i(262333);
    Log.i("KidsWatchLoginCardChooseUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramp instanceof f))
    {
      com.tencent.mm.kernel.h.aZW().b(972, (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == a.b.JRi.value))
      {
        aa.db((Context)getContext(), getContext().getString(b.h.JSL));
        paramString = com.tencent.mm.plugin.kidswatch.model.b.JSY;
        paramp = com.tencent.mm.plugin.kidswatch.model.b.a.JTa;
        paramString = this.hZO;
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("loginUrl");
          paramString = locala;
        }
        for (;;)
        {
          com.tencent.mm.plugin.kidswatch.model.b.a(paramp, paramString, b.c.JTh, com.tencent.mm.plugin.kidswatch.model.b.b.JTc, this.JTA, paramInt2);
          paramString = com.tencent.mm.plugin.kidswatch.b.a.JTW;
          paramString = getContext();
          kotlin.g.b.s.s(paramString, "context");
          com.tencent.mm.plugin.kidswatch.b.a.h((Context)paramString, "", true);
          AppMethodBeat.o(262333);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == a.b.JRr.value))
      {
        Log.i("KidsWatchLoginCardChooseUI", paramInt1 + ", " + paramInt2 + ", showBlockBySpam");
        v.f((Context)this, paramString, 30846);
        AppMethodBeat.o(262333);
        return;
      }
      paramp = com.tencent.mm.plugin.kidswatch.model.b.JSY;
      locala = com.tencent.mm.plugin.kidswatch.model.b.a.JTa;
      paramp = this.hZO;
      if (paramp != null) {
        break label376;
      }
      kotlin.g.b.s.bIx("loginUrl");
      paramp = localObject;
    }
    label376:
    for (;;)
    {
      com.tencent.mm.plugin.kidswatch.model.b.a(locala, paramp, b.c.JTh, com.tencent.mm.plugin.kidswatch.model.b.b.JTf, this.JTA, paramInt2);
      Log.i("KidsWatchLoginCardChooseUI", paramInt1 + ", " + paramInt2 + ", showAlertWhenError");
      paramp = com.tencent.mm.plugin.kidswatch.b.a.JTW;
      paramp = getContext();
      kotlin.g.b.s.s(paramp, "context");
      com.tencent.mm.plugin.kidswatch.b.a.i((Context)paramp, paramInt2, paramString);
      AppMethodBeat.o(262333);
      return;
    }
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
    b(KidsWatchLoginCardChooseUI paramKidsWatchLoginCardChooseUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginCardChooseUI
 * JD-Core Version:    0.7.0.1
 */