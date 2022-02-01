package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.a;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  String iHD;
  private LinkedList<String> iHE;
  String language;
  public final com.tencent.mm.al.b rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151202);
    this.iHE = new LinkedList();
    if ((!bt.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      ad.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, bt.flS().toString() });
    }
    for (;;)
    {
      Object localObject = new b.a();
      ((b.a)localObject).hNM = new bfe();
      ((b.a)localObject).hNN = new bff();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((b.a)localObject).funcId = 453;
      this.rr = ((b.a)localObject).aDC();
      this.iHD = paramString1;
      this.language = paramString2;
      this.iHE.addAll(paramLinkedList);
      int i = 10 - this.iHE.size();
      if (i > 0) {
        this.iHE.addAll(((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().P(i, paramString2));
      }
      localObject = (bfe)this.rr.hNK.hNQ;
      ((bfe)localObject).app_id = paramString1;
      ((bfe)localObject).language = paramString2;
      ((bfe)localObject).GBb = this.iHE;
      ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.iHE) });
      AppMethodBeat.o(151202);
      return;
      ad.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, bt.flS().toString() });
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(151203);
    this.callback = paramf;
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
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iHD, this.language });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    paramq = (bff)this.rr.hNL.hNQ;
    paramArrayOfByte = paramq.GBd;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.dcr.size()), Integer.valueOf(paramArrayOfByte.Fsr.size()) });
    Object localObject = new a();
    ((a)localObject).field_acctTypeId = paramArrayOfByte.Fsq;
    ((a)localObject).field_language = this.language;
    g.ajD();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAccTypeInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "acctTypeId", "language" });
    ((a)localObject).field_accTypeRec = paramArrayOfByte;
    g.ajD();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAccTypeInfoStg().a((a)localObject);
    localObject = paramq.GBc;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((em)localObject).Fwj), Integer.valueOf(((em)localObject).dcr.size()), Integer.valueOf(((em)localObject).Fsr.size()) });
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = this.iHD;
    localc.field_language = this.language;
    g.ajD();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((em)localObject);
    localc.field_acctTypeId = paramArrayOfByte.Fsq;
    g.ajD();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((em)localObject).dcr.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cfq)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((cfq)localObject).key)) {
        ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).IC(((cfq)localObject).url);
      }
    }
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(paramq.GBe.size()) });
    paramq = paramq.GBe.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (efn)paramq.next();
      localObject = new com.tencent.mm.openim.e.e();
      ((com.tencent.mm.openim.e.e)localObject).field_appid = this.iHD;
      ((com.tencent.mm.openim.e.e)localObject).field_wordingId = paramArrayOfByte.HjZ;
      ((com.tencent.mm.openim.e.e)localObject).field_language = this.language;
      g.ajD();
      ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.e.e)localObject).field_wording = paramArrayOfByte.dxD;
      ((com.tencent.mm.openim.e.e)localObject).field_pinyin = paramArrayOfByte.pinyin;
      ((com.tencent.mm.openim.e.e)localObject).field_quanpin = paramArrayOfByte.HQM;
      g.ajD();
      ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.e.e)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */