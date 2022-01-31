package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import java.lang.ref.WeakReference;

public final class d
{
  public static <Input extends EditText,  extends ab> void a(v paramv, Input paramInput, a.a parama)
  {
    AppMethodBeat.i(123904);
    if (!((ab)paramInput).aQY())
    {
      AppMethodBeat.o(123904);
      return;
    }
    paramv = new WeakReference(paramv);
    paramv = new d.1(new WeakReference(paramInput), paramv);
    paramInput = ((ab)paramInput).getAutoFillController();
    paramInput.s(parama.jqq);
    paramInput.a(paramv);
    if ("screen".equalsIgnoreCase(parama.jqp)) {}
    for (paramv = f.jpv;; paramv = f.jpw)
    {
      paramInput.a(paramv);
      AppMethodBeat.o(123904);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */