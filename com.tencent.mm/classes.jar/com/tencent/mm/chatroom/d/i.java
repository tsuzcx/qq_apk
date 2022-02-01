package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.abt;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  public int dAb;
  public String dAc;
  public final List<String> dAd;
  public final List<String> dAf;
  public List<String> dAg;
  public List<String> dAh;
  public final List<String> fKJ;
  private final com.tencent.mm.al.b rr;
  
  public i(String paramString, List<String> paramList)
  {
    this(paramString, paramList, null, null);
    AppMethodBeat.i(12461);
    AppMethodBeat.o(12461);
  }
  
  public i(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213399);
    this.dAb = 0;
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0) {
        localObject = (String)paramList.get(0);
      }
    }
    ad.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString1 + " size : " + paramList.size() + " username : " + (String)localObject);
    localObject = new b.a();
    ((b.a)localObject).hNM = new abs();
    ((b.a)localObject).hNN = new abt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((b.a)localObject).funcId = 119;
    ((b.a)localObject).hNO = 37;
    ((b.a)localObject).respCmdId = 1000000037;
    this.rr = ((b.a)localObject).aDC();
    localObject = (abs)this.rr.hNK.hNQ;
    ((abs)localObject).Gbo = z.IX(paramString1);
    paramString1 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      bys localbys = new bys();
      localbys.Gcd = z.IX(str);
      paramString1.add(localbys);
    }
    ((abs)localObject).FuN = paramString1;
    ((abs)localObject).fLb = paramString1.size();
    ((abs)localObject).iht = paramString2;
    ((abs)localObject).Gbq = paramString3;
    this.dAd = new LinkedList();
    this.fKJ = new LinkedList();
    this.dAf = new LinkedList();
    this.dAg = new LinkedList();
    this.dAh = new LinkedList();
    this.dAc = "";
    AppMethodBeat.o(213399);
  }
  
  private void O(List<byt> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((byt)paramList.get(i)).GTR;
      if (j == 0) {
        this.dAh.add(z.a(((byt)paramList.get(i)).Gcd));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((byt)paramList.get(i)).Gcd);
          this.fKJ.add(z.a(((byt)paramList.get(i)).Gcd));
        }
        else if (j == 1)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((byt)paramList.get(i)).Gcd);
          this.dAf.add(z.a(((byt)paramList.get(i)).Gcd));
        }
        else if (j == 2)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((byt)paramList.get(i)).Gcd);
          this.dAd.add(z.a(((byt)paramList.get(i)).Gcd));
        }
        else if (j == 4)
        {
          ad.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((byt)paramList.get(i)).Gcd);
          this.dAg.add(z.a(((byt)paramList.get(i)).Gcd));
        }
        else if ((j != 5) && (j != 6))
        {
          ad.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  private static boolean a(abt paramabt)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!z.a(paramabt.FuO).toLowerCase().endsWith("@chatroom")) || (paramabt.fLb == 0))
    {
      ad.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramabt.FuO + "] listCnt:" + paramabt.fLb);
      AppMethodBeat.o(12463);
      return false;
    }
    am localam = new am();
    localam.sT(z.a(paramabt.Gbo));
    localam.sU(z.a(paramabt.Gbr));
    localam.sV(z.a(paramabt.Gbs));
    localam.setUsername(z.a(paramabt.FuO));
    bp localbp = ((l)g.ab(l.class)).azp();
    if (!localbp.aTn(localam.field_username)) {
      localbp.ag(localam);
    }
    Object localObject = new com.tencent.mm.ak.i();
    ((com.tencent.mm.ak.i)localObject).username = localam.field_username;
    ((com.tencent.mm.ak.i)localObject).hMX = paramabt.FVo;
    ((com.tencent.mm.ak.i)localObject).hMW = paramabt.FVp;
    ((com.tencent.mm.ak.i)localObject).ePj = 3;
    ((com.tencent.mm.ak.i)localObject).eB(false);
    ((com.tencent.mm.ak.i)localObject).dDp = -1;
    p.aEx().b((com.tencent.mm.ak.i)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramabt.FuN.size())
    {
      if (((byt)paramabt.FuN.get(i)).GTR == 0)
      {
        localObject = localbp.Bf(z.a(((byt)paramabt.FuN.get(i)).Gcd));
        if ((int)((com.tencent.mm.o.b)localObject).gfj == 0) {
          break label336;
        }
        ((am)localObject).acG();
        localbp.c(((aw)localObject).field_username, (am)localObject);
      }
      for (;;)
      {
        localArrayList.add(((aw)localObject).field_username);
        i += 1;
        break;
        label336:
        localObject = com.tencent.mm.model.q.a((am)localObject, (byt)paramabt.FuN.get(i));
        localbp.ag((am)localObject);
      }
    }
    if (!localArrayList.contains(u.aAm()))
    {
      localArrayList.add(u.aAm());
      ad.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(u.aAm()));
    }
    boolean bool = com.tencent.mm.model.q.a(localam.field_username, localArrayList, u.aAm());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof c))
    {
      parama = (c)parama;
      parama.chatroomName = this.dAc;
      parama.dAd = this.dAd;
      parama.dyW = this.dAb;
      parama.dAa = this.dAh;
      parama.fKI = this.dAh;
      parama.fKJ = this.fKJ;
      parama.dAf = this.dAf;
      parama.fKK = new LinkedList();
      parama.dAg = this.dAg;
      AppMethodBeat.o(12466);
      return parama;
    }
    AppMethodBeat.o(12466);
    return parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12462);
    this.callback = paramf;
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
    paramq = (abt)this.rr.hNL.hNQ;
    this.dAc = z.a(paramq.FuO);
    paramInt1 = this.rr.hNL.getRetCode();
    this.dAb = paramq.fLb;
    O(paramq.FuN);
    if ((!bt.isNullOrNil(this.dAc)) && (paramInt1 == 0)) {
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