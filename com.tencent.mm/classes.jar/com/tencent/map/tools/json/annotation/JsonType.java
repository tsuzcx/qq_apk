package com.tencent.map.tools.json.annotation;

import android.support.annotation.Keep;
import com.tencent.map.tools.json.FieldNameStyle;
import com.tencent.map.tools.json.JsonParser.Deserializer;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@Keep
public @interface JsonType
{
  boolean allowEmpty() default true;
  
  Class<? extends JsonParser.Deserializer> deserializer() default JsonParser.Deserializer.class;
  
  String fieldNamePrefix() default "";
  
  FieldNameStyle fieldNameStyle() default FieldNameStyle.HUMP;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.tools.json.annotation.JsonType
 * JD-Core Version:    0.7.0.1
 */