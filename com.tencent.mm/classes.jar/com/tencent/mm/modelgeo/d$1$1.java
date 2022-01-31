package com.tencent.mm.modelgeo;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1, boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt, double paramDouble3, double paramDouble4, double paramDouble5) {}
  
  public final void run()
  {
    AppMethodBeat.i(78124);
    Bundle localBundle = new Bundle();
    localBundle.putString("indoor_building_floor", this.fCm.fCe.fBY);
    localBundle.putString("indoor_building_id", this.fCm.fCe.fBX);
    localBundle.putInt("indoor_building_type", this.fCm.fCe.fBZ);
    d.a(this.fCm.fCe, this.fCf, this.fCg, this.fCh, this.fCi, this.fCj, this.fCk, this.fCl, localBundle);
    AppMethodBeat.o(78124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d.1.1
 * JD-Core Version:    0.7.0.1
 */