package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpt;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class am
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int scene;
  public int tbB;
  public f tbC;
  private LinkedList<cpv> tbD;
  private LinkedList<cps> tbE;
  public String tbF;
  public int type;
  
  public am(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.tbE, paramf.field_modItem.LxK, 1);
    this.tbC = paramf;
  }
  
  public am(int paramInt, LinkedList<cps> paramLinkedList, LinkedList<cpv> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private am(int paramInt1, LinkedList<cps> paramLinkedList, LinkedList<cpv> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new cpt();
    locala.iLO = new cpu();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.iLP = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.aXF();
    this.tbD = paramLinkedList1;
    this.tbE = paramLinkedList;
    this.tbB = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public am(int paramInt, LinkedList<cps> paramLinkedList, LinkedList<cpv> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.tbF = paramString;
  }
  
  public am(int paramInt, LinkedList<cps> paramLinkedList, LinkedList<cpv> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.tbF = paramString;
    this.scene = 1;
  }
  
  public final long cVe()
  {
    if (this.tbC == null) {
      return -1L;
    }
    return this.tbC.field_localId;
  }
  
  public final int cVf()
  {
    if (this.tbC == null) {
      return -1;
    }
    return this.tbC.field_type;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.tbE == null) || (this.tbE.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    cpt localcpt = (cpt)this.rr.iLK.iLR;
    localcpt.MvK = this.tbE.size();
    if (this.tbD != null) {
      localcpt.MvM = this.tbD.size();
    }
    for (localcpt.KOH = this.tbD;; localcpt.KOH = new LinkedList())
    {
      if (!Util.isNullOrNil(this.tbF)) {
        localcpt.MvN = this.tbF;
      }
      localcpt.MvK = this.tbE.size();
      localcpt.MvL = this.tbE;
      localcpt.KGZ = this.tbB;
      localcpt.Scene = this.scene;
      this.callback = parami;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localcpt.MvM = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    Log.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.tbB + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(this.tbB));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */