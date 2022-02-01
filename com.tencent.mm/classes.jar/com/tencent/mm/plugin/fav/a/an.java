package com.tencent.mm.plugin.fav.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class an
  extends n
  implements k
{
  private g callback;
  private List<Integer> qbh;
  private a qbi;
  private SparseArray<String> qbj;
  private final b rr;
  private int scene;
  private String toUser;
  
  public an(String paramString, List<Integer> paramList, a parama)
  {
    AppMethodBeat.i(103486);
    this.callback = null;
    this.qbi = null;
    this.qbj = new SparseArray();
    b.a locala = new b.a();
    locala.gUU = new csv();
    locala.gUV = new csw();
    locala.uri = "/cgi-bin/micromsg-bin/sharefav";
    locala.funcId = 608;
    locala.reqCmdId = 246;
    locala.respCmdId = 1000000246;
    this.rr = locala.atI();
    this.toUser = paramString;
    this.scene = 2;
    this.qbh = paramList;
    this.qbi = parama;
    AppMethodBeat.o(103486);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103488);
    csv localcsv = (csv)this.rr.gUS.gUX;
    localcsv.Eky = this.toUser;
    localcsv.Scene = this.scene;
    localcsv.CEn = new LinkedList(this.qbh);
    localcsv.mAK = localcsv.CEn.size();
    ad.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[] { localcsv.Eky, Integer.valueOf(localcsv.Scene), localcsv.CEn, Integer.valueOf(localcsv.mAK) });
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
    ad.d("MicroMsg.NetSceneShareFavItem", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.qbj.clear();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (csw)((b)paramq).gUT.gUX;
      if (paramq.Dze != this.qbh.size()) {
        ad.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[] { Integer.valueOf(this.qbh.size()), Integer.valueOf(paramq.Dze) });
      }
      paramInt1 = 0;
      while ((paramInt1 < paramq.CEw.size()) && (paramInt1 < this.qbh.size()))
      {
        ad.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[] { this.qbh.get(paramInt1), paramq.CEw.get(paramInt1) });
        this.qbj.put(((Integer)this.qbh.get(paramInt1)).intValue(), ((cmf)paramq.CEw.get(paramInt1)).Ehn);
        paramInt1 += 1;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.qbi != null) {
      this.qbi.d(this.qbj);
    }
    AppMethodBeat.o(103487);
  }
  
  public static abstract interface a
  {
    public abstract void d(SparseArray<String> paramSparseArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.an
 * JD-Core Version:    0.7.0.1
 */