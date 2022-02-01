package com.tencent.map.tools.json.annotation;

import androidx.annotation.Keep;
import com.tencent.map.tools.json.JsonParser.Deserializer;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
@Keep
public @interface Json
{
  Class<? extends JsonParser.Deserializer> deserializer() default JsonParser.Deserializer.class;
  
  boolean ignore() default false;
  
  String name() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.json.annotation.Json
 * JD-Core Version:    0.7.0.1
 */