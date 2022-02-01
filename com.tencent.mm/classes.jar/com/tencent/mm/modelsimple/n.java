package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public static String ilB;
  public static String ilC;
  public static String ilD;
  public static String ilE;
  public static String ilF;
  public static String ilG;
  public static String ilH;
  public static String ilI;
  public static String ilJ;
  public static String ilK;
  public static String ilL;
  private static int ilM;
  private static int ilN = -1;
  private static int ilO = 22;
  private static int ilP = 0;
  private static boolean ilQ = false;
  private static int ilR = 0;
  private f callback;
  
  public n(int paramInt)
  {
    ilM = paramInt;
  }
  
  public static int aKD()
  {
    return ilN;
  }
  
  public static boolean aKE()
  {
    return (ilP & 0x2) != 0;
  }
  
  public static boolean aKF()
  {
    return (ilO & 0x4) != 0;
  }
  
  public static int aKG()
  {
    return ilM;
  }
  
  public static boolean aKH()
  {
    return (ilP & 0x200) != 0;
  }
  
  public static boolean aKI()
  {
    return (ilP & 0x400) != 0;
  }
  
  public static void eR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ilO |= 0x4;
      return;
    }
    ilO &= 0xFFFFFFFB;
  }
  
  public static int getDeviceType()
  {
    return ilR;
  }
  
  public static boolean pS(int paramInt)
  {
    return ilM != paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20633);
    b.a locala = new b.a();
    beu localbeu = new beu();
    localbeu.qei = ac.fks();
    ad.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localbeu.qei });
    locala.hNM = localbeu;
    locala.hNN = new bev();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.callback = paramf;
    int i = dispatch(parame, locala.aDC(), this);
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
      paramArrayOfByte = (bev)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      ilN = paramArrayOfByte.GAU;
      ad.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(ilN), Integer.valueOf(paramArrayOfByte.FuX) });
      Object localObject = bw.M(paramArrayOfByte.GAT, "summary");
      paramInt1 = ilO;
      if (localObject != null)
      {
        ilB = (String)((Map)localObject).get(".summary.banner");
        ilC = bt.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        ad.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.GAR), paramArrayOfByte.GAT });
        localObject = (beu)((com.tencent.mm.al.b)paramq).hNK.hNQ;
        Iterator localIterator = paramArrayOfByte.GAS.iterator();
        while (localIterator.hasNext())
        {
          paramq = (cdz)localIterator.next();
          if (paramq.FCe.ffY().hashCode() != ((beu)localObject).BaseRequest.FCe.ffY().hashCode())
          {
            ilR = paramq.GXW;
            ad.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(ilR) });
            localObject = bw.M(paramq.GXX, "wording");
            ad.d("MicroMsg.NetSceneGetOnlineInfo", paramq.GXX);
            if (localObject != null)
            {
              ilD = (String)((Map)localObject).get(".wording.title");
              ilE = (String)((Map)localObject).get(".wording.notify");
              ilF = (String)((Map)localObject).get(".wording.mute_title");
              ilG = (String)((Map)localObject).get(".wording.mute_tips");
              ilK = (String)((Map)localObject).get(".wording.exit_confirm");
              ilH = (String)((Map)localObject).get(".wording.lock_title");
              ilI = (String)((Map)localObject).get(".wording.mute_lock_title");
              ilJ = (String)((Map)localObject).get(".wording.exit");
              ilL = (String)((Map)localObject).get(".wording.usage_link");
            }
            paramInt1 = paramq.GXZ;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.FuX;
      ilP = i;
      if ((i & 0x2) == 0)
      {
        ilQ = true;
        if (paramInt1 != ilO)
        {
          ilO = paramInt1;
          ba.aBQ();
          c.aiG();
        }
        if ((paramArrayOfByte.FuX & 0x40) != 0)
        {
          ba.aBQ();
          paramArrayOfByte = c.azp().Bf("filehelper");
          if (paramArrayOfByte != null)
          {
            paramq = paramArrayOfByte;
            if (!bt.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            af.E(paramArrayOfByte);
            ba.aBQ();
            paramq = c.azp().Bf("filehelper");
          }
          if ((paramq != null) && (!com.tencent.mm.o.b.lM(paramq.field_type)))
          {
            paramq.acH();
            ba.aBQ();
            c.azp().c(paramq.field_username, paramq);
          }
          ba.aBQ();
          paramq = c.azv().aTz("filehelper");
          if (paramq != null) {
            break label697;
          }
          paramq = new at("filehelper");
          paramq.qu(bt.flT());
          ba.aBQ();
          c.azv().e(paramq);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(20634);
        return;
        ilQ = false;
        break;
        label697:
        paramq.qu(bt.flT());
        ba.aBQ();
        c.azv().a(paramq, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */