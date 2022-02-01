package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

public final class i
  implements com.tencent.mm.ak.g, MobileInputUI.b
{
  private SecurityImage iJk;
  fl iQO;
  private g iRp;
  MobileInputUI iSZ;
  
  public i()
  {
    AppMethodBeat.i(128279);
    this.iJk = null;
    this.iRp = null;
    this.iQO = new fl();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.iTe[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.iSZ.iTC = az.aLe(this.iSZ.countryCode);
      this.iSZ.iTD = this.iSZ.iTq.getText().toString();
      parama = az.aLc(this.iSZ.iTC + this.iSZ.iTD);
      MobileInputUI localMobileInputUI1 = this.iSZ;
      MobileInputUI localMobileInputUI2 = this.iSZ;
      this.iSZ.getString(2131755906);
      localMobileInputUI1.iJi = h.b(localMobileInputUI2, this.iSZ.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.g.agi().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.iSZ = paramMobileInputUI;
    paramMobileInputUI.iGS.setVisibility(0);
    paramMobileInputUI.iTp.setVisibility(0);
    paramMobileInputUI.iTq.requestFocus();
    paramMobileInputUI.iTv.setText(2131755830);
    paramMobileInputUI.iTv.setVisibility(0);
    paramMobileInputUI.iTx.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final m localm = new m(this.iSZ, 2001, 0);
    localm.setTitle(2131760755);
    paramMobileInputUI.add(localm);
    localm = new m(this.iSZ, 2002, 0);
    if (b.aGb())
    {
      localm.setTitle(2131760751);
      paramMobileInputUI.add(localm);
    }
    if (paramMobileInputUI.size() > 1)
    {
      final e locale = new e(this.iSZ, 1, false);
      locale.ISu = new i.1(this, paramMobileInputUI);
      locale.ISv = new n.d()
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
            ((i)localObject).iQO.dXB = 1L;
            ((i)localObject).iQO.dCQ = 10L;
            ((i)localObject).iQO.aHZ();
            paramAnonymousMenuItem = new Intent(((i)localObject).iSZ, FacebookLoginUI.class);
            localObject = ((i)localObject).iSZ;
            paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileInputUI)localObject).startActivity((Intent)paramAnonymousMenuItem.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      locale.Ihj = new e.b()
      {
        public final void onDismiss() {}
      };
      this.iSZ.iTz.setText(2131760756);
      this.iSZ.iTz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          i.this.iSZ.hideVKB();
          locale.cED();
          if (paramMobileInputUI.contains(localm))
          {
            i.this.iQO.dXB = 1L;
            i.this.iQO.dCQ = 9L;
            i.this.iQO.aHZ();
          }
          AppMethodBeat.o(128276);
        }
      });
    }
    for (;;)
    {
      this.iSZ.iTz.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      this.iSZ.iTz.setText(2131760755);
      this.iSZ.iTz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128277);
          i.a(i.this);
          AppMethodBeat.o(128277);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128284);
    ac.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iSZ.iJi != null)
    {
      this.iSZ.iJi.dismiss();
      this.iSZ.iJi = null;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.iRp != null))
    {
      this.iRp.iSL = this.iSZ.iSL;
      this.iRp.a(this.iSZ, paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).Js() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this.iSZ, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        h.l(this.iSZ, 2131762328, 2131762329);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.iSZ, this.iSZ.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        h.c(this.iSZ, this.iSZ.getString(2131756462), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.iSZ.hideVKB();
      paramn = new Intent(this.iSZ, MobileInputUI.class);
      paramn.putExtra("mobile_input_purpose", -1);
      paramn.putExtra("mobile_auth_type", 7);
      paramn.putExtra("from_switch_account", this.iSZ.iRl);
      paramn.putExtra("couttry_code", this.iSZ.countryCode);
      paramn.putExtra("input_mobile_number", this.iSZ.iTD);
      paramString = this.iSZ;
      paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramn.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    com.tencent.mm.kernel.g.agi().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.IK("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    com.tencent.mm.kernel.g.agi().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */