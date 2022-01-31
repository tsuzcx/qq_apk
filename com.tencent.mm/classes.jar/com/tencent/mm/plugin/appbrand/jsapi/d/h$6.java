package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class h$6
  extends com.tencent.mm.plugin.appbrand.widget.input.i
{
  h$6(h paramh, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  private void aDe()
  {
    AppMethodBeat.i(123554);
    v localv = (v)this.hMF.get();
    if ((localv == null) || (localv.iuy == null))
    {
      AppMethodBeat.o(123554);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.input.h.aQF().d(localv.iuy);
    AppMethodBeat.o(123554);
  }
  
  public final void Cb(String paramString)
  {
    AppMethodBeat.i(123553);
    v localv = (v)this.hMF.get();
    if (localv == null)
    {
      AppMethodBeat.o(123553);
      return;
    }
    try
    {
      int i = this.jlk;
      h.a locala = new h.a();
      paramString = new JSONObject().put("value", e.Fq(paramString)).put("data", h.ob(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
      locala.a(localv.getRuntime().ws(), localv.hashCode()).BM(paramString.toString()).aBz();
      AppMethodBeat.o(123553);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramString });
      AppMethodBeat.o(123553);
    }
  }
  
  public final void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(123550);
    if (this.hMF.get() != null) {}
    try
    {
      paramString = e.Fq(paramString);
      paramString = new JSONObject().put("value", paramString).put("inputId", this.jlk).put("cursor", paramInt).toString();
      if (paramBoolean1) {
        ((v)this.hMF.get()).c("onKeyboardConfirm", paramString, 0);
      }
      if (!paramBoolean2) {
        ((v)this.hMF.get()).c("onKeyboardComplete", paramString, 0);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[] { bo.l(paramString) });
      }
    }
    if (!paramBoolean2) {
      aDe();
    }
    AppMethodBeat.o(123550);
  }
  
  public final void aDc()
  {
    AppMethodBeat.i(123551);
    if (this.hMF.get() != null)
    {
      int i = this.jlk;
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("inputId", Integer.valueOf(i));
      ((v)this.hMF.get()).h(this.bAX, this.hMN.j("ok", localHashMap));
      h.T(i, this.hMG);
      h.a(i, (v)this.hMF.get());
    }
    AppMethodBeat.o(123551);
  }
  
  public final void aDd()
  {
    AppMethodBeat.i(123552);
    if (this.hMF.get() != null)
    {
      ((v)this.hMF.get()).h(this.bAX, this.hMN.j("fail", null));
      aDe();
    }
    AppMethodBeat.o(123552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.h.6
 * JD-Core Version:    0.7.0.1
 */