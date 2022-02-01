package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private final c[] bVV;
  final f bVW;
  char bVX = '\000';
  char bVY = '\000';
  char[] bVZ;
  int bWa;
  float bWb;
  float bWc;
  float bWd;
  float bWe;
  float bWf;
  float bWg;
  float bWh;
  float bWi;
  int bWj;
  int endIndex;
  int startIndex;
  
  d(c[] paramArrayOfc, f paramf)
  {
    this.bVV = paramArrayOfc;
    this.bVW = paramf;
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
  
  final void q(char paramChar)
  {
    int m = 0;
    AppMethodBeat.i(39845);
    this.bVY = paramChar;
    this.bWd = this.bWe;
    this.bWf = this.bVW.r(paramChar);
    this.bWg = Math.max(this.bWd, this.bWf);
    this.bVZ = null;
    int k = 0;
    while (k < this.bVV.length)
    {
      Object localObject = this.bVV[k];
      paramChar = this.bVX;
      char c = this.bVY;
      TickerView.a locala = this.bVW.bWp;
      int n = ((c)localObject).p(paramChar);
      int i1 = ((c)localObject).p(c);
      if ((n < 0) || (i1 < 0))
      {
        localObject = null;
        if (localObject != null)
        {
          this.bVZ = this.bVV[k].bVR;
          this.startIndex = ((c.a)localObject).startIndex;
          this.endIndex = ((c.a)localObject).endIndex;
        }
        k += 1;
      }
      else
      {
        int j;
        switch (c.1.bVT[locala.ordinal()])
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
            i = ((c)localObject).bVR.length;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (i1 < n)
            {
              i = i1 + ((c)localObject).bVQ;
              j = n;
              continue;
              i = i1;
              j = n;
              if (n < i1)
              {
                j = n + ((c)localObject).bVQ;
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
                      if (((c)localObject).bVQ - n + i1 < n - i1)
                      {
                        i = i1 + ((c)localObject).bVQ;
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
                        if (((c)localObject).bVQ - i1 + n < i1 - n)
                        {
                          j = n + ((c)localObject).bVQ;
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
    if (this.bVZ == null)
    {
      if (this.bVX == this.bVY)
      {
        this.bVZ = new char[] { this.bVX };
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
      this.bWj = i;
      this.bWi = this.bWh;
      this.bWh = 0.0F;
      AppMethodBeat.o(39845);
      return;
      this.bVZ = new char[] { this.bVX, this.bVY };
      this.startIndex = 0;
      this.endIndex = 1;
      break;
    }
  }
  
  final float zS()
  {
    AppMethodBeat.i(39846);
    zT();
    float f = this.bWe;
    AppMethodBeat.o(39846);
    return f;
  }
  
  final void zT()
  {
    AppMethodBeat.i(39847);
    float f = this.bVW.r(this.bVY);
    if ((this.bWe == this.bWf) && (this.bWf != f))
    {
      this.bWf = f;
      this.bWe = f;
      this.bWg = f;
    }
    AppMethodBeat.o(39847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.d
 * JD-Core Version:    0.7.0.1
 */