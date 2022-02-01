package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.protocal.protobuf.yr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  public yr wZY;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new yq();
    ((c.a)localObject).otF = new yr();
    ((c.a)localObject).funcId = 1562;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (yq)c.b.b(this.rr.otB);
    ((yq)localObject).ZgH = paramLinkedList;
    ((yq)localObject).desc = paramString;
    ((yq)localObject).Zhl = paramBoolean1;
    ((yq)localObject).Zhm = paramBoolean2;
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63910);
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wZY = ((yr)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wZY.hAV), this.wZY.wYI });
    if ((!this.oaK) && (this.wZY.hAV != 0)) {
      this.wZR = true;
    }
    if ((!this.oaK) && (!this.wZR))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTZ, Integer.valueOf(this.wZY.ZgK));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUa, Integer.valueOf(this.wZY.ZgG));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUc, this.wZY.desc);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUi, this.wZY.OhN);
      params = new ArrayList();
      Iterator localIterator = this.wZY.ZgH.iterator();
      while (localIterator.hasNext()) {
        params.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUf, Util.listToString(params, ","));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.oaK) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 7L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(63909);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63909);
    return i;
  }
  
  public final int getType()
  {
    return 1562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.g
 * JD-Core Version:    0.7.0.1
 */