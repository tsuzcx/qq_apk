package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/jsapi/component/service/JSContextInterfaceUtils;", "", "()V", "LOAD_JS_FILES_PORT_SCRIPT", "", "luggage-wechat-full-sdk_release"})
public final class h
{
  public static final String cBq;
  public static final h cBr;
  
  static
  {
    AppMethodBeat.i(230029);
    cBr = new h();
    cBq = "(function(global) {\n    let loadJsFilesWithOptions = global.WeixinJSContext.loadJsFilesWithOptions\n    global.WeixinJSContext.loadJsFiles = function(contextId, paths, options) {\n        if (!options) {\n            options = '{}'\n        } else if (typeof options !== 'string') {\n            options = JSON.stringify(options)\n        }\n        loadJsFilesWithOptions(contextId, paths, options)\n    }\n})(this);";
    AppMethodBeat.o(230029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.h
 * JD-Core Version:    0.7.0.1
 */