package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/StateObject;", "", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "", "value", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aa
{
  public abstract ab a(ab paramab1, ab paramab2, ab paramab3);
  
  public abstract void a(ab paramab);
  
  public abstract ab pp();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static ab a(aa paramaa, ab paramab1, ab paramab2, ab paramab3)
    {
      AppMethodBeat.i(202669);
      s.u(paramaa, "this");
      s.u(paramab1, "previous");
      s.u(paramab2, "current");
      s.u(paramab3, "applied");
      AppMethodBeat.o(202669);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.aa
 * JD-Core Version:    0.7.0.1
 */