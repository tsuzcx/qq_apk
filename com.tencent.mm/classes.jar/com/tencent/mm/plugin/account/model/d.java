package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.protocal.protobuf.jl;

public final class d
  extends m
  implements k
{
  public static int gAM = 1;
  public static int gAN = 2;
  private f callback;
  private b rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(124676);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new jk();
    ((b.a)localObject).fsY = new jl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((b.a)localObject).funcId = 256;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (jk)this.rr.fsV.fta;
    ((jk)localObject).OpCode = paramInt;
    ((jk)localObject).wvs = paramString;
    AppMethodBeat.o(124676);
  }
  
  public final int Ac()
  {
    return ((jk)this.rr.fsV.fta).OpCode;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124677);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124677);
    return i;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124678);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(124678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.d
 * JD-Core Version:    0.7.0.1
 */