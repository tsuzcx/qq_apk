package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
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
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "()V", "enterScene", "", "imeActiveObserver", "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeActiveObserver$1", "Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeActiveObserver$1;", "imeDefaultObserver", "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeDefaultObserver$1", "Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeDefaultObserver$1;", "imm", "Landroid/view/inputmethod/InputMethodManager;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lkotlin/Lazy;", "listener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "mCloseBtn", "Landroid/widget/Button;", "getMCloseBtn", "()Landroid/widget/Button;", "mCloseBtn$delegate", "mDescTv", "Landroid/widget/TextView;", "getMDescTv", "()Landroid/widget/TextView;", "mDescTv$delegate", "mGoMainBtn", "getMGoMainBtn", "mGoMainBtn$delegate", "mOpenBtn", "getMOpenBtn", "mOpenBtn$delegate", "mSettingContainer", "Landroid/widget/LinearLayout;", "getMSettingContainer", "()Landroid/widget/LinearLayout;", "mSettingContainer$delegate", "toast", "Landroid/widget/Toast;", "doFifthProcess", "", "doFirstProcess", "doFourthProcess", "auto", "", "doFourthProcessImpl", "doInstall", "doSecondProcess", "doThirdProcess", "doUnInstall", "getForceOrientation", "getLayoutId", "initUI", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "setupStatuBar", "updateProfile", "Companion", "plugin-hld_release"})
public final class WelabHldInfoUI
  extends MMActivity
  implements View.OnClickListener
{
  private static final int DGD;
  public static final a DGE;
  private static final f xjs;
  private Toast BRG;
  private final f DGA;
  private final g DGB;
  private final ViewTreeObserver.OnWindowFocusChangeListener DGC;
  private final f DGu;
  private final f DGv;
  private final f DGw;
  private final f DGx;
  private final f DGy;
  private final f DGz;
  private int enterScene;
  
  static
  {
    AppMethodBeat.i(212197);
    DGE = new a((byte)0);
    xjs = g.ar((kotlin.g.a.a)WelabHldInfoUI.b.DGF);
    DGD = aw.fromDPToPix(MMApplicationContext.getContext(), 184);
    AppMethodBeat.o(212197);
  }
  
  public WelabHldInfoUI()
  {
    AppMethodBeat.i(212195);
    this.DGu = g.ar((kotlin.g.a.a)new l(this));
    this.DGv = g.ar((kotlin.g.a.a)new o(this));
    this.DGw = g.ar((kotlin.g.a.a)new n(this));
    this.DGx = g.ar((kotlin.g.a.a)new k(this));
    this.DGy = g.ar((kotlin.g.a.a)new m(this));
    this.enterScene = 6;
    this.DGz = g.ar((kotlin.g.a.a)new h(this));
    this.DGA = new f(this, new Handler());
    this.DGB = new g(this, new Handler());
    this.DGC = ((ViewTreeObserver.OnWindowFocusChangeListener)new j(this));
    AppMethodBeat.o(212195);
  }
  
  private final void cQY()
  {
    AppMethodBeat.i(212170);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = getContext();
    p.j(localObject, "context");
    if (com.tencent.mm.plugin.hld.f.l.hf((Context)localObject))
    {
      eFI().setText(a.j.settings_plugins_installed);
      eFJ().setVisibility(0);
      eFM().setVisibility(0);
      eFL().setVisibility(0);
      eFK().setVisibility(8);
      AppMethodBeat.o(212170);
      return;
    }
    eFI().setText(a.j.welab_name_hld_desc);
    eFJ().setVisibility(8);
    eFM().setVisibility(8);
    eFL().setVisibility(8);
    eFK().setVisibility(0);
    AppMethodBeat.o(212170);
  }
  
  private final TextView eFI()
  {
    AppMethodBeat.i(212144);
    TextView localTextView = (TextView)this.DGu.getValue();
    AppMethodBeat.o(212144);
    return localTextView;
  }
  
  private final LinearLayout eFJ()
  {
    AppMethodBeat.i(212145);
    LinearLayout localLinearLayout = (LinearLayout)this.DGv.getValue();
    AppMethodBeat.o(212145);
    return localLinearLayout;
  }
  
  private final Button eFK()
  {
    AppMethodBeat.i(212146);
    Button localButton = (Button)this.DGw.getValue();
    AppMethodBeat.o(212146);
    return localButton;
  }
  
  private final Button eFL()
  {
    AppMethodBeat.i(212148);
    Button localButton = (Button)this.DGx.getValue();
    AppMethodBeat.o(212148);
    return localButton;
  }
  
  private final Button eFM()
  {
    AppMethodBeat.i(212149);
    Button localButton = (Button)this.DGy.getValue();
    AppMethodBeat.o(212149);
    return localButton;
  }
  
  private final InputMethodManager eFN()
  {
    AppMethodBeat.i(212151);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.DGz.getValue();
    AppMethodBeat.o(212151);
    return localInputMethodManager;
  }
  
  private final void eFO()
  {
    AppMethodBeat.i(212175);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    if (!com.tencent.mm.plugin.hld.f.l.eHk())
    {
      eFP();
      AppMethodBeat.o(212175);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    if (!com.tencent.mm.plugin.hld.f.l.eHn())
    {
      eFQ();
      AppMethodBeat.o(212175);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = getContext();
    p.j(localObject, "context");
    if (!com.tencent.mm.plugin.hld.f.l.hh((Context)localObject))
    {
      eFR();
      AppMethodBeat.o(212175);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = getContext();
    p.j(localObject, "context");
    if (!com.tencent.mm.plugin.hld.f.l.hi((Context)localObject))
    {
      sW(false);
      localObject = k.DDb;
      k.hL(3, this.enterScene);
      AppMethodBeat.o(212175);
      return;
    }
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    if (!com.tencent.mm.plugin.hld.f.l.eHq())
    {
      eFT();
      AppMethodBeat.o(212175);
      return;
    }
    cQY();
    AppMethodBeat.o(212175);
  }
  
  private final void eFP()
  {
    AppMethodBeat.i(212177);
    Object localObject = new Intent((Context)getContext(), HldPrivacyInfoUI.class);
    ((Intent)localObject).putExtra("ime_enter_scene", this.enterScene);
    getContext().startActivityForResult((Intent)localObject, 1);
    localObject = k.DDb;
    k.hL(7, this.enterScene);
    AppMethodBeat.o(212177);
  }
  
  private final void eFQ()
  {
    AppMethodBeat.i(212180);
    Object localObject = new Intent((Context)getContext(), HldPrepare9UI.class);
    ((Intent)localObject).putExtra("ime_enter_scene", this.enterScene);
    getContext().startActivityForResult((Intent)localObject, 2);
    localObject = k.DDb;
    k.hL(9, this.enterScene);
    AppMethodBeat.o(212180);
  }
  
  private final void eFR()
  {
    AppMethodBeat.i(212182);
    Object localObject1 = new Intent("android.settings.INPUT_METHOD_SETTINGS");
    ((Intent)localObject1).setFlags(67108864);
    getContext().startActivityForResult((Intent)localObject1, 3);
    Object localObject2 = new Intent((Context)getContext(), HldGuideActivity.class);
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "doThirdProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "doThirdProcess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    getContext().overridePendingTransition(0, 0);
    localObject1 = k.DDb;
    k.hL(2, this.enterScene);
    AppMethodBeat.o(212182);
  }
  
  private final void eFS()
  {
    AppMethodBeat.i(212187);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = getContext();
    p.j(localObject, "context");
    if (com.tencent.mm.plugin.hld.f.l.hh((Context)localObject))
    {
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject = getContext();
      p.j(localObject, "context");
      if (!com.tencent.mm.plugin.hld.f.l.hi((Context)localObject)) {
        eFN().showInputMethodPicker();
      }
    }
    AppMethodBeat.o(212187);
  }
  
  private final void eFT()
  {
    AppMethodBeat.i(212190);
    Intent localIntent = new Intent((Context)getContext(), HldPrepare10UI.class);
    getContext().startActivityForResult(localIntent, 4);
    AppMethodBeat.o(212190);
  }
  
  private final void sW(boolean paramBoolean)
  {
    AppMethodBeat.i(212184);
    Log.d("WxIme.WelabHldInfoUI", "handleStep2 ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      h.ZvG.n((Runnable)new c(this), 500L);
      AppMethodBeat.o(212184);
      return;
    }
    eFS();
    AppMethodBeat.o(212184);
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
    AppMethodBeat.i(212160);
    super.initView();
    setIsDarkActionbarBg(true);
    hideActionbarLine();
    setMMTitleVisibility(8);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = getWindow();
      ((Window)localObject1).clearFlags(201326592);
      ((Window)localObject1).addFlags(-2147483648);
      p.j(localObject1, "window");
      ((Window)localObject1).setStatusBarColor(getResources().getColor(a.c.hld_welab_main_color));
    }
    setActionbarColor(getResources().getColor(a.c.hld_welab_main_color));
    setNavigationbarColor(getResources().getColor(a.c.hld_welab_main_color));
    setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
    eFJ().setOnClickListener((View.OnClickListener)this);
    eFK().setOnClickListener((View.OnClickListener)this);
    eFM().setOnClickListener((View.OnClickListener)this);
    eFL().setOnClickListener((View.OnClickListener)this);
    cQY();
    int i = ((Number)xjs.getValue()).intValue() - DGD;
    Object localObject1 = (ImageView)findViewById(a.f.hld_img);
    p.j(localObject1, "imgview");
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212160);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).height = ((int)(i * 0.45F));
    ((ViewGroup.MarginLayoutParams)localObject2).width = ((int)(((ViewGroup.MarginLayoutParams)localObject2).height * 0.525F));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (Button)findViewById(a.f.open_btn);
    p.j(localObject1, "openButtonView");
    localObject2 = ((Button)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212160);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i * 0.219F));
    ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (Button)findViewById(a.f.go_main_btn);
    p.j(localObject1, "goButtonView");
    localObject2 = ((Button)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212160);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)(i * 0.14F));
    ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    AppMethodBeat.o(212160);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212166);
    Log.i("WxIme.WelabHldInfoUI", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(212166);
      return;
    }
    if (paramInt2 == -1)
    {
      eFO();
      if (paramInt1 == 4)
      {
        paramIntent = getContext();
        p.j(paramIntent, "context");
        v.a((CharSequence)paramIntent.getResources().getString(a.j.ime_active_finish), (Context)getContext(), 0, null);
        AppMethodBeat.o(212166);
        return;
      }
    }
    AppMethodBeat.o(212166);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212173);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.hld_setting_container;
      if (paramView != null) {
        break label111;
      }
      label59:
      i = a.f.open_btn;
      if (paramView != null) {
        break label217;
      }
      label67:
      i = a.f.go_main_btn;
      if (paramView != null) {
        break label245;
      }
      label75:
      i = a.f.close_btn;
      if (paramView != null) {
        break label288;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212173);
      return;
      paramView = null;
      break;
      label111:
      if (paramView.intValue() != i) {
        break label59;
      }
      localObject = new Intent((Context)getContext(), HldSettingUI.class);
      paramView = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/ui/WelabHldInfoUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      continue;
      label217:
      if (paramView.intValue() != i) {
        break label67;
      }
      eFO();
      paramView = k.DDb;
      k.hL(13, this.enterScene);
      continue;
      label245:
      if (paramView.intValue() != i) {
        break label75;
      }
      paramView = new Intent();
      paramView.addFlags(268435456).addFlags(67108864);
      c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", paramView);
      continue;
      label288:
      if (paramView.intValue() == i)
      {
        paramView = new e((Context)getContext(), 1, true);
        paramView.j((CharSequence)getContext().getString(a.j.contact_info_wxime_uninstall_tip), 17, com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 14));
        paramView.a((q.f)new d(this));
        paramView.a((q.g)new e(this));
        paramView.eik();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212157);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("enabled_input_methods"), false, (ContentObserver)this.DGA);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("default_input_method"), false, (ContentObserver)this.DGB);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    this.enterScene = paramBundle.getIntent().getIntExtra("ime_enter_scene", 6);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    boolean bool = paramBundle.getIntent().getBooleanExtra("ime_open_active", false);
    Log.i("WxIme.WelabHldInfoUI", "onActivityCreate " + this.enterScene + ' ' + bool);
    if (bool) {
      eFO();
    }
    paramBundle = k.DDb;
    k.ap(0, 3, 3);
    paramBundle = k.DDb;
    k.hL(1, this.enterScene);
    AppMethodBeat.o(212157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212163);
    super.onDestroy();
    AppCompatActivity localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    localAppCompatActivity.getContentResolver().unregisterContentObserver((ContentObserver)this.DGA);
    localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    localAppCompatActivity.getContentResolver().unregisterContentObserver((ContentObserver)this.DGB);
    AppMethodBeat.o(212163);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212161);
    super.onResume();
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getWindow();
    p.j(localObject, "context.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "context.window.decorView");
    ((View)localObject).getViewTreeObserver().addOnWindowFocusChangeListener(this.DGC);
    localObject = getContext();
    p.j(localObject, "context");
    boolean bool = ((AppCompatActivity)localObject).getIntent().getBooleanExtra("ime_auto_open_choose_list", false);
    Log.i("WxIme.WelabHldInfoUI", "onActivityResumed autoOpenChooseList:".concat(String.valueOf(bool)));
    localObject = this.BRG;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    this.BRG = null;
    if (bool)
    {
      localObject = getContext();
      p.j(localObject, "context");
      ((AppCompatActivity)localObject).getIntent().putExtra("ime_auto_open_choose_list", false);
      sW(true);
      localObject = k.DDb;
      k.hL(6, this.enterScene);
      localObject = w.makeText((Context)getContext(), (CharSequence)getContext().getString(a.j.ime_collect_info_choose_ime), 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    AppMethodBeat.o(212161);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(212162);
    super.onStop();
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((AppCompatActivity)localObject).getWindow();
    p.j(localObject, "context.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "context.window.decorView");
    ((View)localObject).getViewTreeObserver().removeOnWindowFocusChangeListener(this.DGC);
    AppMethodBeat.o(212162);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/WelabHldInfoUI$Companion;", "", "()V", "REQUEST_CODE_ACTIVE_FIFTH_PROCESS_ACTIVE", "", "REQUEST_CODE_ACTIVE_FIRST_PROCESS_PRIVACY_INFO", "REQUEST_CODE_ACTIVE_SECOND_PROCESS_COLLECT_DATA", "REQUEST_CODE_ACTIVE_THIRD_PROCESS_ACTIVE", "TAG", "", "TOP_HEIGHT", "getTOP_HEIGHT", "()I", "displayHeight", "getDisplayHeight", "displayHeight$delegate", "Lkotlin/Lazy;", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(WelabHldInfoUI paramWelabHldInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(212067);
      WelabHldInfoUI.b(this.DGG);
      AppMethodBeat.o(212067);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(WelabHldInfoUI paramWelabHldInfoUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(209761);
      AppCompatActivity localAppCompatActivity = this.DGG.getContext();
      p.j(localAppCompatActivity, "context");
      paramo.a(0, localAppCompatActivity.getResources().getColor(a.c.red_text_color), (CharSequence)this.DGG.getContext().getString(a.j.settings_plugins_uninstall));
      AppMethodBeat.o(209761);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(WelabHldInfoUI paramWelabHldInfoUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(213126);
      p.k(paramMenuItem, "menuItem");
      Log.i("WxIme.WelabHldInfoUI", "click close ime");
      WelabHldInfoUI.a(this.DGG).showInputMethodPicker();
      AppMethodBeat.o(213126);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeActiveObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-hld_release"})
  public static final class f
    extends ContentObserver
  {
    f(Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(210033);
      super.onChange(paramBoolean);
      Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject = this.DGG.getContext();
      p.j(localObject, "context");
      boolean bool = com.tencent.mm.plugin.hld.f.l.hh((Context)localObject);
      Log.i("WxIme.WelabHldInfoUI", "isActive:" + bool + " selfChange:" + paramBoolean);
      if (bool)
      {
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject = this.DGG.getContext();
        p.j(localObject, "context");
        com.tencent.mm.plugin.hld.f.l.hc((Context)localObject);
        localObject = k.DDb;
        k.UB(2);
      }
      AppMethodBeat.o(210033);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/ui/WelabHldInfoUI$imeDefaultObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-hld_release"})
  public static final class g
    extends ContentObserver
  {
    g(Handler paramHandler)
    {
      super();
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(216967);
      super.onChange(paramBoolean);
      Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      localObject = this.DGG.getContext();
      p.j(localObject, "context");
      boolean bool = com.tencent.mm.plugin.hld.f.l.hi((Context)localObject);
      Log.i("WxIme.WelabHldInfoUI", "isDefault:" + bool + " selfChange:" + paramBoolean);
      if (bool)
      {
        WelabHldInfoUI.c(this.DGG);
        localObject = k.DDb;
        k.UB(3);
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.tg(true);
        localObject = this.DGG.getContext();
        p.j(localObject, "context");
        v.a((CharSequence)((AppCompatActivity)localObject).getResources().getString(a.j.ime_active_finish), (Context)this.DGG.getContext(), 2, null);
        AppMethodBeat.o(216967);
        return;
      }
      WelabHldInfoUI.d(this.DGG);
      localObject = k.DDb;
      k.UB(4);
      localObject = k.DDb;
      k.hL(4, WelabHldInfoUI.e(this.DGG));
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.tg(false);
      AppMethodBeat.o(216967);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/inputmethod/InputMethodManager;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<InputMethodManager>
  {
    h(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(WelabHldInfoUI paramWelabHldInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(210568);
      this.DGG.hideVKB();
      this.DGG.finish();
      AppMethodBeat.o(210568);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onWindowFocusChanged"})
  static final class j
    implements ViewTreeObserver.OnWindowFocusChangeListener
  {
    j(WelabHldInfoUI paramWelabHldInfoUI) {}
    
    public final void onWindowFocusChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(217564);
      WelabHldInfoUI.d(this.DGG);
      AppMethodBeat.o(217564);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Button>
  {
    k(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<TextView>
  {
    l(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<Button>
  {
    m(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<Button>
  {
    n(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    o(WelabHldInfoUI paramWelabHldInfoUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.WelabHldInfoUI
 * JD-Core Version:    0.7.0.1
 */