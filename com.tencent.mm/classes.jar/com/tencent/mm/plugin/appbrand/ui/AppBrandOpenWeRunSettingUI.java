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
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.t;
import java.util.LinkedList;
import java.util.List;

public class AppBrandOpenWeRunSettingUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private an contact = null;
  private ImageView fTj;
  private TextView fWX;
  private TextView jeW;
  private TextView mHr;
  p mHs;
  private TextView titleTv;
  
  private void updateStatus()
  {
    AppMethodBeat.i(48670);
    a.b.c(this.fTj, this.contact.field_username);
    this.jeW.setText(this.contact.adG());
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      this.fWX.setTextColor(t.kJ(getContext()));
      this.fWX.setText(2131763360);
      this.fWX.setCompoundDrawablesWithIntrinsicBounds(2131234178, 0, 0, 0);
      this.mHr.setText(2131763360);
      this.mHr.setClickable(false);
      AppMethodBeat.o(48670);
      return;
    }
    this.fWX.setTextColor(t.kK(getContext()));
    this.fWX.setText(2131763368);
    this.fWX.setCompoundDrawablesWithIntrinsicBounds(2131234177, 0, 0, 0);
    this.mHr.setText(2131763358);
    this.mHr.setClickable(true);
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
    this.fTj = ((ImageView)findViewById(2131303026));
    this.jeW = ((TextView)findViewById(2131303027));
    this.fWX = ((TextView)findViewById(2131303029));
    this.titleTv = ((TextView)findViewById(2131303031));
    this.mHr = ((TextView)findViewById(2131303028));
    this.mHr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48665);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandOpenWeRunSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        com.tencent.mm.plugin.sport.a.c.md(13);
        paramAnonymousView = AppBrandOpenWeRunSettingUI.this;
        paramAnonymousView.getString(2131755906);
        paramAnonymousView.mHs = h.b(paramAnonymousView, paramAnonymousView.getString(2131763362), true, null);
        paramAnonymousView.mHs.show();
        com.tencent.mm.kernel.g.ajQ().gDv.a(30, paramAnonymousView);
        paramAnonymousView = new LinkedList();
        paramAnonymousView.add("gh_43f2581f6fd6");
        localObject = new LinkedList();
        ((LinkedList)localObject).add(Integer.valueOf(1));
        paramAnonymousView = new o(paramAnonymousView, (List)localObject, "", "");
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousView, 0);
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
    paramBundle = bu.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH("gh_43f2581f6fd6");
    if ((this.contact == null) || ((int)this.contact.ght == 0))
    {
      getString(2131755906);
      this.mHs = h.b(this, getString(2131755936), true, null);
      this.mHs.show();
      au.a.hIG.a("gh_43f2581f6fd6", "", new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48667);
          ae.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this, ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH("gh_43f2581f6fd6"));
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
      com.tencent.mm.kernel.g.ajQ().gDv.b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label122;
      }
      ae.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString))) {
        Toast.makeText(ak.getContext(), paramString, 1).show();
      }
      setResult(1);
    }
    label122:
    an localan;
    for (;;)
    {
      if (this.mHs != null) {
        this.mHs.dismiss();
      }
      updateStatus();
      AppMethodBeat.o(48671);
      return;
      paramn = ((o)paramn).fdt();
      ae.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", new Object[] { paramn });
      this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH("gh_43f2581f6fd6");
      localan = this.contact;
      if ((localan != null) && (!bu.isNullOrNil(paramn))) {
        break;
      }
      ae.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + paramn + ", contact = " + localan);
      paramString = ag.aGp().Ef(this.contact.field_username);
      ag.aGp().g(paramString);
      com.tencent.mm.kernel.g.ajR().ajA().set(327825, Boolean.TRUE);
      setResult(-1);
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48668);
          AppBrandOpenWeRunSettingUI.this.finish();
          AppMethodBeat.o(48668);
        }
      }, 1500L);
    }
    if (x.Am(localan.field_username))
    {
      String str = bu.nullAsNil(localan.field_username);
      paramString = com.tencent.mm.al.g.eX(str);
      if (paramString != null) {
        paramString.field_username = paramn;
      }
      ag.aGp().delete(str);
      localan.tu(str);
    }
    for (;;)
    {
      localan.setUsername(paramn);
      if ((int)localan.ght == 0) {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().ao(localan);
      }
      if ((int)localan.ght <= 0)
      {
        ae.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
        break;
      }
      x.B(localan);
      paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localan.field_username);
      if (paramString != null)
      {
        ag.aGp().f(paramString);
        break;
      }
      paramString = com.tencent.mm.al.g.eX(paramn.field_username);
      if ((paramString == null) || (paramString.Kp()))
      {
        ae.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
        au.a.hIG.aJ(paramn.field_username, "");
        com.tencent.mm.aj.c.Dv(paramn.field_username);
        break;
      }
      if (!paramn.fuk()) {
        break;
      }
      ae.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramn.eRm) });
      au.a.hIG.aJ(paramn.field_username, "");
      com.tencent.mm.aj.c.Dv(paramn.field_username);
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