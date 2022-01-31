package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

final class l$2
  implements Runnable
{
  l$2(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(113836);
    ab.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
    Object localObject = this.cbI.cbE.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((n)((Iterator)localObject).next()).cleanup();
    }
    localObject = this.cbI.Cu();
    if (localObject != null) {
      try
      {
        ((V8Context)localObject).release();
        AppMethodBeat.o(113836);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", new Object[] { localException });
      }
    }
    AppMethodBeat.o(113836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.d.a.l.2
 * JD-Core Version:    0.7.0.1
 */