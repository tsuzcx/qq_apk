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
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.j;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public final class a
{
  public static a mht;
  private ResultReceiver MU;
  private final Handler mHandler;
  private int mhj;
  private boolean mhk;
  private boolean mhl;
  private boolean mhm;
  private Timer mhn;
  private TimerTask mho;
  private ComponentName mhp;
  private Activity mhq;
  private j mhr;
  private com.tencent.mm.ui.widget.a.d mhs;
  
  static
  {
    AppMethodBeat.i(136154);
    mht = null;
    mht = new a();
    AppMethodBeat.o(136154);
  }
  
  public a()
  {
    AppMethodBeat.i(136130);
    this.mhj = 0;
    this.mhk = false;
    this.mhl = false;
    this.mhm = false;
    this.mhs = null;
    this.mHandler = new Handler();
    AppMethodBeat.o(136130);
  }
  
  private void am(int paramInt, String paramString)
  {
    AppMethodBeat.i(136145);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.MU.send(10001, localBundle);
    AppMethodBeat.o(136145);
  }
  
  private void an(int paramInt, String paramString)
  {
    AppMethodBeat.i(136146);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.MU.send(10001, localBundle);
    AppMethodBeat.o(136146);
  }
  
  private void bHN()
  {
    AppMethodBeat.i(136137);
    this.mho = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(136122);
        Log.i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", new Object[] { Integer.valueOf(a.a(a.this)) });
        a.b(a.this);
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136121);
            if (a.a(a.this) > 10)
            {
              Log.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", new Object[] { Integer.valueOf(10) });
              a.c(a.this);
              a.d(a.this);
              AppMethodBeat.o(136121);
              return;
            }
            if (com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHY())
            {
              Log.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
              a.c(a.this);
              a.e(a.this);
            }
            AppMethodBeat.o(136121);
          }
        });
        AppMethodBeat.o(136122);
      }
    };
    this.mhn = new Timer();
    this.mhn.scheduleAtFixedRate(this.mho, 0L, 300L);
    bHv();
    AppMethodBeat.o(136137);
  }
  
  private void bHO()
  {
    AppMethodBeat.i(136138);
    if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHX())
    {
      am(13000, "not support NFC");
      AppMethodBeat.o(136138);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHW())
    {
      am(13002, "not support HCE");
      AppMethodBeat.o(136138);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHY())
    {
      bHP();
      AppMethodBeat.o(136138);
      return;
    }
    bHR();
    AppMethodBeat.o(136138);
  }
  
  private void bHP()
  {
    AppMethodBeat.i(136139);
    if (this.mhq == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
      AppMethodBeat.o(136139);
      return;
    }
    if (this.mhk)
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
      q(13001, "system NFC switch not opened", this.mhq.getString(2131762791));
      AppMethodBeat.o(136139);
      return;
    }
    d.a locala = new d.a(this.mhq);
    locala.boo(this.mhq.getString(2131762793)).bou(this.mhq.getString(2131762789)).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(136123);
        a.f(a.this);
        AppMethodBeat.o(136123);
      }
    });
    if (bHQ()) {
      locala.bov(this.mhq.getString(2131762776)).d(new DialogInterface.OnClickListener()
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
      locala.f(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(136125);
          Log.i("MicroMsg.HCEActivityMgr", "alvinluo cancel by pressing back");
          a.a(a.this, "system NFC switch not opened");
          AppMethodBeat.o(136125);
        }
      });
      this.mhs = locala.hbn();
      this.mhs.setCanceledOnTouchOutside(false);
      this.mhs.show();
      this.mhk = true;
      AppMethodBeat.o(136139);
      return;
      locala.bou(this.mhq.getString(2131762777));
    }
  }
  
  private boolean bHQ()
  {
    AppMethodBeat.i(136140);
    if (this.mhq == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
      AppMethodBeat.o(136140);
      return false;
    }
    Object localObject = new Intent("android.settings.NFC_SETTINGS");
    localObject = this.mhq.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
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
  
  @TargetApi(19)
  private void bHR()
  {
    AppMethodBeat.i(136141);
    if (this.mhq == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(136141);
      return;
    }
    CardEmulation localCardEmulation = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this.mhq));
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo component name: " + this.mhp);
    if (!localCardEmulation.isDefaultServiceForCategory(this.mhp, "payment"))
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[] { Boolean.TRUE });
      c(this.mhp);
      AppMethodBeat.o(136141);
      return;
    }
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
    an(0, "NFC switch has opened and now is NFC default application");
    AppMethodBeat.o(136141);
  }
  
  private void bHv()
  {
    AppMethodBeat.i(136133);
    if (this.mhq != null)
    {
      this.mhr = j.b(this.mhq, this.mhq.getString(2131762778), false);
      AppMethodBeat.o(136133);
      return;
    }
    Log.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
    AppMethodBeat.o(136133);
  }
  
  private void biW()
  {
    AppMethodBeat.i(136134);
    if (this.mhr != null)
    {
      this.mhr.dismiss();
      this.mhr = null;
    }
    AppMethodBeat.o(136134);
  }
  
  @TargetApi(19)
  private void c(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(136142);
    if (this.mhq == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
      AppMethodBeat.o(136142);
      return;
    }
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[] { Boolean.valueOf(this.mhm) });
    if (this.mhm)
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
      q(13004, "not set default NFC application", this.mhq.getString(2131762792));
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
          f.aK(a.h(a.this)).a(localIntent, new f.b()
          {
            public final void a(int paramAnonymous2Int, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(136127);
              a.mht.xk(2);
              AppMethodBeat.o(136127);
            }
          });
          AppMethodBeat.o(136128);
          return;
        }
        Log.e("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication can not find activity");
        if (a.h(a.this) != null) {
          a.a(a.this, "not set default NFC application", a.h(a.this).getString(2131762792));
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
    if (this.mhq == null)
    {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
      AppMethodBeat.o(136143);
      return;
    }
    d.a locala = new d.a(this.mhq);
    locala.bon("");
    locala.boo(paramString2);
    locala.bou(this.mhq.getString(2131762777)).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(136129);
        a.a(a.this, paramInt, paramString1);
        AppMethodBeat.o(136129);
      }
    });
    locala.Dk(true);
    this.mhs = locala.hbn();
    this.mhs.setCanceledOnTouchOutside(false);
    this.mhs.show();
    AppMethodBeat.o(136143);
  }
  
  public final void a(Activity paramActivity, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(136131);
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
    if ((paramActivity == null) || (paramResultReceiver == null)) {
      Log.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
    }
    this.mhq = paramActivity;
    this.MU = paramResultReceiver;
    AppMethodBeat.o(136131);
  }
  
  public final void b(ComponentName paramComponentName)
  {
    AppMethodBeat.i(136132);
    Log.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
    this.mhp = paramComponentName;
    AppMethodBeat.o(136132);
  }
  
  public final void bHM()
  {
    AppMethodBeat.i(136136);
    if (this.mhl)
    {
      bHN();
      AppMethodBeat.o(136136);
      return;
    }
    bHO();
    AppMethodBeat.o(136136);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(136144);
    if ((this.mhs != null) && (this.mhs.isShowing()))
    {
      this.mhs.dismiss();
      this.mhs = null;
    }
    biW();
    AppMethodBeat.o(136144);
  }
  
  public final void resetStatus()
  {
    this.mhl = false;
    this.mhm = false;
    this.mhk = false;
  }
  
  public final void xk(int paramInt)
  {
    AppMethodBeat.i(136135);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
      this.mhl = true;
      AppMethodBeat.o(136135);
      return;
    }
    if (paramInt == 2) {
      Log.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
    }
    AppMethodBeat.o(136135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a
 * JD-Core Version:    0.7.0.1
 */