package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

final class e
{
  c[] cgD;
  private final f cgE;
  final ArrayList<d> cgS;
  Set<Character> cgT;
  
  e(f paramf)
  {
    AppMethodBeat.i(39849);
    this.cgS = new ArrayList();
    this.cgE = paramf;
    AppMethodBeat.o(39849);
  }
  
  private char[] IP()
  {
    AppMethodBeat.i(39855);
    int j = this.cgS.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((d)this.cgS.get(i)).cgF;
      i += 1;
    }
    AppMethodBeat.o(39855);
    return arrayOfChar;
  }
  
  final float IM()
  {
    AppMethodBeat.i(39854);
    float f = 0.0F;
    int j = this.cgS.size();
    int i = 0;
    while (i < j)
    {
      f += ((d)this.cgS.get(i)).IM();
      i += 1;
    }
    AppMethodBeat.o(39854);
    return f;
  }
  
  final float IO()
  {
    AppMethodBeat.i(39853);
    float f = 0.0F;
    int j = this.cgS.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.cgS.get(i);
      locald.IN();
      f += locald.cgO;
      i += 1;
    }
    AppMethodBeat.o(39853);
    return f;
  }
  
  final void b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(39850);
    if (this.cgD == null)
    {
      paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
      AppMethodBeat.o(39850);
      throw paramArrayOfChar;
    }
    int i = 0;
    while (i < this.cgS.size()) {
      if (((d)this.cgS.get(i)).IM() > 0.0F) {
        i += 1;
      } else {
        this.cgS.remove(i);
      }
    }
    int[] arrayOfInt = a.a(IP(), paramArrayOfChar, this.cgT);
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
        this.cgS.add(i, new d(this.cgD, this.cgE));
      case 0: 
        ((d)this.cgS.get(i)).q(paramArrayOfChar[k]);
        i += 1;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        ((d)this.cgS.get(i)).q('\000');
        i += 1;
      }
    }
    AppMethodBeat.o(39850);
  }
  
  final void onAnimationEnd()
  {
    AppMethodBeat.i(39851);
    int j = this.cgS.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.cgS.get(i);
      locald.IN();
      locald.cgO = locald.cgM;
      i += 1;
    }
    AppMethodBeat.o(39851);
  }
  
  final void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(39852);
    int j = this.cgS.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.cgS.get(i);
      if (paramFloat == 1.0F)
      {
        locald.cgF = locald.cgG;
        locald.cgP = 0.0F;
        locald.cgQ = 0.0F;
      }
      float f1 = locald.cgE.cgK;
      float f2 = Math.abs(locald.endIndex - locald.startIndex) * f1 * paramFloat / f1;
      float f3 = (int)f2;
      float f4 = locald.cgQ;
      locald.cgJ = ((f2 - f3) * f1 * locald.cgR + f4 * (1.0F - paramFloat));
      int k = locald.startIndex;
      locald.cgI = ((int)f2 * locald.cgR + k);
      locald.cgK = f1;
      locald.cgM = (locald.cgL + (locald.cgN - locald.cgL) * paramFloat);
      i += 1;
    }
    AppMethodBeat.o(39852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.e
 * JD-Core Version:    0.7.0.1
 */