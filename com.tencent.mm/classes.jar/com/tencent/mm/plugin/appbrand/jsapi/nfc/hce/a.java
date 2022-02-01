package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.luggage.b.c.a.b;
import com.tencent.luggage.l.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.m;
import java.util.List;

public final class a
{
  public static a skT;
  private ResultReceiver dK;
  private MTimerHandler eln;
  private final Handler mHandler;
  private int skL;
  private boolean skM;
  private boolean skN;
  private boolean skO;
  private ComponentName skP;
  private Activity skQ;
  private m skR;
  private com.tencent.mm.ui.widget.a.e skS;
  
  static
  {
    AppMethodBeat.i(136154);
    skT = null;
    skT = new a();
    AppMethodBeat.o(136154);
  }
  
  public a()
  {
    AppMethodBeat.i(136130);
    this.skL = 0;
    this.skM = false;
    this.skN = false;
    this.skO = false;
    this.skS = null;
    this.mHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(136130);
  }
  
  private void ay(int paramInt, String paramString)
  {
    AppMethodBeat.i(136145);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.dK.send(10001, localBundle);
    AppMethodBeat.o(136145);
  }
  
  private void az(int paramInt, String paramString)
  {
    AppMethodBeat.i(136146);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.dK.send(10001, localBundle);
    AppMethodBeat.o(136146);
  }
  
  private void bQa()
  {
    AppMethodBeat.i(136134);
    if (this.skR != null)
    {
      this.skR.dismiss();
      this.skR = null;
    }
    AppMethodBeat.o(136134);
  }
  
