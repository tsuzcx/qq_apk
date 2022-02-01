package com.tencent.mobileqq.msf.sdk;

import java.io.PrintStream;

final class s
  extends Thread
{
  public void run()
  {
    try
    {
      for (;;)
      {
        String str = (String)o.h.k();
        if (str != null) {
          o.d(str);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      System.out.println("write log file error." + localInterruptedException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.s
 * JD-Core Version:    0.7.0.1
 */