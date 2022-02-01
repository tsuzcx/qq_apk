package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;

public final class a
  extends d
{
  private static a vet;
  private e veu;
  private c vev;
  private b vew;
  
  public static a cWU()
  {
    AppMethodBeat.i(21859);
    if (vet == null)
    {
      locala = new a();
      vet = locala;
      a(locala);
    }
    a locala = vet;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void cUE()
  {
    vet = null;
  }
  
  public final void cUK() {}
  
  public final void cUL() {}
  
  public final e cWV()
  {
    AppMethodBeat.i(21861);
    if (this.veu == null) {
      this.veu = new e();
    }
    e locale = this.veu;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c cWW()
  {
    AppMethodBeat.i(21862);
    if (this.vev == null) {
      this.vev = new c();
    }
    c localc = this.vev;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b cWX()
  {
    AppMethodBeat.i(21863);
    if (this.vew == null) {
      this.vew = new b();
    }
    b localb = this.vew;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    cWU().cWX().cWY();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.br.c.bV(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */