package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hv;
import com.tencent.mm.h.a.hv.b;
import com.tencent.mm.h.a.hw;
import com.tencent.mm.h.a.hw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class n
  implements f, MobileVerifyUI.b
{
  private String dqS = null;
  private String fcQ = "";
  private int fcR = 2;
  private MobileVerifyUI fpj;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.fpj = paramMobileVerifyUI;
    this.dqS = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.fcQ = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.fcR = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    switch (n.3.fpn[parama.ordinal()])
    {
    default: 
      return false;
    case 1: 
      parama = new hv();
      parama.bPQ.context = this.fpj;
      com.tencent.mm.sdk.b.a.udP.m(parama);
      parama = parama.bPR.bPS;
      localObject = new hw();
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      localObject = ((hw)localObject).bPT.bPU;
      g.Dk().a(132, this);
      parama = new x(this.fpj.bSe, 2, this.fpj.fcd.getText().toString().trim(), "", parama, (String)localObject);
      g.Dk().a(parama, 0);
      localObject = this.fpj;
      localMobileVerifyUI = this.fpj;
      this.fpj.getString(q.j.app_tip);
      ((MobileVerifyUI)localObject).dnm = h.b(localMobileVerifyUI, this.fpj.getString(q.j.bind_mcontact_verifing), true, new n.2(this, parama));
      return false;
    case 2: 
      g.Dk().a(132, this);
      parama = new x(this.fpj.bSe, 1, "", 0, "");
      g.Dk().a(parama, 0);
      return false;
    }
    parama = new hv();
    parama.bPQ.context = this.fpj;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    parama = parama.bPR.bPS;
    Object localObject = new hw();
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    localObject = ((hw)localObject).bPT.bPU;
    g.Dk().a(132, this);
    parama = new x(this.fpj.bSe, 2, this.fpj.fcd.getText().toString().trim(), "", parama, (String)localObject);
    g.Dk().a(parama, 0);
    localObject = this.fpj;
    MobileVerifyUI localMobileVerifyUI = this.fpj;
    this.fpj.getString(q.j.app_tip);
    ((MobileVerifyUI)localObject).dnm = h.b(localMobileVerifyUI, this.fpj.getString(q.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        g.Dk().c(parama);
        g.Dk().b(132, n.this);
      }
    });
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int i = 0;
    y.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpj.dnm != null)
    {
      this.fpj.dnm.dismiss();
      this.fpj.dnm = null;
    }
    if (paramm.getType() == 132)
    {
      g.Dk().b(132, this);
      if ((((x)paramm).rN() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        paramInt1 = i;
        if (com.tencent.mm.pluginsdk.a.eI(this.fpj).size() != 0) {
          paramInt1 = 1;
        }
        if ((this.fcQ == null) || (!this.fcQ.contains("1")) || (paramInt1 == 0)) {
          break label268;
        }
        com.tencent.mm.plugin.b.a.qj("R300_300_QQ");
        paramString = new Intent(this.fpj, FindMContactAddUI.class);
        paramString.addFlags(67108864);
        paramString.putExtra("regsetinfo_ticket", this.dqS);
        paramString.putExtra("regsetinfo_NextStep", this.fcQ);
        paramString.putExtra("regsetinfo_NextStyle", this.fcR);
        paramString.putExtra("login_type", 1);
        paramm = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpj);
        paramm.addFlags(67108864);
        MMWizardActivity.b(this.fpj, paramString, paramm);
        this.fpj.finish();
      }
    }
    label268:
    while ((this.fpj.h(paramInt1, paramInt2, paramString)) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      return;
      paramString = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpj);
      paramString.addFlags(67108864);
      this.fpj.startActivity(paramString);
      this.fpj.fpP = 4;
      this.fpj.finish();
      return;
    }
    Toast.makeText(this.fpj, this.fpj.getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */