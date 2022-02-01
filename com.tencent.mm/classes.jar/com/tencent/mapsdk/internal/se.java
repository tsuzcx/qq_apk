package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class se
  implements ba
{
  private final sj a;
  
  public se(sj paramsj)
  {
    this.a = paramsj;
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(224334);
    if (this.a == null)
    {
      AppMethodBeat.o(224334);
      return;
    }
    if (paramv != null) {
      this.a.a(((VectorMap)this.a.e_).o.t.a());
    }
    paramv = this.a;
    if ((paramv.B != null) && (paramv.B.getLooper().getThread().isAlive())) {
      paramv.B.sendEmptyMessage(0);
    }
    AppMethodBeat.o(224334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.se
 * JD-Core Version:    0.7.0.1
 */