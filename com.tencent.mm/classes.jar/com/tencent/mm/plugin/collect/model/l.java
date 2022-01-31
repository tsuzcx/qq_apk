package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private final String TAG;
  private f callback;
  public pw kNu;
  private b rr;
  
  public l()
  {
    AppMethodBeat.i(40975);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    b.a locala = new b.a();
    locala.fsX = new pv();
    locala.fsY = new pw();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(40975);
  }
  
  private static JSONObject a(bda parambda)
  {
    AppMethodBeat.i(40979);
    if ((parambda != null) && (!bo.isNullOrNil(parambda.cyA))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(40979);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", parambda.type);
      localJSONObject.put("wording", parambda.cyA);
      localJSONObject.put("url", parambda.url);
      localJSONObject.put("waapp_username", parambda.xtb);
      localJSONObject.put("waapp_path", parambda.xtc);
      AppMethodBeat.o(40979);
      return localJSONObject;
    }
    catch (JSONException parambda)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", parambda, "", new Object[0]);
      AppMethodBeat.o(40979);
    }
    return null;
  }
  
  private static JSONArray bl(List<bda> paramList)
  {
    AppMethodBeat.i(40978);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
      AppMethodBeat.o(40978);
      return null;
    }
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        JSONObject localJSONObject = a((bda)paramList.get(i));
        if (localJSONObject != null) {
          localJSONArray.put(i, localJSONObject);
        }
        i += 1;
      }
      AppMethodBeat.o(40978);
      return localJSONArray;
    }
    catch (JSONException paramList)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramList, "", new Object[0]);
      AppMethodBeat.o(40978);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(40976);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(40976);
    return i;
  }
  
  public final int getType()
  {
    return 1588;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40977);
    this.kNu = ((pw)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    ab.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.kNu.url, this.kNu.ueu, this.kNu.wIf });
    if (!bo.isNullOrNil(this.kNu.url))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yHK, this.kNu.url);
    }
    g.RM();
    g.RL().Ru().set(ac.a.yHM, Integer.valueOf(c.IK(this.kNu.wIa)));
    if (!bo.isNullOrNil(this.kNu.ueu))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yHL, this.kNu.ueu);
    }
    g.RM();
    g.RL().Ru().set(ac.a.yHO, this.kNu.wIf);
    paramq = a(this.kNu.wIe);
    paramArrayOfByte = bl(this.kNu.wId);
    if (paramq != null)
    {
      ab.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { paramq.toString() });
      g.RM();
      g.RL().Ru().set(ac.a.yHN, paramq.toString());
    }
    if (paramArrayOfByte != null)
    {
      ab.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      g.RM();
      g.RL().Ru().set(ac.a.yHP, paramArrayOfByte.toString());
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.l
 * JD-Core Version:    0.7.0.1
 */