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
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.m;
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
  int dMe;
  String id;
  MMSwitchBtn lpB;
  m lpC;
  int pkgVersion;
  
  public int getLayoutId()
  {
    return 2131497119;
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
    if (((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().aXP()) {}
    for (paramBundle = String.format("(%s)", new Object[] { com.tencent.mm.plugin.appbrand.dynamic.widget.b.bCv() });; paramBundle = "")
    {
      setMMTitle(getString(2131768831, new Object[] { paramBundle }));
      paramBundle = getIntent();
      this.id = paramBundle.getStringExtra("id");
      this.appId = paramBundle.getStringExtra("app_id");
      this.dMe = paramBundle.getIntExtra("pkg_type", 0);
      this.pkgVersion = paramBundle.getIntExtra("pkg_version", 0);
      setMMSubTitle(String.format("(%s)", new Object[] { this.id }));
      this.lpB = ((MMSwitchBtn)findViewById(2131305619));
      this.lpC = ((com.tencent.mm.plugin.appbrand.widget.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buH().afV(this.appId);
      if (this.lpC == null)
      {
        this.lpC = new m();
        this.lpC.field_appId = this.appId;
      }
      this.lpB.setCheck(this.lpC.field_openDebug);
      this.lpB.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(121492);
          WxaWidgetDebugUI.this.lpC.field_openDebug = paramAnonymousBoolean;
          com.tencent.mm.plugin.appbrand.widget.n localn = ((com.tencent.mm.plugin.appbrand.widget.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buH();
          m localm = WxaWidgetDebugUI.this.lpC;
          if ((localm != null) && (!Util.isNullOrNil(localm.field_appId)))
          {
            localm.field_appIdHash = localm.field_appId.hashCode();
            localn.replace(localm);
          }
          AppMethodBeat.o(121492);
        }
      });
      paramBundle = (TextView)findViewById(2131302687);
      paramBundle.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(getString(2131768837), true, new c.a()
      {
        public final void YF(String paramAnonymousString)
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
      findViewById(2131307033).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121495);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXH().restart();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(121494);
              Toast.makeText(WxaWidgetDebugUI.this.getContext(), 2131768840, 1).show();
              AppMethodBeat.o(121494);
            }
          }, 1000L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(121495);
        }
      });
      paramBundle = findViewById(2131310509);
      if (!((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().aXP()) {
        break;
      }
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(121496);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent(WxaWidgetDebugUI.this.getContext(), WxaWidgetSettingsUI.class);
          ((Intent)localObject).putExtra("app_id", WxaWidgetDebugUI.this.appId);
          ((Intent)localObject).putExtra("pkg_type", WxaWidgetDebugUI.this.dMe);
          ((Intent)localObject).putExtra("pkg_version", WxaWidgetDebugUI.this.pkgVersion);
          paramAnonymousView = WxaWidgetDebugUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetDebugUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI
 * JD-Core Version:    0.7.0.1
 */