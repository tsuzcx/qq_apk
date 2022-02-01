package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  public int dBg;
  public String dBh;
  public final List<String> dBi;
  public final List<String> dBk;
  public List<String> dBl;
  public List<String> dBm;
  public final List<String> fMM;
  private final b rr;
  
  public i(String paramString, List<String> paramList)
  {
    this(paramString, paramList, null, null);
    AppMethodBeat.i(12461);
    AppMethodBeat.o(12461);
  }
  
  public i(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217111);
    this.dBg = 0;
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0) {
        localObject = (String)paramList.get(0);
      }
    }
    ae.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString1 + " size : " + paramList.size() + " username : " + (String)localObject);
    localObject = new b.a();
    ((b.a)localObject).hQF = new acb();
    ((b.a)localObject).hQG = new acc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((b.a)localObject).funcId = 119;
    ((b.a)localObject).hQH = 37;
    ((b.a)localObject).respCmdId = 1000000037;
    this.rr = ((b.a)localObject).aDS();
    localObject = (acb)this.rr.hQD.hQJ;
    ((acb)localObject).GtV = z.Jw(paramString1);
    paramString1 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      bzm localbzm = new bzm();
      localbzm.GuK = z.Jw(str);
      paramString1.add(localbzm);
    }
    ((acb)localObject).FNl = paramString1;
    ((acb)localObject).fNf = paramString1.size();
    ((acb)localObject).ikm = paramString2;
    ((acb)localObject).GtX = paramString3;
    this.dBi = new LinkedList();
    this.fMM = new LinkedList();
    this.dBk = new LinkedList();
    this.dBl = new LinkedList();
    this.dBm = new LinkedList();
    this.dBh = "";
    AppMethodBeat.o(217111);
  }
  
  private void O(List<bzn> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((bzn)paramList.get(i)).Hns;
      if (j == 0) {
        this.dBm.add(z.a(((bzn)paramList.get(i)).GuK));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          ae.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((bzn)paramList.get(i)).GuK);
          this.fMM.add(z.a(((bzn)paramList.get(i)).GuK));
        }
        else if (j == 1)
        {
          ae.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((bzn)paramList.get(i)).GuK);
          this.dBk.add(z.a(((bzn)paramList.get(i)).GuK));
        }
        else if (j == 2)
        {
          ae.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((bzn)paramList.get(i)).GuK);
          this.dBi.add(z.a(((bzn)paramList.get(i)).GuK));
        }
        else if (j == 4)
        {
          ae.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((bzn)paramList.get(i)).GuK);
          this.dBl.add(z.a(((bzn)paramList.get(i)).GuK));
        }
        else if ((j != 5) && (j != 6))
        {
          ae.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  private static boolean a(acc paramacc)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!z.a(paramacc.FNm).toLowerCase().endsWith("@chatroom")) || (paramacc.fNf == 0))
    {
      ae.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramacc.FNm + "] listCnt:" + paramacc.fNf);
      AppMethodBeat.o(12463);
      return false;
    }
    an localan = new an();
    localan.to(z.a(paramacc.GtV));
    localan.tp(z.a(paramacc.GtY));
    localan.tq(z.a(paramacc.GtZ));
    localan.setUsername(z.a(paramacc.FNm));
    bq localbq = ((l)g.ab(l.class)).azF();
    if (!localbq.aUO(localan.field_username)) {
      localbq.an(localan);
    }
    Object localObject = new com.tencent.mm.aj.i();
    ((com.tencent.mm.aj.i)localObject).username = localan.field_username;
    ((com.tencent.mm.aj.i)localObject).hPQ = paramacc.GnN;
    ((com.tencent.mm.aj.i)localObject).hPP = paramacc.GnO;
    ((com.tencent.mm.aj.i)localObject).eQU = 3;
    ((com.tencent.mm.aj.i)localObject).eD(false);
    ((com.tencent.mm.aj.i)localObject).dEu = -1;
    p.aEN().b((com.tencent.mm.aj.i)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramacc.FNl.size())
    {
      if (((bzn)paramacc.FNl.get(i)).Hns == 0)
      {
        localObject = localbq.BH(z.a(((bzn)paramacc.FNl.get(i)).GuK));
        if ((int)((com.tencent.mm.contact.c)localObject).ght == 0) {
          break label336;
        }
        ((an)localObject).acR();
        localbq.c(((aw)localObject).field_username, (an)localObject);
      }
      for (;;)
      {
        localArrayList.add(((aw)localObject).field_username);
        i += 1;
        break;
        label336:
        localObject = r.a((an)localObject, (bzn)paramacc.FNl.get(i));
        localbq.an((an)localObject);
      }
    }
    if (!localArrayList.contains(v.aAC()))
    {
      localArrayList.add(v.aAC());
      ae.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(v.aAC()));
    }
    boolean bool = r.a(localan.field_username, localArrayList, v.aAC());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof com.tencent.mm.roomsdk.a.b.c))
    {
      parama = (com.tencent.mm.roomsdk.a.b.c)parama;
      parama.chatroomName = this.dBh;
      parama.dBi = this.dBi;
      parama.dAb = this.dBg;
      parama.dBf = this.dBm;
      parama.fML = this.dBm;
      parama.fMM = this.fMM;
      parama.dBk = this.dBk;
      parama.fMN = new LinkedList();
      parama.dBl = this.dBl;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12464);
    ae.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (acc)this.rr.hQE.hQJ;
    this.dBh = z.a(paramq.FNm);
    paramInt1 = this.rr.hQE.getRetCode();
    this.dBg = paramq.fNf;
    O(paramq.FNl);
    if ((!bu.isNullOrNil(this.dBh)) && (paramInt1 == 0)) {
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