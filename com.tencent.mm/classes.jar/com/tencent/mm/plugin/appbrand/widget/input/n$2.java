package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.f.a;
import com.tencent.mm.plugin.appbrand.page.q;

final class n$2
  implements Runnable
{
  n$2(q paramq, String paramString, Integer paramInteger) {}
  
  public final void run()
  {
    Object localObject = (aa)n.arR().get(this.gkf);
    if (localObject != null)
    {
      localObject = n.a(this.gkf, ((aa)localObject).getInputId());
      if (localObject != null) {
        ((z)localObject).updateValue(this.eOB, this.hug);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n.2
 * JD-Core Version:    0.7.0.1
 */