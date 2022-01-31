package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.al;

final class d$d
  extends d.b
{
  private d$d(d.c paramc)
  {
    super(paramc, (byte)0);
  }
  
  private void aKx()
  {
    AppMethodBeat.i(102263);
    m.aNS().ac(new d.d.1(this));
    AppMethodBeat.o(102263);
  }
  
  public final void Ec(String paramString)
  {
    AppMethodBeat.i(102261);
    super.Ec(paramString);
    aKx();
    AppMethodBeat.o(102261);
  }
  
  public final void aID()
  {
    AppMethodBeat.i(102260);
    super.aID();
    aKx();
    AppMethodBeat.o(102260);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(102262);
    super.onCancel();
    aKx();
    AppMethodBeat.o(102262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.d
 * JD-Core Version:    0.7.0.1
 */