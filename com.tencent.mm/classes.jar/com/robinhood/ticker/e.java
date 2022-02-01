package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

final class e
{
  c[] dZd;
  private final f dZe;
  final ArrayList<d> dZs;
  Set<Character> dZt;
  
  e(f paramf)
  {
    AppMethodBeat.i(39849);
    this.dZs = new ArrayList();
    this.dZe = paramf;
    AppMethodBeat.o(39849);
  }
  
  private char[] akt()
  {
    AppMethodBeat.i(39855);
    int j = this.dZs.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((d)this.dZs.get(i)).dZf;
      i += 1;
    }
    AppMethodBeat.o(39855);
    return arrayOfChar;
  }
  
  final float akq()
  {
    AppMethodBeat.i(39854);
    float f = 0.0F;
    int j = this.dZs.size();
    int i = 0;
    while (i < j)
    {
      f += ((d)this.dZs.get(i)).akq();
      i += 1;
    }
    AppMethodBeat.o(39854);
    return f;
  }
  
  final float aks()
  {
    AppMethodBeat.i(39853);
    float f = 0.0F;
    int j = this.dZs.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.dZs.get(i);
      locald.akr();
      f += locald.dZo;
      i += 1;
    }
    AppMethodBeat.o(39853);
    return f;
  }
  
  final void b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(39850);
    if (this.dZd == null)
    {
      paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
      AppMethodBeat.o(39850);
      throw paramArrayOfChar;
    }
    int i = 0;
    while (i < this.dZs.size()) {
      if (((d)this.dZs.get(i)).akq() > 0.0F) {
        i += 1;
      } else {
        this.dZs.remove(i);
      }
    }
    int[] arrayOfInt = a.a(akt(), paramArrayOfChar, this.dZt);
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
        this.dZs.add(i, new d(this.dZd, this.dZe));
      case 0: 
        ((d)this.dZs.get(i)).m(paramArrayOfChar[k]);
        i += 1;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        ((d)this.dZs.get(i)).m('\000');
        i += 1;
      }
    }
    AppMethodBeat.o(39850);
  }
  
  final void onAnimationEnd()
  {
    AppMethodBeat.i(39851);
    int j = this.dZs.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.dZs.get(i);
      locald.akr();
      locald.dZo = locald.dZm;
      i += 1;
    }
    AppMethodBeat.o(39851);
  }
  
  final void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(39852);
    int j = this.dZs.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.dZs.get(i);
      if (paramFloat == 1.0F)
      {
        locald.dZf = locald.dZg;
        locald.dZp = 0.0F;
        locald.dZq = 0.0F;
      }
      float f1 = locald.dZe.dZk;
      float f2 = Math.abs(locald.endIndex - locald.startIndex) * f1 * paramFloat / f1;
      float f3 = (int)f2;
      float f4 = locald.dZq;
      locald.dZj = ((f2 - f3) * f1 * locald.dZr + f4 * (1.0F - paramFloat));
      int k = locald.startIndex;
      locald.dZi = ((int)f2 * locald.dZr + k);
      locald.dZk = f1;
      locald.dZm = (locald.dZl + (locald.dZn - locald.dZl) * paramFloat);
      i += 1;
    }
    AppMethodBeat.o(39852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.robinhood.ticker.e
 * JD-Core Version:    0.7.0.1
 */