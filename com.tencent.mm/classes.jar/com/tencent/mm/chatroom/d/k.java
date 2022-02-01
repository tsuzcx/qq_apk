package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends com.tencent.mm.roomsdk.model.a
  implements m
{
  private com.tencent.mm.am.h callback;
  public String hBy;
  public int hSc;
  public final List<String> hSd;
  public final List<String> hSf;
  public List<String> hSg;
  public List<String> hSh;
  public final List<String> lyk;
  private final com.tencent.mm.am.c rr;
  
  public k(String paramString, List<String> paramList)
  {
    this(paramString, paramList, null, null);
    AppMethodBeat.i(12461);
    AppMethodBeat.o(12461);
  }
  
  public k(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241438);
    this.hSc = 0;
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
    localObject = new c.a();
    ((c.a)localObject).otE = new agw();
    ((c.a)localObject).otF = new agx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/createchatroom";
    ((c.a)localObject).funcId = 119;
    ((c.a)localObject).otG = 37;
    ((c.a)localObject).respCmdId = 1000000037;
    this.rr = ((c.a)localObject).bEF();
    localObject = (agw)c.b.b(this.rr.otB);
    ((agw)localObject).ZpU = w.Sk(paramString1);
    paramString1 = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      str = (String)paramList.next();
      doe localdoe = new doe();
      localdoe.ZqQ = w.Sk(str);
      paramString1.add(localdoe);
    }
    ((agw)localObject).YFm = paramString1;
    ((agw)localObject).lyF = paramString1.size();
    ((agw)localObject).oOI = paramString2;
    ((agw)localObject).ZpW = paramString3;
    this.hSd = new LinkedList();
    this.lyk = new LinkedList();
    this.hSf = new LinkedList();
    this.hSg = new LinkedList();
    this.hSh = new LinkedList();
    this.hBy = "";
    AppMethodBeat.o(241438);
  }
  
  private static boolean a(agx paramagx)
  {
    int i = 0;
    AppMethodBeat.i(12463);
    if ((!w.a(paramagx.YFn).toLowerCase().endsWith("@chatroom")) || (paramagx.lyF == 0))
    {
      Log.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + paramagx.YFn + "] listCnt:" + paramagx.lyF);
      AppMethodBeat.o(12463);
      return false;
    }
    au localau = new au();
    localau.setNickname(w.a(paramagx.ZpU));
    localau.AY(w.a(paramagx.ZpX));
    localau.AZ(w.a(paramagx.ZpY));
    localau.setUsername(w.a(paramagx.YFn));
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    if (!localbx.bxy(localau.field_username)) {
      localbx.aB(localau);
    }
    Object localObject = new j();
    ((j)localObject).username = localau.field_username;
    ((j)localObject).osN = paramagx.ZhO;
    ((j)localObject).osM = paramagx.ZhP;
    ((j)localObject).jZY = 3;
    ((j)localObject).gX(false);
    ((j)localObject).eQp = -1;
    q.bFE().b((j)localObject);
    ArrayList localArrayList = new ArrayList();
    if (i < paramagx.YFm.size())
    {
      if (((dof)paramagx.YFm.get(i)).aaVf == 0)
      {
        localObject = localbx.JE(w.a(((dof)paramagx.YFm.get(i)).ZqQ));
        if ((int)((d)localObject).maN == 0) {
          break label334;
        }
        ((au)localObject).aRJ();
        localbx.d(((az)localObject).field_username, (au)localObject);
      }
      for (;;)
      {
        localArrayList.add(((az)localObject).field_username);
        i += 1;
        break;
        label334:
        localObject = v.a((au)localObject, (dof)paramagx.YFm.get(i));
        localbx.aB((au)localObject);
      }
    }
    if (!localArrayList.contains(z.bAM()))
    {
      localArrayList.add(z.bAM());
      Log.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + localArrayList.contains(z.bAM()));
    }
    boolean bool = v.a(localau.field_username, localArrayList, z.bAM());
    AppMethodBeat.o(12463);
    return bool;
  }
  
  private void br(List<dof> paramList)
  {
    AppMethodBeat.i(12465);
    int i = 0;
    if (i < paramList.size())
    {
      int j = ((dof)paramList.get(i)).aaVf;
      if (j == 0) {
        this.hSh.add(w.a(((dof)paramList.get(i)).ZqQ));
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((dof)paramList.get(i)).ZqQ);
          this.lyk.add(w.a(((dof)paramList.get(i)).ZqQ));
        }
        else if (j == 1)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((dof)paramList.get(i)).ZqQ);
          this.hSf.add(w.a(((dof)paramList.get(i)).ZqQ));
        }
        else if (j == 2)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((dof)paramList.get(i)).ZqQ);
          this.hSd.add(w.a(((dof)paramList.get(i)).ZqQ));
        }
        else if (j == 4)
        {
          Log.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((dof)paramList.get(i)).ZqQ);
          this.hSg.add(w.a(((dof)paramList.get(i)).ZqQ));
        }
        else if ((j != 5) && (j != 6))
        {
          Log.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(j)));
        }
      }
    }
    AppMethodBeat.o(12465);
  }
  
  public final com.tencent.mm.roomsdk.model.b.a a(com.tencent.mm.roomsdk.model.b.a parama)
  {
    AppMethodBeat.i(12466);
    if ((parama instanceof com.tencent.mm.roomsdk.model.b.c))
    {
      parama = (com.tencent.mm.roomsdk.model.b.c)parama;
      parama.chatroomName = this.hBy;
      parama.hSd = this.hSd;
      parama.hQS = this.hSc;
      parama.hSb = this.hSh;
      parama.lyj = this.hSh;
      parama.lyk = this.lyk;
      parama.hSf = this.hSf;
      parama.lyl = new LinkedList();
      parama.hSg = this.hSg;
      AppMethodBeat.o(12466);
      return parama;
    }
    AppMethodBeat.o(12466);
    return parama;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(12462);
    this.callback = paramh;
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
    params = (agx)c.c.b(this.rr.otC);
    this.hBy = w.a(params.YFn);
    paramInt1 = this.rr.otC.getRetCode();
    this.hSc = params.lyF;
    br(params.YFm);
    if ((!Util.isNullOrNil(this.hBy)) && (paramInt1 == 0)) {
      a(params);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.k
 * JD-Core Version:    0.7.0.1
 */