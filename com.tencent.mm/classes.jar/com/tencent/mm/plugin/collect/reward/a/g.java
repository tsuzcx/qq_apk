package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private i callback;
  public wv qxG;
  private d rr;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new wu();
    ((d.a)localObject).iLO = new wv();
    ((d.a)localObject).funcId = 1562;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (wu)this.rr.iLK.iLR;
    ((wu)localObject).Lhn = paramLinkedList;
    ((wu)localObject).desc = paramString;
    ((wu)localObject).LhR = paramBoolean1;
    ((wu)localObject).LhS = paramBoolean2;
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63910);
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qxG = ((wv)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxG.dDN), this.qxG.qwn });
    if ((!this.qxx) && (this.qxG.dDN != 0)) {
      this.qxy = true;
    }
    if ((!this.qxx) && (!this.qxy))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oej, Integer.valueOf(this.qxG.Lhq));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oek, Integer.valueOf(this.qxG.Lhm));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oem, this.qxG.desc);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oes, this.qxG.Cog);
      params = new ArrayList();
      Iterator localIterator = this.qxG.Lhn.iterator();
      while (localIterator.hasNext()) {
        params.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oep, Util.listToString(params, ","));
      h.CyF.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.qxx) {
        h.CyF.idkeyStat(724L, 7L, 1L, false);
      } else {
        h.CyF.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(63909);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63909);
    return i;
  }
  
  public final int getType()
  {
    return 1562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.g
 * JD-Core Version:    0.7.0.1
 */