package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ao
  extends q
  implements m
{
  private i callback;
  private int dKy;
  public final List<String> kfA;
  public final List<String> kfB;
  private final String kfC;
  private int kfD;
  private int kfE;
  
  public ao(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.kfC = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(6, null));
    this.kfE = 0;
    this.kfD = 0;
    this.kfA = paramList1;
    this.kfB = paramList2;
    this.dKy = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> aZ(List<cko> paramList)
  {
    AppMethodBeat.i(131152);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      AppMethodBeat.o(131152);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((cko)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> ba(List<cpb> paramList)
  {
    AppMethodBeat.i(131153);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      AppMethodBeat.o(131153);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(b.Ts(((cpb)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = parami;
    if (((this.kfA == null) || (this.kfA.size() == 0)) && ((this.kfB == null) || (this.kfB.size() == 0)))
    {
      Log.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    parami = new d.a();
    parami.iLN = new eno();
    parami.iLO = new enp();
    parami.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    parami.funcId = 133;
    parami.iLP = 0;
    parami.respCmdId = 0;
    parami = parami.aXF();
    eno localeno = (eno)parami.iLK.iLR;
    localeno.KPP = this.kfC;
    localeno.UserName = z.aTY();
    localeno.KMz = this.dKy;
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
        if (this.kfA != null)
        {
          j = i;
          if (this.kfD < this.kfA.size())
          {
            if (this.kfA.get(this.kfD) != null)
            {
              localObject2 = new cpb();
              ((cpb)localObject2).v = ((String)this.kfA.get(this.kfD));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.kfD += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.kfB != null)
        {
          k = j;
          if (this.kfE < this.kfB.size())
          {
            if (this.kfB.get(this.kfE) != null)
            {
              localObject2 = new cko();
              ((cko)localObject2).v = ((String)this.kfB.get(this.kfE));
              localLinkedList.add(localObject2);
            }
            this.kfE += 1;
            k = j - 1;
          }
        }
        if (this.kfB == null) {
          break;
        }
        i = k;
      } while (this.kfE < this.kfB.size());
      if (this.kfA == null) {
        break;
      }
      i = k;
    } while (this.kfD < this.kfA.size());
    label438:
    localeno.Mnw = ((LinkedList)localObject1);
    localeno.Nlr = ((LinkedList)localObject1).size();
    localeno.Nlt = localLinkedList;
    localeno.Nls = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.kfB == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.kfA != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.kfA.size())
    {
      Log.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.kfE + "," + this.kfD + "] req:[" + localeno.Nlt.size() + "," + localeno.Mnw.size() + "]");
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.kfB.size();
      break;
    }
  }
  
  public final int getType()
  {
    return 133;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131151);
    Log.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131151);
      return;
    }
    params = (eno)((d)params).iLK.iLR;
    l.aX(aZ(params.Nlt));
    l.aX(ba(params.Mnw));
    if (((this.kfB == null) || (this.kfE >= this.kfB.size())) && ((this.kfA == null) || (this.kfD >= this.kfA.size())))
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
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(131150);
    params = (eno)((d)params).iLK.iLR;
    int i = params.Nlt.size() + params.Mnw.size();
    if ((i == 0) || (i > 200))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      params = q.b.iMr;
      AppMethodBeat.o(131150);
      return params;
    }
    if ((params.KPP == null) || (params.KPP.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      params = q.b.iMr;
      AppMethodBeat.o(131150);
      return params;
    }
    if ((params.UserName == null) || (params.UserName.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      params = q.b.iMr;
      AppMethodBeat.o(131150);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(131150);
    return params;
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