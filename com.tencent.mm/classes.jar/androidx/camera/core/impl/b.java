package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b<T>
  extends ac.a<T>
{
  private final Class<T> Ky;
  private final String id;
  private final Object token;
  
  b(String paramString, Class<T> paramClass, Object paramObject)
  {
    AppMethodBeat.i(198727);
    if (paramString == null)
    {
      paramString = new NullPointerException("Null id");
      AppMethodBeat.o(198727);
      throw paramString;
    }
    this.id = paramString;
    if (paramClass == null)
    {
      paramString = new NullPointerException("Null valueClass");
      AppMethodBeat.o(198727);
      throw paramString;
    }
    this.Ky = paramClass;
    this.token = paramObject;
    AppMethodBeat.o(198727);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198764);
    if (paramObject == this)
    {
      AppMethodBeat.o(198764);
      return true;
    }
    if ((paramObject instanceof ac.a))
    {
      paramObject = (ac.a)paramObject;
      if ((this.id.equals(paramObject.getId())) && (this.Ky.equals(paramObject.jM()))) {
        if (this.token == null)
        {
          if (paramObject.jN() != null) {}
        }
        else {
          while (this.token.equals(paramObject.jN()))
          {
            AppMethodBeat.o(198764);
            return true;
          }
        }
      }
      AppMethodBeat.o(198764);
      return false;
    }
    AppMethodBeat.o(198764);
    return false;
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198773);
    int j = this.id.hashCode();
    int k = this.Ky.hashCode();
    if (this.token == null) {}
    for (int i = 0;; i = this.token.hashCode())
    {
      AppMethodBeat.o(198773);
      return i ^ ((j ^ 0xF4243) * 1000003 ^ k) * 1000003;
    }
  }
  
  public final Class<T> jM()
  {
    return this.Ky;
  }
  
  public final Object jN()
  {
    return this.token;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198756);
    String str = "Option{id=" + this.id + ", valueClass=" + this.Ky + ", token=" + this.token + "}";
    AppMethodBeat.o(198756);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.b
 * JD-Core Version:    0.7.0.1
 */