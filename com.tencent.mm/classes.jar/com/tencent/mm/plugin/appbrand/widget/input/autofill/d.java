package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d
{
  public static <Input extends EditText,  extends af> void a(final ad paramad, Input paramInput, a.a parama)
  {
    AppMethodBeat.i(136644);
    if (!((af)paramInput).coI())
    {
      AppMethodBeat.o(136644);
      return;
    }
    paramad = new WeakReference(paramad);
    paramad = new h()
    {
      public final void a(String paramAnonymousString, h.a paramAnonymousa)
      {
        AppMethodBeat.i(136643);
        Object localObject = (EditText)this.rzl.get();
        ad localad = (ad)paramad.get();
        if ((localObject == null) || (localad == null))
        {
          AppMethodBeat.o(136643);
          return;
        }
        int i = ((af)localObject).getInputId();
        localObject = new d.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("id", paramAnonymousString);
        localHashMap.put("type", paramAnonymousa.name().toLowerCase());
        localHashMap.put("inputId", Integer.valueOf(i));
        ((d.a)localObject).i(localad).D(localHashMap).bPO();
        AppMethodBeat.o(136643);
      }
    };
    paramInput = ((af)paramInput).getAutoFillController();
    paramInput.N(parama.rzR);
    paramInput.a(paramad);
    if ("screen".equalsIgnoreCase(parama.rzQ)) {}
    for (paramad = f.rzt;; paramad = f.rzu)
    {
      paramInput.a(paramad);
      AppMethodBeat.o(136644);
      return;
    }
  }
  
  public static final class a
    extends r
  {
    private static final int CTRL_INDEX = 207;
    public static final String NAME = "onKeyboardDropdownOperate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */