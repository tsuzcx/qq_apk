package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI
  extends WalletBaseUI
  implements b
{
  private boolean isPaused = false;
  private Dialog mProgressDialog = null;
  private int wFZ = 0;
  private d wGn = null;
  private Animation wGp;
  private TextView wGu;
  private a wGv;
  private boolean wGw = false;
  private final int wGx = 1;
  
  private void dKD()
  {
    AppMethodBeat.i(64535);
    Log.i("MicroMsg.FingerPrintAuthUI", "request Identify2");
    this.wGn.a(getContext(), new b()
    {
      public final void bg(int paramAnonymousInt, String paramAnonymousString)
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
        FingerPrintAuthUI.a(FingerPrintAuthUI.this, paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(64524);
      }
    });
    AppMethodBeat.o(64535);
  }
  
  private static void dKE()
  {
    AppMethodBeat.i(64536);
    Log.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64536);
  }
  
  private void dKI()
  {
    AppMethodBeat.i(64537);
    this.wGn.a(this, 1);
    AppMethodBeat.o(64537);
  }
  
  private void dS(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(64541);
    this.wGw = false;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64527);
        String str2 = paramString;
        String str1 = str2;
        if (Util.isNullOrNil(str2)) {
          str1 = FingerPrintAuthUI.this.getString(2131760697);
        }
        com.tencent.mm.ui.base.h.a(FingerPrintAuthUI.this, str1, "", FingerPrintAuthUI.this.getString(2131767734), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(64526);
            com.tencent.mm.wallet_core.a.c(FingerPrintAuthUI.this, new Bundle(), FingerPrintAuthUI.5.this.val$errCode);
            AppMethodBeat.o(64526);
          }
        });
        AppMethodBeat.o(64527);
      }
    });
    AppMethodBeat.o(64541);
  }
  
  public final void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(64542);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
      doSceneProgress(new ad(null, 19), false);
      AppMethodBeat.o(64542);
      return;
    }
    ku(false);
    Log.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
    com.tencent.mm.ui.base.h.d(this, getString(2131760697), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64528);
        com.tencent.mm.wallet_core.a.c(FingerPrintAuthUI.this, new Bundle(), -1);
        AppMethodBeat.o(64528);
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
    return 2131494689;
  }
  
  protected final void ku(final boolean paramBoolean)
  {
    AppMethodBeat.i(64533);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64523);
        if (paramBoolean)
        {
          FingerPrintAuthUI.a(FingerPrintAuthUI.this, com.tencent.mm.wallet_core.ui.h.c(FingerPrintAuthUI.this, false, null));
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
    setMMTitle(getString(2131763772));
    this.wGu = ((TextView)findViewById(2131302685));
    paramBundle = (i)g.af(i.class);
    this.wGn = paramBundle.dKv();
    if (this.wGn == null)
    {
      dS(getString(2131760697), -1);
      AppMethodBeat.o(64532);
      return;
    }
    Object localObject = com.tencent.mm.wallet_core.a.bx(this);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("pwd");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
        dS(getString(2131760697), -1);
        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "get user pwd error");
        AppMethodBeat.o(64532);
      }
    }
    else
    {
      Log.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
      dS(getString(2131760697), -1);
      com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
      AppMethodBeat.o(64532);
      return;
    }
    if (!paramBundle.dKr())
    {
      dS(getString(2131768105), -1);
      AppMethodBeat.o(64532);
      return;
    }
    if (paramBundle.dKq())
    {
      ku(true);
      f.hlO().hlP();
      this.wGn.a(this, new b()
      {
        public final void bg(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64522);
          FingerPrintAuthUI.this.ku(false);
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
    if (this.wGp != null) {
      this.wGp.cancel();
    }
    this.wGv = null;
    super.onDestroy();
    AppMethodBeat.o(64539);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64538);
    super.onPause();
    this.isPaused = true;
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    dKE();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(64538);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64534);
    super.onResume();
    this.isPaused = false;
    if (this.wGw) {
      dKD();
    }
    AppMethodBeat.o(64534);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64540);
    if (this.wGn.onSceneEnd(paramInt1, paramInt2, paramString, paramq))
    {
      AppMethodBeat.o(64540);
      return true;
    }
    if ((paramq instanceof ad))
    {
      ku(false);
      com.tencent.mm.wallet_core.a.c(this, new Bundle(), 0);
      Toast.makeText(this, 2131760698, 0).show();
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
    private WeakReference<FingerPrintAuthUI> wGB;
    
    public a(FingerPrintAuthUI paramFingerPrintAuthUI)
    {
      AppMethodBeat.i(64529);
      this.wGB = null;
      this.wGB = new WeakReference(paramFingerPrintAuthUI);
      AppMethodBeat.o(64529);
    }
    
    private FingerPrintAuthUI dKJ()
    {
      AppMethodBeat.i(64530);
      if (this.wGB != null)
      {
        FingerPrintAuthUI localFingerPrintAuthUI = (FingerPrintAuthUI)this.wGB.get();
        AppMethodBeat.o(64530);
        return localFingerPrintAuthUI;
      }
      AppMethodBeat.o(64530);
      return null;
    }
    
    public final void gz(int paramInt1, int paramInt2)
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
        if (dKJ() != null)
        {
          FingerPrintAuthUI.a(dKJ(), paramInt2);
          AppMethodBeat.o(64531);
          return;
          Log.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          if (dKJ() != null)
          {
            FingerPrintAuthUI.a(dKJ());
            FingerPrintAuthUI.a(FingerPrintAuthUI.this, true);
            AppMethodBeat.o(64531);
            return;
            Log.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
            if (dKJ() != null)
            {
              FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
              AppMethodBeat.o(64531);
              return;
              String str = MMApplicationContext.getContext().getString(2131766339);
              com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
              if (dKJ() != null)
              {
                FingerPrintAuthUI.a(dKJ(), str, -1);
                AppMethodBeat.o(64531);
                return;
                Log.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = MMApplicationContext.getContext().getString(2131766337);
                if (paramInt1 == 10308)
                {
                  str = MMApplicationContext.getContext().getString(2131766338);
                  com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                }
                while (dKJ() != null)
                {
                  FingerPrintAuthUI.a(dKJ(), str, -1);
                  AppMethodBeat.o(64531);
                  return;
                  com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
                }
                Log.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = MMApplicationContext.getContext().getString(2131766337);
                com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
                com.tencent.mm.plugin.soter.d.a.aaw(2);
                if (dKJ() != null) {
                  FingerPrintAuthUI.a(dKJ(), str, -1);
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