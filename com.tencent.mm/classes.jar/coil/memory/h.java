package coil.memory;

import coil.size.Size;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/ImmutableHardwareBitmapService;", "Lcoil/memory/HardwareBitmapService;", "allowHardware", "", "(Z)V", "size", "Lcoil/size/Size;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h
  extends g
{
  private final boolean col;
  
  public h(boolean paramBoolean)
  {
    super((byte)0);
    this.col = paramBoolean;
  }
  
  public final boolean a(Size paramSize, k paramk)
  {
    AppMethodBeat.i(188276);
    s.u(paramSize, "size");
    boolean bool = this.col;
    AppMethodBeat.o(188276);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.h
 * JD-Core Version:    0.7.0.1
 */