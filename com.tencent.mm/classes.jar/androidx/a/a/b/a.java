package androidx.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a<K, V>
  extends b<K, V>
{
  public HashMap<K, b.c<K, V>> yd;
  
  public a()
  {
    AppMethodBeat.i(186199);
    this.yd = new HashMap();
    AppMethodBeat.o(186199);
  }
  
  public final boolean contains(K paramK)
  {
    AppMethodBeat.i(186205);
    boolean bool = this.yd.containsKey(paramK);
    AppMethodBeat.o(186205);
    return bool;
  }
  
  protected final b.c<K, V> n(K paramK)
  {
    AppMethodBeat.i(186200);
    paramK = (b.c)this.yd.get(paramK);
    AppMethodBeat.o(186200);
    return paramK;
  }
  
  public final V putIfAbsent(K paramK, V paramV)
  {
    AppMethodBeat.i(186202);
    b.c localc = n(paramK);
    if (localc != null)
    {
      paramK = localc.mValue;
      AppMethodBeat.o(186202);
      return paramK;
    }
    this.yd.put(paramK, a(paramK, paramV));
    AppMethodBeat.o(186202);
    return null;
  }
  
  public final V remove(K paramK)
  {
    AppMethodBeat.i(186204);
    Object localObject = super.remove(paramK);
    this.yd.remove(paramK);
    AppMethodBeat.o(186204);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */