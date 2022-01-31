package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;

final class b$3
  implements Runnable
{
  b$3(b paramb, b.a parama, String paramString) {}
  
  public final void run()
  {
    if (this.bze != null)
    {
      Object localObject = this.bzd.byX.executeScript(this.bhZ);
      b.a locala = this.bze;
      if (localObject == null) {}
      for (localObject = null;; localObject = localObject.toString())
      {
        locala.cB((String)localObject);
        return;
      }
    }
    this.bzd.byX.executeVoidScript(this.bhZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.b.3
 * JD-Core Version:    0.7.0.1
 */