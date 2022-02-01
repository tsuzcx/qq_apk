package androidx.recyclerview.widget;

import androidx.b.a;
import androidx.b.d;
import androidx.core.f.f.a;
import androidx.core.f.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab
{
  final d<RecyclerView.v> anA;
  final a<RecyclerView.v, a> anz;
  
  ab()
  {
    AppMethodBeat.i(263013);
    this.anz = new a();
    this.anA = new d();
    AppMethodBeat.o(263013);
  }
  
  final boolean J(RecyclerView.v paramv)
  {
    AppMethodBeat.i(263016);
    paramv = (a)this.anz.get(paramv);
    if ((paramv != null) && ((paramv.flags & 0x1) != 0))
    {
      AppMethodBeat.o(263016);
      return true;
    }
    AppMethodBeat.o(263016);
    return false;
  }
  
  final boolean K(RecyclerView.v paramv)
  {
    AppMethodBeat.i(263020);
    paramv = (a)this.anz.get(paramv);
    if ((paramv != null) && ((paramv.flags & 0x4) != 0))
    {
      AppMethodBeat.o(263020);
      return true;
    }
    AppMethodBeat.o(263020);
    return false;
  }
  
  final void L(RecyclerView.v paramv)
  {
    AppMethodBeat.i(263025);
    a locala2 = (a)this.anz.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mQ();
      this.anz.put(paramv, locala1);
    }
    locala1.flags |= 0x1;
    AppMethodBeat.o(263025);
  }
  
  final void M(RecyclerView.v paramv)
  {
    AppMethodBeat.i(263028);
    paramv = (a)this.anz.get(paramv);
    if (paramv == null)
    {
      AppMethodBeat.o(263028);
      return;
    }
    paramv.flags &= 0xFFFFFFFE;
    AppMethodBeat.o(263028);
  }
  
  final void N(RecyclerView.v paramv)
  {
    AppMethodBeat.i(263032);
    int i = this.anA.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv == this.anA.aM(i)) {
          this.anA.aK(i);
        }
      }
      else
      {
        paramv = (a)this.anz.remove(paramv);
        if (paramv != null) {
          a.a(paramv);
        }
        AppMethodBeat.o(263032);
        return;
      }
      i -= 1;
    }
  }
  
  final void a(long paramLong, RecyclerView.v paramv)
  {
    AppMethodBeat.i(263018);
    this.anA.a(paramLong, paramv);
    AppMethodBeat.o(263018);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(263030);
    int i = this.anz.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.anz.aO(i);
      a locala = (a)this.anz.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.l(localv);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.anB == null) {
            paramb.l(localv);
          } else {
            paramb.a(localv, locala.anB, locala.anC);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localv, locala.anB, locala.anC);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localv, locala.anB, locala.anC);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localv, locala.anB, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localv, locala.anB, locala.anC);
        }
      }
    }
    AppMethodBeat.o(263030);
  }
  
  final void b(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(263015);
    a locala2 = (a)this.anz.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mQ();
      this.anz.put(paramv, locala1);
    }
    locala1.anB = paramc;
    locala1.flags |= 0x4;
    AppMethodBeat.o(263015);
  }
  
  final void c(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(263019);
    a locala2 = (a)this.anz.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mQ();
      this.anz.put(paramv, locala1);
    }
    locala1.flags |= 0x2;
    locala1.anB = paramc;
    AppMethodBeat.o(263019);
  }
  
  final void clear()
  {
    AppMethodBeat.i(263014);
    this.anz.clear();
    this.anA.clear();
    AppMethodBeat.o(263014);
  }
  
  final void d(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(263023);
    a locala2 = (a)this.anz.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.mQ();
      this.anz.put(paramv, locala1);
    }
    locala1.anC = paramc;
    locala1.flags |= 0x8;
    AppMethodBeat.o(263023);
  }
  
  final RecyclerView.f.c f(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(263017);
    int i = this.anz.q(paramv);
    if (i < 0)
    {
      AppMethodBeat.o(263017);
      return null;
    }
    a locala = (a)this.anz.aM(i);
    if ((locala != null) && ((locala.flags & paramInt) != 0))
    {
      locala.flags &= (paramInt ^ 0xFFFFFFFF);
      if (paramInt == 4) {}
      for (paramv = locala.anB;; paramv = locala.anC)
      {
        if ((locala.flags & 0xC) == 0)
        {
          this.anz.removeAt(i);
          a.a(locala);
        }
        AppMethodBeat.o(263017);
        return paramv;
        if (paramInt != 8) {
          break;
        }
      }
      paramv = new IllegalArgumentException("Must provide flag PRE or POST");
      AppMethodBeat.o(263017);
      throw paramv;
    }
    AppMethodBeat.o(263017);
    return null;
  }
  
  final RecyclerView.v o(long paramLong)
  {
    AppMethodBeat.i(263021);
    RecyclerView.v localv = (RecyclerView.v)this.anA.get(paramLong, null);
    AppMethodBeat.o(263021);
    return localv;
  }
  
  static final class a
  {
    static f.a<a> anD;
    RecyclerView.f.c anB;
    RecyclerView.f.c anC;
    int flags;
    
    static
    {
      AppMethodBeat.i(263012);
      anD = new f.b(20);
      AppMethodBeat.o(263012);
    }
    
    static void a(a parama)
    {
      AppMethodBeat.i(263010);
      parama.flags = 0;
      parama.anB = null;
      parama.anC = null;
      anD.release(parama);
      AppMethodBeat.o(263010);
    }
    
    static a mQ()
    {
      AppMethodBeat.i(263009);
      a locala = (a)anD.acquire();
      if (locala == null)
      {
        locala = new a();
        AppMethodBeat.o(263009);
        return locala;
      }
      AppMethodBeat.o(263009);
      return locala;
    }
    
    static void mR()
    {
      AppMethodBeat.i(263011);
      while (anD.acquire() != null) {}
      AppMethodBeat.o(263011);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void b(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void c(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void l(RecyclerView.v paramv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.recyclerview.widget.ab
 * JD-Core Version:    0.7.0.1
 */