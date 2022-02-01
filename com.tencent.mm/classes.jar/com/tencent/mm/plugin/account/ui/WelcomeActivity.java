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
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.d.a;
import com.tencent.mm.ui.g.a.d.b;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WelcomeActivity
  extends MMFragmentActivity
{
  private static final String[] jje = { "public_profile" };
  private com.tencent.mm.ui.g.a.d jjD;
  private c jjT;
  private gk jjW;
  private x jlC;
  private WelcomeSelectView jrt;
  
  public WelcomeActivity()
  {
    AppMethodBeat.i(128811);
    this.jjW = new gk();
    this.jlC = new x();
    AppMethodBeat.o(128811);
  }
  
  private void aUN()
  {
    AppMethodBeat.i(128814);
    if (r.s(this, "com.facebook.katana"))
    {
      this.jjD.a("name,picture.type(large)", new d.a()
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
            if (WelcomeActivity.d(WelcomeActivity.this).KAc != null)
            {
              localObject1 = localObject2;
              if (WelcomeActivity.d(WelcomeActivity.this).KAc.getToken() != null) {
                localObject1 = WelcomeActivity.d(WelcomeActivity.this).KAc.getToken().toString();
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
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousJSONObject, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousJSONObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousJSONObject, "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            WelcomeActivity.a(WelcomeActivity.this).enS = 1L;
            WelcomeActivity.a(WelcomeActivity.this).dPl = 3L;
            WelcomeActivity.a(WelcomeActivity.this).aLk();
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
    g.ajF().a(new aq.a()
    {
      JSONObject jka = null;
      
      public final boolean aEm()
      {
        AppMethodBeat.i(128809);
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("fields", "name,picture.type(large)");
        try
        {
          localObject = WelcomeActivity.e(WelcomeActivity.this).s("me", (Bundle)localObject);
          ad.i("MicroMsg.WelcomeActivity", "result json %s", new Object[] { localObject });
          this.jka = new JSONObject((String)localObject);
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
      
      public final boolean aEn()
      {
        AppMethodBeat.i(128810);
        if (this.jka != null) {}
        try
        {
          Object localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
          ((Intent)localObject).putExtra("third_app_token", WelcomeActivity.e(WelcomeActivity.this).iZb.toString());
          ((Intent)localObject).putExtra("reg_3d_app_type", 1);
          ((Intent)localObject).putExtra("register_title", WelcomeActivity.this.getString(2131757943));
          ((Intent)localObject).putExtra("register_nick_name", this.jka.getString("name"));
          ((Intent)localObject).putExtra("register_avatar", ((JSONObject)this.jka.get("picture")).getJSONObject("data").getString("url"));
          WelcomeActivity localWelcomeActivity = WelcomeActivity.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localWelcomeActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localWelcomeActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localWelcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          WelcomeActivity.a(WelcomeActivity.this).enS = 1L;
          WelcomeActivity.a(WelcomeActivity.this).dPl = 3L;
          WelcomeActivity.a(WelcomeActivity.this).aLk();
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
      if (this.jjD != null) {
        this.jjD.i(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(128817);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(128816);
    Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("can_finish", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.ke(this);
    AppMethodBeat.o(128816);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128812);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.jrt = new WelcomeSelectView(this);
    setContentView(this.jrt);
    this.jrt.aUO();
    this.jrt.jrx.setOnClickListener(new WelcomeActivity.1(this));
    this.jrt.jrv.setOnClickListener(new WelcomeActivity.4(this));
    paramBundle = new ArrayList();
    final com.tencent.mm.ui.base.m localm = new com.tencent.mm.ui.base.m(this, 1001, 0);
    localm.setTitle(2131762305);
    paramBundle.add(localm);
    localm = new com.tencent.mm.ui.base.m(this, 1002, 0);
    if (com.tencent.mm.ax.b.aJk())
    {
      localm.setTitle(2131762303);
      paramBundle.add(localm);
    }
    if (paramBundle.size() > 1)
    {
      final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      locale.KJy = new WelcomeActivity.5(this, paramBundle);
      locale.KJz = new n.e()
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128804);
            return;
            WelcomeActivity.a(WelcomeActivity.this).enS = 1L;
            WelcomeActivity.a(WelcomeActivity.this).dPl = 2L;
            WelcomeActivity.a(WelcomeActivity.this).aLk();
            WelcomeActivity.b(WelcomeActivity.this);
          }
        }
      };
      locale.JXC = new e.b()
      {
        public final void onDismiss() {}
      };
      this.jrt.jrw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128805);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (com.tencent.mm.protocal.d.Fnm)
          {
            WelcomeActivity.c(WelcomeActivity.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128805);
            return;
          }
          locale.cMW();
          if (paramBundle.contains(localm))
          {
            WelcomeActivity.a(WelcomeActivity.this).enS = 1L;
            WelcomeActivity.a(WelcomeActivity.this).dPl = 1L;
            WelcomeActivity.a(WelcomeActivity.this).aLk();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128805);
        }
      });
      AppMethodBeat.o(128812);
      return;
    }
    this.jrt.jrw.setOnClickListener(new WelcomeActivity.9(this));
    AppMethodBeat.o(128812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128815);
    super.onDestroy();
    this.jjW.aLk();
    if (this.jjD != null) {
      this.jjD.logout();
    }
    AppMethodBeat.o(128815);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(161711);
    this.jlC.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(161711);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128813);
    super.onResume();
    this.jrt.init();
    AppMethodBeat.o(128813);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */