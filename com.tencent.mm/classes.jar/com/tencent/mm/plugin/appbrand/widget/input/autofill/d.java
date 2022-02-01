package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d
{
  public static <Input extends EditText,  extends ab> void a(final ac paramac, Input paramInput, a.a parama)
  {
    AppMethodBeat.i(136644);
    if (!((ab)paramInput).cby())
    {
      AppMethodBeat.o(136644);
      return;
    }
    paramac = new WeakReference(paramac);
    paramac = new h()
    {
      public final void a(String paramAnonymousString, h.a paramAnonymousa)
      {
        AppMethodBeat.i(136643);
        Object localObject = (EditText)this.owr.get();
        ac localac = (ac)paramac.get();
        if ((localObject == null) || (localac == null))
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
        ((d.a)localObject).g(localac).K(localHashMap).bEo();
        AppMethodBeat.o(136643);
      }
    };
    paramInput = ((ab)paramInput).getAutoFillController();
    paramInput.N(parama.oxt);
    paramInput.a(paramac);
    if ("screen".equalsIgnoreCase(parama.oxs)) {}
    for (paramac = f.owz;; paramac = f.owA)
    {
      paramInput.a(paramac);
      AppMethodBeat.o(136644);
      return;
    }
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = 207;
    public static final String NAME = "onKeyboardDropdownOperate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */