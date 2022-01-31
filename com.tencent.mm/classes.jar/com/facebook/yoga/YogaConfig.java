package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaConfig
{
  public static int SPACING_TYPE = 1;
  private YogaLogger mLogger;
  long mNativePointer;
  private YogaNodeClonedFunction mNodeClonedFunction;
  
  public YogaConfig()
  {
    AppMethodBeat.i(144031);
    this.mNativePointer = jni_YGConfigNew();
    if (this.mNativePointer == 0L)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Failed to allocate native memory");
      AppMethodBeat.o(144031);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(144031);
  }
  
  private native void jni_YGConfigFree(long paramLong);
  
  private native long jni_YGConfigNew();
  
  private native void jni_YGConfigSetExperimentalFeatureEnabled(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void jni_YGConfigSetHasNodeClonedFunc(long paramLong, boolean paramBoolean);
  
  private native void jni_YGConfigSetLogger(long paramLong, Object paramObject);
  
  private native void jni_YGConfigSetPointScaleFactor(long paramLong, float paramFloat);
  
  private native void jni_YGConfigSetUseLegacyStretchBehaviour(long paramLong, boolean paramBoolean);
  
  private native void jni_YGConfigSetUseWebDefaults(long paramLong, boolean paramBoolean);
  
  protected void finalize()
  {
    AppMethodBeat.i(144032);
    try
    {
      jni_YGConfigFree(this.mNativePointer);
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(144032);
    }
  }
  
  public YogaLogger getLogger()
  {
    return this.mLogger;
  }
  
  public final void onNodeCloned(YogaNode paramYogaNode1, YogaNode paramYogaNode2, YogaNode paramYogaNode3, int paramInt)
  {
    AppMethodBeat.i(144039);
    this.mNodeClonedFunction.onNodeCloned(paramYogaNode1, paramYogaNode2, paramYogaNode3, paramInt);
    AppMethodBeat.o(144039);
  }
  
  public void setExperimentalFeatureEnabled(YogaExperimentalFeature paramYogaExperimentalFeature, boolean paramBoolean)
  {
    AppMethodBeat.i(144033);
    jni_YGConfigSetExperimentalFeatureEnabled(this.mNativePointer, paramYogaExperimentalFeature.intValue(), paramBoolean);
    AppMethodBeat.o(144033);
  }
  
  public void setLogger(YogaLogger paramYogaLogger)
  {
    AppMethodBeat.i(144037);
    this.mLogger = paramYogaLogger;
    jni_YGConfigSetLogger(this.mNativePointer, paramYogaLogger);
    AppMethodBeat.o(144037);
  }
  
  public void setOnNodeCloned(YogaNodeClonedFunction paramYogaNodeClonedFunction)
  {
    AppMethodBeat.i(144038);
    this.mNodeClonedFunction = paramYogaNodeClonedFunction;
    long l = this.mNativePointer;
    if (paramYogaNodeClonedFunction != null) {}
    for (boolean bool = true;; bool = false)
    {
      jni_YGConfigSetHasNodeClonedFunc(l, bool);
      AppMethodBeat.o(144038);
      return;
    }
  }
  
  public void setPointScaleFactor(float paramFloat)
  {
    AppMethodBeat.i(144035);
    jni_YGConfigSetPointScaleFactor(this.mNativePointer, paramFloat);
    AppMethodBeat.o(144035);
  }
  
  public void setUseLegacyStretchBehaviour(boolean paramBoolean)
  {
    AppMethodBeat.i(144036);
    jni_YGConfigSetUseLegacyStretchBehaviour(this.mNativePointer, paramBoolean);
    AppMethodBeat.o(144036);
  }
  
  public void setUseWebDefaults(boolean paramBoolean)
  {
    AppMethodBeat.i(144034);
    jni_YGConfigSetUseWebDefaults(this.mNativePointer, paramBoolean);
    AppMethodBeat.o(144034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.yoga.YogaConfig
 * JD-Core Version:    0.7.0.1
 */