package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum JsApiLaunchMiniProgram$LaunchPreconditionTask$a
{
  public final String bjm;
  
  static
  {
    AppMethodBeat.i(131329);
    hSZ = new a("FAIL", 0, "fail");
    hTa = new a("FAIL_MORE_THAN_ONE_TASK", 1, "fail can not launch more than 1 mini program");
    hTb = new a("OK", 2, "ok");
    hTc = new a[] { hSZ, hTa, hTb };
    AppMethodBeat.o(131329);
  }
  
  private JsApiLaunchMiniProgram$LaunchPreconditionTask$a(String paramString)
  {
    this.bjm = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.LaunchPreconditionTask.a
 * JD-Core Version:    0.7.0.1
 */