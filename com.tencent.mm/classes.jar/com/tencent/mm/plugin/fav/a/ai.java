package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private LinkedList<Integer> wHq;
  private int wHr;
  
  public ai(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.wHr = 0;
    d.a locala = new d.a();
    locala.lBU = new jm();
    locala.lBV = new jn();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.lBW = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.bgN();
    this.wHq = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean dkg()
  {
    AppMethodBeat.i(103460);
    if ((this.wHq != null) && (this.wHr < this.wHq.size())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(103460);
      return bool;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103461);
    if ((this.wHq == null) || (this.wHq.isEmpty()) || (this.wHr >= this.wHq.size()))
    {
      Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.wHr) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = parami;
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.wHq.size()), Integer.valueOf(this.wHr), this.wHq });
    parami = (jm)d.b.b(this.rr.lBR);
    parami.RPj.clear();
    int j = this.wHr;
    int i = 0;
    if (j < this.wHq.size())
    {
      int k = ((Integer)this.wHq.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      parami.RPj.add(Integer.valueOf(k));
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
      this.wHr = (j + 1);
      parami.rVx = parami.RPj.size();
      Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(parami.rVx), parami.RPj });
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(103461);
      return i;
    }
  }
  
  public final int getType()
  {
    return 403;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103462);
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.wHr), Integer.valueOf(this.wHq.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (dkg())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    params = ((jn)d.c.b(((d)params).lBS)).rVy;
    if ((params == null) || (params.size() == 0))
    {
      Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (dkg())
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
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[] { Integer.valueOf(params.size()) });
    paramInt1 = 0;
    if (paramInt1 < params.size())
    {
      afu localafu = (afu)params.get(paramInt1);
      if (localafu.CqV < 0) {
        Log.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localafu.RIr) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localafu.RIr));
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localafu.RIr) });
      }
    }
    b.dI(paramArrayOfByte);
    if (dkg())
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */