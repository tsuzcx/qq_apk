package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class am
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public int qbc;
  public f qbd;
  private LinkedList<bqt> qbe;
  private LinkedList<bqq> qbf;
  public String qbg;
  private final com.tencent.mm.al.b rr;
  private int scene;
  public int type;
  
  public am(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.qbf, paramf.field_modItem.Din, 1);
    this.qbd = paramf;
  }
  
  public am(int paramInt, LinkedList<bqq> paramLinkedList, LinkedList<bqt> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private am(int paramInt1, LinkedList<bqq> paramLinkedList, LinkedList<bqt> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    b.a locala = new b.a();
    locala.gUU = new bqr();
    locala.gUV = new bqs();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.reqCmdId = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.atI();
    this.qbe = paramLinkedList1;
    this.qbf = paramLinkedList;
    this.qbc = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public am(int paramInt, LinkedList<bqq> paramLinkedList, LinkedList<bqt> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.qbg = paramString;
  }
  
  public am(int paramInt, LinkedList<bqq> paramLinkedList, LinkedList<bqt> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.qbg = paramString;
    this.scene = 1;
  }
  
  public final long cin()
  {
    if (this.qbd == null) {
      return -1L;
    }
    return this.qbd.field_localId;
  }
  
  public final int cio()
  {
    if (this.qbd == null) {
      return -1;
    }
    return this.qbd.field_type;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.qbf == null) || (this.qbf.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    bqr localbqr = (bqr)this.rr.gUS.gUX;
    localbqr.DOP = this.qbf.size();
    if (this.qbe != null) {
      localbqr.DOR = this.qbe.size();
    }
    for (localbqr.CEH = this.qbe;; localbqr.CEH = new LinkedList())
    {
      if (!bt.isNullOrNil(this.qbg)) {
        localbqr.DOS = this.qbg;
      }
      localbqr.DOP = this.qbf.size();
      localbqr.DOQ = this.qbf;
      localbqr.Cxl = this.qbc;
      localbqr.Scene = this.scene;
      this.callback = paramg;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localbqr.DOR = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    ad.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.qbc + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(this.qbc));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */