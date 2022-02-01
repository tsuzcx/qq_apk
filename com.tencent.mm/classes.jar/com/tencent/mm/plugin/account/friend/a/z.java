package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.Set;

public final class z
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private String dkA;
  private String dky;
  private int hwd;
  public final com.tencent.mm.ak.b rr;
  
  public z(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.hwd = 2;
    this.dky = null;
    this.dkA = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new lg();
    ((b.a)localObject).hvu = new lh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).funcId = 132;
    ((b.a)localObject).reqCmdId = 45;
    ((b.a)localObject).respCmdId = 1000000045;
    this.rr = ((b.a)localObject).aAz();
    localObject = (lg)this.rr.hvr.hvw;
    ((lg)localObject).DUY = paramInt1;
    ((lg)localObject).DYp = paramInt2;
    ((lg)localObject).DYq = paramString3;
    if ((bs.isNullOrNil(this.dky)) && (bs.isNullOrNil(this.dkA)))
    {
      if (i.GqM)
      {
        paramString3 = ai.getContext().getString(2131762749);
        ((lg)localObject).DYs = paramString3;
        ((lg)localObject).DYt = d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label304;
      }
      com.tencent.mm.kernel.g.agR().agA().set(4097, paramString1);
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((lg)localObject).DYn = paramString1;
      ((lg)localObject).DYo = paramString2;
      ((lg)localObject).pAD = ab.eUO();
      AppMethodBeat.o(131090);
      return;
      paramString3 = ai.getContext().getString(2131762748);
      break;
      label304:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)com.tencent.mm.kernel.g.agR().agA().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)com.tencent.mm.kernel.g.agR().agA().get(6, null);
      }
    }
  }
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.dky = paramString4;
    this.dkA = paramString5;
    paramString1 = (lg)this.rr.hvr.hvw;
    paramString1.DYs = paramString4;
    paramString1.DYt = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public final int Js()
  {
    return ((lg)this.rr.hvr.hvw).DUY;
  }
  
  public final String aEr()
  {
    return ((lh)this.rr.hvs.hvw).ddJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(131091);
    this.callback = paramg;
    paramg = (lg)this.rr.hvr.hvw;
    if ((paramg.DYn == null) || (paramg.DYn.length() <= 0))
    {
      ac.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramg.DYn);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((paramg.DUY == 2) || (paramg.DUY == 19)) && ((paramg.DYo == null) || (paramg.DYo.length() <= 0)))
    {
      ac.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramg.DYn);
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
    paramq = (lg)this.rr.hvr.hvw;
    paramArrayOfByte = (lh)this.rr.hvs.hvw;
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.DTP;
      ac.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().ghx.set(47, Integer.valueOf(paramInt1));
      localObject = com.tencent.mm.kernel.g.agQ().ghe.hwg;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject).eG(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        ac.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          ac.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hwd) });
          this.hwd -= 1;
          if (this.hwd <= 0)
          {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(131092);
            return;
            label229:
            bool = false;
            break;
            ac.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[] { paramArrayOfByte });
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
      ac.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.DYD + "safedevice status = " + paramArrayOfByte.DNg);
    }
    if ((paramq.DUY == 2) || (paramq.DUY == 4) || (paramq.DUY == 11) || (paramq.DUY == 19))
    {
      com.tencent.mm.kernel.g.agR().agA().set(4097, "");
      paramArrayOfByte = (String)com.tencent.mm.kernel.g.agR().agA().get(6, "");
      com.tencent.mm.kernel.g.agR().agA().set(6, paramq.DYn);
      if (!bs.isNullOrNil(paramArrayOfByte))
      {
        if (com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQW, "").equals(paramArrayOfByte)) {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQW, u.axw());
        }
        localObject = ca.hpQ.azx().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(ca.hpQ.getString(str, "login_user_name"))) {
            ca.hpQ.m(str, "login_user_name", str);
          }
        }
      }
      if ((bs.isNullOrNil(this.dky)) || (bs.isNullOrNil(this.dkA))) {
        l.fn(true);
      }
      if (paramq.DUY == 19) {
        com.tencent.mm.kernel.g.agR().agA().set(12322, null);
      }
      ac.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (paramq.DUY == 3)
      {
        com.tencent.mm.kernel.g.agR().agA().set(4097, "");
        com.tencent.mm.kernel.g.agR().agA().set(6, "");
        com.tencent.mm.kernel.g.agR().agA().set(12322, null);
        com.tencent.mm.kernel.g.agR().agA().set(64, Integer.valueOf(paramArrayOfByte.DNg));
        paramq = new wq();
        paramq.dzu.dzv = false;
        paramq.dzu.dzw = true;
        a.GpY.l(paramq);
        l.aPI();
        l.aPJ();
        ac.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */