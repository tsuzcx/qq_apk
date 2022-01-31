package com.tencent.mm.ai;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acu;
import com.tencent.mm.protocal.c.acv;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class t
  extends m
  implements k
{
  private Object data;
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  
  private t(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new acu();
    ((b.a)localObject).ecI = new acv();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
    ((b.a)localObject).ecG = 1285;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (acu)this.dmK.ecE.ecN;
    ((acu)localObject).sPM = paramString1;
    ((acu)localObject).uC = 1;
    ((acu)localObject).data = paramString2;
    this.data = null;
  }
  
  public static void a(f paramf)
  {
    g.DO().dJT.b(1285, paramf);
  }
  
  public static boolean m(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("brand_user_name", paramString2);
      localJSONObject.put("bizchat_id", paramString3);
      paramString1 = new t(paramString1, localJSONObject.toString());
      return g.DO().dJT.a(paramString1, 0);
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1285;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.t
 * JD-Core Version:    0.7.0.1
 */