package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  implements az
{
  private static final int hXH;
  private a hXI;
  private byte[] hXJ;
  private com.tencent.mm.plugin.a.b hXK;
  private e[] hXL;
  private e[] hXM;
  private e[] hXN;
  private e[] hXO;
  private e[] hXP;
  private e[] hXQ;
  private e[] hXR;
  private e[] hXS;
  private e[] hXT;
  private e[] hXU;
  
  static
  {
    AppMethodBeat.i(126773);
    hXH = com.tencent.mm.plugin.a.c.bJ("dscp");
    AppMethodBeat.o(126773);
  }
  
  public d()
  {
    AppMethodBeat.i(126747);
    this.hXJ = null;
    this.hXI = new a();
    AppMethodBeat.o(126747);
  }
  
  private static e[] Fw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(126749);
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue(paramString);
    if (bu.isNullOrNil((String)localObject2))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[] { paramString });
      AppMethodBeat.o(126749);
      return null;
    }
    Object localObject1 = localObject2;
    if (!((String)localObject2).startsWith("[")) {
      localObject1 = "[".concat(String.valueOf(localObject2));
    }
    localObject2 = localObject1;
    if (!((String)localObject1).endsWith("]")) {
      localObject2 = (String)localObject1 + "]";
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[] { paramString, localObject2 });
    try
    {
      paramString = new JSONArray((String)localObject2);
      int j = paramString.length();
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[] { Integer.valueOf(j) });
      localObject1 = new e[j];
      while (i < j)
      {
        localObject1[i] = r(paramString.getJSONObject(i));
        i += 1;
      }
      AppMethodBeat.o(126749);
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + paramString.toString());
      AppMethodBeat.o(126749);
      return null;
    }
    return localObject1;
  }
  
  public static int H(int paramInt, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(126769);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126769);
      return paramInt;
      paramInt = 1;
      continue;
      if (!pi(2)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.o.fB(paramString))
      {
        if (!r.isH265Video(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public static int I(int paramInt, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(126770);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check story video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126770);
      return paramInt;
      paramInt = 1;
      continue;
      if (!pi(3)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.o.fB(paramString))
      {
        if (!r.isH265Video(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public static int a(int paramInt, s params)
  {
    AppMethodBeat.i(126767);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 2) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 130L, 1L, false);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(126767);
      return paramInt;
      paramInt = 1;
      break;
      paramInt = a(params);
      break;
      paramInt = a(params);
      break;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 131L, 1L, false);
    }
  }
  
  private static int a(s params)
  {
    int i = 1;
    AppMethodBeat.i(126768);
    if (!pi(1))
    {
      AppMethodBeat.o(126768);
      return 1;
    }
    com.tencent.mm.modelvideo.o.aNh();
    params = t.HJ(params.getFileName());
    if (!com.tencent.mm.vfs.o.fB(params))
    {
      AppMethodBeat.o(126768);
      return 2;
    }
    if (!r.isH265Video(params)) {}
    for (;;)
    {
      AppMethodBeat.o(126768);
      return i;
      i = 2;
    }
  }
  
  private static VideoTransPara a(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(126757);
    label183:
    int i;
    label369:
    Object localObject;
    String str;
    boolean bool2;
    int j;
    boolean bool1;
    if ((paramInt == 2) || (paramInt == 4) || (paramInt == 1)) {
      switch (paramInt)
      {
      case 3: 
      default: 
        paramVideoTransPara.hYi = 0;
        paramVideoTransPara.hYp = 0;
        paramVideoTransPara.hYj = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwJ, 0);
        paramVideoTransPara.hYk = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwM, 10);
        paramVideoTransPara.hYl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwL, 10);
        paramVideoTransPara.hYo = 0;
        if (paramVideoTransPara.hYj != 0)
        {
          paramVideoTransPara.hkJ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwT, 21);
          paramVideoTransPara.hkK = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwU, 39);
          paramVideoTransPara.hYr = paramVideoTransPara.videoBitrate;
          paramVideoTransPara.hYs = paramInt;
          i = m.aao() & 0xFF;
          if ((i < 30) || (Build.VERSION.SDK_INT <= 25)) {
            paramVideoTransPara.hYi = 0;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "ABA: Prams abaSwitch: [%d]  qpSwitch: [%d] abaUpgear: [%d] abaDowngear: [%d] ceilingVideoBR: [%d] flooringVideoBR:[%d] minQP: [%d] maxQP: [%d] CPUlevel: [%d] AndroidVersionSDK: [%d] remuxSecene: [%d] isEnable720p: [%d] maxVideoSize: [%d]", new Object[] { Integer.valueOf(paramVideoTransPara.hYi), Integer.valueOf(paramVideoTransPara.hYj), Integer.valueOf(paramVideoTransPara.hYk), Integer.valueOf(paramVideoTransPara.hYl), Integer.valueOf(paramVideoTransPara.hYm), Integer.valueOf(paramVideoTransPara.hYn), Integer.valueOf(paramVideoTransPara.hkJ), Integer.valueOf(paramVideoTransPara.hkK), Integer.valueOf(i), Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramVideoTransPara.hYs), Integer.valueOf(paramVideoTransPara.hYp), Integer.valueOf(paramVideoTransPara.hYq) });
          localObject = ay.aRW("HardcoderQP");
          if (localObject != null)
          {
            str = ((ay)localObject).decodeString("HCMinQPKey", null);
            localObject = ((ay)localObject).decodeString("HCMaxQPKey", null);
            if ((str != null) && (localObject != null))
            {
              bool2 = false;
              i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwJ, 0);
              j = com.tencent.mm.compatible.deviceinfo.ae.geT.gdQ;
              if (j != 0) {
                break label1034;
              }
              bool1 = true;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, forceHWQP:%s, qpSwitch:%s, deviceQPCfg:%s, forceHWQPOff:%s", new Object[] { str, localObject, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if ((!bool1) && ((bool2) || ((i & 0x2) != 0)))
      {
        j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwT, 21);
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwU, 39);
        j = Math.max(0, Math.min(51, j));
        i = Math.max(0, Math.min(51, i));
        if ((j != 0) && (i != 51))
        {
          paramVideoTransPara.hkJ = j;
          paramVideoTransPara.hkK = i;
          paramVideoTransPara.hYi = 0;
          paramVideoTransPara.hYj |= 0x2;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, value: minQP:%d, maxQP:%d, Scence:%d", new Object[] { str, localObject, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        }
      }
      AppMethodBeat.o(126757);
      return paramVideoTransPara;
      paramVideoTransPara.hYi = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwG, 0);
      paramVideoTransPara.hYp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwW, 0);
      paramVideoTransPara.hYm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwN, 10);
      paramVideoTransPara.hYn = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwO, 10);
      paramVideoTransPara.hYq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwP, 10);
      break;
      paramVideoTransPara.hYi = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwH, 0);
      paramVideoTransPara.hYp = 0;
      paramVideoTransPara.hYm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwQ, 10);
      paramVideoTransPara.hYn = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwR, 10);
      paramVideoTransPara.hYq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwS, 10);
      break;
      paramVideoTransPara.hYi = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwI, 0);
      paramVideoTransPara.hYp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwV, 0);
      paramVideoTransPara.hYm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwN, 10);
      paramVideoTransPara.hYn = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwO, 10);
      paramVideoTransPara.hYq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwP, 10);
      break;
      paramVideoTransPara.hkJ = 0;
      paramVideoTransPara.hkK = 51;
      break label183;
      paramVideoTransPara.hYi = 0;
      paramVideoTransPara.hYj = 0;
      paramVideoTransPara.hYr = paramVideoTransPara.videoBitrate;
      paramVideoTransPara.hkJ = 0;
      paramVideoTransPara.hkK = 51;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "ABA: it does not use the ABA or MinMax QP Limitation");
      break label369;
      label1034:
      if ((paramInt > 0) && (paramInt <= 3) && (j > 0) && ((1 << paramInt - 1 & j) != 0))
      {
        bool2 = true;
        bool1 = false;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5, PInt paramPInt6)
  {
    AppMethodBeat.i(126751);
    if ((bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString3)) || (bu.isNullOrNil(paramString4)))
    {
      AppMethodBeat.o(126751);
      return false;
    }
    try
    {
      int i;
      if (!bu.isNullOrNil(paramString1))
      {
        arrayOfString = paramString1.split("~");
        paramPInt1.value = bu.getInt(arrayOfString[0], -1);
        paramPInt2.value = bu.getInt(arrayOfString[1], -1);
        if (paramPInt1.value >= 0)
        {
          i = paramPInt2.value;
          if (i >= 0) {}
        }
        else
        {
          AppMethodBeat.o(126751);
          return false;
        }
      }
      else
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
      }
      String[] arrayOfString = paramString2.split("x");
      paramPInt3.value = bu.getInt(arrayOfString[0], -1);
      paramPInt4.value = bu.getInt(arrayOfString[1], -1);
      if (paramPInt3.value >= 0)
      {
        i = paramPInt4.value;
        if (i >= 0) {}
      }
      else
      {
        AppMethodBeat.o(126751);
        return false;
      }
      paramPInt5.value = bu.getInt(paramString3, -1);
      paramPInt6.value = bu.getInt(paramString4, -1);
      if (paramPInt5.value >= 0)
      {
        i = paramPInt6.value;
        if (i >= 0) {}
      }
      else
      {
        AppMethodBeat.o(126751);
        return false;
      }
      paramPInt6.value *= 1000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreVideoControl", "parse video para error." + localException.toString());
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramPInt3.value), Integer.valueOf(paramPInt4.value), Integer.valueOf(paramPInt5.value), Integer.valueOf(paramPInt6.value) });
    AppMethodBeat.o(126751);
    return true;
  }
  
  public static d aHh()
  {
    AppMethodBeat.i(126748);
    d locald = (d)u.ap(d.class);
    AppMethodBeat.o(126748);
    return locald;
  }
  
  private static VideoTransPara aHp()
  {
    AppMethodBeat.i(126762);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = 720;
    localVideoTransPara.height = 1280;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.hpl = 10;
    localVideoTransPara.audioBitrate = 64000;
    localVideoTransPara.hXW = 2;
    localVideoTransPara.hXX = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(126762);
    return localVideoTransPara;
  }
  
  private static VideoTransPara aHq()
  {
    AppMethodBeat.i(169099);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = 1072;
    localVideoTransPara.height = ((int)(localVideoTransPara.width * 3.5F / 3.0D));
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.hpl = 1;
    localVideoTransPara.audioBitrate = 128000;
    localVideoTransPara.hXW = 2;
    localVideoTransPara.hXX = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(169099);
    return localVideoTransPara;
  }
  
  public static boolean aHr()
  {
    AppMethodBeat.i(126764);
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQC, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100136");
    if (localc.isValid()) {}
    for (int i = bu.getInt((String)localc.fsy().get("streamingDownload"), 0);; i = 0)
    {
      boolean bool2 = aHt();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(126764);
        return bool1;
        if (j > 0) {
          bool1 = true;
        } else if (i > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean aHs()
  {
    AppMethodBeat.i(126765);
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQC, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100153");
    if (localc.isValid()) {}
    for (int i = bu.getInt((String)localc.fsy().get("snsStreamDownload"), 0);; i = 0)
    {
      boolean bool2 = aHt();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(126765);
        return bool1;
        if (j > 0) {
          bool1 = true;
        } else if (i > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean aHt()
  {
    AppMethodBeat.i(126766);
    long l = bu.HQ();
    int k = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQC, Integer.valueOf(-1))).intValue();
    Object localObject1 = com.tencent.mm.model.c.d.aDI().xi("100190");
    Object localObject2;
    int i;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject2 = ((com.tencent.mm.storage.c)localObject1).fsy();
      i = bu.getInt((String)((Map)localObject2).get("player"), 1);
      localObject1 = (String)((Map)localObject2).get("apilevel");
      localObject2 = (String)((Map)localObject2).get("devices");
    }
    for (;;)
    {
      int m = Build.VERSION.SDK_INT;
      String str = Build.BRAND + Build.MODEL;
      String[] arrayOfString;
      int n;
      int j;
      if (!bu.isNullOrNil((String)localObject1))
      {
        arrayOfString = ((String)localObject1).split(";");
        n = arrayOfString.length;
        j = 0;
        if (j < n) {
          if (bu.getInt(arrayOfString[j], 0) != m) {}
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bu.isNullOrNil((String)localObject2))
        {
          arrayOfString = ((String)localObject2).split(";");
          n = arrayOfString.length;
          j = 0;
        }
        for (;;)
        {
          bool2 = bool1;
          if (j < n)
          {
            if (arrayOfString[j].equalsIgnoreCase(str)) {
              bool2 = false;
            }
          }
          else
          {
            if (com.tencent.mm.compatible.util.d.lB(18)) {
              bool2 = false;
            }
            if (Build.BRAND.equalsIgnoreCase("meizu")) {
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISo, Boolean.TRUE);
            }
            if (k == 0) {
              bool2 = false;
            }
            if (i <= 0) {
              bool2 = false;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(m), localObject1, str, localObject2, Integer.valueOf(i), Long.valueOf(bu.aO(l)) });
            AppMethodBeat.o(126766);
            return bool2;
            j += 1;
            break;
          }
          j += 1;
        }
      }
      localObject2 = null;
      localObject1 = null;
      i = 1;
    }
  }
  
  public static boolean aHu()
  {
    AppMethodBeat.i(126771);
    String str = null;
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100253");
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      str = (String)((com.tencent.mm.storage.c)localObject).fsy().get("noCompleteRange");
    }
    localObject = str;
    if (bu.isNullOrNil(str)) {
      localObject = "20:00-23:30";
    }
    com.tencent.mm.kernel.g.ajP();
    int i = i.cf(com.tencent.mm.kernel.a.getUin(), 30);
    boolean bool = b.an((String)localObject, i);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[] { Boolean.valueOf(bool), localObject, Integer.valueOf(i) });
    if (!bool)
    {
      AppMethodBeat.o(126771);
      return true;
    }
    AppMethodBeat.o(126771);
    return false;
  }
  
  public static int b(VideoTransPara paramVideoTransPara)
  {
    if (paramVideoTransPara == null) {
      return 0;
    }
    switch (paramVideoTransPara.duration)
    {
    default: 
      return paramVideoTransPara.duration;
    }
    return 1;
  }
  
  private static VideoTransPara ph(int paramInt)
  {
    AppMethodBeat.i(126763);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.hpl = 1;
    localVideoTransPara.audioBitrate = 48000;
    localVideoTransPara.hXW = 2;
    localVideoTransPara.hXX = 1;
    localVideoTransPara.audioChannelCount = 1;
    if (paramInt <= 120)
    {
      localVideoTransPara.fps = 30;
      localVideoTransPara.width = 540;
      localVideoTransPara.height = 960;
    }
    for (localVideoTransPara.videoBitrate = 1200000;; localVideoTransPara.videoBitrate = 544000)
    {
      AppMethodBeat.o(126763);
      return localVideoTransPara;
      localVideoTransPara.fps = 24;
      localVideoTransPara.width = 360;
      localVideoTransPara.height = 640;
    }
  }
  
  public static boolean pi(int paramInt)
  {
    AppMethodBeat.i(126772);
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUb, Integer.valueOf(-1))).intValue();
    int i = j;
    if (j == -1) {
      if (!com.tencent.mm.plugin.o.f.dpm()) {
        break label91;
      }
    }
    label91:
    for (i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUb, Integer.valueOf(i));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        break;
      }
      AppMethodBeat.o(126772);
      return false;
    }
    i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("VideoDownloadH265Flag", 0);
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      j = com.tencent.mm.compatible.deviceinfo.ae.geX.gcn;
      if (j != -1) {
        if (j == 1) {
          bool1 = true;
        }
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevc, scene:%s, flag:%s, configResult:%s, dynamicConfigResult:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j) });
      boolean bool2 = bool1;
      if (paramInt == 2)
      {
        bool2 = bool1;
        if (bool1)
        {
          String str1 = Build.MODEL.toLowerCase();
          String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxT, "");
          bool2 = bool1;
          if (!bu.isNullOrNil(str2))
          {
            bool2 = bool1;
            if (str2.contains(str1))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "model %s is hit, expt:%s", new Object[] { str1, str2 });
              bool2 = false;
            }
          }
        }
      }
      AppMethodBeat.o(126772);
      return bool2;
      if ((i & 0x2) != 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      if ((i & 0x4) != 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      if ((i & 0x1) != 0)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      if ((i & 0x8) != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        if (!j.DEBUG) {
          break label382;
        }
        bool1 = true;
        break;
      }
      label382:
      break;
      bool1 = false;
    }
  }
  
  private static e r(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126750);
    e locale = new e();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1;
        int j;
        if (paramJSONObject.isNull("time"))
        {
          localObject1 = "";
          Object localObject3 = paramJSONObject.getString("abr");
          Object localObject4 = paramJSONObject.getString("intval");
          Object localObject5 = paramJSONObject.getString("prof");
          Object localObject6 = paramJSONObject.getString("preset");
          if (paramJSONObject.isNull("stepbr"))
          {
            localObject2 = "0";
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[] { localObject1, localObject3, localObject4, localObject5, localObject6, localObject2 });
            locale.a((String)localObject1, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject2);
            localObject2 = paramJSONObject.getJSONArray("conf");
            localObject1 = new ArrayList();
            localObject3 = new PInt();
            localObject4 = new PInt();
            localObject5 = new PInt();
            localObject6 = new PInt();
            PInt localPInt1 = new PInt();
            PInt localPInt2 = new PInt();
            j = ((JSONArray)localObject2).length();
            i = 0;
            if (i >= j) {
              continue;
            }
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            if (localJSONObject.isNull("dura")) {
              break label537;
            }
            paramJSONObject = localJSONObject.getString("dura");
            if (!a(paramJSONObject, localJSONObject.getString("wh"), localJSONObject.getString("fps"), localJSONObject.getString("vbr"), (PInt)localObject3, (PInt)localObject4, (PInt)localObject5, (PInt)localObject6, localPInt1, localPInt2)) {
              break label530;
            }
            ((List)localObject1).add(new f(((PInt)localObject3).value, ((PInt)localObject4).value, ((PInt)localObject5).value, ((PInt)localObject6).value, localPInt1.value, localPInt2.value, localPInt2.value));
            break label530;
          }
        }
        else
        {
          localObject1 = paramJSONObject.getString("time");
          continue;
        }
        Object localObject2 = paramJSONObject.getString("stepbr");
        continue;
        Collections.sort((List)localObject1);
        if ((((List)localObject1).size() >= 2) && (!locale.hXY))
        {
          j = ((f)((List)localObject1).get(0)).hYg;
          i = 1;
          if (i < ((List)localObject1).size())
          {
            paramJSONObject = (f)((List)localObject1).get(i);
            paramJSONObject.hYf = j;
            j = paramJSONObject.hYg;
            i += 1;
            continue;
          }
        }
        locale.hXZ = new f[((List)localObject1).size()];
        ((List)localObject1).toArray(locale.hXZ);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[] { locale });
        AppMethodBeat.o(126750);
        return locale;
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + paramJSONObject.toString());
        AppMethodBeat.o(126750);
        return null;
      }
      label530:
      i += 1;
      continue;
      label537:
      paramJSONObject = "";
    }
  }
  
  public final boolean Fx(String paramString)
  {
    AppMethodBeat.i(126753);
    if (this.hXK == null) {
      this.hXK = new com.tencent.mm.plugin.a.b();
    }
    localObject1 = this.hXK;
    ((com.tencent.mm.plugin.a.b)localObject1).iTc = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).iTe = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).iTf = null;
    long l1 = bu.HQ();
    long l2 = this.hXK.Jy(paramString);
    if (l2 <= 0L)
    {
      AppMethodBeat.o(126753);
      return false;
    }
    localObject2 = null;
    localObject1 = null;
    localObject6 = null;
    Object localObject7 = null;
    try
    {
      localRandomAccessFile = com.tencent.mm.vfs.o.dg(paramString, false);
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      localRandomAccessFile.seek(l2);
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      byte[] arrayOfByte = new byte[8];
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      localObject3 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, com.tencent.mm.plugin.a.a.bmo);
      Object localObject4;
      Object localObject5;
      for (localObject1 = null;; localObject1 = localObject5)
      {
        localObject4 = localObject1;
        if (localObject3 == null) {
          break;
        }
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject5 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, hXH);
        localObject4 = localObject5;
        if (localObject5 != null) {
          break;
        }
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localRandomAccessFile.seek(((com.tencent.mm.plugin.a.a)localObject3).getEndPos());
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject3 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, com.tencent.mm.plugin.a.a.bmo);
      }
      localObject3 = localObject7;
      if (localObject4 != null)
      {
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject5 = new byte[(int)localObject4.getSize() - 8];
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localRandomAccessFile.seek(localObject4.iTb + 8L);
        localObject3 = localObject7;
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        if (localRandomAccessFile.read((byte[])localObject5) > 0)
        {
          localObject1 = localRandomAccessFile;
          localObject2 = localRandomAccessFile;
          localObject3 = new String((byte[])localObject5, "UTF-8");
        }
      }
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RandomAccessFile localRandomAccessFile;
        Object localObject3;
        boolean bool;
        localObject2 = localObject1;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[] { paramString, localException.toString() });
        localObject2 = localObject6;
        if (localObject1 != null) {
          try
          {
            ((RandomAccessFile)localObject1).close();
            localObject2 = localObject6;
          }
          catch (IOException localIOException1)
          {
            localObject2 = localObject6;
          }
        }
      }
    }
    finally
    {
      if (localObject2 == null) {}
    }
    try
    {
      localRandomAccessFile.close();
      localObject2 = localObject3;
    }
    catch (IOException localIOException2)
    {
      try
      {
        localObject2.close();
        AppMethodBeat.o(126753);
        throw paramString;
        AppMethodBeat.o(126753);
        return false;
        localIOException2 = localIOException2;
        localObject2 = localException;
      }
      catch (IOException localIOException3)
      {
        break label486;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[] { localObject2, Long.valueOf(l2), Long.valueOf(bu.aO(l1)), paramString });
    if (!bu.isNullOrNil(localObject2))
    {
      bool = localObject2.contains("WXVer");
      AppMethodBeat.o(126753);
      return bool;
    }
  }
  
  public final VideoTransPara aHi()
  {
    AppMethodBeat.i(126754);
    long l = bu.HQ();
    if (this.hXL == null) {
      this.hXL = Fw("C2CRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.hXL != null)
    {
      i = 0;
      if (i < this.hXL.length)
      {
        localObject = this.hXL[i];
        if ((localObject != null) && (((e)localObject).aHv()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
          localVideoTransPara = ((e)localObject).aHw();
        }
      }
    }
    for (boolean bool = ((e)localObject).hXY;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = new VideoTransPara();
        ((VideoTransPara)localObject).isDefault = true;
        ((VideoTransPara)localObject).width = 540;
        ((VideoTransPara)localObject).height = 960;
        ((VideoTransPara)localObject).fps = 30;
        ((VideoTransPara)localObject).videoBitrate = 1200000;
        ((VideoTransPara)localObject).hpl = 10;
        ((VideoTransPara)localObject).audioBitrate = 64000;
        ((VideoTransPara)localObject).hXW = 2;
        ((VideoTransPara)localObject).hXX = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).hpl = 10;
      localVideoTransPara = a((VideoTransPara)localObject, 1);
      localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwq, 10);
      if (!bool) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 11L, 1L, false);
      }
      for (;;)
      {
        i = bu.o((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 13, 18));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, i, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bu.aO(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126754);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 12L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aHj()
  {
    AppMethodBeat.i(126755);
    long l = bu.HQ();
    if (this.hXM == null) {
      this.hXM = Fw("SnsRecordVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.hXM != null)
    {
      i = 0;
      if (i < this.hXM.length)
      {
        locale = this.hXM[i];
        if ((locale != null) && (locale.aHv()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = locale.aHw();
        }
      }
    }
    for (boolean bool = locale.hXY;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = aHp();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.hpl = 10;
        localVideoTransPara.hYh = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwo, 10);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = bu.o((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, i, 1L, false);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bu.aO(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126755);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aHk()
  {
    AppMethodBeat.i(126756);
    long l = bu.HQ();
    if (this.hXN == null) {
      this.hXN = Fw("SnsAlbumVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.hXN != null)
    {
      i = 0;
      if (i < this.hXN.length)
      {
        locale = this.hXN[i];
        if ((locale != null) && (locale.aHv()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
          localVideoTransPara = locale.aHw();
        }
      }
    }
    for (boolean bool = locale.hXY;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = aHp();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.hpl = 10;
        localVideoTransPara.hYh = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwp, 10);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 21L, 1L, false);
        }
        for (;;)
        {
          i = bu.o((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 23, 28));
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, i, 1L, false);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[] { Long.valueOf(bu.aO(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126756);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 22L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aHl()
  {
    AppMethodBeat.i(126758);
    long l = bu.HQ();
    if (this.hXO == null) {
      this.hXO = Fw("StoryRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.hXO != null)
    {
      i = 0;
      if (i < this.hXO.length)
      {
        localObject = this.hXO[i];
        if ((localObject != null) && (((e)localObject).aHv()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
          localVideoTransPara = ((e)localObject).aHw();
        }
      }
    }
    for (boolean bool = ((e)localObject).hXY;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = new VideoTransPara();
        ((VideoTransPara)localObject).isDefault = true;
        ((VideoTransPara)localObject).width = 720;
        ((VideoTransPara)localObject).height = 1280;
        ((VideoTransPara)localObject).fps = 30;
        ((VideoTransPara)localObject).videoBitrate = 3500000;
        ((VideoTransPara)localObject).hpl = 10;
        ((VideoTransPara)localObject).audioBitrate = 48000;
        ((VideoTransPara)localObject).hXW = 2;
        ((VideoTransPara)localObject).hXX = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).hpl = 10;
      ((VideoTransPara)localObject).hYh = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 3);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxM, 15);
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = bu.o((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, i, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bu.aO(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126758);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aHm()
  {
    AppMethodBeat.i(169097);
    long l = bu.HQ();
    if (this.hXP == null) {
      this.hXP = Fw("FinderRecordVideoConfig");
    }
    int i;
    if (this.hXP != null)
    {
      i = 0;
      if (i < this.hXP.length)
      {
        localObject1 = this.hXP[i];
        if ((localObject1 != null) && (((e)localObject1).aHv())) {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((e)localObject1).aHx();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aHq();
      }
      if (com.tencent.mm.sdk.platformtools.ae.getLogLevel() <= 1)
      {
        i = ak.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).hYh = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGT, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGU, 3);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(bu.aO(l)), localObject1 });
      AppMethodBeat.o(169097);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara aHn()
  {
    AppMethodBeat.i(169098);
    long l = bu.HQ();
    if (this.hXQ == null) {
      this.hXQ = Fw("FinderPublishVideoConfig");
    }
    int i;
    if (this.hXQ != null)
    {
      i = 0;
      if (i < this.hXQ.length)
      {
        localObject1 = this.hXQ[i];
        if ((localObject1 != null) && (((e)localObject1).aHv())) {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((e)localObject1).aHx();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aHq();
      }
      if (com.tencent.mm.sdk.platformtools.ae.getLogLevel() <= 1)
      {
        i = ak.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).hYh = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGV, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGW, 3);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(bu.aO(l)), localObject1 });
      AppMethodBeat.o(169098);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara aHo()
  {
    AppMethodBeat.i(126761);
    long l = bu.HQ();
    if (this.hXU == null) {
      this.hXU = Fw("NearbyRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.hXU != null)
    {
      i = 0;
      if (i < this.hXU.length)
      {
        localObject = this.hXU[i];
        if ((localObject != null) && (((e)localObject).aHv()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
          localVideoTransPara = ((e)localObject).aHw();
        }
      }
    }
    for (boolean bool = ((e)localObject).hXY;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null) {
        localObject = aHp();
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).hpl = 10;
      ((VideoTransPara)localObject).hYh = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 2);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = 10;
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = bu.o((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, i, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bu.aO(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126761);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara c(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(126760);
    if (paramVideoTransPara == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
      AppMethodBeat.o(126760);
      return null;
    }
    if (paramVideoTransPara.duration >= 300)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(126760);
      return null;
    }
    long l = bu.HQ();
    VideoTransPara localVideoTransPara = ph(paramVideoTransPara.duration);
    boolean bool = true;
    int i = 1;
    Object localObject1 = com.tencent.mm.model.c.d.aDI().xi("100157");
    if (((com.tencent.mm.storage.c)localObject1).isValid()) {
      i = bu.getInt((String)((com.tencent.mm.storage.c)localObject1).fsy().get("VideoEncodeStep"), 1);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      i = 1;
      if (i == 0) {
        break label402;
      }
      if (this.hXT == null) {
        this.hXT = Fw("C2CAlbumVideoStepConfig");
      }
      localObject1 = this.hXT;
      label176:
      if (localObject1 == null) {
        break label440;
      }
      i = 0;
      label183:
      if (i >= localObject1.length) {
        break label435;
      }
      Object localObject2 = localObject1[i];
      if ((localObject2 == null) || (!localObject2.aHv())) {
        break label428;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
      i = a.a(localObject2.hXZ, paramVideoTransPara, localVideoTransPara);
      bool = localObject2.hXY;
      label236:
      if (i > 0) {
        break label459;
      }
      localObject1 = ph(paramVideoTransPara.duration);
      label249:
      localObject1 = a((VideoTransPara)localObject1, 1);
      if (bool) {
        break label472;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 1L, 1L, false);
    }
    for (;;)
    {
      int j = bu.o((Integer)com.tencent.mm.plugin.report.service.g.a(((VideoTransPara)localObject1).videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 3, 8));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, j, 1L, false);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(j), Integer.valueOf(i), localObject1, paramVideoTransPara });
      AppMethodBeat.o(126760);
      return localObject1;
      i = 0;
      break;
      label402:
      if (this.hXS == null) {
        this.hXS = Fw("C2CAlbumVideoConfig");
      }
      localObject1 = this.hXS;
      break label176;
      label428:
      i += 1;
      break label183;
      label435:
      i = 0;
      break label236;
      label440:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
      i = a.a(null, paramVideoTransPara, localVideoTransPara);
      break label236;
      label459:
      localVideoTransPara.isDefault = false;
      localObject1 = localVideoTransPara;
      break label249;
      label472:
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(422L, 2L, 1L, false);
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final byte[] getWeixinMeta()
  {
    AppMethodBeat.i(126752);
    if (bu.cF(this.hXJ)) {}
    try
    {
      Object localObject = "{\"WXVer\":" + com.tencent.mm.protocal.d.FFH + "}";
      this.hXJ = ((String)localObject).getBytes("UTF-8");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[] { localObject });
      localObject = this.hXJ;
      AppMethodBeat.o(126752);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease()
  {
    this.hXL = null;
    this.hXT = null;
    this.hXS = null;
    this.hXM = null;
    this.hXN = null;
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final VideoTransPara pg(int paramInt)
  {
    AppMethodBeat.i(126759);
    long l = bu.HQ();
    int i;
    if (this.hXR == null)
    {
      if (paramInt == 1) {
        this.hXR = Fw("GameRecordBigVideoConfig");
      }
    }
    else
    {
      if (this.hXR == null) {
        break label362;
      }
      i = 0;
      label41:
      if (i >= this.hXR.length) {
        break label362;
      }
      localObject1 = this.hXR[i];
      if ((localObject1 == null) || (!((e)localObject1).aHv())) {
        break label266;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get game Record config.");
    }
    label266:
    label273:
    label362:
    for (Object localObject1 = ((e)localObject1).aHw();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramInt != 1) {
          break label273;
        }
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).isDefault = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).hpl = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).hXW = 2;
        ((VideoTransPara)localObject2).hXX = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
      for (((VideoTransPara)localObject2).audioChannelCount = 1;; ((VideoTransPara)localObject2).audioChannelCount = 1)
      {
        ((VideoTransPara)localObject2).audioSampleRate = 44100;
        ((VideoTransPara)localObject2).hpl = 10;
        ((VideoTransPara)localObject2).hYh = 200;
        localObject1 = a((VideoTransPara)localObject2, 1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SubCoreVideoControl", "get game record para cost %d. %s", new Object[] { Long.valueOf(bu.aO(l)), localObject1 });
        AppMethodBeat.o(126759);
        return localObject1;
        this.hXR = Fw("GameRecordVideoConfig");
        break;
        i += 1;
        break label41;
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).isDefault = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).hpl = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).hXW = 2;
        ((VideoTransPara)localObject2).hXX = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.d
 * JD-Core Version:    0.7.0.1
 */