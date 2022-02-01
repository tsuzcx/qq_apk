package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.g;
import android.support.v4.e.l.a;
import android.support.v4.e.l.b;

final class bg
{
  final a<RecyclerView.v, a> azU = new a();
  final g<RecyclerView.v> azV = new g();
  
  final boolean G(RecyclerView.v paramv)
  {
    paramv = (a)this.azU.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x1) != 0);
  }
  
  final boolean H(RecyclerView.v paramv)
  {
    paramv = (a)this.azU.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x4) != 0);
  }
  
  final void I(RecyclerView.v paramv)
  {
    a locala2 = (a)this.azU.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nm();
      this.azU.put(paramv, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void J(RecyclerView.v paramv)
  {
    paramv = (a)this.azU.get(paramv);
    if (paramv == null) {
      return;
    }
    paramv.flags &= 0xFFFFFFFE;
  }
  
  final void K(RecyclerView.v paramv)
  {
    int i = this.azV.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv == this.azV.valueAt(i)) {
          this.azV.removeAt(i);
        }
      }
      else
      {
        paramv = (a)this.azU.remove(paramv);
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
    this.azV.put(paramLong, paramv);
  }
  
  final void a(b paramb)
  {
    int i = this.azU.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.azU.keyAt(i);
      a locala = (a)this.azU.removeAt(i);
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
          if (locala.azW == null) {
            paramb.j(localv);
          } else {
            paramb.a(localv, locala.azW, locala.azX);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localv, locala.azW, locala.azX);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localv, locala.azW, locala.azX);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localv, locala.azW, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localv, locala.azW, locala.azX);
        }
      }
    }
  }
  
  final void b(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.azU.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nm();
      this.azU.put(paramv, locala1);
    }
    locala1.azW = paramc;
    locala1.flags |= 0x4;
  }
  
  final void c(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.azU.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nm();
      this.azU.put(paramv, locala1);
    }
    locala1.flags |= 0x2;
    locala1.azW = paramc;
  }
  
  final void clear()
  {
    this.azU.clear();
    this.azV.clear();
  }
  
  final RecyclerView.f.c d(RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    int i = this.azU.indexOfKey(paramv);
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
        locala = (a)this.azU.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramv = locala.azW;; paramv = locala.azX)
    {
      localObject1 = paramv;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.azU.removeAt(i);
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
    a locala2 = (a)this.azU.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nm();
      this.azU.put(paramv, locala1);
    }
    locala1.azX = paramc;
    locala1.flags |= 0x8;
  }
  
  final RecyclerView.v n(long paramLong)
  {
    return (RecyclerView.v)this.azV.get(paramLong, null);
  }
  
  static final class a
  {
    static l.a<a> azY = new l.b(20);
    RecyclerView.f.c azW;
    RecyclerView.f.c azX;
    int flags;
    
    static void a(a parama)
    {
      parama.flags = 0;
      parama.azW = null;
      parama.azX = null;
      azY.release(parama);
    }
    
    static a nm()
    {
      a locala2 = (a)azY.acquire();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void nn()
    {
      while (azY.acquire() != null) {}
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