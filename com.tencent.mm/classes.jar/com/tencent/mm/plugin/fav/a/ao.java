package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
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
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ehq;
import com.tencent.mm.protocal.protobuf.ehr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class ao
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int scene;
  private String toUser;
  private List<Integer> wHL;
  private a wHM;
  private SparseArray<String> wHN;
  
  public ao(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.wHM = null;
    this.wHN = new SparseArray();
    d.a locala = new d.a();
    locala.lBU = new ehq();
    locala.lBV = new ehr();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.lBW = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.bgN();
    this.toUser = paramString;
    this.scene = 2;
    this.wHL = paramList;
    this.wHM = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103488);
    ehq localehq = (ehq)d.b.b(this.rr.lBR);
    localehq.UjK = this.toUser;
    localehq.CPw = this.scene;
    localehq.RPj = new LinkedList(this.wHL);
    localehq.rVx = localehq.RPj.size();
    Log.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localehq.UjK, Integer.valueOf(localehq.CPw), localehq.RPj, Integer.valueOf(localehq.rVx) });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103488);
    return i;
  }
  
  public final int getType()
  {
    return 608;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103487);
    Log.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.wHN.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ehr)d.c.b(((d)params).lBS);
      if (params.TlO != this.wHL.size()) {
        Log.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.wHL.size()), Integer.valueOf(params.TlO) });
      }
      paramInt1 = 0;
      while ((paramInt1 < params.RPt.size()) && (paramInt1 < this.wHL.size()))
      {
        Log.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.wHL.get(paramInt1), params.RPt.get(paramInt1) });
        this.wHN.put(((Integer)this.wHL.get(paramInt1)).intValue(), ((eaf)params.RPt.get(paramInt1)).Ufy);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.wHM != null) {
      this.wHM.e(this.wHN);
    }
    AppMethodBeat.o(103487);
  }
  
  public static abstract interface a
  {
    public abstract void e(SparseArray<String> paramSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ao
 * JD-Core Version:    0.7.0.1
 */