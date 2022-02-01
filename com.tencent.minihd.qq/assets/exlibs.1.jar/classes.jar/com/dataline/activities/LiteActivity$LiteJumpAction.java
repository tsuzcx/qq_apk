package com.dataline.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class LiteActivity$LiteJumpAction
{
  private LiteActivity b;
  
  public LiteActivity$LiteJumpAction(LiteActivity paramLiteActivity1, LiteActivity paramLiteActivity2)
  {
    this.b = paramLiteActivity2;
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 26	android/net/Uri:getScheme	()Ljava/lang/String;
    //   6: astore 4
    //   8: aload 4
    //   10: ldc 28
    //   12: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +20 -> 35
    //   18: new 36	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokevirtual 39	android/net/Uri:getPath	()Ljava/lang/String;
    //   26: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: areturn
    //   35: aload 4
    //   37: ldc 47
    //   39: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +110 -> 152
    //   45: aload_0
    //   46: getfield 16	com/dataline/activities/LiteActivity$LiteJumpAction:b	Lcom/dataline/activities/LiteActivity;
    //   49: invokevirtual 53	com/dataline/activities/LiteActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   52: aload_1
    //   53: iconst_1
    //   54: anewarray 30	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: ldc 55
    //   61: aastore
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 61	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_3
    //   71: aload_1
    //   72: ldc 55
    //   74: invokeinterface 67 2 0
    //   79: istore_2
    //   80: aload_1
    //   81: astore_3
    //   82: aload_1
    //   83: invokeinterface 71 1 0
    //   88: pop
    //   89: aload_1
    //   90: astore_3
    //   91: aload_1
    //   92: iload_2
    //   93: invokeinterface 75 2 0
    //   98: astore 4
    //   100: aload 4
    //   102: astore_3
    //   103: aload_1
    //   104: ifnull -71 -> 33
    //   107: aload_1
    //   108: invokeinterface 78 1 0
    //   113: aload 4
    //   115: areturn
    //   116: astore 4
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: astore_3
    //   122: aload 4
    //   124: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull +35 -> 163
    //   131: aload_1
    //   132: invokeinterface 78 1 0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_1
    //   140: aload_3
    //   141: ifnull +9 -> 150
    //   144: aload_3
    //   145: invokeinterface 78 1 0
    //   150: aload_1
    //   151: athrow
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: goto -15 -> 140
    //   158: astore 4
    //   160: goto -40 -> 120
    //   163: aconst_null
    //   164: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	LiteJumpAction
    //   0	165	1	paramUri	Uri
    //   79	14	2	i	int
    //   1	144	3	localObject	Object
    //   6	108	4	str	String
    //   116	7	4	localException1	java.lang.Exception
    //   158	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   45	69	116	java/lang/Exception
    //   45	69	139	finally
    //   71	80	154	finally
    //   82	89	154	finally
    //   91	100	154	finally
    //   122	127	154	finally
    //   71	80	158	java/lang/Exception
    //   82	89	158	java/lang/Exception
    //   91	100	158	java/lang/Exception
  }
  
  private void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      LiteActivity.a(this.a);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = a((Uri)paramArrayList.next());
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      LiteActivity.a(this.a, localArrayList, i);
      return;
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramIntent.putExtra("dataline_share_finish", true);
      ((Bundle)localObject).getString("android.intent.extra.TITLE");
      ((Bundle)localObject).getString("android.intent.extra.SUBJECT");
      str1 = ((Bundle)localObject).getString("android.intent.extra.TEXT");
      ((Bundle)localObject).getString("image_url");
      ((Bundle)localObject).getString("detail_url");
      str2 = paramIntent.getType();
    } while (TextUtils.isEmpty(str2));
    if ((str2.startsWith("text")) && (!((Bundle)localObject).containsKey("android.intent.extra.STREAM")))
    {
      LiteActivity.a(this.b, str1);
      return;
    }
    if (str2.startsWith("message"))
    {
      paramIntent = (SpannableString)((Bundle)localObject).get("android.intent.extra.TEXT");
      LiteActivity.a(this.b, paramIntent.toString());
      return;
    }
    if (str2.startsWith("image"))
    {
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)((Bundle)localObject).get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.a(this.a);
          return;
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent);
        a((ArrayList)localObject, true);
        return;
      }
      a((ArrayList)((Bundle)localObject).get("android.intent.extra.STREAM"), true);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SEND"))
    {
      paramIntent = (Uri)((Bundle)localObject).get("android.intent.extra.STREAM");
      if (paramIntent == null)
      {
        LiteActivity.a(this.a);
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramIntent);
      a((ArrayList)localObject, false);
      return;
    }
    a((ArrayList)((Bundle)localObject).get("android.intent.extra.STREAM"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.LiteJumpAction
 * JD-Core Version:    0.7.0.1
 */