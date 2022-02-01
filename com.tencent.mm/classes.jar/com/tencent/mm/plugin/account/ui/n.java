package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jl.b;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class n
  implements f, MobileVerifyUI.b
{
  private String fRw = null;
  private String jdL = "";
  private int jdM = 2;
  private MobileVerifyUI jqo;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.jqo = paramMobileVerifyUI;
    this.fRw = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.jdL = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.jdM = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (3.jqs[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new jl();
      parama.dxo.context = this.jqo;
      com.tencent.mm.sdk.b.a.IvT.l(parama);
      parama = parama.dxp.dxq;
      Object localObject = new jm();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = ((jm)localObject).dxr.dxs;
      g.ajj().a(132, this);
      parama = new z(this.jqo.dAs, 2, this.jqo.jda.getText().toString().trim(), "", parama, (String)localObject);
      g.ajj().a(parama, 0);
      localObject = this.jqo;
      MobileVerifyUI localMobileVerifyUI = this.jqo;
      this.jqo.getString(2131755906);
      ((MobileVerifyUI)localObject).fOC = h.b(localMobileVerifyUI, this.jqo.getString(2131756503), true, new n.2(this, parama));
      continue;
      g.ajj().a(132, this);
      parama = new z(this.jqo.dAs, 1, "", 0, "");
      g.ajj().a(parama, 0);
      continue;
      parama = new jl();
      parama.dxo.context = this.jqo;
      com.tencent.mm.sdk.b.a.IvT.l(parama);
      parama = parama.dxp.dxq;
      localObject = new jm();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = ((jm)localObject).dxr.dxs;
      g.ajj().a(132, this);
      parama = new z(this.jqo.dAs, 2, this.jqo.jda.getText().toString().trim(), "", parama, (String)localObject);
      g.ajj().a(parama, 0);
      localObject = this.jqo;
      localMobileVerifyUI = this.jqo;
      this.jqo.getString(2131755906);
      ((MobileVerifyUI)localObject).fOC = h.b(localMobileVerifyUI, this.jqo.getString(2131756503), true, new n.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128421);
    ae.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jqo.fOC != null)
    {
      this.jqo.fOC.dismiss();
      this.jqo.fOC = null;
    }
    if (paramn.getType() == 132)
    {
      g.ajj().b(132, this);
      if ((((z)paramn).KZ() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        if (com.tencent.mm.pluginsdk.b.hq(this.jqo).size() != 0) {}
        for (paramInt1 = 1; (this.jdL != null) && (this.jdL.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.KB("R300_300_QQ");
          paramString = new Intent(this.jqo, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.fRw);
          paramString.putExtra("regsetinfo_NextStep", this.jdL);
          paramString.putExtra("regsetinfo_NextStyle", this.jdM);
          paramString.putExtra("login_type", 1);
          paramn = com.tencent.mm.plugin.account.a.a.iUz.bE(this.jqo);
          paramn.addFlags(67108864);
          MMWizardActivity.b(this.jqo, paramString, paramn);
          this.jqo.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramn = com.tencent.mm.plugin.account.a.a.iUz.bE(this.jqo);
        paramn.addFlags(67108864);
        paramString = this.jqo;
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.jqo.jqS = 4;
        this.jqo.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.jqo.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.jqo, this.jqo.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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