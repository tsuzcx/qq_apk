package c.t.m.g;

import android.os.Build.VERSION;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class aj
{
  URL a;
  String b;
  int c;
  public String d;
  private boolean e;
  private boolean f;
  private int g;
  
  public aj(URL paramURL, String paramString)
  {
    if (x.a.a("direct_access_use_schedule", 0, 1, 1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.e = bool1;
      bool1 = bool2;
      if (x.a.a("direct_https_use_sche", 0, 1, 1) == 1) {
        bool1 = true;
      }
      this.f = bool1;
      this.g = x.a.a("direct_access_domain_try_times", 1, 8, 2);
      this.d = "";
      this.a = paramURL;
      this.b = paramString;
      return;
    }
  }
  
  public final List<n> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 3;
    int j = 0;
    n localn = new n(this.a.getHost());
    localn.e = 3;
    for (;;)
    {
      try
      {
        Object localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(localn);
          localn.c = 1;
          return localObject;
        }
        if ((!x.i()) && (this.e)) {
          if ((paramBoolean2) && (!this.f))
          {
            break label282;
            if (i < this.g)
            {
              ((List)localObject).add(localn);
              i += 1;
              continue;
            }
            if (x.i())
            {
              i = 2;
              localn.c = i;
              return localObject;
            }
            i = k;
            if (!this.e) {
              continue;
            }
            i = 4;
            continue;
          }
          else
          {
            if ((paramBoolean2) && (Build.VERSION.SDK_INT <= 18))
            {
              i = 0;
              if (i < this.g)
              {
                ((List)localObject).add(localn);
                i += 1;
                continue;
              }
              localn.c = 10;
              return localObject;
            }
            localObject = ah.a(this.a.getHost());
            List localList = ((v)localObject).c;
            this.c = ((v)localObject).d;
            this.d = ((v)localObject).b;
            return localList;
          }
        }
      }
      catch (Exception localException)
      {
        ArrayList localArrayList = new ArrayList();
        i = j;
        if (i < this.g)
        {
          localArrayList.add(localn);
          i += 1;
          continue;
        }
        localn.c = 8;
        return localArrayList;
      }
      label282:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.aj
 * JD-Core Version:    0.7.0.1
 */