package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.b;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ia.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class n
  implements f, MobileVerifyUI.b
{
  private String eiu = null;
  private MobileVerifyUI gGG;
  private String guB = "";
  private int guC = 2;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(125247);
    this.gGG = paramMobileVerifyUI;
    this.eiu = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.guB = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.guC = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(125247);
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(125248);
    switch (n.3.gGK[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125248);
      return false;
      parama = new hz();
      parama.cxj.context = this.gGG;
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      parama = parama.cxk.cxl;
      Object localObject = new ia();
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      localObject = ((ia)localObject).cxm.cxn;
      g.Rc().a(132, this);
      parama = new x(this.gGG.czF, 2, this.gGG.gtO.getText().toString().trim(), "", parama, (String)localObject);
      g.Rc().a(parama, 0);
      localObject = this.gGG;
      MobileVerifyUI localMobileVerifyUI = this.gGG;
      this.gGG.getString(2131297087);
      ((MobileVerifyUI)localObject).eeN = h.b(localMobileVerifyUI, this.gGG.getString(2131297610), true, new n.2(this, parama));
      continue;
      g.Rc().a(132, this);
      parama = new x(this.gGG.czF, 1, "", 0, "");
      g.Rc().a(parama, 0);
      continue;
      parama = new hz();
      parama.cxj.context = this.gGG;
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      parama = parama.cxk.cxl;
      localObject = new ia();
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      localObject = ((ia)localObject).cxm.cxn;
      g.Rc().a(132, this);
      parama = new x(this.gGG.czF, 2, this.gGG.gtO.getText().toString().trim(), "", parama, (String)localObject);
      g.Rc().a(parama, 0);
      localObject = this.gGG;
      localMobileVerifyUI = this.gGG;
      this.gGG.getString(2131297087);
      ((MobileVerifyUI)localObject).eeN = h.b(localMobileVerifyUI, this.gGG.getString(2131297610), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(125244);
          g.Rc().a(parama);
          g.Rc().b(132, n.this);
          AppMethodBeat.o(125244);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(125249);
    ab.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gGG.eeN != null)
    {
      this.gGG.eeN.dismiss();
      this.gGG.eeN = null;
    }
    if (paramm.getType() == 132)
    {
      g.Rc().b(132, this);
      if ((((x)paramm).Ac() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        paramInt1 = i;
        if (com.tencent.mm.pluginsdk.a.fI(this.gGG).size() != 0) {
          paramInt1 = 1;
        }
        if ((this.guB != null) && (this.guB.contains("1")) && (paramInt1 != 0))
        {
          com.tencent.mm.plugin.b.a.xD("R300_300_QQ");
          paramString = new Intent(this.gGG, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.eiu);
          paramString.putExtra("regsetinfo_NextStep", this.guB);
          paramString.putExtra("regsetinfo_NextStyle", this.guC);
          paramString.putExtra("login_type", 1);
          paramm = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gGG);
          paramm.addFlags(67108864);
          MMWizardActivity.b(this.gGG, paramString, paramm);
          this.gGG.finish();
          AppMethodBeat.o(125249);
          return;
        }
        paramString = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gGG);
        paramString.addFlags(67108864);
        this.gGG.startActivity(paramString);
        this.gGG.gHl = 4;
        this.gGG.finish();
        AppMethodBeat.o(125249);
        return;
      }
      AppMethodBeat.o(125249);
      return;
    }
    if (this.gGG.l(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125249);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.gGG, this.gGG.getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(125249);
  }
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */