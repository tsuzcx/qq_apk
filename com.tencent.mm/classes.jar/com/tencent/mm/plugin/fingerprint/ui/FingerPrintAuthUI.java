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
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI
  extends WalletBaseUI
  implements b
{
  private boolean isPaused = false;
  private Dialog mProgressDialog = null;
  private d tsH = null;
  private Animation tsJ;
  private TextView tsO;
  private a tsP;
  private boolean tsQ = false;
  private final int tsR = 1;
  private int tst = 0;
  
  private void cSI()
  {
    AppMethodBeat.i(64535);
    ae.i("MicroMsg.FingerPrintAuthUI", "request Identify2");
    this.tsH.a(getContext(), new b()
    {
      public final void bb(int paramAnonymousInt, String paramAnonymousString)
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
  
  private static void cSJ()
  {
    AppMethodBeat.i(64536);
    ae.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64536);
  }
  
  private void cSN()
  {
    AppMethodBeat.i(64537);
    this.tsH.a(this, 1);
    AppMethodBeat.o(64537);
  }
  
  private void dD(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(64541);
    this.tsQ = false;
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64527);
        String str2 = paramString;
        String str1 = str2;
        if (bu.isNullOrNil(str2)) {
          str1 = FingerPrintAuthUI.this.getString(2131759409);
        }
        com.tencent.mm.ui.base.h.a(FingerPrintAuthUI.this, str1, "", FingerPrintAuthUI.this.getString(2131765291), false, new DialogInterface.OnClickListener()
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
  
  public final void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(64542);
    if (paramInt == 0)
    {
      ae.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
      doSceneProgress(new ad(null, 19), false);
      AppMethodBeat.o(64542);
      return;
    }
    js(false);
    ae.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
    com.tencent.mm.ui.base.h.d(this, getString(2131759409), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64528);
        com.tencent.mm.wallet_core.a.b(FingerPrintAuthUI.this, new Bundle(), -1);
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
    return 2131494135;
  }
  
  protected final void js(final boolean paramBoolean)
  {
    AppMethodBeat.i(64533);
    ar.f(new Runnable()
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
    setMMTitle(getString(2131761801));
    this.tsO = ((TextView)findViewById(2131301035));
    paramBundle = (i)g.ab(i.class);
    this.tsH = paramBundle.cSA();
    if (this.tsH == null)
    {
      dD(getString(2131759409), -1);
      AppMethodBeat.o(64532);
      return;
    }
    Object localObject = com.tencent.mm.wallet_core.a.br(this);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("pwd");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ae.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
        dD(getString(2131759409), -1);
        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "get user pwd error");
        AppMethodBeat.o(64532);
      }
    }
    else
    {
      ae.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
      dD(getString(2131759409), -1);
      com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
      AppMethodBeat.o(64532);
      return;
    }
    if (!paramBundle.cSw())
    {
      dD(getString(2131765652), -1);
      AppMethodBeat.o(64532);
      return;
    }
    if (paramBundle.cSv())
    {
      js(true);
      f.fZD().fZE();
      this.tsH.a(this, new b()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64522);
          FingerPrintAuthUI.this.js(false);
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
    ae.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
    AppMethodBeat.o(64532);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64539);
    ae.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
    if (this.tsJ != null) {
      this.tsJ.cancel();
    }
    this.tsP = null;
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
    cSJ();
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
    if (this.tsQ) {
      cSI();
    }
    AppMethodBeat.o(64534);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64540);
    if (this.tsH.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
    {
      AppMethodBeat.o(64540);
      return true;
    }
    if ((paramn instanceof ad))
    {
      js(false);
      com.tencent.mm.wallet_core.a.b(this, new Bundle(), 0);
      Toast.makeText(this, 2131759410, 0).show();
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
    private WeakReference<FingerPrintAuthUI> tsV;
    
    public a(FingerPrintAuthUI paramFingerPrintAuthUI)
    {
      AppMethodBeat.i(64529);
      this.tsV = null;
      this.tsV = new WeakReference(paramFingerPrintAuthUI);
      AppMethodBeat.o(64529);
    }
    
    private FingerPrintAuthUI cSO()
    {
      AppMethodBeat.i(64530);
      if (this.tsV != null)
      {
        FingerPrintAuthUI localFingerPrintAuthUI = (FingerPrintAuthUI)this.tsV.get();
        AppMethodBeat.o(64530);
        return localFingerPrintAuthUI;
      }
      AppMethodBeat.o(64530);
      return null;
    }
    
    public final void gb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64531);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(64531);
        return;
        ae.i("MicroMsg.FingerPrintAuthUI", "identify success");
        if (cSO() != null)
        {
          FingerPrintAuthUI.a(cSO(), paramInt2);
          AppMethodBeat.o(64531);
          return;
          ae.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          if (cSO() != null)
          {
            FingerPrintAuthUI.a(cSO());
            FingerPrintAuthUI.a(FingerPrintAuthUI.this, true);
            AppMethodBeat.o(64531);
            return;
            ae.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
            if (cSO() != null)
            {
              FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
              AppMethodBeat.o(64531);
              return;
              String str = ak.getContext().getString(2131764097);
              com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
              if (cSO() != null)
              {
                FingerPrintAuthUI.a(cSO(), str, -1);
                AppMethodBeat.o(64531);
                return;
                ae.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = ak.getContext().getString(2131764095);
                if (paramInt1 == 10308)
                {
                  str = ak.getContext().getString(2131764096);
                  com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                }
                while (cSO() != null)
                {
                  FingerPrintAuthUI.a(cSO(), str, -1);
                  AppMethodBeat.o(64531);
                  return;
                  com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
                }
                ae.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = ak.getContext().getString(2131764095);
                com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
                com.tencent.mm.plugin.soter.d.a.SA(2);
                if (cSO() != null) {
                  FingerPrintAuthUI.a(cSO(), str, -1);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI
 * JD-Core Version:    0.7.0.1
 */