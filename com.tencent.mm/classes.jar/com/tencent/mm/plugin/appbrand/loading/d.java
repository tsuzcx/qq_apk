package com.tencent.mm.plugin.appbrand.loading;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentRunnable;", "Ljava/lang/Runnable;", "index", "", "TAG", "", "(ILjava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "getIndex", "()I", "run", "", "plugin-appbrand-integration_release"})
public final class d
  implements Runnable
{
  private final String TAG;
  private final int index;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(50840);
    this.index = paramInt;
    this.TAG = paramString;
    AppMethodBeat.o(50840);
  }
  
  public final void run()
  {
    AppMethodBeat.i(50839);
    if (c.kPa.sZ(this.index)) {
      ad.w(this.TAG, "timeout, fallback to legacy logic");
    }
    AppMethodBeat.o(50839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.d
 * JD-Core Version:    0.7.0.1
 */