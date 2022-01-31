package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class al
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL = null;
  public int jZY;
  public f jZZ;
  private LinkedList<axl> kaa;
  private LinkedList<axi> kab;
  public String kac;
  private int scene;
  public int type;
  
  public al(int paramInt, f paramf)
  {
    this(paramInt, paramf.field_modItem.kab, paramf.field_modItem.sWL, 1);
    this.jZZ = paramf;
  }
  
  public al(int paramInt, LinkedList<axi> paramLinkedList, LinkedList<axl> paramLinkedList1)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
  }
  
  private al(int paramInt1, LinkedList<axi> paramLinkedList, LinkedList<axl> paramLinkedList1, int paramInt2)
  {
    b.a locala = new b.a();
    locala.ecH = new axj();
    locala.ecI = new axk();
    locala.uri = "/cgi-bin/micromsg-bin/modfavitem";
    locala.ecG = 426;
    locala.ecJ = 216;
    locala.ecK = 1000000216;
    this.dmK = locala.Kt();
    this.kaa = paramLinkedList1;
    this.kab = paramLinkedList;
    this.jZY = paramInt1;
    this.type = paramInt2;
  }
  
  public al(int paramInt, LinkedList<axi> paramLinkedList, LinkedList<axl> paramLinkedList1, String paramString)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.kac = paramString;
  }
  
  public al(int paramInt, LinkedList<axi> paramLinkedList, LinkedList<axl> paramLinkedList1, String paramString, byte paramByte)
  {
    this(paramInt, paramLinkedList, paramLinkedList1, 0);
    this.kac = paramString;
    this.scene = 1;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    if ((this.scene == 0) && ((this.kab == null) || (this.kab.size() == 0))) {
      return -1;
    }
    axj localaxj = (axj)this.dmK.ecE.ecN;
    localaxj.ttN = this.kab.size();
    if (this.kaa != null) {
      localaxj.ttP = this.kaa.size();
    }
    for (localaxj.sAA = this.kaa;; localaxj.sAA = new LinkedList())
    {
      if (!bk.bl(this.kac)) {
        localaxj.ttQ = this.kac;
      }
      localaxj.ttN = this.kab.size();
      localaxj.ttO = this.kab;
      localaxj.svw = this.jZY;
      localaxj.pyo = this.scene;
      this.dmL = paramf;
      return a(parame, this.dmK, this);
      localaxj.ttP = 0;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.jZY + ", netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    b.d(((ae)g.t(ae.class)).getFavItemInfoStorage().eF(this.jZY));
  }
  
  public final long aQI()
  {
    if (this.jZZ == null) {
      return -1L;
    }
    return this.jZZ.field_localId;
  }
  
  public final int aQJ()
  {
    if (this.jZZ == null) {
      return -1;
    }
    return this.jZZ.field_type;
  }
  
  public final int getType()
  {
    return 426;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */