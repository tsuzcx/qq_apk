package a.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class x
{
  public final ArrayList<Object> ceo;
  
  public x(int paramInt)
  {
    AppMethodBeat.i(55893);
    this.ceo = new ArrayList(paramInt);
    AppMethodBeat.o(55893);
  }
  
  public final void add(Object paramObject)
  {
    AppMethodBeat.i(55895);
    this.ceo.add(paramObject);
    AppMethodBeat.o(55895);
  }
  
  public final void dh(Object paramObject)
  {
    AppMethodBeat.i(55894);
    if (paramObject == null)
    {
      AppMethodBeat.o(55894);
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0)
      {
        this.ceo.ensureCapacity(this.ceo.size() + paramObject.length);
        int j = paramObject.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramObject[i];
          this.ceo.add(localObject);
          i += 1;
        }
      }
      AppMethodBeat.o(55894);
      return;
    }
    paramObject = new UnsupportedOperationException("Don't know how to spread " + paramObject.getClass());
    AppMethodBeat.o(55894);
    throw paramObject;
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(55896);
    paramArrayOfObject = this.ceo.toArray(paramArrayOfObject);
    AppMethodBeat.o(55896);
    return paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.f.b.x
 * JD-Core Version:    0.7.0.1
 */