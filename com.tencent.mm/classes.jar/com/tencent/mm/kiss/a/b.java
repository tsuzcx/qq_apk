package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static b htK;
  public static a htO;
  private ConcurrentHashMap<String, c> htJ;
  public String htL;
  public MMHandler htM;
  public boolean htN;
  public LayoutInflater mInflater;
  public boolean mInitialized;
  public int mMode;
  
  static
  {
    AppMethodBeat.i(141007);
    htK = null;
    htK = new b();
    AppMethodBeat.o(141007);
  }
  
  public b()
  {
    AppMethodBeat.i(141001);
    this.htJ = new ConcurrentHashMap();
    this.mInitialized = false;
    this.mMode = 2;
    this.htN = false;
    AppMethodBeat.o(141001);
  }
  
  public static b aBh()
  {
    return htK;
  }
  
  public static void aBi()
  {
    AppMethodBeat.i(141005);
    if (htO != null)
    {
      a locala = htO;
      try
      {
        boolean bool = locala.init();
        if (!bool)
        {
          AppMethodBeat.o(141005);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(141005);
        return;
      }
      localThrowable.mHandler.removeCallbacksAndMessages(null);
      localThrowable.mHandler.sendEmptyMessageDelayed(0, 1000L);
    }
    AppMethodBeat.o(141005);
  }
  
  public static View c(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(141002);
    paramActivity = LayoutInflater.from(paramActivity).inflate(paramInt, null);
    AppMethodBeat.o(141002);
    return paramActivity;
  }
  
  public static final class a
  {
    Class htQ;
    Field htR;
    Class htS;
    Field htT;
    private boolean htU;
    private boolean htV;
    MMHandler mHandler;
    
    public a(String paramString)
    {
      AppMethodBeat.i(182560);
      this.htT = null;
      this.htU = false;
      this.htV = false;
      this.mHandler = new MMHandler(paramString)
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(140998);
          try
          {
            long l = System.nanoTime();
            paramAnonymousMessage = b.a.this;
            try
            {
              localObject = (ThreadLocal)paramAnonymousMessage.htR.get(null);
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
                label74:
                Log.printErrStackTrace("KISS.InflateRecycler", paramAnonymousMessage, "", new Object[0]);
              }
            }
          }
          catch (Throwable paramAnonymousMessage)
          {
            AppMethodBeat.o(140998);
            return;
          }
          try
          {
            paramAnonymousMessage = paramAnonymousMessage.htT.get(localObject);
            if ((paramAnonymousMessage != null) && ((paramAnonymousMessage instanceof List))) {
              ((List)paramAnonymousMessage).clear();
            }
          }
          catch (IllegalAccessException paramAnonymousMessage)
          {
            Log.printErrStackTrace("KISS.InflateRecycler", paramAnonymousMessage, "", new Object[0]);
            break label74;
          }
          Log.i("KISS.InflateRecycler", "durtion %s", new Object[] { Long.valueOf(System.nanoTime() - l) });
          AppMethodBeat.o(140998);
        }
      };
      AppMethodBeat.o(182560);
    }
    
    /* Error */
    final boolean init()
    {
      // Byte code:
      //   0: ldc 54
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 36	com/tencent/mm/kiss/a/b$a:htU	Z
      //   9: ifeq +15 -> 24
      //   12: aload_0
      //   13: getfield 38	com/tencent/mm/kiss/a/b$a:htV	Z
      //   16: istore_1
      //   17: ldc 54
      //   19: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: iload_1
      //   23: ireturn
      //   24: aload_0
      //   25: iconst_1
      //   26: putfield 36	com/tencent/mm/kiss/a/b$a:htU	Z
      //   29: aload_0
      //   30: ldc 56
      //   32: invokestatic 62	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   35: putfield 64	com/tencent/mm/kiss/a/b$a:htQ	Ljava/lang/Class;
      //   38: aload_0
      //   39: aload_0
      //   40: getfield 64	com/tencent/mm/kiss/a/b$a:htQ	Ljava/lang/Class;
      //   43: ldc 66
      //   45: invokevirtual 70	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   48: putfield 72	com/tencent/mm/kiss/a/b$a:htR	Ljava/lang/reflect/Field;
      //   51: aload_0
      //   52: getfield 72	com/tencent/mm/kiss/a/b$a:htR	Ljava/lang/reflect/Field;
      //   55: iconst_1
      //   56: invokevirtual 78	java/lang/reflect/Field:setAccessible	(Z)V
      //   59: aload_0
      //   60: ldc 80
      //   62: invokestatic 62	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   65: putfield 82	com/tencent/mm/kiss/a/b$a:htS	Ljava/lang/Class;
      //   68: aload_0
      //   69: aload_0
      //   70: getfield 82	com/tencent/mm/kiss/a/b$a:htS	Ljava/lang/Class;
      //   73: ldc 84
      //   75: invokevirtual 70	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   78: putfield 34	com/tencent/mm/kiss/a/b$a:htT	Ljava/lang/reflect/Field;
      //   81: aload_0
      //   82: getfield 34	com/tencent/mm/kiss/a/b$a:htT	Ljava/lang/reflect/Field;
      //   85: iconst_1
      //   86: invokevirtual 78	java/lang/reflect/Field:setAccessible	(Z)V
      //   89: aload_0
      //   90: iconst_1
      //   91: putfield 38	com/tencent/mm/kiss/a/b$a:htV	Z
      //   94: ldc 54
      //   96: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   99: iconst_1
      //   100: ireturn
      //   101: astore_2
      //   102: ldc 86
      //   104: aload_2
      //   105: ldc 88
      //   107: iconst_0
      //   108: anewarray 4	java/lang/Object
      //   111: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   114: ldc 54
      //   116: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   119: iconst_0
      //   120: ireturn
      //   121: astore_2
      //   122: ldc 86
      //   124: aload_2
      //   125: ldc 88
      //   127: iconst_0
      //   128: anewarray 4	java/lang/Object
      //   131: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   134: ldc 54
      //   136: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: iconst_0
      //   140: ireturn
      //   141: astore_2
      //   142: ldc 86
      //   144: aload_2
      //   145: ldc 88
      //   147: iconst_0
      //   148: anewarray 4	java/lang/Object
      //   151: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   154: ldc 54
      //   156: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: iconst_0
      //   160: ireturn
      //   161: astore_2
      //   162: ldc 86
      //   164: aload_2
      //   165: ldc 88
      //   167: iconst_0
      //   168: anewarray 4	java/lang/Object
      //   171: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   174: ldc 54
      //   176: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   179: iconst_0
      //   180: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	181	0	this	a
      //   16	7	1	bool	boolean
      //   101	4	2	localClassNotFoundException1	java.lang.ClassNotFoundException
      //   121	4	2	localNoSuchFieldException1	java.lang.NoSuchFieldException
      //   141	4	2	localClassNotFoundException2	java.lang.ClassNotFoundException
      //   161	4	2	localNoSuchFieldException2	java.lang.NoSuchFieldException
      // Exception table:
      //   from	to	target	type
      //   29	38	101	java/lang/ClassNotFoundException
      //   38	51	121	java/lang/NoSuchFieldException
      //   59	68	141	java/lang/ClassNotFoundException
      //   68	81	161	java/lang/NoSuchFieldException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.a.b
 * JD-Core Version:    0.7.0.1
 */