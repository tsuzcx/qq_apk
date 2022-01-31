package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public ag(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(108471);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new baj();
    ((b.a)localObject).fsY = new bak();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).funcId = 431;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (baj)this.rr.fsV.fta;
    ((baj)localObject).wQf = paramString;
    ((baj)localObject).xpA = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((baj)localObject).xpy = i;
      ((baj)localObject).xpB = new LinkedList();
      ((baj)localObject).xpz = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bo.isNullOrNil(paramList[2])) {
          ((baj)localObject).xpz.add(new bwc().aoF(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(108471);
  }
  
  public final LinkedList<bai> aqH()
  {
    AppMethodBeat.i(108473);
    Object localObject = ((bak)this.rr.fsW.fta).xpC;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bai localbai = (bai)((Iterator)localObject).next();
        a.asD().Zb().in(localbai.jJA, localbai.wYu);
      }
    }
    localObject = ((bak)this.rr.fsW.fta).xpC;
    AppMethodBeat.o(108473);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108472);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108472);
    return i;
  }
  
  public final int getType()
  {
    return 431;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108474);
    paramq = (bak)this.rr.fsW.fta;
    com.tencent.mm.kernel.g.RO().a(new ag.1(this, paramq));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ag
 * JD-Core Version:    0.7.0.1
 */