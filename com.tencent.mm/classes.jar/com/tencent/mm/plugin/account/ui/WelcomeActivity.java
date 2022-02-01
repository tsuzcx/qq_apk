package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.d.a;
import com.tencent.mm.ui.g.a.d.b;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WelcomeActivity
  extends MMFragmentActivity
{
  private static final String[] ipP = { "public_profile" };
  private c iqE;
  private dv iqH;
  private com.tencent.mm.ui.g.a.d iqo;
  private x isp;
  private WelcomeSelectView iyh;
  
  public WelcomeActivity()
  {
    AppMethodBeat.i(128811);
    this.iqH = new dv();
    this.isp = new x();
    AppMethodBeat.o(128811);
  }
  
  private void aKK()
  {
    AppMethodBeat.i(128814);
    if (r.t(this, "com.facebook.katana"))
    {
      this.iqo.a("name,picture.type(large)", new d.a()
      {
        public final void onError(String paramAnonymousString)
        {
          AppMethodBeat.i(128808);
          ad.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", new Object[] { paramAnonymousString });
          h.c(WelcomeActivity.this, WelcomeActivity.this.getString(2131758779), "", true);
          AppMethodBeat.o(128808);
        }
        
        public final void t(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(128807);
          ad.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
          if (paramAnonymousJSONObject != null) {}
          try
          {
            Intent localIntent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (WelcomeActivity.d(WelcomeActivity.this).HiC != null)
            {
              localObject1 = localObject2;
              if (WelcomeActivity.d(WelcomeActivity.this).HiC.getToken() != null) {
                localObject1 = WelcomeActivity.d(WelcomeActivity.this).HiC.getToken().toString();
              }
            }
            localIntent.putExtra("third_app_token", (String)localObject1);
            localIntent.putExtra("reg_3d_app_type", 1);
            localIntent.putExtra("register_title", WelcomeActivity.this.getString(2131757943));
            if (paramAnonymousJSONObject.has("name"))
            {
              localIntent.putExtra("register_nick_name", paramAnonymousJSONObject.getString("name"));
              ad.i("MicroMsg.WelcomeActivity", "name %s", new Object[] { paramAnonymousJSONObject.getString("name") });
            }
            if (paramAnonymousJSONObject.has("picture"))
            {
              ad.i("MicroMsg.WelcomeActivity", "picture %s", new Object[] { paramAnonymousJSONObject.get("picture") });
              localIntent.putExtra("register_avatar", ((JSONObject)paramAnonymousJSONObject.get("picture")).getJSONObject("data").getString("url"));
            }
            paramAnonymousJSONObject = WelcomeActivity.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousJSONObject, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousJSONObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousJSONObject, "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            WelcomeActivity.a(WelcomeActivity.this).dVG = 1L;
            WelcomeActivity.a(WelcomeActivity.this).dFd = 3L;
            WelcomeActivity.a(WelcomeActivity.this).aBj();
            AppMethodBeat.o(128807);
            return;
          }
          catch (Exception paramAnonymousJSONObject)
          {
            ad.printErrStackTrace("MicroMsg.WelcomeActivity", paramAnonymousJSONObject, "parse json error!", new Object[0]);
            h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
            AppMethodBeat.o(128807);
          }
        }
      });
      AppMethodBeat.o(128814);
      return;
    }
    g.afE().a(new aq.a()
    {
      JSONObject iqL = null;
      
      public final boolean aus()
      {
        AppMethodBeat.i(128809);
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("fields", "name,picture.type(large)");
        try
        {
          localObject = WelcomeActivity.e(WelcomeActivity.this).q("me", (Bundle)localObject);
          ad.i("MicroMsg.WelcomeActivity", "result json %s", new Object[] { localObject });
          this.iqL = new JSONObject((String)localObject);
          AppMethodBeat.o(128809);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "get name and picture error!", new Object[0]);
            h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
          }
        }
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(128810);
        if (this.iqL != null) {}
        try
        {
          Object localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
          ((Intent)localObject).putExtra("third_app_token", WelcomeActivity.e(WelcomeActivity.this).ifJ.toString());
          ((Intent)localObject).putExtra("reg_3d_app_type", 1);
          ((Intent)localObject).putExtra("register_title", WelcomeActivity.this.getString(2131757943));
          ((Intent)localObject).putExtra("register_nick_name", this.iqL.getString("name"));
          ((Intent)localObject).putExtra("register_avatar", ((JSONObject)this.iqL.get("picture")).getJSONObject("data").getString("url"));
          WelcomeActivity localWelcomeActivity = WelcomeActivity.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localWelcomeActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localWelcomeActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localWelcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          WelcomeActivity.a(WelcomeActivity.this).dVG = 1L;
          WelcomeActivity.a(WelcomeActivity.this).dFd = 3L;
          WelcomeActivity.a(WelcomeActivity.this).aBj();
          AppMethodBeat.o(128810);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "parse json error!", new Object[0]);
            h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
          }
        }
      }
    });
    AppMethodBeat.o(128814);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(128817);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      ad.i("MicroMsg.WelcomeActivity", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.iqo != null) {
        this.iqo.i(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(128817);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(128816);
    Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("can_finish", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.jI(this);
    AppMethodBeat.o(128816);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128812);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.iyh = new WelcomeSelectView(this);
    setContentView(this.iyh);
    this.iyh.aKL();
    this.iyh.iyl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128794);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        paramAnonymousView.putExtra("from_login_history", true);
        com.tencent.mm.plugin.account.a.a.hYt.o(paramAnonymousView, WelcomeActivity.this);
        AppMethodBeat.o(128794);
      }
    });
    this.iyh.iyj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128802);
        Object localObject = new Intent(WelcomeActivity.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        paramAnonymousView = WelcomeActivity.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128802);
      }
    });
    paramBundle = new ArrayList();
    final m localm = new m(this, 1001, 0);
    localm.setTitle(2131762305);
    paramBundle.add(localm);
    localm = new m(this, 1002, 0);
    if (com.tencent.mm.ax.b.azk())
    {
      localm.setTitle(2131762303);
      paramBundle.add(localm);
    }
    if (paramBundle.size() > 1)
    {
      final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(128803);
          if (paramAnonymousl.eSQ())
          {
            Iterator localIterator = paramBundle.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousl.g((m)localIterator.next());
            }
          }
          AppMethodBeat.o(128803);
        }
      };
      locale.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(128804);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(128804);
            return;
            Object localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
            paramAnonymousMenuItem = WelcomeActivity.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128804);
            return;
            WelcomeActivity.a(WelcomeActivity.this).dVG = 1L;
            WelcomeActivity.a(WelcomeActivity.this).dFd = 2L;
            WelcomeActivity.a(WelcomeActivity.this).aBj();
            WelcomeActivity.b(WelcomeActivity.this);
          }
        }
      };
      locale.GHn = new e.b()
      {
        public final void onDismiss() {}
      };
      this.iyh.iyk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128805);
          if (com.tencent.mm.protocal.d.CpN)
          {
            WelcomeActivity.c(WelcomeActivity.this);
            AppMethodBeat.o(128805);
            return;
          }
          locale.csG();
          if (paramBundle.contains(localm))
          {
            WelcomeActivity.a(WelcomeActivity.this).dVG = 1L;
            WelcomeActivity.a(WelcomeActivity.this).dFd = 1L;
            WelcomeActivity.a(WelcomeActivity.this).aBj();
          }
          AppMethodBeat.o(128805);
        }
      });
      AppMethodBeat.o(128812);
      return;
    }
    this.iyh.iyk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128806);
        if (com.tencent.mm.protocal.d.CpN)
        {
          WelcomeActivity.c(WelcomeActivity.this);
          AppMethodBeat.o(128806);
          return;
        }
        Object localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
        paramAnonymousView = WelcomeActivity.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128806);
      }
    });
    AppMethodBeat.o(128812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128815);
    super.onDestroy();
    this.iqH.aBj();
    if (this.iqo != null) {
      this.iqo.logout();
    }
    AppMethodBeat.o(128815);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(161711);
    this.isp.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(161711);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128813);
    super.onResume();
    this.iyh.init();
    AppMethodBeat.o(128813);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */