package com.google.android.exoplayer2.a;

public final class f$h
  extends Exception
{
  public final int errorCode;
  
  public f$h(int paramInt)
  {
    super("AudioTrack write failed: " + paramInt);
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.f.h
 * JD-Core Version:    0.7.0.1
 */