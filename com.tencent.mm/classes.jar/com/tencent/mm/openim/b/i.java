package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.d.a;
import com.tencent.mm.openim.d.d;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.protocal.c.clm;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends m
  implements k
{
  String auI;
  public final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  String ePT;
  private LinkedList<String> ePU = new LinkedList();
  
  public i(String paramString1, String paramString2, LinkedList<String> paramLinkedList)
  {
    if ((!bk.bl(paramString1)) && (paramString1.equals("wework"))) {
      y.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", new Object[] { paramString1, bk.csb().toString() });
    }
    for (;;)
    {
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new aic();
      ((b.a)localObject).ecI = new aid();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimresource";
      ((b.a)localObject).ecG = 453;
      this.dmK = ((b.a)localObject).Kt();
      this.ePT = paramString1;
      this.auI = paramString2;
      this.ePU.addAll(paramLinkedList);
      int i = 10 - this.ePU.size();
      if (i > 0) {
        this.ePU.addAll(((PluginOpenIM)g.t(PluginOpenIM.class)).getWordingInfoStg().v(i, paramString2));
      }
      localObject = (aic)this.dmK.ecE.ecN;
      ((aic)localObject).app_id = paramString1;
      ((aic)localObject).auI = paramString2;
      ((aic)localObject).tfs = this.ePU;
      y.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[] { paramString1, paramString2, p(paramLinkedList), p(this.ePU) });
      return;
      y.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", new Object[] { paramString1, bk.csb().toString() });
    }
  }
  
  private static String p(LinkedList<String> paramLinkedList)
  {
    String str = "size:" + paramLinkedList.size() + "[";
    Iterator localIterator = paramLinkedList.iterator();
    for (paramLinkedList = str; localIterator.hasNext(); paramLinkedList = paramLinkedList + str + ",") {
      str = (String)localIterator.next();
    }
    return paramLinkedList + "]";
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePT, this.auI });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (aid)this.dmK.ecF.ecN;
    paramArrayOfByte = paramq.tfu;
    y.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[] { Integer.valueOf(paramArrayOfByte.stZ.size()), Integer.valueOf(paramArrayOfByte.stY.size()) });
    Object localObject = new a();
    ((a)localObject).field_acctTypeId = paramArrayOfByte.stX;
    ((a)localObject).field_language = this.auI;
    g.DQ();
    ((PluginOpenIM)g.t(PluginOpenIM.class)).getAccTypeInfoStg().b((com.tencent.mm.sdk.e.c)localObject, new String[] { "acctTypeId", "language" });
    ((a)localObject).field_accTypeRec = paramArrayOfByte;
    g.DQ();
    ((PluginOpenIM)g.t(PluginOpenIM.class)).getAccTypeInfoStg().a((a)localObject);
    localObject = paramq.tft;
    y.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[] { Integer.valueOf(((dj)localObject).swG), Integer.valueOf(((dj)localObject).stZ.size()), Integer.valueOf(((dj)localObject).stY.size()) });
    com.tencent.mm.openim.d.c localc = new com.tencent.mm.openim.d.c();
    localc.field_appid = this.ePT;
    localc.field_language = this.auI;
    g.DQ();
    ((PluginOpenIM)g.t(PluginOpenIM.class)).getAppIdInfoStg().b(localc, new String[] { "appid", "language" });
    localc.field_appRec = ((dj)localObject);
    localc.field_acctTypeId = paramArrayOfByte.stX;
    g.DQ();
    ((PluginOpenIM)g.t(PluginOpenIM.class)).getAppIdInfoStg().a(localc);
    paramArrayOfByte = ((dj)localObject).stZ.iterator();
    while (paramArrayOfByte.hasNext())
    {
      localObject = (bbx)paramArrayOfByte.next();
      if ("openim_desc_icon".equals(((bbx)localObject).key)) {
        ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).oR(((bbx)localObject).url);
      }
    }
    y.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[] { Integer.valueOf(paramq.tfv.size()) });
    paramq = paramq.tfv.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (clm)paramq.next();
      localObject = new com.tencent.mm.openim.d.e();
      ((com.tencent.mm.openim.d.e)localObject).field_appid = this.ePT;
      ((com.tencent.mm.openim.d.e)localObject).field_wordingId = paramArrayOfByte.tYI;
      ((com.tencent.mm.openim.d.e)localObject).field_language = this.auI;
      g.DQ();
      ((PluginOpenIM)g.t(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c)localObject, new String[] { "appid", "wordingId", "language" });
      ((com.tencent.mm.openim.d.e)localObject).field_wording = paramArrayOfByte.bQZ;
      ((com.tencent.mm.openim.d.e)localObject).field_pinyin = paramArrayOfByte.ndQ;
      ((com.tencent.mm.openim.d.e)localObject).field_quanpin = paramArrayOfByte.tYJ;
      g.DQ();
      ((PluginOpenIM)g.t(PluginOpenIM.class)).getWordingInfoStg().a((com.tencent.mm.openim.d.e)localObject);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 453;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.i
 * JD-Core Version:    0.7.0.1
 */