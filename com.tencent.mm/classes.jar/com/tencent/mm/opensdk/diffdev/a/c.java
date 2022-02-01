package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c
  implements Runnable
{
  c(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(3729);
    Object localObject = new ArrayList();
    ((List)localObject).addAll(a.a(this.g.f));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onQrcodeScanned();
    }
    AppMethodBeat.o(3729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.c
 * JD-Core Version:    0.7.0.1
 */