package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class b$1$1
  implements AdapterView.OnItemClickListener
{
  b$1$1(b.1 param1, com.tencent.mm.plugin.appbrand.widget.b.b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new HashMap();
    paramAdapterView.put("tapIndex", Integer.valueOf(paramInt));
    this.gAh.gcp.C(this.gAh.dIS, this.gAh.gAf.h("ok", paramAdapterView));
    this.gAg.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.b.1.1
 * JD-Core Version:    0.7.0.1
 */