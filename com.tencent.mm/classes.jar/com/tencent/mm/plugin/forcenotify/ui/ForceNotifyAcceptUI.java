package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "executor", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
@com.tencent.mm.ui.base.a(3)
public final class ForceNotifyAcceptUI
  extends MMActivity
{
  final String TAG;
  private p iMZ;
  private final ak mHf;
  
  public ForceNotifyAcceptUI()
  {
    AppMethodBeat.i(140611);
    this.TAG = "MicroMsg.ForceNotifyAcceptUI";
    this.mHf = new ak(this.TAG);
    AppMethodBeat.o(140611);
  }
  
  public final int getLayoutId()
  {
    return 2130969619;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(140609);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(140609);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(140608);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new ForceNotifyAcceptUI.a(this));
    paramBundle = (Context)this;
    getString(2131297087);
    this.iMZ = h.b(paramBundle, getString(2131297112), false, (DialogInterface.OnCancelListener)ForceNotifyAcceptUI.b.mHz);
    paramBundle = this.iMZ;
    if (paramBundle != null) {
      paramBundle.show();
    }
    paramBundle = getIntent();
    j.p(paramBundle, "intent");
    paramBundle = paramBundle.getExtras().getString("data");
    ab.d(this.TAG, "data:%s", new Object[] { paramBundle });
    if (paramBundle == null)
    {
      finish();
      ab.d(this.TAG, "data is null");
      AppMethodBeat.o(140608);
      return;
    }
    this.mHf.post((Runnable)new ForceNotifyAcceptUI.c(this, paramBundle));
    ((Button)findViewById(2131824230)).setOnClickListener((View.OnClickListener)new d(this, paramBundle));
    ((Button)findViewById(2131824231)).setOnClickListener((View.OnClickListener)new ForceNotifyAcceptUI.e(this));
    AppMethodBeat.o(140608);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140610);
    super.onDestroy();
    p localp = this.iMZ;
    if (localp != null)
    {
      localp.dismiss();
      AppMethodBeat.o(140610);
      return;
    }
    AppMethodBeat.o(140610);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(ForceNotifyAcceptUI paramForceNotifyAcceptUI, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(140606);
      paramView = this.mHy;
      Context localContext = (Context)this.mHy;
      this.mHy.getString(2131297087);
      ForceNotifyAcceptUI.a(paramView, h.b(localContext, this.mHy.getString(2131297112), false, (DialogInterface.OnCancelListener)ForceNotifyAcceptUI.d.1.mHC));
      paramView = ForceNotifyAcceptUI.a(this.mHy);
      if (paramView != null) {
        paramView.show();
      }
      new com.tencent.mm.plugin.forcenotify.c.a(paramBundle).adl().b((com.tencent.mm.vending.c.a)new ForceNotifyAcceptUI.d.2(this));
      AppMethodBeat.o(140606);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI
 * JD-Core Version:    0.7.0.1
 */