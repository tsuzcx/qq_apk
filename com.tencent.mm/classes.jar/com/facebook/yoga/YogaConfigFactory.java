package com.facebook.yoga;

public abstract class YogaConfigFactory
{
  public static YogaConfig create()
  {
    return new YogaConfigJNIFinalizer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.yoga.YogaConfigFactory
 * JD-Core Version:    0.7.0.1
 */