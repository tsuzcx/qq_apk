package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.f.a.pt.a;
import com.tencent.mm.f.a.pt.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class c
  extends a
{
  private String BxX;
  private a BxY;
  private com.tencent.mm.plugin.fingerprint.d.c BxZ;
  private String fHc;
  
  public c()
  {
    AppMethodBeat.i(64295);
    this.BxY = new a((byte)0);
    this.BxZ = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(p.ByH.ByI, (byte)0);
    this.BxU.a(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            c.a(c.this, paramAnonymousc.fHc);
            c.b(c.this, paramAnonymousc.fHd);
          }
          paramc.hu(paramAnonymousc.errCode, paramAnonymousc.fHa);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(pt parampt, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.fHc))
    {
      Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.BxX)) {
        break label147;
      }
      Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      Log.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((parampt != null) && (parampt.fOs.fOw != null))
      {
        pt.b localb = new pt.b();
        localb.fOy = type();
        localb.errCode = 0;
        localb.fHc = this.fHc;
        localb.fHd = this.BxX;
        localb.fHa = paramInt;
        parampt.fOt = localb;
        parampt.fOs.fOw.run();
      }
      this.fHc = "";
      this.BxX = "";
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
  
  public final boolean eoA()
  {
    return false;
  }
  
  public final boolean eoB()
  {
    return false;
  }
  
  public final boolean eos()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.BxU.gh(MMApplicationContext.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean eot()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.BxU.eoQ();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void eou()
  {
    AppMethodBeat.i(64299);
    Log.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.BxU.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean eov()
  {
    return true;
  }
  
  public final boolean eow()
  {
    AppMethodBeat.i(64300);
    boolean bool = d.eow();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final Map<String, String> eox()
  {
    return null;
  }
  
  public final Map<String, String> eoy()
  {
    return null;
  }
  
  public final boolean eoz()
  {
    return true;
  }
  
  public final void ge(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.BxU.eoT();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.BxU.cancel();
    AppMethodBeat.o(64303);
  }
  
  final class a
    implements a.b
  {
    private a() {}
    
    public final void G(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(64294);
      if (c.a(c.this) != null) {
        c.a(c.this).hu(paramInt1, paramInt2);
      }
      AppMethodBeat.o(64294);
    }
    
    public final void ci(int paramInt1, int paramInt2)
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