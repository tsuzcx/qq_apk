package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.rr.a;
import com.tencent.mm.g.a.rr.b;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

final class v$1
  implements com.tencent.mm.al.g
{
  v$1(v paramv, rr paramrr, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(63852);
    if ((this.nUk.ibM != null) && (this.nUk.ibM.isShowing()))
    {
      this.nUk.ibM.dismiss();
      this.nUk.ibM = null;
    }
    com.tencent.mm.kernel.g.aeS().b(1800, this);
    paramString = (k)paramn;
    paramString.a(new r.a() {}).b(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(63851);
        v.1.this.nUj.dxl.errMsg = paramString.nTG.nTK;
        if (bt.isNullOrNil(v.1.this.nUj.dxl.errMsg)) {
          v.1.this.nUj.dxl.errMsg = v.1.this.val$context.getString(2131765901);
        }
        AppMethodBeat.o(63851);
      }
    }).c(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(63850);
        v.1.this.nUj.dxl.errMsg = paramAnonymousString;
        if (bt.isNullOrNil(v.1.this.nUj.dxl.errMsg)) {
          v.1.this.nUj.dxl.errMsg = v.1.this.val$context.getString(2131765901);
        }
        AppMethodBeat.o(63850);
      }
    });
    this.nUj.dxk.callback.run();
    AppMethodBeat.o(63852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v.1
 * JD-Core Version:    0.7.0.1
 */