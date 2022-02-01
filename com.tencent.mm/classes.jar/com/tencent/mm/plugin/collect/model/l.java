package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ag;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  public vv qwk;
  private d rr;
  
  public l()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    d.a locala = new d.a();
    locala.iLN = new vu();
    locala.iLO = new vv();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(cor paramcor)
  {
    AppMethodBeat.i(63831);
    if ((paramcor != null) && (!Util.isNullOrNil(paramcor.dQx))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramcor.type);
      localJSONObject.put("wording", paramcor.dQx);
      localJSONObject.put("url", paramcor.url);
      localJSONObject.put("waapp_username", paramcor.MuQ);
      localJSONObject.put("waapp_path", paramcor.MuR);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException paramcor)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramcor, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray dc(List<cor> paramList)
  {
    AppMethodBeat.i(63830);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
      AppMethodBeat.o(63830);
      return null;
    }
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        JSONObject localJSONObject = a((cor)paramList.get(i));
        if (localJSONObject != null) {
          localJSONArray.put(i, localJSONObject);
        }
        i += 1;
      }
      AppMethodBeat.o(63830);
      return localJSONArray;
    }
    catch (JSONException paramList)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramList, "", new Object[0]);
      AppMethodBeat.o(63830);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(63828);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63828);
    return i;
  }
  
  public final int getType()
  {
    return 1588;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63829);
    this.qwk = ((vv)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Log.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.qwk.url, this.qwk.HTZ, this.qwk.LgO });
    if (!Util.isNullOrNil(this.qwk.url))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdF, this.qwk.url);
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdH, Integer.valueOf(ag.aqj(this.qwk.LgF)));
    if (!Util.isNullOrNil(this.qwk.HTZ))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdG, this.qwk.HTZ);
    }
    if (!Util.isNullOrNil(this.qwk.LgW))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdL, this.qwk.LgW);
    }
    if (!Util.isNullOrNil(this.qwk.LgU))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdM, this.qwk.LgU);
    }
    if (!Util.isNullOrNil(this.qwk.LgV))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdN, this.qwk.LgV);
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdJ, this.qwk.LgO);
    params = a(this.qwk.LgN);
    paramArrayOfByte = dc(this.qwk.LgM);
    if (params != null)
    {
      Log.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { params.toString() });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdI, params.toString());
    }
    if (paramArrayOfByte != null)
    {
      Log.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdK, paramArrayOfByte.toString());
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.l
 * JD-Core Version:    0.7.0.1
 */