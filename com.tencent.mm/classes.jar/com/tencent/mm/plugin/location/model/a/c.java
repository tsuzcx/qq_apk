package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private g callback;
  private Runnable hsF;
  public String jwH;
  public final b rr;
  public int sQd;
  public ddj sQe;
  public List<div> sQf;
  public cii sQg;
  public int sQh;
  private String sQi;
  
  public c(String paramString, int paramInt1, div paramdiv, int paramInt2, ddj paramddj)
  {
    AppMethodBeat.i(55791);
    this.sQe = null;
    this.sQf = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cih();
    ((b.a)localObject).gUV = new cii();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((b.a)localObject).funcId = 492;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cih)this.rr.gUS.gUX;
    ((cih)localObject).Dek = paramString;
    ((cih)localObject).mBH = paramInt1;
    ((cih)localObject).EdJ = paramdiv;
    ((cih)localObject).fVD = paramInt2;
    ((cih)localObject).EdK = paramddj;
    this.sQi = paramString;
    this.sQh = ((cih)localObject).mBH;
    ad.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramdiv.Username + " " + paramdiv.Eze.CJE + " " + paramdiv.Eze.CJD + " heading:" + paramdiv.Eze.DXx);
    ad.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramddj.CJE + " " + paramddj.CJD + " " + paramddj.Name);
    ad.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
    AppMethodBeat.o(55791);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55792);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55792);
    return i;
  }
  
  public final int getType()
  {
    return 492;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55793);
    this.sQg = ((cii)((b)paramq).gUT.gUX);
    if (this.sQg != null) {
      this.jwH = this.sQg.CEv;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.sQd = this.sQg.DIf;
      this.sQe = this.sQg.EdM;
      this.sQf = this.sQg.EdL;
      paramq = new StringBuffer();
      paramq.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.sQg.mAK) }));
      if (this.sQe != null) {
        paramq.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.sQe.CJE), Double.valueOf(this.sQe.CJD), this.sQe.Name }));
      }
      ad.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + paramq.toString());
      paramq = new LinkedList();
      paramArrayOfByte = this.sQg.EdL.iterator();
      while (paramArrayOfByte.hasNext())
      {
        div localdiv = (div)paramArrayOfByte.next();
        if (localdiv == null)
        {
          paramq.add(localdiv);
        }
        else
        {
          if (localdiv.Eze == null) {
            paramq.add(localdiv);
          }
          if ((Math.abs(localdiv.Eze.CJD) > 180.0D) || (Math.abs(localdiv.Eze.CJE) > 90.0D))
          {
            ad.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localdiv.Username, Double.valueOf(localdiv.Eze.CJE), Double.valueOf(localdiv.Eze.CJD), Double.valueOf(localdiv.Eze.DXx) });
            paramq.add(localdiv);
          }
        }
      }
      this.sQg.mAK = this.sQg.EdL.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hsF != null) {
      this.hsF.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */