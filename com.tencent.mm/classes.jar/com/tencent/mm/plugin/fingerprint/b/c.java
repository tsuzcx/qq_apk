package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.nv.a;
import com.tencent.mm.g.a.nv.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Map;

public final class c
  extends a
{
  private String djs;
  private String sjY;
  private a sjZ;
  private com.tencent.mm.plugin.fingerprint.d.c ska;
  
  public c()
  {
    AppMethodBeat.i(64295);
    this.sjZ = new a((byte)0);
    this.ska = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(p.skJ.skK, (byte)0);
    this.sjV.a(ai.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            c.a(c.this, paramAnonymousc.djs);
            c.b(c.this, paramAnonymousc.djt);
          }
          paramc.fL(paramAnonymousc.errCode, paramAnonymousc.djq);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(nv paramnv, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.djs))
    {
      ac.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.sjY)) {
        break label147;
      }
      ac.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      ac.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramnv != null) && (paramnv.dqj.dqn != null))
      {
        nv.b localb = new nv.b();
        localb.dqp = type();
        localb.errCode = 0;
        localb.djs = this.djs;
        localb.djt = this.sjY;
        localb.djq = paramInt;
        paramnv.dqk = localb;
        paramnv.dqj.dqn.run();
      }
      this.djs = "";
      this.sjY = "";
      AppMethodBeat.o(64302);
      return;
      ac.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
      break;
      label147:
      ac.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean cHe()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.sjV.fb(ai.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean cHf()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.sjV.cHC();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void cHg()
  {
    AppMethodBeat.i(64299);
    ac.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.sjV.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean cHh()
  {
    return true;
  }
  
  public final boolean cHi()
  {
    AppMethodBeat.i(64300);
    boolean bool = d.cHi();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final Map<String, String> cHj()
  {
    return null;
  }
  
  public final Map<String, String> cHk()
  {
    return null;
  }
  
  public final boolean cHl()
  {
    return true;
  }
  
  public final boolean cHm()
  {
    return false;
  }
  
  public final boolean cHn()
  {
    return false;
  }
  
  public final void eY(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.sjV.cHF();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.sjV.cancel();
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
        c.a(c.this).fL(paramInt1, paramInt2);
      }
      AppMethodBeat.o(64294);
    }
    
    public final void bO(int paramInt1, int paramInt2)
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