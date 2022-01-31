package a.j.b.a.c.j.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o<T extends a.j.b.a.c.e.a.a>
{
  private final a.j.b.a.c.f.a BUp;
  private final T CyV;
  private final T CyW;
  private final String filePath;
  
  public o(T paramT1, T paramT2, String paramString, a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(122270);
    this.CyV = paramT1;
    this.CyW = paramT2;
    this.filePath = paramString;
    this.BUp = parama;
    AppMethodBeat.o(122270);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122273);
    if (this != paramObject)
    {
      if ((paramObject instanceof o))
      {
        paramObject = (o)paramObject;
        if ((!j.e(this.CyV, paramObject.CyV)) || (!j.e(this.CyW, paramObject.CyW)) || (!j.e(this.filePath, paramObject.filePath)) || (!j.e(this.BUp, paramObject.BUp))) {}
      }
    }
    else
    {
      AppMethodBeat.o(122273);
      return true;
    }
    AppMethodBeat.o(122273);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(122272);
    Object localObject = this.CyV;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.CyW;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.filePath;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.BUp;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(122272);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122271);
    String str = "IncompatibleVersionErrorData(actualVersion=" + this.CyV + ", expectedVersion=" + this.CyW + ", filePath=" + this.filePath + ", classId=" + this.BUp + ")";
    AppMethodBeat.o(122271);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.j.a.o
 * JD-Core Version:    0.7.0.1
 */