package com.tencent.matrix.hook.memory;

import android.os.Build.VERSION;
import com.tencent.matrix.hook.a;

public class WVPreAllocHook
  extends a
{
  public static final WVPreAllocHook cYu = new WVPreAllocHook();
  
  private native boolean installHooksNative(int paramInt, ClassLoader paramClassLoader, boolean paramBoolean);
  
  public final String WJ()
  {
    return "matrix-memoryhook";
  }
  
  public final boolean WK()
  {
    return true;
  }
  
  public final boolean cR(boolean paramBoolean)
  {
    return installHooksNative(Build.VERSION.SDK_INT, getClass().getClassLoader(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.hook.memory.WVPreAllocHook
 * JD-Core Version:    0.7.0.1
 */