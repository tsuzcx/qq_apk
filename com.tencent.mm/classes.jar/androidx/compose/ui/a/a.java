package androidx.compose.ui.a;

import android.content.Context;
import android.view.View;
import android.view.autofill.AutofillManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroidx/compose/ui/autofill/Autofill;", "view", "Landroid/view/View;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "(Landroid/view/View;Landroidx/compose/ui/autofill/AutofillTree;)V", "autofillManager", "Landroid/view/autofill/AutofillManager;", "getAutofillManager", "()Landroid/view/autofill/AutofillManager;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "getView", "()Landroid/view/View;", "cancelAutofillForNode", "", "autofillNode", "Landroidx/compose/ui/autofill/AutofillNode;", "requestAutofillForNode", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public final g auf;
  final AutofillManager aug;
  public final View view;
  
  public a(View paramView, g paramg)
  {
    AppMethodBeat.i(204442);
    this.view = paramView;
    this.auf = paramg;
    paramView = (AutofillManager)this.view.getContext().getSystemService(AutofillManager.class);
    if (paramView == null)
    {
      paramView = (Throwable)new IllegalStateException("Autofill service could not be located.".toString());
      AppMethodBeat.o(204442);
      throw paramView;
    }
    this.aug = paramView;
    this.view.setImportantForAutofill(1);
    AppMethodBeat.o(204442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.a.a
 * JD-Core Version:    0.7.0.1
 */