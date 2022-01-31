package com.tencent.kinda.framework.app;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.BioType;
import com.tencent.kinda.gen.KFingerprintService;
import com.tencent.kinda.gen.VoidBinaryI32Callback;
import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.kinda.gen.VoidStringStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class KindaFingerprintImpl
  implements KFingerprintService
{
  String TAG;
  private c<jc> activetyListener;
  private VoidBoolCallback changePwdCallback;
  int identify_num;
  l mgr;
  
  public KindaFingerprintImpl()
  {
    AppMethodBeat.i(144358);
    this.TAG = "KindaFingerprintImpl";
    this.activetyListener = new KindaFingerprintImpl.1(this);
    this.mgr = ((l)g.E(l.class));
    this.identify_num = 0;
    AppMethodBeat.o(144358);
  }
  
  public void authenticateImpl(String paramString1, String paramString2, VoidBinaryI32Callback paramVoidBinaryI32Callback, VoidCallback paramVoidCallback, VoidBoolCallback paramVoidBoolCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(144360);
    x.uli.mGC = paramString2;
    paramString2 = new oh();
    com.tencent.mm.sdk.b.a.ymk.l(paramString2);
    com.tencent.mm.plugin.soter.d.a.cyb();
    paramString2 = new ma();
    paramString2.cCa.cwk = paramString1;
    paramString2.cCa.cCc = 1;
    paramString2.cCa.cCe = new KindaFingerprintImpl.2(this, paramString2, paramVoidBinaryI32Callback, paramVoidCallback, paramVoidBoolCallback, paramVoidStringCallback);
    com.tencent.mm.sdk.b.a.ymk.a(paramString2, Looper.getMainLooper());
    this.changePwdCallback = paramVoidBoolCallback;
    com.tencent.mm.sdk.b.a.ymk.b(this.activetyListener);
    AppMethodBeat.o(144360);
  }
  
  public void reGenFpRsaKeyImpl(boolean paramBoolean, int paramInt, String paramString, VoidStringStringCallback paramVoidStringStringCallback, VoidCallback paramVoidCallback) {}
  
  public void releaseService()
  {
    AppMethodBeat.i(144361);
    oh localoh = new oh();
    com.tencent.mm.sdk.b.a.ymk.l(localoh);
    com.tencent.mm.sdk.b.a.ymk.d(this.activetyListener);
    AppMethodBeat.o(144361);
  }
  
  public void showFaceIdAuthDialogImpl(String paramString, VoidBinaryI32Callback paramVoidBinaryI32Callback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144362);
    ab.i(this.TAG, "showFaceIdAuthDialogImpl begin");
    x.uli.mGC = paramString;
    h.qsU.e(15817, new Object[] { Integer.valueOf(3) });
    paramString = (i)g.E(i.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("face_auth_scene", 1);
    paramString.a((MMActivity)KindaContext.get(), new KindaFingerprintImpl.3(this, paramVoidBinaryI32Callback, paramVoidCallback1, paramVoidCallback2), localBundle);
    AppMethodBeat.o(144362);
  }
  
  public BioType supportBioType()
  {
    AppMethodBeat.i(144359);
    if ((this.mgr != null) && (this.mgr.bza()) && (!this.mgr.byT()) && (this.mgr.byS()))
    {
      localBioType = BioType.FINGERPRINT;
      AppMethodBeat.o(144359);
      return localBioType;
    }
    if ((this.mgr != null) && (this.mgr.bzn()) && (!this.mgr.byU()) && (this.mgr.byV()))
    {
      localBioType = BioType.FACEID;
      AppMethodBeat.o(144359);
      return localBioType;
    }
    BioType localBioType = BioType.NONE;
    AppMethodBeat.o(144359);
    return localBioType;
  }
  
  public void userCancel()
  {
    AppMethodBeat.i(144363);
    if (this.mgr == null)
    {
      AppMethodBeat.o(144363);
      return;
    }
    this.mgr.userCancel();
    AppMethodBeat.o(144363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl
 * JD-Core Version:    0.7.0.1
 */