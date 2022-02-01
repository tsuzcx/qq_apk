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
import com.tencent.mm.cn.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.l;

@com.tencent.mm.ui.base.a(3)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public final class ForceNotifyAcceptUI
  extends MMActivity
{
  final String TAG;
  private com.tencent.mm.ui.base.p mCn;
  private final ap tjX;
  
  public ForceNotifyAcceptUI()
  {
    AppMethodBeat.i(149206);
    this.TAG = "MicroMsg.ForceNotifyAcceptUI";
    this.tjX = new ap(this.TAG);
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
    this.mCn = h.b(paramBundle, getString(2131755936), false, (DialogInterface.OnCancelListener)b.tjZ);
    paramBundle = this.mCn;
    if (paramBundle != null) {
      paramBundle.show();
    }
    paramBundle = getIntent();
    d.g.b.p.g(paramBundle, "intent");
    paramBundle = paramBundle.getExtras().getString("data");
    ad.d(this.TAG, "data:%s", new Object[] { paramBundle });
    if (paramBundle == null)
    {
      finish();
      ad.d(this.TAG, "data is null");
      AppMethodBeat.o(149203);
      return;
    }
    this.tjX.post((Runnable)new c(this, paramBundle));
    ((Button)findViewById(2131296313)).setOnClickListener((View.OnClickListener)new d(this, paramBundle));
    ((Button)findViewById(2131297687)).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(149203);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149205);
    super.onDestroy();
    com.tencent.mm.ui.base.p localp = this.mCn;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149195);
      this.tjY.onBackPressed();
      AppMethodBeat.o(149195);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    public static final b tjZ;
    
    static
    {
      AppMethodBeat.i(149196);
      tjZ = new b();
      AppMethodBeat.o(149196);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(149198);
      new com.tencent.mm.plugin.forcenotify.c.b(paramBundle).aED().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(149198);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149201);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.tjY;
      localObject = (Context)this.tjY;
      this.tjY.getString(2131755906);
      ForceNotifyAcceptUI.a(paramView, h.b((Context)localObject, this.tjY.getString(2131755936), false, (DialogInterface.OnCancelListener)1.tkb));
      paramView = ForceNotifyAcceptUI.a(this.tjY);
      if (paramView != null) {
        paramView.show();
      }
      new com.tencent.mm.plugin.forcenotify.c.a(paramBundle).aED().b((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {});
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149201);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149202);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.i(this.tjY.TAG, "Cancel!");
      this.tjY.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149202);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI
 * JD-Core Version:    0.7.0.1
 */