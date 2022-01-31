package com.tencent.mm.model.gdpr.ui;

import android.os.Bundle;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.protocal.c.bqm;
import com.tencent.mm.protocal.c.bqn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMWebView;

final class MPGdprPolicyUI$1
  implements e
{
  MPGdprPolicyUI$1(MPGdprPolicyUI paramMPGdprPolicyUI) {}
  
  public final boolean IP()
  {
    this.dYI.runOnUiThread(new MPGdprPolicyUI.1.1(this));
    return true;
  }
  
  public final void IQ()
  {
    this.dYI.runOnUiThread(new MPGdprPolicyUI.1.2(this));
  }
  
  public final void a(MMWebView paramMMWebView)
  {
    this.dYI.runOnUiThread(new MPGdprPolicyUI.1.3(this));
  }
  
  public final boolean b(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 200)
    {
      boolean bool = paramBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
      MPGdprPolicyUI.a(this.dYI, bool);
      MPGdprPolicyUI.b(this.dYI);
      if ((bool) && (!bk.bl(MPGdprPolicyUI.c(this.dYI))) && (MPGdprPolicyUI.d(this.dYI).dYx != 0))
      {
        paramBundle = new com.tencent.mm.ah.a();
        bqm localbqm = new bqm();
        localbqm.bOL = MPGdprPolicyUI.c(this.dYI);
        localbqm.scene = MPGdprPolicyUI.d(this.dYI).dYx;
        b.a locala = new b.a();
        locala.ecH = localbqm;
        locala.ecI = new bqn();
        locala.ecG = 2734;
        locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
        paramBundle.dmK = locala.Kt();
        paramBundle.Km();
      }
    }
    return false;
  }
  
  public final boolean jh(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.1
 * JD-Core Version:    0.7.0.1
 */