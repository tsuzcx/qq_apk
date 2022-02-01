package com.c.a.a;

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
  private static final DecimalFormat bRE;
  private static final DecimalFormat bRF;
  private static r bRG;
  private String bRH;
  private String bRI;
  private final b bRJ;
  private int bRK;
  z bRL;
  private SharedPreferences bRM;
  private f bRN;
  private final Object bRO;
  private final d bRP;
  q bRQ;
  String bRR;
  private int mRetryCount;
  
  static
  {
    AppMethodBeat.i(87891);
    bRE = new DecimalFormat("0000000000");
    bRF = new DecimalFormat("0000000000000000");
    AppMethodBeat.o(87891);
  }
  
  private r()
  {
    AppMethodBeat.i(87892);
    this.bRJ = new b((byte)0);
    this.bRO = new Object();
    this.bRP = new d(this, (byte)0);
    AppMethodBeat.o(87892);
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
      paramLong = bRE.format(paramLong);
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
  private void bC(String paramString)
  {
    AppMethodBeat.i(87901);
    if (paramString == null)
    {
      AppMethodBeat.o(87901);
      return;
    }
    for (;;)
    {
      synchronized (this.bRO)
      {
        try
        {
          String str = zh().getString("1-115-10127", "") + paramString;
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
          zh().edit().putString("1-115-10127", paramString).apply();
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
        zh().edit().putString("1-115-10127", paramString).commit();
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          zh().edit().putString("1-115-10127", "").apply();
          continue;
        }
        zh().edit().putString("1-115-10127", "").commit();
      }
      catch (Exception paramString) {}
      paramString = finally;
      AppMethodBeat.o(87901);
      throw paramString;
    }
  }
  
  private static String bD(String paramString)
  {
    AppMethodBeat.i(87906);
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = System.currentTimeMillis();
      paramString = "T" + bRF.format(l1 + l2);
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
  
  private static f i(String paramString, long paramLong1, long paramLong2)
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
      if (y.bUM) {
        o.s("data_transaction_log_" + y.bUT, paramString);
      }
      if ((paramString.length() <= h.bPp) || (!paramString.startsWith("$UP,")))
      {
        paramString = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
        AppMethodBeat.o(87898);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      if (y.bUM) {
        o.s("data_transaction_log_" + y.bUT, "parse json data error");
      }
      paramString = new Exception("parse json data error");
      AppMethodBeat.o(87898);
      throw paramString;
    }
    switch (paramString.charAt(h.bPp))
    {
    default: 
    case '1': 
      do
      {
        paramString = new Exception("OnlineModule: unable to parse data upload reply");
        AppMethodBeat.o(87898);
        throw paramString;
      } while (paramString.length() <= h.bPq);
      paramString = n(paramString.substring(h.bPq), l);
      paramString.bUA = paramLong1;
      paramString.bRX = paramLong2;
      paramString = new f(1, paramString, null, (byte)0);
      AppMethodBeat.o(87898);
      return paramString;
    case '0': 
      if (paramString.length() > h.bPq) {}
      for (paramString = paramString.substring(h.bPq);; paramString = null)
      {
        paramString = new f(0, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '2': 
      if (paramString.length() > h.bPq) {}
      for (paramString = paramString.substring(h.bPq);; paramString = null)
      {
        paramString = new f(2, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '3': 
      if (paramString.length() > h.bPq) {}
      for (paramString = paramString.substring(h.bPq);; paramString = null)
      {
        paramString = new f(3, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '4': 
      if (paramString.length() > h.bPq) {}
      for (paramString = paramString.substring(h.bPq);; paramString = null)
      {
        paramString = new f(4, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '5': 
      if (paramString.length() > h.bPq) {}
      for (paramString = paramString.substring(h.bPq);; paramString = null)
      {
        paramString = new f(5, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    }
    if (paramString.length() > h.bPq) {}
    for (paramString = paramString.substring(h.bPq);; paramString = null)
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
                  localx.bUy = paramString[2];
                  localx.level = i;
                  localx.bUz = j;
                  localx.bUC = k;
                  localx.provider = paramString[6];
                  localx.bUD = m;
                  localx.bQL = f3;
                  if (localx.bUB == null) {
                    localx.bUB = new x.a();
                  }
                  localx.bUB.bUE = f1;
                  localx.bRq = paramLong;
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
      bC(str);
      AppMethodBeat.o(87900);
      return;
    }
    paramString = v.bF(v.bG(paramString));
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
  
  static r zc()
  {
    AppMethodBeat.i(87893);
    if (bRG == null) {
      bRG = new r();
    }
    r localr = bRG;
    AppMethodBeat.o(87893);
    return localr;
  }
  
  private String zf()
  {
    AppMethodBeat.i(87902);
    try
    {
      String str = zh().getString("1-115-10127", "");
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
  private void zg()
  {
    AppMethodBeat.i(87903);
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        zh().edit().remove("1-115-10127").apply();
        AppMethodBeat.o(87903);
        return;
      }
      zh().edit().remove("1-115-10127").commit();
      AppMethodBeat.o(87903);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87903);
    }
  }
  
  private SharedPreferences zh()
  {
    AppMethodBeat.i(87904);
    if (this.bRM == null)
    {
      localObject = new Exception("OnlineModule: data buffer unavailable");
      AppMethodBeat.o(87904);
      throw ((Throwable)localObject);
    }
    Object localObject = this.bRM;
    AppMethodBeat.o(87904);
    return localObject;
  }
  
  private void zi()
  {
    String str;
    b localb;
    try
    {
      AppMethodBeat.i(87905);
      Object localObject1 = this.bRH;
      str = this.bRI;
      localb = this.bRJ;
      if ((localObject1 == null) || (str == null) || (localb == null))
      {
        localObject1 = new Exception("OnlineModule: authenticate: null arg");
        AppMethodBeat.o(87905);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    System.arraycopy((localObject2 + str).getBytes(), 0, localb.bRT, 0, 27);
    localb.code = 1;
    AppMethodBeat.o(87905);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87895);
    this.bRL = z.b(paramHandler);
    zd();
    AppMethodBeat.o(87895);
  }
  
  final void ar(Context paramContext)
  {
    AppMethodBeat.i(87894);
    try
    {
      String str2 = this.bRR;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0000000000";
      }
      this.bRH = bD(str1);
      this.bRI = a(Long.valueOf(System.currentTimeMillis() / 1000L));
      this.bRN = new f(paramContext);
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    this.bRM = paramContext.getSharedPreferences("0-474-85242", 0);
    AppMethodBeat.o(87894);
  }
  
  final void as(Context paramContext) {}
  
  final void bB(String paramString)
  {
    AppMethodBeat.i(87897);
    if (this.bRL != null) {
      this.bRL.execute(new c(this, paramString, 0L, 1, (byte)0));
    }
    AppMethodBeat.o(87897);
  }
  
  final void yR()
  {
    this.bRQ = null;
  }
  
  final void zd()
  {
    AppMethodBeat.i(87896);
    if (this.bRL != null) {
      try
      {
        this.bRL.execute(d.a(this.bRP));
        AppMethodBeat.o(87896);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(87896);
  }
  
  final boolean ze()
  {
    return this.bRJ.code == 1;
  }
  
  static abstract class a
    implements Runnable
  {
    private final WeakReference<r> bRS;
    
    private a(r paramr)
    {
      this.bRS = new WeakReference(paramr);
    }
    
    final r zj()
    {
      r localr = (r)this.bRS.get();
      if (localr == null) {
        throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
      }
      return localr;
    }
  }
  
  static final class b
  {
    final byte[] bRT;
    int code;
    private final byte[] sessionKey;
    
    private b()
    {
      AppMethodBeat.i(87885);
      this.code = -1;
      this.bRT = new byte[27];
      this.sessionKey = new byte[8];
      AppMethodBeat.o(87885);
    }
  }
  
  static final class c
    extends r.a
  {
    private final String bRU;
    private final long bRV;
    private final int dataType;
    
    private c(r paramr, String paramString, long paramLong, int paramInt)
    {
      super((byte)0);
      this.bRU = paramString;
      this.bRV = paramLong;
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
        r.a(zj(), this.bRU, this.bRV);
        AppMethodBeat.o(87886);
        return;
        r.a(zj(), this.bRU);
      }
    }
  }
  
  static final class d
    extends r.a
  {
    private boolean bRW;
    
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
          r.a(zj());
          localf = r.b(zj());
        }
        catch (Exception localException1)
        {
          f localf;
          Object localObject;
          continue;
        }
        try
        {
          localf.bPe = Build.MODEL;
          localf.bPf = Build.VERSION.RELEASE;
          localf.versionName = localf.bPc.versionName;
          localObject = localf.mContext.getApplicationInfo().loadLabel(localf.bPb);
          if (localObject == null) {
            continue;
          }
          localObject = ((CharSequence)localObject).toString();
          localf.bPd = ((String)localObject);
          if (localf.mSensorManager != null)
          {
            localObject = localf.mSensorManager.getDefaultSensor(1);
            Sensor localSensor1 = localf.mSensorManager.getDefaultSensor(4);
            Sensor localSensor2 = localf.mSensorManager.getDefaultSensor(2);
            Sensor localSensor3 = localf.mSensorManager.getDefaultSensor(11);
            if (localObject != null) {
              localf.bPi = 1;
            }
            if (localSensor1 != null) {
              localf.bPj = 1;
            }
            if (localSensor2 != null) {
              localf.bPk = 1;
            }
            if (localSensor3 != null) {
              localf.bPl = 1;
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
        this.bRW = false;
        AppMethodBeat.o(87887);
        return;
        localObject = "unknown";
      }
    }
  }
  
  static final class e
    extends r.a
  {
    private final String bRU;
    private final long bRV;
    private final long bRX;
    private final boolean bRY;
    private final int bRm;
    
    private e(r paramr, String paramString, long paramLong1, long paramLong2, int paramInt)
    {
      super((byte)0);
      this.bRU = paramString;
      this.bRV = paramLong1;
      this.bRX = paramLong2;
      this.bRm = paramInt;
      this.bRY = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(87889);
      try
      {
        r.a(zj(), this.bRU, this.bRV, this.bRX, this.bRm, this.bRY);
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
    final int bRZ;
    final x bSa;
    final boolean bSb;
    final String message;
    
    private f(int paramInt, x paramx, String paramString)
    {
      super();
      AppMethodBeat.i(87890);
      this.bRZ = paramInt;
      this.bSa = paramx;
      this.message = paramString;
      if ((this.bRZ >= 0) && (this.bRZ != 4) && (this.bRZ != 2)) {}
      for (boolean bool = true;; bool = false)
      {
        this.bSb = bool;
        AppMethodBeat.o(87890);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.r
 * JD-Core Version:    0.7.0.1
 */