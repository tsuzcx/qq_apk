package com.github.henryye.nativeiv.b;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import java.io.InputStream;

public abstract interface b
{
  public abstract a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  public abstract boolean accept(Object paramObject);
  
  public abstract String rq();
  
  public static final class a
  {
    public String errorMsg;
    public InputStream inputStream;
    
    public a() {}
    
    public a(InputStream paramInputStream)
    {
      this.inputStream = paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.b
 * JD-Core Version:    0.7.0.1
 */