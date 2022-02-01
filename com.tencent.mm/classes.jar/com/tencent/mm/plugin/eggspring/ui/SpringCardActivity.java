package com.tencent.mm.plugin.eggspring.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.eggspring.d.a;
import com.tencent.mm.plugin.eggspring.d.b;
import com.tencent.mm.plugin.eggspring.d.e;
import com.tencent.mm.plugin.eggspring.d.f;
import com.tencent.mm.plugin.eggspring.d.g;
import com.tencent.mm.plugin.eggspring.d.h;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "clicked", "", "delayShowLoading", "Ljava/lang/Runnable;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "luckyBagLoadingImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "luckyBagLoop", "rootLayout", "Landroid/view/ViewGroup;", "uiHandler", "Landroid/os/Handler;", "adjustCloseBtnColor", "", "color", "", "boundView", "finish", "getForceOrientation", "getLayoutId", "initBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity
  extends MMActivity
{
  public static final SpringCardActivity.a uyc;
  private Handler cQo;
  private boolean jLv;
  private ViewGroup uxW;
  private MMAnimateView uxX;
  private MMAnimateView uxY;
  private o uxZ;
  private s uya;
  private final Runnable uyb;
  
  static
  {
    AppMethodBeat.i(108208);
    uyc = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.uyb = ((Runnable)new c(this));
    AppMethodBeat.o(108207);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(249453);
    s locals = this.uya;
    if (locals != null) {
      locals.dismiss();
    }
    super.finish();
    AppMethodBeat.o(249453);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return d.f.uxu;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(249448);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      finish();
    }
    AppMethodBeat.o(249448);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108179);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.cQo = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), d.g.icons_outlined_close);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    int i = paramBundle.getResources().getColor(d.b.uwQ);
    setActionbarColor(i);
    if (au.auk(i)) {
      updateBackBtn(au.o((Context)this, d.g.icons_outlined_close, -1));
    }
    for (;;)
    {
      hideActionbarLine();
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(2050);
      supportLightStatusBar();
      paramBundle = findViewById(d.e.root_layout);
      p.j(paramBundle, "findViewById(R.id.root_layout)");
      this.uxW = ((ViewGroup)paramBundle);
      paramBundle = findViewById(d.e.uxq);
      p.j(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
      this.uxX = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(d.e.uxr);
      p.j(paramBundle, "findViewById(R.id.lucky_bag_loading_loop)");
      this.uxY = ((MMAnimateView)paramBundle);
      paramBundle = (View.OnClickListener)new b(this);
      Object localObject = this.uxX;
      if (localObject == null) {
        p.bGy("luckyBagLoadingImg");
      }
      ((MMAnimateView)localObject).setOnClickListener(paramBundle);
      localObject = this.uxY;
      if (localObject == null) {
        p.bGy("luckyBagLoop");
      }
      ((MMAnimateView)localObject).setOnClickListener(paramBundle);
      this.uxZ = ((o)new e());
      paramBundle = AppForegroundDelegate.fby;
      localObject = this.uxZ;
      if (localObject == null) {
        p.bGy("appForegroundLis");
      }
      paramBundle.a((o)localObject);
      AppMethodBeat.o(108179);
      return;
      updateBackBtn(au.o((Context)this, d.g.icons_outlined_close, -16777216));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Log.i("MicroMsg.SpringCardActivity", "onDestroy: ");
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.fby;
    o localo = this.uxZ;
    if (localo == null) {
      p.bGy("appForegroundLis");
    }
    localAppForegroundDelegate.b(localo);
    AppMethodBeat.o(108183);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(108181);
    super.onResume();
    Log.i("MicroMsg.SpringCardActivity", "onResume: ");
    AppMethodBeat.o(108181);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(249452);
    super.onStop();
    Log.i("MicroMsg.SpringCardActivity", "onStop: " + this.jLv);
    if (this.jLv) {
      finish();
    }
    AppMethodBeat.o(249452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(249368);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("MicroMsg.SpringCardActivity", "onClick: " + SpringCardActivity.a(this.uyd));
      if (SpringCardActivity.a(this.uyd))
      {
        a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249368);
        return;
      }
      SpringCardActivity.b(this.uyd);
      d.C(SpringCardActivity.c(this.uyd));
      d.a(1000L, SpringCardActivity.c(this.uyd));
      paramView = this.uyd.getContext();
      p.j(paramView, "context");
      int i = paramView.getResources().getColor(d.b.uwQ);
      paramView = new Intent();
      paramView.putExtra("customize_status_bar_color", i);
      paramView.putExtra("webview_bg_color_rsID", d.b.uwQ);
      paramView.putExtra("from_shortcut", true);
      paramView.putExtra("disable_minimize", true);
      paramView.putExtra("MMActivity.OverrideEnterAnimation", d.a.anim_not_change);
      paramView.putExtra("MMActivity.OverrideExitAnimation", d.a.push_down_out);
      c.b((Context)this.uyd, "webview", ".ui.tools.WebViewUI", paramView, 1001);
      this.uyd.overridePendingTransition(d.a.push_up_in, d.a.anim_not_change);
      a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(249368);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(249594);
      s locals = SpringCardActivity.d(this.uyd);
      if (locals != null) {
        locals.dismiss();
      }
      SpringCardActivity.a(this.uyd, s.a((Context)this.uyd, (CharSequence)this.uyd.getString(d.h.uxw), true, 0, null));
      AppMethodBeat.o(249594);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SpringCardActivity paramSpringCardActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(162211);
      this.uyd.finish();
      AppMethodBeat.o(162211);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"})
  public static final class e
    implements o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(249316);
      Log.d("MicroMsg.SpringCardActivity", "onAppBackground");
      AppMethodBeat.o(249316);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(249315);
      Log.d("MicroMsg.SpringCardActivity", "onAppForeground");
      AppMethodBeat.o(249315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */