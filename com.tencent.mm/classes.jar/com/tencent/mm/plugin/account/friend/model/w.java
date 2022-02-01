package com.tencent.mm.plugin.account.friend.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abs;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.Set;

public final class w
  extends p
  implements m
{
  public static int pTm = 0;
  private com.tencent.mm.am.h callback;
  private String hNI;
  private String hNK;
  private int ouk;
  public final com.tencent.mm.am.c rr;
  
  public w(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(131090);
    this.callback = null;
    this.ouk = 2;
    this.hNI = null;
    this.hNK = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new my();
    ((c.a)localObject).otF = new mz();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((c.a)localObject).funcId = 132;
    ((c.a)localObject).otG = 45;
    ((c.a)localObject).respCmdId = 1000000045;
    this.rr = ((c.a)localObject).bEF();
    localObject = (my)c.b.b(this.rr.otB);
    ((my)localObject).YKH = paramInt1;
    ((my)localObject).YOe = paramInt2;
    ((my)localObject).YOf = paramString3;
    if ((Util.isNullOrNil(this.hNI)) && (Util.isNullOrNil(this.hNK)))
    {
      if (ChannelUtil.isNokiaAol)
      {
        paramString3 = MMApplicationContext.getContext().getString(a.g.safe_device_android_device_nm);
        ((my)localObject).YOh = paramString3;
        ((my)localObject).YOi = d.Yxf;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label301;
      }
      com.tencent.mm.kernel.h.baE().ban().B(4097, paramString1);
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneBindOpMobile", "Get mobile:%s opcode:%s verifyCode:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
      ((my)localObject).YOc = paramString1;
      ((my)localObject).YOd = paramString2;
      ((my)localObject).yts = LocaleUtil.getApplicationLanguage();
      ((my)localObject).YOv = pTm;
      AppMethodBeat.o(131090);
      return;
      paramString3 = MMApplicationContext.getContext().getString(a.g.safe_device_android_device);
      break;
      label301:
      if ((paramInt1 == 2) || (paramInt1 == 25) || (paramInt1 == 19)) {
        paramString1 = (String)com.tencent.mm.kernel.h.baE().ban().d(4097, null);
      } else if (paramInt1 == 3) {
        paramString1 = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
      }
    }
  }
  
  public w(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt1, paramString2, paramInt2, paramString3);
    AppMethodBeat.i(304788);
    ((my)c.b.b(this.rr.otB)).YJu = paramString4;
    AppMethodBeat.o(304788);
  }
  
  public w(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    AppMethodBeat.i(131089);
    this.hNI = paramString4;
    this.hNK = paramString5;
    paramString1 = (my)c.b.b(this.rr.otB);
    paramString1.YOh = paramString4;
    paramString1.YOi = paramString5;
    AppMethodBeat.o(131089);
  }
  
  public w(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, paramInt, paramString2, paramString3, paramString5, paramString6);
    AppMethodBeat.i(304781);
    ((my)c.b.b(this.rr.otB)).YOu = paramString4;
    AppMethodBeat.o(304781);
  }
  
  public final int bIO()
  {
    AppMethodBeat.i(304802);
    int i = ((my)c.b.b(this.rr.otB)).YKH;
    AppMethodBeat.o(304802);
    return i;
  }
  
  public final String bIQ()
  {
    AppMethodBeat.i(304823);
    String str = ((mz)c.c.b(this.rr.otC)).hFb;
    AppMethodBeat.o(304823);
    return str;
  }
  
  public final my bXg()
  {
    AppMethodBeat.i(304799);
    my localmy = (my)c.b.b(this.rr.otB);
    AppMethodBeat.o(304799);
    return localmy;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131091);
    this.callback = paramh;
    paramh = (my)c.b.b(this.rr.otB);
    if ((paramh.YOc == null) || (paramh.YOc.length() <= 0))
    {
      Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + paramh.YOc);
      AppMethodBeat.o(131091);
      return -1;
    }
    if (((paramh.YKH == 2) || (paramh.YKH == 19)) && ((paramh.YOd == null) || (paramh.YOd.length() <= 0)))
    {
      Log.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + paramh.YOc);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131092);
    params = (my)c.b.b(this.rr.otB);
    paramArrayOfByte = (mz)c.c.b(this.rr.otC);
    Object localObject;
    boolean bool;
    if (paramArrayOfByte != null)
    {
      paramInt1 = paramArrayOfByte.YJy;
      Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().mCE.B(47, Integer.valueOf(paramInt1));
      localObject = com.tencent.mm.kernel.h.baD().mCm.oun;
      if (localObject != null)
      {
        if ((paramInt1 & 0x1) != 0) {
          break label232;
        }
        bool = true;
        ((g)localObject).hd(bool);
      }
    }
    for (;;)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        Log.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
        if ((paramInt2 == 4) && (paramInt3 == -240))
        {
          Log.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[] { Integer.valueOf(this.ouk) });
          this.ouk -= 1;
          if (this.ouk <= 0)
          {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(131092);
            return;
            label232:
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
      Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.YOw + "safedevice status = " + paramArrayOfByte.YCa);
    }
    if ((params.YKH == 2) || (params.YKH == 4) || (params.YKH == 11) || (params.YKH == 19))
    {
      com.tencent.mm.kernel.h.baE().ban().B(4097, "");
      paramArrayOfByte = (String)com.tencent.mm.kernel.h.baE().ban().d(6, "");
      com.tencent.mm.kernel.h.baE().ban().B(6, params.YOc);
      if (!Util.isNullOrNil(paramArrayOfByte))
      {
        if (com.tencent.mm.kernel.h.baE().ban().get(at.a.acWp, "").equals(paramArrayOfByte)) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acWp, z.bAM());
        }
        localObject = cj.ono.bDj().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (paramArrayOfByte.equals(cj.ono.getString(str, "login_user_name"))) {
            cj.ono.s(str, "login_user_name", str);
          }
        }
      }
      if ((Util.isNullOrNil(this.hNI)) || (Util.isNullOrNil(this.hNK))) {
        i.hN(true);
      }
      if (params.YKH == 19) {
        com.tencent.mm.kernel.h.baE().ban().B(12322, null);
      }
      l.kK(4, 3);
      Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131092);
      return;
      if (params.YKH == 3)
      {
        com.tencent.mm.kernel.h.baE().ban().B(4097, "");
        com.tencent.mm.kernel.h.baE().ban().B(6, "");
        com.tencent.mm.kernel.h.baE().ban().B(12322, null);
        com.tencent.mm.kernel.h.baE().ban().B(64, Integer.valueOf(paramArrayOfByte.YCa));
        params = new abs();
        params.ifi.hAJ = false;
        params.ifi.ifj = true;
        params.publish();
        i.bXb();
        i.bXc();
        Log.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.w
 * JD-Core Version:    0.7.0.1
 */