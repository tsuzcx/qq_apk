package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.roomsdk.a.a
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  public int dqC;
  public String dqD;
  public final List<String> dqE;
  public final List<String> dqG;
  public List<String> dqH;
  public List<String> dqI;
  public final List<String> foJ;
  private final com.tencent.mm.al.b rr;
  
  public i(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12461);
    this.dqC = 0;
    ad.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString + " size : " + paramList.size() + " username : " + (String)paramList.get(0));
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new yx();
    ((b.a)localObject).gUV = new yy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((b.a)localObject).funcId = 119;
    ((b.a)localObject).reqCmdId = 37;
    ((b.a)localObject).respCmdId = 1000000037;
    this.rr = ((b.a)localObject).atI();
    localObject = (yx)this.rr.gUS.gUX;
    ((yx)localObject).DaZ = z.BE(paramString);
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      bpm localbpm = new bpm();
      localbpm.DbD = z.BE(str);
      paramString.add(localbpm);
    }
    ((yx)localObject).Cxd = paramString;
    ((yx)localObject).fpb = paramString.size();
    this.dqE = new LinkedList();
    this.foJ = new LinkedList();
    this.dqG = new LinkedList();
    this.dqH = new LinkedList();
    this.dqI = new LinkedList();
    this.dqD = "";
    AppMethodBeat.o(12461);
  }
  
  private void W(List<bpn> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((bpn)paramList.get(i)).DNS;
      if (j == 0) {
        this.dqI.add(z.a(((bpn)paramList.get(i)).DbD));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((bpn)paramList.get(i)).DbD);
          this.foJ.add(z.a(((bpn)paramList.get(i)).DbD));
        }
        else if (j == 1)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((bpn)paramList.get(i)).DbD);
          this.dqG.add(z.a(((bpn)paramList.get(i)).DbD));
        }
        else if (j == 2)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((bpn)paramList.get(i)).DbD);
          this.dqE.add(z.a(((bpn)paramList.get(i)).DbD));
        }
        else if (j == 4)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((bpn)paramList.get(i)).DbD);
          this.dqH.add(z.a(((bpn)paramList.get(i)).DbD));
        }
        else if ((j != 5) && (j != 6))
        {
          ad.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  private static boolean a(yy paramyy)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!z.a(paramyy.Cxe).toLowerCase().endsWith("@chatroom")) || (paramyy.fpb == 0))
    {
      ad.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramyy.Cxe + "] listCnt:" + paramyy.fpb);
      AppMethodBeat.o(12463);
      return false;
    }
    af localaf = new af();
    localaf.nd(z.a(paramyy.DaZ));
    localaf.ne(z.a(paramyy.Dbb));
    localaf.nf(z.a(paramyy.Dbc));
    localaf.setUsername(z.a(paramyy.Cxe));
    bg localbg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
    if (!localbg.aIb(localaf.field_username)) {
      localbg.af(localaf);
    }
    Object localObject = new com.tencent.mm.ak.i();
    ((com.tencent.mm.ak.i)localObject).username = localaf.field_username;
    ((com.tencent.mm.ak.i)localObject).gUg = paramyy.CVv;
    ((com.tencent.mm.ak.i)localObject).gUf = paramyy.CVw;
    ((com.tencent.mm.ak.i)localObject).evo = 3;
    ((com.tencent.mm.ak.i)localObject).ee(false);
    ((com.tencent.mm.ak.i)localObject).dtM = -1;
    p.auF().b((com.tencent.mm.ak.i)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramyy.Cxd.size())
    {
      if (((bpn)paramyy.Cxd.get(i)).DNS == 0)
      {
        localObject = localbg.aHY(z.a(((bpn)paramyy.Cxd.get(i)).DbD));
        if ((int)((com.tencent.mm.n.b)localObject).fId == 0) {
          break label335;
        }
        ((af)localObject).Zj();
        localbg.c(((au)localObject).field_username, (af)localObject);
      }
      for (;;)
      {
        localArrayList.add(((au)localObject).field_username);
        i += 1;
        break;
        label335:
        localObject = com.tencent.mm.model.q.a((af)localObject, (bpn)paramyy.Cxd.get(i));
        localbg.af((af)localObject);
      }
    }
    if (!localArrayList.contains(u.aqG()))
    {
      localArrayList.add(u.aqG());
      ad.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(u.aqG()));
    }
    boolean bool = com.tencent.mm.model.q.a(localaf.field_username, localArrayList, u.aqG());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof c))
    {
      parama = (c)parama;
      parama.chatroomName = this.dqD;
      parama.dqE = this.dqE;
      parama.dpx = this.dqC;
      parama.dqB = this.dqI;
      parama.foI = this.dqI;
      parama.foJ = this.foJ;
      parama.dqG = this.dqG;
      parama.foK = new LinkedList();
      parama.dqH = this.dqH;
      AppMethodBeat.o(12466);
      return parama;
    }
    AppMethodBeat.o(12466);
    return parama;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    ad.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (yy)this.rr.gUT.gUX;
    this.dqD = z.a(paramq.Cxe);
    paramInt1 = this.rr.gUT.getRetCode();
    this.dqC = paramq.fpb;
    W(paramq.Cxd);
    if ((!bt.isNullOrNil(this.dqD)) && (paramInt1 == 0)) {
      a(paramq);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.i
 * JD-Core Version:    0.7.0.1
 */