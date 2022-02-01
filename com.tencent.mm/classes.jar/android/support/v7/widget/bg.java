package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.g;
import android.support.v4.e.l.a;
import android.support.v4.e.l.b;

final class bg
{
  final a<RecyclerView.w, a> azW = new a();
  final g<RecyclerView.w> azX = new g();
  
  final boolean E(RecyclerView.w paramw)
  {
    paramw = (a)this.azW.get(paramw);
    return (paramw != null) && ((paramw.flags & 0x1) != 0);
  }
  
  final boolean F(RecyclerView.w paramw)
  {
    paramw = (a)this.azW.get(paramw);
    return (paramw != null) && ((paramw.flags & 0x4) != 0);
  }
  
  final void G(RecyclerView.w paramw)
  {
    a locala2 = (a)this.azW.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nk();
      this.azW.put(paramw, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void H(RecyclerView.w paramw)
  {
    paramw = (a)this.azW.get(paramw);
    if (paramw == null) {
      return;
    }
    paramw.flags &= 0xFFFFFFFE;
  }
  
  final void I(RecyclerView.w paramw)
  {
    int i = this.azX.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramw == this.azX.valueAt(i)) {
          this.azX.removeAt(i);
        }
      }
      else
      {
        paramw = (a)this.azW.remove(paramw);
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
    this.azX.put(paramLong, paramw);
  }
  
  final void a(b paramb)
  {
    int i = this.azW.size() - 1;
    if (i >= 0)
    {
      RecyclerView.w localw = (RecyclerView.w)this.azW.keyAt(i);
      a locala = (a)this.azW.removeAt(i);
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
          if (locala.azY == null) {
            paramb.j(localw);
          } else {
            paramb.a(localw, locala.azY, locala.azZ);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localw, locala.azY, locala.azZ);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localw, locala.azY, locala.azZ);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localw, locala.azY, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localw, locala.azY, locala.azZ);
        }
      }
    }
  }
  
  final void b(RecyclerView.w paramw, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.azW.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nk();
      this.azW.put(paramw, locala1);
    }
    locala1.azY = paramc;
    locala1.flags |= 0x4;
  }
  
  final void c(RecyclerView.w paramw, RecyclerView.f.c paramc)
  {
    a locala2 = (a)this.azW.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nk();
      this.azW.put(paramw, locala1);
    }
    locala1.flags |= 0x2;
    locala1.azY = paramc;
  }
  
  final void clear()
  {
    this.azW.clear();
    this.azX.clear();
  }
  
  final RecyclerView.f.c d(RecyclerView.w paramw, int paramInt)
  {
    Object localObject2 = null;
    int i = this.azW.indexOfKey(paramw);
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
        locala = (a)this.azW.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramw = locala.azY;; paramw = locala.azZ)
    {
      localObject1 = paramw;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.azW.removeAt(i);
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
    a locala2 = (a)this.azW.get(paramw);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.nk();
      this.azW.put(paramw, locala1);
    }
    locala1.azZ = paramc;
    locala1.flags |= 0x8;
  }
  
  final RecyclerView.w n(long paramLong)
  {
    return (RecyclerView.w)this.azX.get(paramLong, null);
  }
  
  static final class a
  {
    static l.a<a> aAa = new l.b(20);
    RecyclerView.f.c azY;
    RecyclerView.f.c azZ;
    int flags;
    
    static void a(a parama)
    {
      parama.flags = 0;
      parama.azY = null;
      parama.azZ = null;
      aAa.release(parama);
    }
    
    static a nk()
    {
      a locala2 = (a)aAa.acquire();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      return locala1;
    }
    
    static void nl()
    {
      while (aAa.acquire() != null) {}
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