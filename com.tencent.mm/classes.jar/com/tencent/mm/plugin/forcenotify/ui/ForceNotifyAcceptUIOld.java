package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public final class ForceNotifyAcceptUIOld
  extends MMActivity
{
  private final MMHandler BEi;
  final String TAG;
  private s oTk;
  
  public ForceNotifyAcceptUIOld()
  {
    AppMethodBeat.i(254065);
    this.TAG = "MicroMsg.ForceNotifyAcceptUI";
    this.BEi = new MMHandler(this.TAG);
    AppMethodBeat.o(254065);
  }
  
  public final int getLayoutId()
  {
    return a.f.force_notify_accept_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(254061);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(254061);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(254059);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = (Context)this;
    getString(a.h.app_tip);
    this.oTk = h.a(paramBundle, getString(a.h.app_waiting), false, (DialogInterface.OnCancelListener)b.BEk);
    paramBundle = this.oTk;
    if (paramBundle != null) {
      paramBundle.show();
    }
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    paramBundle = paramBundle.getExtras();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("data");; paramBundle = null)
    {
      Log.d(this.TAG, "data:%s", new Object[] { paramBundle });
      if (paramBundle != null) {
        break;
      }
      finish();
      Log.d(this.TAG, "data is null");
      AppMethodBeat.o(254059);
      return;
    }
    this.BEi.post((Runnable)new c(this, paramBundle));
    ((Button)findViewById(a.e.accept)).setOnClickListener((View.OnClickListener)new d(this, paramBundle));
    ((Button)findViewById(a.e.cancel)).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(254059);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(254063);
    super.onDestroy();
    s locals = this.oTk;
    if (locals != null)
    {
      locals.dismiss();
      AppMethodBeat.o(254063);
      return;
    }
    AppMethodBeat.o(254063);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252781);
      this.BEj.onBackPressed();
      AppMethodBeat.o(252781);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    public static final b BEk;
    
    static
    {
      AppMethodBeat.i(253522);
      BEk = new b();
      AppMethodBeat.o(253522);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(253819);
      new com.tencent.mm.plugin.forcenotify.d.b(paramBundle).bhW().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(253819);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252562);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.BEj;
      localObject = (Context)this.BEj;
      this.BEj.getString(a.h.app_tip);
      ForceNotifyAcceptUIOld.a(paramView, h.a((Context)localObject, this.BEj.getString(a.h.app_waiting), false, (DialogInterface.OnCancelListener)1.BEm));
      paramView = ForceNotifyAcceptUIOld.a(this.BEj);
      if (paramView != null) {
        paramView.show();
      }
      new com.tencent.mm.plugin.forcenotify.d.a(paramBundle).bhW().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252562);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ForceNotifyAcceptUIOld paramForceNotifyAcceptUIOld) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253372);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i(this.BEj.TAG, "Cancel!");
      this.BEj.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUIOld$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUIOld
 * JD-Core Version:    0.7.0.1
 */