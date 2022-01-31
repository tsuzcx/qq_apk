package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.backup.b.d
{
  private static a jGV;
  private e jGW;
  private c jGX;
  private b jGY;
  
  public static a aUU()
  {
    AppMethodBeat.i(17802);
    if (jGV == null)
    {
      locala = new a();
      jGV = locala;
      a(locala);
    }
    a locala = jGV;
    AppMethodBeat.o(17802);
    return locala;
  }
  
  public final void aSG()
  {
    jGV = null;
  }
  
  public final void aSM() {}
  
  public final void aSN() {}
  
  public final e aUV()
  {
    AppMethodBeat.i(17804);
    if (this.jGW == null) {
      this.jGW = new e();
    }
    e locale = this.jGW;
    AppMethodBeat.o(17804);
    return locale;
  }
  
  public final c aUW()
  {
    AppMethodBeat.i(17805);
    if (this.jGX == null) {
      this.jGX = new c();
    }
    c localc = this.jGX;
    AppMethodBeat.o(17805);
    return localc;
  }
  
  public final b aUX()
  {
    AppMethodBeat.i(17806);
    if (this.jGY == null) {
      this.jGY = new b();
    }
    b localb = this.jGY;
    AppMethodBeat.o(17806);
    return localb;
  }
  
  public final void m(Object... paramVarArgs)
  {
    AppMethodBeat.i(17803);
    paramVarArgs = (Context)paramVarArgs[0];
    aUU().aUX().aUY();
    com.tencent.mm.plugin.backup.g.b.clear();
    com.tencent.mm.bq.d.aH(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    AppMethodBeat.o(17803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */