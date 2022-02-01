package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class am
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private final com.tencent.mm.al.b rr;
  public int rtK;
  public f rtL;
  private LinkedList<bzz> rtM;
  private LinkedList<bzw> rtN;
  public String rtO;
  private int scene;
  public int type;
  
  public am(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.rtN, paramf.field_modItem.Gjf, 1);
    this.rtL = paramf;
  }
  
  public am(int paramInt, LinkedList<bzw> paramLinkedList, LinkedList<bzz> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private am(int paramInt1, LinkedList<bzw> paramLinkedList, LinkedList<bzz> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new bzx();
    locala.hNN = new bzy();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.hNO = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.aDC();
    this.rtM = paramLinkedList1;
    this.rtN = paramLinkedList;
    this.rtK = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public am(int paramInt, LinkedList<bzw> paramLinkedList, LinkedList<bzz> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.rtO = paramString;
  }
  
  public am(int paramInt, LinkedList<bzw> paramLinkedList, LinkedList<bzz> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.rtO = paramString;
    this.scene = 1;
  }
  
  public final int cvA()
  {
    if (this.rtL == null) {
      return -1;
    }
    return this.rtL.field_type;
  }
  
  public final long cvz()
  {
    if (this.rtL == null) {
      return -1L;
    }
    return this.rtL.field_localId;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.rtN == null) || (this.rtN.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    bzx localbzx = (bzx)this.rr.hNK.hNQ;
    localbzx.GUO = this.rtN.size();
    if (this.rtM != null) {
      localbzx.GUQ = this.rtM.size();
    }
    for (localbzx.FCD = this.rtM;; localbzx.FCD = new LinkedList())
    {
      if (!bt.isNullOrNil(this.rtO)) {
        localbzx.GUR = this.rtO;
      }
      localbzx.GUO = this.rtN.size();
      localbzx.GUP = this.rtN;
      localbzx.FuW = this.rtK;
      localbzx.Scene = this.scene;
      this.callback = paramf;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localbzx.GUQ = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    ad.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.rtK + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((af)g.ad(af.class)).getFavItemInfoStorage().vF(this.rtK));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */