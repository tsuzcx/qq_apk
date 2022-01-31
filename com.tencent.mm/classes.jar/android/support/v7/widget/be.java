package android.support.v7.widget;

import android.support.v4.f.a;
import android.support.v4.f.f;

final class be
{
  final a<RecyclerView.v, be.a> ans = new a();
  final f<RecyclerView.v> ant = new f();
  
  final boolean C(RecyclerView.v paramv)
  {
    paramv = (be.a)this.ans.get(paramv);
    return (paramv != null) && ((paramv.flags & 0x1) != 0);
  }
  
  final void D(RecyclerView.v paramv)
  {
    be.a locala2 = (be.a)this.ans.get(paramv);
    be.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = be.a.jg();
      this.ans.put(paramv, locala1);
    }
    locala1.flags |= 0x1;
  }
  
  final void E(RecyclerView.v paramv)
  {
    paramv = (be.a)this.ans.get(paramv);
    if (paramv == null) {
      return;
    }
    paramv.flags &= 0xFFFFFFFE;
  }
  
  final void F(RecyclerView.v paramv)
  {
    int i = this.ant.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv != this.ant.valueAt(i)) {
          break label78;
        }
        f localf = this.ant;
        if (localf.Eh[i] != f.Ee)
        {
          localf.Eh[i] = f.Ee;
          localf.Ef = true;
        }
      }
      paramv = (be.a)this.ans.remove(paramv);
      if (paramv != null) {
        be.a.a(paramv);
      }
      return;
      label78:
      i -= 1;
    }
  }
  
  final void a(long paramLong, RecyclerView.v paramv)
  {
    this.ant.put(paramLong, paramv);
  }
  
  final void a(be.b paramb)
  {
    int i = this.ans.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.ans.keyAt(i);
      be.a locala = (be.a)this.ans.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.j(localv);
      }
      for (;;)
      {
        be.a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.anu == null) {
            paramb.j(localv);
          } else {
            paramb.a(localv, locala.anu, locala.anv);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localv, locala.anu, locala.anv);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localv, locala.anu, locala.anv);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localv, locala.anu, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localv, locala.anu, locala.anv);
        } else {
          int j = locala.flags;
        }
      }
    }
  }
  
  final void b(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    be.a locala2 = (be.a)this.ans.get(paramv);
    be.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = be.a.jg();
      this.ans.put(paramv, locala1);
    }
    locala1.anu = paramc;
    locala1.flags |= 0x4;
  }
  
  final void c(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    be.a locala2 = (be.a)this.ans.get(paramv);
    be.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = be.a.jg();
      this.ans.put(paramv, locala1);
    }
    locala1.anv = paramc;
    locala1.flags |= 0x8;
  }
  
  final void clear()
  {
    this.ans.clear();
    this.ant.clear();
  }
  
  final RecyclerView.f.c d(RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    int i = this.ans.indexOfKey(paramv);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    be.a locala;
    do
    {
      do
      {
        return localObject1;
        locala = (be.a)this.ans.valueAt(i);
        localObject1 = localObject2;
      } while (locala == null);
      localObject1 = localObject2;
    } while ((locala.flags & paramInt) == 0);
    locala.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramv = locala.anu;; paramv = locala.anv)
    {
      localObject1 = paramv;
      if ((locala.flags & 0xC) != 0) {
        break;
      }
      this.ans.removeAt(i);
      be.a.a(locala);
      return paramv;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.be
 * JD-Core Version:    0.7.0.1
 */