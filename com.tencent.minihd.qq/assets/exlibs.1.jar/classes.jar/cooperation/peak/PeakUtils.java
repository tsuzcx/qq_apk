package cooperation.peak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public final class PeakUtils
{
  public static final int a = 5000;
  public static final SparseBooleanArray a;
  public static final String a = "PEAK";
  public static final int[] a;
  public static final String b = "extra.CAN_FORWARD_TO_GROUP_ALBUM";
  public static final String c = "extra.EXTRA_FORWARD_TO_QZONE_SRC";
  public static final String d = "extra.GROUP_UIN";
  public static final String e = "extra.GROUP_CODE";
  public static final String f = "KEY_THUMBNAL_BOUND";
  public static final String g = "PhotoConst.MAXUM_SELECTED_NUM";
  public static final String h = "PhotoConst.IS_SINGLE_MODE";
  public static final String i = "PhotoConst.IS_CONTAIN_GIF";
  public static final String j = "extra.IS_FROM_MULTI_MSG";
  public static final String k = "extra.AIO_CURRENT_PANEL_STATE";
  public static final String l = "extra.MOBILE_QQ_PROCESS_ID";
  public static final String m = "extra.IMAGE_PROVIDER";
  public static final String n = "extra.EXTRA_CURRENT_IMAGE";
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    jdField_a_of_type_ArrayOfInt = new int[] { 5, 7, 9 };
    int i1 = 0;
    if (i1 < 10)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i3 = arrayOfInt.length;
      i2 = 0;
      label47:
      if (i2 >= i3) {
        break label98;
      }
      if (i1 == arrayOfInt[i2] - 1) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i1, true);
      }
    }
    label98:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0) {
        jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i1, false);
      }
      i1 += 1;
      break;
      i2 += 1;
      break label47;
      return;
    }
  }
  
  /* Error */
  public static java.util.ArrayList a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 73	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 80	java/io/File:exists	()Z
    //   22: ifeq -15 -> 7
    //   25: invokestatic 84	com/tencent/mobileqq/utils/LogTag:a	()V
    //   28: new 86	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 90	java/io/File:length	()J
    //   36: l2i
    //   37: invokespecial 93	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 7
    //   42: new 95	java/io/BufferedInputStream
    //   45: dup
    //   46: new 97	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 103	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: astore_0
    //   62: sipush 1024
    //   65: newarray byte
    //   67: astore 5
    //   69: aload 4
    //   71: astore_0
    //   72: aload 4
    //   74: aload 5
    //   76: iconst_0
    //   77: sipush 1024
    //   80: invokevirtual 107	java/io/BufferedInputStream:read	([BII)I
    //   83: istore_1
    //   84: iconst_m1
    //   85: iload_1
    //   86: if_icmpeq +117 -> 203
    //   89: aload 4
    //   91: astore_0
    //   92: aload 7
    //   94: aload 5
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 111	java/io/ByteArrayOutputStream:write	([BII)V
    //   101: goto -32 -> 69
    //   104: astore 5
    //   106: aload 4
    //   108: astore_0
    //   109: aload 5
    //   111: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   114: aload 4
    //   116: ifnull +205 -> 321
    //   119: aload 4
    //   121: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   124: iconst_0
    //   125: istore_1
    //   126: aload 6
    //   128: astore_0
    //   129: iload_1
    //   130: ifeq +59 -> 189
    //   133: new 119	java/util/ArrayList
    //   136: dup
    //   137: bipush 10
    //   139: invokespecial 120	java/util/ArrayList:<init>	(I)V
    //   142: astore 4
    //   144: aload 7
    //   146: invokevirtual 124	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   149: astore 5
    //   151: aload 5
    //   153: arraylength
    //   154: istore_3
    //   155: iconst_0
    //   156: istore_1
    //   157: aload 4
    //   159: astore_0
    //   160: iload_1
    //   161: iload_3
    //   162: if_icmpge +27 -> 189
    //   165: iload_1
    //   166: iconst_1
    //   167: iadd
    //   168: istore_2
    //   169: aload 5
    //   171: iload_1
    //   172: baload
    //   173: iconst_m1
    //   174: if_icmpne +142 -> 316
    //   177: aload 5
    //   179: iload_2
    //   180: baload
    //   181: bipush 217
    //   183: if_icmpne +82 -> 265
    //   186: aload 4
    //   188: astore_0
    //   189: aload 7
    //   191: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   194: ldc 127
    //   196: ldc 129
    //   198: invokestatic 132	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: areturn
    //   203: iconst_1
    //   204: istore_2
    //   205: iload_2
    //   206: istore_1
    //   207: aload 4
    //   209: ifnull -83 -> 126
    //   212: aload 4
    //   214: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   217: iload_2
    //   218: istore_1
    //   219: goto -93 -> 126
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   227: iload_2
    //   228: istore_1
    //   229: goto -103 -> 126
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   237: iconst_0
    //   238: istore_1
    //   239: goto -113 -> 126
    //   242: astore 4
    //   244: aconst_null
    //   245: astore_0
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   254: aload 4
    //   256: athrow
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   262: goto -8 -> 254
    //   265: aload 5
    //   267: iload_2
    //   268: baload
    //   269: bipush 218
    //   271: if_icmpne +45 -> 316
    //   274: aload 4
    //   276: iload_2
    //   277: iconst_1
    //   278: isub
    //   279: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: invokevirtual 142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: iload_2
    //   287: iconst_1
    //   288: iadd
    //   289: istore_1
    //   290: goto -133 -> 157
    //   293: astore 4
    //   295: aload 4
    //   297: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   300: goto -106 -> 194
    //   303: astore 4
    //   305: goto -59 -> 246
    //   308: astore 5
    //   310: aconst_null
    //   311: astore 4
    //   313: goto -207 -> 106
    //   316: iload_2
    //   317: istore_1
    //   318: goto -161 -> 157
    //   321: iconst_0
    //   322: istore_1
    //   323: goto -197 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString	String
    //   83	240	1	i1	int
    //   168	149	2	i2	int
    //   154	9	3	i3	int
    //   57	156	4	localObject1	Object
    //   242	33	4	localObject2	Object
    //   293	3	4	localIOException1	java.io.IOException
    //   303	1	4	localObject3	Object
    //   311	1	4	localObject4	Object
    //   67	28	5	arrayOfByte1	byte[]
    //   104	6	5	localIOException2	java.io.IOException
    //   149	117	5	arrayOfByte2	byte[]
    //   308	1	5	localIOException3	java.io.IOException
    //   1	126	6	localObject5	Object
    //   40	150	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	69	104	java/io/IOException
    //   72	84	104	java/io/IOException
    //   92	101	104	java/io/IOException
    //   212	217	222	java/io/IOException
    //   119	124	232	java/io/IOException
    //   42	59	242	finally
    //   250	254	257	java/io/IOException
    //   189	194	293	java/io/IOException
    //   62	69	303	finally
    //   72	84	303	finally
    //   92	101	303	finally
    //   109	114	303	finally
    //   42	59	308	java/io/IOException
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(BaseApplicationImpl.a, PhotoListActivity.class);
    paramBundle.putExtras(localBundle);
    paramActivity.startActivityForResult(paramBundle, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "enterPhotoPicker");
    }
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, IAIOImageProvider paramIAIOImageProvider, AIOImageData paramAIOImageData)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramContext, AIOGalleryActivity.class);
    paramBundle.addFlags(603979776);
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramIAIOImageProvider.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIOImageData);
    paramBundle.putExtras(localBundle);
    paramContext.startActivity(paramBundle);
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 8
    //   18: aload_0
    //   19: ifnonnull +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: new 73	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 80	java/io/File:exists	()Z
    //   39: ifeq -17 -> 22
    //   42: aload_0
    //   43: invokestatic 221	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/lang/String;)Z
    //   46: ifeq -24 -> 22
    //   49: invokestatic 84	com/tencent/mobileqq/utils/LogTag:a	()V
    //   52: new 97	java/io/FileInputStream
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore 5
    //   63: aload 11
    //   65: astore 6
    //   67: aload 10
    //   69: astore 7
    //   71: aload 9
    //   73: astore 8
    //   75: aload 5
    //   77: invokevirtual 225	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   80: astore_0
    //   81: aload_0
    //   82: astore 6
    //   84: aload_0
    //   85: astore 7
    //   87: aload_0
    //   88: astore 8
    //   90: aload_0
    //   91: getstatic 231	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   94: lconst_0
    //   95: aload_0
    //   96: invokevirtual 236	java/nio/channels/FileChannel:size	()J
    //   99: invokevirtual 240	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   102: astore 9
    //   104: aload_0
    //   105: astore 6
    //   107: aload_0
    //   108: astore 7
    //   110: aload_0
    //   111: astore 8
    //   113: aload_0
    //   114: invokevirtual 236	java/nio/channels/FileChannel:size	()J
    //   117: l2i
    //   118: istore_3
    //   119: iconst_0
    //   120: istore_1
    //   121: iload_1
    //   122: iload_3
    //   123: if_icmpge +364 -> 487
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: aload_0
    //   131: astore 6
    //   133: aload_0
    //   134: astore 7
    //   136: aload_0
    //   137: astore 8
    //   139: aload 9
    //   141: iload_1
    //   142: invokevirtual 246	java/nio/MappedByteBuffer:get	(I)B
    //   145: iconst_m1
    //   146: if_icmpne +336 -> 482
    //   149: iload_2
    //   150: iload_3
    //   151: if_icmpge +331 -> 482
    //   154: iload_2
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: aload_0
    //   159: astore 6
    //   161: aload_0
    //   162: astore 7
    //   164: aload_0
    //   165: astore 8
    //   167: aload 9
    //   169: iload_2
    //   170: invokevirtual 246	java/nio/MappedByteBuffer:get	(I)B
    //   173: istore_2
    //   174: iload_2
    //   175: bipush 194
    //   177: if_icmpeq +21 -> 198
    //   180: iload_2
    //   181: bipush 198
    //   183: if_icmpeq +15 -> 198
    //   186: iload_2
    //   187: bipush 202
    //   189: if_icmpeq +9 -> 198
    //   192: iload_2
    //   193: bipush 206
    //   195: if_icmpne -74 -> 121
    //   198: iconst_1
    //   199: istore 4
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   209: aload 5
    //   211: ifnull +268 -> 479
    //   214: aload 5
    //   216: invokevirtual 248	java/io/FileInputStream:close	()V
    //   219: ldc 127
    //   221: ldc 250
    //   223: invokestatic 132	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: iload 4
    //   228: ireturn
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   234: goto -25 -> 209
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   242: goto -23 -> 219
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_0
    //   248: aload 8
    //   250: ifnull +8 -> 258
    //   253: aload 8
    //   255: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   258: aload_0
    //   259: ifnull +214 -> 473
    //   262: aload_0
    //   263: invokevirtual 248	java/io/FileInputStream:close	()V
    //   266: iconst_0
    //   267: istore 4
    //   269: goto -50 -> 219
    //   272: astore 5
    //   274: aload 5
    //   276: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   279: goto -21 -> 258
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   287: iconst_0
    //   288: istore 4
    //   290: goto -71 -> 219
    //   293: astore_0
    //   294: aconst_null
    //   295: astore 5
    //   297: aload 7
    //   299: ifnull +8 -> 307
    //   302: aload 7
    //   304: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   307: aload 5
    //   309: ifnull +164 -> 473
    //   312: aload 5
    //   314: invokevirtual 248	java/io/FileInputStream:close	()V
    //   317: iconst_0
    //   318: istore 4
    //   320: goto -101 -> 219
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   328: goto -21 -> 307
    //   331: astore_0
    //   332: aload_0
    //   333: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   336: iconst_0
    //   337: istore 4
    //   339: goto -120 -> 219
    //   342: astore_0
    //   343: aconst_null
    //   344: astore 5
    //   346: aload 6
    //   348: ifnull +8 -> 356
    //   351: aload 6
    //   353: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   356: aload 5
    //   358: ifnull +115 -> 473
    //   361: aload 5
    //   363: invokevirtual 248	java/io/FileInputStream:close	()V
    //   366: iconst_0
    //   367: istore 4
    //   369: goto -150 -> 219
    //   372: astore_0
    //   373: aload_0
    //   374: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   377: goto -21 -> 356
    //   380: astore_0
    //   381: aload_0
    //   382: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   385: iconst_0
    //   386: istore 4
    //   388: goto -169 -> 219
    //   391: astore_0
    //   392: aconst_null
    //   393: astore 5
    //   395: aconst_null
    //   396: astore 6
    //   398: aload 6
    //   400: ifnull +8 -> 408
    //   403: aload 6
    //   405: invokevirtual 247	java/nio/channels/FileChannel:close	()V
    //   408: aload 5
    //   410: ifnull +8 -> 418
    //   413: aload 5
    //   415: invokevirtual 248	java/io/FileInputStream:close	()V
    //   418: aload_0
    //   419: athrow
    //   420: astore 6
    //   422: aload 6
    //   424: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   427: goto -19 -> 408
    //   430: astore 5
    //   432: aload 5
    //   434: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   437: goto -19 -> 418
    //   440: astore_0
    //   441: aconst_null
    //   442: astore 6
    //   444: goto -46 -> 398
    //   447: astore 7
    //   449: aload_0
    //   450: astore 6
    //   452: aload 7
    //   454: astore_0
    //   455: goto -57 -> 398
    //   458: astore_0
    //   459: goto -113 -> 346
    //   462: astore_0
    //   463: goto -166 -> 297
    //   466: astore_0
    //   467: aload 5
    //   469: astore_0
    //   470: goto -222 -> 248
    //   473: iconst_0
    //   474: istore 4
    //   476: goto -257 -> 219
    //   479: goto -260 -> 219
    //   482: iload_2
    //   483: istore_1
    //   484: goto -363 -> 121
    //   487: iconst_0
    //   488: istore 4
    //   490: goto -289 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	paramString	String
    //   120	364	1	i1	int
    //   129	354	2	i2	int
    //   118	34	3	i3	int
    //   199	290	4	bool	boolean
    //   32	183	5	localObject1	Object
    //   272	3	5	localIOException1	java.io.IOException
    //   295	119	5	localObject2	Object
    //   430	38	5	localIOException2	java.io.IOException
    //   4	400	6	localObject3	Object
    //   420	3	6	localIOException3	java.io.IOException
    //   442	9	6	str	String
    //   1	302	7	localObject4	Object
    //   447	6	7	localObject5	Object
    //   16	238	8	localObject6	Object
    //   13	155	9	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   10	58	10	localObject7	Object
    //   7	57	11	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   205	209	229	java/io/IOException
    //   214	219	237	java/io/IOException
    //   52	63	245	java/io/FileNotFoundException
    //   253	258	272	java/io/IOException
    //   262	266	282	java/io/IOException
    //   52	63	293	java/io/IOException
    //   302	307	323	java/io/IOException
    //   312	317	331	java/io/IOException
    //   52	63	342	java/lang/IndexOutOfBoundsException
    //   351	356	372	java/io/IOException
    //   361	366	380	java/io/IOException
    //   52	63	391	finally
    //   403	408	420	java/io/IOException
    //   413	418	430	java/io/IOException
    //   75	81	440	finally
    //   90	104	447	finally
    //   113	119	447	finally
    //   139	149	447	finally
    //   167	174	447	finally
    //   75	81	458	java/lang/IndexOutOfBoundsException
    //   90	104	458	java/lang/IndexOutOfBoundsException
    //   113	119	458	java/lang/IndexOutOfBoundsException
    //   139	149	458	java/lang/IndexOutOfBoundsException
    //   167	174	458	java/lang/IndexOutOfBoundsException
    //   75	81	462	java/io/IOException
    //   90	104	462	java/io/IOException
    //   113	119	462	java/io/IOException
    //   139	149	462	java/io/IOException
    //   167	174	462	java/io/IOException
    //   75	81	466	java/io/FileNotFoundException
    //   90	104	466	java/io/FileNotFoundException
    //   113	119	466	java/io/FileNotFoundException
    //   139	149	466	java/io/FileNotFoundException
    //   167	174	466	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.peak.PeakUtils
 * JD-Core Version:    0.7.0.1
 */