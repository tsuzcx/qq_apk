package oicq.wlogin_sdk.report.event;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import oicq.wlogin_sdk.report.c;
import oicq.wlogin_sdk.tools.util;

public class EventSaver
{
  public static final String EVENT_ITEM_SPLIT = ";";
  public static final String WLOGIN_SP_EVENT = "WLOGIN_EVENT";
  
  public static void saveEvent(b paramb)
  {
    c.b(paramb);
  }
  
  public void realClearEvent(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = paramContext.getSharedPreferences("WLOGIN_EVENT", 4).edit();
        paramContext.putString(paramString, "");
        paramContext.commit();
        util.LOGI(util.LOG_TAG_EVENT_REPORT + "realClearEvent eventType=" + paramString, "");
      }
      finally {}
    }
  }
  
  public String realReadEvent(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        util.LOGI(util.LOG_TAG_EVENT_REPORT + "realReadEvent eventType=" + paramString, "");
        paramContext = paramContext.getSharedPreferences("WLOGIN_EVENT", 4).getString(paramString, "");
      }
      finally {}
    }
  }
  
  /* Error */
  public void realSaveItem(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +21 -> 24
    //   6: aload_2
    //   7: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +14 -> 24
    //   13: aload_3
    //   14: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore 4
    //   19: iload 4
    //   21: ifeq +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: ldc 11
    //   30: iconst_4
    //   31: invokevirtual 31	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   34: astore 5
    //   36: aload 5
    //   38: aload_2
    //   39: ldc 39
    //   41: invokeinterface 79 3 0
    //   46: astore 6
    //   48: aload_3
    //   49: astore_1
    //   50: aload 6
    //   52: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +28 -> 83
    //   58: new 51	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   65: aload 6
    //   67: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 8
    //   72: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_1
    //   83: aload 5
    //   85: invokeinterface 37 1 0
    //   90: astore_3
    //   91: aload_3
    //   92: aload_2
    //   93: aload_1
    //   94: invokeinterface 45 3 0
    //   99: pop
    //   100: aload_3
    //   101: invokeinterface 49 1 0
    //   106: pop
    //   107: new 51	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   114: getstatic 57	oicq/wlogin_sdk/tools/util:LOG_TAG_EVENT_REPORT	Ljava/lang/String;
    //   117: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 89
    //   122: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 91
    //   131: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: ldc 39
    //   143: invokestatic 71	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: goto -122 -> 24
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	EventSaver
    //   0	154	1	paramContext	Context
    //   0	154	2	paramString1	String
    //   0	154	3	paramString2	String
    //   17	3	4	bool	boolean
    //   34	50	5	localSharedPreferences	SharedPreferences
    //   46	20	6	str	String
    // Exception table:
    //   from	to	target	type
    //   6	19	149	finally
    //   27	48	149	finally
    //   50	83	149	finally
    //   83	146	149	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.EventSaver
 * JD-Core Version:    0.7.0.1
 */