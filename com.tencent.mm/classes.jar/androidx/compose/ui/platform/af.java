package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"simpleIdentityToString", "", "obj", "", "name", "nativeClass", "AtomicInt", "Ljava/util/concurrent/atomic/AtomicInteger;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final String al(Object paramObject)
  {
    AppMethodBeat.i(206747);
    s.u(paramObject, "obj");
    if (paramObject.getClass().isAnonymousClass()) {}
    for (Object localObject = paramObject.getClass().getName();; localObject = paramObject.getClass().getSimpleName())
    {
      localObject = new StringBuilder().append((String)localObject).append('@');
      am localam = am.aixg;
      paramObject = String.format("%07x", Arrays.copyOf(new Object[] { Integer.valueOf(System.identityHashCode(paramObject)) }, 1));
      s.s(paramObject, "java.lang.String.format(format, *args)");
      paramObject = paramObject;
      AppMethodBeat.o(206747);
      return paramObject;
    }
  }
  
  public static final Object am(Object paramObject)
  {
    AppMethodBeat.i(206756);
    s.u(paramObject, "<this>");
    paramObject = paramObject.getClass();
    AppMethodBeat.o(206756);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.af
 * JD-Core Version:    0.7.0.1
 */