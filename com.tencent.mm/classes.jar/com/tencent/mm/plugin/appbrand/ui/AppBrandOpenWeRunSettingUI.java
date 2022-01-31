package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.s;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private ad contact = null;
  private ImageView ehv;
  private TextView gpr;
  private TextView gvQ;
  private TextView iMY;
  com.tencent.mm.ui.base.p iMZ;
  private TextView titleTv;
  
  private void aMi()
  {
    AppMethodBeat.i(132999);
    a.b.c(this.ehv, this.contact.field_username);
    this.gvQ.setText(this.contact.Of());
    if (a.je(this.contact.field_type))
    {
      this.gpr.setTextColor(s.iD(getContext()));
      this.gpr.setText(2131303378);
      this.gpr.setCompoundDrawablesWithIntrinsicBounds(2130840454, 0, 0, 0);
      this.iMY.setText(2131303378);
      this.iMY.setClickable(false);
      AppMethodBeat.o(132999);
      return;
    }
    this.gpr.setTextColor(s.iE(getContext()));
    this.gpr.setText(2131303386);
    this.gpr.setCompoundDrawablesWithIntrinsicBounds(2130840453, 0, 0, 0);
    this.iMY.setText(2131303376);
    this.iMY.setClickable(true);
    AppMethodBeat.o(132999);
  }
  
  public int getLayoutId()
  {
    return 2130968700;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(132998);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131296750));
    this.ehv = ((ImageView)findViewById(2131821266));
    this.gvQ = ((TextView)findViewById(2131821267));
    this.gpr = ((TextView)findViewById(2131821268));
    this.titleTv = ((TextView)findViewById(2131821269));
    this.iMY = ((TextView)findViewById(2131821271));
    this.iMY.setOnClickListener(new AppBrandOpenWeRunSettingUI.1(this));
    setBackBtn(new AppBrandOpenWeRunSettingUI.2(this));
    paramBundle = bo.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((j)g.E(j.class)).YA().arw("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.euF == 0))
    {
      getString(2131297087);
      this.iMZ = h.b(this, getString(2131297112), true, null);
      this.iMZ.show();
      ao.a.flI.a("gh_43f2581f6fd6", "", new AppBrandOpenWeRunSettingUI.3(this));
    }
    this.titleTv.setText(getString(2131296752, new Object[] { paramBundle }));
    aMi();
    AppMethodBeat.o(132998);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(133000);
    if ((paramm instanceof com.tencent.mm.pluginsdk.model.m))
    {
      g.RK().eHt.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label122;
      }
      ab.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bo.isNullOrNil(paramString))) {
        Toast.makeText(ah.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label122:
    ad localad;
    for (;;)
    {
      if (this.iMZ != null) {
        this.iMZ.dismiss();
      }
      aMi();
      AppMethodBeat.o(133000);
      return;
      paramm = ((com.tencent.mm.pluginsdk.model.m)paramm).dlk();
      ab.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramm });
      this.contact = ((j)g.E(j.class)).YA().arw("gh_43f2581f6fd6");
      localad = this.contact;
      if ((localad != null) && (!bo.isNullOrNil(paramm))) {
        break;
      }
      ab.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramm + ", contact = " + localad);
      paramString = com.tencent.mm.aj.z.afi().rK(this.contact.field_username);
      com.tencent.mm.aj.z.afi().e(paramString);
      g.RL().Ru().set(327825, Boolean.TRUE);
      setResult(-1);
      al.p(new AppBrandOpenWeRunSettingUI.4(this), 1500L);
    }
    if (t.nS(localad.field_username))
    {
      String str = bo.nullAsNil(localad.field_username);
      paramString = com.tencent.mm.aj.f.rS(str);
      if (paramString != null) {
        paramString.field_username = paramm;
      }
      com.tencent.mm.aj.z.afi().delete(str);
      localad.jv(str);
    }
    for (;;)
    {
      localad.setUsername(paramm);
      if ((int)localad.euF == 0) {
        ((j)g.E(j.class)).YA().Z(localad);
      }
      if ((int)localad.euF <= 0)
      {
        ab.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      t.q(localad);
      paramm = ((j)g.E(j.class)).YA().arw(localad.field_username);
      if (paramString != null)
      {
        com.tencent.mm.aj.z.afi().d(paramString);
        break;
      }
      paramString = com.tencent.mm.aj.f.rS(paramm.field_username);
      if ((paramString == null) || (paramString.aea()))
      {
        ab.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        ao.a.flI.am(paramm.field_username, "");
        com.tencent.mm.ah.b.qT(paramm.field_username);
        break;
      }
      if (!paramm.dwC()) {
        break;
      }
      ab.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramm.dqR) });
      ao.a.flI.am(paramm.field_username, "");
      com.tencent.mm.ah.b.qT(paramm.field_username);
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