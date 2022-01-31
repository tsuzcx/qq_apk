package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends m
  implements k
{
  private f callback;
  private LinkedList<Integer> mue;
  private int muf;
  private final com.tencent.mm.ai.b rr;
  
  public ag(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(102719);
    this.callback = null;
    this.muf = 0;
    b.a locala = new b.a();
    locala.fsX = new ht();
    locala.fsY = new hu();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.reqCmdId = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.ado();
    this.mue = paramLinkedList;
    AppMethodBeat.o(102719);
  }
  
  private boolean bwT()
  {
    AppMethodBeat.i(102720);
    if ((this.mue != null) && (this.muf < this.mue.size())) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(102720);
      return bool;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(102721);
    if ((this.mue == null) || (this.mue.isEmpty()) || (this.muf >= this.mue.size()))
    {
      ab.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.muf) });
      AppMethodBeat.o(102721);
      return -1;
    }
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.mue.size()), Integer.valueOf(this.muf), this.mue });
    paramf = (ht)this.rr.fsV.fta;
    paramf.wuv.clear();
    int j = this.muf;
    int i = 0;
    if (j < this.mue.size())
    {
      int k = ((Integer)this.mue.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      paramf.wuv.add(Integer.valueOf(k));
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
      this.muf = (j + 1);
      paramf.jJu = paramf.wuv.size();
      ab.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramf.jJu), paramf.wuv });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(102721);
      return i;
    }
  }
  
  public final int getType()
  {
    return 403;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102722);
    ab.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.muf), Integer.valueOf(this.mue.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (bwT())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(102722);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102722);
      return;
    }
    paramq = ((hu)((com.tencent.mm.ai.b)paramq).fsW.fta).jJv;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ab.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (bwT())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(102722);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102722);
      return;
    }
    paramArrayOfByte = new ArrayList();
    ab.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[] { Integer.valueOf(paramq.size()) });
    paramInt1 = 0;
    if (paramInt1 < paramq.size())
    {
      wv localwv = (wv)paramq.get(paramInt1);
      if (localwv.Ret < 0) {
        ab.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localwv.woD) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localwv.woD));
        ab.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localwv.woD) });
      }
    }
    b.bF(paramArrayOfByte);
    if (bwT())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(102722);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(102722);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ag
 * JD-Core Version:    0.7.0.1
 */