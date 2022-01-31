package a.j.b.a.c.j.a;

import a.f.a.b;
import a.j.b.a.c.b.aa;
import a.j.b.a.c.b.e;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class w$e
  extends a.f.b.k
  implements b<Integer, e>
{
  w$e(w paramw, a.aa paramaa)
  {
    super(1);
  }
  
  public final e VV(int paramInt)
  {
    AppMethodBeat.i(122319);
    Object localObject = r.a(this.Czx.CyY.BOc, paramInt);
    List localList = a.k.i.d(a.k.i.d(a.k.i.a(this.Czy, (b)new w.e.b(this)), (b)w.e.c.CzB));
    paramInt = a.k.i.e(a.k.i.a(localObject, (b)w.e.a.Czz));
    while (localList.size() < paramInt) {
      localList.add(Integer.valueOf(0));
    }
    localObject = this.Czx.CyY.CiZ.BUa.a((a)localObject, localList);
    AppMethodBeat.o(122319);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.j.a.w.e
 * JD-Core Version:    0.7.0.1
 */