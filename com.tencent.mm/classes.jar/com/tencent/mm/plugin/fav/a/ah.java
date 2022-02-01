package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends n
  implements k
{
  private g callback;
  private LinkedList<Integer> qJs;
  private int qJt;
  private final com.tencent.mm.ak.b rr;
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.qJt = 0;
    b.a locala = new b.a();
    locala.hvt = new iy();
    locala.hvu = new iz();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.reqCmdId = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.aAz();
    this.qJs = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean cpQ()
  {
    AppMethodBeat.i(103460);
    if ((this.qJs != null) && (this.qJt < this.qJs.size())) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(103460);
      return bool;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103461);
    if ((this.qJs == null) || (this.qJs.isEmpty()) || (this.qJt >= this.qJs.size()))
    {
      ac.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.qJt) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.qJs.size()), Integer.valueOf(this.qJt), this.qJs });
    paramg = (iy)this.rr.hvr.hvw;
    paramg.DWN.clear();
    int j = this.qJt;
    int i = 0;
    if (j < this.qJs.size())
    {
      int k = ((Integer)this.qJs.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      paramg.DWN.add(Integer.valueOf(k));
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
      this.qJt = (j + 1);
      paramg.ncL = paramg.DWN.size();
      ac.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramg.ncL), paramg.DWN });
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
    ac.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qJt), Integer.valueOf(this.qJs.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cpQ())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    paramq = ((iz)((com.tencent.mm.ak.b)paramq).hvs.hvw).ncM;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ac.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (cpQ())
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
    ac.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[] { Integer.valueOf(paramq.size()) });
    paramInt1 = 0;
    if (paramInt1 < paramq.size())
    {
      aaz localaaz = (aaz)paramq.get(paramInt1);
      if (localaaz.Ret < 0) {
        ac.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localaaz.DPH) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localaaz.DPH));
        ac.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localaaz.DPH) });
      }
    }
    b.dj(paramArrayOfByte);
    if (cpQ())
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */