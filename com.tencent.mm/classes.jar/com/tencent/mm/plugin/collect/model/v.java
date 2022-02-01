package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.sn.a;
import com.tencent.mm.g.a.sn.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.h;
import java.lang.ref.WeakReference;

public final class v
  extends com.tencent.mm.sdk.b.c<sn>
{
  Dialog iXW;
  
  public v()
  {
    AppMethodBeat.i(160790);
    this.__eventId = sn.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(final sn paramsn)
  {
    AppMethodBeat.i(63856);
    ae.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramsn.dIe.type) });
    if ((paramsn.dIe.aWN == null) || (paramsn.dIe.aWN.get() == null))
    {
      ae.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramsn.dIe.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    final Context localContext = (Context)paramsn.dIe.aWN.get();
    Object localObject;
    if (paramsn.dIe.type == 0)
    {
      this.iXW = h.a(localContext, false, null);
      localObject = new k(paramsn.dIe.dIg, paramsn.dIe.scene);
      g.ajj().a(1800, new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(63852);
          if ((v.this.iXW != null) && (v.this.iXW.isShowing()))
          {
            v.this.iXW.dismiss();
            v.this.iXW = null;
          }
          g.ajj().b(1800, this);
          paramAnonymousString = (k)paramAnonymousn;
          paramAnonymousString.a(new r.a() {}).b(new r.a()
          {
            public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(63851);
              v.1.this.phD.dIf.errMsg = paramAnonymousString.pha.phe;
              if (bu.isNullOrNil(v.1.this.phD.dIf.errMsg)) {
                v.1.this.phD.dIf.errMsg = v.1.this.val$context.getString(2131765901);
              }
              AppMethodBeat.o(63851);
            }
          }).c(new r.a()
          {
            public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(63850);
              v.1.this.phD.dIf.errMsg = paramAnonymous2String;
              if (bu.isNullOrNil(v.1.this.phD.dIf.errMsg)) {
                v.1.this.phD.dIf.errMsg = v.1.this.val$context.getString(2131765901);
              }
              AppMethodBeat.o(63850);
            }
          });
          paramsn.dIe.callback.run();
          AppMethodBeat.o(63852);
        }
      });
      g.ajj().a((n)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramsn.dIe.type == 1)
      {
        this.iXW = h.a(localContext, false, null);
        localObject = new com.tencent.mm.plugin.collect.reward.a.c(paramsn.dIe.dIg, paramsn.dIe.scene);
        g.ajj().a(2811, new f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(63855);
            if ((v.this.iXW != null) && (v.this.iXW.isShowing()))
            {
              v.this.iXW.dismiss();
              v.this.iXW = null;
            }
            g.ajj().b(2811, this);
            paramAnonymousString = (com.tencent.mm.plugin.collect.reward.a.c)paramAnonymousn;
            paramAnonymousString.a(new r.a() {}).b(new r.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(63854);
                v.2.this.phD.dIf.errMsg = paramAnonymousString.pir.phe;
                if (bu.isNullOrNil(v.2.this.phD.dIf.errMsg)) {
                  v.2.this.phD.dIf.errMsg = v.2.this.val$context.getString(2131765901);
                }
                AppMethodBeat.o(63854);
              }
            }).c(new r.a()
            {
              public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(63853);
                v.2.this.phD.dIf.errMsg = paramAnonymous2String;
                if (bu.isNullOrNil(v.2.this.phD.dIf.errMsg)) {
                  v.2.this.phD.dIf.errMsg = v.2.this.val$context.getString(2131765901);
                }
                AppMethodBeat.o(63853);
              }
            });
            paramsn.dIe.callback.run();
            AppMethodBeat.o(63855);
          }
        });
        g.ajj().a((n)localObject, 0);
      }
      else
      {
        ae.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramsn.dIe.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v
 * JD-Core Version:    0.7.0.1
 */