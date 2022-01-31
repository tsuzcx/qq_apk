package com.tencent.luggage.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$4
  implements Runnable
{
  public a$4(a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(140544);
    if (this.bCx <= 0L)
    {
      AppMethodBeat.o(140544);
      return;
    }
    for (;;)
    {
      synchronized (a.f(this.bCw))
      {
        if (this.bCx < 5120L)
        {
          if (a.f(this.bCw).fs(0))
          {
            a.f(this.bCw).put(0, a.f(this.bCw).get(0) + 1);
            AppMethodBeat.o(140544);
            return;
          }
          a.f(this.bCw).put(0, 1);
        }
      }
      if (this.bCx < 10240L)
      {
        if (a.f(this.bCw).fs(1)) {
          a.f(this.bCw).put(1, a.f(this.bCw).get(1) + 1);
        } else {
          a.f(this.bCw).put(1, 1);
        }
      }
      else if (this.bCx < 20480L)
      {
        if (a.f(this.bCw).fs(2)) {
          a.f(this.bCw).put(2, a.f(this.bCw).get(2) + 1);
        } else {
          a.f(this.bCw).put(2, 1);
        }
      }
      else if (this.bCx < 51200L)
      {
        if (a.f(this.bCw).fs(3)) {
          a.f(this.bCw).put(3, a.f(this.bCw).get(3) + 1);
        } else {
          a.f(this.bCw).put(3, 1);
        }
      }
      else if (this.bCx < 102400L)
      {
        if (a.f(this.bCw).fs(4)) {
          a.f(this.bCw).put(4, a.f(this.bCw).get(4) + 1);
        } else {
          a.f(this.bCw).put(4, 1);
        }
      }
      else if (this.bCx < 153600L)
      {
        if (a.f(this.bCw).fs(5)) {
          a.f(this.bCw).put(5, a.f(this.bCw).get(5) + 1);
        } else {
          a.f(this.bCw).put(5, 1);
        }
      }
      else if (this.bCx < 204800L)
      {
        if (a.f(this.bCw).fs(6)) {
          a.f(this.bCw).put(6, a.f(this.bCw).get(6) + 1);
        } else {
          a.f(this.bCw).put(6, 1);
        }
      }
      else if (this.bCx < 512000L)
      {
        if (a.f(this.bCw).fs(7)) {
          a.f(this.bCw).put(7, a.f(this.bCw).get(7) + 1);
        } else {
          a.f(this.bCw).put(7, 1);
        }
      }
      else if (this.bCx < 1048576L)
      {
        if (a.f(this.bCw).fs(8)) {
          a.f(this.bCw).put(8, a.f(this.bCw).get(8) + 1);
        } else {
          a.f(this.bCw).put(8, 1);
        }
      }
      else if (this.bCx < 2097152L)
      {
        if (a.f(this.bCw).fs(9)) {
          a.f(this.bCw).put(9, a.f(this.bCw).get(9) + 1);
        } else {
          a.f(this.bCw).put(9, 1);
        }
      }
      else if (this.bCx < 3145728L)
      {
        if (a.f(this.bCw).fs(10)) {
          a.f(this.bCw).put(10, a.f(this.bCw).get(10) + 1);
        } else {
          a.f(this.bCw).put(10, 1);
        }
      }
      else if (a.f(this.bCw).fs(11)) {
        a.f(this.bCw).put(11, a.f(this.bCw).get(11) + 1);
      } else {
        a.f(this.bCw).put(11, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.f.a.4
 * JD-Core Version:    0.7.0.1
 */