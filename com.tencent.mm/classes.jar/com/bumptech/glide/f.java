package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  private final float aAT;
  
  static
  {
    AppMethodBeat.i(76786);
    aAQ = new f("LOW", 0, 0.5F);
    aAR = new f("NORMAL", 1, 1.0F);
    aAS = new f("HIGH", 2, 1.5F);
    aAU = new f[] { aAQ, aAR, aAS };
    AppMethodBeat.o(76786);
  }
  
  private f(float paramFloat)
  {
    this.aAT = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.bumptech.glide.f
 * JD-Core Version:    0.7.0.1
 */