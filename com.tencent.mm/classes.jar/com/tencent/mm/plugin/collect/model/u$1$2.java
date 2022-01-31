package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.b;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class u$1$2
  implements p.a
{
  u$1$2(u.1 param1, k paramk) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(141986);
    this.kNX.kNV.cGz.errMsg = this.kNY.kNt.kNv;
    if (bo.isNullOrNil(this.kNX.kNV.cGz.errMsg)) {
      this.kNX.kNV.cGz.errMsg = this.kNX.val$context.getString(2131305682);
    }
    AppMethodBeat.o(141986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u.1.2
 * JD-Core Version:    0.7.0.1
 */