package midas.x;

public class lh
{
  public static long a = 600000L;
  public static long b = 86400000L;
  private static kw.i c;
  private static long d;
  
  public static void a()
  {
    b(0L);
  }
  
  public static void a(kw.i parami)
  {
    c = parami;
  }
  
  public static void a(ky paramky, ln paramln)
  {
    long l1 = System.currentTimeMillis();
    if (a(l1))
    {
      if (c != null)
      {
        b(l1);
        final long l2 = paramky.b.longValue();
        paramky.b = Long.valueOf(l1);
        c.a(paramky, new ln()
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
      throw new IllegalArgumentException("Must set IPHandler.Updater first");
    }
    lc.c("IPUpdater", "update() frequency is too high! Ignored");
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
      lc.a("IPUpdater", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public static boolean a(ky paramky)
  {
    if (paramky == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramky.b.longValue();
    long l3 = l1 - l2;
    paramky = new StringBuilder();
    paramky.append("isOverdue() time: ");
    paramky.append(l1);
    paramky.append("-");
    paramky.append(l2);
    paramky.append("=");
    paramky.append(l3);
    paramky.append(">");
    paramky.append(b);
    paramky.append(" : ");
    boolean bool;
    if (l3 > b) {
      bool = true;
    } else {
      bool = false;
    }
    paramky.append(bool);
    lc.b("IPUpdater", paramky.toString());
    if (l3 >= 0L) {
      return l3 > b;
    }
    return true;
  }
  
  private static long b()
  {
    if (d <= 0L) {
      d = lj.b("lastUpdateTime", 0L);
    }
    return d;
  }
  
  private static void b(long paramLong)
  {
    d = paramLong;
    lj.a("lastUpdateTime", d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lh
 * JD-Core Version:    0.7.0.1
 */