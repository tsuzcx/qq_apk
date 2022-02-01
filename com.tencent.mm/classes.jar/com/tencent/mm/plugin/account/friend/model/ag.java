package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public ag(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dic();
    ((c.a)localObject).otF = new did();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((c.a)localObject).funcId = 431;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dic)c.b.b(this.rr.otB);
    ((dic)localObject).Njp = paramString;
    ((dic)localObject).aaNa = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((dic)localObject).aaMY = i;
      ((dic)localObject).aaNb = new LinkedList();
      ((dic)localObject).aaMZ = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!Util.isNullOrNil(paramList[2])) {
          ((dic)localObject).aaMZ.add(new etl().btH(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<dib> bXo()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((did)c.c.b(this.rr.otC)).aaNc;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dib localdib = (dib)((Iterator)localObject).next();
        a.caJ().bAc().pE(localdib.UserName, localdib.aant);
      }
    }
    localObject = ((did)c.c.b(this.rr.otC)).aaNc;
    AppMethodBeat.o(131134);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131133);
    this.callback = paramh;
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
    params = (did)c.c.b(this.rr.otC);
    com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(131130);
        if ((params != null) && (params.aaNc.size() > 0))
        {
          Iterator localIterator = params.aaNc.iterator();
          while (localIterator.hasNext())
          {
            dib localdib = (dib)localIterator.next();
            if (localdib.vhk == 1)
            {
              j localj = new j();
              localj.username = localdib.UserName;
              localj.osN = localdib.ZhO;
              localj.osM = localdib.ZhP;
              localj.eQp = -1;
              Log.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bFw(), localj.bFx() });
              localj.jZY = 3;
              localj.gX(true);
              q.bFE().b(localj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ag
 * JD-Core Version:    0.7.0.1
 */