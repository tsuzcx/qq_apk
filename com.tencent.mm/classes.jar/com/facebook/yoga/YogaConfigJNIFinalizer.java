package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaConfigJNIFinalizer
  extends YogaConfigJNIBase
{
  protected void finalize()
  {
    AppMethodBeat.i(192951);
    try
    {
      freeNatives();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(192951);
    }
  }
  
  public void freeNatives()
  {
    AppMethodBeat.i(192952);
    if (this.mNativePointer != 0L)
    {
      long l = this.mNativePointer;
      this.mNativePointer = 0L;
      YogaNative.jni_YGConfigFreeJNI(l);
    }
    AppMethodBeat.o(192952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaConfigJNIFinalizer
 * JD-Core Version:    0.7.0.1
 */