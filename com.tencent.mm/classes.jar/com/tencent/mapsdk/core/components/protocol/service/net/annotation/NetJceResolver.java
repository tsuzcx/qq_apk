package com.tencent.mapsdk.core.components.protocol.service.net.annotation;

import com.qq.taf.jce.MapJceStruct;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface NetJceResolver
{
  Class<? extends MapJceStruct> inJce();
  
  Class<? extends MapJceStruct> outJce();
  
  int[] queryRange();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver
 * JD-Core Version:    0.7.0.1
 */