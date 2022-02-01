package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
{
  public boolean fIQ;
  public int fIR;
  public int fIS;
  public int fIT;
  public int fIU;
  public int fIV;
  public int fIW;
  public int fIX;
  public int fIY;
  public int mVideoHeight;
  public int mVideoWidth;
  
  public aa()
  {
    AppMethodBeat.i(155820);
    reset();
    AppMethodBeat.o(155820);
  }
  
  public final void reset()
  {
    this.fIQ = false;
    this.mVideoHeight = 224;
    this.mVideoWidth = 288;
    this.fIR = 10;
    this.fIS = 3000000;
    this.fIT = 1;
    this.fIU = 1;
    this.fIV = 1;
    this.fIW = 0;
    this.fIX = 1;
    this.fIY = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.aa
 * JD-Core Version:    0.7.0.1
 */