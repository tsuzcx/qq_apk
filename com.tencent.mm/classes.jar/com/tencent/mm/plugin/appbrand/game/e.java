package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.engine.JsClassUtils;
import com.tencent.magicbrush.engine.JsEngine;
import com.tencent.magicbrush.engine.c;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;

public final class e
  implements d
{
  int fZV;
  c fZW;
  private boolean fZX;
  
  public e(boolean paramBoolean, c paramc, int paramInt)
  {
    this.fZW = paramc;
    this.fZV = paramInt;
    this.fZX = paramBoolean;
  }
  
  public final <T extends g> T I(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(d paramd, String paramString)
  {
    if ((paramd == null) || (bk.bl(paramString)))
    {
      y.e("MicroMsg.WAGameJsContextImpl", "shareObject object name is null [%s], [%s]", new Object[] { paramd, paramString });
      return;
    }
    if (!(paramd instanceof e))
    {
      y.e("MicroMsg.WAGameJsContextImpl", "share Object with different JSContext type , [%s]", new Object[] { paramd });
      return;
    }
    c localc = this.fZW;
    paramd = ((e)paramd).fZW;
    JsEngine.pushObject(localc.bkz, paramd.bkz, paramString);
  }
  
  public final void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramURL == null) {
      evaluateJavascript(paramString, paramValueCallback);
    }
    for (;;)
    {
      return;
      if ((this.fZW == null) || (bk.bl(paramString)))
      {
        y.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[] { this.fZW, paramString });
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue("");
        }
      }
      else
      {
        c localc = this.fZW;
        paramURL = paramURL.toString();
        if (localc.bkz == 0L) {}
        for (paramURL = ""; paramValueCallback != null; paramURL = JsEngine.evaluateJavascriptFile(localc.bkz, paramString, paramURL))
        {
          paramValueCallback.onReceiveValue(bk.pm(paramURL));
          return;
        }
      }
    }
  }
  
  public final void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback)
  {
    if ((paramURL == null) || (bk.bl(paramString2))) {
      evaluateJavascript(paramString3, paramValueCallback);
    }
    for (;;)
    {
      return;
      if (this.fZW == null)
      {
        y.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[] { this.fZW, paramString3 });
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue("");
        }
      }
      else
      {
        c localc = this.fZW;
        paramURL = paramURL.toString();
        if (localc.bkz == 0L) {}
        for (paramURL = ""; paramValueCallback != null; paramURL = JsEngine.evaluateJavascriptCache(localc.bkz, paramString3, paramURL, paramString1, paramString2))
        {
          paramValueCallback.onReceiveValue(bk.pm(paramURL));
          return;
        }
      }
    }
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (this.fZW == null) {}
    c localc;
    do
    {
      return;
      localc = this.fZW;
    } while (!JsClassUtils.hasJavascriptInterface(paramObject));
    JsEngine.addJsInterface(localc.bkz, paramObject, paramString);
  }
  
  public final boolean age()
  {
    return this.fZX;
  }
  
  public final int agf()
  {
    return this.fZV;
  }
  
  public final void destroy()
  {
    if (this.fZW != null) {
      this.fZW.dispose();
    }
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if ((this.fZW == null) || (bk.bl(paramString)))
    {
      y.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[] { this.fZW, paramString });
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("");
      }
    }
    for (;;)
    {
      return;
      c localc = this.fZW;
      if (localc.bkz == 0L) {}
      for (paramString = ""; paramValueCallback != null; paramString = JsEngine.evaluateJavascript(localc.bkz, paramString))
      {
        paramValueCallback.onReceiveValue(bk.pm(paramString));
        return;
      }
    }
  }
  
  public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.i.e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e
 * JD-Core Version:    0.7.0.1
 */