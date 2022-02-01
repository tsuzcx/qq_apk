package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private final c[] bOa;
  final f bOb;
  char bOc = '\000';
  char bOd = '\000';
  char[] bOe;
  int bOf;
  float bOg;
  float bOh;
  float bOi;
  float bOj;
  float bOk;
  float bOl;
  float bOm;
  float bOn;
  int bOo;
  int endIndex;
  int startIndex;
  
  d(c[] paramArrayOfc, f paramf)
  {
    this.bOa = paramArrayOfc;
    this.bOb = paramf;
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
  
  final void o(char paramChar)
  {
    int m = 0;
    AppMethodBeat.i(39845);
    this.bOd = paramChar;
    this.bOi = this.bOj;
    this.bOk = this.bOb.p(paramChar);
    this.bOl = Math.max(this.bOi, this.bOk);
    this.bOe = null;
    int k = 0;
    while (k < this.bOa.length)
    {
      Object localObject = this.bOa[k];
      paramChar = this.bOc;
      char c = this.bOd;
      TickerView.a locala = this.bOb.bOu;
      int n = ((c)localObject).n(paramChar);
      int i1 = ((c)localObject).n(c);
      if ((n < 0) || (i1 < 0))
      {
        localObject = null;
        if (localObject != null)
        {
          this.bOe = this.bOa[k].bNW;
          this.startIndex = ((c.a)localObject).startIndex;
          this.endIndex = ((c.a)localObject).endIndex;
        }
        k += 1;
      }
      else
      {
        int j;
        switch (c.1.bNY[locala.ordinal()])
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
            i = ((c)localObject).bNW.length;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (i1 < n)
            {
              i = i1 + ((c)localObject).bNV;
              j = n;
              continue;
              i = i1;
              j = n;
              if (n < i1)
              {
                j = n + ((c)localObject).bNV;
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
                      if (((c)localObject).bNV - n + i1 < n - i1)
                      {
                        i = i1 + ((c)localObject).bNV;
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
                        if (((c)localObject).bNV - i1 + n < i1 - n)
                        {
                          j = n + ((c)localObject).bNV;
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
    if (this.bOe == null)
    {
      if (this.bOc == this.bOd)
      {
        this.bOe = new char[] { this.bOc };
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
      this.bOo = i;
      this.bOn = this.bOm;
      this.bOm = 0.0F;
      AppMethodBeat.o(39845);
      return;
      this.bOe = new char[] { this.bOc, this.bOd };
      this.startIndex = 0;
      this.endIndex = 1;
      break;
    }
  }
  
  final float yI()
  {
    AppMethodBeat.i(39846);
    yJ();
    float f = this.bOj;
    AppMethodBeat.o(39846);
    return f;
  }
  
  final void yJ()
  {
    AppMethodBeat.i(39847);
    float f = this.bOb.p(this.bOd);
    if ((this.bOj == this.bOk) && (this.bOk != f))
    {
      this.bOk = f;
      this.bOj = f;
      this.bOl = f;
    }
    AppMethodBeat.o(39847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.d
 * JD-Core Version:    0.7.0.1
 */