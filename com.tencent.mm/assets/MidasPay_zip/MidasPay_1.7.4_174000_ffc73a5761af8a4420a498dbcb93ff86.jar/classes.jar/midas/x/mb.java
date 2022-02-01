package midas.x;

import java.util.ArrayList;
import java.util.Iterator;

class mb
  implements kk
{
  private final ky a;
  private md b;
  private boolean c = false;
  private boolean d = false;
  
  mb(ky paramky, md parammd)
  {
    this.a = paramky;
    this.b = parammd;
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
    kn localkn = this.b.c();
    if (localkn == null) {
      return;
    }
    localkn.a(new a(paramkl, false));
    this.c = true;
  }
  
  public void b(kl paramkl)
  {
    if (this.b == null) {
      return;
    }
    kn localkn = this.b.c();
    if (localkn == null) {
      return;
    }
    localkn.a(new a(paramkl, true));
    this.c = true;
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
      if (mb.a(mb.this) != null) {
        mb.a(mb.this).w();
      }
      mb.a(mb.this, true);
    }
    
    public String b()
    {
      String str = "";
      if (mb.a(mb.this) != null) {
        str = mb.a(mb.this).getClass().getSimpleName();
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
        if (mb.b(mb.this) != null) {
          mb.b(mb.this).a(this);
        }
        localObject1 = mb.b(mb.this, this.c);
        if (mb.a(mb.this) != null)
        {
          if (mb.a(mb.this).x()) {
            ((kz)localObject1).e = true;
          }
          if (mb.a(mb.this).m != null) {
            mb.a(mb.this).m.a((kz)localObject1, this.b);
          } else if ((mb.b(mb.this) != null) && (mb.b(mb.this).d() != null)) {
            mb.b(mb.this).d().a((kz)localObject1, this.b);
          }
        }
        return;
      }
      finally
      {
        Thread.currentThread().setName(str);
        if (mb.b(mb.this) != null) {
          mb.b(mb.this).b(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mb
 * JD-Core Version:    0.7.0.1
 */