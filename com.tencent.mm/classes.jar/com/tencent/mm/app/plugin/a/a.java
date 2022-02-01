package com.tencent.mm.app.plugin.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.ewg;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private Context hlA;
  private long hlB;
  public c rr;
  
  public a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(239337);
    this.hlB = System.currentTimeMillis();
    this.hlA = paramContext;
    paramContext = new c.a();
    paramContext.funcId = getType();
    paramContext.uri = "/cgi-bin/mmsearch-bin/mmgettagjump";
    paramContext.otE = new ewf();
    paramContext.otF = new ewg();
    this.rr = paramContext.bEF();
    paramContext = (ewf)c.b.b(this.rr.otB);
    paramContext.YWK = paramString;
    paramContext.IJG = paramInt;
    AppMethodBeat.o(239337);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(239344);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(239344);
    return i;
  }
  
  public final int getType()
  {
    return 4790;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(239353);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.hlB) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(239353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */