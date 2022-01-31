package com.tencent.mm.compatible.j;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;

final class b$1
  implements a.a
{
  b$1(Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(93116);
    this.etp.putExtra("android.intent.extra.durationLimit", 30);
    this.etp.putExtra("android.intent.extra.sizeLimit", 10485760);
    AppMethodBeat.o(93116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.j.b.1
 * JD-Core Version:    0.7.0.1
 */