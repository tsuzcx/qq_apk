package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final b rr;
  
  public aj(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bpx();
    ((b.a)localObject).hvu = new bpy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).funcId = 431;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bpx)this.rr.hvr.hvw;
    ((bpx)localObject).Ewu = paramString;
    ((bpx)localObject).FeR = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((bpx)localObject).FeP = i;
      ((bpx)localObject).FeS = new LinkedList();
      ((bpx)localObject).FeQ = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bs.isNullOrNil(paramList[2])) {
          ((bpx)localObject).FeQ.add(new crm().aJV(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<bpw> aPU()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((bpy)this.rr.hvs.hvw).FeT;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bpw localbpw = (bpw)((Iterator)localObject).next();
        a.aRW().axc().lv(localbpw.ncR, localbpw.ELg);
      }
    }
    localObject = ((bpy)this.rr.hvs.hvw).FeT;
    AppMethodBeat.o(131134);
    return localObject;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(131133);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131133);
    return i;
  }
  
  public final int getType()
  {
    return 431;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131135);
    paramq = (bpy)this.rr.hvs.hvw;
    com.tencent.mm.kernel.g.agU().a(new ap.a()
    {
      public final boolean aBj()
      {
        AppMethodBeat.i(131130);
        if ((paramq != null) && (paramq.FeT.size() > 0))
        {
          Iterator localIterator = paramq.FeT.iterator();
          while (localIterator.hasNext())
          {
            bpw localbpw = (bpw)localIterator.next();
            if (localbpw.ndj == 1)
            {
              i locali = new i();
              locali.username = localbpw.ncR;
              locali.huF = localbpw.Eof;
              locali.huE = localbpw.Eog;
              locali.drx = -1;
              ac.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aBo(), locali.aBp() });
              locali.exK = 3;
              locali.ez(true);
              p.aBw().b(locali);
            }
          }
        }
        AppMethodBeat.o(131130);
        return true;
      }
      
      public final boolean aBk()
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj
 * JD-Core Version:    0.7.0.1
 */