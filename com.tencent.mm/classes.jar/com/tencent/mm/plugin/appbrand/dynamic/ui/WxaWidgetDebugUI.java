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
import com.tencent.mm.bs.d;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetDebugUI
  extends MMActivity
{
  String appId;
  int dkC;
  String id;
  MMSwitchBtn jod;
  com.tencent.mm.plugin.appbrand.widget.n joe;
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
    if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().atS()) {}
    for (paramBundle = String.format("(%s)", new Object[] { b.aVS() });; paramBundle = "")
    {
      setMMTitle(getString(2131766318, new Object[] { paramBundle }));
      paramBundle = getIntent();
      this.id = paramBundle.getStringExtra("id");
      this.appId = paramBundle.getStringExtra("app_id");
      this.dkC = paramBundle.getIntExtra("pkg_type", 0);
      this.pkgVersion = paramBundle.getIntExtra("pkg_version", 0);
      setMMSubTitle(String.format("(%s)", new Object[] { this.id }));
      this.jod = ((MMSwitchBtn)findViewById(2131303023));
      this.joe = ((com.tencent.mm.plugin.appbrand.widget.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aOG().NA(this.appId);
      if (this.joe == null)
      {
        this.joe = new com.tencent.mm.plugin.appbrand.widget.n();
        this.joe.field_appId = this.appId;
      }
      this.jod.setCheck(this.joe.field_openDebug);
      this.jod.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121492);
          WxaWidgetDebugUI.this.joe.field_openDebug = paramAnonymousBoolean;
          o localo = ((com.tencent.mm.plugin.appbrand.widget.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aOG();
          com.tencent.mm.plugin.appbrand.widget.n localn = WxaWidgetDebugUI.this.joe;
          if ((localn != null) && (!bt.isNullOrNil(localn.field_appId)))
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
        public final void Ho(String paramAnonymousString)
        {
          AppMethodBeat.i(121493);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousString);
          d.b(WxaWidgetDebugUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          ad.d("WxaWidgetDebugUI", "on custom url(%s) span clicked.", new Object[] { paramAnonymousString });
          AppMethodBeat.o(121493);
        }
      }));
      paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
      findViewById(2131304137).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121495);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atK().restart();
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(121494);
              Toast.makeText(WxaWidgetDebugUI.this.getContext(), 2131766327, 1).show();
              AppMethodBeat.o(121494);
            }
          }, 1000L);
          AppMethodBeat.o(121495);
        }
      });
      paramBundle = findViewById(2131306997);
      if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().atS()) {
        break;
      }
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121496);
          Object localObject = new Intent(WxaWidgetDebugUI.this.getContext(), WxaWidgetSettingsUI.class);
          ((Intent)localObject).putExtra("app_id", WxaWidgetDebugUI.this.appId);
          ((Intent)localObject).putExtra("pkg_type", WxaWidgetDebugUI.this.dkC);
          ((Intent)localObject).putExtra("pkg_version", WxaWidgetDebugUI.this.pkgVersion);
          paramAnonymousView = WxaWidgetDebugUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI
 * JD-Core Version:    0.7.0.1
 */