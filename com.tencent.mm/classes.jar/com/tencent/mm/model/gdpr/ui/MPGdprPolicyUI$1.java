package com.tencent.mm.model.gdpr.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

final class MPGdprPolicyUI$1
  implements e
{
  MPGdprPolicyUI$1(MPGdprPolicyUI paramMPGdprPolicyUI) {}
  
  public final void a(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(1500);
    this.foM.runOnUiThread(new MPGdprPolicyUI.1.3(this));
    AppMethodBeat.o(1500);
  }
  
  public final boolean abM()
  {
    AppMethodBeat.i(1498);
    this.foM.runOnUiThread(new MPGdprPolicyUI.1.1(this));
    AppMethodBeat.o(1498);
    return true;
  }
  
  public final void abN()
  {
    AppMethodBeat.i(1499);
    this.foM.runOnUiThread(new MPGdprPolicyUI.1.2(this));
    AppMethodBeat.o(1499);
  }
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(1501);
    if (paramInt == 200)
    {
      boolean bool = paramBundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
      MPGdprPolicyUI.a(this.foM, bool);
      MPGdprPolicyUI.b(this.foM);
      if ((bool) && (!bo.isNullOrNil(MPGdprPolicyUI.c(this.foM))) && (MPGdprPolicyUI.d(this.foM).foC != 0))
      {
        paramBundle = new com.tencent.mm.ai.a();
        cau localcau = new cau();
        localcau.cwc = MPGdprPolicyUI.c(this.foM);
        localcau.scene = MPGdprPolicyUI.d(this.foM).foC;
        b.a locala = new b.a();
        locala.fsX = localcau;
        locala.fsY = new cav();
        locala.funcId = 2734;
        locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
        paramBundle.rr = locala.ado();
        paramBundle.adl();
      }
    }
    AppMethodBeat.o(1501);
    return false;
  }
  
  public final boolean pV(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.1
 * JD-Core Version:    0.7.0.1
 */