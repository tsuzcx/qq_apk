package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public List<se> yFL;
  
  public j()
  {
    AppMethodBeat.i(55697);
    d.a locala = new d.a();
    locala.iLN = new byk();
    locala.iLO = new byl();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweapplistbylocation";
    locala.funcId = 1913;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yFL = new ArrayList(8);
    AppMethodBeat.o(55697);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(55698);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55698);
    return i;
  }
  
  public final int getType()
  {
    return 1913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55699);
    Log.i("MicroMsg.NetSceneGetWeappListByLocation", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (byl)this.rr.iLL.iLR;
    if (params.MdU != null)
    {
      paramInt1 = params.MdU.size();
      Log.i("MicroMsg.NetSceneGetWeappListByLocation", "weapp list size: %s.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 > 8) {
        break label126;
      }
      this.yFL.addAll(params.MdU);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55699);
      return;
      label126:
      this.yFL.addAll(params.MdU.subList(0, 8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.j
 * JD-Core Version:    0.7.0.1
 */