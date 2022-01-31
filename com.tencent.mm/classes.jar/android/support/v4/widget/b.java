package android.support.v4.widget;

import android.os.Build.VERSION;

public abstract interface b
{
  public static final boolean IG;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 27) {}
    for (boolean bool = true;; bool = false)
    {
      IG = bool;
      return;
    }
  }
  
  public abstract void setAutoSizeTextTypeWithDefaults(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.b
 * JD-Core Version:    0.7.0.1
 */