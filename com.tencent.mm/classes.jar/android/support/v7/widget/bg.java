package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.g;
import android.support.v4.e.l.a;
import android.support.v4.e.l.b;

final class bg
{
  final a<RecyclerView.v, a> axl = new a();
  final g<RecyclerView.v> axm = new g();
  
  final boolean E(RecyclerView.v paramv)
  {
    paramv = (a)this.axl.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x1) != 0);
  }
  
  final boolean F(RecyclerView.v paramv)
  {
    paramv = (a)this.axl.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x4) != 0);
  }
  
  final void G(RecyclerView.v paramv)
  {
    a locala2 = (a)this.axl.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mI();
      this.axl.put(paramv, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void H(RecyclerView.v paramv)
  {
    paramv = (a)this.axl.get(paramv);
    if (paramv == null) {
      return;
    }
    paramv.flags &= 0xFFFFFFFE;
  }
  
  final void I(RecyclerView.v paramv)
  {
    int i = this.axm.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv == this.axm.valueAt(i)) {
          this.axm.removeAt(i);
        }
      }
      else
      {
        paramv = (a)this.axl.remove(paramv);
        if (paramv != null) {
          a.a(paramv);
        }
        return;
      }
      i -= 1;
    }
  }
  
  final void a(long paramLong, RecyclerView.v paramv)
  {
    this.axm.put(paramLong, paramv);
  }
  
  final void a(b paramb)
  {
    int i = this.axl.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.axl.keyAt(i);
      a locala = (a)this.axl.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.j(localv);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.axn == null) {
            paramb.j(localv);
          } else {
            paramb.a(localv, locala.axn, locala.axo);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localv, locala.axn, locala.axo);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localv, locala.axn, locala.axo);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localv, locala.axn, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localv, locala.axn, locala.axo);
        }
      }
    }
  }
  
  final void b(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.axl.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mI();
      this.axl.put(paramv, locala1);
    }
    locala1.axn = paramc;
    locala1.flags |= 0x4;
  }
  
  final void c(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.axl.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mI();
      this.axl.put(paramv, locala1);
    }
    locala1.flags |= 0x2;
    locala1.axn = paramc;
  }
  
  final void clear()
  {
    this.axl.clear();
    this.axm.clear();
  }
  
  final RecyclerView.f.c d(RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    int i = this.axl.indexOfKey(paramv);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    a locala;
    do
    {
      do
      {
        return localObject1;
        locala = (a)this.axl.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramv = locala.axn;; paramv = locala.axo)
    {
      localObject1 = paramv;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.axl.removeAt(i);
      a.a(locala);
      return paramv;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  final void d(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.axl.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mI();
      this.axl.put(paramv, locala1);
    }
    locala1.axo = paramc;
    locala1.flags |= 0x8;
  }
  
  final RecyclerView.v l(long paramLong)
  {
    return (RecyclerView.v)this.axm.get(paramLong, null);
  }
  
  static final class a
  {
    static l.a<a> axp = new l.b(20);
    RecyclerView.f.c axn;
    RecyclerView.f.c axo;
    int flags;
    
    static void a(a parama)
    {
      parama.flags = 0;
      parama.axn = null;
      parama.axo = null;
      axp.release(parama);
    }
    
    static a mI()
    {
      a locala2 = (a)axp.acquire();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void mJ()
    {
      while (axp.acquire() != null) {}
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void b(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void c(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void j(RecyclerView.v paramv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bg
 * JD-Core Version:    0.7.0.1
 */