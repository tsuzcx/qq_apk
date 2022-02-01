package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.roomsdk.a.b.c;
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
  private com.tencent.mm.an.i callback;
  public int fMs;
  public final List<String> fMt;
  public final List<String> fMv;
  public List<String> fMw;
  public List<String> fMx;
  public String fwY;
  public final List<String> iWj;
  private final com.tencent.mm.an.d rr;
  
  public i(String paramString, List<String> paramList)
  {
    this(paramString, paramList, null, null);
    AppMethodBeat.i(12461);
    AppMethodBeat.o(12461);
  }
  
  public i(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188075);
    this.fMs = 0;
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
    ((d.a)localObject).lBU = new aek();
    ((d.a)localObject).lBV = new ael();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((d.a)localObject).funcId = 119;
    ((d.a)localObject).lBW = 37;
    ((d.a)localObject).respCmdId = 1000000037;
    this.rr = ((d.a)localObject).bgN();
    localObject = (aek)d.b.b(this.rr.lBR);
    ((aek)localObject).SqT = com.tencent.mm.platformtools.z.ZW(paramString1);
    paramString1 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      cwz localcwz = new cwz();
      localcwz.SrM = com.tencent.mm.platformtools.z.ZW(str);
      paramString1.add(localcwz);
    }
    ((aek)localObject).RIk = paramString1;
    ((aek)localObject).iWB = paramString1.size();
    ((aek)localObject).lVG = paramString2;
    ((aek)localObject).SqV = paramString3;
    this.fMt = new LinkedList();
    this.iWj = new LinkedList();
    this.fMv = new LinkedList();
    this.fMw = new LinkedList();
    this.fMx = new LinkedList();
    this.fwY = "";
    AppMethodBeat.o(188075);
  }
  
  private void R(List<cxa> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((cxa)paramList.get(i)).TFy;
      if (j == 0) {
        this.fMx.add(com.tencent.mm.platformtools.z.a(((cxa)paramList.get(i)).SrM));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((cxa)paramList.get(i)).SrM);
          this.iWj.add(com.tencent.mm.platformtools.z.a(((cxa)paramList.get(i)).SrM));
        }
        else if (j == 1)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((cxa)paramList.get(i)).SrM);
          this.fMv.add(com.tencent.mm.platformtools.z.a(((cxa)paramList.get(i)).SrM));
        }
        else if (j == 2)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((cxa)paramList.get(i)).SrM);
          this.fMt.add(com.tencent.mm.platformtools.z.a(((cxa)paramList.get(i)).SrM));
        }
        else if (j == 4)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((cxa)paramList.get(i)).SrM);
          this.fMw.add(com.tencent.mm.platformtools.z.a(((cxa)paramList.get(i)).SrM));
        }
        else if ((j != 5) && (j != 6))
        {
          Log.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  private static boolean a(ael paramael)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!com.tencent.mm.platformtools.z.a(paramael.RIl).toLowerCase().endsWith("@chatroom")) || (paramael.iWB == 0))
    {
      Log.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramael.RIl + "] listCnt:" + paramael.iWB);
      AppMethodBeat.o(12463);
      return false;
    }
    as localas = new as();
    localas.setNickname(com.tencent.mm.platformtools.z.a(paramael.SqT));
    localas.It(com.tencent.mm.platformtools.z.a(paramael.SqW));
    localas.Iu(com.tencent.mm.platformtools.z.a(paramael.SqX));
    localas.setUsername(com.tencent.mm.platformtools.z.a(paramael.RIl));
    bv localbv = ((n)h.ae(n.class)).bbL();
    if (!localbv.bwl(localas.field_username)) {
      localbv.av(localas);
    }
    Object localObject = new j();
    ((j)localObject).username = localas.field_username;
    ((j)localObject).lBe = paramael.SjI;
    ((j)localObject).lBd = paramael.SjJ;
    ((j)localObject).hDc = 3;
    ((j)localObject).gg(false);
    ((j)localObject).cUP = -1;
    q.bhP().b((j)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramael.RIk.size())
    {
      if (((cxa)paramael.RIk.get(i)).TFy == 0)
      {
        localObject = localbv.RG(com.tencent.mm.platformtools.z.a(((cxa)paramael.RIk.get(i)).SrM));
        if ((int)((com.tencent.mm.contact.d)localObject).jxt == 0) {
          break label336;
        }
        ((as)localObject).axj();
        localbv.c(((ax)localObject).field_username, (as)localObject);
      }
      for (;;)
      {
        localArrayList.add(((ax)localObject).field_username);
        i += 1;
        break;
        label336:
        localObject = v.a((as)localObject, (cxa)paramael.RIk.get(i));
        localbv.av((as)localObject);
      }
    }
    if (!localArrayList.contains(com.tencent.mm.model.z.bcZ()))
    {
      localArrayList.add(com.tencent.mm.model.z.bcZ());
      Log.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(com.tencent.mm.model.z.bcZ()));
    }
    boolean bool = v.a(localas.field_username, localArrayList, com.tencent.mm.model.z.bcZ());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof c))
    {
      parama = (c)parama;
      parama.chatroomName = this.fwY;
      parama.fMt = this.fMt;
      parama.fLk = this.fMs;
      parama.fMr = this.fMx;
      parama.iWi = this.fMx;
      parama.iWj = this.iWj;
      parama.fMv = this.fMv;
      parama.iWk = new LinkedList();
      parama.fMw = this.fMw;
      AppMethodBeat.o(12466);
      return parama;
    }
    AppMethodBeat.o(12466);
    return parama;
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
    params = (ael)d.c.b(this.rr.lBS);
    this.fwY = com.tencent.mm.platformtools.z.a(params.RIl);
    paramInt1 = this.rr.lBS.getRetCode();
    this.fMs = params.iWB;
    R(params.RIk);
    if ((!Util.isNullOrNil(this.fwY)) && (paramInt1 == 0)) {
      a(params);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.i
 * JD-Core Version:    0.7.0.1
 */