package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$b$b
{
  public int efF;
  public int efG;
  public int efH;
  
  public static b kK(String paramString)
  {
    y.i("MicroMsg.BizInfo", "HardwareBizInfo = " + paramString);
    b localb = new b();
    if ((paramString == null) || (paramString.length() <= 0)) {
      return localb;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localb.efF = paramString.optInt("hardware_flag");
      localb.efG = paramString.optInt("connect_status_display_mode");
      localb.efH = paramString.optInt("special_internal_brand_type");
      return localb;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return localb;
  }
  
  public final boolean Mc()
  {
    return (this.efF & 0x1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.d.b.b
 * JD-Core Version:    0.7.0.1
 */