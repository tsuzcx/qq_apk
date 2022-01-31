package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mm.h.a.gj;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b
{
  private static b dNh = new b();
  public LayoutInflater Lu;
  private ConcurrentHashMap<String, c> dNg = new ConcurrentHashMap();
  public Looper dNi;
  public ah dNj;
  public boolean dNk = false;
  public boolean dNl = false;
  public b dNm;
  public int mMode = 2;
  
  public static b ED()
  {
    return dNh;
  }
  
  public final View a(Activity paramActivity, String paramString, int paramInt)
  {
    if (this.dNl)
    {
      y.i("KISS.InflateRecycler", "not support application inflate");
      return paramActivity.getLayoutInflater().inflate(paramInt, null);
    }
    if (!this.dNk) {
      return paramActivity.getLayoutInflater().inflate(paramInt, null);
    }
    paramActivity = (c)this.dNg.get(paramString);
    if (paramActivity != null) {
      try
      {
        View localView = (View)paramActivity.dNy.poll();
        if (this.mMode == 1) {
          paramActivity.dNz.add(localView);
        }
        if (localView != null)
        {
          y.i("KISS.InflateRecycler", "cache reach %s", new Object[] { paramString });
          localView.addOnAttachStateChangeListener(new a(paramString, this));
          return localView;
        }
      }
      finally {}
    }
    y.i("KISS.InflateRecycler", "no cache reach %s", new Object[] { paramString });
    return this.Lu.inflate(paramInt, null);
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, ViewGroup paramViewGroup, int... paramVarArgs)
  {
    if (!this.dNk) {
      return false;
    }
    if (this.dNl)
    {
      y.i("KISS.InflateRecycler", "not support application inflate");
      return false;
    }
    if (paramViewGroup != null)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        Assert.assertFalse(paramViewGroup.isAttachedToWindow());
      }
      if (paramViewGroup.getParent() != null) {
        break label148;
      }
    }
    label148:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((c)this.dNg.get(paramString) != null) {
        break;
      }
      c localc = new c();
      this.dNg.put(paramString, localc);
      localc.dNA = paramInt1;
      localc.dNo = paramString;
      localc.Ls = paramInt2;
      localc.dNB = paramVarArgs;
      localc.dNC = paramViewGroup;
      this.dNj.sendMessage(this.dNj.obtainMessage(0, localc));
      return true;
    }
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    return a(paramString, paramInt1, paramInt2, null, paramVarArgs);
  }
  
  private static final class a
    implements View.OnAttachStateChangeListener
  {
    private String dNo;
    private b dNp;
    private b.c dNq;
    
    public a(String paramString, b paramb)
    {
      this.dNo = paramString;
      this.dNp = paramb;
      this.dNq = null;
    }
    
    public final void onViewAttachedToWindow(View paramView) {}
    
    /* Error */
    public final void onViewDetachedFromWindow(View paramView)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 24	com/tencent/mm/kiss/a/b$a:dNp	Lcom/tencent/mm/kiss/a/b;
      //   4: invokestatic 36	com/tencent/mm/kiss/a/b:b	(Lcom/tencent/mm/kiss/a/b;)Ljava/util/concurrent/ConcurrentHashMap;
      //   7: aload_0
      //   8: getfield 22	com/tencent/mm/kiss/a/b$a:dNo	Ljava/lang/String;
      //   11: invokevirtual 42	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   14: checkcast 44	com/tencent/mm/kiss/a/c
      //   17: astore_3
      //   18: aload_0
      //   19: getfield 24	com/tencent/mm/kiss/a/b$a:dNp	Lcom/tencent/mm/kiss/a/b;
      //   22: invokestatic 48	com/tencent/mm/kiss/a/b:c	(Lcom/tencent/mm/kiss/a/b;)I
      //   25: iconst_1
      //   26: if_icmpne +78 -> 104
      //   29: aload_3
      //   30: ifnull +36 -> 66
      //   33: aload_3
      //   34: monitorenter
      //   35: aload_3
      //   36: getfield 52	com/tencent/mm/kiss/a/c:dNz	Ljava/util/Queue;
      //   39: aload_1
      //   40: invokeinterface 58 2 0
      //   45: pop
      //   46: aload_3
      //   47: getfield 61	com/tencent/mm/kiss/a/c:dNy	Ljava/util/Queue;
      //   50: aload_1
      //   51: invokeinterface 64 2 0
      //   56: pop
      //   57: aload_3
      //   58: monitorexit
      //   59: aload_0
      //   60: getfield 26	com/tencent/mm/kiss/a/b$a:dNq	Lcom/tencent/mm/kiss/a/b$c;
      //   63: ifnull +3 -> 66
      //   66: aload_1
      //   67: aload_0
      //   68: invokevirtual 70	android/view/View:removeOnAttachStateChangeListener	(Landroid/view/View$OnAttachStateChangeListener;)V
      //   71: aload_0
      //   72: getfield 24	com/tencent/mm/kiss/a/b$a:dNp	Lcom/tencent/mm/kiss/a/b;
      //   75: invokestatic 74	com/tencent/mm/kiss/a/b:d	(Lcom/tencent/mm/kiss/a/b;)Lcom/tencent/mm/kiss/a/b$b;
      //   78: ifnull +20 -> 98
      //   81: aload_0
      //   82: getfield 24	com/tencent/mm/kiss/a/b$a:dNp	Lcom/tencent/mm/kiss/a/b;
      //   85: invokestatic 74	com/tencent/mm/kiss/a/b:d	(Lcom/tencent/mm/kiss/a/b;)Lcom/tencent/mm/kiss/a/b$b;
      //   88: astore_1
      //   89: aload_1
      //   90: invokevirtual 80	com/tencent/mm/kiss/a/b$b:init	()Z
      //   93: istore_2
      //   94: iload_2
      //   95: ifne +20 -> 115
      //   98: return
      //   99: astore_1
      //   100: aload_3
      //   101: monitorexit
      //   102: aload_1
      //   103: athrow
      //   104: aload_0
      //   105: getfield 24	com/tencent/mm/kiss/a/b$a:dNp	Lcom/tencent/mm/kiss/a/b;
      //   108: aload_3
      //   109: invokestatic 83	com/tencent/mm/kiss/a/b:a	(Lcom/tencent/mm/kiss/a/b;Lcom/tencent/mm/kiss/a/c;)V
      //   112: goto -46 -> 66
      //   115: aload_1
      //   116: getfield 87	com/tencent/mm/kiss/a/b$b:mHandler	Lcom/tencent/mm/sdk/platformtools/ah;
      //   119: aconst_null
      //   120: invokevirtual 93	com/tencent/mm/sdk/platformtools/ah:removeCallbacksAndMessages	(Ljava/lang/Object;)V
      //   123: aload_1
      //   124: getfield 87	com/tencent/mm/kiss/a/b$b:mHandler	Lcom/tencent/mm/sdk/platformtools/ah;
      //   127: iconst_0
      //   128: ldc2_w 94
      //   131: invokevirtual 99	com/tencent/mm/sdk/platformtools/ah:sendEmptyMessageDelayed	(IJ)Z
      //   134: pop
      //   135: return
      //   136: astore_1
      //   137: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	138	0	this	a
      //   0	138	1	paramView	View
      //   93	2	2	bool	boolean
      //   17	92	3	localc	c
      // Exception table:
      //   from	to	target	type
      //   35	59	99	finally
      //   100	102	99	finally
      //   89	94	136	java/lang/Throwable
    }
  }
  
  private static final class b
  {
    Class dNr;
    Field dNs;
    Class dNt;
    Field dNu = null;
    private boolean dNv = false;
    private boolean dNw = false;
    ah mHandler;
    
    public b(Looper paramLooper)
    {
      this.mHandler = new ah(paramLooper)
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          try
          {
            long l = System.nanoTime();
            paramAnonymousMessage = b.b.this;
            try
            {
              localObject = (ThreadLocal)paramAnonymousMessage.dNs.get(null);
              if (localObject != null)
              {
                localObject = ((ThreadLocal)localObject).get();
                if (localObject == null) {}
              }
            }
            catch (IllegalAccessException paramAnonymousMessage)
            {
              for (;;)
              {
                Object localObject;
                label69:
                y.printErrStackTrace("KISS.InflateRecycler", paramAnonymousMessage, "", new Object[0]);
              }
            }
            try
            {
              paramAnonymousMessage = paramAnonymousMessage.dNu.get(localObject);
              if ((paramAnonymousMessage != null) && ((paramAnonymousMessage instanceof List))) {
                ((List)paramAnonymousMessage).clear();
              }
            }
            catch (IllegalAccessException paramAnonymousMessage)
            {
              y.printErrStackTrace("KISS.InflateRecycler", paramAnonymousMessage, "", new Object[0]);
              break label69;
            }
            y.i("KISS.InflateRecycler", "durtion %s", new Object[] { Long.valueOf(System.nanoTime() - l) });
            return;
          }
          catch (Throwable paramAnonymousMessage) {}
        }
      };
    }
    
    /* Error */
    final boolean init()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	com/tencent/mm/kiss/a/b$b:dNv	Z
      //   4: ifeq +8 -> 12
      //   7: aload_0
      //   8: getfield 31	com/tencent/mm/kiss/a/b$b:dNw	Z
      //   11: ireturn
      //   12: aload_0
      //   13: iconst_1
      //   14: putfield 29	com/tencent/mm/kiss/a/b$b:dNv	Z
      //   17: aload_0
      //   18: ldc 45
      //   20: invokestatic 51	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   23: putfield 53	com/tencent/mm/kiss/a/b$b:dNr	Ljava/lang/Class;
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 53	com/tencent/mm/kiss/a/b$b:dNr	Ljava/lang/Class;
      //   31: ldc 55
      //   33: invokevirtual 59	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   36: putfield 61	com/tencent/mm/kiss/a/b$b:dNs	Ljava/lang/reflect/Field;
      //   39: aload_0
      //   40: getfield 61	com/tencent/mm/kiss/a/b$b:dNs	Ljava/lang/reflect/Field;
      //   43: iconst_1
      //   44: invokevirtual 67	java/lang/reflect/Field:setAccessible	(Z)V
      //   47: aload_0
      //   48: ldc 69
      //   50: invokestatic 51	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   53: putfield 71	com/tencent/mm/kiss/a/b$b:dNt	Ljava/lang/Class;
      //   56: aload_0
      //   57: aload_0
      //   58: getfield 71	com/tencent/mm/kiss/a/b$b:dNt	Ljava/lang/Class;
      //   61: ldc 73
      //   63: invokevirtual 59	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   66: putfield 27	com/tencent/mm/kiss/a/b$b:dNu	Ljava/lang/reflect/Field;
      //   69: aload_0
      //   70: getfield 27	com/tencent/mm/kiss/a/b$b:dNu	Ljava/lang/reflect/Field;
      //   73: iconst_1
      //   74: invokevirtual 67	java/lang/reflect/Field:setAccessible	(Z)V
      //   77: aload_0
      //   78: iconst_1
      //   79: putfield 31	com/tencent/mm/kiss/a/b$b:dNw	Z
      //   82: iconst_1
      //   83: ireturn
      //   84: astore_1
      //   85: ldc 75
      //   87: aload_1
      //   88: ldc 77
      //   90: iconst_0
      //   91: anewarray 4	java/lang/Object
      //   94: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: iconst_0
      //   98: ireturn
      //   99: astore_1
      //   100: ldc 75
      //   102: aload_1
      //   103: ldc 77
      //   105: iconst_0
      //   106: anewarray 4	java/lang/Object
      //   109: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   112: iconst_0
      //   113: ireturn
      //   114: astore_1
      //   115: ldc 75
      //   117: aload_1
      //   118: ldc 77
      //   120: iconst_0
      //   121: anewarray 4	java/lang/Object
      //   124: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   127: iconst_0
      //   128: ireturn
      //   129: astore_1
      //   130: ldc 75
      //   132: aload_1
      //   133: ldc 77
      //   135: iconst_0
      //   136: anewarray 4	java/lang/Object
      //   139: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   142: iconst_0
      //   143: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	b
      //   84	4	1	localClassNotFoundException1	java.lang.ClassNotFoundException
      //   99	4	1	localNoSuchFieldException1	java.lang.NoSuchFieldException
      //   114	4	1	localClassNotFoundException2	java.lang.ClassNotFoundException
      //   129	4	1	localNoSuchFieldException2	java.lang.NoSuchFieldException
      // Exception table:
      //   from	to	target	type
      //   17	26	84	java/lang/ClassNotFoundException
      //   26	39	99	java/lang/NoSuchFieldException
      //   47	56	114	java/lang/ClassNotFoundException
      //   56	69	129	java/lang/NoSuchFieldException
    }
  }
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.a.b
 * JD-Core Version:    0.7.0.1
 */