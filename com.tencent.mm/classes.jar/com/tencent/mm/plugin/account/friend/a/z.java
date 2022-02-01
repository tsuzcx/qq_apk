package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.zv;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ci;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.Set;

public final class z
  extends q
  implements m
{
  private i callback;
  private String fIi;
  private String fIk;
  private int lCA;
  public final com.tencent.mm.an.d rr;
  
  public z(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.lCA = 2;
    this.fIi = null;
    this.fIk = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new lx();
    ((d.a)localObject).lBV = new ly();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((d.a)localObject).funcId = 132;
    ((d.a)localObject).lBW = 45;
    ((d.a)localObject).respCmdId = 1000000045;
    this.rr = ((d.a)localObject).bgN();
    localObject = (lx)d.b.b(this.rr.lBR);
    ((lx)localObject).RNt = paramInt1;
    ((lx)localObject).RQP = paramInt2;
    ((lx)localObject).RQQ = paramString3;
    if ((Util.isNullOrNil(this.fIi)) && (Util.isNullOrNil(this.fIk)))
    {
      if (ChannelUtil.isNokiaAol)
      {
        paramString3 = MMApplicationContext.getContext().getString(a.g.safe_device_android_device_nm);
        ((lx)localObject).RQS = paramString3;
        ((lx)localObject).RQT = com.tencent.mm.protocal.d.RAB;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label306;
      }
      h.aHG().aHp().i(4097, paramString1);
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((lx)localObject).RQN = paramString1;
      ((lx)localObject).RQO = paramString2;
      ((lx)localObject).vhq = LocaleUtil.getApplicationLanguage();
      AppMethodBeat.o(131090);
      return;
      paramString3 = MMApplicationContext.getContext().getString(a.g.safe_device_android_device);
      break;
      label306:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)h.aHG().aHp().b(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)h.aHG().aHp().b(6, null);
      }
    }
  }
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.fIi = paramString4;
    this.fIk = paramString5;
    paramString1 = (lx)d.b.b(this.rr.lBR);
    paramString1.RQS = paramString4;
    paramString1.RQT = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public final int ZB()
  {
    AppMethodBeat.i(193587);
    int i = ((lx)d.b.b(this.rr.lBR)).RNt;
    AppMethodBeat.o(193587);
    return i;
  }
  
  public final String bkW()
  {
    AppMethodBeat.i(193604);
    String str = ((ly)d.c.b(this.rr.lBS)).fAo;
    AppMethodBeat.o(193604);
    return str;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131091);
    this.callback = parami;
    parami = (lx)d.b.b(this.rr.lBR);
    if ((parami.RQN == null) || (parami.RQN.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + parami.RQN);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((parami.RNt == 2) || (parami.RNt == 19)) && ((parami.RQO == null) || (parami.RQO.length() <= 0)))
    {
      Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + parami.RQN);
      AppMethodBeat.o(131091);
      return -1;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131091);
    return i;
  }
  
  public final int getType()
  {
    return 132;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131092);
    params = (lx)d.b.b(this.rr.lBR);
    paramArrayOfByte = (ly)d.c.b(this.rr.lBS);
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.RMk;
      Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      h.aHH();
      h.aHG().kcw.i(47, Integer.valueOf(paramInt1));
      localObject = h.aHF().kcd.lCD;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((g)localObject).gm(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        Log.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.lCA) });
          this.lCA -= 1;
          if (this.lCA <= 0)
          {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(131092);
            return;
            label229:
            bool = false;
            break;
            Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[] { paramArrayOfByte });
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
      Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.RRe + "safedevice status = " + paramArrayOfByte.RFx);
    }
    if ((params.RNt == 2) || (params.RNt == 4) || (params.RNt == 11) || (params.RNt == 19))
    {
      h.aHG().aHp().i(4097, "");
      paramArrayOfByte = (String)h.aHG().aHp().b(6, "");
      h.aHG().aHp().i(6, params.RQN);
      if (!Util.isNullOrNil(paramArrayOfByte))
      {
        if (h.aHG().aHp().get(ar.a.VuG, "").equals(paramArrayOfByte)) {
          h.aHG().aHp().set(ar.a.VuG, com.tencent.mm.model.z.bcZ());
        }
        localObject = ci.lvQ.bfs().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(ci.lvQ.getString(str, "login_user_name"))) {
            ci.lvQ.o(str, "login_user_name", str);
          }
        }
      }
      if ((Util.isNullOrNil(this.fIi)) || (Util.isNullOrNil(this.fIk))) {
        l.gX(true);
      }
      if (params.RNt == 19) {
        h.aHG().aHp().i(12322, null);
      }
      Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (params.RNt == 3)
      {
        h.aHG().aHp().i(4097, "");
        h.aHG().aHp().i(6, "");
        h.aHG().aHp().i(12322, null);
        h.aHG().aHp().i(64, Integer.valueOf(paramArrayOfByte.RFx));
        params = new zv();
        params.fZc.fZd = false;
        params.fZc.fZe = true;
        EventCenter.instance.publish(params);
        l.byo();
        l.byp();
        Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */