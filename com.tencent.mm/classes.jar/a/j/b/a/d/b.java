package a.j.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V>
{
  private static final b<Object, Object> CFr;
  private final d<a<e<K, V>>> CFs;
  private final int size;
  
  static
  {
    AppMethodBeat.i(122993);
    CFr = new b(d.epe(), 0);
    AppMethodBeat.o(122993);
  }
  
  private b(d<a<e<K, V>>> paramd, int paramInt)
  {
    this.CFs = paramd;
    this.size = paramInt;
  }
  
  private static <K, V> int a(a<e<K, V>> parama, Object paramObject)
  {
    AppMethodBeat.i(122992);
    int i = 0;
    while ((parama != null) && (parama.size > 0))
    {
      if (((e)parama.first).ypR.equals(paramObject))
      {
        AppMethodBeat.o(122992);
        return i;
      }
      parama = parama.CFp;
      i += 1;
    }
    AppMethodBeat.o(122992);
    return -1;
  }
  
  public static <K, V> b<K, V> epd()
  {
    return CFr;
  }
  
  public final b<K, V> H(K paramK, V paramV)
  {
    AppMethodBeat.i(122990);
    a locala2 = Wd(paramK.hashCode());
    int i = locala2.size;
    int j = a(locala2, paramK);
    a locala1 = locala2;
    if (j != -1) {
      locala1 = locala2.Wb(j);
    }
    paramV = locala1.dU(new e(paramK, paramV));
    paramK = this.CFs.u(paramK.hashCode(), paramV);
    j = this.size;
    paramK = new b(paramK, paramV.size + (j - i));
    AppMethodBeat.o(122990);
    return paramK;
  }
  
  public final a<e<K, V>> Wd(int paramInt)
  {
    AppMethodBeat.i(122991);
    a locala = (a)this.CFs.get(paramInt);
    if (locala == null)
    {
      locala = a.epc();
      AppMethodBeat.o(122991);
      return locala;
    }
    AppMethodBeat.o(122991);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.d.b
 * JD-Core Version:    0.7.0.1
 */