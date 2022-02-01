package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaNodeJNIFinalizer
  extends YogaNodeJNIBase
{
  public YogaNodeJNIFinalizer() {}
  
  public YogaNodeJNIFinalizer(YogaConfig paramYogaConfig)
  {
    super(paramYogaConfig);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(192958);
    try
    {
      freeNatives();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(192958);
    }
  }
  
  public void freeNatives()
  {
    AppMethodBeat.i(192959);
    if (this.mNativePointer != 0L)
    {
      long l = this.mNativePointer;
      this.mNativePointer = 0L;
      YogaNative.jni_YGNodeFreeJNI(l);
    }
    AppMethodBeat.o(192959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeJNIFinalizer
 * JD-Core Version:    0.7.0.1
 */