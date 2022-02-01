package com.tencent.luggage.game.c;

import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.InputStream;

public abstract class g$b
{
  public static String cvx = "WAGameVConsole.html";
  
  public abstract void LZ();
  
  public abstract boolean dn(String paramString);
  
  public abstract InputStream jdMethod_do(String paramString);
  
  public final a dr(String paramString)
  {
    InputStream localInputStream = jdMethod_do(paramString);
    if (localInputStream == null) {
      return null;
    }
    return new a(MimeTypeUtil.getMimeTypeByFilePath(paramString), "UTF-8", localInputStream);
  }
  
  public final class a
  {
    public InputStream aFm;
    public String charset;
    public String mimeType;
    
    a(String paramString1, String paramString2, InputStream paramInputStream)
    {
      this.mimeType = paramString1;
      this.charset = paramString2;
      this.aFm = paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.c.g.b
 * JD-Core Version:    0.7.0.1
 */