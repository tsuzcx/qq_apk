package com.facebook.internal;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public class AppCall
{
  private static AppCall currentPendingCall;
  private UUID callId;
  private int requestCode;
  private Intent requestIntent;
  
  public AppCall(int paramInt)
  {
    this(paramInt, UUID.randomUUID());
    AppMethodBeat.i(96611);
    AppMethodBeat.o(96611);
  }
  
  public AppCall(int paramInt, UUID paramUUID)
  {
    this.callId = paramUUID;
    this.requestCode = paramInt;
  }
  
  /* Error */
  public static AppCall finishPendingCall(UUID paramUUID, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 43
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 47	com/facebook/internal/AppCall:getCurrentPendingCall	()Lcom/facebook/internal/AppCall;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +22 -> 35
    //   16: aload_2
    //   17: invokevirtual 50	com/facebook/internal/AppCall:getCallId	()Ljava/util/UUID;
    //   20: aload_0
    //   21: invokevirtual 54	java/util/UUID:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +11 -> 35
    //   27: aload_2
    //   28: invokevirtual 58	com/facebook/internal/AppCall:getRequestCode	()I
    //   31: iload_1
    //   32: if_icmpeq +15 -> 47
    //   35: ldc 43
    //   37: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aconst_null
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: aconst_null
    //   48: invokestatic 62	com/facebook/internal/AppCall:setCurrentPendingCall	(Lcom/facebook/internal/AppCall;)Z
    //   51: pop
    //   52: ldc 43
    //   54: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_2
    //   58: astore_0
    //   59: goto -17 -> 42
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramUUID	UUID
    //   0	68	1	paramInt	int
    //   11	47	2	localAppCall	AppCall
    // Exception table:
    //   from	to	target	type
    //   3	12	62	finally
    //   16	35	62	finally
    //   35	40	62	finally
    //   47	57	62	finally
  }
  
  public static AppCall getCurrentPendingCall()
  {
    return currentPendingCall;
  }
  
  /* Error */
  private static boolean setCurrentPendingCall(AppCall paramAppCall)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 65
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 47	com/facebook/internal/AppCall:getCurrentPendingCall	()Lcom/facebook/internal/AppCall;
    //   11: astore_2
    //   12: aload_0
    //   13: putstatic 64	com/facebook/internal/AppCall:currentPendingCall	Lcom/facebook/internal/AppCall;
    //   16: aload_2
    //   17: ifnull +15 -> 32
    //   20: iconst_1
    //   21: istore_1
    //   22: ldc 65
    //   24: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc 65
    //   36: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -12 -> 27
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramAppCall	AppCall
    //   21	13	1	bool	boolean
    //   11	6	2	localAppCall	AppCall
    // Exception table:
    //   from	to	target	type
    //   3	16	42	finally
    //   22	27	42	finally
    //   34	39	42	finally
  }
  
  public UUID getCallId()
  {
    return this.callId;
  }
  
  public int getRequestCode()
  {
    return this.requestCode;
  }
  
  public Intent getRequestIntent()
  {
    return this.requestIntent;
  }
  
  public boolean setPending()
  {
    AppMethodBeat.i(96612);
    boolean bool = setCurrentPendingCall(this);
    AppMethodBeat.o(96612);
    return bool;
  }
  
  public void setRequestCode(int paramInt)
  {
    this.requestCode = paramInt;
  }
  
  public void setRequestIntent(Intent paramIntent)
  {
    this.requestIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.AppCall
 * JD-Core Version:    0.7.0.1
 */