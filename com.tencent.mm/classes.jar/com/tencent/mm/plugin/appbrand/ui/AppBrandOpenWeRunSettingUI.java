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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.t;
import java.util.LinkedList;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.storage.af contact = null;
  private ImageView fuj;
  private TextView fxX;
  private TextView iiN;
  private TextView lAi;
  p lAj;
  private TextView titleTv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.c(this.fuj, this.contact.field_username);
    this.iiN.setText(this.contact.ZX());
    if (com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      this.fxX.setTextColor(t.kf(getContext()));
      this.fxX.setText(2131763360);
      this.fxX.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      this.lAi.setText(2131763360);
      this.lAi.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.fxX.setTextColor(t.kg(getContext()));
    this.fxX.setText(2131763368);
    this.fxX.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    this.lAi.setText(2131763358);
    this.lAi.setClickable(true);
    AppMethodBeat.o(48670);
  }
  
  public int getLayoutId()
  {
    return 2131493015;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48669);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131755535));
    this.fuj = ((ImageView)findViewById(2131303026));
    this.iiN = ((TextView)findViewById(2131303027));
    this.fxX = ((TextView)findViewById(2131303029));
    this.titleTv = ((TextView)findViewById(2131303031));
    this.lAi = ((TextView)findViewById(2131303028));
    this.lAi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48665);
        com.tencent.mm.plugin.sport.a.c.lI(13);
        paramAnonymousView = AppBrandOpenWeRunSettingUI.this;
        paramAnonymousView.getString(2131755906);
        paramAnonymousView.lAj = h.b(paramAnonymousView, paramAnonymousView.getString(2131763362), true, null);
        paramAnonymousView.lAj.show();
        com.tencent.mm.kernel.g.afA().gcy.a(30, paramAnonymousView);
        paramAnonymousView = new LinkedList();
        paramAnonymousView.add("gh_43f2581f6fd6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramAnonymousView = new o(paramAnonymousView, localLinkedList, "", "");
        com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousView, 0);
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
    paramBundle = bt.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.fId == 0))
    {
      getString(2131755906);
      this.lAj = h.b(this, getString(2131755936), true, null);
      this.lAj.show();
      ar.a.gMW.a("gh_43f2581f6fd6", "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48667);
          ad.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this, ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY("gh_43f2581f6fd6"));
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this);
          AppBrandOpenWeRunSettingUI.b(AppBrandOpenWeRunSettingUI.this).dismiss();
          AppMethodBeat.o(48667);
        }
      });
    }
    this.titleTv.setText(getString(2131755537, new Object[] { paramBundle }));
    updateStatus();
    AppMethodBeat.o(48669);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(48671);
    if ((paramn instanceof o))
    {
      com.tencent.mm.kernel.g.afA().gcy.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label122;
      }
      ad.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString))) {
        Toast.makeText(aj.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label122:
    com.tencent.mm.storage.af localaf;
    for (;;)
    {
      if (this.lAj != null) {
        this.lAj.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramn = ((o)paramn).evr();
      ad.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramn });
      this.contact = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY("gh_43f2581f6fd6");
      localaf = this.contact;
      if ((localaf != null) && (!bt.isNullOrNil(paramn))) {
        break;
      }
      ad.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramn + ", contact = " + localaf);
      paramString = com.tencent.mm.am.af.awe().wy(this.contact.field_username);
      com.tencent.mm.am.af.awe().g(paramString);
      com.tencent.mm.kernel.g.afB().afk().set(327825, Boolean.TRUE);
      setResult(-1);
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48668);
          AppBrandOpenWeRunSettingUI.this.finish();
          AppMethodBeat.o(48668);
        }
      }, 1500L);
    }
    if (w.sC(localaf.field_username))
    {
      String str = bt.nullAsNil(localaf.field_username);
      paramString = f.ei(str);
      if (paramString != null) {
        paramString.field_username = paramn;
      }
      com.tencent.mm.am.af.awe().delete(str);
      localaf.nj(str);
    }
    for (;;)
    {
      localaf.setUsername(paramn);
      if ((int)localaf.fId == 0) {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().ag(localaf);
      }
      if ((int)localaf.fId <= 0)
      {
        ad.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      w.u(localaf);
      paramn = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(localaf.field_username);
      if (paramString != null)
      {
        com.tencent.mm.am.af.awe().f(paramString);
        break;
      }
      paramString = f.ei(paramn.field_username);
      if ((paramString == null) || (paramString.IY()))
      {
        ad.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        ar.a.gMW.aB(paramn.field_username, "");
        com.tencent.mm.ak.c.vO(paramn.field_username);
        break;
      }
      if (!paramn.eKF()) {
        break;
      }
      ad.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramn.evG) });
      ar.a.gMW.aB(paramn.field_username, "");
      com.tencent.mm.ak.c.vO(paramn.field_username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI
 * JD-Core Version:    0.7.0.1
 */