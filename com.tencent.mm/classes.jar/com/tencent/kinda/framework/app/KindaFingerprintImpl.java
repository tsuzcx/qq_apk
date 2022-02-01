package com.tencent.kinda.framework.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Looper;
import androidx.lifecycle.q;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.BioType;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KFingerprintService;
import com.tencent.kinda.gen.VoidBinaryI32Callback;
import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringBinaryCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.kinda.gen.VoidStringStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kv;
import com.tencent.mm.autogen.a.kv.b;
import com.tencent.mm.autogen.a.nf;
import com.tencent.mm.autogen.a.ua;
import com.tencent.mm.plugin.fingerprint.mgr.a.c;
import com.tencent.mm.plugin.fingerprint.mgr.a.d;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.plugin.fingerprint.mgr.j;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.l;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class KindaFingerprintImpl
  implements KFingerprintService
{
  String TAG;
  private IListener<nf> activetyListener;
  private VoidBoolCallback changePwdCallback;
  int identify_num;
  com.tencent.mm.plugin.fingerprint.c.a mgr;
  private Dialog tipDialog;
  
  public KindaFingerprintImpl()
  {
    AppMethodBeat.i(18436);
    this.TAG = "KindaFingerprintImpl";
    this.activetyListener = new IListener(com.tencent.mm.app.f.hfK)
    {
      public boolean callback(nf paramAnonymousnf)
      {
        AppMethodBeat.i(18426);
        if ((paramAnonymousnf != null) && (KindaFingerprintImpl.this.changePwdCallback != null)) {
          KindaFingerprintImpl.this.changePwdCallback.call(false);
        }
        AppMethodBeat.o(18426);
        return false;
      }
    };
    this.mgr = ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class));
    this.identify_num = 0;
    this.tipDialog = null;
    AppMethodBeat.o(18436);
  }
  
  public void authenticateImpl(String paramString1, String paramString2, ITransmitKvData paramITransmitKvData, final VoidBinaryI32Callback paramVoidBinaryI32Callback, final VoidCallback paramVoidCallback, final VoidBoolCallback paramVoidBoolCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(226399);
    if (KindaContext.get() == null)
    {
      AppMethodBeat.o(226399);
      return;
    }
    j.Hgj.Hgd = paramString2;
    new ua().publish();
    com.tencent.mm.plugin.soter.model.a.htx();
    Log.i(this.TAG, "req fingerprint auth 2");
    com.tencent.mm.plugin.soter.model.a.htx();
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 38);
    paramVoidStringCallback = (i)com.tencent.mm.kernel.h.ax(i.class);
    paramString2 = new com.tencent.mm.plugin.fingerprint.mgr.a.f(paramString2);
    paramString2.hAT = paramString1;
    if (paramITransmitKvData != null)
    {
      paramString2.qBc = paramITransmitKvData.getString("prompt_title");
      paramString2.Hgv = paramITransmitKvData.getString("prompt_subtitle");
      paramString2.Hgx = paramITransmitKvData.getString("prompt_button");
    }
    paramVoidStringCallback.a(MMApplicationContext.getContext(), paramString2, new d()
    {
      public void onFail(com.tencent.mm.plugin.fingerprint.mgr.a.e paramAnonymouse)
      {
        AppMethodBeat.i(18429);
        com.tencent.mm.plugin.soter.model.a.amP(2);
        c localc = paramAnonymouse.Hgu;
        if ((localc.errCode == 2005) || (localc.errCode == 2007)) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 36);
        }
        if ((localc.errCode == 10308) || (localc.errCode == 2) || (localc.errCode == 1001))
        {
          Log.i(KindaFingerprintImpl.this.TAG, "hy: FingerPrintAuthEvent callback, auth | fail max | common err | pipeline exception, should change to pwd!");
          paramVoidBoolCallback.call(true);
        }
        for (;;)
        {
          Log.i(KindaFingerprintImpl.this.TAG, "FingerPrint fail! retry count: " + paramAnonymouse.retryCount);
          AppMethodBeat.o(18429);
          return;
          paramVoidBoolCallback.call(false);
        }
      }
      
      public void onRetry(com.tencent.mm.plugin.fingerprint.mgr.a.e paramAnonymouse)
      {
        AppMethodBeat.i(18430);
        com.tencent.mm.plugin.soter.model.a.amP(1);
        paramVoidCallback.call();
        Log.i(KindaFingerprintImpl.this.TAG, "FingerPrint retry! retry count: " + paramAnonymouse.retryCount);
        AppMethodBeat.o(18430);
      }
      
      public void onSuccess(com.tencent.mm.plugin.fingerprint.mgr.a.e paramAnonymouse)
      {
        AppMethodBeat.i(18428);
        Log.i(KindaFingerprintImpl.this.TAG, "FingerPrint success!, encrypted_pay_info: %s, retry count: ", new Object[] { paramAnonymouse.Hgu.hMz, Integer.valueOf(paramAnonymouse.retryCount) });
        hz localhz = new hz();
        localhz.YJG = true;
        localhz.hMz = paramAnonymouse.Hgu.hMz;
        localhz.hMA = paramAnonymouse.Hgu.hMA;
        localhz.VSw = paramAnonymouse.retryCount;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("json", paramAnonymouse.Hgu.Hge);
          localJSONObject.put("signature", paramAnonymouse.Hgu.Hgf);
          localJSONObject.put("soter_type", u.iiC().ijm());
          localhz.YJH = localJSONObject.toString();
        }
        catch (JSONException localJSONException)
        {
          try
          {
            for (;;)
            {
              paramVoidBinaryI32Callback.call(localhz.toByteArray(), paramAnonymouse.Hgu.hMx);
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 37);
              com.tencent.mm.plugin.soter.model.a.amP(0);
              AppMethodBeat.o(18428);
              return;
              localJSONException = localJSONException;
              Log.printErrStackTrace(KindaFingerprintImpl.this.TAG, localJSONException, "json exception while construct json for soter_req. message: %s", new Object[] { localJSONException.getMessage() });
            }
          }
          catch (IOException paramAnonymouse)
          {
            for (;;)
            {
              Log.printErrStackTrace(KindaFingerprintImpl.this.TAG, paramAnonymouse, "FingerPrint exception: %s", new Object[] { paramAnonymouse.getMessage() });
            }
          }
        }
      }
    });
    this.changePwdCallback = paramVoidBoolCallback;
    this.activetyListener.alive();
    AppMethodBeat.o(226399);
  }
  
  public void changeAuthKey(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(18443);
    Bundle localBundle = new Bundle();
    localBundle.putString("pwd", paramString);
    paramString = (i)com.tencent.mm.kernel.h.ax(i.class);
    int i;
    if ((paramString.ftQ()) || (paramString.ftP())) {
      if (paramBoolean2)
      {
        i = 0;
        if (!this.mgr.ftq()) {
          break label102;
        }
        i = 1;
      }
    }
    for (;;)
    {
      localBundle.putInt("key_open_biometric_type", i);
      this.mgr.a(paramBoolean1, paramBoolean2, localBundle);
      AppMethodBeat.o(18443);
      return;
      label102:
      if (this.mgr.ftt()) {
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
    boolean bool = this.mgr.ftC();
    if ((j.Hgj.Hgl) || (!bool)) {}
    for (bool = true;; bool = false)
    {
      j.Hgj.Hgl = bool;
      AppMethodBeat.o(18442);
      return bool;
    }
  }
  
  public void reGenFpRsaKeyImpl(boolean paramBoolean, int paramInt, String paramString, final VoidStringStringCallback paramVoidStringStringCallback, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18440);
    final kv localkv = new kv();
    localkv.hMv = null;
    localkv.hMu.hMw = paramBoolean;
    if (paramBoolean) {
      showProgress();
    }
    localkv.hMu.hMx = paramInt;
    localkv.hMu.hMy = paramString;
    localkv.callback = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18431);
        Log.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback");
        kv.b localb = localkv.hMv;
        if ((localb != null) && (localb.isSuccess))
        {
          Log.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          KindaFingerprintImpl.this.closeTipDialog();
          if (paramVoidStringStringCallback != null)
          {
            paramVoidStringStringCallback.call(localb.hMz, localb.hMA);
            AppMethodBeat.o(18431);
          }
        }
        else if ((localb != null) && (!localb.isSuccess))
        {
          Log.e(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
          KindaFingerprintImpl.this.closeTipDialog();
          if (paramVoidCallback != null)
          {
            paramVoidCallback.call();
            AppMethodBeat.o(18431);
          }
        }
        else
        {
          Log.i(KindaFingerprintImpl.this.TAG, "GenFingerPrintRsaKeyEvent callback, result == null");
        }
        AppMethodBeat.o(18431);
      }
    };
    localkv.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(18440);
  }
  
  public void releaseService()
  {
    AppMethodBeat.i(18439);
    new ua().publish();
    this.activetyListener.dead();
    AppMethodBeat.o(18439);
  }
  
  public void setNeedChangeAuthKey(boolean paramBoolean)
  {
    j.Hgj.Hgl = paramBoolean;
  }
  
  public void showBioAuthViewImpl(String paramString1, String paramString2, VoidStringBinaryCallback paramVoidStringBinaryCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3) {}
  
  public void showFaceIdAuthDialogImpl(String paramString, final VoidBinaryI32Callback paramVoidBinaryI32Callback, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18441);
    Log.i(this.TAG, "showFaceIdAuthDialogImpl begin");
    j.Hgj.Hgd = paramString;
    com.tencent.mm.plugin.report.service.h.OAn.b(15817, new Object[] { Integer.valueOf(3) });
    paramString = (com.tencent.mm.plugin.fingerprint.mgr.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.e.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("face_auth_scene", 1);
    paramString.a((MMActivity)KindaContext.get(), new com.tencent.mm.plugin.fingerprint.faceid.auth.a()
    {
      public void onAuthCancel()
      {
        AppMethodBeat.i(18434);
        Log.i(KindaFingerprintImpl.this.TAG, "face id auth cancel");
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AppMethodBeat.o(18434);
      }
      
      public void onAuthFail(int paramAnonymousInt)
      {
        AppMethodBeat.i(18433);
        Log.i(KindaFingerprintImpl.this.TAG, "face id auth fail: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(KindaFingerprintImpl.this.identify_num) });
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
        Log.i(KindaFingerprintImpl.this.TAG, "face id auth success");
        hz localhz = new hz();
        localhz.YJG = true;
        localhz.hMz = "";
        localhz.hMA = "";
        localhz.YJH = ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).ftu();
        KindaFingerprintImpl localKindaFingerprintImpl = KindaFingerprintImpl.this;
        paramAnonymousInt2 = localKindaFingerprintImpl.identify_num + 1;
        localKindaFingerprintImpl.identify_num = paramAnonymousInt2;
        localhz.VSw = paramAnonymousInt2;
        try
        {
          paramVoidBinaryI32Callback.call(localhz.toByteArray(), paramAnonymousInt1);
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
        this.tipDialog = l.a(KindaContext.get(), false, new DialogInterface.OnCancelListener()
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
      Log.e(this.TAG, "fingerprint loading error! KindaContext return null!!");
    }
    AppMethodBeat.o(18445);
  }
  
  public BioType supportBioType()
  {
    AppMethodBeat.i(18437);
    if ((this.mgr != null) && (this.mgr.ftv()) && (!this.mgr.ftr()) && (this.mgr.ftq()))
    {
      localBioType = BioType.FINGERPRINT;
      AppMethodBeat.o(18437);
      return localBioType;
    }
    if ((this.mgr != null) && (this.mgr.ftD()) && (!this.mgr.fts()) && (this.mgr.ftt()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl
 * JD-Core Version:    0.7.0.1
 */