package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.a.a;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.plugin.appbrand.utils.j;

final class w$25
  implements a.a
{
  w$25(w paramw) {}
  
  public final void a(final Context paramContext, final f paramf, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(317225);
    if (!ao.aoz())
    {
      this.qvY.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(316720);
          j localj = j.uqy;
          j.a(paramContext, paramf, "android.permission.WRITE_EXTERNAL_STORAGE", paramRunnable1, paramRunnable2);
          AppMethodBeat.o(316720);
        }
      }, 0L);
      AppMethodBeat.o(317225);
      return;
    }
    j localj = j.uqy;
    j.a(paramContext, paramf, "android.permission.WRITE_EXTERNAL_STORAGE", paramRunnable1, paramRunnable2);
    AppMethodBeat.o(317225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.25
 * JD-Core Version:    0.7.0.1
 */