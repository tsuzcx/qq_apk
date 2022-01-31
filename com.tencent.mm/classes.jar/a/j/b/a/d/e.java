package a.j.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e<K, V>
  implements Serializable
{
  public final V value;
  public final K ypR;
  
  public e(K paramK, V paramV)
  {
    this.ypR = paramK;
    this.value = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(123004);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(123004);
      return false;
    }
    paramObject = (e)paramObject;
    if (this.ypR == null)
    {
      if (paramObject.ypR != null) {
        break label73;
      }
      if (this.value != null) {
        break label80;
      }
      if (paramObject.value != null) {
        break label73;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(123004);
      return true;
      if (this.ypR.equals(paramObject.ypR)) {
        break;
      }
      label73:
      label80:
      do
      {
        AppMethodBeat.o(123004);
        return false;
      } while (!this.value.equals(paramObject.value));
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(123005);
    int i;
    if (this.ypR == null)
    {
      i = 0;
      if (this.value != null) {
        break label43;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(123005);
      return i ^ j;
      i = this.ypR.hashCode();
      break;
      label43:
      j = this.value.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123006);
    String str = this.ypR + "=" + this.value;
    AppMethodBeat.o(123006);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.d.e
 * JD-Core Version:    0.7.0.1
 */