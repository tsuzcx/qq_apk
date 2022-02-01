package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private com.tencent.mm.ak.g callback;
  public sr oxc;
  private b rr;
  
  public l()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    b.a locala = new b.a();
    locala.hvt = new sq();
    locala.hvu = new sr();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(buh parambuh)
  {
    AppMethodBeat.i(63831);
    if ((parambuh != null) && (!bs.isNullOrNil(parambuh.dlQ))) {}
    for (int i = 1; i == 0; i = 0)
    {
      ac.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", parambuh.type);
      localJSONObject.put("wording", parambuh.dlQ);
      localJSONObject.put("url", parambuh.url);
      localJSONObject.put("waapp_username", parambuh.Fks);
      localJSONObject.put("waapp_path", parambuh.Fkt);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException parambuh)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", parambuh, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray cJ(List<buh> paramList)
  {
    AppMethodBeat.i(63830);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
      AppMethodBeat.o(63830);
      return null;
    }
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        JSONObject localJSONObject = a((buh)paramList.get(i));
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
      ac.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramList, "", new Object[0]);
      AppMethodBeat.o(63830);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    this.oxc = ((sr)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    ac.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.oxc.url, this.oxc.BsL, this.oxc.EmC });
    if (!bs.isNullOrNil(this.oxc.url))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOt, this.oxc.url);
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOv, Integer.valueOf(ag.adO(this.oxc.Emt)));
    if (!bs.isNullOrNil(this.oxc.BsL))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOu, this.oxc.BsL);
    }
    if (!bs.isNullOrNil(this.oxc.EmK))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOz, this.oxc.EmK);
    }
    if (!bs.isNullOrNil(this.oxc.EmI))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOA, this.oxc.EmI);
    }
    if (!bs.isNullOrNil(this.oxc.EmJ))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOB, this.oxc.EmJ);
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOx, this.oxc.EmC);
    paramq = a(this.oxc.EmB);
    paramArrayOfByte = cJ(this.oxc.EmA);
    if (paramq != null)
    {
      ac.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { paramq.toString() });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOw, paramq.toString());
    }
    if (paramArrayOfByte != null)
    {
      ac.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOy, paramArrayOfByte.toString());
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