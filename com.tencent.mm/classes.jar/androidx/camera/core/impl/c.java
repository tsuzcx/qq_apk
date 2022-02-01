package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends ag
{
  private final Object value;
  
  c(Object paramObject)
  {
    AppMethodBeat.i(198728);
    if (paramObject == null)
    {
      paramObject = new NullPointerException("Null value");
      AppMethodBeat.o(198728);
      throw paramObject;
    }
    this.value = paramObject;
    AppMethodBeat.o(198728);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198745);
    if (paramObject == this)
    {
      AppMethodBeat.o(198745);
      return true;
    }
    if ((paramObject instanceof ag))
    {
      paramObject = (ag)paramObject;
      boolean bool = this.value.equals(paramObject.getValue());
      AppMethodBeat.o(198745);
      return bool;
    }
    AppMethodBeat.o(198745);
    return false;
  }
  
  public final Object getValue()
  {
    return this.value;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198753);
    int i = this.value.hashCode();
    AppMethodBeat.o(198753);
    return 0xF4243 ^ i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198742);
    String str = "Identifier{value=" + this.value + "}";
    AppMethodBeat.o(198742);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.camera.core.impl.c
 * JD-Core Version:    0.7.0.1
 */