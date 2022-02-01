package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private final d rr;
  
  public aj(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new crh();
    ((d.a)localObject).lBV = new cri();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((d.a)localObject).funcId = 431;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (crh)d.b.b(this.rr.lBR);
    ((crh)localObject).HlB = paramString;
    ((crh)localObject).Tys = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((crh)localObject).Tyq = i;
      ((crh)localObject).Tyt = new LinkedList();
      ((crh)localObject).Tyr = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!Util.isNullOrNil(paramList[2])) {
          ((crh)localObject).Tyr.add(new eaf().btQ(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<crg> byA()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((cri)d.c.b(this.rr.lBS)).Tyu;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        crg localcrg = (crg)((Iterator)localObject).next();
        a.bBt().bcn().nG(localcrg.UserName, localcrg.Tav);
      }
    }
    localObject = ((cri)d.c.b(this.rr.lBS)).Tyu;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131135);
    params = (cri)d.c.b(this.rr.lBS);
    h.aHJ().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(131130);
        if ((params != null) && (params.Tyu.size() > 0))
        {
          Iterator localIterator = params.Tyu.iterator();
          while (localIterator.hasNext())
          {
            crg localcrg = (crg)localIterator.next();
            if (localcrg.rVU == 1)
            {
              j localj = new j();
              localj.username = localcrg.UserName;
              localj.lBe = localcrg.SjI;
              localj.lBd = localcrg.SjJ;
              localj.cUP = -1;
              Log.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bhH(), localj.bhI() });
              localj.hDc = 3;
              localj.gg(true);
              com.tencent.mm.am.q.bhP().b(localj);
            }
          }
        }
        AppMethodBeat.o(131130);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(131131);
        String str = super.toString() + "|onGYNetEnd";
        AppMethodBeat.o(131131);
        return str;
      }
    });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj
 * JD-Core Version:    0.7.0.1
 */