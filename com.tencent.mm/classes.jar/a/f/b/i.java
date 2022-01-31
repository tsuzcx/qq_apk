package a.f.b;

import a.j.a;
import a.j.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
  extends c
  implements h, e
{
  private final int BNe;
  
  public i(int paramInt)
  {
    this.BNe = paramInt;
  }
  
  public i(Object paramObject)
  {
    super(paramObject);
    this.BNe = 1;
  }
  
  public final int eaY()
  {
    return this.BNe;
  }
  
  protected final a eba()
  {
    AppMethodBeat.i(55883);
    e locale = v.a(this);
    AppMethodBeat.o(55883);
    return locale;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(55884);
    if (paramObject == this)
    {
      AppMethodBeat.o(55884);
      return true;
    }
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      if (ebe() == null)
      {
        if (paramObject.ebe() != null) {}
      }
      else {
        while (ebe().equals(paramObject.ebe()))
        {
          if ((!getName().equals(paramObject.getName())) || (!dyz().equals(paramObject.dyz())) || (!j.e(ebb(), paramObject.ebb()))) {
            break;
          }
          AppMethodBeat.o(55884);
          return true;
        }
      }
      AppMethodBeat.o(55884);
      return false;
    }
    if ((paramObject instanceof e))
    {
      boolean bool = paramObject.equals(ebc());
      AppMethodBeat.o(55884);
      return bool;
    }
    AppMethodBeat.o(55884);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(55885);
    if (ebe() == null) {}
    for (int i = 0;; i = ebe().hashCode() * 31)
    {
      int j = getName().hashCode();
      int k = dyz().hashCode();
      AppMethodBeat.o(55885);
      return (i + j) * 31 + k;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(55886);
    Object localObject = ebc();
    if (localObject != this)
    {
      localObject = localObject.toString();
      AppMethodBeat.o(55886);
      return localObject;
    }
    if ("<init>".equals(getName()))
    {
      AppMethodBeat.o(55886);
      return "constructor (Kotlin reflection is not available)";
    }
    localObject = "function " + getName() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(55886);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.i
 * JD-Core Version:    0.7.0.1
 */