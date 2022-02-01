package c.t.m.g;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bq
{
  LinkedList<a> a = new LinkedList();
  boolean b;
  
  public final b a(by paramby)
  {
    a locala;
    Object localObject2;
    Object localObject1;
    bz localbz;
    Object localObject3;
    int i;
    boolean bool2;
    label94:
    boolean bool1;
    if (this.b)
    {
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        localObject2 = locala.a;
        if (paramby != null)
        {
          localObject1 = ((by)localObject2).a;
          localbz = paramby.a;
          localObject2 = ((by)localObject2).b;
          localObject3 = paramby.b;
          if ((localObject2 == null) || (localObject3 == null))
          {
            i = 1;
            if (i != 0) {
              break label295;
            }
            bool2 = true;
            if (!bool2) {
              break label378;
            }
            if ((localObject1 != null) && (localbz != null)) {
              break label301;
            }
            bool1 = false;
          }
        }
      }
    }
    for (;;)
    {
      label111:
      if (cj.a)
      {
        localObject1 = new StringBuilder("Hybrid Info: similar=");
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append("wifi=").append(bool1).append(", ");
        ((StringBuilder)localObject1).append("cell=").append(bool2);
        ((StringBuilder)localObject1).append("]");
        cj.a("TencentHybridInfo", ((StringBuilder)localObject1).toString());
        cj.a("TencentHybridInfo", "=========================================");
      }
      if ((bool2) && (bool1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label374;
        }
        return locala.b;
        if ((((bw)localObject2).e != ((bw)localObject3).e) || (((bw)localObject2).b != ((bw)localObject3).b) || (((bw)localObject2).c != ((bw)localObject3).c) || (((bw)localObject2).g != ((bw)localObject3).g) || (Math.abs(((bw)localObject2).i - ((bw)localObject3).i) > 20000L))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label295:
        bool2 = false;
        break label94;
        label301:
        localObject2 = ((bz)localObject1).a;
        localObject3 = localbz.a;
        if ((localObject2 == null) || (localObject3 == null))
        {
          bool1 = false;
          break label111;
        }
        if ((Math.abs(((bz)localObject1).b - localbz.b) <= 40000L) && (!b.a.a((List)localObject2, (List)localObject3)))
        {
          bool1 = true;
          break label111;
        }
        bool1 = false;
        break label111;
      }
      label374:
      break;
      return null;
      label378:
      bool1 = false;
    }
  }
  
  static final class a
  {
    by a;
    b b;
    
    a(by paramby, b paramb)
    {
      this.a = paramby;
      this.b = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bq
 * JD-Core Version:    0.7.0.1
 */