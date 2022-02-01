package androidx.compose.ui.a;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/autofill/AutofillApi26Helper;", "", "()V", "getAutofillId", "Landroid/view/autofill/AutofillId;", "structure", "Landroid/view/ViewStructure;", "isDate", "", "value", "Landroid/view/autofill/AutofillValue;", "isList", "isText", "isToggle", "setAutofillHints", "", "hints", "", "", "(Landroid/view/ViewStructure;[Ljava/lang/String;)V", "setAutofillId", "parent", "virtualId", "", "setAutofillType", "type", "textValue", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d aui;
  
  static
  {
    AppMethodBeat.i(204448);
    aui = new d();
    AppMethodBeat.o(204448);
  }
  
  public final AutofillId a(ViewStructure paramViewStructure)
  {
    AppMethodBeat.i(204458);
    s.u(paramViewStructure, "structure");
    paramViewStructure = paramViewStructure.getAutofillId();
    AppMethodBeat.o(204458);
    return paramViewStructure;
  }
  
  public final void a(ViewStructure paramViewStructure, AutofillId paramAutofillId, int paramInt)
  {
    AppMethodBeat.i(204452);
    s.u(paramViewStructure, "structure");
    s.u(paramAutofillId, "parent");
    paramViewStructure.setAutofillId(paramAutofillId, paramInt);
    AppMethodBeat.o(204452);
  }
  
  public final void a(ViewStructure paramViewStructure, String[] paramArrayOfString)
  {
    AppMethodBeat.i(204466);
    s.u(paramViewStructure, "structure");
    s.u(paramArrayOfString, "hints");
    paramViewStructure.setAutofillHints(paramArrayOfString);
    AppMethodBeat.o(204466);
  }
  
  public final boolean a(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(204471);
    s.u(paramAutofillValue, "value");
    boolean bool = paramAutofillValue.isText();
    AppMethodBeat.o(204471);
    return bool;
  }
  
  public final boolean b(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(204476);
    s.u(paramAutofillValue, "value");
    boolean bool = paramAutofillValue.isDate();
    AppMethodBeat.o(204476);
    return bool;
  }
  
  public final void c(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(204462);
    s.u(paramViewStructure, "structure");
    paramViewStructure.setAutofillType(paramInt);
    AppMethodBeat.o(204462);
  }
  
  public final boolean c(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(204483);
    s.u(paramAutofillValue, "value");
    boolean bool = paramAutofillValue.isList();
    AppMethodBeat.o(204483);
    return bool;
  }
  
  public final boolean d(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(204488);
    s.u(paramAutofillValue, "value");
    boolean bool = paramAutofillValue.isToggle();
    AppMethodBeat.o(204488);
    return bool;
  }
  
  public final CharSequence e(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(204494);
    s.u(paramAutofillValue, "value");
    paramAutofillValue = paramAutofillValue.getTextValue();
    s.s(paramAutofillValue, "value.textValue");
    AppMethodBeat.o(204494);
    return paramAutofillValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.a.d
 * JD-Core Version:    0.7.0.1
 */