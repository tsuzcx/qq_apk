package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.g;
import android.support.v4.e.l.a;
import android.support.v4.e.l.b;

final class bg
{
  final a<RecyclerView.w, a> ayf = new a();
  final g<RecyclerView.w> ayg = new g();
  
  final boolean E(RecyclerView.w paramw)
  {
    paramw = (a)this.ayf.get(paramw);
    return (paramw != null) && ((paramw.flags & 0x1) != 0);
  }
  
  final boolean F(RecyclerView.w paramw)
  {
    paramw = (a)this.ayf.get(paramw);
    return (paramw != null) && ((paramw.flags & 0x4) != 0);
  }
  
  final void G(RecyclerView.w paramw)
  {
    a locala2 = (a)this.ayf.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mS();
      this.ayf.put(paramw, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void H(RecyclerView.w paramw)
  {
    paramw = (a)this.ayf.get(paramw);
    if (paramw == null) {
      return;
    }
    paramw.flags &= 0xFFFFFFFE;
  }
  
  final void I(RecyclerView.w paramw)
  {
    int i = this.ayg.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramw == this.ayg.valueAt(i)) {
          this.ayg.removeAt(i);
        }
      }
      else
      {
        paramw = (a)this.ayf.remove(paramw);
        if (paramw != null) {
          a.a(paramw);
        }
        return;
      }
      i -= 1;
    }
  }
  
  final void a(long paramLong, RecyclerView.w paramw)
  {
    this.ayg.put(paramLong, paramw);
  }
  
  final void a(b paramb)
  {
    int i = this.ayf.size() - 1;
    if (i >= 0)
    {
      RecyclerView.w localw = (RecyclerView.w)this.ayf.keyAt(i);
      a locala = (a)this.ayf.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.j(localw);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.ayh == null) {
            paramb.j(localw);
          } else {
            paramb.a(localw, locala.ayh, locala.ayi);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localw, locala.ayh, locala.ayi);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localw, locala.ayh, locala.ayi);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localw, locala.ayh, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localw, locala.ayh, locala.ayi);
        }
      }
    }
  }
  
  final void b(RecyclerView.w paramw, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.ayf.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mS();
      this.ayf.put(paramw, locala1);
    }
    locala1.ayh = paramc;
    locala1.flags |= 0x4;
  }
  
  final void c(RecyclerView.w paramw, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.ayf.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mS();
      this.ayf.put(paramw, locala1);
    }
    locala1.flags |= 0x2;
    locala1.ayh = paramc;
  }
  
  final void clear()
  {
    this.ayf.clear();
    this.ayg.clear();
  }
  
  final RecyclerView.f.c d(RecyclerView.w paramw, int paramInt)
  {
    Object localObject2 = null;
    int i = this.ayf.indexOfKey(paramw);
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
        locala = (a)this.ayf.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramw = locala.ayh;; paramw = locala.ayi)
    {
      localObject1 = paramw;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.ayf.removeAt(i);
      a.a(locala);
      return paramw;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  final void d(RecyclerView.w paramw, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.ayf.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mS();
      this.ayf.put(paramw, locala1);
    }
    locala1.ayi = paramc;
    locala1.flags |= 0x8;
  }
  
  final RecyclerView.w n(long paramLong)
  {
    return (RecyclerView.w)this.ayg.get(paramLong, null);
  }
  
  static final class a
  {
    static l.a<a> ayj = new l.b(20);
    RecyclerView.f.c ayh;
    RecyclerView.f.c ayi;
    int flags;
    
    static void a(a parama)
    {
      parama.flags = 0;
      parama.ayh = null;
      parama.ayi = null;
      ayj.release(parama);
    }
    
    static a mS()
    {
      a locala2 = (a)ayj.acquire();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void mT()
    {
      while (ayj.acquire() != null) {}
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void b(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void c(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void j(RecyclerView.w paramw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.bg
 * JD-Core Version:    0.7.0.1
 */