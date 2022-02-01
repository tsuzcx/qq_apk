package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$b
{
  public int x;
  public int y;
  public int z;
  
  public final b mS(int paramInt)
  {
    this.x = 1;
    this.y = 1;
    this.z = paramInt;
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140010);
    String str = "[" + this.x + ", " + this.y + ", " + this.z + "]";
    AppMethodBeat.o(140010);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.d.b
 * JD-Core Version:    0.7.0.1
 */