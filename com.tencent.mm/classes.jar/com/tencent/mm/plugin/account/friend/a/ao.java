package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private int dgL;
  public final List<String> iLv;
  public final List<String> iLw;
  private final String iLx;
  private int iLy;
  private int iLz;
  
  public ao(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.iLx = ((String)com.tencent.mm.kernel.g.agR().agA().get(6, null));
    this.iLz = 0;
    this.iLy = 0;
    this.iLv = paramList1;
    this.iLw = paramList2;
    this.dgL = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> aP(List<brp> paramList)
  {
    AppMethodBeat.i(131152);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      AppMethodBeat.o(131152);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((brp)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> aQ(List<buq> paramList)
  {
    AppMethodBeat.i(131153);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      AppMethodBeat.o(131153);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(a.GG(((buq)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = paramg;
    if (((this.iLv == null) || (this.iLv.size() == 0)) && ((this.iLw == null) || (this.iLw.size() == 0)))
    {
      ac.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    paramg = new b.a();
    paramg.hvt = new dnc();
    paramg.hvu = new dnd();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramg.funcId = 133;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    paramg = paramg.aAz();
    dnc localdnc = (dnc)paramg.hvr.hvw;
    localdnc.DYn = this.iLx;
    localdnc.ncR = u.axw();
    localdnc.DUY = this.dgL;
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
        if (this.iLv != null)
        {
          j = i;
          if (this.iLy < this.iLv.size())
          {
            if (this.iLv.get(this.iLy) != null)
            {
              localObject2 = new buq();
              ((buq)localObject2).v = ((String)this.iLv.get(this.iLy));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.iLy += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.iLw != null)
        {
          k = j;
          if (this.iLz < this.iLw.size())
          {
            if (this.iLw.get(this.iLz) != null)
            {
              localObject2 = new brp();
              ((brp)localObject2).v = ((String)this.iLw.get(this.iLz));
              localLinkedList.add(localObject2);
            }
            this.iLz += 1;
            k = j - 1;
          }
        }
        if (this.iLw == null) {
          break;
        }
        i = k;
      } while (this.iLz < this.iLw.size());
      if (this.iLv == null) {
        break;
      }
      i = k;
    } while (this.iLy < this.iLv.size());
    label438:
    localdnc.FeQ = ((LinkedList)localObject1);
    localdnc.FUJ = ((LinkedList)localObject1).size();
    localdnc.FUL = localLinkedList;
    localdnc.FUK = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.iLw == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.iLv != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.iLv.size())
    {
      ac.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.iLz + "," + this.iLy + "] req:[" + localdnc.FUL.size() + "," + localdnc.FeQ.size() + "]");
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.iLw.size();
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
    ac.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131151);
      return;
    }
    paramq = (dnc)((b)paramq).hvr.hvw;
    l.aN(aP(paramq.FUL));
    l.aN(aQ(paramq.FeQ));
    if (((this.iLw == null) || (this.iLz >= this.iLw.size())) && ((this.iLv == null) || (this.iLy >= this.iLv.size())))
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
    paramq = (dnc)((b)paramq).hvr.hvw;
    int i = paramq.FUL.size() + paramq.FeQ.size();
    if ((i == 0) || (i > 200))
    {
      ac.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      paramq = n.b.hwb;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.DYn == null) || (paramq.DYn.length() <= 0))
    {
      ac.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      paramq = n.b.hwb;
      AppMethodBeat.o(131150);
      return paramq;
    }
    if ((paramq.ncR == null) || (paramq.ncR.length() <= 0))
    {
      ac.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      paramq = n.b.hwb;
      AppMethodBeat.o(131150);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(131150);
    return paramq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ao
 * JD-Core Version:    0.7.0.1
 */