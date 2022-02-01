package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends n
  implements k
{
  private g callback;
  private LinkedList<Integer> qaM;
  private int qaN;
  private final com.tencent.mm.al.b rr;
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.qaN = 0;
    b.a locala = new b.a();
    locala.gUU = new is();
    locala.gUV = new it();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.reqCmdId = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.atI();
    this.qaM = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean cij()
  {
    AppMethodBeat.i(103460);
    if ((this.qaM != null) && (this.qaN < this.qaM.size())) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(103460);
      return bool;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103461);
    if ((this.qaM == null) || (this.qaM.isEmpty()) || (this.qaN >= this.qaM.size()))
    {
      ad.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.qaN) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.qaM.size()), Integer.valueOf(this.qaN), this.qaM });
    paramg = (is)this.rr.gUS.gUX;
    paramg.CEn.clear();
    int j = this.qaN;
    int i = 0;
    if (j < this.qaM.size())
    {
      int k = ((Integer)this.qaM.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      paramg.CEn.add(Integer.valueOf(k));
      i += 1;
    }
    label270:
    for (;;)
    {
      if (i < 20)
      {
        j += 1;
        break;
      }
      this.qaN = (j + 1);
      paramg.mAK = paramg.CEn.size();
      ad.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramg.mAK), paramg.CEn });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(103461);
      return i;
    }
  }
  
  public final int getType()
  {
    return 403;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103462);
    ad.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qaN), Integer.valueOf(this.qaM.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cij())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    paramq = ((it)((com.tencent.mm.al.b)paramq).gUT.gUX).mAL;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ad.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (cij())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    paramArrayOfByte = new ArrayList();
    ad.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[] { Integer.valueOf(paramq.size()) });
    paramInt1 = 0;
    if (paramInt1 < paramq.size())
    {
      aaa localaaa = (aaa)paramq.get(paramInt1);
      if (localaaa.Ret < 0) {
        ad.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localaaa.Cxl) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localaaa.Cxl));
        ad.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localaaa.Cxl) });
      }
    }
    b.dh(paramArrayOfByte);
    if (cij())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(103462);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103462);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */