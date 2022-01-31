package a.j.b.a.c.d.a;

import a.j.b.a.c.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a$b
{
  public final c CbY;
  private final int CbZ;
  
  public a$b(c paramc, int paramInt)
  {
    AppMethodBeat.i(119646);
    this.CbY = paramc;
    this.CbZ = paramInt;
    AppMethodBeat.o(119646);
  }
  
  private final boolean a(a.a parama)
  {
    AppMethodBeat.i(119645);
    if ((this.CbZ & 1 << parama.ordinal()) != 0)
    {
      AppMethodBeat.o(119645);
      return true;
    }
    AppMethodBeat.o(119645);
    return false;
  }
  
  public final List<a.a> efo()
  {
    AppMethodBeat.i(119644);
    Object localObject = a.a.values();
    Collection localCollection = (Collection)new ArrayList();
    int k = localObject.length;
    int i = 0;
    if (i < k)
    {
      a.a locala = localObject[i];
      b localb = (b)this;
      if ((localb.a(a.a.CbW)) || (localb.a(locala))) {}
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localCollection.add(locala);
        }
        i += 1;
        break;
      }
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(119644);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */