package com.tencent.mm.plugin.expt.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashSet;

public final class a
{
  private static a zNt;
  public IListener<gh> lsH;
  HashSet<b> qnx;
  
  private a()
  {
    AppMethodBeat.i(299428);
    this.lsH = new ExptTrigger.1(this, com.tencent.mm.app.f.hfK);
    this.qnx = new HashSet();
    this.qnx.add(new e());
    this.qnx.add(new f());
    this.qnx.add(new c());
    this.qnx.add(new d());
    AppMethodBeat.o(299428);
  }
  
  public static a dNO()
  {
    AppMethodBeat.i(299422);
    if (zNt == null) {
      zNt = new a();
    }
    a locala = zNt;
    AppMethodBeat.o(299422);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.trigger.a
 * JD-Core Version:    0.7.0.1
 */