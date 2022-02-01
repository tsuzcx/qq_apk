package coil.size;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/size/RealSizeResolver;", "Lcoil/size/SizeResolver;", "size", "Lcoil/size/Size;", "(Lcoil/size/Size;)V", "equals", "", "other", "", "hashCode", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements f
{
  private final Size cob;
  
  public c(Size paramSize)
  {
    AppMethodBeat.i(188183);
    this.cob = paramSize;
    AppMethodBeat.o(188183);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188204);
    if ((this == paramObject) || (((paramObject instanceof c)) && (s.p(this.cob, ((c)paramObject).cob))))
    {
      AppMethodBeat.o(188204);
      return true;
    }
    AppMethodBeat.o(188204);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188214);
    int i = this.cob.hashCode();
    AppMethodBeat.o(188214);
    return i;
  }
  
  public final Object o(d<? super Size> paramd)
  {
    return this.cob;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188224);
    String str = "RealSizeResolver(size=" + this.cob + ')';
    AppMethodBeat.o(188224);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.size.c
 * JD-Core Version:    0.7.0.1
 */