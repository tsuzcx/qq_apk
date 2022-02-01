package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.ka.b;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.kb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public final class o
  implements i, MobileVerifyUI.c
{
  private String gwF = null;
  private String kbO = "";
  private int kbP = 2;
  private MobileVerifyUI koA;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.koA = paramMobileVerifyUI;
    this.gwF = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.kbO = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.kbP = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (3.koE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new ka();
      parama.dOV.context = this.koA;
      EventCenter.instance.publish(parama);
      parama = parama.dOW.dOX;
      Object localObject = new kb();
      EventCenter.instance.publish((IEvent)localObject);
      localObject = ((kb)localObject).dOY.dOZ;
      g.azz().a(132, this);
      parama = new z(this.koA.dSf, 2, this.koA.kbd.getText().toString().trim(), "", parama, (String)localObject);
      g.azz().a(parama, 0);
      localObject = this.koA;
      MobileVerifyUI localMobileVerifyUI = this.koA;
      this.koA.getString(2131755998);
      ((MobileVerifyUI)localObject).gtM = h.a(localMobileVerifyUI, this.koA.getString(2131756639), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128417);
          g.azz().a(parama);
          g.azz().b(132, o.this);
          AppMethodBeat.o(128417);
        }
      });
      continue;
      g.azz().a(132, this);
      parama = new z(this.koA.dSf, 1, "", 0, "");
      g.azz().a(parama, 0);
      continue;
      parama = new ka();
      parama.dOV.context = this.koA;
      EventCenter.instance.publish(parama);
      parama = parama.dOW.dOX;
      localObject = new kb();
      EventCenter.instance.publish((IEvent)localObject);
      localObject = ((kb)localObject).dOY.dOZ;
      g.azz().a(132, this);
      parama = new z(this.koA.dSf, 2, this.koA.kbd.getText().toString().trim(), "", parama, (String)localObject);
      g.azz().a(parama, 0);
      localObject = this.koA;
      localMobileVerifyUI = this.koA;
      this.koA.getString(2131755998);
      ((MobileVerifyUI)localObject).gtM = h.a(localMobileVerifyUI, this.koA.getString(2131756639), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128416);
          g.azz().a(parama);
          g.azz().b(132, o.this);
          AppMethodBeat.o(128416);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128421);
    Log.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.koA.gtM != null)
    {
      this.koA.gtM.dismiss();
      this.koA.gtM = null;
    }
    if (paramq.getType() == 132)
    {
      g.azz().b(132, this);
      if ((((z)paramq).Vj() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.a.unhold();
        if (b.ik(this.koA).size() != 0) {}
        for (paramInt1 = 1; (this.kbO != null) && (this.kbO.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.bwV("R300_300_QQ");
          paramString = new Intent(this.koA, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.gwF);
          paramString.putExtra("regsetinfo_NextStep", this.kbO);
          paramString.putExtra("regsetinfo_NextStyle", this.kbP);
          paramString.putExtra("login_type", 1);
          paramq = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.koA);
          paramq.addFlags(67108864);
          MMWizardActivity.b(this.koA, paramString, paramq);
          this.koA.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramq = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.koA);
        paramq.addFlags(67108864);
        paramString = this.koA;
        paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramq.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.koA.kpe = 4;
        this.koA.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.koA.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.koA, this.koA.getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128421);
  }
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */