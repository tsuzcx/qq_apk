package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.b.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.oe.a;
import com.tencent.mm.g.a.oe.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Map;

public final class c
  extends a
{
  private String dwk;
  private String trt;
  private a tru;
  private com.tencent.mm.plugin.fingerprint.d.c trv;
  
  public c()
  {
    AppMethodBeat.i(64295);
    this.tru = new a((byte)0);
    this.trv = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(p.tse.tsf, (byte)0);
    this.trq.a(ak.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            c.a(c.this, paramAnonymousc.dwk);
            c.b(c.this, paramAnonymousc.dwl);
          }
          paramc.gb(paramAnonymousc.errCode, paramAnonymousc.dwi);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(oe paramoe, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.dwk))
    {
      ae.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.trt)) {
        break label147;
      }
      ae.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      ae.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramoe != null) && (paramoe.dDb.dDf != null))
      {
        oe.b localb = new oe.b();
        localb.dDh = type();
        localb.errCode = 0;
        localb.dwk = this.dwk;
        localb.dwl = this.trt;
        localb.dwi = paramInt;
        paramoe.dDc = localb;
        paramoe.dDb.dDf.run();
      }
      this.dwk = "";
      this.trt = "";
      AppMethodBeat.o(64302);
      return;
      ae.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
      break;
      label147:
      ae.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    return false;
  }
  
  public final boolean cRY()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.trq.fi(ak.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean cRZ()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.trq.cSw();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void cSa()
  {
    AppMethodBeat.i(64299);
    ae.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.trq.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean cSb()
  {
    return true;
  }
  
  public final boolean cSc()
  {
    AppMethodBeat.i(64300);
    boolean bool = d.cSc();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final Map<String, String> cSd()
  {
    return null;
  }
  
  public final Map<String, String> cSe()
  {
    return null;
  }
  
  public final boolean cSf()
  {
    return true;
  }
  
  public final boolean cSg()
  {
    return false;
  }
  
  public final boolean cSh()
  {
    return false;
  }
  
  public final void ff(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.trq.cSz();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.trq.cancel();
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
        c.a(c.this).gb(paramInt1, paramInt2);
      }
      AppMethodBeat.o(64294);
    }
    
    public final void bQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(64293);
      if (c.a(c.this) != null) {
        c.a(c.this);
      }
      AppMethodBeat.o(64293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.c
 * JD-Core Version:    0.7.0.1
 */