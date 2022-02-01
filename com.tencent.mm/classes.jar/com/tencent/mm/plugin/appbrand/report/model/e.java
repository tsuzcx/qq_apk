package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum e
{
  public Map<String, e.a> lSK;
  
  static
  {
    AppMethodBeat.i(48117);
    lSJ = new e("INSTANCE");
    lSL = new e[] { lSJ };
    AppMethodBeat.o(48117);
  }
  
  private e()
  {
    AppMethodBeat.i(48116);
    this.lSK = new HashMap();
    AppMethodBeat.o(48116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.e
 * JD-Core Version:    0.7.0.1
 */