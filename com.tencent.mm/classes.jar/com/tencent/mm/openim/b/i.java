package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.b;
import com.tencent.mm.openim.e.c;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  String language;
  String myg;
  private LinkedList<String> myh;
  public final com.tencent.mm.an.d rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151202);
    this.myh = new LinkedList();
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      Log.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, Util.getStack().toString() });
    }
    for (;;)
    {
      Object localObject = new d.a();
      ((d.a)localObject).lBU = new bzm();
      ((d.a)localObject).lBV = new bzn();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((d.a)localObject).funcId = 453;
      this.rr = ((d.a)localObject).bgN();
      this.myg = paramString1;
      this.language = paramString2;
      this.myh.addAll(paramLinkedList);
      int i = 10 - this.myh.size();
      if (i > 0) {
        this.myh.addAll(((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().U(i, paramString2));
      }
      localObject = (bzm)d.b.b(this.rr.lBR);
      ((bzm)localObject).app_id = paramString1;
      ((bzm)localObject).language = paramString2;
      ((bzm)localObject).Tin = this.myh;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.myh) });
      AppMethodBeat.o(151202);
      return;
      Log.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, Util.getStack().toString() });
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(151203);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151203);
    return i;
  }
  
  public final int getType()
  {
    return 453;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151204);
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.myg, this.language });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    params = (bzn)d.c.b(this.rr.lBS);
    paramArrayOfByte = params.Tip;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.fmW.size()), Integer.valueOf(paramArrayOfByte.RFH.size()) });
    Object localObject = new com.tencent.mm.openim.e.a();
    ((com.tencent.mm.openim.e.a)localObject).field_acctTypeId = paramArrayOfByte.RFG;
    ((com.tencent.mm.openim.e.a)localObject).field_language = this.language;
    com.tencent.mm.kernel.h.aHH();
    ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getAccTypeInfoStg().get((IAutoDBItem)localObject, new String[] { "acctTypeId", "language" });
    ((com.tencent.mm.openim.e.a)localObject).field_accTypeRec = paramArrayOfByte;
    com.tencent.mm.kernel.h.aHH();
    ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getAccTypeInfoStg().a((com.tencent.mm.openim.e.a)localObject);
    localObject = params.Tio;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((ew)localObject).RJG), Integer.valueOf(((ew)localObject).fmW.size()), Integer.valueOf(((ew)localObject).RFH.size()) });
    c localc = new c();
    localc.field_appid = this.myg;
    localc.field_language = this.language;
    com.tencent.mm.kernel.h.aHH();
    ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((ew)localObject);
    localc.field_acctTypeId = paramArrayOfByte.RFG;
    com.tencent.mm.kernel.h.aHH();
    ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((ew)localObject).fmW.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (dgb)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((dgb)localObject).key)) {
        ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).ZA(((dgb)localObject).url);
      }
    }
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(params.Tiq.size()) });
    params = params.Tiq.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (fmp)params.next();
      localObject = new com.tencent.mm.openim.e.g();
      ((com.tencent.mm.openim.e.g)localObject).field_appid = this.myg;
      ((com.tencent.mm.openim.e.g)localObject).field_wordingId = paramArrayOfByte.Uam;
      ((com.tencent.mm.openim.e.g)localObject).field_language = this.language;
      com.tencent.mm.kernel.h.aHH();
      ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.e.g)localObject).field_wording = paramArrayOfByte.wording;
      ((com.tencent.mm.openim.e.g)localObject).field_pinyin = paramArrayOfByte.pinyin;
      ((com.tencent.mm.openim.e.g)localObject).field_quanpin = paramArrayOfByte.ULo;
      com.tencent.mm.kernel.h.aHH();
      ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.e.g)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */