package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import com.tencent.map.tools.net.NetMethod;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface NetRequest
{
  String authority() default "";
  
  String constQuery() default "";
  
  NetHead head() default @NetHead;
  
  NetMethod method();
  
  String path() default "";
  
  String[] queryKeys() default {};
  
  int retry() default 1;
  
  boolean useExtraQuery() default true;
  
  String userAgent() default "androidsdk";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest
 * JD-Core Version:    0.7.0.1
 */