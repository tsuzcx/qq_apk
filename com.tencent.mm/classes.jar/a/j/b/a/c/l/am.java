package a.j.b.a.c.l;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
{
  public static final boolean aq(w paramw)
  {
    AppMethodBeat.i(122645);
    j.q(paramw, "receiver$0");
    az localaz = paramw.eoL();
    paramw = localaz;
    if (!(localaz instanceof f)) {
      paramw = null;
    }
    paramw = (f)paramw;
    if (paramw != null)
    {
      boolean bool = paramw.egG();
      AppMethodBeat.o(122645);
      return bool;
    }
    AppMethodBeat.o(122645);
    return false;
  }
  
  public static final f ar(w paramw)
  {
    AppMethodBeat.i(122646);
    j.q(paramw, "receiver$0");
    az localaz = paramw.eoL();
    paramw = localaz;
    if (!(localaz instanceof f)) {
      paramw = null;
    }
    paramw = (f)paramw;
    if (paramw != null)
    {
      if (paramw.egG())
      {
        AppMethodBeat.o(122646);
        return paramw;
      }
      AppMethodBeat.o(122646);
      return null;
    }
    AppMethodBeat.o(122646);
    return null;
  }
  
  public static final w as(w paramw)
  {
    AppMethodBeat.i(122647);
    j.q(paramw, "receiver$0");
    Object localObject2 = paramw.eoL();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ak)) {
      localObject1 = null;
    }
    localObject2 = (ak)localObject1;
    localObject1 = paramw;
    if (localObject2 != null)
    {
      localObject1 = ((ak)localObject2).enS();
      if (localObject1 != null) {
        break label58;
      }
      localObject1 = paramw;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(122647);
      return localObject1;
    }
  }
  
  public static final w at(w paramw)
  {
    AppMethodBeat.i(122648);
    j.q(paramw, "receiver$0");
    Object localObject2 = paramw.eoL();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ak)) {
      localObject1 = null;
    }
    localObject2 = (ak)localObject1;
    localObject1 = paramw;
    if (localObject2 != null)
    {
      localObject1 = ((ak)localObject2).enT();
      if (localObject1 != null) {
        break label58;
      }
      localObject1 = paramw;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(122648);
      return localObject1;
    }
  }
  
  public static final boolean b(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122649);
    j.q(paramw1, "first");
    j.q(paramw2, "second");
    az localaz = paramw1.eoL();
    Object localObject = localaz;
    if (!(localaz instanceof ak)) {
      localObject = null;
    }
    localObject = (ak)localObject;
    if (localObject != null)
    {
      bool = ((ak)localObject).ad(paramw2);
      if (!bool)
      {
        localObject = paramw2.eoL();
        paramw2 = (w)localObject;
        if (!(localObject instanceof ak)) {
          paramw2 = null;
        }
        paramw2 = (ak)paramw2;
        if (paramw2 == null) {
          break label106;
        }
      }
    }
    label106:
    for (boolean bool = paramw2.ad(paramw1);; bool = false)
    {
      if (!bool) {
        break label111;
      }
      AppMethodBeat.o(122649);
      return true;
      bool = false;
      break;
    }
    label111:
    AppMethodBeat.o(122649);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.l.am
 * JD-Core Version:    0.7.0.1
 */