package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.soter.a.g.f;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI
  extends WalletBaseUI
  implements b
{
  private int ByW = 0;
  private d Bzj = null;
  private Animation Bzl;
  private TextView Bzq;
  private a Bzr;
  private boolean Bzs = false;
  private final int Bzt = 1;
  private boolean isPaused = false;
  private Dialog mProgressDialog = null;
  
  private void epc()
  {
    AppMethodBeat.i(64535);
    Log.i("MicroMsg.FingerPrintAuthUI", "request Identify2");
    this.Bzj.a(getContext(), new b()
    {
      public final void bh(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64524);
        if (paramAnonymousInt == 0)
        {
          FingerPrintAuthUI.f(FingerPrintAuthUI.this);
          AppMethodBeat.o(64524);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          FingerPrintAuthUI.a(FingerPrintAuthUI.this);
          AppMethodBeat.o(64524);
          return;
        }
        if (paramAnonymousInt == -3)
        {
          FingerPrintAuthUI.b(FingerPrintAuthUI.this, paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(64524);
          return;
        }
        FingerPrintAuthUI.a(FingerPrintAuthUI.this, paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(64524);
      }
    });
    AppMethodBeat.o(64535);
  }
  
  private static void epd()
  {
    AppMethodBeat.i(64536);
    Log.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64536);
  }
  
  private void eph()
  {
    AppMethodBeat.i(64537);
    this.Bzj.a(this, 1);
    AppMethodBeat.o(64537);
  }
  
  private void eq(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(64541);
    this.Bzs = false;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64527);
        String str2 = paramString;
        String str1 = str2;
        if (Util.isNullOrNil(str2)) {
          str1 = FingerPrintAuthUI.this.getString(a.i.fingerprint_open_fail);
        }
        com.tencent.mm.ui.base.h.a(FingerPrintAuthUI.this, str1, "", FingerPrintAuthUI.this.getString(a.i.wallet_i_know_it), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(64526);
            com.tencent.mm.wallet_core.a.b(FingerPrintAuthUI.this, new Bundle(), FingerPrintAuthUI.5.this.val$errCode);
            AppMethodBeat.o(64526);
          }
        });
        AppMethodBeat.o(64527);
      }
    });
    AppMethodBeat.o(64541);
  }
  
  public final void bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(64542);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
      doSceneProgress(new ae(null, 19), false);
      AppMethodBeat.o(64542);
      return;
    }
    lG(false);
    Log.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
    com.tencent.mm.ui.base.h.d(this, getString(a.i.fingerprint_open_fail), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(271961);
        com.tencent.mm.wallet_core.a.b(FingerPrintAuthUI.this, new Bundle(), -1);
        AppMethodBeat.o(271961);
      }
    });
    AppMethodBeat.o(64542);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.fingerprint_authorize_layout;
  }
  
  protected final void lG(final boolean paramBoolean)
  {
    AppMethodBeat.i(64533);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64523);
        if (paramBoolean)
        {
          FingerPrintAuthUI.a(FingerPrintAuthUI.this, com.tencent.mm.wallet_core.ui.i.c(FingerPrintAuthUI.this, false, null));
          AppMethodBeat.o(64523);
          return;
        }
        if ((FingerPrintAuthUI.e(FingerPrintAuthUI.this) != null) && (FingerPrintAuthUI.e(FingerPrintAuthUI.this).isShowing()))
        {
          FingerPrintAuthUI.e(FingerPrintAuthUI.this).dismiss();
          FingerPrintAuthUI.a(FingerPrintAuthUI.this, null);
        }
        AppMethodBeat.o(64523);
      }
    });
    AppMethodBeat.o(64533);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64532);
    super.onCreate(paramBundle);
    setMMTitle(getString(a.i.open_fingerprint_auth_title));
    this.Bzq = ((TextView)findViewById(a.f.input_tips));
    paramBundle = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    this.Bzj = paramBundle.eoU();
    if (this.Bzj == null)
    {
      eq(getString(a.i.fingerprint_open_fail), -1);
      AppMethodBeat.o(64532);
      return;
    }
    Object localObject = com.tencent.mm.wallet_core.a.bE(this);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("pwd");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
        eq(getString(a.i.fingerprint_open_fail), -1);
        com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, -1, "get user pwd error");
        AppMethodBeat.o(64532);
      }
    }
    else
    {
      Log.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
      eq(getString(a.i.fingerprint_open_fail), -1);
      com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
      AppMethodBeat.o(64532);
      return;
    }
    if (!paramBundle.eoQ())
    {
      eq(getString(a.i.wallet_password_setting_ui_set_sys_fp_guide_text), -1);
      AppMethodBeat.o(64532);
      return;
    }
    if (paramBundle.eoP())
    {
      lG(true);
      f.ipn().ipo();
      this.Bzj.a(this, new b()
      {
        public final void bh(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64522);
          FingerPrintAuthUI.this.lG(false);
          if (paramAnonymousInt == 0)
          {
            FingerPrintAuthUI.b(FingerPrintAuthUI.this);
            if (FingerPrintAuthUI.c(FingerPrintAuthUI.this))
            {
              FingerPrintAuthUI.d(FingerPrintAuthUI.this);
              AppMethodBeat.o(64522);
            }
          }
          else
          {
            FingerPrintAuthUI.a(FingerPrintAuthUI.this, paramAnonymousString, paramAnonymousInt);
          }
          AppMethodBeat.o(64522);
        }
      }, (String)localObject);
      AppMethodBeat.o(64532);
      return;
    }
    Log.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
    AppMethodBeat.o(64532);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64539);
    Log.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
    if (this.Bzl != null) {
      this.Bzl.cancel();
    }
    this.Bzr = null;
    super.onDestroy();
    AppMethodBeat.o(64539);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64538);
    super.onPause();
    this.isPaused = true;
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null)
    {
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      localWakeLock.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    epd();
    if (localWakeLock != null)
    {
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(64538);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64534);
    super.onResume();
    this.isPaused = false;
    if (this.Bzs) {
      epc();
    }
    AppMethodBeat.o(64534);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64540);
    if (this.Bzj.onSceneEnd(paramInt1, paramInt2, paramString, paramq))
    {
      AppMethodBeat.o(64540);
      return true;
    }
    if ((paramq instanceof ae))
    {
      lG(false);
      com.tencent.mm.wallet_core.a.b(this, new Bundle(), 0);
      Toast.makeText(this, a.i.fingerprint_open_success, 0).show();
      AppMethodBeat.o(64540);
      return true;
    }
    AppMethodBeat.o(64540);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    implements c
  {
    private WeakReference<FingerPrintAuthUI> Bzx;
    
    public a(FingerPrintAuthUI paramFingerPrintAuthUI)
    {
      AppMethodBeat.i(64529);
      this.Bzx = null;
      this.Bzx = new WeakReference(paramFingerPrintAuthUI);
      AppMethodBeat.o(64529);
    }
    
    private FingerPrintAuthUI epi()
    {
      AppMethodBeat.i(64530);
      if (this.Bzx != null)
      {
        FingerPrintAuthUI localFingerPrintAuthUI = (FingerPrintAuthUI)this.Bzx.get();
        AppMethodBeat.o(64530);
        return localFingerPrintAuthUI;
      }
      AppMethodBeat.o(64530);
      return null;
    }
    
    public final void hu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64531);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(64531);
        return;
        Log.i("MicroMsg.FingerPrintAuthUI", "identify success");
        if (epi() != null)
        {
          FingerPrintAuthUI.a(epi(), paramInt2);
          AppMethodBeat.o(64531);
          return;
          Log.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          if (epi() != null)
          {
            FingerPrintAuthUI.a(epi());
            FingerPrintAuthUI.a(FingerPrintAuthUI.this, true);
            AppMethodBeat.o(64531);
            return;
            Log.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
            if (epi() != null)
            {
              FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
              AppMethodBeat.o(64531);
              return;
              String str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
              com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramInt1, "fingerprint error");
              if (epi() != null)
              {
                FingerPrintAuthUI.a(epi(), str, -1);
                AppMethodBeat.o(64531);
                return;
                Log.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
                if (paramInt1 == 10308)
                {
                  str = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial);
                  com.tencent.mm.plugin.soter.d.a.c(6, -1000223, -1, "too many trial");
                }
                while (epi() != null)
                {
                  FingerPrintAuthUI.a(epi(), str, -1);
                  AppMethodBeat.o(64531);
                  return;
                  com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramInt1, "fingerprint error");
                }
                Log.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
                com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramInt1, "fingerprint error");
                com.tencent.mm.plugin.soter.d.a.ahQ(2);
                if (epi() != null) {
                  FingerPrintAuthUI.a(epi(), str, -1);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI
 * JD-Core Version:    0.7.0.1
 */