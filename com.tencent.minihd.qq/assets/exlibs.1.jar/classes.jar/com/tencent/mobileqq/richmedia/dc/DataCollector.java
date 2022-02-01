package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import jqr;

public class DataCollector
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static String a_ = "DataCollector";
  Handler jdField_a_of_type_AndroidOsHandler = new jqr(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  public boolean a;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Colloector-Tasker");
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public DataCollector(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    a_ = getClass().getSimpleName();
  }
  
  static Looper a()
  {
    return jdField_a_of_type_AndroidOsHandlerThread.getLooper();
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataCollector
 * JD-Core Version:    0.7.0.1
 */