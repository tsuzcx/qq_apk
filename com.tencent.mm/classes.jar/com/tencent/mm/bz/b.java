package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b fsQ;
  
  public b(bug parambug)
  {
    AppMethodBeat.i(116353);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bug();
    ((b.a)localObject).fsY = new buh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((b.a)localObject).funcId = 809;
    this.fsQ = ((b.a)localObject).ado();
    localObject = (bug)this.fsQ.fsV.fta;
    ((bug)localObject).xHA = parambug.xHA;
    ((bug)localObject).xHz = parambug.xHz;
    ((bug)localObject).wxW = parambug.wxW;
    ((bug)localObject).EmotionList.addAll(parambug.EmotionList);
    ((bug)localObject).jKs = parambug.jKs;
    AppMethodBeat.o(116353);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(116354);
    this.callback = paramf;
    int i = dispatch(parame, this.fsQ, this);
    AppMethodBeat.o(116354);
    return i;
  }
  
  public final int getType()
  {
    return 809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116355);
    ab.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(116355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bz.b
 * JD-Core Version:    0.7.0.1
 */