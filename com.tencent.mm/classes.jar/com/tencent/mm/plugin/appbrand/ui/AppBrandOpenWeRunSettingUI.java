package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.u;
import java.util.LinkedList;
import java.util.List;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private au contact = null;
  private ImageView lKK;
  private TextView lPf;
  private TextView pRg;
  w rYw;
  private TextView titleTv;
  private TextView ubv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.g(this.lKK, this.contact.field_username);
    this.pRg.setText(this.contact.aSV());
    if (com.tencent.mm.contact.d.rs(this.contact.field_type))
    {
      this.lPf.setTextColor(u.nF(getContext()));
      this.lPf.setText(ba.i.settings_plugins_installed);
      this.lPf.setCompoundDrawablesWithIntrinsicBounds(ba.e.status_enable, 0, 0, 0);
      this.ubv.setText(ba.i.settings_plugins_installed);
      this.ubv.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.lPf.setTextColor(u.nG(getContext()));
    this.lPf.setText(ba.i.settings_plugins_uninstalled);
    this.lPf.setCompoundDrawablesWithIntrinsicBounds(ba.e.status_disable, 0, 0, 0);
    this.ubv.setText(ba.i.settings_plugins_install);
    this.ubv.setClickable(true);
    AppMethodBeat.o(48670);
  }
  
  public int getLayoutId()
  {
    return ba.g.app_brand_open_we_run_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48669);
    super.onCreate(paramBundle);
    setMMTitle(getString(ba.i.app_brand_open_we_run));
    this.lKK = ((ImageView)findViewById(ba.f.open_we_run_avatar_iv));
    this.pRg = ((TextView)findViewById(ba.f.open_we_run_nickname_tv));
    this.lPf = ((TextView)findViewById(ba.f.open_we_run_status_tv));
    this.titleTv = ((TextView)findViewById(ba.f.open_we_run_title));
    this.ubv = ((TextView)findViewById(ba.f.open_we_run_open));
    this.ubv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48665);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        com.tencent.mm.plugin.sport.a.d.rG(13);
        paramAnonymousView = AppBrandOpenWeRunSettingUI.this;
        paramAnonymousView.getString(ba.i.app_tip);
        paramAnonymousView.rYw = k.a(paramAnonymousView, paramAnonymousView.getString(ba.i.settings_plugins_installing), true, null);
        paramAnonymousView.rYw.show();
        com.tencent.mm.kernel.h.baD().mCm.a(30, paramAnonymousView);
        paramAnonymousView = new LinkedList();
        paramAnonymousView.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramAnonymousView = new v(paramAnonymousView, (List)localObject, "", "");
        com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousView, 0);
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48665);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48666);
        AppBrandOpenWeRunSettingUI.this.finish();
        AppMethodBeat.o(48666);
        return true;
      }
    });
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.maN == 0))
    {
      getString(ba.i.app_tip);
      this.rYw = k.a(this, getString(ba.i.app_waiting), true, null);
      this.rYw.show();
      az.a.okP.a("gh_43f2581f6fd6", "", new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48667);
          Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this, ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_43f2581f6fd6"));
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this);
          AppBrandOpenWeRunSettingUI.b(AppBrandOpenWeRunSettingUI.this).dismiss();
          AppMethodBeat.o(48667);
        }
      });
    }
    this.titleTv.setText(getString(ba.i.app_brand_open_we_run_title, new Object[] { paramBundle }));
    updateStatus();
    AppMethodBeat.o(48669);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(48671);
    if ((paramp instanceof v))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label124;
      }
      Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label124:
    au localau;
    for (;;)
    {
      if (this.rYw != null) {
        this.rYw.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramp = ((v)paramp).iIc();
      Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramp });
      this.contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("gh_43f2581f6fd6");
      localau = this.contact;
      if ((localau != null) && (!Util.isNullOrNil(paramp))) {
        break;
      }
      Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramp + ", contact = " + localau);
      paramString = af.bHf().Mn(this.contact.field_username);
      if (paramString != null) {
        af.bHf().h(paramString);
      }
      com.tencent.mm.kernel.h.baE().ban().B(327825, Boolean.TRUE);
      setResult(-1);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48668);
          AppBrandOpenWeRunSettingUI.this.finish();
          AppMethodBeat.o(48668);
        }
      }, 1500L);
    }
    if (au.bxa(localau.field_username))
    {
      String str = Util.nullAsNil(localau.field_username);
      paramString = g.hU(str);
      if (paramString != null) {
        paramString.field_username = paramp;
      }
      af.bHf().Mo(str);
      localau.Bd(str);
    }
    for (;;)
    {
      localau.setUsername(paramp);
      if ((int)localau.maN == 0) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().aC(localau);
      }
      if ((int)localau.maN <= 0)
      {
        Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      ab.I(localau);
      paramp = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localau.field_username);
      if (paramString != null)
      {
        af.bHf().g(paramString);
        break;
      }
      paramString = g.hU(paramp.field_username);
      if ((paramString == null) || (paramString.aAJ()))
      {
        Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        az.a.okP.aZ(paramp.field_username, "");
        com.tencent.mm.modelavatar.d.LA(paramp.field_username);
        break;
      }
      if (!paramp.iZI()) {
        break;
      }
      Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramp.kak) });
      az.a.okP.aZ(paramp.field_username, "");
      com.tencent.mm.modelavatar.d.LA(paramp.field_username);
      break;
      paramString = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI
 * JD-Core Version:    0.7.0.1
 */