package com.tencent.tmassistant;

import android.content.Context;
import com.tencent.tmassistantsdk.internal.b.b;
import java.util.ArrayList;
import java.util.Iterator;

public class e
{
  protected static e a = null;
  protected static ArrayList c = new ArrayList();
  protected static ArrayList d = new ArrayList();
  protected Context b = null;
  
  protected e(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new e(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public b a(String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = d.iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          boolean bool = localb.c.equals(paramString);
          if (bool == true)
          {
            paramString = localb;
            return paramString;
          }
        }
        else
        {
          paramString = new b(this.b, paramString, "com.tencent.android.qqdownloader.SDKService");
          if (paramString.e()) {
            d.add(paramString);
          } else {
            paramString = null;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 22	com/tencent/tmassistant/e:c	Ljava/util/ArrayList;
    //   5: invokevirtual 37	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   8: astore_3
    //   9: aload_3
    //   10: invokeinterface 43 1 0
    //   15: ifeq +49 -> 64
    //   18: aload_3
    //   19: invokeinterface 47 1 0
    //   24: checkcast 72	com/tencent/tmassistant/b
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -22 -> 9
    //   34: aload 4
    //   36: getfield 73	com/tencent/tmassistant/b:c	Ljava/lang/String;
    //   39: aload_1
    //   40: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: iconst_1
    //   44: if_icmpne -35 -> 9
    //   47: aload 4
    //   49: invokevirtual 76	com/tencent/tmassistant/b:f	()V
    //   52: aload_3
    //   53: invokeinterface 79 1 0
    //   58: iconst_1
    //   59: istore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: iconst_0
    //   65: istore_2
    //   66: goto -6 -> 60
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	e
    //   0	74	1	paramString	String
    //   59	7	2	bool	boolean
    //   8	45	3	localIterator	Iterator
    //   27	21	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	9	69	finally
    //   9	29	69	finally
    //   34	58	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.e
 * JD-Core Version:    0.7.0.1
 */