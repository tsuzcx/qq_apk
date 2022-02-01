package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;

public final class a
  extends d
{
  private static a oRe;
  private e oRf;
  private c oRg;
  private b oRh;
  
  public static a cgZ()
  {
    AppMethodBeat.i(21859);
    if (oRe == null)
    {
      locala = new a();
      oRe = locala;
      a(locala);
    }
    a locala = oRe;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void ceH()
  {
    oRe = null;
  }
  
  public final void ceN() {}
  
  public final void ceO() {}
  
  public final e cha()
  {
    AppMethodBeat.i(21861);
    if (this.oRf == null) {
      this.oRf = new e();
    }
    e locale = this.oRf;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c chb()
  {
    AppMethodBeat.i(21862);
    if (this.oRg == null) {
      this.oRg = new c();
    }
    c localc = this.oRg;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b chc()
  {
    AppMethodBeat.i(21863);
    if (this.oRh == null) {
      this.oRh = new b();
    }
    b localb = this.oRh;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    cgZ().chc().chd();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.br.c.bs(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */