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
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.c.a;
import com.tencent.mm.ui.h.a.d.a;
import com.tencent.mm.ui.h.a.d.b;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WelcomeActivity
  extends MMFragmentActivity
{
  private static final String[] kkg = { "public_profile" };
  private com.tencent.mm.ui.h.a.d kkF;
  private c kkV;
  private ka kkY;
  private x kmF;
  private WelcomeSelectView ksB;
  
  public WelcomeActivity()
  {
    AppMethodBeat.i(128811);
    this.kkY = new ka();
    this.kmF = new x();
    AppMethodBeat.o(128811);
  }
  
  private void bpX()
  {
    AppMethodBeat.i(128814);
    if (r.s(this, "com.facebook.katana"))
    {
      this.kkF.a("name,picture.type(large)", new d.a()
      {
        public final void A(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(128807);
          Log.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
          if (paramAnonymousJSONObject != null) {}
          try
          {
            Intent localIntent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (WelcomeActivity.d(WelcomeActivity.this).QjM != null)
            {
              localObject1 = localObject2;
              if (WelcomeActivity.d(WelcomeActivity.this).QjM.getToken() != null) {
                localObject1 = WelcomeActivity.d(WelcomeActivity.this).QjM.getToken().toString();
              }
            }
            localIntent.putExtra("third_app_token", (String)localObject1);
            localIntent.putExtra("reg_3d_app_type", 1);
            localIntent.putExtra("register_title", WelcomeActivity.this.getString(2131758186));
            if (paramAnonymousJSONObject.has("name"))
            {
              localIntent.putExtra("register_nick_name", paramAnonymousJSONObject.getString("name"));
              Log.i("MicroMsg.WelcomeActivity", "name %s", new Object[] { paramAnonymousJSONObject.getString("name") });
            }
            if (paramAnonymousJSONObject.has("picture"))
            {
              Log.i("MicroMsg.WelcomeActivity", "picture %s", new Object[] { paramAnonymousJSONObject.get("picture") });
              localIntent.putExtra("register_avatar", ((JSONObject)paramAnonymousJSONObject.get("picture")).getJSONObject("data").getString("url"));
            }
            paramAnonymousJSONObject = WelcomeActivity.this;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousJSONObject, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousJSONObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousJSONObject, "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            WelcomeActivity.a(WelcomeActivity.this).eTd = 1L;
            WelcomeActivity.a(WelcomeActivity.this).ejA = 3L;
            WelcomeActivity.a(WelcomeActivity.this).bfK();
            AppMethodBeat.o(128807);
            return;
          }
          catch (Exception paramAnonymousJSONObject)
          {
            Log.printErrStackTrace("MicroMsg.WelcomeActivity", paramAnonymousJSONObject, "parse json error!", new Object[0]);
            h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
            AppMethodBeat.o(128807);
          }
        }
        
        public final void onError(String paramAnonymousString)
        {
          AppMethodBeat.i(128808);
          Log.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", new Object[] { paramAnonymousString });
          h.c(WelcomeActivity.this, WelcomeActivity.this.getString(2131759100), "", true);
          AppMethodBeat.o(128808);
        }
      });
      AppMethodBeat.o(128814);
      return;
    }
    g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      JSONObject klc = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(128809);
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("fields", "name,picture.type(large)");
        try
        {
          localObject = WelcomeActivity.e(WelcomeActivity.this).r("me", (Bundle)localObject);
          Log.i("MicroMsg.WelcomeActivity", "result json %s", new Object[] { localObject });
          this.klc = new JSONObject((String)localObject);
          AppMethodBeat.o(128809);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "get name and picture error!", new Object[0]);
            h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
          }
        }
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(128810);
        if (this.klc != null) {}
        try
        {
          Object localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
          ((Intent)localObject).putExtra("third_app_token", WelcomeActivity.e(WelcomeActivity.this).jZX.toString());
          ((Intent)localObject).putExtra("reg_3d_app_type", 1);
          ((Intent)localObject).putExtra("register_title", WelcomeActivity.this.getString(2131758186));
          ((Intent)localObject).putExtra("register_nick_name", this.klc.getString("name"));
          ((Intent)localObject).putExtra("register_avatar", ((JSONObject)this.klc.get("picture")).getJSONObject("data").getString("url"));
          WelcomeActivity localWelcomeActivity = WelcomeActivity.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localWelcomeActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localWelcomeActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localWelcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          WelcomeActivity.a(WelcomeActivity.this).eTd = 1L;
          WelcomeActivity.a(WelcomeActivity.this).ejA = 3L;
          WelcomeActivity.a(WelcomeActivity.this).bfK();
          AppMethodBeat.o(128810);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "parse json error!", new Object[0]);
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
      Log.i("MicroMsg.WelcomeActivity", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.kkF != null) {
        this.kkF.j(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(128817);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(128816);
    Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("can_finish", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.kd(this);
    AppMethodBeat.o(128816);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128812);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.ksB = new WelcomeSelectView(this);
    setContentView(this.ksB);
    this.ksB.bpY();
    this.ksB.ksF.setOnClickListener(new WelcomeActivity.1(this));
    this.ksB.ksD.setOnClickListener(new WelcomeActivity.4(this));
    paramBundle = new ArrayList();
    final n localn = new n(this, 1001, 0);
    localn.setTitle(2131764371);
    paramBundle.add(localn);
    localn = new n(this, 1002, 0);
    if (com.tencent.mm.aw.b.bdD())
    {
      localn.setTitle(2131764369);
      paramBundle.add(localn);
    }
    if (paramBundle.size() > 1)
    {
      final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      locale.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(128803);
          if (paramAnonymousm.gKQ())
          {
            Iterator localIterator = paramBundle.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousm.g((n)localIterator.next());
            }
          }
          AppMethodBeat.o(128803);
        }
      };
      locale.HLY = new o.g()
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128804);
            return;
            WelcomeActivity.a(WelcomeActivity.this).eTd = 1L;
            WelcomeActivity.a(WelcomeActivity.this).ejA = 2L;
            WelcomeActivity.a(WelcomeActivity.this).bfK();
            WelcomeActivity.b(WelcomeActivity.this);
          }
        }
      };
      locale.PGl = new e.b()
      {
        public final void onDismiss() {}
      };
      this.ksB.ksE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128805);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (com.tencent.mm.protocal.d.KyR)
          {
            WelcomeActivity.c(WelcomeActivity.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128805);
            return;
          }
          locale.dGm();
          if (paramBundle.contains(localn))
          {
            WelcomeActivity.a(WelcomeActivity.this).eTd = 1L;
            WelcomeActivity.a(WelcomeActivity.this).ejA = 1L;
            WelcomeActivity.a(WelcomeActivity.this).bfK();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128805);
        }
      });
      AppMethodBeat.o(128812);
      return;
    }
    this.ksB.ksE.setOnClickListener(new WelcomeActivity.9(this));
    AppMethodBeat.o(128812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128815);
    super.onDestroy();
    this.kkY.bfK();
    if (this.kkF != null) {
      this.kkF.logout();
    }
    AppMethodBeat.o(128815);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(161711);
    this.kmF.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(161711);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128813);
    super.onResume();
    this.ksB.init();
    AppMethodBeat.o(128813);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */