package com.bumptech.glide.h;

import android.support.v4.e.a;
import android.support.v4.e.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V>
  extends a<K, V>
{
  private int aFZ;
  
  public final void a(n<? extends K, ? extends V> paramn)
  {
    AppMethodBeat.i(77725);
    this.aFZ = 0;
    super.a(paramn);
    AppMethodBeat.o(77725);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(77722);
    this.aFZ = 0;
    super.clear();
    AppMethodBeat.o(77722);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77727);
    if (this.aFZ == 0) {
      this.aFZ = super.hashCode();
    }
    int i = this.aFZ;
    AppMethodBeat.o(77727);
    return i;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(77724);
    this.aFZ = 0;
    paramK = super.put(paramK, paramV);
    AppMethodBeat.o(77724);
    return paramK;
  }
  
  public final V removeAt(int paramInt)
  {
    AppMethodBeat.i(77726);
    this.aFZ = 0;
    Object localObject = super.removeAt(paramInt);
    AppMethodBeat.o(77726);
    return localObject;
  }
  
  public final V setValueAt(int paramInt, V paramV)
  {
    AppMethodBeat.i(77723);
    this.aFZ = 0;
    paramV = super.setValueAt(paramInt, paramV);
    AppMethodBeat.o(77723);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.b
 * JD-Core Version:    0.7.0.1
 */