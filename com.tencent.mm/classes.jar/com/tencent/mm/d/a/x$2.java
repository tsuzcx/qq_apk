package com.tencent.mm.d.a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class x$2
  implements ComponentCallbacks2
{
  x$2(x paramx) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(113921);
    ab.i(x.access$100(), "onLowMemory");
    this.ccK.gl(2);
    ab.i(x.access$100(), "onLowMemory notification with CRITICAL end");
    AppMethodBeat.o(113921);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(113920);
    ab.i(x.access$100(), "onTrimMemory level = [%d]", new Object[] { Integer.valueOf(paramInt) });
    Integer localInteger = x.gn(paramInt);
    if (localInteger != null) {
      this.ccK.gl(localInteger.intValue());
    }
    AppMethodBeat.o(113920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.x.2
 * JD-Core Version:    0.7.0.1
 */