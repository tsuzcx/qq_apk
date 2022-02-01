package com.tencent.mobileqq.utils;

public class PTTAgcWrapper
{
  private static PTTAgcWrapper jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = null;
  private static boolean jdField_a_of_type_Boolean = false;
  
  private PTTAgcWrapper()
  {
    PTTAGCCreateAPI();
    PTTAGCCalcuAPI();
    PTTAGCResetAPI();
  }
  
  private static native void PTTAGCCalcuAPI();
  
  public static native int PTTAGCCreateAPI();
  
  public static native int PTTAGCFreeAPI();
  
  public static native void PTTAGCResetAPI();
  
  public static native void PTTAGCRunAPI(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void PTTVMICRunAPI(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  /* Error */
  public static PTTAgcWrapper a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   6: ifnonnull +41 -> 47
    //   9: getstatic 11	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Boolean	Z
    //   12: ifne +25 -> 37
    //   15: aload_0
    //   16: ldc 34
    //   18: invokestatic 40	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
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
    //   34: putstatic 11	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Boolean	Z
    //   37: new 2	com/tencent/mobileqq/utils/PTTAgcWrapper
    //   40: dup
    //   41: invokespecial 41	com/tencent/mobileqq/utils/PTTAgcWrapper:<init>	()V
    //   44: putstatic 13	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   47: getstatic 13	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   50: astore_0
    //   51: goto -23 -> 28
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramContext	android.content.Context
    //   21	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	54	finally
    //   33	37	54	finally
    //   37	47	54	finally
    //   47	51	54	finally
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PTTVMICRunAPI(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PTTAGCRunAPI(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected void finalize()
  {
    super.finalize();
    PTTAGCFreeAPI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PTTAgcWrapper
 * JD-Core Version:    0.7.0.1
 */