package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class Pcm2AmrWrapper
{
  private static final String jdField_a_of_type_JavaLangString = "Pcm2AmrWrapper";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int jdField_b_of_type_Int = 320;
  private static final int jdField_c_of_type_Int = 10240;
  private int jdField_a_of_type_Int = 14;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[320];
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte = new byte[10240];
  private int e = 1;
  private int f = 0;
  private int g = 0;
  
  public Pcm2AmrWrapper(Context paramContext, int paramInt)
  {
    this.c = new byte[320];
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.e = paramInt;
    this.jdField_a_of_type_Int = Amr2PcmWrapper.a(paramInt);
    this.b = new byte[this.jdField_a_of_type_Int];
    this.jdField_d_of_type_Int = AmrInputStreamWrapper.GsmAmrEncoderNew();
    AmrInputStreamWrapper.GsmAmrEncoderInitialize(this.jdField_d_of_type_Int);
  }
  
  public static void a(Context paramContext)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_d_of_type_Int == 0) {
      throw new IllegalStateException("not open");
    }
    if (AmrInputStreamWrapper.GsmAmrEncoderEncode(this.jdField_d_of_type_Int, this.e, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
      b();
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   11: invokestatic 89	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(I)V
    //   14: aload_0
    //   15: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   25: invokestatic 92	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(I)V
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   33: aload_0
    //   34: invokevirtual 85	com/tencent/mobileqq/utils/Pcm2AmrWrapper:b	()V
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   51: ifeq +10 -> 61
    //   54: aload_0
    //   55: getfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   58: invokestatic 92	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(I)V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 66	com/tencent/mobileqq/utils/Pcm2AmrWrapper:jdField_d_of_type_Int	I
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	Pcm2AmrWrapper
    //   38	7	1	localObject1	Object
    //   46	21	1	localObject2	Object
    //   68	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	28	38	finally
    //   0	14	46	finally
    //   47	61	68	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f + paramInt > 10240) {
      this.jdField_d_of_type_ArrayOfByte = new byte[this.f + paramInt];
    }
    if (this.f + paramInt < 320)
    {
      System.arraycopy(paramArrayOfByte, 0, this.c, this.f, paramInt);
      return null;
    }
    System.arraycopy(this.c, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.f);
    System.arraycopy(paramArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, this.f, paramInt);
    this.g = (this.f + paramInt);
    paramInt = this.g % 320;
    this.f = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, this.g - paramInt, this.c, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.g / 320 * this.jdField_a_of_type_Int];
    int i = 0;
    paramInt = 0;
    while (this.g >= 320)
    {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, 320);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.b);
        System.arraycopy(this.b, 0, paramArrayOfByte, i, this.b.length);
        i += this.b.length;
        paramInt += 320;
        this.g -= 320;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Pcm2AmrWrapper", 2, "========mPcm2Amr.pcm2amrParser==IOException=====", paramArrayOfByte);
        }
        b();
        return null;
      }
    }
    if (i == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public void b()
  {
    this.f = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.Pcm2AmrWrapper
 * JD-Core Version:    0.7.0.1
 */