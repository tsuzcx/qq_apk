package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl
  implements CallbackManager
{
  private static final String INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
  private static final String TAG;
  private static Map<Integer, Callback> staticCallbacks;
  private Map<Integer, Callback> callbacks;
  
  static
  {
    AppMethodBeat.i(17714);
    TAG = CallbackManagerImpl.class.getSimpleName();
    staticCallbacks = new HashMap();
    AppMethodBeat.o(17714);
  }
  
  public CallbackManagerImpl()
  {
    AppMethodBeat.i(17707);
    this.callbacks = new HashMap();
    AppMethodBeat.o(17707);
  }
  
  private static Callback getStaticCallback(Integer paramInteger)
  {
    try
    {
      AppMethodBeat.i(17709);
      paramInteger = (Callback)staticCallbacks.get(paramInteger);
      AppMethodBeat.o(17709);
      return paramInteger;
    }
    finally
    {
      paramInteger = finally;
      throw paramInteger;
    }
  }
  
  /* Error */
  public static void registerStaticCallback(int paramInt, Callback paramCallback)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 17708
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc 62
    //   12: invokestatic 68	com/facebook/internal/Validate:notNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: getstatic 43	com/facebook/internal/CallbackManagerImpl:staticCallbacks	Ljava/util/Map;
    //   18: iload_0
    //   19: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: invokeinterface 78 2 0
    //   27: ifeq +13 -> 40
    //   30: sipush 17708
    //   33: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: getstatic 43	com/facebook/internal/CallbackManagerImpl:staticCallbacks	Ljava/util/Map;
    //   43: iload_0
    //   44: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aload_1
    //   48: invokeinterface 82 3 0
    //   53: pop
    //   54: sipush 17708
    //   57: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -24 -> 36
    //   63: astore_1
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramInt	int
    //   0	69	1	paramCallback	Callback
    // Exception table:
    //   from	to	target	type
    //   3	36	63	finally
    //   40	60	63	finally
  }
  
  private static boolean runStaticCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(17710);
    Callback localCallback = getStaticCallback(Integer.valueOf(paramInt1));
    if (localCallback != null)
    {
      boolean bool = localCallback.onActivityResult(paramInt2, paramIntent);
      AppMethodBeat.o(17710);
      return bool;
    }
    AppMethodBeat.o(17710);
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(17713);
    Callback localCallback = (Callback)this.callbacks.get(Integer.valueOf(paramInt1));
    if (localCallback != null)
    {
      bool = localCallback.onActivityResult(paramInt2, paramIntent);
      AppMethodBeat.o(17713);
      return bool;
    }
    boolean bool = runStaticCallback(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(17713);
    return bool;
  }
  
  public final void registerCallback(int paramInt, Callback paramCallback)
  {
    AppMethodBeat.i(17711);
    Validate.notNull(paramCallback, "callback");
    this.callbacks.put(Integer.valueOf(paramInt), paramCallback);
    AppMethodBeat.o(17711);
  }
  
  public final void unregisterCallback(int paramInt)
  {
    AppMethodBeat.i(17712);
    this.callbacks.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(17712);
  }
  
  public static abstract interface Callback
  {
    public abstract boolean onActivityResult(int paramInt, Intent paramIntent);
  }
  
  public static enum RequestCodeOffset
  {
    private final int offset;
    
    static
    {
      AppMethodBeat.i(17706);
      Login = new RequestCodeOffset("Login", 0, 0);
      Share = new RequestCodeOffset("Share", 1, 1);
      Message = new RequestCodeOffset("Message", 2, 2);
      Like = new RequestCodeOffset("Like", 3, 3);
      GameRequest = new RequestCodeOffset("GameRequest", 4, 4);
      AppGroupCreate = new RequestCodeOffset("AppGroupCreate", 5, 5);
      AppGroupJoin = new RequestCodeOffset("AppGroupJoin", 6, 6);
      AppInvite = new RequestCodeOffset("AppInvite", 7, 7);
      DeviceShare = new RequestCodeOffset("DeviceShare", 8, 8);
      $VALUES = new RequestCodeOffset[] { Login, Share, Message, Like, GameRequest, AppGroupCreate, AppGroupJoin, AppInvite, DeviceShare };
      AppMethodBeat.o(17706);
    }
    
    private RequestCodeOffset(int paramInt)
    {
      this.offset = paramInt;
    }
    
    public final int toRequestCode()
    {
      AppMethodBeat.i(17705);
      int i = FacebookSdk.getCallbackRequestCodeOffset();
      int j = this.offset;
      AppMethodBeat.o(17705);
      return i + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.CallbackManagerImpl
 * JD-Core Version:    0.7.0.1
 */