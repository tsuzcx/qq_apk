package com.tencent.mm.compatible.e;

public final class t
{
  public int dyA;
  public int dyB;
  public int dyC;
  public int dys;
  public int dyt;
  public int dyu;
  public int dyv;
  public int dyw;
  public int dyx;
  public int dyy;
  public int dyz;
  
  public t()
  {
    reset();
  }
  
  public final void reset()
  {
    this.dys = -1;
    this.dyt = -1;
    this.dyu = -1;
    this.dyv = -1;
    this.dyw = -1;
    this.dyx = -1;
    this.dyy = -1;
    this.dyz = -1;
    this.dyA = -1;
    this.dyB = -1;
    this.dyC = -1;
  }
  
  public final String toString()
  {
    return String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s, recorderOption: %s, useMetering: %s, transcodeEncoderType: %s, checkSendVideoBitrate: %s", new Object[] { Integer.valueOf(this.dys), Integer.valueOf(this.dyt), Integer.valueOf(this.dyu), Integer.valueOf(this.dyv), Integer.valueOf(this.dyw), Integer.valueOf(this.dyx), Integer.valueOf(this.dyy), Integer.valueOf(this.dyz), Integer.valueOf(this.dyA), Integer.valueOf(this.dyB), Integer.valueOf(this.dyC) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.t
 * JD-Core Version:    0.7.0.1
 */