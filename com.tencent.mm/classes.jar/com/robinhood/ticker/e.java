package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;

final class e
{
  c[] bOa;
  private final f bOb;
  final ArrayList<d> bOp;
  Set<Character> bOq;
  
  e(f paramf)
  {
    AppMethodBeat.i(39849);
    this.bOp = new ArrayList();
    this.bOb = paramf;
    AppMethodBeat.o(39849);
  }
  
  private char[] yL()
  {
    AppMethodBeat.i(39855);
    int j = this.bOp.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((d)this.bOp.get(i)).bOc;
      i += 1;
    }
    AppMethodBeat.o(39855);
    return arrayOfChar;
  }
  
  final void b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(39850);
    if (this.bOa == null)
    {
      paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
      AppMethodBeat.o(39850);
      throw paramArrayOfChar;
    }
    int i = 0;
    while (i < this.bOp.size()) {
      if (((d)this.bOp.get(i)).yI() > 0.0F) {
        i += 1;
      } else {
        this.bOp.remove(i);
      }
    }
    int[] arrayOfInt = a.a(yL(), paramArrayOfChar, this.bOq);
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
        this.bOp.add(i, new d(this.bOa, this.bOb));
      case 0: 
        ((d)this.bOp.get(i)).o(paramArrayOfChar[k]);
        i += 1;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        ((d)this.bOp.get(i)).o('\000');
        i += 1;
      }
    }
    AppMethodBeat.o(39850);
  }
  
  final void onAnimationEnd()
  {
    AppMethodBeat.i(39851);
    int j = this.bOp.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bOp.get(i);
      locald.yJ();
      locald.bOl = locald.bOj;
      i += 1;
    }
    AppMethodBeat.o(39851);
  }
  
  final void setAnimationProgress(float paramFloat)
  {
    AppMethodBeat.i(39852);
    int j = this.bOp.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bOp.get(i);
      if (paramFloat == 1.0F)
      {
        locald.bOc = locald.bOd;
        locald.bOm = 0.0F;
        locald.bOn = 0.0F;
      }
      float f1 = locald.bOb.bOh;
      float f2 = Math.abs(locald.endIndex - locald.startIndex) * f1 * paramFloat / f1;
      float f3 = (int)f2;
      float f4 = locald.bOn;
      locald.bOg = ((f2 - f3) * f1 * locald.bOo + f4 * (1.0F - paramFloat));
      int k = locald.startIndex;
      locald.bOf = ((int)f2 * locald.bOo + k);
      locald.bOh = f1;
      locald.bOj = (locald.bOi + (locald.bOk - locald.bOi) * paramFloat);
      i += 1;
    }
    AppMethodBeat.o(39852);
  }
  
  final float yI()
  {
    AppMethodBeat.i(39854);
    float f = 0.0F;
    int j = this.bOp.size();
    int i = 0;
    while (i < j)
    {
      f += ((d)this.bOp.get(i)).yI();
      i += 1;
    }
    AppMethodBeat.o(39854);
    return f;
  }
  
  final float yK()
  {
    AppMethodBeat.i(39853);
    float f = 0.0F;
    int j = this.bOp.size();
    int i = 0;
    while (i < j)
    {
      d locald = (d)this.bOp.get(i);
      locald.yJ();
      f += locald.bOl;
      i += 1;
    }
    AppMethodBeat.o(39853);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.e
 * JD-Core Version:    0.7.0.1
 */