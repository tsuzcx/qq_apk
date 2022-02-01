package midas.x;

import java.util.ArrayList;
import java.util.Iterator;

public class va
  implements qa
{
  public final fb a;
  public final eb b;
  
  public va(eb parameb, fb paramfb)
  {
    this.a = paramfb;
    this.b = parameb;
  }
  
  public gb a()
  {
    return a(true);
  }
  
  public final gb a(boolean paramBoolean)
  {
    Object localObject2 = new gb();
    ((gb)localObject2).a(this.a);
    Object localObject1 = this.b;
    if (localObject1 == null) {
      return localObject2;
    }
    if (paramBoolean) {
      localObject1 = ((eb)localObject1).d();
    } else {
      localObject1 = ((eb)localObject1).c();
    }
    if (localObject1 == null) {
      return localObject2;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    localObject1 = localObject2;
    do
    {
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = ((cb)localIterator.next()).a(this.a, (gb)localObject1);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (!((gb)localObject2).e);
    ((gb)localObject2).h();
    return localObject2;
  }
  
  public void a(ra paramra)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((eb)localObject).b();
    if (localObject == null) {
      return;
    }
    ((ta)localObject).a(new a(paramra, false));
  }
  
  public void b(ra paramra)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((eb)localObject).b();
    if (localObject == null) {
      return;
    }
    ((ta)localObject).a(new a(paramra, true));
  }
  
  public class a
    implements ua
  {
    public final ra a;
    public final boolean b;
    
    public a(ra paramra, boolean paramBoolean)
    {
      this.a = paramra;
      this.b = paramBoolean;
    }
    
    public String b()
    {
      if (va.a(va.this) != null) {
        return va.a(va.this).getClass().getSimpleName();
      }
      return "";
    }
    
    public void cancel()
    {
      if (va.a(va.this) != null) {
        va.a(va.this).s();
      }
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
        if (va.b(va.this) != null) {
          va.b(va.this).a(this);
        }
        localObject1 = va.a(va.this, this.b);
        if (va.a(va.this) != null)
        {
          if (va.a(va.this).p()) {
            ((gb)localObject1).f = true;
          }
          if (va.a(va.this).l != null) {
            va.a(va.this).l.a((gb)localObject1, this.a);
          } else if ((va.b(va.this) != null) && (va.b(va.this).a() != null)) {
            va.b(va.this).a().a((gb)localObject1, this.a);
          }
        }
        return;
      }
      finally
      {
        Thread.currentThread().setName(str);
        if (va.b(va.this) != null) {
          va.b(va.this).b(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.va
 * JD-Core Version:    0.7.0.1
 */