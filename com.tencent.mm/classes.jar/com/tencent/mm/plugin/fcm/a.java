package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class a
  implements f
{
  private static a mEQ;
  final Context context;
  private int mER;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private SharedPreferences byB()
  {
    AppMethodBeat.i(56433);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    AppMethodBeat.o(56433);
    return localSharedPreferences;
  }
  
  public static a byx()
  {
    AppMethodBeat.i(56427);
    if (mEQ != null)
    {
      localObject = mEQ;
      AppMethodBeat.o(56427);
      return localObject;
    }
    Object localObject = ah.getContext();
    if (localObject == null)
    {
      ab.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
      AppMethodBeat.o(56427);
      return null;
    }
    localObject = new a((Context)localObject);
    mEQ = (a)localObject;
    AppMethodBeat.o(56427);
    return localObject;
  }
  
  private void hG(boolean paramBoolean)
  {
    AppMethodBeat.i(56432);
    Object localObject = byB();
    ab.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(paramBoolean)));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.mER = com.tencent.mm.kernel.a.QW();
      AppMethodBeat.o(56432);
      return;
    }
    this.mER = 0;
    AppMethodBeat.o(56432);
  }
  
  public final void Oi(String paramString)
  {
    AppMethodBeat.i(56430);
    ab.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", new Object[] { paramString });
    e.qrI.idkeyStat(901L, 11L, 1L, false);
    if (bo.isNullOrNil(paramString))
    {
      e.qrI.idkeyStat(901L, 13L, 1L, false);
      ab.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
      AppMethodBeat.o(56430);
      return;
    }
    if (this.mER == com.tencent.mm.kernel.a.QW())
    {
      e.qrI.idkeyStat(901L, 12L, 1L, false);
      ab.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
      AppMethodBeat.o(56430);
      return;
    }
    paramString = new b(paramString);
    g.RM();
    g.RK().eHt.a(paramString.getType(), this);
    g.RM();
    g.RK().eHt.a(paramString, 0);
    e.qrI.idkeyStat(901L, 14L, 1L, false);
    AppMethodBeat.o(56430);
  }
  
  public final boolean byA()
  {
    AppMethodBeat.i(56431);
    boolean bool = byB().getBoolean("isRegToSvr", false);
    AppMethodBeat.o(56431);
    return bool;
  }
  
  final boolean byy()
  {
    AppMethodBeat.i(56428);
    try
    {
      if (Build.VERSION.SDK_INT < 14)
      {
        ab.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
        AppMethodBeat.o(56428);
        return false;
      }
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
      if (i != 0)
      {
        ab.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(i)));
        AppMethodBeat.o(56428);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.FCM.FcmRegister", localThrowable.toString());
      AppMethodBeat.o(56428);
      return false;
    }
    AppMethodBeat.o(56428);
    return true;
  }
  
  final void byz()
  {
    AppMethodBeat.i(56429);
    e.qrI.idkeyStat(901L, 18L, 1L, false);
    Object localObject = FirebaseInstanceId.rL().getToken();
    if (bo.isNullOrNil((String)localObject))
    {
      e.qrI.idkeyStat(901L, 19L, 1L, false);
      ab.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
      AppMethodBeat.o(56429);
      return;
    }
    hG(false);
    localObject = new c((String)localObject);
    g.RM();
    g.RK().eHt.a(((c)localObject).getType(), this);
    g.RM();
    g.RK().eHt.a((m)localObject, 0);
    e.qrI.idkeyStat(901L, 21L, 1L, false);
    AppMethodBeat.o(56429);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    AppMethodBeat.i(56434);
    if (paramm == null)
    {
      AppMethodBeat.o(56434);
      return;
    }
    if ((paramm instanceof b))
    {
      g.RM();
      g.RK().eHt.a(((b)paramm).getType(), this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
        e.qrI.idkeyStat(901L, 16L, 1L, false);
        bool = true;
      }
      for (;;)
      {
        hG(bool);
        AppMethodBeat.o(56434);
        return;
        ab.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
        e.qrI.idkeyStat(901L, 17L, 1L, false);
      }
    }
    if ((paramm instanceof c))
    {
      g.RM();
      g.RK().eHt.a(((c)paramm).getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label187;
      }
      ab.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
      e.qrI.idkeyStat(901L, 23L, 1L, false);
    }
    for (;;)
    {
      hG(false);
      AppMethodBeat.o(56434);
      return;
      label187:
      ab.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
      e.qrI.idkeyStat(901L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */