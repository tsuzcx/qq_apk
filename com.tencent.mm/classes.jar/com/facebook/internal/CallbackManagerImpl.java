package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl
  implements CallbackManager
{
  private static final String INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  private static final String TAG;
  private static Map<Integer, CallbackManagerImpl.Callback> staticCallbacks;
  private Map<Integer, CallbackManagerImpl.Callback> callbacks;
  
  static
  {
    AppMethodBeat.i(72278);
    TAG = CallbackManagerImpl.class.getSimpleName();
    staticCallbacks = new HashMap();
    AppMethodBeat.o(72278);
  }
  
  public CallbackManagerImpl()
  {
    AppMethodBeat.i(72271);
    this.callbacks = new HashMap();
    AppMethodBeat.o(72271);
  }
  
  private static CallbackManagerImpl.Callback getStaticCallback(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(72273);
      paramInteger = (CallbackManagerImpl.Callback)staticCallbacks.get(paramInteger);
      AppMethodBeat.o(72273);
      return paramInteger;
    }
    finally
    {
      paramInteger = finally;
      throw paramInteger;
    }
  }
  
  /* Error */
  public static void registerStaticCallback(int paramInt, CallbackManagerImpl.Callback paramCallback)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 62
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 64
    //   11: invokestatic 70	com/facebook/internal/Validate:notNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 42	com/facebook/internal/CallbackManagerImpl:staticCallbacks	Ljava/util/Map;
    //   17: iload_0
    //   18: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: invokeinterface 80 2 0
    //   26: ifeq +12 -> 38
    //   29: ldc 62
    //   31: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 42	com/facebook/internal/CallbackManagerImpl:staticCallbacks	Ljava/util/Map;
    //   41: iload_0
    //   42: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aload_1
    //   46: invokeinterface 84 3 0
    //   51: pop
    //   52: ldc 62
    //   54: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: goto -23 -> 34
    //   60: astore_1
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramInt	int
    //   0	66	1	paramCallback	CallbackManagerImpl.Callback
    // Exception table:
    //   from	to	target	type
    //   3	34	60	finally
    //   38	57	60	finally
  }
  
  private static boolean runStaticCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72274);
    CallbackManagerImpl.Callback localCallback = getStaticCallback(Integer.valueOf(paramInt1));
    if (localCallback != null)
    {
      boolean bool = localCallback.onActivityResult(paramInt2, paramIntent);
      AppMethodBeat.o(72274);
      return bool;
    }
    AppMethodBeat.o(72274);
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72277);
    CallbackManagerImpl.Callback localCallback = (CallbackManagerImpl.Callback)this.callbacks.get(Integer.valueOf(paramInt1));
    if (localCallback != null)
    {
      bool = localCallback.onActivityResult(paramInt2, paramIntent);
      AppMethodBeat.o(72277);
      return bool;
    }
    boolean bool = runStaticCallback(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(72277);
    return bool;
  }
  
  public final void registerCallback(int paramInt, CallbackManagerImpl.Callback paramCallback)
  {
    AppMethodBeat.i(72275);
    Validate.notNull(paramCallback, "callback");
    this.callbacks.put(Integer.valueOf(paramInt), paramCallback);
    AppMethodBeat.o(72275);
  }
  
  public final void unregisterCallback(int paramInt)
  {
    AppMethodBeat.i(72276);
    this.callbacks.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(72276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.CallbackManagerImpl
 * JD-Core Version:    0.7.0.1
 */