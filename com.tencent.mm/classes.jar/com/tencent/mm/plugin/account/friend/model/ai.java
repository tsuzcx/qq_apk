package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eyb;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public ai(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(131139);
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eyb();
    ((c.a)localObject).otF = new eyc();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((c.a)localObject).funcId = 432;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eyb)c.b.b(this.rr.otB);
    ((eyb)localObject).Njp = paramString;
    ((eyb)localObject).aaMZ = new LinkedList();
    ((eyb)localObject).aaMY = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!Util.isNullOrNil(paramList)) {
        ((eyb)localObject).aaMZ.add(new etl().btH(paramList));
      }
    }
    AppMethodBeat.o(131139);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131140);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ai
 * JD-Core Version:    0.7.0.1
 */