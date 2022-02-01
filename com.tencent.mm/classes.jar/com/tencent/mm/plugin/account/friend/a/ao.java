package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  extends n
  implements k
{
  private f callback;
  private int dto;
  private int jhA;
  private int jhB;
  public final List<String> jhx;
  public final List<String> jhy;
  private final String jhz;
  
  public ao(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.jhz = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(6, null));
    this.jhB = 0;
    this.jhA = 0;
    this.jhx = paramList1;
    this.jhy = paramList2;
    this.dto = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> aQ(List<bww> paramList)
  {
    AppMethodBeat.i(131152);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      AppMethodBeat.o(131152);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((bww)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> aR(List<bzz> paramList)
  {
    AppMethodBeat.i(131153);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      AppMethodBeat.o(131153);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.b.Ku(((bzz)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = paramf;
    if (((this.jhx == null) || (this.jhx.size() == 0)) && ((this.jhy == null) || (this.jhy.size() == 0)))
    {
      ae.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    paramf = new b.a();
    paramf.hQF = new dtq();
    paramf.hQG = new dtr();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramf.funcId = 133;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    paramf = paramf.aDS();
    dtq localdtq = (dtq)paramf.hQD.hQJ;
    localdtq.FWe = this.jhz;
    localdtq.nIJ = v.aAC();
    localdtq.FSQ = this.dto;
    int i = 200;
    Object localObject1 = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    do
    {
      int k;
      do
      {
        if (i <= 0) {
          break label438;
        }
        int j = i;
        Object localObject2;
        if (this.jhx != null)
        {
          j = i;
          if (this.jhA < this.jhx.size())
          {
            if (this.jhx.get(this.jhA) != null)
            {
              localObject2 = new bzz();
              ((bzz)localObject2).v = ((String)this.jhx.get(this.jhA));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.jhA += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.jhy != null)
        {
          k = j;
          if (this.jhB < this.jhy.size())
          {
            if (this.jhy.get(this.jhB) != null)
            {
              localObject2 = new bww();
              ((bww)localObject2).v = ((String)this.jhy.get(this.jhB));
              localLinkedList.add(localObject2);
            }
            this.jhB += 1;
            k = j - 1;
          }
        }
        if (this.jhy == null) {
          break;
        }
        i = k;
      } while (this.jhB < this.jhy.size());
      if (this.jhx == null) {
        break;
      }
      i = k;
    } while (this.jhA < this.jhx.size());
    label438:
    localdtq.HhU = ((LinkedList)localObject1);
    localdtq.HZk = ((LinkedList)localObject1).size();
    localdtq.HZm = localLinkedList;
    localdtq.HZl = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.jhy == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.jhx != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.jhx.size())
    {
      ae.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.jhB + "," + this.jhA + "] req:[" + localdtq.HZm.size() + "," + localdtq.HhU.size() + "]");
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.jhy.size();
      break;
    }
  }
  
  public final int getType()
  {
    return 133;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131151);
    ae.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131151);
      return;
    }
    paramq = (dtq)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    l.aO(aQ(paramq.HZm));
    l.aO(aR(paramq.HhU));
    if (((this.jhy == null) || (this.jhB >= this.jhy.size())) && ((this.jhx == null) || (this.jhA >= this.jhx.size())))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131151);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(131151);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(131150);
    paramq = (dtq)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    int i = paramq.HZm.size() + paramq.HhU.size();
    if ((i == 0) || (i > 200))
    {
      ae.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      paramq = n.b.hRj;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.FWe == null) || (paramq.FWe.length() <= 0))
    {
      ae.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      paramq = n.b.hRj;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.nIJ == null) || (paramq.nIJ.length() <= 0))
    {
      ae.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      paramq = n.b.hRj;
      AppMethodBeat.o(131150);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(131150);
    return paramq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ao
 * JD-Core Version:    0.7.0.1
 */