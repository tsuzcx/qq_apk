package com.tencent.mm.plugin.extaccessories;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;

public final class b
  implements ar
{
  String dKt;
  private b.a jLM;
  
  public final void bh(boolean paramBoolean)
  {
    y.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.jLM == null) {
      this.jLM = new b.a();
    }
    a.udP.c(this.jLM);
    au.DS().k(new b.1(this), 5000L);
  }
  
  public final void bi(boolean paramBoolean)
  {
    au.Hx();
    this.dKt = c.FU();
    File localFile = new File(this.dKt);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(this.dKt + "image/spen/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
    if (this.jLM != null) {
      a.udP.d(this.jLM);
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */