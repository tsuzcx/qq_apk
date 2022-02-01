package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.i.a.c.a;
import com.tencent.mm.ui.i.a.d.a;
import com.tencent.mm.ui.i.a.d.b;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WelcomeActivity
  extends MMFragmentActivity
{
  private static final String[] nbW = { "public_profile" };
  private c ncL;
  private ms ncO;
  private com.tencent.mm.ui.i.a.d ncv;
  private x nex;
  private WelcomeSelectView nkk;
  
  public WelcomeActivity()
  {
    AppMethodBeat.i(128811);
    this.ncO = new ms();
    this.nex = new x();
    AppMethodBeat.o(128811);
  }
  
  private void bAj()
  {
    AppMethodBeat.i(128814);
    if (r.u(this, "com.facebook.katana"))
    {
      this.ncv.a("name,picture.type(large)", new d.a()
      {
        public final void C(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(128807);
          Log.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
          if (paramAnonymousJSONObject != null) {}
          try
          {
            Intent localIntent = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (WelcomeActivity.d(WelcomeActivity.this).XGX != null)
            {
              localObject1 = localObject2;
              if (WelcomeActivity.d(WelcomeActivity.this).XGX.getToken() != null) {
                localObject1 = WelcomeActivity.d(WelcomeActivity.this).XGX.getToken().toString();
              }
            }
            localIntent.putExtra("third_app_token", (String)localObject1);
            localIntent.putExtra("reg_3d_app_type", 1);
            localIntent.putExtra("register_title", WelcomeActivity.this.getString(r.j.continue_register_title));
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
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousJSONObject, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousJSONObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousJSONObject, "com/tencent/mm/plugin/account/ui/WelcomeActivity$8", "onCompleted", "(Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            WelcomeActivity.a(WelcomeActivity.this).gVr = 1L;
            WelcomeActivity.a(WelcomeActivity.this).gef = 3L;
            WelcomeActivity.a(WelcomeActivity.this).bpa();
            AppMethodBeat.o(128807);
            return;
          }
          catch (Exception paramAnonymousJSONObject)
          {
            Log.printErrStackTrace("MicroMsg.WelcomeActivity", paramAnonymousJSONObject, "parse json error!", new Object[0]);
            com.tencent.mm.ui.base.h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
            AppMethodBeat.o(128807);
          }
        }
        
        public final void onError(String paramAnonymousString)
        {
          AppMethodBeat.i(128808);
          Log.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", new Object[] { paramAnonymousString });
          com.tencent.mm.ui.base.h.c(WelcomeActivity.this, WelcomeActivity.this.getString(r.j.facebook_auth_failed), "", true);
          AppMethodBeat.o(128808);
        }
      });
      AppMethodBeat.o(128814);
      return;
    }
    com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      JSONObject ncS = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(128809);
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("fields", "name,picture.type(large)");
        try
        {
          localObject = WelcomeActivity.e(WelcomeActivity.this).w("me", (Bundle)localObject);
          Log.i("MicroMsg.WelcomeActivity", "result json %s", new Object[] { localObject });
          this.ncS = new JSONObject((String)localObject);
          AppMethodBeat.o(128809);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "get name and picture error!", new Object[0]);
            com.tencent.mm.ui.base.h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
          }
        }
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(128810);
        if (this.ncS != null) {}
        try
        {
          Object localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
          ((Intent)localObject).putExtra("third_app_token", WelcomeActivity.e(WelcomeActivity.this).mRq.toString());
          ((Intent)localObject).putExtra("reg_3d_app_type", 1);
          ((Intent)localObject).putExtra("register_title", WelcomeActivity.this.getString(r.j.continue_register_title));
          ((Intent)localObject).putExtra("register_nick_name", this.ncS.getString("name"));
          ((Intent)localObject).putExtra("register_avatar", ((JSONObject)this.ncS.get("picture")).getJSONObject("data").getString("url"));
          WelcomeActivity localWelcomeActivity = WelcomeActivity.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localWelcomeActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localWelcomeActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localWelcomeActivity, "com/tencent/mm/plugin/account/ui/WelcomeActivity$9", "onPostExecute", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          WelcomeActivity.a(WelcomeActivity.this).gVr = 1L;
          WelcomeActivity.a(WelcomeActivity.this).gef = 3L;
          WelcomeActivity.a(WelcomeActivity.this).bpa();
          AppMethodBeat.o(128810);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "parse json error!", new Object[0]);
            com.tencent.mm.ui.base.h.c(WelcomeActivity.this, "Retrieve Failed, Error Format!", "", true);
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
      if (this.ncv != null) {
        this.ncv.j(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(128817);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(128816);
    Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("can_finish", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.lb(this);
    AppMethodBeat.o(128816);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128812);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.nkk = new WelcomeSelectView(this);
    setContentView(this.nkk);
    this.nkk.bAk();
    this.nkk.nko.setOnClickListener(new WelcomeActivity.1(this));
    this.nkk.nkm.setOnClickListener(new WelcomeActivity.4(this));
    paramBundle = new ArrayList();
    final p localp = new p(this, 1001, 0);
    localp.setTitle(r.j.regby_mobile_title);
    paramBundle.add(localp);
    localp = new p(this, 1002, 0);
    if (com.tencent.mm.az.b.bmX())
    {
      localp.setTitle(r.j.regby_facebook_title);
      paramBundle.add(localp);
    }
    if (paramBundle.size() > 1)
    {
      final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      locale.ODT = new WelcomeActivity.5(this, paramBundle);
      locale.ODU = new q.g()
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128804);
            return;
            WelcomeActivity.a(WelcomeActivity.this).gVr = 1L;
            WelcomeActivity.a(WelcomeActivity.this).gef = 2L;
            WelcomeActivity.a(WelcomeActivity.this).bpa();
            WelcomeActivity.b(WelcomeActivity.this);
          }
        }
      };
      locale.XbB = new e.b()
      {
        public final void onDismiss() {}
      };
      this.nkk.nkn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128805);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (com.tencent.mm.protocal.d.RAG)
          {
            WelcomeActivity.c(WelcomeActivity.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128805);
            return;
          }
          locale.eik();
          if (paramBundle.contains(localp))
          {
            WelcomeActivity.a(WelcomeActivity.this).gVr = 1L;
            WelcomeActivity.a(WelcomeActivity.this).gef = 1L;
            WelcomeActivity.a(WelcomeActivity.this).bpa();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128805);
        }
      });
      AppMethodBeat.o(128812);
      return;
    }
    this.nkk.nkn.setOnClickListener(new WelcomeActivity.9(this));
    AppMethodBeat.o(128812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128815);
    super.onDestroy();
    this.ncO.bpa();
    if (this.ncv != null) {
      this.ncv.dbv();
    }
    AppMethodBeat.o(128815);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(161711);
    this.nex.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(161711);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128813);
    super.onResume();
    this.nkk.init();
    AppMethodBeat.o(128813);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */