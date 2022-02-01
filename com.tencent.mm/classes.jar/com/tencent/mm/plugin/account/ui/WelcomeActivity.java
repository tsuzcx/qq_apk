package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.mmfb.sdk.e;
import com.tencent.mm.ui.mmfb.sdk.f.a;
import com.tencent.mm.ui.mmfb.sdk.g;
import com.tencent.mm.ui.mmfb.sdk.h;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WelcomeActivity
  extends MMFragmentActivity
{
  private static final String[] qbG = { "public_profile" };
  private com.tencent.mm.ui.mmfb.sdk.f qbV;
  private pu qbY;
  private u qbk;
  private WelcomeSelectView qhs;
  private g qht;
  
  public WelcomeActivity()
  {
    AppMethodBeat.i(128811);
    this.qbY = new pu();
    this.qbk = new u();
    AppMethodBeat.o(128811);
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
      AppMethodBeat.o(128817);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(128816);
    Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("can_finish", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.nf(this);
    AppMethodBeat.o(128816);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128812);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if ((Build.VERSION.SDK_INT >= 26) && (!y.jjW())) {
      getWindow().setNavigationBarColor(getResources().getColor(r.c.Earth_bg_Dark));
    }
    this.qhs = new WelcomeSelectView(this);
    setContentView(this.qhs);
    this.qhs.bZb();
    this.qhs.qhx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128794);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/WelcomeActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("not_auth_setting", true);
        paramAnonymousView.putExtra("from_login_history", true);
        com.tencent.mm.plugin.account.sdk.a.pFn.m(paramAnonymousView, WelcomeActivity.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128794);
      }
    });
    this.qhs.qhv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128802);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((aw.jkP()) || (aw.ato()))
        {
          paramAnonymousView = d.pWz;
          localObject = new Intent(WelcomeActivity.this, LoginSelectUI.class);
          ((Intent)localObject).putExtra("mobile_input_purpose", 1);
          paramAnonymousView = WelcomeActivity.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128802);
          return;
          localObject = new Intent(WelcomeActivity.this, MobileInputUI.class);
          ((Intent)localObject).putExtra("mobile_input_purpose", 1);
          paramAnonymousView = WelcomeActivity.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
    paramBundle = new ArrayList();
    final t localt = new t(this, 1001, 0);
    localt.setTitle(r.j.regby_mobile_title);
    paramBundle.add(localt);
    localt = new t(this, 1002, 0);
    if (com.tencent.mm.au.b.bKJ())
    {
      localt.setTitle(r.j.regby_facebook_title);
      paramBundle.add(localt);
    }
    if (paramBundle.size() > 1)
    {
      final com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(this, 1, false);
      localf.Vtg = new u.g()
      {
        public final void onCreateMMMenu(s paramAnonymouss)
        {
          AppMethodBeat.i(128803);
          if (paramAnonymouss.jmw())
          {
            Iterator localIterator = paramBundle.iterator();
            while (localIterator.hasNext()) {
              paramAnonymouss.j((t)localIterator.next());
            }
          }
          AppMethodBeat.o(128803);
        }
      };
      localf.GAC = new u.i()
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/WelcomeActivity$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128804);
            return;
            WelcomeActivity.a(WelcomeActivity.this).joN = 1L;
            WelcomeActivity.a(WelcomeActivity.this).ikE = 2L;
            WelcomeActivity.a(WelcomeActivity.this).bMH();
            WelcomeActivity.b(WelcomeActivity.this);
          }
        }
      };
      localf.aeLi = new f.b()
      {
        public final void onDismiss() {}
      };
      this.qhs.qhw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128805);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          localf.dDn();
          if (paramBundle.contains(localt))
          {
            WelcomeActivity.a(WelcomeActivity.this).joN = 1L;
            WelcomeActivity.a(WelcomeActivity.this).ikE = 1L;
            WelcomeActivity.a(WelcomeActivity.this).bMH();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128805);
        }
      });
      AppMethodBeat.o(128812);
      return;
    }
    this.qhs.qhw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128806);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = new Intent(WelcomeActivity.this, RegByMobileRegAIOUI.class);
        paramAnonymousView = WelcomeActivity.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128806);
      }
    });
    AppMethodBeat.o(128812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128815);
    super.onDestroy();
    this.qbY.bMH();
    if (this.qht != null) {
      this.qht.afzb = 0L;
    }
    if (this.qbV != null) {
      this.qbV.cf(this);
    }
    AppMethodBeat.o(128815);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(161711);
    this.qbk.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(161711);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128813);
    super.onResume();
    this.qhs.init();
    AppMethodBeat.o(128813);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */