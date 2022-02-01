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
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends p
  implements m
{
  private h callback;
  private String hMi;
  public final c rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150500);
    this.hMi = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cdv();
    ((c.a)localObject).otF = new cdw();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((c.a)localObject).funcId = 655;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cdv)c.b.b(this.rr.otB);
    ((cdv)localObject).YTd = paramDouble1;
    ((cdv)localObject).YTc = paramDouble2;
    AppMethodBeat.o(150500);
  }
  
  public final Addr bJo()
  {
    int i = 0;
    AppMethodBeat.i(150503);
    if (Util.isNullOrNil(this.hMi))
    {
      AppMethodBeat.o(150503);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        Log.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.hMi });
        Object localObject = new JSONObject(this.hMi);
        localAddr.request_id = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.oDI = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.oDJ = localJSONObject.getString("p");
        localAddr.oDK = localJSONObject.getString("c");
        localAddr.oDM = localJSONObject.getString("d");
        localAddr.oDN = "";
        localAddr.oDO = "";
        localAddr.oDP = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.oDO = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.oDR = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.oDP = localJSONObject.getString("name");
            continue;
            if (Util.isNullOrNil(localAddr.oDP)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.oDO = "";
        }
        AppMethodBeat.o(150503);
        return localAddr;
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(150503);
        return null;
      }
      label290:
      i += 1;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150501);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150501);
    return i;
  }
  
  public final int getType()
  {
    return 655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150502);
    Log.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.hMi = ((cdw)c.c.b(((c)params).otC)).aamk;
      Log.d("MicroMsg.NetSceneGetAddress", this.hMi);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(150502);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelgeo.e
 * JD-Core Version:    0.7.0.1
 */