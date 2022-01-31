package a.j.b.a.c.h;

import a.h.b;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j$b
  extends b<T>
{
  public j$b(Object paramObject1, Object paramObject2, j paramj)
  {
    super(paramObject2);
  }
  
  public final boolean b(k<?> paramk)
  {
    AppMethodBeat.i(121855);
    a.f.b.j.q(paramk, "property");
    if (this.Cve.Cul)
    {
      paramk = (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
      AppMethodBeat.o(121855);
      throw paramk;
    }
    AppMethodBeat.o(121855);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.h.j.b
 * JD-Core Version:    0.7.0.1
 */