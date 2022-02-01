package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  private Runnable jkz;
  public String qwG;
  public final d rr;
  public int yHb;
  public ejg yHc;
  public List<eox> yHd;
  public dmb yHe;
  public int yHf;
  private String yHg;
  
  public c(String paramString, int paramInt1, eox parameox, int paramInt2, ejg paramejg)
  {
    AppMethodBeat.i(55791);
    this.yHc = null;
    this.yHd = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dma();
    ((d.a)localObject).iLO = new dmb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((d.a)localObject).funcId = 492;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dma)this.rr.iLK.iLR;
    ((dma)localObject).Ltk = paramString;
    ((dma)localObject).oUv = paramInt1;
    ((dma)localObject).MPD = parameox;
    ((dma)localObject).hil = paramInt2;
    ((dma)localObject).MPE = paramejg;
    this.yHg = paramString;
    this.yHf = ((dma)localObject).oUv;
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + parameox.Username + " " + parameox.NmV.KUu + " " + parameox.NmV.KUt + " heading:" + parameox.NmV.MIv);
    Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + paramejg.KUu + " " + paramejg.KUt + " " + paramejg.Name);
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
    this.yHe = ((dmb)((d)params).iLL.iLR);
    if (this.yHe != null) {
      this.qwG = this.yHe.KOu;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.yHb = this.yHe.MlI;
      this.yHc = this.yHe.MPG;
      this.yHd = this.yHe.MPF;
      params = new StringBuffer();
      params.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.yHe.oTz) }));
      if (this.yHc != null) {
        params.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.yHc.KUu), Double.valueOf(this.yHc.KUt), this.yHc.Name }));
      }
      Log.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + params.toString());
      params = new LinkedList();
      paramArrayOfByte = this.yHe.MPF.iterator();
      while (paramArrayOfByte.hasNext())
      {
        eox localeox = (eox)paramArrayOfByte.next();
        if (localeox == null)
        {
          params.add(localeox);
        }
        else
        {
          if (localeox.NmV == null) {
            params.add(localeox);
          }
          if ((Math.abs(localeox.NmV.KUt) > 180.0D) || (Math.abs(localeox.NmV.KUu) > 90.0D))
          {
            Log.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localeox.Username, Double.valueOf(localeox.NmV.KUu), Double.valueOf(localeox.NmV.KUt), Double.valueOf(localeox.NmV.MIv) });
            params.add(localeox);
          }
        }
      }
      this.yHe.oTz = this.yHe.MPF.size();
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.jkz != null) {
      this.jkz.run();
    }
    AppMethodBeat.o(55793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */