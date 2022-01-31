package com.tencent.luggage.d;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$6
  implements Runnable
{
  f$6(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(90779);
    if (!((Activity)this.byY.mContext).isFinishing()) {
      this.byY.byT = m.a(this.byY.mContext.getApplicationContext(), this.byY.uj());
    }
    AppMethodBeat.o(90779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.d.f.6
 * JD-Core Version:    0.7.0.1
 */