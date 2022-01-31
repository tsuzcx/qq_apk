package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  implements ar
{
  private static final int ejC = com.tencent.mm.plugin.a.c.aG("dscp");
  private a ejD = new a();
  private byte[] ejE = null;
  private com.tencent.mm.plugin.a.b ejF;
  private e[] ejG;
  private e[] ejH;
  private e[] ejI;
  private e[] ejJ;
  private e[] ejK;
  
  public static d Nl()
  {
    return (d)p.B(d.class);
  }
  
  private static VideoTransPara Np()
  {
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.width = 540;
    localVideoTransPara.height = 960;
    localVideoTransPara.fps = 30;
    localVideoTransPara.videoBitrate = 1600000;
    localVideoTransPara.ejN = 10;
    localVideoTransPara.ejM = 64000;
    localVideoTransPara.ejO = 2;
    localVideoTransPara.ejP = 1;
    return localVideoTransPara;
  }
  
  public static boolean Nq()
  {
    int j = ((Integer)g.DP().Dz().get(ac.a.utw, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100136");
    if (localc.isValid()) {}
    for (int i = bk.getInt((String)localc.ctr().get("streamingDownload"), 0);; i = 0)
    {
      boolean bool2 = Ns();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        y.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean Nr()
  {
    int j = ((Integer)g.DP().Dz().get(ac.a.utw, Integer.valueOf(-1))).intValue();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100153");
    if (localc.isValid()) {}
    for (int i = bk.getInt((String)localc.ctr().get("snsStreamDownload"), 0);; i = 0)
    {
      boolean bool2 = Ns();
      boolean bool1;
      if ((j == 0) || (i == -1) || (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        y.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j), Integer.valueOf(i) });
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
  
  public static boolean Ns()
  {
    long l = bk.UZ();
    int k = ((Integer)g.DP().Dz().get(ac.a.utw, Integer.valueOf(-1))).intValue();
    Object localObject1 = com.tencent.mm.model.c.c.IX().fJ("100190");
    Object localObject2;
    int i;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject2 = ((com.tencent.mm.storage.c)localObject1).ctr();
      i = bk.getInt((String)((Map)localObject2).get("player"), 1);
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
      if (!bk.bl((String)localObject1))
      {
        arrayOfString = ((String)localObject1).split(";");
        n = arrayOfString.length;
        j = 0;
        if (j < n) {
          if (bk.getInt(arrayOfString[j], 0) != m) {}
        }
      }
      for (boolean bool1 = false;; bool1 = true)
      {
        boolean bool2 = bool1;
        if (!bk.bl((String)localObject2))
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
            if (com.tencent.mm.compatible.util.d.gG(18)) {
              bool2 = false;
            }
            if (Build.BRAND.equalsIgnoreCase("meizu")) {
              g.DP().Dz().c(ac.a.uuT, Boolean.valueOf(true));
            }
            if (k == 0) {
              bool2 = false;
            }
            if (i <= 0) {
              bool2 = false;
            }
            y.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(m), localObject1, str, localObject2, Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
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
  
  public static boolean Nt()
  {
    String str = null;
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100253");
    if (((com.tencent.mm.storage.c)localObject).isValid()) {
      str = (String)((com.tencent.mm.storage.c)localObject).ctr().get("noCompleteRange");
    }
    localObject = str;
    if (bk.bl(str)) {
      localObject = "20:00-23:30";
    }
    g.DN();
    int i = com.tencent.mm.a.h.aT(com.tencent.mm.kernel.a.CK(), 30);
    boolean bool = b.O((String)localObject, i);
    y.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s] endHash[%d]", new Object[] { Boolean.valueOf(bool), localObject, Integer.valueOf(i) });
    return !bool;
  }
  
  public static int a(int paramInt, s params)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      y.i("MicroMsg.SubCoreVideoControl", "check c2c video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt != 2) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 130L, 1L, false);
      return paramInt;
      paramInt = 1;
      continue;
      paramInt = a(params);
      continue;
      paramInt = a(params);
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(354L, 131L, 1L, false);
    return paramInt;
  }
  
  public static int a(VideoTransPara paramVideoTransPara)
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
  
  private static int a(s params)
  {
    boolean bool1 = false;
    int j = ((Integer)g.DP().Dz().get(ac.a.uwC, Integer.valueOf(-1))).intValue();
    int i = j;
    if (j == -1) {
      if (!com.tencent.mm.plugin.s.e.bio()) {
        break label87;
      }
    }
    label85:
    label87:
    for (i = 1;; i = 0)
    {
      g.DP().Dz().c(ac.a.uwC, Integer.valueOf(-1));
      y.d("MicroMsg.SubCoreVideoControl", "check device support hevc[%d]", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        break;
      }
      if (bool1) {
        break label364;
      }
      return 1;
    }
    Object localObject1 = com.tencent.mm.model.c.c.IX().fJ("100253");
    Object localObject2;
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject2 = ((com.tencent.mm.storage.c)localObject1).ctr();
      i = bk.getInt((String)((Map)localObject2).get("openHevc"), 0);
      localObject1 = (String)((Map)localObject2).get("brands");
      localObject2 = (String)((Map)localObject2).get("devices");
    }
    for (;;)
    {
      String str = Build.BRAND;
      Object localObject3;
      int k;
      if (!bk.bl((String)localObject1))
      {
        localObject3 = ((String)localObject1).split(";");
        k = localObject3.length;
        j = 0;
        label193:
        if (j < k) {
          if (!localObject3[j].equalsIgnoreCase(str)) {}
        }
      }
      for (bool1 = false;; bool1 = true)
      {
        localObject3 = Build.BRAND + Build.MODEL;
        boolean bool2 = bool1;
        String[] arrayOfString;
        if (!bk.bl((String)localObject2))
        {
          arrayOfString = ((String)localObject2).split(";");
          k = arrayOfString.length;
          j = 0;
        }
        for (;;)
        {
          bool2 = bool1;
          if (j < k)
          {
            if (arrayOfString[j].equalsIgnoreCase((String)localObject3)) {
              bool2 = false;
            }
          }
          else
          {
            if (i <= 0) {
              bool2 = false;
            }
            y.i("MicroMsg.SubCoreVideoControl", "check support hevc [%b] abtestFlag[%d] brands[%s, %s] device[%s, %s]", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), str, localObject1, localObject3, localObject2 });
            bool1 = bool2;
            break;
            j += 1;
            break label193;
          }
          j += 1;
        }
        label364:
        o.Sr();
        params = t.nS(params.getFileName());
        if (!com.tencent.mm.vfs.e.bK(params)) {
          return 2;
        }
        if (!r.nN(params)) {
          break label85;
        }
        return 2;
      }
      localObject2 = null;
      localObject1 = null;
      i = 0;
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5, PInt paramPInt6)
  {
    if ((bk.bl(paramString2)) || (bk.bl(paramString3)) || (bk.bl(paramString4))) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (bk.bl(paramString1)) {
          continue;
        }
        String[] arrayOfString = paramString1.split("~");
        paramPInt1.value = bk.getInt(arrayOfString[0], -1);
        paramPInt2.value = bk.getInt(arrayOfString[1], -1);
        if ((paramPInt1.value < 0) || (paramPInt2.value < 0)) {
          break;
        }
        arrayOfString = paramString2.split("x");
        paramPInt3.value = bk.getInt(arrayOfString[0], -1);
        paramPInt4.value = bk.getInt(arrayOfString[1], -1);
        if ((paramPInt3.value < 0) || (paramPInt4.value < 0)) {
          break;
        }
        paramPInt5.value = bk.getInt(paramString3, -1);
        paramPInt6.value = bk.getInt(paramString4, -1);
        if ((paramPInt5.value < 0) || (paramPInt6.value < 0)) {
          break;
        }
        paramPInt6.value *= 1000;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.SubCoreVideoControl", "parse video para error." + localException.toString());
        continue;
      }
      y.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramPInt3.value), Integer.valueOf(paramPInt4.value), Integer.valueOf(paramPInt5.value), Integer.valueOf(paramPInt6.value) });
      return true;
      paramPInt2.value = 0;
      paramPInt1.value = 0;
    }
  }
  
  private static e f(JSONObject paramJSONObject)
  {
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
            y.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", new Object[] { localObject1, localObject3, localObject4, localObject5, localObject6, localObject2 });
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
              break label519;
            }
            paramJSONObject = localJSONObject.getString("dura");
            if (!a(paramJSONObject, localJSONObject.getString("wh"), localJSONObject.getString("fps"), localJSONObject.getString("vbr"), (PInt)localObject3, (PInt)localObject4, (PInt)localObject5, (PInt)localObject6, localPInt1, localPInt2)) {
              break label512;
            }
            ((List)localObject1).add(new f(((PInt)localObject3).value, ((PInt)localObject4).value, ((PInt)localObject5).value, ((PInt)localObject6).value, localPInt1.value, localPInt2.value, localPInt2.value));
            break label512;
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
        if ((((List)localObject1).size() >= 2) && (!locale.ejQ))
        {
          j = ((f)((List)localObject1).get(0)).ejY;
          i = 1;
          if (i < ((List)localObject1).size())
          {
            paramJSONObject = (f)((List)localObject1).get(i);
            paramJSONObject.ejX = j;
            j = paramJSONObject.ejY;
            i += 1;
            continue;
          }
        }
        locale.ejR = new f[((List)localObject1).size()];
        ((List)localObject1).toArray(locale.ejR);
        y.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", new Object[] { locale });
        return locale;
      }
      catch (Exception paramJSONObject)
      {
        y.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + paramJSONObject.toString());
        return null;
      }
      label512:
      i += 1;
      continue;
      label519:
      paramJSONObject = "";
    }
  }
  
  private static VideoTransPara it(int paramInt)
  {
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.isDefault = true;
    localVideoTransPara.ejN = 1;
    localVideoTransPara.ejM = 48000;
    localVideoTransPara.ejO = 2;
    localVideoTransPara.ejP = 1;
    if (paramInt <= 120)
    {
      localVideoTransPara.fps = 30;
      localVideoTransPara.width = 540;
      localVideoTransPara.height = 960;
      localVideoTransPara.videoBitrate = 1200000;
      return localVideoTransPara;
    }
    localVideoTransPara.fps = 24;
    localVideoTransPara.width = 360;
    localVideoTransPara.height = 640;
    localVideoTransPara.videoBitrate = 544000;
    return localVideoTransPara;
  }
  
  private static e[] lP(String paramString)
  {
    int i = 0;
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue(paramString);
    if (bk.bl((String)localObject2))
    {
      y.i("MicroMsg.SubCoreVideoControl", "key %s config is null", new Object[] { paramString });
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Object localObject1 = localObject2;
      if (!((String)localObject2).startsWith("[")) {
        localObject1 = "[" + (String)localObject2;
      }
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith("]")) {
        localObject2 = (String)localObject1 + "]";
      }
      y.i("MicroMsg.SubCoreVideoControl", "%s=%s ", new Object[] { paramString, localObject2 });
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        int j = ((JSONArray)localObject2).length();
        y.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", new Object[] { Integer.valueOf(j) });
        localObject1 = new e[j];
        for (;;)
        {
          paramString = (String)localObject1;
          if (i >= j) {
            break;
          }
          localObject1[i] = f(((JSONArray)localObject2).getJSONObject(i));
          i += 1;
        }
        return null;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + paramString.toString());
      }
    }
  }
  
  public static int q(int paramInt, String paramString)
  {
    int i = 2;
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      y.i("MicroMsg.SubCoreVideoControl", "check sns video format[%d]", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
      paramInt = 1;
      continue;
      if (!com.tencent.mm.plugin.s.e.bio()) {
        break;
      }
      paramInt = i;
      if (com.tencent.mm.vfs.e.bK(paramString))
      {
        if (!r.nN(paramString)) {
          break;
        }
        paramInt = i;
      }
    }
  }
  
  public final VideoTransPara Nm()
  {
    long l = bk.UZ();
    if (this.ejG == null) {
      this.ejG = lP("C2CRecordVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.ejG != null)
    {
      i = 0;
      if (i < this.ejG.length)
      {
        locale = this.ejG[i];
        if ((locale != null) && (locale.Nu()))
        {
          y.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
          localVideoTransPara = locale.Nv();
        }
      }
    }
    for (boolean bool = locale.ejQ;; bool = true)
    {
      if (localVideoTransPara == null)
      {
        localVideoTransPara = new VideoTransPara();
        localVideoTransPara.isDefault = true;
        localVideoTransPara.width = 540;
        localVideoTransPara.height = 960;
        localVideoTransPara.fps = 30;
        localVideoTransPara.videoBitrate = 1200000;
        localVideoTransPara.ejN = 10;
        localVideoTransPara.ejM = 64000;
        localVideoTransPara.ejO = 2;
        localVideoTransPara.ejP = 1;
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.ejN = 10;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jHY);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 11L, 1L, false);
        }
        for (;;)
        {
          i = bk.g((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 13, 18));
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, i, 1L, false);
          y.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bk.cp(l)), localVideoTransPara, Integer.valueOf(i) });
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 12L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara Nn()
  {
    long l = bk.UZ();
    if (this.ejH == null) {
      this.ejH = lP("SnsRecordVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.ejH != null)
    {
      i = 0;
      if (i < this.ejH.length)
      {
        locale = this.ejH[i];
        if ((locale != null) && (locale.Nu()))
        {
          y.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
          localVideoTransPara = locale.Nv();
        }
      }
    }
    for (boolean bool = locale.ejQ;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = Np();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.ejN = 10;
        localVideoTransPara.ejZ = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jHW);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 31L, 1L, false);
        }
        for (;;)
        {
          i = bk.g((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 33, 38));
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, i, 1L, false);
          y.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", new Object[] { Long.valueOf(bk.cp(l)), localVideoTransPara, Integer.valueOf(i) });
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 32L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara No()
  {
    long l = bk.UZ();
    if (this.ejI == null) {
      this.ejI = lP("SnsAlbumVideoConfig");
    }
    int i;
    e locale;
    VideoTransPara localVideoTransPara;
    if (this.ejI != null)
    {
      i = 0;
      if (i < this.ejI.length)
      {
        locale = this.ejI[i];
        if ((locale != null) && (locale.Nu()))
        {
          y.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
          localVideoTransPara = locale.Nv();
        }
      }
    }
    for (boolean bool = locale.ejQ;; bool = true)
    {
      if (localVideoTransPara == null) {
        localVideoTransPara = Np();
      }
      for (;;)
      {
        localVideoTransPara.audioSampleRate = 44100;
        localVideoTransPara.ejN = 10;
        localVideoTransPara.ejZ = 200;
        localVideoTransPara.duration = ((com.tencent.mm.plugin.expt.a.a)g.r(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.jHX);
        if (!bool) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 21L, 1L, false);
        }
        for (;;)
        {
          i = bk.g((Integer)com.tencent.mm.plugin.report.service.h.a(localVideoTransPara.videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 23, 28));
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, i, 1L, false);
          y.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", new Object[] { Long.valueOf(bk.cp(l)), localVideoTransPara, Integer.valueOf(i) });
          return localVideoTransPara;
          i += 1;
          break;
          com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 22L, 1L, false);
        }
      }
      localVideoTransPara = null;
    }
  }
  
  public final VideoTransPara b(VideoTransPara paramVideoTransPara)
  {
    if (paramVideoTransPara == null)
    {
      y.e("MicroMsg.SubCoreVideoControl", "get c2c album video para but original video para is null.");
      return null;
    }
    if (paramVideoTransPara.duration >= 300)
    {
      y.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", new Object[] { Integer.valueOf(300) });
      return null;
    }
    long l = bk.UZ();
    VideoTransPara localVideoTransPara = it(paramVideoTransPara.duration);
    int i = 1;
    Object localObject1 = com.tencent.mm.model.c.c.IX().fJ("100157");
    if (((com.tencent.mm.storage.c)localObject1).isValid()) {
      i = bk.getInt((String)((com.tencent.mm.storage.c)localObject1).ctr().get("VideoEncodeStep"), 1);
    }
    y.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", new Object[] { Integer.valueOf(i) });
    label155:
    label162:
    boolean bool;
    if (i > 0)
    {
      i = 1;
      if (i == 0) {
        break label367;
      }
      if (this.ejK == null) {
        this.ejK = lP("C2CAlbumVideoStepConfig");
      }
      localObject1 = this.ejK;
      if (localObject1 == null) {
        break label408;
      }
      i = 0;
      if (i >= localObject1.length) {
        break label400;
      }
      Object localObject2 = localObject1[i];
      if ((localObject2 == null) || (!localObject2.Nu())) {
        break label393;
      }
      y.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
      i = a.a(localObject2.ejR, paramVideoTransPara, localVideoTransPara);
      bool = localObject2.ejQ;
      label215:
      if (i > 0) {
        break label430;
      }
      localObject1 = it(paramVideoTransPara.duration);
      label228:
      if (bool) {
        break label443;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 1L, 1L, false);
    }
    for (;;)
    {
      int j = bk.g((Integer)com.tencent.mm.plugin.report.service.h.a(((VideoTransPara)localObject1).videoBitrate / 1000, new int[] { 350, 544, 800, 1200, 1600 }, 3, 8));
      com.tencent.mm.plugin.report.service.h.nFQ.a(422L, j, 1L, false);
      y.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(j), Integer.valueOf(i), localObject1, paramVideoTransPara });
      return localObject1;
      i = 0;
      break;
      label367:
      if (this.ejJ == null) {
        this.ejJ = lP("C2CAlbumVideoConfig");
      }
      localObject1 = this.ejJ;
      break label155;
      label393:
      i += 1;
      break label162;
      label400:
      bool = true;
      i = 0;
      break label215;
      label408:
      y.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
      i = a.a(null, paramVideoTransPara, localVideoTransPara);
      bool = true;
      break label215;
      label430:
      localVideoTransPara.isDefault = false;
      localObject1 = localVideoTransPara;
      break label228;
      label443:
      com.tencent.mm.plugin.report.service.h.nFQ.a(422L, 2L, 1L, false);
    }
  }
  
  public final void bh(boolean paramBoolean) {}
  
  public final void bi(boolean paramBoolean) {}
  
  public final byte[] getWeixinMeta()
  {
    if (bk.bE(this.ejE)) {}
    try
    {
      String str = "{\"WXVer\":" + com.tencent.mm.protocal.d.spa + "}";
      this.ejE = str.getBytes("UTF-8");
      y.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", new Object[] { str });
      return this.ejE;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", new Object[] { localException.toString() });
      }
    }
  }
  
  public final void gf(int paramInt) {}
  
  /* Error */
  public final boolean lQ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 700	com/tencent/mm/modelcontrol/d:ejF	Lcom/tencent/mm/plugin/a/b;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 702	com/tencent/mm/plugin/a/b
    //   11: dup
    //   12: invokespecial 703	com/tencent/mm/plugin/a/b:<init>	()V
    //   15: putfield 700	com/tencent/mm/modelcontrol/d:ejF	Lcom/tencent/mm/plugin/a/b;
    //   18: aload_0
    //   19: getfield 700	com/tencent/mm/modelcontrol/d:ejF	Lcom/tencent/mm/plugin/a/b;
    //   22: astore 6
    //   24: aload 6
    //   26: ldc2_w 704
    //   29: putfield 709	com/tencent/mm/plugin/a/b:eUb	J
    //   32: aload 6
    //   34: ldc2_w 704
    //   37: putfield 712	com/tencent/mm/plugin/a/b:eUd	J
    //   40: aload 6
    //   42: aconst_null
    //   43: putfield 716	com/tencent/mm/plugin/a/b:eUe	Lcom/tencent/mm/plugin/a/a;
    //   46: invokestatic 189	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   49: lstore_2
    //   50: aload_0
    //   51: getfield 700	com/tencent/mm/modelcontrol/d:ejF	Lcom/tencent/mm/plugin/a/b;
    //   54: aload_1
    //   55: invokevirtual 720	com/tencent/mm/plugin/a/b:po	(Ljava/lang/String;)J
    //   58: lstore 4
    //   60: lload 4
    //   62: lconst_0
    //   63: lcmp
    //   64: ifgt +5 -> 69
    //   67: iconst_0
    //   68: ireturn
    //   69: aconst_null
    //   70: astore 11
    //   72: aconst_null
    //   73: astore 12
    //   75: new 722	java/io/RandomAccessFile
    //   78: dup
    //   79: new 724	java/io/File
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 725	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: ldc_w 726
    //   90: invokespecial 729	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore 8
    //   95: aload 8
    //   97: astore 6
    //   99: aload 8
    //   101: lload 4
    //   103: invokevirtual 733	java/io/RandomAccessFile:seek	(J)V
    //   106: aload 8
    //   108: astore 6
    //   110: bipush 8
    //   112: newarray byte
    //   114: astore 13
    //   116: aload 8
    //   118: astore 6
    //   120: aload 8
    //   122: aload 13
    //   124: getstatic 738	com/tencent/mm/plugin/a/a:aBk	I
    //   127: invokestatic 741	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   130: astore 7
    //   132: aconst_null
    //   133: astore 6
    //   135: aload 6
    //   137: astore 9
    //   139: aload 7
    //   141: ifnull +65 -> 206
    //   144: aload 8
    //   146: astore 6
    //   148: aload 8
    //   150: aload 13
    //   152: getstatic 32	com/tencent/mm/modelcontrol/d:ejC	I
    //   155: invokestatic 741	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   158: astore 10
    //   160: aload 10
    //   162: astore 9
    //   164: aload 10
    //   166: ifnonnull +40 -> 206
    //   169: aload 8
    //   171: astore 6
    //   173: aload 8
    //   175: aload 7
    //   177: invokevirtual 744	com/tencent/mm/plugin/a/a:Ve	()J
    //   180: invokevirtual 733	java/io/RandomAccessFile:seek	(J)V
    //   183: aload 8
    //   185: astore 6
    //   187: aload 8
    //   189: aload 13
    //   191: getstatic 738	com/tencent/mm/plugin/a/a:aBk	I
    //   194: invokestatic 741	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   197: astore 7
    //   199: aload 10
    //   201: astore 6
    //   203: goto -68 -> 135
    //   206: aload 12
    //   208: astore 7
    //   210: aload 9
    //   212: ifnull +74 -> 286
    //   215: aload 8
    //   217: astore 6
    //   219: aload 9
    //   221: invokevirtual 747	com/tencent/mm/plugin/a/a:getSize	()J
    //   224: l2i
    //   225: bipush 8
    //   227: isub
    //   228: newarray byte
    //   230: astore 10
    //   232: aload 8
    //   234: astore 6
    //   236: aload 8
    //   238: aload 9
    //   240: getfield 750	com/tencent/mm/plugin/a/a:eUa	J
    //   243: ldc2_w 751
    //   246: ladd
    //   247: invokevirtual 733	java/io/RandomAccessFile:seek	(J)V
    //   250: aload 12
    //   252: astore 7
    //   254: aload 8
    //   256: astore 6
    //   258: aload 8
    //   260: aload 10
    //   262: invokevirtual 756	java/io/RandomAccessFile:read	([B)I
    //   265: ifle +21 -> 286
    //   268: aload 8
    //   270: astore 6
    //   272: new 154	java/lang/String
    //   275: dup
    //   276: aload 10
    //   278: ldc_w 683
    //   281: invokespecial 759	java/lang/String:<init>	([BLjava/lang/String;)V
    //   284: astore 7
    //   286: aload 8
    //   288: invokevirtual 762	java/io/RandomAccessFile:close	()V
    //   291: aload 7
    //   293: astore 6
    //   295: ldc 165
    //   297: ldc_w 764
    //   300: iconst_4
    //   301: anewarray 4	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: aload 6
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: lload 4
    //   313: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   316: aastore
    //   317: dup
    //   318: iconst_2
    //   319: lload_2
    //   320: invokestatic 256	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   323: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   326: aastore
    //   327: dup
    //   328: iconst_3
    //   329: aload_1
    //   330: aastore
    //   331: invokestatic 178	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: aload 6
    //   336: invokestatic 226	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   339: ifne +91 -> 430
    //   342: aload 6
    //   344: ldc_w 766
    //   347: invokevirtual 770	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   350: ireturn
    //   351: astore 9
    //   353: aconst_null
    //   354: astore 7
    //   356: aload 7
    //   358: astore 6
    //   360: ldc 165
    //   362: ldc_w 772
    //   365: iconst_2
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload_1
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: aload 9
    //   377: invokevirtual 383	java/lang/Exception:toString	()Ljava/lang/String;
    //   380: aastore
    //   381: invokestatic 693	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload 11
    //   386: astore 6
    //   388: aload 7
    //   390: ifnull -95 -> 295
    //   393: aload 7
    //   395: invokevirtual 762	java/io/RandomAccessFile:close	()V
    //   398: aload 11
    //   400: astore 6
    //   402: goto -107 -> 295
    //   405: astore 6
    //   407: aload 11
    //   409: astore 6
    //   411: goto -116 -> 295
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 6
    //   418: aload 6
    //   420: ifnull +8 -> 428
    //   423: aload 6
    //   425: invokevirtual 762	java/io/RandomAccessFile:close	()V
    //   428: aload_1
    //   429: athrow
    //   430: iconst_0
    //   431: ireturn
    //   432: astore 6
    //   434: aload 7
    //   436: astore 6
    //   438: goto -143 -> 295
    //   441: astore 6
    //   443: goto -15 -> 428
    //   446: astore_1
    //   447: goto -29 -> 418
    //   450: astore 9
    //   452: aload 8
    //   454: astore 7
    //   456: goto -100 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	d
    //   0	459	1	paramString	String
    //   49	271	2	l1	long
    //   58	254	4	l2	long
    //   22	379	6	localObject1	Object
    //   405	1	6	localIOException1	java.io.IOException
    //   409	15	6	localObject2	Object
    //   432	1	6	localIOException2	java.io.IOException
    //   436	1	6	localObject3	Object
    //   441	1	6	localIOException3	java.io.IOException
    //   130	325	7	localObject4	Object
    //   93	360	8	localRandomAccessFile	java.io.RandomAccessFile
    //   137	102	9	localObject5	Object
    //   351	25	9	localException1	Exception
    //   450	1	9	localException2	Exception
    //   158	119	10	localObject6	Object
    //   70	338	11	localObject7	Object
    //   73	178	12	localObject8	Object
    //   114	76	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   75	95	351	java/lang/Exception
    //   393	398	405	java/io/IOException
    //   75	95	414	finally
    //   286	291	432	java/io/IOException
    //   423	428	441	java/io/IOException
    //   99	106	446	finally
    //   110	116	446	finally
    //   120	132	446	finally
    //   148	160	446	finally
    //   173	183	446	finally
    //   187	199	446	finally
    //   219	232	446	finally
    //   236	250	446	finally
    //   258	268	446	finally
    //   272	286	446	finally
    //   360	384	446	finally
    //   99	106	450	java/lang/Exception
    //   110	116	450	java/lang/Exception
    //   120	132	450	java/lang/Exception
    //   148	160	450	java/lang/Exception
    //   173	183	450	java/lang/Exception
    //   187	199	450	java/lang/Exception
    //   219	232	450	java/lang/Exception
    //   236	250	450	java/lang/Exception
    //   258	268	450	java/lang/Exception
    //   272	286	450	java/lang/Exception
  }
  
  public final void onAccountRelease()
  {
    this.ejG = null;
    this.ejK = null;
    this.ejJ = null;
    this.ejH = null;
    this.ejI = null;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.d
 * JD-Core Version:    0.7.0.1
 */