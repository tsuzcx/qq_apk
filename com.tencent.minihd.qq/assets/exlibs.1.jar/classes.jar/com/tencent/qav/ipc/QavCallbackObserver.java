package com.tencent.qav.ipc;

import android.graphics.Bitmap;
import com.tencent.qav.observer.FilterableObserver;

public class QavCallbackObserver
  extends FilterableObserver
{
  public static final int a = 10;
  public static final int b = 11;
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(String paramString) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 10: 
      a((String)paramVarArgs[0]);
      return;
    }
    a((Bitmap)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.QavCallbackObserver
 * JD-Core Version:    0.7.0.1
 */