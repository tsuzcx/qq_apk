package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Arrays;

public final class r$d
{
  public final String[] fJi = new String[9];
  
  public r$d()
  {
    Arrays.fill(this.fJi, "0");
    this.fJi[0] = ((String)g.DP().Dz().get(ac.a.usS, ""));
    this.fJi[1] = String.valueOf(g.DP().Dz().get(ac.a.usT, Long.valueOf(0L)));
    this.fJi[2] = String.valueOf(bk.UX());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.d
 * JD-Core Version:    0.7.0.1
 */