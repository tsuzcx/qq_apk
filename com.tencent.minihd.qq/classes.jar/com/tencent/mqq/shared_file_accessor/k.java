package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class k
  extends a
{
  private WeakReference d = null;
  private SharedPreferences e = null;
  
  static
  {
    new Object();
  }
  
  public k(Context paramContext, String paramString, int paramInt)
  {
    this.b = true;
    this.c = paramString;
    this.d = new WeakReference(paramContext);
    paramContext = localContext;
    if (this.d != null) {
      paramContext = (Context)this.d.get();
    }
    localContext = paramContext;
    if (paramContext == null)
    {
      localContext = SharedPreferencesProxyManager.getInstance().a();
      this.d = new WeakReference(localContext);
    }
    if (localContext != null) {
      this.e = p.a(localContext, paramString, paramInt);
    }
    this.c = paramString;
  }
  
  private static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, b paramb)
  {
    String str = paramb.a;
    Object localObject = paramb.c;
    try
    {
      switch (paramb.d.a)
      {
      case 5: 
        paramEditor.putBoolean(str, ((Boolean)localObject).booleanValue());
        return paramEditor;
      case 3: 
        paramEditor.putFloat(str, ((Float)localObject).floatValue());
        return paramEditor;
      case 1: 
        paramEditor.putInt(str, ((Integer)localObject).intValue());
        return paramEditor;
      case 2: 
        paramEditor.putLong(str, ((Long)localObject).longValue());
        return paramEditor;
      case 4: 
        paramEditor.putString(str, (String)localObject);
        return paramEditor;
      case 6: 
        int i = Build.VERSION.SDK_INT;
        if (i >= 11) {
          try
          {
            paramEditor.putStringSet(str, (Set)localObject);
            return paramEditor;
          }
          catch (Exception paramb)
          {
            return paramEditor;
          }
        }
        break;
      }
      return paramEditor;
    }
    catch (ClassCastException paramb) {}
    return paramEditor;
  }
  
  protected final void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = this.e.edit();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext())
      {
        localEditor.commit();
        return;
      }
      b localb = (b)paramList.next();
      switch (localb.b)
      {
      default: 
        break;
      case 0: 
        a(localEditor, localb);
        break;
      case 2: 
        localEditor.clear();
        break;
      case 1: 
        localEditor.remove(localb.a);
      }
    }
  }
  
  protected final Object b(String paramString, e parame, Object paramObject)
  {
    SharedPreferences localSharedPreferences2 = null;
    SharedPreferences localSharedPreferences1 = null;
    boolean bool = false;
    float f;
    try
    {
      switch (parame.a)
      {
      case 5: 
        parame = this.e;
        if (paramObject != null) {
          bool = ((Boolean)paramObject).booleanValue();
        }
        return Boolean.valueOf(parame.getBoolean(paramString, bool));
      }
    }
    catch (ClassCastException paramString)
    {
      label136:
      return paramObject;
    }
    parame = this.e;
    int i;
    if (paramObject != null)
    {
      f = ((Float)paramObject).floatValue();
      return Float.valueOf(parame.getFloat(paramString, f));
      parame = this.e;
      if (paramObject == null) {
        break label282;
      }
      i = ((Integer)paramObject).intValue();
      return Integer.valueOf(parame.getInt(paramString, i));
      parame = this.e;
      if (paramObject == null) {
        break label288;
      }
    }
    label282:
    label288:
    for (long l = ((Long)paramObject).longValue();; l = 0L)
    {
      return Long.valueOf(parame.getLong(paramString, l));
      localSharedPreferences2 = this.e;
      parame = localSharedPreferences1;
      if (paramObject != null) {
        parame = (String)paramObject;
      }
      return localSharedPreferences2.getString(paramString, parame);
      i = Build.VERSION.SDK_INT;
      if (i >= 11)
      {
        try
        {
          localSharedPreferences1 = this.e;
          parame = localSharedPreferences2;
          if (paramObject != null) {
            parame = (Set)paramObject;
          }
          paramString = localSharedPreferences1.getStringSet(paramString, parame);
          return paramString;
        }
        catch (Exception paramString)
        {
          return paramObject;
        }
        if (this.e.contains(paramString)) {
          return Boolean.valueOf(true);
        }
      }
      return paramObject;
      f = 0.0F;
      break;
      i = 0;
      break label136;
    }
  }
  
  /* Error */
  public final java.util.Map b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 220	com/tencent/mqq/shared_file_accessor/k:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: ldc2_w 221
    //   15: invokevirtual 226	java/lang/Object:wait	(J)V
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_0
    //   21: invokevirtual 228	com/tencent/mqq/shared_file_accessor/k:a	()V
    //   24: aload_0
    //   25: getfield 22	com/tencent/mqq/shared_file_accessor/k:e	Landroid/content/SharedPreferences;
    //   28: invokeinterface 231 1 0
    //   33: areturn
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    //   39: astore_2
    //   40: goto -22 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	k
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    //   39	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   11	18	34	finally
    //   18	20	34	finally
    //   11	18	39	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.k
 * JD-Core Version:    0.7.0.1
 */