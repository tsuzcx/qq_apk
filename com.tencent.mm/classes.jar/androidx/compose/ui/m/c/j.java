package androidx.compose.ui.m.c;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/InputMethodManagerImpl;", "Landroidx/compose/ui/text/input/InputMethodManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imm", "Landroid/view/inputmethod/InputMethodManager;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lkotlin/Lazy;", "hideSoftInputFromWindow", "", "windowToken", "Landroid/os/IBinder;", "restartInput", "view", "Landroid/view/View;", "showSoftInput", "updateExtractedText", "token", "", "extractedText", "Landroid/view/inputmethod/ExtractedText;", "updateSelection", "selectionStart", "selectionEnd", "compositionStart", "compositionEnd", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements i
{
  private final kotlin.j bcL;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(205261);
    this.bcL = k.a(o.aiuH, (a)new a(paramContext));
    AppMethodBeat.o(205261);
  }
  
  private final InputMethodManager Bt()
  {
    AppMethodBeat.i(205264);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.bcL.getValue();
    AppMethodBeat.o(205264);
    return localInputMethodManager;
  }
  
  public final void C(View paramView)
  {
    AppMethodBeat.i(205269);
    s.u(paramView, "view");
    Bt().showSoftInput(paramView, 0);
    AppMethodBeat.o(205269);
  }
  
  public final void f(IBinder paramIBinder)
  {
    AppMethodBeat.i(205272);
    Bt().hideSoftInputFromWindow(paramIBinder, 0);
    AppMethodBeat.o(205272);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/inputmethod/InputMethodManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<InputMethodManager>
  {
    a(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.j
 * JD-Core Version:    0.7.0.1
 */