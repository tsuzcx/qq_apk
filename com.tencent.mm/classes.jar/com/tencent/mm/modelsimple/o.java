package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class o
  extends q
  implements m
{
  public static String lZA;
  public static String lZB;
  public static String lZC;
  public static String lZD;
  public static String lZE;
  public static String lZF;
  public static String lZG;
  public static String lZH;
  private static int lZI;
  private static int lZJ = -1;
  private static int lZK = 22;
  private static int lZL = 0;
  private static boolean lZM = false;
  private static int lZN = 0;
  private static int lZO = 0;
  public static String lZx;
  public static String lZy;
  public static String lZz;
  private i callback;
  
  public o(int paramInt)
  {
    lZI = paramInt;
  }
  
  public static int bob()
  {
    return lZO;
  }
  
  public static int bor()
  {
    return lZJ;
  }
  
  public static boolean bos()
  {
    return (lZL & 0x2) != 0;
  }
  
  public static boolean bot()
  {
    return (lZK & 0x4) != 0;
  }
  
  public static int bou()
  {
    return lZI;
  }
  
  public static int bov()
  {
    return lZN;
  }
  
  public static boolean bow()
  {
    return (lZL & 0x200) != 0;
  }
  
  public static boolean box()
  {
    return (lZL & 0x400) != 0;
  }
  
  public static boolean boy()
  {
    return (lZL & 0x20) != 0;
  }
  
  public static void gw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      lZK |= 0x4;
      return;
    }
    lZK &= 0xFFFFFFFB;
  }
  
  public static boolean wK(int paramInt)
  {
    return lZI != paramInt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20633);
    d.a locala = new d.a();
    bzc localbzc = new bzc();
    localbzc.vhq = LocaleUtil.getApplicationLanguage();
    Log.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localbzc.vhq });
    locala.lBU = localbzc;
    locala.lBV = new bzd();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.callback = parami;
    int i = dispatch(paramg, locala.bgN(), this);
    AppMethodBeat.o(20633);
    return i;
  }
  
  public final int getType()
  {
    return 526;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20634);
    Log.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bzd)d.c.b(((com.tencent.mm.an.d)params).lBS);
      lZJ = paramArrayOfByte.Tig;
      Log.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(lZJ), Integer.valueOf(paramArrayOfByte.RIs) });
      Object localObject = XmlParser.parseXml(paramArrayOfByte.Tif, "summary", null);
      paramInt1 = lZK;
      if (localObject != null)
      {
        lZx = (String)((Map)localObject).get(".summary.banner");
        lZy = Util.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        Log.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.Tid), paramArrayOfByte.Tif });
        localObject = (bzc)d.b.b(((com.tencent.mm.an.d)params).lBR);
        Iterator localIterator = paramArrayOfByte.Tie.iterator();
        while (localIterator.hasNext())
        {
          params = (dek)localIterator.next();
          if (params.RPd.Ap().hashCode() != ((bzc)localObject).BaseRequest.RPd.Ap().hashCode())
          {
            lZN = params.TMc;
            Log.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(lZN) });
            localObject = XmlParser.parseXml(params.TMd, "wording", null);
            Log.d("MicroMsg.NetSceneGetOnlineInfo", params.TMd);
            if (localObject != null)
            {
              lZz = (String)((Map)localObject).get(".wording.title");
              lZA = (String)((Map)localObject).get(".wording.notify");
              lZB = (String)((Map)localObject).get(".wording.mute_title");
              lZC = (String)((Map)localObject).get(".wording.mute_tips");
              lZG = (String)((Map)localObject).get(".wording.exit_confirm");
              lZD = (String)((Map)localObject).get(".wording.lock_title");
              lZE = (String)((Map)localObject).get(".wording.mute_lock_title");
              lZF = (String)((Map)localObject).get(".wording.exit");
              lZH = (String)((Map)localObject).get(".wording.usage_link");
            }
            paramInt1 = params.TMf;
            lZO = params.RPe;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.RIs;
      lZL = i;
      if ((i & 0x2) == 0)
      {
        lZM = true;
        if (paramInt1 != lZK)
        {
          lZK = paramInt1;
          bh.beI();
          c.aGI();
        }
        paramInt1 = paramArrayOfByte.RIs;
        i = paramArrayOfByte.Tig;
        if (((paramInt1 & 0x40) != 0) || (7 == i) || (8 == i))
        {
          bh.beI();
          paramArrayOfByte = c.bbL().RG("filehelper");
          if (paramArrayOfByte != null)
          {
            params = paramArrayOfByte;
            if (!Util.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            ak.S(paramArrayOfByte);
            bh.beI();
            params = c.bbL().RG("filehelper");
          }
          if ((params != null) && (!com.tencent.mm.contact.d.rk(params.field_type)))
          {
            params.axk();
            bh.beI();
            c.bbL().c(params.field_username, params);
          }
          bh.beI();
          params = c.bbR().bwx("filehelper");
          if (params != null) {
            break label731;
          }
          params = new az("filehelper");
          params.EB(Util.nowMilliSecond());
          bh.beI();
          c.bbR().e(params);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(20634);
        return;
        lZM = false;
        break;
        label731:
        params.EB(Util.nowMilliSecond());
        bh.beI();
        c.bbR().a(params, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */