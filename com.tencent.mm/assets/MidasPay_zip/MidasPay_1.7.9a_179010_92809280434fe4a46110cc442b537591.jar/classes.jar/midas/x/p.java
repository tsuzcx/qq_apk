package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class p
{
  public static p f;
  public boolean a = false;
  public ArrayList<u> b = null;
  public ArrayList<v> c = null;
  public String d = "";
  public String e = "";
  
  public static p o()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new p();
        }
      }
      finally {}
    }
    return f;
  }
  
  public int a(int paramInt)
  {
    ArrayList localArrayList = this.b;
    Object localObject = this.c;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        v localv = (v)((Iterator)localObject).next();
        if ((localv.b().equals("AllGold")) && (paramInt >= localv.c()))
        {
          if (localv.a() == -1) {
            break label134;
          }
          if (localv.d() == 1)
          {
            i = localv.a() * paramInt / 100;
            break label136;
          }
          if (localv.d() == 2)
          {
            i = localv.a();
            break label136;
          }
        }
      }
      i = 0;
    }
    else
    {
      label134:
      i = paramInt;
    }
    label136:
    paramInt = Math.min(i, paramInt);
    if (paramInt <= 0)
    {
      paramInt = 0;
      while (paramInt < localArrayList.size())
      {
        ((u)localArrayList.get(paramInt)).a(0);
        paramInt += 1;
      }
      return 0;
    }
    int i = paramInt / 10 * 10;
    paramInt = 0;
    int j = 0;
    while (paramInt < localArrayList.size())
    {
      localObject = (u)localArrayList.get(paramInt);
      if (!((u)localObject).h())
      {
        ((u)localObject).a(0);
      }
      else if (Integer.valueOf(((u)localObject).c()).intValue() <= 0)
      {
        ((u)localObject).a(0);
      }
      else
      {
        int m = Math.min(i, Integer.valueOf(((u)localObject).c()).intValue());
        ((u)localObject).a(m);
        int k = j + m;
        m = i - m;
        j = k;
        i = m;
        if (m <= 0)
        {
          paramInt += 1;
          while (paramInt < localArrayList.size())
          {
            ((u)localArrayList.get(paramInt)).a(0);
            paramInt += 1;
          }
          return k;
        }
      }
      paramInt += 1;
    }
    return j;
  }
  
  public void a()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    localArrayList = this.c;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public void a(u paramu)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    if ("PriGold".equals(paramu.e())) {
      paramu.b(50);
    } else {
      paramu.b(10);
    }
    this.b.add(paramu);
  }
  
  public void a(v paramv)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramv);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    return (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(paramString)) || (!this.d.contains(paramString));
  }
  
  public int b(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if (localu.h()) {
        paramInt += localu.a();
      }
    }
    return paramInt;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      u localu = (u)((Iterator)localObject2).next();
      if ((localu.h()) && (localu.a() > 0))
      {
        if (((StringBuffer)localObject1).length() > 0) {
          ((StringBuffer)localObject1).append("&");
        }
        ((StringBuffer)localObject1).append(localu.b());
        ((StringBuffer)localObject1).append("=");
        ((StringBuffer)localObject1).append(String.valueOf(localu.a()));
      }
    }
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SPResRuleList=");
      ((StringBuilder)localObject2).append(URLEncoder.encode(((StringBuffer)localObject1).toString(), "UTF-8"));
      localObject1 = URLEncoder.encode(((StringBuilder)localObject2).toString(), "UTF-8");
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public String c(int paramInt)
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (v)((Iterator)localObject1).next();
        if ((((v)localObject2).b().equals("AllGold")) && (paramInt >= ((v)localObject2).c()))
        {
          int i = ((v)localObject2).c();
          if (((v)localObject2).a() == -1)
          {
            if (i <= 0) {
              return null;
            }
            localObject1 = APTools.b(i);
            localStringBuilder.append("满");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("元可用");
          }
          else if (i <= 0)
          {
            if (((v)localObject2).d() == 1)
            {
              localObject1 = String.valueOf(paramInt * ((v)localObject2).a() / 100 / 10);
            }
            else
            {
              if (((v)localObject2).d() != 2) {
                break label209;
              }
              localObject1 = String.valueOf(((v)localObject2).a() / 10);
            }
            localStringBuilder.append("当前订单最多使用");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("宝券");
            break;
            label209:
            return null;
          }
          else
          {
            if (((v)localObject2).d() == 1)
            {
              localObject1 = String.valueOf(paramInt * ((v)localObject2).a() / 100 / 10);
            }
            else
            {
              if (((v)localObject2).d() != 2) {
                break label325;
              }
              localObject1 = String.valueOf(((v)localObject2).a() / 10);
            }
            localObject2 = APTools.b(i);
            localStringBuilder.append("订单金额满");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("元");
            localStringBuilder.append("，");
            localStringBuilder.append("最多可用");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("宝券");
            break;
            label325:
            return null;
          }
        }
      }
      if (localStringBuilder.length() > 0) {
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public ArrayList<u> d()
  {
    return this.b;
  }
  
  public boolean d(int paramInt)
  {
    ArrayList localArrayList = this.b;
    Object localObject = this.c;
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        v localv = (v)((Iterator)localObject).next();
        if ((localv.b().equals("AllGold")) && (paramInt >= localv.c()))
        {
          if (localv.a() == -1) {
            break label133;
          }
          if (localv.d() == 1)
          {
            i = localv.a() * paramInt / 100;
            break label135;
          }
          if (localv.d() == 2)
          {
            i = localv.a();
            break label135;
          }
        }
      }
      i = 0;
    }
    else
    {
      label133:
      i = paramInt;
    }
    label135:
    paramInt = Math.min(i, paramInt);
    if (paramInt <= 0) {
      return true;
    }
    if (localArrayList.size() > 0) {
      return paramInt - Math.min(paramInt, Integer.valueOf(((u)localArrayList.get(0)).c()).intValue()) <= 0;
    }
    return true;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return true;
      }
      localObject = this.c;
      localObject = (v)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      boolean bool = g();
      a(false);
      int i = p4.p().e().c.b();
      a(bool);
      return i >= ((v)localObject).c();
    }
    return true;
  }
  
  public boolean g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    boolean bool1 = o.m().i();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.a)
    {
      ArrayList localArrayList = this.b;
      if (localArrayList == null) {
        return false;
      }
      bool1 = bool2;
      if (localArrayList.size() > 0)
      {
        bool1 = bool2;
        if (n()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean i()
  {
    Object localObject = this.b;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      u localu = (u)((Iterator)localObject).next();
      if (Integer.parseInt(localu.c()) > 0) {
        bool |= localu.h();
      }
    }
    return bool;
  }
  
  public boolean j()
  {
    return a(p4.p().e().f.e);
  }
  
  public void k()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).a(true);
    }
  }
  
  public void l()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((u)((Iterator)localObject).next()).a(true);
      }
    }
  }
  
  public void m()
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (localArrayList.size() >= 2)) {
      Collections.sort(this.b, new a());
    }
    localArrayList = this.c;
    if ((localArrayList != null) && (localArrayList.size() > 1)) {
      Collections.sort(this.c, new b());
    }
  }
  
  public final boolean n()
  {
    int i = p4.p().e().b.saveType;
    return (i == 0) || (i == 1);
  }
  
  public class a
    implements Comparator<u>
  {
    public a() {}
    
    public int a(u paramu1, u paramu2)
    {
      return paramu2.g() - paramu1.g();
    }
  }
  
  public class b
    implements Comparator<v>
  {
    public b() {}
    
    public int a(v paramv1, v paramv2)
    {
      return paramv2.c() - paramv1.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p
 * JD-Core Version:    0.7.0.1
 */