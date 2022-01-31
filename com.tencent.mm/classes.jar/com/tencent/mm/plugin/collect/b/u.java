package com.tencent.mm.plugin.collect.b;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ox;
import com.tencent.mm.h.a.ox.a;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import java.lang.ref.WeakReference;

public final class u
  extends com.tencent.mm.sdk.b.c<ox>
{
  Dialog eXA;
  
  public u()
  {
    this.udX = ox.class.getName().hashCode();
  }
  
  private boolean a(final ox paramox)
  {
    y.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramox.bYx.type) });
    if ((paramox.bYx.aoB == null) || (paramox.bYx.aoB.get() == null))
    {
      y.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramox.bYx.bFJ.run();
      return false;
    }
    Object localObject = (Context)paramox.bYx.aoB.get();
    if (paramox.bYx.type == 0)
    {
      this.eXA = com.tencent.mm.wallet_core.ui.g.a((Context)localObject, false, null);
      localObject = new k(paramox.bYx.bYz, paramox.bYx.scene);
      com.tencent.mm.kernel.g.Dk().a(1800, new u.1(this, paramox));
      com.tencent.mm.kernel.g.Dk().a((m)localObject, 0);
      return false;
    }
    if (paramox.bYx.type == 1)
    {
      this.eXA = com.tencent.mm.wallet_core.ui.g.a((Context)localObject, false, null);
      localObject = new com.tencent.mm.plugin.collect.reward.a.c(paramox.bYx.bYz, paramox.bYx.scene);
      com.tencent.mm.kernel.g.Dk().a(2811, new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, m paramAnonymousm)
        {
          if ((u.this.eXA != null) && (u.this.eXA.isShowing()))
          {
            u.this.eXA.dismiss();
            u.this.eXA = null;
          }
          com.tencent.mm.kernel.g.Dk().b(2811, this);
          paramAnonymousString = (com.tencent.mm.plugin.collect.reward.a.c)paramAnonymousm;
          paramAnonymousString.a(new u.2.3(this)).b(new n.a()
          {
            public final void f(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, m paramAnonymous2m)
            {
              u.2.this.iHR.bYy.aox = paramAnonymousString.iIc.iHr;
            }
          }).c(new u.2.1(this));
          paramox.bYx.bFJ.run();
        }
      });
      com.tencent.mm.kernel.g.Dk().a((m)localObject, 0);
      return false;
    }
    y.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramox.bYx.type) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.u
 * JD-Core Version:    0.7.0.1
 */