package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

final class e
{
  c[] bLI;
  private final f bLJ;
  final ArrayList<d> bLX;
  Set<Character> bLY;
  
  e(f paramf)
  {
    AppMethodBeat.i(39849);
    this.bLX = new ArrayList();
    this.bLJ = paramf;
    AppMethodBeat.o(39849);
  }
  
  private char[] yy()
  {
    AppMethodBeat.i(39855);
    int j = this.bLX.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((d)this.bLX.get(i)).bLK;
      i += 1;
    }
    AppMethodBeat.o(39855);
    return arrayOfChar;
  }
  
  final void b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(39850);
    if (this.bLI == null)
    {
      paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
      AppMethodBeat.o(39850);
      throw paramArrayOfChar;
    }
    int i = 0;
    while (i < this.bLX.size()) {
      if (((d)this.bLX.get(i)).yv() > 0.0F) {
        i += 1;
      } else {
        this.bLX.remove(i);
      }
    }
    int[] arrayOfInt = a.a(yy(), paramArrayOfChar, this.bLY);
    int j = 0;
    int k = 0;
    i = 0;
    if (j < arrayOfInt.length)
    {
      switch (arrayOfInt[j])
      {
      default: 
        paramArrayOfChar = new IllegalArgumentException("Unknown action: " + arrayOfInt[j]);
        AppMethodBeat.o(39850);
        throw paramArrayOfChar;
      case 1: 
        this.bLX.add(i, new d(this.bLI, this.bLJ));
      case 0: 
        ((d)this.bLX.get(i)).o(paramArrayOfChar[k]);
        i += 1;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        ((d)this.bLX.get(i)).o('\000');
        i += 1;
      }
    }
    AppMethodBeat.o(39850);
  }
  
  final void onAnimationEnd()
  {
    AppMethodBeat.i(39851);
    int j = this.bLX.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bLX.get(i);
      locald.yw();
      locald.bLT = locald.bLR;
      i += 1;
    }
    AppMethodBeat.o(39851);
  }
  
  final void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(39852);
    int j = this.bLX.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bLX.get(i);
      if (paramFloat == 1.0F)
      {
        locald.bLK = locald.bLL;
        locald.bLU = 0.0F;
        locald.bLV = 0.0F;
      }
      float f1 = locald.bLJ.bLP;
      float f2 = Math.abs(locald.endIndex - locald.startIndex) * f1 * paramFloat / f1;
      float f3 = (int)f2;
      float f4 = locald.bLV;
      locald.bLO = ((f2 - f3) * f1 * locald.bLW + f4 * (1.0F - paramFloat));
      int k = locald.startIndex;
      locald.bLN = ((int)f2 * locald.bLW + k);
      locald.bLP = f1;
      locald.bLR = (locald.bLQ + (locald.bLS - locald.bLQ) * paramFloat);
      i += 1;
    }
    AppMethodBeat.o(39852);
  }
  
  final float yv()
  {
    AppMethodBeat.i(39854);
    float f = 0.0F;
    int j = this.bLX.size();
    int i = 0;
    while (i < j)
    {
      f += ((d)this.bLX.get(i)).yv();
      i += 1;
    }
    AppMethodBeat.o(39854);
    return f;
  }
  
  final float yx()
  {
    AppMethodBeat.i(39853);
    float f = 0.0F;
    int j = this.bLX.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bLX.get(i);
      locald.yw();
      f += locald.bLT;
      i += 1;
    }
    AppMethodBeat.o(39853);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.e
 * JD-Core Version:    0.7.0.1
 */