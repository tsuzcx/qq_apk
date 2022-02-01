package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.Set;

public final class z
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String dxq;
  private String dxs;
  private int hRl;
  public final com.tencent.mm.ak.b rr;
  
  public z(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.hRl = 2;
    this.dxq = null;
    this.dxs = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new lq();
    ((b.a)localObject).hQG = new lr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).funcId = 132;
    ((b.a)localObject).hQH = 45;
    ((b.a)localObject).respCmdId = 1000000045;
    this.rr = ((b.a)localObject).aDS();
    localObject = (lq)this.rr.hQD.hQJ;
    ((lq)localObject).FSQ = paramInt1;
    ((lq)localObject).FWg = paramInt2;
    ((lq)localObject).FWh = paramString3;
    if ((bu.isNullOrNil(this.dxq)) && (bu.isNullOrNil(this.dxs)))
    {
      if (com.tencent.mm.sdk.platformtools.k.IwL)
      {
        paramString3 = ak.getContext().getString(2131762749);
        ((lq)localObject).FWj = paramString3;
        ((lq)localObject).FWk = d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label304;
      }
      g.ajR().ajA().set(4097, paramString1);
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((lq)localObject).FWe = paramString1;
      ((lq)localObject).FWf = paramString2;
      ((lq)localObject).qkN = ad.fom();
      AppMethodBeat.o(131090);
      return;
      paramString3 = ak.getContext().getString(2131762748);
      break;
      label304:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)g.ajR().ajA().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)g.ajR().ajA().get(6, null);
      }
    }
  }
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.dxq = paramString4;
    this.dxs = paramString5;
    paramString1 = (lq)this.rr.hQD.hQJ;
    paramString1.FWj = paramString4;
    paramString1.FWk = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public final int KZ()
  {
    return ((lq)this.rr.hQD.hQJ).FSQ;
  }
  
  public final String aHN()
  {
    return ((lr)this.rr.hQE.hQJ).dqk;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(131091);
    this.callback = paramf;
    paramf = (lq)this.rr.hQD.hQJ;
    if ((paramf.FWe == null) || (paramf.FWe.length() <= 0))
    {
      ae.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramf.FWe);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((paramf.FSQ == 2) || (paramf.FSQ == 19)) && ((paramf.FWf == null) || (paramf.FWf.length() <= 0)))
    {
      ae.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramf.FWe);
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
    paramq = (lq)this.rr.hQD.hQJ;
    paramArrayOfByte = (lr)this.rr.hQE.hQJ;
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.FRH;
      ae.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.ajS();
      g.ajR().gDO.set(47, Integer.valueOf(paramInt1));
      localObject = g.ajQ().gDv.hRo;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject).eK(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        ae.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          ae.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hRl) });
          this.hRl -= 1;
          if (this.hRl <= 0)
          {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(131092);
            return;
            label229:
            bool = false;
            break;
            ae.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[] { paramArrayOfByte });
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
      ae.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.FWu + "safedevice status = " + paramArrayOfByte.FKJ);
    }
    if ((paramq.FSQ == 2) || (paramq.FSQ == 4) || (paramq.FSQ == 11) || (paramq.FSQ == 19))
    {
      g.ajR().ajA().set(4097, "");
      paramArrayOfByte = (String)g.ajR().ajA().get(6, "");
      g.ajR().ajA().set(6, paramq.FWe);
      if (!bu.isNullOrNil(paramArrayOfByte))
      {
        if (g.ajR().ajA().get(am.a.IXT, "").equals(paramArrayOfByte)) {
          g.ajR().ajA().set(am.a.IXT, v.aAC());
        }
        localObject = cd.hLa.aCQ().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(cd.hLa.getString(str, "login_user_name"))) {
            cd.hLa.l(str, "login_user_name", str);
          }
        }
      }
      if ((bu.isNullOrNil(this.dxq)) || (bu.isNullOrNil(this.dxs))) {
        l.fs(true);
      }
      if (paramq.FSQ == 19) {
        g.ajR().ajA().set(12322, null);
      }
      ae.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (paramq.FSQ == 3)
      {
        g.ajR().ajA().set(4097, "");
        g.ajR().ajA().set(6, "");
        g.ajR().ajA().set(12322, null);
        g.ajR().ajA().set(64, Integer.valueOf(paramArrayOfByte.FKJ));
        paramq = new xn();
        paramq.dMV.dMW = false;
        paramq.dMV.dMX = true;
        a.IvT.l(paramq);
        l.aTt();
        l.aTu();
        ae.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */