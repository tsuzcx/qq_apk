package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;

public final class b
  implements e<String>
{
  private String fWo;
  
  public final void a(com.tencent.mm.plugin.appbrand.dynamic.d.b.b paramb)
  {
    paramb.run();
  }
  
  public final void afo() {}
  
  public final int afp()
  {
    return 1;
  }
  
  public final void reset()
  {
    this.fWo = null;
  }
  
  public final boolean ti(String paramString)
  {
    if (this.fWo == null) {}
    while ((!TextUtils.isEmpty(paramString)) && (paramString.hashCode() != this.fWo.hashCode())) {
      return true;
    }
    return false;
  }
  
  public final void w(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */