package com.tencent.component.network.utils.thread;

import cwr;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  public static final String a = " sub:";
  private final int jdField_a_of_type_Int;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private final String b;
  
  public PriorityThreadFactory(String paramString, int paramInt)
  {
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new cwr(this, paramRunnable, this.b + '-' + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() + " sub:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */