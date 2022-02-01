package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elv;
import com.tencent.mm.protocal.protobuf.elw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
  extends p
  implements m
{
  private h callback;
  public String nickname;
  public boolean qhG;
  private c rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20777);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new elv();
    ((c.a)localObject).otF = new elw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((c.a)localObject).funcId = 417;
    ((c.a)localObject).otG = 202;
    ((c.a)localObject).respCmdId = 1000000202;
    this.rr = ((c.a)localObject).bEF();
    localObject = (elv)c.b.b(this.rr.otB);
    ((elv)localObject).fZW = 0;
    ((elv)localObject).abqw = paramString1;
    ((elv)localObject).appid = paramString2;
    ((elv)localObject).scene = paramInt;
    AppMethodBeat.o(20777);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20779);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20779);
    return i;
  }
  
  public final int getType()
  {
    return 417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(20778);
    Log.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (elw)c.c.b(((c)params).otC);
      this.username = params.appusername;
      this.nickname = params.abqz;
      if (params.abqy != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.qhG = bool;
      if (params.abqi.abql != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + params.abqi.abql.size());
        a.bZe();
        a.bZg().x(params.abqi.abql);
        a.bZe();
        a.bZg().bZj();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20778);
      return;
      label198:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */