package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b jDU;
  private com.tencent.mm.plugin.backup.c.a jBa;
  private c jDV;
  private e jDW;
  private d jDX;
  private a jDY;
  private PowerManager.WakeLock wakeLock = null;
  
  public static b aTX()
  {
    AppMethodBeat.i(17490);
    if (jDU == null)
    {
      localb = new b();
      jDU = localb;
      a(localb);
    }
    b localb = jDU;
    AppMethodBeat.o(17490);
    return localb;
  }
  
  public final void aSG()
  {
    jDU = null;
  }
  
  public final void aSM()
  {
    AppMethodBeat.i(17497);
    al.d(new b.1(this));
    AppMethodBeat.o(17497);
  }
  
  public final void aSN()
  {
    AppMethodBeat.i(17498);
    al.d(new b.2(this));
    AppMethodBeat.o(17498);
  }
  
  public final c aTY()
  {
    AppMethodBeat.i(17493);
    if (this.jDV == null) {
      this.jDV = new c();
    }
    c localc = this.jDV;
    AppMethodBeat.o(17493);
    return localc;
  }
  
  public final e aTZ()
  {
    AppMethodBeat.i(17494);
    if (this.jDW == null) {
      this.jDW = new e();
    }
    e locale = this.jDW;
    AppMethodBeat.o(17494);
    return locale;
  }
  
  public final com.tencent.mm.plugin.backup.c.a aTs()
  {
    AppMethodBeat.i(17492);
    if (this.jBa == null) {
      this.jBa = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.jBa;
    AppMethodBeat.o(17492);
    return locala;
  }
  
  public final d aUa()
  {
    AppMethodBeat.i(17495);
    if (this.jDX == null) {
      this.jDX = new d();
    }
    d locald = this.jDX;
    AppMethodBeat.o(17495);
    return locald;
  }
  
  public final a aUb()
  {
    AppMethodBeat.i(17496);
    if (this.jDY == null) {
      this.jDY = new a();
    }
    a locala = this.jDY;
    AppMethodBeat.o(17496);
    return locala;
  }
  
  public final void m(Object... paramVarArgs)
  {
    AppMethodBeat.i(17491);
    ((Boolean)paramVarArgs[0]).booleanValue();
    paramVarArgs = aTX().aTY();
    new ak(Looper.getMainLooper()).postDelayed(new c.5(paramVarArgs), 100L);
    AppMethodBeat.o(17491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b
 * JD-Core Version:    0.7.0.1
 */