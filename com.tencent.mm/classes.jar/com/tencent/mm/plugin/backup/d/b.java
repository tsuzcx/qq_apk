package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

public final class b
  extends com.tencent.mm.plugin.backup.b.d
{
  private static b jAW;
  private d jAX;
  private c jAY;
  private a jAZ;
  private com.tencent.mm.plugin.backup.c.a jBa;
  String jBb = "tickit";
  private PowerManager.WakeLock wakeLock = null;
  
  public static b aTr()
  {
    AppMethodBeat.i(17238);
    if (jAW == null)
    {
      localb = new b();
      jAW = localb;
      a(localb);
    }
    b localb = jAW;
    AppMethodBeat.o(17238);
    return localb;
  }
  
  public final void aSG()
  {
    jAW = null;
  }
  
  public final void aSM()
  {
    AppMethodBeat.i(17244);
    al.d(new b.2(this));
    AppMethodBeat.o(17244);
  }
  
  public final void aSN()
  {
    AppMethodBeat.i(17245);
    al.d(new b.3(this));
    AppMethodBeat.o(17245);
  }
  
  public final com.tencent.mm.plugin.backup.c.a aTs()
  {
    AppMethodBeat.i(17240);
    if (this.jBa == null) {
      this.jBa = new com.tencent.mm.plugin.backup.c.a();
    }
    com.tencent.mm.plugin.backup.c.a locala = this.jBa;
    AppMethodBeat.o(17240);
    return locala;
  }
  
  public final d aTt()
  {
    AppMethodBeat.i(17241);
    if (this.jAX == null) {
      this.jAX = new d();
    }
    d locald = this.jAX;
    AppMethodBeat.o(17241);
    return locald;
  }
  
  public final c aTu()
  {
    AppMethodBeat.i(17242);
    if (this.jAY == null) {
      this.jAY = new c();
    }
    c localc = this.jAY;
    AppMethodBeat.o(17242);
    return localc;
  }
  
  public final a aTv()
  {
    AppMethodBeat.i(17243);
    if (this.jAZ == null) {
      this.jAZ = new a();
    }
    a locala = this.jAZ;
    AppMethodBeat.o(17243);
    return locala;
  }
  
  public final void m(Object... paramVarArgs)
  {
    AppMethodBeat.i(17239);
    al.d(new b.1(this, (String)paramVarArgs[0]));
    AppMethodBeat.o(17239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b
 * JD-Core Version:    0.7.0.1
 */