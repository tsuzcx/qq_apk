package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class IntKeyframeSet
  extends KeyframeSet
{
  private int deltaValue;
  private boolean firstTime = true;
  private int firstValue;
  private int lastValue;
  
  public IntKeyframeSet(Keyframe.IntKeyframe... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public IntKeyframeSet clone()
  {
    ArrayList localArrayList = this.mKeyframes;
    int j = this.mKeyframes.size();
    Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return new IntKeyframeSet(arrayOfIntKeyframe);
      }
      arrayOfIntKeyframe[i] = ((Keyframe.IntKeyframe)((Keyframe)localArrayList.get(i)).clone());
      i += 1;
    }
  }
  
  public int getIntValue(float paramFloat)
  {
    float f1;
    if (this.mNumKeyframes == 2)
    {
      if (this.firstTime)
      {
        this.firstTime = false;
        this.firstValue = ((Keyframe.IntKeyframe)this.mKeyframes.get(0)).getIntValue();
        this.lastValue = ((Keyframe.IntKeyframe)this.mKeyframes.get(1)).getIntValue();
        this.deltaValue = (this.lastValue - this.firstValue);
      }
      f1 = paramFloat;
      if (this.mInterpolator != null) {
        f1 = this.mInterpolator.getInterpolation(paramFloat);
      }
      if (this.mEvaluator == null) {
        return this.firstValue + (int)(this.deltaValue * f1);
      }
      return ((Number)this.mEvaluator.evaluate(f1, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
    }
    Keyframe.IntKeyframe localIntKeyframe;
    int j;
    float f2;
    float f3;
    if (paramFloat <= 0.0F)
    {
      localObject = (Keyframe.IntKeyframe)this.mKeyframes.get(0);
      localIntKeyframe = (Keyframe.IntKeyframe)this.mKeyframes.get(1);
      i = ((Keyframe.IntKeyframe)localObject).getIntValue();
      j = localIntKeyframe.getIntValue();
      f2 = ((Keyframe.IntKeyframe)localObject).getFraction();
      f3 = localIntKeyframe.getFraction();
      localObject = localIntKeyframe.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.mEvaluator == null) {
        return (int)((j - i) * paramFloat) + i;
      }
      return ((Number)this.mEvaluator.evaluate(paramFloat, Integer.valueOf(i), Integer.valueOf(j))).intValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (Keyframe.IntKeyframe)this.mKeyframes.get(this.mNumKeyframes - 2);
      localIntKeyframe = (Keyframe.IntKeyframe)this.mKeyframes.get(this.mNumKeyframes - 1);
      i = ((Keyframe.IntKeyframe)localObject).getIntValue();
      j = localIntKeyframe.getIntValue();
      f2 = ((Keyframe.IntKeyframe)localObject).getFraction();
      f3 = localIntKeyframe.getFraction();
      localObject = localIntKeyframe.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.mEvaluator == null) {
        return (int)((j - i) * paramFloat) + i;
      }
      return ((Number)this.mEvaluator.evaluate(paramFloat, Integer.valueOf(i), Integer.valueOf(j))).intValue();
    }
    Object localObject = (Keyframe.IntKeyframe)this.mKeyframes.get(0);
    int i = 1;
    for (;;)
    {
      if (i >= this.mNumKeyframes) {
        return ((Number)((Keyframe)this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).intValue();
      }
      localIntKeyframe = (Keyframe.IntKeyframe)this.mKeyframes.get(i);
      if (paramFloat < localIntKeyframe.getFraction())
      {
        Interpolator localInterpolator = localIntKeyframe.getInterpolator();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((Keyframe.IntKeyframe)localObject).getFraction()) / (localIntKeyframe.getFraction() - ((Keyframe.IntKeyframe)localObject).getFraction());
        i = ((Keyframe.IntKeyframe)localObject).getIntValue();
        j = localIntKeyframe.getIntValue();
        if (this.mEvaluator == null) {
          return (int)((j - i) * paramFloat) + i;
        }
        return ((Number)this.mEvaluator.evaluate(paramFloat, Integer.valueOf(i), Integer.valueOf(j))).intValue();
      }
      localObject = localIntKeyframe;
      i += 1;
    }
  }
  
  public Object getValue(float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.IntKeyframeSet
 * JD-Core Version:    0.7.0.1
 */