package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class an
  extends n
  implements k
{
  private f callback;
  private List<Integer> rCb;
  private a rCc;
  private SparseArray<String> rCd;
  private final b rr;
  private int scene;
  private String toUser;
  
  public an(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.rCc = null;
    this.rCd = new SparseArray();
    b.a locala = new b.a();
    locala.hQF = new del();
    locala.hQG = new dem();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.hQH = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.aDS();
    this.toUser = paramString;
    this.scene = 2;
    this.rCb = paramList;
    this.rCc = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103488);
    del localdel = (del)this.rr.hQD.hQJ;
    localdel.HLG = this.toUser;
    localdel.Scene = this.scene;
    localdel.FUE = new LinkedList(this.rCb);
    localdel.nID = localdel.FUE.size();
    ae.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localdel.HLG, Integer.valueOf(localdel.Scene), localdel.FUE, Integer.valueOf(localdel.nID) });
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
    ae.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.rCd.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (dem)((b)paramq).hQE.hQJ;
      if (paramq.GXA != this.rCb.size()) {
        ae.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.rCb.size()), Integer.valueOf(paramq.GXA) });
      }
      paramInt1 = 0;
      while ((paramInt1 < paramq.FUN.size()) && (paramInt1 < this.rCb.size()))
      {
        ae.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.rCb.get(paramInt1), paramq.FUN.get(paramInt1) });
        this.rCd.put(((Integer)this.rCb.get(paramInt1)).intValue(), ((cxn)paramq.FUN.get(paramInt1)).HId);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.rCc != null) {
      this.rCc.e(this.rCd);
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