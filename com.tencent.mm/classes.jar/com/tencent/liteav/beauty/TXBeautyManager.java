package com.tencent.liteav.beauty;

import android.graphics.Bitmap;

public abstract interface TXBeautyManager
{
  public abstract void enableSharpnessEnhancement(boolean paramBoolean);
  
  public abstract void setBeautyLevel(float paramFloat);
  
  public abstract void setBeautyStyle(int paramInt);
  
  public abstract void setChinLevel(float paramFloat);
  
  public abstract void setEyeAngleLevel(float paramFloat);
  
  public abstract void setEyeDistanceLevel(float paramFloat);
  
  public abstract void setEyeLightenLevel(float paramFloat);
  
  public abstract void setEyeScaleLevel(float paramFloat);
  
  public abstract void setFaceBeautyLevel(float paramFloat);
  
  public abstract void setFaceNarrowLevel(float paramFloat);
  
  public abstract void setFaceShortLevel(float paramFloat);
  
  public abstract void setFaceSlimLevel(float paramFloat);
  
  public abstract void setFaceVLevel(float paramFloat);
  
  public abstract void setFilter(Bitmap paramBitmap);
  
  public abstract void setFilterStrength(float paramFloat);
  
  public abstract void setForeheadLevel(float paramFloat);
  
  public abstract void setGreenScreenFile(String paramString);
  
  public abstract void setLipsThicknessLevel(float paramFloat);
  
  public abstract void setMotionMute(boolean paramBoolean);
  
  public abstract void setMotionTmpl(String paramString);
  
  public abstract void setMouthShapeLevel(float paramFloat);
  
  public abstract void setNosePositionLevel(float paramFloat);
  
  public abstract void setNoseSlimLevel(float paramFloat);
  
  public abstract void setNoseWingLevel(float paramFloat);
  
  public abstract void setPounchRemoveLevel(float paramFloat);
  
  public abstract void setPreprocessor(d paramd);
  
  public abstract void setRuddyLevel(float paramFloat);
  
  public abstract void setSmileLinesRemoveLevel(float paramFloat);
  
  public abstract void setToothWhitenLevel(float paramFloat);
  
  public abstract void setWhitenessLevel(float paramFloat);
  
  public abstract void setWrinkleRemoveLevel(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.TXBeautyManager
 * JD-Core Version:    0.7.0.1
 */