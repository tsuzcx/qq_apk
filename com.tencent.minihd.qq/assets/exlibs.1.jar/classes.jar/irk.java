import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.DiscOfflinePreviewController;

public class irk
  extends FMObserver
{
  public irk(DiscOfflinePreviewController paramDiscOfflinePreviewController) {}
  
  /* Error */
  protected void a(boolean paramBoolean, int paramInt1, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, int paramInt2, java.lang.String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 20	com/tencent/mobileqq/filemanager/data/FMConfig:a	Z
    //   5: ifeq +44 -> 49
    //   8: ldc 22
    //   10: astore 5
    //   12: ldc 24
    //   14: astore 6
    //   16: aload_0
    //   17: getfield 10	irk:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   20: getfield 29	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback	Lcom/tencent/mobileqq/filemanager/activity/FilePreviewActivity$ControlerCallback;
    //   23: iload_1
    //   24: aload 5
    //   26: aload 6
    //   28: iload_2
    //   29: i2l
    //   30: aload_3
    //   31: aload 4
    //   33: aconst_null
    //   34: aload_0
    //   35: getfield 10	irk:a	Lcom/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController;
    //   38: getfield 32	com/tencent/mobileqq/filemanager/core/DiscOfflinePreviewController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokeinterface 37 10 0
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload 5
    //   51: ifnull +31 -> 82
    //   54: aload 5
    //   56: invokevirtual 43	java/lang/String:length	()I
    //   59: ifle +23 -> 82
    //   62: aload 5
    //   64: ldc 45
    //   66: invokevirtual 49	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   69: ifne +13 -> 82
    //   72: iload 7
    //   74: invokestatic 53	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: astore 6
    //   79: goto -63 -> 16
    //   82: aload 6
    //   84: astore 5
    //   86: goto -14 -> 72
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	irk
    //   0	94	1	paramBoolean	boolean
    //   0	94	2	paramInt1	int
    //   0	94	3	paramString1	java.lang.String
    //   0	94	4	paramString2	java.lang.String
    //   0	94	5	paramString3	java.lang.String
    //   0	94	6	paramString4	java.lang.String
    //   0	94	7	paramInt2	int
    //   0	94	8	paramString5	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	8	89	finally
    //   16	46	89	finally
    //   54	72	89	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     irk
 * JD-Core Version:    0.7.0.1
 */