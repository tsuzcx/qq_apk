package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
  extends p
  implements m
{
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(65275);
    AppMethodBeat.o(65275);
    throw null;
  }
  
  public final int getType()
  {
    return 980;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65276);
    Log.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    AppMethodBeat.o(65276);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */