package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  extends n
  implements k
{
  private f callback;
  private int dsi;
  public final List<String> jeE;
  public final List<String> jeF;
  private final String jeG;
  private int jeH;
  private int jeI;
  
  public ao(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.jeG = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(6, null));
    this.jeI = 0;
    this.jeH = 0;
    this.jeE = paramList1;
    this.jeF = paramList2;
    this.dsi = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> aQ(List<bwc> paramList)
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
      localArrayList.add(((bwc)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> aR(List<bzf> paramList)
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
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.b.JV(((bzf)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = paramf;
    if (((this.jeE == null) || (this.jeE.size() == 0)) && ((this.jeF == null) || (this.jeF.size() == 0)))
    {
      ad.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    paramf = new b.a();
    paramf.hNM = new dst();
    paramf.hNN = new dsu();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramf.funcId = 133;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    paramf = paramf.aDC();
    dst localdst = (dst)paramf.hNK.hNQ;
    localdst.FDJ = this.jeG;
    localdst.nDo = u.aAm();
    localdst.FAt = this.dsi;
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
        if (this.jeE != null)
        {
          j = i;
          if (this.jeH < this.jeE.size())
          {
            if (this.jeE.get(this.jeH) != null)
            {
              localObject2 = new bzf();
              ((bzf)localObject2).v = ((String)this.jeE.get(this.jeH));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.jeH += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.jeF != null)
        {
          k = j;
          if (this.jeI < this.jeF.size())
          {
            if (this.jeF.get(this.jeI) != null)
            {
              localObject2 = new bwc();
              ((bwc)localObject2).v = ((String)this.jeF.get(this.jeI));
              localLinkedList.add(localObject2);
            }
            this.jeI += 1;
            k = j - 1;
          }
        }
        if (this.jeF == null) {
          break;
        }
        i = k;
      } while (this.jeI < this.jeF.size());
      if (this.jeE == null) {
        break;
      }
      i = k;
    } while (this.jeH < this.jeE.size());
    label438:
    localdst.GOu = ((LinkedList)localObject1);
    localdst.HFx = ((LinkedList)localObject1).size();
    localdst.HFz = localLinkedList;
    localdst.HFy = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.jeF == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.jeE != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.jeE.size())
    {
      ad.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.jeI + "," + this.jeH + "] req:[" + localdst.HFz.size() + "," + localdst.GOu.size() + "]");
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.jeF.size();
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
    paramq = (dst)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    l.aO(aQ(paramq.HFz));
    l.aO(aR(paramq.GOu));
    if (((this.jeF == null) || (this.jeI >= this.jeF.size())) && ((this.jeE == null) || (this.jeH >= this.jeE.size())))
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
    paramq = (dst)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    int i = paramq.HFz.size() + paramq.GOu.size();
    if ((i == 0) || (i > 200))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      paramq = n.b.hOq;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.FDJ == null) || (paramq.FDJ.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      paramq = n.b.hOq;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.nDo == null) || (paramq.nDo.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      paramq = n.b.hOq;
      AppMethodBeat.o(131150);
      return paramq;
    }
    paramq = n.b.hOp;
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