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
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.be;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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

public class e
  implements be
{
  private static final int oBx;
  private com.tencent.mm.plugin.a.b oBA;
  private f[] oBB;
  private f[] oBC;
  private f[] oBD;
  private f[] oBE;
  private f[] oBF;
  private f[] oBG;
  private f[] oBH;
  private f[] oBI;
  private f[] oBJ;
  private f[] oBK;
  private f[] oBL;
  private f[] oBM;
  private a oBy;
  private byte[] oBz;
  
  static
  {
    AppMethodBeat.i(126773);
    oBx = com.tencent.mm.plugin.a.c.du("dscp");
    AppMethodBeat.o(126773);
  }
  
  public e()
  {
    AppMethodBeat.i(126747);
    this.oBz = null;
    this.oBy = new a();
    AppMethodBeat.o(126747);
  }
  
  private static f K(JSONObject paramJSONObject)
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
        if ((((List)localObject1).size() >= 2) && (!localf.oBQ))
        {
          j = ((g)((List)localObject1).get(0)).oBY;
          i = 1;
          if (i < ((List)localObject1).size())
          {
            paramJSONObject = (g)((List)localObject1).get(i);
            paramJSONObject.oBX = j;
            j = paramJSONObject.oBY;
            i += 1;
            continue;
          }
        }
        localf.oBR = new g[((List)localObject1).size()];
        ((List)localObject1).toArray(localf.oBR);
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
  
  private f[] NC(String paramString)
  {
    AppMethodBeat.i(126749);
    String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue(paramString);
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[] { paramString });
      AppMethodBeat.o(126749);
      return null;
    }
    Log.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[] { paramString, str });
    paramString = ND(str);
    AppMethodBeat.o(126749);
    return paramString;
  }
  
  private static f[] ND(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(233805);
    Object localObject = paramString;
    if (!paramString.startsWith("[")) {
      localObject = "[".concat(String.valueOf(paramString));
    }
    paramString = (String)localObject;
    if (!((String)localObject).endsWith("]")) {
      paramString = (String)localObject + "]";
    }
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      Log.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[] { Integer.valueOf(j) });
      localObject = new f[j];
      while (i < j)
      {
        localObject[i] = K(paramString.getJSONObject(i));
        i += 1;
      }
      AppMethodBeat.o(233805);
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + paramString.toString());
      AppMethodBeat.o(233805);
      return null;
    }
    return localObject;
  }
  
  public static int R(int paramInt, String paramString)
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
      if (!wb(2)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.y.ZC(paramString))
      {
        if (!com.tencent.mm.modelvideo.y.isH265Video(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public static int S(int paramInt, String paramString)
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
      if (!wb(3)) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.y.ZC(paramString))
      {
        if (!com.tencent.mm.modelvideo.y.isH265Video(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public static int a(int paramInt, z paramz)
  {
    AppMethodBeat.i(126767);
    switch (paramInt)
    {
    default: 
      paramInt = 1;
      Log.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 2) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 130L, 1L, false);
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(126767);
      return paramInt;
      paramInt = 1;
      break;
      paramInt = a(paramz);
      break;
      paramInt = a(paramz);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 131L, 1L, false);
    }
  }
  
  private static int a(z paramz)
  {
    int i = 1;
    AppMethodBeat.i(126768);
    if (!wb(1))
    {
      AppMethodBeat.o(126768);
      return 1;
    }
    v.bOh();
    paramz = aa.PX(paramz.getFileName());
    if (!com.tencent.mm.vfs.y.ZC(paramz))
    {
      AppMethodBeat.o(126768);
      return 2;
    }
    if (!com.tencent.mm.modelvideo.y.isH265Video(paramz)) {}
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
    label142:
    int i;
    label328:
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
        paramVideoTransPara.oCb = 0;
        paramVideoTransPara.oCi = 0;
        paramVideoTransPara.oCc = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGV, 0);
        paramVideoTransPara.oCh = 0;
        if (paramVideoTransPara.oCc != 0)
        {
          paramVideoTransPara.nxU = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHD, 21);
          paramVideoTransPara.nxV = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHE, 39);
          paramVideoTransPara.oCk = paramVideoTransPara.videoBitrate;
          paramVideoTransPara.oCl = paramInt;
          i = m.aOK() & 0xFF;
          if ((i < 30) || (Build.VERSION.SDK_INT <= 25)) {
            paramVideoTransPara.oCb = 0;
          }
          Log.i("MicroMsg.SubCoreVideoControl", "ABA: Prams abaSwitch: [%d]  qpSwitch: [%d] swHevcRatio: [%f] hwHevcRatio: [%f] ceilingVideoBR: [%d] flooringVideoBR:[%d] minQP: [%d] maxQP: [%d] CPUlevel: [%d] AndroidVersionSDK: [%d] remuxSecene: [%d] isEnable1080p: [%d] maxVideoSize: [%d]", new Object[] { Integer.valueOf(paramVideoTransPara.oCb), Integer.valueOf(paramVideoTransPara.oCc), Float.valueOf(paramVideoTransPara.oCd), Float.valueOf(paramVideoTransPara.oCe), Integer.valueOf(paramVideoTransPara.oCf), Integer.valueOf(paramVideoTransPara.oCg), Integer.valueOf(paramVideoTransPara.nxU), Integer.valueOf(paramVideoTransPara.nxV), Integer.valueOf(i), Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramVideoTransPara.oCl), Integer.valueOf(paramVideoTransPara.oCi), Integer.valueOf(paramVideoTransPara.oCj) });
          localObject = MultiProcessMMKV.getMMKV("HardcoderQP");
          if (localObject != null)
          {
            str = ((MultiProcessMMKV)localObject).decodeString("HCMinQPKey", null);
            localObject = ((MultiProcessMMKV)localObject).decodeString("HCMaxQPKey", null);
            if ((str != null) && (localObject != null))
            {
              bool2 = false;
              i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGV, 0);
              j = af.lYf.lWY;
              if (j != 0) {
                break label1134;
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
        j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHD, 21);
        i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHE, 39);
        j = Math.max(0, Math.min(51, j));
        i = Math.max(0, Math.min(51, i));
        if ((j != 0) && (i != 51))
        {
          paramVideoTransPara.nxU = j;
          paramVideoTransPara.nxV = i;
          Log.i("MicroMsg.SubCoreVideoControl", "steve:[hardcoder] get hardcoder QP key: min:%s, max:%s, value: minQP:%d, maxQP:%d, Scence:%d", new Object[] { str, localObject, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) });
        }
      }
      AppMethodBeat.o(126757);
      return paramVideoTransPara;
      paramVideoTransPara.oCb = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGS, 1);
      paramVideoTransPara.oCi = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHG, 0);
      paramVideoTransPara.oCf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHb, 10);
      paramVideoTransPara.oCg = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHc, 10);
      paramVideoTransPara.oCj = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHd, 36);
      paramVideoTransPara.oCd = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGX, 0.7F);
      paramVideoTransPara.oCe = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGY, 1.0F);
      break;
      paramVideoTransPara.oCb = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGT, 1);
      paramVideoTransPara.oCi = 0;
      paramVideoTransPara.oCf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHe, 25);
      paramVideoTransPara.oCg = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHg, 10);
      paramVideoTransPara.oCj = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHh, 36);
      paramVideoTransPara.oCd = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGZ, 0.7F);
      paramVideoTransPara.oCe = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHa, 1.0F);
      break;
      paramVideoTransPara.oCb = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGU, 1);
      paramVideoTransPara.oCi = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHF, 0);
      paramVideoTransPara.oCf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHb, 10);
      paramVideoTransPara.oCg = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHc, 10);
      paramVideoTransPara.oCj = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHd, 36);
      paramVideoTransPara.oCd = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGX, 0.7F);
      paramVideoTransPara.oCe = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGY, 1.0F);
      break;
      paramVideoTransPara.nxU = 0;
      paramVideoTransPara.nxV = 51;
      break label142;
      paramVideoTransPara.oCb = 0;
      paramVideoTransPara.oCc = 0;
      paramVideoTransPara.oCk = paramVideoTransPara.videoBitrate;
      paramVideoTransPara.nxU = 0;
      paramVideoTransPara.nxV = 51;
      Log.i("MicroMsg.SubCoreVideoControl", "ABA: it does not use the ABA or MinMax QP Limitation");
      break label328;
      label1134:
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
  
  public static e bIg()
  {
    AppMethodBeat.i(126748);
    e locale = (e)com.tencent.mm.model.y.aL(e.class);
    AppMethodBeat.o(126748);
    return locale;
  }
  
  private f[] bIo()
  {
    AppMethodBeat.i(233812);
    if (bIs()) {
      if (this.oBL == null) {
        this.oBL = NC("C2CAlbumVideoStepConfig");
      }
    }
    for (f[] arrayOff = this.oBL;; arrayOff = this.oBK)
    {
      AppMethodBeat.o(233812);
      return arrayOff;
      if (this.oBK == null) {
        this.oBK = NC("C2CAlbumVideoConfig");
      }
    }
  }
  
  private static VideoTransPara bIq()
  {
    AppMethodBeat.i(126762);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.oBZ = true;
    localVideoTransPara.width = 720;
    localVideoTransPara.height = 1280;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.nCd = 10;
    localVideoTransPara.audioBitrate = 64000;
    localVideoTransPara.oBO = 2;
    localVideoTransPara.oBP = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(126762);
    return localVideoTransPara;
  }
  
  private static VideoTransPara bIr()
  {
    AppMethodBeat.i(169099);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.oBZ = true;
    localVideoTransPara.width = 1072;
    localVideoTransPara.height = ((int)(localVideoTransPara.width * 3.5F / 3.0D));
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 2000000;
    localVideoTransPara.nCd = 1;
    localVideoTransPara.audioBitrate = 128000;
    localVideoTransPara.oBO = 2;
    localVideoTransPara.oBP = 1;
    localVideoTransPara.audioChannelCount = 1;
    AppMethodBeat.o(169099);
    return localVideoTransPara;
  }
  
  private static boolean bIs()
  {
    AppMethodBeat.i(233816);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100157");
    if ((localc != null) && (localc.isValid())) {}
    for (int i = Util.getInt((String)localc.iWZ().get("VideoEncodeStep"), 1);; i = 1)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(233816);
        return true;
      }
      AppMethodBeat.o(233816);
      return false;
    }
  }
  
  public static boolean bIt()
  {
    AppMethodBeat.i(126764);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNY, Integer.valueOf(-1))).intValue();
    boolean bool2 = bIv();
    if ((i == 0) || (!bool2)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(1) });
      AppMethodBeat.o(126764);
      return bool1;
    }
  }
  
  public static boolean bIu()
  {
    AppMethodBeat.i(126765);
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNY, Integer.valueOf(-1))).intValue();
    boolean bool2 = bIv();
    if ((i == 0) || (!bool2)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(1) });
      AppMethodBeat.o(126765);
      return bool1;
    }
  }
  
  public static boolean bIv()
  {
    AppMethodBeat.i(126766);
    long l = Util.currentTicks();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNY, Integer.valueOf(-1))).intValue();
    int j = Build.VERSION.SDK_INT;
    String str = Build.BRAND + q.aPo();
    if (!Util.isNullOrNil(null)) {
      throw new NullPointerException();
    }
    for (;;)
    {
      if (!Util.isNullOrNil(null)) {
        throw new NullPointerException();
      }
      if (com.tencent.mm.compatible.util.d.rc(18)) {
        bool = false;
      }
      if (Build.BRAND.equalsIgnoreCase("meizu")) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acPO, Boolean.TRUE);
      }
      if (i == 0) {
        bool = false;
      }
      Log.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), null, str, null, Integer.valueOf(1), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(126766);
      return bool;
      boolean bool = true;
    }
  }
  
  public static boolean bIw()
  {
    String str = null;
    AppMethodBeat.i(126771);
    if (Util.isNullOrNil(null)) {
      str = "20:00-23:30";
    }
    com.tencent.mm.kernel.h.baC();
    int i = i.jdMethod_do(com.tencent.mm.kernel.b.getUin(), 30);
    boolean bool = b.aU(str, i);
    Log.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[] { Boolean.valueOf(bool), str, Integer.valueOf(i) });
    if (!bool)
    {
      AppMethodBeat.o(126771);
      return true;
    }
    AppMethodBeat.o(126771);
    return false;
  }
  
  public static boolean bIx()
  {
    AppMethodBeat.i(233840);
    boolean bool = com.tencent.mm.plugin.u.f.gbE();
    Log.i("MicroMsg.SubCoreVideoControl", "check device support hevcenc[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "no hevc encoder found!");
      AppMethodBeat.o(233840);
      return false;
    }
    bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yYM, false);
    Log.i("MicroMsg.SubCoreVideoControl", "further check checkDeviceSupportHevcEnc bH265EncDisabled:%b ", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      Log.i("MicroMsg.SubCoreVideoControl", "model %s is hit", new Object[] { q.aPo().toLowerCase() });
    }
    for (bool = false;; bool = true)
    {
      Log.i("MicroMsg.SubCoreVideoControl", "check checkDeviceSupportHevcEnc, scene:%s, configResult:%s", new Object[] { Integer.valueOf(5), Boolean.valueOf(bool) });
      AppMethodBeat.o(233840);
      return bool;
    }
  }
  
  /* Error */
  public static int m(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 778
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +248 -> 255
    //   10: aload_2
    //   11: ldc_w 780
    //   14: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   90: ldc 97
    //   92: new 193	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 786
    //   99: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: iload_0
    //   103: invokevirtual 789	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc_w 791
    //   109: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload_3
    //   113: invokevirtual 789	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 793
    //   119: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: iload 5
    //   124: invokevirtual 796	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: ldc_w 798
    //   130: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 4
    //   135: invokevirtual 796	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: ldc_w 800
    //   141: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 802
    //   151: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   183: getstatic 309	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   186: sipush 1579
    //   189: iload_0
    //   190: invokevirtual 806	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   193: ldc 97
    //   195: new 193	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 808
    //   202: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: iload 8
    //   207: invokevirtual 796	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   210: ldc_w 810
    //   213: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 6
    //   218: invokevirtual 796	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   221: ldc_w 812
    //   224: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload_0
    //   228: invokevirtual 789	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 791
    //   234: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: iload_3
    //   238: invokevirtual 789	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 518	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: ldc_w 778
    //   250: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   274: invokestatic 285	com/tencent/mm/modelcontrol/e:wb	(I)Z
    //   277: istore 4
    //   279: iload 4
    //   281: istore 5
    //   283: aload_1
    //   284: invokestatic 290	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   287: istore 9
    //   289: iload 9
    //   291: istore 5
    //   293: iload 5
    //   295: ifeq +9 -> 304
    //   298: aload_1
    //   299: invokestatic 295	com/tencent/mm/modelvideo/y:isH265Video	(Ljava/lang/String;)Z
    //   302: istore 6
    //   304: iload 4
    //   306: istore 7
    //   308: iload 6
    //   310: istore 4
    //   312: iload 7
    //   314: ifne +142 -> 456
    //   317: invokestatic 688	com/tencent/mm/compatible/deviceinfo/q:aPo	()Ljava/lang/String;
    //   320: invokevirtual 773	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   323: astore 10
    //   325: getstatic 309	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 19789
    //   331: iconst_5
    //   332: anewarray 4	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: ldc_w 814
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload 10
    //   345: aastore
    //   346: dup
    //   347: iconst_2
    //   348: iconst_0
    //   349: invokestatic 272	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: iconst_0
    //   356: invokestatic 272	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_4
    //   362: ldc 79
    //   364: aastore
    //   365: invokevirtual 817	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   368: iconst_1
    //   369: istore_3
    //   370: goto -288 -> 82
    //   373: astore 10
    //   375: iconst_0
    //   376: istore 4
    //   378: iload 5
    //   380: istore 6
    //   382: ldc 97
    //   384: new 193	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 819
    //   391: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload 10
    //   396: invokevirtual 822	java/lang/Throwable:toString	()Ljava/lang/String;
    //   399: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: iload 4
    //   410: istore 5
    //   412: iload 7
    //   414: istore 4
    //   416: iload 6
    //   418: istore 7
    //   420: goto -108 -> 312
    //   423: astore 10
    //   425: ldc 97
    //   427: new 193	java/lang/StringBuilder
    //   430: dup
    //   431: ldc_w 824
    //   434: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   437: aload 10
    //   439: invokevirtual 822	java/lang/Throwable:toString	()Ljava/lang/String;
    //   442: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   373	22	10	localObject1	Object
    //   423	15	10	localObject2	Object
    //   505	1	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   272	279	373	finally
    //   283	289	373	finally
    //   317	368	423	finally
    //   298	304	505	finally
  }
  
  private static VideoTransPara wa(int paramInt)
  {
    AppMethodBeat.i(126763);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.oBZ = true;
    localVideoTransPara.nCd = 1;
    localVideoTransPara.audioBitrate = 48000;
    localVideoTransPara.oBO = 2;
    localVideoTransPara.oBP = 1;
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
  
  public static boolean wb(int paramInt)
  {
    boolean bool4 = false;
    AppMethodBeat.i(126772);
    int j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acRU, Integer.valueOf(-1))).intValue();
    int i = j;
    if (j == -1) {
      if (!com.tencent.mm.plugin.u.f.gbA()) {
        break label94;
      }
    }
    label94:
    for (i = 1;; i = 0)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acRU, Integer.valueOf(i));
      Log.i("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        break;
      }
      AppMethodBeat.o(126772);
      return false;
    }
    i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("VideoDownloadH265Flag", 0);
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
      j = af.lYj.lVs;
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
          String str1 = q.aPo().toLowerCase();
          String str2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yJa, "");
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
              str2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIc, "");
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
        bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yYL, false);
        Log.i("MicroMsg.SubCoreVideoControl", "further check checkDeviceSupportHevc bH265PlayDisabled:%b ", new Object[] { Boolean.valueOf(bool2) });
        if (bool2)
        {
          Log.i("MicroMsg.SubCoreVideoControl", "model %s is hit", new Object[] { q.aPo().toLowerCase() });
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
  
  public final boolean NE(String paramString)
  {
    AppMethodBeat.i(126753);
    if (this.oBA == null) {
      this.oBA = new com.tencent.mm.plugin.a.b();
    }
    localObject1 = this.oBA;
    ((com.tencent.mm.plugin.a.b)localObject1).pDH = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).fileLength = -1L;
    ((com.tencent.mm.plugin.a.b)localObject1).pDJ = null;
    long l1 = Util.currentTicks();
    long l2 = this.oBA.Sl(paramString);
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
      localRandomAccessFile = com.tencent.mm.vfs.y.eA(paramString, false);
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      localRandomAccessFile.seek(l2);
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      byte[] arrayOfByte = new byte[8];
      localObject1 = localRandomAccessFile;
      localObject2 = localRandomAccessFile;
      localObject3 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, com.tencent.mm.plugin.a.a.cPH);
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
        localObject5 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, oBx);
        localObject4 = localObject5;
        if (localObject5 != null) {
          break;
        }
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localRandomAccessFile.seek(((com.tencent.mm.plugin.a.a)localObject3).getEndPos());
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject3 = com.tencent.mm.plugin.a.c.a(localRandomAccessFile, arrayOfByte, com.tencent.mm.plugin.a.a.cPH);
      }
      localObject3 = localObject7;
      if (localObject4 != null)
      {
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localObject5 = new byte[(int)localObject4.getSize() - 8];
        localObject1 = localRandomAccessFile;
        localObject2 = localRandomAccessFile;
        localRandomAccessFile.seek(localObject4.pDG + 8L);
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
  
  public final VideoTransPara a(VideoTransPara paramVideoTransPara, String paramString)
  {
    AppMethodBeat.i(233881);
    if (paramVideoTransPara == null)
    {
      Log.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
      AppMethodBeat.o(233881);
      return null;
    }
    int i = paramVideoTransPara.duration;
    Object localObject1 = com.tencent.mm.k.a.lZC;
    if (i >= com.tencent.mm.k.a.aQy())
    {
      Log.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[] { Integer.valueOf(300) });
      AppMethodBeat.o(233881);
      return null;
    }
    long l = Util.currentTicks();
    localObject1 = wa(paramVideoTransPara.duration);
    boolean bool = true;
    if (Util.isNullOrNil(paramString))
    {
      paramString = bIo();
      if (paramString == null) {
        break label336;
      }
      i = 0;
      label107:
      if (i >= paramString.length) {
        break label331;
      }
      Object localObject2 = paramString[i];
      if ((localObject2 == null) || (!localObject2.bIy())) {
        break label324;
      }
      Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
      i = a.a(localObject2.oBR, paramVideoTransPara, (VideoTransPara)localObject1);
      bool = localObject2.oBQ;
      label158:
      if (i > 0) {
        break label355;
      }
      paramString = wa(paramVideoTransPara.duration);
      label170:
      paramString = a(paramString, 1);
      if (bool) {
        break label367;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 1L, 1L, false);
    }
    for (;;)
    {
      int j = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(paramString.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 3, 8));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, j, 1L, false);
      Log.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(j), Integer.valueOf(i), paramString, paramVideoTransPara });
      AppMethodBeat.o(233881);
      return paramString;
      paramString = ND(paramString);
      break;
      label324:
      i += 1;
      break label107;
      label331:
      i = 0;
      break label158;
      label336:
      Log.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
      i = a.a(null, paramVideoTransPara, (VideoTransPara)localObject1);
      break label158;
      label355:
      ((VideoTransPara)localObject1).oBZ = false;
      paramString = (String)localObject1;
      break label170;
      label367:
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 2L, 1L, false);
    }
  }
  
  public final VideoTransPara bIh()
  {
    AppMethodBeat.i(126754);
    long l = Util.currentTicks();
    if (this.oBB == null) {
      this.oBB = NC("C2CRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.oBB != null)
    {
      i = 0;
      if (i < this.oBB.length)
      {
        localObject = this.oBB[i];
        if ((localObject != null) && (((f)localObject).bIy()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
          localVideoTransPara = ((f)localObject).bIz();
        }
      }
    }
    for (boolean bool = ((f)localObject).oBQ;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = new VideoTransPara();
        ((VideoTransPara)localObject).oBZ = true;
        ((VideoTransPara)localObject).width = 540;
        ((VideoTransPara)localObject).height = 960;
        ((VideoTransPara)localObject).fps = 30;
        ((VideoTransPara)localObject).videoBitrate = 1200000;
        ((VideoTransPara)localObject).nCd = 10;
        ((VideoTransPara)localObject).audioBitrate = 64000;
        ((VideoTransPara)localObject).oBO = 2;
        ((VideoTransPara)localObject).oBP = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).nCd = 10;
      localVideoTransPara = a((VideoTransPara)localObject, 1);
      localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGz, 15);
      if (!bool) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 11L, 1L, false);
      }
      for (;;)
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 13, 18));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, i, 1L, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126754);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 12L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bIi()
  {
    AppMethodBeat.i(126755);
    long l = Util.currentTicks();
    if (this.oBC == null) {
      this.oBC = NC("SnsRecordVideoConfig");
    }
    int i;
    f localf;
    VideoTransPara localVideoTransPara;
    if (this.oBC != null)
    {
      i = 0;
      if (i < this.oBC.length)
      {
        localf = this.oBC[i];
        if ((localf != null) && (localf.bIy()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = localf.bIz();
        }
      }
    }
    for (boolean bool = localf.oBQ;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = bIq();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.nCd = 10;
        localVideoTransPara.oCa = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGx, 30);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, i, 1L, false);
          Log.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126755);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bIj()
  {
    AppMethodBeat.i(233854);
    Log.i("MicroMsg.SubCoreVideoControl", "getSnsTemplateVideoPara");
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWq, true);
    long l = Util.currentTicks();
    if ((this.oBD == null) || (bool)) {
      this.oBD = NC("SnsVideoTemplateVideoConfig");
    }
    int i;
    f localf;
    VideoTransPara localVideoTransPara;
    if (this.oBD != null)
    {
      i = 0;
      if (i < this.oBD.length)
      {
        localf = this.oBD[i];
        if ((localf != null) && (localf.bIy()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = localf.bIz();
        }
      }
    }
    for (bool = localf.oBQ;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = bIq();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.nCd = 10;
        localVideoTransPara.oCa = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeU, 60);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, i, 1L, false);
          Log.i("MicroMsg.SubCoreVideoControl", "get sns template para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(233854);
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bIk()
  {
    AppMethodBeat.i(126756);
    long l = Util.currentTicks();
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWq, true);
    boolean bool1;
    int i;
    label103:
    VideoTransPara localVideoTransPara;
    if ((this.oBE == null) || (bool2))
    {
      this.oBE = NC("SnsAlbumVideoConfig");
      if (this.oBE == null)
      {
        bool1 = true;
        Log.i("MicroMsg.SubCoreVideoControl", "snsAlbumControl is null:[%b] enable:[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    else
    {
      bool1 = true;
      if (this.oBE == null) {
        break label427;
      }
      i = 0;
      if (i >= this.oBE.length) {
        break label427;
      }
      f localf = this.oBE[i];
      if (localf != null) {
        Log.i("MicroMsg.SubCoreVideoControl", "index:%d content:%s", new Object[] { Integer.valueOf(i), localf.toString() });
      }
      if ((localf == null) || (!localf.bIy())) {
        break label400;
      }
      Log.i("MicroMsg.SubCoreVideoControl", "index:%d,it busy time, try to get sns album config.", new Object[] { Integer.valueOf(i) });
      localVideoTransPara = localf.bIz();
      bool1 = localf.oBQ;
    }
    for (;;)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = bIq();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.nCd = 10;
        localVideoTransPara.oCa = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGy, 30);
        localVideoTransPara = a(localVideoTransPara, 2);
        if (!bool1) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 21L, 1L, false);
        }
        for (;;)
        {
          i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 23, 28));
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, i, 1L, false);
          Log.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
          AppMethodBeat.o(126756);
          return localVideoTransPara;
          bool1 = false;
          break;
          label400:
          i += 1;
          break label103;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 22L, 1L, false);
        }
      }
      label427:
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bIl()
  {
    AppMethodBeat.i(126758);
    long l = Util.currentTicks();
    if (this.oBF == null) {
      this.oBF = NC("StoryRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.oBF != null)
    {
      i = 0;
      if (i < this.oBF.length)
      {
        localObject = this.oBF[i];
        if ((localObject != null) && (((f)localObject).bIy()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
          localVideoTransPara = ((f)localObject).bIz();
        }
      }
    }
    for (boolean bool = ((f)localObject).oBQ;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = new VideoTransPara();
        ((VideoTransPara)localObject).oBZ = true;
        ((VideoTransPara)localObject).width = 720;
        ((VideoTransPara)localObject).height = 1280;
        ((VideoTransPara)localObject).fps = 30;
        ((VideoTransPara)localObject).videoBitrate = 3500000;
        ((VideoTransPara)localObject).nCd = 10;
        ((VideoTransPara)localObject).audioBitrate = 48000;
        ((VideoTransPara)localObject).oBO = 2;
        ((VideoTransPara)localObject).oBP = 1;
        ((VideoTransPara)localObject).audioChannelCount = 1;
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).nCd = 10;
      ((VideoTransPara)localObject).oCa = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 3);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIQ, 15);
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, i, 1L, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get story record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126758);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara bIm()
  {
    AppMethodBeat.i(169097);
    long l = Util.currentTicks();
    if (this.oBG == null) {
      this.oBG = NC("FinderRecordVideoConfig");
    }
    int i;
    if (this.oBG != null)
    {
      i = 0;
      if (i < this.oBG.length)
      {
        localObject1 = this.oBG[i];
        if ((localObject1 != null) && (((f)localObject1).bIy())) {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((f)localObject1).bIA();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bIr();
      }
      if (Log.getLogLevel() <= 1)
      {
        i = MMApplicationContext.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).oCa = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXJ, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXK, 1);
      Log.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
      AppMethodBeat.o(169097);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara bIn()
  {
    AppMethodBeat.i(169098);
    long l = Util.currentTicks();
    if (this.oBH == null) {
      this.oBH = NC("FinderPublishVideoConfig");
    }
    int i;
    if (this.oBH != null)
    {
      i = 0;
      if (i < this.oBH.length)
      {
        localObject1 = this.oBH[i];
        if ((localObject1 != null) && (((f)localObject1).bIy())) {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((f)localObject1).bIA();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bIr();
      }
      if (Log.getLogLevel() <= 1)
      {
        i = MMApplicationContext.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).oCa = 540;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXL, 60);
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXM, 1);
      Log.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
      AppMethodBeat.o(169098);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara bIp()
  {
    AppMethodBeat.i(126761);
    long l = Util.currentTicks();
    if (this.oBM == null) {
      this.oBM = NC("NearbyRecordVideoConfig");
    }
    int i;
    Object localObject;
    VideoTransPara localVideoTransPara;
    if (this.oBM != null)
    {
      i = 0;
      if (i < this.oBM.length)
      {
        localObject = this.oBM[i];
        if ((localObject != null) && (((f)localObject).bIy()))
        {
          Log.i("MicroMsg.SubCoreVideoControl", "is busy time, try to get nearby record config.");
          localVideoTransPara = ((f)localObject).bIz();
        }
      }
    }
    for (boolean bool = ((f)localObject).oBQ;; bool = true)
    {
      localObject = localVideoTransPara;
      if (localVideoTransPara == null) {
        localObject = bIq();
      }
      ((VideoTransPara)localObject).audioSampleRate = 44100;
      ((VideoTransPara)localObject).nCd = 10;
      ((VideoTransPara)localObject).oCa = 200;
      localVideoTransPara = a((VideoTransPara)localObject, 2);
      if (localVideoTransPara.duration <= 0) {
        localVideoTransPara.duration = 10;
      }
      if (!bool) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 31L, 1L, false);
      }
      for (;;)
      {
        i = Util.nullAsNil((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, i, 1L, false);
        Log.i("MicroMsg.SubCoreVideoControl", "get nearby record para cost %d. %s rpt %d", new Object[] { Long.valueOf(Util.ticksToNow(l)), localVideoTransPara, Integer.valueOf(i) });
        AppMethodBeat.o(126761);
        return localVideoTransPara;
        i += 1;
        break;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(422L, 32L, 1L, false);
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara c(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(126760);
    paramVideoTransPara = a(paramVideoTransPara, null);
    AppMethodBeat.o(126760);
    return paramVideoTransPara;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final byte[] getWeixinMeta()
  {
    AppMethodBeat.i(126752);
    if (Util.isNullOrNil(this.oBz)) {}
    try
    {
      Object localObject = "{\"WXVer\":" + com.tencent.mm.protocal.d.Yxh + "}";
      this.oBz = ((String)localObject).getBytes("UTF-8");
      Log.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[] { localObject });
      localObject = this.oBz;
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
    this.oBB = null;
    this.oBL = null;
    this.oBK = null;
    this.oBC = null;
    this.oBE = null;
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final VideoTransPara vY(int paramInt)
  {
    AppMethodBeat.i(233875);
    long l = Util.currentTicks();
    if (this.oBI == null) {
      this.oBI = NC("PublishMegaVideoConfig");
    }
    int i;
    if (this.oBI != null)
    {
      i = 0;
      if (i < this.oBI.length)
      {
        localObject1 = this.oBI[i];
        if ((localObject1 != null) && (((f)localObject1).bIy())) {
          Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get story Record config.");
        }
      }
    }
    for (Object localObject1 = ((f)localObject1).bIA();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bIr();
      }
      if (Log.getLogLevel() <= 1)
      {
        i = MMApplicationContext.getContext().getSharedPreferences("finder_config_sp_key", 0).getInt("SWITCH_POST_VIDEO_RATE", -1);
        if (i > 0) {
          ((VideoTransPara)localObject2).videoBitrate = i;
        }
      }
      ((VideoTransPara)localObject2).audioSampleRate = 44100;
      ((VideoTransPara)localObject2).oCa = 720;
      localObject1 = a((VideoTransPara)localObject2, 4);
      ((VideoTransPara)localObject1).duration = paramInt;
      ((VideoTransPara)localObject1).minDuration = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXL, 60);
      Log.i("MicroMsg.SubCoreVideoControl", "get finder record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
      AppMethodBeat.o(233875);
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public final VideoTransPara vZ(int paramInt)
  {
    AppMethodBeat.i(126759);
    long l = Util.currentTicks();
    int i;
    if (this.oBJ == null)
    {
      if (paramInt == 1) {
        this.oBJ = NC("GameRecordBigVideoConfig");
      }
    }
    else
    {
      if (this.oBJ == null) {
        break label364;
      }
      i = 0;
      label42:
      if (i >= this.oBJ.length) {
        break label364;
      }
      localObject1 = this.oBJ[i];
      if ((localObject1 == null) || (!((f)localObject1).bIy())) {
        break label268;
      }
      Log.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get game Record config.");
    }
    label268:
    label275:
    label364:
    for (Object localObject1 = ((f)localObject1).bIz();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramInt != 1) {
          break label275;
        }
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).oBZ = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).nCd = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).oBO = 2;
        ((VideoTransPara)localObject2).oBP = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
      for (((VideoTransPara)localObject2).audioChannelCount = 1;; ((VideoTransPara)localObject2).audioChannelCount = 1)
      {
        ((VideoTransPara)localObject2).audioSampleRate = 44100;
        ((VideoTransPara)localObject2).nCd = 10;
        ((VideoTransPara)localObject2).oCa = 200;
        localObject1 = a((VideoTransPara)localObject2, 1);
        Log.i("MicroMsg.SubCoreVideoControl", "get game record para cost %d. %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), localObject1 });
        AppMethodBeat.o(126759);
        return localObject1;
        this.oBJ = NC("GameRecordVideoConfig");
        break;
        i += 1;
        break label42;
        localObject2 = new VideoTransPara();
        ((VideoTransPara)localObject2).oBZ = true;
        ((VideoTransPara)localObject2).width = 1080;
        ((VideoTransPara)localObject2).height = 1920;
        ((VideoTransPara)localObject2).fps = 30;
        ((VideoTransPara)localObject2).videoBitrate = 3500000;
        ((VideoTransPara)localObject2).nCd = 10;
        ((VideoTransPara)localObject2).audioBitrate = 48000;
        ((VideoTransPara)localObject2).oBO = 2;
        ((VideoTransPara)localObject2).oBP = 1;
        ((VideoTransPara)localObject2).duration = 60;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.e
 * JD-Core Version:    0.7.0.1
 */