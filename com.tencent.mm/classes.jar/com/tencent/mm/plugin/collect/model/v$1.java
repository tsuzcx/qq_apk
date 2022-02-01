package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tk.a;
import com.tencent.mm.g.a.tk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

final class v$1
  implements i
{
  v$1(v paramv, tk paramtk, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(63852);
    if ((v.a(this.qwO) != null) && (v.a(this.qwO).isShowing()))
    {
      v.a(this.qwO).dismiss();
      v.b(this.qwO);
    }
    g.azz().b(1800, this);
    paramString = (k)paramq;
    paramString.a(new r.a() {}).b(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(63851);
        v.1.this.qwN.dZR.errMsg = paramString.qwj.qwn;
        if (Util.isNullOrNil(v.1.this.qwN.dZR.errMsg)) {
          v.1.this.qwN.dZR.errMsg = v.1.this.val$context.getString(2131768354);
        }
        AppMethodBeat.o(63851);
      }
    }).c(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(63850);
        v.1.this.qwN.dZR.errMsg = paramAnonymousString;
        if (Util.isNullOrNil(v.1.this.qwN.dZR.errMsg)) {
          v.1.this.qwN.dZR.errMsg = v.1.this.val$context.getString(2131768354);
        }
        AppMethodBeat.o(63850);
      }
    });
    this.qwN.dZQ.callback.run();
    AppMethodBeat.o(63852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v.1
 * JD-Core Version:    0.7.0.1
 */