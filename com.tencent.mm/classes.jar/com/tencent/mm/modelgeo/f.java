package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f
  extends q
  implements m
{
  private i callback;
  private String fGM;
  public final d rr;
  
  public f(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(192131);
    this.fGM = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new boj();
    ((d.a)localObject).lBV = new bok();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/geocoderlocation";
    ((d.a)localObject).funcId = 4005;
    this.rr = ((d.a)localObject).bgN();
    localObject = (boj)d.b.b(this.rr.lBR);
    ((boj)localObject).RVz = paramDouble1;
    ((boj)localObject).RVy = paramDouble2;
    AppMethodBeat.o(192131);
  }
  
  public final Addr blt()
  {
    AppMethodBeat.i(192161);
    if (Util.isNullOrNil(this.fGM))
    {
      AppMethodBeat.o(192161);
      return null;
    }
    Addr localAddr = new Addr();
    try
    {
      Log.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.fGM });
      JSONObject localJSONObject1 = new JSONObject(this.fGM);
      localAddr.request_id = localJSONObject1.optString("request_id");
      localJSONObject1 = localJSONObject1.getJSONObject("result");
      localAddr.lLg = localJSONObject1.optString("address");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("address_component");
      if (localJSONObject2 != null)
      {
        localAddr.lLh = localJSONObject2.optString("province");
        localAddr.lLi = localJSONObject2.optString("city");
        localAddr.lLk = localJSONObject2.optString("district");
        localAddr.lLl = "";
        localAddr.lLm = localJSONObject2.optString("street");
        localAddr.lLn = localJSONObject2.optString("street_number");
      }
      localJSONObject2 = localJSONObject1.optJSONObject("formatted_addresses");
      if (localJSONObject2 != null)
      {
        localAddr.lLg = localJSONObject2.optString("recommend");
        localAddr.lLp = localJSONObject2.optString("rough");
      }
      if (!Util.isNullOrNil(localAddr.lLn)) {
        localAddr.lLm = "";
      }
      localJSONObject1 = localJSONObject1.optJSONObject("address_reference");
      if (localJSONObject1 != null)
      {
        localJSONObject1 = localJSONObject1.optJSONObject("town");
        if (localJSONObject1 != null) {
          localAddr.lLo = localJSONObject1.optString("title");
        }
      }
      AppMethodBeat.o(192161);
      return localAddr;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(192161);
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(192138);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(192138);
    return i;
  }
  
  public final int getType()
  {
    return 4005;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192146);
    Log.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.fGM = ((bok)d.c.b(((d)params).lBS)).SZs;
      Log.d("MicroMsg.NetSceneGetAddress", this.fGM);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(192146);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(192146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.f
 * JD-Core Version:    0.7.0.1
 */