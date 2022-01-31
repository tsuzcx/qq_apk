package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.f;

final class bg
{
  final a<RecyclerView.v, bg.a> apJ = new a();
  final f<RecyclerView.v> apK = new f();
  
  final boolean H(RecyclerView.v paramv)
  {
    paramv = (bg.a)this.apJ.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x1) != 0);
  }
  
  final boolean I(RecyclerView.v paramv)
  {
    paramv = (bg.a)this.apJ.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x4) != 0);
  }
  
  final void J(RecyclerView.v paramv)
  {
    bg.a locala2 = (bg.a)this.apJ.get(paramv);
    bg.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = bg.a.lb();
      this.apJ.put(paramv, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void K(RecyclerView.v paramv)
  {
    paramv = (bg.a)this.apJ.get(paramv);
    if (paramv == null) {
      return;
    }
    paramv.flags &= 0xFFFFFFFE;
  }
  
  final void L(RecyclerView.v paramv)
  {
    int i = this.apK.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv == this.apK.valueAt(i)) {
          this.apK.removeAt(i);
        }
      }
      else
      {
        paramv = (bg.a)this.apJ.remove(paramv);
        if (paramv != null) {
          bg.a.a(paramv);
        }
        return;
      }
      i -= 1;
    }
  }
  
  final void a(long paramLong, RecyclerView.v paramv)
  {
    this.apK.put(paramLong, paramv);
  }
  
  final void a(bg.b paramb)
  {
    int i = this.apJ.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.apJ.keyAt(i);
      bg.a locala = (bg.a)this.apJ.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.j(localv);
      }
      for (;;)
      {
        bg.a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.apL == null) {
            paramb.j(localv);
          } else {
            paramb.a(localv, locala.apL, locala.apM);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localv, locala.apL, locala.apM);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localv, locala.apL, locala.apM);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localv, locala.apL, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localv, locala.apL, locala.apM);
        }
      }
    }
  }
  
  final void b(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    bg.a locala2 = (bg.a)this.apJ.get(paramv);
    bg.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = bg.a.lb();
      this.apJ.put(paramv, locala1);
    }
    locala1.apL = paramc;
    locala1.flags |= 0x4;
  }
  
  final void c(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    bg.a locala2 = (bg.a)this.apJ.get(paramv);
    bg.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = bg.a.lb();
      this.apJ.put(paramv, locala1);
    }
    locala1.flags |= 0x2;
    locala1.apL = paramc;
  }
  
  final void clear()
  {
    this.apJ.clear();
    this.apK.clear();
  }
  
  final RecyclerView.f.c d(RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    int i = this.apJ.indexOfKey(paramv);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    bg.a locala;
    do
    {
      do
      {
        return localObject1;
        locala = (bg.a)this.apJ.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramv = locala.apL;; paramv = locala.apM)
    {
      localObject1 = paramv;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.apJ.removeAt(i);
      bg.a.a(locala);
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
    bg.a locala2 = (bg.a)this.apJ.get(paramv);
    bg.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = bg.a.lb();
      this.apJ.put(paramv, locala1);
    }
    locala1.apM = paramc;
    locala1.flags |= 0x8;
  }
  
  final RecyclerView.v k(long paramLong)
  {
    return (RecyclerView.v)this.apK.get(paramLong, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.bg
 * JD-Core Version:    0.7.0.1
 */