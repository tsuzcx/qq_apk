package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.a;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.soter.e.b;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.pluginsdk.wallet.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.w;
import java.util.Map;

public final class d
  extends a
{
  private com.a.a.a mFL;
  private d.a mFM;
  private com.tencent.mm.pluginsdk.wallet.d mFN;
  
  public d()
  {
    AppMethodBeat.i(41442);
    this.mFL = null;
    this.mFM = new d.a(this, (byte)0);
    this.mFN = null;
    AppMethodBeat.o(41442);
  }
  
  public static void bzd()
  {
    AppMethodBeat.i(41448);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
    if (!e.bzf())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
      AppMethodBeat.o(41448);
      return;
    }
    if ((com.tencent.mm.plugin.wallet_core.model.t.cTN().cUn()) || (com.tencent.mm.plugin.wallet_core.model.t.cTN().cUm()))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
      AppMethodBeat.o(41448);
      return;
    }
    try
    {
      Object localObject = e.getUserId();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:".concat(String.valueOf(localObject)));
      String str = q.LK();
      str = FingerPrintAuth.getRsaKey(e.dU(ah.getContext()), (String)localObject, str);
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
        localObject = FingerPrintAuth.genRsaKey(e.dU(ah.getContext()), e.getUserId(), q.LK());
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
        AppMethodBeat.o(41448);
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localUnsatisfiedLinkError.getMessage());
      AppMethodBeat.o(41448);
      return;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
      AppMethodBeat.o(41448);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localException.getMessage());
      AppMethodBeat.o(41448);
    }
  }
  
  private int[] sW()
  {
    AppMethodBeat.i(41445);
    if (this.mFL != null)
    {
      int[] arrayOfInt = this.mFL.sW();
      AppMethodBeat.o(41445);
      return arrayOfInt;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
    AppMethodBeat.o(41445);
    return null;
  }
  
  public final int a(com.tencent.mm.pluginsdk.wallet.d paramd)
  {
    return 0;
  }
  
  public final int a(com.tencent.mm.pluginsdk.wallet.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(41451);
    if (this.mFL == null) {
      this.mFL = com.a.a.a.sV();
    }
    if (this.mFL != null)
    {
      this.mFN = paramd;
      this.mFL = com.a.a.a.sV();
      paramd = sW();
      int i = this.mFL.a(this.mFM, paramd);
      AppMethodBeat.o(41451);
      return i;
    }
    AppMethodBeat.o(41451);
    return -1;
  }
  
  public final void a(ma paramma, int paramInt)
  {
    AppMethodBeat.i(41454);
    String str1;
    String str2;
    Object localObject;
    if (paramma != null)
    {
      str1 = paramma.cCa.cwk;
      str2 = e.getUserId();
      localObject = q.LK();
      String str3 = w.dSo();
      str1 = FingerPrintAuth.genPayFPEncrypt(e.dU(ah.getContext()), str2, (String)localObject, String.valueOf(paramInt), str3, str1, Build.MODEL);
      str2 = FingerPrintAuth.genOpenFPSign(e.dU(ah.getContext()), e.getUserId(), q.LK(), str1);
      if (TextUtils.isEmpty(str1)) {
        break label194;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      label88:
      if (TextUtils.isEmpty(str2)) {
        break label204;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramma != null) && (paramma.cCa.cCe != null))
      {
        localObject = new ma.b();
        ((ma.b)localObject).cCg = 1;
        ((ma.b)localObject).errCode = 0;
        ((ma.b)localObject).cwl = str1;
        ((ma.b)localObject).cwm = str2;
        ((ma.b)localObject).cwj = paramInt;
        paramma.cCb = ((ma.b)localObject);
        paramma.cCa.cCe.run();
      }
      AppMethodBeat.o(41454);
      return;
      str1 = "";
      break;
      label194:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
      break label88;
      label204:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    return false;
  }
  
  public final k byZ()
  {
    AppMethodBeat.i(41456);
    h localh = new h();
    AppMethodBeat.o(41456);
    return localh;
  }
  
  public final boolean bza()
  {
    AppMethodBeat.i(41443);
    int[] arrayOfInt = com.a.a.a.sX();
    boolean bool1;
    label35:
    boolean bool2;
    if (arrayOfInt != null)
    {
      i = 0;
      if (i < arrayOfInt.length) {
        if (1 == arrayOfInt[i])
        {
          bool1 = true;
          if (ac.ery.eqB != 1) {
            break label122;
          }
          bool2 = true;
          label47:
          if ((ac.erA == null) || (!ac.erA.ers)) {
            break label127;
          }
        }
      }
    }
    label122:
    label127:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2) || (i != 0)) {
        break label132;
      }
      AppMethodBeat.o(41443);
      return true;
      i += 1;
      break;
      bool1 = false;
      break label35;
      bool2 = false;
      break label47;
    }
    label132:
    AppMethodBeat.o(41443);
    return false;
  }
  
  public final boolean bzb()
  {
    AppMethodBeat.i(41444);
    this.mFL = com.a.a.a.sV();
    int[] arrayOfInt = sW();
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
    }
    bzg();
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      AppMethodBeat.o(41444);
      return true;
    }
    AppMethodBeat.o(41444);
    return false;
  }
  
  public final void bzc()
  {
    AppMethodBeat.i(41447);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    if (ac.erA.cJE)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "IFingerPrintMgr is not SoterAuthMgrImp but the device is in white list of SOTER, recheck it!");
      com.tencent.mm.plugin.report.service.h.qsU.cT(1104, 0);
      b.a(false, false, new d.1(this));
    }
    if (!bza())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
      AppMethodBeat.o(41447);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.cTN().cUt();
    if ((localObject != null) && (!((com.tencent.mm.plugin.wallet_core.model.ak)localObject).cUd()))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
      AppMethodBeat.o(41447);
      return;
    }
    localObject = new com.tencent.mm.sdk.platformtools.ak(Looper.myLooper());
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
    com.tencent.mm.sdk.g.d.post(new d.2(this, (com.tencent.mm.sdk.platformtools.ak)localObject), getClass().getName());
    AppMethodBeat.o(41447);
  }
  
  public final boolean bze()
  {
    return true;
  }
  
  public final boolean bzf()
  {
    AppMethodBeat.i(41450);
    boolean bool = e.bzf();
    AppMethodBeat.o(41450);
    return bool;
  }
  
  public final void bzg()
  {
    AppMethodBeat.i(41452);
    this.mFN = null;
    if (this.mFL != null) {
      try
      {
        this.mFL.release();
        this.mFL = null;
        AppMethodBeat.o(41452);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "auth systemRelease occur exception e:" + localException.getMessage());
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "systemRelease auth == null");
    AppMethodBeat.o(41452);
  }
  
  public final void bzh()
  {
    AppMethodBeat.i(41453);
    if (this.mFL != null) {
      try
      {
        this.mFL.abort();
        AppMethodBeat.o(41453);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + localException.getMessage());
      }
    }
    AppMethodBeat.o(41453);
  }
  
  public final void bzi()
  {
    AppMethodBeat.i(41455);
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
    AppMethodBeat.o(41455);
  }
  
  public final Map<String, String> bzj()
  {
    return null;
  }
  
  public final l bzk()
  {
    return null;
  }
  
  public final Map<String, String> bzl()
  {
    return null;
  }
  
  public final boolean bzm()
  {
    return true;
  }
  
  public final boolean bzn()
  {
    return false;
  }
  
  public final boolean bzo()
  {
    return false;
  }
  
  public final void dS(Context paramContext)
  {
    AppMethodBeat.i(41446);
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.android.settings.fingerprint.FingerprintSettings");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
    }
    AppMethodBeat.o(41446);
  }
  
  public final void dT(Context paramContext)
  {
    AppMethodBeat.i(41449);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
    if (!c.byX())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
      AppMethodBeat.o(41449);
      return;
    }
    if (e.dV(paramContext) != 0)
    {
      e.hK(false);
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
      AppMethodBeat.o(41449);
      return;
    }
    e.hK(true);
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
    AppMethodBeat.o(41449);
  }
  
  public final int type()
  {
    return 1;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(41457);
    bzh();
    bzg();
    AppMethodBeat.o(41457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d
 * JD-Core Version:    0.7.0.1
 */