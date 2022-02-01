package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.backup.b.d
{
  private static a myo;
  private e myp;
  private c myq;
  private b myr;
  
  public static a byd()
  {
    AppMethodBeat.i(21859);
    if (myo == null)
    {
      locala = new a();
      myo = locala;
      a(locala);
    }
    a locala = myo;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void bvO()
  {
    myo = null;
  }
  
  public final void bvU() {}
  
  public final void bvV() {}
  
  public final e bye()
  {
    AppMethodBeat.i(21861);
    if (this.myp == null) {
      this.myp = new e();
    }
    e locale = this.myp;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c byf()
  {
    AppMethodBeat.i(21862);
    if (this.myq == null) {
      this.myq = new c();
    }
    c localc = this.myq;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b byg()
  {
    AppMethodBeat.i(21863);
    if (this.myr == null) {
      this.myr = new b();
    }
    b localb = this.myr;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    byd().byg().byh();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.bs.d.aZ(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */