package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private f callback;
  public vl pbP;
  private b rr;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new vk();
    ((b.a)localObject).hNN = new vl();
    ((b.a)localObject).funcId = 1562;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (vk)this.rr.hNK.hNQ;
    ((vk)localObject).FUk = paramLinkedList;
    ((vk)localObject).desc = paramString;
    ((vk)localObject).FUO = paramBoolean1;
    ((vk)localObject).FUP = paramBoolean2;
    ad.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63910);
    ad.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pbP = ((vl)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbP.dlw), this.pbP.paA });
    if ((!this.pbG) && (this.pbP.dlw != 0)) {
      this.pbH = true;
    }
    if ((!this.pbG) && (!this.pbH))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBs, Integer.valueOf(this.pbP.FUn));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBt, Integer.valueOf(this.pbP.FUj));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBv, this.pbP.desc);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBB, this.pbP.xXy);
      paramq = new ArrayList();
      Iterator localIterator = this.pbP.FUk.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBy, bt.m(paramq, ","));
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.pbG) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(724L, 7L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63909);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
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