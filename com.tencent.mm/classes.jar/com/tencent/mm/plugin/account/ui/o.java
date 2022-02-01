package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.lu;
import com.tencent.mm.autogen.a.lu.b;
import com.tencent.mm.autogen.a.lv;
import com.tencent.mm.autogen.a.lv.a;
import com.tencent.mm.plugin.account.friend.model.w;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.List;

public final class o
  implements com.tencent.mm.am.h, MobileVerifyUI.b
{
  private String lCS = null;
  private String pPU = "";
  private int pPV = 2;
  private MobileVerifyUI qdA;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.qdA = paramMobileVerifyUI;
    this.lCS = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.pPU = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.pPV = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (3.qdE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new lu();
      parama.hNG.context = this.qdA;
      parama.publish();
      parama = parama.hNH.hNI;
      Object localObject = new lv();
      ((lv)localObject).publish();
      localObject = ((lv)localObject).hNJ.hNK;
      com.tencent.mm.kernel.h.aZW().a(132, this);
      parama = new w(this.qdA.hRk, 2, this.qdA.pPd.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      localObject = this.qdA;
      MobileVerifyUI localMobileVerifyUI = this.qdA;
      this.qdA.getString(r.j.app_tip);
      ((MobileVerifyUI)localObject).lzP = k.a(localMobileVerifyUI, this.qdA.getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128417);
          com.tencent.mm.kernel.h.aZW().a(parama);
          com.tencent.mm.kernel.h.aZW().b(132, o.this);
          AppMethodBeat.o(128417);
        }
      });
      continue;
      com.tencent.mm.kernel.h.aZW().a(132, this);
      parama = new w(this.qdA.hRk, 1, "", 0, "", "");
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      continue;
      parama = new lu();
      parama.hNG.context = this.qdA;
      parama.publish();
      parama = parama.hNH.hNI;
      localObject = new lv();
      ((lv)localObject).publish();
      localObject = ((lv)localObject).hNJ.hNK;
      com.tencent.mm.kernel.h.aZW().a(132, this);
      parama = new w(this.qdA.hRk, 2, this.qdA.pPd.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      localObject = this.qdA;
      localMobileVerifyUI = this.qdA;
      this.qdA.getString(r.j.app_tip);
      ((MobileVerifyUI)localObject).lzP = k.a(localMobileVerifyUI, this.qdA.getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128416);
          com.tencent.mm.kernel.h.aZW().a(parama);
          com.tencent.mm.kernel.h.aZW().b(132, o.this);
          AppMethodBeat.o(128416);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128421);
    Log.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qdA.lzP != null)
    {
      this.qdA.lzP.dismiss();
      this.qdA.lzP = null;
    }
    if (paramp.getType() == 132)
    {
      com.tencent.mm.kernel.h.aZW().b(132, this);
      if ((((w)paramp).bIO() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.b.aZI();
        paramString = com.tencent.mm.pluginsdk.b.lk(this.qdA);
        if ((paramString != null) && (paramString.size() != 0)) {}
        for (paramInt1 = 1; (this.pPU != null) && (this.pPU.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.TA("R300_300_QQ");
          paramString = new Intent(this.qdA, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.lCS);
          paramString.putExtra("regsetinfo_NextStep", this.pPU);
          paramString.putExtra("regsetinfo_NextStyle", this.pPV);
          paramString.putExtra("login_type", 1);
          paramp = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this.qdA);
          paramp.addFlags(67108864);
          MMWizardActivity.b(this.qdA, paramString, paramp);
          this.qdA.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramp = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this.qdA);
        paramp.addFlags(67108864);
        paramString = this.qdA;
        paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramp.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.qdA.qed = 4;
        this.qdA.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.qdA.p(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.qdA, this.qdA.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128421);
  }
  
  public final void start() {}
  
  public final void stop()
  {
    AppMethodBeat.i(304981);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    AppMethodBeat.o(304981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */