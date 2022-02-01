package com.robinhood.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  private final c[] dZd;
  final f dZe;
  char dZf = '\000';
  char dZg = '\000';
  char[] dZh;
  int dZi;
  float dZj;
  float dZk;
  float dZl;
  float dZm;
  float dZn;
  float dZo;
  float dZp;
  float dZq;
  int dZr;
  int endIndex;
  int startIndex;
  
  d(c[] paramArrayOfc, f paramf)
  {
    this.dZd = paramArrayOfc;
    this.dZe = paramf;
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
  
  final float akq()
  {
    AppMethodBeat.i(39846);
    akr();
    float f = this.dZm;
    AppMethodBeat.o(39846);
    return f;
  }
  
  final void akr()
  {
    AppMethodBeat.i(39847);
    float f = this.dZe.n(this.dZg);
    if ((this.dZm == this.dZn) && (this.dZn != f))
    {
      this.dZn = f;
      this.dZm = f;
      this.dZo = f;
    }
    AppMethodBeat.o(39847);
  }
  
  final void m(char paramChar)
  {
    int m = 0;
    AppMethodBeat.i(39845);
    this.dZg = paramChar;
    this.dZl = this.dZm;
    this.dZn = this.dZe.n(paramChar);
    this.dZo = Math.max(this.dZl, this.dZn);
    this.dZh = null;
    int k = 0;
    while (k < this.dZd.length)
    {
      Object localObject = this.dZd[k];
      paramChar = this.dZf;
      char c = this.dZg;
      TickerView.a locala = this.dZe.dZx;
      int n = ((c)localObject).l(paramChar);
      int i1 = ((c)localObject).l(c);
      if ((n < 0) || (i1 < 0))
      {
        localObject = null;
        if (localObject != null)
        {
          this.dZh = this.dZd[k].dYZ;
          this.startIndex = ((c.a)localObject).startIndex;
          this.endIndex = ((c.a)localObject).endIndex;
        }
        k += 1;
      }
      else
      {
        int j;
        switch (c.1.dZb[locala.ordinal()])
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
            i = ((c)localObject).dYZ.length;
            j = n;
          }
          else
          {
            i = i1;
            j = n;
            if (i1 < n)
            {
              i = i1 + ((c)localObject).dYY;
              j = n;
              continue;
              i = i1;
              j = n;
              if (n < i1)
              {
                j = n + ((c)localObject).dYY;
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
                      if (((c)localObject).dYY - n + i1 < n - i1)
                      {
                        i = i1 + ((c)localObject).dYY;
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
                        if (((c)localObject).dYY - i1 + n < i1 - n)
                        {
                          j = n + ((c)localObject).dYY;
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
    if (this.dZh == null)
    {
      if (this.dZf == this.dZg)
      {
        this.dZh = new char[] { this.dZf };
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
      this.dZr = i;
      this.dZq = this.dZp;
      this.dZp = 0.0F;
      AppMethodBeat.o(39845);
      return;
      this.dZh = new char[] { this.dZf, this.dZg };
      this.startIndex = 0;
      this.endIndex = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.robinhood.ticker.d
 * JD-Core Version:    0.7.0.1
 */