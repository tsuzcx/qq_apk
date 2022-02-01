package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.Set;

public final class z
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private String dmQ;
  private String dmS;
  private int gVE;
  public final com.tencent.mm.al.b rr;
  
  public z(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.gVE = 2;
    this.dmQ = null;
    this.dmS = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new la();
    ((b.a)localObject).gUV = new lb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).funcId = 132;
    ((b.a)localObject).reqCmdId = 45;
    ((b.a)localObject).respCmdId = 1000000045;
    this.rr = ((b.a)localObject).atI();
    localObject = (la)this.rr.gUS.gUX;
    ((la)localObject).CCB = paramInt1;
    ((la)localObject).CFP = paramInt2;
    ((la)localObject).CFQ = paramString3;
    if ((bt.isNullOrNil(this.dmQ)) && (bt.isNullOrNil(this.dmS)))
    {
      if (i.ETz)
      {
        paramString3 = aj.getContext().getString(2131762749);
        ((la)localObject).CFS = paramString3;
        ((la)localObject).CFT = d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label304;
      }
      com.tencent.mm.kernel.g.afB().afk().set(4097, paramString1);
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((la)localObject).CFN = paramString1;
      ((la)localObject).CFO = paramString2;
      ((la)localObject).oXs = ac.eFu();
      AppMethodBeat.o(131090);
      return;
      paramString3 = aj.getContext().getString(2131762748);
      break;
      label304:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)com.tencent.mm.kernel.g.afB().afk().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)com.tencent.mm.kernel.g.afB().afk().get(6, null);
      }
    }
  }
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.dmQ = paramString4;
    this.dmS = paramString5;
    paramString1 = (la)this.rr.gUS.gUX;
    paramString1.CFS = paramString4;
    paramString1.CFT = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public final int JJ()
  {
    return ((la)this.rr.gUS.gUX).CCB;
  }
  
  public final String axz()
  {
    return ((lb)this.rr.gUT.gUX).dgo;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131091);
    this.callback = paramg;
    paramg = (la)this.rr.gUS.gUX;
    if ((paramg.CFN == null) || (paramg.CFN.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramg.CFN);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((paramg.CCB == 2) || (paramg.CCB == 19)) && ((paramg.CFO == null) || (paramg.CFO.length() <= 0)))
    {
      ad.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramg.CFN);
      AppMethodBeat.o(131091);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131091);
    return i;
  }
  
  public final int getType()
  {
    return 132;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131092);
    paramq = (la)this.rr.gUS.gUX;
    paramArrayOfByte = (lb)this.rr.gUT.gUX;
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.CBr;
      ad.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().gcR.set(47, Integer.valueOf(paramInt1));
      localObject = com.tencent.mm.kernel.g.afA().gcy.gVH;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject).el(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        ad.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          ad.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.gVE) });
          this.gVE -= 1;
          if (this.gVE <= 0)
          {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(131092);
            return;
            label229:
            bool = false;
            break;
            ad.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[] { paramArrayOfByte });
            continue;
          }
          doScene(dispatcher(), this.callback);
          AppMethodBeat.o(131092);
          return;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(131092);
        return;
      }
    }
    if (paramArrayOfByte != null) {
      ad.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.CGd + "safedevice status = " + paramArrayOfByte.CuL);
    }
    if ((paramq.CCB == 2) || (paramq.CCB == 4) || (paramq.CCB == 11) || (paramq.CCB == 19))
    {
      com.tencent.mm.kernel.g.afB().afk().set(4097, "");
      paramArrayOfByte = (String)com.tencent.mm.kernel.g.afB().afk().get(6, "");
      com.tencent.mm.kernel.g.afB().afk().set(6, paramq.CFN);
      if (!bt.isNullOrNil(paramArrayOfByte))
      {
        if (com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftd, "").equals(paramArrayOfByte)) {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftd, u.aqG());
        }
        localObject = ca.gPq.asG().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(ca.gPq.getString(str, "login_user_name"))) {
            ca.gPq.m(str, "login_user_name", str);
          }
        }
      }
      if ((bt.isNullOrNil(this.dmQ)) || (bt.isNullOrNil(this.dmS))) {
        l.eT(true);
      }
      if (paramq.CCB == 19) {
        com.tencent.mm.kernel.g.afB().afk().set(12322, null);
      }
      ad.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (paramq.CCB == 3)
      {
        com.tencent.mm.kernel.g.afB().afk().set(4097, "");
        com.tencent.mm.kernel.g.afB().afk().set(6, "");
        com.tencent.mm.kernel.g.afB().afk().set(12322, null);
        com.tencent.mm.kernel.g.afB().afk().set(64, Integer.valueOf(paramArrayOfByte.CuL));
        paramq = new wf();
        paramq.dBG.dBH = false;
        paramq.dBG.dBI = true;
        a.ESL.l(paramq);
        l.aIR();
        l.aIS();
        ad.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */