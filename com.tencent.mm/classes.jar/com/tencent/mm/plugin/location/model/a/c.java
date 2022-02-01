package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private Runnable ips;
  public String kuP;
  public final b rr;
  public int vnk;
  public dpk vnl;
  public List<duy> vnm;
  public ctl vnn;
  public int vno;
  private String vnp;
  
  public c(String paramString, int paramInt1, duy paramduy, int paramInt2, dpk paramdpk)
  {
    AppMethodBeat.i(55791);
    this.vnl = null;
    this.vnm = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ctk();
    ((b.a)localObject).hQG = new ctl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((b.a)localObject).funcId = 492;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ctk)this.rr.hQD.hQJ;
    ((ctk)localObject).GxB = paramString;
    ((ctk)localObject).nJA = paramInt1;
    ((ctk)localObject).HEv = paramduy;
    ((ctk)localObject).gvw = paramInt2;
    ((ctk)localObject).HEw = paramdpk;
    this.vnp = paramString;
    this.vno = ((ctk)localObject).nJA;
    ae.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramduy.Username + " " + paramduy.IaJ.Gay + " " + paramduy.IaJ.Gax + " heading:" + paramduy.IaJ.HxW);
    ae.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramdpk.Gay + " " + paramdpk.Gax + " " + paramdpk.Name);
    ae.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
    AppMethodBeat.o(55791);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55792);
    this.callback = paramf;
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
    this.vnn = ((ctl)((b)paramq).hQE.hQJ);
    if (this.vnn != null) {
      this.kuP = this.vnn.FUM;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.vnk = this.vnn.HgD;
      this.vnl = this.vnn.HEy;
      this.vnm = this.vnn.HEx;
      paramq = new StringBuffer();
      paramq.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.vnn.nID) }));
      if (this.vnl != null) {
        paramq.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.vnl.Gay), Double.valueOf(this.vnl.Gax), this.vnl.Name }));
      }
      ae.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + paramq.toString());
      paramq = new LinkedList();
      paramArrayOfByte = this.vnn.HEx.iterator();
      while (paramArrayOfByte.hasNext())
      {
        duy localduy = (duy)paramArrayOfByte.next();
        if (localduy == null)
        {
          paramq.add(localduy);
        }
        else
        {
          if (localduy.IaJ == null) {
            paramq.add(localduy);
          }
          if ((Math.abs(localduy.IaJ.Gax) > 180.0D) || (Math.abs(localduy.IaJ.Gay) > 90.0D))
          {
            ae.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localduy.Username, Double.valueOf(localduy.IaJ.Gay), Double.valueOf(localduy.IaJ.Gax), Double.valueOf(localduy.IaJ.HxW) });
            paramq.add(localduy);
          }
        }
      }
      this.vnn.nID = this.vnn.HEx.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.ips != null) {
      this.ips.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */