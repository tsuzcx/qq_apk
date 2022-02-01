package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private static int hSA = 0;
  public static String hSk;
  public static String hSl;
  public static String hSm;
  public static String hSn;
  public static String hSo;
  public static String hSp;
  public static String hSq;
  public static String hSr;
  public static String hSs;
  public static String hSt;
  public static String hSu;
  private static int hSv;
  private static int hSw = -1;
  private static int hSx = 22;
  private static int hSy = 0;
  private static boolean hSz = false;
  private g callback;
  
  public n(int paramInt)
  {
    hSv = paramInt;
  }
  
  public static int aHs()
  {
    return hSw;
  }
  
  public static boolean aHt()
  {
    return (hSy & 0x2) != 0;
  }
  
  public static boolean aHu()
  {
    return (hSx & 0x4) != 0;
  }
  
  public static int aHv()
  {
    return hSv;
  }
  
  public static boolean aHw()
  {
    return (hSy & 0x200) != 0;
  }
  
  public static boolean aHx()
  {
    return (hSy & 0x400) != 0;
  }
  
  public static void eP(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      hSx |= 0x4;
      return;
    }
    hSx &= 0xFFFFFFFB;
  }
  
  public static int getDeviceType()
  {
    return hSA;
  }
  
  public static boolean pp(int paramInt)
  {
    return hSv != paramInt;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20633);
    b.a locala = new b.a();
    baq localbaq = new baq();
    localbaq.pAD = ab.eUO();
    ac.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localbaq.pAD });
    locala.hvt = localbaq;
    locala.hvu = new bar();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.callback = paramg;
    int i = dispatch(parame, locala.aAz(), this);
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
    ac.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bar)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      hSw = paramArrayOfByte.ERC;
      ac.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(hSw), Integer.valueOf(paramArrayOfByte.DPI) });
      Object localObject = bv.L(paramArrayOfByte.ERB, "summary");
      paramInt1 = hSx;
      if (localObject != null)
      {
        hSk = (String)((Map)localObject).get(".summary.banner");
        hSl = bs.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        ac.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.ERz), paramArrayOfByte.ERB });
        localObject = (baq)((com.tencent.mm.ak.b)paramq).hvr.hvw;
        Iterator localIterator = paramArrayOfByte.ERA.iterator();
        while (localIterator.hasNext())
        {
          paramq = (bzi)localIterator.next();
          if (paramq.DWI.eQU().hashCode() != ((baq)localObject).BaseRequest.DWI.eQU().hashCode())
          {
            hSA = paramq.Fok;
            ac.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(hSA) });
            localObject = bv.L(paramq.Fol, "wording");
            ac.d("MicroMsg.NetSceneGetOnlineInfo", paramq.Fol);
            if (localObject != null)
            {
              hSm = (String)((Map)localObject).get(".wording.title");
              hSn = (String)((Map)localObject).get(".wording.notify");
              hSo = (String)((Map)localObject).get(".wording.mute_title");
              hSp = (String)((Map)localObject).get(".wording.mute_tips");
              hSt = (String)((Map)localObject).get(".wording.exit_confirm");
              hSq = (String)((Map)localObject).get(".wording.lock_title");
              hSr = (String)((Map)localObject).get(".wording.mute_lock_title");
              hSs = (String)((Map)localObject).get(".wording.exit");
              hSu = (String)((Map)localObject).get(".wording.usage_link");
            }
            paramInt1 = paramq.Fon;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.DPI;
      hSy = i;
      if ((i & 0x2) == 0)
      {
        hSz = true;
        if (paramInt1 != hSx)
        {
          hSx = paramInt1;
          az.ayM();
          c.afU();
        }
        if ((paramArrayOfByte.DPI & 0x40) != 0)
        {
          az.ayM();
          paramArrayOfByte = c.awB().aNt("filehelper");
          if (paramArrayOfByte != null)
          {
            paramq = paramArrayOfByte;
            if (!bs.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            ae.E(paramArrayOfByte);
            az.ayM();
            paramq = c.awB().aNt("filehelper");
          }
          if ((paramq != null) && (!com.tencent.mm.n.b.ln(paramq.field_type)))
          {
            paramq.aaf();
            az.ayM();
            c.awB().c(paramq.field_username, paramq);
          }
          az.ayM();
          paramq = c.awG().aNI("filehelper");
          if (paramq != null) {
            break label697;
          }
          paramq = new ap("filehelper");
          paramq.ou(bs.eWj());
          az.ayM();
          c.awG().e(paramq);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(20634);
        return;
        hSz = false;
        break;
        label697:
        paramq.ou(bs.eWj());
        az.ayM();
        c.awG().a(paramq, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */