package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  String iKw;
  private LinkedList<String> iKx;
  String language;
  public final com.tencent.mm.ak.b rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151202);
    this.iKx = new LinkedList();
    if ((!bu.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      ae.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, bu.fpN().toString() });
    }
    for (;;)
    {
      Object localObject = new b.a();
      ((b.a)localObject).hQF = new bfu();
      ((b.a)localObject).hQG = new bfv();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((b.a)localObject).funcId = 453;
      this.rr = ((b.a)localObject).aDS();
      this.iKw = paramString1;
      this.language = paramString2;
      this.iKx.addAll(paramLinkedList);
      int i = 10 - this.iKx.size();
      if (i > 0) {
        this.iKx.addAll(((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().P(i, paramString2));
      }
      localObject = (bfu)this.rr.hQD.hQJ;
      ((bfu)localObject).app_id = paramString1;
      ((bfu)localObject).language = paramString2;
      ((bfu)localObject).GUB = this.iKx;
      ae.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.iKx) });
      AppMethodBeat.o(151202);
      return;
      ae.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, bu.fpN().toString() });
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iKw, this.language });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    paramq = (bfv)this.rr.hQE.hQJ;
    paramArrayOfByte = paramq.GUD;
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.ddt.size()), Integer.valueOf(paramArrayOfByte.FKP.size()) });
    Object localObject = new com.tencent.mm.openim.e.a();
    ((com.tencent.mm.openim.e.a)localObject).field_acctTypeId = paramArrayOfByte.FKO;
    ((com.tencent.mm.openim.e.a)localObject).field_language = this.language;
    g.ajS();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAccTypeInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "acctTypeId", "language" });
    ((com.tencent.mm.openim.e.a)localObject).field_accTypeRec = paramArrayOfByte;
    g.ajS();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAccTypeInfoStg().a((com.tencent.mm.openim.e.a)localObject);
    localObject = paramq.GUC;
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((em)localObject).FOH), Integer.valueOf(((em)localObject).ddt.size()), Integer.valueOf(((em)localObject).FKP.size()) });
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = this.iKw;
    localc.field_language = this.language;
    g.ajS();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((em)localObject);
    localc.field_acctTypeId = paramArrayOfByte.FKO;
    g.ajS();
    ((PluginOpenIM)g.ad(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((em)localObject).ddt.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cgk)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((cgk)localObject).key)) {
        ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).Jb(((cgk)localObject).url);
      }
    }
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(paramq.GUE.size()) });
    paramq = paramq.GUE.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (ehe)paramq.next();
      localObject = new com.tencent.mm.openim.e.e();
      ((com.tencent.mm.openim.e.e)localObject).field_appid = this.iKw;
      ((com.tencent.mm.openim.e.e)localObject).field_wordingId = paramArrayOfByte.HDz;
      ((com.tencent.mm.openim.e.e)localObject).field_language = this.language;
      g.ajS();
      ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().get((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.e.e)localObject).field_wording = paramArrayOfByte.dyI;
      ((com.tencent.mm.openim.e.e)localObject).field_pinyin = paramArrayOfByte.pinyin;
      ((com.tencent.mm.openim.e.e)localObject).field_quanpin = paramArrayOfByte.IkT;
      g.ajS();
      ((PluginOpenIM)g.ad(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.e.e)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */