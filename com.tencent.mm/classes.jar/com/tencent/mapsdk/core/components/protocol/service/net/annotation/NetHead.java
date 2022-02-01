package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface NetHead
{
  String[] keys() default {};
  
  String[] values() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetHead
 * JD-Core Version:    0.7.0.1
 */