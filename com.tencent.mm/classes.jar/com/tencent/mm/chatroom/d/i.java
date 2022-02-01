package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.roomsdk.a.a
  implements m
{
  private com.tencent.mm.ak.i callback;
  public int dSV;
  public String dSW;
  public final List<String> dSX;
  public final List<String> dSZ;
  public List<String> dTa;
  public List<String> dTb;
  public final List<String> grY;
  private final d rr;
  
  public i(String paramString, List<String> paramList)
  {
    this(paramString, paramList, null, null);
    AppMethodBeat.i(12461);
    AppMethodBeat.o(12461);
  }
  
  public i(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194025);
    this.dSV = 0;
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() > 0) {
        localObject = (String)paramList.get(0);
      }
    }
    Log.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + paramString1 + " size : " + paramList.size() + " username : " + (String)localObject);
    localObject = new d.a();
    ((d.a)localObject).iLN = new aed();
    ((d.a)localObject).iLO = new aee();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((d.a)localObject).funcId = 119;
    ((d.a)localObject).iLP = 37;
    ((d.a)localObject).respCmdId = 1000000037;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aed)this.rr.iLK.iLR;
    ((aed)localObject).Lpx = com.tencent.mm.platformtools.z.Su(paramString1);
    paramString1 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      con localcon = new con();
      localcon.Lqp = com.tencent.mm.platformtools.z.Su(str);
      paramString1.add(localcon);
    }
    ((aed)localObject).KGQ = paramString1;
    ((aed)localObject).gsq = paramString1.size();
    ((aed)localObject).jfi = paramString2;
    ((aed)localObject).Lpz = paramString3;
    this.dSX = new LinkedList();
    this.grY = new LinkedList();
    this.dSZ = new LinkedList();
    this.dTa = new LinkedList();
    this.dTb = new LinkedList();
    this.dSW = "";
    AppMethodBeat.o(194025);
  }
  
  private void U(List<coo> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((coo)paramList.get(i)).MuH;
      if (j == 0) {
        this.dTb.add(com.tencent.mm.platformtools.z.a(((coo)paramList.get(i)).Lqp));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((coo)paramList.get(i)).Lqp);
          this.grY.add(com.tencent.mm.platformtools.z.a(((coo)paramList.get(i)).Lqp));
        }
        else if (j == 1)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((coo)paramList.get(i)).Lqp);
          this.dSZ.add(com.tencent.mm.platformtools.z.a(((coo)paramList.get(i)).Lqp));
        }
        else if (j == 2)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((coo)paramList.get(i)).Lqp);
          this.dSX.add(com.tencent.mm.platformtools.z.a(((coo)paramList.get(i)).Lqp));
        }
        else if (j == 4)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((coo)paramList.get(i)).Lqp);
          this.dTa.add(com.tencent.mm.platformtools.z.a(((coo)paramList.get(i)).Lqp));
        }
        else if ((j != 5) && (j != 6))
        {
          Log.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  private static boolean a(aee paramaee)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!com.tencent.mm.platformtools.z.a(paramaee.KGR).toLowerCase().endsWith("@chatroom")) || (paramaee.gsq == 0))
    {
      Log.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramaee.KGR + "] listCnt:" + paramaee.gsq);
      AppMethodBeat.o(12463);
      return false;
    }
    as localas = new as();
    localas.setNickname(com.tencent.mm.platformtools.z.a(paramaee.Lpx));
    localas.BF(com.tencent.mm.platformtools.z.a(paramaee.LpA));
    localas.BG(com.tencent.mm.platformtools.z.a(paramaee.LpB));
    localas.setUsername(com.tencent.mm.platformtools.z.a(paramaee.KGR));
    bv localbv = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN();
    if (!localbv.bjN(localas.field_username)) {
      localbv.ap(localas);
    }
    Object localObject = new com.tencent.mm.aj.i();
    ((com.tencent.mm.aj.i)localObject).username = localas.field_username;
    ((com.tencent.mm.aj.i)localObject).iKX = paramaee.Lir;
    ((com.tencent.mm.aj.i)localObject).iKW = paramaee.Lis;
    ((com.tencent.mm.aj.i)localObject).fuz = 3;
    ((com.tencent.mm.aj.i)localObject).fv(false);
    ((com.tencent.mm.aj.i)localObject).cSx = -1;
    p.aYB().b((com.tencent.mm.aj.i)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramaee.KGQ.size())
    {
      if (((coo)paramaee.KGQ.get(i)).MuH == 0)
      {
        localObject = localbv.Kn(com.tencent.mm.platformtools.z.a(((coo)paramaee.KGQ.get(i)).Lqp));
        if ((int)((com.tencent.mm.contact.c)localObject).gMZ == 0) {
          break label336;
        }
        ((as)localObject).aqP();
        localbv.c(((ax)localObject).field_username, (as)localObject);
      }
      for (;;)
      {
        localArrayList.add(((ax)localObject).field_username);
        i += 1;
        break;
        label336:
        localObject = v.a((as)localObject, (coo)paramaee.KGQ.get(i));
        localbv.ap((as)localObject);
      }
    }
    if (!localArrayList.contains(com.tencent.mm.model.z.aTY()))
    {
      localArrayList.add(com.tencent.mm.model.z.aTY());
      Log.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(com.tencent.mm.model.z.aTY()));
    }
    boolean bool = v.a(localas.field_username, localArrayList, com.tencent.mm.model.z.aTY());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof com.tencent.mm.roomsdk.a.b.c))
    {
      parama = (com.tencent.mm.roomsdk.a.b.c)parama;
      parama.chatroomName = this.dSW;
      parama.dSX = this.dSX;
      parama.dRN = this.dSV;
      parama.dSU = this.dTb;
      parama.grX = this.dTb;
      parama.grY = this.grY;
      parama.dSZ = this.dSZ;
      parama.grZ = new LinkedList();
      parama.dTa = this.dTa;
      AppMethodBeat.o(12466);
      return parama;
    }
    AppMethodBeat.o(12466);
    return parama;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(12462);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12462);
    return i;
  }
  
  public final int getType()
  {
    return 119;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12464);
    Log.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (aee)this.rr.iLL.iLR;
    this.dSW = com.tencent.mm.platformtools.z.a(params.KGR);
    paramInt1 = this.rr.iLL.getRetCode();
    this.dSV = params.gsq;
    U(params.KGQ);
    if ((!Util.isNullOrNil(this.dSW)) && (paramInt1 == 0)) {
      a(params);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.i
 * JD-Core Version:    0.7.0.1
 */