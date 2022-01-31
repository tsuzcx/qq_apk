package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements Runnable
{
  b$4(b paramb, String paramString1, b.a parama, String paramString2) {}
  
  public final void run()
  {
    y.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", new Object[] { this.bzf });
    if (this.bze != null)
    {
      Object localObject = this.bzd.byX.executeScript(this.bhZ, this.bzf, 0);
      b.a locala = this.bze;
      if (localObject == null) {}
      for (localObject = null;; localObject = localObject.toString())
      {
        locala.cB((String)localObject);
        return;
      }
    }
    this.bzd.byX.executeVoidScript(this.bhZ, this.bzf, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.b.4
 * JD-Core Version:    0.7.0.1
 */