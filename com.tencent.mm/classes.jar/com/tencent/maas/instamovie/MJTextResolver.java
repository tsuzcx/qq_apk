package com.tencent.maas.instamovie;

public abstract interface MJTextResolver
{
  public static final String KEY_DEVICE_NAME = "deviceName";
  public static final String KEY_USERNAME = "username";
  
  public abstract String resolve(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJTextResolver
 * JD-Core Version:    0.7.0.1
 */