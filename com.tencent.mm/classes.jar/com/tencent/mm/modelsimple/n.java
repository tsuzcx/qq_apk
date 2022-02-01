package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public static String hrI;
  public static String hrJ;
  public static String hrK;
  public static String hrL;
  public static String hrM;
  public static String hrN;
  public static String hrO;
  public static String hrP;
  public static String hrQ;
  public static String hrR;
  public static String hrS;
  private static int hrT;
  private static int hrU = -1;
  private static int hrV = 22;
  private static int hrW = 0;
  private static boolean hrX = false;
  private static int hrY = 0;
  private g callback;
  
  public n(int paramInt)
  {
    hrT = paramInt;
  }
  
  public static int aAC()
  {
    return hrU;
  }
  
  public static boolean aAD()
  {
    return (hrW & 0x2) != 0;
  }
  
  public static boolean aAE()
  {
    return (hrV & 0x4) != 0;
  }
  
  public static int aAF()
  {
    return hrT;
  }
  
  public static boolean aAG()
  {
    return (hrW & 0x200) != 0;
  }
  
  public static boolean aAH()
  {
    return (hrW & 0x400) != 0;
  }
  
  public static void ev(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      hrV |= 0x4;
      return;
    }
    hrV &= 0xFFFFFFFB;
  }
  
  public static int getDeviceType()
  {
    return hrY;
  }
  
  public static boolean oB(int paramInt)
  {
    return hrT != paramInt;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20633);
    b.a locala = new b.a();
    awy localawy = new awy();
    localawy.oXs = ac.eFu();
    ad.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localawy.oXs });
    locala.gUU = localawy;
    locala.gUV = new awz();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.callback = paramg;
    int i = dispatch(parame, locala.atI(), this);
    AppMethodBeat.o(20633);
    return i;
  }
  
  public final int getType()
  {
    return 526;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20634);
    ad.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (awz)((com.tencent.mm.al.b)paramq).gUT.gUX;
      hrU = paramArrayOfByte.Dwh;
      ad.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(hrU), Integer.valueOf(paramArrayOfByte.Cxm) });
      Object localObject = bw.K(paramArrayOfByte.Dwg, "summary");
      paramInt1 = hrV;
      if (localObject != null)
      {
        hrI = (String)((Map)localObject).get(".summary.banner");
        hrJ = bt.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        ad.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.Dwe), paramArrayOfByte.Dwg });
        localObject = (awy)((com.tencent.mm.al.b)paramq).gUS.gUX;
        Iterator localIterator = paramArrayOfByte.Dwf.iterator();
        while (localIterator.hasNext())
        {
          paramq = (bur)localIterator.next();
          if (paramq.CEi.eBA().hashCode() != ((awy)localObject).BaseRequest.CEi.eBA().hashCode())
          {
            hrY = paramq.DRP;
            ad.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(hrY) });
            localObject = bw.K(paramq.DRQ, "wording");
            ad.d("MicroMsg.NetSceneGetOnlineInfo", paramq.DRQ);
            if (localObject != null)
            {
              hrK = (String)((Map)localObject).get(".wording.title");
              hrL = (String)((Map)localObject).get(".wording.notify");
              hrM = (String)((Map)localObject).get(".wording.mute_title");
              hrN = (String)((Map)localObject).get(".wording.mute_tips");
              hrR = (String)((Map)localObject).get(".wording.exit_confirm");
              hrO = (String)((Map)localObject).get(".wording.lock_title");
              hrP = (String)((Map)localObject).get(".wording.mute_lock_title");
              hrQ = (String)((Map)localObject).get(".wording.exit");
              hrS = (String)((Map)localObject).get(".wording.usage_link");
            }
            paramInt1 = paramq.DRS;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.Cxm;
      hrW = i;
      if ((i & 0x2) == 0)
      {
        hrX = true;
        if (paramInt1 != hrV)
        {
          hrV = paramInt1;
          az.arV();
          c.aeE();
        }
        if ((paramArrayOfByte.Cxm & 0x40) != 0)
        {
          az.arV();
          paramArrayOfByte = c.apM().aHY("filehelper");
          if (paramArrayOfByte != null)
          {
            paramq = paramArrayOfByte;
            if (!bt.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            ae.D(paramArrayOfByte);
            az.arV();
            paramq = c.apM().aHY("filehelper");
          }
          if ((paramq != null) && (!com.tencent.mm.n.b.ls(paramq.field_type)))
          {
            paramq.Zk();
            az.arV();
            c.apM().c(paramq.field_username, paramq);
          }
          az.arV();
          paramq = c.apR().aIn("filehelper");
          if (paramq != null) {
            break label697;
          }
          paramq = new am("filehelper");
          paramq.kS(bt.eGO());
          az.arV();
          c.apR().e(paramq);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(20634);
        return;
        hrX = false;
        break;
        label697:
        paramq.kS(bt.eGO());
        az.arV();
        c.apR().a(paramq, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */