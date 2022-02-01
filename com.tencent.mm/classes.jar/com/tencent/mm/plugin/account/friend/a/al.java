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
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public al(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(131139);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dbc();
    ((b.a)localObject).hQG = new dbd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((b.a)localObject).funcId = 432;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dbc)this.rr.hQD.hQJ;
    ((dbc)localObject).xrf = paramString;
    ((dbc)localObject).HhU = new LinkedList();
    ((dbc)localObject).HhT = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!bu.isNullOrNil(paramList)) {
        ((dbc)localObject).HhU.add(new cxn().aQV(paramList));
      }
    }
    AppMethodBeat.o(131139);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131140);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.al
 * JD-Core Version:    0.7.0.1
 */