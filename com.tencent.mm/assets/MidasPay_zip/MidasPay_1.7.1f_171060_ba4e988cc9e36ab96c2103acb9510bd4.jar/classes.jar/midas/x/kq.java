package midas.x;

import java.util.ArrayList;
import java.util.Iterator;

class kq
  implements iz
{
  private final jn a;
  private ks b;
  private boolean c = false;
  private boolean d = false;
  
  kq(jn paramjn, ks paramks)
  {
    this.a = paramjn;
    this.b = paramks;
  }
  
  private jo a(boolean paramBoolean)
  {
    Object localObject2 = new jo();
    ((jo)localObject2).a(this.a);
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
        localObject2 = ((jk)localIterator.next()).a(this.a, (jo)localObject1);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (!((jo)localObject2).d);
    ((jo)localObject2).h();
    return localObject2;
  }
  
  public jo a()
  {
    return a(true);
  }
  
  public void a(ja paramja)
  {
    if (this.b == null) {
      return;
    }
    jc localjc = this.b.c();
    if (localjc == null) {
      return;
    }
    localjc.a(new a(paramja, false));
    this.c = true;
  }
  
  public void b(ja paramja)
  {
    if (this.b == null) {
      return;
    }
    jc localjc = this.b.c();
    if (localjc == null) {
      return;
    }
    localjc.a(new a(paramja, true));
    this.c = true;
  }
  
  class a
    implements jd
  {
    private final ja b;
    private final boolean c;
    
    a(ja paramja, boolean paramBoolean)
    {
      this.b = paramja;
      this.c = paramBoolean;
    }
    
    public void a()
    {
      if (kq.a(kq.this) != null) {
        kq.a(kq.this).w();
      }
      kq.a(kq.this, true);
    }
    
    public String b()
    {
      String str = "";
      if (kq.a(kq.this) != null) {
        str = kq.a(kq.this).getClass().getSimpleName();
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
        if (kq.b(kq.this) != null) {
          kq.b(kq.this).a(this);
        }
        localObject1 = kq.b(kq.this, this.c);
        if (kq.a(kq.this) != null)
        {
          if (kq.a(kq.this).x()) {
            ((jo)localObject1).e = true;
          }
          if (kq.a(kq.this).m != null) {
            kq.a(kq.this).m.a((jo)localObject1, this.b);
          } else if ((kq.b(kq.this) != null) && (kq.b(kq.this).d() != null)) {
            kq.b(kq.this).d().a((jo)localObject1, this.b);
          }
        }
        return;
      }
      finally
      {
        Thread.currentThread().setName(str);
        if (kq.b(kq.this) != null) {
          kq.b(kq.this).b(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.kq
 * JD-Core Version:    0.7.0.1
 */