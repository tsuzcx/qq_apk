package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  implements com.tencent.mm.model.ax
{
  private static final int hUP;
  private a hUQ;
  private byte[] hUR;
  private com.tencent.mm.plugin.a.b hUS;
  private e[] hUT;
  private e[] hUU;
  private e[] hUV;
  private e[] hUW;
  private e[] hUX;
  private e[] hUY;
  private e[] hUZ;
  private e[] hVa;
  private e[] hVb;
  private e[] hVc;
  
  static
  {
    AppMethodBeat.i(126773);
    hUP = com.tencent.mm.plugin.a.c.bJ("dscp");
    AppMethodBeat.o(126773);
  }
  
  public d()
  {
    AppMethodBeat.i(126747);
    this.hUR = null;
    this.hUQ = new a();
    AppMethodBeat.o(126747);
  }
  
  private static e[] EU(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(126749);
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue(paramString);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[] { paramString });
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
    ad.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[] { paramString, localObject2 });
    try
    {
      paramString = new JSONArray((String)localObject2);
      int j = paramString.length();
      ad.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[] { Integer.valueOf(j) });
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
      ad.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + paramString.toString());
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
      ad.i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126769);
      return paramInt;
      paramInt = 1;
      continue;
      if (!pf(2)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.i.fv(paramString))
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
      ad.i("MicroMsg.SubCoreVideoControl", "check story video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126770);
      return paramInt;
      paramInt = 1;
      continue;
      if (!pf(3)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.i.fv(paramString))
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
      ad.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 2) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 130L, 1L, false);
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
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 131L, 1L, false);
    }
  }
  
  private static int a(s params)
  {
    int i = 1;
    AppMethodBeat.i(126768);
    if (!pf(1))
    {
      AppMethodBeat.o(126768);
      return 1;
    }
    o.aMJ();
    params = com.tencent.mm.modelvideo.t.Hh(params.getFileName());
    if (!com.tencent.mm.vfs.i.fv(params))
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
        paramVideoTransPara.hVq = 0;
        paramVideoTransPara.hVx = 0;
        paramVideoTransPara.hVr = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqc, 0);
        paramVideoTransPara.hVs = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqf, 10);
        paramVideoTransPara.hVt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqe, 10);
        paramVideoTransPara.hVw = 0;
        if (paramVideoTransPara.hVr != 0)
        {
          paramVideoTransPara.hhV = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqm, 21);
          paramVideoTransPara.hhW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqn, 39);
          paramVideoTransPara.hVz = paramVideoTransPara.videoBitrate;
          paramVideoTransPara.hVA = paramInt;
          i = m.aaf() & 0xFF;
          if ((i < 30) || (Build.VERSION.SDK_INT <= 25)) {
            paramVideoTransPara.hVq = 0;
          }
          ad.i("MicroMsg.SubCoreVideoControl", "ABA: Prams abaSwitch: [%d]  qpSwitch: [%d] abaUpgear: [%d] abaDowngear: [%d] ceilingVideoBR: [%d] flooringVideoBR:[%d] minQP: [%d] maxQP: [%d] CPUlevel: [%d] AndroidVersionSDK: [%d] remuxSecene: [%d] isEnable720p: [%d] maxVideoSize: [%d]", new Object[] { Integer.valueOf(paramVideoTransPara.hVq), Integer.valueOf(paramVideoTransPara.hVr), Integer.valueOf(paramVideoTransPara.hVs), Integer.valueOf(paramVideoTransPara.hVt), Integer.valueOf(paramVideoTransPara.hVu), Integer.valueOf(paramVideoTransPara.hVv), Integer.valueOf(paramVideoTransPara.hhV), Integer.valueOf(paramVideoTransPara.hhW), Integer.valueOf(i), Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramVideoTransPara.hVA), Integer.valueOf(paramVideoTransPara.hVx), Integer.valueOf(paramVideoTransPara.hVy) });
          localObject = com.tencent.mm.sdk.platformtools.ax.aQz("HardcoderQP");
          if (localObject != null)
          {
            str = ((com.tencent.mm.sdk.platformtools.ax)localObject).decodeString("HCMinQPKey", null);
            localObject = ((com.tencent.mm.sdk.platformtools.ax)localObject).decodeString("HCMaxQPKey", null);
            if ((str != null) && (localObject != null))
            {
              bool2 = false;
              i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqc, 0);
              j = ae.gcL.gbI;
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
      ad.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, forceHWQP:%s, qpSwitch:%s, deviceQPCfg:%s, forceHWQPOff:%s", new Object[] { str, localObject, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if ((!bool1) && ((bool2) || ((i & 0x2) != 0)))
      {
        j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqm, 21);
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqn, 39);
        j = Math.max(0, Math.min(51, j));
        i = Math.max(0, Math.min(51, i));
        if ((j != 0) && (i != 51))
        {
          paramVideoTransPara.hhV = j;
          paramVideoTransPara.hhW = i;
          paramVideoTransPara.hVq = 0;
          paramVideoTransPara.hVr |= 0x2;
          ad.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, value: minQP:%d, maxQP:%d, Scence:%d", new Object[] { str, localObject, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        }
      }
      AppMethodBeat.o(126757);
      return paramVideoTransPara;
      paramVideoTransPara.hVq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpZ, 0);
      paramVideoTransPara.hVx = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.xLf, 0);
      paramVideoTransPara.hVu = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqg, 10);
      paramVideoTransPara.hVv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqh, 10);
      paramVideoTransPara.hVy = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqi, 10);
      break;
      paramVideoTransPara.hVq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqa, 0);
      paramVideoTransPara.hVx = 0;
      paramVideoTransPara.hVu = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqj, 10);
      paramVideoTransPara.hVv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqk, 10);
      paramVideoTransPara.hVy = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qql, 10);
      break;
      paramVideoTransPara.hVq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqb, 0);
      paramVideoTransPara.hVx = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqo, 0);
      paramVideoTransPara.hVu = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqg, 10);
      paramVideoTransPara.hVv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqh, 10);
      paramVideoTransPara.hVy = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqi, 10);
      break;
      paramVideoTransPara.hhV = 0;
      paramVideoTransPara.hhW = 51;
      break label183;
      paramVideoTransPara.hVq = 0;
      paramVideoTransPara.hVr = 0;
      paramVideoTransPara.hVz = paramVideoTransPara.videoBitrate;
      paramVideoTransPara.hhV = 0;
      paramVideoTransPara.hhW = 51;
      ad.i("MicroMsg.SubCoreVideoControl", "ABA: it does not use the ABA or MinMax QP Limitation");
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
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)) || (bt.isNullOrNil(paramString4)))
    {
      AppMethodBeat.o(126751);
      return false;
    }
    try
    {
      int i;
      if (!bt.isNullOrNil(paramString1))
      {
        arrayOfString = paramString1.split("~");
        paramPInt1.value = bt.getInt(arrayOfString[0], -1);
        paramPInt2.value = bt.getInt(arrayOfString[1], -1);
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
      paramPInt3.value = bt.getInt(arrayOfString[0], -1);
      paramPInt4.value = bt.getInt(arrayOfString[1], -1);
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
      paramPInt5.value = bt.getInt(paramString3, -1);
      paramPInt6.value = bt.getInt(paramString4, -1);
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
        ad.e("MicroMsg.SubCoreVideoControl", "parse video para error." + localException.toString());
      }
    }
    ad.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramPInt3.value), Integer.valueOf(paramPInt4.value), Integer.valueOf(paramPInt5.value), Integer.valueOf(paramPInt6.value) });
    AppMethodBeat.o(126751);
    return true;
  }
  
  public static d aGQ()
  {
    AppMethodBeat.i(126748);
    d locald = (d)com.tencent.mm.model.t.ap(d.class);
    AppMethodBeat.o(126748);
    return locald;
  }
  
  private static VideoTransPara aGY()
  {
    AppMethodBeat.i(126762);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = 720;
    localVideoTransPara.height = 1280;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.hmx = 10;
    localVideoTransPara.audioBitrate = 64000;
    localVideoTransPara.hVe = 2;
    localVideoTransPara.hVf = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(126762);
    return localVideoTransPara;
  }
  
  private static VideoTransPara aGZ()
  {
    AppMethodBeat.i(169099);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = 1072;
    localVideoTransPara.height = ((int)(localVideoTransPara.width * 3.5F / 3.0D));
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.hmx = 1;
    localVideoTransPara.audioBitrate = 128000;
    localVideoTransPara.hVe = 2;
    localVideoTransPara.hVf = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(169099);
    return localVideoTransPara;
  }
  
  public static boolean aHa()
  {
    AppMethodBeat.i(126764);
    int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwe, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100136");
    if (localc.isValid()) {}
    for (int i = bt.getInt((String)localc.foF().get("streamingDownload"), 0);; i = 0)
    {
      boolean bool2 = aHc();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        ad.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean aHb()
  {
    AppMethodBeat.i(126765);
    int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwe, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100153");
    if (localc.isValid()) {}
    for (int i = bt.getInt((String)localc.foF().get("snsStreamDownload"), 0);; i = 0)
    {
      boolean bool2 = aHc();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        ad.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean aHc()
  {
    AppMethodBeat.i(126766);
    long l = bt.HI();
    int k = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwe, Integer.valueOf(-1))).intValue();
    Object localObject1 = com.tencent.mm.model.c.d.aDs().wz("100190");
    Object localObject2;
    int i;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject2 = ((com.tencent.mm.storage.c)localObject1).foF();
      i = bt.getInt((String)((Map)localObject2).get("player"), 1);
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
      if (!bt.isNullOrNil((String)localObject1))
      {
        arrayOfString = ((String)localObject1).split(";");
        n = arrayOfString.length;
        j = 0;
        if (j < n) {
          if (bt.getInt(arrayOfString[j], 0) != m) {}
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bt.isNullOrNil((String)localObject2))
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
            if (com.tencent.mm.compatible.util.d.lz(18)) {
              bool2 = false;
            }
            if (Build.BRAND.equalsIgnoreCase("meizu")) {
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxQ, Boolean.TRUE);
            }
            if (k == 0) {
              bool2 = false;
            }
            if (i <= 0) {
              bool2 = false;
            }
            ad.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(m), localObject1, str, localObject2, Integer.valueOf(i), Long.valueOf(bt.aO(l)) });
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
  
  public static boolean aHd()
  {
    AppMethodBeat.i(126771);
    String str = null;
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100253");
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      str = (String)((com.tencent.mm.storage.c)localObject).foF().get("noCompleteRange");
    }
    localObject = str;
    if (bt.isNullOrNil(str)) {
      localObject = "20:00-23:30";
    }
    com.tencent.mm.kernel.g.ajA();
    int i = com.tencent.mm.b.i.ce(com.tencent.mm.kernel.a.getUin(), 30);
    boolean bool = b.am((String)localObject, i);
    ad.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[] { Boolean.valueOf(bool), localObject, Integer.valueOf(i) });
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
  
  private static VideoTransPara pe(int paramInt)
  {
    AppMethodBeat.i(126763);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.hmx = 1;
    localVideoTransPara.audioBitrate = 48000;
    localVideoTransPara.hVe = 2;
    localVideoTransPara.hVf = 1;
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
  
  public static boolean pf(int paramInt)
  {
    AppMethodBeat.i(126772);
    int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IzC, Integer.valueOf(-1))).intValue();
    int i = j;
    if (j == -1) {
      if (!com.tencent.mm.plugin.o.f.dmo()) {
        break label91;
      }
    }
    label91:
    for (i = 1;; i = 0)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IzC, Integer.valueOf(i));
      ad.i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        break;
      }
      AppMethodBeat.o(126772);
      return false;
    }
    i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("VideoDownloadH265Flag", 0);
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      j = ae.gcP.gae;
      if (j != -1) {
        if (j == 1) {
          bool1 = true;
        }
      }
      break;
    }
    for (;;)
    {
      ad.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevc, scene:%s, flag:%s, configResult:%s, dynamicConfigResult:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j) });
      boolean bool2 = bool1;
      if (paramInt == 2)
      {
        bool2 = bool1;
        if (bool1)
        {
          String str1 = Build.MODEL.toLowerCase();
          String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qre, "");
          bool2 = bool1;
          if (!bt.isNullOrNil(str2))
          {
            bool2 = bool1;
            if (str2.contains(str1))
            {
              ad.i("MicroMsg.SubCoreVideoControl", "model %s is hit, expt:%s", new Object[] { str1, str2 });
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
        if (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
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
            ad.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[] { localObject1, localObject3, localObject4, localObject5, localObject6, localObject2 });
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
        if ((((List)localObject1).size() >= 2) && (!locale.hVg))
        {
          j = ((f)((List)localObject1).get(0)).hVo;
          i = 1;
          if (i < ((List)localObject1).size())
          {
            paramJSONObject = (f)((List)localObject1).get(i);
            paramJSONObject.hVn = j;
            j = paramJSONObject.hVo;
            i += 1;
            continue;
          }
        }
        locale.hVh = new f[((List)localObject1).size()];
        ((List)localObject1).toArray(locale.hVh);
        ad.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[] { locale });
        AppMethodBeat.o(126750);
        return locale;
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + paramJSONObject.toString());
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
  
  public final boolean EV(String paramString)
  {
    AppMethodBeat.i(126753);
    if (this.hUS == null) {
      this.hUS = new com.tencent.mm.plugin.a.b();
    }
    localObject1 = this.hUS;
    ((com.tencent.mm.plugin.a.b)localObject1).iQj = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).iQl = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).iQm = null;
    long l1 = bt.HI();
    long l2 = this.hUS.IZ(paramString);
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
      localRandomAccessFile = com.tencent.mm.vfs.i.dd(paramString, false);
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
        localObject5 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, hUP);
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
        localRandomAccessFile.seek(localObject4.iQi + 8L);
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
        ad.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[] { paramString, localException.toString() });
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
    ad.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[] { localObject2, Long.valueOf(l2), Long.valueOf(bt.aO(l1)), paramString });
    if (!bt.isNullOrNil(localObject2))
    {
      bool = localObject2.contains("WXVer");
      AppMethodBeat.o(126753);
      return bool;
    }
  }
  
  public final VideoTransPara aGR()
  {
    AppMethodBeat.i(126754);
    long l = bt.HI();
    if (this.hUT == null) {
      this.hUT = EU("C2CRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.hUT != null)
    {
      i = 0;
      if (i < this.hUT.length)
      {
        localObject = this.hUT[i];
        if ((localObject != null) && (((e)localObject).aHe()))
        {
          ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
          localVideoTransPara = ((e)localObject).aHf();
        }
      }
    }
    for (boolean bool = ((e)localObject).hVg;; bool = true)
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
        ((VideoTransPara)localObject).hmx = 10;
        ((VideoTransPara)localObject).audioBitrate = 64000;
        ((VideoTransPara)localObject).hVe = 2;
        ((VideoTransPara)localObject).hVf = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).hmx = 10;
      localVideoTransPara = a((VideoTransPara)localObject, 1);
      localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpJ, 10);
      if (!bool) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 11L, 1L, false);
      }
      for (;;)
      {
        i = bt.n((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 13, 18));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, i, 1L, false);
        ad.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bt.aO(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126754);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 12L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aGS()
  {
    AppMethodBeat.i(126755);
    long l = bt.HI();
    if (this.hUU == null) {
      this.hUU = EU("SnsRecordVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.hUU != null)
    {
      i = 0;
      if (i < this.hUU.length)
      {
        locale = this.hUU[i];
        if ((locale != null) && (locale.aHe()))
        {
          ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = locale.aHf();
        }
      }
    }
    for (boolean bool = locale.hVg;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = aGY();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.hmx = 10;
        localVideoTransPara.hVp = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpH, 10);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = bt.n((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, i, 1L, false);
          ad.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bt.aO(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126755);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aGT()
  {
    AppMethodBeat.i(126756);
    long l = bt.HI();
    if (this.hUV == null) {
      this.hUV = EU("SnsAlbumVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.hUV != null)
    {
      i = 0;
      if (i < this.hUV.length)
      {
        locale = this.hUV[i];
        if ((locale != null) && (locale.aHe()))
        {
          ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
          localVideoTransPara = locale.aHf();
        }
      }
    }
    for (boolean bool = locale.hVg;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = aGY();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.hmx = 10;
        localVideoTransPara.hVp = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpI, 10);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 21L, 1L, false);
        }
        for (;;)
        {
          i = bt.n((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 23, 28));
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, i, 1L, false);
          ad.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[] { Long.valueOf(bt.aO(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126756);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 22L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aGU()
  {
    AppMethodBeat.i(126758);
    long l = bt.HI();
    if (this.hUW == null) {
      this.hUW = EU("StoryRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.hUW != null)
    {
      i = 0;
      if (i < this.hUW.length)
      {
        localObject = this.hUW[i];
        if ((localObject != null) && (((e)localObject).aHe()))
        {
          ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
          localVideoTransPara = ((e)localObject).aHf();
        }
      }
    }
    for (boolean bool = ((e)localObject).hVg;; bool = true)
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
        ((VideoTransPara)localObject).hmx = 10;
        ((VideoTransPara)localObject).audioBitrate = 48000;
        ((VideoTransPara)localObject).hVe = 2;
        ((VideoTransPara)localObject).hVf = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).hmx = 10;
      ((VideoTransPara)localObject).hVp = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 3);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqZ, 15);
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = bt.n((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, i, 1L, false);
        ad.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bt.aO(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126758);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aGV()
  {
    AppMethodBeat.i(169097);
    long l = bt.HI();
    if (this.hUX == null) {
      this.hUX = EU("FinderRecordVideoConfig");
    }
    int i;
    if (this.hUX != null)
    {
      i = 0;
      if (i < this.hUX.length)
      {
        localObject1 = this.hUX[i];
        if ((localObject1 != null) && (((e)localObject1).aHe())) {
          ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((e)localObject1).aHg();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aGZ();
      }
      if (ad.getLogLevel() <= 1)
      {
        i = aj.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).hVp = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzM, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzN, 3);
      ad.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(bt.aO(l)), localObject1 });
      AppMethodBeat.o(169097);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara aGW()
  {
    AppMethodBeat.i(169098);
    long l = bt.HI();
    if (this.hUY == null) {
      this.hUY = EU("FinderPublishVideoConfig");
    }
    int i;
    if (this.hUY != null)
    {
      i = 0;
      if (i < this.hUY.length)
      {
        localObject1 = this.hUY[i];
        if ((localObject1 != null) && (((e)localObject1).aHe())) {
          ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((e)localObject1).aHg();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = aGZ();
      }
      if (ad.getLogLevel() <= 1)
      {
        i = aj.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).hVp = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzO, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzP, 3);
      ad.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(bt.aO(l)), localObject1 });
      AppMethodBeat.o(169098);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara aGX()
  {
    AppMethodBeat.i(126761);
    long l = bt.HI();
    if (this.hVc == null) {
      this.hVc = EU("NearbyRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.hVc != null)
    {
      i = 0;
      if (i < this.hVc.length)
      {
        localObject = this.hVc[i];
        if ((localObject != null) && (((e)localObject).aHe()))
        {
          ad.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
          localVideoTransPara = ((e)localObject).aHf();
        }
      }
    }
    for (boolean bool = ((e)localObject).hVg;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null) {
        localObject = aGY();
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).hmx = 10;
      ((VideoTransPara)localObject).hVp = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 2);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = 10;
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = bt.n((Integer)com.tencent.mm.plugin.report.service.g.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, i, 1L, false);
        ad.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bt.aO(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126761);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara c(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(126760);
    if (paramVideoTransPara == null)
    {
      ad.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
      AppMethodBeat.o(126760);
      return null;
    }
    if (paramVideoTransPara.duration >= 300)
    {
      ad.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(126760);
      return null;
    }
    long l = bt.HI();
    VideoTransPara localVideoTransPara = pe(paramVideoTransPara.duration);
    boolean bool = true;
    int i = 1;
    Object localObject1 = com.tencent.mm.model.c.d.aDs().wz("100157");
    if (((com.tencent.mm.storage.c)localObject1).isValid()) {
      i = bt.getInt((String)((com.tencent.mm.storage.c)localObject1).foF().get("VideoEncodeStep"), 1);
    }
    ad.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      i = 1;
      if (i == 0) {
        break label402;
      }
      if (this.hVb == null) {
        this.hVb = EU("C2CAlbumVideoStepConfig");
      }
      localObject1 = this.hVb;
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
      if ((localObject2 == null) || (!localObject2.aHe())) {
        break label428;
      }
      ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
      i = a.a(localObject2.hVh, paramVideoTransPara, localVideoTransPara);
      bool = localObject2.hVg;
      label236:
      if (i > 0) {
        break label459;
      }
      localObject1 = pe(paramVideoTransPara.duration);
      label249:
      localObject1 = a((VideoTransPara)localObject1, 1);
      if (bool) {
        break label472;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 1L, 1L, false);
    }
    for (;;)
    {
      int j = bt.n((Integer)com.tencent.mm.plugin.report.service.g.a(((VideoTransPara)localObject1).videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 3, 8));
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, j, 1L, false);
      ad.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(j), Integer.valueOf(i), localObject1, paramVideoTransPara });
      AppMethodBeat.o(126760);
      return localObject1;
      i = 0;
      break;
      label402:
      if (this.hVa == null) {
        this.hVa = EU("C2CAlbumVideoConfig");
      }
      localObject1 = this.hVa;
      break label176;
      label428:
      i += 1;
      break label183;
      label435:
      i = 0;
      break label236;
      label440:
      ad.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
      i = a.a(null, paramVideoTransPara, localVideoTransPara);
      break label236;
      label459:
      localVideoTransPara.isDefault = false;
      localObject1 = localVideoTransPara;
      break label249;
      label472:
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(422L, 2L, 1L, false);
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
    if (bt.cC(this.hUR)) {}
    try
    {
      Object localObject = "{\"WXVer\":" + com.tencent.mm.protocal.d.Fnj + "}";
      this.hUR = ((String)localObject).getBytes("UTF-8");
      ad.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[] { localObject });
      localObject = this.hUR;
      AppMethodBeat.o(126752);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease()
  {
    this.hUT = null;
    this.hVb = null;
    this.hVa = null;
    this.hUU = null;
    this.hUV = null;
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final VideoTransPara pd(int paramInt)
  {
    AppMethodBeat.i(126759);
    long l = bt.HI();
    int i;
    if (this.hUZ == null)
    {
      if (paramInt == 1) {
        this.hUZ = EU("GameRecordBigVideoConfig");
      }
    }
    else
    {
      if (this.hUZ == null) {
        break label362;
      }
      i = 0;
      label41:
      if (i >= this.hUZ.length) {
        break label362;
      }
      localObject1 = this.hUZ[i];
      if ((localObject1 == null) || (!((e)localObject1).aHe())) {
        break label266;
      }
      ad.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get game Record config.");
    }
    label266:
    label273:
    label362:
    for (Object localObject1 = ((e)localObject1).aHf();; localObject1 = null)
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
        ((VideoTransPara)localObject2).hmx = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).hVe = 2;
        ((VideoTransPara)localObject2).hVf = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
      for (((VideoTransPara)localObject2).audioChannelCount = 1;; ((VideoTransPara)localObject2).audioChannelCount = 1)
      {
        ((VideoTransPara)localObject2).audioSampleRate = 44100;
        ((VideoTransPara)localObject2).hmx = 10;
        ((VideoTransPara)localObject2).hVp = 200;
        localObject1 = a((VideoTransPara)localObject2, 1);
        ad.i("MicroMsg.SubCoreVideoControl", "get game record para cost %d. %s", new Object[] { Long.valueOf(bt.aO(l)), localObject1 });
        AppMethodBeat.o(126759);
        return localObject1;
        this.hUZ = EU("GameRecordVideoConfig");
        break;
        i += 1;
        break label41;
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).isDefault = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).hmx = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).hVe = 2;
        ((VideoTransPara)localObject2).hVf = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.d
 * JD-Core Version:    0.7.0.1
 */