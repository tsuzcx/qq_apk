package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.Set;

public final class x
  extends m
  implements k
{
  private f callback;
  private String cxl;
  private String cxn;
  private int ftx;
  public final com.tencent.mm.ai.b rr;
  
  public x(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(108429);
    this.callback = null;
    this.ftx = 2;
    this.cxl = null;
    this.cxn = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new js();
    ((b.a)localObject).fsY = new jt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).funcId = 132;
    ((b.a)localObject).reqCmdId = 45;
    ((b.a)localObject).respCmdId = 1000000045;
    this.rr = ((b.a)localObject).ado();
    localObject = (js)this.rr.fsV.fta;
    ((js)localObject).wsW = paramInt1;
    ((js)localObject).wvI = paramInt2;
    ((js)localObject).wvJ = paramString3;
    if ((bo.isNullOrNil(this.cxl)) && (bo.isNullOrNil(this.cxn)))
    {
      if (com.tencent.mm.sdk.platformtools.g.ymO)
      {
        paramString3 = ah.getContext().getString(2131302837);
        ((js)localObject).wvL = paramString3;
        ((js)localObject).wvM = d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label304;
      }
      com.tencent.mm.kernel.g.RL().Ru().set(4097, paramString1);
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((js)localObject).wvG = paramString1;
      ((js)localObject).wvH = paramString2;
      ((js)localObject).lGH = aa.dsG();
      AppMethodBeat.o(108429);
      return;
      paramString3 = ah.getContext().getString(2131302836);
      break;
      label304:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(6, null);
      }
    }
  }
  
  public x(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(108428);
    this.cxl = paramString4;
    this.cxn = paramString5;
    paramString1 = (js)this.rr.fsV.fta;
    paramString1.wvL = paramString4;
    paramString1.wvM = paramString5;
    AppMethodBeat.o(108428);
  }
  
  public final int Ac()
  {
    return ((js)this.rr.fsV.fta).wsW;
  }
  
  public final String agx()
  {
    return ((jt)this.rr.fsW.fta).crs;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108430);
    this.callback = paramf;
    paramf = (js)this.rr.fsV.fta;
    if ((paramf.wvG == null) || (paramf.wvG.length() <= 0))
    {
      ab.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramf.wvG);
      AppMethodBeat.o(108430);
      return -1;
    }
    if (((paramf.wsW == 2) || (paramf.wsW == 19)) && ((paramf.wvH == null) || (paramf.wvH.length() <= 0)))
    {
      ab.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramf.wvG);
      AppMethodBeat.o(108430);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108430);
    return i;
  }
  
  public final int getType()
  {
    return 132;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108431);
    paramq = (js)this.rr.fsV.fta;
    paramArrayOfByte = (jt)this.rr.fsW.fta;
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.wsa;
      ab.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().eHM.set(47, Integer.valueOf(paramInt1));
      localObject = com.tencent.mm.kernel.g.RK().eHt.ftA;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject).cT(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        ab.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          ab.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ftx) });
          this.ftx -= 1;
          if (this.ftx <= 0)
          {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(108431);
            return;
            label229:
            bool = false;
            break;
            ab.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[] { paramArrayOfByte });
            continue;
          }
          doScene(dispatcher(), this.callback);
          AppMethodBeat.o(108431);
          return;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(108431);
        return;
      }
    }
    if (paramArrayOfByte != null) {
      ab.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.wvU + "safedevice status = " + paramArrayOfByte.wmw);
    }
    if ((paramq.wsW == 2) || (paramq.wsW == 4) || (paramq.wsW == 11) || (paramq.wsW == 19))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(4097, "");
      paramArrayOfByte = (String)com.tencent.mm.kernel.g.RL().Ru().get(6, "");
      com.tencent.mm.kernel.g.RL().Ru().set(6, paramq.wvG);
      if (!bo.isNullOrNil(paramArrayOfByte))
      {
        if (com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJS, "").equals(paramArrayOfByte)) {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJS, r.Zn());
        }
        localObject = bx.fnO.abf().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(bx.fnO.getString(str, "login_user_name"))) {
            bx.fnO.n(str, "login_user_name", str);
          }
        }
      }
      if ((bo.isNullOrNil(this.cxl)) || (bo.isNullOrNil(this.cxn))) {
        l.dx(true);
      }
      if (paramq.wsW == 19) {
        com.tencent.mm.kernel.g.RL().Ru().set(12322, null);
      }
      ab.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108431);
      return;
      if (paramq.wsW == 3)
      {
        com.tencent.mm.kernel.g.RL().Ru().set(4097, "");
        com.tencent.mm.kernel.g.RL().Ru().set(6, "");
        com.tencent.mm.kernel.g.RL().Ru().set(12322, null);
        com.tencent.mm.kernel.g.RL().Ru().set(64, Integer.valueOf(paramArrayOfByte.wmw));
        paramq = new ug();
        paramq.cKJ.cKK = false;
        paramq.cKJ.cKL = true;
        a.ymk.l(paramq);
        l.aqw();
        l.aqx();
        ab.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.x
 * JD-Core Version:    0.7.0.1
 */