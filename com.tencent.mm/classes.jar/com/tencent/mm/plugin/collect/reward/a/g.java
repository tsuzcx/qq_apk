package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private f callback;
  public qt kOL;
  private b rr;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(41048);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qs();
    ((b.a)localObject).fsY = new qt();
    ((b.a)localObject).funcId = 1562;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (qs)this.rr.fsV.fta;
    ((qs)localObject).wIy = paramLinkedList;
    ((qs)localObject).desc = paramString;
    ((qs)localObject).wIX = paramBoolean1;
    ((qs)localObject).wIY = paramBoolean2;
    ab.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(41048);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41050);
    ab.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kOL = ((qt)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOL.cnK), this.kOL.kNv });
    if ((!this.kOC) && (this.kOL.cnK != 0)) {
      this.kOD = true;
    }
    if ((!this.kOC) && (!this.kOD))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIl, Integer.valueOf(this.kOL.wIB));
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIm, Integer.valueOf(this.kOL.wIx));
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIo, this.kOL.desc);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIu, this.kOL.qiN);
      paramq = new ArrayList();
      Iterator localIterator = this.kOL.wIy.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIr, bo.d(paramq, ","));
      h.qsU.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(41050);
      return;
      if (this.kOC) {
        h.qsU.idkeyStat(724L, 7L, 1L, false);
      } else {
        h.qsU.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(41049);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41049);
    return i;
  }
  
  public final int getType()
  {
    return 1562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.g
 * JD-Core Version:    0.7.0.1
 */