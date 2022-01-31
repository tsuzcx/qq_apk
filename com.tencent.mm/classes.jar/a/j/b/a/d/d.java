package a.j.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V>
{
  private static final d<Object> CFw;
  private final c<V> CFx;
  
  static
  {
    AppMethodBeat.i(123003);
    CFw = new d(c.CFt);
    AppMethodBeat.o(123003);
  }
  
  private d(c<V> paramc)
  {
    this.CFx = paramc;
  }
  
  private d<V> a(c<V> paramc)
  {
    AppMethodBeat.i(123000);
    if (paramc == this.CFx)
    {
      AppMethodBeat.o(123000);
      return this;
    }
    paramc = new d(paramc);
    AppMethodBeat.o(123000);
    return paramc;
  }
  
  public static <V> d<V> epe()
  {
    return CFw;
  }
  
  public final V get(int paramInt)
  {
    AppMethodBeat.i(123001);
    Object localObject = this.CFx.get(paramInt);
    AppMethodBeat.o(123001);
    return localObject;
  }
  
  public final d<V> u(int paramInt, V paramV)
  {
    AppMethodBeat.i(123002);
    paramV = a(this.CFx.b(paramInt, paramV));
    AppMethodBeat.o(123002);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.d.d
 * JD-Core Version:    0.7.0.1
 */