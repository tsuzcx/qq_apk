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
import com.tencent.mm.co.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public final class ForceNotifyAcceptUI
  extends MMActivity
{
  final String TAG;
  private q nUq;
  private final MMHandler wLW;
  
  public ForceNotifyAcceptUI()
  {
    AppMethodBeat.i(149206);
    this.TAG = "MicroMsg.ForceNotifyAcceptUI";
    this.wLW = new MMHandler(this.TAG);
    AppMethodBeat.o(149206);
  }
  
  public final int getLayoutId()
  {
    return 2131494715;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149204);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(149204);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(149203);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = (Context)this;
    getString(2131755998);
    this.nUq = h.a(paramBundle, getString(2131756029), false, (DialogInterface.OnCancelListener)b.wLY);
    paramBundle = this.nUq;
    if (paramBundle != null) {
      paramBundle.show();
    }
    paramBundle = getIntent();
    p.g(paramBundle, "intent");
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
      AppMethodBeat.o(149203);
      return;
    }
    this.wLW.post((Runnable)new c(this, paramBundle));
    ((Button)findViewById(2131296326)).setOnClickListener((View.OnClickListener)new d(this, paramBundle));
    ((Button)findViewById(2131297959)).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(149203);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149205);
    super.onDestroy();
    q localq = this.nUq;
    if (localq != null)
    {
      localq.dismiss();
      AppMethodBeat.o(149205);
      return;
    }
    AppMethodBeat.o(149205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149195);
      this.wLX.onBackPressed();
      AppMethodBeat.o(149195);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    public static final b wLY;
    
    static
    {
      AppMethodBeat.i(149196);
      wLY = new b();
      AppMethodBeat.o(149196);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(149198);
      new com.tencent.mm.plugin.forcenotify.c.b(paramBundle).aYI().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(149198);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149201);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.wLX;
      localObject = (Context)this.wLX;
      this.wLX.getString(2131755998);
      ForceNotifyAcceptUI.a(paramView, h.a((Context)localObject, this.wLX.getString(2131756029), false, (DialogInterface.OnCancelListener)ForceNotifyAcceptUI.d.1.wMa));
      paramView = ForceNotifyAcceptUI.a(this.wLX);
      if (paramView != null) {
        paramView.show();
      }
      new com.tencent.mm.plugin.forcenotify.c.a(paramBundle).aYI().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149201);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149202);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i(this.wLX.TAG, "Cancel!");
      this.wLX.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI
 * JD-Core Version:    0.7.0.1
 */