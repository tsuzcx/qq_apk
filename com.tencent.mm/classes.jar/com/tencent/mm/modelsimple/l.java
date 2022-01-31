package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.protocal.c.baf;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class l
  extends m
  implements k
{
  private static int ezA = 0;
  private static int ezB = 22;
  private static int ezC = 0;
  private static boolean ezD = false;
  public static String ezp;
  public static String ezq;
  public static String ezr;
  public static String ezs;
  public static String ezt;
  public static String ezu;
  public static String ezv;
  public static String ezw;
  public static String ezx;
  public static String ezy;
  private static int ezz;
  private f dmL;
  
  public l(int paramInt)
  {
    ezz = paramInt;
  }
  
  public static int Qr()
  {
    return ezA;
  }
  
  public static boolean Qs()
  {
    return (ezC & 0x2) != 0;
  }
  
  public static boolean Qt()
  {
    return (ezB & 0x4) != 0;
  }
  
  public static int Qu()
  {
    return ezz;
  }
  
  public static boolean Qv()
  {
    return (ezC & 0x200) != 0;
  }
  
  public static boolean Qw()
  {
    return (ezC & 0x400) != 0;
  }
  
  public static void ca(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ezB |= 0x4;
      return;
    }
    ezB &= 0xFFFFFFFB;
  }
  
  public static boolean jb(int paramInt)
  {
    return ezz != paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    b.a locala = new b.a();
    ahs localahs = new ahs();
    localahs.jxi = x.cqJ();
    y.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localahs.jxi });
    locala.ecH = localahs;
    locala.ecI = new aht();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.ecG = 526;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmL = paramf;
    return a(parame, locala.Kt(), this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (aht)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      ezA = paramArrayOfByte.tfl;
      y.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(ezA), Integer.valueOf(paramArrayOfByte.svx) });
      Object localObject = bn.s(paramArrayOfByte.tfk, "summary");
      paramInt1 = ezB;
      if (localObject != null)
      {
        ezp = (String)((Map)localObject).get(".summary.banner");
        y.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.tfi), paramArrayOfByte.tfk });
        localObject = (ahs)((com.tencent.mm.ah.b)paramq).ecE.ecN;
        Iterator localIterator = paramArrayOfByte.tfj.iterator();
        while (localIterator.hasNext())
        {
          paramq = (baf)localIterator.next();
          if (paramq.sAk.coM().hashCode() != ((ahs)localObject).tEX.sAk.coM().hashCode())
          {
            localObject = bn.s(paramq.twf, "wording");
            y.d("MicroMsg.NetSceneGetOnlineInfo", paramq.twf);
            if (localObject != null)
            {
              ezq = (String)((Map)localObject).get(".wording.title");
              ezr = (String)((Map)localObject).get(".wording.notify");
              ezs = (String)((Map)localObject).get(".wording.mute_title");
              ezt = (String)((Map)localObject).get(".wording.mute_tips");
              ezu = (String)((Map)localObject).get(".wording.exit");
              ezv = (String)((Map)localObject).get(".wording.exit_confirm");
              ezw = (String)((Map)localObject).get(".wording.lock_title");
              ezx = (String)((Map)localObject).get(".wording.mute_lock_title");
              ezy = (String)((Map)localObject).get(".wording.exit");
            }
            paramInt1 = paramq.twh;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.svx;
      ezC = i;
      if ((i & 0x2) == 0)
      {
        ezD = true;
        if (paramInt1 != ezB)
        {
          ezB = paramInt1;
          au.Hx();
          c.CY();
        }
        if ((paramArrayOfByte.svx & 0x40) != 0)
        {
          au.Hx();
          paramArrayOfByte = c.Fw().abl("filehelper");
          if (paramArrayOfByte != null)
          {
            paramq = paramArrayOfByte;
            if (!bk.bl(paramArrayOfByte.field_username)) {}
          }
          else
          {
            aa.x(paramArrayOfByte);
            au.Hx();
            paramq = c.Fw().abl("filehelper");
          }
          if ((paramq != null) && (!a.gR(paramq.field_type)))
          {
            paramq.AH();
            au.Hx();
            c.Fw().a(paramq.field_username, paramq);
          }
          au.Hx();
          paramq = c.FB().abv("filehelper");
          if (paramq != null) {
            break label631;
          }
          paramq = new ak("filehelper");
          paramq.ba(bk.UY());
          au.Hx();
          c.FB().d(paramq);
        }
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        ezD = false;
        break;
        label631:
        paramq.ba(bk.UY());
        au.Hx();
        c.FB().a(paramq, "filehelper");
      }
    }
  }
  
  public final int getType()
  {
    return 526;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.l
 * JD-Core Version:    0.7.0.1
 */