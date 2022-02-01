import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder;

public class jed
  implements Runnable
{
  public jed(MagicfaceXBigDecoder paramMagicfaceXBigDecoder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   4: getfield 24	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_Boolean	Z
    //   7: ifeq +212 -> 219
    //   10: aload_0
    //   11: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   14: iconst_0
    //   15: invokestatic 27	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;Z)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   23: aload_0
    //   24: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   27: getfield 31	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:d	[B
    //   30: aload_0
    //   31: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   34: getfield 35	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   37: invokevirtual 38	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	([BI)I
    //   40: istore_1
    //   41: aload_0
    //   42: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   45: iload_1
    //   46: aload_0
    //   47: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   50: getfield 35	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   53: isub
    //   54: putfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   57: aload_0
    //   58: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   61: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   64: ifge +4 -> 68
    //   67: return
    //   68: aload_0
    //   69: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   72: aload_0
    //   73: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   76: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   79: aload_0
    //   80: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   83: getfield 35	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   86: aload_0
    //   87: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   90: getfield 31	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:d	[B
    //   93: invokevirtual 45	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:b	(II[B)V
    //   96: aload_0
    //   97: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   100: iload_1
    //   101: putfield 35	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:l	I
    //   104: aload_0
    //   105: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   108: getfield 48	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   111: aload_0
    //   112: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   115: getfield 51	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:e	[B
    //   118: aload_0
    //   119: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   122: getfield 41	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:k	I
    //   125: aload_0
    //   126: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   129: getfield 54	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:f	[B
    //   132: invokevirtual 60	com/tencent/mobileqq/magicface/DecoderUtil:decodeAlphaDecoder	([BI[B)I
    //   135: pop
    //   136: aload_0
    //   137: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   140: iconst_1
    //   141: invokestatic 27	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;Z)Z
    //   144: pop
    //   145: aload_0
    //   146: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   149: invokestatic 63	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   152: astore_2
    //   153: aload_2
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   159: invokestatic 63	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:a	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   162: invokevirtual 66	java/lang/Object:notify	()V
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_0
    //   168: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   171: invokestatic 68	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:b	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   174: astore_2
    //   175: aload_2
    //   176: monitorenter
    //   177: aload_0
    //   178: getfield 12	jed:a	Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;
    //   181: invokestatic 68	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder:b	(Lcom/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder;)Ljava/lang/Object;
    //   184: invokevirtual 71	java/lang/Object:wait	()V
    //   187: aload_2
    //   188: monitorexit
    //   189: goto -189 -> 0
    //   192: astore_3
    //   193: aload_2
    //   194: monitorexit
    //   195: aload_3
    //   196: athrow
    //   197: astore_2
    //   198: goto -198 -> 0
    //   201: astore_3
    //   202: aload_2
    //   203: monitorexit
    //   204: aload_3
    //   205: athrow
    //   206: astore_2
    //   207: goto -40 -> 167
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   215: return
    //   216: astore_2
    //   217: aload_2
    //   218: athrow
    //   219: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	jed
    //   40	61	1	i	int
    //   197	6	2	localException1	java.lang.Exception
    //   206	1	2	localException2	java.lang.Exception
    //   210	2	2	localException3	java.lang.Exception
    //   216	2	2	localObject2	Object
    //   192	4	3	localObject3	Object
    //   201	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   177	189	192	finally
    //   193	195	192	finally
    //   167	177	197	java/lang/Exception
    //   195	197	197	java/lang/Exception
    //   155	167	201	finally
    //   202	204	201	finally
    //   145	155	206	java/lang/Exception
    //   204	206	206	java/lang/Exception
    //   0	67	210	java/lang/Exception
    //   68	145	210	java/lang/Exception
    //   0	67	216	finally
    //   68	145	216	finally
    //   145	155	216	finally
    //   167	177	216	finally
    //   195	197	216	finally
    //   204	206	216	finally
    //   211	215	216	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jed
 * JD-Core Version:    0.7.0.1
 */