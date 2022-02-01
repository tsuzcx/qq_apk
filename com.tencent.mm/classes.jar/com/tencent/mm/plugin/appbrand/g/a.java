package com.tencent.mm.plugin.appbrand.g;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.a.b;
import java.io.InputStream;
import java.util.Map;

public abstract interface a
  extends b
{
  public abstract Bitmap a(String paramString, Rect paramRect, b paramb);
  
  public abstract void a(String paramString, c paramc);
  
  public abstract void a(String paramString, Map<String, String> paramMap, c paramc);
  
  public abstract Bitmap bH(String paramString);
  
  public static abstract interface a
  {
    public abstract String Ap();
    
    public abstract void a(String paramString, Map<String, String> paramMap, a.c paramc);
    
    public abstract Bitmap b(String paramString, Rect paramRect, a.b paramb);
    
    public abstract boolean match(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void M(Bitmap paramBitmap);
  }
  
  public static abstract interface c
  {
    public abstract void z(InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.a
 * JD-Core Version:    0.7.0.1
 */