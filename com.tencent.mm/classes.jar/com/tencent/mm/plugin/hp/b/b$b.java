package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(90554);
    nKa = new b("SCENE_PATCH", 0, 0);
    nKb = new b("SCENE_LOAD", 1, 1);
    nKc = new b("SCENE_CHECK", 2, 2);
    nKd = new b[] { nKa, nKb, nKc };
    AppMethodBeat.o(90554);
  }
  
  private b$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.b.b
 * JD-Core Version:    0.7.0.1
 */