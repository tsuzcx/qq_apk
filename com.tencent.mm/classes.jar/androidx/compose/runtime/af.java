package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/InvalidationResult;", "", "(Ljava/lang/String;I)V", "IGNORED", "SCHEDULED", "DEFERRED", "IMMINENT", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum af
{
  static
  {
    AppMethodBeat.i(201874);
    aog = new af("IGNORED", 0);
    aoh = new af("SCHEDULED", 1);
    aoi = new af("DEFERRED", 2);
    aoj = new af("IMMINENT", 3);
    aok = new af[] { aog, aoh, aoi, aoj };
    AppMethodBeat.o(201874);
  }
  
  private af() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.af
 * JD-Core Version:    0.7.0.1
 */