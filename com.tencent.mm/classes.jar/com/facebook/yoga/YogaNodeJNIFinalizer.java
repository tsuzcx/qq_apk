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
    AppMethodBeat.i(208195);
    try
    {
      freeNatives();
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(208195);
    }
  }
  
  public void freeNatives()
  {
    AppMethodBeat.i(208197);
    if (this.mNativePointer != 0L)
    {
      long l = this.mNativePointer;
      this.mNativePointer = 0L;
      YogaNative.jni_YGNodeFreeJNI(l);
    }
    AppMethodBeat.o(208197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeJNIFinalizer
 * JD-Core Version:    0.7.0.1
 */