package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.elr;
import com.tencent.mm.protocal.protobuf.els;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  private c rr;
  public int status;
  
  public d(String paramString1, String paramString2, com.tencent.mm.b.p paramp)
  {
    AppMethodBeat.i(20774);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new elr();
    ((c.a)localObject).otF = new els();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
    ((c.a)localObject).funcId = 582;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    StringBuilder localStringBuilder = new StringBuilder("a2key is ");
    if (!Util.isNullOrNil(paramString1))
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", newa2key is ");
      if (Util.isNullOrNil(paramString2)) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", bool1);
      this.rr = ((c.a)localObject).bEF();
      localObject = (elr)c.b.b(this.rr.otB);
      ((elr)localObject).YJr = new gol().df(Util.decodeHexString(paramString1));
      ((elr)localObject).abqj = new gol().df(Util.decodeHexString(paramString2));
      ((elr)localObject).qq = paramp.intValue();
      AppMethodBeat.o(20774);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20776);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20776);
    return i;
  }
  
  public final int getType()
  {
    return 582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20775);
    Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (els)c.c.b(((c)params).otC);
      this.status = params.abqk;
      Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
      if ((params.abqi.abql != null) && (this.status == 0))
      {
        Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + params.abqi.abql.size());
        a.bZe();
        a.bZg().x(params.abqi.abql);
        a.bZe();
        a.bZg().bZj();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.d
 * JD-Core Version:    0.7.0.1
 */