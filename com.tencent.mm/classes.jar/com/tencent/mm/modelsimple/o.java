package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.jr;
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
  public static String jjB;
  public static String jjC;
  public static String jjD;
  public static String jjE;
  public static String jjF;
  public static String jjG;
  public static String jjH;
  public static String jjI;
  public static String jjJ;
  public static String jjK;
  public static String jjL;
  private static int jjM;
  private static int jjN = -1;
  private static int jjO = 22;
  private static int jjP = 0;
  private static boolean jjQ = false;
  private static int jjR = 0;
  private static int jjS = 0;
  private i callback;
  
  public o(int paramInt)
  {
    jjM = paramInt;
  }
  
  public static int beM()
  {
    return jjS;
  }
  
  public static int bfc()
  {
    return jjN;
  }
  
  public static boolean bfd()
  {
    return (jjP & 0x2) != 0;
  }
  
  public static boolean bfe()
  {
    return (jjO & 0x4) != 0;
  }
  
  public static int bff()
  {
    return jjM;
  }
  
  public static boolean bfg()
  {
    return (jjP & 0x200) != 0;
  }
  
  public static boolean bfh()
  {
    return (jjP & 0x400) != 0;
  }
  
  public static boolean bfi()
  {
    return (jjP & 0x20) != 0;
  }
  
  public static void fK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jjO |= 0x4;
      return;
    }
    jjO &= 0xFFFFFFFB;
  }
  
  public static int getDeviceType()
  {
    return jjR;
  }
  
  public static boolean tK(int paramInt)
  {
    return jjM != paramInt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20633);
    d.a locala = new d.a();
    brg localbrg = new brg();
    localbrg.rBI = LocaleUtil.getApplicationLanguage();
    Log.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localbrg.rBI });
    locala.iLN = localbrg;
    locala.iLO = new brh();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.callback = parami;
    int i = dispatch(paramg, locala.aXF(), this);
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
      paramArrayOfByte = (brh)((d)params).iLL.iLR;
      jjN = paramArrayOfByte.LYM;
      Log.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(jjN), Integer.valueOf(paramArrayOfByte.KHa) });
      Object localObject = XmlParser.parseXml(paramArrayOfByte.LYL, "summary", null);
      paramInt1 = jjO;
      if (localObject != null)
      {
        jjB = (String)((Map)localObject).get(".summary.banner");
        jjC = Util.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        Log.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s", new Object[] { Integer.valueOf(paramArrayOfByte.LYJ), paramArrayOfByte.LYL });
        localObject = (brg)((d)params).iLK.iLR;
        Iterator localIterator = paramArrayOfByte.LYK.iterator();
        while (localIterator.hasNext())
        {
          params = (cva)localIterator.next();
          if (params.KOi.yO().hashCode() != ((brg)localObject).BaseRequest.KOi.yO().hashCode())
          {
            jjR = params.MAt;
            Log.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(jjR) });
            localObject = XmlParser.parseXml(params.MAu, "wording", null);
            Log.d("MicroMsg.NetSceneGetOnlineInfo", params.MAu);
            if (localObject != null)
            {
              jjD = (String)((Map)localObject).get(".wording.title");
              jjE = (String)((Map)localObject).get(".wording.notify");
              jjF = (String)((Map)localObject).get(".wording.mute_title");
              jjG = (String)((Map)localObject).get(".wording.mute_tips");
              jjK = (String)((Map)localObject).get(".wording.exit_confirm");
              jjH = (String)((Map)localObject).get(".wording.lock_title");
              jjI = (String)((Map)localObject).get(".wording.mute_lock_title");
              jjJ = (String)((Map)localObject).get(".wording.exit");
              jjL = (String)((Map)localObject).get(".wording.usage_link");
            }
            paramInt1 = params.MAw;
            jjS = params.KOj;
          }
        }
      }
    }
    for (;;)
    {
      int i = paramArrayOfByte.KHa;
      jjP = i;
      if ((i & 0x2) == 0)
      {
        jjQ = true;
        if (paramInt1 != jjO)
        {
          jjO = paramInt1;
          bg.aVF();
          com.tencent.mm.model.c.azl();
        }
        paramInt1 = paramArrayOfByte.KHa;
        i = paramArrayOfByte.LYM;
        if (((paramInt1 & 0x40) != 0) || (7 == i) || (8 == i))
        {
          bg.aVF();
          paramArrayOfByte = com.tencent.mm.model.c.aSN().Kn("filehelper");
          if (paramArrayOfByte != null)
          {
            params = paramArrayOfByte;
            if (!Util.isNullOrNil(paramArrayOfByte.field_username)) {}
          }
          else
          {
            ak.L(paramArrayOfByte);
            bg.aVF();
            params = com.tencent.mm.model.c.aSN().Kn("filehelper");
          }
          if ((params != null) && (!com.tencent.mm.contact.c.oR(params.field_type)))
          {
            params.aqQ();
            bg.aVF();
            com.tencent.mm.model.c.aSN().c(params.field_username, params);
          }
          bg.aVF();
          params = com.tencent.mm.model.c.aST().bjY("filehelper");
          if (params != null) {
            break label731;
          }
          params = new az("filehelper");
          params.yA(Util.nowMilliSecond());
          bg.aVF();
          com.tencent.mm.model.c.aST().e(params);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(20634);
        return;
        jjQ = false;
        break;
        label731:
        params.yA(Util.nowMilliSecond());
        bg.aVF();
        com.tencent.mm.model.c.aST().a(params, "filehelper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */