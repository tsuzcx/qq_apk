package androidx.core.widget;

import android.os.Build.VERSION;

public abstract interface b
{
  public static final boolean bwp;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 27) {}
    for (boolean bool = true;; bool = false)
    {
      bwp = bool;
      return;
    }
  }
  
  public abstract void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setAutoSizeTextTypeWithDefaults(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.b
 * JD-Core Version:    0.7.0.1
 */