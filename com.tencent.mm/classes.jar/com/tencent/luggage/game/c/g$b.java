package com.tencent.luggage.game.c;

import com.tencent.mm.sdk.f.d;
import java.io.InputStream;

public abstract class g$b
{
  public static String cjB = "WAGameVConsole.html";
  
  public abstract void CD();
  
  public abstract boolean cO(String paramString);
  
  public abstract InputStream cP(String paramString);
  
  public final a cS(String paramString)
  {
    InputStream localInputStream = cP(paramString);
    if (localInputStream == null) {
      return null;
    }
    return new a(d.aPg(paramString), "UTF-8", localInputStream);
  }
  
  public final class a
  {
    public InputStream aFw;
    public String charset;
    public String mimeType;
    
    a(String paramString1, String paramString2, InputStream paramInputStream)
    {
      this.mimeType = paramString1;
      this.charset = paramString2;
      this.aFw = paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.g.b
 * JD-Core Version:    0.7.0.1
 */