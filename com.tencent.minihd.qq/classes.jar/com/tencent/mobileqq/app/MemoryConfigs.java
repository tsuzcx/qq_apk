package com.tencent.mobileqq.app;

public class MemoryConfigs
{
  private static MemoryConfigs a;
  private static final int jdField_b_of_type_Int = 6;
  private static final String jdField_b_of_type_JavaLangString = "Q.Memory.MemoryConfigs";
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs = null;
  }
  
  /* Error */
  private MemoryConfigs()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 28
    //   7: putfield 30	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: fconst_0
    //   12: putfield 32	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 34	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Boolean	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 36	com/tencent/mobileqq/app/MemoryConfigs:b	Z
    //   25: aload_0
    //   26: bipush 15
    //   28: putfield 38	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   31: aload_0
    //   32: ldc2_w 39
    //   35: putfield 42	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Long	J
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 44	com/tencent/mobileqq/app/MemoryConfigs:c	Z
    //   43: invokestatic 49	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   46: astore_1
    //   47: aload_1
    //   48: getstatic 55	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:new_memory_strategy	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   51: invokevirtual 59	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   54: invokevirtual 62	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_2
    //   58: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +28 -> 89
    //   64: ldc 12
    //   66: iconst_2
    //   67: new 70	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   74: ldc 73
    //   76: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_2
    //   90: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +12 -> 105
    //   96: aload_2
    //   97: ldc 92
    //   99: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +4 -> 106
    //   105: return
    //   106: aload_2
    //   107: ldc 100
    //   109: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   112: astore_2
    //   113: aload_2
    //   114: arraylength
    //   115: iconst_1
    //   116: if_icmple +174 -> 290
    //   119: aload_2
    //   120: aload_1
    //   121: getfield 105	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_Int	I
    //   124: aload_2
    //   125: arraylength
    //   126: irem
    //   127: aaload
    //   128: astore_1
    //   129: aload_1
    //   130: ldc 107
    //   132: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: arraylength
    //   138: bipush 6
    //   140: if_icmplt -35 -> 105
    //   143: aload_1
    //   144: iconst_1
    //   145: aaload
    //   146: ldc 109
    //   148: invokevirtual 104	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   151: astore_2
    //   152: aload_2
    //   153: iconst_0
    //   154: aaload
    //   155: ldc 111
    //   157: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +46 -> 206
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 36	com/tencent/mobileqq/app/MemoryConfigs:b	Z
    //   168: aload_0
    //   169: aload_2
    //   170: iconst_1
    //   171: aaload
    //   172: invokestatic 117	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   175: putfield 38	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   178: aload_0
    //   179: getfield 38	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   182: bipush 50
    //   184: if_icmple +9 -> 193
    //   187: aload_0
    //   188: bipush 50
    //   190: putfield 38	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   193: aload_0
    //   194: getfield 38	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   197: iconst_1
    //   198: if_icmpge +8 -> 206
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 38	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   206: aload_0
    //   207: aload_1
    //   208: iconst_2
    //   209: aaload
    //   210: putfield 30	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   213: aload_1
    //   214: iconst_3
    //   215: aaload
    //   216: ldc 111
    //   218: invokevirtual 121	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   221: ifeq +8 -> 229
    //   224: aload_0
    //   225: iconst_1
    //   226: putfield 34	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Boolean	Z
    //   229: aload_0
    //   230: aload_1
    //   231: iconst_4
    //   232: aaload
    //   233: invokestatic 127	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   236: invokevirtual 131	java/lang/Float:floatValue	()F
    //   239: putfield 32	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   242: aload_0
    //   243: getfield 32	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   246: fconst_1
    //   247: fcmpl
    //   248: ifle +8 -> 256
    //   251: aload_0
    //   252: fconst_1
    //   253: putfield 32	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   256: ldc 111
    //   258: aload_1
    //   259: iconst_5
    //   260: aaload
    //   261: invokevirtual 121	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   264: ifeq +42 -> 306
    //   267: aload_0
    //   268: iconst_1
    //   269: putfield 44	com/tencent/mobileqq/app/MemoryConfigs:c	Z
    //   272: return
    //   273: astore_1
    //   274: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -172 -> 105
    //   280: ldc 12
    //   282: iconst_2
    //   283: ldc 133
    //   285: aload_1
    //   286: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: return
    //   290: aload_2
    //   291: iconst_0
    //   292: aaload
    //   293: astore_1
    //   294: goto -165 -> 129
    //   297: astore_2
    //   298: aload_0
    //   299: fconst_0
    //   300: putfield 32	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   303: goto -47 -> 256
    //   306: aload_0
    //   307: iconst_0
    //   308: putfield 44	com/tencent/mobileqq/app/MemoryConfigs:c	Z
    //   311: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	MemoryConfigs
    //   46	213	1	localObject1	Object
    //   273	13	1	localException1	java.lang.Exception
    //   293	1	1	localObject2	Object
    //   57	234	2	localObject3	Object
    //   297	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   129	193	273	java/lang/Exception
    //   193	206	273	java/lang/Exception
    //   206	229	273	java/lang/Exception
    //   256	272	273	java/lang/Exception
    //   298	303	273	java/lang/Exception
    //   306	311	273	java/lang/Exception
    //   229	256	297	java/lang/Exception
  }
  
  public static MemoryConfigs a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs = new MemoryConfigs();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryConfigs
 * JD-Core Version:    0.7.0.1
 */