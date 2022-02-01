package androidx.recyclerview.widget;

import androidx.b.a;
import androidx.b.d;
import androidx.core.f.e.a;
import androidx.core.f.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class z
{
  final a<RecyclerView.v, a> cbX;
  final d<RecyclerView.v> cbY;
  
  z()
  {
    AppMethodBeat.i(194916);
    this.cbX = new a();
    this.cbY = new d();
    AppMethodBeat.o(194916);
  }
  
  final boolean G(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194943);
    paramv = (a)this.cbX.get(paramv);
    if ((paramv != null) && ((paramv.flags & 0x1) != 0))
    {
      AppMethodBeat.o(194943);
      return true;
    }
    AppMethodBeat.o(194943);
    return false;
  }
  
  final boolean H(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194973);
    paramv = (a)this.cbX.get(paramv);
    if ((paramv != null) && ((paramv.flags & 0x4) != 0))
    {
      AppMethodBeat.o(194973);
      return true;
    }
    AppMethodBeat.o(194973);
    return false;
  }
  
  final void I(RecyclerView.v paramv)
  {
    AppMethodBeat.i(194995);
    a locala2 = (a)this.cbX.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.Ls();
      this.cbX.put(paramv, locala1);
    }
    locala1.flags |= 0x1;
    AppMethodBeat.o(194995);
  }
  
  final void J(RecyclerView.v paramv)
  {
    AppMethodBeat.i(195001);
    paramv = (a)this.cbX.get(paramv);
    if (paramv == null)
    {
      AppMethodBeat.o(195001);
      return;
    }
    paramv.flags &= 0xFFFFFFFE;
    AppMethodBeat.o(195001);
  }
  
  final void K(RecyclerView.v paramv)
  {
    AppMethodBeat.i(195019);
    int i = this.cbY.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramv == this.cbY.bl(i)) {
          this.cbY.bj(i);
        }
      }
      else
      {
        paramv = (a)this.cbX.remove(paramv);
        if (paramv != null) {
          a.a(paramv);
        }
        AppMethodBeat.o(195019);
        return;
      }
      i -= 1;
    }
  }
  
  final void a(long paramLong, RecyclerView.v paramv)
  {
    AppMethodBeat.i(194959);
    this.cbY.a(paramLong, paramv);
    AppMethodBeat.o(194959);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(195011);
    int i = this.cbX.size() - 1;
    if (i >= 0)
    {
      RecyclerView.v localv = (RecyclerView.v)this.cbX.bn(i);
      a locala = (a)this.cbX.removeAt(i);
      if ((locala.flags & 0x3) == 3) {
        paramb.m(localv);
      }
      for (;;)
      {
        a.a(locala);
        i -= 1;
        break;
        if ((locala.flags & 0x1) != 0)
        {
          if (locala.cbZ == null) {
            paramb.m(localv);
          } else {
            paramb.a(localv, locala.cbZ, locala.cca);
          }
        }
        else if ((locala.flags & 0xE) == 14) {
          paramb.b(localv, locala.cbZ, locala.cca);
        } else if ((locala.flags & 0xC) == 12) {
          paramb.c(localv, locala.cbZ, locala.cca);
        } else if ((locala.flags & 0x4) != 0) {
          paramb.a(localv, locala.cbZ, null);
        } else if ((locala.flags & 0x8) != 0) {
          paramb.b(localv, locala.cbZ, locala.cca);
        }
      }
    }
    AppMethodBeat.o(195011);
  }
  
  final void b(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(194933);
    a locala2 = (a)this.cbX.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.Ls();
      this.cbX.put(paramv, locala1);
    }
    locala1.cbZ = paramc;
    locala1.flags |= 0x4;
    AppMethodBeat.o(194933);
  }
  
  final RecyclerView.v bA(long paramLong)
  {
    AppMethodBeat.i(194981);
    RecyclerView.v localv = (RecyclerView.v)this.cbY.get(paramLong, null);
    AppMethodBeat.o(194981);
    return localv;
  }
  
  final void c(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(194967);
    a locala2 = (a)this.cbX.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.Ls();
      this.cbX.put(paramv, locala1);
    }
    locala1.flags |= 0x2;
    locala1.cbZ = paramc;
    AppMethodBeat.o(194967);
  }
  
  final void clear()
  {
    AppMethodBeat.i(194923);
    this.cbX.clear();
    this.cbY.clear();
    AppMethodBeat.o(194923);
  }
  
  final void d(RecyclerView.v paramv, RecyclerView.f.c paramc)
  {
    AppMethodBeat.i(194988);
    a locala2 = (a)this.cbX.get(paramv);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = a.Ls();
      this.cbX.put(paramv, locala1);
    }
    locala1.cca = paramc;
    locala1.flags |= 0x8;
    AppMethodBeat.o(194988);
  }
  
  final RecyclerView.f.c f(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(194952);
    int i = this.cbX.y(paramv);
    if (i < 0)
    {
      AppMethodBeat.o(194952);
      return null;
    }
    a locala = (a)this.cbX.bl(i);
    if ((locala != null) && ((locala.flags & paramInt) != 0))
    {
      locala.flags &= (paramInt ^ 0xFFFFFFFF);
      if (paramInt == 4) {}
      for (paramv = locala.cbZ;; paramv = locala.cca)
      {
        if ((locala.flags & 0xC) == 0)
        {
          this.cbX.removeAt(i);
          a.a(locala);
        }
        AppMethodBeat.o(194952);
        return paramv;
        if (paramInt != 8) {
          break;
        }
      }
      paramv = new IllegalArgumentException("Must provide flag PRE or POST");
      AppMethodBeat.o(194952);
      throw paramv;
    }
    AppMethodBeat.o(194952);
    return null;
  }
  
  static final class a
  {
    static e.a<a> ccb;
    RecyclerView.f.c cbZ;
    RecyclerView.f.c cca;
    int flags;
    
    static
    {
      AppMethodBeat.i(194971);
      ccb = new e.b(20);
      AppMethodBeat.o(194971);
    }
    
    static a Ls()
    {
      AppMethodBeat.i(194946);
      a locala = (a)ccb.acquire();
      if (locala == null)
      {
        locala = new a();
        AppMethodBeat.o(194946);
        return locala;
      }
      AppMethodBeat.o(194946);
      return locala;
    }
    
    static void Lt()
    {
      AppMethodBeat.i(194963);
      while (ccb.acquire() != null) {}
      AppMethodBeat.o(194963);
    }
    
    static void a(a parama)
    {
      AppMethodBeat.i(194956);
      parama.flags = 0;
      parama.cbZ = null;
      parama.cca = null;
      ccb.release(parama);
      AppMethodBeat.o(194956);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void b(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void c(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2);
    
    public abstract void m(RecyclerView.v paramv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.z
 * JD-Core Version:    0.7.0.1
 */