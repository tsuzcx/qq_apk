package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.t;
import com.tencent.mm.plugin.appbrand.widget.u;
import com.tencent.mm.plugin.appbrand.wxawidget.b.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetDebugUI
  extends MMActivity
{
  String appId;
  int hJK;
  String id;
  int pkgVersion;
  MMSwitchBtn rnN;
  t rnO;
  
  public int getLayoutId()
  {
    return b.b.wxa_widget_debug_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(121497);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(121491);
        WxaWidgetDebugUI.this.finish();
        AppMethodBeat.o(121491);
        return false;
      }
    });
    int i = b.c.wxa_widget_debugger;
    if (((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().bEP()) {}
    for (paramBundle = String.format("(%s)", new Object[] { com.tencent.mm.plugin.appbrand.dynamic.widget.b.cof() });; paramBundle = "")
    {
      setMMTitle(getString(i, new Object[] { paramBundle }));
      paramBundle = getIntent();
      this.id = paramBundle.getStringExtra("id");
      this.appId = paramBundle.getStringExtra("app_id");
      this.hJK = paramBundle.getIntExtra("pkg_type", 0);
      this.pkgVersion = paramBundle.getIntExtra("pkg_version", 0);
      setMMSubTitle(String.format("(%s)", new Object[] { this.id }));
      this.rnN = ((MMSwitchBtn)findViewById(b.a.open_debug_btn));
      this.rnO = ((com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.widget.b.b.class)).cfi().agX(this.appId);
      if (this.rnO == null)
      {
        this.rnO = new t();
        this.rnO.field_appId = this.appId;
      }
      this.rnN.setCheck(this.rnO.field_openDebug);
      this.rnN.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121492);
          WxaWidgetDebugUI.this.rnO.field_openDebug = paramAnonymousBoolean;
          u localu = ((com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.widget.b.b.class)).cfi();
          t localt = WxaWidgetDebugUI.this.rnO;
          if ((localt != null) && (!Util.isNullOrNil(localt.field_appId)))
          {
            localt.field_appIdHash = localt.field_appId.hashCode();
            localu.replace(localt);
          }
          AppMethodBeat.o(121492);
        }
      });
      paramBundle = (TextView)findViewById(b.a.inspect_guide_tv);
      paramBundle.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(getString(b.c.wxa_widget_open_inspect_guide), true, new c.a()
      {
        public final void performOpenUrl(String paramAnonymousString)
        {
          AppMethodBeat.i(121493);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousString);
          com.tencent.mm.br.c.b(WxaWidgetDebugUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          Log.d("WxaWidgetDebugUI", "on custom url(%s) span clicked.", new Object[] { paramAnonymousString });
          AppMethodBeat.o(121493);
        }
      }));
      paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
      findViewById(b.a.restart_support_process_btn).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121495);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().bEH();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(121494);
              Toast.makeText(WxaWidgetDebugUI.this.getContext(), b.c.wxa_widget_restart_support_process_succ, 1).show();
              AppMethodBeat.o(121494);
            }
          }, 1000L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121495);
        }
      });
      paramBundle = findViewById(b.a.widget_settings_btn);
      if (!((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().bEP()) {
        break;
      }
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121496);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = new Intent(WxaWidgetDebugUI.this.getContext(), WxaWidgetSettingsUI.class);
          ((Intent)localObject).putExtra("app_id", WxaWidgetDebugUI.this.appId);
          ((Intent)localObject).putExtra("pkg_type", WxaWidgetDebugUI.this.hJK);
          ((Intent)localObject).putExtra("pkg_version", WxaWidgetDebugUI.this.pkgVersion);
          paramAnonymousView = WxaWidgetDebugUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121496);
        }
      });
      AppMethodBeat.o(121497);
      return;
    }
    paramBundle.setVisibility(8);
    AppMethodBeat.o(121497);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI
 * JD-Core Version:    0.7.0.1
 */