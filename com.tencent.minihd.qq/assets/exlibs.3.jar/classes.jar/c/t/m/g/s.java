package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class s
{
  String a;
  Map b;
  
  public s(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final void a(a parama)
  {
    this.b.put(parama.a, parama);
  }
  
  public static final class a
  {
    String a;
    public String b;
    public List c;
    long d;
    
    public a(String paramString1, long paramLong, String paramString2)
    {
      this.a = paramString1;
      this.d = paramLong;
      this.b = paramString2;
      this.c = new ArrayList();
    }
    
    public a(String paramString1, long paramLong, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.d = paramLong;
      this.b = paramString3;
      this.c = a(paramString2);
    }
    
    private static ArrayList a(String paramString)
    {
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(",");
        if ((paramString != null) && (paramString.length > 0))
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            String[] arrayOfString = paramString[i].split(":");
            if ((arrayOfString != null) && (arrayOfString.length > 0)) {
              localArrayList.add(new r(arrayOfString[0], Integer.parseInt(arrayOfString[1])));
            }
            i += 1;
          }
        }
      }
      return localArrayList;
    }
    
    public final String a()
    {
      Object localObject = this.c;
      if (((List)localObject).size() == 0) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((r)((Iterator)localObject).next()).a());
        localStringBuilder.append(",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return localStringBuilder.toString();
    }
    
    public final boolean b()
    {
      return System.currentTimeMillis() - this.d > b.a.b().b.e * 60 * 1000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.s
 * JD-Core Version:    0.7.0.1
 */