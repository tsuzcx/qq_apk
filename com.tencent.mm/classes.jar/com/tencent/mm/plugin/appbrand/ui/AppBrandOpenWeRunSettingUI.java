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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.t;
import java.util.LinkedList;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private com.tencent.mm.storage.ai contact = null;
  private TextView fBE;
  private ImageView fxQ;
  private TextView iIU;
  private TextView mce;
  p mcf;
  private TextView titleTv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.c(this.fxQ, this.contact.field_username);
    this.iIU.setText(this.contact.aaS());
    if (com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      this.fBE.setTextColor(t.kq(getContext()));
      this.fBE.setText(2131763360);
      this.fBE.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      this.mce.setText(2131763360);
      this.mce.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.fBE.setTextColor(t.kr(getContext()));
    this.fBE.setText(2131763368);
    this.fBE.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    this.mce.setText(2131763358);
    this.mce.setClickable(true);
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
    this.fxQ = ((ImageView)findViewById(2131303026));
    this.iIU = ((TextView)findViewById(2131303027));
    this.fBE = ((TextView)findViewById(2131303029));
    this.titleTv = ((TextView)findViewById(2131303031));
    this.mce = ((TextView)findViewById(2131303028));
    this.mce.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48665);
        com.tencent.mm.plugin.sport.a.c.lA(13);
        paramAnonymousView = AppBrandOpenWeRunSettingUI.this;
        paramAnonymousView.getString(2131755906);
        paramAnonymousView.mcf = h.b(paramAnonymousView, paramAnonymousView.getString(2131763362), true, null);
        paramAnonymousView.mcf.show();
        com.tencent.mm.kernel.g.agQ().ghe.a(30, paramAnonymousView);
        paramAnonymousView = new LinkedList();
        paramAnonymousView.add("gh_43f2581f6fd6");
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add(Integer.valueOf(1));
        paramAnonymousView = new o(paramAnonymousView, localLinkedList, "", "");
        com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousView, 0);
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
    paramBundle = bs.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.fLJ == 0))
    {
      getString(2131755906);
      this.mcf = h.b(this, getString(2131755936), true, null);
      this.mcf.show();
      ar.a.hnw.a("gh_43f2581f6fd6", "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48667);
          ac.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this, ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt("gh_43f2581f6fd6"));
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
      com.tencent.mm.kernel.g.agQ().ghe.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label122;
      }
      ac.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString))) {
        Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label122:
    com.tencent.mm.storage.ai localai;
    for (;;)
    {
      if (this.mcf != null) {
        this.mcf.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramn = ((o)paramn).eKL();
      ac.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramn });
      this.contact = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt("gh_43f2581f6fd6");
      localai = this.contact;
      if ((localai != null) && (!bs.isNullOrNil(paramn))) {
        break;
      }
      ac.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramn + ", contact = " + localai);
      paramString = af.aCW().AE(this.contact.field_username);
      af.aCW().g(paramString);
      com.tencent.mm.kernel.g.agR().agA().set(327825, Boolean.TRUE);
      setResult(-1);
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48668);
          AppBrandOpenWeRunSettingUI.this.finish();
          AppMethodBeat.o(48668);
        }
      }, 1500L);
    }
    if (w.wF(localai.field_username))
    {
      String str = bs.nullAsNil(localai.field_username);
      paramString = f.dX(str);
      if (paramString != null) {
        paramString.field_username = paramn;
      }
      af.aCW().delete(str);
      localai.qp(str);
    }
    for (;;)
    {
      localai.setUsername(paramn);
      if ((int)localai.fLJ == 0) {
        ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().ah(localai);
      }
      if ((int)localai.fLJ <= 0)
      {
        ac.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      w.u(localai);
      paramn = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(localai.field_username);
      if (paramString != null)
      {
        af.aCW().f(paramString);
        break;
      }
      paramString = f.dX(paramn.field_username);
      if ((paramString == null) || (paramString.IH()))
      {
        ac.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        ar.a.hnw.aJ(paramn.field_username, "");
        com.tencent.mm.aj.c.zU(paramn.field_username);
        break;
      }
      if (!paramn.fah()) {
        break;
      }
      ac.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramn.eyc) });
      ar.a.hnw.aJ(paramn.field_username, "");
      com.tencent.mm.aj.c.zU(paramn.field_username);
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