package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class o
  extends n
  implements k
{
  public static String ioA;
  public static String ioB;
  public static String ioC;
  public static String ioD;
  public static String ioE;
  private static int ioF;
  private static int ioG = -1;
  private static int ioH = 22;
  private static int ioI = 0;
  private static boolean ioJ = false;
  private static int ioK = 0;
  private static int ioL = 0;
  public static String iou;
  public static String iov;
  public static String iow;
  public static String iox;
  public static String ioy;
  public static String ioz;
  private f callback;
  
  public o(int paramInt)
  {
    ioF = paramInt;
  }
  
  public static int aKL()
  {
    return ioL;
  }
  
  public static int aLa()
  {
    return ioG;
  }
  
  public static boolean aLb()
  {
    return (ioI & 0x2) != 0;
  }
  
  public static boolean aLc()
  {
    return (ioH & 0x4) != 0;
  }
  
  public static int aLd()
  {
    return ioF;
  }
  
  public static boolean aLe()
  {
    return (ioI & 0x200) != 0;
  }
  
  public static boolean aLf()
  {
    return (ioI & 0x400) != 0;
  }
  
  public static void eU(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ioH |= 0x4;
      return;
    }
    ioH &= 0xFFFFFFFB;
  }
  
  public static int getDeviceType()
  {
    return ioK;
  }
  
  public static boolean pV(int paramInt)
  {
    return ioF != paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20633);
    b.a locala = new b.a();
    bfk localbfk = new bfk();
    localbfk.qkN = ad.fom();
    ae.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localbfk.qkN });
    locala.hQF = localbfk;
    locala.hQG = new bfl();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.callback = paramf;
    int i = dispatch(parame, locala.aDS(), this);
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
    ae.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bfl)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      ioG = paramArrayOfByte.GUu;
      ae.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(ioG), Integer.valueOf(paramArrayOfByte.FNv) });
      Object localObject = bx.M(paramArrayOfByte.GUt, "summary");
      paramInt1 = ioH;
      if (localObject != null)
      {
        iou = (String)((Map)localObject).get(".summary.banner");
        iov = bu.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        ae.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.GUr), paramArrayOfByte.GUt });
        localObject = (bfk)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
        Iterator localIterator = paramArrayOfByte.GUs.iterator();
        while (localIterator.hasNext())
        {
          paramq = (cet)localIterator.next();
          if (paramq.FUz.fjO().hashCode() != ((bfk)localObject).BaseRequest.FUz.fjO().hashCode())
          {
            ioK = paramq.Hrw;
            ae.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(ioK) });
            localObject = bx.M(paramq.Hrx, "wording");
            ae.d("MicroMsg.NetSceneGetOnlineInfo", paramq.Hrx);
            if (localObject != null)
            {
              iow = (String)((Map)localObject).get(".wording.title");
              iox = (String)((Map)localObject).get(".wording.notify");
              ioy = (String)((Map)localObject).get(".wording.mute_title");
              ioz = (String)((Map)localObject).get(".wording.mute_tips");
              ioD = (String)((Map)localObject).get(".wording.exit_confirm");
              ioA = (String)((Map)localObject).get(".wording.lock_title");
              ioB = (String)((Map)localObject).get(".wording.mute_lock_title");
              ioC = (String)((Map)localObject).get(".wording.exit");
              ioE = (String)((Map)localObject).get(".wording.usage_link");
            }
            paramInt1 = paramq.Hrz;
            ioL = paramq.FUA;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.FNv;
      ioI = i;
      if ((i & 0x2) == 0)
      {
        ioJ = true;
        if (paramInt1 != ioH)
        {
          ioH = paramInt1;
          bc.aCg();
          com.tencent.mm.model.c.aiV();
        }
        if ((paramArrayOfByte.FNv & 0x40) != 0)
        {
          bc.aCg();
          paramArrayOfByte = com.tencent.mm.model.c.azF().BH("filehelper");
          if (paramArrayOfByte != null)
          {
            paramq = paramArrayOfByte;
            if (!bu.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            ag.L(paramArrayOfByte);
            bc.aCg();
            paramq = com.tencent.mm.model.c.azF().BH("filehelper");
          }
          if ((paramq != null) && (!com.tencent.mm.contact.c.lO(paramq.field_type)))
          {
            paramq.acS();
            bc.aCg();
            com.tencent.mm.model.c.azF().c(paramq.field_username, paramq);
          }
          bc.aCg();
          paramq = com.tencent.mm.model.c.azL().aVa("filehelper");
          if (paramq != null) {
            break label706;
          }
          paramq = new au("filehelper");
          paramq.qH(bu.fpO());
          bc.aCg();
          com.tencent.mm.model.c.azL().e(paramq);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(20634);
        return;
        ioJ = false;
        break;
        label706:
        paramq.qH(bu.fpO());
        bc.aCg();
        com.tencent.mm.model.c.azL().a(paramq, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */