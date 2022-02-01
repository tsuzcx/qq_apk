package com.tencent.liteav.basic.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  protected static c f;
  private static Context g;
  protected String a;
  SharedPreferences b;
  SharedPreferences.Editor c;
  String d;
  long e;
  private boolean h;
  private boolean i;
  private a j;
  private final b k;
  
  static
  {
    AppMethodBeat.i(14593);
    g = null;
    AppMethodBeat.o(14593);
  }
  
  public c()
  {
    AppMethodBeat.i(222046);
    this.d = "";
    this.e = 0L;
    this.h = false;
    this.i = false;
    this.j = new a(null);
    this.k = new b();
    AppMethodBeat.o(222046);
  }
  
  private long a(String paramString1, String paramString2, String paramString3)
  {
    long l2 = -1L;
    AppMethodBeat.i(222059);
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1))
    {
      l1 = l2;
      if (a.q(this.j) != null)
      {
        paramString1 = a.q(this.j).optJSONObject(paramString1);
        l1 = l2;
        if (paramString1 != null)
        {
          paramString1 = paramString1.optJSONObject(paramString2);
          l1 = l2;
          if (paramString1 != null) {
            l1 = paramString1.optLong(paramString3, -1L);
          }
        }
      }
    }
    AppMethodBeat.o(222059);
    return l1;
  }
  
  private a a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222082);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(222082);
      return null;
    }
    a locala = new a(null);
    try
    {
      f(paramJSONObject, locala);
      e(paramJSONObject, locala);
      d(paramJSONObject, locala);
      a(paramJSONObject, locala);
      b(paramJSONObject, locala);
      c(paramJSONObject, locala);
      g(paramJSONObject, locala);
      i(paramJSONObject, locala);
      h(paramJSONObject, locala);
      this.k.a(paramJSONObject.optJSONArray("compatible_config"));
      paramJSONObject = locala;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        TXCLog.w("CloudConfig", "parse config catch exception " + paramJSONObject.toString());
        paramJSONObject = null;
      }
    }
    AppMethodBeat.o(222082);
    return paramJSONObject;
  }
  
  public static c a()
  {
    AppMethodBeat.i(222047);
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new c();
      }
      c localc = f;
      AppMethodBeat.o(222047);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(222047);
    }
  }
  
  private static String a(File paramFile)
  {
    AppMethodBeat.i(222068);
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramFile = new ZipFile(paramFile);
      Object localObject1 = paramFile.entries();
      do
      {
        if (!((Enumeration)localObject1).hasMoreElements()) {
          break;
        }
        localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
      } while (((ZipEntry)localObject2).isDirectory());
      localObject1 = paramFile.getInputStream((ZipEntry)localObject2);
      Object localObject2 = new byte[1048576];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int m = ((InputStream)localObject1).read((byte[])localObject2);
        if (m <= 0) {
          break;
        }
        localByteArrayOutputStream.write((byte[])localObject2, 0, m);
      }
      ((InputStream)localObject1).close();
    }
    finally
    {
      AppMethodBeat.o(222068);
    }
    paramFile.close();
    paramFile = localByteArrayOutputStream.toString();
    AppMethodBeat.o(222068);
    return paramFile;
    paramFile.close();
    AppMethodBeat.o(222068);
    return "";
  }
  
  private void a(int paramInt)
  {
    try
    {
      AppMethodBeat.i(222066);
      int m = paramInt;
      if (paramInt <= 0) {
        m = 1;
      }
      this.e = (System.currentTimeMillis() + m * 24 * 60 * 60 * 1000);
      TXCLog.i("CloudConfig", "setExpiredtime: days=" + m + " expiredTime=" + this.e);
      AppMethodBeat.o(222066);
      return;
    }
    finally {}
  }
  
  private void a(a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222063);
    Object localObject1;
    if ((this.c == null) && (g != null))
    {
      localObject1 = g.getSharedPreferences("cloud_config", 0);
      if (localObject1 != null) {
        this.c = ((SharedPreferences)localObject1).edit();
      }
    }
    if (this.c != null)
    {
      this.c.putLong("expired_time", this.e);
      this.c.putInt("hw_config", a.b(parama));
      this.c.putInt("ExposureCompensation", a.c(parama));
      this.c.putInt("UGCSWMuxerConfig", a.d(parama));
      this.c.putInt("CPU", a.i(parama));
      this.c.putInt("FPS", a.j(parama));
      this.c.putInt("CPU_MAX", a.g(parama));
      this.c.putInt("FPS_MIN", a.h(parama));
      this.c.putInt("CheckCount", a.f(parama));
      this.c.putInt("PreGenerateSW", a.e(parama));
      this.c.putString("trae_config", a.a(parama));
      if (a.q(parama) != null) {
        this.c.putString("AppIDConfig", a.q(parama).toString());
      }
      Object localObject2 = "0";
      if (a.n(parama) != null)
      {
        localObject1 = a.n(parama)[0];
        int m = 1;
        for (;;)
        {
          localObject2 = localObject1;
          if (m >= a.n(parama).length) {
            break;
          }
          localObject1 = (String)localObject1 + "|";
          localObject1 = (String)localObject1 + a.n(parama)[m];
          m += 1;
        }
      }
      if (a.k(parama) == null) {
        a.a(parama, "");
      }
      this.c.putString("system_aec_config", a.l(parama) + "," + a.m(parama) + "," + (String)localObject2 + "," + a.p(parama) + "," + a.k(parama));
      if (paramJSONObject != null) {
        break label494;
      }
      this.c.putString("compatible_config", null);
    }
    for (;;)
    {
      this.c.commit();
      AppMethodBeat.o(222063);
      return;
      label494:
      this.c.putString("compatible_config", paramJSONObject.toString());
    }
  }
  
  private void a(String paramString, a parama)
  {
    AppMethodBeat.i(222076);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("InfoList"))
      {
        paramString = paramString.getJSONArray("InfoList");
        int m = 0;
        while (m < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(m);
          if ((localJSONObject != null) && (localJSONObject.getString("MachineType").equals(Build.MODEL)))
          {
            a.b(parama, localJSONObject.getString("ConfigValue"));
            AppMethodBeat.o(222076);
            return;
          }
          m += 1;
        }
      }
      AppMethodBeat.o(222076);
      return;
    }
    catch (JSONException paramString)
    {
      TXCLog.w("CloudConfig", "parseTraeLocalConfig catch ecxeption".concat(String.valueOf(paramString)));
      AppMethodBeat.o(222076);
    }
  }
  
  private void a(JSONObject paramJSONObject, a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(222070);
    a.a(parama, 0);
    a.b(parama, 0);
    a.a(parama, null);
    a.c(parama, 0);
    a.a(parama, "");
    Object localObject1 = localObject2;
    int m;
    JSONObject localJSONObject2;
    int n;
    label152:
    label205:
    int i1;
    if (paramJSONObject.has("SystemAECConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("SystemAECConfig");
      localObject1 = localObject2;
      if (paramJSONObject.has("InfoList"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("InfoList");
        m = 0;
        paramJSONObject = null;
        if (m < localJSONArray.length())
        {
          localJSONObject2 = localJSONArray.getJSONObject(m);
          localObject2 = paramJSONObject;
          if (localJSONObject2 != null)
          {
            localObject2 = paramJSONObject;
            if (localJSONObject2.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER))
            {
              localObject1 = localJSONObject2.optJSONArray("WhiteList");
              if (localObject1 == null) {
                break label646;
              }
              n = 0;
              if (n >= ((JSONArray)localObject1).length()) {
                break label646;
              }
              localObject2 = ((JSONArray)localObject1).optJSONObject(n);
              if (localObject2 == null) {
                break label652;
              }
              localObject2 = ((JSONObject)localObject2).optString("Model");
              if ((localObject2 == null) || (!Build.MODEL.equals(localObject2))) {
                break label652;
              }
              n = 1;
              localObject1 = localJSONObject2.optJSONArray("BlackList");
              if (localObject1 == null) {
                break label640;
              }
              i1 = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i1 < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i1);
        if (localObject2 != null)
        {
          localObject2 = ((JSONObject)localObject2).optString("Model");
          if ((localObject2 == null) || (!Build.MODEL.equals(localObject2))) {}
        }
      }
      else
      {
        label640:
        for (i1 = 1;; i1 = 0)
        {
          localObject1 = paramJSONObject;
          if (n != 0) {}
          for (;;)
          {
            try
            {
              for (;;)
              {
                a.a(parama, localJSONObject2.optInt("SystemAEC", 0));
                a.b(parama, localJSONObject2.optInt("AGC", 0));
                localObject1 = localJSONObject2.optString("SampleRate", "");
                paramJSONObject = (JSONObject)localObject1;
                try
                {
                  if (!paramJSONObject.isEmpty())
                  {
                    localObject1 = paramJSONObject.split("\\|");
                    a.a(parama, new int[localObject1.length]);
                    n = 0;
                    while (n < localObject1.length)
                    {
                      a.n(parama)[n] = Integer.valueOf(localObject1[n].trim()).intValue();
                      n += 1;
                    }
                  }
                  a.c(parama, localJSONObject2.optInt("HWAACCodec", 0));
                  a.a(parama, localJSONObject2.optString("SceneType", ""));
                  localObject1 = paramJSONObject;
                  localObject2 = localObject1;
                  if (i1 != 0)
                  {
                    a.a(parama, 0);
                    a.b(parama, 0);
                    a.a(parama, null);
                    a.c(parama, 0);
                    a.a(parama, "");
                    localObject2 = localObject1;
                  }
                  m += 1;
                  paramJSONObject = (JSONObject)localObject2;
                }
                catch (Exception localException1) {}
              }
            }
            catch (Exception localException2)
            {
              JSONObject localJSONObject1;
              continue;
            }
            TXCLog.e("CloudConfig", "parseSysAECConfig Exception: " + localException1.getMessage());
            localJSONObject1 = paramJSONObject;
          }
          localJSONObject1 = paramJSONObject;
          TXCLog.i("CloudConfig", "system aec config1:" + a.l(parama) + "," + a.m(parama) + "," + localJSONObject1 + "," + a.p(parama) + "," + a.k(parama) + ", model = " + Build.MODEL + ", manufacturer = " + Build.MANUFACTURER + "， board = " + Build.BOARD);
          AppMethodBeat.o(222070);
          return;
        }
        label646:
        n = 0;
        break label205;
        label652:
        n += 1;
        break label152;
      }
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(222069);
    a(false);
    try
    {
      paramString = new JSONObject(paramString);
      int m = 1;
      if (paramString.has("UpdateFrequency")) {
        m = paramString.getInt("UpdateFrequency");
      }
      a(m);
      paramString = a(paramString);
      if (paramString != null)
      {
        this.j = paramString;
        a(paramString, this.k.a());
      }
      AppMethodBeat.o(222069);
      return;
    }
    catch (JSONException paramString)
    {
      TXCLog.w("CloudConfig", "parseRespon catch ecxeption".concat(String.valueOf(paramString)));
      AppMethodBeat.o(222069);
    }
  }
  
  private void b(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222071);
    if (paramJSONObject.has("TraeConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("TraeConfig");
      if (paramJSONObject.has("InfoList"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("InfoList");
        int m = 0;
        while (m < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
          if ((localJSONObject != null) && (localJSONObject.getString("MachineType").equals(Build.MODEL)))
          {
            a.b(parama, localJSONObject.getString("ConfigValue"));
            TXCLog.d("CloudConfig", "parseTRAEConfig get TRAE config: " + a.a(parama));
            AppMethodBeat.o(222071);
            return;
          }
          m += 1;
        }
      }
    }
    AppMethodBeat.o(222071);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222072);
    if (paramJSONObject.has("WeiXinConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("WeiXinConfig");
      if (paramJSONObject.has("InfoList"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("InfoList");
        int m = 0;
        while (m < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
          if (localJSONObject != null)
          {
            String str1 = localJSONObject.getString("Manufacture");
            String str2 = localJSONObject.getString("Model");
            if ((str1.equals(Build.MANUFACTURER)) && (str2.equals(Build.MODEL)))
            {
              a.d(parama, Integer.parseInt(localJSONObject.getString("SampleRate")));
              TXCLog.d("CloudConfig", "parseWeiXinConfig get WeiXin config: record sample rate = " + a.o(parama));
              AppMethodBeat.o(222072);
              return;
            }
          }
          m += 1;
        }
      }
    }
    AppMethodBeat.o(222072);
  }
  
  private void d(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222073);
    a.e(parama, 60);
    a.f(parama, 70);
    a.g(parama, 80);
    a.h(parama, 50);
    a.i(parama, 10);
    if (paramJSONObject.has("HWWhiteList"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("HWWhiteList");
      if (paramJSONObject.has("SWToHWThreshold"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("SWToHWThreshold");
        if (paramJSONObject.has("CPU"))
        {
          a.e(parama, paramJSONObject.getInt("CPU"));
          TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CPU:" + a.i(parama));
        }
        if (paramJSONObject.has("FPS"))
        {
          a.f(parama, paramJSONObject.getInt("FPS"));
          TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.FPS:" + a.j(parama));
        }
        if (paramJSONObject.has("CPU_MAX"))
        {
          a.g(parama, paramJSONObject.getInt("CPU_MAX"));
          TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CPU:" + a.g(parama));
        }
        if (paramJSONObject.has("FPS_MIN"))
        {
          a.h(parama, paramJSONObject.getInt("FPS_MIN"));
          TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.FPS:" + a.h(parama));
        }
        if (paramJSONObject.has("CheckCount"))
        {
          a.i(parama, paramJSONObject.getInt("CheckCount"));
          TXCLog.d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CheckCount:" + a.f(parama));
        }
      }
    }
    AppMethodBeat.o(222073);
  }
  
  private void e(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222074);
    int m;
    if (paramJSONObject.has("ExposureWhiteConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("ExposureWhiteConfig").getJSONArray("InfoList");
      m = 0;
    }
    for (;;)
    {
      if (m < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
        if ((localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
        {
          a.j(parama, localJSONObject.getInt("ExposureCompensation"));
          TXCLog.d("CloudConfig", "parseExposureConfig get exposure config: " + a.c(parama));
        }
      }
      else
      {
        if (g != null)
        {
          paramJSONObject = new Intent("com.tencent.liteav.basic.serverconfig.get");
          g.sendBroadcast(paramJSONObject);
        }
        AppMethodBeat.o(222074);
        return;
      }
      m += 1;
    }
  }
  
  private void f(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222075);
    if (paramJSONObject.has("HWBlackConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("HWBlackConfig");
      int m = 16;
      if (paramJSONObject.has("HWMiniSupportAPI")) {
        m = paramJSONObject.getInt("HWMiniSupportAPI");
      }
      if (Build.VERSION.SDK_INT < m)
      {
        a.k(parama, 0);
        AppMethodBeat.o(222075);
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("InfoList");
      m = 0;
      while (m < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
        if ((localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
        {
          if (localJSONObject.has("profile"))
          {
            a.k(parama, 1);
            TXCLog.d("CloudConfig", "parseHWBlackConfig get HWBlack config: " + a.b(parama));
            AppMethodBeat.o(222075);
            return;
          }
          a.k(parama, 0);
          TXCLog.d("CloudConfig", "parseHWBlackConfig get HWBlack config: " + a.b(parama));
          AppMethodBeat.o(222075);
          return;
        }
        m += 1;
      }
    }
    AppMethodBeat.o(222075);
  }
  
  private void g(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222077);
    if (paramJSONObject.has("UGCSWMuxerConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("UGCSWMuxerConfig").getJSONArray("InfoList");
      int m = 0;
      while (m < paramJSONObject.length())
      {
        if (paramJSONObject.getJSONObject(m).getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER))
        {
          a.l(parama, 1);
          AppMethodBeat.o(222077);
          return;
        }
        m += 1;
      }
    }
    AppMethodBeat.o(222077);
  }
  
  private void h(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222078);
    if (paramJSONObject.has("UGCConfig"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("UGCConfig");
      if (paramJSONObject != null)
      {
        if ((paramJSONObject.has("PreGenerateALLSW")) && (paramJSONObject.getInt("PreGenerateALLSW") == 1))
        {
          a.m(parama, 1);
          AppMethodBeat.o(222078);
          return;
        }
        if (paramJSONObject.has("PreGenerateSW"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("PreGenerateSW");
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.getJSONArray("InfoList");
            int m = 0;
            while (m < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
              if ((localJSONObject.has("Manufacture")) && (localJSONObject.has("Model")) && (localJSONObject.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) && (localJSONObject.getString("Model").equalsIgnoreCase(Build.MODEL)))
              {
                a.m(parama, 1);
                AppMethodBeat.o(222078);
                return;
              }
              m += 1;
            }
          }
        }
      }
    }
    AppMethodBeat.o(222078);
  }
  
  private void i(JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(222079);
    if (paramJSONObject.has("AppIDConfig"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("AppIDConfig");
      if (paramJSONObject != null)
      {
        a.a(parama, paramJSONObject);
        TXCLog.w("CloudConfig", "parse global config : " + a.q(parama));
      }
    }
    AppMethodBeat.o(222079);
  }
  
  private void k()
  {
    AppMethodBeat.i(222061);
    l();
    j();
    AppMethodBeat.o(222061);
  }
  
  private void l()
  {
    try
    {
      AppMethodBeat.i(222062);
      if (n())
      {
        b(true);
        if (!p()) {
          q();
        }
        TXCLog.i("CloudConfig", "load config(system aec):" + a.l(this.j) + "," + a.m(this.j) + "," + a.p(this.j) + "," + a.k(this.j) + ", model = " + Build.MODEL + ", manufacturer = " + Build.MANUFACTURER + "， board = " + Build.BOARD);
      }
      AppMethodBeat.o(222062);
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 603
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 53	com/tencent/liteav/basic/d/c:h	Z
    //   12: ifne +14 -> 26
    //   15: aload_0
    //   16: getfield 51	com/tencent/liteav/basic/d/c:e	J
    //   19: invokestatic 206	java/lang/System:currentTimeMillis	()J
    //   22: lcmp
    //   23: ifle +15 -> 38
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc_w 603
    //   31: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_1
    //   39: istore_1
    //   40: ldc_w 603
    //   43: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -12 -> 34
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   27	13	1	bool	boolean
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	49	finally
    //   28	34	49	finally
    //   40	46	49	finally
  }
  
  /* Error */
  private boolean n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	com/tencent/liteav/basic/d/c:i	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_1
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	c
    //   6	13	1	bool	boolean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private void o()
  {
    AppMethodBeat.i(222067);
    int m;
    Object localObject5;
    try
    {
      TXCLog.w("CloudConfig", "update server config ");
      Object localObject1 = (HttpURLConnection)new URL("http://dldir1.qq.com/hudongzhibo/liteavsvrcfg/serverconfig_en.zip").openConnection();
      if (!this.d.isEmpty()) {
        ((HttpURLConnection)localObject1).addRequestProperty("If-Modified-Since", this.d);
      }
      localObject4 = ((HttpURLConnection)localObject1).getHeaderField("Last-Modified");
      m = ((HttpURLConnection)localObject1).getResponseCode();
      if (m != 200) {
        break label290;
      }
      if ((localObject4 != null) && (!((String)localObject4).isEmpty()))
      {
        this.d = ((String)localObject4);
        if (this.c != null) {
          this.c.putString("last_modify", this.d);
        }
      }
      localObject4 = ((HttpURLConnection)localObject1).getInputStream();
      localObject5 = new byte[1024];
      localObject1 = new ByteArrayOutputStream();
      for (;;)
      {
        m = ((InputStream)localObject4).read((byte[])localObject5);
        if (m == -1) {
          break;
        }
        ((ByteArrayOutputStream)localObject1).write((byte[])localObject5, 0, m);
      }
      localObject4 = a.a(Base64.decode(TXCCommonUtil.getConfigCenterKey().getBytes("UTF-8"), 2));
    }
    catch (Exception localException)
    {
      TXCLog.e("CloudConfig", "fetch config catch exception ".concat(String.valueOf(localException)));
      a(false);
      AppMethodBeat.o(222067);
      return;
    }
    Object localObject4 = a.a(localException.toByteArray(), (PrivateKey)localObject4);
    File localFile = null;
    try
    {
      if (!TextUtils.isEmpty(this.a))
      {
        localFile = new File(this.a, "serverconfig_dec.zip");
        localObject5 = new FileOutputStream(localFile);
        ((FileOutputStream)localObject5).write((byte[])localObject4);
        ((FileOutputStream)localObject5).close();
      }
      b(a(localFile));
      AppMethodBeat.o(222067);
      return;
    }
    finally
    {
      AppMethodBeat.o(222067);
    }
    label290:
    if (m == 304)
    {
      a(1);
      localObject3 = g;
      if (localObject3 != null)
      {
        localObject3 = ((Context)localObject3).getSharedPreferences("cloud_config", 0);
        if (localObject3 != null)
        {
          TXCLog.i("CloudConfig", "updateInternal: return 304(code), update expiredTime into file. expiredTime=" + this.e);
          ((SharedPreferences)localObject3).edit().putLong("expired_time", this.e).commit();
        }
      }
      a(false);
      if ("fetch config Not-Modified-Since " + this.d != null) {
        break label414;
      }
    }
    label414:
    for (Object localObject3 = "";; localObject3 = this.d)
    {
      TXCLog.d("CloudConfig", (String)localObject3);
      AppMethodBeat.o(222067);
      return;
    }
  }
  
  private boolean p()
  {
    AppMethodBeat.i(222080);
    if (g == null)
    {
      AppMethodBeat.o(222080);
      return false;
    }
    this.b = g.getSharedPreferences("cloud_config", 0);
    if ((this.b != null) && (this.b.contains("expired_time")))
    {
      TXCLog.w("CloudConfig", "loadLocalFileConfig ");
      this.c = this.b.edit();
      try
      {
        this.d = this.b.getString("last_modify", "");
        this.e = this.b.getLong("expired_time", System.currentTimeMillis());
        a.k(this.j, this.b.getInt("hw_config", 2));
        a.j(this.j, this.b.getInt("ExposureCompensation", 0));
        a.l(this.j, this.b.getInt("UGCSWMuxerConfig", 0));
        a.e(this.j, this.b.getInt("CPU", 60));
        a.f(this.j, this.b.getInt("FPS", 70));
        a.g(this.j, this.b.getInt("CPU_MAX", 80));
        a.h(this.j, this.b.getInt("FPS_MIN", 50));
        a.i(this.j, this.b.getInt("CheckCount", 10));
        a.b(this.j, this.b.getString("trae_config", ""));
        a.m(this.j, this.b.getInt("PreGenerateSW", 1));
        Object localObject1 = this.b.getString("system_aec_config", "");
        Object localObject2 = this.b.getString("AppIDConfig", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          a.a(this.j, new JSONObject((String)localObject2));
        }
        TXCLog.i("CloudConfig", "system aec config:".concat(String.valueOf(localObject1)));
        if (!((String)localObject1).isEmpty())
        {
          localObject1 = ((String)localObject1).split(",");
          if ((localObject1 != null) && (localObject1.length >= 5))
          {
            a.a(this.j, Integer.valueOf(localObject1[0]).intValue());
            a.b(this.j, Integer.valueOf(localObject1[1]).intValue());
            localObject2 = localObject1[2].split("\\|");
            if (localObject2 != null)
            {
              a.a(this.j, new int[localObject2.length]);
              int m = 0;
              while (m < localObject2.length)
              {
                a.n(this.j)[m] = Integer.valueOf(localObject2[m].trim()).intValue();
                m += 1;
              }
            }
            a.c(this.j, Integer.valueOf(localObject1[3]).intValue());
            a.a(this.j, localObject1[4]);
          }
        }
        this.k.a(this.b.getString("compatible_config", null));
        AppMethodBeat.o(222080);
        return true;
      }
      catch (Exception localException)
      {
        this.c.clear();
        this.c.commit();
        TXCLog.d("CloudConfig", "loadLocalFileConfig catch exception ".concat(String.valueOf(localException)));
        AppMethodBeat.o(222080);
        return false;
      }
    }
    AppMethodBeat.o(222080);
    return false;
  }
  
  private void q()
  {
    AppMethodBeat.i(222081);
    try
    {
      TXCLog.w("CloudConfig", "loadDefaultConfig ");
      a locala = a(new JSONObject("{\n    \"version\": 3,\n    \"UpdateFrequency\": 1,\n    \"AppIDConfig\": {\n        \"Global\": {\n            \"DataReport\": {\n                \"UserPortrait\":0\n            },\n            \"DNSWhiteList\": {\n              \"InfoList\": [\n                \"qq\",\n                \"tencent\"\n              ]\n            },\n            \"Audio\": {\n                \"RTC_JitterCycle\":240,\n                \"LIVE_JitterCycle\":500,\n                \"LoadingThreshold\":800,\n                \"SmoothModeAdjust\":0,\n                \"SmoothAdjust\":10,\n                \"RtcPlayHungryTimeThreshold\":60,\n                \"BlockThreshold\": 100,\n                \"SmoothSpeed\":1.2\n            },\n            \"Network\": {\n                \"EnableRouteOptimize\":0,\n                \"RouteSamplingMaxCount\":10,\n                \"QualityDataCacheCount\":0,\n                \"NACKRetryCnt\": 8,\n                \"AccRetryCountWithoutSecret\":1\n            },\n            \"QUICMode\": {\n                \"Live\":2,\n                \"LinkMain\":2,\n                \"LinkSub\":2,\n                \"RTC\":2,\n                \"AVRoom\":0\n            },\n            \"ILiveRoom\": {\n               \"Live_FecRatioAudio\":0,\n               \"Live_FecRatioVideoI\":0,\n               \"Live_FecRatioVideoP\":0,\n               \"Chat_FecRatioAudio\":0,\n               \"Chat_FecRatioVideoI\":0,\n               \"Chat_FecRatioVideoP\":0,\n               \"Rtc_MinCacheTime\":300,\n               \"Rtc_MaxCacheTime\":1000,\n               \"MinCacheTime\":700,\n               \"MaxCacheTime\":2000\n           },\n           \"Video\": {\n               \"CheckVideoEncDownBps\":1\n           }\n       },\n       \"1252463788\":{\n            \"Network\": {\n                \"EnableRouteOptimize\":1,\n                \"RouteSamplingMaxCount\":100,\n                \"QualityDataCacheCount\":10\n            }\n       }\n    },\n    \"PlayModeConfig\":{\n        \"SmoothModeOffset\":300\n    },\n    \"UGCSWMuxerConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\"\n            }\n        ]\n    },\n    \"UGCConfig\": {\n        \"PreGenerateALLSW\":0,\n        \"PreGenerateSW\": {\n                \"InfoList\": [\n                    {\n                        \"Manufacture\": \"OPPO\",\n                        \"Model\": \"OPPO A57\"\n                    }\n                ]\n            }\n         },\n    \"HWBlackConfig\": {\n        \"HWMiniSupportAPI\": 17,\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"P6-U06\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"SCH-I939(S3)\"\n            },\n            {\n                \"Manufacture\": \"VIVO\",\n                \"Model\": \"vivo X5Pro D\"\n            },\n            {\n                \"Manufacture\": \"金立\",\n                \"Model\": \"GN9006\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"A7000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI NXT-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI MHA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L29\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-TL00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n             {\n                 \"Manufacture\": \"HUAWEI\",\n                 \"Model\": \"HUAWEI GRA-UL00\"\n             }\n        ]\n    },\n    \"ExposureWhiteConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"Meizu\",\n                \"Model\": \"MX4 Pro\",\n                \"ExposureCompensation\": 1\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3\",\n                \"ExposureCompensation\": 30\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3C\",\n                \"ExposureCompensation\": 30\n            }\n        ]\n    },\n    \"SystemAECConfig\": {\n        \"__comment__\":\"SceneType(开启系统aec的场景，1为连麦，2为通话)\",\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9\"}],\n                \"BlackList\": [],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9Plus\"},{\"Model\":\"vivo X7Plus\"},{\"Model\":\"vivo X7\"}],\n                \"BlackList\": [{\"Model\":\"vivo Y51A\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"WhiteList\": [{\"Model\":\"VTR-TL00\"},{\"Model\":\"HUAWEI GRA-UL00\"},{\"Model\":\"HUAWEI NXT-AL10\"},{\"Model\":\"PLK-AL10\"},{\"Model\":\"PLK-UL00\"},{\"Model\":\"EVA-AL10\"},{\"Model\":\"HUAWEI MT7-TL10\"}],\n                \"BlackList\": [{\"Model\":\"MHA-AL00\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 2\"},{\"Model\":\"Redmi Note 4\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 3\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"MI 4\"},{\"Model\":\"MI 3C\"},{\"Model\":\"Mi-4c\"}],\n                \"BlackList\": [{\"Model\":\"MI 6\"},{\"Model\":\"Redmi 4A\"},{\"Model\":\"MI 5X\"},{\"Model\":\"MI 5\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Google\",\n                \"WhiteList\": [{\"Model\":\"Pixel XL\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"samsung\",\n                \"WhiteList\": [{\"Model\":\"SM-G9350\"},{\"Model\":\"SM-G9500\"},{\"Model\":\"SM-G950U\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                 \"Manufacture\": \"LeMobile\",\n                 \"WhiteList\": [{\"Model\":\"X620\"}],\n                 \"SystemAEC\": 1,\n                 \"AGC\": 0,\n                 \"SampleRate\": \"48000|16000\",\n                 \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n             {\n                  \"Manufacture\": \"asus\",\n                  \"WhiteList\": [{\"Model\":\"ASUS_Z00ADB\"}],\n                  \"SystemAEC\": 1,\n                  \"AGC\": 0,\n                  \"SampleRate\": \"48000|16000\",\n                  \"HWAACCodec\": 1,\n                 \"SceneType\": \"1|2\"\n             }\n        ]\n    },\n    \"WeiXinConfig\": {\n        \"InfoList\":[\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\",\n                \"SampleRate\": \"16000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"ALP-AL00\",\n                \"SampleRate\": \"16000\"\n            }\n        ]\n    },\n    \"HWWhiteList\": {\n        \"SWToHWThreshold\": {\n            \"CPU_MAX\": 80,\n            \"FPS_MIN\": 50,\n            \"CPU\": 20,\n            \"FPS\": 70,\n            \"CheckCount\": 10,\n            \"__comment__\": \"软编根据性能切硬编的阈值，avgTotalCPU >= CPU_MAX || avgFPS <= FPS_MIN || (avgAppCPU >= CPU && avgFPS <= FPS) 性能指标满足上述条件则切硬编。CheckCount表示需要做X次有效性能数据采集。\"\n\t\t}\n    },\n    \"TraeConfig\": {\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1074,\n            \"MachineType\": \"OPPO A57\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"OPPO R11s\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1076,\n            \"MachineType\": \"OPPO R11\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1077,\n            \"MachineType\": \"OPPO A83\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"OPPO A73\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"SM-G9006V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1081,\n            \"MachineType\": \"vivo Y83A\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1083,\n            \"MachineType\": \"OPPO R17\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1084,\n            \"MachineType\": \"OPPO R15\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1085,\n            \"MachineType\": \"OPPO A37M\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1086,\n            \"MachineType\": \"OPPO A7X\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1087,\n            \"MachineType\": \"OPPO A3\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1088,\n            \"MachineType\": \"OPPO A5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1089,\n            \"MachineType\": \"OPPO A83T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1090,\n            \"MachineType\": \"OPPO R11T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1091,\n            \"MachineType\": \"OPPO R9S PLUS\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1092,\n            \"MachineType\": \"vivo Y51A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1093,\n            \"MachineType\": \"vivo V1813A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1095,\n            \"MachineType\": \"vivo Y67\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1097,\n            \"MachineType\": \"MHA-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1098,\n            \"MachineType\": \"ALP-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1099,\n            \"MachineType\": \"VTR-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1100,\n            \"MachineType\": \"BND-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1101,\n            \"MachineType\": \"COL-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1102,\n            \"MachineType\": \"BKL-AL20\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1103,\n            \"MachineType\": \"PRA-AL00X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1104,\n            \"MachineType\": \"MI 6X\"\n          }\n        ]\n    }\n}\n"));
      if (locala != null) {
        this.j = locala;
      }
      AppMethodBeat.o(222081);
      return;
    }
    catch (JSONException localJSONException)
    {
      TXCLog.w("CloudConfig", "loadDefaultConfig catch exception ".concat(String.valueOf(localJSONException)));
      this.j = new a(null);
      AppMethodBeat.o(222081);
    }
  }
  
  public long a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222058);
    k();
    long l2 = a(TXCCommonUtil.getAppID(), paramString1, paramString2);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = a("Global", paramString1, paramString2);
    }
    AppMethodBeat.o(222058);
    return l1;
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(222049);
    if (g == null)
    {
      paramContext = paramContext.getApplicationContext();
      g = paramContext;
      paramContext = paramContext.getExternalFilesDir(null);
      if (paramContext != null) {
        this.a = (paramContext.getAbsolutePath() + "/txrtmp/");
      }
    }
    AppMethodBeat.o(222049);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(222055);
    k();
    if ((paramFloat2 >= a.g(this.j)) || (paramFloat3 <= a.h(this.j)) || ((paramFloat1 >= a.i(this.j)) && (paramFloat3 <= a.j(this.j)))) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(222055);
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    AppMethodBeat.i(222060);
    k();
    if (a.q(this.j) != null)
    {
      Object localObject = a.q(this.j).optJSONObject("Global");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONObject("DNSWhiteList");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONArray("InfoList");
          if (localObject != null)
          {
            int m = 0;
            while (m < ((JSONArray)localObject).length()) {
              try
              {
                boolean bool = paramString.contains(((JSONArray)localObject).getString(m));
                if (bool)
                {
                  AppMethodBeat.o(222060);
                  return true;
                }
              }
              catch (Exception localException)
              {
                TXCLog.e("CloudConfig", "get string from json failed.", localException);
                m += 1;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(222060);
    return false;
  }
  
  public b b()
  {
    AppMethodBeat.i(222048);
    b localb = a().k;
    AppMethodBeat.o(222048);
    return localb;
  }
  
  public String c()
  {
    AppMethodBeat.i(222050);
    k();
    if (a.a(this.j).isEmpty()) {
      a("{\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1074,\n            \"MachineType\": \"OPPO A57\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"OPPO R11s\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1076,\n            \"MachineType\": \"OPPO R11\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1077,\n            \"MachineType\": \"OPPO A83\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"OPPO A73\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"SM-G9006V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1081,\n            \"MachineType\": \"vivo Y83A\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1083,\n            \"MachineType\": \"OPPO R17\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1084,\n            \"MachineType\": \"OPPO R15\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1085,\n            \"MachineType\": \"OPPO A37M\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1086,\n            \"MachineType\": \"OPPO A7X\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1087,\n            \"MachineType\": \"OPPO A3\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1088,\n            \"MachineType\": \"OPPO A5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1089,\n            \"MachineType\": \"OPPO A83T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1090,\n            \"MachineType\": \"OPPO R11T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1091,\n            \"MachineType\": \"OPPO R9S PLUS\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1092,\n            \"MachineType\": \"vivo Y51A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1093,\n            \"MachineType\": \"vivo V1813A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1095,\n            \"MachineType\": \"vivo Y67\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1097,\n            \"MachineType\": \"MHA-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1098,\n            \"MachineType\": \"ALP-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1099,\n            \"MachineType\": \"VTR-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1100,\n            \"MachineType\": \"BND-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1101,\n            \"MachineType\": \"COL-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1102,\n            \"MachineType\": \"BKL-AL20\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1103,\n            \"MachineType\": \"PRA-AL00X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1104,\n            \"MachineType\": \"MI 6X\"\n          }\n        ]    }", this.j);
    }
    String str = a.a(this.j);
    AppMethodBeat.o(222050);
    return str;
  }
  
  public int d()
  {
    AppMethodBeat.i(222051);
    k();
    int m = a.b(this.j);
    AppMethodBeat.o(222051);
    return m;
  }
  
  public int e()
  {
    AppMethodBeat.i(222052);
    k();
    int m = a.c(this.j);
    AppMethodBeat.o(222052);
    return m;
  }
  
  public int f()
  {
    AppMethodBeat.i(222053);
    k();
    int m = a.d(this.j);
    AppMethodBeat.o(222053);
    return m;
  }
  
  public int g()
  {
    AppMethodBeat.i(222054);
    k();
    int m = a.f(this.j);
    AppMethodBeat.o(222054);
    return m;
  }
  
  public boolean h()
  {
    AppMethodBeat.i(222056);
    long l2 = a("Audio", "UseLowLatencySampleRate");
    TXCLog.i("CloudConfig", "defaultValueOfUseLowLatencySampleRate: %d", new Object[] { Long.valueOf(l2) });
    long l1 = l2;
    if (l2 == -1L) {
      l1 = 0L;
    }
    if (1L == b().a(".audio.use_low_latency_samplerate", l1))
    {
      AppMethodBeat.o(222056);
      return true;
    }
    AppMethodBeat.o(222056);
    return false;
  }
  
  public long i()
  {
    AppMethodBeat.i(222057);
    long l = a("Audio", "LowLatencySampleRateBlockTime");
    if (l == -1L)
    {
      l = TimeUnit.DAYS.toMillis(7L);
      AppMethodBeat.o(222057);
      return l;
    }
    l = TimeUnit.SECONDS.toMillis(l);
    AppMethodBeat.o(222057);
    return l;
  }
  
  public void j()
  {
    AppMethodBeat.i(222064);
    if (m())
    {
      a(true);
      new Thread()
      {
        public void run()
        {
          AppMethodBeat.i(222037);
          c.a(c.this);
          AppMethodBeat.o(222037);
        }
      }.start();
    }
    AppMethodBeat.o(222064);
  }
  
  static class a
  {
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int[] f;
    private int g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private JSONObject o;
    private int p;
    private int q;
    
    private a()
    {
      AppMethodBeat.i(222036);
      this.a = 2;
      this.b = "";
      this.c = 0;
      this.d = 0;
      this.e = 0;
      this.f = null;
      this.g = 0;
      this.h = "";
      this.i = 60;
      this.j = 70;
      this.k = 80;
      this.l = 50;
      this.m = 10;
      this.n = 0;
      this.o = new JSONObject();
      this.p = -1;
      this.q = 0;
      AppMethodBeat.o(222036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.d.c
 * JD-Core Version:    0.7.0.1
 */