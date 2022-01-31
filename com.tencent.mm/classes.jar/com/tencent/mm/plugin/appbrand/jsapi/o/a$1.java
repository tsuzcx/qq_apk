package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;

final class a$1
  implements Runnable
{
  a$1(a parama, r paramr, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(74779);
    a locala = this.hXr;
    r localr = this.bAW;
    int i = this.bAX;
    Object localObject = v.aae().oP(localr.hashCode() + "toast_name");
    if (localObject != null)
    {
      localObject = (View)((v.b)localObject).get("toast_view", null);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if (t.aw((View)localObject)) {
          ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
        }
        localr.h(i, locala.j("ok", null));
        AppMethodBeat.o(74779);
        return;
      }
    }
    localr.h(i, locala.j("fail:toast can't be found", null));
    AppMethodBeat.o(74779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.1
 * JD-Core Version:    0.7.0.1
 */