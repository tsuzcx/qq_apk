package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends n
  implements k
{
  private f callback;
  private String dvT;
  public final b rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150500);
    this.dvT = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awj();
    ((b.a)localObject).hQG = new awk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((b.a)localObject).funcId = 655;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (awj)this.rr.hQD.hQJ;
    ((awj)localObject).Gay = paramDouble1;
    ((awj)localObject).Gax = paramDouble2;
    AppMethodBeat.o(150500);
  }
  
  public final Addr aIk()
  {
    int i = 0;
    AppMethodBeat.i(150503);
    if (bu.isNullOrNil(this.dvT))
    {
      AppMethodBeat.o(150503);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        ae.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.dvT });
        Object localObject = new JSONObject(this.dvT);
        localAddr.iaa = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.hZQ = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.hZR = localJSONObject.getString("p");
        localAddr.hZS = localJSONObject.getString("c");
        localAddr.hZU = localJSONObject.getString("d");
        localAddr.hZV = "";
        localAddr.hZW = "";
        localAddr.hZX = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.hZW = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.hZY = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.hZX = localJSONObject.getString("name");
            continue;
            if (bu.isNullOrNil(localAddr.hZX)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.hZW = "";
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
    ae.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.dvT = ((awk)((b)paramq).hQE.hQJ).GOb;
      ae.d("MicroMsg.NetSceneGetAddress", this.dvT);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelgeo.e
 * JD-Core Version:    0.7.0.1
 */