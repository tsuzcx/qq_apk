package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
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
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class an
  extends n
  implements k
{
  private f callback;
  private final b rr;
  private List<Integer> rtP;
  private a rtQ;
  private SparseArray<String> rtR;
  private int scene;
  private String toUser;
  
  public an(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.rtQ = null;
    this.rtR = new SparseArray();
    b.a locala = new b.a();
    locala.hNM = new ddr();
    locala.hNN = new dds();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.hNO = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.aDC();
    this.toUser = paramString;
    this.scene = 2;
    this.rtP = paramList;
    this.rtQ = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103488);
    ddr localddr = (ddr)this.rr.hNK.hNQ;
    localddr.Hse = this.toUser;
    localddr.Scene = this.scene;
    localddr.FCj = new LinkedList(this.rtP);
    localddr.nDi = localddr.FCj.size();
    ad.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localddr.Hse, Integer.valueOf(localddr.Scene), localddr.FCj, Integer.valueOf(localddr.nDi) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103488);
    return i;
  }
  
  public final int getType()
  {
    return 608;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103487);
    ad.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.rtR.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (dds)((b)paramq).hNL.hNQ;
      if (paramq.GDX != this.rtP.size()) {
        ad.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.rtP.size()), Integer.valueOf(paramq.GDX) });
      }
      paramInt1 = 0;
      while ((paramInt1 < paramq.FCs.size()) && (paramInt1 < this.rtP.size()))
      {
        ad.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.rtP.get(paramInt1), paramq.FCs.get(paramInt1) });
        this.rtR.put(((Integer)this.rtP.get(paramInt1)).intValue(), ((cwt)paramq.FCs.get(paramInt1)).HoB);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.rtQ != null) {
      this.rtQ.e(this.rtR);
    }
    AppMethodBeat.o(103487);
  }
  
  public static abstract interface a
  {
    public abstract void e(SparseArray<String> paramSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.an
 * JD-Core Version:    0.7.0.1
 */