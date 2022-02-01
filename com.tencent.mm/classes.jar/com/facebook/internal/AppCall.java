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
    AppMethodBeat.i(7635);
    AppMethodBeat.o(7635);
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
    //   3: sipush 7633
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 45	com/facebook/internal/AppCall:getCurrentPendingCall	()Lcom/facebook/internal/AppCall;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +22 -> 36
    //   17: aload_2
    //   18: invokevirtual 48	com/facebook/internal/AppCall:getCallId	()Ljava/util/UUID;
    //   21: aload_0
    //   22: invokevirtual 52	java/util/UUID:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +11 -> 36
    //   28: aload_2
    //   29: invokevirtual 56	com/facebook/internal/AppCall:getRequestCode	()I
    //   32: iload_1
    //   33: if_icmpeq +16 -> 49
    //   36: sipush 7633
    //   39: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: areturn
    //   49: aconst_null
    //   50: invokestatic 60	com/facebook/internal/AppCall:setCurrentPendingCall	(Lcom/facebook/internal/AppCall;)Z
    //   53: pop
    //   54: sipush 7633
    //   57: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_2
    //   61: astore_0
    //   62: goto -18 -> 44
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramUUID	UUID
    //   0	71	1	paramInt	int
    //   12	49	2	localAppCall	AppCall
    // Exception table:
    //   from	to	target	type
    //   3	13	65	finally
    //   17	36	65	finally
    //   36	42	65	finally
    //   49	60	65	finally
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
    //   3: sipush 7634
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 45	com/facebook/internal/AppCall:getCurrentPendingCall	()Lcom/facebook/internal/AppCall;
    //   12: astore_2
    //   13: aload_0
    //   14: putstatic 62	com/facebook/internal/AppCall:currentPendingCall	Lcom/facebook/internal/AppCall;
    //   17: aload_2
    //   18: ifnull +16 -> 34
    //   21: iconst_1
    //   22: istore_1
    //   23: sipush 7634
    //   26: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_1
    //   36: sipush 7634
    //   39: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -13 -> 29
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramAppCall	AppCall
    //   22	14	1	bool	boolean
    //   12	6	2	localAppCall	AppCall
    // Exception table:
    //   from	to	target	type
    //   3	17	45	finally
    //   23	29	45	finally
    //   36	42	45	finally
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
    AppMethodBeat.i(7636);
    boolean bool = setCurrentPendingCall(this);
    AppMethodBeat.o(7636);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.AppCall
 * JD-Core Version:    0.7.0.1
 */