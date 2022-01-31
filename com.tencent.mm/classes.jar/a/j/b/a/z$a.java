package a.j.b.a;

import a.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;

public final class z$a<T>
  extends z.c<T>
{
  private final a<T> BLZ;
  private SoftReference<Object> BQj;
  
  public z$a(T paramT, a<T> parama)
  {
    AppMethodBeat.i(118897);
    this.BQj = null;
    this.BLZ = parama;
    if (paramT != null) {
      this.BQj = new SoftReference(dp(paramT));
    }
    AppMethodBeat.o(118897);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(118898);
    Object localObject = this.BQj;
    if (localObject != null)
    {
      localObject = ((SoftReference)localObject).get();
      if (localObject != null)
      {
        localObject = dq(localObject);
        AppMethodBeat.o(118898);
        return localObject;
      }
    }
    localObject = this.BLZ.invoke();
    this.BQj = new SoftReference(dp(localObject));
    AppMethodBeat.o(118898);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.z.a
 * JD-Core Version:    0.7.0.1
 */