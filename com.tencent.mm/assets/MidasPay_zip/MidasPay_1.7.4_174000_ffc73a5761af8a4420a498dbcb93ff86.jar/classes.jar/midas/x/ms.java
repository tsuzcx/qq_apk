package midas.x;

public class ms
{
  public static long a = 600000L;
  public static long b = 86400000L;
  private static mh.i c;
  private static long d;
  
  public static void a()
  {
    b(0L);
  }
  
  public static void a(mh.i parami)
  {
    c = parami;
  }
  
  public static void a(mj parammj, my parammy)
  {
    long l1 = System.currentTimeMillis();
    if (a(l1))
    {
      if (c == null)
      {
        mn.c("IPUpdater", "update() sUpdater is null! Ignored");
        return;
      }
      b(l1);
      final long l2 = parammj.b.longValue();
      parammj.b = Long.valueOf(l1);
      c.a(parammj, new my()
      {
        public void a(int paramAnonymousInt, Object paramAnonymousObject)
        {
          if (paramAnonymousInt != 0) {
            this.a.b = Long.valueOf(l2);
          }
          this.c.a(paramAnonymousInt, paramAnonymousObject);
        }
      });
      return;
    }
    mn.c("IPUpdater", "update() frequency is too high! Ignored");
  }
  
  private static boolean a(long paramLong)
  {
    long l1 = b();
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
      mn.a("IPUpdater", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public static boolean a(mj parammj)
  {
    if (parammj == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = parammj.b.longValue();
    long l3 = l1 - l2;
    parammj = new StringBuilder();
    parammj.append("isOverdue() time: ");
    parammj.append(l1);
    parammj.append("-");
    parammj.append(l2);
    parammj.append("=");
    parammj.append(l3);
    parammj.append(">");
    parammj.append(b);
    parammj.append(" : ");
    boolean bool;
    if (l3 > b) {
      bool = true;
    } else {
      bool = false;
    }
    parammj.append(bool);
    mn.b("IPUpdater", parammj.toString());
    if (l3 >= 0L) {
      return l3 > b;
    }
    return true;
  }
  
  private static long b()
  {
    if (d <= 0L) {
      d = mu.b("lastUpdateTime", 0L);
    }
    return d;
  }
  
  private static void b(long paramLong)
  {
    d = paramLong;
    mu.a("lastUpdateTime", d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ms
 * JD-Core Version:    0.7.0.1
 */