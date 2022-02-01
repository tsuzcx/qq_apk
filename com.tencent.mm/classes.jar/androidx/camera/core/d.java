package androidx.camera.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
  extends r
{
  private final r.b Gg;
  private final r.a Gh;
  
  d(r.b paramb, r.a parama)
  {
    AppMethodBeat.i(198480);
    if (paramb == null)
    {
      paramb = new NullPointerException("Null type");
      AppMethodBeat.o(198480);
      throw paramb;
    }
    this.Gg = paramb;
    this.Gh = parama;
    AppMethodBeat.o(198480);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198504);
    if (paramObject == this)
    {
      AppMethodBeat.o(198504);
      return true;
    }
    if ((paramObject instanceof r))
    {
      paramObject = (r)paramObject;
      if (this.Gg.equals(paramObject.iz())) {
        if (this.Gh == null)
        {
          if (paramObject.iA() != null) {}
        }
        else {
          while (this.Gh.equals(paramObject.iA()))
          {
            AppMethodBeat.o(198504);
            return true;
          }
        }
      }
      AppMethodBeat.o(198504);
      return false;
    }
    AppMethodBeat.o(198504);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198509);
    int j = this.Gg.hashCode();
    if (this.Gh == null) {}
    for (int i = 0;; i = this.Gh.hashCode())
    {
      AppMethodBeat.o(198509);
      return i ^ 1000003 * (j ^ 0xF4243);
    }
  }
  
  public final r.a iA()
  {
    return this.Gh;
  }
  
  public final r.b iz()
  {
    return this.Gg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198496);
    String str = "CameraState{type=" + this.Gg + ", error=" + this.Gh + "}";
    AppMethodBeat.o(198496);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.d
 * JD-Core Version:    0.7.0.1
 */