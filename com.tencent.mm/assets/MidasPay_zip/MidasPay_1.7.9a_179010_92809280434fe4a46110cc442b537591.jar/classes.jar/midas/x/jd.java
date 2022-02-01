package midas.x;

public class jd
{
  public static long a = 600000L;
  public static long b = 86400000L;
  public static yc c;
  public static long d;
  
  public static long a()
  {
    if (d <= 0L) {
      d = ld.a("lastUpdateTime", 0L);
    }
    return d;
  }
  
  public static void a(ad paramad, pd parampd)
  {
    long l1 = System.currentTimeMillis();
    if (a(l1))
    {
      if (c == null)
      {
        ed.c("IPUpdater", "update() sUpdater is null! Ignored");
        return;
      }
      b(l1);
      final long l2 = paramad.b.longValue();
      paramad.b = Long.valueOf(l1);
      c.a(paramad, new a(paramad, l2, parampd));
      return;
    }
    ed.c("IPUpdater", "update() frequency is too high! Ignored");
  }
  
  public static void a(yc paramyc)
  {
    c = paramyc;
  }
  
  public static boolean a(long paramLong)
  {
    long l1 = a();
    long l2 = paramLong - l1;
    boolean bool = true;
    if (l2 >= 0L)
    {
      if (l2 > a) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCanUpdate() time: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("-");
      localStringBuilder.append(l1);
      localStringBuilder.append("=");
      localStringBuilder.append(l2);
      localStringBuilder.append(">");
      localStringBuilder.append(a);
      localStringBuilder.append(" : ");
      if (l2 <= a) {
        bool = false;
      }
      localStringBuilder.append(bool);
      ed.b("IPUpdater", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public static boolean a(ad paramad)
  {
    if (paramad == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramad.b.longValue();
    long l3 = l1 - l2;
    paramad = new StringBuilder();
    paramad.append("isOverdue() time: ");
    paramad.append(l1);
    paramad.append("-");
    paramad.append(l2);
    paramad.append("=");
    paramad.append(l3);
    paramad.append(">");
    paramad.append(b);
    paramad.append(" : ");
    boolean bool;
    if (l3 > b) {
      bool = true;
    } else {
      bool = false;
    }
    paramad.append(bool);
    ed.a("IPUpdater", paramad.toString());
    if (l3 >= 0L) {
      return l3 > b;
    }
    return true;
  }
  
  public static void b()
  {
    b(0L);
  }
  
  public static void b(long paramLong)
  {
    d = paramLong;
    ld.b("lastUpdateTime", d);
  }
  
  public static final class a
    implements pd
  {
    public a(ad paramad, long paramLong, pd parampd) {}
    
    public void a(int paramInt, Object paramObject)
    {
      if (paramInt != 0) {
        this.a.b = Long.valueOf(l2);
      }
      this.c.a(paramInt, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.jd
 * JD-Core Version:    0.7.0.1
 */