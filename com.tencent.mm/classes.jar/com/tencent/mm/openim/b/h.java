package com.tencent.mm.openim.b;

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
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends m
  implements k
{
  private f callback;
  private String gfL;
  private String gfM;
  public bid gfN;
  private int ret;
  private final b rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78855);
    b.a locala = new b.a();
    locala.fsX = new anb();
    locala.fsY = new anc();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.funcId = 881;
    this.rr = locala.ado();
    this.gfL = paramString1;
    this.gfM = bo.bf(paramString2, "");
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.gfM, paramString3 });
    paramString2 = (anb)this.rr.fsV.fta;
    paramString2.gfL = paramString1;
    paramString2.gfK = this.gfM;
    paramString2.crs = paramString3;
    AppMethodBeat.o(78855);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78856);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78856);
    return i;
  }
  
  public final int getType()
  {
    return 881;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78857);
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfL });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78857);
      return;
    }
    paramq = (anc)this.rr.fsW.fta;
    this.gfN = paramq.xdC;
    this.ret = s.a(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.h
 * JD-Core Version:    0.7.0.1
 */