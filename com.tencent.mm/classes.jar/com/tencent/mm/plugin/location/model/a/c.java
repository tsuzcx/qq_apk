package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.bjz;
import com.tencent.mm.protocal.c.bka;
import com.tencent.mm.protocal.c.byn;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  private Runnable eAk;
  public String gfH;
  public int lEq;
  public byn lEr = null;
  public List<ccg> lEs = null;
  public bka lEt;
  public int lEu;
  private String lEv;
  
  public c(String paramString, int paramInt1, ccg paramccg, int paramInt2, byn parambyn)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bjz();
    ((b.a)localObject).ecI = new bka();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
    ((b.a)localObject).ecG = 492;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bjz)this.dmK.ecE.ecN;
    ((bjz)localObject).sTd = paramString;
    ((bjz)localObject).hQR = paramInt1;
    ((bjz)localObject).tDN = paramccg;
    ((bjz)localObject).kTR = paramInt2;
    ((bjz)localObject).tDO = parambyn;
    this.lEv = paramString;
    this.lEu = ((bjz)localObject).hQR;
    y.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + paramccg.sxM + " " + paramccg.tRA.sDn + " " + paramccg.tRA.sDm + " heading:" + paramccg.tRA.tzO);
    y.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + parambyn.sDn + " " + parambyn.sDm + " " + parambyn.kRZ);
    y.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + paramString + " uploadStatus:" + paramInt1);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.lEt = ((bka)((b)paramq).ecF.ecN);
    if (this.lEt != null) {
      this.gfH = this.lEt.sHj;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.lEq = this.lEt.tox;
      this.lEr = this.lEt.tDQ;
      this.lEs = this.lEt.tDP;
      paramq = new StringBuffer();
      paramq.append(String.format("[ resp count %d ] ", new Object[] { Integer.valueOf(this.lEt.hPS) }));
      if (this.lEr != null) {
        paramq.append(String.format("[ roomPoi  %f %f %s] ", new Object[] { Double.valueOf(this.lEr.sDn), Double.valueOf(this.lEr.sDm), this.lEr.kRZ }));
      }
      y.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + paramq.toString());
      paramq = new LinkedList();
      paramArrayOfByte = this.lEt.tDP.iterator();
      while (paramArrayOfByte.hasNext())
      {
        ccg localccg = (ccg)paramArrayOfByte.next();
        if (localccg == null)
        {
          paramq.add(localccg);
        }
        else
        {
          if (localccg.tRA == null) {
            paramq.add(localccg);
          }
          if ((Math.abs(localccg.tRA.sDm) > 180.0D) || (Math.abs(localccg.tRA.sDn) > 90.0D))
          {
            y.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[] { localccg.sxM, Double.valueOf(localccg.tRA.sDn), Double.valueOf(localccg.tRA.sDm), Double.valueOf(localccg.tRA.tzO) });
            paramq.add(localccg);
          }
        }
      }
      this.lEt.hPS = this.lEt.tDP.size();
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.eAk != null) {
      this.eAk.run();
    }
  }
  
  public final int getType()
  {
    return 492;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.c
 * JD-Core Version:    0.7.0.1
 */