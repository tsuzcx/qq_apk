package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class al
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public al(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(131139);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eek();
    ((d.a)localObject).lBV = new eel();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((d.a)localObject).funcId = 432;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eek)d.b.b(this.rr.lBR);
    ((eek)localObject).HlB = paramString;
    ((eek)localObject).Tyr = new LinkedList();
    ((eek)localObject).Tyq = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!Util.isNullOrNil(paramList)) {
        ((eek)localObject).Tyr.add(new eaf().btQ(paramList));
      }
    }
    AppMethodBeat.o(131139);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131140);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131140);
    return i;
  }
  
  public final int getType()
  {
    return 432;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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