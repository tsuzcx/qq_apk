package a.j.b.a.c.a.a;

import a.a.j;
import a.j.b.a.c.b.t;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d
  extends a.j.b.a.c.i.e.e
{
  public d(i parami, b paramb)
  {
    super(parami, (a.j.b.a.c.b.e)paramb);
    AppMethodBeat.i(119157);
    AppMethodBeat.o(119157);
  }
  
  public final List<t> ecV()
  {
    AppMethodBeat.i(119156);
    Object localObject = this.CxO;
    if (localObject == null)
    {
      localObject = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
      AppMethodBeat.o(119156);
      throw ((Throwable)localObject);
    }
    localObject = ((b)localObject).BUB;
    switch (e.bLo[localObject.ordinal()])
    {
    default: 
      localObject = (List)a.a.v.BMx;
      AppMethodBeat.o(119156);
      return localObject;
    case 1: 
      localObject = f.BUN;
      localObject = j.listOf(f.a.a((b)this.CxO, false));
      AppMethodBeat.o(119156);
      return localObject;
    }
    localObject = f.BUN;
    localObject = j.listOf(f.a.a((b)this.CxO, true));
    AppMethodBeat.o(119156);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */