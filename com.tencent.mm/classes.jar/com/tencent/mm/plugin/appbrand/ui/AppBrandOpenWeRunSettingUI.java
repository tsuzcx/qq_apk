package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.v;
import java.util.LinkedList;
import java.util.List;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements i
{
  private as contact = null;
  private ImageView jiu;
  private TextView jmj;
  private TextView mUy;
  s oTk;
  private TextView qVN;
  private TextView titleTv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.c(this.jiu, this.contact.field_username);
    this.mUy.setText(this.contact.ays());
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      this.jmj.setTextColor(v.lC(getContext()));
      this.jmj.setText(au.i.settings_plugins_installed);
      this.jmj.setCompoundDrawablesWithIntrinsicBounds(au.e.status_enable, 0, 0, 0);
      this.qVN.setText(au.i.settings_plugins_installed);
      this.qVN.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.jmj.setTextColor(v.lD(getContext()));
    this.jmj.setText(au.i.settings_plugins_uninstalled);
    this.jmj.setCompoundDrawablesWithIntrinsicBounds(au.e.status_disable, 0, 0, 0);
    this.qVN.setText(au.i.settings_plugins_install);
    this.qVN.setClickable(true);
    AppMethodBeat.o(48670);
  }
  
  public int getLayoutId()
  {
    return au.g.app_brand_open_we_run_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48669);
    super.onCreate(paramBundle);
    setMMTitle(getString(au.i.app_brand_open_we_run));
    this.jiu = ((ImageView)findViewById(au.f.open_we_run_avatar_iv));
    this.mUy = ((TextView)findViewById(au.f.open_we_run_nickname_tv));
    this.jmj = ((TextView)findViewById(au.f.open_we_run_status_tv));
    this.titleTv = ((TextView)findViewById(au.f.open_we_run_title));
    this.qVN = ((TextView)findViewById(au.f.open_we_run_open));
    this.qVN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48665);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        com.tencent.mm.plugin.sport.a.d.rE(13);
        paramAnonymousView = AppBrandOpenWeRunSettingUI.this;
        paramAnonymousView.getString(au.i.app_tip);
        paramAnonymousView.oTk = com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getString(au.i.settings_plugins_installing), true, null);
        paramAnonymousView.oTk.show();
        com.tencent.mm.kernel.h.aHF().kcd.a(30, paramAnonymousView);
        paramAnonymousView = new LinkedList();
        paramAnonymousView.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramAnonymousView = new com.tencent.mm.pluginsdk.model.t(paramAnonymousView, (List)localObject, "", "");
        com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousView, 0);
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
    this.contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.jxt == 0))
    {
      getString(au.i.app_tip);
      this.oTk = com.tencent.mm.ui.base.h.a(this, getString(au.i.app_waiting), true, null);
      this.oTk.show();
      az.a.ltq.a("gh_43f2581f6fd6", "", new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48667);
          Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this, ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_43f2581f6fd6"));
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this);
          AppBrandOpenWeRunSettingUI.b(AppBrandOpenWeRunSettingUI.this).dismiss();
          AppMethodBeat.o(48667);
        }
      });
    }
    this.titleTv.setText(getString(au.i.app_brand_open_we_run_title, new Object[] { paramBundle }));
    updateStatus();
    AppMethodBeat.o(48669);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(48671);
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      com.tencent.mm.kernel.h.aHF().kcd.b(30, this);
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
    as localas;
    for (;;)
    {
      if (this.oTk != null) {
        this.oTk.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramq = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
      Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramq });
      this.contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG("gh_43f2581f6fd6");
      localas = this.contact;
      if ((localas != null) && (!Util.isNullOrNil(paramq))) {
        break;
      }
      Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramq + ", contact = " + localas);
      paramString = af.bjv().Uo(this.contact.field_username);
      af.bjv().h(paramString);
      com.tencent.mm.kernel.h.aHG().aHp().i(327825, Boolean.TRUE);
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
    if (ab.Qk(localas.field_username))
    {
      String str = Util.nullAsNil(localas.field_username);
      paramString = g.gu(str);
      if (paramString != null) {
        paramString.field_username = paramq;
      }
      af.bjv().Up(str);
      localas.Iy(str);
    }
    for (;;)
    {
      localas.setUsername(paramq);
      if ((int)localas.jxt == 0) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().aw(localas);
      }
      if ((int)localas.jxt <= 0)
      {
        Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      ab.H(localas);
      paramq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localas.field_username);
      if (paramString != null)
      {
        af.bjv().g(paramString);
        break;
      }
      paramString = g.gu(paramq.field_username);
      if ((paramString == null) || (paramString.YR()))
      {
        Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        az.a.ltq.aP(paramq.field_username, "");
        com.tencent.mm.am.d.TA(paramq.field_username);
        break;
      }
      if (!paramq.hyb()) {
        break;
      }
      Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramq.hDo) });
      az.a.ltq.aP(paramq.field_username, "");
      com.tencent.mm.am.d.TA(paramq.field_username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI
 * JD-Core Version:    0.7.0.1
 */