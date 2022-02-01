package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  public static final int a = 0;
  private static NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = -1;
  public static final int c = 80;
  public static final int d = 160;
  public static final int e = 8000;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 2;
  private int j = 0;
  
  private int a(int paramInt)
  {
    if (this.j != 0) {
      return nativeInit(this.j, paramInt);
    }
    return -1;
  }
  
  /* Error */
  public static NoiseSuppression a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   6: ifnonnull +59 -> 65
    //   9: getstatic 30	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   12: ifne +25 -> 37
    //   15: aload_0
    //   16: ldc 48
    //   18: invokestatic 54	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +10 -> 33
    //   26: aconst_null
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: iconst_1
    //   34: putstatic 30	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   37: new 2	com/tencent/mobileqq/utils/NoiseSuppression
    //   40: dup
    //   41: invokespecial 55	com/tencent/mobileqq/utils/NoiseSuppression:<init>	()V
    //   44: putstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   47: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   50: sipush 8000
    //   53: invokespecial 57	com/tencent/mobileqq/utils/NoiseSuppression:a	(I)I
    //   56: pop
    //   57: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   60: iconst_2
    //   61: invokespecial 59	com/tencent/mobileqq/utils/NoiseSuppression:b	(I)I
    //   64: pop
    //   65: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   68: astore_0
    //   69: goto -41 -> 28
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramContext	android.content.Context
    //   21	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	72	finally
    //   33	37	72	finally
    //   37	65	72	finally
    //   65	69	72	finally
  }
  
  private int b(int paramInt)
  {
    if (this.j != 0) {
      return nativeSetPolicy(this.j, paramInt);
    }
    return -1;
  }
  
  private native int nativeCreate();
  
  private native int nativeInit(int paramInt1, int paramInt2);
  
  private native int nativeProcess(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private native int nativeRelease(int paramInt);
  
  private native int nativeSetPolicy(int paramInt1, int paramInt2);
  
  public int a()
  {
    if (this.j != 0) {
      return nativeRelease(this.j);
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 80) && (paramInt2 != 160)) {
      throw new IllegalArgumentException();
    }
    if (this.j != 0) {
      return nativeProcess(this.j, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  protected void finalize()
  {
    super.finalize();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */