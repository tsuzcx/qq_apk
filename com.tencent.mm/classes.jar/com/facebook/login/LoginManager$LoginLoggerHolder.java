package com.facebook.login;

class LoginManager$LoginLoggerHolder
{
  private static LoginLogger logger;
  
  /* Error */
  private static LoginLogger getLogger(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 30
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +19 -> 28
    //   12: aload_0
    //   13: ifnonnull +22 -> 35
    //   16: aconst_null
    //   17: astore_0
    //   18: ldc 30
    //   20: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: invokestatic 36	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   31: astore_0
    //   32: goto -20 -> 12
    //   35: getstatic 38	com/facebook/login/LoginManager$LoginLoggerHolder:logger	Lcom/facebook/login/LoginLogger;
    //   38: ifnonnull +17 -> 55
    //   41: new 40	com/facebook/login/LoginLogger
    //   44: dup
    //   45: aload_0
    //   46: invokestatic 44	com/facebook/FacebookSdk:getApplicationId	()Ljava/lang/String;
    //   49: invokespecial 47	com/facebook/login/LoginLogger:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   52: putstatic 38	com/facebook/login/LoginManager$LoginLoggerHolder:logger	Lcom/facebook/login/LoginLogger;
    //   55: getstatic 38	com/facebook/login/LoginManager$LoginLoggerHolder:logger	Lcom/facebook/login/LoginLogger;
    //   58: astore_0
    //   59: ldc 30
    //   61: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -41 -> 23
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   3	8	67	finally
    //   18	23	67	finally
    //   28	32	67	finally
    //   35	55	67	finally
    //   55	64	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.LoginManager.LoginLoggerHolder
 * JD-Core Version:    0.7.0.1
 */