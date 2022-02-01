package androidx.compose.ui.a;

import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillManager.AutofillCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/autofill/AutofillCallback;", "Landroid/view/autofill/AutofillManager$AutofillCallback;", "()V", "onAutofillEvent", "", "view", "Landroid/view/View;", "virtualId", "", "event", "register", "autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "unregister", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends AutofillManager.AutofillCallback
{
  public static final e auj;
  
  static
  {
    AppMethodBeat.i(204437);
    auj = new e();
    AppMethodBeat.o(204437);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(204440);
    s.u(parama, "autofill");
    parama.aug.registerCallback((AutofillManager.AutofillCallback)this);
    AppMethodBeat.o(204440);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(204444);
    s.u(parama, "autofill");
    parama.aug.unregisterCallback((AutofillManager.AutofillCallback)this);
    AppMethodBeat.o(204444);
  }
  
  public final void onAutofillEvent(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204439);
    s.u(paramView, "view");
    super.onAutofillEvent(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(204439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.a.e
 * JD-Core Version:    0.7.0.1
 */