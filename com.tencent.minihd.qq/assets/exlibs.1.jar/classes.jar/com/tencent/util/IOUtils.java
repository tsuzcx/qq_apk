package com.tencent.util;

import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;

public class IOUtils
{
  private static final String a = "IOUtils";
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      QLog.e("IOUtils", 1, "", paramCloseable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.IOUtils
 * JD-Core Version:    0.7.0.1
 */