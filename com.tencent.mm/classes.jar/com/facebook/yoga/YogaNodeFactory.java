package com.facebook.yoga;

public abstract class YogaNodeFactory
{
  public static YogaNode create()
  {
    return new YogaNodeJNIFinalizer();
  }
  
  public static YogaNode create(YogaConfig paramYogaConfig)
  {
    return new YogaNodeJNIFinalizer(paramYogaConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeFactory
 * JD-Core Version:    0.7.0.1
 */