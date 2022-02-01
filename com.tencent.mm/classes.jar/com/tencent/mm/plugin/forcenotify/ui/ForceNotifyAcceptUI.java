package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.widget.a.j;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "OVERLAY_PERMISSION_REQ_CODE", "", "onActivityResult", "", "requestCode", "resultCode", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onPause", "onResume", "showAlert", "Companion", "OverlayPermissionResultCallBack", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ForceNotifyAcceptUI
  extends MMBaseActivity
{
  private static j DMg;
  public static final ForceNotifyAcceptUI.a HoG;
  private static b HoI;
  private final int HoH;
  
  static
  {
    AppMethodBeat.i(275078);
    HoG = new ForceNotifyAcceptUI.a((byte)0);
    AppMethodBeat.o(275078);
  }
  
  public ForceNotifyAcceptUI()
  {
    AppMethodBeat.i(149206);
    this.HoH = 1234;
    AppMethodBeat.o(149206);
  }
  
  private static final void a(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
  {
    AppMethodBeat.i(275061);
    s.u(paramForceNotifyAcceptUI, "this$0");
    b localb = HoI;
    if (localb != null) {
      localb.e(paramForceNotifyAcceptUI);
    }
    HoI = null;
    paramForceNotifyAcceptUI.finish();
    AppMethodBeat.o(275061);
  }
  
  private static final void b(ForceNotifyAcceptUI paramForceNotifyAcceptUI)
  {
    AppMethodBeat.i(275071);
    s.u(paramForceNotifyAcceptUI, "this$0");
    if (d.rb(23)) {
      try
      {
        Object localObject = Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class);
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(275071);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException) {}
    }
    String str;
    while (Util.isNullOrNil((String)str))
    {
      str = paramForceNotifyAcceptUI.getString(a.h.floating_window_permission_url);
      s.s(str, "getString(R.string.floating_window_permission_url)");
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      c.b((Context)paramForceNotifyAcceptUI, "webview", ".ui.tools.WebViewUI", localIntent);
      paramForceNotifyAcceptUI.finish();
      AppMethodBeat.o(275071);
      return;
    }
    paramForceNotifyAcceptUI.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(s.X("package:", MMApplicationContext.getPackageName()))), paramForceNotifyAcceptUI.HoH);
    AppMethodBeat.o(275071);
  }
  
  private final void cZS()
  {
    AppMethodBeat.i(275055);
    if (getIntent() == null)
    {
      AppMethodBeat.o(275055);
      return;
    }
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      AppMethodBeat.o(275055);
      return;
    }
    j localj = new j((Context)this, 1, 2, false);
    localj.bh((CharSequence)((Bundle)localObject).getString("title", getString(a.h.force_notify_window_permission_title_chat)));
    View localView = af.mU((Context)this).inflate(a.f.force_notify_permission_content_view, null);
    TextView localTextView = (TextView)localView.findViewById(a.e.force_notify_permission_tips_tv);
    if (localTextView != null) {
      localTextView.setText((CharSequence)((Bundle)localObject).getString("warning_content"));
    }
    localj.setCustomView(localView);
    if (d.rb(23)) {}
    for (int i = a.h.force_notify_go_setting;; i = a.h.force_notify_view_open_method)
    {
      localObject = getString(i);
      s.s(localObject, "getString(if (CApiLevel.…_notify_view_open_method)");
      localj.d((CharSequence)getString(a.h.force_notify_cancel), (CharSequence)localObject);
      localj.aFd(0);
      localj.a(new ForceNotifyAcceptUI..ExternalSyntheticLambda1(this), new ForceNotifyAcceptUI..ExternalSyntheticLambda0(this));
      DMg = localj;
      localj.dDn();
      AppMethodBeat.o(275055);
      return;
    }
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(275108);
    if (HoI == null)
    {
      finish();
      AppMethodBeat.o(275108);
      return;
    }
    if (paramInt1 == this.HoH) {
      if (b.dh(MMApplicationContext.getContext()))
      {
        paramIntent = HoI;
        if (paramIntent != null) {
          paramIntent.c(this);
        }
      }
    }
    for (;;)
    {
      HoI = null;
      finish();
      AppMethodBeat.o(275108);
      return;
      paramIntent = HoI;
      if (paramIntent != null)
      {
        paramIntent.d(this);
        continue;
        paramIntent = HoI;
        if (paramIntent != null) {
          paramIntent.d(this);
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
    cZS();
    AppMethodBeat.o(149203);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(275097);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (DMg != null)
    {
      paramIntent = DMg;
      if (paramIntent != null) {
        paramIntent.cyW();
      }
      DMg = null;
    }
    cZS();
    AppMethodBeat.o(275097);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(275101);
    super.onPause();
    ag.activateBroadcast(false);
    AppMethodBeat.o(275101);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(275093);
    super.onResume();
    ag.activateBroadcast(true);
    AppMethodBeat.o(275093);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$OverlayPermissionResultCallBack;", "", "onResultAllow", "", "dialog", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "onResultCancel", "onResultRefuse", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void c(ForceNotifyAcceptUI paramForceNotifyAcceptUI);
    
    public abstract void d(ForceNotifyAcceptUI paramForceNotifyAcceptUI);
    
    public abstract void e(ForceNotifyAcceptUI paramForceNotifyAcceptUI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI
 * JD-Core Version:    0.7.0.1
 */