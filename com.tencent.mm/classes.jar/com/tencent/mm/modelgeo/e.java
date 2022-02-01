package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends q
  implements m
{
  private i callback;
  private String dNA;
  public final d rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150500);
    this.dNA = "";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bht();
    ((d.a)localObject).iLO = new bhu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((d.a)localObject).funcId = 655;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bht)this.rr.iLK.iLR;
    ((bht)localObject).KUu = paramDouble1;
    ((bht)localObject).KUt = paramDouble2;
    AppMethodBeat.o(150500);
  }
  
  public final Addr bce()
  {
    int i = 0;
    AppMethodBeat.i(150503);
    if (Util.isNullOrNil(this.dNA))
    {
      AppMethodBeat.o(150503);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        Log.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.dNA });
        Object localObject = new JSONObject(this.dNA);
        localAddr.request_id = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.iUO = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.iUP = localJSONObject.getString("p");
        localAddr.iUQ = localJSONObject.getString("c");
        localAddr.iUS = localJSONObject.getString("d");
        localAddr.iUT = "";
        localAddr.iUU = "";
        localAddr.iUV = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.iUU = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.iUW = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.iUV = localJSONObject.getString("name");
            continue;
            if (Util.isNullOrNil(localAddr.iUV)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.iUU = "";
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150501);
    this.callback = parami;
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
      this.dNA = ((bhu)((d)params).iLL.iLR).LSg;
      Log.d("MicroMsg.NetSceneGetAddress", this.dNA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.e
 * JD-Core Version:    0.7.0.1
 */