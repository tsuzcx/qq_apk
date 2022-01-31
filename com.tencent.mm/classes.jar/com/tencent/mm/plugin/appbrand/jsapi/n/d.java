package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class d
  extends b
{
  private int bxX;
  WeakReference<e> hWK;
  private m hyA;
  
  abstract void H(JSONObject paramJSONObject);
  
  final void a(m paramm, e parame, JSONObject paramJSONObject, int paramInt)
  {
    this.hyA = paramm;
    this.hWK = new WeakReference(parame);
    this.bxX = paramInt;
    H(paramJSONObject);
  }
  
  public final View aEv()
  {
    if (this.hWK == null) {
      return null;
    }
    return ((e)this.hWK.get()).vC().iux;
  }
  
  final void aEw()
  {
    ah(AppBrandEmptyPickerView.class);
    this.jrY.setOnResultListener(new d.1(this));
    this.jrY.show();
  }
  
  final void l(String paramString, Map<String, Object> paramMap)
  {
    if ((this.hWK != null) && (this.hWK.get() != null) && (this.hyA != null)) {
      ((e)this.hWK.get()).h(this.bxX, this.hyA.j(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.d
 * JD-Core Version:    0.7.0.1
 */