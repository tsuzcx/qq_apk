package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import java.lang.ref.WeakReference;

public final class d
{
  public static <Input extends EditText,  extends ab> void a(aa paramaa, Input paramInput, a.a parama)
  {
    AppMethodBeat.i(136644);
    if (!((ab)paramInput).bEr())
    {
      AppMethodBeat.o(136644);
      return;
    }
    paramaa = new WeakReference(paramaa);
    paramaa = new d.1(new WeakReference(paramInput), paramaa);
    paramInput = ((ab)paramInput).getAutoFillController();
    paramInput.H(parama.niF);
    paramInput.a(paramaa);
    if ("screen".equalsIgnoreCase(parama.niE)) {}
    for (paramaa = f.nhK;; paramaa = f.nhL)
    {
      paramInput.a(paramaa);
      AppMethodBeat.o(136644);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */