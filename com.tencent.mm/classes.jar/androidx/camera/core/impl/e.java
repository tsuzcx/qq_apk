package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  extends bg
{
  private final bg.b KC;
  private final bg.a KD;
  
  e(bg.b paramb, bg.a parama)
  {
    AppMethodBeat.i(198713);
    if (paramb == null)
    {
      paramb = new NullPointerException("Null configType");
      AppMethodBeat.o(198713);
      throw paramb;
    }
    this.KC = paramb;
    if (parama == null)
    {
      paramb = new NullPointerException("Null configSize");
      AppMethodBeat.o(198713);
      throw paramb;
    }
    this.KD = parama;
    AppMethodBeat.o(198713);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198744);
    if (paramObject == this)
    {
      AppMethodBeat.o(198744);
      return true;
    }
    if ((paramObject instanceof bg))
    {
      paramObject = (bg)paramObject;
      if ((this.KC.equals(paramObject.jO())) && (this.KD.equals(paramObject.jP())))
      {
        AppMethodBeat.o(198744);
        return true;
      }
      AppMethodBeat.o(198744);
      return false;
    }
    AppMethodBeat.o(198744);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198750);
    int i = this.KC.hashCode();
    int j = this.KD.hashCode();
    AppMethodBeat.o(198750);
    return (i ^ 0xF4243) * 1000003 ^ j;
  }
  
  public final bg.b jO()
  {
    return this.KC;
  }
  
  public final bg.a jP()
  {
    return this.KD;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198738);
    String str = "SurfaceConfig{configType=" + this.KC + ", configSize=" + this.KD + "}";
    AppMethodBeat.o(198738);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.e
 * JD-Core Version:    0.7.0.1
 */