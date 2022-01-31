package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$1
  implements h
{
  d$1(WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public final void a(String paramString, h.a parama)
  {
    Object localObject = (EditText)this.hxd.get();
    q localq = (q)this.gro.get();
    if ((localObject == null) || (localq == null)) {
      return;
    }
    int i = ((aa)localObject).getInputId();
    localObject = new d.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", paramString);
    localHashMap.put("type", parama.name().toLowerCase());
    localHashMap.put("inputId", Integer.valueOf(i));
    ((d.a)localObject).d(localq).o(localHashMap).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.d.1
 * JD-Core Version:    0.7.0.1
 */