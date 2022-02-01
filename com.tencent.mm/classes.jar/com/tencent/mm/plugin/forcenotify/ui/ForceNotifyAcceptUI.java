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
import com.tencent.mm.plugin.forcenotify.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.l;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public final class ForceNotifyAcceptUI
  extends MMActivity
{
  final String TAG;
  private p lAj;
  private final ap reB;
  
  public ForceNotifyAcceptUI()
  {
    AppMethodBeat.i(149206);
    this.TAG = "MicroMsg.ForceNotifyAcceptUI";
    this.reB = new ap(this.TAG);
    AppMethodBeat.o(149206);
  }
  
  public final int getLayoutId()
  {
    return 2131494160;
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
    getString(2131755906);
    this.lAj = h.b(paramBundle, getString(2131755936), false, (DialogInterface.OnCancelListener)b.reD);
    paramBundle = this.lAj;
    if (paramBundle != null) {
      paramBundle.show();
    }
    paramBundle = getIntent();
    k.g(paramBundle, "intent");
    paramBundle = paramBundle.getExtras().getString("data");
    ad.d(this.TAG, "data:%s", new Object[] { paramBundle });
    if (paramBundle == null)
    {
      finish();
      ad.d(this.TAG, "data is null");
      AppMethodBeat.o(149203);
      return;
    }
    this.reB.post((Runnable)new c(this, paramBundle));
    ((Button)findViewById(2131296313)).setOnClickListener((View.OnClickListener)new d(this, paramBundle));
    ((Button)findViewById(2131297687)).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(149203);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149205);
    super.onDestroy();
    p localp = this.lAj;
    if (localp != null)
    {
      localp.dismiss();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149195);
      this.reC.onBackPressed();
      AppMethodBeat.o(149195);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    public static final b reD;
    
    static
    {
      AppMethodBeat.i(149196);
      reD = new b();
      AppMethodBeat.o(149196);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(149198);
      new b(paramBundle).auK().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(149198);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149201);
      paramView = this.reC;
      Context localContext = (Context)this.reC;
      this.reC.getString(2131755906);
      ForceNotifyAcceptUI.a(paramView, h.b(localContext, this.reC.getString(2131755936), false, (DialogInterface.OnCancelListener)1.reG));
      paramView = ForceNotifyAcceptUI.a(this.reC);
      if (paramView != null) {
        paramView.show();
      }
      new com.tencent.mm.plugin.forcenotify.c.a(paramBundle).auK().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(149201);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149202);
      ad.i(this.reC.TAG, "Cancel!");
      this.reC.finish();
      AppMethodBeat.o(149202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI
 * JD-Core Version:    0.7.0.1
 */