package com.tencent.luggage.game.c;

import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.InputStream;

public abstract class g$b
{
  public static String elG = "WAGameVConsole.html";
  
  public abstract void aoZ();
  
  public abstract boolean eP(String paramString);
  
  public abstract InputStream eQ(String paramString);
  
  public final a eT(String paramString)
  {
    InputStream localInputStream = eQ(paramString);
    if (localInputStream == null) {
      return null;
    }
    return new a(MimeTypeUtil.getMimeTypeByFilePath(paramString), "UTF-8", localInputStream);
  }
  
  public final class a
  {
    public String charset;
    public InputStream elH;
    public String mimeType;
    
    a(String paramString1, String paramString2, InputStream paramInputStream)
    {
      this.mimeType = paramString1;
      this.charset = paramString2;
      this.elH = paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.g.b
 * JD-Core Version:    0.7.0.1
 */