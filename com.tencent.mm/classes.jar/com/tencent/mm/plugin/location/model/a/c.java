package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fot;
import com.tencent.mm.protocal.protobuf.fvj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends p
  implements m
{
  public int KdE;
  public fot KdF;
  public List<fvj> KdG;
  public eor KdH;
  public int KdI;
  private String KdJ;
  private h callback;
  private Runnable oTq;
  public final com.tencent.mm.am.c rr;
  public String wZb;
  
  public c(String paramString, int paramInt1, fvj paramfvj, int paramInt2, fot paramfot)
  {
    AppMethodBeat.i(55791);
    this.KdF = null;
    this.KdG = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eoq();
    ((c.a)localObject).otF = new eor();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((c.a)localObject).funcId = 492;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eoq)c.b.b(this.rr.otB);
    ((eoq)localObject).ZvR = paramString;
    ((eoq)localObject).vhJ = paramInt1;
    ((eoq)localObject).absQ = paramfvj;
    ((eoq)localObject).muB = paramInt2;
    ((eoq)localObject).absR = paramfot;
    this.KdJ = paramString;
    this.KdI = ((eoq)localObject).vhJ;
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramfvj.Username + " " + paramfvj.abTG.YTd + " " + paramfvj.abTG.YTc + " heading:" + paramfvj.abTG.abkT);
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramfot.YTd + " " + paramfot.YTc + " " + paramfot.IGU);
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
    AppMethodBeat.o(55791);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(55792);
    this.callback = paramh;
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
    this.KdH = ((eor)c.c.b(((com.tencent.mm.am.c)params).otC));
    if (this.KdH != null) {
      this.wZb = this.KdH.YMF;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.KdE = this.KdH.aaLi;
      this.KdF = this.KdH.absT;
      this.KdG = this.KdH.absS;
      params = new StringBuffer();
      params.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.KdH.vgN) }));
      if (this.KdF != null) {
        params.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.KdF.YTd), Double.valueOf(this.KdF.YTc), this.KdF.IGU }));
      }
      Log.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + params.toString());
      params = new LinkedList();
      paramArrayOfByte = this.KdH.absS.iterator();
      while (paramArrayOfByte.hasNext())
      {
        fvj localfvj = (fvj)paramArrayOfByte.next();
        if (localfvj == null)
        {
          params.add(localfvj);
        }
        else
        {
          if (localfvj.abTG == null) {
            params.add(localfvj);
          }
          if ((Math.abs(localfvj.abTG.YTc) > 180.0D) || (Math.abs(localfvj.abTG.YTd) > 90.0D))
          {
            Log.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localfvj.Username, Double.valueOf(localfvj.abTG.YTd), Double.valueOf(localfvj.abTG.YTc), Double.valueOf(localfvj.abTG.abkT) });
            params.add(localfvj);
          }
        }
      }
      this.KdH.vgN = this.KdH.absS.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.oTq != null) {
      this.oTq.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */