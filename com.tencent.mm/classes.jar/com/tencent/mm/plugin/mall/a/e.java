package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends m
{
  public d vDe;
  
  public e()
  {
    AppMethodBeat.i(65991);
    setRequestData(new HashMap());
    AppMethodBeat.o(65991);
  }
  
  public final int getTenpayCgicmd()
  {
    return 2713;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/geteuinfo";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(65992);
    ad.d("MicroMsg.NetSceneGetEUInfo", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(65992);
      return;
    }
    try
    {
      this.vDe = new d(paramJSONObject.toString());
      g.ajD();
      g.ajC().ajl().set(al.a.IEe, paramJSONObject.toString());
      AppMethodBeat.o(65992);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneGetEUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(65992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.e
 * JD-Core Version:    0.7.0.1
 */