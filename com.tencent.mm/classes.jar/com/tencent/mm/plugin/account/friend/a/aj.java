package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public aj(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cil();
    ((d.a)localObject).iLO = new cim();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((d.a)localObject).funcId = 431;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cil)this.rr.iLK.iLR;
    ((cil)localObject).Bri = paramString;
    ((cil)localObject).Mnx = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((cil)localObject).Mnv = i;
      ((cil)localObject).Mny = new LinkedList();
      ((cil)localObject).Mnw = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!Util.isNullOrNil(paramList[2])) {
          ((cil)localObject).Mnw.add(new dqi().bhy(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<cik> bor()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((cim)this.rr.iLL.iLR).Mnz;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cik localcik = (cik)((Iterator)localObject).next();
        a.bqE().aTp().mP(localcik.UserName, localcik.LRO);
      }
    }
    localObject = ((cim)this.rr.iLL.iLR).Mnz;
    AppMethodBeat.o(131134);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131133);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131133);
    return i;
  }
  
  public final int getType()
  {
    return 431;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131135);
    params = (cim)this.rr.iLL.iLR;
    com.tencent.mm.kernel.g.aAk().postAtFrontOfWorker(new aj.1(this, params));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj
 * JD-Core Version:    0.7.0.1
 */