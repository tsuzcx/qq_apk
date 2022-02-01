package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d
{
  public static <Input extends EditText,  extends ab> void a(final aa paramaa, Input paramInput, a.a parama)
  {
    AppMethodBeat.i(136644);
    if (!((ab)paramInput).bAp())
    {
      AppMethodBeat.o(136644);
      return;
    }
    paramaa = new WeakReference(paramaa);
    paramaa = new h()
    {
      public final void a(String paramAnonymousString, h.a paramAnonymousa)
      {
        AppMethodBeat.i(136643);
        Object localObject = (EditText)this.mHe.get();
        aa localaa = (aa)paramaa.get();
        if ((localObject == null) || (localaa == null))
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
        ((d.a)localObject).g(localaa).A(localHashMap).beN();
        AppMethodBeat.o(136643);
      }
    };
    paramInput = ((ab)paramInput).getAutoFillController();
    paramInput.H(parama.mIi);
    paramInput.a(paramaa);
    if ("screen".equalsIgnoreCase(parama.mIh)) {}
    for (paramaa = f.mHm;; paramaa = f.mHn)
    {
      paramInput.a(paramaa);
      AppMethodBeat.o(136644);
      return;
    }
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = 207;
    public static final String NAME = "onKeyboardDropdownOperate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d
 * JD-Core Version:    0.7.0.1
 */