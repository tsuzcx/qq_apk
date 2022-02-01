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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  implements f, MobileInputUI.b
{
  private SecurityImage jfm;
  gm jmP;
  private g jnr;
  MobileInputUI jpb;
  
  public i()
  {
    AppMethodBeat.i(128279);
    this.jfm = null;
    this.jnr = null;
    this.jmP = new gm();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.jpg[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.jpb.jpE = bb.aSh(this.jpb.countryCode);
      this.jpb.jpF = this.jpb.jps.getText().toString();
      parama = bb.aSf(this.jpb.jpE + this.jpb.jpF);
      MobileInputUI localMobileInputUI1 = this.jpb;
      MobileInputUI localMobileInputUI2 = this.jpb;
      this.jpb.getString(2131755906);
      localMobileInputUI1.jfk = h.b(localMobileInputUI2, this.jpb.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.jpb = paramMobileInputUI;
    paramMobileInputUI.jcU.setVisibility(0);
    paramMobileInputUI.jpr.setVisibility(0);
    paramMobileInputUI.jps.requestFocus();
    paramMobileInputUI.jpx.setText(2131755830);
    paramMobileInputUI.jpx.setVisibility(0);
    paramMobileInputUI.jpz.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final m localm = new m(this.jpb, 2001, 0);
    localm.setTitle(2131760755);
    paramMobileInputUI.add(localm);
    localm = new m(this.jpb, 2002, 0);
    if (com.tencent.mm.aw.b.aJC())
    {
      localm.setTitle(2131760751);
      paramMobileInputUI.add(localm);
    }
    if (paramMobileInputUI.size() > 1)
    {
      final e locale = new e(this.jpb, 1, false);
      locale.LfS = new n.d()
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
      locale.LfT = new n.e()
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
            ((i)localObject).jmP.epA = 1L;
            ((i)localObject).jmP.dQB = 10L;
            ((i)localObject).jmP.aLH();
            paramAnonymousMenuItem = new Intent(((i)localObject).jpb, FacebookLoginUI.class);
            localObject = ((i)localObject).jpb;
            paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileInputUI)localObject).startActivity((Intent)paramAnonymousMenuItem.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      };
      locale.KtV = new e.b()
      {
        public final void onDismiss() {}
      };
      this.jpb.jpB.setText(2131760756);
      this.jpb.jpB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          i.this.jpb.hideVKB();
          locale.cPF();
          if (paramMobileInputUI.contains(localm))
          {
            i.this.jmP.epA = 1L;
            i.this.jmP.dQB = 9L;
            i.this.jmP.aLH();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128276);
        }
      });
    }
    for (;;)
    {
      this.jpb.jpB.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      this.jpb.jpB.setText(2131760755);
      this.jpb.jpB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128277);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          i.a(i.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128277);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128284);
    ae.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jpb.jfk != null)
    {
      this.jpb.jfk.dismiss();
      this.jpb.jfk = null;
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.jnr != null))
    {
      this.jnr.joN = this.jpb.joN;
      this.jnr.a(this.jpb, paramInt1, paramInt2, paramString, paramn);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).KZ() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if (paramString != null)
        {
          paramString.a(this.jpb, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        h.l(this.jpb, 2131762328, 2131762329);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.jpb, this.jpb.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        h.c(this.jpb, this.jpb.getString(2131756462), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.jpb.hideVKB();
      paramn = new Intent(this.jpb, MobileInputUI.class);
      paramn.putExtra("mobile_input_purpose", -1);
      paramn.putExtra("mobile_auth_type", 7);
      paramn.putExtra("from_switch_account", this.jpb.jnn);
      paramn.putExtra("couttry_code", this.jpb.countryCode);
      paramn.putExtra("input_mobile_number", this.jpb.jpF);
      paramString = this.jpb;
      paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramn.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    com.tencent.mm.kernel.g.ajj().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.KA("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    com.tencent.mm.kernel.g.ajj().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */