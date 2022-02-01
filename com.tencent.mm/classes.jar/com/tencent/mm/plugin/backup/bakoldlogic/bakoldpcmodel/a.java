package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;

public final class a
  extends d
{
  private static a rTd;
  private e rTe;
  private c rTf;
  private b rTg;
  
  public static a cuk()
  {
    AppMethodBeat.i(21859);
    if (rTd == null)
    {
      locala = new a();
      rTd = locala;
      a(locala);
    }
    a locala = rTd;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void crU()
  {
    rTd = null;
  }
  
  public final void csa() {}
  
  public final void csb() {}
  
  public final e cul()
  {
    AppMethodBeat.i(21861);
    if (this.rTe == null) {
      this.rTe = new e();
    }
    e locale = this.rTe;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c cum()
  {
    AppMethodBeat.i(21862);
    if (this.rTf == null) {
      this.rTf = new c();
    }
    c localc = this.rTf;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b cun()
  {
    AppMethodBeat.i(21863);
    if (this.rTg == null) {
      this.rTg = new b();
    }
    b localb = this.rTg;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void n(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    cuk().cun().cuo();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.by.c.bs(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */