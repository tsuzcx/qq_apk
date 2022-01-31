package com.tencent.mm.plugin.auto.a;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class b
  implements ar
{
  private a hEZ = new a();
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
    a locala = this.hEZ;
    com.tencent.mm.sdk.b.a.udP.c(locala.hEX);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
    a locala = this.hEZ;
    com.tencent.mm.sdk.b.a.udP.d(locala.hEX);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.b
 * JD-Core Version:    0.7.0.1
 */