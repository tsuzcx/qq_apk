package com.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class r
  extends d
{
  private static final DecimalFormat bZA;
  private static r bZB;
  private static final DecimalFormat bZz;
  private String bZC;
  private String bZD;
  private final b bZE;
  private int bZF;
  z bZG;
  private SharedPreferences bZH;
  private f bZI;
  private final Object bZJ;
  private final d bZK;
  q bZL;
  String bZM;
  private int mRetryCount;
  
  static
  {
    AppMethodBeat.i(87891);
    bZz = new DecimalFormat("0000000000");
    bZA = new DecimalFormat("0000000000000000");
    AppMethodBeat.o(87891);
  }
  
  private r()
  {
    AppMethodBeat.i(87892);
    this.bZE = new b((byte)0);
    this.bZJ = new Object();
    this.bZK = new d(this, (byte)0);
    AppMethodBeat.o(87892);
  }
  
  static r An()
  {
    AppMethodBeat.i(87893);
    if (bZB == null) {
      bZB = new r();
    }
    r localr = bZB;
    AppMethodBeat.o(87893);
    return localr;
  }
  
  private String Aq()
  {
    AppMethodBeat.i(87902);
    try
    {
      String str = As().getString("1-115-10127", "");
      AppMethodBeat.o(87902);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87902);
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  private void Ar()
  {
    AppMethodBeat.i(87903);
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        As().edit().remove("1-115-10127").apply();
        AppMethodBeat.o(87903);
        return;
      }
      As().edit().remove("1-115-10127").commit();
      AppMethodBeat.o(87903);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87903);
    }
  }
  
  private SharedPreferences As()
  {
    AppMethodBeat.i(87904);
    if (this.bZH == null)
    {
      localObject = new Exception("OnlineModule: data buffer unavailable");
      AppMethodBeat.o(87904);
      throw ((Throwable)localObject);
    }
    Object localObject = this.bZH;
    AppMethodBeat.o(87904);
    return localObject;
  }
  
  private void At()
  {
    String str;
    b localb;
    try
    {
      AppMethodBeat.i(87905);
      Object localObject1 = this.bZC;
      str = this.bZD;
      localb = this.bZE;
      if ((localObject1 == null) || (str == null) || (localb == null))
      {
        localObject1 = new Exception("OnlineModule: authenticate: null arg");
        AppMethodBeat.o(87905);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    System.arraycopy((localObject2 + str).getBytes(), 0, localb.bZO, 0, 27);
    localb.code = 1;
    AppMethodBeat.o(87905);
  }
  
  private static String a(Long paramLong)
  {
    AppMethodBeat.i(87907);
    if (paramLong == null)
    {
      paramLong = new Exception("OnlineModule: null source id");
      AppMethodBeat.o(87907);
      throw paramLong;
    }
    try
    {
      paramLong = bZz.format(paramLong);
      AppMethodBeat.o(87907);
      return paramLong;
    }
    catch (NumberFormatException paramLong)
    {
      paramLong = new Exception("OnlineModule: invalid source id");
      AppMethodBeat.o(87907);
      throw paramLong;
    }
  }
  
  @SuppressLint({"NewApi"})
  private void cn(String paramString)
  {
    AppMethodBeat.i(87901);
    if (paramString == null)
    {
      AppMethodBeat.o(87901);
      return;
    }
    for (;;)
    {
      synchronized (this.bZJ)
      {
        try
        {
          String str = As().getString("1-115-10127", "") + paramString;
          int i = str.length() - 307200;
          paramString = str;
          if (i > 0)
          {
            int j = str.indexOf("&OD[]=", i);
            if (j < i) {
              continue;
            }
            paramString = str.substring(j);
          }
          if (Build.VERSION.SDK_INT < 9) {
            continue;
          }
          As().edit().putString("1-115-10127", paramString).apply();
        }
        catch (Exception paramString)
        {
          continue;
        }
        catch (Error paramString) {}
        AppMethodBeat.o(87901);
        return;
        paramString = "";
        continue;
        As().edit().putString("1-115-10127", paramString).commit();
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          As().edit().putString("1-115-10127", "").apply();
          continue;
        }
        As().edit().putString("1-115-10127", "").commit();
      }
      catch (Exception paramString) {}
      paramString = finally;
      AppMethodBeat.o(87901);
      throw paramString;
    }
  }
  
  private static String co(String paramString)
  {
    AppMethodBeat.i(87906);
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = System.currentTimeMillis();
      paramString = "T" + bZA.format(l1 + l2);
      AppMethodBeat.o(87906);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString = new Exception("OnlineModule: invalid device id, type: 0");
      AppMethodBeat.o(87906);
      throw paramString;
    }
  }
  
  private static f h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(87898);
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("errorcode", -5);
      if (i != 0)
      {
        paramString = new f(i, null, null, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
      l = paramString.optLong("hitarea", 0L);
      paramString = new String(Base64.decode(paramString.optString("swdata", null), 0), "UTF-8");
      if (y.ccH) {
        o.t("data_transaction_log_" + y.ccO, paramString);
      }
      if ((paramString.length() <= h.bXk) || (!paramString.startsWith("$UP,")))
      {
        paramString = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
        AppMethodBeat.o(87898);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      if (y.ccH) {
        o.t("data_transaction_log_" + y.ccO, "parse json data error");
      }
      paramString = new Exception("parse json data error");
      AppMethodBeat.o(87898);
      throw paramString;
    }
    switch (paramString.charAt(h.bXk))
    {
    default: 
    case '1': 
      do
      {
        paramString = new Exception("OnlineModule: unable to parse data upload reply");
        AppMethodBeat.o(87898);
        throw paramString;
      } while (paramString.length() <= h.bXl);
      paramString = n(paramString.substring(h.bXl), l);
      paramString.ccv = paramLong1;
      paramString.bZS = paramLong2;
      paramString = new f(1, paramString, null, (byte)0);
      AppMethodBeat.o(87898);
      return paramString;
    case '0': 
      if (paramString.length() > h.bXl) {}
      for (paramString = paramString.substring(h.bXl);; paramString = null)
      {
        paramString = new f(0, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '2': 
      if (paramString.length() > h.bXl) {}
      for (paramString = paramString.substring(h.bXl);; paramString = null)
      {
        paramString = new f(2, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '3': 
      if (paramString.length() > h.bXl) {}
      for (paramString = paramString.substring(h.bXl);; paramString = null)
      {
        paramString = new f(3, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '4': 
      if (paramString.length() > h.bXl) {}
      for (paramString = paramString.substring(h.bXl);; paramString = null)
      {
        paramString = new f(4, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '5': 
      if (paramString.length() > h.bXl) {}
      for (paramString = paramString.substring(h.bXl);; paramString = null)
      {
        paramString = new f(5, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    }
    if (paramString.length() > h.bXl) {}
    for (paramString = paramString.substring(h.bXl);; paramString = null)
    {
      paramString = new f(6, null, paramString, (byte)0);
      AppMethodBeat.o(87898);
      return paramString;
    }
  }
  
  private static x n(String paramString, long paramLong)
  {
    int m = 0;
    AppMethodBeat.i(87899);
    if (paramString != null)
    {
      paramString = paramString.split(",", -1);
      if (paramString.length == 10) {
        try
        {
          double d1 = Double.parseDouble(paramString[0]);
          double d2 = Double.parseDouble(paramString[1]);
          float f3 = Float.parseFloat(paramString[8]);
          try
          {
            i = Integer.parseInt(paramString[3]);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            try
            {
              j = Integer.parseInt(paramString[4]);
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              try
              {
                for (;;)
                {
                  k = Integer.parseInt(paramString[5]);
                  try
                  {
                    int n = Integer.parseInt(paramString[7]);
                    m = n;
                  }
                  catch (NumberFormatException localNumberFormatException5)
                  {
                    label90:
                    float f1;
                    break label90;
                  }
                  f1 = 0.0F;
                  try
                  {
                    float f2 = Float.parseFloat(paramString[9]);
                    f1 = f2;
                  }
                  catch (NumberFormatException localNumberFormatException4)
                  {
                    label106:
                    x localx;
                    break label106;
                  }
                  localx = new x();
                  localx.latitude = d1;
                  localx.longitude = d2;
                  localx.cct = paramString[2];
                  localx.level = i;
                  localx.ccu = j;
                  localx.ccx = k;
                  localx.provider = paramString[6];
                  localx.ccy = m;
                  localx.bYG = f3;
                  if (localx.ccw == null) {
                    localx.ccw = new x.a();
                  }
                  localx.ccw.ccz = f1;
                  localx.bZl = paramLong;
                  AppMethodBeat.o(87899);
                  return localx;
                  localNumberFormatException1 = localNumberFormatException1;
                  int i = 0;
                  continue;
                  localNumberFormatException2 = localNumberFormatException2;
                  int j = 0;
                }
              }
              catch (NumberFormatException localNumberFormatException3)
              {
                for (;;)
                {
                  int k = 0;
                }
              }
            }
          }
          paramString = new Exception("OnlineModule: unable to get location from data upload reply");
        }
        catch (NumberFormatException paramString) {}
      }
    }
    AppMethodBeat.o(87899);
    throw paramString;
  }
  
  private void o(String paramString, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(87900);
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.startsWith("&OD[]=")) {
        str = paramString;
      }
    }
    else
    {
      cn(str);
      AppMethodBeat.o(87900);
      return;
    }
    paramString = v.cq(v.cr(paramString));
    if (paramString == null)
    {
      paramString = null;
      label56:
      if (paramString != null) {
        break label90;
      }
    }
    label90:
    for (paramString = localObject;; paramString = paramString.replace("&WD[]=", "|WD,"))
    {
      str = v.b(paramString, paramLong, "1");
      break;
      paramString = paramString.replace("&MD=", "|MD,");
      break label56;
    }
  }
  
  final void Ac()
  {
    this.bZL = null;
  }
  
  final void Ao()
  {
    AppMethodBeat.i(87896);
    if (this.bZG != null) {
      try
      {
        this.bZG.execute(d.a(this.bZK));
        AppMethodBeat.o(87896);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(87896);
  }
  
  final boolean Ap()
  {
    return this.bZE.code == 1;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87895);
    this.bZG = z.b(paramHandler);
    Ao();
    AppMethodBeat.o(87895);
  }
  
  final void at(Context paramContext)
  {
    AppMethodBeat.i(87894);
    try
    {
      String str2 = this.bZM;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0000000000";
      }
      this.bZC = co(str1);
      this.bZD = a(Long.valueOf(System.currentTimeMillis() / 1000L));
      this.bZI = new f(paramContext);
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    this.bZH = paramContext.getSharedPreferences("0-474-85242", 0);
    AppMethodBeat.o(87894);
  }
  
  final void au(Context paramContext) {}
  
  final void cm(String paramString)
  {
    AppMethodBeat.i(87897);
    if (this.bZG != null) {
      this.bZG.execute(new c(this, paramString, 0L, 1, (byte)0));
    }
    AppMethodBeat.o(87897);
  }
  
  static abstract class a
    implements Runnable
  {
    private final WeakReference<r> bZN;
    
    private a(r paramr)
    {
      this.bZN = new WeakReference(paramr);
    }
    
    final r Au()
    {
      r localr = (r)this.bZN.get();
      if (localr == null) {
        throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
      }
      return localr;
    }
  }
  
  static final class b
  {
    final byte[] bZO;
    int code;
    private final byte[] sessionKey;
    
    private b()
    {
      AppMethodBeat.i(87885);
      this.code = -1;
      this.bZO = new byte[27];
      this.sessionKey = new byte[8];
      AppMethodBeat.o(87885);
    }
  }
  
  static final class c
    extends r.a
  {
    private final String bZP;
    private final long bZQ;
    private final int dataType;
    
    private c(r paramr, String paramString, long paramLong, int paramInt)
    {
      super((byte)0);
      this.bZP = paramString;
      this.bZQ = paramLong;
      this.dataType = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(87886);
      for (;;)
      {
        try
        {
          int i = this.dataType;
          switch (i)
          {
          default: 
            AppMethodBeat.o(87886);
            return;
          }
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(87886);
          return;
        }
        r.a(Au(), this.bZP, this.bZQ);
        AppMethodBeat.o(87886);
        return;
        r.a(Au(), this.bZP);
      }
    }
  }
  
  static final class d
    extends r.a
  {
    private boolean bZR;
    
    private d(r paramr)
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(87887);
      for (;;)
      {
        try
        {
          r.a(Au());
          localf = r.b(Au());
        }
        catch (Exception localException1)
        {
          f localf;
          Object localObject;
          continue;
        }
        try
        {
          localf.bWZ = Build.MODEL;
          localf.bXa = Build.VERSION.RELEASE;
          localf.versionName = localf.bWX.versionName;
          localObject = localf.mContext.getApplicationInfo().loadLabel(localf.bWW);
          if (localObject == null) {
            continue;
          }
          localObject = ((CharSequence)localObject).toString();
          localf.bWY = ((String)localObject);
          if (localf.mSensorManager != null)
          {
            localObject = localf.mSensorManager.getDefaultSensor(1);
            Sensor localSensor1 = localf.mSensorManager.getDefaultSensor(4);
            Sensor localSensor2 = localf.mSensorManager.getDefaultSensor(2);
            Sensor localSensor3 = localf.mSensorManager.getDefaultSensor(11);
            if (localObject != null) {
              localf.bXd = 1;
            }
            if (localSensor1 != null) {
              localf.bXe = 1;
            }
            if (localSensor2 != null) {
              localf.bXf = 1;
            }
            if (localSensor3 != null) {
              localf.bXg = 1;
            }
          }
        }
        catch (Error localError)
        {
          continue;
        }
        catch (Exception localException2)
        {
          continue;
        }
        this.bZR = false;
        AppMethodBeat.o(87887);
        return;
        localObject = "unknown";
      }
    }
  }
  
  static final class e
    extends r.a
  {
    private final String bZP;
    private final long bZQ;
    private final long bZS;
    private final boolean bZT;
    private final int bZh;
    
    private e(r paramr, String paramString, long paramLong1, long paramLong2, int paramInt)
    {
      super((byte)0);
      this.bZP = paramString;
      this.bZQ = paramLong1;
      this.bZS = paramLong2;
      this.bZh = paramInt;
      this.bZT = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(87889);
      try
      {
        r.a(Au(), this.bZP, this.bZQ, this.bZS, this.bZh, this.bZT);
        AppMethodBeat.o(87889);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(87889);
      }
    }
  }
  
  static final class f
    extends p
  {
    final int bZU;
    final x bZV;
    final boolean bZW;
    final String message;
    
    private f(int paramInt, x paramx, String paramString)
    {
      super();
      AppMethodBeat.i(87890);
      this.bZU = paramInt;
      this.bZV = paramx;
      this.message = paramString;
      if ((this.bZU >= 0) && (this.bZU != 4) && (this.bZU != 2)) {}
      for (boolean bool = true;; bool = false)
      {
        this.bZW = bool;
        AppMethodBeat.o(87890);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.r
 * JD-Core Version:    0.7.0.1
 */