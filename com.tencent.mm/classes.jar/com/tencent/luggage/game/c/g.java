package com.tencent.luggage.game.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.sdk.f.d;
import java.io.InputStream;

public abstract interface g
{
  public abstract a By();
  
  public abstract void a(b paramb);
  
  public abstract void au(Context paramContext);
  
  public abstract void bO(String paramString);
  
  public abstract void destroy();
  
  public abstract View getView();
  
  public abstract void loadUrl(String paramString);
  
  public abstract void requestLayout();
  
  public abstract void setTranslationY(float paramFloat);
  
  public abstract void setVisibility(int paramInt);
  
  public static abstract interface a
  {
    public abstract void Bz();
  }
  
  public static abstract class b
  {
    public static String cck = "WAGameVConsole.html";
    
    public abstract void Bx();
    
    public abstract boolean cd(String paramString);
    
    public abstract InputStream ce(String paramString);
    
    public final a cg(String paramString)
    {
      InputStream localInputStream = ce(paramString);
      if (localInputStream == null) {
        return null;
      }
      return new a(d.aCP(paramString), "UTF-8", localInputStream);
    }
    
    public final class a
    {
      public InputStream aCO;
      public String charset;
      public String mimeType;
      
      a(String paramString1, String paramString2, InputStream paramInputStream)
      {
        this.mimeType = paramString1;
        this.charset = paramString2;
        this.aCO = paramInputStream;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.g
 * JD-Core Version:    0.7.0.1
 */