package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class v$1
  extends v<FieldDescriptorType, Object>
{
  v$1(int paramInt)
  {
    super(paramInt, (byte)0);
  }
  
  public final void emF()
  {
    AppMethodBeat.i(121620);
    if (!this.Crr)
    {
      int i = 0;
      while (i < enc())
      {
        localObject = VN(i);
        if (((h.a)((Map.Entry)localObject).getKey()).emJ()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = ene().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((h.a)localEntry.getKey()).emJ()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.emF();
    AppMethodBeat.o(121620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.g.v.1
 * JD-Core Version:    0.7.0.1
 */