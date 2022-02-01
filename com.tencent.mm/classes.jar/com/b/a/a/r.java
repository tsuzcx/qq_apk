package com.b.a.a;

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
  private static final DecimalFormat ckg;
  private static final DecimalFormat ckh;
  private static r cki;
  private String ckj;
  private String ckk;
  private final b ckl;
  private int ckm;
  z ckn;
  private SharedPreferences cko;
  private f ckp;
  private final Object ckq;
  private final d ckr;
  q cks;
  String ckt;
  private int mRetryCount;
  
  static
  {
    AppMethodBeat.i(87891);
    ckg = new DecimalFormat("0000000000");
    ckh = new DecimalFormat("0000000000000000");
    AppMethodBeat.o(87891);
  }
  
  private r()
  {
    AppMethodBeat.i(87892);
    this.ckl = new b((byte)0);
    this.ckq = new Object();
    this.ckr = new d(this, (byte)0);
    AppMethodBeat.o(87892);
  }
  
  static r Jg()
  {
    AppMethodBeat.i(87893);
    if (cki == null) {
      cki = new r();
    }
    r localr = cki;
    AppMethodBeat.o(87893);
    return localr;
  }
  
  private String Jj()
  {
    AppMethodBeat.i(87902);
    try
    {
      String str = Jl().getString("1-115-10127", "");
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
  private void Jk()
  {
    AppMethodBeat.i(87903);
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        Jl().edit().remove("1-115-10127").apply();
        AppMethodBeat.o(87903);
        return;
      }
      Jl().edit().remove("1-115-10127").commit();
      AppMethodBeat.o(87903);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87903);
    }
  }
  
  private SharedPreferences Jl()
  {
    AppMethodBeat.i(87904);
    if (this.cko == null)
    {
      localObject = new Exception("OnlineModule: data buffer unavailable");
      AppMethodBeat.o(87904);
      throw ((Throwable)localObject);
    }
    Object localObject = this.cko;
    AppMethodBeat.o(87904);
    return localObject;
  }
  
  private void Jm()
  {
    String str;
    b localb;
    try
    {
      AppMethodBeat.i(87905);
      Object localObject1 = this.ckj;
      str = this.ckk;
      localb = this.ckl;
      if ((localObject1 == null) || (str == null) || (localb == null))
      {
        localObject1 = new Exception("OnlineModule: authenticate: null arg");
        AppMethodBeat.o(87905);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    System.arraycopy((localObject2 + str).getBytes(), 0, localb.ckv, 0, 27);
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
      paramLong = ckg.format(paramLong);
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
  private void cC(String paramString)
  {
    AppMethodBeat.i(87901);
    if (paramString == null)
    {
      AppMethodBeat.o(87901);
      return;
    }
    for (;;)
    {
      synchronized (this.ckq)
      {
        try
        {
          String str = Jl().getString("1-115-10127", "") + paramString;
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
          Jl().edit().putString("1-115-10127", paramString).apply();
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
        Jl().edit().putString("1-115-10127", paramString).commit();
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          Jl().edit().putString("1-115-10127", "").apply();
          continue;
        }
        Jl().edit().putString("1-115-10127", "").commit();
      }
      catch (Exception paramString) {}
      paramString = finally;
      AppMethodBeat.o(87901);
      throw paramString;
    }
  }
  
  private static String cD(String paramString)
  {
    AppMethodBeat.i(87906);
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = System.currentTimeMillis();
      paramString = "T" + ckh.format(l1 + l2);
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
      if (y.cnn) {
        o.t("data_transaction_log_" + y.cnu, paramString);
      }
      if ((paramString.length() <= h.chR) || (!paramString.startsWith("$UP,")))
      {
        paramString = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
        AppMethodBeat.o(87898);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      if (y.cnn) {
        o.t("data_transaction_log_" + y.cnu, "parse json data error");
      }
      paramString = new Exception("parse json data error");
      AppMethodBeat.o(87898);
      throw paramString;
    }
    switch (paramString.charAt(h.chR))
    {
    default: 
    case '1': 
      do
      {
        paramString = new Exception("OnlineModule: unable to parse data upload reply");
        AppMethodBeat.o(87898);
        throw paramString;
      } while (paramString.length() <= h.chS);
      paramString = o(paramString.substring(h.chS), l);
      paramString.cnb = paramLong1;
      paramString.ckz = paramLong2;
      paramString = new f(1, paramString, null, (byte)0);
      AppMethodBeat.o(87898);
      return paramString;
    case '0': 
      if (paramString.length() > h.chS) {}
      for (paramString = paramString.substring(h.chS);; paramString = null)
      {
        paramString = new f(0, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '2': 
      if (paramString.length() > h.chS) {}
      for (paramString = paramString.substring(h.chS);; paramString = null)
      {
        paramString = new f(2, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '3': 
      if (paramString.length() > h.chS) {}
      for (paramString = paramString.substring(h.chS);; paramString = null)
      {
        paramString = new f(3, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '4': 
      if (paramString.length() > h.chS) {}
      for (paramString = paramString.substring(h.chS);; paramString = null)
      {
        paramString = new f(4, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    case '5': 
      if (paramString.length() > h.chS) {}
      for (paramString = paramString.substring(h.chS);; paramString = null)
      {
        paramString = new f(5, null, paramString, (byte)0);
        AppMethodBeat.o(87898);
        return paramString;
      }
    }
    if (paramString.length() > h.chS) {}
    for (paramString = paramString.substring(h.chS);; paramString = null)
    {
      paramString = new f(6, null, paramString, (byte)0);
      AppMethodBeat.o(87898);
      return paramString;
    }
  }
  
  private static x o(String paramString, long paramLong)
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
                  localx.cmZ = paramString[2];
                  localx.level = i;
                  localx.cna = j;
                  localx.cnd = k;
                  localx.provider = paramString[6];
                  localx.cne = m;
                  localx.cjn = f3;
                  if (localx.cnc == null) {
                    localx.cnc = new x.a();
                  }
                  localx.cnc.cnf = f1;
                  localx.cjS = paramLong;
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
  
  private void p(String paramString, long paramLong)
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
      cC(str);
      AppMethodBeat.o(87900);
      return;
    }
    paramString = v.cF(v.cG(paramString));
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
  
  final void IV()
  {
    this.cks = null;
  }
  
  final void Jh()
  {
    AppMethodBeat.i(87896);
    if (this.ckn != null) {
      try
      {
        this.ckn.execute(d.a(this.ckr));
        AppMethodBeat.o(87896);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(87896);
  }
  
  final boolean Ji()
  {
    return this.ckl.code == 1;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87895);
    this.ckn = z.b(paramHandler);
    Jh();
    AppMethodBeat.o(87895);
  }
  
  final void au(Context paramContext)
  {
    AppMethodBeat.i(87894);
    try
    {
      String str2 = this.ckt;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0000000000";
      }
      this.ckj = cD(str1);
      this.ckk = a(Long.valueOf(System.currentTimeMillis() / 1000L));
      this.ckp = new f(paramContext);
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    this.cko = paramContext.getSharedPreferences("0-474-85242", 0);
    AppMethodBeat.o(87894);
  }
  
  final void av(Context paramContext) {}
  
  final void cB(String paramString)
  {
    AppMethodBeat.i(87897);
    if (this.ckn != null) {
      this.ckn.execute(new c(this, paramString, 0L, 1, (byte)0));
    }
    AppMethodBeat.o(87897);
  }
  
  static abstract class a
    implements Runnable
  {
    private final WeakReference<r> cku;
    
    private a(r paramr)
    {
      this.cku = new WeakReference(paramr);
    }
    
    final r Jn()
    {
      r localr = (r)this.cku.get();
      if (localr == null) {
        throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
      }
      return localr;
    }
  }
  
  static final class b
  {
    final byte[] ckv;
    int code;
    private final byte[] sessionKey;
    
    private b()
    {
      AppMethodBeat.i(87885);
      this.code = -1;
      this.ckv = new byte[27];
      this.sessionKey = new byte[8];
      AppMethodBeat.o(87885);
    }
  }
  
  static final class c
    extends r.a
  {
    private final String ckw;
    private final long ckx;
    private final int dataType;
    
    private c(r paramr, String paramString, long paramLong, int paramInt)
    {
      super((byte)0);
      this.ckw = paramString;
      this.ckx = paramLong;
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
        r.a(Jn(), this.ckw, this.ckx);
        AppMethodBeat.o(87886);
        return;
        r.a(Jn(), this.ckw);
      }
    }
  }
  
  static final class d
    extends r.a
  {
    private boolean cky;
    
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
          r.a(Jn());
          localf = r.b(Jn());
        }
        catch (Exception localException1)
        {
          f localf;
          Object localObject;
          continue;
        }
        try
        {
          localf.chG = Build.MODEL;
          localf.chH = Build.VERSION.RELEASE;
          localf.versionName = localf.mPackageInfo.versionName;
          localObject = localf.mContext.getApplicationInfo().loadLabel(localf.chE);
          if (localObject == null) {
            continue;
          }
          localObject = ((CharSequence)localObject).toString();
          localf.chF = ((String)localObject);
          if (localf.mSensorManager != null)
          {
            localObject = localf.mSensorManager.getDefaultSensor(1);
            Sensor localSensor1 = localf.mSensorManager.getDefaultSensor(4);
            Sensor localSensor2 = localf.mSensorManager.getDefaultSensor(2);
            Sensor localSensor3 = localf.mSensorManager.getDefaultSensor(11);
            if (localObject != null) {
              localf.chK = 1;
            }
            if (localSensor1 != null) {
              localf.chL = 1;
            }
            if (localSensor2 != null) {
              localf.chM = 1;
            }
            if (localSensor3 != null) {
              localf.chN = 1;
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
        this.cky = false;
        AppMethodBeat.o(87887);
        return;
        localObject = "unknown";
      }
    }
  }
  
  static final class e
    extends r.a
  {
    private final int cjO;
    private final boolean ckA;
    private final String ckw;
    private final long ckx;
    private final long ckz;
    
    private e(r paramr, String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
    {
      super((byte)0);
      this.ckw = paramString;
      this.ckx = paramLong1;
      this.ckz = paramLong2;
      this.cjO = paramInt;
      this.ckA = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(87889);
      try
      {
        r.a(Jn(), this.ckw, this.ckx, this.ckz, this.cjO, this.ckA);
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
    final x ckB;
    final boolean ckC;
    final String message;
    final int resultCode;
    
    private f(int paramInt, x paramx, String paramString)
    {
      super();
      AppMethodBeat.i(87890);
      this.resultCode = paramInt;
      this.ckB = paramx;
      this.message = paramString;
      if ((this.resultCode >= 0) && (this.resultCode != 4) && (this.resultCode != 2)) {}
      for (boolean bool = true;; bool = false)
      {
        this.ckC = bool;
        AppMethodBeat.o(87890);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.r
 * JD-Core Version:    0.7.0.1
 */