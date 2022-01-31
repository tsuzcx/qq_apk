package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private f callback;
  public qc kOF;
  public boolean kOG;
  private com.tencent.mm.ai.b rr;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(41034);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    b.a locala = new b.a();
    locala.fsX = new qb();
    locala.fsY = new qc();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((qb)this.rr.fsV.fta).wIu = paramBoolean;
    this.kOG = paramBoolean;
    AppMethodBeat.o(41034);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41036);
    ab.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kOF = ((qc)((com.tencent.mm.ai.b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOF.cnK), this.kOF.kNv });
    if ((!this.kOC) && (this.kOF.cnK != 0)) {
      this.kOD = true;
    }
    if ((!this.kOC) && (!this.kOD))
    {
      g.RL().Ru().set(ac.a.yIl, Integer.valueOf(this.kOF.wIB));
      g.RL().Ru().set(ac.a.yIm, Integer.valueOf(this.kOF.wIx));
      g.RL().Ru().set(ac.a.yIo, this.kOF.desc);
      g.RL().Ru().set(ac.a.yIn, this.kOF.jVh);
      g.RL().Ru().set(ac.a.yIq, Integer.valueOf(this.kOF.wIA));
      g.RL().Ru().set(ac.a.yIs, this.kOF.knU);
      g.RL().Ru().set(ac.a.yIt, this.kOF.wIz);
      g.RL().Ru().set(ac.a.yIu, this.kOF.qiN);
      paramq = new ArrayList();
      Iterator localIterator = this.kOF.wIy.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      g.RL().Ru().set(ac.a.yIr, bo.d(paramq, ","));
      h.qsU.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(41036);
      return;
      if (this.kOC) {
        h.qsU.idkeyStat(724L, 4L, 1L, false);
      } else {
        h.qsU.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean bhR()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(41035);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41035);
    return i;
  }
  
  public final int getType()
  {
    return 1323;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */