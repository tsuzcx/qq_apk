package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.backup.b.d
{
  private static a nAM;
  private e nAN;
  private c nAO;
  private b nAP;
  
  public static a bJi()
  {
    AppMethodBeat.i(21859);
    if (nAM == null)
    {
      locala = new a();
      nAM = locala;
      a(locala);
    }
    a locala = nAM;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void bGS()
  {
    nAM = null;
  }
  
  public final void bGY() {}
  
  public final void bGZ() {}
  
  public final e bJj()
  {
    AppMethodBeat.i(21861);
    if (this.nAN == null) {
      this.nAN = new e();
    }
    e locale = this.nAN;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c bJk()
  {
    AppMethodBeat.i(21862);
    if (this.nAO == null) {
      this.nAO = new c();
    }
    c localc = this.nAO;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b bJl()
  {
    AppMethodBeat.i(21863);
    if (this.nAP == null) {
      this.nAP = new b();
    }
    b localb = this.nAP;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    bJi().bJl().bJm();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.bs.d.bf(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */