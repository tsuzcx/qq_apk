package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f
  extends p
  implements m
{
  private h callback;
  private String hMi;
  public final c rr;
  
  public f(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(231717);
    this.hMi = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ccu();
    ((c.a)localObject).otF = new ccv();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/geocoderlocation";
    ((c.a)localObject).funcId = 4005;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ccu)c.b.b(this.rr.otB);
    ((ccu)localObject).YTd = paramDouble1;
    ((ccu)localObject).YTc = paramDouble2;
    AppMethodBeat.o(231717);
  }
  
  public final Addr bJo()
  {
    AppMethodBeat.i(231731);
    if (Util.isNullOrNil(this.hMi))
    {
      AppMethodBeat.o(231731);
      return null;
    }
    Addr localAddr = new Addr();
    try
    {
      Log.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.hMi });
      JSONObject localJSONObject1 = new JSONObject(this.hMi);
      localAddr.request_id = localJSONObject1.optString("request_id");
      localJSONObject1 = localJSONObject1.getJSONObject("result");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("address_component");
      if (localJSONObject2 != null)
      {
        localAddr.oDJ = localJSONObject2.optString("province");
        localAddr.oDK = localJSONObject2.optString("city");
        localAddr.oDM = localJSONObject2.optString("district");
        localAddr.oDN = "";
        localAddr.oDO = localJSONObject2.optString("street");
        localAddr.oDP = localJSONObject2.optString("street_number");
      }
      localJSONObject2 = localJSONObject1.optJSONObject("formatted_addresses");
      if (localJSONObject2 != null)
      {
        localAddr.oDI = localJSONObject2.optString("recommend");
        localAddr.oDR = localJSONObject2.optString("rough");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(localAddr.oDP)) {
          localAddr.oDO = "";
        }
        localJSONObject1 = localJSONObject1.optJSONObject("address_reference");
        if (localJSONObject1 != null)
        {
          localJSONObject1 = localJSONObject1.optJSONObject("town");
          if (localJSONObject1 != null) {
            localAddr.oDQ = localJSONObject1.optString("title");
          }
        }
        AppMethodBeat.o(231731);
        return localAddr;
        localJSONObject2 = localJSONObject1.optJSONObject("address_component");
        if (localJSONObject2 != null)
        {
          localAddr.oDI = localJSONObject2.optString("street_number");
          if (Util.isNullOrNil(localAddr.oDI)) {
            localAddr.oDI = localJSONObject2.optString("street");
          }
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(231731);
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(231720);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(231720);
    return i;
  }
  
  public final int getType()
  {
    return 4005;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231726);
    Log.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.hMi = ((ccv)c.c.b(((c)params).otC)).aamk;
      Log.d("MicroMsg.NetSceneGetAddress", this.hMi);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(231726);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(231726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelgeo.f
 * JD-Core Version:    0.7.0.1
 */