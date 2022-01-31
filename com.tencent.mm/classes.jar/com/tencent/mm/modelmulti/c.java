package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private f dmL;
  public final b esv;
  
  public c(List<apw> paramList, long paramLong, apy paramapy)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ace();
    ((b.a)localObject).ecI = new acf();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((b.a)localObject).ecG = 1708;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.esv = ((b.a)localObject).Kt();
    localObject = (ace)this.esv.ecE.ecN;
    ((ace)localObject).tbc.addAll(paramList);
    ((ace)localObject).tbf = paramLong;
    ((ace)localObject).tbe = paramapy;
    y.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((ace)localObject).tbc.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Object localObject = (ace)this.esv.ecE.ecN;
    paramString = ((ace)localObject).tbc;
    paramArrayOfByte = (apw)paramString.get(0);
    localObject = ((ace)localObject).tbe;
    paramq = (acf)((b)paramq).ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq.result != 0) {
        h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.dCX, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((apy)localObject).latitude), String.valueOf(((apy)localObject).longitude), Integer.valueOf(2), Integer.valueOf(paramq.result) });
      }
      y.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      return;
    }
    h.nFQ.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.dCX, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((apy)localObject).latitude), String.valueOf(((apy)localObject).longitude), Integer.valueOf(1), Integer.valueOf(paramq.result) });
    y.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
  }
  
  public final int getType()
  {
    return 1708;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */