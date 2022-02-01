package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "OVERLAY_PERMISSION_REQ_CODE", "", "onActivityResult", "", "requestCode", "resultCode", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onPause", "onResume", "showAlert", "Companion", "OverlayPermissionResultCallBack", "plugin-force-notify_release"})
public final class ForceNotifyAcceptUI
  extends MMBaseActivity
{
  private static b BEe;
  public static final ForceNotifyAcceptUI.a BEf;
  private static g yTG;
  private final int BEd;
  
  static
  {
    AppMethodBeat.i(252556);
    BEf = new ForceNotifyAcceptUI.a((byte)0);
    AppMethodBeat.o(252556);
  }
  
  public ForceNotifyAcceptUI()
  {
    AppMethodBeat.i(149206);
    this.BEd = 1234;
    AppMethodBeat.o(149206);
  }
  
  private final void cxh()
  {
    AppMethodBeat.i(252550);
    if (getIntent() == null)
    {
      AppMethodBeat.o(252550);
      return;
    }
    Object localObject1 = getIntent();
    p.j(localObject1, "intent");
    localObject1 = ((Intent)localObject1).getExtras();
    if (localObject1 == null)
    {
      AppMethodBeat.o(252550);
      return;
    }
    p.j(localObject1, "intent.extras ?: return");
    g localg = new g((Context)this, 1, 2, false);
    localg.aT((CharSequence)((Bundle)localObject1).getString("title", getString(a.h.force_notify_window_permission_title_chat)));
    Object localObject2 = ad.kS((Context)this).inflate(a.f.force_notify_permission_content_view, null);
    TextView localTextView = (TextView)((View)localObject2).findViewById(a.e.force_notify_permission_tips_tv);
    if (localTextView != null) {
      localTextView.setText((CharSequence)((Bundle)localObject1).getString("warning_content"));
    }
    localg.setCustomView((View)localObject2);
    if (d.qV(23)) {}
    for (int i = a.h.force_notify_go_setting;; i = a.h.force_notify_view_open_method)
    {
      localObject2 = getString(i);
      p.j(localObject2, "getString(if (CApiLevel.…_notify_view_open_method)");
      localg.d((CharSequence)getString(a.h.force_notify_cancel), (CharSequence)localObject2);
      localg.ayt(0);
      localg.a((g.a)new c(this, (Bundle)localObject1), (g.a)new d(this, (Bundle)localObject1));
      yTG = localg;
      localg.eik();
      AppMethodBeat.o(252550);
      return;
    }
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252552);
    if (BEe == null)
    {
      finish();
      AppMethodBeat.o(252552);
      return;
    }
    if (paramInt1 == this.BEd) {
      if (b.ct(MMApplicationContext.getContext()))
      {
        paramIntent = BEe;
        if (paramIntent != null) {
          paramIntent.b(this);
        }
      }
    }
    for (;;)
    {
      BEe = null;
      finish();
      AppMethodBeat.o(252552);
      return;
      paramIntent = BEe;
      if (paramIntent != null)
      {
        paramIntent.c(this);
        continue;
        paramIntent = BEe;
        if (paramIntent != null) {
          paramIntent.c(this);
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149203);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setTheme(a.i.MMTheme_NoTitleTranslucent);
    cxh();
    AppMethodBeat.o(149203);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(252548);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (yTG != null)
    {
      paramIntent = yTG;
      if (paramIntent != null) {
        paramIntent.bYF();
      }
      yTG = null;
    }
    cxh();
    AppMethodBeat.o(252548);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252549);
    super.onPause();
    ac.activateBroadcast(false);
    AppMethodBeat.o(252549);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252545);
    super.onResume();
    ac.activateBroadcast(true);
    AppMethodBeat.o(252545);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$OverlayPermissionResultCallBack;", "", "onResultAllow", "", "dialog", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "onResultCancel", "onResultRefuse", "plugin-force-notify_release"})
  public static abstract interface b
  {
    public abstract void b(ForceNotifyAcceptUI paramForceNotifyAcceptUI);
    
    public abstract void c(ForceNotifyAcceptUI paramForceNotifyAcceptUI);
    
    public abstract void d(ForceNotifyAcceptUI paramForceNotifyAcceptUI);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$showAlert$1$2"})
  static final class c
    implements g.a
  {
    c(ForceNotifyAcceptUI paramForceNotifyAcceptUI, Bundle paramBundle) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(253589);
      ForceNotifyAcceptUI.b localb = ForceNotifyAcceptUI.eqp();
      if (localb != null) {
        localb.d(this.BEg);
      }
      ForceNotifyAcceptUI.a(null);
      this.BEg.finish();
      AppMethodBeat.o(253589);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$showAlert$1$3"})
  static final class d
    implements g.a
  {
    d(ForceNotifyAcceptUI paramForceNotifyAcceptUI, Bundle paramBundle) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(252812);
      if (d.qV(23)) {
        try
        {
          Object localObject = Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class);
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(252812);
            throw ((Throwable)localObject);
          }
        }
        catch (Exception localException) {}
      }
      String str;
      while (Util.isNullOrNil((String)str))
      {
        str = this.BEg.getString(a.h.floating_window_permission_url);
        p.j(str, "getString(R.string.floating_window_permission_url)");
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        c.b((Context)this.BEg, "webview", ".ui.tools.WebViewUI", localIntent);
        this.BEg.finish();
        AppMethodBeat.o(252812);
        return;
      }
      this.BEg.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + MMApplicationContext.getPackageName())), ForceNotifyAcceptUI.a(this.BEg));
      AppMethodBeat.o(252812);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI
 * JD-Core Version:    0.7.0.1
 */