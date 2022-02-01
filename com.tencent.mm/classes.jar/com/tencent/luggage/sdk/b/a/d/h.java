package com.tencent.luggage.sdk.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/service/JSContextInterfaceUtils;", "", "()V", "LOAD_JS_FILES_PORT_SCRIPT", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h esU;
  public static final String esV;
  
  static
  {
    AppMethodBeat.i(220313);
    esU = new h();
    esV = "(function(global) {\n    let loadJsFilesWithOptions = global.WeixinJSContext.loadJsFilesWithOptions\n    global.WeixinJSContext.loadJsFiles = function(contextId, paths, options) {\n        if (!options) {\n            options = '{}'\n        } else if (typeof options !== 'string') {\n            options = JSON.stringify(options)\n        }\n        loadJsFilesWithOptions(contextId, paths, options)\n    }\n})(this);";
    AppMethodBeat.o(220313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.h
 * JD-Core Version:    0.7.0.1
 */