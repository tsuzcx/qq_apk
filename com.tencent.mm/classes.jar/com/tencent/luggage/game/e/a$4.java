package com.tencent.luggage.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$4
  implements Runnable
{
  public a$4(a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(130693);
    if (this.eom <= 0L)
    {
      AppMethodBeat.o(130693);
      return;
    }
    for (;;)
    {
      synchronized (a.f(this.eol))
      {
        if (this.eom < 5120L)
        {
          if (a.f(this.eol).bp(0))
          {
            a.f(this.eol).put(0, a.f(this.eol).get(0) + 1);
            AppMethodBeat.o(130693);
            return;
          }
          a.f(this.eol).put(0, 1);
        }
      }
      if (this.eom < 10240L)
      {
        if (a.f(this.eol).bp(1)) {
          a.f(this.eol).put(1, a.f(this.eol).get(1) + 1);
        } else {
          a.f(this.eol).put(1, 1);
        }
      }
      else if (this.eom < 20480L)
      {
        if (a.f(this.eol).bp(2)) {
          a.f(this.eol).put(2, a.f(this.eol).get(2) + 1);
        } else {
          a.f(this.eol).put(2, 1);
        }
      }
      else if (this.eom < 51200L)
      {
        if (a.f(this.eol).bp(3)) {
          a.f(this.eol).put(3, a.f(this.eol).get(3) + 1);
        } else {
          a.f(this.eol).put(3, 1);
        }
      }
      else if (this.eom < 102400L)
      {
        if (a.f(this.eol).bp(4)) {
          a.f(this.eol).put(4, a.f(this.eol).get(4) + 1);
        } else {
          a.f(this.eol).put(4, 1);
        }
      }
      else if (this.eom < 153600L)
      {
        if (a.f(this.eol).bp(5)) {
          a.f(this.eol).put(5, a.f(this.eol).get(5) + 1);
        } else {
          a.f(this.eol).put(5, 1);
        }
      }
      else if (this.eom < 204800L)
      {
        if (a.f(this.eol).bp(6)) {
          a.f(this.eol).put(6, a.f(this.eol).get(6) + 1);
        } else {
          a.f(this.eol).put(6, 1);
        }
      }
      else if (this.eom < 512000L)
      {
        if (a.f(this.eol).bp(7)) {
          a.f(this.eol).put(7, a.f(this.eol).get(7) + 1);
        } else {
          a.f(this.eol).put(7, 1);
        }
      }
      else if (this.eom < 1048576L)
      {
        if (a.f(this.eol).bp(8)) {
          a.f(this.eol).put(8, a.f(this.eol).get(8) + 1);
        } else {
          a.f(this.eol).put(8, 1);
        }
      }
      else if (this.eom < 2097152L)
      {
        if (a.f(this.eol).bp(9)) {
          a.f(this.eol).put(9, a.f(this.eol).get(9) + 1);
        } else {
          a.f(this.eol).put(9, 1);
        }
      }
      else if (this.eom < 3145728L)
      {
        if (a.f(this.eol).bp(10)) {
          a.f(this.eol).put(10, a.f(this.eol).get(10) + 1);
        } else {
          a.f(this.eol).put(10, 1);
        }
      }
      else if (a.f(this.eol).bp(11)) {
        a.f(this.eol).put(11, a.f(this.eol).get(11) + 1);
      } else {
        a.f(this.eol).put(11, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.4
 * JD-Core Version:    0.7.0.1
 */