package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet
{
  TypeEvaluator mEvaluator;
  Keyframe mFirstKeyframe;
  Interpolator mInterpolator;
  ArrayList<Keyframe> mKeyframes;
  Keyframe mLastKeyframe;
  int mNumKeyframes;
  
  public KeyframeSet(Keyframe... paramVarArgs)
  {
    this.mNumKeyframes = paramVarArgs.length;
    this.mKeyframes = new ArrayList();
    this.mKeyframes.addAll(Arrays.asList(paramVarArgs));
    this.mFirstKeyframe = ((Keyframe)this.mKeyframes.get(0));
    this.mLastKeyframe = ((Keyframe)this.mKeyframes.get(this.mNumKeyframes - 1));
    this.mInterpolator = this.mLastKeyframe.getInterpolator();
  }
  
  public static KeyframeSet ofFloat(float... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfFloatKeyframe[0] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0F));
      arrayOfFloatKeyframe[1] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new FloatKeyframeSet(arrayOfFloatKeyframe);
      arrayOfFloatKeyframe[0] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0F, paramVarArgs[0]));
      int i = 1;
      while (i < j)
      {
        arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)Keyframe.ofFloat(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static KeyframeSet ofInt(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe.IntKeyframe[] arrayOfIntKeyframe = new Keyframe.IntKeyframe[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfIntKeyframe[0] = ((Keyframe.IntKeyframe)Keyframe.ofInt(0.0F));
      arrayOfIntKeyframe[1] = ((Keyframe.IntKeyframe)Keyframe.ofInt(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new IntKeyframeSet(arrayOfIntKeyframe);
      arrayOfIntKeyframe[0] = ((Keyframe.IntKeyframe)Keyframe.ofInt(0.0F, paramVarArgs[0]));
      int i = 1;
      while (i < j)
      {
        arrayOfIntKeyframe[i] = ((Keyframe.IntKeyframe)Keyframe.ofInt(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static KeyframeSet ofKeyframe(Keyframe... paramVarArgs)
  {
    int n = paramVarArgs.length;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject;
    if (i >= n)
    {
      if ((m != 0) && (k == 0) && (j == 0))
      {
        localObject = new Keyframe.FloatKeyframe[n];
        i = 0;
      }
    }
    else {
      for (;;)
      {
        if (i >= n)
        {
          return new FloatKeyframeSet((Keyframe.FloatKeyframe[])localObject);
          if ((paramVarArgs[i] instanceof Keyframe.FloatKeyframe)) {
            m = 1;
          }
          for (;;)
          {
            i += 1;
            break;
            if ((paramVarArgs[i] instanceof Keyframe.IntKeyframe)) {
              k = 1;
            } else {
              j = 1;
            }
          }
        }
        localObject[i] = ((Keyframe.FloatKeyframe)paramVarArgs[i]);
        i += 1;
      }
    }
    if ((k != 0) && (m == 0) && (j == 0))
    {
      localObject = new Keyframe.IntKeyframe[n];
      i = 0;
      for (;;)
      {
        if (i >= n) {
          return new IntKeyframeSet((Keyframe.IntKeyframe[])localObject);
        }
        localObject[i] = ((Keyframe.IntKeyframe)paramVarArgs[i]);
        i += 1;
      }
    }
    return new KeyframeSet(paramVarArgs);
  }
  
  public static KeyframeSet ofObject(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    Keyframe.ObjectKeyframe[] arrayOfObjectKeyframe = new Keyframe.ObjectKeyframe[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfObjectKeyframe[0] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0F));
      arrayOfObjectKeyframe[1] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new KeyframeSet(arrayOfObjectKeyframe);
      arrayOfObjectKeyframe[0] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0F, paramVarArgs[0]));
      int i = 1;
      while (i < j)
      {
        arrayOfObjectKeyframe[i] = ((Keyframe.ObjectKeyframe)Keyframe.ofObject(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public KeyframeSet clone()
  {
    ArrayList localArrayList = this.mKeyframes;
    int j = this.mKeyframes.size();
    Keyframe[] arrayOfKeyframe = new Keyframe[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return new KeyframeSet(arrayOfKeyframe);
      }
      arrayOfKeyframe[i] = ((Keyframe)localArrayList.get(i)).clone();
      i += 1;
    }
  }
  
  public Object getValue(float paramFloat)
  {
    float f;
    if (this.mNumKeyframes == 2)
    {
      f = paramFloat;
      if (this.mInterpolator != null) {
        f = this.mInterpolator.getInterpolation(paramFloat);
      }
      return this.mEvaluator.evaluate(f, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
    }
    Object localObject2;
    if (paramFloat <= 0.0F)
    {
      localObject1 = (Keyframe)this.mKeyframes.get(1);
      localObject2 = ((Keyframe)localObject1).getInterpolator();
      f = paramFloat;
      if (localObject2 != null) {
        f = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = this.mFirstKeyframe.getFraction();
      paramFloat = (f - paramFloat) / (((Keyframe)localObject1).getFraction() - paramFloat);
      return this.mEvaluator.evaluate(paramFloat, this.mFirstKeyframe.getValue(), ((Keyframe)localObject1).getValue());
    }
    if (paramFloat >= 1.0F)
    {
      localObject1 = (Keyframe)this.mKeyframes.get(this.mNumKeyframes - 2);
      localObject2 = this.mLastKeyframe.getInterpolator();
      f = paramFloat;
      if (localObject2 != null) {
        f = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = ((Keyframe)localObject1).getFraction();
      paramFloat = (f - paramFloat) / (this.mLastKeyframe.getFraction() - paramFloat);
      return this.mEvaluator.evaluate(paramFloat, ((Keyframe)localObject1).getValue(), this.mLastKeyframe.getValue());
    }
    Object localObject1 = this.mFirstKeyframe;
    int i = 1;
    for (;;)
    {
      if (i >= this.mNumKeyframes) {
        return this.mLastKeyframe.getValue();
      }
      localObject2 = (Keyframe)this.mKeyframes.get(i);
      if (paramFloat < ((Keyframe)localObject2).getFraction())
      {
        Interpolator localInterpolator = ((Keyframe)localObject2).getInterpolator();
        f = paramFloat;
        if (localInterpolator != null) {
          f = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = ((Keyframe)localObject1).getFraction();
        paramFloat = (f - paramFloat) / (((Keyframe)localObject2).getFraction() - paramFloat);
        return this.mEvaluator.evaluate(paramFloat, ((Keyframe)localObject1).getValue(), ((Keyframe)localObject2).getValue());
      }
      localObject1 = localObject2;
      i += 1;
    }
  }
  
  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    this.mEvaluator = paramTypeEvaluator;
  }
  
  public String toString()
  {
    String str = " ";
    int i = 0;
    for (;;)
    {
      if (i >= this.mNumKeyframes) {
        return str;
      }
      str = str + ((Keyframe)this.mKeyframes.get(i)).getValue() + "  ";
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.KeyframeSet
 * JD-Core Version:    0.7.0.1
 */