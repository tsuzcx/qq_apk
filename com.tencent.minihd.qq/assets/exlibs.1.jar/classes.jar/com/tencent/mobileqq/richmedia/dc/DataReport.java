package com.tencent.mobileqq.richmedia.dc;

import android.os.Handler;
import android.os.HandlerThread;
import jqs;

public class DataReport
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Reportor-Tasker");
  private static DataReport jdField_a_of_type_ComTencentMobileqqRichmediaDcDataReport = new DataReport();
  private static final String jdField_a_of_type_JavaLangString = "DataReport";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static DataReport a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaDcDataReport;
  }
  
  public void a(jqs paramjqs)
  {
    if (paramjqs == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramjqs);
  }
  
  public void a(jqs paramjqs, long paramLong)
  {
    if (paramjqs == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramjqs, paramLong);
  }
  
  public void b(jqs paramjqs, long paramLong)
  {
    if (paramjqs == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport
 * JD-Core Version:    0.7.0.1
 */