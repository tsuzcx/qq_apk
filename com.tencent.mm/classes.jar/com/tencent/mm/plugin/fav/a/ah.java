package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends n
  implements k
{
  private f callback;
  private LinkedList<Integer> rBG;
  private int rBH;
  private final com.tencent.mm.ak.b rr;
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.rBH = 0;
    b.a locala = new b.a();
    locala.hQF = new jh();
    locala.hQG = new ji();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.hQH = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.aDS();
    this.rBG = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean cwW()
  {
    AppMethodBeat.i(103460);
    if ((this.rBG != null) && (this.rBH < this.rBG.size())) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(103460);
      return bool;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103461);
    if ((this.rBG == null) || (this.rBG.isEmpty()) || (this.rBH >= this.rBG.size()))
    {
      ae.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.rBH) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.rBG.size()), Integer.valueOf(this.rBH), this.rBG });
    paramf = (jh)this.rr.hQD.hQJ;
    paramf.FUE.clear();
    int j = this.rBH;
    int i = 0;
    if (j < this.rBG.size())
    {
      int k = ((Integer)this.rBG.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      paramf.FUE.add(Integer.valueOf(k));
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
      this.rBH = (j + 1);
      paramf.nID = paramf.FUE.size();
      ae.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramf.nID), paramf.FUE });
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
    ae.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rBH), Integer.valueOf(this.rBG.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cwW())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    paramq = ((ji)((com.tencent.mm.ak.b)paramq).hQE.hQJ).nIE;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ae.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (cwW())
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
    ae.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[] { Integer.valueOf(paramq.size()) });
    paramInt1 = 0;
    if (paramInt1 < paramq.size())
    {
      adi localadi = (adi)paramq.get(paramInt1);
      if (localadi.Ret < 0) {
        ae.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localadi.FNu) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localadi.FNu));
        ae.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localadi.FNu) });
      }
    }
    b.jdMethod_do(paramArrayOfByte);
    if (cwW())
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */