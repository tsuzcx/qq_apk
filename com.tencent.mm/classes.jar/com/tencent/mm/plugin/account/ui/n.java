package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.iv.b;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.iw.a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class n
  implements com.tencent.mm.al.g, MobileVerifyUI.b
{
  private String fsw = null;
  private String ihB = "";
  private int ihC = 2;
  private MobileVerifyUI iuh;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.iuh = paramMobileVerifyUI;
    this.fsw = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.ihB = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.ihC = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (3.iul[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new iv();
      parama.dmO.context = this.iuh;
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      parama = parama.dmP.dmQ;
      Object localObject = new iw();
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
      localObject = ((iw)localObject).dmR.dmS;
      com.tencent.mm.kernel.g.aeS().a(132, this);
      parama = new z(this.iuh.dpO, 2, this.iuh.igP.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      localObject = this.iuh;
      MobileVerifyUI localMobileVerifyUI = this.iuh;
      this.iuh.getString(2131755906);
      ((MobileVerifyUI)localObject).fpP = h.b(localMobileVerifyUI, this.iuh.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128417);
          com.tencent.mm.kernel.g.aeS().a(parama);
          com.tencent.mm.kernel.g.aeS().b(132, n.this);
          AppMethodBeat.o(128417);
        }
      });
      continue;
      com.tencent.mm.kernel.g.aeS().a(132, this);
      parama = new z(this.iuh.dpO, 1, "", 0, "");
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      continue;
      parama = new iv();
      parama.dmO.context = this.iuh;
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      parama = parama.dmP.dmQ;
      localObject = new iw();
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
      localObject = ((iw)localObject).dmR.dmS;
      com.tencent.mm.kernel.g.aeS().a(132, this);
      parama = new z(this.iuh.dpO, 2, this.iuh.igP.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      localObject = this.iuh;
      localMobileVerifyUI = this.iuh;
      this.iuh.getString(2131755906);
      ((MobileVerifyUI)localObject).fpP = h.b(localMobileVerifyUI, this.iuh.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128416);
          com.tencent.mm.kernel.g.aeS().a(parama);
          com.tencent.mm.kernel.g.aeS().b(132, n.this);
          AppMethodBeat.o(128416);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128421);
    ad.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iuh.fpP != null)
    {
      this.iuh.fpP.dismiss();
      this.iuh.fpP = null;
    }
    if (paramn.getType() == 132)
    {
      com.tencent.mm.kernel.g.aeS().b(132, this);
      if ((((z)paramn).JJ() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        if (com.tencent.mm.pluginsdk.a.gU(this.iuh).size() != 0) {}
        for (paramInt1 = 1; (this.ihB != null) && (this.ihB.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.aUz("R300_300_QQ");
          paramString = new Intent(this.iuh, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.fsw);
          paramString.putExtra("regsetinfo_NextStep", this.ihB);
          paramString.putExtra("regsetinfo_NextStyle", this.ihC);
          paramString.putExtra("login_type", 1);
          paramn = com.tencent.mm.plugin.account.a.a.hYt.bA(this.iuh);
          paramn.addFlags(67108864);
          MMWizardActivity.b(this.iuh, paramString, paramn);
          this.iuh.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramn = com.tencent.mm.plugin.account.a.a.hYt.bA(this.iuh);
        paramn.addFlags(67108864);
        paramString = this.iuh;
        paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.iuh.iuL = 4;
        this.iuh.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.iuh.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.iuh, this.iuh.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128421);
  }
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */