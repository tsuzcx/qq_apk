package com.tencent.mobileqq.log;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.File;
import jdg;

public abstract class ReportLogHelper
{
  static String a = "";
  static String b = "";
  static String c = "";
  
  public static ProgressDialog a(Context paramContext, int paramInt)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130841600);
    paramContext = new ProgressDialog(paramContext, 2131558902);
    paramContext.show();
    paramContext.getWindow().setContentView(2130903050);
    paramContext.setContentView(2130903050);
    ((TextView)paramContext.findViewById(2131296606)).setText(paramInt);
    ((ProgressBar)paramContext.findViewById(2131296605)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      paramContext = new File(Environment.getExternalStorageDirectory().getPath() + paramString);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static void a(Activity paramActivity, String paramString, Handler paramHandler)
  {
    paramHandler.post(new jdg(paramActivity, paramString));
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 148	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +28 -> 38
    //   13: aload 4
    //   15: ldc 150
    //   17: invokevirtual 154	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   20: istore_3
    //   21: iload_3
    //   22: ifeq +16 -> 38
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 156	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: return
    //   38: new 95	java/io/File
    //   41: dup
    //   42: getstatic 162	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   45: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 118	java/io/File:exists	()Z
    //   55: ifne +9 -> 64
    //   58: aload 4
    //   60: invokevirtual 121	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: new 164	java/io/FileWriter
    //   67: dup
    //   68: new 95	java/io/File
    //   71: dup
    //   72: new 101	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   79: getstatic 162	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   82: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 166
    //   87: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: iconst_1
    //   97: invokespecial 169	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   100: astore 4
    //   102: aload 4
    //   104: new 101	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   111: ldc 171
    //   113: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: getstatic 14	com/tencent/mobileqq/log/ReportLogHelper:a	Ljava/lang/String;
    //   119: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 173
    //   124: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 16	com/tencent/mobileqq/log/ReportLogHelper:b	Ljava/lang/String;
    //   130: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 175
    //   135: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: getstatic 18	com/tencent/mobileqq/log/ReportLogHelper:c	Ljava/lang/String;
    //   141: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 177
    //   146: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 179
    //   151: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   160: aload 4
    //   162: ldc 184
    //   164: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   167: new 186	android/text/format/Time
    //   170: dup
    //   171: invokespecial 187	android/text/format/Time:<init>	()V
    //   174: astore 5
    //   176: aload 5
    //   178: invokevirtual 190	android/text/format/Time:setToNow	()V
    //   181: aload 4
    //   183: new 101	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   190: aload 5
    //   192: ldc 192
    //   194: invokevirtual 196	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 198
    //   202: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: ldc 200
    //   215: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   218: aload 4
    //   220: ldc 184
    //   222: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   225: aload_0
    //   226: ifnull +32 -> 258
    //   229: aload 4
    //   231: new 101	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   238: ldc 202
    //   240: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_0
    //   244: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc 204
    //   249: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   258: aload 4
    //   260: aload_1
    //   261: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: ldc 184
    //   268: invokevirtual 182	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   271: aload 4
    //   273: invokevirtual 207	java/io/FileWriter:close	()V
    //   276: iconst_0
    //   277: ifeq -240 -> 37
    //   280: new 156	java/lang/NullPointerException
    //   283: dup
    //   284: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   287: athrow
    //   288: astore_0
    //   289: return
    //   290: astore_1
    //   291: aload 5
    //   293: astore_0
    //   294: aload_1
    //   295: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   298: aload_0
    //   299: ifnull -262 -> 37
    //   302: aload_0
    //   303: invokevirtual 207	java/io/FileWriter:close	()V
    //   306: return
    //   307: astore_0
    //   308: return
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_1
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 207	java/io/FileWriter:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_0
    //   323: return
    //   324: astore_1
    //   325: goto -5 -> 320
    //   328: astore_0
    //   329: aload 4
    //   331: astore_1
    //   332: goto -20 -> 312
    //   335: astore 4
    //   337: aload_0
    //   338: astore_1
    //   339: aload 4
    //   341: astore_0
    //   342: goto -30 -> 312
    //   345: astore_1
    //   346: aload 4
    //   348: astore_0
    //   349: goto -55 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramString1	String
    //   0	352	1	paramString2	String
    //   0	352	2	paramBoolean	boolean
    //   20	2	3	i	int
    //   6	324	4	localObject1	Object
    //   335	12	4	localObject2	Object
    //   1	291	5	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   280	288	288	java/lang/Exception
    //   3	8	290	java/lang/Exception
    //   13	21	290	java/lang/Exception
    //   38	64	290	java/lang/Exception
    //   64	102	290	java/lang/Exception
    //   302	306	307	java/lang/Exception
    //   3	8	309	finally
    //   13	21	309	finally
    //   38	64	309	finally
    //   64	102	309	finally
    //   29	37	322	java/lang/Exception
    //   316	320	324	java/lang/Exception
    //   102	225	328	finally
    //   229	258	328	finally
    //   258	276	328	finally
    //   294	298	335	finally
    //   102	225	345	java/lang/Exception
    //   229	258	345	java/lang/Exception
    //   258	276	345	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLogHelper
 * JD-Core Version:    0.7.0.1
 */