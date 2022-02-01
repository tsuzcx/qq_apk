package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private final c[] ciE;
  final f ciF;
  char ciG = '\000';
  char ciH = '\000';
  char[] ciI;
  int ciJ;
  float ciK;
  float ciL;
  float ciM;
  float ciN;
  float ciO;
  float ciP;
  float ciQ;
  float ciR;
  int ciS;
  int endIndex;
  int startIndex;
  
  d(c[] paramArrayOfc, f paramf)
  {
    this.ciE = paramArrayOfc;
    this.ciF = paramf;
  }
  
  static boolean a(Canvas paramCanvas, Paint paramPaint, char[] paramArrayOfChar, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(39848);
    if ((paramInt >= 0) && (paramInt < paramArrayOfChar.length))
    {
      paramCanvas.drawText(paramArrayOfChar, paramInt, 1, 0.0F, paramFloat, paramPaint);
      AppMethodBeat.o(39848);
      return true;
    }
    AppMethodBeat.o(39848);
    return false;
  }
  
  final float Kp()
  {
    AppMethodBeat.i(39846);
    Kq();
    float f = this.ciN;
    AppMethodBeat.o(39846);
    return f;
  }
  
  final void Kq()
  {
    AppMethodBeat.i(39847);
    float f = this.ciF.w(this.ciH);
    if ((this.ciN == this.ciO) && (this.ciO != f))
    {
      this.ciO = f;
      this.ciN = f;
      this.ciP = f;
    }
    AppMethodBeat.o(39847);
  }
  
  final void v(char paramChar)
  {
    int m = 0;
    AppMethodBeat.i(39845);
    this.ciH = paramChar;
    this.ciM = this.ciN;
    this.ciO = this.ciF.w(paramChar);
    this.ciP = Math.max(this.ciM, this.ciO);
    this.ciI = null;
    int k = 0;
    while (k < this.ciE.length)
    {
      Object localObject = this.ciE[k];
      paramChar = this.ciG;
      char c = this.ciH;
      TickerView.a locala = this.ciF.ciY;
      int n = ((c)localObject).u(paramChar);
      int i1 = ((c)localObject).u(c);
      if ((n < 0) || (i1 < 0))
      {
        localObject = null;
        if (localObject != null)
        {
          this.ciI = this.ciE[k].ciA;
          this.startIndex = ((c.a)localObject).startIndex;
          this.endIndex = ((c.a)localObject).endIndex;
        }
        k += 1;
      }
      else
      {
        int j;
        switch (c.1.ciC[locala.ordinal()])
        {
        default: 
          j = n;
          i = i1;
        }
        for (;;)
        {
          localObject = new c.a((c)localObject, j, i);
          break;
          if (c == 0)
          {
            i = ((c)localObject).ciA.length;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (i1 < n)
            {
              i = i1 + ((c)localObject).ciz;
              j = n;
              continue;
              i = i1;
              j = n;
              if (n < i1)
              {
                j = n + ((c)localObject).ciz;
                i = i1;
                continue;
                i = i1;
                j = n;
                if (paramChar != 0)
                {
                  i = i1;
                  j = n;
                  if (c != 0) {
                    if (i1 < n)
                    {
                      i = i1;
                      j = n;
                      if (((c)localObject).ciz - n + i1 < n - i1)
                      {
                        i = i1 + ((c)localObject).ciz;
                        j = n;
                      }
                    }
                    else
                    {
                      i = i1;
                      j = n;
                      if (n < i1)
                      {
                        i = i1;
                        j = n;
                        if (((c)localObject).ciz - i1 + n < i1 - n)
                        {
                          j = n + ((c)localObject).ciz;
                          i = i1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (this.ciI == null)
    {
      if (this.ciG == this.ciH)
      {
        this.ciI = new char[] { this.ciG };
        this.endIndex = 0;
        this.startIndex = 0;
      }
    }
    else
    {
      i = m;
      if (this.endIndex >= this.startIndex) {
        i = 1;
      }
      if (i == 0) {
        break label555;
      }
    }
    label555:
    for (int i = 1;; i = -1)
    {
      this.ciS = i;
      this.ciR = this.ciQ;
      this.ciQ = 0.0F;
      AppMethodBeat.o(39845);
      return;
      this.ciI = new char[] { this.ciG, this.ciH };
      this.startIndex = 0;
      this.endIndex = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.robinhood.ticker.d
 * JD-Core Version:    0.7.0.1
 */