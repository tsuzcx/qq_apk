package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d
{
  public static <Input extends EditText,  extends ab> void a(final z paramz, Input paramInput, a.a parama)
  {
    AppMethodBeat.i(136644);
    if (!((ab)paramInput).bFj())
    {
      AppMethodBeat.o(136644);
      return;
    }
    paramz = new WeakReference(paramz);
    paramz = new h()
    {
      public final void a(String paramAnonymousString, h.a paramAnonymousa)
      {
        AppMethodBeat.i(136643);
        Object localObject = (EditText)this.nmK.get();
        z localz = (z)paramz.get();
        if ((localObject == null) || (localz == null))
        {
          AppMethodBeat.o(136643);
          return;
        }
        int i = ((ab)localObject).getInputId();
        localObject = new d.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("id", paramAnonymousString);
        localHashMap.put("type", paramAnonymousa.name().toLowerCase());
        localHashMap.put("inputId", Integer.valueOf(i));
        ((d.a)localObject).g(localz).H(localHashMap).bja();
        AppMethodBeat.o(136643);
      }
    };
    paramInput = ((ab)paramInput).getAutoFillController();
    paramInput.H(parama.nnN);
    paramInput.a(paramz);
    if ("screen".equalsIgnoreCase(parama.nnM)) {}
    for (paramz = f.nmS;; paramz = f.nmT)
    {
      paramInput.a(paramz);
      AppMethodBeat.o(136644);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */