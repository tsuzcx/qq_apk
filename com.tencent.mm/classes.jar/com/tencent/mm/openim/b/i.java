package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.b;
import com.tencent.mm.openim.e.c;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fbu;
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
  private com.tencent.mm.ak.i callback;
  String jHc;
  private LinkedList<String> jHd;
  String language;
  public final com.tencent.mm.ak.d rr;
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151202);
    this.jHd = new LinkedList();
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.equals("wework"))) {
      Log.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, Util.getStack().toString() });
    }
    for (;;)
    {
      Object localObject = new d.a();
      ((d.a)localObject).iLN = new brq();
      ((d.a)localObject).iLO = new brr();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((d.a)localObject).funcId = 453;
      this.rr = ((d.a)localObject).aXF();
      this.jHc = paramString1;
      this.language = paramString2;
      this.jHd.addAll(paramLinkedList);
      int i = 10 - this.jHd.size();
      if (i > 0) {
        this.jHd.addAll(((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().S(i, paramString2));
      }
      localObject = (brq)this.rr.iLK.iLR;
      ((brq)localObject).app_id = paramString1;
      ((brq)localObject).language = paramString2;
      ((brq)localObject).LYT = this.jHd;
      Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.jHd) });
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
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
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.jHc, this.language });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151204);
      return;
    }
    params = (brr)this.rr.iLL.iLR;
    paramArrayOfByte = params.LYV;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.duo.size()), Integer.valueOf(paramArrayOfByte.KEp.size()) });
    Object localObject = new com.tencent.mm.openim.e.a();
    ((com.tencent.mm.openim.e.a)localObject).field_acctTypeId = paramArrayOfByte.KEo;
    ((com.tencent.mm.openim.e.a)localObject).field_language = this.language;
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAccTypeInfoStg().get((IAutoDBItem)localObject, new String[] { "acctTypeId", "language" });
    ((com.tencent.mm.openim.e.a)localObject).field_accTypeRec = paramArrayOfByte;
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAccTypeInfoStg().a((com.tencent.mm.openim.e.a)localObject);
    localObject = params.LYU;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((ez)localObject).KIp), Integer.valueOf(((ez)localObject).duo.size()), Integer.valueOf(((ez)localObject).KEp.size()) });
    c localc = new c();
    localc.field_appid = this.jHc;
    localc.field_language = this.language;
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((ez)localObject);
    localc.field_acctTypeId = paramArrayOfByte.KEo;
    com.tencent.mm.kernel.g.aAi();
    ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((ez)localObject).duo.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cwr)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((cwr)localObject).key)) {
        ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).RY(((cwr)localObject).url);
      }
    }
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(params.LYW.size()) });
    params = params.LYW.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (fbu)params.next();
      localObject = new e();
      ((e)localObject).field_appid = this.jHc;
      ((e)localObject).field_wordingId = paramArrayOfByte.MOt;
      ((e)localObject).field_language = this.language;
      com.tencent.mm.kernel.g.aAi();
      ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().get((IAutoDBItem)localObject, new String[] { "appid", "wordingId", "language" });
      ((e)localObject).field_wording = paramArrayOfByte.dQx;
      ((e)localObject).field_pinyin = paramArrayOfByte.pinyin;
      ((e)localObject).field_quanpin = paramArrayOfByte.NxU;
      com.tencent.mm.kernel.g.aAi();
      ((PluginOpenIM)com.tencent.mm.kernel.g.ah(PluginOpenIM.class)).getWordingInfoStg().a((e)localObject);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */