package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class u$1$1
  implements p.a
{
  u$1$1(u.1 param1) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(141985);
    this.kNX.kNV.cGz.errMsg = paramString;
    if (bo.isNullOrNil(this.kNX.kNV.cGz.errMsg)) {
      this.kNX.kNV.cGz.errMsg = this.kNX.val$context.getString(2131305682);
    }
    AppMethodBeat.o(141985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u.1.1
 * JD-Core Version:    0.7.0.1
 */