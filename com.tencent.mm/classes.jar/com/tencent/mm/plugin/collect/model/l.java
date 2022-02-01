package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public um pax;
  private b rr;
  
  public l()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    b.a locala = new b.a();
    locala.hNM = new ul();
    locala.hNN = new um();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(byw parambyw)
  {
    AppMethodBeat.i(63831);
    if ((parambyw != null) && (!bt.isNullOrNil(parambyw.dxD))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", parambyw.type);
      localJSONObject.put("wording", parambyw.dxD);
      localJSONObject.put("url", parambyw.url);
      localJSONObject.put("waapp_username", parambyw.GUa);
      localJSONObject.put("waapp_path", parambyw.GUb);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException parambyw)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", parambyw, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray cK(List<byw> paramList)
  {
    AppMethodBeat.i(63830);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
      AppMethodBeat.o(63830);
      return null;
    }
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        JSONObject localJSONObject = a((byw)paramList.get(i));
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
      ad.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramList, "", new Object[0]);
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
    this.pax = ((um)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    ad.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.pax.url, this.pax.CTa, this.pax.FTL });
    if (!bt.isNullOrNil(this.pax.url))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IAO, this.pax.url);
    }
    g.ajD();
    g.ajC().ajl().set(al.a.IAQ, Integer.valueOf(ag.ago(this.pax.FTC)));
    if (!bt.isNullOrNil(this.pax.CTa))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IAP, this.pax.CTa);
    }
    if (!bt.isNullOrNil(this.pax.FTT))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IAU, this.pax.FTT);
    }
    if (!bt.isNullOrNil(this.pax.FTR))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IAV, this.pax.FTR);
    }
    if (!bt.isNullOrNil(this.pax.FTS))
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IAW, this.pax.FTS);
    }
    g.ajD();
    g.ajC().ajl().set(al.a.IAS, this.pax.FTL);
    paramq = a(this.pax.FTK);
    paramArrayOfByte = cK(this.pax.FTJ);
    if (paramq != null)
    {
      ad.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { paramq.toString() });
      g.ajD();
      g.ajC().ajl().set(al.a.IAR, paramq.toString());
    }
    if (paramArrayOfByte != null)
    {
      ad.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      g.ajD();
      g.ajC().ajl().set(al.a.IAT, paramArrayOfByte.toString());
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