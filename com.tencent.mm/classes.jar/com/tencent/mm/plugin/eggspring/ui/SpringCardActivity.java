package com.tencent.mm.plugin.eggspring.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.eggspring.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "clicked", "", "delayShowLoading", "Ljava/lang/Runnable;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "luckyBagLoadingImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "luckyBagLoop", "rootLayout", "Landroid/view/ViewGroup;", "uiHandler", "Landroid/os/Handler;", "adjustCloseBtnColor", "", "color", "", "boundView", "finish", "getForceOrientation", "getLayoutId", "initBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity
  extends MMActivity
{
  public static final SpringCardActivity.a qVs;
  private Handler cPw;
  private boolean hau;
  private ViewGroup qVm;
  private MMAnimateView qVn;
  private MMAnimateView qVo;
  private o qVp;
  private q qVq;
  private final Runnable qVr;
  
  static
  {
    AppMethodBeat.i(108208);
    qVs = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.qVr = ((Runnable)new c(this));
    AppMethodBeat.o(108207);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(194580);
    q localq = this.qVq;
    if (localq != null) {
      localq.dismiss();
    }
    super.finish();
    AppMethodBeat.o(194580);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131496543;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(194578);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      finish();
    }
    AppMethodBeat.o(194578);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108179);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.cPw = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131690761);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131101168);
    setActionbarColor(i);
    if (ar.aln(i)) {
      updateBackBtn(ar.m((Context)this, 2131690761, -1));
    }
    for (;;)
    {
      hideActionbarLine();
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(2050);
      supportLightStatusBar();
      paramBundle = findViewById(2131307165);
      p.g(paramBundle, "findViewById(R.id.root_layout)");
      this.qVm = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131304012);
      p.g(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
      this.qVn = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131304013);
      p.g(paramBundle, "findViewById(R.id.lucky_bag_loading_loop)");
      this.qVo = ((MMAnimateView)paramBundle);
      paramBundle = (View.OnClickListener)new b(this);
      Object localObject = this.qVn;
      if (localObject == null) {
        p.btv("luckyBagLoadingImg");
      }
      ((MMAnimateView)localObject).setOnClickListener(paramBundle);
      localObject = this.qVo;
      if (localObject == null) {
        p.btv("luckyBagLoop");
      }
      ((MMAnimateView)localObject).setOnClickListener(paramBundle);
      this.qVp = ((o)new e());
      paramBundle = AppForegroundDelegate.djR;
      localObject = this.qVp;
      if (localObject == null) {
        p.btv("appForegroundLis");
      }
      paramBundle.a((o)localObject);
      AppMethodBeat.o(108179);
      return;
      updateBackBtn(ar.m((Context)this, 2131690761, -16777216));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Log.i("MicroMsg.SpringCardActivity", "onDestroy: ");
    Object localObject = com.tencent.mm.plugin.eggspring.c.qUO;
    com.tencent.mm.plugin.eggspring.c.cEH().FF(16);
    localObject = AppForegroundDelegate.djR;
    o localo = this.qVp;
    if (localo == null) {
      p.btv("appForegroundLis");
    }
    ((AppForegroundDelegate)localObject).b(localo);
    AppMethodBeat.o(108183);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(108181);
    super.onResume();
    Log.i("MicroMsg.SpringCardActivity", "onResume: ");
    c.a locala = com.tencent.mm.plugin.eggspring.c.qUO;
    com.tencent.mm.plugin.eggspring.c.cEH().FF(1);
    AppMethodBeat.o(108181);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(194579);
    super.onStop();
    Log.i("MicroMsg.SpringCardActivity", "onStop: " + this.hau);
    if (this.hau) {
      finish();
    }
    AppMethodBeat.o(194579);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(194574);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("MicroMsg.SpringCardActivity", "onClick: " + SpringCardActivity.a(this.qVt));
      if (SpringCardActivity.a(this.qVt))
      {
        a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194574);
        return;
      }
      SpringCardActivity.b(this.qVt);
      d.C(SpringCardActivity.c(this.qVt));
      d.a(1000L, SpringCardActivity.c(this.qVt));
      paramView = this.qVt.getContext();
      p.g(paramView, "context");
      int i = paramView.getResources().getColor(2131101168);
      paramView = new Intent();
      paramView.putExtra("customize_status_bar_color", i);
      paramView.putExtra("webview_bg_color_rsID", 2131101168);
      paramView.putExtra("from_shortcut", true);
      paramView.putExtra("disable_minimize", true);
      paramView.putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
      paramView.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
      com.tencent.mm.br.c.b((Context)this.qVt, "webview", ".ui.tools.WebViewUI", paramView, 1001);
      this.qVt.overridePendingTransition(2130772132, 2130771986);
      a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194574);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(194575);
      q localq = SpringCardActivity.d(this.qVt);
      if (localq != null) {
        localq.dismiss();
      }
      SpringCardActivity.a(this.qVt, q.a((Context)this.qVt, (CharSequence)this.qVt.getString(2131758480), true, 0, null));
      AppMethodBeat.o(194575);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SpringCardActivity paramSpringCardActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(162211);
      this.qVt.finish();
      AppMethodBeat.o(162211);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"})
  public static final class e
    implements o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(194577);
      Log.d("MicroMsg.SpringCardActivity", "onAppBackground");
      AppMethodBeat.o(194577);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(194576);
      Log.d("MicroMsg.SpringCardActivity", "onAppForeground");
      AppMethodBeat.o(194576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */