package com.tencent.mm.plugin.hld.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.z;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "()V", "enterScene", "", "imeActiveObserver", "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeActiveObserver$1", "Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeActiveObserver$1;", "imeDefaultObserver", "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeDefaultObserver$1", "Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeDefaultObserver$1;", "imm", "Landroid/view/inputmethod/InputMethodManager;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lkotlin/Lazy;", "listener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "mCloseBtn", "Landroid/widget/Button;", "getMCloseBtn", "()Landroid/widget/Button;", "mCloseBtn$delegate", "mDescTv", "Landroid/widget/TextView;", "getMDescTv", "()Landroid/widget/TextView;", "mDescTv$delegate", "mGoMainBtn", "getMGoMainBtn", "mGoMainBtn$delegate", "mOpenBtn", "getMOpenBtn", "mOpenBtn$delegate", "mSettingContainer", "Landroid/widget/LinearLayout;", "getMSettingContainer", "()Landroid/widget/LinearLayout;", "mSettingContainer$delegate", "toast", "Landroid/widget/Toast;", "doFifthProcess", "", "doFirstProcess", "doFourthProcess", "auto", "", "doFourthProcessImpl", "doInstall", "doSecondProcess", "doThirdProcess", "doUnInstall", "getForceOrientation", "getLayoutId", "initUI", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "setupStatuBar", "updateProfile", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WelabHldInfoUI
  extends MMActivity
  implements View.OnClickListener
{
  private static final j<Integer> AIl;
  public static final WelabHldInfoUI.a JxT;
  private static final int Jyb;
  private final j CWP;
  private Toast HDo;
  private final j JxU;
  private final j JxV;
  private final j JxW;
  private final j JxX;
  private final c JxY;
  private final d JxZ;
  private final ViewTreeObserver.OnWindowFocusChangeListener Jya;
  private final j bcL;
  private int enterScene;
  
  static
  {
    AppMethodBeat.i(312454);
    JxT = new WelabHldInfoUI.a((byte)0);
    AIl = kotlin.k.cm((kotlin.g.a.a)WelabHldInfoUI.b.Jyc);
    Jyb = bd.fromDPToPix(MMApplicationContext.getContext(), 184);
    AppMethodBeat.o(312454);
  }
  
  public WelabHldInfoUI()
  {
    AppMethodBeat.i(312272);
    this.JxU = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.JxV = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.JxW = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.CWP = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.JxX = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.enterScene = 6;
    this.bcL = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.JxY = new c(this, new Handler());
    this.JxZ = new d(this, new Handler());
    this.Jya = new WelabHldInfoUI..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(312272);
  }
  
  private final InputMethodManager Bt()
  {
    AppMethodBeat.i(312317);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.bcL.getValue();
    AppMethodBeat.o(312317);
    return localInputMethodManager;
  }
  
  private static final void a(WelabHldInfoUI paramWelabHldInfoUI)
  {
    AppMethodBeat.i(312419);
    kotlin.g.b.s.u(paramWelabHldInfoUI, "this$0");
    paramWelabHldInfoUI.fNL();
    AppMethodBeat.o(312419);
  }
  
  private static final void a(WelabHldInfoUI paramWelabHldInfoUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(312413);
    kotlin.g.b.s.u(paramWelabHldInfoUI, "this$0");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    Log.i("WxIme.WelabHldInfoUI", "click close ime");
    paramWelabHldInfoUI.Bt().showInputMethodPicker();
    AppMethodBeat.o(312413);
  }
  
  private static final void a(WelabHldInfoUI paramWelabHldInfoUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(312400);
    kotlin.g.b.s.u(paramWelabHldInfoUI, "this$0");
    params.a(0, paramWelabHldInfoUI.getContext().getResources().getColor(a.c.red_text_color), (CharSequence)paramWelabHldInfoUI.getContext().getString(a.j.settings_plugins_uninstall));
    AppMethodBeat.o(312400);
  }
  
  private static final void a(WelabHldInfoUI paramWelabHldInfoUI, boolean paramBoolean)
  {
    AppMethodBeat.i(312386);
    kotlin.g.b.s.u(paramWelabHldInfoUI, "this$0");
    paramWelabHldInfoUI.dvr();
    AppMethodBeat.o(312386);
  }
  
  private static final boolean a(WelabHldInfoUI paramWelabHldInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312392);
    kotlin.g.b.s.u(paramWelabHldInfoUI, "this$0");
    paramWelabHldInfoUI.hideVKB();
    paramWelabHldInfoUI.finish();
    AppMethodBeat.o(312392);
    return true;
  }
  
  private final void dvr()
  {
    AppMethodBeat.i(312327);
    Object localObject = l.JyV;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    if (l.iA((Context)localObject))
    {
      fNC().setText(a.j.settings_plugins_installed);
      fND().setVisibility(0);
      fNG().setVisibility(0);
      fNF().setVisibility(0);
      fNE().setVisibility(8);
      AppMethodBeat.o(312327);
      return;
    }
    fNC().setText(a.j.welab_name_hld_desc);
    fND().setVisibility(8);
    fNG().setVisibility(8);
    fNF().setVisibility(8);
    fNE().setVisibility(0);
    AppMethodBeat.o(312327);
  }
  
  private final TextView fNC()
  {
    AppMethodBeat.i(312282);
    Object localObject = this.JxU.getValue();
    kotlin.g.b.s.s(localObject, "<get-mDescTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312282);
    return localObject;
  }
  
  private final LinearLayout fND()
  {
    AppMethodBeat.i(312286);
    Object localObject = this.JxV.getValue();
    kotlin.g.b.s.s(localObject, "<get-mSettingContainer>(...)");
    localObject = (LinearLayout)localObject;
    AppMethodBeat.o(312286);
    return localObject;
  }
  
  private final Button fNE()
  {
    AppMethodBeat.i(312294);
    Object localObject = this.JxW.getValue();
    kotlin.g.b.s.s(localObject, "<get-mOpenBtn>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312294);
    return localObject;
  }
  
  private final Button fNF()
  {
    AppMethodBeat.i(312301);
    Object localObject = this.CWP.getValue();
    kotlin.g.b.s.s(localObject, "<get-mCloseBtn>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312301);
    return localObject;
  }
  
  private final Button fNG()
  {
    AppMethodBeat.i(312309);
    Object localObject = this.JxX.getValue();
    kotlin.g.b.s.s(localObject, "<get-mGoMainBtn>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312309);
    return localObject;
  }
  
  private final void fNH()
  {
    AppMethodBeat.i(312332);
    Object localObject = l.JyV;
    if (!l.fOT())
    {
      fNI();
      AppMethodBeat.o(312332);
      return;
    }
    localObject = l.JyV;
    if (!l.fOW())
    {
      fNJ();
      AppMethodBeat.o(312332);
      return;
    }
    localObject = l.JyV;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    if (!l.iC((Context)localObject))
    {
      fNK();
      AppMethodBeat.o(312332);
      return;
    }
    localObject = l.JyV;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    if (!l.iD((Context)localObject))
    {
      xb(false);
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.jp(3, this.enterScene);
      AppMethodBeat.o(312332);
      return;
    }
    localObject = l.JyV;
    if (!l.fOZ())
    {
      fNM();
      AppMethodBeat.o(312332);
      return;
    }
    dvr();
    AppMethodBeat.o(312332);
  }
  
  private final void fNI()
  {
    AppMethodBeat.i(312342);
    Object localObject = new Intent((Context)getContext(), HldPrivacyInfoUI.class);
    ((Intent)localObject).putExtra("ime_enter_scene", this.enterScene);
    getContext().startActivityForResult((Intent)localObject, 1);
    localObject = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.jp(7, this.enterScene);
    AppMethodBeat.o(312342);
  }
  
  private final void fNJ()
  {
    AppMethodBeat.i(312349);
    Object localObject = new Intent((Context)getContext(), HldPrepare9UI.class);
    ((Intent)localObject).putExtra("ime_enter_scene", this.enterScene);
    getContext().startActivityForResult((Intent)localObject, 2);
    localObject = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.jp(9, this.enterScene);
    AppMethodBeat.o(312349);
  }
  
  private final void fNK()
  {
    AppMethodBeat.i(312355);
    Object localObject1 = new Intent("android.settings.INPUT_METHOD_SETTINGS");
    ((Intent)localObject1).setFlags(67108864);
    getContext().startActivityForResult((Intent)localObject1, 3);
    Object localObject2 = new Intent((Context)getContext(), HldGuideActivity.class);
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "doThirdProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "doThirdProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getContext().overridePendingTransition(0, 0);
    localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.jp(2, this.enterScene);
    AppMethodBeat.o(312355);
  }
  
  private final void fNL()
  {
    AppMethodBeat.i(312370);
    Object localObject = l.JyV;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    if (l.iC((Context)localObject))
    {
      localObject = l.JyV;
      localObject = getContext();
      kotlin.g.b.s.s(localObject, "context");
      if (!l.iD((Context)localObject)) {
        Bt().showInputMethodPicker();
      }
    }
    AppMethodBeat.o(312370);
  }
  
  private final void fNM()
  {
    AppMethodBeat.i(312377);
    Intent localIntent = new Intent((Context)getContext(), HldPrepare10UI.class);
    getContext().startActivityForResult(localIntent, 4);
    AppMethodBeat.o(312377);
  }
  
  private final void xb(boolean paramBoolean)
  {
    AppMethodBeat.i(312363);
    Log.d("WxIme.WelabHldInfoUI", kotlin.g.b.s.X("handleStep2 ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      h.ahAA.o(new WelabHldInfoUI..ExternalSyntheticLambda4(this), 500L);
      AppMethodBeat.o(312363);
      return;
    }
    fNL();
    AppMethodBeat.o(312363);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return a.h.welab_appinfo_hld;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(312529);
    super.initView();
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    setMMTitleVisibility(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = getWindow();
      ((Window)localObject1).clearFlags(201326592);
      ((Window)localObject1).addFlags(-2147483648);
      ((Window)localObject1).setStatusBarColor(getResources().getColor(a.c.hld_welab_main_color));
    }
    setActionbarColor(getResources().getColor(a.c.hld_welab_main_color));
    setNavigationbarColor(getResources().getColor(a.c.hld_welab_main_color));
    setBackBtn(new WelabHldInfoUI..ExternalSyntheticLambda0(this));
    fND().setOnClickListener((View.OnClickListener)this);
    fNE().setOnClickListener((View.OnClickListener)this);
    fNG().setOnClickListener((View.OnClickListener)this);
    fNF().setOnClickListener((View.OnClickListener)this);
    dvr();
    int i = ((Number)AIl.getValue()).intValue() - Jyb;
    Object localObject1 = (ImageView)findViewById(a.f.hld_img);
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(312529);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).height = ((int)(i * 0.45F));
    ((ViewGroup.MarginLayoutParams)localObject2).width = ((int)(((ViewGroup.MarginLayoutParams)localObject2).height * 0.525F));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (Button)findViewById(a.f.open_btn);
    localObject2 = ((Button)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(312529);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i * 0.219F));
    ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (Button)findViewById(a.f.go_main_btn);
    localObject2 = ((Button)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(312529);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i * 0.14F));
    ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    AppMethodBeat.o(312529);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(312566);
    Log.i("WxIme.WelabHldInfoUI", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(312566);
      return;
    }
    if (paramInt2 == -1)
    {
      fNH();
      if (paramInt1 == 4)
      {
        z.a(null, (CharSequence)getContext().getResources().getString(a.j.ime_active_finish), (Context)getContext(), 0, null);
        AppMethodBeat.o(312566);
        return;
      }
    }
    AppMethodBeat.o(312566);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312579);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.hld_setting_container;
      if (paramView != null) {
        break label111;
      }
      label53:
      i = a.f.open_btn;
      if (paramView != null) {
        break label217;
      }
      label61:
      i = a.f.go_main_btn;
      if (paramView != null) {
        break label245;
      }
      label69:
      i = a.f.close_btn;
      if (paramView != null) {
        break label288;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312579);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label111:
      if (paramView.intValue() != i) {
        break label53;
      }
      localObject = new Intent((Context)getContext(), HldSettingUI.class);
      paramView = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      label217:
      if (paramView.intValue() != i) {
        break label61;
      }
      fNH();
      paramView = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.jp(13, this.enterScene);
      continue;
      label245:
      if (paramView.intValue() != i) {
        break label69;
      }
      paramView = new Intent();
      paramView.addFlags(268435456).addFlags(67108864);
      c.g(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", paramView);
      continue;
      label288:
      if (paramView.intValue() == i)
      {
        paramView = new f((Context)getContext(), 1, true);
        paramView.h((CharSequence)getContext().getString(a.j.contact_info_wxime_uninstall_tip), 17, com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 14));
        paramView.Vtg = new WelabHldInfoUI..ExternalSyntheticLambda2(this);
        paramView.GAC = new WelabHldInfoUI..ExternalSyntheticLambda3(this);
        paramView.dDn();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312511);
    super.onCreate(paramBundle);
    initView();
    getContext().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("enabled_input_methods"), false, (ContentObserver)this.JxY);
    getContext().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("default_input_method"), false, (ContentObserver)this.JxZ);
    this.enterScene = getContext().getIntent().getIntExtra("ime_enter_scene", 6);
    boolean bool = getContext().getIntent().getBooleanExtra("ime_open_active", false);
    Log.i("WxIme.WelabHldInfoUI", "onActivityCreate " + this.enterScene + ' ' + bool);
    if (bool) {
      fNH();
    }
    paramBundle = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.aL(0, 3, 3);
    paramBundle = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.jp(1, this.enterScene);
    AppMethodBeat.o(312511);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(312556);
    super.onDestroy();
    getContext().getContentResolver().unregisterContentObserver((ContentObserver)this.JxY);
    getContext().getContentResolver().unregisterContentObserver((ContentObserver)this.JxZ);
    AppMethodBeat.o(312556);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(312541);
    super.onResume();
    getContext().getWindow().getDecorView().getViewTreeObserver().addOnWindowFocusChangeListener(this.Jya);
    boolean bool = getContext().getIntent().getBooleanExtra("ime_auto_open_choose_list", false);
    Log.i("WxIme.WelabHldInfoUI", kotlin.g.b.s.X("onActivityResumed autoOpenChooseList:", Boolean.valueOf(bool)));
    Object localObject = this.HDo;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    this.HDo = null;
    if (bool)
    {
      getContext().getIntent().putExtra("ime_auto_open_choose_list", false);
      xb(true);
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.jp(6, this.enterScene);
      localObject = aa.makeText((Context)getContext(), (CharSequence)getContext().getString(a.j.ime_collect_info_choose_ime), 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    AppMethodBeat.o(312541);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(312550);
    super.onStop();
    getContext().getWindow().getDecorView().getViewTreeObserver().removeOnWindowFocusChangeListener(this.Jya);
    AppMethodBeat.o(312550);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeActiveObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ContentObserver
  {
    c(WelabHldInfoUI paramWelabHldInfoUI, Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(312223);
      super.onChange(paramBoolean);
      Object localObject = l.JyV;
      localObject = this.Jyd.getContext();
      kotlin.g.b.s.s(localObject, "context");
      boolean bool = l.iC((Context)localObject);
      Log.i("WxIme.WelabHldInfoUI", "isActive:" + bool + " selfChange:" + paramBoolean);
      if (bool)
      {
        localObject = l.JyV;
        localObject = this.Jyd.getContext();
        kotlin.g.b.s.s(localObject, "context");
        l.ix((Context)localObject);
        localObject = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.Yy(2);
      }
      AppMethodBeat.o(312223);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeDefaultObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends ContentObserver
  {
    d(WelabHldInfoUI paramWelabHldInfoUI, Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(312248);
      super.onChange(paramBoolean);
      Object localObject = l.JyV;
      localObject = this.Jyd.getContext();
      kotlin.g.b.s.s(localObject, "context");
      boolean bool = l.iD((Context)localObject);
      Log.i("WxIme.WelabHldInfoUI", "isDefault:" + bool + " selfChange:" + paramBoolean);
      if (bool)
      {
        WelabHldInfoUI.b(this.Jyd);
        localObject = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.Yy(3);
        localObject = l.JyV;
        l.xr(true);
        z.a(null, (CharSequence)this.Jyd.getContext().getResources().getString(a.j.ime_active_finish), (Context)this.Jyd.getContext(), 2, null);
        AppMethodBeat.o(312248);
        return;
      }
      WelabHldInfoUI.c(this.Jyd);
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.Yy(4);
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.jp(4, WelabHldInfoUI.d(this.Jyd));
      localObject = l.JyV;
      l.xr(false);
      AppMethodBeat.o(312248);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/inputmethod/InputMethodManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<InputMethodManager>
  {
    e(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Button>
  {
    f(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TextView>
  {
    g(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Button>
  {
    h(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Button>
  {
    i(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    j(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.WelabHldInfoUI
 * JD-Core Version:    0.7.0.1
 */