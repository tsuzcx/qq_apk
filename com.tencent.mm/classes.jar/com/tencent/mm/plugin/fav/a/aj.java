package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends p
  implements m
{
  private int AdA;
  private LinkedList<Integer> Adz;
  private h callback;
  private final c rr;
  
  public aj(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103459);
    this.callback = null;
    this.AdA = 0;
    c.a locala = new c.a();
    locala.otE = new ki();
    locala.otF = new kj();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
    locala.funcId = 403;
    locala.otG = 194;
    locala.respCmdId = 1000000194;
    this.rr = locala.bEF();
    this.Adz = paramLinkedList;
    AppMethodBeat.o(103459);
  }
  
  private boolean dQR()
  {
    AppMethodBeat.i(103460);
    if ((this.Adz != null) && (this.AdA < this.Adz.size())) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(103460);
      return bool;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103461);
    if ((this.Adz == null) || (this.Adz.isEmpty()) || (this.AdA >= this.Adz.size()))
    {
      Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[] { Integer.valueOf(this.AdA) });
      AppMethodBeat.o(103461);
      return -1;
    }
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.Adz.size()), Integer.valueOf(this.AdA), this.Adz });
    paramh = (ki)c.b.b(this.rr.otB);
    paramh.YMw.clear();
    int j = this.AdA;
    int i = 0;
    if (j < this.Adz.size())
    {
      int k = ((Integer)this.Adz.get(j)).intValue();
      if (k <= 0) {
        break label270;
      }
      paramh.YMw.add(Integer.valueOf(k));
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
      this.AdA = (j + 1);
      paramh.vgN = paramh.YMw.size();
      Log.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(paramh.vgN), paramh.YMw });
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
    Log.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.AdA), Integer.valueOf(this.Adz.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (dQR())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103462);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103462);
      return;
    }
    params = ((kj)c.c.b(((c)params).otC)).vgO;
    if ((params == null) || (params.size() == 0))
    {
      Log.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
      if (dQR())
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
      aih localaih = (aih)params.get(paramInt1);
      if (localaih.Idd < 0) {
        Log.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[] { Integer.valueOf(localaih.YFt) });
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        paramArrayOfByte.add(Integer.valueOf(localaih.YFt));
        Log.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[] { Integer.valueOf(localaih.YFt) });
      }
    }
    b.fD(paramArrayOfByte);
    if (dQR())
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */