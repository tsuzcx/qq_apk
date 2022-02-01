package com.f.a.a;

import android.content.Context;
import android.os.Bundle;
import com.f.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class b
{
  Object dYr = null;
  Method dYs = null;
  public boolean dYt = false;
  private Method dYu = null;
  private Method dYv = null;
  private Method dYw = null;
  private Method dYx = null;
  private Method dYy = null;
  private Context mContext = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static a e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(207434);
    Object localObject = new StringBuilder("Result = ");
    boolean bool;
    if (paramBundle != null)
    {
      bool = true;
      ((StringBuilder)localObject).append(bool).append(", code = ").append(paramInt);
      localObject = new a();
      ((a)localObject).code = paramInt;
      if (paramBundle != null) {
        break label78;
      }
    }
    label78:
    for (paramBundle = new Bundle();; paramBundle = new Bundle(paramBundle))
    {
      ((a)localObject).result = paramBundle;
      AppMethodBeat.o(207434);
      return localObject;
      bool = false;
      break;
    }
  }
  
  /* Error */
  final a h(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 94
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 30	com/f/a/a/b:dYt	Z
    //   12: ifne +18 -> 30
    //   15: sipush 526
    //   18: aconst_null
    //   19: invokestatic 96	com/f/a/a/b:e	(ILandroid/os/Bundle;)Lcom/f/a/b/a;
    //   22: astore_1
    //   23: ldc 94
    //   25: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_1
    //   29: areturn
    //   30: new 78	android/os/Bundle
    //   33: dup
    //   34: invokespecial 79	android/os/Bundle:<init>	()V
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 28	com/f/a/a/b:dYs	Ljava/lang/reflect/Method;
    //   43: aload_0
    //   44: getfield 26	com/f/a/a/b:dYr	Ljava/lang/Object;
    //   47: iconst_4
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_2
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: aload_3
    //   62: aastore
    //   63: dup
    //   64: iconst_3
    //   65: aconst_null
    //   66: aastore
    //   67: invokevirtual 102	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +68 -> 140
    //   75: aload_1
    //   76: instanceof 78
    //   79: ifeq +61 -> 140
    //   82: aload_1
    //   83: checkcast 78	android/os/Bundle
    //   86: astore_1
    //   87: aload_1
    //   88: ldc 103
    //   90: iconst_0
    //   91: invokevirtual 107	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   94: istore 4
    //   96: iload 4
    //   98: aload_1
    //   99: invokestatic 96	com/f/a/a/b:e	(ILandroid/os/Bundle;)Lcom/f/a/b/a;
    //   102: astore_1
    //   103: ldc 94
    //   105: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: areturn
    //   110: astore_2
    //   111: aload 5
    //   113: astore_1
    //   114: new 52	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 109
    //   120: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: sipush 526
    //   131: istore 4
    //   133: goto -37 -> 96
    //   136: astore_2
    //   137: goto -23 -> 114
    //   140: aload 5
    //   142: astore_1
    //   143: goto -47 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	b
    //   0	146	1	paramString1	java.lang.String
    //   0	146	2	paramString2	java.lang.String
    //   0	146	3	paramString3	java.lang.String
    //   1	131	4	i	int
    //   37	104	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   39	71	110	java/lang/Exception
    //   75	87	110	java/lang/Exception
    //   87	96	136	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.f.a.a.b
 * JD-Core Version:    0.7.0.1
 */