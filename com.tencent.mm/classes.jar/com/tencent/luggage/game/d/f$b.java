package com.tencent.luggage.game.d;

import com.tencent.mm.sdk.f.c;
import java.io.InputStream;

public abstract class f$b
{
  public static String bAN = "WAGameVConsole.html";
  
  public abstract boolean bO(String paramString);
  
  public abstract InputStream bP(String paramString);
  
  public final f.b.a bR(String paramString)
  {
    InputStream localInputStream = bP(paramString);
    if (localInputStream == null) {
      return null;
    }
    return new f.b.a(this, c.amX(paramString), "UTF-8", localInputStream);
  }
  
  public abstract void uG();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.f.b
 * JD-Core Version:    0.7.0.1
 */