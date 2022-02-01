package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(117386);
    uIe = new b("SCENE_PATCH", 0, 0);
    uIf = new b("SCENE_LOAD", 1, 1);
    uIg = new b("SCENE_CHECK", 2, 2);
    uIh = new b[] { uIe, uIf, uIg };
    AppMethodBeat.o(117386);
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