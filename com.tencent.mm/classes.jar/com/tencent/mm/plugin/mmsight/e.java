package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class e
  implements ar
{
  private m mfB = new m();
  private c mfC = new e.1(this);
  private c mfD = new e.2(this);
  
  public final void bh(boolean paramBoolean)
  {
    o.Sw().a(this.mfB);
    a.udP.b(this.mfD);
    a.udP.c(this.mfC);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    o.Sw().b(this.mfB);
    a.udP.d(this.mfD);
    j.mji.ET();
    a.udP.d(this.mfC);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.e
 * JD-Core Version:    0.7.0.1
 */