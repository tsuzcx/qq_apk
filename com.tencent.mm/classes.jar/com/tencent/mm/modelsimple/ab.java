package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.df;
import java.util.LinkedList;

public final class ab
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public ab(String paramString, int paramInt, LinkedList<df> paramLinkedList)
  {
    AppMethodBeat.i(78609);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new clq();
    ((b.a)localObject).fsY = new clr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((b.a)localObject).funcId = 1200;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (clq)this.rr.fsV.fta;
    ((clq)localObject).link = paramString;
    ((clq)localObject).scene = paramInt;
    ((clq)localObject).xVF = paramLinkedList;
    AppMethodBeat.o(78609);
  }
  
  public final String ajX()
  {
    clr localclr = (clr)this.rr.fsW.fta;
    if (localclr == null) {
      return null;
    }
    return localclr.xVG;
  }
  
  public final clr ajY()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (clr)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78610);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78610);
    return i;
  }
  
  public final int getType()
  {
    return 1200;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78611);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */