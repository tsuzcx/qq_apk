package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import java.util.Collection;
import java.util.LinkedHashMap;

final class a
  extends j
{
  final long iJS;
  private String iJT;
  
  a(long paramLong)
  {
    super(AppBrandEmbedUI.class, null, null);
    this.iJS = paramLong;
  }
  
  final void EN(String paramString)
  {
    AppMethodBeat.i(132778);
    if (this.iJT.equals(paramString))
    {
      this.iLj.clear();
      this.iLk.clear();
      this.iLl = g.iKU;
      AppMethodBeat.o(132778);
      return;
    }
    super.EN(paramString);
    AppMethodBeat.o(132778);
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(132777);
    if (this.iLj.keySet().isEmpty()) {
      this.iJT = paramString;
    }
    super.a(paramString, paramInt, paramAppBrandRemoteTaskController);
    AppMethodBeat.o(132777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a
 * JD-Core Version:    0.7.0.1
 */