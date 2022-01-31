package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class ae
  extends m
  implements k
{
  private f callback;
  public bpi koC;
  private final b rr;
  
  public ae(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(87907);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aju();
    ((b.a)localObject).fsY = new ajv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
    ((b.a)localObject).funcId = 1382;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aju)this.rr.fsV.fta;
    ((aju)localObject).xbg = paramLinkedList;
    ((aju)localObject).scene = paramInt;
    AppMethodBeat.o(87907);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87909);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87909);
    return i;
  }
  
  public final int getType()
  {
    return 1382;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87908);
    ab.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.koC = ((ajv)this.rr.fsW.fta).xbh;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ae
 * JD-Core Version:    0.7.0.1
 */