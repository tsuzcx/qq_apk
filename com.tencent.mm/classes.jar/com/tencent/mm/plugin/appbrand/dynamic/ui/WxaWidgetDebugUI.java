package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.app.Activity;
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
import com.tencent.mm.br.d;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetDebugUI
  extends MMActivity
{
  String appId;
  int duK;
  String id;
  MMSwitchBtn klQ;
  com.tencent.mm.plugin.appbrand.widget.n klR;
  int pkgVersion;
  
  public int getLayoutId()
  {
    return 2131496123;
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
    if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().aEc()) {}
    for (paramBundle = String.format("(%s)", new Object[] { com.tencent.mm.plugin.appbrand.dynamic.widget.b.bhc() });; paramBundle = "")
    {
      setMMTitle(getString(2131766318, new Object[] { paramBundle }));
      paramBundle = getIntent();
      this.id = paramBundle.getStringExtra("id");
      this.appId = paramBundle.getStringExtra("app_id");
      this.duK = paramBundle.getIntExtra("pkg_type", 0);
      this.pkgVersion = paramBundle.getIntExtra("pkg_version", 0);
      setMMSubTitle(String.format("(%s)", new Object[] { this.id }));
      this.klQ = ((MMSwitchBtn)findViewById(2131303023));
      this.klR = ((com.tencent.mm.plugin.appbrand.widget.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aZq().VZ(this.appId);
      if (this.klR == null)
      {
        this.klR = new com.tencent.mm.plugin.appbrand.widget.n();
        this.klR.field_appId = this.appId;
      }
      this.klQ.setCheck(this.klR.field_openDebug);
      this.klQ.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121492);
          WxaWidgetDebugUI.this.klR.field_openDebug = paramAnonymousBoolean;
          o localo = ((com.tencent.mm.plugin.appbrand.widget.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aZq();
          com.tencent.mm.plugin.appbrand.widget.n localn = WxaWidgetDebugUI.this.klR;
          if ((localn != null) && (!bu.isNullOrNil(localn.field_appId)))
          {
            localn.field_appIdHash = localn.field_appId.hashCode();
            localo.replace(localn);
          }
          AppMethodBeat.o(121492);
        }
      });
      paramBundle = (TextView)findViewById(2131301036);
      paramBundle.setText(c.a(getString(2131766324), true, new c.a()
      {
        public final void Pu(String paramAnonymousString)
        {
          AppMethodBeat.i(121493);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousString);
          d.b(WxaWidgetDebugUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          ae.d("WxaWidgetDebugUI", "on custom url(%s) span clicked.", new Object[] { paramAnonymousString });
          AppMethodBeat.o(121493);
        }
      }));
      paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
      findViewById(2131304137).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121495);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDU().restart();
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(121494);
              Toast.makeText(WxaWidgetDebugUI.this.getContext(), 2131766327, 1).show();
              AppMethodBeat.o(121494);
            }
          }, 1000L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121495);
        }
      });
      paramBundle = findViewById(2131306997);
      if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().aEc()) {
        break;
      }
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121496);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = new Intent(WxaWidgetDebugUI.this.getContext(), WxaWidgetSettingsUI.class);
          ((Intent)localObject).putExtra("app_id", WxaWidgetDebugUI.this.appId);
          ((Intent)localObject).putExtra("pkg_type", WxaWidgetDebugUI.this.duK);
          ((Intent)localObject).putExtra("pkg_version", WxaWidgetDebugUI.this.pkgVersion);
          paramAnonymousView = WxaWidgetDebugUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI
 * JD-Core Version:    0.7.0.1
 */