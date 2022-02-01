package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
{
  public boolean gcr;
  public int gcs;
  public int gct;
  public int gcu;
  public int gcv;
  public int gcw;
  public int gcx;
  public int gcy;
  public int gcz;
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
    this.gcr = false;
    this.mVideoHeight = 224;
    this.mVideoWidth = 288;
    this.gcs = 10;
    this.gct = 3000000;
    this.gcu = 1;
    this.gcv = 1;
    this.gcw = 1;
    this.gcx = 0;
    this.gcy = 1;
    this.gcz = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.aa
 * JD-Core Version:    0.7.0.1
 */