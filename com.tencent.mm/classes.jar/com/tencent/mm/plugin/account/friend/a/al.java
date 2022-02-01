package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.platformtools.bt;
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
    ((b.a)localObject).hNM = new dai();
    ((b.a)localObject).hNN = new daj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((b.a)localObject).funcId = 432;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dai)this.rr.hNK.hNQ;
    ((dai)localObject).xbo = paramString;
    ((dai)localObject).GOu = new LinkedList();
    ((dai)localObject).GOt = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!bt.isNullOrNil(paramList)) {
        ((dai)localObject).GOu.add(new cwt().aPy(paramList));
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