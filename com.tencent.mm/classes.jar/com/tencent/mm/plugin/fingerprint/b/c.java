package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.od.a;
import com.tencent.mm.g.a.od.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Map;

public final class c
  extends a
{
  private String dvf;
  private String tgA;
  private a tgB;
  private com.tencent.mm.plugin.fingerprint.d.c tgC;
  
  public c()
  {
    AppMethodBeat.i(64295);
    this.tgB = new a((byte)0);
    this.tgC = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(p.thl.thm, (byte)0);
    this.tgx.a(aj.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            c.a(c.this, paramAnonymousc.dvf);
            c.b(c.this, paramAnonymousc.dvg);
          }
          paramc.gb(paramAnonymousc.errCode, paramAnonymousc.dvd);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(od paramod, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.dvf))
    {
      ad.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.tgA)) {
        break label147;
      }
      ad.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      ad.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramod != null) && (paramod.dBW.dCa != null))
      {
        od.b localb = new od.b();
        localb.dCc = type();
        localb.errCode = 0;
        localb.dvf = this.dvf;
        localb.dvg = this.tgA;
        localb.dvd = paramInt;
        paramod.dBX = localb;
        paramod.dBW.dCa.run();
      }
      this.dvf = "";
      this.tgA = "";
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
  
  public final boolean cPA()
  {
    return true;
  }
  
  public final boolean cPB()
  {
    return false;
  }
  
  public final boolean cPC()
  {
    return false;
  }
  
  public final boolean cPt()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.tgx.fe(aj.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean cPu()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.tgx.cPR();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void cPv()
  {
    AppMethodBeat.i(64299);
    ad.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.tgx.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean cPw()
  {
    return true;
  }
  
  public final boolean cPx()
  {
    AppMethodBeat.i(64300);
    boolean bool = d.cPx();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final Map<String, String> cPy()
  {
    return null;
  }
  
  public final Map<String, String> cPz()
  {
    return null;
  }
  
  public final void fb(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.tgx.cPU();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.tgx.cancel();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.c
 * JD-Core Version:    0.7.0.1
 */