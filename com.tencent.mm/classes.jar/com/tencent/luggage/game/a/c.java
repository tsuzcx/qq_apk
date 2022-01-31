package com.tencent.luggage.game.a;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.IMBEventListener;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;

public final class c
{
  boolean bzG;
  public volatile MBRuntime bzI;
  boolean bzJ;
  boolean bzK;
  i bzL;
  c.c bzM;
  MBRuntime.IMBEventListener bzN;
  public MBRuntime.MBParams bzO;
  public final c.a bzP;
  
  public c()
  {
    AppMethodBeat.i(140332);
    this.bzJ = false;
    this.bzG = false;
    this.bzK = true;
    this.bzO = new MBRuntime.MBParams();
    this.bzP = new c.a(this, new c.2(this));
    AppMethodBeat.o(140332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.game.a.c
 * JD-Core Version:    0.7.0.1
 */