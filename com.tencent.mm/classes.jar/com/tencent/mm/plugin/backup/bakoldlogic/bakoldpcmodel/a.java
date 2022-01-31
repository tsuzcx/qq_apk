package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.backup.b.d;

public final class a
  extends d
{
  private static a hNt;
  private e hNu;
  private c hNv;
  private b hNw;
  
  public static a avr()
  {
    if (hNt == null)
    {
      a locala = new a();
      hNt = locala;
      a(locala);
    }
    return hNt;
  }
  
  public final void ati()
  {
    hNt = null;
  }
  
  public final void ato() {}
  
  public final void atp() {}
  
  public final e avs()
  {
    if (this.hNu == null) {
      this.hNu = new e();
    }
    return this.hNu;
  }
  
  public final c avt()
  {
    if (this.hNv == null) {
      this.hNv = new c();
    }
    return this.hNv;
  }
  
  public final b avu()
  {
    if (this.hNw == null) {
      this.hNw = new b();
    }
    return this.hNw;
  }
  
  public final void l(Object... paramVarArgs)
  {
    paramVarArgs = (Context)paramVarArgs[0];
    avr().avu().avv();
    com.tencent.mm.plugin.backup.g.b.clear();
    paramVarArgs.stopService(new Intent().setClassName(paramVarArgs, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a
 * JD-Core Version:    0.7.0.1
 */