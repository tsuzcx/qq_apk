package com.tencent.kinda.framework.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.a.if.b;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.plugin.fingerprint.b.a.d;
import com.tencent.mm.plugin.fingerprint.b.a.e;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class KindaFingerprintImpl
  implements KFingerprintService
{
  String TAG;
  private com.tencent.mm.sdk.b.c<ki> activetyListener;
  private VoidBoolCallback changePwdCallback;
  int identify_num;
  com.tencent.mm.plugin.fingerprint.d.a mgr;
  private Dialog tipDialog;
  
  public KindaFingerprintImpl()
  {
    AppMethodBeat.i(18436);
    this.TAG = "KindaFingerprintImpl";
    this.activetyListener = new KindaFingerprintImpl.1(this);
    this.mgr = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
    this.identify_num = 0;
    this.tipDialog = null;
    AppMethodBeat.o(18436);
  }
  
  public void authenticateImpl(String paramString1, String paramString2, final VoidBinaryI32Callback paramVoidBinaryI32Callback, final VoidCallback paramVoidCallback, final VoidBoolCallback paramVoidBoolCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(18438);
    if (KindaContext.get() == null)
    {
      AppMethodBeat.o(18438);
      return;
    }
    p.skJ.skD = paramString2;
    paramVoidStringCallback = new qg();
    com.tencent.mm.sdk.b.a.GpY.l(paramVoidStringCallback);
    com.tencent.mm.plugin.soter.d.a.dTo();
    ac.i(this.TAG, "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.d.a.dTo();
    com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 38);
    paramVoidStringCallback = (i)com.tencent.mm.kernel.g.ab(i.class);
    paramString2 = new f(paramString2);
    paramString2.dac = paramString1;
    paramVoidStringCallback.a(ai.getContext(), paramString2, new d()
    {
      public void onFail(e paramAnonymouse)
      {
        AppMethodBeat.i(18429);
        com.tencent.mm.plugin.soter.d.a.Qj(2);
        com.tencent.mm.plugin.fingerprint.b.a.c localc = paramAnonymouse.skU;
        if ((localc.errCode == 2005) || (localc.errCode == 2007)) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 36);
        }
        if ((localc.errCode == 10308) || (localc.errCode == 2) || (localc.errCode == 1001))
        {
          ac.i(KindaFingerprintImpl.this.TAG, "hy: FingerPrintAuthEvent callback, auth | fail max | common err | pipeline exception, should change to pwd!");
          paramVoidBoolCallback.call(true);
        }
        for (;;)
        {
          ac.i(KindaFingerprintImpl.this.TAG, "FingerPrint fail! retry count: " + paramAnonymouse.retryCount);
          AppMethodBeat.o(18429);
          return;
          paramVoidBoolCallback.call(false);
        }
      }
      
      public void onRetry(e paramAnonymouse)
      {
        AppMethodBeat.i(18430);
        com.tencent.mm.plugin.soter.d.a.Qj(1);
        paramVoidCallback.call();
        ac.i(KindaFingerprintImpl.this.TAG, "FingerPrint retry! retry count: " + paramAnonymouse.retryCount);
        AppMethodBeat.o(18430);
      }
      
      public void onSuccess(e paramAnonymouse)
      {
        AppMethodBeat.i(18428);
        ac.i(KindaFingerprintImpl.this.TAG, "FingerPrint success!, encrypted_pay_info: %s, retry count: ", new Object[] { paramAnonymouse.skU.djs, Integer.valueOf(paramAnonymouse.retryCount) });
        gt localgt = new gt();
        localgt.DTX = true;
        localgt.djs = paramAnonymouse.skU.djs;
        localgt.djt = paramAnonymouse.skU.djt;
        localgt.BIr = paramAnonymouse.retryCount;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("json", paramAnonymouse.skU.skE);
          localJSONObject.put("signature", paramAnonymouse.skU.skF);
          localJSONObject.put("soter_type", s.ery().esg());
          localgt.DTY = localJSONObject.toString();
        }
        catch (JSONException localJSONException)
        {
          try
          {
            for (;;)
            {
              paramVoidBinaryI32Callback.call(localgt.toByteArray(), paramAnonymouse.skU.djq);
              com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 37);
              com.tencent.mm.plugin.soter.d.a.Qj(0);
              AppMethodBeat.o(18428);
              return;
              localJSONException = localJSONException;
              ac.printErrStackTrace(KindaFingerprintImpl.this.TAG, localJSONException, "json exception while construct json for soter_req. message: %s", new Object[] { localJSONException.getMessage() });
            }
          }
          catch (IOException paramAnonymouse)
          {
            for (;;)
            {
              ac.printErrStackTrace(KindaFingerprintImpl.this.TAG, paramAnonymouse, "FingerPrint exception: %s", new Object[] { paramAnonymouse.getMessage() });
            }
          }
        }
      }
    });
    this.changePwdCallback = paramVoidBoolCallback;
    com.tencent.mm.sdk.b.a.GpY.b(this.activetyListener);
    AppMethodBeat.o(18438);
  }
  
  public void changeAuthKey(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(18443);
    Bundle localBundle = new Bundle();
    localBundle.putString("pwd", paramString);
    int i;
    if (paramBoolean2)
    {
      i = 0;
      if (!this.mgr.cGZ()) {
        break label75;
      }
      i = 1;
    }
    for (;;)
    {
      localBundle.putInt("key_open_biometric_type", i);
      this.mgr.a(paramBoolean1, paramBoolean2, localBundle);
      AppMethodBeat.o(18443);
      return;
      label75:
      if (this.mgr.cHc()) {
        i = 2;
      }
    }
  }
  
  public void closeTipDialog()
  {
    AppMethodBeat.i(18446);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(18446);
  }
  
  public boolean isNeedChangeAuthKey()
  {
    AppMethodBeat.i(18442);
    boolean bool = this.mgr.cHl();
    if ((p.skJ.skL) || (!bool)) {}
    for (bool = true;; bool = false)
    {
      p.skJ.skL = bool;
      AppMethodBeat.o(18442);
      return bool;
    }
  }
  
  public void reGenFpRsaKeyImpl(boolean paramBoolean, int paramInt, String paramString, final VoidStringStringCallback paramVoidStringStringCallback, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18440);
    final if localif = new if();
    localif.djo = null;
    localif.djn.djp = paramBoolean;
    if (paramBoolean) {
      showProgress();
    }
    localif.djn.djq = paramInt;
    localif.djn.djr = paramString;
    localif.callback = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18431);
        ac.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback");
        if.b localb = localif.djo;
        if ((localb != null) && (localb.deB))
        {
          ac.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          KindaFingerprintImpl.this.closeTipDialog();
          if (paramVoidStringStringCallback != null)
          {
            paramVoidStringStringCallback.call(localb.djs, localb.djt);
            AppMethodBeat.o(18431);
          }
        }
        else if ((localb != null) && (!localb.deB))
        {
          ac.e(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
          KindaFingerprintImpl.this.closeTipDialog();
          if (paramVoidCallback != null)
          {
            paramVoidCallback.call();
            AppMethodBeat.o(18431);
          }
        }
        else
        {
          ac.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result == null");
        }
        AppMethodBeat.o(18431);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a(localif, Looper.getMainLooper());
    AppMethodBeat.o(18440);
  }
  
  public void releaseService()
  {
    AppMethodBeat.i(18439);
    qg localqg = new qg();
    com.tencent.mm.sdk.b.a.GpY.l(localqg);
    com.tencent.mm.sdk.b.a.GpY.d(this.activetyListener);
    AppMethodBeat.o(18439);
  }
  
  public void setNeedChangeAuthKey(boolean paramBoolean)
  {
    p.skJ.skL = paramBoolean;
  }
  
  public void showFaceIdAuthDialogImpl(String paramString, final VoidBinaryI32Callback paramVoidBinaryI32Callback, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18441);
    ac.i(this.TAG, "showFaceIdAuthDialogImpl begin");
    p.skJ.skD = paramString;
    com.tencent.mm.plugin.report.service.h.wUl.f(15817, new Object[] { Integer.valueOf(3) });
    paramString = (com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("face_auth_scene", 1);
    paramString.a((MMActivity)KindaContext.get(), new com.tencent.mm.plugin.fingerprint.faceid.auth.a()
    {
      public void onAuthCancel()
      {
        AppMethodBeat.i(18434);
        ac.i(KindaFingerprintImpl.this.TAG, "face id auth cancel");
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AppMethodBeat.o(18434);
      }
      
      public void onAuthFail(int paramAnonymousInt)
      {
        AppMethodBeat.i(18433);
        ac.i(KindaFingerprintImpl.this.TAG, "face id auth fail: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(KindaFingerprintImpl.this.identify_num) });
        if (paramVoidCallback1 != null) {
          paramVoidCallback1.call();
        }
        KindaFingerprintImpl localKindaFingerprintImpl = KindaFingerprintImpl.this;
        localKindaFingerprintImpl.identify_num += 1;
        AppMethodBeat.o(18433);
      }
      
      public void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(18432);
        ac.i(KindaFingerprintImpl.this.TAG, "face id auth success");
        gt localgt = new gt();
        localgt.DTX = true;
        localgt.djs = "";
        localgt.djt = "";
        localgt.DTY = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).cHd();
        KindaFingerprintImpl localKindaFingerprintImpl = KindaFingerprintImpl.this;
        paramAnonymousInt2 = localKindaFingerprintImpl.identify_num + 1;
        localKindaFingerprintImpl.identify_num = paramAnonymousInt2;
        localgt.BIr = paramAnonymousInt2;
        try
        {
          paramVoidBinaryI32Callback.call(localgt.toByteArray(), paramAnonymousInt1);
          AppMethodBeat.o(18432);
          return;
        }
        catch (IOException localIOException)
        {
          AppMethodBeat.o(18432);
        }
      }
    }, localBundle);
    AppMethodBeat.o(18441);
  }
  
  public void showProgress()
  {
    AppMethodBeat.i(18445);
    if ((this.tipDialog == null) || (!this.tipDialog.isShowing()))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      if (KindaContext.get() != null)
      {
        this.tipDialog = com.tencent.mm.wallet_core.ui.g.a(KindaContext.get(), false, new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(18435);
            KindaFingerprintImpl.this.closeTipDialog();
            AppMethodBeat.o(18435);
          }
        });
        AppMethodBeat.o(18445);
        return;
      }
      ac.e(this.TAG, "fingerprint loading error! KindaContext return null!!");
    }
    AppMethodBeat.o(18445);
  }
  
  public BioType supportBioType()
  {
    AppMethodBeat.i(18437);
    if ((this.mgr != null) && (this.mgr.cHe()) && (!this.mgr.cHa()) && (this.mgr.cGZ()))
    {
      localBioType = BioType.FINGERPRINT;
      AppMethodBeat.o(18437);
      return localBioType;
    }
    if ((this.mgr != null) && (this.mgr.cHm()) && (!this.mgr.cHb()) && (this.mgr.cHc()))
    {
      localBioType = BioType.FACEID;
      AppMethodBeat.o(18437);
      return localBioType;
    }
    BioType localBioType = BioType.NONE;
    AppMethodBeat.o(18437);
    return localBioType;
  }
  
  public void userCancel()
  {
    AppMethodBeat.i(18444);
    if (this.mgr == null)
    {
      AppMethodBeat.o(18444);
      return;
    }
    this.mgr.userCancel();
    AppMethodBeat.o(18444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl
 * JD-Core Version:    0.7.0.1
 */