package com.tencent.mm.app.plugin.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private Context fhp;
  private long fhq;
  public d rr;
  
  public a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(263679);
    this.fhq = System.currentTimeMillis();
    this.fhp = paramContext;
    paramContext = new d.a();
    paramContext.funcId = getType();
    paramContext.uri = "/cgi-bin/mmsearch-bin/mmgettagjump";
    paramContext.lBU = new eco();
    paramContext.lBV = new ecp();
    this.rr = paramContext.bgN();
    paramContext = (eco)d.b.b(this.rr.lBR);
    paramContext.RYJ = paramString;
    paramContext.CPw = paramInt;
    AppMethodBeat.o(263679);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(263680);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(263680);
    return i;
  }
  
  public final int getType()
  {
    return 4790;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(263681);
    Log.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.fhq) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(263681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */