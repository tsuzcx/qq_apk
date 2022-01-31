package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;

public final class e$a
{
  Layout.Alignment aMi;
  float aMj;
  int aMk;
  float aMl;
  int aMm;
  SpannableStringBuilder aPQ;
  long endTime;
  int lineType;
  long startTime;
  float width;
  
  public e$a()
  {
    reset();
  }
  
  public final e nF()
  {
    if ((this.aMl != 1.4E-45F) && (this.aMm == -2147483648))
    {
      if (this.aMi != null) {
        break label80;
      }
      this.aMm = -2147483648;
    }
    for (;;)
    {
      return new e(this.startTime, this.endTime, this.aPQ, this.aMi, this.aMj, this.lineType, this.aMk, this.aMl, this.aMm, this.width);
      label80:
      switch (e.1.aPP[this.aMi.ordinal()])
      {
      default: 
        new StringBuilder("Unrecognized alignment: ").append(this.aMi);
        this.aMm = 0;
        break;
      case 1: 
        this.aMm = 0;
        break;
      case 2: 
        this.aMm = 1;
        break;
      case 3: 
        this.aMm = 2;
      }
    }
  }
  
  public final void reset()
  {
    this.startTime = 0L;
    this.endTime = 0L;
    this.aPQ = null;
    this.aMi = null;
    this.aMj = 1.4E-45F;
    this.lineType = -2147483648;
    this.aMk = -2147483648;
    this.aMl = 1.4E-45F;
    this.aMm = -2147483648;
    this.width = 1.4E-45F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.e.a
 * JD-Core Version:    0.7.0.1
 */