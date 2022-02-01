package androidx.compose.ui.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/TextInputService;", "", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "(Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "_currentInputSession", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/text/input/TextInputSession;", "Landroidx/compose/ui/text/AtomicReference;", "currentInputSession", "getCurrentInputSession$ui_text_release", "()Landroidx/compose/ui/text/input/TextInputSession;", "hideSoftwareKeyboard", "", "showSoftwareKeyboard", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "stopInput", "session", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public class s
{
  private final m bdk;
  private final AtomicReference<Object> bdl;
  
  public s(m paramm)
  {
    AppMethodBeat.i(205270);
    this.bdk = paramm;
    this.bdl = new AtomicReference(null);
    AppMethodBeat.o(205270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.m.c.s
 * JD-Core Version:    0.7.0.1
 */