package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.d;
import java.util.HashMap;

public final class n
{
  public final HashMap<Integer, n.a> gfk = new HashMap();
  
  public final void F(int paramInt, String paramString)
  {
    n.a locala = (n.a)this.gfk.remove(Integer.valueOf(paramInt));
    if (locala == null) {
      return;
    }
    int i = ((com.tencent.mm.plugin.appbrand.n)locala.gfl.getRuntime()).fzB.a(locala.gfl, locala.gfm, locala.data, false);
    long l1 = System.currentTimeMillis();
    long l2 = locala.startTime;
    com.tencent.mm.plugin.appbrand.report.model.i.a(locala.gfl.getRuntime().mAppId, locala.path, locala.gfm.getName(), locala.data, i, l1 - l2, paramString);
    this.gfk.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n
 * JD-Core Version:    0.7.0.1
 */