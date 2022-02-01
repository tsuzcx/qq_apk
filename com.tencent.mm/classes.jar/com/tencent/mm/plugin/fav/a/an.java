package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class an
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private int scene;
  public int type;
  public int wHG;
  public f wHH;
  private LinkedList<cyl> wHI;
  private LinkedList<cyi> wHJ;
  public String wHK;
  
  public an(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.wHJ, paramf.field_modItem.SAl, 1);
    this.wHH = paramf;
  }
  
  public an(int paramInt, LinkedList<cyi> paramLinkedList, LinkedList<cyl> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private an(int paramInt1, LinkedList<cyi> paramLinkedList, LinkedList<cyl> paramLinkedList1, int paramInt2)
  {
    AppMethodBeat.i(103483);
    this.callback = null;
    d.a locala = new d.a();
    locala.lBU = new cyj();
    locala.lBV = new cyk();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.funcId = 426;
    locala.lBW = 216;
    locala.respCmdId = 1000000216;
    this.rr = locala.bgN();
    this.wHI = paramLinkedList1;
    this.wHJ = paramLinkedList;
    this.wHG = paramInt1;
    this.type = paramInt2;
    AppMethodBeat.o(103483);
  }
  
  public an(int paramInt, LinkedList<cyi> paramLinkedList, LinkedList<cyl> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.wHK = paramString;
  }
  
  public an(int paramInt, LinkedList<cyi> paramLinkedList, LinkedList<cyl> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.wHK = paramString;
    this.scene = 1;
  }
  
  public final long dkk()
  {
    if (this.wHH == null) {
      return -1L;
    }
    return this.wHH.field_localId;
  }
  
  public final int dkl()
  {
    if (this.wHH == null) {
      return -1;
    }
    return this.wHH.field_type;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103484);
    if ((this.scene == 0) && ((this.wHJ == null) || (this.wHJ.size() == 0)))
    {
      AppMethodBeat.o(103484);
      return -1;
    }
    cyj localcyj = (cyj)d.b.b(this.rr.lBR);
    localcyj.TGI = this.wHJ.size();
    if (this.wHI != null) {
      localcyj.TGK = this.wHI.size();
    }
    for (localcyj.RPF = this.wHI;; localcyj.RPF = new LinkedList())
    {
      if (!Util.isNullOrNil(this.wHK)) {
        localcyj.TGL = this.wHK;
      }
      localcyj.TGI = this.wHJ.size();
      localcyj.TGJ = this.wHJ;
      localcyj.RIr = this.wHG;
      localcyj.CPw = this.scene;
      this.callback = parami;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(103484);
      return i;
      localcyj.TGK = 0;
    }
  }
  
  public final int getType()
  {
    return 426;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103485);
    Log.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.wHG + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((ag)h.ag(ag.class)).getFavItemInfoStorage().Kn(this.wHG));
    AppMethodBeat.o(103485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.an
 * JD-Core Version:    0.7.0.1
 */