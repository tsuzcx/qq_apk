package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  private g callback;
  private String djc;
  public final b rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150500);
    this.djc = "";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new arx();
    ((b.a)localObject).hvu = new ary();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((b.a)localObject).funcId = 655;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (arx)this.rr.hvr.hvw;
    ((arx)localObject).Ecg = paramDouble1;
    ((arx)localObject).Ecf = paramDouble2;
    AppMethodBeat.o(150500);
  }
  
  public final Addr aEO()
  {
    int i = 0;
    AppMethodBeat.i(150503);
    if (bs.isNullOrNil(this.djc))
    {
      AppMethodBeat.o(150503);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        ac.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.djc });
        Object localObject = new JSONObject(this.djc);
        localAddr.hED = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.hEt = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.hEu = localJSONObject.getString("p");
        localAddr.hEv = localJSONObject.getString("c");
        localAddr.hEx = localJSONObject.getString("d");
        localAddr.hEy = "";
        localAddr.hEz = "";
        localAddr.hEA = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.hEz = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.hEB = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.hEA = localJSONObject.getString("name");
            continue;
            if (bs.isNullOrNil(localAddr.hEA)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.hEz = "";
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
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(150501);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.djc = ((ary)((b)paramq).hvs.hvw).ELz;
      ac.d("MicroMsg.NetSceneGetAddress", this.djc);
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