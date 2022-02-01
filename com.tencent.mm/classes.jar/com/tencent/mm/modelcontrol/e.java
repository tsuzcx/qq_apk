package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.model.be;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  implements be
{
  private static final int lIW;
  private a lIX;
  private byte[] lIY;
  private com.tencent.mm.plugin.a.b lIZ;
  private f[] lJa;
  private f[] lJb;
  private f[] lJc;
  private f[] lJd;
  private f[] lJe;
  private f[] lJf;
  private f[] lJg;
  private f[] lJh;
  private f[] lJi;
  private f[] lJj;
  private f[] lJk;
  
  static
  {
    AppMethodBeat.i(126773);
    lIW = com.tencent.mm.plugin.a.c.bU("dscp");
    AppMethodBeat.o(126773);
  }
  
  public e()
  {
    AppMethodBeat.i(126747);
    this.lIY = null;
    this.lIX = new a();
    AppMethodBeat.o(126747);
  }
  
  private static f A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126750);
    f localf = new f();
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
            Log.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[] { localObject1, localObject3, localObject4, localObject5, localObject6, localObject2 });
            localf.a((String)localObject1, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject2);
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
              break label515;
            }
            paramJSONObject = localJSONObject.getString("dura");
            if (!a(paramJSONObject, localJSONObject.getString("wh"), localJSONObject.getString("fps"), localJSONObject.getString("vbr"), (PInt)localObject3, (PInt)localObject4, (PInt)localObject5, (PInt)localObject6, localPInt1, localPInt2)) {
              break label508;
            }
            ((List)localObject1).add(new g(((PInt)localObject3).value, ((PInt)localObject4).value, ((PInt)localObject5).value, ((PInt)localObject6).value, localPInt1.value, localPInt2.value, localPInt2.value));
            break label508;
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
        if ((((List)localObject1).size() >= 2) && (!localf.lJo))
        {
          j = ((g)((List)localObject1).get(0)).lJw;
          i = 1;
          if (i < ((List)localObject1).size())
          {
            paramJSONObject = (g)((List)localObject1).get(i);
            paramJSONObject.lJv = j;
            j = paramJSONObject.lJw;
            i += 1;
            continue;
          }
        }
        localf.lJp = new g[((List)localObject1).size()];
        ((List)localObject1).toArray(localf.lJp);
        Log.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[] { localf });
        AppMethodBeat.o(126750);
        return localf;
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + paramJSONObject.toString());
        AppMethodBeat.o(126750);
        return null;
      }
      label508:
      i += 1;
      continue;
      label515:
      paramJSONObject = "";
    }
  }
  
  public static int M(int paramInt, String paramString)
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
      Log.i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126769);
      return paramInt;
      paramInt = 1;
      continue;
      if (!vW(2)) {
        break;
      }
      paramInt = i;
      if (u.agG(paramString))
      {
        if (!v.isH265Video(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public static int N(int paramInt, String paramString)
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
      Log.i("MicroMsg.SubCoreVideoControl", "check story video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126770);
      return paramInt;
      paramInt = 1;
      continue;
      if (!vW(3)) {
        break;
      }
      paramInt = i;
      if (u.agG(paramString))
      {
        if (!v.isH265Video(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  private static f[] VD(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(126749);
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue(paramString);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[] { paramString });
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
    Log.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[] { paramString, localObject2 });
    try
    {
      paramString = new JSONArray((String)localObject2);
      int j = paramString.length();
      Log.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[] { Integer.valueOf(j) });
      localObject1 = new f[j];
      while (i < j)
      {
        localObject1[i] = A(paramString.getJSONObject(i));
        i += 1;
      }
      AppMethodBeat.o(126749);
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + paramString.toString());
      AppMethodBeat.o(126749);
      return null;
    }
    return localObject1;
  }
  
  public static int a(int paramInt, w paramw)
  {
    AppMethodBeat.i(126767);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
      Log.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 2) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 130L, 1L, false);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(126767);
      return paramInt;
      paramInt = 1;
      break;
      paramInt = a(paramw);
      break;
      paramInt = a(paramw);
      break;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 131L, 1L, false);
    }
  }
  
  private static int a(w paramw)
  {
    int i = 1;
    AppMethodBeat.i(126768);
    if (!vW(1))
    {
      AppMethodBeat.o(126768);
      return 1;
    }
    s.bqB();
    paramw = x.XT(paramw.getFileName());
    if (!u.agG(paramw))
    {
      AppMethodBeat.o(126768);
      return 2;
    }
    if (!v.isH265Video(paramw)) {}
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
    label188:
    int i;
    label374:
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
        paramVideoTransPara.lJz = 0;
        paramVideoTransPara.lJG = 0;
        paramVideoTransPara.lJA = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuq, 0);
        paramVideoTransPara.lJB = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vut, 10);
        paramVideoTransPara.lJC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vus, 10);
        paramVideoTransPara.lJF = 0;
        if (paramVideoTransPara.lJA != 0)
        {
          paramVideoTransPara.kSl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuI, 21);
          paramVideoTransPara.kSm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuJ, 39);
          paramVideoTransPara.lJI = paramVideoTransPara.videoBitrate;
          paramVideoTransPara.lJJ = paramInt;
          i = m.aus() & 0xFF;
          if ((i < 30) || (Build.VERSION.SDK_INT <= 25)) {
            paramVideoTransPara.lJz = 0;
          }
          Log.i("MicroMsg.SubCoreVideoControl", "ABA: Prams abaSwitch: [%d]  qpSwitch: [%d] abaUpgear: [%d] abaDowngear: [%d] ceilingVideoBR: [%d] flooringVideoBR:[%d] minQP: [%d] maxQP: [%d] CPUlevel: [%d] AndroidVersionSDK: [%d] remuxSecene: [%d] isEnable720p: [%d] maxVideoSize: [%d]", new Object[] { Integer.valueOf(paramVideoTransPara.lJz), Integer.valueOf(paramVideoTransPara.lJA), Integer.valueOf(paramVideoTransPara.lJB), Integer.valueOf(paramVideoTransPara.lJC), Integer.valueOf(paramVideoTransPara.lJD), Integer.valueOf(paramVideoTransPara.lJE), Integer.valueOf(paramVideoTransPara.kSl), Integer.valueOf(paramVideoTransPara.kSm), Integer.valueOf(i), Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramVideoTransPara.lJJ), Integer.valueOf(paramVideoTransPara.lJG), Integer.valueOf(paramVideoTransPara.lJH) });
          localObject = MultiProcessMMKV.getMMKV("HardcoderQP");
          if (localObject != null)
          {
            str = ((MultiProcessMMKV)localObject).decodeString("HCMinQPKey", null);
            localObject = ((MultiProcessMMKV)localObject).decodeString("HCMaxQPKey", null);
            if ((str != null) && (localObject != null))
            {
              bool2 = false;
              i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuq, 0);
              j = af.juO.jtH;
              if (j != 0) {
                break label1042;
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
      Log.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, forceHWQP:%s, qpSwitch:%s, deviceQPCfg:%s, forceHWQPOff:%s", new Object[] { str, localObject, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
      if ((!bool1) && ((bool2) || ((i & 0x2) != 0)))
      {
        j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuI, 21);
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuJ, 39);
        j = Math.max(0, Math.min(51, j));
        i = Math.max(0, Math.min(51, i));
        if ((j != 0) && (i != 51))
        {
          paramVideoTransPara.kSl = j;
          paramVideoTransPara.kSm = i;
          Log.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, value: minQP:%d, maxQP:%d, Scence:%d", new Object[] { str, localObject, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        }
      }
      AppMethodBeat.o(126757);
      return paramVideoTransPara;
      paramVideoTransPara.lJz = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vun, 1);
      paramVideoTransPara.lJG = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuL, 1);
      paramVideoTransPara.lJD = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuu, 10);
      paramVideoTransPara.lJE = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuv, 10);
      paramVideoTransPara.lJH = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuw, 36);
      break;
      paramVideoTransPara.lJz = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuo, 1);
      paramVideoTransPara.lJG = 0;
      paramVideoTransPara.lJD = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vux, 10);
      paramVideoTransPara.lJE = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuy, 10);
      paramVideoTransPara.lJH = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuz, 36);
      break;
      paramVideoTransPara.lJz = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vup, 1);
      paramVideoTransPara.lJG = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuK, 0);
      paramVideoTransPara.lJD = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuu, 10);
      paramVideoTransPara.lJE = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuv, 10);
      paramVideoTransPara.lJH = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vuw, 36);
      break;
      paramVideoTransPara.kSl = 0;
      paramVideoTransPara.kSm = 51;
      break label188;
      paramVideoTransPara.lJz = 0;
      paramVideoTransPara.lJA = 0;
      paramVideoTransPara.lJI = paramVideoTransPara.videoBitrate;
      paramVideoTransPara.kSl = 0;
      paramVideoTransPara.kSm = 51;
      Log.i("MicroMsg.SubCoreVideoControl", "ABA: it does not use the ABA or MinMax QP Limitation");
      break label374;
      label1042:
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
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)) || (Util.isNullOrNil(paramString4)))
    {
      AppMethodBeat.o(126751);
      return false;
    }
    try
    {
      int i;
      if (!Util.isNullOrNil(paramString1))
      {
        arrayOfString = paramString1.split("~");
        paramPInt1.value = Util.getInt(arrayOfString[0], -1);
        paramPInt2.value = Util.getInt(arrayOfString[1], -1);
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
      paramPInt3.value = Util.getInt(arrayOfString[0], -1);
      paramPInt4.value = Util.getInt(arrayOfString[1], -1);
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
      paramPInt5.value = Util.getInt(paramString3, -1);
      paramPInt6.value = Util.getInt(paramString4, -1);
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
        Log.e("MicroMsg.SubCoreVideoControl", "parse video para error." + localException.toString());
      }
    }
    Log.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramPInt3.value), Integer.valueOf(paramPInt4.value), Integer.valueOf(paramPInt5.value), Integer.valueOf(paramPInt6.value) });
    AppMethodBeat.o(126751);
    return true;
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
  
  public static boolean bkA()
  {
    AppMethodBeat.i(126765);
    int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmD, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu("100153");
    if (localc.isValid()) {}
    for (int i = Util.getInt((String)localc.hvz().get("snsStreamDownload"), 0);; i = 0)
    {
      boolean bool2 = bkB();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        Log.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean bkB()
  {
    AppMethodBeat.i(126766);
    long l = Util.currentTicks();
    int k = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmD, Integer.valueOf(-1))).intValue();
    Object localObject1 = com.tencent.mm.model.c.d.bgB().Mu("100190");
    Object localObject2;
    int i;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject2 = ((com.tencent.mm.storage.c)localObject1).hvz();
      i = Util.getInt((String)((Map)localObject2).get("player"), 1);
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
      if (!Util.isNullOrNil((String)localObject1))
      {
        arrayOfString = ((String)localObject1).split(";");
        n = arrayOfString.length;
        j = 0;
        if (j < n) {
          if (Util.getInt(arrayOfString[j], 0) != m) {}
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!Util.isNullOrNil((String)localObject2))
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
            if (com.tencent.mm.compatible.util.d.qW(18)) {
              bool2 = false;
            }
            if (Build.BRAND.equalsIgnoreCase("meizu")) {
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vos, Boolean.TRUE);
            }
            if (k == 0) {
              bool2 = false;
            }
            if (i <= 0) {
              bool2 = false;
            }
            Log.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(m), localObject1, str, localObject2, Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
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
  
  public static boolean bkC()
  {
    AppMethodBeat.i(126771);
    String str = null;
    Object localObject = com.tencent.mm.model.c.d.bgB().Mu("100253");
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      str = (String)((com.tencent.mm.storage.c)localObject).hvz().get("noCompleteRange");
    }
    localObject = str;
    if (Util.isNullOrNil(str)) {
      localObject = "20:00-23:30";
    }
    com.tencent.mm.kernel.h.aHE();
    int i = i.cA(com.tencent.mm.kernel.b.getUin(), 30);
    boolean bool = b.aJ((String)localObject, i);
    Log.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[] { Boolean.valueOf(bool), localObject, Integer.valueOf(i) });
    if (!bool)
    {
      AppMethodBeat.o(126771);
      return true;
    }
    AppMethodBeat.o(126771);
    return false;
  }
  
  public static boolean bkD()
  {
    AppMethodBeat.i(216209);
    boolean bool = com.tencent.mm.plugin.u.f.eSL();
    Log.i("MicroMsg.SubCoreVideoControl", "check device support hevcenc[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "no hevc encoder found!");
      AppMethodBeat.o(216209);
      return false;
    }
    bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vII, false);
    Log.i("MicroMsg.SubCoreVideoControl", "further check checkDeviceSupportHevcEnc bH265EncDisabled:%b ", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      Log.i("MicroMsg.SubCoreVideoControl", "model %s is hit", new Object[] { Build.MODEL.toLowerCase() });
    }
    for (bool = false;; bool = true)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevcEnc, scene:%s, configResult:%s", new Object[] { Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(216209);
      return bool;
    }
  }
  
  public static e bkp()
  {
    AppMethodBeat.i(126748);
    e locale = (e)com.tencent.mm.model.y.as(e.class);
    AppMethodBeat.o(126748);
    return locale;
  }
  
  private static VideoTransPara bkx()
  {
    AppMethodBeat.i(126762);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.lJx = true;
    localVideoTransPara.width = 720;
    localVideoTransPara.height = 1280;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.kXt = 10;
    localVideoTransPara.audioBitrate = 64000;
    localVideoTransPara.lJm = 2;
    localVideoTransPara.lJn = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(126762);
    return localVideoTransPara;
  }
  
  private static VideoTransPara bky()
  {
    AppMethodBeat.i(169099);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.lJx = true;
    localVideoTransPara.width = 1072;
    localVideoTransPara.height = ((int)(localVideoTransPara.width * 3.5F / 3.0D));
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.kXt = 1;
    localVideoTransPara.audioBitrate = 128000;
    localVideoTransPara.lJm = 2;
    localVideoTransPara.lJn = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(169099);
    return localVideoTransPara;
  }
  
  public static boolean bkz()
  {
    AppMethodBeat.i(126764);
    int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmD, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu("100136");
    if (localc.isValid()) {}
    for (int i = Util.getInt((String)localc.hvz().get("streamingDownload"), 0);; i = 0)
    {
      boolean bool2 = bkB();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        Log.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  /* Error */
  public static int j(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 753
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +248 -> 255
    //   10: aload_2
    //   11: ldc_w 755
    //   14: invokevirtual 759	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +238 -> 255
    //   20: iconst_1
    //   21: istore 8
    //   23: iconst_0
    //   24: istore 5
    //   26: iconst_0
    //   27: istore 9
    //   29: iconst_0
    //   30: istore 6
    //   32: iconst_0
    //   33: istore 7
    //   35: iconst_0
    //   36: istore 4
    //   38: iload_0
    //   39: tableswitch	default:+25 -> 64, 0:+222->261, 1:+230->269, 2:+230->269
    //   65: lconst_0
    //   66: istore 6
    //   68: iload 4
    //   70: istore 7
    //   72: iconst_1
    //   73: istore_3
    //   74: iload 7
    //   76: istore 4
    //   78: iload 6
    //   80: istore 5
    //   82: iload_3
    //   83: iconst_2
    //   84: if_icmpne +400 -> 484
    //   87: iconst_1
    //   88: istore 6
    //   90: ldc 96
    //   92: new 192	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 761
    //   99: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: iload_0
    //   103: invokevirtual 764	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc_w 766
    //   109: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload_3
    //   113: invokevirtual 764	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 768
    //   119: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: iload 5
    //   124: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: ldc_w 773
    //   130: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 4
    //   135: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: ldc_w 775
    //   141: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 777
    //   151: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload 8
    //   166: ifne +5 -> 171
    //   169: iconst_1
    //   170: istore_3
    //   171: iload 8
    //   173: ifeq +317 -> 490
    //   176: iload 6
    //   178: ifeq +312 -> 490
    //   181: iconst_1
    //   182: istore_0
    //   183: getstatic 304	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   186: sipush 1579
    //   189: iload_0
    //   190: invokevirtual 781	com/tencent/mm/plugin/report/service/h:el	(II)V
    //   193: ldc 96
    //   195: new 192	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 783
    //   202: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: iload 8
    //   207: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   210: ldc_w 785
    //   213: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 6
    //   218: invokevirtual 771	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   221: ldc_w 787
    //   224: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload_0
    //   228: invokevirtual 764	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 766
    //   234: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: iload_3
    //   238: invokevirtual 764	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: ldc_w 753
    //   250: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: iload_3
    //   254: ireturn
    //   255: iconst_0
    //   256: istore 8
    //   258: goto -235 -> 23
    //   261: iconst_1
    //   262: istore_3
    //   263: iconst_0
    //   264: istore 4
    //   266: goto -184 -> 82
    //   269: iconst_0
    //   270: istore 5
    //   272: bipush 6
    //   274: invokestatic 225	com/tencent/mm/modelcontrol/e:vW	(I)Z
    //   277: istore 4
    //   279: iload 4
    //   281: istore 5
    //   283: aload_1
    //   284: invokestatic 230	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   287: istore 9
    //   289: iload 9
    //   291: istore 5
    //   293: iload 5
    //   295: ifeq +9 -> 304
    //   298: aload_1
    //   299: invokestatic 235	com/tencent/mm/modelvideo/v:isH265Video	(Ljava/lang/String;)Z
    //   302: istore 6
    //   304: iload 4
    //   306: istore 7
    //   308: iload 6
    //   310: istore 4
    //   312: iload 7
    //   314: ifne +142 -> 456
    //   317: getstatic 603	android/os/Build:MODEL	Ljava/lang/String;
    //   320: invokevirtual 691	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   323: astore 10
    //   325: getstatic 304	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 19789
    //   331: iconst_5
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: ldc_w 789
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload 10
    //   345: aastore
    //   346: dup
    //   347: iconst_2
    //   348: iconst_0
    //   349: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: iconst_0
    //   356: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_4
    //   362: ldc 78
    //   364: aastore
    //   365: invokevirtual 792	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   368: iconst_1
    //   369: istore_3
    //   370: goto -288 -> 82
    //   373: astore 10
    //   375: iconst_0
    //   376: istore 4
    //   378: iload 5
    //   380: istore 6
    //   382: ldc 96
    //   384: new 192	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 794
    //   391: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload 10
    //   396: invokevirtual 795	java/lang/Throwable:toString	()Ljava/lang/String;
    //   399: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: iload 4
    //   410: istore 5
    //   412: iload 7
    //   414: istore 4
    //   416: iload 6
    //   418: istore 7
    //   420: goto -108 -> 312
    //   423: astore 10
    //   425: ldc 96
    //   427: new 192	java/lang/StringBuilder
    //   430: dup
    //   431: ldc_w 797
    //   434: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   437: aload 10
    //   439: invokevirtual 795	java/lang/Throwable:toString	()Ljava/lang/String;
    //   442: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: iconst_1
    //   452: istore_3
    //   453: goto -371 -> 82
    //   456: iload 5
    //   458: ifne +8 -> 466
    //   461: iconst_2
    //   462: istore_3
    //   463: goto -381 -> 82
    //   466: iload 4
    //   468: istore 7
    //   470: iload 5
    //   472: istore 6
    //   474: iload 4
    //   476: ifeq -404 -> 72
    //   479: iconst_2
    //   480: istore_3
    //   481: goto -399 -> 82
    //   484: iconst_0
    //   485: istore 6
    //   487: goto -397 -> 90
    //   490: iload 8
    //   492: ifne +8 -> 500
    //   495: iconst_2
    //   496: istore_0
    //   497: goto -314 -> 183
    //   500: iconst_3
    //   501: istore_0
    //   502: goto -319 -> 183
    //   505: astore 10
    //   507: iload 4
    //   509: istore 6
    //   511: iload 5
    //   513: istore 4
    //   515: goto -133 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramInt	int
    //   0	518	1	paramString1	String
    //   0	518	2	paramString2	String
    //   73	408	3	i	int
    //   36	478	4	bool1	boolean
    //   24	488	5	bool2	boolean
    //   30	480	6	bool3	boolean
    //   33	436	7	bool4	boolean
    //   21	470	8	bool5	boolean
    //   27	263	9	bool6	boolean
    //   323	21	10	str	String
    //   373	22	10	localThrowable1	java.lang.Throwable
    //   423	15	10	localThrowable2	java.lang.Throwable
    //   505	1	10	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   272	279	373	java/lang/Throwable
    //   283	289	373	java/lang/Throwable
    //   317	368	423	java/lang/Throwable
    //   298	304	505	java/lang/Throwable
  }
  
  private static VideoTransPara vV(int paramInt)
  {
    AppMethodBeat.i(126763);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.lJx = true;
    localVideoTransPara.kXt = 1;
    localVideoTransPara.audioBitrate = 48000;
    localVideoTransPara.lJm = 2;
    localVideoTransPara.lJn = 1;
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
  
  public static boolean vW(int paramInt)
  {
    boolean bool4 = false;
    AppMethodBeat.i(126772);
    int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vqs, Integer.valueOf(-1))).intValue();
    int i = j;
    if (j == -1) {
      if (!com.tencent.mm.plugin.u.f.eSH()) {
        break label94;
      }
    }
    label94:
    for (i = 1;; i = 0)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vqs, Integer.valueOf(i));
      Log.i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        break;
      }
      AppMethodBeat.o(126772);
      return false;
    }
    i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("VideoDownloadH265Flag", 0);
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      j = af.juS.jsd;
      if (j != -1) {
        if (j == 1) {
          bool1 = true;
        }
      }
      break;
    }
    label181:
    for (boolean bool2 = bool1;; bool2 = bool1)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevc, scene:%s, flag:%s, configResult:%s, dynamicConfigResult:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool2), Integer.valueOf(j) });
      if ((paramInt != 2) && (paramInt != 5))
      {
        bool1 = bool2;
        if (paramInt != 6) {}
      }
      else
      {
        bool1 = bool2;
        if (bool2)
        {
          String str1 = Build.MODEL.toLowerCase();
          String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvZ, "");
          boolean bool3 = bool2;
          if (!Util.isNullOrNil(str2))
          {
            bool3 = bool2;
            if (str2.contains(str1))
            {
              Log.i("MicroMsg.SubCoreVideoControl", "model %s is hit, expt:%s", new Object[] { str1, str2 });
              bool3 = false;
            }
          }
          bool1 = bool3;
          if (paramInt == 6)
          {
            bool1 = bool3;
            if (bool3)
            {
              str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvg, "");
              bool1 = bool3;
              if (!Util.isNullOrNil(str2))
              {
                bool1 = bool3;
                if (str2.contains(str1))
                {
                  Log.i("MicroMsg.SubCoreVideoControl", "ad model %s is hit, expt:%s", new Object[] { str1, str2 });
                  bool1 = false;
                }
              }
            }
          }
        }
      }
      if ((paramInt == 5) && (bool1))
      {
        bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIH, false);
        Log.i("MicroMsg.SubCoreVideoControl", "further check checkDeviceSupportHevc bH265PlayDisabled:%b ", new Object[] { Boolean.valueOf(bool2) });
        if (bool2)
        {
          Log.i("MicroMsg.SubCoreVideoControl", "model %s is hit", new Object[] { Build.MODEL.toLowerCase() });
          bool1 = bool4;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(126772);
        return bool1;
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
        for (bool1 = true; BuildInfo.DEBUG; bool1 = false)
        {
          bool1 = true;
          break;
        }
        if ((i & 0x10) != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          if (!BuildInfo.DEBUG) {
            break label598;
          }
          break;
        }
        label598:
        break;
        bool1 = false;
        break label181;
      }
    }
  }
  
  public final boolean VE(String paramString)
  {
    AppMethodBeat.i(126753);
    if (this.lIZ == null) {
      this.lIZ = new com.tencent.mm.plugin.a.b();
    }
    localObject1 = this.lIZ;
    ((com.tencent.mm.plugin.a.b)localObject1).mHg = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).mHi = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).mHj = null;
    long l1 = Util.currentTicks();
    long l2 = this.lIZ.ZY(paramString);
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
      localRandomAccessFile = u.dO(paramString, false);
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      localRandomAccessFile.seek(l2);
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      byte[] arrayOfByte = new byte[8];
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      localObject3 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, com.tencent.mm.plugin.a.a.aVL);
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
        localObject5 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, lIW);
        localObject4 = localObject5;
        if (localObject5 != null) {
          break;
        }
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localRandomAccessFile.seek(((com.tencent.mm.plugin.a.a)localObject3).getEndPos());
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject3 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, com.tencent.mm.plugin.a.a.aVL);
      }
      localObject3 = localObject7;
      if (localObject4 != null)
      {
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject5 = new byte[(int)localObject4.getSize() - 8];
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localRandomAccessFile.seek(localObject4.mHf + 8L);
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
        Log.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", new Object[] { paramString, localException.toString() });
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
    Log.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", new Object[] { localObject2, Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l1)), paramString });
    if (!Util.isNullOrNil(localObject2))
    {
      bool = localObject2.contains("WXVer");
      AppMethodBeat.o(126753);
      return bool;
    }
  }
  
  public final VideoTransPara bkq()
  {
    AppMethodBeat.i(126754);
    long l = Util.currentTicks();
    if (this.lJa == null) {
      this.lJa = VD("C2CRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.lJa != null)
    {
      i = 0;
      if (i < this.lJa.length)
      {
        localObject = this.lJa[i];
        if ((localObject != null) && (((f)localObject).bkE()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
          localVideoTransPara = ((f)localObject).bkF();
        }
      }
    }
    for (boolean bool = ((f)localObject).lJo;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = new VideoTransPara();
        ((VideoTransPara)localObject).lJx = true;
        ((VideoTransPara)localObject).width = 540;
        ((VideoTransPara)localObject).height = 960;
        ((VideoTransPara)localObject).fps = 30;
        ((VideoTransPara)localObject).videoBitrate = 1200000;
        ((VideoTransPara)localObject).kXt = 10;
        ((VideoTransPara)localObject).audioBitrate = 64000;
        ((VideoTransPara)localObject).lJm = 2;
        ((VideoTransPara)localObject).lJn = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).kXt = 10;
      localVideoTransPara = a((VideoTransPara)localObject, 1);
      localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtV, 30);
      if (!bool) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 11L, 1L, false);
      }
      for (;;)
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 13, 18));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, i, 1L, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126754);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 12L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bkr()
  {
    AppMethodBeat.i(126755);
    long l = Util.currentTicks();
    if (this.lJb == null) {
      this.lJb = VD("SnsRecordVideoConfig");
    }
    int i;
    f localf;
    VideoTransPara localVideoTransPara;
    if (this.lJb != null)
    {
      i = 0;
      if (i < this.lJb.length)
      {
        localf = this.lJb[i];
        if ((localf != null) && (localf.bkE()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = localf.bkF();
        }
      }
    }
    for (boolean bool = localf.lJo;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = bkx();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.kXt = 10;
        localVideoTransPara.lJy = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtT, 30);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, i, 1L, false);
          Log.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126755);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bks()
  {
    AppMethodBeat.i(126756);
    long l = Util.currentTicks();
    if (this.lJc == null) {
      this.lJc = VD("SnsAlbumVideoConfig");
    }
    int i;
    f localf;
    VideoTransPara localVideoTransPara;
    if (this.lJc != null)
    {
      i = 0;
      if (i < this.lJc.length)
      {
        localf = this.lJc[i];
        if ((localf != null) && (localf.bkE()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
          localVideoTransPara = localf.bkF();
        }
      }
    }
    for (boolean bool = localf.lJo;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = bkx();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.kXt = 10;
        localVideoTransPara.lJy = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtU, 30);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 21L, 1L, false);
        }
        for (;;)
        {
          i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 23, 28));
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, i, 1L, false);
          Log.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126756);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 22L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bkt()
  {
    AppMethodBeat.i(126758);
    long l = Util.currentTicks();
    if (this.lJd == null) {
      this.lJd = VD("StoryRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.lJd != null)
    {
      i = 0;
      if (i < this.lJd.length)
      {
        localObject = this.lJd[i];
        if ((localObject != null) && (((f)localObject).bkE()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
          localVideoTransPara = ((f)localObject).bkF();
        }
      }
    }
    for (boolean bool = ((f)localObject).lJo;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = new VideoTransPara();
        ((VideoTransPara)localObject).lJx = true;
        ((VideoTransPara)localObject).width = 720;
        ((VideoTransPara)localObject).height = 1280;
        ((VideoTransPara)localObject).fps = 30;
        ((VideoTransPara)localObject).videoBitrate = 3500000;
        ((VideoTransPara)localObject).kXt = 10;
        ((VideoTransPara)localObject).audioBitrate = 48000;
        ((VideoTransPara)localObject).lJm = 2;
        ((VideoTransPara)localObject).lJn = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).kXt = 10;
      ((VideoTransPara)localObject).lJy = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 3);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvP, 15);
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, i, 1L, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126758);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bku()
  {
    AppMethodBeat.i(169097);
    long l = Util.currentTicks();
    if (this.lJe == null) {
      this.lJe = VD("FinderRecordVideoConfig");
    }
    int i;
    if (this.lJe != null)
    {
      i = 0;
      if (i < this.lJe.length)
      {
        localObject1 = this.lJe[i];
        if ((localObject1 != null) && (((f)localObject1).bkE())) {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((f)localObject1).bkG();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bky();
      }
      if (Log.getLogLevel() <= 1)
      {
        i = MMApplicationContext.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).lJy = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHF, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHG, 1);
      Log.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
      AppMethodBeat.o(169097);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara bkv()
  {
    AppMethodBeat.i(169098);
    long l = Util.currentTicks();
    if (this.lJf == null) {
      this.lJf = VD("FinderPublishVideoConfig");
    }
    int i;
    if (this.lJf != null)
    {
      i = 0;
      if (i < this.lJf.length)
      {
        localObject1 = this.lJf[i];
        if ((localObject1 != null) && (((f)localObject1).bkE())) {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((f)localObject1).bkG();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bky();
      }
      if (Log.getLogLevel() <= 1)
      {
        i = MMApplicationContext.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).lJy = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHH, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHI, 1);
      Log.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
      AppMethodBeat.o(169098);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara bkw()
  {
    AppMethodBeat.i(126761);
    long l = Util.currentTicks();
    if (this.lJk == null) {
      this.lJk = VD("NearbyRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.lJk != null)
    {
      i = 0;
      if (i < this.lJk.length)
      {
        localObject = this.lJk[i];
        if ((localObject != null) && (((f)localObject).bkE()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
          localVideoTransPara = ((f)localObject).bkF();
        }
      }
    }
    for (boolean bool = ((f)localObject).lJo;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null) {
        localObject = bkx();
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).kXt = 10;
      ((VideoTransPara)localObject).lJy = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 2);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = 10;
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, i, 1L, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126761);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara c(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(126760);
    if (paramVideoTransPara == null)
    {
      Log.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
      AppMethodBeat.o(126760);
      return null;
    }
    int i = paramVideoTransPara.duration;
    Object localObject1 = com.tencent.mm.n.a.jwk;
    if (i >= com.tencent.mm.n.a.awa())
    {
      Log.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(126760);
      return null;
    }
    long l = Util.currentTicks();
    VideoTransPara localVideoTransPara = vV(paramVideoTransPara.duration);
    boolean bool = true;
    i = 1;
    localObject1 = com.tencent.mm.model.c.d.bgB().Mu("100157");
    if (((com.tencent.mm.storage.c)localObject1).isValid()) {
      i = Util.getInt((String)((com.tencent.mm.storage.c)localObject1).hvz().get("VideoEncodeStep"), 1);
    }
    Log.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      i = 1;
      if (i == 0) {
        break label409;
      }
      if (this.lJj == null) {
        this.lJj = VD("C2CAlbumVideoStepConfig");
      }
      localObject1 = this.lJj;
      label183:
      if (localObject1 == null) {
        break label447;
      }
      i = 0;
      label190:
      if (i >= localObject1.length) {
        break label442;
      }
      Object localObject2 = localObject1[i];
      if ((localObject2 == null) || (!localObject2.bkE())) {
        break label435;
      }
      Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
      i = a.a(localObject2.lJp, paramVideoTransPara, localVideoTransPara);
      bool = localObject2.lJo;
      label243:
      if (i > 0) {
        break label466;
      }
      localObject1 = vV(paramVideoTransPara.duration);
      label256:
      localObject1 = a((VideoTransPara)localObject1, 1);
      if (bool) {
        break label479;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 1L, 1L, false);
    }
    for (;;)
    {
      int j = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(((VideoTransPara)localObject1).videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 3, 8));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, j, 1L, false);
      Log.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(j), Integer.valueOf(i), localObject1, paramVideoTransPara });
      AppMethodBeat.o(126760);
      return localObject1;
      i = 0;
      break;
      label409:
      if (this.lJi == null) {
        this.lJi = VD("C2CAlbumVideoConfig");
      }
      localObject1 = this.lJi;
      break label183;
      label435:
      i += 1;
      break label190;
      label442:
      i = 0;
      break label243;
      label447:
      Log.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
      i = a.a(null, paramVideoTransPara, localVideoTransPara);
      break label243;
      label466:
      localVideoTransPara.lJx = false;
      localObject1 = localVideoTransPara;
      break label256;
      label479:
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(422L, 2L, 1L, false);
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
    if (Util.isNullOrNil(this.lIY)) {}
    try
    {
      Object localObject = "{\"WXVer\":" + com.tencent.mm.protocal.d.RAD + "}";
      this.lIY = ((String)localObject).getBytes("UTF-8");
      Log.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[] { localObject });
      localObject = this.lIY;
      AppMethodBeat.o(126752);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[] { localException.toString() });
      }
    }
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease()
  {
    this.lJa = null;
    this.lJj = null;
    this.lJi = null;
    this.lJb = null;
    this.lJc = null;
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final VideoTransPara vT(int paramInt)
  {
    AppMethodBeat.i(216183);
    long l = Util.currentTicks();
    if (this.lJg == null) {
      this.lJg = VD("PublishMegaVideoConfig");
    }
    int i;
    if (this.lJg != null)
    {
      i = 0;
      if (i < this.lJg.length)
      {
        localObject1 = this.lJg[i];
        if ((localObject1 != null) && (((f)localObject1).bkE())) {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((f)localObject1).bkG();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bky();
      }
      if (Log.getLogLevel() <= 1)
      {
        i = MMApplicationContext.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).lJy = 720;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = paramInt;
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHH, 60);
      Log.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
      AppMethodBeat.o(216183);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara vU(int paramInt)
  {
    AppMethodBeat.i(126759);
    long l = Util.currentTicks();
    int i;
    if (this.lJh == null)
    {
      if (paramInt == 1) {
        this.lJh = VD("GameRecordBigVideoConfig");
      }
    }
    else
    {
      if (this.lJh == null) {
        break label362;
      }
      i = 0;
      label41:
      if (i >= this.lJh.length) {
        break label362;
      }
      localObject1 = this.lJh[i];
      if ((localObject1 == null) || (!((f)localObject1).bkE())) {
        break label266;
      }
      Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get game Record config.");
    }
    label266:
    label273:
    label362:
    for (Object localObject1 = ((f)localObject1).bkF();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramInt != 1) {
          break label273;
        }
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).lJx = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).kXt = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).lJm = 2;
        ((VideoTransPara)localObject2).lJn = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
      for (((VideoTransPara)localObject2).audioChannelCount = 1;; ((VideoTransPara)localObject2).audioChannelCount = 1)
      {
        ((VideoTransPara)localObject2).audioSampleRate = 44100;
        ((VideoTransPara)localObject2).kXt = 10;
        ((VideoTransPara)localObject2).lJy = 200;
        localObject1 = a((VideoTransPara)localObject2, 1);
        Log.i("MicroMsg.SubCoreVideoControl", "get game record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
        AppMethodBeat.o(126759);
        return localObject1;
        this.lJh = VD("GameRecordVideoConfig");
        break;
        i += 1;
        break label41;
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).lJx = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).kXt = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).lJm = 2;
        ((VideoTransPara)localObject2).lJn = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */