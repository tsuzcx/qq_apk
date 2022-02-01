package midas.x;

import android.content.Context;
import android.os.Build.VERSION;

public class sd
{
  /* Error */
  public static boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 12	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   6: aload_0
    //   7: invokevirtual 16	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: invokevirtual 20	android/content/Context:getPackageName	()Ljava/lang/String;
    //   13: sipush 4096
    //   16: invokevirtual 26	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   19: getfield 32	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   22: astore_0
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_3
    //   26: istore 4
    //   28: iload_2
    //   29: aload_0
    //   30: arraylength
    //   31: if_icmpge +45 -> 76
    //   34: aload_0
    //   35: iload_2
    //   36: aaload
    //   37: aload_1
    //   38: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +5 -> 50
    //   48: iconst_1
    //   49: istore_3
    //   50: iload_2
    //   51: iconst_1
    //   52: iadd
    //   53: istore_2
    //   54: goto -29 -> 25
    //   57: astore_0
    //   58: goto +6 -> 64
    //   61: astore_0
    //   62: iconst_0
    //   63: istore_3
    //   64: ldc 40
    //   66: aload_0
    //   67: invokevirtual 45	java/lang/Throwable:toString	()Ljava/lang/String;
    //   70: invokestatic 51	midas/x/ed:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: iload_3
    //   74: istore 4
    //   76: iload 4
    //   78: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramContext	Context
    //   0	79	1	paramString	String
    //   1	53	2	i	int
    //   24	50	3	bool1	boolean
    //   26	51	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   28	43	57	finally
    //   2	23	61	finally
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return a(paramContext, paramString);
    }
    return paramContext.checkSelfPermission(paramString) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.sd
 * JD-Core Version:    0.7.0.1
 */