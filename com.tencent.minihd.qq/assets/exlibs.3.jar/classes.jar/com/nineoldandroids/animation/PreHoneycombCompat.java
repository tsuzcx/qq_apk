package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat
{
  static Property<View, Float> ALPHA = new FloatProperty("alpha")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getAlpha());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setAlpha(paramAnonymousFloat);
    }
  };
  static Property<View, Float> PIVOT_X = new FloatProperty("pivotX")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getPivotX());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setPivotX(paramAnonymousFloat);
    }
  };
  static Property<View, Float> PIVOT_Y = new FloatProperty("pivotY")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getPivotY());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setPivotY(paramAnonymousFloat);
    }
  };
  static Property<View, Float> ROTATION = new FloatProperty("rotation")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getRotation());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setRotation(paramAnonymousFloat);
    }
  };
  static Property<View, Float> ROTATION_X = new FloatProperty("rotationX")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getRotationX());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setRotationX(paramAnonymousFloat);
    }
  };
  static Property<View, Float> ROTATION_Y = new FloatProperty("rotationY")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getRotationY());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setRotationY(paramAnonymousFloat);
    }
  };
  static Property<View, Float> SCALE_X = new FloatProperty("scaleX")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getScaleX());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setScaleX(paramAnonymousFloat);
    }
  };
  static Property<View, Float> SCALE_Y = new FloatProperty("scaleY")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getScaleY());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setScaleY(paramAnonymousFloat);
    }
  };
  static Property<View, Integer> SCROLL_X = new IntProperty("scrollX")
  {
    public Integer get(View paramAnonymousView)
    {
      return Integer.valueOf(AnimatorProxy.wrap(paramAnonymousView).getScrollX());
    }
    
    public void setValue(View paramAnonymousView, int paramAnonymousInt)
    {
      AnimatorProxy.wrap(paramAnonymousView).setScrollX(paramAnonymousInt);
    }
  };
  static Property<View, Integer> SCROLL_Y = new IntProperty("scrollY")
  {
    public Integer get(View paramAnonymousView)
    {
      return Integer.valueOf(AnimatorProxy.wrap(paramAnonymousView).getScrollY());
    }
    
    public void setValue(View paramAnonymousView, int paramAnonymousInt)
    {
      AnimatorProxy.wrap(paramAnonymousView).setScrollY(paramAnonymousInt);
    }
  };
  static Property<View, Float> TRANSLATION_X = new FloatProperty("translationX")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getTranslationX());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setTranslationX(paramAnonymousFloat);
    }
  };
  static Property<View, Float> TRANSLATION_Y = new FloatProperty("translationY")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getTranslationY());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setTranslationY(paramAnonymousFloat);
    }
  };
  static Property<View, Float> X = new FloatProperty("x")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getX());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setX(paramAnonymousFloat);
    }
  };
  static Property<View, Float> Y = new FloatProperty("y")
  {
    public Float get(View paramAnonymousView)
    {
      return Float.valueOf(AnimatorProxy.wrap(paramAnonymousView).getY());
    }
    
    public void setValue(View paramAnonymousView, float paramAnonymousFloat)
    {
      AnimatorProxy.wrap(paramAnonymousView).setY(paramAnonymousFloat);
    }
  };
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.PreHoneycombCompat
 * JD-Core Version:    0.7.0.1
 */