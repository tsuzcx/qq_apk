package midas.x;

import java.util.ArrayList;
import java.util.Iterator;

class je
  implements iz
{
  private final jn a;
  private final jm b;
  
  je(jm paramjm, jn paramjn)
  {
    this.a = paramjn;
    this.b = paramjm;
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
    jc localjc = this.b.d();
    if (localjc == null) {
      return;
    }
    localjc.a(new a(paramja, false));
  }
  
  public void b(ja paramja)
  {
    if (this.b == null) {
      return;
    }
    jc localjc = this.b.d();
    if (localjc == null) {
      return;
    }
    localjc.a(new a(paramja, true));
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
      if (je.a(je.this) != null) {
        je.a(je.this).w();
      }
    }
    
    public String b()
    {
      String str = "";
      if (je.a(je.this) != null) {
        str = je.a(je.this).getClass().getSimpleName();
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
        if (je.b(je.this) != null) {
          je.b(je.this).a(this);
        }
        localObject1 = je.a(je.this, this.c);
        if (je.a(je.this) != null)
        {
          if (je.a(je.this).x()) {
            ((jo)localObject1).e = true;
          }
          if (je.a(je.this).m != null) {
            je.a(je.this).m.a((jo)localObject1, this.b);
          } else if ((je.b(je.this) != null) && (je.b(je.this).e() != null)) {
            je.b(je.this).e().a((jo)localObject1, this.b);
          }
        }
        return;
      }
      finally
      {
        Thread.currentThread().setName(str);
        if (je.b(je.this) != null) {
          je.b(je.this).b(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.je
 * JD-Core Version:    0.7.0.1
 */