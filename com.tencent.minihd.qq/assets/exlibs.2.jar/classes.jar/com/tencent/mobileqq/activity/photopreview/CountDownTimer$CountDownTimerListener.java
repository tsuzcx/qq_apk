package com.tencent.mobileqq.activity.photopreview;

import android.os.SystemClock;

public abstract class CountDownTimer$CountDownTimerListener
{
  private long jdField_a_of_type_Long;
  private CountDownTimer jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
  private long b;
  
  public CountDownTimer$CountDownTimerListener(long paramLong)
  {
    a(paramLong);
  }
  
  public CountDownTimer$CountDownTimerListener(CountDownTimer paramCountDownTimer)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = paramCountDownTimer;
  }
  
  public final void a()
  {
    long l = this.jdField_a_of_type_Long - SystemClock.elapsedRealtime();
    if (l > 1000L)
    {
      b(l);
      return;
    }
    b();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.a(paramLong);
    }
    this.b = paramLong;
    this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() + 1000L * paramLong);
  }
  
  public abstract void b();
  
  public abstract void b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener
 * JD-Core Version:    0.7.0.1
 */