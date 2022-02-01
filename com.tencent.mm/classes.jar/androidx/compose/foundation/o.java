package androidx.compose.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/MutatePriority;", "", "(Ljava/lang/String;I)V", "Default", "UserInput", "PreventUserInput", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum o
{
  static
  {
    AppMethodBeat.i(203602);
    YZ = new o("Default", 0);
    Za = new o("UserInput", 1);
    Zb = new o("PreventUserInput", 2);
    Zc = new o[] { YZ, Za, Zb };
    AppMethodBeat.o(203602);
  }
  
  private o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.foundation.o
 * JD-Core Version:    0.7.0.1
 */