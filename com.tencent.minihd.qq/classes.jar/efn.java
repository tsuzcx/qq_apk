import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.JumpActivity;

public class efn
  extends AsyncTask
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public efn(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  /* Error */
  protected Uri a(java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_1
    //   7: iconst_0
    //   8: aaload
    //   9: checkcast 24	android/content/Context
    //   12: astore 9
    //   14: aload_1
    //   15: iconst_1
    //   16: aaload
    //   17: checkcast 26	android/net/Uri
    //   20: astore 10
    //   22: getstatic 32	com/tencent/mobileqq/app/AppConstants:bc	Ljava/lang/String;
    //   25: astore 8
    //   27: aload 9
    //   29: invokevirtual 36	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   32: aload 10
    //   34: iconst_1
    //   35: anewarray 38	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc 40
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 46	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +467 -> 520
    //   56: aload 4
    //   58: invokeinterface 52 1 0
    //   63: ifeq +457 -> 520
    //   66: aload 4
    //   68: iconst_0
    //   69: invokeinterface 56 2 0
    //   74: astore_1
    //   75: aload_1
    //   76: astore 5
    //   78: aload_1
    //   79: astore_3
    //   80: aload 4
    //   82: invokeinterface 59 1 0
    //   87: aload_1
    //   88: astore 5
    //   90: aload_1
    //   91: astore_3
    //   92: aload 8
    //   94: invokestatic 64	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   97: ifne +21 -> 118
    //   100: aload_1
    //   101: astore 5
    //   103: aload_1
    //   104: astore_3
    //   105: new 66	java/io/File
    //   108: dup
    //   109: aload 8
    //   111: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 72	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: aload_1
    //   119: astore 5
    //   121: aload_1
    //   122: astore_3
    //   123: new 74	java/io/FileOutputStream
    //   126: dup
    //   127: new 66	java/io/File
    //   130: dup
    //   131: new 76	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   138: aload 8
    //   140: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   156: astore 4
    //   158: aload 9
    //   160: invokevirtual 36	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   163: aload 10
    //   165: ldc 90
    //   167: invokevirtual 94	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   170: invokevirtual 100	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   173: astore_3
    //   174: sipush 1024
    //   177: newarray byte
    //   179: astore 5
    //   181: aload_3
    //   182: aload 5
    //   184: invokevirtual 106	java/io/InputStream:read	([B)I
    //   187: istore_2
    //   188: iload_2
    //   189: iconst_m1
    //   190: if_icmpeq +76 -> 266
    //   193: aload 4
    //   195: aload 5
    //   197: iconst_0
    //   198: iload_2
    //   199: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   202: goto -21 -> 181
    //   205: astore 6
    //   207: aload 4
    //   209: astore 5
    //   211: aload 6
    //   213: astore 4
    //   215: aload 4
    //   217: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 114	java/io/InputStream:close	()V
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   238: new 76	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   245: ldc 117
    //   247: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 8
    //   252: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 121	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   265: areturn
    //   266: aload 4
    //   268: invokevirtual 124	java/io/FileOutputStream:flush	()V
    //   271: aload_3
    //   272: ifnull +7 -> 279
    //   275: aload_3
    //   276: invokevirtual 114	java/io/InputStream:close	()V
    //   279: aload 4
    //   281: ifnull +8 -> 289
    //   284: aload 4
    //   286: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   289: new 76	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   296: ldc 117
    //   298: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 8
    //   303: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 121	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   316: areturn
    //   317: astore_3
    //   318: aload_3
    //   319: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   322: goto -43 -> 279
    //   325: astore_3
    //   326: aload_3
    //   327: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   330: goto -41 -> 289
    //   333: astore_3
    //   334: aload_3
    //   335: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   338: goto -110 -> 228
    //   341: astore_3
    //   342: aload_3
    //   343: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   346: goto -108 -> 238
    //   349: astore_3
    //   350: ldc 127
    //   352: astore_1
    //   353: aconst_null
    //   354: astore 4
    //   356: aload 6
    //   358: astore 5
    //   360: aload 5
    //   362: ifnull +8 -> 370
    //   365: aload 5
    //   367: invokevirtual 114	java/io/InputStream:close	()V
    //   370: aload 4
    //   372: ifnull +8 -> 380
    //   375: aload 4
    //   377: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   380: new 76	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   387: ldc 117
    //   389: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload 8
    //   394: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_1
    //   398: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 121	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   407: pop
    //   408: aload_3
    //   409: athrow
    //   410: astore 5
    //   412: aload 5
    //   414: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   417: goto -47 -> 370
    //   420: astore 4
    //   422: aload 4
    //   424: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   427: goto -47 -> 380
    //   430: astore_3
    //   431: aconst_null
    //   432: astore 4
    //   434: aload 5
    //   436: astore_1
    //   437: aload 6
    //   439: astore 5
    //   441: goto -81 -> 360
    //   444: astore_3
    //   445: aload 6
    //   447: astore 5
    //   449: goto -89 -> 360
    //   452: astore 6
    //   454: aload_3
    //   455: astore 5
    //   457: aload 6
    //   459: astore_3
    //   460: goto -100 -> 360
    //   463: astore 6
    //   465: aload 5
    //   467: astore 4
    //   469: aload_3
    //   470: astore 5
    //   472: aload 6
    //   474: astore_3
    //   475: goto -115 -> 360
    //   478: astore 4
    //   480: ldc 127
    //   482: astore_1
    //   483: aconst_null
    //   484: astore_3
    //   485: aload 7
    //   487: astore 5
    //   489: goto -274 -> 215
    //   492: astore 4
    //   494: aload_3
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_3
    //   498: aload 7
    //   500: astore 5
    //   502: goto -287 -> 215
    //   505: astore 6
    //   507: aconst_null
    //   508: astore_3
    //   509: aload 4
    //   511: astore 5
    //   513: aload 6
    //   515: astore 4
    //   517: goto -302 -> 215
    //   520: ldc 127
    //   522: astore_1
    //   523: goto -436 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	this	efn
    //   0	526	1	paramVarArgs	java.lang.Object[]
    //   187	12	2	i	int
    //   79	197	3	localObject1	java.lang.Object
    //   317	2	3	localIOException1	java.io.IOException
    //   325	2	3	localIOException2	java.io.IOException
    //   333	2	3	localIOException3	java.io.IOException
    //   341	2	3	localIOException4	java.io.IOException
    //   349	60	3	localObject2	java.lang.Object
    //   430	1	3	localObject3	java.lang.Object
    //   444	11	3	localObject4	java.lang.Object
    //   459	50	3	localObject5	java.lang.Object
    //   49	327	4	localObject6	java.lang.Object
    //   420	3	4	localIOException5	java.io.IOException
    //   432	36	4	localObject7	java.lang.Object
    //   478	1	4	localException1	java.lang.Exception
    //   492	18	4	localException2	java.lang.Exception
    //   515	1	4	localException3	java.lang.Exception
    //   76	290	5	localObject8	java.lang.Object
    //   410	25	5	localIOException6	java.io.IOException
    //   439	73	5	localObject9	java.lang.Object
    //   1	1	6	localObject10	java.lang.Object
    //   205	241	6	localException4	java.lang.Exception
    //   452	6	6	localObject11	java.lang.Object
    //   463	10	6	localObject12	java.lang.Object
    //   505	9	6	localException5	java.lang.Exception
    //   4	495	7	localObject13	java.lang.Object
    //   25	368	8	str	java.lang.String
    //   12	147	9	localContext	android.content.Context
    //   20	144	10	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   174	181	205	java/lang/Exception
    //   181	188	205	java/lang/Exception
    //   193	202	205	java/lang/Exception
    //   266	271	205	java/lang/Exception
    //   275	279	317	java/io/IOException
    //   284	289	325	java/io/IOException
    //   224	228	333	java/io/IOException
    //   233	238	341	java/io/IOException
    //   27	51	349	finally
    //   56	75	349	finally
    //   365	370	410	java/io/IOException
    //   375	380	420	java/io/IOException
    //   80	87	430	finally
    //   92	100	430	finally
    //   105	118	430	finally
    //   123	158	430	finally
    //   158	174	444	finally
    //   174	181	452	finally
    //   181	188	452	finally
    //   193	202	452	finally
    //   266	271	452	finally
    //   215	220	463	finally
    //   27	51	478	java/lang/Exception
    //   56	75	478	java/lang/Exception
    //   80	87	492	java/lang/Exception
    //   92	100	492	java/lang/Exception
    //   105	118	492	java/lang/Exception
    //   123	158	492	java/lang/Exception
    //   158	174	505	java/lang/Exception
  }
  
  protected void a(Uri paramUri)
  {
    this.jdField_a_of_type_AndroidContentIntent.setData(paramUri);
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     efn
 * JD-Core Version:    0.7.0.1
 */