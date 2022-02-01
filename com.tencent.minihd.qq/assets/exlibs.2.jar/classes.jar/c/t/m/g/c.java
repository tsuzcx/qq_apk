package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  public static final int[] a = { 80, 8080, 14000 };
  public long b;
  private Map c;
  
  public c() {}
  
  public c(ah paramah)
  {
    this.b = paramah.b;
    this.c = new HashMap();
    Iterator localIterator = paramah.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (aw.a(localInteger))
      {
        Object localObject = (ArrayList)paramah.a.get(localInteger);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          r localr = new r();
          if (localr.a(str)) {
            localArrayList.add(localr);
          }
        }
        this.c.put(localInteger, localArrayList);
      }
    }
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "access_cm";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "access_uni";
      }
    } while (paramInt != 3);
    return "access_ct";
  }
  
  public final void a()
  {
    SharedPreferences localSharedPreferences = o.a().getSharedPreferences("Access_Preferences", 0);
    this.b = localSharedPreferences.getLong("timeStamp", 0L);
    this.c = new HashMap();
    int i = 1;
    while (i <= 3)
    {
      Object localObject2 = localSharedPreferences.getString(a(i), "");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "";
        if (i != 1) {
          break label180;
        }
        localObject1 = "183.61.38.168:14000,117.135.171.182:14000,183.61.38.168:80,117.135.171.182:80,183.61.38.168:8080,117.135.171.182:8080";
      }
      for (;;)
      {
        ax.b("SdkAccessInfo", "getDefaultIpListByOpType:" + (String)localObject1);
        localObject1 = ((String)localObject1).split(",");
        if (localObject1.length <= 0) {
          break label220;
        }
        localObject2 = new ArrayList();
        int k = localObject1.length;
        int j = 0;
        while (j < k)
        {
          String str = localObject1[j];
          r localr = new r();
          if (localr.a(str)) {
            ((ArrayList)localObject2).add(localr);
          }
          j += 1;
        }
        label180:
        if (i == 2) {
          localObject1 = "112.90.140.213:14000,112.90.140.216:14000,112.90.140.213:80,112.90.140.216:80,112.90.140.213:8080,112.90.140.216:8080";
        } else if (i == 3) {
          localObject1 = "14.17.41.159:14000,140.206.160.242:14000,14.17.41.159:80,140.206.160.242:80,14.17.41.159:8080,140.206.160.242:8080";
        }
      }
      this.c.put(Integer.valueOf(i), localObject2);
      label220:
      i += 1;
    }
  }
  
  public final void b()
  {
    SharedPreferences localSharedPreferences = o.a().getSharedPreferences("Access_Preferences", 0);
    if ((this.c != null) && (this.c.size() > 0))
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        if (aw.a((Integer)localObject))
        {
          String str = a(((Integer)localObject).intValue());
          if (((ArrayList)this.c.get(localObject)).size() > 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((ArrayList)this.c.get(localObject)).iterator();
            while (((Iterator)localObject).hasNext())
            {
              localStringBuilder.append(((r)((Iterator)localObject).next()).a());
              localStringBuilder.append(",");
            }
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
            localSharedPreferences.edit().putString(str, localStringBuilder.toString()).commit();
          }
        }
      }
      localSharedPreferences.edit().putLong("timesStamp", this.b).commit();
    }
  }
  
  public final ArrayList c()
  {
    int k = 0;
    int i = aw.d();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject;
    if (aw.a(Integer.valueOf(i)))
    {
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        ArrayList localArrayList2 = (ArrayList)this.c.get(localObject);
        if (i == ((Integer)localObject).intValue()) {
          localArrayList1.addAll(0, localArrayList2);
        } else {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    Iterator localIterator = this.c.keySet().iterator();
    int j;
    for (i = 0;; i = Math.max(i, ((ArrayList)this.c.get(localObject)).size()))
    {
      j = k;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Integer)localIterator.next();
    }
    for (;;)
    {
      j += 1;
      if (j >= i) {
        break;
      }
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        localObject = (ArrayList)this.c.get(localObject);
        if (j < ((ArrayList)localObject).size()) {
          localArrayList1.add(((ArrayList)localObject).get(j));
        }
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.c
 * JD-Core Version:    0.7.0.1
 */