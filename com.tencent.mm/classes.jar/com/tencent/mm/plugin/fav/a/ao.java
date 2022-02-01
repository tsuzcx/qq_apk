package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class ao
  extends p
  implements m
{
  public int AdU;
  public f AdV;
  private LinkedList<dpr> AdW;
  private LinkedList<dpo> AdX;
  public String AdY;
  private com.tencent.mm.am.h callback;
  private final c rr;
  private int scene;
  public int type;
  
  public ao(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.AdX, paramf.field_modItem.ZBd, 1);
    this.AdV = paramf;
  }
  
  public ao(int paramInt, LinkedList<dpo> paramLinkedList, LinkedList<dpr> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private ao(int paramInt1, LinkedList<dpo> paramLinkedList, LinkedList<dpr> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = new dpp();
    locala.otF = new dpq();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.otG = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.bEF();
    this.AdW = paramLinkedList1;
    this.AdX = paramLinkedList;
    this.AdU = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public ao(int paramInt, LinkedList<dpo> paramLinkedList, LinkedList<dpr> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.AdY = paramString;
  }
  
  public ao(int paramInt, LinkedList<dpo> paramLinkedList, LinkedList<dpr> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.AdY = paramString;
    this.scene = 1;
  }
  
  public final long dQW()
  {
    if (this.AdV == null) {
      return -1L;
    }
    return this.AdV.field_localId;
  }
  
  public final int dQX()
  {
    if (this.AdV == null) {
      return -1;
    }
    return this.AdV.field_type;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.AdX == null) || (this.AdX.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    dpp localdpp = (dpp)c.b.b(this.rr.otB);
    localdpp.aaWp = this.AdX.size();
    if (this.AdW != null) {
      localdpp.aaWr = this.AdW.size();
    }
    for (localdpp.YMT = this.AdW;; localdpp.YMT = new LinkedList())
    {
      if (!Util.isNullOrNil(this.AdY)) {
        localdpp.aaWs = this.AdY;
      }
      localdpp.aaWp = this.AdX.size();
      localdpp.aaWq = this.AdX;
      localdpp.YFt = this.AdU;
      localdpp.IJG = this.scene;
      this.callback = paramh;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localdpp.aaWr = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    Log.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.AdU + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(this.AdU));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ao
 * JD-Core Version:    0.7.0.1
 */