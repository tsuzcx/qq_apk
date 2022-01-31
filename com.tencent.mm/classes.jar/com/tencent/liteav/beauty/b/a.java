package com.tencent.liteav.beauty.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private boolean a = false;
  
  public void a()
  {
    try
    {
      AppMethodBeat.i(66976);
      this.a = true;
      notify();
      AppMethodBeat.o(66976);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      AppMethodBeat.i(66977);
      while (!this.a) {
        wait();
      }
      this.a = false;
    }
    finally {}
    AppMethodBeat.o(66977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a
 * JD-Core Version:    0.7.0.1
 */