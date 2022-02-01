package com.tencent.tmdownloader.internal.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmdownloader.internal.b.c.b;
import com.tencent.tmdownloader.internal.b.c.c;

public class a
  extends d
{
  protected static d a = null;
  private static final Class[] b = { b.class, c.class, com.tencent.tmdownloader.internal.b.c.a.class };
  
  public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public static d c()
  {
    try
    {
      if (a == null)
      {
        localObject1 = f.a().b();
        if (localObject1 != null) {
          a = new a((Context)localObject1, "tmassistant_sdk_v2.db", null, 2);
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  public int a()
  {
    return 2;
  }
  
  public Class[] b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.b.a.a
 * JD-Core Version:    0.7.0.1
 */