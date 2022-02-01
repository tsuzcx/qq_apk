package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.vx;
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
  private d rr;
  public vx tVj;
  
  public l()
  {
    AppMethodBeat.i(63827);
    this.TAG = "MicroMsg.NetSceneF2fQrcode";
    d.a locala = new d.a();
    locala.lBU = new vw();
    locala.lBV = new vx();
    locala.funcId = 1588;
    locala.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    d.b.b(this.rr.lBR);
    AppMethodBeat.o(63827);
  }
  
  private static JSONObject a(cxf paramcxf)
  {
    AppMethodBeat.i(63831);
    if ((paramcxf != null) && (!Util.isNullOrNil(paramcxf.wording))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
      AppMethodBeat.o(63831);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramcxf.type);
      localJSONObject.put("wording", paramcxf.wording);
      localJSONObject.put("url", paramcxf.url);
      localJSONObject.put("waapp_username", paramcxf.TFL);
      localJSONObject.put("waapp_path", paramcxf.TFM);
      AppMethodBeat.o(63831);
      return localJSONObject;
    }
    catch (JSONException paramcxf)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", paramcxf, "", new Object[0]);
      AppMethodBeat.o(63831);
    }
    return null;
  }
  
  private static JSONArray db(List<cxf> paramList)
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
        JSONObject localJSONObject = a((cxf)paramList.get(i));
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
  
  public final int doScene(g paramg, i parami)
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
    this.tVj = ((vx)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Log.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", new Object[] { this.tVj.url, this.tVj.OMa, this.tVj.Sic });
    if (!Util.isNullOrNil(this.tVj.url))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.VrQ, this.tVj.url);
    }
    h.aHH();
    h.aHG().aHp().set(ar.a.VrS, Integer.valueOf(ag.azH(this.tVj.ShT)));
    if (!Util.isNullOrNil(this.tVj.OMa))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.VrR, this.tVj.OMa);
    }
    if (!Util.isNullOrNil(this.tVj.Sik))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.VrW, this.tVj.Sik);
    }
    if (!Util.isNullOrNil(this.tVj.Sii))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.VrX, this.tVj.Sii);
    }
    if (!Util.isNullOrNil(this.tVj.Sij))
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.VrY, this.tVj.Sij);
    }
    h.aHH();
    h.aHG().aHp().set(ar.a.VrU, this.tVj.Sic);
    params = a(this.tVj.Sib);
    paramArrayOfByte = db(this.tVj.Sia);
    if (params != null)
    {
      Log.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", new Object[] { params.toString() });
      h.aHH();
      h.aHG().aHp().set(ar.a.VrT, params.toString());
    }
    if (paramArrayOfByte != null)
    {
      Log.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", new Object[] { paramArrayOfByte.toString() });
      h.aHH();
      h.aHG().aHp().set(ar.a.VrV, paramArrayOfByte.toString());
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.l
 * JD-Core Version:    0.7.0.1
 */