package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class cn
{
  public byte[] a = new byte[0];
  public Context b;
  public ct c;
  public HandlerThread d;
  public volatile Location e;
  public volatile Location f;
  public volatile List<cp> g;
  public volatile cp h;
  public long i = 0L;
  public long j = 0L;
  private long k = 180000L;
  private long l = 0L;
  
  public cn(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getApplicationContext())
    {
      this.b = paramContext;
      if (this.b != null) {
        break;
      }
      throw new IllegalArgumentException("context cannot be null!");
    }
    try
    {
      paramContext = this.b.getExternalFilesDir("data").getAbsolutePath();
      if (!TextUtils.isEmpty(paramContext))
      {
        this.c = new ct(this.b, paramContext);
        d();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      this.c = null;
    }
  }
  
  public static Location a(Location paramLocation1, Location paramLocation2)
  {
    Location localLocation = paramLocation1;
    if (paramLocation1 == null) {
      localLocation = new Location("gps");
    }
    if (paramLocation2 != null) {
      localLocation.set(paramLocation2);
    }
    return localLocation;
  }
  
  private void d()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("D_CH_ID", "fc_sdk");
    ((HashMap)localObject).put("D_FC_SRC", "209");
    ((HashMap)localObject).put("D_UP_INTERVAL", "1800000");
    ((HashMap)localObject).put("D_MAX_1F_SIZE", "102400");
    ((HashMap)localObject).put("D_NUM_UP", "1");
    ((HashMap)localObject).put("D_MAX_BUF_WF", "25600");
    ((HashMap)localObject).put("D_MAX_FOLDER_SIZE", "104857600");
    ((HashMap)localObject).put("D_MAX_SIZE_UP_1DAY", "10485760");
    ((HashMap)localObject).put("D_MAX_DAY_RENAME", "3");
    ((HashMap)localObject).put("D_MAX_DAY_DELETE", "30");
    ((HashMap)localObject).put("D_UP_NET", "w");
    ((HashMap)localObject).put("D_POS_COLL", "false");
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public final void a()
  {
    int n = 0;
    ct localct = this.c;
    Location localLocation = this.e;
    int m = 0;
    if (m < 2) {
      if (new Object[] { localct, localLocation }[m] == null)
      {
        m = n;
        label42:
        if ((m != 0) && (!j.a(this.g))) {
          break label69;
        }
      }
    }
    label69:
    long l1;
    do
    {
      do
      {
        return;
        m += 1;
        break;
        m = 1;
        break label42;
      } while ((this.c.d) && (j.b(this.b) == 3));
      l1 = System.currentTimeMillis();
    } while (l1 - this.i >= this.k);
    this.j = l1;
    this.f = a(this.f, this.e);
    this.c.a(this.e, null, this.g);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    int m = 0;
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.c != null)
        {
          if (paramString2 != null) {
            if (paramString2.length() != 0) {
              break label491;
            }
          }
        }
        else {
          return;
        }
      }
      label491:
      do
      {
        try
        {
          if ("D_CH_ID".equals(paramString1)) {
            cv.a(paramString2);
          }
          for (;;)
          {
            return;
            paramString1 = finally;
            throw paramString1;
            if (!"D_FC_SRC".equals(paramString1)) {
              break;
            }
            cv.b(paramString2);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cq.a("TxCoreDC", "set data[" + paramString1 + "," + paramString2 + "] error.", localThrowable);
            continue;
            if ("D_POS_COLL".equals(paramString1))
            {
              Boolean.parseBoolean(paramString2.toLowerCase());
            }
            else
            {
              ct localct = this.c;
              if ("D_UP_NET".equals(paramString1))
              {
                if ("m".equals(paramString2.toLowerCase()))
                {
                  localct.d = true;
                }
                else if ("w".equals(paramString2.toLowerCase()))
                {
                  localct.d = false;
                  localct.e = false;
                }
                else if ("w_m1".equals(paramString2.toLowerCase()))
                {
                  localct.d = false;
                  localct.e = true;
                }
              }
              else if ("D_UP_INTERVAL".equals(paramString1)) {
                localct.g = Math.max(900000L, Long.parseLong(paramString2));
              } else if ("D_MAX_1F_SIZE".equals(paramString1)) {
                localct.f = ct.a(Long.parseLong(paramString2), 20480L, 512000L);
              } else if ("D_NUM_UP".equals(paramString1)) {
                localct.h = ((int)ct.a(Long.parseLong(paramString2), 1L, 5L));
              } else if ("D_MAX_BUF_WF".equals(paramString1)) {
                localct.i = ((int)ct.a(Long.parseLong(paramString2), 5120L, 51200L));
              } else if ("D_MAX_FOLDER_SIZE".equals(paramString1)) {
                localct.j = ct.a(Long.parseLong(paramString2), 10240L, 209715200L);
              } else if ("D_MAX_SIZE_UP_1DAY".equals(paramString1)) {
                localct.k = Math.max(Long.parseLong(paramString2), 0L);
              } else if ("D_MAX_DAY_RENAME".equals(paramString1)) {
                localct.l = (ct.a(Long.parseLong(paramString2), 1L, 5L) * 24L * 60L * 60L * 1000L);
              } else if ("D_MAX_DAY_DELETE".equals(paramString1)) {
                localct.m = (ct.a(Long.parseLong(paramString2), 1L, 30L) * 24L * 60L * 60L * 1000L);
              }
            }
          }
        }
        m = 1;
      } while (m == 0);
    }
  }
  
  public final void a(List<ScanResult> paramList)
  {
    synchronized (this.a)
    {
      if (!b()) {
        return;
      }
      if ((this.c == null) || (this.e == null) || (j.a(paramList))) {
        break label244;
      }
      if (paramList.size() == 1)
      {
        if (!"123456789abc".equals(((ScanResult)paramList.get(0)).BSSID.toLowerCase())) {
          break label174;
        }
        return;
      }
    }
    if (paramList.size() > 1)
    {
      if (paramList == null) {
        break label254;
      }
      if (paramList.size() <= 1) {
        break label254;
      }
    }
    for (;;)
    {
      Object localObject;
      if (m != 0)
      {
        return;
        localObject = ((ScanResult)paramList.get(0)).BSSID;
        m = 1;
      }
      for (;;)
      {
        if (m >= paramList.size()) {
          break label266;
        }
        if (!((String)localObject).equals(((ScanResult)paramList.get(m)).BSSID))
        {
          m = 0;
          break;
          label174:
          long l1 = System.currentTimeMillis();
          if ((this.c.d) && (l1 - this.l < 5000L)) {
            return;
          }
          this.l = l1;
          if (l1 - this.i < this.k) {}
          for (localObject = this.g;; localObject = null)
          {
            this.c.a(this.e, paramList, (List)localObject);
            label244:
            return;
          }
          label254:
          m = 1;
          break;
        }
        m += 1;
      }
      label266:
      int m = 1;
    }
  }
  
  public final boolean b()
  {
    if (this.c == null) {
      return false;
    }
    return this.c.a();
  }
  
  public final void c()
  {
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = 0L;
    this.l = 0L;
    this.j = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     c.t.m.g.cn
 * JD-Core Version:    0.7.0.1
 */