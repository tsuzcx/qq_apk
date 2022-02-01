package androidx.compose.a;

import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/CrossfadeAnimationItem;", "T", "", "key", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/animation/CrossfadeAnimationItem;", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g<T>
{
  final m<h, Integer, ah> SP;
  final T key;
  
  public g(T paramT, m<? super h, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(203027);
    this.key = paramT;
    this.SP = paramm;
    AppMethodBeat.o(203027);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203046);
    if (this == paramObject)
    {
      AppMethodBeat.o(203046);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(203046);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.key, paramObject.key))
    {
      AppMethodBeat.o(203046);
      return false;
    }
    if (!s.p(this.SP, paramObject.SP))
    {
      AppMethodBeat.o(203046);
      return false;
    }
    AppMethodBeat.o(203046);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203038);
    if (this.key == null) {}
    for (int i = 0;; i = this.key.hashCode())
    {
      int j = this.SP.hashCode();
      AppMethodBeat.o(203038);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203034);
    String str = "CrossfadeAnimationItem(key=" + this.key + ", content=" + this.SP + ')';
    AppMethodBeat.o(203034);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.a.g
 * JD-Core Version:    0.7.0.1
 */