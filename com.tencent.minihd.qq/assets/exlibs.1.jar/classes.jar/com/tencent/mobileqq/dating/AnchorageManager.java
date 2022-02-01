package com.tencent.mobileqq.dating;

import android.os.Parcelable;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import java.util.Map;

public class AnchorageManager
{
  public static final int a = 3;
  public static final long a = 180000L;
  private LruCache a;
  public String a;
  
  public AnchorageManager()
  {
    this.jdField_a_of_type_JavaLangString = "AnchorageManager";
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(3);
  }
  
  /* Error */
  public AnchorageManager.Anchorage a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   6: aload_1
    //   7: invokevirtual 34	android/support/v4/util/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 36	java/lang/ref/SoftReference
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +57 -> 72
    //   18: aload_2
    //   19: invokevirtual 40	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   22: checkcast 42	com/tencent/mobileqq/dating/AnchorageManager$Anchorage
    //   25: astore_2
    //   26: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +39 -> 68
    //   32: aload_0
    //   33: getfield 20	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: iconst_2
    //   37: new 50	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   44: ldc 53
    //   46: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 59
    //   55: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: areturn
    //   72: aconst_null
    //   73: astore_2
    //   74: goto -48 -> 26
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	AnchorageManager
    //   0	82	1	paramString	String
    //   13	61	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	77	finally
    //   18	26	77	finally
    //   26	68	77	finally
  }
  
  public void a(String paramString, Parcelable paramParcelable, List paramList, Map paramMap)
  {
    a(paramString, paramParcelable, paramList, paramMap, ThreadManager.a(), 180000L);
  }
  
  /* Error */
  public void a(String paramString, Parcelable paramParcelable, List paramList, Map paramMap, java.util.Timer paramTimer, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +30 -> 35
    //   8: aload_0
    //   9: getfield 20	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: iconst_2
    //   13: new 50	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   20: ldc 81
    //   22: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 27	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   39: aload_1
    //   40: invokevirtual 83	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 36	java/lang/ref/SoftReference
    //   46: astore 8
    //   48: aload 8
    //   50: ifnull +68 -> 118
    //   53: aload 8
    //   55: invokevirtual 40	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   58: checkcast 42	com/tencent/mobileqq/dating/AnchorageManager$Anchorage
    //   61: astore 8
    //   63: aload 8
    //   65: ifnonnull +59 -> 124
    //   68: new 42	com/tencent/mobileqq/dating/AnchorageManager$Anchorage
    //   71: dup
    //   72: aload_2
    //   73: aload_3
    //   74: aload 4
    //   76: invokespecial 86	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:<init>	(Landroid/os/Parcelable;Ljava/util/List;Ljava/util/Map;)V
    //   79: astore 8
    //   81: aload_0
    //   82: getfield 27	com/tencent/mobileqq/dating/AnchorageManager:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   85: aload_1
    //   86: new 36	java/lang/ref/SoftReference
    //   89: dup
    //   90: aload 8
    //   92: invokespecial 89	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   95: invokevirtual 93	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: aload 5
    //   101: new 95	hzi
    //   104: dup
    //   105: aload_0
    //   106: aload_1
    //   107: invokespecial 98	hzi:<init>	(Lcom/tencent/mobileqq/dating/AnchorageManager;Ljava/lang/String;)V
    //   110: lload 6
    //   112: invokevirtual 104	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   115: aload_0
    //   116: monitorexit
    //   117: return
    //   118: aconst_null
    //   119: astore 8
    //   121: goto -58 -> 63
    //   124: aload 8
    //   126: aload_3
    //   127: putfield 107	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   130: aload 8
    //   132: aload_2
    //   133: putfield 110	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:jdField_a_of_type_AndroidOsParcelable	Landroid/os/Parcelable;
    //   136: aload 8
    //   138: aload 4
    //   140: putfield 113	com/tencent/mobileqq/dating/AnchorageManager$Anchorage:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   143: goto -62 -> 81
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	AnchorageManager
    //   0	151	1	paramString	String
    //   0	151	2	paramParcelable	Parcelable
    //   0	151	3	paramList	List
    //   0	151	4	paramMap	Map
    //   0	151	5	paramTimer	java.util.Timer
    //   0	151	6	paramLong	long
    //   46	91	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	146	finally
    //   35	48	146	finally
    //   53	63	146	finally
    //   68	81	146	finally
    //   81	115	146	finally
    //   124	143	146	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.AnchorageManager
 * JD-Core Version:    0.7.0.1
 */