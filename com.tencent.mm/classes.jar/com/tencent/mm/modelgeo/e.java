package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends m
  implements k
{
  private f callback;
  private String cvV;
  public final b rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(78144);
    this.cvV = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afp();
    ((b.a)localObject).fsY = new afq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((b.a)localObject).funcId = 655;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (afp)this.rr.fsV.fta;
    ((afp)localObject).wyP = paramDouble1;
    ((afp)localObject).wyO = paramDouble2;
    AppMethodBeat.o(78144);
  }
  
  public final Addr agU()
  {
    int i = 0;
    AppMethodBeat.i(78147);
    if (bo.isNullOrNil(this.cvV))
    {
      AppMethodBeat.o(78147);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        ab.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.cvV });
        Object localObject = new JSONObject(this.cvV);
        localAddr.fBA = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.fBq = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.fBr = localJSONObject.getString("p");
        localAddr.fBs = localJSONObject.getString("c");
        localAddr.fBu = localJSONObject.getString("d");
        localAddr.fBv = "";
        localAddr.fBw = "";
        localAddr.fBx = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.fBw = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.fBy = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.fBx = localJSONObject.getString("name");
            continue;
            if (bo.isNullOrNil(localAddr.fBx)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.fBw = "";
        }
        AppMethodBeat.o(78147);
        return localAddr;
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(78147);
        return null;
      }
      label290:
      i += 1;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78145);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78145);
    return i;
  }
  
  public final int getType()
  {
    return 655;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78146);
    ab.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.cvV = ((afq)((b)paramq).fsW.fta).wYM;
      ab.d("MicroMsg.NetSceneGetAddress", this.cvV);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(78146);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelgeo.e
 * JD-Core Version:    0.7.0.1
 */