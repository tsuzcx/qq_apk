package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends m
  implements k
{
  private final String TAG = "MicroMsg.NetSceneF2fQrcode";
  private b dmK;
  private f dmL;
  public mw iHp;
  
  public l()
  {
    b.a locala = new b.a();
    locala.ecH = new mv();
    locala.ecI = new mw();
    locala.ecG = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  private static JSONObject a(awl paramawl)
  {
    if ((paramawl != null) && (!bk.bl(paramawl.bQZ))) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramawl.type);
      localJSONObject.put("wording", paramawl.bQZ);
      localJSONObject.put("url", paramawl.url);
      localJSONObject.put("waapp_username", paramawl.ttb);
      localJSONObject.put("waapp_path", paramawl.ttc);
      return localJSONObject;
    }
    catch (JSONException paramawl)
    {
      y.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramawl, "", new Object[0]);
    }
    return null;
  }
  
  private static JSONArray aW(List<awl> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
      return null;
    }
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        JSONObject localJSONObject = a((awl)paramList.get(i));
        if (localJSONObject != null) {
          localJSONArray.put(i, localJSONObject);
        }
        i += 1;
      }
      return localJSONArray;
    }
    catch (JSONException paramList)
    {
      y.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramList, "", new Object[0]);
    }
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.iHp = ((mw)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    y.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.iHp.url, this.iHp.qsJ, this.iHp.sKu });
    if (!bk.bl(this.iHp.url))
    {
      g.DQ();
      g.DP().Dz().c(ac.a.uxB, this.iHp.url);
    }
    if (!bk.bl(this.iHp.qsJ))
    {
      g.DQ();
      g.DP().Dz().c(ac.a.uxC, this.iHp.qsJ);
    }
    g.DQ();
    g.DP().Dz().c(ac.a.uxE, this.iHp.sKu);
    paramq = a(this.iHp.sKt);
    paramArrayOfByte = aW(this.iHp.sKs);
    if (paramq != null)
    {
      y.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { paramq.toString() });
      g.DQ();
      g.DP().Dz().c(ac.a.uxD, paramq.toString());
    }
    if (paramArrayOfByte != null)
    {
      y.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      g.DQ();
      g.DP().Dz().c(ac.a.uxF, paramArrayOfByte.toString());
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1588;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.l
 * JD-Core Version:    0.7.0.1
 */