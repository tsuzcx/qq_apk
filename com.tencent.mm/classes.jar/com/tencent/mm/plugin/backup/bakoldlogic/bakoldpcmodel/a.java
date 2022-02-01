package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.backup.b.d
{
  private static a nap;
  private e naq;
  private c nar;
  private b nas;
  
  public static a bEZ()
  {
    AppMethodBeat.i(21859);
    if (nap == null)
    {
      locala = new a();
      nap = locala;
      a(locala);
    }
    a locala = nap;
    AppMethodBeat.o(21859);
    return locala;
  }
  
  public final void bCK()
  {
    nap = null;
  }
  
  public final void bCQ() {}
  
  public final void bCR() {}
  
  public final e bFa()
  {
    AppMethodBeat.i(21861);
    if (this.naq == null) {
      this.naq = new e();
    }
    e locale = this.naq;
    AppMethodBeat.o(21861);
    return locale;
  }
  
  public final c bFb()
  {
    AppMethodBeat.i(21862);
    if (this.nar == null) {
      this.nar = new c();
    }
    c localc = this.nar;
    AppMethodBeat.o(21862);
    return localc;
  }
  
  public final b bFc()
  {
    AppMethodBeat.i(21863);
    if (this.nas == null) {
      this.nas = new b();
    }
    b localb = this.nas;
    AppMethodBeat.o(21863);
    return localb;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(21860);
    paramVarArgs = (Context)paramVarArgs[0];
    bEZ().bFc().bFd();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.br.d.ba(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(21860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */