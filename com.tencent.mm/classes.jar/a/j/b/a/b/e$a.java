package a.j.b.a.b;

import a.f.b.j;
import a.j.b.a.c.d.b.a.a;
import a.j.b.a.c.d.b.a.a.a;
import a.j.b.a.c.d.b.n.c;
import a.j.b.a.c.e.b.a.d;
import a.j.b.a.c.e.b.a.g;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "klass", "Ljava/lang/Class;", "descriptors.runtime"})
public final class e$a
{
  public static e aO(Class<?> paramClass)
  {
    int j = 1;
    AppMethodBeat.i(119032);
    j.q(paramClass, "klass");
    a.j.b.a.c.d.b.a.b localb = new a.j.b.a.c.d.b.a.b();
    Object localObject = b.BRe;
    b.a(paramClass, (n.c)localb);
    if ((localb.Ckj == null) || (localb.Cki == null))
    {
      localObject = null;
      if (localObject == null)
      {
        AppMethodBeat.o(119032);
        return null;
      }
    }
    else
    {
      localObject = localb.Cki;
      boolean bool;
      label87:
      g localg;
      label123:
      a.a locala;
      if ((localb.CjW & 0x8) != 0)
      {
        bool = true;
        localg = new g((int[])localObject, bool);
        if (localg.elW()) {
          break label198;
        }
        localb.CjU = localb.CjT;
        localb.CjT = null;
        locala = localb.Ckj;
        if (localb.CjS == null) {
          break label260;
        }
      }
      label258:
      label260:
      for (localObject = localb.CjS;; localObject = d.Cqd)
      {
        localObject = new a(locala, localg, (d)localObject, localb.CjT, localb.CjU, localb.strings, localb.CjV, localb.CjW, localb.packageName);
        break;
        bool = false;
        break label87;
        label198:
        int i = j;
        if (localb.Ckj != a.a.CjY)
        {
          i = j;
          if (localb.Ckj != a.a.CjZ) {
            if (localb.Ckj != a.a.Ckc) {
              break label255;
            }
          }
        }
        label255:
        for (i = j;; i = 0)
        {
          if ((i == 0) || (localb.CjT != null)) {
            break label258;
          }
          localObject = null;
          break;
        }
        break label123;
      }
    }
    paramClass = new e(paramClass, (a)localObject, (byte)0);
    AppMethodBeat.o(119032);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.b.e.a
 * JD-Core Version:    0.7.0.1
 */