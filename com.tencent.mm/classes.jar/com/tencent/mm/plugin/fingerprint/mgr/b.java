package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rg;
import com.tencent.mm.autogen.a.rg.a;
import com.tencent.mm.autogen.a.rg.b;
import com.tencent.mm.plugin.fingerprint.mgr.a.f;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class b
  extends a
{
  private String HfA;
  private a HfB;
  private com.tencent.mm.plugin.fingerprint.c.c HfC;
  private String hMz;
  
  public b()
  {
    AppMethodBeat.i(64295);
    this.HfB = new a((byte)0);
    this.HfC = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.c.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.c.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(j.Hgj.Hgk, (byte)0);
    this.Hfx.a(MMApplicationContext.getContext(), localf, new com.tencent.mm.plugin.fingerprint.mgr.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.mgr.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            b.a(b.this, paramAnonymousc.hMz);
            b.b(b.this, paramAnonymousc.hMA);
          }
          paramc.iP(paramAnonymousc.errCode, paramAnonymousc.hMx);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(rg paramrg, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.hMz))
    {
      Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.HfA)) {
        break label147;
      }
      Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      Log.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramrg != null) && (paramrg.hUl.hUp != null))
      {
        rg.b localb = new rg.b();
        localb.hUr = type();
        localb.errCode = 0;
        localb.hMz = this.hMz;
        localb.hMA = this.HfA;
        localb.hMx = paramInt;
        paramrg.hUm = localb;
        paramrg.hUl.hUp.run();
      }
      this.hMz = "";
      this.HfA = "";
      AppMethodBeat.o(64302);
      return;
      Log.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
      break;
      label147:
      Log.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    return false;
  }
  
  public final Map<String, String> ftA()
  {
    return null;
  }
  
  public final Map<String, String> ftB()
  {
    return null;
  }
  
  public final boolean ftC()
  {
    return true;
  }
  
  public final boolean ftD()
  {
    return false;
  }
  
  public final boolean ftE()
  {
    return false;
  }
  
  public final boolean ftv()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.Hfx.hC(MMApplicationContext.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean ftw()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.Hfx.ftS();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void ftx()
  {
    AppMethodBeat.i(64299);
    Log.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.Hfx.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean fty()
  {
    return true;
  }
  
  public final boolean ftz()
  {
    AppMethodBeat.i(64300);
    boolean bool = c.ftz();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final void hz(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final boolean isRoot()
  {
    return false;
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.Hfx.ftV();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.Hfx.cancel();
    AppMethodBeat.o(64303);
  }
  
  final class a
    implements a.b
  {
    private a() {}
    
    public final void V(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(64294);
      if (b.a(b.this) != null) {
        b.a(b.this).iP(paramInt1, paramInt2);
      }
      AppMethodBeat.o(64294);
    }
    
    public final void cV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64293);
      if (b.a(b.this) != null) {
        b.a(b.this);
      }
      AppMethodBeat.o(64293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.b
 * JD-Core Version:    0.7.0.1
 */