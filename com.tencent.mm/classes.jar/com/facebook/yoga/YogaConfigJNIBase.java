package com.facebook.yoga;

public abstract class YogaConfigJNIBase
  extends YogaConfig
{
  private YogaLogger mLogger;
  long mNativePointer;
  
  YogaConfigJNIBase()
  {
    this(YogaNative.jni_YGConfigNewJNI());
  }
  
  private YogaConfigJNIBase(long paramLong)
  {
    if (paramLong == 0L) {
      throw new IllegalStateException("Failed to allocate native memory");
    }
    this.mNativePointer = paramLong;
  }
  
  YogaConfigJNIBase(boolean paramBoolean)
  {
    this(YogaNative.jni_YGConfigNewJNI());
  }
  
  public YogaLogger getLogger()
  {
    return this.mLogger;
  }
  
  long getNativePointer()
  {
    return this.mNativePointer;
  }
  
  public void setExperimentalFeatureEnabled(YogaExperimentalFeature paramYogaExperimentalFeature, boolean paramBoolean)
  {
    YogaNative.jni_YGConfigSetExperimentalFeatureEnabledJNI(this.mNativePointer, paramYogaExperimentalFeature.intValue(), paramBoolean);
  }
  
  public void setLogger(YogaLogger paramYogaLogger)
  {
    this.mLogger = paramYogaLogger;
    YogaNative.jni_YGConfigSetLoggerJNI(this.mNativePointer, paramYogaLogger);
  }
  
  public void setPointScaleFactor(float paramFloat)
  {
    YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.mNativePointer, paramFloat);
  }
  
  public void setPrintTreeFlag(boolean paramBoolean)
  {
    YogaNative.jni_YGConfigSetPrintTreeFlagJNI(this.mNativePointer, paramBoolean);
  }
  
  public void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean paramBoolean)
  {
    YogaNative.jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviourJNI(this.mNativePointer, paramBoolean);
  }
  
  public void setUseLegacyStretchBehaviour(boolean paramBoolean)
  {
    YogaNative.jni_YGConfigSetUseLegacyStretchBehaviourJNI(this.mNativePointer, paramBoolean);
  }
  
  public void setUseWebDefaults(boolean paramBoolean)
  {
    YogaNative.jni_YGConfigSetUseWebDefaultsJNI(this.mNativePointer, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaConfigJNIBase
 * JD-Core Version:    0.7.0.1
 */