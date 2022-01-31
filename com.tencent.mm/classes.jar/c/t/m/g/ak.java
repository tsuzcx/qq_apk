package c.t.m.g;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class ak
  extends ai
{
  private static boolean q = false;
  public int o = -1;
  public String p;
  private boolean r = false;
  private ao s;
  private an t;
  private aj u;
  private boolean v;
  private n w;
  private String x;
  private String y;
  
  public ak(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, boolean paramBoolean, String paramString3)
  {
    ah.a();
    this.b = paramString1;
    this.c = false;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramInt;
    this.g = paramString2;
    this.v = paramBoolean;
    this.x = paramString3;
  }
  
  public static ak a(String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    return new ak(paramString1, paramMap, paramArrayOfByte, paramInt, paramString2, false, "");
  }
  
  public final an a()
  {
    if (!q) {
      q = true;
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
        System.setProperty("http.keepAlive", "false");
      }
      label32:
      this.t = new an(0, "");
      for (;;)
      {
        Object localObject4;
        long l2;
        try
        {
          Object localObject1 = new URL(this.b);
          String str1 = ((URL)localObject1).getHost();
          this.u = new aj((URL)localObject1, this.b);
          boolean bool = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
          List localList = this.u.a(this.v, bool);
          int n = localList.size();
          long l1 = SystemClock.elapsedRealtime();
          i = this.f;
          int j = 0;
          if (j >= n) {
            break;
          }
          this.n.incrementAndGet();
          this.w = ((n)localList.get(j));
          if (this.w.e < 3) {
            this.r = true;
          }
          localObject4 = this.u;
          localObject1 = this.w;
          if (((n)localObject1).a())
          {
            localObject3 = ((aj)localObject4).b;
            this.y = ((String)localObject3);
            this.s = new ao(str1, this.y, this.c, this.d, this.e, i, this.g);
            if (j != 0) {
              this.s.z = true;
            }
            if ((x.i()) && (j != 0)) {
              this.s.x = true;
            }
            this.s.y = this.n.get();
            this.t = this.s.a();
            if (((this.s.i) || (this.t.c >= 500)) && (x.h()) && (this.r)) {
              ah.a(str1, this.w, this.t.a);
            }
            int m = (int)(this.f - (SystemClock.elapsedRealtime() - l1));
            if (((this.t.a != 0) || (this.t.c < 200) || (this.t.c >= 400)) && (this.t.a != -20) && (this.t.a != -300) && (this.t.a != -306) && (j != n - 1) && (m > 200)) {
              break label817;
            }
            i = 1;
            k = i;
            if (i == 0)
            {
              k = i;
              if (this.t.a == -4)
              {
                k = x.a.a("direct_nonet_retry_gap", 0, 10000, 3000);
                l2 = this.s.w;
                if (l2 < k) {
                  break label822;
                }
                k = 1;
              }
            }
            if (k != 0) {
              break;
            }
            a(true);
            j += 1;
            i = m;
            continue;
          }
          if (((aj)localObject4).a.getProtocol().startsWith("https")) {
            break label707;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.t.a = -300;
          return this.t;
        }
        Object localObject3 = "http://" + localMalformedURLException.a + ":" + localMalformedURLException.b;
        label599:
        String str2 = ((aj)localObject4).a.getFile();
        Object localObject2 = localObject3;
        if (!TextUtils.isEmpty(str2)) {
          if (!str2.startsWith("/")) {
            break label786;
          }
        }
        label786:
        for (localObject2 = (String)localObject3 + str2;; localObject2 = (String)localObject3 + "/" + str2)
        {
          localObject4 = ((aj)localObject4).a.getRef();
          localObject3 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            break;
          }
          localObject3 = (String)localObject2 + "#" + (String)localObject4;
          break;
          label707:
          if (((aj)localObject4).c != 0)
          {
            localObject3 = "https://" + ((n)localObject2).a + ":" + ((aj)localObject4).c;
            break label599;
          }
          localObject3 = "https://" + ((n)localObject2).a + ":443";
          break label599;
        }
        label817:
        int i = 0;
        continue;
        label822:
        SystemClock.sleep(cm.a((int)(k - l2), 200, k, 200));
        int k = i;
      }
      return this.t;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 1;
    HashMap localHashMap2;
    Object localObject;
    label406:
    HashMap localHashMap3;
    if (this.s != null)
    {
      if (this.i) {
        this.s.i = true;
      }
      localHashMap2 = new HashMap();
      if (paramBoolean) {
        break label1036;
      }
      localHashMap2.put("B22", this.k);
      if (!cm.a(this.p)) {
        localHashMap2.put("B15", this.p);
      }
      if (!cm.a(this.x)) {
        localHashMap2.put("B54", this.x);
      }
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("B82", this.g);
      if (this.l != 0L) {
        localHashMap1.put("B83", this.l);
      }
      localHashMap1.put("B44", this.a);
      if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals(this.y))) {
        localHashMap1.put("B49", this.y);
      }
      if (this.w != null)
      {
        if (!this.w.a())
        {
          localObject = this.w;
          localHashMap1.put("B10", ((n)localObject).a + ":" + ((n)localObject).b);
        }
        if (this.w.c != -1) {
          localHashMap1.put("B45", this.w.c);
        }
        localHashMap1.put("B202", this.w.e);
        localHashMap1.put("B204", this.w.d);
        localObject = new StringBuilder();
        if (!this.r) {
          break label1053;
        }
        localHashMap1.put("B203", i);
      }
      localHashMap1.put("B53", this.n.get());
      if (!TextUtils.isEmpty(this.u.d)) {
        localHashMap1.put("B26", this.u.d);
      }
      if (this.j) {
        localHashMap1.put("B97", "1");
      }
      if (this.o != -1) {
        localHashMap1.put("B211", this.o);
      }
      localObject = this.s;
      localHashMap3 = new HashMap();
      localHashMap3.putAll(localHashMap2);
      localHashMap3.put("B59", ((ao)localObject).w);
      if (((ao)localObject).p) {
        localHashMap3.put("B85", "1");
      }
      if (!((ao)localObject).c) {
        break label1058;
      }
      localHashMap3.put("B95", "1");
      label637:
      if (!((ao)localObject).q) {
        localHashMap3.put("B23", "1");
      }
      localHashMap2 = new HashMap();
      localHashMap2.putAll(localHashMap1);
      if (((ao)localObject).m != 0L) {
        localHashMap2.put("B84", ((ao)localObject).m);
      }
      localHashMap2.put("B87", ((ao)localObject).r);
      localHashMap2.put("B88", ((ao)localObject).s);
      localHashMap2.put("B90", ((ao)localObject).v.g);
      localHashMap2.put("B91", ((ao)localObject).v.h);
      localHashMap2.put("B92", ((ao)localObject).v.i);
      localHashMap2.put("B93", ((ao)localObject).v.j);
      localHashMap2.put("B94", ((ao)localObject).v.k);
      if (!TextUtils.isEmpty(((ao)localObject).h)) {
        localHashMap2.put("B47", ((ao)localObject).h);
      }
      if (!TextUtils.isEmpty(((ao)localObject).u)) {
        localHashMap2.put("B41", ((ao)localObject).u);
      }
      if (((ao)localObject).o.a == 0) {
        break label1090;
      }
      i = ((ao)localObject).o.a;
    }
    for (;;)
    {
      if ((((ao)localObject).z) && (i != -4)) {
        break label1121;
      }
      ck.b("HLHttpDirect", m.b(), i, ((ao)localObject).o.b, localHashMap3, localHashMap2, ((ao)localObject).i);
      return;
      label1036:
      localHashMap2.put("B46", "1");
      break;
      label1053:
      i = 0;
      break label406;
      label1058:
      localHashMap3.put("B96", ((ao)localObject).t);
      break label637;
      label1090:
      if (((ao)localObject).o.c == 200) {
        i = 0;
      } else {
        i = ((ao)localObject).o.c;
      }
    }
    label1121:
    ck.a("HLHttpDirect", m.b(), i, ((ao)localObject).o.b, localHashMap3, localHashMap2, ((ao)localObject).i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.ak
 * JD-Core Version:    0.7.0.1
 */