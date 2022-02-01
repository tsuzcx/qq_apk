package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nm.a;
import com.tencent.mm.g.a.nm.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Map;

public final class c
  extends a
{
  private String dlK;
  private String rbE;
  private a rbF;
  private com.tencent.mm.plugin.fingerprint.d.c rbG;
  
  public c()
  {
    AppMethodBeat.i(64295);
    this.rbF = new a((byte)0);
    this.rbG = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(p.rcp.rcq, (byte)0);
    this.rbB.a(aj.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            c.a(c.this, paramAnonymousc.dlK);
            c.b(c.this, paramAnonymousc.dlL);
          }
          paramc.fE(paramAnonymousc.errCode, paramAnonymousc.dlI);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(nm paramnm, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.dlK))
    {
      ad.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.rbE)) {
        break label147;
      }
      ad.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      ad.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramnm != null) && (paramnm.dsz.dsD != null))
      {
        nm.b localb = new nm.b();
        localb.dsF = type();
        localb.errCode = 0;
        localb.dlK = this.dlK;
        localb.dlL = this.rbE;
        localb.dlI = paramInt;
        paramnm.dsA = localb;
        paramnm.dsz.dsD.run();
      }
      this.dlK = "";
      this.rbE = "";
      AppMethodBeat.o(64302);
      return;
      ad.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
      break;
      label147:
      ad.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean ctS()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.rbB.eO(aj.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean ctT()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.rbB.cuq();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void ctU()
  {
    AppMethodBeat.i(64299);
    ad.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.rbB.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean ctV()
  {
    return true;
  }
  
  public final boolean ctW()
  {
    AppMethodBeat.i(64300);
    boolean bool = d.ctW();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final Map<String, String> ctX()
  {
    return null;
  }
  
  public final Map<String, String> ctY()
  {
    return null;
  }
  
  public final boolean ctZ()
  {
    return true;
  }
  
  public final boolean cua()
  {
    return false;
  }
  
  public final boolean cub()
  {
    return false;
  }
  
  public final void eL(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.rbB.cut();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.rbB.cancel();
    AppMethodBeat.o(64303);
  }
  
  final class a
    implements a.b
  {
    private a() {}
    
    public final void D(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(64294);
      if (c.a(c.this) != null) {
        c.a(c.this).fE(paramInt1, paramInt2);
      }
      AppMethodBeat.o(64294);
    }
    
    public final void bR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64293);
      if (c.a(c.this) != null) {
        c.a(c.this);
      }
      AppMethodBeat.o(64293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.c
 * JD-Core Version:    0.7.0.1
 */