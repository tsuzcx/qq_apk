package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public al(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(131139);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cpr();
    ((b.a)localObject).gUV = new cps();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((b.a)localObject).funcId = 432;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cpr)this.rr.gUS.gUX;
    ((cpr)localObject).Ddo = paramString;
    ((cpr)localObject).DJv = new LinkedList();
    ((cpr)localObject).DJu = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!bt.isNullOrNil(paramList)) {
        ((cpr)localObject).DJv.add(new cmf().aEE(paramList));
      }
    }
    AppMethodBeat.o(131139);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(131140);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131140);
    return i;
  }
  
  public final int getType()
  {
    return 432;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131141);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.al
 * JD-Core Version:    0.7.0.1
 */