package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ow.a;
import com.tencent.mm.g.a.ow.b;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class c
  extends a
{
  private String dNR;
  private String wFa;
  private a wFb;
  private com.tencent.mm.plugin.fingerprint.d.c wFc;
  
  public c()
  {
    AppMethodBeat.i(64295);
    this.wFb = new a((byte)0);
    this.wFc = null;
    AppMethodBeat.o(64295);
  }
  
  public final int a(com.tencent.mm.plugin.fingerprint.d.c paramc)
  {
    return 0;
  }
  
  public final int a(final com.tencent.mm.plugin.fingerprint.d.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(64301);
    f localf = new f(p.wFK.wFL, (byte)0);
    this.wEX.a(MMApplicationContext.getContext(), localf, new b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64292);
        if (paramAnonymousc.errCode == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            c.a(c.this, paramAnonymousc.dNR);
            c.b(c.this, paramAnonymousc.dNS);
          }
          paramc.gz(paramAnonymousc.errCode, paramAnonymousc.dNP);
          AppMethodBeat.o(64292);
          return;
        }
      }
    });
    AppMethodBeat.o(64301);
    return 0;
  }
  
  public final void a(ow paramow, int paramInt)
  {
    AppMethodBeat.i(64302);
    if (!TextUtils.isEmpty(this.dNR))
    {
      Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      if (TextUtils.isEmpty(this.wFa)) {
        break label147;
      }
      Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      Log.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramow != null) && (paramow.dUQ.dUU != null))
      {
        ow.b localb = new ow.b();
        localb.dUW = type();
        localb.errCode = 0;
        localb.dNR = this.dNR;
        localb.dNS = this.wFa;
        localb.dNP = paramInt;
        paramow.dUR = localb;
        paramow.dUQ.dUU.run();
      }
      this.dNR = "";
      this.wFa = "";
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
  
  public final boolean dJT()
  {
    AppMethodBeat.i(64296);
    boolean bool = this.wEX.fN(MMApplicationContext.getContext());
    AppMethodBeat.o(64296);
    return bool;
  }
  
  public final boolean dJU()
  {
    AppMethodBeat.i(64297);
    boolean bool = this.wEX.dKr();
    AppMethodBeat.o(64297);
    return bool;
  }
  
  public final void dJV()
  {
    AppMethodBeat.i(64299);
    Log.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    this.wEX.prepare();
    AppMethodBeat.o(64299);
  }
  
  public final boolean dJW()
  {
    return true;
  }
  
  public final boolean dJX()
  {
    AppMethodBeat.i(64300);
    boolean bool = d.dJX();
    AppMethodBeat.o(64300);
    return bool;
  }
  
  public final Map<String, String> dJY()
  {
    return null;
  }
  
  public final Map<String, String> dJZ()
  {
    return null;
  }
  
  public final boolean dKa()
  {
    return true;
  }
  
  public final boolean dKb()
  {
    return false;
  }
  
  public final boolean dKc()
  {
    return false;
  }
  
  public final void fK(Context paramContext)
  {
    AppMethodBeat.i(64298);
    if (paramContext != null)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setAction("com.android.settings.fingerprint.FingerprintSettings");
      ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
      ((Intent)localObject).setFlags(268435456);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(64298);
  }
  
  public final int type()
  {
    AppMethodBeat.i(64304);
    int i = this.wEX.dKu();
    AppMethodBeat.o(64304);
    return i;
  }
  
  public final void userCancel()
  {
    AppMethodBeat.i(64303);
    this.wEX.cancel();
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
        c.a(c.this).gz(paramInt1, paramInt2);
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