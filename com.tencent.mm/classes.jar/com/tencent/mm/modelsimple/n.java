package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends m
  implements k
{
  public static String fPe;
  public static String fPf;
  public static String fPg;
  public static String fPh;
  public static String fPi;
  public static String fPj;
  public static String fPk;
  public static String fPl;
  public static String fPm;
  public static String fPn;
  private static int fPo;
  private static int fPp = -1;
  private static int fPq = 22;
  private static int fPr = 0;
  private static boolean fPs = false;
  private static int fPt = 0;
  private f callback;
  
  public n(int paramInt)
  {
    fPo = paramInt;
  }
  
  public static boolean ajA()
  {
    return (fPq & 0x4) != 0;
  }
  
  public static int ajB()
  {
    return fPo;
  }
  
  public static boolean ajC()
  {
    return (fPr & 0x200) != 0;
  }
  
  public static boolean ajD()
  {
    return (fPr & 0x400) != 0;
  }
  
  public static int ajy()
  {
    return fPp;
  }
  
  public static boolean ajz()
  {
    return (fPr & 0x2) != 0;
  }
  
  public static void dd(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      fPq |= 0x4;
      return;
    }
    fPq &= 0xFFFFFFFB;
  }
  
  public static int getDeviceType()
  {
    return fPt;
  }
  
  public static boolean lT(int paramInt)
  {
    return fPo != paramInt;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16589);
    b.a locala = new b.a();
    amt localamt = new amt();
    localamt.lGH = aa.dsG();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localamt.lGH });
    locala.fsX = localamt;
    locala.fsY = new amu();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.callback = paramf;
    int i = dispatch(parame, locala.ado(), this);
    AppMethodBeat.o(16589);
    return i;
  }
  
  public final int getType()
  {
    return 526;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16590);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (amu)((com.tencent.mm.ai.b)paramq).fsW.fta;
      fPp = paramArrayOfByte.xdw;
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(fPp), Integer.valueOf(paramArrayOfByte.woE) });
      Object localObject = br.F(paramArrayOfByte.xdv, "summary");
      paramInt1 = fPq;
      if (localObject != null)
      {
        fPe = (String)((Map)localObject).get(".summary.banner");
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.xdt), paramArrayOfByte.xdv });
        localObject = (amt)((com.tencent.mm.ai.b)paramq).fsV.fta;
        Iterator localIterator = paramArrayOfByte.xdu.iterator();
        while (localIterator.hasNext())
        {
          paramq = (bhi)localIterator.next();
          if (paramq.wuq.dqj().hashCode() != ((amt)localObject).BaseRequest.wuq.dqj().hashCode())
          {
            fPt = paramq.xws;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(fPt) });
            localObject = br.F(paramq.xwt, "wording");
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetOnlineInfo", paramq.xwt);
            if (localObject != null)
            {
              fPf = (String)((Map)localObject).get(".wording.title");
              fPg = (String)((Map)localObject).get(".wording.notify");
              fPh = (String)((Map)localObject).get(".wording.mute_title");
              fPi = (String)((Map)localObject).get(".wording.mute_tips");
              fPj = (String)((Map)localObject).get(".wording.exit");
              fPk = (String)((Map)localObject).get(".wording.exit_confirm");
              fPl = (String)((Map)localObject).get(".wording.lock_title");
              fPm = (String)((Map)localObject).get(".wording.mute_lock_title");
              fPn = (String)((Map)localObject).get(".wording.exit");
            }
            paramInt1 = paramq.xwv;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.woE;
      fPr = i;
      if ((i & 0x2) == 0)
      {
        fPs = true;
        if (paramInt1 != fPq)
        {
          fPq = paramInt1;
          aw.aaz();
          c.QR();
        }
        if ((paramArrayOfByte.woE & 0x40) != 0)
        {
          aw.aaz();
          paramArrayOfByte = c.YA().arw("filehelper");
          if (paramArrayOfByte != null)
          {
            paramq = paramArrayOfByte;
            if (!bo.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            com.tencent.mm.model.ab.x(paramArrayOfByte);
            aw.aaz();
            paramq = c.YA().arw("filehelper");
          }
          if ((paramq != null) && (!a.je(paramq.field_type)))
          {
            paramq.Nx();
            aw.aaz();
            c.YA().b(paramq.field_username, paramq);
          }
          aw.aaz();
          paramq = c.YF().arH("filehelper");
          if (paramq != null) {
            break label677;
          }
          paramq = new ak("filehelper");
          paramq.fK(bo.aoy());
          aw.aaz();
          c.YF().d(paramq);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(16590);
        return;
        fPs = false;
        break;
        label677:
        paramq.fK(bo.aoy());
        aw.aaz();
        c.YF().a(paramq, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */