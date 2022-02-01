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
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends q
  implements m
{
  private i callback;
  private String fGM;
  public final d rr;
  
  public e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150500);
    this.fGM = "";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpe();
    ((d.a)localObject).lBV = new bpf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((d.a)localObject).funcId = 655;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bpe)d.b.b(this.rr.lBR);
    ((bpe)localObject).RVz = paramDouble1;
    ((bpe)localObject).RVy = paramDouble2;
    AppMethodBeat.o(150500);
  }
  
  public final Addr blt()
  {
    int i = 0;
    AppMethodBeat.i(150503);
    if (Util.isNullOrNil(this.fGM))
    {
      AppMethodBeat.o(150503);
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        Log.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.fGM });
        Object localObject = new JSONObject(this.fGM);
        localAddr.request_id = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.lLg = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.lLh = localJSONObject.getString("p");
        localAddr.lLi = localJSONObject.getString("c");
        localAddr.lLk = localJSONObject.getString("d");
        localAddr.lLl = "";
        localAddr.lLm = "";
        localAddr.lLn = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.lLm = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label290;
              }
              localAddr.lLp = localJSONObject.getString("rough_address_name");
              break label290;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.lLn = localJSONObject.getString("name");
            continue;
            if (Util.isNullOrNil(localAddr.lLn)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.lLm = "";
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
      this.fGM = ((bpf)d.c.b(((d)params).lBS)).SZs;
      Log.d("MicroMsg.NetSceneGetAddress", this.fGM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.e
 * JD-Core Version:    0.7.0.1
 */