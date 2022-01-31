package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;

final class a$1
  implements Runnable
{
  a$1(a parama, o paramo, int paramInt) {}
  
  public final void run()
  {
    a locala = this.gAe;
    o localo = this.gcp;
    int i = this.dIS;
    Object localObject = u.Hc().ii(localo.hashCode() + "toast_name");
    if (localObject != null)
    {
      localObject = (View)((u.b)localObject).get("toast_view", null);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        localo.C(i, locala.h("ok", null));
        return;
      }
    }
    localo.C(i, locala.h("fail:toast can't be found", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a.1
 * JD-Core Version:    0.7.0.1
 */