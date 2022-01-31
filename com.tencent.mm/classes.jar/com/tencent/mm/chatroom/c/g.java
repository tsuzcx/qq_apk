package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  public int cAt;
  public String cAu;
  public final List<String> cAv;
  public final List<String> cAx;
  public List<String> cAy;
  public List<String> cAz;
  private f callback;
  public final List<String> eeo;
  private final b rr;
  
  public g(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(103916);
    this.cAt = 0;
    ab.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString + " size : " + paramList.size() + " username : " + (String)paramList.get(0));
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new vt();
    ((b.a)localObject).fsY = new vu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((b.a)localObject).funcId = 119;
    ((b.a)localObject).reqCmdId = 37;
    ((b.a)localObject).respCmdId = 1000000037;
    this.rr = ((b.a)localObject).ado();
    localObject = (vt)this.rr.fsV.fta;
    ((vt)localObject).wOt = aa.wA(paramString);
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bcw localbcw = new bcw();
      localbcw.wOY = aa.wA(str);
      paramString.add(localbcw);
    }
    ((vt)localObject).wov = paramString;
    ((vt)localObject).eeF = paramString.size();
    this.cAv = new LinkedList();
    this.eeo = new LinkedList();
    this.cAx = new LinkedList();
    this.cAy = new LinkedList();
    this.cAz = new LinkedList();
    this.cAu = "";
    AppMethodBeat.o(103916);
  }
  
  private void K(List<bcx> paramList)
  {
    AppMethodBeat.i(103920);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((bcx)paramList.get(i)).xsS;
      if (j == 0) {
        this.cAz.add(aa.a(((bcx)paramList.get(i)).wOY));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          ab.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((bcx)paramList.get(i)).wOY);
          this.eeo.add(aa.a(((bcx)paramList.get(i)).wOY));
        }
        else if (j == 1)
        {
          ab.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((bcx)paramList.get(i)).wOY);
          this.cAx.add(aa.a(((bcx)paramList.get(i)).wOY));
        }
        else if (j == 2)
        {
          ab.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((bcx)paramList.get(i)).wOY);
          this.cAv.add(aa.a(((bcx)paramList.get(i)).wOY));
        }
        else if (j == 4)
        {
          ab.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((bcx)paramList.get(i)).wOY);
          this.cAy.add(aa.a(((bcx)paramList.get(i)).wOY));
        }
        else if ((j != 5) && (j != 6))
        {
          ab.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(103920);
  }
  
  private static boolean a(vu paramvu)
  {
    int i = 0;
    AppMethodBeat.i(103918);
    if ((!aa.a(paramvu.wow).toLowerCase().endsWith("@chatroom")) || (paramvu.eeF == 0))
    {
      ab.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramvu.wow + "] listCnt:" + paramvu.eeF);
      AppMethodBeat.o(103918);
      return false;
    }
    ad localad = new ad();
    localad.jp(aa.a(paramvu.wOt));
    localad.jq(aa.a(paramvu.wOv));
    localad.jr(aa.a(paramvu.wOw));
    localad.setUsername(aa.a(paramvu.wow));
    bd localbd = ((j)com.tencent.mm.kernel.g.E(j.class)).YA();
    if (!localbd.ary(localad.field_username)) {
      localbd.Y(localad);
    }
    Object localObject = new h();
    ((h)localObject).username = localad.field_username;
    ((h)localObject).fsl = paramvu.wJq;
    ((h)localObject).fsk = paramvu.wJr;
    ((h)localObject).dqB = 3;
    ((h)localObject).cM(false);
    ((h)localObject).bsY = -1;
    o.adg().b((h)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramvu.wov.size())
    {
      if (((bcx)paramvu.wov.get(i)).xsS == 0)
      {
        localObject = localbd.arw(aa.a(((bcx)paramvu.wov.get(i)).wOY));
        if ((int)((com.tencent.mm.n.a)localObject).euF == 0) {
          break label333;
        }
        ((ad)localObject).Nw();
        localbd.b(((aq)localObject).field_username, (ad)localObject);
      }
      for (;;)
      {
        localArrayList.add(((aq)localObject).field_username);
        i += 1;
        break;
        label333:
        localObject = n.a((ad)localObject, (bcx)paramvu.wov.get(i));
        localbd.Y((ad)localObject);
      }
    }
    if (!localArrayList.contains(r.Zn()))
    {
      localArrayList.add(r.Zn());
      ab.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(r.Zn()));
    }
    boolean bool = n.a(localad.field_username, localArrayList, r.Zn());
    AppMethodBeat.o(103918);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(103921);
    if ((parama instanceof c))
    {
      parama = (c)parama;
      parama.chatroomName = this.cAu;
      parama.cAv = this.cAv;
      parama.czr = this.cAt;
      parama.cAs = this.cAz;
      parama.een = this.cAz;
      parama.eeo = this.eeo;
      parama.cAx = this.cAx;
      parama.eep = new LinkedList();
      parama.cAy = this.cAy;
      AppMethodBeat.o(103921);
      return parama;
    }
    AppMethodBeat.o(103921);
    return parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103917);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103917);
    return i;
  }
  
  public final int getType()
  {
    return 119;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103919);
    ab.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (vu)this.rr.fsW.fta;
    this.cAu = aa.a(paramq.wow);
    paramInt1 = this.rr.fsW.getRetCode();
    this.cAt = paramq.eeF;
    K(paramq.wov);
    if ((!bo.isNullOrNil(this.cAu)) && (paramInt1 == 0)) {
      a(paramq);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.g
 * JD-Core Version:    0.7.0.1
 */