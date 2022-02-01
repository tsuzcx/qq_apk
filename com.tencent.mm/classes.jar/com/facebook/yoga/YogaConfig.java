package com.facebook.yoga;

public abstract class YogaConfig
{
  public static int SPACING_TYPE = 1;
  
  public abstract YogaLogger getLogger();
  
  abstract long getNativePointer();
  
  public abstract void setExperimentalFeatureEnabled(YogaExperimentalFeature paramYogaExperimentalFeature, boolean paramBoolean);
  
  public abstract void setLogger(YogaLogger paramYogaLogger);
  
  public abstract void setPointScaleFactor(float paramFloat);
  
  public abstract void setPrintTreeFlag(boolean paramBoolean);
  
  public abstract void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean paramBoolean);
  
  public abstract void setUseLegacyStretchBehaviour(boolean paramBoolean);
  
  public abstract void setUseWebDefaults(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaConfig
 * JD-Core Version:    0.7.0.1
 */