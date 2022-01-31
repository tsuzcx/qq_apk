package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.b;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.p.a;

final class u$2$2
  implements p.a
{
  u$2$2(u.2 param2, c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(141988);
    this.kNZ.kNV.cGz.errMsg = this.kOa.kOH.kNv;
    if (bo.isNullOrNil(this.kNZ.kNV.cGz.errMsg)) {
      this.kNZ.kNV.cGz.errMsg = this.kNZ.val$context.getString(2131305682);
    }
    AppMethodBeat.o(141988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u.2.2
 * JD-Core Version:    0.7.0.1
 */