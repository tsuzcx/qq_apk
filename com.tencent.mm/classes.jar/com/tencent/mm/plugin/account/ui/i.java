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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

public final class i
  implements f, MobileInputUI.b
{
  private SecurityImage jct;
  gk jjW;
  private g jkx;
  MobileInputUI jmh;
  
  public i()
  {
    AppMethodBeat.i(128279);
    this.jct = null;
    this.jkx = null;
    this.jjW = new gk();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.jmm[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.jmh.jmK = ba.aQK(this.jmh.countryCode);
      this.jmh.jmL = this.jmh.jmy.getText().toString();
      parama = ba.aQI(this.jmh.jmK + this.jmh.jmL);
      MobileInputUI localMobileInputUI1 = this.jmh;
      MobileInputUI localMobileInputUI2 = this.jmh;
      this.jmh.getString(2131755906);
      localMobileInputUI1.jcr = h.b(localMobileInputUI2, this.jmh.getString(2131762310), true, new i.6(this));
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.jmh = paramMobileInputUI;
    paramMobileInputUI.jab.setVisibility(0);
    paramMobileInputUI.jmx.setVisibility(0);
    paramMobileInputUI.jmy.requestFocus();
    paramMobileInputUI.jmD.setText(2131755830);
    paramMobileInputUI.jmD.setVisibility(0);
    paramMobileInputUI.jmF.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final m localm = new m(this.jmh, 2001, 0);
    localm.setTitle(2131760755);
    paramMobileInputUI.add(localm);
    localm = new m(this.jmh, 2002, 0);
    if (com.tencent.mm.ax.b.aJk())
    {
      localm.setTitle(2131760751);
      paramMobileInputUI.add(localm);
    }
    if (paramMobileInputUI.size() > 1)
    {
      final e locale = new e(this.jmh, 1, false);
      locale.KJy = new i.1(this, paramMobileInputUI);
      locale.KJz = new n.e()
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
            i.a(i.this);
            AppMethodBeat.o(128275);
            return;
            Object localObject = i.this;
            ((i)localObject).jjW.enS = 1L;
            ((i)localObject).jjW.dPl = 10L;
            ((i)localObject).jjW.aLk();
            paramAnonymousMenuItem = new Intent(((i)localObject).jmh, FacebookLoginUI.class);
            localObject = ((i)localObject).jmh;
            paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileInputUI)localObject).startActivity((Intent)paramAnonymousMenuItem.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      locale.JXC = new i.3(this);
      this.jmh.jmH.setText(2131760756);
      this.jmh.jmH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          i.this.jmh.hideVKB();
          locale.cMW();
          if (paramMobileInputUI.contains(localm))
          {
            i.this.jjW.enS = 1L;
            i.this.jjW.dPl = 9L;
            i.this.jjW.aLk();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128276);
        }
      });
    }
    for (;;)
    {
      this.jmh.jmH.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      this.jmh.jmH.setText(2131760755);
      this.jmh.jmH.setOnClickListener(new i.5(this));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128284);
    ad.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jmh.jcr != null)
    {
      this.jmh.jcr.dismiss();
      this.jmh.jcr = null;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.jkx != null))
    {
      this.jkx.jlT = this.jmh.jlT;
      this.jkx.a(this.jmh, paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).KR() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if (paramString != null)
        {
          paramString.a(this.jmh, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        h.l(this.jmh, 2131762328, 2131762329);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.jmh, this.jmh.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        h.c(this.jmh, this.jmh.getString(2131756462), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.jmh.hideVKB();
      paramn = new Intent(this.jmh, MobileInputUI.class);
      paramn.putExtra("mobile_input_purpose", -1);
      paramn.putExtra("mobile_auth_type", 7);
      paramn.putExtra("from_switch_account", this.jmh.jkt);
      paramn.putExtra("couttry_code", this.jmh.countryCode);
      paramn.putExtra("input_mobile_number", this.jmh.jmL);
      paramString = this.jmh;
      paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramn.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    com.tencent.mm.kernel.g.aiU().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.Kc("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    com.tencent.mm.kernel.g.aiU().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */