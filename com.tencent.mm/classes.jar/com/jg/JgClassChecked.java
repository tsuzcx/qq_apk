package com.jg;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JgClassChecked
{
  int author();
  
  String fComment();
  
  String lastDate();
  
  int level() default 1;
  
  int reviewer();
  
  EType[] vComment();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.jg.JgClassChecked
 * JD-Core Version:    0.7.0.1
 */