package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends d
  implements Runnable
{
  private final int gUo;
  private final String gUp;
  private final c gUq;
  private final c gUr;
  final c gUs;
  
  public q(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    AppMethodBeat.i(129358);
    this.gUq = new q.1(this);
    this.gUr = new q.2(this);
    this.gUs = new q.3(this);
    this.gUo = paramInt;
    this.gUp = paramString;
    AppMethodBeat.o(129358);
  }
  
  public final void avu()
  {
    AppMethodBeat.i(129360);
    super.avu();
    ab.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    AppMethodBeat.o(129360);
  }
  
  public final void run()
  {
    AppMethodBeat.i(129359);
    a(this.gUq);
    a(this.gUr);
    a(this.gUs);
    b(this.gUq);
    start();
    AppMethodBeat.o(129359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q
 * JD-Core Version:    0.7.0.1
 */