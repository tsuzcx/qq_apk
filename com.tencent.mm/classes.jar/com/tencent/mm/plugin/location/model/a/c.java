package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private Runnable imy;
  public String krz;
  public final b rr;
  public int vaZ;
  public don vba;
  public List<dub> vbb;
  public csr vbc;
  public int vbd;
  private String vbe;
  
  public c(String paramString, int paramInt1, dub paramdub, int paramInt2, don paramdon)
  {
    AppMethodBeat.i(55791);
    this.vba = null;
    this.vbb = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new csq();
    ((b.a)localObject).hNN = new csr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((b.a)localObject).funcId = 492;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (csq)this.rr.hNK.hNQ;
    ((csq)localObject).GeT = paramString;
    ((csq)localObject).nEf = paramInt1;
    ((csq)localObject).HkV = paramdub;
    ((csq)localObject).gsU = paramInt2;
    ((csq)localObject).HkW = paramdon;
    this.vbe = paramString;
    this.vbd = ((csq)localObject).nEf;
    ad.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramdub.Username + " " + paramdub.HGW.FIc + " " + paramdub.HGW.FIb + " heading:" + paramdub.HGW.Hew);
    ad.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramdon.FIc + " " + paramdon.FIb + " " + paramdon.Name);
    ad.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
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
    this.vbc = ((csr)((b)paramq).hNL.hNQ);
    if (this.vbc != null) {
      this.krz = this.vbc.FCr;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.vaZ = this.vbc.GNd;
      this.vba = this.vbc.HkY;
      this.vbb = this.vbc.HkX;
      paramq = new StringBuffer();
      paramq.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.vbc.nDi) }));
      if (this.vba != null) {
        paramq.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.vba.FIc), Double.valueOf(this.vba.FIb), this.vba.Name }));
      }
      ad.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + paramq.toString());
      paramq = new LinkedList();
      paramArrayOfByte = this.vbc.HkX.iterator();
      while (paramArrayOfByte.hasNext())
      {
        dub localdub = (dub)paramArrayOfByte.next();
        if (localdub == null)
        {
          paramq.add(localdub);
        }
        else
        {
          if (localdub.HGW == null) {
            paramq.add(localdub);
          }
          if ((Math.abs(localdub.HGW.FIb) > 180.0D) || (Math.abs(localdub.HGW.FIc) > 90.0D))
          {
            ad.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localdub.Username, Double.valueOf(localdub.HGW.FIc), Double.valueOf(localdub.HGW.FIb), Double.valueOf(localdub.HGW.Hew) });
            paramq.add(localdub);
          }
        }
      }
      this.vbc.nDi = this.vbc.HkX.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.imy != null) {
      this.imy.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */