package a.j.b.a;

import a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z$b<T>
  extends z.c<T>
{
  private final a<T> BLZ;
  private Object value = null;
  
  public z$b(a<T> parama)
  {
    this.BLZ = parama;
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(118899);
    Object localObject = this.value;
    if (localObject != null)
    {
      localObject = dq(localObject);
      AppMethodBeat.o(118899);
      return localObject;
    }
    localObject = this.BLZ.invoke();
    this.value = dp(localObject);
    AppMethodBeat.o(118899);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.z.b
 * JD-Core Version:    0.7.0.1
 */