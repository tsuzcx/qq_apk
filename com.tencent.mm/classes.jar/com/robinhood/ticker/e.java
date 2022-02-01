package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

final class e
{
  c[] ciE;
  private final f ciF;
  final ArrayList<d> ciT;
  Set<Character> ciU;
  
  e(f paramf)
  {
    AppMethodBeat.i(39849);
    this.ciT = new ArrayList();
    this.ciF = paramf;
    AppMethodBeat.o(39849);
  }
  
  private char[] Ks()
  {
    AppMethodBeat.i(39855);
    int j = this.ciT.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((d)this.ciT.get(i)).ciG;
      i += 1;
    }
    AppMethodBeat.o(39855);
    return arrayOfChar;
  }
  
  final float Kp()
  {
    AppMethodBeat.i(39854);
    float f = 0.0F;
    int j = this.ciT.size();
    int i = 0;
    while (i < j)
    {
      f += ((d)this.ciT.get(i)).Kp();
      i += 1;
    }
    AppMethodBeat.o(39854);
    return f;
  }
  
  final float Kr()
  {
    AppMethodBeat.i(39853);
    float f = 0.0F;
    int j = this.ciT.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.ciT.get(i);
      locald.Kq();
      f += locald.ciP;
      i += 1;
    }
    AppMethodBeat.o(39853);
    return f;
  }
  
  final void b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(39850);
    if (this.ciE == null)
    {
      paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
      AppMethodBeat.o(39850);
      throw paramArrayOfChar;
    }
    int i = 0;
    while (i < this.ciT.size()) {
      if (((d)this.ciT.get(i)).Kp() > 0.0F) {
        i += 1;
      } else {
        this.ciT.remove(i);
      }
    }
    int[] arrayOfInt = a.a(Ks(), paramArrayOfChar, this.ciU);
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
        this.ciT.add(i, new d(this.ciE, this.ciF));
      case 0: 
        ((d)this.ciT.get(i)).v(paramArrayOfChar[k]);
        i += 1;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        ((d)this.ciT.get(i)).v('\000');
        i += 1;
      }
    }
    AppMethodBeat.o(39850);
  }
  
  final void onAnimationEnd()
  {
    AppMethodBeat.i(39851);
    int j = this.ciT.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.ciT.get(i);
      locald.Kq();
      locald.ciP = locald.ciN;
      i += 1;
    }
    AppMethodBeat.o(39851);
  }
  
  final void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(39852);
    int j = this.ciT.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.ciT.get(i);
      if (paramFloat == 1.0F)
      {
        locald.ciG = locald.ciH;
        locald.ciQ = 0.0F;
        locald.ciR = 0.0F;
      }
      float f1 = locald.ciF.ciL;
      float f2 = Math.abs(locald.endIndex - locald.startIndex) * f1 * paramFloat / f1;
      float f3 = (int)f2;
      float f4 = locald.ciR;
      locald.ciK = ((f2 - f3) * f1 * locald.ciS + f4 * (1.0F - paramFloat));
      int k = locald.startIndex;
      locald.ciJ = ((int)f2 * locald.ciS + k);
      locald.ciL = f1;
      locald.ciN = (locald.ciM + (locald.ciO - locald.ciM) * paramFloat);
      i += 1;
    }
    AppMethodBeat.o(39852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.robinhood.ticker.e
 * JD-Core Version:    0.7.0.1
 */