package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaConfigJNIFinalizer
  extends YogaConfigJNIBase
{
  protected void finalize()
  {
    AppMethodBeat.i(207052);
    try
    {
      freeNatives();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(207052);
    }
  }
  
  public void freeNatives()
  {
    AppMethodBeat.i(207053);
    if (this.mNativePointer != 0L)
    {
      long l = this.mNativePointer;
      this.mNativePointer = 0L;
      YogaNative.jni_YGConfigFreeJNI(l);
    }
    AppMethodBeat.o(207053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.yoga.YogaConfigJNIFinalizer
 * JD-Core Version:    0.7.0.1
 */