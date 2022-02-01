package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.Set;

public final class z
  extends n
  implements k
{
  private f callback;
  private String dwl;
  private String dwn;
  private int hOs;
  public final com.tencent.mm.al.b rr;
  
  public z(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.hOs = 2;
    this.dwl = null;
    this.dwn = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new lq();
    ((b.a)localObject).hNN = new lr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).funcId = 132;
    ((b.a)localObject).hNO = 45;
    ((b.a)localObject).respCmdId = 1000000045;
    this.rr = ((b.a)localObject).aDC();
    localObject = (lq)this.rr.hNK.hNQ;
    ((lq)localObject).FAt = paramInt1;
    ((lq)localObject).FDL = paramInt2;
    ((lq)localObject).FDM = paramString3;
    if ((bt.isNullOrNil(this.dwl)) && (bt.isNullOrNil(this.dwn)))
    {
      if (j.IcA)
      {
        paramString3 = aj.getContext().getString(2131762749);
        ((lq)localObject).FDO = paramString3;
        ((lq)localObject).FDP = d.DEVICE_NAME;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label304;
      }
      g.ajC().ajl().set(4097, paramString1);
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((lq)localObject).FDJ = paramString1;
      ((lq)localObject).FDK = paramString2;
      ((lq)localObject).qei = ac.fks();
      AppMethodBeat.o(131090);
      return;
      paramString3 = aj.getContext().getString(2131762748);
      break;
      label304:
      if ((paramInt1 == 2) || (paramInt1 == 19)) {
        paramString1 = (String)g.ajC().ajl().get(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)g.ajC().ajl().get(6, null);
      }
    }
  }
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.dwl = paramString4;
    this.dwn = paramString5;
    paramString1 = (lq)this.rr.hNK.hNQ;
    paramString1.FDO = paramString4;
    paramString1.FDP = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public final int KR()
  {
    return ((lq)this.rr.hNK.hNQ).FAt;
  }
  
  public final String aHw()
  {
    return ((lr)this.rr.hNL.hNQ).dpf;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(131091);
    this.callback = paramf;
    paramf = (lq)this.rr.hNK.hNQ;
    if ((paramf.FDJ == null) || (paramf.FDJ.length() <= 0))
    {
      ad.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramf.FDJ);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((paramf.FAt == 2) || (paramf.FAt == 19)) && ((paramf.FDK == null) || (paramf.FDK.length() <= 0)))
    {
      ad.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramf.FDJ);
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
    paramq = (lq)this.rr.hNK.hNQ;
    paramArrayOfByte = (lr)this.rr.hNL.hNQ;
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.Fzj;
      ad.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      g.ajD();
      g.ajC().gBh.set(47, Integer.valueOf(paramInt1));
      localObject = g.ajB().gAO.hOv;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label229;
        }
        bool = true;
        ((com.tencent.mm.network.e)localObject).eI(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        ad.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          ad.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.hOs) });
          this.hOs -= 1;
          if (this.hOs <= 0)
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
      ad.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.FDZ + "safedevice status = " + paramArrayOfByte.Fsl);
    }
    if ((paramq.FAt == 2) || (paramq.FAt == 4) || (paramq.FAt == 11) || (paramq.FAt == 19))
    {
      g.ajC().ajl().set(4097, "");
      paramArrayOfByte = (String)g.ajC().ajl().get(6, "");
      g.ajC().ajl().set(6, paramq.FDJ);
      if (!bt.isNullOrNil(paramArrayOfByte))
      {
        if (g.ajC().ajl().get(al.a.IDt, "").equals(paramArrayOfByte)) {
          g.ajC().ajl().set(al.a.IDt, u.aAm());
        }
        localObject = cb.hIi.aCA().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(cb.hIi.getString(str, "login_user_name"))) {
            cb.hIi.l(str, "login_user_name", str);
          }
        }
      }
      if ((bt.isNullOrNil(this.dwl)) || (bt.isNullOrNil(this.dwn))) {
        l.fr(true);
      }
      if (paramq.FAt == 19) {
        g.ajC().ajl().set(12322, null);
      }
      ad.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (paramq.FAt == 3)
      {
        g.ajC().ajl().set(4097, "");
        g.ajC().ajl().set(6, "");
        g.ajC().ajl().set(12322, null);
        g.ajC().ajl().set(64, Integer.valueOf(paramArrayOfByte.Fsl));
        paramq = new xj();
        paramq.dLG.dLH = false;
        paramq.dLG.dLI = true;
        a.IbL.l(paramq);
        l.aSU();
        l.aSV();
        ad.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.z
 * JD-Core Version:    0.7.0.1
 */