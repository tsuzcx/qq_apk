package androidx.compose.ui.platform;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/platform/WindowInfo;", "()V", "_isWindowFocused", "Landroidx/compose/runtime/MutableState;", "", "value", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
  implements ba
{
  final an<Boolean> aVI;
  
  public bb()
  {
    AppMethodBeat.i(206868);
    this.aVI = bj.T(Boolean.FALSE);
    AppMethodBeat.o(206868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.bb
 * JD-Core Version:    0.7.0.1
 */