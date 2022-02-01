package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  private f callback;
  private String duO;
  public final b rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150500);
    this.duO = "";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new avt();
    ((b.a)localObject).hNN = new avu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((b.a)localObject).funcId = 655;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (avt)this.rr.hNK.hNQ;
    ((avt)localObject).FIc = paramDouble1;
    ((avt)localObject).FIb = paramDouble2;
    AppMethodBeat.o(150500);
  }
  
  public final Addr aHT()
  {
    int i = 0;
    AppMethodBeat.i(150503);
    if (bt.isNullOrNil(this.duO))
    {
      AppMethodBeat.o(150503);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        ad.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.duO });
        Object localObject = new JSONObject(this.duO);
        localAddr.hXi = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.hWY = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.hWZ = localJSONObject.getString("p");
        localAddr.hXa = localJSONObject.getString("c");
        localAddr.hXc = localJSONObject.getString("d");
        localAddr.hXd = "";
        localAddr.hXe = "";
        localAddr.hXf = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.hXe = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.hXg = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.hXf = localJSONObject.getString("name");
            continue;
            if (bt.isNullOrNil(localAddr.hXf)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.hXe = "";
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
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150501);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150501);
    return i;
  }
  
  public final int getType()
  {
    return 655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150502);
    ad.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.duO = ((avu)((b)paramq).hNL.hNQ).GuC;
      ad.d("MicroMsg.NetSceneGetAddress", this.duO);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.e
 * JD-Core Version:    0.7.0.1
 */