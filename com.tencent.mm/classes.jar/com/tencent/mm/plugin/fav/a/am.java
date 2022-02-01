package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class am
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public int qJI;
  public f qJJ;
  private LinkedList<bvk> qJK;
  private LinkedList<bvh> qJL;
  public String qJM;
  private final com.tencent.mm.ak.b rr;
  private int scene;
  public int type;
  
  public am(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.qJL, paramf.field_modItem.EBt, 1);
    this.qJJ = paramf;
  }
  
  public am(int paramInt, LinkedList<bvh> paramLinkedList, LinkedList<bvk> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private am(int paramInt1, LinkedList<bvh> paramLinkedList, LinkedList<bvk> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new bvi();
    locala.hvu = new bvj();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.reqCmdId = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.aAz();
    this.qJK = paramLinkedList1;
    this.qJL = paramLinkedList;
    this.qJI = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public am(int paramInt, LinkedList<bvh> paramLinkedList, LinkedList<bvk> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.qJM = paramString;
  }
  
  public am(int paramInt, LinkedList<bvh> paramLinkedList, LinkedList<bvk> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.qJM = paramString;
    this.scene = 1;
  }
  
  public final long cpU()
  {
    if (this.qJJ == null) {
      return -1L;
    }
    return this.qJJ.field_localId;
  }
  
  public final int cpV()
  {
    if (this.qJJ == null) {
      return -1;
    }
    return this.qJJ.field_type;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.qJL == null) || (this.qJL.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    bvi localbvi = (bvi)this.rr.hvr.hvw;
    localbvi.Flg = this.qJL.size();
    if (this.qJK != null) {
      localbvi.Fli = this.qJK.size();
    }
    for (localbvi.DXh = this.qJK;; localbvi.DXh = new LinkedList())
    {
      if (!bs.isNullOrNil(this.qJM)) {
        localbvi.Flj = this.qJM;
      }
      localbvi.Flg = this.qJL.size();
      localbvi.Flh = this.qJL;
      localbvi.DPH = this.qJI;
      localbvi.Scene = this.scene;
      this.callback = paramg;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localbvi.Fli = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    ac.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.qJI + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(this.qJI));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */