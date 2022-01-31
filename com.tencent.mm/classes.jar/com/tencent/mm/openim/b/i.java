package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends m
  implements k
{
  String axa;
  private com.tencent.mm.ai.f callback;
  String gfO;
  private LinkedList<String> gfP;
  public final com.tencent.mm.ai.b rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78858);
    this.gfP = new LinkedList();
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      ab.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, bo.dtY().toString() });
    }
    for (;;)
    {
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new and();
      ((b.a)localObject).fsY = new ane();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((b.a)localObject).funcId = 453;
      this.rr = ((b.a)localObject).ado();
      this.gfO = paramString1;
      this.axa = paramString2;
      this.gfP.addAll(paramLinkedList);
      int i = 10 - this.gfP.size();
      if (i > 0) {
        this.gfP.addAll(((PluginOpenIM)g.G(PluginOpenIM.class)).getWordingInfoStg().E(i, paramString2));
      }
      localObject = (and)this.rr.fsV.fta;
      ((and)localObject).app_id = paramString1;
      ((and)localObject).axa = paramString2;
      ((and)localObject).xdD = this.gfP;
      ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.gfP) });
      AppMethodBeat.o(78858);
      return;
      ab.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, bo.dtY().toString() });
    }
  }
  
  private static String p(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78861);
    String str = "size:" + paramLinkedList.size() + "[";
    Iterator localIterator = paramLinkedList.iterator();
    for (paramLinkedList = str; localIterator.hasNext(); paramLinkedList = paramLinkedList + str + ",") {
      str = (String)localIterator.next();
    }
    paramLinkedList = paramLinkedList + "]";
    AppMethodBeat.o(78861);
    return paramLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(78859);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78859);
    return i;
  }
  
  public final int getType()
  {
    return 453;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78860);
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfO, this.axa });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78860);
      return;
    }
    paramq = (ane)this.rr.fsW.fta;
    paramArrayOfByte = paramq.xdF;
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.ceF.size()), Integer.valueOf(paramArrayOfByte.wmC.size()) });
    Object localObject = new a();
    ((a)localObject).field_acctTypeId = paramArrayOfByte.wmB;
    ((a)localObject).field_language = this.axa;
    g.RM();
    ((PluginOpenIM)g.G(PluginOpenIM.class)).getAccTypeInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "acctTypeId", "language" });
    ((a)localObject).field_accTypeRec = paramArrayOfByte;
    g.RM();
    ((PluginOpenIM)g.G(PluginOpenIM.class)).getAccTypeInfoStg().a((a)localObject);
    localObject = paramq.xdE;
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((dt)localObject).wpI), Integer.valueOf(((dt)localObject).ceF.size()), Integer.valueOf(((dt)localObject).wmC.size()) });
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = this.gfO;
    localc.field_language = this.axa;
    g.RM();
    ((PluginOpenIM)g.G(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((dt)localObject);
    localc.field_acctTypeId = paramArrayOfByte.wmB;
    g.RM();
    ((PluginOpenIM)g.G(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((dt)localObject).ceF.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (biy)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((biy)localObject).key)) {
        ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).wj(((biy)localObject).url);
      }
    }
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(paramq.xdG.size()) });
    paramq = paramq.xdG.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (czc)paramq.next();
      localObject = new com.tencent.mm.openim.e.e();
      ((com.tencent.mm.openim.e.e)localObject).field_appid = this.gfO;
      ((com.tencent.mm.openim.e.e)localObject).field_wordingId = paramArrayOfByte.ygb;
      ((com.tencent.mm.openim.e.e)localObject).field_language = this.axa;
      g.RM();
      ((PluginOpenIM)g.G(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.e.e)localObject).field_wording = paramArrayOfByte.cyA;
      ((com.tencent.mm.openim.e.e)localObject).field_pinyin = paramArrayOfByte.pJg;
      ((com.tencent.mm.openim.e.e)localObject).field_quanpin = paramArrayOfByte.ygc;
      g.RM();
      ((PluginOpenIM)g.G(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.e.e)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */