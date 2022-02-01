package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.a;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

final class v$2
  implements f
{
  v$2(v paramv, sm paramsm, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(63855);
    if ((this.pba.iVd != null) && (this.pba.iVd.isShowing()))
    {
      this.pba.iVd.dismiss();
      this.pba.iVd = null;
    }
    g.aiU().b(2811, this);
    paramString = (c)paramn;
    paramString.a(new r.a() {}).b(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(63854);
        v.2.this.paZ.dGZ.errMsg = paramString.pbL.paA;
        if (bt.isNullOrNil(v.2.this.paZ.dGZ.errMsg)) {
          v.2.this.paZ.dGZ.errMsg = v.2.this.val$context.getString(2131765901);
        }
        AppMethodBeat.o(63854);
      }
    }).c(new r.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(63853);
        v.2.this.paZ.dGZ.errMsg = paramAnonymousString;
        if (bt.isNullOrNil(v.2.this.paZ.dGZ.errMsg)) {
          v.2.this.paZ.dGZ.errMsg = v.2.this.val$context.getString(2131765901);
        }
        AppMethodBeat.o(63853);
      }
    });
    this.paZ.dGY.callback.run();
    AppMethodBeat.o(63855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v.2
 * JD-Core Version:    0.7.0.1
 */