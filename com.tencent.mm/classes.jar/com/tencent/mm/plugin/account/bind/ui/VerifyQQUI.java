package com.tencent.mm.plugin.account.bind.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.hv;
import com.tencent.mm.h.a.hv.b;
import com.tencent.mm.h.a.hw;
import com.tencent.mm.h.a.hw.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class VerifyQQUI
  extends MMWizardActivity
  implements f
{
  private String bPS;
  private String bPU;
  private byte[] ebn = null;
  private long feM = 0L;
  private String feN = "";
  private String feO = "";
  private String feP;
  private SecurityImage fex = null;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  public final boolean Wt()
  {
    XM();
    finish();
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindqq_verifyqq;
  }
  
  protected final void initView()
  {
    Object localObject = new hv();
    ((hv)localObject).bPQ.context = this;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    this.bPS = ((hv)localObject).bPR.bPS;
    localObject = new hw();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    this.bPU = ((hw)localObject).bPT.bPU;
    setMMTitle(a.i.bind_qq_verify_title);
    setBackBtn(new VerifyQQUI.1(this));
    localObject = (EditText)findViewById(a.e.bind_qq_verify_qq_uin);
    EditText localEditText = (EditText)findViewById(a.e.bind_qq_verify_qq_pwd);
    addTextOptionMenu(0, getString(a.i.app_finish), new VerifyQQUI.2(this, (EditText)localObject, localEditText));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(144, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.Dk().b(144, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.account.bind.a.b localb = (com.tencent.mm.plugin.account.bind.a.b)paramm;
    byte[] arrayOfByte = com.tencent.mm.kernel.g.DN().CU().bH(localb.eAo);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(bk.i(arrayOfByte, new byte[0]).length), Long.valueOf(localb.eAo) });
    if (bk.bE(arrayOfByte)) {
      arrayOfByte = aa.a(((id)localb.dmK.ecF.ecN).svJ);
    }
    for (;;)
    {
      this.ebn = arrayOfByte;
      this.feO = ((id)((com.tencent.mm.plugin.account.bind.a.b)paramm).dmK.ecF.ecN).sBP;
      if (this.ebn != null) {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.VerifyQQUI", "imgSid:" + this.feO + " img len" + this.ebn.length + " " + com.tencent.mm.compatible.util.g.zI());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.a.a.eUS.tk();
        h.a(this.mController.uMN, a.i.bind_qq_verify_alert_succ, a.i.bind_qq_verify_alert_title, new VerifyQQUI.3(this));
        return;
      }
      int i;
      if (paramInt1 == 4) {
        switch (paramInt2)
        {
        default: 
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            i = 1;
          }
          break;
        }
      }
      while (i == 0)
      {
        Toast.makeText(this, getString(a.i.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        return;
        paramString = com.tencent.mm.i.a.eI(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          h.h(this.mController.uMN, a.i.bind_qq_verify_alert_wrong, a.i.bind_qq_verify_alert_failed_title);
          i = 1;
          continue;
          h.h(this.mController.uMN, a.i.bind_qq_verify_alert_failed_content, a.i.bind_qq_verify_alert_failed_title);
          i = 1;
          continue;
          h.h(this.mController.uMN, a.i.bind_qq_verify_alert_failed_niceqq, a.i.app_tip);
          i = 1;
          continue;
          h.h(this.mController.uMN, a.i.bind_qq_verify_alert_failed_denial, a.i.app_tip);
          i = 1;
          continue;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.VerifyQQUI", "imgSid:" + this.feO + " img len" + this.ebn.length + " " + com.tencent.mm.compatible.util.g.zI());
          if (!com.tencent.mm.kernel.g.DK())
          {
            i = 1;
          }
          else
          {
            if (this.fex == null) {
              this.fex = SecurityImage.a.a(this.mController.uMN, a.i.regbyqq_secimg_title, 0, this.ebn, this.feO, this.feP, new VerifyQQUI.4(this), null, new VerifyQQUI.5(this), new a());
            }
            for (;;)
            {
              i = 1;
              break;
              com.tencent.mm.sdk.platformtools.y.d("MicroMsg.VerifyQQUI", "imgSid:" + this.feO + " img len" + this.ebn.length + " " + com.tencent.mm.compatible.util.g.zI());
              this.fex.a(0, this.ebn, this.feO, this.feP);
            }
            h.h(this.mController.uMN, a.i.bind_qq_verify_alert_failed_freq_limit, a.i.app_tip);
            i = 1;
            continue;
            i = 0;
          }
        }
      }
    }
  }
  
  final class a
    extends SecurityImage.b
  {
    a() {}
    
    public final void Ws()
    {
      com.tencent.mm.plugin.account.bind.a.b localb = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.b(VerifyQQUI.this), VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.i(VerifyQQUI.this), "", VerifyQQUI.j(VerifyQQUI.this), 2, true);
      com.tencent.mm.kernel.g.Dk().a(localb, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI
 * JD-Core Version:    0.7.0.1
 */