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
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI
  extends WalletBaseUI
  implements b
{
  private boolean isPaused = false;
  private Dialog mProgressDialog = null;
  private int skY = 0;
  private d slm = null;
  private Animation slo;
  private TextView slt;
  private a slu;
  private boolean slv = false;
  private final int slw = 1;
  
  private void cHO()
  {
    AppMethodBeat.i(64535);
    ac.i("MicroMsg.FingerPrintAuthUI", "request Identify2");
    this.slm.a(getContext(), new b()
    {
      public final void aZ(int paramAnonymousInt, String paramAnonymousString)
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
  
  private static void cHP()
  {
    AppMethodBeat.i(64536);
    ac.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64536);
  }
  
  private void cHT()
  {
    AppMethodBeat.i(64537);
    this.slm.a(this, 1);
    AppMethodBeat.o(64537);
  }
  
  private void dj(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(64541);
    this.slv = false;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64527);
        String str2 = paramString;
        String str1 = str2;
        if (bs.isNullOrNil(str2)) {
          str1 = FingerPrintAuthUI.this.getString(2131759409);
        }
        h.a(FingerPrintAuthUI.this, str1, "", FingerPrintAuthUI.this.getString(2131765291), false, new DialogInterface.OnClickListener()
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
  
  public final void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(64542);
    if (paramInt == 0)
    {
      ac.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
      doSceneProgress(new ad(null, 19), false);
      AppMethodBeat.o(64542);
      return;
    }
    ji(false);
    ac.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
    h.d(this, getString(2131759409), "", new DialogInterface.OnClickListener()
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
  
  protected final void ji(final boolean paramBoolean)
  {
    AppMethodBeat.i(64533);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64523);
        if (paramBoolean)
        {
          FingerPrintAuthUI.a(FingerPrintAuthUI.this, com.tencent.mm.wallet_core.ui.g.c(FingerPrintAuthUI.this, false, null));
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
    this.slt = ((TextView)findViewById(2131301035));
    paramBundle = (i)com.tencent.mm.kernel.g.ab(i.class);
    this.slm = paramBundle.cHG();
    if (this.slm == null)
    {
      dj(getString(2131759409), -1);
      AppMethodBeat.o(64532);
      return;
    }
    Object localObject = com.tencent.mm.wallet_core.a.bq(this);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("pwd");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ac.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
        dj(getString(2131759409), -1);
        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "get user pwd error");
        AppMethodBeat.o(64532);
      }
    }
    else
    {
      ac.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
      dj(getString(2131759409), -1);
      com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
      AppMethodBeat.o(64532);
      return;
    }
    if (!paramBundle.cHC())
    {
      dj(getString(2131765652), -1);
      AppMethodBeat.o(64532);
      return;
    }
    if (paramBundle.cHB())
    {
      ji(true);
      f.fDM().fDN();
      this.slm.a(this, new b()
      {
        public final void aZ(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64522);
          FingerPrintAuthUI.this.ji(false);
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
    ac.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
    AppMethodBeat.o(64532);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64539);
    ac.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
    if (this.slo != null) {
      this.slo.cancel();
    }
    this.slu = null;
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
    cHP();
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
    if (this.slv) {
      cHO();
    }
    AppMethodBeat.o(64534);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64540);
    if (this.slm.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
    {
      AppMethodBeat.o(64540);
      return true;
    }
    if ((paramn instanceof ad))
    {
      ji(false);
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
    private WeakReference<FingerPrintAuthUI> slA;
    
    public a(FingerPrintAuthUI paramFingerPrintAuthUI)
    {
      AppMethodBeat.i(64529);
      this.slA = null;
      this.slA = new WeakReference(paramFingerPrintAuthUI);
      AppMethodBeat.o(64529);
    }
    
    private FingerPrintAuthUI cHU()
    {
      AppMethodBeat.i(64530);
      if (this.slA != null)
      {
        FingerPrintAuthUI localFingerPrintAuthUI = (FingerPrintAuthUI)this.slA.get();
        AppMethodBeat.o(64530);
        return localFingerPrintAuthUI;
      }
      AppMethodBeat.o(64530);
      return null;
    }
    
    public final void fL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64531);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(64531);
        return;
        ac.i("MicroMsg.FingerPrintAuthUI", "identify success");
        if (cHU() != null)
        {
          FingerPrintAuthUI.a(cHU(), paramInt2);
          AppMethodBeat.o(64531);
          return;
          ac.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          if (cHU() != null)
          {
            FingerPrintAuthUI.a(cHU());
            FingerPrintAuthUI.a(FingerPrintAuthUI.this, true);
            AppMethodBeat.o(64531);
            return;
            ac.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
            if (cHU() != null)
            {
              FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
              AppMethodBeat.o(64531);
              return;
              String str = ai.getContext().getString(2131764097);
              com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
              if (cHU() != null)
              {
                FingerPrintAuthUI.a(cHU(), str, -1);
                AppMethodBeat.o(64531);
                return;
                ac.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = ai.getContext().getString(2131764095);
                if (paramInt1 == 10308)
                {
                  str = ai.getContext().getString(2131764096);
                  com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                }
                while (cHU() != null)
                {
                  FingerPrintAuthUI.a(cHU(), str, -1);
                  AppMethodBeat.o(64531);
                  return;
                  com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
                }
                ac.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramInt1) });
                str = ai.getContext().getString(2131764095);
                com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramInt1, "fingerprint error");
                com.tencent.mm.plugin.soter.d.a.Ql(2);
                if (cHU() != null) {
                  FingerPrintAuthUI.a(cHU(), str, -1);
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