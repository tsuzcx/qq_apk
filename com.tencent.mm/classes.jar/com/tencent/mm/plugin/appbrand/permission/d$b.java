package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;

class d$b
  implements d.c
{
  private final d.c iBJ;
  
  private d$b(d.c paramc)
  {
    this.iBJ = paramc;
  }
  
  public void Ec(String paramString)
  {
    AppMethodBeat.i(156386);
    if (this.iBJ != null) {
      this.iBJ.Ec(paramString);
    }
    AppMethodBeat.o(156386);
  }
  
  public void aID()
  {
    AppMethodBeat.i(156385);
    if (this.iBJ != null) {
      this.iBJ.aID();
    }
    AppMethodBeat.o(156385);
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(156387);
    if (this.iBJ != null) {
      this.iBJ.onCancel();
    }
    AppMethodBeat.o(156387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.b
 * JD-Core Version:    0.7.0.1
 */