package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class Amr2PcmWrapper
{
  private static final String jdField_a_of_type_JavaLangString = "Amr2PcmWrapper";
  private static boolean jdField_a_of_type_Boolean = false;
  static final int[] jdField_a_of_type_ArrayOfInt = { 12, 13, 15, 17, 19, 20, 26, 31, 5, 0 };
  private static final int jdField_b_of_type_Int = 320;
  private static final int jdField_c_of_type_Int = 1024;
  private int jdField_a_of_type_Int = 14;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte = new byte[1024];
  private int e = 0;
  private int f = 0;
  
  public Amr2PcmWrapper(Context paramContext, int paramInt)
  {
    this.b = new byte[320];
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.c = new byte[this.jdField_a_of_type_Int];
    this.jdField_d_of_type_Int = AmrInputStreamWrapper.GsmAmrDecoderNew();
    AmrInputStreamWrapper.GsmAmrDecoderInitialize(this.jdField_d_of_type_Int);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 8)) {
      return jdField_a_of_type_ArrayOfInt[paramInt] + 1;
    }
    return 14;
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
    if (AmrInputStreamWrapper.GsmAmrDecoderDecode(this.jdField_d_of_type_Int, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
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
    //   1: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   11: invokestatic 87	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderCleanup	(I)V
    //   14: aload_0
    //   15: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   25: invokestatic 90	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(I)V
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   33: aload_0
    //   34: invokevirtual 83	com/tencent/mobileqq/utils/Amr2PcmWrapper:b	()V
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   51: ifeq +10 -> 61
    //   54: aload_0
    //   55: getfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   58: invokestatic 90	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(I)V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 64	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_d_of_type_Int	I
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	Amr2PcmWrapper
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
    if (this.e + paramInt > 1024) {
      this.jdField_d_of_type_ArrayOfByte = new byte[this.e + paramInt];
    }
    if (this.e + paramInt < this.jdField_a_of_type_Int)
    {
      System.arraycopy(paramArrayOfByte, 0, this.c, this.e, paramInt);
      return null;
    }
    System.arraycopy(this.c, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.e);
    System.arraycopy(paramArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, this.e, paramInt);
    this.f = (this.e + paramInt);
    paramInt = this.f % this.jdField_a_of_type_Int;
    this.e = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, this.f - paramInt, this.c, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.f / this.jdField_a_of_type_Int * 320];
    int i = 0;
    paramInt = 0;
    while (this.f >= this.jdField_a_of_type_Int)
    {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.b);
        System.arraycopy(this.b, 0, paramArrayOfByte, i, this.b.length);
        i += this.b.length;
        paramInt += this.jdField_a_of_type_Int;
        this.f -= this.jdField_a_of_type_Int;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Amr2PcmWrapper", 2, "========mAmr2Pcm.amr2pcmParser==IOException=====", paramArrayOfByte);
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
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.Amr2PcmWrapper
 * JD-Core Version:    0.7.0.1
 */