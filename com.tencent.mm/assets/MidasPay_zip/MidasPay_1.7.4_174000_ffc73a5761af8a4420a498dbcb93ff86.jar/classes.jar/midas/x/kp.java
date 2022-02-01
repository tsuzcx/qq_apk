package midas.x;

import java.util.ArrayList;
import java.util.Iterator;

class kp
  implements kk
{
  private final ky a;
  private final kx b;
  
  kp(kx paramkx, ky paramky)
  {
    this.a = paramky;
    this.b = paramkx;
  }
  
  private kz a(boolean paramBoolean)
  {
    Object localObject2 = new kz();
    ((kz)localObject2).a(this.a);
    if (this.b == null) {
      return localObject2;
    }
    if (paramBoolean) {
      localObject1 = this.b.b();
    } else {
      localObject1 = this.b.a();
    }
    if (localObject1 == null) {
      return localObject2;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    Object localObject1 = localObject2;
    do
    {
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = ((kv)localIterator.next()).a(this.a, (kz)localObject1);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (!((kz)localObject2).d);
    ((kz)localObject2).h();
    return localObject2;
  }
  
  public kz a()
  {
    return a(true);
  }
  
  public void a(kl paramkl)
  {
    if (this.b == null) {
      return;
    }
    kn localkn = this.b.d();
    if (localkn == null) {
      return;
    }
    localkn.a(new a(paramkl, false));
  }
  
  public void b(kl paramkl)
  {
    if (this.b == null) {
      return;
    }
    kn localkn = this.b.d();
    if (localkn == null) {
      return;
    }
    localkn.a(new a(paramkl, true));
  }
  
  class a
    implements ko
  {
    private final kl b;
    private final boolean c;
    
    a(kl paramkl, boolean paramBoolean)
    {
      this.b = paramkl;
      this.c = paramBoolean;
    }
    
    public void a()
    {
      if (kp.a(kp.this) != null) {
        kp.a(kp.this).w();
      }
    }
    
    public String b()
    {
      String str = "";
      if (kp.a(kp.this) != null) {
        str = kp.a(kp.this).getClass().getSimpleName();
      }
      return str;
    }
    
    public void run()
    {
      String str = Thread.currentThread().getName();
      try
      {
        Object localObject1 = Thread.currentThread();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b());
        localStringBuilder.append("-");
        localStringBuilder.append(Thread.currentThread().getId());
        ((Thread)localObject1).setName(localStringBuilder.toString());
        if (kp.b(kp.this) != null) {
          kp.b(kp.this).a(this);
        }
        localObject1 = kp.a(kp.this, this.c);
        if (kp.a(kp.this) != null)
        {
          if (kp.a(kp.this).x()) {
            ((kz)localObject1).e = true;
          }
          if (kp.a(kp.this).m != null) {
            kp.a(kp.this).m.a((kz)localObject1, this.b);
          } else if ((kp.b(kp.this) != null) && (kp.b(kp.this).e() != null)) {
            kp.b(kp.this).e().a((kz)localObject1, this.b);
          }
        }
        return;
      }
      finally
      {
        Thread.currentThread().setName(str);
        if (kp.b(kp.this) != null) {
          kp.b(kp.this).b(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kp
 * JD-Core Version:    0.7.0.1
 */