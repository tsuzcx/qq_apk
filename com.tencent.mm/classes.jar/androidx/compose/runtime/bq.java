package androidx.compose.runtime;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Trace;", "", "()V", "beginSection", "name", "", "endSection", "", "token", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
{
  public static final bq aqj;
  
  static
  {
    AppMethodBeat.i(201960);
    aqj = new bq();
    AppMethodBeat.o(201960);
  }
  
  public static Object ai(String paramString)
  {
    AppMethodBeat.i(201953);
    s.u(paramString, "name");
    Trace.beginSection(paramString);
    AppMethodBeat.o(201953);
    return null;
  }
  
  public static void qo()
  {
    AppMethodBeat.i(201957);
    Trace.endSection();
    AppMethodBeat.o(201957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bq
 * JD-Core Version:    0.7.0.1
 */