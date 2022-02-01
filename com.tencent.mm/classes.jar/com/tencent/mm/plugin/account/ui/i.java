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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ax.b;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  implements com.tencent.mm.al.g, MobileInputUI.b
{
  private SecurityImage ijd;
  dv iqH;
  private g irj;
  MobileInputUI isU;
  
  public i()
  {
    AppMethodBeat.i(128279);
    this.ijd = null;
    this.irj = null;
    this.iqH = new dv();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.isZ[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.isU.itx = ba.aFN(this.isU.countryCode);
      this.isU.ity = this.isU.itl.getText().toString();
      parama = ba.aFL(this.isU.itx + this.isU.ity);
      MobileInputUI localMobileInputUI1 = this.isU;
      MobileInputUI localMobileInputUI2 = this.isU;
      this.isU.getString(2131755906);
      localMobileInputUI1.ijb = h.b(localMobileInputUI2, this.isU.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.isU = paramMobileInputUI;
    paramMobileInputUI.igJ.setVisibility(0);
    paramMobileInputUI.itk.setVisibility(0);
    paramMobileInputUI.itl.requestFocus();
    paramMobileInputUI.itq.setText(2131755830);
    paramMobileInputUI.itq.setVisibility(0);
    paramMobileInputUI.its.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final m localm = new m(this.isU, 2001, 0);
    localm.setTitle(2131760755);
    paramMobileInputUI.add(localm);
    localm = new m(this.isU, 2002, 0);
    if (b.azk())
    {
      localm.setTitle(2131760751);
      paramMobileInputUI.add(localm);
    }
    if (paramMobileInputUI.size() > 1)
    {
      final e locale = new e(this.isU, 1, false);
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(128274);
          if (paramAnonymousl.size() == 0)
          {
            Iterator localIterator = paramMobileInputUI.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousl.g((m)localIterator.next());
            }
          }
          AppMethodBeat.o(128274);
        }
      };
      locale.HrY = new n.d()
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
            ((i)localObject).iqH.dVG = 1L;
            ((i)localObject).iqH.dFd = 10L;
            ((i)localObject).iqH.aBj();
            paramAnonymousMenuItem = new Intent(((i)localObject).isU, FacebookLoginUI.class);
            localObject = ((i)localObject).isU;
            paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.adn(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileInputUI)localObject).startActivity((Intent)paramAnonymousMenuItem.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      locale.GHn = new e.b()
      {
        public final void onDismiss() {}
      };
      this.isU.itu.setText(2131760756);
      this.isU.itu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          i.this.isU.hideVKB();
          locale.csG();
          if (paramMobileInputUI.contains(localm))
          {
            i.this.iqH.dVG = 1L;
            i.this.iqH.dFd = 9L;
            i.this.iqH.aBj();
          }
          AppMethodBeat.o(128276);
        }
      });
    }
    for (;;)
    {
      this.isU.itu.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      this.isU.itu.setText(2131760755);
      this.isU.itu.setOnClickListener(new View.OnClickListener()
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
    ad.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isU.ijb != null)
    {
      this.isU.ijb.dismiss();
      this.isU.ijb = null;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.irj != null))
    {
      this.irj.isG = this.isU.isG;
      this.irj.a(this.isU, paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).JJ() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null)
        {
          paramString.a(this.isU, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        h.j(this.isU, 2131762328, 2131762329);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.isU, this.isU.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        h.c(this.isU, this.isU.getString(2131756462), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.isU.hideVKB();
      paramn = new Intent(this.isU, MobileInputUI.class);
      paramn.putExtra("mobile_input_purpose", -1);
      paramn.putExtra("mobile_auth_type", 7);
      paramn.putExtra("from_switch_account", this.isU.irf);
      paramn.putExtra("couttry_code", this.isU.countryCode);
      paramn.putExtra("input_mobile_number", this.isU.ity);
      paramString = this.isU;
      paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramn.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    com.tencent.mm.kernel.g.aeS().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.aUy("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    com.tencent.mm.kernel.g.aeS().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */