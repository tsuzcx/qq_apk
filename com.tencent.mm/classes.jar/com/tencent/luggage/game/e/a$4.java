package com.tencent.luggage.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$4
  implements Runnable
{
  public a$4(a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(130693);
    if (this.cez <= 0L)
    {
      AppMethodBeat.o(130693);
      return;
    }
    for (;;)
    {
      synchronized (a.f(this.cey))
      {
        if (this.cez < 5120L)
        {
          if (a.f(this.cey).gK(0))
          {
            a.f(this.cey).put(0, a.f(this.cey).get(0) + 1);
            AppMethodBeat.o(130693);
            return;
          }
          a.f(this.cey).put(0, 1);
        }
      }
      if (this.cez < 10240L)
      {
        if (a.f(this.cey).gK(1)) {
          a.f(this.cey).put(1, a.f(this.cey).get(1) + 1);
        } else {
          a.f(this.cey).put(1, 1);
        }
      }
      else if (this.cez < 20480L)
      {
        if (a.f(this.cey).gK(2)) {
          a.f(this.cey).put(2, a.f(this.cey).get(2) + 1);
        } else {
          a.f(this.cey).put(2, 1);
        }
      }
      else if (this.cez < 51200L)
      {
        if (a.f(this.cey).gK(3)) {
          a.f(this.cey).put(3, a.f(this.cey).get(3) + 1);
        } else {
          a.f(this.cey).put(3, 1);
        }
      }
      else if (this.cez < 102400L)
      {
        if (a.f(this.cey).gK(4)) {
          a.f(this.cey).put(4, a.f(this.cey).get(4) + 1);
        } else {
          a.f(this.cey).put(4, 1);
        }
      }
      else if (this.cez < 153600L)
      {
        if (a.f(this.cey).gK(5)) {
          a.f(this.cey).put(5, a.f(this.cey).get(5) + 1);
        } else {
          a.f(this.cey).put(5, 1);
        }
      }
      else if (this.cez < 204800L)
      {
        if (a.f(this.cey).gK(6)) {
          a.f(this.cey).put(6, a.f(this.cey).get(6) + 1);
        } else {
          a.f(this.cey).put(6, 1);
        }
      }
      else if (this.cez < 512000L)
      {
        if (a.f(this.cey).gK(7)) {
          a.f(this.cey).put(7, a.f(this.cey).get(7) + 1);
        } else {
          a.f(this.cey).put(7, 1);
        }
      }
      else if (this.cez < 1048576L)
      {
        if (a.f(this.cey).gK(8)) {
          a.f(this.cey).put(8, a.f(this.cey).get(8) + 1);
        } else {
          a.f(this.cey).put(8, 1);
        }
      }
      else if (this.cez < 2097152L)
      {
        if (a.f(this.cey).gK(9)) {
          a.f(this.cey).put(9, a.f(this.cey).get(9) + 1);
        } else {
          a.f(this.cey).put(9, 1);
        }
      }
      else if (this.cez < 3145728L)
      {
        if (a.f(this.cey).gK(10)) {
          a.f(this.cey).put(10, a.f(this.cey).get(10) + 1);
        } else {
          a.f(this.cey).put(10, 1);
        }
      }
      else if (a.f(this.cey).gK(11)) {
        a.f(this.cey).put(11, a.f(this.cey).get(11) + 1);
      } else {
        a.f(this.cey).put(11, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.4
 * JD-Core Version:    0.7.0.1
 */