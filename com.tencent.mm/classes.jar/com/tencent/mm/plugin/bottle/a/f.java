package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ber;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class f
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  boolean hYo = false;
  
  public f()
  {
    b.a locala = new b.a();
    locala.ecH = new ber();
    locala.ecI = new bes();
    locala.uri = "/cgi-bin/micromsg-bin/pickbottle";
    locala.ecG = 155;
    locala.ecJ = 54;
    locala.ecK = 1000000054;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetScenePickBottle", "onGYNetEnd type:" + paramInt2 + " code:" + paramInt3);
    if ((paramInt2 == 4) && ((paramInt3 == -2002) || (paramInt3 == -56)))
    {
      c.of(0);
      c.og(0);
    }
    paramArrayOfByte = (bes)this.dmK.ecF.ecN;
    if (paramInt2 == 4) {
      switch (paramInt3)
      {
      default: 
        c.og(paramArrayOfByte.tbz);
        c.of(paramArrayOfByte.tby);
      }
    }
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.hYo = true;
      y.d("MicroMsg.NetScenePickBottle", "bottle pack:pack:" + paramArrayOfByte.tbz + " throw:" + paramArrayOfByte.tby);
      paramq = null;
      if (paramArrayOfByte.twD != null) {
        paramq = paramArrayOfByte.twD.split(":");
      }
      ad localad;
      if ((paramq != null) && (paramq.length >= 2))
      {
        str = paramq[0];
        au.Hx();
        paramq = com.tencent.mm.model.c.Fw().abl(str);
        if ((paramq == null) || (!paramq.field_username.equals(str)))
        {
          localad = new ad();
          localad.setUsername(str);
          if (paramArrayOfByte.hRf != null) {
            break label836;
          }
          paramq = "";
          localad.dk(paramq);
          localad.fl(3);
          paramq = new h();
          paramq.username = str;
          paramq.cCq = 3;
          paramq.bK(true);
          paramq.bcw = -1;
        }
      }
      try
      {
        Map localMap = bn.s(paramArrayOfByte.tdT, "userinfo");
        if (localMap != null)
        {
          localad.fm(bk.getInt((String)localMap.get(".userinfo.$sex"), 0));
          localad.dz((String)localMap.get(".userinfo.$signature"));
          localad.dF(RegionCodeDecoder.ao((String)localMap.get(".userinfo.$country"), (String)localMap.get(".userinfo.$province"), (String)localMap.get(".userinfo.$city")));
          y.d("MicroMsg.NetScenePickBottle", "user:" + str + " sig:" + localad.signature + " sex" + localad.sex + " city:" + localad.getCity() + " prov:" + localad.getProvince());
          paramq.ebT = ((String)localMap.get(".userinfo.$bigheadimgurl"));
          paramq.ebS = ((String)localMap.get(".userinfo.$smallheadimgurl"));
          paramq.bcw = -1;
          y.d("MicroMsg.NetScenePickBottle", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { str, paramq.JX(), paramq.JY() });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.NetScenePickBottle", "Set Contact failed " + localException.getMessage() + " user:" + str);
        }
      }
      au.Hx();
      com.tencent.mm.model.c.Fw().T(localad);
      o.Kh().a(paramq);
      y.d("MicroMsg.NetScenePickBottle", "getBottleType " + paramArrayOfByte.tzA);
      y.d("MicroMsg.NetScenePickBottle", "getMsgType " + paramArrayOfByte.kSW);
      y.d("MicroMsg.NetScenePickBottle", "getBottleInfo " + paramArrayOfByte.twD);
      y.d("MicroMsg.NetScenePickBottle", "getUserInfo " + paramArrayOfByte.tdT);
      y.d("MicroMsg.NetScenePickBottle", "getNickName " + paramArrayOfByte.hRf);
      y.d("MicroMsg.NetScenePickBottle", "getUserStatus " + paramArrayOfByte.tzB);
      y.d("MicroMsg.NetScenePickBottle", "getThrowCount " + paramArrayOfByte.tby);
      y.d("MicroMsg.NetScenePickBottle", "getPickCount " + paramArrayOfByte.tbz);
      y.d("MicroMsg.NetScenePickBottle", "getDistance " + paramArrayOfByte.tzC);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label836:
      paramq = paramArrayOfByte.hRf;
      break;
      if (paramInt3 == -56)
      {
        c.og(paramArrayOfByte.tbz);
        c.og(paramArrayOfByte.tby);
      }
    }
  }
  
  final bes awK()
  {
    return (bes)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.f
 * JD-Core Version:    0.7.0.1
 */