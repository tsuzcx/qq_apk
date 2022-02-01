package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.e.a;
import com.tencent.mm.openim.e.b;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.openim.e.k;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.protocal.protobuf.gjh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  String language;
  String psy;
  private LinkedList<String> psz;
  public final com.tencent.mm.am.c rr;
  int subType;
  
  public l(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    this(paramString1, paramString2, paramLinkedList, 0);
    AppMethodBeat.i(151202);
    AppMethodBeat.o(151202);
  }
  
  public l(String paramString1, String paramString2, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(235828);
    this.psz = new LinkedList();
    this.subType = 0;
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      Log.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, Util.getStack().toString() });
    }
    for (;;)
    {
      Object localObject = new c.a();
      ((c.a)localObject).otE = new cov();
      ((c.a)localObject).otF = new cow();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((c.a)localObject).funcId = 453;
      this.rr = ((c.a)localObject).bEF();
      this.psy = paramString1;
      this.language = paramString2;
      this.subType = paramInt;
      this.psz.addAll(paramLinkedList);
      int i = 10 - this.psz.size();
      if (i > 0) {
        this.psz.addAll(((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().ac(i, paramString2));
      }
      localObject = (cov)c.b.b(this.rr.otB);
      ((cov)localObject).app_id = paramString1;
      ((cov)localObject).language = paramString2;
      ((cov)localObject).aavL = this.psz;
      ((cov)localObject).subtype = paramInt;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, subType: %s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), p(paramLinkedList), p(this.psz) });
      AppMethodBeat.o(235828);
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151203);
    this.callback = paramh;
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
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.psy, this.language });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    params = (cow)c.c.b(this.rr.otC);
    paramArrayOfByte = params.aavN;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.hrh.size()), Integer.valueOf(paramArrayOfByte.YCk.size()) });
    Object localObject = new a();
    ((a)localObject).field_acctTypeId = paramArrayOfByte.YCj;
    ((a)localObject).field_language = this.language;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAccTypeInfoStg().get((IAutoDBItem)localObject, new String[] { "acctTypeId", "language" });
    ((a)localObject).field_accTypeRec = paramArrayOfByte;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAccTypeInfoStg().a((a)localObject);
    localObject = params.aavM;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d, subType: %s", new Object[] { Integer.valueOf(((fq)localObject).YHa), Integer.valueOf(((fq)localObject).hrh.size()), Integer.valueOf(((fq)localObject).YCk.size()), Integer.valueOf(this.subType) });
    com.tencent.mm.openim.e.c localc = new com.tencent.mm.openim.e.c();
    localc.field_appid = this.psy;
    localc.field_language = this.language;
    localc.field_subType = this.subType;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language", "subType" });
    localc.field_appRec = ((fq)localObject);
    localc.field_acctTypeId = paramArrayOfByte.YCj;
    com.tencent.mm.kernel.h.baF();
    ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((fq)localObject).hrh.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (dyi)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((dyi)localObject).key)) {
        ((e)com.tencent.mm.kernel.h.ax(e.class)).RG(((dyi)localObject).url);
      }
    }
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(params.aavO.size()) });
    params = params.aavO.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (gjh)params.next();
      localObject = new k();
      ((k)localObject).field_appid = this.psy;
      ((k)localObject).field_wordingId = paramArrayOfByte.abro;
      ((k)localObject).field_language = this.language;
      com.tencent.mm.kernel.h.baF();
      ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "wordingId", "language" });
      ((k)localObject).field_wording = paramArrayOfByte.wording;
      ((k)localObject).field_pinyin = paramArrayOfByte.pinyin;
      ((k)localObject).field_quanpin = paramArrayOfByte.acfB;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd update wordingId: %s, lang: %s, wording: %s, appId: %s", new Object[] { ((k)localObject).field_wordingId, ((k)localObject).field_language, ((k)localObject).field_wording, ((k)localObject).field_appid });
      com.tencent.mm.kernel.h.baF();
      ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().a((k)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.l
 * JD-Core Version:    0.7.0.1
 */