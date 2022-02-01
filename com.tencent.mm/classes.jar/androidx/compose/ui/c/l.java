package androidx.compose.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/focus/FocusStateImpl;", "", "Landroidx/compose/ui/focus/FocusState;", "(Ljava/lang/String;I)V", "hasFocus", "", "getHasFocus", "()Z", "isCaptured", "isFocused", "Active", "ActiveParent", "Captured", "Disabled", "Inactive", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum l
  implements k
{
  static
  {
    AppMethodBeat.i(204385);
    ave = new l("Active", 0);
    avf = new l("ActiveParent", 1);
    avh = new l("Captured", 2);
    avi = new l("Disabled", 3);
    avj = new l("Inactive", 4);
    avk = new l[] { ave, avf, avh, avi, avj };
    AppMethodBeat.o(204385);
  }
  
  private l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.l
 * JD-Core Version:    0.7.0.1
 */