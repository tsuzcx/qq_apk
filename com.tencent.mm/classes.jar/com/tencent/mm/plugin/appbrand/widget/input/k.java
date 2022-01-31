package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.page.q;
import java.lang.ref.WeakReference;

final class k
  implements e.b, e.c
{
  final WeakReference<q> hsZ;
  
  k(q paramq)
  {
    this.hsZ = new WeakReference(paramq);
    paramq.a(this);
    paramq.a(this);
  }
  
  public final void onDestroy()
  {
    q localq = (q)this.hsZ.get();
    if (localq != null)
    {
      if ((localq.mContext instanceof ac)) {
        ((ac)localq.mContext).XM();
      }
      n.w(localq);
      n.x(localq);
      e.t(localq);
      localq.b(this);
      localq.b(this);
      if (localq.gTF != null) {
        h.arM().e(localq.gTF);
      }
    }
  }
  
  public final void qa()
  {
    q localq = (q)this.hsZ.get();
    if (localq != null) {
      n.w(localq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.k
 * JD-Core Version:    0.7.0.1
 */