package com.tencent.map.tools.net.http;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.LOCAL_VARIABLE})
public @interface HttpRetryMethod
{
  public static final int HTTP_ALWAYS_RETYR = 5;
  public static final int HTTP_NOMARL_RETYR = 3;
  public static final int HTTP_NONE_RETRY = 0;
  public static final int HTTP_ONCE_RETRY = 2;
  public static final int HTTP_SPEED_FIRST_RETRY = 1;
  public static final int HTTP_SUCCESS_FIRST_RETRY = 4;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpRetryMethod
 * JD-Core Version:    0.7.0.1
 */