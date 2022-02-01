package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.exw;
import com.tencent.mm.protocal.protobuf.exx;
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
  private int fDn;
  public final List<String> mWZ;
  public final List<String> mXa;
  private final String mXb;
  private int mXc;
  private int mXd;
  
  public ao(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.mXb = ((String)h.aHG().aHp().b(6, null));
    this.mXd = 0;
    this.mXc = 0;
    this.mWZ = paramList1;
    this.mXa = paramList2;
    this.fDn = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> aX(List<cth> paramList)
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
      localArrayList.add(((cth)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> aY(List<cxr> paramList)
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
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(b.aaY(((cxr)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = parami;
    if (((this.mWZ == null) || (this.mWZ.size() == 0)) && ((this.mXa == null) || (this.mXa.size() == 0)))
    {
      Log.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    parami = new d.a();
    parami.lBU = new exw();
    parami.lBV = new exx();
    parami.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    parami.funcId = 133;
    parami.lBW = 0;
    parami.respCmdId = 0;
    parami = parami.bgN();
    exw localexw = (exw)d.b.b(parami.lBR);
    localexw.RQN = this.mXb;
    localexw.UserName = z.bcZ();
    localexw.RNt = this.fDn;
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
        if (this.mWZ != null)
        {
          j = i;
          if (this.mXc < this.mWZ.size())
          {
            if (this.mWZ.get(this.mXc) != null)
            {
              localObject2 = new cxr();
              ((cxr)localObject2).v = ((String)this.mWZ.get(this.mXc));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.mXc += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.mXa != null)
        {
          k = j;
          if (this.mXd < this.mXa.size())
          {
            if (this.mXa.get(this.mXd) != null)
            {
              localObject2 = new cth();
              ((cth)localObject2).v = ((String)this.mXa.get(this.mXd));
              localLinkedList.add(localObject2);
            }
            this.mXd += 1;
            k = j - 1;
          }
        }
        if (this.mXa == null) {
          break;
        }
        i = k;
      } while (this.mXd < this.mXa.size());
      if (this.mWZ == null) {
        break;
      }
      i = k;
    } while (this.mXc < this.mWZ.size());
    label438:
    localexw.Tyr = ((LinkedList)localObject1);
    localexw.Uyc = ((LinkedList)localObject1).size();
    localexw.Uye = localLinkedList;
    localexw.Uyd = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.mXa == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.mWZ != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.mWZ.size())
    {
      Log.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.mXd + "," + this.mXc + "] req:[" + localexw.Uye.size() + "," + localexw.Tyr.size() + "]");
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.mXa.size();
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
    params = (exw)d.b.b(((d)params).lBR);
    l.aV(aX(params.Uye));
    l.aV(aY(params.Tyr));
    if (((this.mXa == null) || (this.mXd >= this.mXa.size())) && ((this.mWZ == null) || (this.mXc >= this.mWZ.size())))
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
    params = (exw)d.b.b(((d)params).lBR);
    int i = params.Uye.size() + params.Tyr.size();
    if ((i == 0) || (i > 200))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      params = q.b.lCy;
      AppMethodBeat.o(131150);
      return params;
    }
    if ((params.RQN == null) || (params.RQN.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      params = q.b.lCy;
      AppMethodBeat.o(131150);
      return params;
    }
    if ((params.UserName == null) || (params.UserName.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      params = q.b.lCy;
      AppMethodBeat.o(131150);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(131150);
    return params;
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