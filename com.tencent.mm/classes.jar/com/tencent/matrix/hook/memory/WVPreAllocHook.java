package com.tencent.matrix.hook.memory;

import android.os.Build.VERSION;
import com.tencent.matrix.hook.a;

public class WVPreAllocHook
  extends a
{
  public static final WVPreAllocHook eVk = new WVPreAllocHook();
  
  private native boolean installHooksNative(int paramInt, ClassLoader paramClassLoader, boolean paramBoolean);
  
  public final String axH()
  {
    return "matrix-memoryhook";
  }
  
  public final boolean axI()
  {
    return true;
  }
  
  public final boolean dy(boolean paramBoolean)
  {
    return installHooksNative(Build.VERSION.SDK_INT, getClass().getClassLoader(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.hook.memory.WVPreAllocHook
 * JD-Core Version:    0.7.0.1
 */