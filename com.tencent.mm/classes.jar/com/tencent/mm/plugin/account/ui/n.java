package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.jc.b;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class n
  implements com.tencent.mm.ak.g, MobileVerifyUI.b
{
  private String fwd = null;
  private String iHJ = "";
  private int iHK = 2;
  private MobileVerifyUI iUm;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.iUm = paramMobileVerifyUI;
    this.fwd = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.iHJ = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.iHK = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (n.3.iUq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new jc();
      parama.dkw.context = this.iUm;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      parama = parama.dkx.dky;
      Object localObject = new jd();
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      localObject = ((jd)localObject).dkz.dkA;
      com.tencent.mm.kernel.g.agi().a(132, this);
      parama = new z(this.iUm.dnz, 2, this.iUm.iGY.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      localObject = this.iUm;
      MobileVerifyUI localMobileVerifyUI = this.iUm;
      this.iUm.getString(2131755906);
      ((MobileVerifyUI)localObject).fts = h.b(localMobileVerifyUI, this.iUm.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128417);
          com.tencent.mm.kernel.g.agi().a(parama);
          com.tencent.mm.kernel.g.agi().b(132, n.this);
          AppMethodBeat.o(128417);
        }
      });
      continue;
      com.tencent.mm.kernel.g.agi().a(132, this);
      parama = new z(this.iUm.dnz, 1, "", 0, "");
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      continue;
      parama = new jc();
      parama.dkw.context = this.iUm;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      parama = parama.dkx.dky;
      localObject = new jd();
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      localObject = ((jd)localObject).dkz.dkA;
      com.tencent.mm.kernel.g.agi().a(132, this);
      parama = new z(this.iUm.dnz, 2, this.iUm.iGY.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      localObject = this.iUm;
      localMobileVerifyUI = this.iUm;
      this.iUm.getString(2131755906);
      ((MobileVerifyUI)localObject).fts = h.b(localMobileVerifyUI, this.iUm.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128416);
          com.tencent.mm.kernel.g.agi().a(parama);
          com.tencent.mm.kernel.g.agi().b(132, n.this);
          AppMethodBeat.o(128416);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128421);
    ac.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iUm.fts != null)
    {
      this.iUm.fts.dismiss();
      this.iUm.fts = null;
    }
    if (paramn.getType() == 132)
    {
      com.tencent.mm.kernel.g.agi().b(132, this);
      if ((((z)paramn).Js() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        if (com.tencent.mm.pluginsdk.a.hf(this.iUm).size() != 0) {}
        for (paramInt1 = 1; (this.iHJ != null) && (this.iHJ.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.IL("R300_300_QQ");
          paramString = new Intent(this.iUm, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.fwd);
          paramString.putExtra("regsetinfo_NextStep", this.iHJ);
          paramString.putExtra("regsetinfo_NextStyle", this.iHK);
          paramString.putExtra("login_type", 1);
          paramn = com.tencent.mm.plugin.account.a.a.iyx.bD(this.iUm);
          paramn.addFlags(67108864);
          MMWizardActivity.b(this.iUm, paramString, paramn);
          this.iUm.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramn = com.tencent.mm.plugin.account.a.a.iyx.bD(this.iUm);
        paramn.addFlags(67108864);
        paramString = this.iUm;
        paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.iUm.iUQ = 4;
        this.iUm.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.iUm.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.iUm, this.iUm.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128421);
  }
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */