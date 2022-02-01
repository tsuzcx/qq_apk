package androidx.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a<K, V>
  extends b<K, V>
{
  public HashMap<K, b.c<K, V>> yY;
  
  public a()
  {
    AppMethodBeat.i(201100);
    this.yY = new HashMap();
    AppMethodBeat.o(201100);
  }
  
  public final boolean contains(K paramK)
  {
    AppMethodBeat.i(201138);
    boolean bool = this.yY.containsKey(paramK);
    AppMethodBeat.o(201138);
    return bool;
  }
  
  public final V putIfAbsent(K paramK, V paramV)
  {
    AppMethodBeat.i(201117);
    b.c localc = q(paramK);
    if (localc != null)
    {
      paramK = localc.mValue;
      AppMethodBeat.o(201117);
      return paramK;
    }
    this.yY.put(paramK, c(paramK, paramV));
    AppMethodBeat.o(201117);
    return null;
  }
  
  protected final b.c<K, V> q(K paramK)
  {
    AppMethodBeat.i(201107);
    paramK = (b.c)this.yY.get(paramK);
    AppMethodBeat.o(201107);
    return paramK;
  }
  
  public final V remove(K paramK)
  {
    AppMethodBeat.i(201129);
    Object localObject = super.remove(paramK);
    this.yY.remove(paramK);
    AppMethodBeat.o(201129);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */