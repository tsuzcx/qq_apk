package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$b
{
  public int value = 0;
  
  static
  {
    AppMethodBeat.i(102690);
    mtG = new b("Sight", 0, 1);
    mtH = new b("AdUrl", 1, 2);
    mtI = new b("Chat", 2, 3);
    mtJ = new b("TalkChat", 3, 4);
    mtK = new b("Fav", 4, 5);
    mtL = new b[] { mtG, mtH, mtI, mtJ, mtK };
    AppMethodBeat.o(102690);
  }
  
  private m$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m.b
 * JD-Core Version:    0.7.0.1
 */