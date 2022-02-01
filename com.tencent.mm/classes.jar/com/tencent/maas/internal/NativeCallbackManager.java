package com.tencent.maas.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NativeCallbackManager
{
  public static final int INVALID_CALLBACK_ID = -1;
  private static final int MSG_INVOKE_CALLBACK = 1000001;
  private static final String TAG = "NativeCallbackManager";
  private final HandlerThread mCallbackHandlerThread;
  private final SparseArray<NativeCallbackManager.Callback> mCallbackMap;
  private final ReentrantReadWriteLock mCallbackMapLock;
  private final SparseArray<NativeCallbackManager.CallbackWithReturnValue> mCallbackWithReturnReturnValueMap;
  private final AtomicInteger mCurrentID;
  private final SparseIntArray mProgressCallbackMap;
  private final MyHandler myHandler;
  
  public NativeCallbackManager()
  {
    AppMethodBeat.i(216812);
    this.mCurrentID = new AtomicInteger(0);
    this.mCallbackMapLock = new ReentrantReadWriteLock();
    this.mCallbackMap = new SparseArray();
    this.mProgressCallbackMap = new SparseIntArray();
    this.mCallbackWithReturnReturnValueMap = new SparseArray();
    this.mCallbackHandlerThread = new HandlerThread("NativeCallbackManager");
    this.mCallbackHandlerThread.start();
    this.myHandler = new MyHandler(this.mCallbackHandlerThread.getLooper());
    AppMethodBeat.o(216812);
  }
  
  public NativeCallbackManager(Looper paramLooper)
  {
    AppMethodBeat.i(216815);
    this.mCurrentID = new AtomicInteger(0);
    this.mCallbackMapLock = new ReentrantReadWriteLock();
    this.mCallbackMap = new SparseArray();
    this.mProgressCallbackMap = new SparseIntArray();
    this.mCallbackWithReturnReturnValueMap = new SparseArray();
    this.myHandler = new MyHandler(paramLooper);
    this.mCallbackHandlerThread = null;
    AppMethodBeat.o(216815);
  }
  
  /* Error */
  private Object invokeWithReturnValue(int paramInt, NativeCallbackManager.CallbackArgs paramCallbackArgs, SparseArray<NativeCallbackManager.CallbackWithReturnValue> paramSparseArray)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   9: invokevirtual 111	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   12: astore 4
    //   14: aload 4
    //   16: invokevirtual 116	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   19: aload_3
    //   20: iload_1
    //   21: invokevirtual 120	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   24: checkcast 10	com/tencent/maas/internal/NativeCallbackManager$CallbackWithReturnValue
    //   27: astore_3
    //   28: aload 4
    //   30: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   33: aload_3
    //   34: ifnonnull +34 -> 68
    //   37: ldc 107
    //   39: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: astore_3
    //   45: aload 4
    //   47: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   50: aconst_null
    //   51: astore_3
    //   52: goto -19 -> 33
    //   55: astore_2
    //   56: aload 4
    //   58: invokevirtual 123	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   61: ldc 107
    //   63: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_2
    //   67: athrow
    //   68: aload_3
    //   69: aload_2
    //   70: invokevirtual 127	com/tencent/maas/internal/NativeCallbackManager$CallbackWithReturnValue:invoke	(Lcom/tencent/maas/internal/NativeCallbackManager$CallbackArgs;)Ljava/lang/Object;
    //   73: astore_2
    //   74: aload_3
    //   75: getfield 131	com/tencent/maas/internal/NativeCallbackManager$CallbackWithReturnValue:callOnce	Z
    //   78: ifeq +27 -> 105
    //   81: aload_0
    //   82: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 138	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   93: aload_0
    //   94: getfield 64	com/tencent/maas/internal/NativeCallbackManager:mCallbackMap	Landroid/util/SparseArray;
    //   97: iload_1
    //   98: invokevirtual 141	android/util/SparseArray:remove	(I)V
    //   101: aload_3
    //   102: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   105: ldc 107
    //   107: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_2
    //   111: areturn
    //   112: astore 4
    //   114: aload_3
    //   115: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   118: goto -13 -> 105
    //   121: astore_2
    //   122: aload_3
    //   123: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   126: ldc 107
    //   128: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_2
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	NativeCallbackManager
    //   0	133	1	paramInt	int
    //   0	133	2	paramCallbackArgs	NativeCallbackManager.CallbackArgs
    //   0	133	3	paramSparseArray	SparseArray<NativeCallbackManager.CallbackWithReturnValue>
    //   12	45	4	localReadLock	java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock
    //   112	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   19	28	44	java/lang/Exception
    //   19	28	55	finally
    //   93	101	112	java/lang/Exception
    //   93	101	121	finally
  }
  
  private void notifyInvokeCallback(int paramInt)
  {
    AppMethodBeat.i(216821);
    notifyInvokeCallbackArg(paramInt, null);
    AppMethodBeat.o(216821);
  }
  
  private void notifyInvokeCallbackArg(int paramInt, NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    AppMethodBeat.i(216827);
    this.myHandler.obtainMessage(1000001, paramInt, 0, paramCallbackArgs).sendToTarget();
    AppMethodBeat.o(216827);
  }
  
  private Object notifyInvokeCallbackArgWithReturnValue(int paramInt, NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    AppMethodBeat.i(216834);
    paramCallbackArgs = invokeWithReturnValue(paramInt, paramCallbackArgs, this.mCallbackWithReturnReturnValueMap);
    AppMethodBeat.o(216834);
    return paramCallbackArgs;
  }
  
  /* Error */
  public int registerCallback(NativeCallbackManager.Callback paramCallback)
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 54	com/tencent/maas/internal/NativeCallbackManager:mCurrentID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   9: invokevirtual 172	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   12: istore_2
    //   13: aload_0
    //   14: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   17: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 138	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   25: aload_0
    //   26: getfield 64	com/tencent/maas/internal/NativeCallbackManager:mCallbackMap	Landroid/util/SparseArray;
    //   29: iload_2
    //   30: aload_1
    //   31: invokevirtual 176	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   34: aload_3
    //   35: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   38: ldc 168
    //   40: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_1
    //   46: aload_3
    //   47: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   50: goto -12 -> 38
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   58: ldc 168
    //   60: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	NativeCallbackManager
    //   0	65	1	paramCallback	NativeCallbackManager.Callback
    //   12	32	2	i	int
    //   20	35	3	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    // Exception table:
    //   from	to	target	type
    //   25	34	45	java/lang/Exception
    //   25	34	53	finally
  }
  
  /* Error */
  public int registerCallbackWithReturnValue(NativeCallbackManager.CallbackWithReturnValue paramCallbackWithReturnValue)
  {
    // Byte code:
    //   0: ldc 179
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 54	com/tencent/maas/internal/NativeCallbackManager:mCurrentID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   9: invokevirtual 172	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   12: istore_2
    //   13: aload_0
    //   14: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   17: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 138	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   25: aload_0
    //   26: getfield 71	com/tencent/maas/internal/NativeCallbackManager:mCallbackWithReturnReturnValueMap	Landroid/util/SparseArray;
    //   29: iload_2
    //   30: aload_1
    //   31: invokevirtual 176	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   34: aload_3
    //   35: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   38: ldc 179
    //   40: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_1
    //   46: aload_3
    //   47: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   50: goto -12 -> 38
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   58: ldc 179
    //   60: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	NativeCallbackManager
    //   0	65	1	paramCallbackWithReturnValue	NativeCallbackManager.CallbackWithReturnValue
    //   12	32	2	i	int
    //   20	35	3	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    // Exception table:
    //   from	to	target	type
    //   25	34	45	java/lang/Exception
    //   25	34	53	finally
  }
  
  /* Error */
  public int[] registerProgressWithComplete(NativeCallbackManager.Callback paramCallback1, NativeCallbackManager.Callback paramCallback2)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +7 -> 13
    //   9: aload_2
    //   10: ifnonnull +20 -> 30
    //   13: ldc 182
    //   15: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_2
    //   19: newarray int
    //   21: dup
    //   22: iconst_0
    //   23: iconst_m1
    //   24: iastore
    //   25: dup
    //   26: iconst_1
    //   27: iconst_m1
    //   28: iastore
    //   29: areturn
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 184	com/tencent/maas/internal/NativeCallbackManager:registerCallback	(Lcom/tencent/maas/internal/NativeCallbackManager$Callback;)I
    //   35: istore_3
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 184	com/tencent/maas/internal/NativeCallbackManager:registerCallback	(Lcom/tencent/maas/internal/NativeCallbackManager$Callback;)I
    //   41: istore 4
    //   43: aload_0
    //   44: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   47: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 138	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   55: aload_0
    //   56: getfield 69	com/tencent/maas/internal/NativeCallbackManager:mProgressCallbackMap	Landroid/util/SparseIntArray;
    //   59: iload 4
    //   61: iload_3
    //   62: invokevirtual 187	android/util/SparseIntArray:put	(II)V
    //   65: aload_1
    //   66: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   69: ldc 182
    //   71: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iconst_2
    //   75: newarray int
    //   77: dup
    //   78: iconst_0
    //   79: iload_3
    //   80: iastore
    //   81: dup
    //   82: iconst_1
    //   83: iload 4
    //   85: iastore
    //   86: areturn
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   92: goto -23 -> 69
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   100: ldc 182
    //   102: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	NativeCallbackManager
    //   0	107	1	paramCallback1	NativeCallbackManager.Callback
    //   0	107	2	paramCallback2	NativeCallbackManager.Callback
    //   35	45	3	i	int
    //   41	43	4	j	int
    // Exception table:
    //   from	to	target	type
    //   55	65	87	java/lang/Exception
    //   55	65	95	finally
  }
  
  /* Error */
  public void removeAllCallback()
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   9: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 138	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   17: aload_0
    //   18: getfield 64	com/tencent/maas/internal/NativeCallbackManager:mCallbackMap	Landroid/util/SparseArray;
    //   21: invokevirtual 192	android/util/SparseArray:clear	()V
    //   24: aload_1
    //   25: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   28: ldc 189
    //   30: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   39: ldc 189
    //   41: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   50: ldc 189
    //   52: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	NativeCallbackManager
    //   12	35	1	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   34	1	2	localException	java.lang.Exception
    //   45	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	34	java/lang/Exception
    //   17	24	45	finally
  }
  
  /* Error */
  public void removeAllCallbackWithReturnValue()
  {
    // Byte code:
    //   0: ldc 194
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 59	com/tencent/maas/internal/NativeCallbackManager:mCallbackMapLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   9: invokevirtual 135	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 138	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   17: aload_0
    //   18: getfield 71	com/tencent/maas/internal/NativeCallbackManager:mCallbackWithReturnReturnValueMap	Landroid/util/SparseArray;
    //   21: invokevirtual 192	android/util/SparseArray:clear	()V
    //   24: aload_1
    //   25: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   28: ldc 194
    //   30: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   39: ldc 194
    //   41: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 142	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   50: ldc 194
    //   52: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	NativeCallbackManager
    //   12	35	1	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   34	1	2	localException	java.lang.Exception
    //   45	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	34	java/lang/Exception
    //   17	24	45	finally
  }
  
  class MyHandler
    extends Handler
  {
    public MyHandler(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    private void handleInvokeCallbackMsg(Message paramMessage)
    {
      // Byte code:
      //   0: ldc 22
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: aload_1
      //   8: getfield 34	android/os/Message:arg1	I
      //   11: istore_2
      //   12: aload_0
      //   13: getfield 13	com/tencent/maas/internal/NativeCallbackManager$MyHandler:this$0	Lcom/tencent/maas/internal/NativeCallbackManager;
      //   16: invokestatic 38	com/tencent/maas/internal/NativeCallbackManager:access$000	(Lcom/tencent/maas/internal/NativeCallbackManager;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   19: invokevirtual 44	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   22: astore 5
      //   24: aload 5
      //   26: invokevirtual 50	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   29: aload_0
      //   30: getfield 13	com/tencent/maas/internal/NativeCallbackManager$MyHandler:this$0	Lcom/tencent/maas/internal/NativeCallbackManager;
      //   33: invokestatic 54	com/tencent/maas/internal/NativeCallbackManager:access$100	(Lcom/tencent/maas/internal/NativeCallbackManager;)Landroid/util/SparseArray;
      //   36: iload_2
      //   37: invokevirtual 60	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   40: checkcast 62	com/tencent/maas/internal/NativeCallbackManager$Callback
      //   43: astore 4
      //   45: aload 5
      //   47: invokevirtual 65	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   50: aload 4
      //   52: astore_3
      //   53: aload_3
      //   54: ifnonnull +32 -> 86
      //   57: ldc 22
      //   59: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   62: return
      //   63: astore 4
      //   65: aload 5
      //   67: invokevirtual 65	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   70: goto -17 -> 53
      //   73: astore_1
      //   74: aload 5
      //   76: invokevirtual 65	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   79: ldc 22
      //   81: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   84: aload_1
      //   85: athrow
      //   86: aload_3
      //   87: aload_1
      //   88: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   91: checkcast 74	com/tencent/maas/internal/NativeCallbackManager$CallbackArgs
      //   94: invokevirtual 78	com/tencent/maas/internal/NativeCallbackManager$Callback:invoke	(Lcom/tencent/maas/internal/NativeCallbackManager$CallbackArgs;)V
      //   97: aload_3
      //   98: getfield 82	com/tencent/maas/internal/NativeCallbackManager$Callback:callOnce	Z
      //   101: ifeq +91 -> 192
      //   104: aload_0
      //   105: getfield 13	com/tencent/maas/internal/NativeCallbackManager$MyHandler:this$0	Lcom/tencent/maas/internal/NativeCallbackManager;
      //   108: invokestatic 38	com/tencent/maas/internal/NativeCallbackManager:access$000	(Lcom/tencent/maas/internal/NativeCallbackManager;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   111: invokevirtual 86	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
      //   114: astore_1
      //   115: aload_1
      //   116: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
      //   119: aload_0
      //   120: getfield 13	com/tencent/maas/internal/NativeCallbackManager$MyHandler:this$0	Lcom/tencent/maas/internal/NativeCallbackManager;
      //   123: invokestatic 54	com/tencent/maas/internal/NativeCallbackManager:access$100	(Lcom/tencent/maas/internal/NativeCallbackManager;)Landroid/util/SparseArray;
      //   126: iload_2
      //   127: invokevirtual 92	android/util/SparseArray:remove	(I)V
      //   130: aload_0
      //   131: getfield 13	com/tencent/maas/internal/NativeCallbackManager$MyHandler:this$0	Lcom/tencent/maas/internal/NativeCallbackManager;
      //   134: invokestatic 96	com/tencent/maas/internal/NativeCallbackManager:access$200	(Lcom/tencent/maas/internal/NativeCallbackManager;)Landroid/util/SparseIntArray;
      //   137: iload_2
      //   138: iconst_m1
      //   139: invokevirtual 101	android/util/SparseIntArray:get	(II)I
      //   142: istore_2
      //   143: iload_2
      //   144: iconst_m1
      //   145: if_icmpeq +14 -> 159
      //   148: aload_0
      //   149: getfield 13	com/tencent/maas/internal/NativeCallbackManager$MyHandler:this$0	Lcom/tencent/maas/internal/NativeCallbackManager;
      //   152: invokestatic 54	com/tencent/maas/internal/NativeCallbackManager:access$100	(Lcom/tencent/maas/internal/NativeCallbackManager;)Landroid/util/SparseArray;
      //   155: iload_2
      //   156: invokevirtual 92	android/util/SparseArray:remove	(I)V
      //   159: aload_1
      //   160: invokevirtual 102	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
      //   163: ldc 22
      //   165: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: return
      //   169: astore_3
      //   170: aload_1
      //   171: invokevirtual 102	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
      //   174: ldc 22
      //   176: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   179: return
      //   180: astore_3
      //   181: aload_1
      //   182: invokevirtual 102	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
      //   185: ldc 22
      //   187: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: aload_3
      //   191: athrow
      //   192: ldc 22
      //   194: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	198	0	this	MyHandler
      //   0	198	1	paramMessage	Message
      //   11	145	2	i	int
      //   6	92	3	localObject1	Object
      //   169	1	3	localException1	java.lang.Exception
      //   180	11	3	localObject2	Object
      //   43	8	4	localCallback	NativeCallbackManager.Callback
      //   63	1	4	localException2	java.lang.Exception
      //   22	53	5	localReadLock	java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock
      // Exception table:
      //   from	to	target	type
      //   29	45	63	java/lang/Exception
      //   29	45	73	finally
      //   119	143	169	java/lang/Exception
      //   148	159	169	java/lang/Exception
      //   119	143	180	finally
      //   148	159	180	finally
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(216809);
      if (paramMessage.what == 1000001) {
        handleInvokeCallbackMsg(paramMessage);
      }
      AppMethodBeat.o(216809);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.maas.internal.NativeCallbackManager
 * JD-Core Version:    0.7.0.1
 */