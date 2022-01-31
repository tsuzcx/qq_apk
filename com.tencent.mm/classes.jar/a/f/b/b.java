package a.f.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"})
public final class b
{
  public static final <T> Iterator<T> W(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56232);
    j.q(paramArrayOfT, "array");
    paramArrayOfT = (Iterator)new a(paramArrayOfT);
    AppMethodBeat.o(56232);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.f.b.b
 * JD-Core Version:    0.7.0.1
 */