  private void ctB()
  {
    AppMethodBeat.i(136137);
    this.eln = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(328033);
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", new Object[] { Integer.valueOf(a.a(a.this)) });
        a.b(a.this);
        if (a.a(a.this) > 10)
        {
          Log.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", new Object[] { Integer.valueOf(10) });
          a.this.aDM();
          a.c(a.this);
          AppMethodBeat.o(328033);
          return false;
        }
        if (d.ctM())
        {
          Log.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
          a.this.aDM();
          a.d(a.this);
          AppMethodBeat.o(328033);
          return false;
        }
        AppMethodBeat.o(328033);
        return true;
      }
    }, true);
    this.eln.startTimer(0L, 300L);
    ctk();
    AppMethodBeat.o(136137);
  }
  
  private void ctC()
  {
    AppMethodBeat.i(136138);
    if (!d.ctL())
    {
      ay(13000, "not support NFC");
      AppMethodBeat.o(136138);
      return;
    }
    if (!d.ctK())
    {
      ay(13002, "not support HCE");
      AppMethodBeat.o(136138);
      return;
    }
    if (!d.ctM())
    {
      ctD();
      AppMethodBeat.o(136138);
      return;
    }
    ctF();
    AppMethodBeat.o(136138);
  }
  
  private void ctD()
  {
    AppMethodBeat.i(136139);
    if (this.skQ == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
      AppMethodBeat.o(136139);
      return;
    }
    if (this.skM)
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
      t(13001, "system NFC switch not opened", this.skQ.getString(a.b.luggage_not_open_nfc_switch_tips));
      AppMethodBeat.o(136139);
      return;
    }
    e.a locala = new e.a(this.skQ);
    locala.bDw(this.skQ.getString(a.b.luggage_open_nfc_switch_tips)).bDC(this.skQ.getString(a.b.luggage_jump_to_settings)).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(136123);
        a.e(a.this);
        AppMethodBeat.o(136123);
      }
    });
    if (ctE()) {
      locala.bDD(this.skQ.getString(a.b.luggage_app_cancel)).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(136124);
          Log.i("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
          a.a(a.this, "system NFC switch not opened");
          AppMethodBeat.o(136124);
        }
      });
    }
    for (;;)
    {
      locala.e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(136125);
          Log.i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
          a.a(a.this, "system NFC switch not opened");
          AppMethodBeat.o(136125);
        }
      });
      this.skS = locala.jHH();
      this.skS.setCanceledOnTouchOutside(false);
      this.skS.show();
      this.skM = true;
      AppMethodBeat.o(136139);
      return;
      locala.bDC(this.skQ.getString(a.b.luggage_app_ok));
    }
  }
  
  private boolean ctE()
  {
    AppMethodBeat.i(136140);
    if (this.skQ == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
      AppMethodBeat.o(136140);
      return false;
    }
    Object localObject = new Intent("android.settings.NFC_SETTINGS");
    localObject = this.skQ.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + ((List)localObject).size());
      int i = 0;
      while (i < ((List)localObject).size())
      {
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", new Object[] { ((ResolveInfo)((List)localObject).get(i)).activityInfo.name });
        i += 1;
      }
      AppMethodBeat.o(136140);
      return true;
    }
    Log.e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
    AppMethodBeat.o(136140);
    return false;
  }
  
  private void ctF()
  {
    AppMethodBeat.i(136141);
    if (this.skQ == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(136141);
      return;
    }
    CardEmulation localCardEmulation = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.skQ));
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.skP);
    if (!localCardEmulation.isDefaultServiceForCategory(this.skP, "payment"))
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[] { Boolean.TRUE });
      d(this.skP);
      AppMethodBeat.o(136141);
      return;
    }
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
    az(0, "NFC switch has opened and now is NFC default application");
    AppMethodBeat.o(136141);
  }
  
  private void ctk()
  {
    AppMethodBeat.i(136133);
    if (this.skQ != null)
    {
      this.skR = m.b(this.skQ, this.skQ.getString(a.b.luggage_app_waiting), false);
      AppMethodBeat.o(136133);
      return;
    }
    Log.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
    AppMethodBeat.o(136133);
  }
  
  private void d(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(136142);
    if (this.skQ == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(136142);
      return;
    }
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[] { Boolean.valueOf(this.skO) });
    if (this.skO)
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
      t(13004, "not set default NFC application", this.skQ.getString(a.b.luggage_not_set_default_nfc_application_tips));
      AppMethodBeat.o(136142);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136128);
        a.f(a.this);
        Intent localIntent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
        localIntent.putExtra("category", "payment");
        localIntent.putExtra("component", paramComponentName);
        if ((a.g(a.this) != null) && (localIntent.resolveActivity(a.g(a.this).getPackageManager()) != null))
        {
          com.tencent.luggage.l.e.bt(a.g(a.this)).a(localIntent, new e.b()
          {
            public final void onResult(int paramAnonymous2Int, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(136127);
              a.skT.AU(2);
              AppMethodBeat.o(136127);
            }
          });
          AppMethodBeat.o(136128);
          return;
        }
        Log.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication can not find activity");
        if (a.g(a.this) != null) {
          a.a(a.this, "not set default NFC application", a.g(a.this).getString(a.b.luggage_not_set_default_nfc_application_tips));
        }
        AppMethodBeat.o(136128);
      }
    }, 200L);
    AppMethodBeat.o(136142);
  }
  
  private void t(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(136143);
    aDM();
    if (this.skQ == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
      AppMethodBeat.o(136143);
      return;
    }
    e.a locala = new e.a(this.skQ);
    locala.bDv("");
    locala.bDw(paramString2);
    locala.bDC(this.skQ.getString(a.b.luggage_app_ok)).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(136129);
        a.a(a.this, paramInt, paramString1);
        AppMethodBeat.o(136129);
      }
    });
    locala.NC(true);
    this.skS = locala.jHH();
    this.skS.setCanceledOnTouchOutside(false);
    this.skS.show();
    AppMethodBeat.o(136143);
  }
  
  public final void AU(int paramInt)
  {
    AppMethodBeat.i(136135);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
      this.skN = true;
      AppMethodBeat.o(136135);
      return;
    }
    if (paramInt == 2) {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
    }
    AppMethodBeat.o(136135);
  }
  
  public final void a(Activity paramActivity, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(136131);
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
    if ((paramActivity == null) || (paramResultReceiver == null)) {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
    }
    this.skQ = paramActivity;
    this.dK = paramResultReceiver;
    AppMethodBeat.o(136131);
  }
  
  public final void aDM()
  {
    AppMethodBeat.i(136144);
    if ((this.skS != null) && (this.skS.isShowing()))
    {
      this.skS.dismiss();
      this.skS = null;
    }
    bQa();
    AppMethodBeat.o(136144);
  }
  
  public final void c(ComponentName paramComponentName)
  {
    AppMethodBeat.i(136132);
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
    this.skP = paramComponentName;
    AppMethodBeat.o(136132);
  }
  
  public final void ctA()
  {
    AppMethodBeat.i(136136);
    if (this.skN)
    {
      ctB();
      AppMethodBeat.o(136136);
      return;
    }
    ctC();
    AppMethodBeat.o(136136);
  }
  
  public final void resetStatus()
  {
    this.skN = false;
    this.skO = false;
    this.skM = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a
 * JD-Core Version:    0.7.0.1
 */