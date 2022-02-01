package com.tencent.loginsecsdk;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProtocolDet
{
  private static final String DET_CACHE_FILE_NAME = "pd2.dat";
  private static final int EXTRA_IPV4_DATA_ITEM_SIZE = 21;
  private static final int EXTRA_IPV6_DATA_ITEM_SIZE = 33;
  private static final int IPV4_LEN = 4;
  private static final int IPV6_LEN = 16;
  private static final int MAX_CACHED_FILE_SIZE = 4096;
  private static final int MAX_CACHED_ITEM_COUNT = 3;
  private static byte cNum = 0;
  
  /* Error */
  private static byte[] convertExtraDataListToBuffer(List<LoginExtraData> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: new 42	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 43	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore 6
    //   24: new 45	java/io/DataOutputStream
    //   27: dup
    //   28: aload 6
    //   30: invokespecial 48	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 7
    //   35: aload_0
    //   36: invokeinterface 54 1 0
    //   41: istore_2
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_1
    //   45: iload_2
    //   46: if_icmpge +149 -> 195
    //   49: aload_0
    //   50: iload_1
    //   51: invokeinterface 58 2 0
    //   56: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   59: getfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   62: lstore 4
    //   64: aload_0
    //   65: iload_1
    //   66: invokeinterface 58 2 0
    //   71: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   74: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   77: istore_3
    //   78: aload_0
    //   79: iload_1
    //   80: invokeinterface 58 2 0
    //   85: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   88: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   91: iconst_4
    //   92: if_icmpeq +21 -> 113
    //   95: aload_0
    //   96: iload_1
    //   97: invokeinterface 58 2 0
    //   102: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   105: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   108: bipush 16
    //   110: if_icmpne +77 -> 187
    //   113: aload 7
    //   115: lload 4
    //   117: invokevirtual 69	java/io/DataOutputStream:writeLong	(J)V
    //   120: aload 7
    //   122: iload_3
    //   123: invokevirtual 73	java/io/DataOutputStream:writeByte	(I)V
    //   126: aload 7
    //   128: aload_0
    //   129: iload_1
    //   130: invokeinterface 58 2 0
    //   135: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   138: getfield 77	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   141: invokevirtual 81	java/io/DataOutputStream:write	([B)V
    //   144: aload 7
    //   146: aload_0
    //   147: iload_1
    //   148: invokeinterface 58 2 0
    //   153: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   156: getfield 84	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   159: invokevirtual 87	java/io/DataOutputStream:writeInt	(I)V
    //   162: aload 7
    //   164: aload_0
    //   165: iload_1
    //   166: invokeinterface 58 2 0
    //   171: checkcast 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   174: getfield 90	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   177: invokevirtual 87	java/io/DataOutputStream:writeInt	(I)V
    //   180: iload_1
    //   181: iconst_1
    //   182: iadd
    //   183: istore_1
    //   184: goto -140 -> 44
    //   187: ldc 92
    //   189: ldc 94
    //   191: invokestatic 100	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   194: pop
    //   195: aload 6
    //   197: invokevirtual 104	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   200: astore_0
    //   201: aload 6
    //   203: ifnull +8 -> 211
    //   206: aload 6
    //   208: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   211: aload 7
    //   213: ifnull +8 -> 221
    //   216: aload 7
    //   218: invokevirtual 108	java/io/DataOutputStream:close	()V
    //   221: aload_0
    //   222: areturn
    //   223: astore 6
    //   225: aload 6
    //   227: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   230: goto -19 -> 211
    //   233: astore 6
    //   235: aload 6
    //   237: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   240: goto -19 -> 221
    //   243: astore 6
    //   245: aload 11
    //   247: astore_0
    //   248: aload_0
    //   249: astore 7
    //   251: aload 9
    //   253: astore 8
    //   255: aload 6
    //   257: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   260: aload_0
    //   261: ifnull +7 -> 268
    //   264: aload_0
    //   265: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   268: aload 9
    //   270: ifnull +8 -> 278
    //   273: aload 9
    //   275: invokevirtual 108	java/io/DataOutputStream:close	()V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   285: goto -17 -> 268
    //   288: astore_0
    //   289: aload_0
    //   290: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   293: goto -15 -> 278
    //   296: astore_0
    //   297: aload 7
    //   299: ifnull +8 -> 307
    //   302: aload 7
    //   304: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   307: aload 8
    //   309: ifnull +8 -> 317
    //   312: aload 8
    //   314: invokevirtual 108	java/io/DataOutputStream:close	()V
    //   317: aload_0
    //   318: athrow
    //   319: astore 6
    //   321: aload 6
    //   323: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   326: goto -19 -> 307
    //   329: astore 6
    //   331: aload 6
    //   333: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   336: goto -19 -> 317
    //   339: astore_0
    //   340: aload 6
    //   342: astore 7
    //   344: aload 10
    //   346: astore 8
    //   348: goto -51 -> 297
    //   351: astore_0
    //   352: aload 7
    //   354: astore 8
    //   356: aload 6
    //   358: astore 7
    //   360: goto -63 -> 297
    //   363: astore 7
    //   365: aload 6
    //   367: astore_0
    //   368: aload 7
    //   370: astore 6
    //   372: goto -124 -> 248
    //   375: astore 8
    //   377: aload 6
    //   379: astore_0
    //   380: aload 8
    //   382: astore 6
    //   384: aload 7
    //   386: astore 9
    //   388: goto -140 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramList	List<LoginExtraData>
    //   43	141	1	i	int
    //   41	6	2	j	int
    //   77	46	3	k	int
    //   62	54	4	l	long
    //   22	185	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   223	3	6	localException1	Exception
    //   233	3	6	localException2	Exception
    //   243	13	6	localException3	Exception
    //   319	3	6	localException4	Exception
    //   329	37	6	localException5	Exception
    //   370	13	6	localException6	Exception
    //   1	358	7	localObject1	Object
    //   363	22	7	localException7	Exception
    //   7	348	8	localObject2	Object
    //   375	6	8	localException8	Exception
    //   13	374	9	localException9	Exception
    //   10	335	10	localObject3	Object
    //   4	242	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   206	211	223	java/lang/Exception
    //   216	221	233	java/lang/Exception
    //   15	24	243	java/lang/Exception
    //   264	268	280	java/lang/Exception
    //   273	278	288	java/lang/Exception
    //   15	24	296	finally
    //   255	260	296	finally
    //   302	307	319	java/lang/Exception
    //   312	317	329	java/lang/Exception
    //   24	35	339	finally
    //   35	42	351	finally
    //   49	113	351	finally
    //   113	180	351	finally
    //   187	195	351	finally
    //   195	201	351	finally
    //   24	35	363	java/lang/Exception
    //   35	42	375	java/lang/Exception
    //   49	113	375	java/lang/Exception
    //   113	180	375	java/lang/Exception
    //   187	195	375	java/lang/Exception
    //   195	201	375	java/lang/Exception
  }
  
  private static String getCachedDetFileFullPath(Context paramContext)
  {
    return paramContext.getFilesDir() + File.separator + "pd2.dat";
  }
  
  /* Error */
  private static LoginExtraData getExtraDataFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: new 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   9: dup
    //   10: aconst_null
    //   11: invokespecial 145	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$1;)V
    //   14: astore 4
    //   16: new 147	java/io/DataInputStream
    //   19: dup
    //   20: new 149	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 151	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: invokespecial 154	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_0
    //   32: aload 4
    //   34: aload_0
    //   35: invokevirtual 158	java/io/DataInputStream:readLong	()J
    //   38: putfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   41: aload 4
    //   43: aload_0
    //   44: invokevirtual 162	java/io/DataInputStream:readByte	()B
    //   47: putfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   50: aload 4
    //   52: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   55: iconst_4
    //   56: if_icmpeq +13 -> 69
    //   59: aload 4
    //   61: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   64: bipush 16
    //   66: if_icmpne +62 -> 128
    //   69: aload 4
    //   71: aload 4
    //   73: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   76: newarray byte
    //   78: putfield 77	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   81: aload_0
    //   82: aload 4
    //   84: getfield 77	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   87: invokevirtual 166	java/io/DataInputStream:read	([B)I
    //   90: pop
    //   91: aload 4
    //   93: aload_0
    //   94: invokevirtual 169	java/io/DataInputStream:readInt	()I
    //   97: putfield 84	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   100: aload 4
    //   102: aload_0
    //   103: invokevirtual 169	java/io/DataInputStream:readInt	()I
    //   106: putfield 90	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 170	java/io/DataInputStream:close	()V
    //   117: aload 4
    //   119: areturn
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   125: goto -8 -> 117
    //   128: ldc 92
    //   130: ldc 94
    //   132: invokestatic 100	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 170	java/io/DataInputStream:close	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_0
    //   155: aload_2
    //   156: astore_1
    //   157: aload_0
    //   158: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 170	java/io/DataInputStream:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   176: goto -7 -> 169
    //   179: astore_0
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 170	java/io/DataInputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_0
    //   199: aload_3
    //   200: astore_1
    //   201: goto -21 -> 180
    //   204: astore_2
    //   205: aload_0
    //   206: astore_1
    //   207: aload_2
    //   208: astore_0
    //   209: goto -29 -> 180
    //   212: astore_0
    //   213: goto -58 -> 155
    //   216: astore_1
    //   217: aload_0
    //   218: astore_2
    //   219: aload_1
    //   220: astore_0
    //   221: goto -66 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramArrayOfByte	byte[]
    //   1	184	1	localObject1	Object
    //   190	2	1	localException1	Exception
    //   200	7	1	localObject2	Object
    //   216	4	1	localException2	Exception
    //   5	161	2	localObject3	Object
    //   204	4	2	localObject4	Object
    //   218	1	2	arrayOfByte	byte[]
    //   3	197	3	localObject5	Object
    //   14	104	4	localLoginExtraData	LoginExtraData
    // Exception table:
    //   from	to	target	type
    //   113	117	120	java/lang/Exception
    //   140	144	146	java/lang/Exception
    //   6	16	154	java/lang/Exception
    //   165	169	171	java/lang/Exception
    //   6	16	179	finally
    //   157	161	179	finally
    //   184	188	190	java/lang/Exception
    //   16	32	198	finally
    //   32	69	204	finally
    //   69	109	204	finally
    //   128	136	204	finally
    //   16	32	212	java/lang/Exception
    //   32	69	216	java/lang/Exception
    //   69	109	216	java/lang/Exception
    //   128	136	216	java/lang/Exception
  }
  
  public static byte[] getLoginExtraData(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = loadExtraDataFromFile(paramContext, 3);
    if (paramContext == null) {
      return packExtraData(null);
    }
    cNum = (byte)paramContext.size();
    return packExtraData(convertExtraDataListToBuffer(paramContext));
  }
  
  /* Error */
  private static List<LoginExtraData> loadExtraDataFromFile(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: new 184	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 185	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: aload 4
    //   17: astore_3
    //   18: aload_0
    //   19: invokestatic 187	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   22: invokestatic 191	com/tencent/loginsecsdk/ProtocolDet:loadFileContent	(Ljava/lang/String;)[B
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +27 -> 54
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 193	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: aconst_null
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   51: goto -9 -> 42
    //   54: aload 4
    //   56: astore_3
    //   57: new 147	java/io/DataInputStream
    //   60: dup
    //   61: new 149	java/io/ByteArrayInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 151	java/io/ByteArrayInputStream:<init>	([B)V
    //   69: invokespecial 154	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 197	java/io/DataInputStream:available	()I
    //   77: ifeq +20 -> 97
    //   80: aload 5
    //   82: invokeinterface 54 1 0
    //   87: istore_2
    //   88: iload_2
    //   89: iload_1
    //   90: if_icmplt +18 -> 108
    //   93: iload_1
    //   94: ifle +14 -> 108
    //   97: aload_0
    //   98: ifnull +186 -> 284
    //   101: aload_0
    //   102: invokevirtual 170	java/io/DataInputStream:close	()V
    //   105: aload 5
    //   107: areturn
    //   108: new 8	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData
    //   111: dup
    //   112: aconst_null
    //   113: invokespecial 145	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:<init>	(Lcom/tencent/loginsecsdk/ProtocolDet$1;)V
    //   116: astore_3
    //   117: aload_3
    //   118: aload_0
    //   119: invokevirtual 158	java/io/DataInputStream:readLong	()J
    //   122: putfield 62	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mUin	J
    //   125: aload_3
    //   126: aload_0
    //   127: invokevirtual 162	java/io/DataInputStream:readByte	()B
    //   130: putfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   133: aload_3
    //   134: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   137: iconst_4
    //   138: if_icmpeq +12 -> 150
    //   141: aload_3
    //   142: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   145: bipush 16
    //   147: if_icmpne +81 -> 228
    //   150: aload_3
    //   151: aload_3
    //   152: getfield 65	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mlen	B
    //   155: newarray byte
    //   157: putfield 77	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   160: aload_0
    //   161: aload_3
    //   162: getfield 77	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mIp	[B
    //   165: invokevirtual 166	java/io/DataInputStream:read	([B)I
    //   168: pop
    //   169: aload_3
    //   170: aload_0
    //   171: invokevirtual 169	java/io/DataInputStream:readInt	()I
    //   174: putfield 84	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mTime	I
    //   177: aload_3
    //   178: aload_0
    //   179: invokevirtual 169	java/io/DataInputStream:readInt	()I
    //   182: putfield 90	com/tencent/loginsecsdk/ProtocolDet$LoginExtraData:mVersion	I
    //   185: aload 5
    //   187: aload_3
    //   188: invokeinterface 201 2 0
    //   193: pop
    //   194: goto -121 -> 73
    //   197: astore 4
    //   199: aload_0
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   206: aload 5
    //   208: astore_3
    //   209: aload_0
    //   210: ifnull -166 -> 44
    //   213: aload_0
    //   214: invokevirtual 170	java/io/DataInputStream:close	()V
    //   217: aload 5
    //   219: areturn
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   225: aload 5
    //   227: areturn
    //   228: ldc 92
    //   230: ldc 94
    //   232: invokestatic 100	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: goto -139 -> 97
    //   239: astore 4
    //   241: aload_0
    //   242: astore_3
    //   243: aload 4
    //   245: astore_0
    //   246: aload_3
    //   247: ifnull +7 -> 254
    //   250: aload_3
    //   251: invokevirtual 170	java/io/DataInputStream:close	()V
    //   254: aload_0
    //   255: athrow
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   261: aload 5
    //   263: areturn
    //   264: astore_3
    //   265: aload_3
    //   266: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   269: goto -15 -> 254
    //   272: astore_0
    //   273: goto -27 -> 246
    //   276: astore 4
    //   278: aload 6
    //   280: astore_0
    //   281: goto -82 -> 199
    //   284: aload 5
    //   286: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramContext	Context
    //   0	287	1	paramInt	int
    //   87	4	2	i	int
    //   17	234	3	localObject1	Object
    //   264	2	3	localException1	Exception
    //   1	54	4	localObject2	Object
    //   197	5	4	localException2	Exception
    //   239	5	4	localObject3	Object
    //   276	1	4	localException3	Exception
    //   13	272	5	localArrayList	ArrayList
    //   4	275	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	46	java/lang/Exception
    //   73	88	197	java/lang/Exception
    //   108	150	197	java/lang/Exception
    //   150	194	197	java/lang/Exception
    //   228	236	197	java/lang/Exception
    //   213	217	220	java/lang/Exception
    //   73	88	239	finally
    //   108	150	239	finally
    //   150	194	239	finally
    //   228	236	239	finally
    //   101	105	256	java/lang/Exception
    //   250	254	264	java/lang/Exception
    //   18	26	272	finally
    //   57	73	272	finally
    //   201	206	272	finally
    //   18	26	276	java/lang/Exception
    //   57	73	276	java/lang/Exception
  }
  
  /* Error */
  private static byte[] loadFileContent(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 6
    //   8: astore 4
    //   10: new 130	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload 6
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 209	java/io/File:exists	()Z
    //   27: istore_3
    //   28: iload_3
    //   29: ifne +24 -> 53
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 193	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: aconst_null
    //   45: areturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   51: aconst_null
    //   52: areturn
    //   53: aload 6
    //   55: astore 4
    //   57: new 211	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 214	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 215	java/io/FileInputStream:available	()I
    //   70: istore_2
    //   71: iload_2
    //   72: istore_1
    //   73: iload_2
    //   74: sipush 4096
    //   77: if_icmple +7 -> 84
    //   80: sipush 4096
    //   83: istore_1
    //   84: iload_1
    //   85: newarray byte
    //   87: astore 4
    //   89: aload_0
    //   90: aload 4
    //   92: invokevirtual 216	java/io/FileInputStream:read	([B)I
    //   95: pop
    //   96: aload_0
    //   97: ifnull +108 -> 205
    //   100: aload_0
    //   101: invokevirtual 217	java/io/FileInputStream:close	()V
    //   104: aload 4
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   112: goto -8 -> 104
    //   115: astore 4
    //   117: aload 5
    //   119: astore_0
    //   120: aload 4
    //   122: astore 5
    //   124: aload_0
    //   125: astore 4
    //   127: aload 5
    //   129: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   132: aconst_null
    //   133: astore 5
    //   135: aload 5
    //   137: astore 4
    //   139: aload_0
    //   140: ifnull -36 -> 104
    //   143: aload_0
    //   144: invokevirtual 217	java/io/FileInputStream:close	()V
    //   147: aload 5
    //   149: astore 4
    //   151: goto -47 -> 104
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   159: aload 5
    //   161: astore 4
    //   163: goto -59 -> 104
    //   166: astore_0
    //   167: aload 4
    //   169: ifnull +8 -> 177
    //   172: aload 4
    //   174: invokevirtual 217	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore 4
    //   181: aload 4
    //   183: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   186: goto -9 -> 177
    //   189: astore 5
    //   191: aload_0
    //   192: astore 4
    //   194: aload 5
    //   196: astore_0
    //   197: goto -30 -> 167
    //   200: astore 5
    //   202: goto -78 -> 124
    //   205: goto -101 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   72	13	1	i	int
    //   70	8	2	j	int
    //   27	2	3	bool	boolean
    //   8	97	4	localObject1	Object
    //   115	6	4	localException1	Exception
    //   125	48	4	localObject2	Object
    //   179	3	4	localException2	Exception
    //   192	1	4	str	String
    //   4	156	5	localObject3	Object
    //   189	6	5	localObject4	Object
    //   200	1	5	localException3	Exception
    //   1	53	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	46	java/lang/Exception
    //   100	104	107	java/lang/Exception
    //   10	19	115	java/lang/Exception
    //   23	28	115	java/lang/Exception
    //   57	66	115	java/lang/Exception
    //   143	147	154	java/lang/Exception
    //   10	19	166	finally
    //   23	28	166	finally
    //   57	66	166	finally
    //   127	132	166	finally
    //   172	177	179	java/lang/Exception
    //   66	71	189	finally
    //   84	96	189	finally
    //   66	71	200	java/lang/Exception
    //   84	96	200	java/lang/Exception
  }
  
  /* Error */
  private static byte[] packExtraData(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: new 42	java/io/ByteArrayOutputStream
    //   18: dup
    //   19: invokespecial 43	java/io/ByteArrayOutputStream:<init>	()V
    //   22: astore_3
    //   23: new 45	java/io/DataOutputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 48	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 4
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 73	java/io/DataOutputStream:writeByte	(I)V
    //   39: iconst_0
    //   40: istore_1
    //   41: aload_0
    //   42: ifnull +60 -> 102
    //   45: aload_0
    //   46: arraylength
    //   47: i2b
    //   48: istore_2
    //   49: iload_2
    //   50: istore_1
    //   51: iload_2
    //   52: ifge +5 -> 57
    //   55: iconst_0
    //   56: istore_1
    //   57: aload 4
    //   59: getstatic 32	com/tencent/loginsecsdk/ProtocolDet:cNum	B
    //   62: invokevirtual 73	java/io/DataOutputStream:writeByte	(I)V
    //   65: iload_1
    //   66: ifle +11 -> 77
    //   69: aload 4
    //   71: aload_0
    //   72: iconst_0
    //   73: iload_1
    //   74: invokevirtual 220	java/io/DataOutputStream:write	([BII)V
    //   77: aload_3
    //   78: invokevirtual 104	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: astore_0
    //   82: aload_3
    //   83: ifnull +7 -> 90
    //   86: aload_3
    //   87: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 108	java/io/DataOutputStream:close	()V
    //   100: aload_0
    //   101: areturn
    //   102: iconst_0
    //   103: putstatic 32	com/tencent/loginsecsdk/ProtocolDet:cNum	B
    //   106: goto -49 -> 57
    //   109: astore 6
    //   111: aload_3
    //   112: astore_0
    //   113: aload 4
    //   115: astore_3
    //   116: aload_3
    //   117: astore 4
    //   119: aload_0
    //   120: astore 5
    //   122: aload 6
    //   124: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 108	java/io/DataOutputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_3
    //   146: aload_3
    //   147: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   150: goto -60 -> 90
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   158: goto -58 -> 100
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   166: goto -31 -> 135
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   174: goto -31 -> 143
    //   177: astore_0
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 108	java/io/DataOutputStream:close	()V
    //   198: aload_0
    //   199: athrow
    //   200: astore_3
    //   201: aload_3
    //   202: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   205: goto -17 -> 188
    //   208: astore_3
    //   209: aload_3
    //   210: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   213: goto -15 -> 198
    //   216: astore_0
    //   217: aload 6
    //   219: astore 4
    //   221: aload_3
    //   222: astore 5
    //   224: goto -46 -> 178
    //   227: astore_0
    //   228: aload_3
    //   229: astore 5
    //   231: goto -53 -> 178
    //   234: astore 6
    //   236: aload 7
    //   238: astore_3
    //   239: aload 8
    //   241: astore_0
    //   242: goto -126 -> 116
    //   245: astore 6
    //   247: aload_3
    //   248: astore_0
    //   249: aload 7
    //   251: astore_3
    //   252: goto -136 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramArrayOfByte	byte[]
    //   40	34	1	i	int
    //   48	4	2	j	int
    //   22	118	3	localObject1	Object
    //   145	2	3	localException1	Exception
    //   153	2	3	localException2	Exception
    //   200	2	3	localException3	Exception
    //   208	21	3	localException4	Exception
    //   238	14	3	localObject2	Object
    //   7	213	4	localObject3	Object
    //   1	229	5	localObject4	Object
    //   10	1	6	localObject5	Object
    //   109	109	6	localException5	Exception
    //   234	1	6	localException6	Exception
    //   245	1	6	localException7	Exception
    //   13	237	7	localObject6	Object
    //   4	236	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	109	java/lang/Exception
    //   45	49	109	java/lang/Exception
    //   57	65	109	java/lang/Exception
    //   69	77	109	java/lang/Exception
    //   77	82	109	java/lang/Exception
    //   102	106	109	java/lang/Exception
    //   86	90	145	java/lang/Exception
    //   95	100	153	java/lang/Exception
    //   131	135	161	java/lang/Exception
    //   139	143	169	java/lang/Exception
    //   15	23	177	finally
    //   122	127	177	finally
    //   183	188	200	java/lang/Exception
    //   193	198	208	java/lang/Exception
    //   23	33	216	finally
    //   33	39	227	finally
    //   45	49	227	finally
    //   57	65	227	finally
    //   69	77	227	finally
    //   77	82	227	finally
    //   102	106	227	finally
    //   15	23	234	java/lang/Exception
    //   23	33	245	java/lang/Exception
  }
  
  public static int setLoginExtraData(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || ((paramArrayOfByte.length != 21) && (paramArrayOfByte.length != 33))) {}
    do
    {
      return -1;
      paramArrayOfByte = getExtraDataFromBuffer(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    return updateCachedExtraDataFile(paramContext, paramArrayOfByte);
  }
  
  private static int updateCachedExtraDataFile(Context paramContext, LoginExtraData paramLoginExtraData)
  {
    List localList = loadExtraDataFromFile(paramContext, 0);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    try
    {
      if (((List)localObject).size() < 3) {
        ((List)localObject).add(paramLoginExtraData);
      }
      for (;;)
      {
        return updateFile(paramContext, (List)localObject);
        int k = 0;
        j = ((LoginExtraData)((List)localObject).get(0)).mTime;
        int n = ((List)localObject).size();
        i = 1;
        if (i < n)
        {
          m = j;
          if (j <= ((LoginExtraData)((List)localObject).get(i)).mTime) {
            break;
          }
          m = ((LoginExtraData)((List)localObject).get(i)).mTime;
          k = i;
          break;
        }
        ((List)localObject).set(k, paramLoginExtraData);
      }
    }
    catch (Exception paramLoginExtraData)
    {
      for (;;)
      {
        int i;
        int m;
        paramLoginExtraData.printStackTrace();
        continue;
        i += 1;
        int j = m;
      }
    }
  }
  
  /* Error */
  private static int updateFile(Context paramContext, List<LoginExtraData> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload 4
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 187	com/tencent/loginsecsdk/ProtocolDet:getCachedDetFileFullPath	(Landroid/content/Context;)Ljava/lang/String;
    //   12: astore_0
    //   13: aload 4
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 182	com/tencent/loginsecsdk/ProtocolDet:convertExtraDataListToBuffer	(Ljava/util/List;)[B
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +24 -> 46
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 193	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: iconst_m1
    //   38: ireturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   44: iconst_m1
    //   45: ireturn
    //   46: aload 4
    //   48: astore_2
    //   49: new 238	java/io/FileOutputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 239	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   57: astore_0
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 240	java/io/FileOutputStream:write	([B)V
    //   63: aload_0
    //   64: ifnull +76 -> 140
    //   67: aload_0
    //   68: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   78: goto -7 -> 71
    //   81: astore_1
    //   82: aload_3
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: aload_1
    //   87: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   90: aload_0
    //   91: ifnull -20 -> 71
    //   94: aload_0
    //   95: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   98: goto -27 -> 71
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   106: goto -35 -> 71
    //   109: astore_0
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   125: goto -7 -> 118
    //   128: astore_1
    //   129: aload_0
    //   130: astore_2
    //   131: aload_1
    //   132: astore_0
    //   133: goto -23 -> 110
    //   136: astore_1
    //   137: goto -53 -> 84
    //   140: goto -69 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   0	143	1	paramList	List<LoginExtraData>
    //   7	124	2	localObject1	Object
    //   4	79	3	localObject2	Object
    //   1	46	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	37	39	java/lang/Exception
    //   67	71	73	java/lang/Exception
    //   8	13	81	java/lang/Exception
    //   16	21	81	java/lang/Exception
    //   49	58	81	java/lang/Exception
    //   94	98	101	java/lang/Exception
    //   8	13	109	finally
    //   16	21	109	finally
    //   49	58	109	finally
    //   86	90	109	finally
    //   114	118	120	java/lang/Exception
    //   58	63	128	finally
    //   58	63	136	java/lang/Exception
  }
  
  private static class LoginExtraData
  {
    byte[] mIp;
    int mTime;
    long mUin;
    int mVersion;
    byte mlen;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.loginsecsdk.ProtocolDet
 * JD-Core Version:    0.7.0.1
 */