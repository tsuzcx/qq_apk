package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.backup.b.d
{
  private static a nGh;
  private e nGi;
  private c nGj;
  private b nGk;
  
  public static a bKg()
  {
    AppMethodBeat.i(21859);
    if (nGh == null)
    {
      locala = new a();
      nGh = locala;
      a(locala);
    }
    a locala = nGh;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void bHQ()
  {
    nGh = null;
  }
  
  public final void bHW() {}
  
  public final void bHX() {}
  
  public final e bKh()
  {
    AppMethodBeat.i(21861);
    if (this.nGi == null) {
      this.nGi = new e();
    }
    e locale = this.nGi;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c bKi()
  {
    AppMethodBeat.i(21862);
    if (this.nGj == null) {
      this.nGj = new c();
    }
    c localc = this.nGj;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b bKj()
  {
    AppMethodBeat.i(21863);
    if (this.nGk == null) {
      this.nGk = new b();
    }
    b localb = this.nGk;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void o(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    bKg().bKj().bKk();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.br.d.bg(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */