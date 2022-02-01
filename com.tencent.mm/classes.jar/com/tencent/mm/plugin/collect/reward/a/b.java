package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private f callback;
  public us pbJ;
  public boolean pbK;
  private com.tencent.mm.al.b rr;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    b.a locala = new b.a();
    locala.hNM = new ur();
    locala.hNN = new us();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((ur)this.rr.hNK.hNQ).FUg = paramBoolean;
    this.pbK = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63896);
    ad.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pbJ = ((us)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbJ.dlw), this.pbJ.paA });
    if ((!this.pbG) && (this.pbJ.dlw != 0)) {
      this.pbH = true;
    }
    if ((!this.pbG) && (!this.pbH))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBs, Integer.valueOf(this.pbJ.FUn));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBt, Integer.valueOf(this.pbJ.FUj));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBv, this.pbJ.desc);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBu, this.pbJ.nZO);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBx, Integer.valueOf(this.pbJ.FUm));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBz, this.pbJ.ozC);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBA, this.pbJ.FUl);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBB, this.pbJ.xXy);
      paramq = new ArrayList();
      Iterator localIterator = this.pbJ.FUk.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBy, bt.m(paramq, ","));
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.pbG) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(724L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean caG()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63895);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63895);
    return i;
  }
  
  public final int getType()
  {
    return 1323;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */