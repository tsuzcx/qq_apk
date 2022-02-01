package coil.size;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/size/SizeResolver;", "", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public static final a cqb = a.cqc;
  
  public abstract Object o(d<? super Size> paramd);
  
  @Metadata(d1={""}, d2={"Lcoil/size/SizeResolver$Companion;", "", "()V", "invoke", "Lcoil/size/SizeResolver;", "size", "Lcoil/size/Size;", "create", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(188201);
      cqc = new a();
      AppMethodBeat.o(188201);
    }
    
    public static f b(Size paramSize)
    {
      AppMethodBeat.i(188191);
      s.u(paramSize, "size");
      paramSize = (f)new c(paramSize);
      AppMethodBeat.o(188191);
      return paramSize;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.size.f
 * JD-Core Version:    0.7.0.1
 */