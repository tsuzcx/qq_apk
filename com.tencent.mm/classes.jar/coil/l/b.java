package coil.l;

import coil.j.f;
import coil.j.i;
import coil.j.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcoil/transition/NoneTransition;", "Lcoil/transition/Transition;", "()V", "toString", "", "transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  public static final b cqm;
  
  static
  {
    AppMethodBeat.i(187820);
    cqm = new b();
    AppMethodBeat.o(187820);
  }
  
  public final Object a(d paramd, i parami, kotlin.d.d<? super ah> paramd1)
  {
    AppMethodBeat.i(187829);
    if ((parami instanceof m)) {
      paramd.B(((m)parami).drawable);
    }
    for (;;)
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(187829);
      return paramd;
      if ((parami instanceof f)) {
        paramd.A(parami.getDrawable());
      }
    }
  }
  
  public final String toString()
  {
    return "coil.transition.NoneTransition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.l.b
 * JD-Core Version:    0.7.0.1
 */