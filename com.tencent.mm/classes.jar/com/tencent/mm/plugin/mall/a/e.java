package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends m
{
  public d EOC;
  
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
    Log.d("MicroMsg.NetSceneGetEUInfo", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(65992);
      return;
    }
    try
    {
      this.EOC = new d(paramJSONObject.toString());
      h.aHH();
      h.aHG().aHp().set(ar.a.Vvr, paramJSONObject.toString());
      AppMethodBeat.o(65992);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneGetEUInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(65992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.e
 * JD-Core Version:    0.7.0.1
 */