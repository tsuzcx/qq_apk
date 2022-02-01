package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
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
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dxq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class an
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int scene;
  private List<Integer> tbG;
  private a tbH;
  private SparseArray<String> tbI;
  private String toUser;
  
  public an(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.tbH = null;
    this.tbI = new SparseArray();
    d.a locala = new d.a();
    locala.iLN = new dxp();
    locala.iLO = new dxq();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.iLP = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.aXF();
    this.toUser = paramString;
    this.scene = 2;
    this.tbG = paramList;
    this.tbH = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103488);
    dxp localdxp = (dxp)this.rr.iLK.iLR;
    localdxp.MXp = this.toUser;
    localdxp.Scene = this.scene;
    localdxp.KOn = new LinkedList(this.tbG);
    localdxp.oTz = localdxp.KOn.size();
    Log.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localdxp.MXp, Integer.valueOf(localdxp.Scene), localdxp.KOn, Integer.valueOf(localdxp.oTz) });
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
    this.tbI.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dxq)((d)params).iLL.iLR;
      if (params.Mcp != this.tbG.size()) {
        Log.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.tbG.size()), Integer.valueOf(params.Mcp) });
      }
      paramInt1 = 0;
      while ((paramInt1 < params.KOv.size()) && (paramInt1 < this.tbG.size()))
      {
        Log.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.tbG.get(paramInt1), params.KOv.get(paramInt1) });
        this.tbI.put(((Integer)this.tbG.get(paramInt1)).intValue(), ((dqi)params.KOv.get(paramInt1)).MTo);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.tbH != null) {
      this.tbH.e(this.tbI);
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