package coil.util;

import coil.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"mapData", "", "Lcoil/ComponentRegistry;", "data", "requireDecoder", "Lcoil/decode/Decoder;", "T", "source", "Lokio/BufferedSource;", "mimeType", "", "(Lcoil/ComponentRegistry;Ljava/lang/Object;Lokio/BufferedSource;Ljava/lang/String;)Lcoil/decode/Decoder;", "requireFetcher", "Lcoil/fetch/Fetcher;", "(Lcoil/ComponentRegistry;Ljava/lang/Object;)Lcoil/fetch/Fetcher;", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final Object a(coil.b paramb, Object paramObject)
  {
    AppMethodBeat.i(188101);
    s.u(paramb, "<this>");
    s.u(paramObject, "data");
    List localList = paramb.mappers;
    int i = 0;
    int k = localList.size() - 1;
    paramb = paramObject;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      r localr = (r)localList.get(i);
      coil.i.b localb = (coil.i.b)localr.bsC;
      paramb = paramObject;
      if (((Class)localr.bsD).isAssignableFrom(paramObject.getClass()))
      {
        paramb = paramObject;
        if (localb.aV(paramObject)) {
          paramb = localb.aY(paramObject);
        }
      }
      if (j > k)
      {
        AppMethodBeat.o(188101);
        return paramb;
      }
      i = j;
      paramObject = paramb;
    }
  }
  
  public static final <T> g<T> b(coil.b paramb, T paramT)
  {
    AppMethodBeat.i(188116);
    s.u(paramb, "<this>");
    s.u(paramT, "data");
    List localList = paramb.ckU;
    int k = localList.size() - 1;
    if (k >= 0) {}
    int j;
    label146:
    label157:
    label172:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      paramb = localList.get(i);
      r localr = (r)paramb;
      g localg = (g)localr.bsC;
      if ((((Class)localr.bsD).isAssignableFrom(paramT.getClass())) && (localg.aV(paramT)))
      {
        i = 1;
        if (i == 0) {
          break label146;
        }
      }
      for (;;)
      {
        paramb = (r)paramb;
        if (paramb != null) {
          break label157;
        }
        paramb = (Throwable)new IllegalStateException(s.X("Unable to fetch data. No fetcher supports: ", paramT).toString());
        AppMethodBeat.o(188116);
        throw paramb;
        i = 0;
        break;
        if (j <= k) {
          break label172;
        }
        paramb = null;
      }
      paramb = (g)paramb.bsC;
      AppMethodBeat.o(188116);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.util.b
 * JD-Core Version:    0.7.0.1
 */