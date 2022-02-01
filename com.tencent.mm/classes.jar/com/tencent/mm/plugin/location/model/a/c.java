package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dvs;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.protocal.protobuf.eti;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  public int EkV;
  public eti EkW;
  public List<ezh> EkX;
  public dvt EkY;
  public int EkZ;
  private String Ela;
  private i callback;
  private Runnable maA;
  public final d rr;
  public String tVH;
  
  public c(String paramString, int paramInt1, ezh paramezh, int paramInt2, eti parameti)
  {
    AppMethodBeat.i(55791);
    this.EkW = null;
    this.EkX = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dvs();
    ((d.a)localObject).lBV = new dvt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((d.a)localObject).funcId = 492;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dvs)d.b.b(this.rr.lBR);
    ((dvs)localObject).SvI = paramString;
    ((dvs)localObject).rWu = paramInt1;
    ((dvs)localObject).UbH = paramezh;
    ((dvs)localObject).jUj = paramInt2;
    ((dvs)localObject).UbI = parameti;
    this.Ela = paramString;
    this.EkZ = ((dvs)localObject).rWu;
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramezh.Username + " " + paramezh.UzK.RVz + " " + paramezh.UzK.RVy + " heading:" + paramezh.UzK.TUj);
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + parameti.RVz + " " + parameti.RVy + " " + parameti.CMP);
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
    AppMethodBeat.o(55791);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(55792);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55792);
    return i;
  }
  
  public final int getType()
  {
    return 492;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55793);
    this.EkY = ((dvt)d.c.b(((d)params).lBS));
    if (this.EkY != null) {
      this.tVH = this.EkY.RPs;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.EkV = this.EkY.TwB;
      this.EkW = this.EkY.UbK;
      this.EkX = this.EkY.UbJ;
      params = new StringBuffer();
      params.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.EkY.rVx) }));
      if (this.EkW != null) {
        params.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.EkW.RVz), Double.valueOf(this.EkW.RVy), this.EkW.CMP }));
      }
      Log.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + params.toString());
      params = new LinkedList();
      paramArrayOfByte = this.EkY.UbJ.iterator();
      while (paramArrayOfByte.hasNext())
      {
        ezh localezh = (ezh)paramArrayOfByte.next();
        if (localezh == null)
        {
          params.add(localezh);
        }
        else
        {
          if (localezh.UzK == null) {
            params.add(localezh);
          }
          if ((Math.abs(localezh.UzK.RVy) > 180.0D) || (Math.abs(localezh.UzK.RVz) > 90.0D))
          {
            Log.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localezh.Username, Double.valueOf(localezh.UzK.RVz), Double.valueOf(localezh.UzK.RVy), Double.valueOf(localezh.UzK.TUj) });
            params.add(localezh);
          }
        }
      }
      this.EkY.rVx = this.EkY.UbJ.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.maA != null) {
      this.maA.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */