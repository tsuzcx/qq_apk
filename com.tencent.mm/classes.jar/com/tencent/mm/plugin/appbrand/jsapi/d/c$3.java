package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class c$3
  extends w
{
  c$3(c paramc, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  private void aiX()
  {
    q localq = (q)this.gro.get();
    if ((localq == null) || (localq.gTF == null)) {
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.input.h.arM().g(localq.gTF);
  }
  
  public final void lt(int paramInt)
  {
    try
    {
      q localq = (q)this.gro.get();
      if (localq == null) {
        return;
      }
      localq.i("onKeyboardShow", com.tencent.mm.ab.h.CH().E("inputId", getInputId()).E("height", com.tencent.mm.plugin.appbrand.u.h.mx(paramInt)).toString(), 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void onBackspacePressedWhileValueNoChange(String paramString)
  {
    q localq = (q)this.gro.get();
    if (localq == null) {
      return;
    }
    try
    {
      int i = getInputId();
      f.a locala = new f.a();
      paramString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.v.c.wH(paramString)).put("data", c.lr(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
      locala.a(localq.getRuntime().Zy(), localq.hashCode()).tL(paramString.toString()).dispatch();
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramString });
    }
  }
  
  public final void onInputDone(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.gro.get() != null) {}
    try
    {
      paramString = com.tencent.mm.plugin.appbrand.v.c.wH(paramString);
      paramString = new JSONObject().put("value", paramString).put("inputId", getInputId()).put("cursor", paramInt).toString();
      if (paramBoolean1) {
        ((q)this.gro.get()).i("onKeyboardConfirm", paramString, 0);
      }
      if (!paramBoolean2) {
        ((q)this.gro.get()).i("onKeyboardComplete", paramString, 0);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { bk.j(paramString) });
      }
    }
    if (!paramBoolean2) {
      aiX();
    }
  }
  
  public final void onInputInitialized()
  {
    if (this.gro.get() != null)
    {
      int i = getInputId();
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("inputId", Integer.valueOf(i));
      ((q)this.gro.get()).C(this.dIS, this.grn.h("ok", localHashMap));
      c.I(i, this.grp);
      c.a(i, (q)this.gro.get());
    }
  }
  
  public final void onRuntimeFail()
  {
    com.tencent.mm.plugin.appbrand.v.c.aa(this);
    if (this.gro.get() != null)
    {
      ((q)this.gro.get()).C(this.dIS, this.grn.h("fail", null));
      aiX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.c.3
 * JD-Core Version:    0.7.0.1
 */