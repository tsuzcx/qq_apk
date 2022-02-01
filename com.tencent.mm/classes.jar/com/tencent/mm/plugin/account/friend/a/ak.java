package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public ak(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131136);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dan();
    ((b.a)localObject).hQG = new dao();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendinviteemail";
    ((b.a)localObject).funcId = 116;
    ((b.a)localObject).hQH = 41;
    ((b.a)localObject).respCmdId = 1000000041;
    this.rr = ((b.a)localObject).aDS();
    localObject = new LinkedList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((LinkedList)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    ((dan)this.rr.hQD.hQJ).HJT = ((LinkedList)localObject);
    ((dan)this.rr.hQD.hQJ).HJS = ((LinkedList)localObject).size();
    AppMethodBeat.o(131136);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131137);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131137);
    return i;
  }
  
  public final int getType()
  {
    return 116;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131138);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ak
 * JD-Core Version:    0.7.0.1
 */