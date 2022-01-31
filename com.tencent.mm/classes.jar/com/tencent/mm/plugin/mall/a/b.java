package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  extends j
{
  public a lYh;
  
  public b()
  {
    D(new HashMap());
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSceneGetEUInfo", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    try
    {
      this.lYh = new a(paramJSONObject.toString());
      g.DQ();
      g.DP().Dz().c(ac.a.uzD, paramJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.NetSceneGetEUInfo", paramString, "", new Object[0]);
    }
  }
  
  public final int aEC()
  {
    return 2713;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/geteuinfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */