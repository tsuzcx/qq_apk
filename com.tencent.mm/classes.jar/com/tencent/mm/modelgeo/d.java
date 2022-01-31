package com.tencent.mm.modelgeo;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends m
  implements k
{
  private String bOE = "";
  public final b dmK;
  private f dmL;
  
  public d(double paramDouble1, double paramDouble2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aax();
    ((b.a)localObject).ecI = new aay();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getaddress";
    ((b.a)localObject).ecG = 655;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aax)this.dmK.ecE.ecN;
    ((aax)localObject).sDn = paramDouble1;
    ((aax)localObject).sDm = paramDouble2;
  }
  
  public final Addr Of()
  {
    int i = 0;
    if (bk.bl(this.bOE)) {
      return null;
    }
    Addr localAddr = new Addr();
    for (;;)
    {
      try
      {
        y.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[] { this.bOE });
        Object localObject = new JSONObject(this.bOE);
        localAddr.elj = ((JSONObject)localObject).optString("request_id");
        localObject = ((JSONObject)localObject).getJSONArray("results");
        localAddr.ekZ = ((JSONArray)localObject).getJSONObject(1).getString("address_name");
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(0);
        localAddr.ela = localJSONObject.getString("p");
        localAddr.elb = localJSONObject.getString("c");
        localAddr.eld = localJSONObject.getString("d");
        localAddr.ele = "";
        localAddr.elf = "";
        localAddr.elg = "";
        int j = ((JSONArray)localObject).length();
        if (i < j) {
          try
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            String str = localJSONObject.getString("dtype");
            if ("ST".equals(str))
            {
              localAddr.elf = localJSONObject.getString("name");
              if (!"FORMAT_ADDRESS".equals(str)) {
                break label270;
              }
              localAddr.elh = localJSONObject.getString("rough_address_name");
              break label270;
            }
            if (!"ST_NO".equals(str)) {
              continue;
            }
            localAddr.elg = localJSONObject.getString("name");
            continue;
            if (bk.bl(localAddr.elg)) {
              continue;
            }
          }
          catch (Exception localException2) {}
        } else {
          localAddr.elf = "";
        }
        return localAddr;
      }
      catch (Exception localException1)
      {
        return null;
      }
      label270:
      i += 1;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.bOE = ((aay)((b)paramq).ecF.ecN).tav;
      y.d("MicroMsg.NetSceneGetAddress", this.bOE);
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
    }
    while (this.dmL == null) {
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 655;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d
 * JD-Core Version:    0.7.0.1
 */