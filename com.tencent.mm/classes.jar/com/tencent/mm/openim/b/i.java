package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  String aTm;
  private com.tencent.mm.ak.g callback;
  String iog;
  private LinkedList<String> ioh;
  public final com.tencent.mm.ak.b rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151202);
    this.ioh = new LinkedList();
    if ((!bs.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      ac.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, bs.eWi().toString() });
    }
    for (;;)
    {
      Object localObject = new b.a();
      ((b.a)localObject).hvt = new bba();
      ((b.a)localObject).hvu = new bbb();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((b.a)localObject).funcId = 453;
      this.rr = ((b.a)localObject).aAz();
      this.iog = paramString1;
      this.aTm = paramString2;
      this.ioh.addAll(paramLinkedList);
      int i = 10 - this.ioh.size();
      if (i > 0) {
        this.ioh.addAll(((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().N(i, paramString2));
      }
      localObject = (bba)this.rr.hvr.hvw;
      ((bba)localObject).app_id = paramString1;
      ((bba)localObject).aTm = paramString2;
      ((bba)localObject).ERJ = this.ioh;
      ac.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.ioh) });
      AppMethodBeat.o(151202);
      return;
      ac.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, bs.eWi().toString() });
    }
  }
  
  private static String p(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151205);
    String str = "size:" + paramLinkedList.size() + "[";
    Iterator localIterator = paramLinkedList.iterator();
    for (paramLinkedList = str; localIterator.hasNext(); paramLinkedList = paramLinkedList + str + ",") {
      str = (String)localIterator.next();
    }
    paramLinkedList = paramLinkedList + "]";
    AppMethodBeat.o(151205);
    return paramLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151203);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151203);
    return i;
  }
  
  public final int getType()
  {
    return 453;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151204);
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iog, this.aTm });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    paramq = (bbb)this.rr.hvs.hvw;
    paramArrayOfByte = paramq.ERL;
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.cRb.size()), Integer.valueOf(paramArrayOfByte.DNm.size()) });
    Object localObject = new a();
    ((a)localObject).field_acctTypeId = paramArrayOfByte.DNl;
    ((a)localObject).field_language = this.aTm;
    com.tencent.mm.kernel.g.agS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "acctTypeId", "language" });
    ((a)localObject).field_accTypeRec = paramArrayOfByte;
    com.tencent.mm.kernel.g.agS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().a((a)localObject);
    localObject = paramq.ERK;
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((ei)localObject).DQR), Integer.valueOf(((ei)localObject).cRb.size()), Integer.valueOf(((ei)localObject).DNm.size()) });
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = this.iog;
    localc.field_language = this.aTm;
    com.tencent.mm.kernel.g.agS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((ei)localObject);
    localc.field_acctTypeId = paramArrayOfByte.DNl;
    com.tencent.mm.kernel.g.agS();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((ei)localObject).cRb.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (caz)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((caz)localObject).key)) {
        ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).Fm(((caz)localObject).url);
      }
    }
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(paramq.ERM.size()) });
    paramq = paramq.ERM.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (dzj)paramq.next();
      localObject = new com.tencent.mm.openim.e.e();
      ((com.tencent.mm.openim.e.e)localObject).field_appid = this.iog;
      ((com.tencent.mm.openim.e.e)localObject).field_wordingId = paramArrayOfByte.GfC;
      ((com.tencent.mm.openim.e.e)localObject).field_language = this.aTm;
      com.tencent.mm.kernel.g.agS();
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.e.e)localObject).field_wording = paramArrayOfByte.dlQ;
      ((com.tencent.mm.openim.e.e)localObject).field_pinyin = paramArrayOfByte.pinyin;
      ((com.tencent.mm.openim.e.e)localObject).field_quanpin = paramArrayOfByte.GfD;
      com.tencent.mm.kernel.g.agS();
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.e.e)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */