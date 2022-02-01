package coil.memory;

import coil.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/memory/MemoryCacheService;", "", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "(Lcoil/bitmap/BitmapReferenceCounter;Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;)V", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  private final u clU;
  private final d cnQ;
  private final r cnR;
  
  public l(d paramd, r paramr, u paramu)
  {
    AppMethodBeat.i(188285);
    this.cnQ = paramd;
    this.cnR = paramr;
    this.clU = paramu;
    AppMethodBeat.o(188285);
  }
  
  public final n.a a(MemoryCache.Key paramKey)
  {
    AppMethodBeat.i(188298);
    if (paramKey == null)
    {
      AppMethodBeat.o(188298);
      return null;
    }
    n.a locala2 = this.cnR.a(paramKey);
    n.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = this.clU.a(paramKey);
    }
    if (locala1 != null) {
      this.cnQ.p(locala1.getBitmap());
    }
    AppMethodBeat.o(188298);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.l
 * JD-Core Version:    0.7.0.1
 */