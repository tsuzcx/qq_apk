package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  private final float azZ;
  
  static
  {
    AppMethodBeat.i(76786);
    azW = new f("LOW", 0, 0.5F);
    azX = new f("NORMAL", 1, 1.0F);
    azY = new f("HIGH", 2, 1.5F);
    aAa = new f[] { azW, azX, azY };
    AppMethodBeat.o(76786);
  }
  
  private f(float paramFloat)
  {
    this.azZ = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.bumptech.glide.f
 * JD-Core Version:    0.7.0.1
 */