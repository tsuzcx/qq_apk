package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

final class e
{
  c[] bVV;
  private final f bVW;
  final ArrayList<d> bWk;
  Set<Character> bWl;
  
  e(f paramf)
  {
    AppMethodBeat.i(39849);
    this.bWk = new ArrayList();
    this.bVW = paramf;
    AppMethodBeat.o(39849);
  }
  
  private char[] zW()
  {
    AppMethodBeat.i(39855);
    int j = this.bWk.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((d)this.bWk.get(i)).bVX;
      i += 1;
    }
    AppMethodBeat.o(39855);
    return arrayOfChar;
  }
  
  final void b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(39850);
    if (this.bVV == null)
    {
      paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
      AppMethodBeat.o(39850);
      throw paramArrayOfChar;
    }
    int i = 0;
    while (i < this.bWk.size()) {
      if (((d)this.bWk.get(i)).zT() > 0.0F) {
        i += 1;
      } else {
        this.bWk.remove(i);
      }
    }
    int[] arrayOfInt = a.a(zW(), paramArrayOfChar, this.bWl);
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
        this.bWk.add(i, new d(this.bVV, this.bVW));
      case 0: 
        ((d)this.bWk.get(i)).q(paramArrayOfChar[k]);
        i += 1;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        ((d)this.bWk.get(i)).q('\000');
        i += 1;
      }
    }
    AppMethodBeat.o(39850);
  }
  
  final void onAnimationEnd()
  {
    AppMethodBeat.i(39851);
    int j = this.bWk.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bWk.get(i);
      locald.zU();
      locald.bWg = locald.bWe;
      i += 1;
    }
    AppMethodBeat.o(39851);
  }
  
  final void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(39852);
    int j = this.bWk.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bWk.get(i);
      if (paramFloat == 1.0F)
      {
        locald.bVX = locald.bVY;
        locald.bWh = 0.0F;
        locald.bWi = 0.0F;
      }
      float f1 = locald.bVW.bWc;
      float f2 = Math.abs(locald.endIndex - locald.startIndex) * f1 * paramFloat / f1;
      float f3 = (int)f2;
      float f4 = locald.bWi;
      locald.bWb = ((f2 - f3) * f1 * locald.bWj + f4 * (1.0F - paramFloat));
      int k = locald.startIndex;
      locald.bWa = ((int)f2 * locald.bWj + k);
      locald.bWc = f1;
      locald.bWe = (locald.bWd + (locald.bWf - locald.bWd) * paramFloat);
      i += 1;
    }
    AppMethodBeat.o(39852);
  }
  
  final float zT()
  {
    AppMethodBeat.i(39854);
    float f = 0.0F;
    int j = this.bWk.size();
    int i = 0;
    while (i < j)
    {
      f += ((d)this.bWk.get(i)).zT();
      i += 1;
    }
    AppMethodBeat.o(39854);
    return f;
  }
  
  final float zV()
  {
    AppMethodBeat.i(39853);
    float f = 0.0F;
    int j = this.bWk.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bWk.get(i);
      locald.zU();
      f += locald.bWg;
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