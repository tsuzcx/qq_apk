package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends m
  implements k
{
  private f callback;
  private int cut;
  public final List<String> gyr;
  public final List<String> gys;
  private final String gyt;
  private int gyu;
  private int gyv;
  
  public al(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(108487);
    this.gyt = ((String)com.tencent.mm.kernel.g.RL().Ru().get(6, null));
    this.gyv = 0;
    this.gyu = 0;
    this.gyr = paramList1;
    this.gys = paramList2;
    this.cut = 1;
    AppMethodBeat.o(108487);
  }
  
  private static List<String> at(List<bba> paramList)
  {
    AppMethodBeat.i(108491);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.i("MicroMsg.NetSceneUploadMContact", "the req emai list is empty");
      AppMethodBeat.o(108491);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((bba)paramList.next()).v);
    }
    AppMethodBeat.o(108491);
    return localArrayList;
  }
  
  private static List<String> au(List<bdj> paramList)
  {
    AppMethodBeat.i(108492);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.i("MicroMsg.NetSceneUploadMContact", "the req mobile list is empty");
      AppMethodBeat.o(108492);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(com.tencent.mm.a.g.w(a.xw(((bdj)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(108492);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int m = 0;
    AppMethodBeat.i(108488);
    this.callback = paramf;
    if (((this.gyr == null) || (this.gyr.size() == 0)) && ((this.gys == null) || (this.gys.size() == 0)))
    {
      ab.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(108488);
      return -1;
    }
    paramf = new b.a();
    paramf.fsX = new coh();
    paramf.fsY = new coi();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramf.funcId = 133;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    paramf = paramf.ado();
    coh localcoh = (coh)paramf.fsV.fta;
    localcoh.wvG = this.gyt;
    localcoh.jJA = r.Zn();
    localcoh.wsW = this.cut;
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
        if (this.gyr != null)
        {
          j = i;
          if (this.gyu < this.gyr.size())
          {
            if (this.gyr.get(this.gyu) != null)
            {
              localObject2 = new bdj();
              ((bdj)localObject2).v = ((String)this.gyr.get(this.gyu));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.gyu += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.gys != null)
        {
          k = j;
          if (this.gyv < this.gys.size())
          {
            if (this.gys.get(this.gyv) != null)
            {
              localObject2 = new bba();
              ((bba)localObject2).v = ((String)this.gys.get(this.gyv));
              localLinkedList.add(localObject2);
            }
            this.gyv += 1;
            k = j - 1;
          }
        }
        if (this.gys == null) {
          break;
        }
        i = k;
      } while (this.gyv < this.gys.size());
      if (this.gyr == null) {
        break;
      }
      i = k;
    } while (this.gyu < this.gyr.size());
    label438:
    localcoh.xpz = ((LinkedList)localObject1);
    localcoh.xXa = ((LinkedList)localObject1).size();
    localcoh.xXc = localLinkedList;
    localcoh.xXb = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.gys == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.gyr != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.gyr.size())
    {
      ab.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.gyv + "," + this.gyu + "] req:[" + localcoh.xXc.size() + "," + localcoh.xpz.size() + "]");
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(108488);
      return i;
      i = this.gys.size();
      break;
    }
  }
  
  public final int getType()
  {
    return 133;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108490);
    ab.i("MicroMsg.NetSceneUploadMContact", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadMContact", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108490);
      return;
    }
    paramq = (coh)((b)paramq).fsV.fta;
    l.ar(at(paramq.xXc));
    l.ar(au(paramq.xpz));
    if (((this.gys == null) || (this.gyv >= this.gys.size())) && ((this.gyr == null) || (this.gyu >= this.gyr.size())))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108490);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(108490);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(108489);
    paramq = (coh)((b)paramq).fsV.fta;
    int i = paramq.xXc.size() + paramq.xpz.size();
    if ((i == 0) || (i > 200))
    {
      ab.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      paramq = m.b.ftv;
      AppMethodBeat.o(108489);
      return paramq;
    }
    if ((paramq.wvG == null) || (paramq.wvG.length() <= 0))
    {
      ab.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      paramq = m.b.ftv;
      AppMethodBeat.o(108489);
      return paramq;
    }
    if ((paramq.jJA == null) || (paramq.jJA.length() <= 0))
    {
      ab.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      paramq = m.b.ftv;
      AppMethodBeat.o(108489);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(108489);
    return paramq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.al
 * JD-Core Version:    0.7.0.1
 */