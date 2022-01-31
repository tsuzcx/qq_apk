package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

final class b$1$1
  implements AdapterView.OnItemClickListener
{
  b$1$1(b.1 param1, com.tencent.mm.plugin.appbrand.widget.b.b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74781);
    paramAdapterView = new HashMap();
    paramAdapterView.put("tapIndex", Integer.valueOf(paramInt));
    this.hXu.bAW.h(this.hXu.bAX, this.hXu.hXs.j("ok", paramAdapterView));
    this.hXt.dismiss();
    AppMethodBeat.o(74781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.1.1
 * JD-Core Version:    0.7.0.1
 */