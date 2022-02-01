package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private final c[] cgD;
  final f cgE;
  char cgF = '\000';
  char cgG = '\000';
  char[] cgH;
  int cgI;
  float cgJ;
  float cgK;
  float cgL;
  float cgM;
  float cgN;
  float cgO;
  float cgP;
  float cgQ;
  int cgR;
  int endIndex;
  int startIndex;
  
  d(c[] paramArrayOfc, f paramf)
  {
    this.cgD = paramArrayOfc;
    this.cgE = paramf;
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
  
  final float IM()
  {
    AppMethodBeat.i(39846);
    IN();
    float f = this.cgM;
    AppMethodBeat.o(39846);
    return f;
  }
  
  final void IN()
  {
    AppMethodBeat.i(39847);
    float f = this.cgE.r(this.cgG);
    if ((this.cgM == this.cgN) && (this.cgN != f))
    {
      this.cgN = f;
      this.cgM = f;
      this.cgO = f;
    }
    AppMethodBeat.o(39847);
  }
  
  final void q(char paramChar)
  {
    int m = 0;
    AppMethodBeat.i(39845);
    this.cgG = paramChar;
    this.cgL = this.cgM;
    this.cgN = this.cgE.r(paramChar);
    this.cgO = Math.max(this.cgL, this.cgN);
    this.cgH = null;
    int k = 0;
    while (k < this.cgD.length)
    {
      Object localObject = this.cgD[k];
      paramChar = this.cgF;
      char c = this.cgG;
      TickerView.a locala = this.cgE.cgX;
      int n = ((c)localObject).p(paramChar);
      int i1 = ((c)localObject).p(c);
      if ((n < 0) || (i1 < 0))
      {
        localObject = null;
        if (localObject != null)
        {
          this.cgH = this.cgD[k].cgz;
          this.startIndex = ((c.a)localObject).startIndex;
          this.endIndex = ((c.a)localObject).endIndex;
        }
        k += 1;
      }
      else
      {
        int j;
        switch (c.1.cgB[locala.ordinal()])
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
            i = ((c)localObject).cgz.length;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (i1 < n)
            {
              i = i1 + ((c)localObject).cgy;
              j = n;
              continue;
              i = i1;
              j = n;
              if (n < i1)
              {
                j = n + ((c)localObject).cgy;
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
                      if (((c)localObject).cgy - n + i1 < n - i1)
                      {
                        i = i1 + ((c)localObject).cgy;
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
                        if (((c)localObject).cgy - i1 + n < i1 - n)
                        {
                          j = n + ((c)localObject).cgy;
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
    if (this.cgH == null)
    {
      if (this.cgF == this.cgG)
      {
        this.cgH = new char[] { this.cgF };
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
      this.cgR = i;
      this.cgQ = this.cgP;
      this.cgP = 0.0F;
      AppMethodBeat.o(39845);
      return;
      this.cgH = new char[] { this.cgF, this.cgG };
      this.startIndex = 0;
      this.endIndex = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.d
 * JD-Core Version:    0.7.0.1
 */