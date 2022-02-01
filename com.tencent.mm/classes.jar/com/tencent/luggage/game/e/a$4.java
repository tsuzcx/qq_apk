package com.tencent.luggage.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$4
  implements Runnable
{
  public a$4(a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(130693);
    if (this.clP <= 0L)
    {
      AppMethodBeat.o(130693);
      return;
    }
    for (;;)
    {
      synchronized (a.f(this.clO))
      {
        if (this.clP < 5120L)
        {
          if (a.f(this.clO).gx(0))
          {
            a.f(this.clO).put(0, a.f(this.clO).get(0) + 1);
            AppMethodBeat.o(130693);
            return;
          }
          a.f(this.clO).put(0, 1);
        }
      }
      if (this.clP < 10240L)
      {
        if (a.f(this.clO).gx(1)) {
          a.f(this.clO).put(1, a.f(this.clO).get(1) + 1);
        } else {
          a.f(this.clO).put(1, 1);
        }
      }
      else if (this.clP < 20480L)
      {
        if (a.f(this.clO).gx(2)) {
          a.f(this.clO).put(2, a.f(this.clO).get(2) + 1);
        } else {
          a.f(this.clO).put(2, 1);
        }
      }
      else if (this.clP < 51200L)
      {
        if (a.f(this.clO).gx(3)) {
          a.f(this.clO).put(3, a.f(this.clO).get(3) + 1);
        } else {
          a.f(this.clO).put(3, 1);
        }
      }
      else if (this.clP < 102400L)
      {
        if (a.f(this.clO).gx(4)) {
          a.f(this.clO).put(4, a.f(this.clO).get(4) + 1);
        } else {
          a.f(this.clO).put(4, 1);
        }
      }
      else if (this.clP < 153600L)
      {
        if (a.f(this.clO).gx(5)) {
          a.f(this.clO).put(5, a.f(this.clO).get(5) + 1);
        } else {
          a.f(this.clO).put(5, 1);
        }
      }
      else if (this.clP < 204800L)
      {
        if (a.f(this.clO).gx(6)) {
          a.f(this.clO).put(6, a.f(this.clO).get(6) + 1);
        } else {
          a.f(this.clO).put(6, 1);
        }
      }
      else if (this.clP < 512000L)
      {
        if (a.f(this.clO).gx(7)) {
          a.f(this.clO).put(7, a.f(this.clO).get(7) + 1);
        } else {
          a.f(this.clO).put(7, 1);
        }
      }
      else if (this.clP < 1048576L)
      {
        if (a.f(this.clO).gx(8)) {
          a.f(this.clO).put(8, a.f(this.clO).get(8) + 1);
        } else {
          a.f(this.clO).put(8, 1);
        }
      }
      else if (this.clP < 2097152L)
      {
        if (a.f(this.clO).gx(9)) {
          a.f(this.clO).put(9, a.f(this.clO).get(9) + 1);
        } else {
          a.f(this.clO).put(9, 1);
        }
      }
      else if (this.clP < 3145728L)
      {
        if (a.f(this.clO).gx(10)) {
          a.f(this.clO).put(10, a.f(this.clO).get(10) + 1);
        } else {
          a.f(this.clO).put(10, 1);
        }
      }
      else if (a.f(this.clO).gx(11)) {
        a.f(this.clO).put(11, a.f(this.clO).get(11) + 1);
      } else {
        a.f(this.clO).put(11, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.4
 * JD-Core Version:    0.7.0.1
 */