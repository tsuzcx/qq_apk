package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.sdk.platformtools.y;

final class RuntimeLoadModuleTask$a$2
  implements j.b
{
  RuntimeLoadModuleTask$a$2(RuntimeLoadModuleTask.a parama) {}
  
  public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    y.i("MicroMsg.AppBrand.RuntimeLoadModuleTask[modularizing]", "hy: prepare job progress callback, %s", new Object[] { paramWxaPkgLoadProgress.toString() });
    if (RuntimeLoadModuleTask.a.a(this.gLH) != null) {
      RuntimeLoadModuleTask.a.a(this.gLH).U(new RuntimeLoadModuleTask.WxaPkgResultProgressPair(paramWxaPkgLoadProgress));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a.2
 * JD-Core Version:    0.7.0.1
 */