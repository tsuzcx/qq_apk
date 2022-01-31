package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.g.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.f;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public final class a
{
  public static a hUM;
  private ResultReceiver Di;
  private int hUC;
  private boolean hUD;
  private boolean hUE;
  private boolean hUF;
  private Timer hUG;
  private TimerTask hUH;
  private ComponentName hUI;
  private Activity hUJ;
  private f hUK;
  private c hUL;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(137906);
    hUM = null;
    hUM = new a();
    AppMethodBeat.o(137906);
  }
  
  public a()
  {
    AppMethodBeat.i(137891);
    this.hUC = 0;
    this.hUD = false;
    this.hUE = false;
    this.hUF = false;
    this.hUL = null;
    this.mHandler = new Handler();
    AppMethodBeat.o(137891);
  }
  
  private void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(137898);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.Di.send(10001, localBundle);
    AppMethodBeat.o(137898);
  }
  
  private void W(int paramInt, String paramString)
  {
    AppMethodBeat.i(137899);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.Di.send(10001, localBundle);
    AppMethodBeat.o(137899);
  }
  
  private void aCV()
  {
    AppMethodBeat.i(137892);
    if (this.hUK != null)
    {
      this.hUK.dismiss();
      this.hUK = null;
    }
    AppMethodBeat.o(137892);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(141917);
    if (this.hUJ != null)
    {
      this.hUK = f.g(this.hUJ, this.hUJ.getString(2131301357));
      AppMethodBeat.o(141917);
      return;
    }
    ab.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
    AppMethodBeat.o(141917);
  }
  
  private void aEb()
  {
    AppMethodBeat.i(141920);
    this.hUH = new a.1(this);
    this.hUG = new Timer();
    this.hUG.scheduleAtFixedRate(this.hUH, 0L, 300L);
    aDM();
    AppMethodBeat.o(141920);
  }
  
  private void aEc()
  {
    AppMethodBeat.i(137893);
    if (!d.aEl())
    {
      V(13000, "not support NFC");
      AppMethodBeat.o(137893);
      return;
    }
    if (!d.aEk())
    {
      V(13002, "not support HCE");
      AppMethodBeat.o(137893);
      return;
    }
    if (!d.aEm())
    {
      aEd();
      AppMethodBeat.o(137893);
      return;
    }
    aEf();
    AppMethodBeat.o(137893);
  }
  
  private void aEd()
  {
    AppMethodBeat.i(141921);
    if (this.hUJ == null)
    {
      ab.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
      AppMethodBeat.o(141921);
      return;
    }
    if (this.hUD)
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
      p(13001, "system NFC switch not opened", this.hUJ.getString(2131301370));
      AppMethodBeat.o(141921);
      return;
    }
    c.a locala = new c.a(this.hUJ);
    locala.avn(this.hUJ.getString(2131301372)).avs(this.hUJ.getString(2131301368)).a(new a.2(this));
    if (aEe()) {
      locala.avt(this.hUJ.getString(2131301355)).b(new a.3(this));
    }
    for (;;)
    {
      locala.e(new a.4(this));
      this.hUL = locala.aLZ();
      this.hUL.setCanceledOnTouchOutside(false);
      this.hUL.show();
      this.hUD = true;
      AppMethodBeat.o(141921);
      return;
      locala.avs(this.hUJ.getString(2131301356));
    }
  }
  
  private boolean aEe()
  {
    AppMethodBeat.i(141922);
    if (this.hUJ == null)
    {
      ab.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
      AppMethodBeat.o(141922);
      return false;
    }
    Object localObject = new Intent("android.settings.NFC_SETTINGS");
    localObject = this.hUJ.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + ((List)localObject).size());
      int i = 0;
      while (i < ((List)localObject).size())
      {
        ab.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", new Object[] { ((ResolveInfo)((List)localObject).get(i)).activityInfo.name });
        i += 1;
      }
      AppMethodBeat.o(141922);
      return true;
    }
    ab.e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
    AppMethodBeat.o(141922);
    return false;
  }
  
  @TargetApi(19)
  private void aEf()
  {
    AppMethodBeat.i(137894);
    if (this.hUJ == null)
    {
      ab.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(137894);
      return;
    }
    CardEmulation localCardEmulation = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.hUJ));
    ab.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.hUI);
    if (!localCardEmulation.isDefaultServiceForCategory(this.hUI, "payment"))
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[] { Boolean.TRUE });
      c(this.hUI);
      AppMethodBeat.o(137894);
      return;
    }
    ab.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
    W(0, "NFC switch has opened and now is NFC default application");
    AppMethodBeat.o(137894);
  }
  
  @TargetApi(19)
  private void c(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(137895);
    if (this.hUJ == null)
    {
      ab.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(137895);
      return;
    }
    ab.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[] { Boolean.valueOf(this.hUF) });
    if (this.hUF)
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
      p(13004, "not set default NFC application", this.hUJ.getString(2131301371));
      AppMethodBeat.o(137895);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141913);
        a.g(a.this);
        Intent localIntent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
        localIntent.putExtra("category", "payment");
        localIntent.putExtra("component", paramComponentName);
        e.at(a.h(a.this)).a(localIntent, new a.6.1(this));
        AppMethodBeat.o(141913);
      }
    }, 200L);
    AppMethodBeat.o(137895);
  }
  
  private void p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(137896);
    dismissDialog();
    if (this.hUJ == null)
    {
      ab.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
      AppMethodBeat.o(137896);
      return;
    }
    c.a locala = new c.a(this.hUJ);
    locala.avm("");
    locala.avn(paramString2);
    locala.avs(this.hUJ.getString(2131301356)).a(new a.7(this, paramInt, paramString1));
    locala.rG(true);
    this.hUL = locala.aLZ();
    this.hUL.setCanceledOnTouchOutside(false);
    this.hUL.show();
    AppMethodBeat.o(137896);
  }
  
  public final void a(Activity paramActivity, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(141915);
    ab.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
    if ((paramActivity == null) || (paramResultReceiver == null)) {
      ab.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
    }
    this.hUJ = paramActivity;
    this.Di = paramResultReceiver;
    AppMethodBeat.o(141915);
  }
  
  public final void aDZ()
  {
    AppMethodBeat.i(141919);
    if (this.hUE)
    {
      aEb();
      AppMethodBeat.o(141919);
      return;
    }
    aEc();
    AppMethodBeat.o(141919);
  }
  
  public final void aEa()
  {
    this.hUE = false;
    this.hUF = false;
    this.hUD = false;
  }
  
  public final void b(ComponentName paramComponentName)
  {
    AppMethodBeat.i(141916);
    ab.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
    this.hUI = paramComponentName;
    AppMethodBeat.o(141916);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(137897);
    if ((this.hUL != null) && (this.hUL.isShowing()))
    {
      this.hUL.dismiss();
      this.hUL = null;
    }
    aCV();
    AppMethodBeat.o(137897);
  }
  
  public final void oi(int paramInt)
  {
    AppMethodBeat.i(141918);
    if (paramInt == 1)
    {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
      this.hUE = true;
      AppMethodBeat.o(141918);
      return;
    }
    if (paramInt == 2) {
      ab.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
    }
    AppMethodBeat.o(141918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a
 * JD-Core Version:    0.7.0.1
 */