package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
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
  private String dOX;
  private String dOZ;
  private int iMt;
  public final com.tencent.mm.ak.d rr;
  
  public z(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.iMt = 2;
    this.dOX = null;
    this.dOZ = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new mh();
    ((d.a)localObject).iLO = new mi();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((d.a)localObject).funcId = 132;
    ((d.a)localObject).iLP = 45;
    ((d.a)localObject).respCmdId = 1000000045;
    this.rr = ((d.a)localObject).aXF();
    localObject = (mh)this.rr.iLK.iLR;
    ((mh)localObject).KMz = paramInt1;
    ((mh)localObject).KPR = paramInt2;
    ((mh)localObject).KPS = paramString3;
    if ((Util.isNullOrNil(this.dOX)) && (Util.isNullOrNil(this.dOZ)))
    {
      if (ChannelUtil.isNokiaAol)
      {
        paramString3 = MMApplicationContext.getContext().getString(2131764834);
        ((mh)localObject).KPU = paramString3;
        ((mh)localObject).KPV = com.tencent.mm.protocal.d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label304;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(4097, paramString1);
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((mh)localObject).KPP = paramString1;
      ((mh)localObject).KPQ = paramString2;
      ((mh)localObject).rBI = LocaleUtil.getApplicationLanguage();
      AppMethodBeat.o(131090);
      return;
      paramString3 = MMApplicationContext.getContext().getString(2131764833);
      break;
      label304:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(6, null);
      }
    }
  }
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.dOX = paramString4;
    this.dOZ = paramString5;
    paramString1 = (mh)this.rr.iLK.iLR;
    paramString1.KPU = paramString4;
    paramString1.KPV = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public final int Vj()
  {
    return ((mh)this.rr.iLK.iLR).KMz;
  }
  
  public final String bbG()
  {
    return ((mi)this.rr.iLL.iLR).dHx;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131091);
    this.callback = parami;
    parami = (mh)this.rr.iLK.iLR;
    if ((parami.KPP == null) || (parami.KPP.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + parami.KPP);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((parami.KMz == 2) || (parami.KMz == 19)) && ((parami.KPQ == null) || (parami.KPQ.length() <= 0)))
    {
      Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + parami.KPP);
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
    params = (mh)this.rr.iLK.iLR;
    paramArrayOfByte = (mi)this.rr.iLL.iLR;
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.KLo;
      Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(paramInt1));
      localObject = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((com.tencent.mm.network.g)localObject).fB(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        Log.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.iMt) });
          this.iMt -= 1;
          if (this.iMt <= 0)
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
      Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.KQg + "safedevice status = " + paramArrayOfByte.KEf);
    }
    if ((params.KMz == 2) || (params.KMz == 4) || (params.KMz == 11) || (params.KMz == 19))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(4097, "");
      paramArrayOfByte = (String)com.tencent.mm.kernel.g.aAh().azQ().get(6, "");
      com.tencent.mm.kernel.g.aAh().azQ().set(6, params.KPP);
      if (!Util.isNullOrNil(paramArrayOfByte))
      {
        if (com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ogq, "").equals(paramArrayOfByte)) {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogq, com.tencent.mm.model.z.aTY());
        }
        localObject = ch.iFO.aWo().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(ch.iFO.getString(str, "login_user_name"))) {
            ch.iFO.l(str, "login_user_name", str);
          }
        }
      }
      if ((Util.isNullOrNil(this.dOX)) || (Util.isNullOrNil(this.dOZ))) {
        l.gl(true);
      }
      if (params.KMz == 19) {
        com.tencent.mm.kernel.g.aAh().azQ().set(12322, null);
      }
      Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (params.KMz == 3)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(4097, "");
        com.tencent.mm.kernel.g.aAh().azQ().set(6, "");
        com.tencent.mm.kernel.g.aAh().azQ().set(12322, null);
        com.tencent.mm.kernel.g.aAh().azQ().set(64, Integer.valueOf(paramArrayOfByte.KEf));
        params = new yo();
        params.eeN.eeO = false;
        params.eeN.eeP = true;
        EventCenter.instance.publish(params);
        l.bof();
        l.bog();
        Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */