package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.c.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.f;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public final class a
{
  public static a gyn = new a();
  ResultReceiver Cz;
  private int gyd = 0;
  private boolean gye = false;
  boolean gyf = false;
  private boolean gyg = false;
  Timer gyh;
  TimerTask gyi;
  ComponentName gyj;
  Activity gyk;
  f gyl;
  private c gym = null;
  private final Handler mHandler = new Handler();
  
  private void K(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.Cz.send(10001, localBundle);
  }
  
  private void L(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.Cz.send(10001, localBundle);
    if (this.gyk != null) {
      this.gyk.finish();
    }
  }
  
  @TargetApi(19)
  private void ajH()
  {
    if (this.gyk == null)
    {
      y.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
      return;
    }
    Object localObject = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.gyk));
    y.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.gyj);
    if (!((CardEmulation)localObject).isDefaultServiceForCategory(this.gyj, "payment"))
    {
      y.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[] { Boolean.valueOf(true) });
      localObject = this.gyj;
      if (this.gyk == null)
      {
        y.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
        return;
      }
      y.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[] { Boolean.valueOf(this.gyg) });
      if (this.gyg)
      {
        y.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
        h(13004, "not set default NFC application", this.gyk.getString(a.b.luggage_not_set_default_nfc_application_tips));
        return;
      }
      this.mHandler.postDelayed(new a.5(this, (ComponentName)localObject), 200L);
      return;
    }
    y.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
    L(0, "NFC switch has opened and now is NFC default application");
  }
  
  private void h(final int paramInt, final String paramString1, String paramString2)
  {
    dismissDialog();
    if (this.gyk == null)
    {
      y.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
      return;
    }
    c.a locala = new c.a(this.gyk);
    locala.aez("");
    locala.aeA(paramString2);
    locala.aeD(this.gyk.getString(a.b.luggage_app_ok)).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        a.a(a.this, paramInt, paramString1);
      }
    });
    locala.nW(true);
    this.gym = locala.aoP();
    this.gym.show();
  }
  
  final void ajG()
  {
    if (!d.ajM())
    {
      K(13000, "not support NFC");
      return;
    }
    if (!d.ajL())
    {
      K(13002, "not support HCE");
      return;
    }
    if (!d.ajN())
    {
      if (this.gyk == null)
      {
        y.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
        return;
      }
      if (this.gye)
      {
        y.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
        h(13001, "system NFC switch not opened", this.gyk.getString(a.b.luggage_not_open_nfc_switch_tips));
        return;
      }
      c.a locala = new c.a(this.gyk);
      locala.aeA(this.gyk.getString(a.b.luggage_open_nfc_switch_tips)).aeD(this.gyk.getString(a.b.luggage_jump_to_settings)).a(new a.2(this));
      int i;
      if (this.gyk == null)
      {
        y.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
        i = 0;
        if (i == 0) {
          break label365;
        }
        locala.aeE(this.gyk.getString(a.b.luggage_app_cancel)).b(new a.3(this));
      }
      for (;;)
      {
        locala.e(new a.4(this));
        this.gym = locala.aoP();
        this.gym.setCanceledOnTouchOutside(false);
        this.gym.show();
        this.gye = true;
        return;
        Object localObject = new Intent("android.settings.NFC_SETTINGS");
        localObject = this.gyk.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          y.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + ((List)localObject).size());
          i = 0;
          while (i < ((List)localObject).size())
          {
            y.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", new Object[] { ((ResolveInfo)((List)localObject).get(i)).activityInfo.name });
            i += 1;
          }
          i = 1;
          break;
        }
        y.e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
        i = 0;
        break;
        label365:
        locala.aeD(this.gyk.getString(a.b.luggage_app_ok));
      }
    }
    ajH();
  }
  
  public final void dismissDialog()
  {
    if ((this.gym != null) && (this.gym.isShowing()))
    {
      this.gym.dismiss();
      this.gym = null;
    }
    if (this.gyl != null)
    {
      this.gyl.dismiss();
      this.gyl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a
 * JD-Core Version:    0.7.0.1
 */