package a.j.b.a.c.l.a;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.w;
import a.j.b.a.c.n.i;
import a.j.b.a.c.n.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;

public final class o
{
  int CCu;
  private boolean CCv;
  ArrayDeque<ad> CCw;
  Set<ad> CCx;
  final boolean CCy;
  private final boolean CCz;
  
  private o(boolean paramBoolean)
  {
    this.CCy = paramBoolean;
    this.CCz = true;
  }
  
  public static o.a a(ad paramad, e parame)
  {
    AppMethodBeat.i(122779);
    j.q(paramad, "subType");
    j.q(parame, "superType");
    paramad = o.a.CCB;
    AppMethodBeat.o(122779);
    return paramad;
  }
  
  public static Boolean b(az paramaz1, az paramaz2)
  {
    AppMethodBeat.i(122777);
    j.q(paramaz1, "subType");
    j.q(paramaz2, "superType");
    AppMethodBeat.o(122777);
    return null;
  }
  
  public static boolean c(an paraman1, an paraman2)
  {
    AppMethodBeat.i(122778);
    j.q(paraman1, "a");
    j.q(paraman2, "b");
    boolean bool = j.e(paraman1, paraman2);
    AppMethodBeat.o(122778);
    return bool;
  }
  
  final void clear()
  {
    AppMethodBeat.i(122781);
    Object localObject = this.CCw;
    if (localObject == null) {
      j.ebi();
    }
    ((ArrayDeque)localObject).clear();
    localObject = this.CCx;
    if (localObject == null) {
      j.ebi();
    }
    ((Set)localObject).clear();
    this.CCv = false;
    AppMethodBeat.o(122781);
  }
  
  public final boolean e(az paramaz)
  {
    AppMethodBeat.i(122782);
    j.q(paramaz, "receiver$0");
    if ((this.CCz) && ((paramaz.enU() instanceof k)))
    {
      AppMethodBeat.o(122782);
      return true;
    }
    AppMethodBeat.o(122782);
    return false;
  }
  
  final void initialize()
  {
    AppMethodBeat.i(122780);
    if (!this.CCv) {}
    Object localObject;
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(122780);
      throw ((Throwable)localObject);
    }
    this.CCv = true;
    if (this.CCw == null) {
      this.CCw = new ArrayDeque(4);
    }
    if (this.CCx == null)
    {
      localObject = i.CFl;
      this.CCx = ((Set)i.b.epb());
    }
    AppMethodBeat.o(122780);
  }
  
  public static abstract class c
  {
    public abstract ad aJ(w paramw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.l.a.o
 * JD-Core Version:    0.7.0.1
 */