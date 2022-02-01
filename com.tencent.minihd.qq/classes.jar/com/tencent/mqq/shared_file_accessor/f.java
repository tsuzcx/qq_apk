package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;

final class f
  implements h
{
  private WeakReference a = null;
  private Uri b = null;
  
  public f(WeakReference paramWeakReference, String paramString)
  {
    this.a = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl.2/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    this.b = Uri.parse(paramWeakReference);
  }
  
  private static Object a(Cursor paramCursor, e parame)
  {
    boolean bool = true;
    if (paramCursor == null) {
      return null;
    }
    try
    {
      switch (parame.a)
      {
      case 0: 
        if (paramCursor.getCount() == 0) {
          break;
        }
      case 5: 
      case 3: 
      case 1: 
      case 2: 
      case 4: 
        for (;;)
        {
          return Boolean.valueOf(bool);
          if (paramCursor.getInt(0) != 0) {
            return Boolean.valueOf(true);
          }
          return Boolean.valueOf(false);
          return Float.valueOf(paramCursor.getFloat(0));
          return Integer.valueOf(paramCursor.getInt(0));
          return Long.valueOf(paramCursor.getLong(0));
          paramCursor = paramCursor.getString(0);
          return paramCursor;
          bool = false;
        }
      }
      return null;
    }
    catch (Exception paramCursor)
    {
      return null;
    }
  }
  
  /* Error */
  public final Object a(String paramString, e parame, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mqq/shared_file_accessor/f:a	Ljava/lang/ref/WeakReference;
    //   4: ifnonnull +5 -> 9
    //   7: aload_3
    //   8: areturn
    //   9: aload_0
    //   10: getfield 17	com/tencent/mqq/shared_file_accessor/f:a	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 105	android/content/Context
    //   19: astore 5
    //   21: aload 5
    //   23: ifnull -16 -> 7
    //   26: aload 5
    //   28: invokevirtual 109	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_0
    //   32: getfield 19	com/tencent/mqq/shared_file_accessor/f:b	Landroid/net/Uri;
    //   35: bipush 6
    //   37: anewarray 111	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 113
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: ldc 115
    //   53: aastore
    //   54: dup
    //   55: iconst_3
    //   56: aload_2
    //   57: getfield 51	com/tencent/mqq/shared_file_accessor/e:a	I
    //   60: invokestatic 117	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_4
    //   66: ldc 28
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: aload_3
    //   72: invokestatic 120	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 126	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull -77 -> 7
    //   87: aload_1
    //   88: invokeinterface 130 1 0
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +17 -> 114
    //   100: aload_1
    //   101: invokeinterface 133 1 0
    //   106: aload_3
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_1
    //   111: goto -28 -> 83
    //   114: aload_1
    //   115: aload_2
    //   116: invokestatic 135	com/tencent/mqq/shared_file_accessor/f:a	(Landroid/database/Cursor;Lcom/tencent/mqq/shared_file_accessor/e;)Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +11 -> 132
    //   124: aload_1
    //   125: invokeinterface 133 1 0
    //   130: aload_2
    //   131: areturn
    //   132: aload_1
    //   133: invokeinterface 133 1 0
    //   138: aload_3
    //   139: areturn
    //   140: astore_2
    //   141: aload_1
    //   142: invokeinterface 133 1 0
    //   147: aload_3
    //   148: areturn
    //   149: astore_2
    //   150: aload_1
    //   151: invokeinterface 133 1 0
    //   156: aload_2
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	f
    //   0	158	1	paramString	String
    //   0	158	2	parame	e
    //   0	158	3	paramObject	Object
    //   93	3	4	bool	boolean
    //   19	8	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   26	83	108	java/lang/Exception
    //   87	95	140	java/lang/Throwable
    //   114	120	140	java/lang/Throwable
    //   87	95	149	finally
    //   114	120	149	finally
  }
  
  public final void a() {}
  
  public final void a(String paramString)
  {
    if (this.a == null) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.a.get();
    } while (localContext == null);
    try
    {
      localContext.getContentResolver().delete(this.b, paramString, null);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(String paramString, Object paramObject, e parame)
  {
    if (this.a == null) {}
    do
    {
      return;
      parame = (Context)this.a.get();
    } while (parame == null);
    if (paramObject == null)
    {
      a(paramString);
      return;
    }
    try
    {
      parame = parame.getContentResolver();
      Uri localUri = this.b;
      ContentValues localContentValues = new ContentValues(1);
      if ((paramObject instanceof Integer)) {
        localContentValues.put(paramString, (Integer)paramObject);
      }
      for (;;)
      {
        parame.insert(localUri, localContentValues);
        return;
        if ((paramObject instanceof Long)) {
          localContentValues.put(paramString, (Long)paramObject);
        } else if ((paramObject instanceof Float)) {
          localContentValues.put(paramString, (Float)paramObject);
        } else if ((paramObject instanceof String)) {
          localContentValues.put(paramString, (String)paramObject);
        } else if ((paramObject instanceof Boolean)) {
          localContentValues.put(paramString, (Boolean)paramObject);
        } else {
          localContentValues.put(paramString, "");
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final Map b()
  {
    return null;
  }
  
  public final void b(String paramString)
  {
    a("*");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.f
 * JD-Core Version:    0.7.0.1
 */