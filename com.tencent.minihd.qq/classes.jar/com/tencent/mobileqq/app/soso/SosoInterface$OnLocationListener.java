package com.tencent.mobileqq.app.soso;

import android.os.SystemClock;
import android.util.AndroidRuntimeException;

public abstract class SosoInterface$OnLocationListener
{
  public int b;
  public String b;
  public long d;
  protected long e;
  public boolean e;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  
  public SosoInterface$OnLocationListener(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Int = paramInt;
      this.g = paramBoolean1;
      this.f = paramBoolean3;
      this.jdField_e_of_type_Boolean = paramBoolean2;
      this.jdField_e_of_type_Long = paramLong;
      this.d = SystemClock.elapsedRealtime();
      return;
    }
    throw new AndroidRuntimeException("invalid level=" + paramInt);
  }
  
  public abstract void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener
 * JD-Core Version:    0.7.0.1
 */