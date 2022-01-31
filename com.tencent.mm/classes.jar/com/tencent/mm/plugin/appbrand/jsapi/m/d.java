package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class d
  extends b
{
  private int bhx;
  private i gho;
  WeakReference<e> gzJ;
  
  final void a(i parami, e parame, JSONObject paramJSONObject, int paramInt)
  {
    this.gho = parami;
    this.gzJ = new WeakReference(parame);
    this.bhx = paramInt;
    z(paramJSONObject);
  }
  
  protected final View ajS()
  {
    if (this.gzJ == null) {
      return null;
    }
    return ((e)this.gzJ.get()).agW().gVj;
  }
  
  final void ajT()
  {
    N(AppBrandEmptyPickerView.class);
    this.hzI.setOnResultListener(new d.1(this));
    this.hzI.show();
  }
  
  final void j(String paramString, Map<String, Object> paramMap)
  {
    if ((this.gzJ != null) && (this.gzJ.get() != null) && (this.gho != null)) {
      ((e)this.gzJ.get()).C(this.bhx, this.gho.h(paramString, paramMap));
    }
  }
  
  abstract void z(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.d
 * JD-Core Version:    0.7.0.1
 */