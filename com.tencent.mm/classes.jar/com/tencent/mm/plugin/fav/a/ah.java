package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private LinkedList<Integer> tbl;
  private int tbm;
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.tbm = 0;
    d.a locala = new d.a();
    locala.iLN = new jw();
    locala.iLO = new jx();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.iLP = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.aXF();
    this.tbl = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean cVa()
  {
    AppMethodBeat.i(103460);
    if ((this.tbl != null) && (this.tbm < this.tbl.size())) {}
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
    if ((this.tbl == null) || (this.tbl.isEmpty()) || (this.tbm >= this.tbl.size()))
    {
      Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.tbm) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = parami;
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.tbl.size()), Integer.valueOf(this.tbm), this.tbl });
    parami = (jw)this.rr.iLK.iLR;
    parami.KOn.clear();
    int j = this.tbm;
    int i = 0;
    if (j < this.tbl.size())
    {
      int k = ((Integer)this.tbl.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      parami.KOn.add(Integer.valueOf(k));
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
      this.tbm = (j + 1);
      parami.oTz = parami.KOn.size();
      Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(parami.oTz), parami.KOn });
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
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.tbm), Integer.valueOf(this.tbl.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cVa())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    params = ((jx)((d)params).iLL.iLR).oTA;
    if ((params == null) || (params.size() == 0))
    {
      Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (cVa())
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
      afl localafl = (afl)params.get(paramInt1);
      if (localafl.Ret < 0) {
        Log.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localafl.KGZ) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localafl.KGZ));
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localafl.KGZ) });
      }
    }
    b.dC(paramArrayOfByte);
    if (cVa())
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
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */