package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.kq;
import com.tencent.mm.f.a.kq.b;
import com.tencent.mm.f.a.kr;
import com.tencent.mm.f.a.kr.a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.List;

public final class o
  implements i, MobileVerifyUI.b
{
  private String jaS = null;
  private String mTn = "";
  private int mTo = 2;
  private MobileVerifyUI ngs;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    AppMethodBeat.i(128419);
    this.ngs = paramMobileVerifyUI;
    this.jaS = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.mTn = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.mTo = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    AppMethodBeat.o(128419);
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128420);
    switch (3.ngw[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128420);
      return false;
      parama = new kq();
      parama.fIg.context = this.ngs;
      EventCenter.instance.publish(parama);
      parama = parama.fIh.fIi;
      Object localObject = new kr();
      EventCenter.instance.publish((IEvent)localObject);
      localObject = ((kr)localObject).fIj.fIk;
      com.tencent.mm.kernel.h.aGY().a(132, this);
      parama = new z(this.ngs.fLC, 2, this.ngs.mSy.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      localObject = this.ngs;
      MobileVerifyUI localMobileVerifyUI = this.ngs;
      this.ngs.getString(r.j.app_tip);
      ((MobileVerifyUI)localObject).iXX = com.tencent.mm.ui.base.h.a(localMobileVerifyUI, this.ngs.getString(r.j.bind_mcontact_verifing), true, new o.2(this, parama));
      continue;
      com.tencent.mm.kernel.h.aGY().a(132, this);
      parama = new z(this.ngs.fLC, 1, "", 0, "");
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      continue;
      parama = new kq();
      parama.fIg.context = this.ngs;
      EventCenter.instance.publish(parama);
      parama = parama.fIh.fIi;
      localObject = new kr();
      EventCenter.instance.publish((IEvent)localObject);
      localObject = ((kr)localObject).fIj.fIk;
      com.tencent.mm.kernel.h.aGY().a(132, this);
      parama = new z(this.ngs.fLC, 2, this.ngs.mSy.getText().toString().trim(), "", parama, (String)localObject);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      localObject = this.ngs;
      localMobileVerifyUI = this.ngs;
      this.ngs.getString(r.j.app_tip);
      ((MobileVerifyUI)localObject).iXX = com.tencent.mm.ui.base.h.a(localMobileVerifyUI, this.ngs.getString(r.j.bind_mcontact_verifing), true, new o.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128421);
    Log.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.ngs.iXX != null)
    {
      this.ngs.iXX.dismiss();
      this.ngs.iXX = null;
    }
    if (paramq.getType() == 132)
    {
      com.tencent.mm.kernel.h.aGY().b(132, this);
      if ((((z)paramq).ZB() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.kernel.b.aGG();
        if (com.tencent.mm.pluginsdk.b.jn(this.ngs).size() != 0) {}
        for (paramInt1 = 1; (this.mTn != null) && (this.mTn.contains("1")) && (paramInt1 != 0); paramInt1 = 0)
        {
          com.tencent.mm.plugin.b.a.bkD("R300_300_QQ");
          paramString = new Intent(this.ngs, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.jaS);
          paramString.putExtra("regsetinfo_NextStep", this.mTn);
          paramString.putExtra("regsetinfo_NextStyle", this.mTo);
          paramString.putExtra("login_type", 1);
          paramq = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this.ngs);
          paramq.addFlags(67108864);
          MMWizardActivity.b(this.ngs, paramString, paramq);
          this.ngs.finish();
          AppMethodBeat.o(128421);
          return;
        }
        paramq = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this.ngs);
        paramq.addFlags(67108864);
        paramString = this.ngs;
        paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramq.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.ngs.ngV = 4;
        this.ngs.finish();
        AppMethodBeat.o(128421);
        return;
      }
      AppMethodBeat.o(128421);
      return;
    }
    if (this.ngs.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128421);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.ngs, this.ngs.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128421);
  }
  
  public final void start() {}
  
  public final void stop()
  {
    AppMethodBeat.i(219002);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    AppMethodBeat.o(219002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */