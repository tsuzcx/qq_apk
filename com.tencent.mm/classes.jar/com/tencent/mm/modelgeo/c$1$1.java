package com.tencent.mm.modelgeo;

import android.os.Bundle;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt, double paramDouble3, double paramDouble4, double paramDouble5) {}
  
  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("indoor_building_floor", this.elU.elM.elG);
    localBundle.putString("indoor_building_id", this.elU.elM.elF);
    localBundle.putInt("indoor_building_type", this.elU.elM.elH);
    c.a(this.elU.elM, this.elN, this.elO, this.elP, this.elQ, this.elR, this.elS, this.elT, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c.1.1
 * JD-Core Version:    0.7.0.1
 */