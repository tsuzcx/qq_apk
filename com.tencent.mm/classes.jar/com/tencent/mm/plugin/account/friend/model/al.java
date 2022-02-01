package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.ftp;
import com.tencent.mm.protocal.protobuf.ftq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int hId;
  public final List<String> pTH;
  public final List<String> pTI;
  private final String pTJ;
  private int pTK;
  private int pTL;
  
  public al(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131148);
    this.pTJ = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
    this.pTL = 0;
    this.pTK = 0;
    this.pTH = paramList1;
    this.pTI = paramList2;
    this.hId = 1;
    AppMethodBeat.o(131148);
  }
  
  private static List<String> cC(List<dkj> paramList)
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
      localArrayList.add(((dkj)paramList.next()).v);
    }
    AppMethodBeat.o(131152);
    return localArrayList;
  }
  
  private static List<String> cD(List<dow> paramList)
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
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest(b.Tu(((dow)paramList.next()).v).getBytes()));
    }
    AppMethodBeat.o(131153);
    return localArrayList;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    int m = 0;
    AppMethodBeat.i(131149);
    this.callback = paramh;
    if (((this.pTH == null) || (this.pTH.size() == 0)) && ((this.pTI == null) || (this.pTI.size() == 0)))
    {
      Log.i("MicroMsg.NetSceneUploadMContact", "listMobile or listEmile is null or zero");
      AppMethodBeat.o(131149);
      return -1;
    }
    paramh = new c.a();
    paramh.otE = new ftp();
    paramh.otF = new ftq();
    paramh.uri = "/cgi-bin/micromsg-bin/uploadmcontact";
    paramh.funcId = 133;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    paramh = paramh.bEF();
    ftp localftp = (ftp)c.b.b(paramh.otB);
    localftp.YOc = this.pTJ;
    localftp.UserName = z.bAM();
    localftp.YKH = this.hId;
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
        if (this.pTH != null)
        {
          j = i;
          if (this.pTK < this.pTH.size())
          {
            if (this.pTH.get(this.pTK) != null)
            {
              localObject2 = new dow();
              ((dow)localObject2).v = ((String)this.pTH.get(this.pTK));
              ((LinkedList)localObject1).add(localObject2);
            }
            this.pTK += 1;
            j = i - 1;
          }
        }
        k = j;
        if (this.pTI != null)
        {
          k = j;
          if (this.pTL < this.pTI.size())
          {
            if (this.pTI.get(this.pTL) != null)
            {
              localObject2 = new dkj();
              ((dkj)localObject2).v = ((String)this.pTI.get(this.pTL));
              localLinkedList.add(localObject2);
            }
            this.pTL += 1;
            k = j - 1;
          }
        }
        if (this.pTI == null) {
          break;
        }
        i = k;
      } while (this.pTL < this.pTI.size());
      if (this.pTH == null) {
        break;
      }
      i = k;
    } while (this.pTK < this.pTH.size());
    label438:
    localftp.aaMZ = ((LinkedList)localObject1);
    localftp.abRJ = ((LinkedList)localObject1).size();
    localftp.abRL = localLinkedList;
    localftp.abRK = localLinkedList.size();
    localObject1 = new StringBuilder("doscene in:[");
    if (this.pTI == null)
    {
      i = 0;
      localObject1 = ((StringBuilder)localObject1).append(i).append(",");
      if (this.pTH != null) {
        break label618;
      }
    }
    label618:
    for (i = m;; i = this.pTH.size())
    {
      Log.v("MicroMsg.NetSceneUploadMContact", i + "] index:[" + this.pTL + "," + this.pTK + "] req:[" + localftp.abRL.size() + "," + localftp.aaMZ.size() + "]");
      i = dispatch(paramg, paramh, this);
      AppMethodBeat.o(131149);
      return i;
      i = this.pTI.size();
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
    params = (ftp)c.b.b(((c)params).otB);
    i.cA(cC(params.abRL));
    i.cA(cD(params.aaMZ));
    if (((this.pTI == null) || (this.pTL >= this.pTI.size())) && ((this.pTH == null) || (this.pTK >= this.pTH.size())))
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
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(131150);
    params = (ftp)c.b.b(((c)params).otB);
    int i = params.abRL.size() + params.aaMZ.size();
    if ((i == 0) || (i > 200))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : exceed max send count");
      params = p.b.oui;
      AppMethodBeat.o(131150);
      return params;
    }
    if ((params.YOc == null) || (params.YOc.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : moblie null");
      params = p.b.oui;
      AppMethodBeat.o(131150);
      return params;
    }
    if ((params.UserName == null) || (params.UserName.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneUploadMContact", "security checked failed : username null");
      params = p.b.oui;
      AppMethodBeat.o(131150);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(131150);
    return params;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.al
 * JD-Core Version:    0.7.0.1
 */