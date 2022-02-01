package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.jk.b;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.jl.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class n
  implements f, MobileVerifyUI.b
{
  private String fPq = null;
  private String jaS = "";
  private int jaT = 2;
  private MobileVerifyUI jnv;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.jnv = paramMobileVerifyUI;
    this.fPq = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.jaS = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.jaT = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (n.3.jnz[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new jk();
      parama.dwj.context = this.jnv;
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      parama = parama.dwk.dwl;
      Object localObject = new jl();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = ((jl)localObject).dwm.dwn;
      g.aiU().a(132, this);
      parama = new z(this.jnv.dzn, 2, this.jnv.jah.getText().toString().trim(), "", parama, (String)localObject);
      g.aiU().a(parama, 0);
      localObject = this.jnv;
      MobileVerifyUI localMobileVerifyUI = this.jnv;
      this.jnv.getString(2131755906);
      ((MobileVerifyUI)localObject).fMu = h.b(localMobileVerifyUI, this.jnv.getString(2131756503), true, new n.2(this, parama));
      continue;
      g.aiU().a(132, this);
      parama = new z(this.jnv.dzn, 1, "", 0, "");
      g.aiU().a(parama, 0);
      continue;
      parama = new jk();
      parama.dwj.context = this.jnv;
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      parama = parama.dwk.dwl;
      localObject = new jl();
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = ((jl)localObject).dwm.dwn;
      g.aiU().a(132, this);
      parama = new z(this.jnv.dzn, 2, this.jnv.jah.getText().toString().trim(), "", parama, (String)localObject);
      g.aiU().a(parama, 0);
      localObject = this.jnv;
      localMobileVerifyUI = this.jnv;
      this.jnv.getString(2131755906);
      ((MobileVerifyUI)localObject).fMu = h.b(localMobileVerifyUI, this.jnv.getString(2131756503), true, new n.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128421);
    ad.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jnv.fMu != null)
    {
      this.jnv.fMu.dismiss();
      this.jnv.fMu = null;
    }
    if (paramn.getType() == 132)
    {
      g.aiU().b(132, this);
      if ((((z)paramn).KR() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        if (com.tencent.mm.pluginsdk.b.hk(this.jnv).size() != 0) {}
        for (paramInt1 = 1; (this.jaS != null) && (this.jaS.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.Ma("R300_300_QQ");
          paramString = new Intent(this.jnv, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.fPq);
          paramString.putExtra("regsetinfo_NextStep", this.jaS);
          paramString.putExtra("regsetinfo_NextStyle", this.jaT);
          paramString.putExtra("login_type", 1);
          paramn = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jnv);
          paramn.addFlags(67108864);
          MMWizardActivity.b(this.jnv, paramString, paramn);
          this.jnv.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramn = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jnv);
        paramn.addFlags(67108864);
        paramString = this.jnv;
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahp(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.jnv.jnZ = 4;
        this.jnv.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.jnv.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.jnv, this.jnv.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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