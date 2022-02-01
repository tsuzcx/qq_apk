package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Anchor;", "", "loc", "", "(I)V", "location", "getLocation$runtime_release", "()I", "setLocation$runtime_release", "valid", "", "getValid", "()Z", "toIndexFor", "slots", "Landroidx/compose/runtime/SlotTable;", "writer", "Landroidx/compose/runtime/SlotWriter;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  int location;
  
  public c(int paramInt)
  {
    this.location = paramInt;
  }
  
  public final int a(be parambe)
  {
    AppMethodBeat.i(202338);
    s.u(parambe, "slots");
    s.u(this, "anchor");
    if (!parambe.apK) {}
    for (int i = 1; i == 0; i = 0)
    {
      j.ah("Use active SlotWriter to determine anchor location instead".toString());
      parambe = new f();
      AppMethodBeat.o(202338);
      throw parambe;
    }
    if (!nS())
    {
      parambe = (Throwable)new IllegalArgumentException("Anchor refers to a group that was removed".toString());
      AppMethodBeat.o(202338);
      throw parambe;
    }
    i = this.location;
    AppMethodBeat.o(202338);
    return i;
  }
  
  public final int a(bg parambg)
  {
    AppMethodBeat.i(202349);
    s.u(parambg, "writer");
    int i = parambg.b(this);
    AppMethodBeat.o(202349);
    return i;
  }
  
  public final boolean nS()
  {
    return this.location != -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.c
 * JD-Core Version:    0.7.0.1
 */