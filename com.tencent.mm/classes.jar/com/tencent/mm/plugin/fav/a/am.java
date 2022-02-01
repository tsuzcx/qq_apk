package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class am
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public int rBW;
  public f rBX;
  private LinkedList<cat> rBY;
  private LinkedList<caq> rBZ;
  public String rCa;
  private final com.tencent.mm.ak.b rr;
  private int scene;
  public int type;
  
  public am(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.rBZ, paramf.field_modItem.GBO, 1);
    this.rBX = paramf;
  }
  
  public am(int paramInt, LinkedList<caq> paramLinkedList, LinkedList<cat> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private am(int paramInt1, LinkedList<caq> paramLinkedList, LinkedList<cat> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new car();
    locala.hQG = new cas();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.hQH = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.aDS();
    this.rBY = paramLinkedList1;
    this.rBZ = paramLinkedList;
    this.rBW = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public am(int paramInt, LinkedList<caq> paramLinkedList, LinkedList<cat> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.rCa = paramString;
  }
  
  public am(int paramInt, LinkedList<caq> paramLinkedList, LinkedList<cat> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.rCa = paramString;
    this.scene = 1;
  }
  
  public final long cxa()
  {
    if (this.rBX == null) {
      return -1L;
    }
    return this.rBX.field_localId;
  }
  
  public final int cxb()
  {
    if (this.rBX == null) {
      return -1;
    }
    return this.rBX.field_type;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.rBZ == null) || (this.rBZ.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    car localcar = (car)this.rr.hQD.hQJ;
    localcar.Hop = this.rBZ.size();
    if (this.rBY != null) {
      localcar.Hor = this.rBY.size();
    }
    for (localcar.FUY = this.rBY;; localcar.FUY = new LinkedList())
    {
      if (!bu.isNullOrNil(this.rCa)) {
        localcar.Hos = this.rCa;
      }
      localcar.Hop = this.rBZ.size();
      localcar.Hoq = this.rBZ;
      localcar.FNu = this.rBW;
      localcar.Scene = this.scene;
      this.callback = paramf;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localcar.Hor = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    ae.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.rBW + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((af)g.ad(af.class)).getFavItemInfoStorage().vV(this.rBW));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */