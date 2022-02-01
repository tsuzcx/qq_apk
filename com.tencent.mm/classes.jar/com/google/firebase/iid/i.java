package com.google.firebase.iid;

import android.util.Pair;
import androidx.b.a;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

final class i
{
  private final Map<Pair<String, String>, TaskCompletionSource<String>> dCM;
  
  i()
  {
    AppMethodBeat.i(4164);
    this.dCM = new a();
    AppMethodBeat.o(4164);
  }
  
  static String a(TaskCompletionSource<String> paramTaskCompletionSource)
  {
    AppMethodBeat.i(4167);
    try
    {
      paramTaskCompletionSource = (String)Tasks.await(paramTaskCompletionSource.getTask());
      AppMethodBeat.o(4167);
      return paramTaskCompletionSource;
    }
    catch (ExecutionException paramTaskCompletionSource)
    {
      paramTaskCompletionSource = paramTaskCompletionSource.getCause();
      if ((paramTaskCompletionSource instanceof IOException))
      {
        paramTaskCompletionSource = (IOException)paramTaskCompletionSource;
        AppMethodBeat.o(4167);
        throw paramTaskCompletionSource;
      }
      if ((paramTaskCompletionSource instanceof RuntimeException))
      {
        paramTaskCompletionSource = (RuntimeException)paramTaskCompletionSource;
        AppMethodBeat.o(4167);
        throw paramTaskCompletionSource;
      }
      paramTaskCompletionSource = new IOException(paramTaskCompletionSource);
      AppMethodBeat.o(4167);
      throw paramTaskCompletionSource;
    }
    catch (InterruptedException paramTaskCompletionSource)
    {
      paramTaskCompletionSource = new IOException(paramTaskCompletionSource);
      AppMethodBeat.o(4167);
      throw paramTaskCompletionSource;
    }
  }
  
  private static String a(l paraml, TaskCompletionSource<String> paramTaskCompletionSource)
  {
    AppMethodBeat.i(4166);
    try
    {
      paraml = paraml.zzp();
      paramTaskCompletionSource.setResult(paraml);
      AppMethodBeat.o(4166);
      return paraml;
    }
    catch (RuntimeException paraml)
    {
      paramTaskCompletionSource.setException(paraml);
      AppMethodBeat.o(4166);
      throw paraml;
    }
    catch (IOException paraml)
    {
      label27:
      break label27;
    }
  }
  
  /* Error */
  final l a(String paramString1, String paramString2, l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 4165
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 78	android/util/Pair
    //   11: dup
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 81	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 22	com/google/firebase/iid/i:dCM	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 87 2 0
    //   28: checkcast 34	com/google/android/gms/tasks/TaskCompletionSource
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +63 -> 96
    //   36: ldc 89
    //   38: iconst_3
    //   39: invokestatic 95	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   42: ifeq +35 -> 77
    //   45: aload_1
    //   46: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   49: astore_1
    //   50: new 101	java/lang/StringBuilder
    //   53: dup
    //   54: aload_1
    //   55: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   58: invokevirtual 105	java/lang/String:length	()I
    //   61: bipush 29
    //   63: iadd
    //   64: invokespecial 107	java/lang/StringBuilder:<init>	(I)V
    //   67: ldc 109
    //   69: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 115	com/google/firebase/iid/j
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 118	com/google/firebase/iid/j:<init>	(Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    //   85: astore_1
    //   86: sipush 4165
    //   89: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: ldc 89
    //   98: iconst_3
    //   99: invokestatic 95	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   102: ifeq +35 -> 137
    //   105: aload_1
    //   106: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   109: astore_2
    //   110: new 101	java/lang/StringBuilder
    //   113: dup
    //   114: aload_2
    //   115: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 105	java/lang/String:length	()I
    //   121: bipush 24
    //   123: iadd
    //   124: invokespecial 107	java/lang/StringBuilder:<init>	(I)V
    //   127: ldc 120
    //   129: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_2
    //   133: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: new 34	com/google/android/gms/tasks/TaskCompletionSource
    //   140: dup
    //   141: invokespecial 121	com/google/android/gms/tasks/TaskCompletionSource:<init>	()V
    //   144: astore_2
    //   145: aload_0
    //   146: getfield 22	com/google/firebase/iid/i:dCM	Ljava/util/Map;
    //   149: aload_1
    //   150: aload_2
    //   151: invokeinterface 125 3 0
    //   156: pop
    //   157: new 127	com/google/firebase/iid/k
    //   160: dup
    //   161: aload_0
    //   162: aload_3
    //   163: aload_2
    //   164: aload_1
    //   165: invokespecial 130	com/google/firebase/iid/k:<init>	(Lcom/google/firebase/iid/i;Lcom/google/firebase/iid/l;Lcom/google/android/gms/tasks/TaskCompletionSource;Landroid/util/Pair;)V
    //   168: astore_1
    //   169: sipush 4165
    //   172: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -83 -> 92
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	i
    //   0	183	1	paramString1	String
    //   0	183	2	paramString2	String
    //   0	183	3	paraml	l
    // Exception table:
    //   from	to	target	type
    //   2	32	178	finally
    //   36	77	178	finally
    //   77	92	178	finally
    //   96	137	178	finally
    //   137	175	178	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.i
 * JD-Core Version:    0.7.0.1
 */