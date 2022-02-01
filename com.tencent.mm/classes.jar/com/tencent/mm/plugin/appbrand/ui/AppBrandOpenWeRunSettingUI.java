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
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.t;
import java.util.LinkedList;
import java.util.List;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private am contact = null;
  private ImageView fRd;
  private TextView fUR;
  private TextView jcd;
  private TextView mCm;
  p mCn;
  private TextView titleTv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.c(this.fRd, this.contact.field_username);
    this.jcd.setText(this.contact.adv());
    if (com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      this.fUR.setTextColor(t.kC(getContext()));
      this.fUR.setText(2131763360);
      this.fUR.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      this.mCm.setText(2131763360);
      this.mCm.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.fUR.setTextColor(t.kD(getContext()));
    this.fUR.setText(2131763368);
    this.fUR.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    this.mCm.setText(2131763358);
    this.mCm.setClickable(true);
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
    this.fRd = ((ImageView)findViewById(2131303026));
    this.jcd = ((TextView)findViewById(2131303027));
    this.fUR = ((TextView)findViewById(2131303029));
    this.titleTv = ((TextView)findViewById(2131303031));
    this.mCm = ((TextView)findViewById(2131303028));
    this.mCm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48665);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        com.tencent.mm.plugin.sport.a.c.ma(13);
        paramAnonymousView = AppBrandOpenWeRunSettingUI.this;
        paramAnonymousView.getString(2131755906);
        paramAnonymousView.mCn = h.b(paramAnonymousView, paramAnonymousView.getString(2131763362), true, null);
        paramAnonymousView.mCn.show();
        com.tencent.mm.kernel.g.ajB().gAO.a(30, paramAnonymousView);
        paramAnonymousView = new LinkedList();
        paramAnonymousView.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramAnonymousView = new o(paramAnonymousView, (List)localObject, "", "");
        com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousView, 0);
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
    paramBundle = bt.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.gfj == 0))
    {
      getString(2131755906);
      this.mCn = h.b(this, getString(2131755936), true, null);
      this.mCn.show();
      as.a.hFO.a("gh_43f2581f6fd6", "", new as.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48667);
          ad.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this, ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf("gh_43f2581f6fd6"));
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
      com.tencent.mm.kernel.g.ajB().gAO.b(30, this);
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
    am localam;
    for (;;)
    {
      if (this.mCn != null) {
        this.mCn.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramn = ((o)paramn).eZF();
      ad.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramn });
      this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf("gh_43f2581f6fd6");
      localam = this.contact;
      if ((localam != null) && (!bt.isNullOrNil(paramn))) {
        break;
      }
      ad.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramn + ", contact = " + localam);
      paramString = ag.aFZ().DD(this.contact.field_username);
      ag.aFZ().g(paramString);
      com.tencent.mm.kernel.g.ajC().ajl().set(327825, Boolean.TRUE);
      setResult(-1);
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48668);
          AppBrandOpenWeRunSettingUI.this.finish();
          AppMethodBeat.o(48668);
        }
      }, 1500L);
    }
    if (w.zC(localam.field_username))
    {
      String str = bt.nullAsNil(localam.field_username);
      paramString = com.tencent.mm.am.g.eS(str);
      if (paramString != null) {
        paramString.field_username = paramn;
      }
      ag.aFZ().delete(str);
      localam.sZ(str);
    }
    for (;;)
    {
      localam.setUsername(paramn);
      if ((int)localam.gfj == 0) {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().ah(localam);
      }
      if ((int)localam.gfj <= 0)
      {
        ad.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      w.u(localam);
      paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(localam.field_username);
      if (paramString != null)
      {
        ag.aFZ().f(paramString);
        break;
      }
      paramString = com.tencent.mm.am.g.eS(paramn.field_username);
      if ((paramString == null) || (paramString.Kh()))
      {
        ad.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        as.a.hFO.aI(paramn.field_username, "");
        com.tencent.mm.ak.c.CT(paramn.field_username);
        break;
      }
      if (!paramn.fqk()) {
        break;
      }
      ad.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramn.ePB) });
      as.a.hFO.aI(paramn.field_username, "");
      com.tencent.mm.ak.c.CT(paramn.field_username);
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