package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;

abstract class r
  extends ac
{
  public r(Context paramContext)
  {
    super(paramContext);
    super.setHorizontallyScrolling(true);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return false;
  }
  
  public final boolean coH()
  {
    return false;
  }
  
  public boolean coL()
  {
    return false;
  }
  
  public final boolean isLaidOut()
  {
    boolean bool1 = super.isLaidOut();
    if ((bool1) && (isFocusable()))
    {
      if ((getBottom() > getTop()) && (getRight() > getLeft())) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          return bool1;
        }
        try
        {
          StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
          if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length < 3)) {
            return bool1;
          }
          boolean bool2 = arrayOfStackTraceElement[2].getMethodName().equals("canTakeFocus");
          if (!bool2) {
            return bool1;
          }
          return false;
        }
        catch (Throwable localThrowable) {}
      }
    }
    return bool1;
  }
  
  public void setGravity(int paramInt)
  {
    super.setGravity(paramInt & 0xFFFFFFAF & 0xFFFFFFCF | 0x10);
  }
  
  public final void setInputType(int paramInt)
  {
    super.setInputType(0xFFFDFFFF & paramInt);
  }
  
  public final void setSingleLine(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.r
 * JD-Core Version:    0.7.0.1
 */