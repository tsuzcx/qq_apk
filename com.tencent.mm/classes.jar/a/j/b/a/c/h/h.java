package a.j.b.a.c.h;

import a.a.e;
import a.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public enum h
{
  public static final Set<h> Cui;
  public static final Set<h> Cuj;
  public static final a Cuk;
  private final boolean Cuh;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(121848);
    Object localObject1 = new h("VISIBILITY", 0, true);
    CtW = (h)localObject1;
    Object localObject2 = new h("MODALITY", 1, true);
    CtX = (h)localObject2;
    h localh1 = new h("OVERRIDE", 2, true);
    CtY = localh1;
    h localh2 = new h("ANNOTATIONS", 3, false);
    CtZ = localh2;
    h localh3 = new h("INNER", 4, true);
    Cua = localh3;
    h localh4 = new h("MEMBER_KIND", 5, true);
    Cub = localh4;
    h localh5 = new h("DATA", 6, true);
    Cuc = localh5;
    h localh6 = new h("INLINE", 7, true);
    Cud = localh6;
    h localh7 = new h("EXPECT", 8, true);
    Cue = localh7;
    h localh8 = new h("ACTUAL", 9, true);
    Cuf = localh8;
    Cug = new h[] { localObject1, localObject2, localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8 };
    Cuk = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    while (i < j)
    {
      localh1 = localObject1[i];
      if (localh1.Cuh) {
        ((Collection)localObject2).add(localh1);
      }
      i += 1;
    }
    Cui = j.o((Iterable)localObject2);
    Cuj = e.S(values());
    AppMethodBeat.o(121848);
  }
  
  private h(boolean paramBoolean)
  {
    this.Cuh = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.h.h
 * JD-Core Version:    0.7.0.1
 */