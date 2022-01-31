package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$c
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(102693);
    mtM = new c("Chat", 0, 2);
    mtN = new c("Chatroom", 1, 3);
    mtO = new c("Sns", 2, 4);
    mtP = new c[] { mtM, mtN, mtO };
    AppMethodBeat.o(102693);
  }
  
  private m$c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m.c
 * JD-Core Version:    0.7.0.1
 */