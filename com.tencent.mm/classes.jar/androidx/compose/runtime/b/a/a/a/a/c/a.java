package androidx.compose.runtime.b.a.a.a.a.c;

import androidx.compose.runtime.b.a.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "", "()V", "previous", "(Ljava/lang/Object;)V", "next", "(Ljava/lang/Object;Ljava/lang/Object;)V", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "getNext", "()Ljava/lang/Object;", "getPrevious", "withNext", "newNext", "withPrevious", "newPrevious", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  final Object arg;
  final Object arh;
  
  public a()
  {
    this(localb, localb);
    AppMethodBeat.i(202739);
    AppMethodBeat.o(202739);
  }
  
  public a(Object paramObject)
  {
    this(paramObject, b.aro);
  }
  
  public a(Object paramObject1, Object paramObject2)
  {
    this.arg = paramObject1;
    this.arh = paramObject2;
  }
  
  public final a af(Object paramObject)
  {
    AppMethodBeat.i(202750);
    paramObject = new a(this.arg, paramObject);
    AppMethodBeat.o(202750);
    return paramObject;
  }
  
  public final boolean qY()
  {
    return this.arh != b.aro;
  }
  
  public final boolean qZ()
  {
    return this.arg != b.aro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */