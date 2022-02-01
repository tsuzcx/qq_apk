package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.fbr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class ap
  extends p
  implements m
{
  private List<Integer> AdZ;
  private a Aea;
  private SparseArray<String> Aeb;
  private h callback;
  private final c rr;
  private int scene;
  private String toUser;
  
  public ap(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.Aea = null;
    this.Aeb = new SparseArray();
    c.a locala = new c.a();
    locala.otE = new fbq();
    locala.otF = new fbr();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.otG = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.bEF();
    this.toUser = paramString;
    this.scene = 2;
    this.AdZ = paramList;
    this.Aea = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103488);
    fbq localfbq = (fbq)c.b.b(this.rr.otB);
    localfbq.abBo = this.toUser;
    localfbq.IJG = this.scene;
    localfbq.YMw = new LinkedList(this.AdZ);
    localfbq.vgN = localfbq.YMw.size();
    Log.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localfbq.abBo, Integer.valueOf(localfbq.IJG), localfbq.YMw, Integer.valueOf(localfbq.vgN) });
    this.callback = paramh;
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
    this.Aeb.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (fbr)c.c.b(((c)params).otC);
      if (params.aazK != this.AdZ.size()) {
        Log.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.AdZ.size()), Integer.valueOf(params.aazK) });
      }
      paramInt1 = 0;
      while ((paramInt1 < params.YMG.size()) && (paramInt1 < this.AdZ.size()))
      {
        Log.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.AdZ.get(paramInt1), params.YMG.get(paramInt1) });
        this.Aeb.put(((Integer)this.AdZ.get(paramInt1)).intValue(), ((etl)params.YMG.get(paramInt1)).abwM);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.Aea != null) {
      this.Aea.e(this.Aeb);
    }
    AppMethodBeat.o(103487);
  }
  
  public static abstract interface a
  {
    public abstract void e(SparseArray<String> paramSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ap
 * JD-Core Version:    0.7.0.1
 */