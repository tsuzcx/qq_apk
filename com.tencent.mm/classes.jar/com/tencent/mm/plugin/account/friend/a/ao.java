package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private int djq;
  public final List<String> ilo;
  public final List<String> ilp;
  private final String ilq;
  private int ilr;
  private int ils;
  
  public ao(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.ilq = ((String)com.tencent.mm.kernel.g.afB().afk().get(6, null));
    this.ils = 0;
    this.ilr = 0;
    this.ilo = paramList1;
    this.ilp = paramList2;
    this.djq = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> aR(List<bmz> paramList)
  {
    AppMethodBeat.i(131152);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      AppMethodBeat.o(131152);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((bmz)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> aS(List<bpz> paramList)
  {
    AppMethodBeat.i(131153);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      AppMethodBeat.o(131153);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(a.CD(((bpz)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = paramg;
    if (((this.ilo == null) || (this.ilo.size() == 0)) && ((this.ilp == null) || (this.ilp.size() == 0)))
    {
      ad.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    paramg = new b.a();
    paramg.gUU = new dhn();
    paramg.gUV = new dho();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramg.funcId = 133;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    paramg = paramg.atI();
    dhn localdhn = (dhn)paramg.gUS.gUX;
    localdhn.CFN = this.ilq;
    localdhn.mAQ = u.aqG();
    localdhn.CCB = this.djq;
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
        if (this.ilo != null)
        {
          j = i;
          if (this.ilr < this.ilo.size())
          {
            if (this.ilo.get(this.ilr) != null)
            {
              localObject2 = new bpz();
              ((bpz)localObject2).v = ((String)this.ilo.get(this.ilr));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.ilr += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.ilp != null)
        {
          k = j;
          if (this.ils < this.ilp.size())
          {
            if (this.ilp.get(this.ils) != null)
            {
              localObject2 = new bmz();
              ((bmz)localObject2).v = ((String)this.ilp.get(this.ils));
              localLinkedList.add(localObject2);
            }
            this.ils += 1;
            k = j - 1;
          }
        }
        if (this.ilp == null) {
          break;
        }
        i = k;
      } while (this.ils < this.ilp.size());
      if (this.ilo == null) {
        break;
      }
      i = k;
    } while (this.ilr < this.ilo.size());
    label438:
    localdhn.DJv = ((LinkedList)localObject1);
    localdhn.ExH = ((LinkedList)localObject1).size();
    localdhn.ExJ = localLinkedList;
    localdhn.ExI = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.ilp == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.ilo != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.ilo.size())
    {
      ad.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.ils + "," + this.ilr + "] req:[" + localdhn.ExJ.size() + "," + localdhn.DJv.size() + "]");
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.ilp.size();
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
    ad.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131151);
      return;
    }
    paramq = (dhn)((b)paramq).gUS.gUX;
    l.aP(aR(paramq.ExJ));
    l.aP(aS(paramq.DJv));
    if (((this.ilp == null) || (this.ils >= this.ilp.size())) && ((this.ilo == null) || (this.ilr >= this.ilo.size())))
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
    paramq = (dhn)((b)paramq).gUS.gUX;
    int i = paramq.ExJ.size() + paramq.DJv.size();
    if ((i == 0) || (i > 200))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      paramq = n.b.gVC;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.CFN == null) || (paramq.CFN.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      paramq = n.b.gVC;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.mAQ == null) || (paramq.mAQ.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      paramq = n.b.gVC;
      AppMethodBeat.o(131150);
      return paramq;
    }
    paramq = n.b.gVB;
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