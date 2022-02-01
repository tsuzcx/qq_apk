package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class o
{
  private static o f;
  private boolean a = false;
  private ArrayList<t> b = null;
  private ArrayList<u> c = null;
  private String d = "";
  private String e = "";
  
  public static o a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new o();
        }
      }
      finally {}
    }
    return f;
  }
  
  private boolean p()
  {
    switch (ed.b().n().a.saveType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if (localt.f()) {
        paramInt += localt.g();
      }
    }
    return paramInt;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(t paramt)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    if ("PriGold".equals(paramt.b())) {
      paramt.b(50);
    } else {
      paramt.b(10);
    }
    this.b.add(paramt);
  }
  
  public void a(u paramu)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramu);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean b()
  {
    boolean bool1 = n.a().h();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (this.a)
    {
      if (this.b == null) {
        return false;
      }
      bool1 = bool2;
      if (this.b.size() > 0)
      {
        bool1 = bool2;
        if (p()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    ArrayList localArrayList = this.b;
    Object localObject = this.c;
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        u localu = (u)((Iterator)localObject).next();
        if ((localu.a().equals("AllGold")) && (paramInt >= localu.b()))
        {
          if (localu.d() == -1) {
            break label133;
          }
          if (localu.c() == 1)
          {
            i = localu.d() * paramInt / 100;
            break label135;
          }
          if (localu.c() == 2)
          {
            i = localu.d();
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
      return paramInt - Math.min(paramInt, Integer.valueOf(((t)localArrayList.get(0)).e()).intValue()) <= 0;
    }
    return true;
  }
  
  public int c(int paramInt)
  {
    ArrayList localArrayList = this.b;
    Object localObject = this.c;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        u localu = (u)((Iterator)localObject).next();
        if ((localu.a().equals("AllGold")) && (paramInt >= localu.b()))
        {
          if (localu.d() == -1) {
            break label134;
          }
          if (localu.c() == 1)
          {
            i = localu.d() * paramInt / 100;
            break label136;
          }
          if (localu.c() == 2)
          {
            i = localu.d();
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
        ((t)localArrayList.get(paramInt)).a(0);
        paramInt += 1;
      }
      return 0;
    }
    int i = paramInt / 10 * 10;
    paramInt = 0;
    int j = 0;
    while (paramInt < localArrayList.size())
    {
      localObject = (t)localArrayList.get(paramInt);
      if (!((t)localObject).f())
      {
        ((t)localObject).a(0);
      }
      else if (Integer.valueOf(((t)localObject).e()).intValue() <= 0)
      {
        ((t)localObject).a(0);
      }
      else
      {
        int m = Math.min(i, Integer.valueOf(((t)localObject).e()).intValue());
        ((t)localObject).a(m);
        int k = j + m;
        m = i - m;
        j = k;
        i = m;
        if (m <= 0)
        {
          paramInt += 1;
          while (paramInt < localArrayList.size())
          {
            ((t)localArrayList.get(paramInt)).a(0);
            paramInt += 1;
          }
          return k;
        }
      }
      paramInt += 1;
    }
    return j;
  }
  
  public boolean c()
  {
    if (this.c != null)
    {
      if (this.c.size() <= 0) {
        return true;
      }
      u localu = (u)this.c.get(this.c.size() - 1);
      boolean bool = e();
      a(false);
      int i = ed.b().n().b.b();
      a(bool);
      return i >= localu.b();
    }
    return true;
  }
  
  public boolean c(String paramString)
  {
    return (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(paramString)) || (!this.d.contains(paramString));
  }
  
  public String d(int paramInt)
  {
    if (this.c != null)
    {
      if (this.c.size() <= 0) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (u)((Iterator)localObject1).next();
        if ((((u)localObject2).a().equals("AllGold")) && (paramInt >= ((u)localObject2).b()))
        {
          int i = ((u)localObject2).b();
          if (((u)localObject2).d() == -1)
          {
            if (i <= 0) {
              return null;
            }
            localObject1 = APTools.a(i);
            localStringBuilder.append("满");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("元可用");
          }
          else if (i <= 0)
          {
            if (((u)localObject2).c() == 1)
            {
              localObject1 = String.valueOf(paramInt * ((u)localObject2).d() / 100 / 10);
            }
            else
            {
              if (((u)localObject2).c() != 2) {
                break label210;
              }
              localObject1 = String.valueOf(((u)localObject2).d() / 10);
            }
            localStringBuilder.append("当前订单最多使用");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("宝券");
            break;
            label210:
            return null;
          }
          else
          {
            if (((u)localObject2).c() == 1)
            {
              localObject1 = String.valueOf(paramInt * ((u)localObject2).d() / 100 / 10);
            }
            else
            {
              if (((u)localObject2).c() != 2) {
                break label326;
              }
              localObject1 = String.valueOf(((u)localObject2).d() / 10);
            }
            localObject2 = APTools.a(i);
            localStringBuilder.append("订单金额满");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("元");
            localStringBuilder.append("，");
            localStringBuilder.append("最多可用");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("宝券");
            break;
            label326:
            return null;
          }
        }
      }
      if (localStringBuilder.length() > 0) {
        return localStringBuilder.toString();
      }
      return null;
    }
    return null;
  }
  
  public boolean d()
  {
    Object localObject = this.b;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      t localt = (t)((Iterator)localObject).next();
      if (Integer.parseInt(localt.e()) > 0) {
        bool |= localt.f();
      }
    }
    return bool;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).a(true);
    }
  }
  
  public ArrayList<t> g()
  {
    return this.b;
  }
  
  public void h()
  {
    if ((this.b != null) && (this.b.size() >= 2)) {
      Collections.sort(this.b, new Comparator()
      {
        public int a(t paramAnonymoust1, t paramAnonymoust2)
        {
          return paramAnonymoust2.h() - paramAnonymoust1.h();
        }
      });
    }
    if ((this.c != null) && (this.c.size() > 1)) {
      Collections.sort(this.c, new Comparator()
      {
        public int a(u paramAnonymousu1, u paramAnonymousu2)
        {
          return paramAnonymousu2.b() - paramAnonymousu1.b();
        }
      });
    }
  }
  
  public void i()
  {
    if (this.b != null) {
      this.b.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
  }
  
  public void j()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((t)((Iterator)localObject).next()).a(true);
      }
      return;
    }
  }
  
  public String k()
  {
    String str = "";
    if (this.b == null) {
      return "";
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      if ((localt.f()) && (localt.g() > 0)) {
        if (!TextUtils.isEmpty(str)) {
          str = localt.d();
        } else {
          str = "";
        }
      }
    }
    return str;
  }
  
  public String l()
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      t localt = (t)((Iterator)localObject2).next();
      if ((localt.f()) && (localt.g() > 0))
      {
        if (((StringBuffer)localObject1).length() > 0) {
          ((StringBuffer)localObject1).append("&");
        }
        ((StringBuffer)localObject1).append(localt.c());
        ((StringBuffer)localObject1).append("=");
        ((StringBuffer)localObject1).append(String.valueOf(localt.g()));
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
  
  public String m()
  {
    return this.d;
  }
  
  public String n()
  {
    return this.e;
  }
  
  public boolean o()
  {
    return c(ed.b().n().e.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.o
 * JD-Core Version:    0.7.0.1
 */