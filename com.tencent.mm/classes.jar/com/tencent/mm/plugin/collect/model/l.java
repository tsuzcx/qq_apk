package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.ag;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public uo phb;
  private b rr;
  
  public l()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    b.a locala = new b.a();
    locala.hQF = new un();
    locala.hQG = new uo();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(bzq parambzq)
  {
    AppMethodBeat.i(63831);
    if ((parambzq != null) && (!bu.isNullOrNil(parambzq.dyI))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", parambzq.type);
      localJSONObject.put("wording", parambzq.dyI);
      localJSONObject.put("url", parambzq.url);
      localJSONObject.put("waapp_username", parambzq.HnB);
      localJSONObject.put("waapp_path", parambzq.HnC);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException parambzq)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", parambzq, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray cN(List<bzq> paramList)
  {
    AppMethodBeat.i(63830);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
      AppMethodBeat.o(63830);
      return null;
    }
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        JSONObject localJSONObject = a((bzq)paramList.get(i));
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
      ae.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramList, "", new Object[0]);
      AppMethodBeat.o(63830);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63828);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63828);
    return i;
  }
  
  public final int getType()
  {
    return 1588;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63829);
    this.phb = ((uo)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    ae.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.phb.url, this.phb.DkG, this.phb.Gmk });
    if (!bu.isNullOrNil(this.phb.url))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IVn, this.phb.url);
    }
    g.ajS();
    g.ajR().ajA().set(am.a.IVp, Integer.valueOf(ag.agX(this.phb.Gmb)));
    if (!bu.isNullOrNil(this.phb.DkG))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IVo, this.phb.DkG);
    }
    if (!bu.isNullOrNil(this.phb.Gms))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IVt, this.phb.Gms);
    }
    if (!bu.isNullOrNil(this.phb.Gmq))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IVu, this.phb.Gmq);
    }
    if (!bu.isNullOrNil(this.phb.Gmr))
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IVv, this.phb.Gmr);
    }
    g.ajS();
    g.ajR().ajA().set(am.a.IVr, this.phb.Gmk);
    paramq = a(this.phb.Gmj);
    paramArrayOfByte = cN(this.phb.Gmi);
    if (paramq != null)
    {
      ae.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { paramq.toString() });
      g.ajS();
      g.ajR().ajA().set(am.a.IVq, paramq.toString());
    }
    if (paramArrayOfByte != null)
    {
      ae.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      g.ajS();
      g.ajR().ajA().set(am.a.IVs, paramArrayOfByte.toString());
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.l
 * JD-Core Version:    0.7.0.1
 */