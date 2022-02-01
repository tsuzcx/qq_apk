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
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

final class v$2
  implements i
{
  v$2(v paramv, tk paramtk, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(63855);
    if ((v.a(this.qwO) != null) && (v.a(this.qwO).isShowing()))
    {
      v.a(this.qwO).dismiss();
      v.b(this.qwO);
    }
    g.azz().b(2811, this);
    paramString = (c)paramq;
    paramString.a(new r.a() {}).b(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(63854);
        v.2.this.qwN.dZR.errMsg = paramString.qxC.qwn;
        if (Util.isNullOrNil(v.2.this.qwN.dZR.errMsg)) {
          v.2.this.qwN.dZR.errMsg = v.2.this.val$context.getString(2131768354);
        }
        AppMethodBeat.o(63854);
      }
    }).c(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(63853);
        v.2.this.qwN.dZR.errMsg = paramAnonymousString;
        if (Util.isNullOrNil(v.2.this.qwN.dZR.errMsg)) {
          v.2.this.qwN.dZR.errMsg = v.2.this.val$context.getString(2131768354);
        }
        AppMethodBeat.o(63853);
      }
    });
    this.qwN.dZQ.callback.run();
    AppMethodBeat.o(63855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v.2
 * JD-Core Version:    0.7.0.1
 */