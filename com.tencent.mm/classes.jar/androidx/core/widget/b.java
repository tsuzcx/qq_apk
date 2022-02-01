package androidx.core.widget;

import android.os.Build.VERSION;

public abstract interface b
{
  public static final boolean PX;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 27) {}
    for (boolean bool = true;; bool = false)
    {
      PX = bool;
      return;
    }
  }
  
  public abstract void setAutoSizeTextTypeWithDefaults(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.b
 * JD-Core Version:    0.7.0.1
 */