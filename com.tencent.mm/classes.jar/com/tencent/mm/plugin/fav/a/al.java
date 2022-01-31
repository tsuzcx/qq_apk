package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class al
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public int muu;
  public f muv;
  private LinkedList<beb> muw;
  private LinkedList<bdy> mux;
  public String muy;
  private final com.tencent.mm.ai.b rr;
  private int scene;
  public int type;
  
  public al(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.mux, paramf.field_modItem.wUK, 1);
    this.muv = paramf;
  }
  
  public al(int paramInt, LinkedList<bdy> paramLinkedList, LinkedList<beb> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private al(int paramInt1, LinkedList<bdy> paramLinkedList, LinkedList<beb> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(102743);
    this.callback = null;
    b.a locala = new b.a();
    locala.fsX = new bdz();
    locala.fsY = new bea();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.reqCmdId = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.ado();
    this.muw = paramLinkedList1;
    this.mux = paramLinkedList;
    this.muu = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(102743);
  }
  
  public al(int paramInt, LinkedList<bdy> paramLinkedList, LinkedList<beb> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.muy = paramString;
  }
  
  public al(int paramInt, LinkedList<bdy> paramLinkedList, LinkedList<beb> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.muy = paramString;
    this.scene = 1;
  }
  
  public final long bwX()
  {
    if (this.muv == null) {
      return -1L;
    }
    return this.muv.field_localId;
  }
  
  public final int bwY()
  {
    if (this.muv == null) {
      return -1;
    }
    return this.muv.field_type;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(102744);
    if ((this.scene == 0) && ((this.mux == null) || (this.mux.size() == 0)))
    {
      AppMethodBeat.o(102744);
      return -1;
    }
    bdz localbdz = (bdz)this.rr.fsV.fta;
    localbdz.xtM = this.mux.size();
    if (this.muw != null) {
      localbdz.xtO = this.muw.size();
    }
    for (localbdz.wuP = this.muw;; localbdz.wuP = new LinkedList())
    {
      if (!bo.isNullOrNil(this.muy)) {
        localbdz.xtP = this.muy;
      }
      localbdz.xtM = this.mux.size();
      localbdz.xtN = this.mux;
      localbdz.woD = this.muu;
      localbdz.Scene = this.scene;
      this.callback = paramf;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(102744);
      return i;
      localbdz.xtO = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102745);
    ab.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.muu + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((ae)g.G(ae.class)).getFavItemInfoStorage().kc(this.muu));
    AppMethodBeat.o(102745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */