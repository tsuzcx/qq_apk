package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b hKr;
  private com.tencent.mm.plugin.backup.c.a hHE;
  private c hKs;
  private e hKt;
  private d hKu;
  private a hKv;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b auw()
  {
    if (hKr == null)
    {
      b localb = new b();
      hKr = localb;
      a(localb);
    }
    return hKr;
  }
  
  public final com.tencent.mm.plugin.backup.c.a atT()
  {
    if (this.hHE == null) {
      this.hHE = new com.tencent.mm.plugin.backup.c.a();
    }
    return this.hHE;
  }
  
  public final void ati()
  {
    hKr = null;
  }
  
  public final void ato()
  {
    ai.d(new b.1(this));
  }
  
  public final void atp()
  {
    ai.d(new b.2(this));
  }
  
  public final a auA()
  {
    if (this.hKv == null) {
      this.hKv = new a();
    }
    return this.hKv;
  }
  
  public final c aux()
  {
    if (this.hKs == null) {
      this.hKs = new c();
    }
    return this.hKs;
  }
  
  public final e auy()
  {
    if (this.hKt == null) {
      this.hKt = new e();
    }
    return this.hKt;
  }
  
  public final d auz()
  {
    if (this.hKu == null) {
      this.hKu = new d();
    }
    return this.hKu;
  }
  
  public final void l(Object... paramVarArgs)
  {
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = auw().aux();
    new ah(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */