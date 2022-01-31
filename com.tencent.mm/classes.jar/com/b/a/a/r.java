package com.b.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class r
  extends d
{
  private static final DecimalFormat bpi;
  private static final DecimalFormat bpj;
  private static r bpk;
  private String bpl;
  private String bpm;
  private final r.b bpn;
  private int bpo;
  z bpp;
  private SharedPreferences bpq;
  private f bpr;
  private final Object bpt;
  private final r.d bpu;
  q bpv;
  String bpw;
  private int mRetryCount;
  
  static
  {
    AppMethodBeat.i(55546);
    bpi = new DecimalFormat("0000000000");
    bpj = new DecimalFormat("0000000000000000");
    AppMethodBeat.o(55546);
  }
  
  private r()
  {
    AppMethodBeat.i(55547);
    this.bpn = new r.b((byte)0);
    this.bpt = new Object();
    this.bpu = new r.d(this, (byte)0);
    AppMethodBeat.o(55547);
  }
  
  private static String a(Long paramLong)
  {
    AppMethodBeat.i(55562);
    if (paramLong == null)
    {
      paramLong = new Exception("OnlineModule: null source id");
      AppMethodBeat.o(55562);
      throw paramLong;
    }
    try
    {
      paramLong = bpi.format(paramLong);
      AppMethodBeat.o(55562);
      return paramLong;
    }
    catch (NumberFormatException paramLong)
    {
      paramLong = new Exception("OnlineModule: invalid source id");
      AppMethodBeat.o(55562);
      throw paramLong;
    }
  }
  
  @SuppressLint({"NewApi"})
  private void bq(String paramString)
  {
    AppMethodBeat.i(55556);
    if (paramString == null)
    {
      AppMethodBeat.o(55556);
      return;
    }
    for (;;)
    {
      synchronized (this.bpt)
      {
        try
        {
          String str = tt().getString("1-115-10127", "") + paramString;
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
          tt().edit().putString("1-115-10127", paramString).apply();
        }
        catch (Exception paramString)
        {
          continue;
        }
        catch (Error paramString) {}
        AppMethodBeat.o(55556);
        return;
        paramString = "";
        continue;
        tt().edit().putString("1-115-10127", paramString).commit();
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          tt().edit().putString("1-115-10127", "").apply();
          continue;
        }
        tt().edit().putString("1-115-10127", "").commit();
      }
      catch (Exception paramString) {}
      paramString = finally;
      AppMethodBeat.o(55556);
      throw paramString;
    }
  }
  
  private static String br(String paramString)
  {
    AppMethodBeat.i(55561);
    try
    {
      long l1 = Long.parseLong(paramString);
      long l2 = System.currentTimeMillis();
      paramString = "T" + bpj.format(l1 + l2);
      AppMethodBeat.o(55561);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString = new Exception("OnlineModule: invalid device id, type: 0");
      AppMethodBeat.o(55561);
      throw paramString;
    }
  }
  
  private static r.f i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(55553);
    long l;
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("errorcode", -5);
      if (i != 0)
      {
        paramString = new r.f(i, null, null, (byte)0);
        AppMethodBeat.o(55553);
        return paramString;
      }
      l = paramString.optLong("hitarea", 0L);
      paramString = new String(Base64.decode(paramString.optString("swdata", null), 0), "UTF-8");
      if (y.bsr) {
        o.r("data_transaction_log_" + y.bsy, paramString);
      }
      if ((paramString.length() <= h.bmQ) || (!paramString.startsWith("$UP,")))
      {
        paramString = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
        AppMethodBeat.o(55553);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      if (y.bsr) {
        o.r("data_transaction_log_" + y.bsy, "parse json data error");
      }
      paramString = new Exception("parse json data error");
      AppMethodBeat.o(55553);
      throw paramString;
    }
    switch (paramString.charAt(h.bmQ))
    {
    default: 
    case '1': 
      do
      {
        paramString = new Exception("OnlineModule: unable to parse data upload reply");
        AppMethodBeat.o(55553);
        throw paramString;
      } while (paramString.length() <= h.bmR);
      paramString = n(paramString.substring(h.bmR), l);
      paramString.bsf = paramLong1;
      paramString.bpC = paramLong2;
      paramString = new r.f(1, paramString, null, (byte)0);
      AppMethodBeat.o(55553);
      return paramString;
    case '0': 
      if (paramString.length() > h.bmR) {}
      for (paramString = paramString.substring(h.bmR);; paramString = null)
      {
        paramString = new r.f(0, null, paramString, (byte)0);
        AppMethodBeat.o(55553);
        return paramString;
      }
    case '2': 
      if (paramString.length() > h.bmR) {}
      for (paramString = paramString.substring(h.bmR);; paramString = null)
      {
        paramString = new r.f(2, null, paramString, (byte)0);
        AppMethodBeat.o(55553);
        return paramString;
      }
    case '3': 
      if (paramString.length() > h.bmR) {}
      for (paramString = paramString.substring(h.bmR);; paramString = null)
      {
        paramString = new r.f(3, null, paramString, (byte)0);
        AppMethodBeat.o(55553);
        return paramString;
      }
    case '4': 
      if (paramString.length() > h.bmR) {}
      for (paramString = paramString.substring(h.bmR);; paramString = null)
      {
        paramString = new r.f(4, null, paramString, (byte)0);
        AppMethodBeat.o(55553);
        return paramString;
      }
    case '5': 
      if (paramString.length() > h.bmR) {}
      for (paramString = paramString.substring(h.bmR);; paramString = null)
      {
        paramString = new r.f(5, null, paramString, (byte)0);
        AppMethodBeat.o(55553);
        return paramString;
      }
    }
    if (paramString.length() > h.bmR) {}
    for (paramString = paramString.substring(h.bmR);; paramString = null)
    {
      paramString = new r.f(6, null, paramString, (byte)0);
      AppMethodBeat.o(55553);
      return paramString;
    }
  }
  
  private static x n(String paramString, long paramLong)
  {
    int m = 0;
    AppMethodBeat.i(55554);
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
                  localx.bsc = paramString[2];
                  localx.level = i;
                  localx.bse = j;
                  localx.bsh = k;
                  localx.bsd = paramString[6];
                  localx.bsi = m;
                  localx.boo = f3;
                  if (localx.bsg == null) {
                    localx.bsg = new x.a();
                  }
                  localx.bsg.bsj = f1;
                  localx.boT = paramLong;
                  AppMethodBeat.o(55554);
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
    AppMethodBeat.o(55554);
    throw paramString;
  }
  
  private void o(String paramString, long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(55555);
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.startsWith("&OD[]=")) {
        str = paramString;
      }
    }
    else
    {
      bq(str);
      AppMethodBeat.o(55555);
      return;
    }
    paramString = v.bt(v.bu(paramString));
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
      str = v.a(paramString, paramLong, "1");
      break;
      paramString = paramString.replace("&MD=", "|MD,");
      break label56;
    }
  }
  
  static r to()
  {
    AppMethodBeat.i(55548);
    if (bpk == null) {
      bpk = new r();
    }
    r localr = bpk;
    AppMethodBeat.o(55548);
    return localr;
  }
  
  private String tr()
  {
    AppMethodBeat.i(55557);
    try
    {
      String str = tt().getString("1-115-10127", "");
      AppMethodBeat.o(55557);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55557);
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  private void ts()
  {
    AppMethodBeat.i(55558);
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        tt().edit().remove("1-115-10127").apply();
        AppMethodBeat.o(55558);
        return;
      }
      tt().edit().remove("1-115-10127").commit();
      AppMethodBeat.o(55558);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55558);
    }
  }
  
  private SharedPreferences tt()
  {
    AppMethodBeat.i(55559);
    if (this.bpq == null)
    {
      localObject = new Exception("OnlineModule: data buffer unavailable");
      AppMethodBeat.o(55559);
      throw ((Throwable)localObject);
    }
    Object localObject = this.bpq;
    AppMethodBeat.o(55559);
    return localObject;
  }
  
  private void tu()
  {
    String str;
    r.b localb;
    try
    {
      AppMethodBeat.i(55560);
      Object localObject1 = this.bpl;
      str = this.bpm;
      localb = this.bpn;
      if ((localObject1 == null) || (str == null) || (localb == null))
      {
        localObject1 = new Exception("OnlineModule: authenticate: null arg");
        AppMethodBeat.o(55560);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    System.arraycopy((localObject2 + str).getBytes(), 0, localb.bpy, 0, 27);
    localb.code = 1;
    AppMethodBeat.o(55560);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(55550);
    this.bpp = z.b(paramHandler);
    tp();
    AppMethodBeat.o(55550);
  }
  
  final void al(Context paramContext)
  {
    AppMethodBeat.i(55549);
    try
    {
      String str2 = this.bpw;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0000000000";
      }
      this.bpl = br(str1);
      this.bpm = a(Long.valueOf(System.currentTimeMillis() / 1000L));
      this.bpr = new f(paramContext);
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    this.bpq = paramContext.getSharedPreferences("0-474-85242", 0);
    AppMethodBeat.o(55549);
  }
  
  final void am(Context paramContext) {}
  
  final void bp(String paramString)
  {
    AppMethodBeat.i(55552);
    if (this.bpp != null) {
      this.bpp.execute(new r.c(this, paramString, 0L, 1, (byte)0));
    }
    AppMethodBeat.o(55552);
  }
  
  final void td()
  {
    this.bpv = null;
  }
  
  final void tp()
  {
    AppMethodBeat.i(55551);
    if (this.bpp != null) {
      try
      {
        this.bpp.execute(r.d.a(this.bpu));
        AppMethodBeat.o(55551);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(55551);
  }
  
  final boolean tq()
  {
    return this.bpn.code == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.b.a.a.r
 * JD-Core Version:    0.7.0.1
 */