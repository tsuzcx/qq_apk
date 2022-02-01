package com.tencent.mm.app.plugin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@interface URISpanHandlerSet$a
{
  URISpanHandlerSet.PRIORITY abS() default URISpanHandlerSet.PRIORITY.NORMAL;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.a
 * JD-Core Version:    0.7.0.1
 */