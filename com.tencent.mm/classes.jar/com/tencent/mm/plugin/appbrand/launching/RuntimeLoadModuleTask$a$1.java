package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

final class RuntimeLoadModuleTask$a$1
  implements j.c
{
  RuntimeLoadModuleTask$a$1(RuntimeLoadModuleTask.a parama) {}
  
  public final void b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    if (RuntimeLoadModuleTask.a.a(this.gLH) != null)
    {
      RuntimeLoadModuleTask.a.a(this.gLH).U(new RuntimeLoadModuleTask.WxaPkgResultProgressPair(paramWxaPkgWrappingInfo));
      RuntimeLoadModuleTask.a.b(this.gLH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a.1
 * JD-Core Version:    0.7.0.1
 */