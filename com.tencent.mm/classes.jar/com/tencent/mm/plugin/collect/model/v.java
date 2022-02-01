package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sa.a;
import com.tencent.mm.g.a.sa.b;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.lang.ref.WeakReference;

public final class v
  extends com.tencent.mm.sdk.b.c<sa>
{
  Dialog iBT;
  
  public v()
  {
    AppMethodBeat.i(160790);
    this.__eventId = sa.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(final sa paramsa)
  {
    AppMethodBeat.i(63856);
    ac.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramsa.duX.type) });
    if ((paramsa.duX.aMw == null) || (paramsa.duX.aMw.get() == null))
    {
      ac.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramsa.duX.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    final Context localContext = (Context)paramsa.duX.aMw.get();
    Object localObject;
    if (paramsa.duX.type == 0)
    {
      this.iBT = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
      localObject = new k(paramsa.duX.duZ, paramsa.duX.scene);
      com.tencent.mm.kernel.g.agi().a(1800, new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(63852);
          if ((v.this.iBT != null) && (v.this.iBT.isShowing()))
          {
            v.this.iBT.dismiss();
            v.this.iBT = null;
          }
          com.tencent.mm.kernel.g.agi().b(1800, this);
          paramAnonymousString = (k)paramAnonymousn;
          paramAnonymousString.a(new r.a() {}).b(new r.a()
          {
            public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(63851);
              v.1.this.oxE.duY.errMsg = paramAnonymousString.oxb.oxf;
              if (bs.isNullOrNil(v.1.this.oxE.duY.errMsg)) {
                v.1.this.oxE.duY.errMsg = v.1.this.val$context.getString(2131765901);
              }
              AppMethodBeat.o(63851);
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(63850);
              v.1.this.oxE.duY.errMsg = paramAnonymous2String;
              if (bs.isNullOrNil(v.1.this.oxE.duY.errMsg)) {
                v.1.this.oxE.duY.errMsg = v.1.this.val$context.getString(2131765901);
              }
              AppMethodBeat.o(63850);
            }
          });
          paramsa.duX.callback.run();
          AppMethodBeat.o(63852);
        }
      });
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramsa.duX.type == 1)
      {
        this.iBT = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
        localObject = new com.tencent.mm.plugin.collect.reward.a.c(paramsa.duX.duZ, paramsa.duX.scene);
        com.tencent.mm.kernel.g.agi().a(2811, new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(63855);
            if ((v.this.iBT != null) && (v.this.iBT.isShowing()))
            {
              v.this.iBT.dismiss();
              v.this.iBT = null;
            }
            com.tencent.mm.kernel.g.agi().b(2811, this);
            paramAnonymousString = (com.tencent.mm.plugin.collect.reward.a.c)paramAnonymousn;
            paramAnonymousString.a(new r.a() {}).b(new r.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(63854);
                v.2.this.oxE.duY.errMsg = paramAnonymousString.oyq.oxf;
                if (bs.isNullOrNil(v.2.this.oxE.duY.errMsg)) {
                  v.2.this.oxE.duY.errMsg = v.2.this.val$context.getString(2131765901);
                }
                AppMethodBeat.o(63854);
              }
            }).c(new r.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(63853);
                v.2.this.oxE.duY.errMsg = paramAnonymous2String;
                if (bs.isNullOrNil(v.2.this.oxE.duY.errMsg)) {
                  v.2.this.oxE.duY.errMsg = v.2.this.val$context.getString(2131765901);
                }
                AppMethodBeat.o(63853);
              }
            });
            paramsa.duX.callback.run();
            AppMethodBeat.o(63855);
          }
        });
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      }
      else
      {
        ac.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramsa.duX.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v
 * JD-Core Version:    0.7.0.1
 */