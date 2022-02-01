package com.tencent.mm.plugin.game.commlib.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c<E extends b>
  extends CopyOnWriteArrayList<E>
{
  private Object lock;
  
  public c()
  {
    AppMethodBeat.i(89953);
    this.lock = new Object();
    AppMethodBeat.o(89953);
  }
  
  public final int b(E paramE)
  {
    AppMethodBeat.i(89954);
    Object localObject = this.lock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < size())
        {
          if (paramE.a((b)get(i)) < 0)
          {
            j = 1;
            if (j == 0) {
              i = size();
            }
            add(i, paramE);
            return i;
          }
          i += 1;
          continue;
        }
        i = 0;
      }
      finally
      {
        AppMethodBeat.o(89954);
      }
      int j = 0;
    }
  }
  
  public final int c(E paramE)
  {
    AppMethodBeat.i(89955);
    Object localObject = this.lock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < size())
        {
          if (paramE.a((b)get(i)) <= 0)
          {
            j = 1;
            if (j == 0) {
              i = size();
            }
            add(i, paramE);
            return i;
          }
          i += 1;
          continue;
        }
        i = 0;
      }
      finally
      {
        AppMethodBeat.o(89955);
      }
      int j = 0;
    }
  }
  
  public final int dk(Object paramObject)
  {
    AppMethodBeat.i(89956);
    int i = 0;
    int k;
    for (int j = 0; i < size(); j = k)
    {
      k = j;
      if (((b)get(i)).ccZ().equals(paramObject)) {
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(89956);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c.c
 * JD-Core Version:    0.7.0.1
 */