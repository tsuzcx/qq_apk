package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ul;
import com.tencent.mm.f.a.ul.a;
import com.tencent.mm.f.a.ul.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.lang.ref.WeakReference;

public final class w
  extends IListener<ul>
{
  private Dialog mMi;
  
  public w()
  {
    AppMethodBeat.i(160790);
    this.__eventId = ul.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(final ul paramul)
  {
    AppMethodBeat.i(63856);
    Log.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramul.fTK.type) });
    if ((paramul.fTK.aFX == null) || (paramul.fTK.aFX.get() == null))
    {
      Log.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramul.fTK.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    final Context localContext = (Context)paramul.fTK.aFX.get();
    Object localObject;
    if (paramul.fTK.type == 0)
    {
      this.mMi = com.tencent.mm.wallet_core.ui.i.a(localContext, false, null);
      localObject = new k(paramul.fTK.fTM, paramul.fTK.scene);
      h.aGY().a(1800, new com.tencent.mm.an.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(63852);
          if ((w.a(w.this) != null) && (w.a(w.this).isShowing()))
          {
            w.a(w.this).dismiss();
            w.b(w.this);
          }
          h.aGY().b(1800, this);
          paramAnonymousString = (k)paramAnonymousq;
          paramAnonymousString.a(new r.a() {}).b(new r.a()
          {
            public final void e(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(63851);
              w.1.this.tVN.fTL.errMsg = paramAnonymousString.tVi.tVo;
              if (Util.isNullOrNil(w.1.this.tVN.fTL.errMsg)) {
                w.1.this.tVN.fTL.errMsg = w.1.this.val$context.getString(a.i.wallet_unknown_err);
              }
              AppMethodBeat.o(63851);
            }
          }).c(new r.a()
          {
            public final void e(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
            {
              AppMethodBeat.i(63850);
              w.1.this.tVN.fTL.errMsg = paramAnonymous2String;
              if (Util.isNullOrNil(w.1.this.tVN.fTL.errMsg)) {
                w.1.this.tVN.fTL.errMsg = w.1.this.val$context.getString(a.i.wallet_unknown_err);
              }
              AppMethodBeat.o(63850);
            }
          });
          paramul.fTK.callback.run();
          AppMethodBeat.o(63852);
        }
      });
      h.aGY().a((q)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramul.fTK.type == 1)
      {
        this.mMi = com.tencent.mm.wallet_core.ui.i.a(localContext, false, null);
        localObject = new c(paramul.fTK.fTM, paramul.fTK.scene);
        h.aGY().a(2811, new com.tencent.mm.an.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(63855);
            if ((w.a(w.this) != null) && (w.a(w.this).isShowing()))
            {
              w.a(w.this).dismiss();
              w.b(w.this);
            }
            h.aGY().b(2811, this);
            paramAnonymousString = (c)paramAnonymousq;
            paramAnonymousString.a(new r.a() {}).b(new r.a()
            {
              public final void e(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(63854);
                w.2.this.tVN.fTL.errMsg = paramAnonymousString.tWC.tVo;
                if (Util.isNullOrNil(w.2.this.tVN.fTL.errMsg)) {
                  w.2.this.tVN.fTL.errMsg = w.2.this.val$context.getString(a.i.wallet_unknown_err);
                }
                AppMethodBeat.o(63854);
              }
            }).c(new r.a()
            {
              public final void e(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(63853);
                w.2.this.tVN.fTL.errMsg = paramAnonymous2String;
                if (Util.isNullOrNil(w.2.this.tVN.fTL.errMsg)) {
                  w.2.this.tVN.fTL.errMsg = w.2.this.val$context.getString(a.i.wallet_unknown_err);
                }
                AppMethodBeat.o(63853);
              }
            });
            paramul.fTK.callback.run();
            AppMethodBeat.o(63855);
          }
        });
        h.aGY().a((q)localObject, 0);
      }
      else
      {
        Log.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramul.fTK.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.w
 * JD-Core Version:    0.7.0.1
 */