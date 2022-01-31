package com.tencent.mm.modelgeo;

import android.os.Bundle;

final class c$2$1
  implements Runnable
{
  c$2$1(c.2 param2, boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt, double paramDouble3, double paramDouble4, double paramDouble5) {}
  
  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("indoor_building_floor", this.elV.elM.elG);
    localBundle.putString("indoor_building_id", this.elV.elM.elF);
    localBundle.putInt("indoor_building_type", this.elV.elM.elH);
    c.a(this.elV.elM, this.elN, this.elO, this.elP, this.elQ, this.elR, this.elS, this.elT, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c.2.1
 * JD-Core Version:    0.7.0.1
 */