package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  implements at
{
  private static final int fzG;
  private a fzH;
  private byte[] fzI;
  private com.tencent.mm.plugin.a.b fzJ;
  private e[] fzK;
  private e[] fzL;
  private e[] fzM;
  private e[] fzN;
  private e[] fzO;
  private e[] fzP;
  private e[] fzQ;
  private e[] fzR;
  
  static
  {
    AppMethodBeat.i(50616);
    fzG = com.tencent.mm.plugin.a.c.aS("dscp");
    AppMethodBeat.o(50616);
  }
  
  public d()
  {
    AppMethodBeat.i(50592);
    this.fzI = null;
    this.fzH = new a();
    AppMethodBeat.o(50592);
  }
  
  public static int a(int paramInt, s params)
  {
    AppMethodBeat.i(50610);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
      ab.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 2) {
        h.qsU.idkeyStat(354L, 130L, 1L, false);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(50610);
      return paramInt;
      paramInt = 1;
      break;
      paramInt = a(params);
      break;
      paramInt = a(params);
      break;
      h.qsU.idkeyStat(354L, 131L, 1L, false);
    }
  }
  
  private static int a(s params)
  {
    int i = 1;
    AppMethodBeat.i(50611);
    if (!lh(1))
    {
      AppMethodBeat.o(50611);
      return 1;
    }
    o.alE();
    params = t.vf(params.getFileName());
    if (!com.tencent.mm.vfs.e.cN(params))
    {
      AppMethodBeat.o(50611);
      return 2;
    }
    if (!r.va(params)) {}
    for (;;)
    {
      AppMethodBeat.o(50611);
      return i;
      i = 2;
    }
  }
  
  private static VideoTransPara a(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(139637);
    if (paramInt == 2)
    {
      paramVideoTransPara.fAh = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRL, 0);
      paramVideoTransPara.fAi = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRM, 0);
      paramVideoTransPara.fAj = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRO, 10);
      paramVideoTransPara.fAk = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRN, 10);
      paramVideoTransPara.fAl = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRP, 10);
      paramVideoTransPara.fAm = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRQ, 10);
      if (paramVideoTransPara.fAi != 0)
      {
        paramVideoTransPara.fAn = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRR, 21);
        paramVideoTransPara.fAo = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRS, 39);
        paramVideoTransPara.fAp = paramVideoTransPara.videoBitrate;
        paramInt = m.Lo() & 0xFF;
        if ((paramInt < 30) || (Build.VERSION.SDK_INT <= 25)) {
          paramVideoTransPara.fAh = 0;
        }
        ab.i("MicroMsg.SubCoreVideoControl", "ABA: Prams abaSwitch: [%d]  qpSwitch: [%d] abaUpgear: [%d] abaDowngear: [%d] abaIncreasesize: [%d] abaDecreasesize:[%d] minQP: [%d] maxQP: [%d] CPUlevel: [%d] AndroidVersionSDK: [%d]", new Object[] { Integer.valueOf(paramVideoTransPara.fAh), Integer.valueOf(paramVideoTransPara.fAi), Integer.valueOf(paramVideoTransPara.fAj), Integer.valueOf(paramVideoTransPara.fAk), Integer.valueOf(paramVideoTransPara.fAl), Integer.valueOf(paramVideoTransPara.fAm), Integer.valueOf(paramVideoTransPara.fAn), Integer.valueOf(paramVideoTransPara.fAo), Integer.valueOf(paramInt), Integer.valueOf(Build.VERSION.SDK_INT) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(139637);
      return paramVideoTransPara;
      paramVideoTransPara.fAn = 0;
      paramVideoTransPara.fAo = 51;
      break;
      paramVideoTransPara.fAh = 0;
      paramVideoTransPara.fAi = 0;
      paramVideoTransPara.fAp = paramVideoTransPara.videoBitrate;
      paramVideoTransPara.fAn = 0;
      paramVideoTransPara.fAo = 51;
      ab.i("MicroMsg.SubCoreVideoControl", "ABA: it does not use the ABA or MinMax QP Limitation");
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5, PInt paramPInt6)
  {
    AppMethodBeat.i(50596);
    if ((bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3)) || (bo.isNullOrNil(paramString4)))
    {
      AppMethodBeat.o(50596);
      return false;
    }
    try
    {
      int i;
      if (!bo.isNullOrNil(paramString1))
      {
        arrayOfString = paramString1.split("~");
        paramPInt1.value = bo.getInt(arrayOfString[0], -1);
        paramPInt2.value = bo.getInt(arrayOfString[1], -1);
        if (paramPInt1.value >= 0)
        {
          i = paramPInt2.value;
          if (i >= 0) {}
        }
        else
        {
          AppMethodBeat.o(50596);
          return false;
        }
      }
      else
      {
        paramPInt2.value = 0;
        paramPInt1.value = 0;
      }
      String[] arrayOfString = paramString2.split("x");
      paramPInt3.value = bo.getInt(arrayOfString[0], -1);
      paramPInt4.value = bo.getInt(arrayOfString[1], -1);
      if (paramPInt3.value >= 0)
      {
        i = paramPInt4.value;
        if (i >= 0) {}
      }
      else
      {
        AppMethodBeat.o(50596);
        return false;
      }
      paramPInt5.value = bo.getInt(paramString3, -1);
      paramPInt6.value = bo.getInt(paramString4, -1);
      if (paramPInt5.value >= 0)
      {
        i = paramPInt6.value;
        if (i >= 0) {}
      }
      else
      {
        AppMethodBeat.o(50596);
        return false;
      }
      paramPInt6.value *= 1000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SubCoreVideoControl", "parse video para error." + localException.toString());
      }
    }
    ab.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramPInt3.value), Integer.valueOf(paramPInt4.value), Integer.valueOf(paramPInt5.value), Integer.valueOf(paramPInt6.value) });
    AppMethodBeat.o(50596);
    return true;
  }
  
  public static d afW()
  {
    AppMethodBeat.i(50593);
    d locald = (d)q.S(d.class);
    AppMethodBeat.o(50593);
    return locald;
  }
  
  private static VideoTransPara agc()
  {
    AppMethodBeat.i(50605);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = 540;
    localVideoTransPara.height = 960;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 1600000;
    localVideoTransPara.fzU = 10;
    localVideoTransPara.fzT = 64000;
    localVideoTransPara.fzV = 2;
    localVideoTransPara.fzW = 1;
    localVideoTransPara.eRF = 1;
    AppMethodBeat.o(50605);
    return localVideoTransPara;
  }
  
  public static boolean agd()
  {
    AppMethodBeat.i(50607);
    int j = ((Integer)g.RL().Ru().get(ac.a.yDz, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100136");
    if (localc.isValid()) {}
    for (int i = bo.getInt((String)localc.dvN().get("streamingDownload"), 0);; i = 0)
    {
      boolean bool2 = agf();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        ab.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(50607);
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
  
  public static boolean age()
  {
    AppMethodBeat.i(50608);
    int j = ((Integer)g.RL().Ru().get(ac.a.yDz, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100153");
    if (localc.isValid()) {}
    for (int i = bo.getInt((String)localc.dvN().get("snsStreamDownload"), 0);; i = 0)
    {
      boolean bool2 = agf();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        ab.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(50608);
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
  
  public static boolean agf()
  {
    AppMethodBeat.i(50609);
    long l = bo.yB();
    int k = ((Integer)g.RL().Ru().get(ac.a.yDz, Integer.valueOf(-1))).intValue();
    Object localObject1 = com.tencent.mm.model.c.c.abU().me("100190");
    Object localObject2;
    int i;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject2 = ((com.tencent.mm.storage.c)localObject1).dvN();
      i = bo.getInt((String)((Map)localObject2).get("player"), 1);
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
      if (!bo.isNullOrNil((String)localObject1))
      {
        arrayOfString = ((String)localObject1).split(";");
        n = arrayOfString.length;
        j = 0;
        if (j < n) {
          if (bo.getInt(arrayOfString[j], 0) != m) {}
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bo.isNullOrNil((String)localObject2))
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
            if (com.tencent.mm.compatible.util.d.fw(18)) {
              bool2 = false;
            }
            if (Build.BRAND.equalsIgnoreCase("meizu")) {
              g.RL().Ru().set(ac.a.yFa, Boolean.TRUE);
            }
            if (k == 0) {
              bool2 = false;
            }
            if (i <= 0) {
              bool2 = false;
            }
            ab.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(m), localObject1, str, localObject2, Integer.valueOf(i), Long.valueOf(bo.av(l)) });
            AppMethodBeat.o(50609);
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
  
  public static boolean agg()
  {
    AppMethodBeat.i(50614);
    String str = null;
    Object localObject = com.tencent.mm.model.c.c.abU().me("100253");
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      str = (String)((com.tencent.mm.storage.c)localObject).dvN().get("noCompleteRange");
    }
    localObject = str;
    if (bo.isNullOrNil(str)) {
      localObject = "20:00-23:30";
    }
    g.RJ();
    int i = i.bQ(com.tencent.mm.kernel.a.getUin(), 30);
    boolean bool = b.W((String)localObject, i);
    ab.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[] { Boolean.valueOf(bool), localObject, Integer.valueOf(i) });
    if (!bool)
    {
      AppMethodBeat.o(50614);
      return true;
    }
    AppMethodBeat.o(50614);
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
  
  private static VideoTransPara lg(int paramInt)
  {
    AppMethodBeat.i(50606);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.fzU = 1;
    localVideoTransPara.fzT = 48000;
    localVideoTransPara.fzV = 2;
    localVideoTransPara.fzW = 1;
    localVideoTransPara.eRF = 1;
    if (paramInt <= 120)
    {
      localVideoTransPara.fps = 30;
      localVideoTransPara.width = 540;
      localVideoTransPara.height = 960;
    }
    for (localVideoTransPara.videoBitrate = 1200000;; localVideoTransPara.videoBitrate = 544000)
    {
      AppMethodBeat.o(50606);
      return localVideoTransPara;
      localVideoTransPara.fps = 24;
      localVideoTransPara.width = 360;
      localVideoTransPara.height = 640;
    }
  }
  
  private static boolean lh(int paramInt)
  {
    AppMethodBeat.i(50615);
    int j = ((Integer)g.RL().Ru().get(ac.a.yGK, Integer.valueOf(-1))).intValue();
    int i = j;
    if (j == -1) {
      if (!com.tencent.mm.plugin.n.e.bQq()) {
        break label91;
      }
    }
    label91:
    for (i = 1;; i = 0)
    {
      g.RL().Ru().set(ac.a.yGK, Integer.valueOf(i));
      ab.i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        break;
      }
      AppMethodBeat.o(50615);
      return false;
    }
    i = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("VideoDownloadH265Flag", 0);
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      j = ac.erF.epI;
      if (j != -1) {
        if (j == 1) {
          bool1 = true;
        }
      }
      break;
    }
    for (;;)
    {
      ab.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevc, scene:%s, flag:%s, configResult:%s, dynamicConfigResult:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool1), Integer.valueOf(j) });
      boolean bool2 = bool1;
      if (paramInt == 2)
      {
        bool2 = bool1;
        if (bool1)
        {
          String str1 = Build.MODEL.toLowerCase();
          String str2 = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSw, "");
          bool2 = bool1;
          if (!bo.isNullOrNil(str2))
          {
            bool2 = bool1;
            if (str2.contains(str1))
            {
              ab.i("MicroMsg.SubCoreVideoControl", "model %s is hit, expt:%s", new Object[] { str1, str2 });
              bool2 = false;
            }
          }
        }
      }
      AppMethodBeat.o(50615);
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
      bool1 = false;
    }
  }
  
  private static e m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50595);
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
            ab.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[] { localObject1, localObject3, localObject4, localObject5, localObject6, localObject2 });
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
        if ((((List)localObject1).size() >= 2) && (!locale.fzX))
        {
          j = ((f)((List)localObject1).get(0)).fAf;
          i = 1;
          if (i < ((List)localObject1).size())
          {
            paramJSONObject = (f)((List)localObject1).get(i);
            paramJSONObject.fAe = j;
            j = paramJSONObject.fAf;
            i += 1;
            continue;
          }
        }
        locale.fzY = new f[((List)localObject1).size()];
        ((List)localObject1).toArray(locale.fzY);
        ab.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[] { locale });
        AppMethodBeat.o(50595);
        return locale;
      }
      catch (Exception paramJSONObject)
      {
        ab.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + paramJSONObject.toString());
        AppMethodBeat.o(50595);
        return null;
      }
      label530:
      i += 1;
      continue;
      label537:
      paramJSONObject = "";
    }
  }
  
  private static e[] sN(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(50594);
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue(paramString);
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[] { paramString });
      AppMethodBeat.o(50594);
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
    ab.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[] { paramString, localObject2 });
    try
    {
      paramString = new JSONArray((String)localObject2);
      int j = paramString.length();
      ab.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[] { Integer.valueOf(j) });
      localObject1 = new e[j];
      while (i < j)
      {
        localObject1[i] = m(paramString.getJSONObject(i));
        i += 1;
      }
      AppMethodBeat.o(50594);
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + paramString.toString());
      AppMethodBeat.o(50594);
      return null;
    }
    return localObject1;
  }
  
  public static int x(int paramInt, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(50612);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(50612);
      return paramInt;
      paramInt = 1;
      continue;
      if (!lh(2)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.e.cN(paramString))
      {
        if (!r.va(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public static int y(int paramInt, String paramString)
  {
    int i = 2;
    AppMethodBeat.i(50613);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.SubCoreVideoControl", "check story video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(50613);
      return paramInt;
      paramInt = 1;
      continue;
      if (!lh(3)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.e.cN(paramString))
      {
        if (!r.va(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public final VideoTransPara afX()
  {
    AppMethodBeat.i(50599);
    long l = bo.yB();
    if (this.fzK == null) {
      this.fzK = sN("C2CRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.fzK != null)
    {
      i = 0;
      if (i < this.fzK.length)
      {
        localObject = this.fzK[i];
        if ((localObject != null) && (((e)localObject).agh()))
        {
          ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
          localVideoTransPara = ((e)localObject).agi();
        }
      }
    }
    for (boolean bool = ((e)localObject).fzX;; bool = true)
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
        ((VideoTransPara)localObject).fzU = 10;
        ((VideoTransPara)localObject).fzT = 64000;
        ((VideoTransPara)localObject).fzV = 2;
        ((VideoTransPara)localObject).fzW = 1;
        ((VideoTransPara)localObject).eRF = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).fzU = 10;
      localVideoTransPara = a((VideoTransPara)localObject, 1);
      localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRw, 10);
      if (!bool) {
        h.qsU.idkeyStat(422L, 11L, 1L, false);
      }
      for (;;)
      {
        i = bo.g((Integer)h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 13, 18));
        h.qsU.idkeyStat(422L, i, 1L, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bo.av(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(50599);
        return localVideoTransPara;
        i += 1;
        break;
        h.qsU.idkeyStat(422L, 12L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara afY()
  {
    AppMethodBeat.i(50600);
    long l = bo.yB();
    if (this.fzL == null) {
      this.fzL = sN("SnsRecordVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.fzL != null)
    {
      i = 0;
      if (i < this.fzL.length)
      {
        locale = this.fzL[i];
        if ((locale != null) && (locale.agh()))
        {
          ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = locale.agi();
        }
      }
    }
    for (boolean bool = locale.fzX;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = agc();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.fzU = 10;
        localVideoTransPara.fAg = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRu, 10);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          h.qsU.idkeyStat(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = bo.g((Integer)h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          h.qsU.idkeyStat(422L, i, 1L, false);
          ab.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bo.av(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(50600);
          return localVideoTransPara;
          i += 1;
          break;
          h.qsU.idkeyStat(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara afZ()
  {
    AppMethodBeat.i(50601);
    long l = bo.yB();
    if (this.fzM == null) {
      this.fzM = sN("SnsAlbumVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.fzM != null)
    {
      i = 0;
      if (i < this.fzM.length)
      {
        locale = this.fzM[i];
        if ((locale != null) && (locale.agh()))
        {
          ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
          localVideoTransPara = locale.agi();
        }
      }
    }
    for (boolean bool = locale.fzX;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = agc();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.fzU = 10;
        localVideoTransPara.fAg = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRv, 10);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          h.qsU.idkeyStat(422L, 21L, 1L, false);
        }
        for (;;)
        {
          i = bo.g((Integer)h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 23, 28));
          h.qsU.idkeyStat(422L, i, 1L, false);
          ab.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[] { Long.valueOf(bo.av(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(50601);
          return localVideoTransPara;
          i += 1;
          break;
          h.qsU.idkeyStat(422L, 22L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara aga()
  {
    AppMethodBeat.i(50602);
    long l = bo.yB();
    if (this.fzN == null) {
      this.fzN = sN("StoryRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.fzN != null)
    {
      i = 0;
      if (i < this.fzN.length)
      {
        localObject = this.fzN[i];
        if ((localObject != null) && (((e)localObject).agh()))
        {
          ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
          localVideoTransPara = ((e)localObject).agi();
        }
      }
    }
    for (boolean bool = ((e)localObject).fzX;; bool = true)
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
        ((VideoTransPara)localObject).fzU = 10;
        ((VideoTransPara)localObject).fzT = 48000;
        ((VideoTransPara)localObject).fzV = 2;
        ((VideoTransPara)localObject).fzW = 1;
        ((VideoTransPara)localObject).eRF = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).fzU = 10;
      ((VideoTransPara)localObject).fAg = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 3);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSr, 15);
      }
      if (!bool) {
        h.qsU.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = bo.g((Integer)h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        h.qsU.idkeyStat(422L, i, 1L, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bo.av(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(50602);
        return localVideoTransPara;
        i += 1;
        break;
        h.qsU.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara agb()
  {
    AppMethodBeat.i(50604);
    long l = bo.yB();
    if (this.fzR == null) {
      this.fzR = sN("NearbyRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.fzR != null)
    {
      i = 0;
      if (i < this.fzR.length)
      {
        localObject = this.fzR[i];
        if ((localObject != null) && (((e)localObject).agh()))
        {
          ab.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
          localVideoTransPara = ((e)localObject).agi();
        }
      }
    }
    for (boolean bool = ((e)localObject).fzX;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null) {
        localObject = agc();
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).fzU = 10;
      ((VideoTransPara)localObject).fAg = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 2);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = 10;
      }
      if (!bool) {
        h.qsU.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = bo.g((Integer)h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        h.qsU.idkeyStat(422L, i, 1L, false);
        ab.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bo.av(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(50604);
        return localVideoTransPara;
        i += 1;
        break;
        h.qsU.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara c(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(50603);
    if (paramVideoTransPara == null)
    {
      ab.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
      AppMethodBeat.o(50603);
      return null;
    }
    if (paramVideoTransPara.duration >= 300)
    {
      ab.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(50603);
      return null;
    }
    long l = bo.yB();
    VideoTransPara localVideoTransPara = lg(paramVideoTransPara.duration);
    boolean bool = true;
    int i = 1;
    Object localObject1 = com.tencent.mm.model.c.c.abU().me("100157");
    if (((com.tencent.mm.storage.c)localObject1).isValid()) {
      i = bo.getInt((String)((com.tencent.mm.storage.c)localObject1).dvN().get("VideoEncodeStep"), 1);
    }
    ab.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      i = 1;
      if (i == 0) {
        break label402;
      }
      if (this.fzQ == null) {
        this.fzQ = sN("C2CAlbumVideoStepConfig");
      }
      localObject1 = this.fzQ;
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
      if ((localObject2 == null) || (!localObject2.agh())) {
        break label428;
      }
      ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
      i = a.a(localObject2.fzY, paramVideoTransPara, localVideoTransPara);
      bool = localObject2.fzX;
      label236:
      if (i > 0) {
        break label459;
      }
      localObject1 = lg(paramVideoTransPara.duration);
      label249:
      localObject1 = a((VideoTransPara)localObject1, 1);
      if (bool) {
        break label472;
      }
      h.qsU.idkeyStat(422L, 1L, 1L, false);
    }
    for (;;)
    {
      int j = bo.g((Integer)h.a(((VideoTransPara)localObject1).videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 3, 8));
      h.qsU.idkeyStat(422L, j, 1L, false);
      ab.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(j), Integer.valueOf(i), localObject1, paramVideoTransPara });
      AppMethodBeat.o(50603);
      return localObject1;
      i = 0;
      break;
      label402:
      if (this.fzP == null) {
        this.fzP = sN("C2CAlbumVideoConfig");
      }
      localObject1 = this.fzP;
      break label176;
      label428:
      i += 1;
      break label183;
      label435:
      i = 0;
      break label236;
      label440:
      ab.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
      i = a.a(null, paramVideoTransPara, localVideoTransPara);
      break label236;
      label459:
      localVideoTransPara.isDefault = false;
      localObject1 = localVideoTransPara;
      break label249;
      label472:
      h.qsU.idkeyStat(422L, 2L, 1L, false);
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final byte[] getWeixinMeta()
  {
    AppMethodBeat.i(50597);
    if (bo.ce(this.fzI)) {}
    try
    {
      Object localObject = "{\"WXVer\":" + com.tencent.mm.protocal.d.whH + "}";
      this.fzI = ((String)localObject).getBytes("UTF-8");
      ab.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[] { localObject });
      localObject = this.fzI;
      AppMethodBeat.o(50597);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[] { localException.toString() });
      }
    }
  }
  
  public final VideoTransPara lf(int paramInt)
  {
    AppMethodBeat.i(139638);
    long l = bo.yB();
    int i;
    if (this.fzO == null)
    {
      if (paramInt == 1) {
        this.fzO = sN("GameRecordBigVideoConfig");
      }
    }
    else
    {
      if (this.fzO == null) {
        break label362;
      }
      i = 0;
      label41:
      if (i >= this.fzO.length) {
        break label362;
      }
      localObject1 = this.fzO[i];
      if ((localObject1 == null) || (!((e)localObject1).agh())) {
        break label266;
      }
      ab.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get game Record config.");
    }
    label266:
    label273:
    label362:
    for (Object localObject1 = ((e)localObject1).agi();; localObject1 = null)
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
        ((VideoTransPara)localObject2).fzU = 10;
        ((VideoTransPara)localObject2).fzT = 48000;
        ((VideoTransPara)localObject2).fzV = 2;
        ((VideoTransPara)localObject2).fzW = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
      for (((VideoTransPara)localObject2).eRF = 1;; ((VideoTransPara)localObject2).eRF = 1)
      {
        ((VideoTransPara)localObject2).audioSampleRate = 44100;
        ((VideoTransPara)localObject2).fzU = 10;
        ((VideoTransPara)localObject2).fAg = 200;
        localObject1 = a((VideoTransPara)localObject2, 1);
        ab.i("MicroMsg.SubCoreVideoControl", "get game record para cost %d. %s", new Object[] { Long.valueOf(bo.av(l)), localObject1 });
        AppMethodBeat.o(139638);
        return localObject1;
        this.fzO = sN("GameRecordVideoConfig");
        break;
        i += 1;
        break label41;
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).isDefault = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).fzU = 10;
        ((VideoTransPara)localObject2).fzT = 48000;
        ((VideoTransPara)localObject2).fzV = 2;
        ((VideoTransPara)localObject2).fzW = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
    }
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease()
  {
    this.fzK = null;
    this.fzQ = null;
    this.fzP = null;
    this.fzL = null;
    this.fzM = null;
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  /* Error */
  public final boolean sO(String paramString)
  {
    // Byte code:
    //   0: ldc_w 881
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 883	com/tencent/mm/modelcontrol/d:fzJ	Lcom/tencent/mm/plugin/a/b;
    //   10: ifnonnull +14 -> 24
    //   13: aload_0
    //   14: new 885	com/tencent/mm/plugin/a/b
    //   17: dup
    //   18: invokespecial 886	com/tencent/mm/plugin/a/b:<init>	()V
    //   21: putfield 883	com/tencent/mm/modelcontrol/d:fzJ	Lcom/tencent/mm/plugin/a/b;
    //   24: aload_0
    //   25: getfield 883	com/tencent/mm/modelcontrol/d:fzJ	Lcom/tencent/mm/plugin/a/b;
    //   28: astore 7
    //   30: aload 7
    //   32: ldc2_w 887
    //   35: putfield 892	com/tencent/mm/plugin/a/b:glZ	J
    //   38: aload 7
    //   40: ldc2_w 887
    //   43: putfield 895	com/tencent/mm/plugin/a/b:gmb	J
    //   46: aload 7
    //   48: aconst_null
    //   49: putfield 899	com/tencent/mm/plugin/a/b:gmc	Lcom/tencent/mm/plugin/a/a;
    //   52: invokestatic 390	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   55: lstore_2
    //   56: aload_0
    //   57: getfield 883	com/tencent/mm/modelcontrol/d:fzJ	Lcom/tencent/mm/plugin/a/b;
    //   60: aload_1
    //   61: invokevirtual 903	com/tencent/mm/plugin/a/b:wD	(Ljava/lang/String;)J
    //   64: lstore 4
    //   66: lload 4
    //   68: lconst_0
    //   69: lcmp
    //   70: ifgt +11 -> 81
    //   73: ldc_w 881
    //   76: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: aconst_null
    //   82: astore 12
    //   84: aconst_null
    //   85: astore 13
    //   87: new 905	java/io/RandomAccessFile
    //   90: dup
    //   91: new 907	java/io/File
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 908	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: ldc_w 910
    //   102: invokespecial 913	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   105: astore 9
    //   107: aload 9
    //   109: astore 7
    //   111: aload 9
    //   113: lload 4
    //   115: invokevirtual 917	java/io/RandomAccessFile:seek	(J)V
    //   118: aload 9
    //   120: astore 7
    //   122: bipush 8
    //   124: newarray byte
    //   126: astore 14
    //   128: aload 9
    //   130: astore 7
    //   132: aload 9
    //   134: aload 14
    //   136: getstatic 922	com/tencent/mm/plugin/a/a:aFP	I
    //   139: invokestatic 925	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   142: astore 8
    //   144: aconst_null
    //   145: astore 7
    //   147: aload 7
    //   149: astore 10
    //   151: aload 8
    //   153: ifnull +65 -> 218
    //   156: aload 9
    //   158: astore 7
    //   160: aload 9
    //   162: aload 14
    //   164: getstatic 42	com/tencent/mm/modelcontrol/d:fzG	I
    //   167: invokestatic 925	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   170: astore 11
    //   172: aload 11
    //   174: astore 10
    //   176: aload 11
    //   178: ifnonnull +40 -> 218
    //   181: aload 9
    //   183: astore 7
    //   185: aload 9
    //   187: aload 8
    //   189: invokevirtual 928	com/tencent/mm/plugin/a/a:getEndPos	()J
    //   192: invokevirtual 917	java/io/RandomAccessFile:seek	(J)V
    //   195: aload 9
    //   197: astore 7
    //   199: aload 9
    //   201: aload 14
    //   203: getstatic 922	com/tencent/mm/plugin/a/a:aFP	I
    //   206: invokestatic 925	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   209: astore 8
    //   211: aload 11
    //   213: astore 7
    //   215: goto -68 -> 147
    //   218: aload 13
    //   220: astore 8
    //   222: aload 10
    //   224: ifnull +74 -> 298
    //   227: aload 9
    //   229: astore 7
    //   231: aload 10
    //   233: invokevirtual 931	com/tencent/mm/plugin/a/a:getSize	()J
    //   236: l2i
    //   237: bipush 8
    //   239: isub
    //   240: newarray byte
    //   242: astore 11
    //   244: aload 9
    //   246: astore 7
    //   248: aload 9
    //   250: aload 10
    //   252: getfield 934	com/tencent/mm/plugin/a/a:glY	J
    //   255: ldc2_w 935
    //   258: ladd
    //   259: invokevirtual 917	java/io/RandomAccessFile:seek	(J)V
    //   262: aload 13
    //   264: astore 8
    //   266: aload 9
    //   268: astore 7
    //   270: aload 9
    //   272: aload 11
    //   274: invokevirtual 940	java/io/RandomAccessFile:read	([B)I
    //   277: ifle +21 -> 298
    //   280: aload 9
    //   282: astore 7
    //   284: new 231	java/lang/String
    //   287: dup
    //   288: aload 11
    //   290: ldc_w 851
    //   293: invokespecial 943	java/lang/String:<init>	([BLjava/lang/String;)V
    //   296: astore 8
    //   298: aload 9
    //   300: invokevirtual 946	java/io/RandomAccessFile:close	()V
    //   303: aload 8
    //   305: astore 7
    //   307: ldc 62
    //   309: ldc_w 948
    //   312: iconst_4
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload 7
    //   320: aastore
    //   321: dup
    //   322: iconst_1
    //   323: lload 4
    //   325: invokestatic 442	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   328: aastore
    //   329: dup
    //   330: iconst_2
    //   331: lload_2
    //   332: invokestatic 437	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   335: invokestatic 442	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   338: aastore
    //   339: dup
    //   340: iconst_3
    //   341: aload_1
    //   342: aastore
    //   343: invokestatic 75	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload 7
    //   348: invokestatic 227	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   351: ifne +107 -> 458
    //   354: aload 7
    //   356: ldc_w 950
    //   359: invokevirtual 534	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   362: istore 6
    //   364: ldc_w 881
    //   367: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: iload 6
    //   372: ireturn
    //   373: astore 10
    //   375: aconst_null
    //   376: astore 8
    //   378: aload 8
    //   380: astore 7
    //   382: ldc 62
    //   384: ldc_w 952
    //   387: iconst_2
    //   388: anewarray 4	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: aload_1
    //   394: aastore
    //   395: dup
    //   396: iconst_1
    //   397: aload 10
    //   399: invokevirtual 258	java/lang/Exception:toString	()Ljava/lang/String;
    //   402: aastore
    //   403: invokestatic 861	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   406: aload 12
    //   408: astore 7
    //   410: aload 8
    //   412: ifnull -105 -> 307
    //   415: aload 8
    //   417: invokevirtual 946	java/io/RandomAccessFile:close	()V
    //   420: aload 12
    //   422: astore 7
    //   424: goto -117 -> 307
    //   427: astore 7
    //   429: aload 12
    //   431: astore 7
    //   433: goto -126 -> 307
    //   436: astore_1
    //   437: aconst_null
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 946	java/io/RandomAccessFile:close	()V
    //   450: ldc_w 881
    //   453: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload_1
    //   457: athrow
    //   458: ldc_w 881
    //   461: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: iconst_0
    //   465: ireturn
    //   466: astore 7
    //   468: aload 8
    //   470: astore 7
    //   472: goto -165 -> 307
    //   475: astore 7
    //   477: goto -27 -> 450
    //   480: astore_1
    //   481: goto -41 -> 440
    //   484: astore 10
    //   486: aload 9
    //   488: astore 8
    //   490: goto -112 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	d
    //   0	493	1	paramString	String
    //   55	277	2	l1	long
    //   64	260	4	l2	long
    //   362	9	6	bool	boolean
    //   28	395	7	localObject1	Object
    //   427	1	7	localIOException1	java.io.IOException
    //   431	15	7	localObject2	Object
    //   466	1	7	localIOException2	java.io.IOException
    //   470	1	7	localObject3	Object
    //   475	1	7	localIOException3	java.io.IOException
    //   142	347	8	localObject4	Object
    //   105	382	9	localRandomAccessFile	java.io.RandomAccessFile
    //   149	102	10	localObject5	Object
    //   373	25	10	localException1	Exception
    //   484	1	10	localException2	Exception
    //   170	119	11	localObject6	Object
    //   82	348	12	localObject7	Object
    //   85	178	13	localObject8	Object
    //   126	76	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   87	107	373	java/lang/Exception
    //   415	420	427	java/io/IOException
    //   87	107	436	finally
    //   298	303	466	java/io/IOException
    //   445	450	475	java/io/IOException
    //   111	118	480	finally
    //   122	128	480	finally
    //   132	144	480	finally
    //   160	172	480	finally
    //   185	195	480	finally
    //   199	211	480	finally
    //   231	244	480	finally
    //   248	262	480	finally
    //   270	280	480	finally
    //   284	298	480	finally
    //   382	406	480	finally
    //   111	118	484	java/lang/Exception
    //   122	128	484	java/lang/Exception
    //   132	144	484	java/lang/Exception
    //   160	172	484	java/lang/Exception
    //   185	195	484	java/lang/Exception
    //   199	211	484	java/lang/Exception
    //   231	244	484	java/lang/Exception
    //   248	262	484	java/lang/Exception
    //   270	280	484	java/lang/Exception
    //   284	298	484	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.d
 * JD-Core Version:    0.7.0.1
 */