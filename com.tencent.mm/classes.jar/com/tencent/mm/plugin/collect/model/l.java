package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.sg;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private com.tencent.mm.al.g callback;
  public sh nTH;
  private b rr;
  
  public l()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    b.a locala = new b.a();
    locala.gUU = new sg();
    locala.gUV = new sh();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(bpq parambpq)
  {
    AppMethodBeat.i(63831);
    if ((parambpq != null) && (!bt.isNullOrNil(parambpq.doh))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", parambpq.type);
      localJSONObject.put("wording", parambpq.doh);
      localJSONObject.put("url", parambpq.url);
      localJSONObject.put("waapp_username", parambpq.DOb);
      localJSONObject.put("waapp_path", parambpq.DOc);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException parambpq)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", parambpq, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray cH(List<bpq> paramList)
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
        JSONObject localJSONObject = a((bpq)paramList.get(i));
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(63828);
    this.callback = paramg;
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
    this.nTH = ((sh)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    ad.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.nTH.url, this.nTH.Aar, this.nTH.CTR });
    if (!bt.isNullOrNil(this.nTH.url))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqD, this.nTH.url);
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqF, Integer.valueOf(ag.abv(this.nTH.CTI)));
    if (!bt.isNullOrNil(this.nTH.Aar))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqE, this.nTH.Aar);
    }
    if (!bt.isNullOrNil(this.nTH.CTZ))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqJ, this.nTH.CTZ);
    }
    if (!bt.isNullOrNil(this.nTH.CTX))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqK, this.nTH.CTX);
    }
    if (!bt.isNullOrNil(this.nTH.CTY))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqL, this.nTH.CTY);
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqH, this.nTH.CTR);
    paramq = a(this.nTH.CTQ);
    paramArrayOfByte = cH(this.nTH.CTP);
    if (paramq != null)
    {
      ad.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { paramq.toString() });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqG, paramq.toString());
    }
    if (paramArrayOfByte != null)
    {
      ad.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqI, paramArrayOfByte.toString());
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