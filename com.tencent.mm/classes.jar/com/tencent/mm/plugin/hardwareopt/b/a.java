package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.mm.protocal.c.aoy;

public class a
{
  private static volatile a ljy = null;
  private aoy ljz = null;
  
  public static a baO()
  {
    if (ljy == null) {
      try
      {
        if (ljy == null) {
          ljy = new a();
        }
        a locala = ljy;
        return locala;
      }
      finally {}
    }
    return ljy;
  }
  
  public final aoy baP()
  {
    if (this.ljz == null) {
      this.ljz = new aoy();
    }
    return this.ljz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.b.a
 * JD-Core Version:    0.7.0.1
 */