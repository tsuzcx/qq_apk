package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class am
  extends m
  implements k
{
  private f callback;
  private am.a muA;
  private SparseArray<String> muB;
  private List<Integer> muz;
  private final b rr;
  private int scene;
  private String toUser;
  
  public am(String paramString, List<Integer> paramList, am.a parama)
  {
    AppMethodBeat.i(102746);
    this.callback = null;
    this.muA = null;
    this.muB = new SparseArray();
    b.a locala = new b.a();
    locala.fsX = new ccd();
    locala.fsY = new cce();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.reqCmdId = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.ado();
    this.toUser = paramString;
    this.scene = 2;
    this.muz = paramList;
    this.muA = parama;
    AppMethodBeat.o(102746);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(102748);
    ccd localccd = (ccd)this.rr.fsV.fta;
    localccd.xMA = this.toUser;
    localccd.Scene = this.scene;
    localccd.wuv = new LinkedList(this.muz);
    localccd.jJu = localccd.wuv.size();
    ab.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localccd.xMA, Integer.valueOf(localccd.Scene), localccd.wuv, Integer.valueOf(localccd.jJu) });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(102748);
    return i;
  }
  
  public final int getType()
  {
    return 608;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102747);
    ab.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.muB.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cce)((b)paramq).fsW.fta;
      if (paramq.xgi != this.muz.size()) {
        ab.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.muz.size()), Integer.valueOf(paramq.xgi) });
      }
      paramInt1 = 0;
      while ((paramInt1 < paramq.wuF.size()) && (paramInt1 < this.muz.size()))
      {
        ab.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.muz.get(paramInt1), paramq.wuF.get(paramInt1) });
        this.muB.put(((Integer)this.muz.get(paramInt1)).intValue(), ((bwc)paramq.wuF.get(paramInt1)).xJE);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.muA != null) {
      this.muA.d(this.muB);
    }
    AppMethodBeat.o(102747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */