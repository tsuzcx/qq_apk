package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ah;
import com.tencent.mm.wallet_core.model.w;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  extends w
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  public xp wYF;
  
  public k()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    c.a locala = new c.a();
    locala.otE = new xo();
    locala.otF = new xp();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    c.b.b(this.rr.otB);
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(dok paramdok)
  {
    AppMethodBeat.i(63831);
    if ((paramdok != null) && (!Util.isNullOrNil(paramdok.wording))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramdok.type);
      localJSONObject.put("wording", paramdok.wording);
      localJSONObject.put("url", paramdok.url);
      localJSONObject.put("waapp_username", paramdok.aaVs);
      localJSONObject.put("waapp_path", paramdok.aaVt);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException paramdok)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramdok, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray eW(List<dok> paramList)
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
        JSONObject localJSONObject = a((dok)paramList.get(i));
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(63828);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63828);
    return i;
  }
  
  public final int getType()
  {
    return 1588;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(293537);
    this.wYF = ((xp)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Log.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.wYF.url, this.wYF.VBL, this.wYF.Zgi });
    if (!Util.isNullOrNil(this.wYF.url))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTu, this.wYF.url);
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTw, Integer.valueOf(ah.aGs(this.wYF.ZfZ)));
    if (!Util.isNullOrNil(this.wYF.VBL))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTv, this.wYF.VBL);
    }
    if (!Util.isNullOrNil(this.wYF.Zgq))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTA, this.wYF.Zgq);
    }
    if (!Util.isNullOrNil(this.wYF.Zgo))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTB, this.wYF.Zgo);
    }
    if (!Util.isNullOrNil(this.wYF.Zgp))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTC, this.wYF.Zgp);
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTy, this.wYF.Zgi);
    params = a(this.wYF.Zgh);
    paramArrayOfByte = eW(this.wYF.Zgg);
    if (params != null)
    {
      Log.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { params.toString() });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTx, params.toString());
    }
    if (paramArrayOfByte != null)
    {
      Log.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTz, paramArrayOfByte.toString());
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(293537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.k
 * JD-Core Version:    0.7.0.1
 */