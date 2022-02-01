package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class an
  extends n
  implements k
{
  private g callback;
  private List<Integer> qJN;
  private a qJO;
  private SparseArray<String> qJP;
  private final b rr;
  private int scene;
  private String toUser;
  
  public an(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.qJO = null;
    this.qJP = new SparseArray();
    b.a locala = new b.a();
    locala.hvt = new cye();
    locala.hvu = new cyf();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.reqCmdId = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.aAz();
    this.toUser = paramString;
    this.scene = 2;
    this.qJN = paramList;
    this.qJO = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103488);
    cye localcye = (cye)this.rr.hvr.hvw;
    localcye.FHw = this.toUser;
    localcye.Scene = this.scene;
    localcye.DWN = new LinkedList(this.qJN);
    localcye.ncL = localcye.DWN.size();
    ac.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localcye.FHw, Integer.valueOf(localcye.Scene), localcye.DWN, Integer.valueOf(localcye.ncL) });
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.qJP.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cyf)((b)paramq).hvs.hvw;
      if (paramq.EUA != this.qJN.size()) {
        ac.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.qJN.size()), Integer.valueOf(paramq.EUA) });
      }
      paramInt1 = 0;
      while ((paramInt1 < paramq.DWW.size()) && (paramInt1 < this.qJN.size()))
      {
        ac.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.qJN.get(paramInt1), paramq.DWW.get(paramInt1) });
        this.qJP.put(((Integer)this.qJN.get(paramInt1)).intValue(), ((crm)paramq.DWW.get(paramInt1)).FEm);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.qJO != null) {
      this.qJO.d(this.qJP);
    }
    AppMethodBeat.o(103487);
  }
  
  public static abstract interface a
  {
    public abstract void d(SparseArray<String> paramSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.an
 * JD-Core Version:    0.7.0.1
 */