package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  Layout.Alignment aTC;
  float aTD;
  int aTE;
  float aTF;
  int aTG;
  SpannableStringBuilder aXk;
  long endTime;
  int lineType;
  long startTime;
  float width;
  
  public e$a()
  {
    AppMethodBeat.i(95726);
    reset();
    AppMethodBeat.o(95726);
  }
  
  private a qe()
  {
    AppMethodBeat.i(95728);
    if (this.aTC == null) {
      this.aTG = -2147483648;
    }
    for (;;)
    {
      AppMethodBeat.o(95728);
      return this;
      switch (e.1.aXj[this.aTC.ordinal()])
      {
      default: 
        new StringBuilder("Unrecognized alignment: ").append(this.aTC);
        this.aTG = 0;
        break;
      case 1: 
        this.aTG = 0;
        break;
      case 2: 
        this.aTG = 1;
        break;
      case 3: 
        this.aTG = 2;
      }
    }
  }
  
  public final e qd()
  {
    AppMethodBeat.i(95727);
    if ((this.aTF != 1.4E-45F) && (this.aTG == -2147483648)) {
      qe();
    }
    e locale = new e(this.startTime, this.endTime, this.aXk, this.aTC, this.aTD, this.lineType, this.aTE, this.aTF, this.aTG, this.width);
    AppMethodBeat.o(95727);
    return locale;
  }
  
  public final void reset()
  {
    this.startTime = 0L;
    this.endTime = 0L;
    this.aXk = null;
    this.aTC = null;
    this.aTD = 1.4E-45F;
    this.lineType = -2147483648;
    this.aTE = -2147483648;
    this.aTF = 1.4E-45F;
    this.aTG = -2147483648;
    this.width = 1.4E-45F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.e.a
 * JD-Core Version:    0.7.0.1
 */