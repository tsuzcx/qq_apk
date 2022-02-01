package com.tencent.component.network.utils.a;

import com.tencent.component.network.downloader.impl.c;
import java.util.concurrent.TimeUnit;

public final class e$a
{
  public int a;
  public long a;
  public TimeUnit a;
  public boolean a;
  public int b = -1;
  public int c = 20000;
  public int d = 20000;
  public int e = 45000;
  
  public e$a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = TimeUnit.SECONDS;
    this.jdField_a_of_type_Int = -1;
  }
  
  public e$a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = TimeUnit.SECONDS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = c.c;
      this.b = c.c;
      this.jdField_a_of_type_Long = 120L;
      this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = c.jdField_a_of_type_JavaUtilConcurrentTimeUnit;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.e.a
 * JD-Core Version:    0.7.0.1
 */