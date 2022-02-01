package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
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
import android.os.ResultReceiver;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.i;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public final class a
{
  public static a kbz;
  private ResultReceiver JX;
  private int kbp;
  private boolean kbq;
  private boolean kbr;
  private boolean kbs;
  private Timer kbt;
  private TimerTask kbu;
  private ComponentName kbv;
  private Activity kbw;
  private i kbx;
  private com.tencent.mm.ui.widget.a.d kby;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(136154);
    kbz = null;
    kbz = new a();
    AppMethodBeat.o(136154);
  }
  
  public a()
  {
    AppMethodBeat.i(136130);
    this.kbp = 0;
    this.kbq = false;
    this.kbr = false;
    this.kbs = false;
    this.kby = null;
    this.mHandler = new Handler();
    AppMethodBeat.o(136130);
  }
  
  private void aEr()
  {
    AppMethodBeat.i(136134);
    if (this.kbx != null)
    {
      this.kbx.dismiss();
      this.kbx = null;
    }
    AppMethodBeat.o(136134);
  }
  
  private void ag(int paramInt, String paramString)
  {
    AppMethodBeat.i(136145);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.JX.send(10001, localBundle);
    AppMethodBeat.o(136145);
  }
  
  private void ah(int paramInt, String paramString)
  {
    AppMethodBeat.i(136146);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.JX.send(10001, localBundle);
    AppMethodBeat.o(136146);
  }
  
  private void baM()
  {
    AppMethodBeat.i(136133);
    if (this.kbw != null)
    {
      this.kbx = i.c(this.kbw, this.kbw.getString(2131761002), false);
      AppMethodBeat.o(136133);
      return;
    }
    ad.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
    AppMethodBeat.o(136133);
  }
  
  private void bbd()
  {
    AppMethodBeat.i(136137);
    this.kbu = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(136122);
        ad.i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", new Object[] { Integer.valueOf(a.a(a.this)) });
        a.b(a.this);
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136121);
            if (a.a(a.this) > 10)
            {
              ad.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", new Object[] { Integer.valueOf(10) });
              a.c(a.this);
              a.d(a.this);
              AppMethodBeat.o(136121);
              return;
            }
            if (com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bbo())
            {
              ad.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
              a.c(a.this);
              a.e(a.this);
            }
            AppMethodBeat.o(136121);
          }
        });
        AppMethodBeat.o(136122);
      }
    };
    this.kbt = new Timer();
    this.kbt.scheduleAtFixedRate(this.kbu, 0L, 300L);
    baM();
    AppMethodBeat.o(136137);
  }
  
  private void bbe()
  {
    AppMethodBeat.i(136138);
    if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bbn())
    {
      ag(13000, "not support NFC");
      AppMethodBeat.o(136138);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bbm())
    {
      ag(13002, "not support HCE");
      AppMethodBeat.o(136138);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bbo())
    {
      bbf();
      AppMethodBeat.o(136138);
      return;
    }
    bbh();
    AppMethodBeat.o(136138);
  }
  
  private void bbf()
  {
    AppMethodBeat.i(136139);
    if (this.kbw == null)
    {
      ad.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
      AppMethodBeat.o(136139);
      return;
    }
    if (this.kbq)
    {
      ad.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
      q(13001, "system NFC switch not opened", this.kbw.getString(2131761015));
      AppMethodBeat.o(136139);
      return;
    }
    d.a locala = new d.a(this.kbw);
    locala.aMg(this.kbw.getString(2131761017)).aMm(this.kbw.getString(2131761013)).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(136123);
        a.f(a.this);
        AppMethodBeat.o(136123);
      }
    });
    if (bbg()) {
      locala.aMn(this.kbw.getString(2131761000)).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(136124);
          ad.i("MicroMsg.HCEActivityMgr", "alvinluo user click cancel button of NFC tips dialog.");
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
          ad.i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
          a.a(a.this, "system NFC switch not opened");
          AppMethodBeat.o(136125);
        }
      });
      this.kby = locala.fft();
      this.kby.setCanceledOnTouchOutside(false);
      this.kby.show();
      this.kbq = true;
      AppMethodBeat.o(136139);
      return;
      locala.aMm(this.kbw.getString(2131761001));
    }
  }
  
  private boolean bbg()
  {
    AppMethodBeat.i(136140);
    if (this.kbw == null)
    {
      ad.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
      AppMethodBeat.o(136140);
      return false;
    }
    Object localObject = new Intent("android.settings.NFC_SETTINGS");
    localObject = this.kbw.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ad.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity not null, activities size: " + ((List)localObject).size());
      int i = 0;
      while (i < ((List)localObject).size())
      {
        ad.i("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", new Object[] { ((ResolveInfo)((List)localObject).get(i)).activityInfo.name });
        i += 1;
      }
      AppMethodBeat.o(136140);
      return true;
    }
    ad.e("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
    AppMethodBeat.o(136140);
    return false;
  }
  
  @TargetApi(19)
  private void bbh()
  {
    AppMethodBeat.i(136141);
    if (this.kbw == null)
    {
      ad.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(136141);
      return;
    }
    CardEmulation localCardEmulation = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.kbw));
    ad.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.kbv);
    if (!localCardEmulation.isDefaultServiceForCategory(this.kbv, "payment"))
    {
      ad.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[] { Boolean.TRUE });
      c(this.kbv);
      AppMethodBeat.o(136141);
      return;
    }
    ad.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
    ah(0, "NFC switch has opened and now is NFC default application");
    AppMethodBeat.o(136141);
  }
  
  @TargetApi(19)
  private void c(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(136142);
    if (this.kbw == null)
    {
      ad.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(136142);
      return;
    }
    ad.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[] { Boolean.valueOf(this.kbs) });
    if (this.kbs)
    {
      ad.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
      q(13004, "not set default NFC application", this.kbw.getString(2131761016));
      AppMethodBeat.o(136142);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136128);
        a.g(a.this);
        Intent localIntent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
        localIntent.putExtra("category", "payment");
        localIntent.putExtra("component", paramComponentName);
        if ((a.h(a.this) != null) && (localIntent.resolveActivity(a.h(a.this).getPackageManager()) != null))
        {
          e.az(a.h(a.this)).a(localIntent, new e.a()
          {
            public final void a(int paramAnonymous2Int, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(136127);
              a.kbz.rS(2);
              AppMethodBeat.o(136127);
            }
          });
          AppMethodBeat.o(136128);
          return;
        }
        ad.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication can not find activity");
        if (a.h(a.this) != null) {
          a.a(a.this, "not set default NFC application", a.h(a.this).getString(2131761016));
        }
        AppMethodBeat.o(136128);
      }
    }, 200L);
    AppMethodBeat.o(136142);
  }
  
  private void q(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(136143);
    dismissDialog();
    if (this.kbw == null)
    {
      ad.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
      AppMethodBeat.o(136143);
      return;
    }
    d.a locala = new d.a(this.kbw);
    locala.aMf("");
    locala.aMg(paramString2);
    locala.aMm(this.kbw.getString(2131761001)).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(136129);
        a.a(a.this, paramInt, paramString1);
        AppMethodBeat.o(136129);
      }
    });
    locala.wX(true);
    this.kby = locala.fft();
    this.kby.setCanceledOnTouchOutside(false);
    this.kby.show();
    AppMethodBeat.o(136143);
  }
  
  public final void a(Activity paramActivity, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(136131);
    ad.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
    if ((paramActivity == null) || (paramResultReceiver == null)) {
      ad.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
    }
    this.kbw = paramActivity;
    this.JX = paramResultReceiver;
    AppMethodBeat.o(136131);
  }
  
  public final void b(ComponentName paramComponentName)
  {
    AppMethodBeat.i(136132);
    ad.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
    this.kbv = paramComponentName;
    AppMethodBeat.o(136132);
  }
  
  public final void bbc()
  {
    AppMethodBeat.i(136136);
    if (this.kbr)
    {
      bbd();
      AppMethodBeat.o(136136);
      return;
    }
    bbe();
    AppMethodBeat.o(136136);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(136144);
    if ((this.kby != null) && (this.kby.isShowing()))
    {
      this.kby.dismiss();
      this.kby = null;
    }
    aEr();
    AppMethodBeat.o(136144);
  }
  
  public final void rS(int paramInt)
  {
    AppMethodBeat.i(136135);
    if (paramInt == 1)
    {
      ad.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
      this.kbr = true;
      AppMethodBeat.o(136135);
      return;
    }
    if (paramInt == 2) {
      ad.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
    }
    AppMethodBeat.o(136135);
  }
  
  public final void resetStatus()
  {
    this.kbr = false;
    this.kbs = false;
    this.kbq = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a
 * JD-Core Version:    0.7.0.1
 */