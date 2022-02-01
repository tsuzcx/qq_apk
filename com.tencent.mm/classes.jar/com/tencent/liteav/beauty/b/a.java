package com.tencent.liteav.beauty.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private boolean a = false;
  
  public void a()
  {
    try
    {
      AppMethodBeat.i(15022);
      this.a = true;
      notify();
      AppMethodBeat.o(15022);
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
      AppMethodBeat.i(15023);
      while (!this.a) {
        wait();
      }
      this.a = false;
    }
    finally {}
    AppMethodBeat.o(15023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a
 * JD-Core Version:    0.7.0.1
 */