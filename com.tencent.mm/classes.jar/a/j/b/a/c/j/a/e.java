package a.j.b.a.c.j.a;

import a.f.b.j;
import a.j.b.a.c.b.am;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.a;
import a.j.b.a.c.e.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  final c BOc;
  final a.c Cys;
  final a Cyt;
  final am Cyu;
  
  public e(c paramc, a.c paramc1, a parama, am paramam)
  {
    AppMethodBeat.i(122248);
    this.BOc = paramc;
    this.Cys = paramc1;
    this.Cyt = parama;
    this.Cyu = paramam;
    AppMethodBeat.o(122248);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122251);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!j.e(this.BOc, paramObject.BOc)) || (!j.e(this.Cys, paramObject.Cys)) || (!j.e(this.Cyt, paramObject.Cyt)) || (!j.e(this.Cyu, paramObject.Cyu))) {}
      }
    }
    else
    {
      AppMethodBeat.o(122251);
      return true;
    }
    AppMethodBeat.o(122251);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(122250);
    Object localObject = this.BOc;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.Cys;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.Cyt;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.Cyu;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(122250);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122249);
    String str = "ClassData(nameResolver=" + this.BOc + ", classProto=" + this.Cys + ", metadataVersion=" + this.Cyt + ", sourceElement=" + this.Cyu + ")";
    AppMethodBeat.o(122249);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.j.a.e
 * JD-Core Version:    0.7.0.1
 */