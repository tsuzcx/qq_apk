package com.tencent.liteav.basic.structs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  private int priority;
  
  static
  {
    AppMethodBeat.i(238210);
    a = new c("ThreadPriorityHigh", 0, -8);
    b = new c("ThreadPriorityDefault", 1, 0);
    c = new c[] { a, b };
    AppMethodBeat.o(238210);
  }
  
  private c(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public final int a()
  {
    return this.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.c
 * JD-Core Version:    0.7.0.1
 */