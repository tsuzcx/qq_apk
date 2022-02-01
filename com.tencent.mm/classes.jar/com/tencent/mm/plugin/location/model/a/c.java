package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private g callback;
  private Runnable hTh;
  public String jXd;
  public final b rr;
  public int tYq;
  public diy tYr;
  public List<dok> tYs;
  public cno tYt;
  public int tYu;
  private String tYv;
  
  public c(String paramString, int paramInt1, dok paramdok, int paramInt2, diy paramdiy)
  {
    AppMethodBeat.i(55791);
    this.tYr = null;
    this.tYs = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cnn();
    ((b.a)localObject).hvu = new cno();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((b.a)localObject).funcId = 492;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cnn)this.rr.hvr.hvw;
    ((cnn)localObject).Exq = paramString;
    ((cnn)localObject).ndI = paramInt1;
    ((cnn)localObject).FAH = paramdok;
    ((cnn)localObject).fZy = paramInt2;
    ((cnn)localObject).FAI = paramdiy;
    this.tYv = paramString;
    this.tYu = ((cnn)localObject).ndI;
    ac.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramdok.Username + " " + paramdok.FWg.Ecg + " " + paramdok.FWg.Ecf + " heading:" + paramdok.FWg.Fur);
    ac.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramdiy.Ecg + " " + paramdiy.Ecf + " " + paramdiy.Name);
    ac.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
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
    this.tYt = ((cno)((b)paramq).hvs.hvw);
    if (this.tYt != null) {
      this.jXd = this.tYt.DWV;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.tYq = this.tYt.FdA;
      this.tYr = this.tYt.FAK;
      this.tYs = this.tYt.FAJ;
      paramq = new StringBuffer();
      paramq.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.tYt.ncL) }));
      if (this.tYr != null) {
        paramq.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.tYr.Ecg), Double.valueOf(this.tYr.Ecf), this.tYr.Name }));
      }
      ac.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + paramq.toString());
      paramq = new LinkedList();
      paramArrayOfByte = this.tYt.FAJ.iterator();
      while (paramArrayOfByte.hasNext())
      {
        dok localdok = (dok)paramArrayOfByte.next();
        if (localdok == null)
        {
          paramq.add(localdok);
        }
        else
        {
          if (localdok.FWg == null) {
            paramq.add(localdok);
          }
          if ((Math.abs(localdok.FWg.Ecf) > 180.0D) || (Math.abs(localdok.FWg.Ecg) > 90.0D))
          {
            ac.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localdok.Username, Double.valueOf(localdok.FWg.Ecg), Double.valueOf(localdok.FWg.Ecf), Double.valueOf(localdok.FWg.Fur) });
            paramq.add(localdok);
          }
        }
      }
      this.tYt.ncL = this.tYt.FAJ.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hTh != null) {
      this.hTh.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */