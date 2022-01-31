package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b hHA;
  private d hHB;
  private c hHC;
  private a hHD;
  private com.tencent.mm.plugin.backup.c.a hHE;
  String hHF = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b atS()
  {
    if (hHA == null)
    {
      b localb = new b();
      hHA = localb;
      a(localb);
    }
    return hHA;
  }
  
  public final com.tencent.mm.plugin.backup.c.a atT()
  {
    if (this.hHE == null) {
      this.hHE = new com.tencent.mm.plugin.backup.c.a();
    }
    return this.hHE;
  }
  
  public final d atU()
  {
    if (this.hHB == null) {
      this.hHB = new d();
    }
    return this.hHB;
  }
  
  public final c atV()
  {
    if (this.hHC == null) {
      this.hHC = new c();
    }
    return this.hHC;
  }
  
  public final a atW()
  {
    if (this.hHD == null) {
      this.hHD = new a();
    }
    return this.hHD;
  }
  
  public final void ati()
  {
    hHA = null;
  }
  
  public final void ato()
  {
    ai.d(new b.2(this));
  }
  
  public final void atp()
  {
    ai.d(new b.3(this));
  }
  
  public final void l(Object... paramVarArgs)
  {
    ai.d(new b.1(this, (String)paramVarArgs[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b
 * JD-Core Version:    0.7.0.1
 */