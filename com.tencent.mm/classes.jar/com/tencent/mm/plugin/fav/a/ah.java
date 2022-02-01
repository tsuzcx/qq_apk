package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  private LinkedList<Integer> rtu;
  private int rtv;
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.rtv = 0;
    b.a locala = new b.a();
    locala.hNM = new jh();
    locala.hNN = new ji();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.hNO = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.aDC();
    this.rtu = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean cvv()
  {
    AppMethodBeat.i(103460);
    if ((this.rtu != null) && (this.rtv < this.rtu.size())) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(103460);
      return bool;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103461);
    if ((this.rtu == null) || (this.rtu.isEmpty()) || (this.rtv >= this.rtu.size()))
    {
      ad.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.rtv) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.rtu.size()), Integer.valueOf(this.rtv), this.rtu });
    paramf = (jh)this.rr.hNK.hNQ;
    paramf.FCj.clear();
    int j = this.rtv;
    int i = 0;
    if (j < this.rtu.size())
    {
      int k = ((Integer)this.rtu.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      paramf.FCj.add(Integer.valueOf(k));
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
      this.rtv = (j + 1);
      paramf.nDi = paramf.FCj.size();
      ad.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramf.nDi), paramf.FCj });
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
    ad.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rtv), Integer.valueOf(this.rtu.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cvv())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    paramq = ((ji)((com.tencent.mm.al.b)paramq).hNL.hNQ).nDj;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ad.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (cvv())
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
      acz localacz = (acz)paramq.get(paramInt1);
      if (localacz.Ret < 0) {
        ad.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localacz.FuW) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localacz.FuW));
        ad.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localacz.FuW) });
      }
    }
    b.dl(paramArrayOfByte);
    if (cvv())
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */