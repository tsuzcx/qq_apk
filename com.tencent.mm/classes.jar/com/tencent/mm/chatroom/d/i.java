package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.bue;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.roomsdk.a.a
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  public int don;
  public String doo;
  public final List<String> dop;
  public final List<String> dor;
  public List<String> dos;
  public List<String> dot;
  public final List<String> fsj;
  private final com.tencent.mm.ak.b rr;
  
  public i(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12461);
    this.don = 0;
    ac.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString + " size : " + paramList.size() + " username : " + (String)paramList.get(0));
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new zs();
    ((b.a)localObject).hvu = new zt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((b.a)localObject).funcId = 119;
    ((b.a)localObject).reqCmdId = 37;
    ((b.a)localObject).respCmdId = 1000000037;
    this.rr = ((b.a)localObject).aAz();
    localObject = (zs)this.rr.hvr.hvw;
    ((zs)localObject).EtW = z.FI(paramString);
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bud localbud = new bud();
      localbud.EuJ = z.FI(str);
      paramString.add(localbud);
    }
    ((zs)localObject).DPz = paramString;
    ((zs)localObject).fsB = paramString.size();
    this.dop = new LinkedList();
    this.fsj = new LinkedList();
    this.dor = new LinkedList();
    this.dos = new LinkedList();
    this.dot = new LinkedList();
    this.doo = "";
    AppMethodBeat.o(12461);
  }
  
  private void N(List<bue> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((bue)paramList.get(i)).Fkj;
      if (j == 0) {
        this.dot.add(z.a(((bue)paramList.get(i)).EuJ));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          ac.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((bue)paramList.get(i)).EuJ);
          this.fsj.add(z.a(((bue)paramList.get(i)).EuJ));
        }
        else if (j == 1)
        {
          ac.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((bue)paramList.get(i)).EuJ);
          this.dor.add(z.a(((bue)paramList.get(i)).EuJ));
        }
        else if (j == 2)
        {
          ac.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((bue)paramList.get(i)).EuJ);
          this.dop.add(z.a(((bue)paramList.get(i)).EuJ));
        }
        else if (j == 4)
        {
          ac.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((bue)paramList.get(i)).EuJ);
          this.dos.add(z.a(((bue)paramList.get(i)).EuJ));
        }
        else if ((j != 5) && (j != 6))
        {
          ac.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  private static boolean a(zt paramzt)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!z.a(paramzt.DPA).toLowerCase().endsWith("@chatroom")) || (paramzt.fsB == 0))
    {
      ac.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramzt.DPA + "] listCnt:" + paramzt.fsB);
      AppMethodBeat.o(12463);
      return false;
    }
    ai localai = new ai();
    localai.qj(z.a(paramzt.EtW));
    localai.qk(z.a(paramzt.EtY));
    localai.ql(z.a(paramzt.EtZ));
    localai.setUsername(z.a(paramzt.DPA));
    bj localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
    if (!localbj.aNw(localai.field_username)) {
      localbj.ag(localai);
    }
    Object localObject = new com.tencent.mm.aj.i();
    ((com.tencent.mm.aj.i)localObject).username = localai.field_username;
    ((com.tencent.mm.aj.i)localObject).huF = paramzt.Eof;
    ((com.tencent.mm.aj.i)localObject).huE = paramzt.Eog;
    ((com.tencent.mm.aj.i)localObject).exK = 3;
    ((com.tencent.mm.aj.i)localObject).ez(false);
    ((com.tencent.mm.aj.i)localObject).drx = -1;
    p.aBw().b((com.tencent.mm.aj.i)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramzt.DPz.size())
    {
      if (((bue)paramzt.DPz.get(i)).Fkj == 0)
      {
        localObject = localbj.aNt(z.a(((bue)paramzt.DPz.get(i)).EuJ));
        if ((int)((com.tencent.mm.n.b)localObject).fLJ == 0) {
          break label335;
        }
        ((ai)localObject).aae();
        localbj.c(((av)localObject).field_username, (ai)localObject);
      }
      for (;;)
      {
        localArrayList.add(((av)localObject).field_username);
        i += 1;
        break;
        label335:
        localObject = com.tencent.mm.model.q.a((ai)localObject, (bue)paramzt.DPz.get(i));
        localbj.ag((ai)localObject);
      }
    }
    if (!localArrayList.contains(u.axw()))
    {
      localArrayList.add(u.axw());
      ac.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(u.axw()));
    }
    boolean bool = com.tencent.mm.model.q.a(localai.field_username, localArrayList, u.axw());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof c))
    {
      parama = (c)parama;
      parama.chatroomName = this.doo;
      parama.dop = this.dop;
      parama.dni = this.don;
      parama.dom = this.dot;
      parama.fsi = this.dot;
      parama.fsj = this.fsj;
      parama.dor = this.dor;
      parama.fsk = new LinkedList();
      parama.dos = this.dos;
      AppMethodBeat.o(12466);
      return parama;
    }
    AppMethodBeat.o(12466);
    return parama;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(12462);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12462);
    return i;
  }
  
  public final int getType()
  {
    return 119;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12464);
    ac.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (zt)this.rr.hvs.hvw;
    this.doo = z.a(paramq.DPA);
    paramInt1 = this.rr.hvs.getRetCode();
    this.don = paramq.fsB;
    N(paramq.DPz);
    if ((!bs.isNullOrNil(this.doo)) && (paramInt1 == 0)) {
      a(paramq);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.i
 * JD-Core Version:    0.7.0.1
 */