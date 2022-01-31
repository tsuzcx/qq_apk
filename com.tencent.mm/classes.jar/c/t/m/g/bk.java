package c.t.m.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class bk
{
  private static bk b = new bk();
  public Map<String, String> a = new bl();
  
  private bk()
  {
    a(cj.b("HalleyOperInfo_" + m.b(), ""), false);
  }
  
  public static bk a()
  {
    return b;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "cm";
    }
    do
    {
      return str;
      if (paramInt == 3) {
        return "ct";
      }
    } while (paramInt != 2);
    return "uni";
  }
  
  public final String a(String paramString)
  {
    if ((cm.a(paramString)) || ("unknown".equals(paramString))) {
      return "";
    }
    synchronized (this.a)
    {
      paramString = (String)this.a.get(paramString);
      if (!cm.a(paramString)) {
        return paramString;
      }
    }
    return "";
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    label136:
    for (;;)
    {
      try
      {
        if (!cm.a(paramString)) {}
        synchronized (this.a)
        {
          this.a.clear();
          String[] arrayOfString = paramString.split("h;l");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            if (i < j)
            {
              Object localObject2 = arrayOfString[i].split("h,l");
              if (localObject2.length != 2) {
                break label136;
              }
              Object localObject1 = localObject2[0];
              localObject2 = localObject2[1];
              this.a.put(localObject1, localObject2);
              break label136;
            }
          }
          if (paramBoolean) {
            cj.a("HalleyOperInfo_" + m.b(), paramString);
          }
          return;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        return;
      }
    }
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.a)
    {
      ArrayList localArrayList1 = new ArrayList(this.a.keySet());
      ArrayList localArrayList2 = new ArrayList(this.a.values());
      int i = 0;
      while (i < localArrayList1.size())
      {
        String str1 = (String)localArrayList1.get(i);
        String str2 = (String)localArrayList2.get(i);
        localStringBuilder.append(str1).append("h,l").append(str2).append("h;l");
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.bk
 * JD-Core Version:    0.7.0.1
 */