package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.byy;
import java.util.LinkedList;

public final class ah
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public ah(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(108475);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new byx();
    ((b.a)localObject).fsY = new byy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendinviteemail";
    ((b.a)localObject).funcId = 116;
    ((b.a)localObject).reqCmdId = 41;
    ((b.a)localObject).respCmdId = 1000000041;
    this.rr = ((b.a)localObject).ado();
    localObject = new LinkedList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((LinkedList)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    ((byx)this.rr.fsV.fta).xLe = ((LinkedList)localObject);
    ((byx)this.rr.fsV.fta).xLd = ((LinkedList)localObject).size();
    AppMethodBeat.o(108475);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108476);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108476);
    return i;
  }
  
  public final int getType()
  {
    return 116;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108477);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ah
 * JD-Core Version:    0.7.0.1
 */