package com.tencent.mm.plugin.eggspring.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.eggspring.e.a;
import com.tencent.mm.plugin.eggspring.e.b;
import com.tencent.mm.plugin.eggspring.e.e;
import com.tencent.mm.plugin.eggspring.e.f;
import com.tencent.mm.plugin.eggspring.e.g;
import com.tencent.mm.plugin.eggspring.e.h;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "clicked", "", "delayShowLoading", "Ljava/lang/Runnable;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "luckyBagLoadingImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "luckyBagLoop", "rootLayout", "Landroid/view/ViewGroup;", "uiHandler", "Landroid/os/Handler;", "adjustCloseBtnColor", "", "color", "", "boundView", "finish", "getForceOrientation", "getLayoutId", "initBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SpringCardActivity
  extends MMActivity
{
  public static final SpringCardActivity.a xEH;
  private Handler eLs;
  private boolean mkG;
  private MMAnimateView xEI;
  private MMAnimateView xEJ;
  private q xEK;
  private w xEL;
  private final Runnable xEM;
  private ViewGroup xcW;
  
  static
  {
    AppMethodBeat.i(108208);
    xEH = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.xEM = new SpringCardActivity..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(108207);
  }
  
  private static final void a(SpringCardActivity paramSpringCardActivity)
  {
    AppMethodBeat.i(266571);
    s.u(paramSpringCardActivity, "this$0");
    w localw = paramSpringCardActivity.xEL;
    if (localw != null) {
      localw.dismiss();
    }
    paramSpringCardActivity.xEL = w.a((Context)paramSpringCardActivity, (CharSequence)paramSpringCardActivity.getString(e.h.xEg), true, 0, null);
    AppMethodBeat.o(266571);
  }
  
  private static final void a(SpringCardActivity paramSpringCardActivity, View paramView)
  {
    AppMethodBeat.i(266586);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramSpringCardActivity);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSpringCardActivity, "this$0");
    Log.i("MicroMsg.SpringCardActivity", s.X("onClick: ", Boolean.valueOf(paramSpringCardActivity.mkG)));
    if (paramSpringCardActivity.mkG)
    {
      a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(266586);
      return;
    }
    paramSpringCardActivity.mkG = true;
    d.H(paramSpringCardActivity.xEM);
    d.a(1000L, paramSpringCardActivity.xEM);
    int i = paramSpringCardActivity.getContext().getResources().getColor(e.b.xDu);
    paramView = new Intent();
    paramView.putExtra("customize_status_bar_color", i);
    paramView.putExtra("webview_bg_color_rsID", e.b.xDu);
    paramView.putExtra("from_shortcut", true);
    paramView.putExtra("disable_minimize", true);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", e.a.anim_not_change);
    paramView.putExtra("MMActivity.OverrideExitAnimation", e.a.push_down_out);
    c.b((Context)paramSpringCardActivity, "webview", ".ui.tools.WebViewUI", paramView, 1001);
    paramSpringCardActivity.overridePendingTransition(e.a.push_up_in, e.a.anim_not_change);
    a.a(new Object(), "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266586);
  }
  
  private static final boolean a(SpringCardActivity paramSpringCardActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(266580);
    s.u(paramSpringCardActivity, "this$0");
    paramSpringCardActivity.finish();
    AppMethodBeat.o(266580);
    return true;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(266644);
    w localw = this.xEL;
    if (localw != null) {
      localw.dismiss();
    }
    super.finish();
    AppMethodBeat.o(266644);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return e.f.xEa;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(266631);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      finish();
    }
    AppMethodBeat.o(266631);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(108179);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.eLs = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn(new SpringCardActivity..ExternalSyntheticLambda0(this), e.g.icons_outlined_close);
    int i = getContext().getResources().getColor(e.b.xDu);
    setActionbarColor(i);
    Object localObject2;
    if (bb.aAF(i))
    {
      updateBackBtn(bb.m((Context)this, e.g.icons_outlined_close, -1));
      hideActionbarLine();
      getWindow().getDecorView().setSystemUiVisibility(2050);
      supportLightStatusBar();
      paramBundle = findViewById(e.e.root_layout);
      s.s(paramBundle, "findViewById(R.id.root_layout)");
      this.xcW = ((ViewGroup)paramBundle);
      paramBundle = findViewById(e.e.xDW);
      s.s(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
      this.xEI = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(e.e.xDX);
      s.s(paramBundle, "findViewById(R.id.lucky_bag_loading_loop)");
      this.xEJ = ((MMAnimateView)paramBundle);
      SpringCardActivity..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new SpringCardActivity..ExternalSyntheticLambda1(this);
      localObject2 = this.xEI;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("luckyBagLoadingImg");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(localExternalSyntheticLambda1);
      localObject2 = this.xEJ;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("luckyBagLoop");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(localExternalSyntheticLambda1);
      this.xEK = ((q)new SpringCardActivity.b());
      localObject2 = AppForegroundDelegate.heY;
      paramBundle = this.xEK;
      if (paramBundle != null) {
        break label326;
      }
      s.bIx("appForegroundLis");
      paramBundle = localObject1;
    }
    label326:
    for (;;)
    {
      ((AppForegroundDelegate)localObject2).a(paramBundle);
      AppMethodBeat.o(108179);
      return;
      updateBackBtn(bb.m((Context)this, e.g.icons_outlined_close, -16777216));
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Log.i("MicroMsg.SpringCardActivity", "onDestroy: ");
    AppForegroundDelegate localAppForegroundDelegate = AppForegroundDelegate.heY;
    q localq2 = this.xEK;
    q localq1 = localq2;
    if (localq2 == null)
    {
      s.bIx("appForegroundLis");
      localq1 = null;
    }
    localAppForegroundDelegate.b(localq1);
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
    AppMethodBeat.i(266639);
    super.onStop();
    Log.i("MicroMsg.SpringCardActivity", s.X("onStop: ", Boolean.valueOf(this.mkG)));
    if (this.mkG) {
      finish();
    }
    AppMethodBeat.o(266639);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */