package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$1
  implements h
{
  d$1(WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public final void a(String paramString, h.a parama)
  {
    AppMethodBeat.i(136643);
    Object localObject = (EditText)this.nhC.get();
    aa localaa = (aa)this.kNX.get();
    if ((localObject == null) || (localaa == null))
    {
      AppMethodBeat.o(136643);
      return;
    }
    int i = ((ab)localObject).getInputId();
    localObject = new d.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    localHashMap.put("type", parama.name().toLowerCase());
    localHashMap.put("inputId", Integer.valueOf(i));
    ((d.a)localObject).g(localaa).A(localHashMap).bir();
    AppMethodBeat.o(136643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d.1
 * JD-Core Version:    0.7.0.1
 */