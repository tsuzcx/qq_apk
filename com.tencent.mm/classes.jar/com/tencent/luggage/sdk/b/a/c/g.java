package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/jsapi/component/service/JSContextInterfaceUtils;", "", "()V", "LOAD_JS_FILES_PORT_SCRIPT", "", "luggage-wechat-full-sdk_release"})
public final class g
{
  public static final String coZ;
  public static final g cpa;
  
  static
  {
    AppMethodBeat.i(220904);
    cpa = new g();
    coZ = "(function(global) {\n    let loadJsFilesWithOptions = global.WeixinJSContext.loadJsFilesWithOptions\n    global.WeixinJSContext.loadJsFiles = function(contextId, paths, options) {\n        if (!options) {\n            options = '{}'\n        } else if (typeof options !== 'string') {\n            options = JSON.stringify(options)\n        }\n        loadJsFilesWithOptions(contextId, paths, options)\n    }\n})(this);";
    AppMethodBeat.o(220904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.g
 * JD-Core Version:    0.7.0.1
 */