package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;

public final class b
{
  private static c low = new b.1();
  
  public static void init()
  {
    a.udP.c(low);
  }
  
  public static void release()
  {
    a.udP.d(low);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b
 * JD-Core Version:    0.7.0.1
 */