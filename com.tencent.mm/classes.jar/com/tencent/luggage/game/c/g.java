package com.tencent.luggage.game.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.InputStream;

public abstract interface g
{
  public abstract a OS();
  
  public abstract void a(b paramb);
  
  public abstract void aC(Context paramContext);
  
  public abstract void dG(String paramString);
  
  public abstract void destroy();
  
  public abstract View getView();
  
  public abstract void loadUrl(String paramString);
  
  public abstract void requestLayout();
  
  public abstract void setTranslationY(float paramFloat);
  
  public abstract void setVisibility(int paramInt);
  
  public static abstract interface a
  {
    public abstract void OT();
  }
  
  public static abstract class b
  {
    public static String ctM = "WAGameVConsole.html";
    
    public abstract void OR();
    
    public abstract boolean dE(String paramString);
    
    public abstract InputStream dF(String paramString);
    
    public final a dI(String paramString)
    {
      InputStream localInputStream = dF(paramString);
      if (localInputStream == null) {
        return null;
      }
      return new a(MimeTypeUtil.getMimeTypeByFilePath(paramString), "UTF-8", localInputStream);
    }
    
    public final class a
    {
      public String charset;
      public InputStream ctN;
      public String mimeType;
      
      a(String paramString1, String paramString2, InputStream paramInputStream)
      {
        this.mimeType = paramString1;
        this.charset = paramString2;
        this.ctN = paramInputStream;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.g
 * JD-Core Version:    0.7.0.1
 */