package androidx.camera.core.impl.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$c<V>
  extends f<V>
{
  static final f<Object> PO;
  private final V mValue;
  
  static
  {
    AppMethodBeat.i(199063);
    PO = new c(null);
    AppMethodBeat.o(199063);
  }
  
  f$c(V paramV)
  {
    this.mValue = paramV;
  }
  
  public final V get()
  {
    return this.mValue;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199075);
    String str = super.toString() + "[status=SUCCESS, result=[" + this.mValue + "]]";
    AppMethodBeat.o(199075);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.camera.core.impl.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */