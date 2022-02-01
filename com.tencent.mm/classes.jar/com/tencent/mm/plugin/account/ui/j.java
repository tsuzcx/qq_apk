package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  implements i, MobileInputUI.b
{
  private SecurityImage kdp;
  ka kkY;
  private h klz;
  MobileInputUI knl;
  
  public j()
  {
    AppMethodBeat.i(128279);
    this.kdp = null;
    this.klz = null;
    this.kkY = new ka();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.knq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
      this.knl.knP = this.knl.knC.getText().toString();
      parama = PhoneFormater.pureNumber(this.knl.knO + this.knl.knP);
      MobileInputUI localMobileInputUI1 = this.knl;
      MobileInputUI localMobileInputUI2 = this.knl;
      this.knl.getString(2131755998);
      localMobileInputUI1.kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.knl.getString(2131764376), true, new j.6(this));
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      g.azz().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.knl = paramMobileInputUI;
    paramMobileInputUI.kaX.setVisibility(0);
    paramMobileInputUI.knB.setVisibility(0);
    paramMobileInputUI.knC.requestFocus();
    paramMobileInputUI.knH.setText(2131755916);
    paramMobileInputUI.knH.setVisibility(0);
    paramMobileInputUI.knJ.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final n localn = new n(this.knl, 2001, 0);
    if (WeChatBrands.AppInfo.current().isMainland()) {
      localn.setTitle(2131762501);
    }
    for (;;)
    {
      paramMobileInputUI.add(localn);
      localn = new n(this.knl, 2002, 0);
      if (com.tencent.mm.aw.b.bdD())
      {
        localn.setTitle(2131762497);
        paramMobileInputUI.add(localn);
      }
      if (paramMobileInputUI.size() <= 1) {
        break;
      }
      final e locale = new e(this.knl, 1, false);
      locale.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(128274);
          if (paramAnonymousm.size() == 0)
          {
            Iterator localIterator = paramMobileInputUI.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousm.g((n)localIterator.next());
            }
          }
          AppMethodBeat.o(128274);
        }
      };
      locale.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(128275);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(128275);
            return;
            j.a(j.this);
            AppMethodBeat.o(128275);
            return;
            Object localObject = j.this;
            ((j)localObject).kkY.eTd = 1L;
            ((j)localObject).kkY.ejA = 10L;
            ((j)localObject).kkY.bfK();
            paramAnonymousMenuItem = new Intent(((j)localObject).knl, FacebookLoginUI.class);
            localObject = ((j)localObject).knl;
            paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileInputUI)localObject).startActivity((Intent)paramAnonymousMenuItem.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      locale.PGl = new j.3(this);
      this.knl.knL.setText(2131762502);
      this.knl.knL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          j.this.knl.hideVKB();
          locale.dGm();
          if (paramMobileInputUI.contains(localn))
          {
            j.this.kkY.eTd = 1L;
            j.this.kkY.ejA = 9L;
            j.this.kkY.bfK();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128276);
        }
      });
      this.knl.knL.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      localn.setTitle(2131762503);
    }
    if (WeChatBrands.AppInfo.current().isMainland()) {
      this.knl.knL.setText(2131762501);
    }
    for (;;)
    {
      this.knl.knL.setOnClickListener(new j.5(this));
      break;
      this.knl.knL.setText(2131762503);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128284);
    Log.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.knl.kdn != null)
    {
      this.knl.kdn.dismiss();
      this.knl.kdn = null;
    }
    if (((paramq.getType() == 252) || (paramq.getType() == 701)) && (this.klz != null))
    {
      this.klz.kmX = this.knl.kmX;
      this.klz.a(this.knl, paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramq.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramq).Vj() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.knl, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        com.tencent.mm.ui.base.h.n(this.knl, 2131764394, 2131764395);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.knl, this.knl.getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(2131756598), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.knl.hideVKB();
      paramq = new Intent(this.knl, MobileInputUI.class);
      paramq.putExtra("mobile_input_purpose", -1);
      paramq.putExtra("mobile_auth_type", 7);
      paramq.putExtra("from_switch_account", this.knl.klv);
      paramq.putExtra("couttry_code", this.knl.countryCode);
      paramq.putExtra("input_mobile_number", this.knl.knP);
      paramString = this.knl;
      paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramq.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    g.azz().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.bwU("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    g.azz().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */