package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.u;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements i
{
  private as contact = null;
  private TextView gCd;
  private ImageView gyr;
  private TextView kcZ;
  private TextView nUp;
  com.tencent.mm.ui.base.q nUq;
  private TextView titleTv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.c(this.gyr, this.contact.field_username);
    this.kcZ.setText(this.contact.arJ());
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      this.gCd.setTextColor(u.kF(getContext()));
      this.gCd.setText(2131765542);
      this.gCd.setCompoundDrawablesWithIntrinsicBounds(2131235049, 0, 0, 0);
      this.nUp.setText(2131765542);
      this.nUp.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.gCd.setTextColor(u.kG(getContext()));
    this.gCd.setText(2131765550);
    this.gCd.setCompoundDrawablesWithIntrinsicBounds(2131235048, 0, 0, 0);
    this.nUp.setText(2131765540);
    this.nUp.setClickable(true);
    AppMethodBeat.o(48670);
  }
  
  public int getLayoutId()
  {
    return 2131493054;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48669);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131755576));
    this.gyr = ((ImageView)findViewById(2131305629));
    this.kcZ = ((TextView)findViewById(2131305630));
    this.gCd = ((TextView)findViewById(2131305632));
    this.titleTv = ((TextView)findViewById(2131305634));
    this.nUp = ((TextView)findViewById(2131305631));
    this.nUp.setOnClickListener(new AppBrandOpenWeRunSettingUI.1(this));
    setBackBtn(new AppBrandOpenWeRunSettingUI.2(this));
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.gMZ == 0))
    {
      getString(2131755998);
      this.nUq = h.a(this, getString(2131756029), true, null);
      this.nUq.show();
      ay.a.iDq.a("gh_43f2581f6fd6", "", new AppBrandOpenWeRunSettingUI.3(this));
    }
    this.titleTv.setText(getString(2131755578, new Object[] { paramBundle }));
    updateStatus();
    AppMethodBeat.o(48669);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(48671);
    if ((paramq instanceof p))
    {
      com.tencent.mm.kernel.g.aAg().hqi.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label122;
      }
      Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label122:
    as localas;
    for (;;)
    {
      if (this.nUq != null) {
        this.nUq.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramq = ((p)paramq).gmD();
      Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramq });
      this.contact = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
      localas = this.contact;
      if ((localas != null) && (!Util.isNullOrNil(paramq))) {
        break;
      }
      Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramq + ", contact = " + localas);
      paramString = ag.bah().MT(this.contact.field_username);
      ag.bah().h(paramString);
      com.tencent.mm.kernel.g.aAh().azQ().set(327825, Boolean.TRUE);
      setResult(-1);
      MMHandlerThread.postToMainThreadDelayed(new AppBrandOpenWeRunSettingUI.4(this), 1500L);
    }
    if (ab.IR(localas.field_username))
    {
      String str = Util.nullAsNil(localas.field_username);
      paramString = com.tencent.mm.al.g.fJ(str);
      if (paramString != null) {
        paramString.field_username = paramq;
      }
      ag.bah().delete(str);
      localas.BK(str);
    }
    for (;;)
    {
      localas.setUsername(paramq);
      if ((int)localas.gMZ == 0) {
        ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().aq(localas);
      }
      if ((int)localas.gMZ <= 0)
      {
        Log.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      ab.B(localas);
      paramq = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(localas.field_username);
      if (paramString != null)
      {
        ag.bah().g(paramString);
        break;
      }
      paramString = com.tencent.mm.al.g.fJ(paramq.field_username);
      if ((paramString == null) || (paramString.Uz()))
      {
        Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        ay.a.iDq.aL(paramq.field_username, "");
        com.tencent.mm.aj.c.Mf(paramq.field_username);
        break;
      }
      if (!paramq.gBQ()) {
        break;
      }
      Log.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramq.fuP) });
      ay.a.iDq.aL(paramq.field_username, "");
      com.tencent.mm.aj.c.Mf(paramq.field_username);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI
 * JD-Core Version:    0.7.0.1
 */