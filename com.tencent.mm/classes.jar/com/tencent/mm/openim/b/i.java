package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  String aSt;
  private com.tencent.mm.al.g callback;
  String hNK;
  private LinkedList<String> hNL;
  public final com.tencent.mm.al.b rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151202);
    this.hNL = new LinkedList();
    if ((!bt.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      ad.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, bt.eGN().toString() });
    }
    for (;;)
    {
      Object localObject = new b.a();
      ((b.a)localObject).gUU = new axi();
      ((b.a)localObject).gUV = new axj();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((b.a)localObject).funcId = 453;
      this.rr = ((b.a)localObject).atI();
      this.hNK = paramString1;
      this.aSt = paramString2;
      this.hNL.addAll(paramLinkedList);
      int i = 10 - this.hNL.size();
      if (i > 0) {
        this.hNL.addAll(((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().M(i, paramString2));
      }
      localObject = (axi)this.rr.gUS.gUX;
      ((axi)localObject).app_id = paramString1;
      ((axi)localObject).aSt = paramString2;
      ((axi)localObject).Dwo = this.hNL;
      ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.hNL) });
      AppMethodBeat.o(151202);
      return;
      ad.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, bt.eGN().toString() });
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hNK, this.aSt });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    paramq = (axj)this.rr.gUT.gUX;
    paramArrayOfByte = paramq.Dwq;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.cTE.size()), Integer.valueOf(paramArrayOfByte.CuR.size()) });
    Object localObject = new a();
    ((a)localObject).field_acctTypeId = paramArrayOfByte.CuQ;
    ((a)localObject).field_language = this.aSt;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "acctTypeId", "language" });
    ((a)localObject).field_accTypeRec = paramArrayOfByte;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAccTypeInfoStg().a((a)localObject);
    localObject = paramq.Dwp;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((eg)localObject).Cyv), Integer.valueOf(((eg)localObject).cTE.size()), Integer.valueOf(((eg)localObject).CuR.size()) });
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = this.hNK;
    localc.field_language = this.aSt;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((eg)localObject);
    localc.field_acctTypeId = paramArrayOfByte.CuQ;
    com.tencent.mm.kernel.g.afC();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((eg)localObject).cTE.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (bwh)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((bwh)localObject).key)) {
        ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).Bh(((bwh)localObject).url);
      }
    }
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(paramq.Dwr.size()) });
    paramq = paramq.Dwr.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (dts)paramq.next();
      localObject = new com.tencent.mm.openim.e.e();
      ((com.tencent.mm.openim.e.e)localObject).field_appid = this.hNK;
      ((com.tencent.mm.openim.e.e)localObject).field_wordingId = paramArrayOfByte.EIq;
      ((com.tencent.mm.openim.e.e)localObject).field_language = this.aSt;
      com.tencent.mm.kernel.g.afC();
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.e.e)localObject).field_wording = paramArrayOfByte.doh;
      ((com.tencent.mm.openim.e.e)localObject).field_pinyin = paramArrayOfByte.uLz;
      ((com.tencent.mm.openim.e.e)localObject).field_quanpin = paramArrayOfByte.EIr;
      com.tencent.mm.kernel.g.afC();
      ((PluginOpenIM)com.tencent.mm.kernel.g.ad(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.e.e)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */