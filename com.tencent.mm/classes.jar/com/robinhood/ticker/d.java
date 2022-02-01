package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private final c[] bLI;
  final f bLJ;
  char bLK = '\000';
  char bLL = '\000';
  char[] bLM;
  int bLN;
  float bLO;
  float bLP;
  float bLQ;
  float bLR;
  float bLS;
  float bLT;
  float bLU;
  float bLV;
  int bLW;
  int endIndex;
  int startIndex;
  
  d(c[] paramArrayOfc, f paramf)
  {
    this.bLI = paramArrayOfc;
    this.bLJ = paramf;
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
    this.bLL = paramChar;
    this.bLQ = this.bLR;
    this.bLS = this.bLJ.p(paramChar);
    this.bLT = Math.max(this.bLQ, this.bLS);
    this.bLM = null;
    int k = 0;
    while (k < this.bLI.length)
    {
      Object localObject = this.bLI[k];
      paramChar = this.bLK;
      char c = this.bLL;
      TickerView.a locala = this.bLJ.bMc;
      int n = ((c)localObject).n(paramChar);
      int i1 = ((c)localObject).n(c);
      if ((n < 0) || (i1 < 0))
      {
        localObject = null;
        if (localObject != null)
        {
          this.bLM = this.bLI[k].bLE;
          this.startIndex = ((c.a)localObject).startIndex;
          this.endIndex = ((c.a)localObject).endIndex;
        }
        k += 1;
      }
      else
      {
        int j;
        switch (c.1.bLG[locala.ordinal()])
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
            i = ((c)localObject).bLE.length;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (i1 < n)
            {
              i = i1 + ((c)localObject).bLD;
              j = n;
              continue;
              i = i1;
              j = n;
              if (n < i1)
              {
                j = n + ((c)localObject).bLD;
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
                      if (((c)localObject).bLD - n + i1 < n - i1)
                      {
                        i = i1 + ((c)localObject).bLD;
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
                        if (((c)localObject).bLD - i1 + n < i1 - n)
                        {
                          j = n + ((c)localObject).bLD;
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
    if (this.bLM == null)
    {
      if (this.bLK == this.bLL)
      {
        this.bLM = new char[] { this.bLK };
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
      this.bLW = i;
      this.bLV = this.bLU;
      this.bLU = 0.0F;
      AppMethodBeat.o(39845);
      return;
      this.bLM = new char[] { this.bLK, this.bLL };
      this.startIndex = 0;
      this.endIndex = 1;
      break;
    }
  }
  
  final float yv()
  {
    AppMethodBeat.i(39846);
    yw();
    float f = this.bLR;
    AppMethodBeat.o(39846);
    return f;
  }
  
  final void yw()
  {
    AppMethodBeat.i(39847);
    float f = this.bLJ.p(this.bLL);
    if ((this.bLR == this.bLS) && (this.bLS != f))
    {
      this.bLS = f;
      this.bLR = f;
      this.bLT = f;
    }
    AppMethodBeat.o(39847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.d
 * JD-Core Version:    0.7.0.1
 */