package com.google.firebase.iid;

import android.support.v4.e.a;
import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

final class i
{
  @GuardedBy("this")
  private final Map<Pair<String, String>, TaskCompletionSource<String>> bfn;
  
  i()
  {
    AppMethodBeat.i(108728);
    this.bfn = new a();
    AppMethodBeat.o(108728);
  }
  
  static String a(TaskCompletionSource<String> paramTaskCompletionSource)
  {
    AppMethodBeat.i(108731);
    try
    {
      paramTaskCompletionSource = (String)Tasks.await(paramTaskCompletionSource.getTask());
      AppMethodBeat.o(108731);
      return paramTaskCompletionSource;
    }
    catch (ExecutionException paramTaskCompletionSource)
    {
      paramTaskCompletionSource = paramTaskCompletionSource.getCause();
      if ((paramTaskCompletionSource instanceof IOException))
      {
        paramTaskCompletionSource = (IOException)paramTaskCompletionSource;
        AppMethodBeat.o(108731);
        throw paramTaskCompletionSource;
      }
      if ((paramTaskCompletionSource instanceof RuntimeException))
      {
        paramTaskCompletionSource = (RuntimeException)paramTaskCompletionSource;
        AppMethodBeat.o(108731);
        throw paramTaskCompletionSource;
      }
      paramTaskCompletionSource = new IOException(paramTaskCompletionSource);
      AppMethodBeat.o(108731);
      throw paramTaskCompletionSource;
    }
    catch (InterruptedException paramTaskCompletionSource)
    {
      paramTaskCompletionSource = new IOException(paramTaskCompletionSource);
      AppMethodBeat.o(108731);
      throw paramTaskCompletionSource;
    }
  }
  
  private static String a(l paraml, TaskCompletionSource<String> paramTaskCompletionSource)
  {
    AppMethodBeat.i(108730);
    try
    {
      paraml = paraml.zzp();
      paramTaskCompletionSource.setResult(paraml);
      AppMethodBeat.o(108730);
      return paraml;
    }
    catch (RuntimeException paraml)
    {
      paramTaskCompletionSource.setException(paraml);
      AppMethodBeat.o(108730);
      throw paraml;
    }
    catch (IOException paraml)
    {
      label25:
      break label25;
    }
  }
  
  /* Error */
  final l a(String paramString1, String paramString2, l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 83
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 85	android/util/Pair
    //   10: dup
    //   11: aload_1
    //   12: aload_2
    //   13: invokespecial 88	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 26	com/google/firebase/iid/i:bfn	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 94 2 0
    //   27: checkcast 39	com/google/android/gms/tasks/TaskCompletionSource
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +62 -> 94
    //   35: ldc 96
    //   37: iconst_3
    //   38: invokestatic 102	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   41: ifeq +35 -> 76
    //   44: aload_1
    //   45: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore_1
    //   49: new 108	java/lang/StringBuilder
    //   52: dup
    //   53: aload_1
    //   54: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 112	java/lang/String:length	()I
    //   60: bipush 29
    //   62: iadd
    //   63: invokespecial 114	java/lang/StringBuilder:<init>	(I)V
    //   66: ldc 116
    //   68: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_1
    //   72: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 122	com/google/firebase/iid/j
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 125	com/google/firebase/iid/j:<init>	(Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    //   84: astore_1
    //   85: ldc 83
    //   87: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: areturn
    //   94: ldc 96
    //   96: iconst_3
    //   97: invokestatic 102	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   100: ifeq +35 -> 135
    //   103: aload_1
    //   104: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   107: astore_2
    //   108: new 108	java/lang/StringBuilder
    //   111: dup
    //   112: aload_2
    //   113: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 112	java/lang/String:length	()I
    //   119: bipush 24
    //   121: iadd
    //   122: invokespecial 114	java/lang/StringBuilder:<init>	(I)V
    //   125: ldc 127
    //   127: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_2
    //   131: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: new 39	com/google/android/gms/tasks/TaskCompletionSource
    //   138: dup
    //   139: invokespecial 128	com/google/android/gms/tasks/TaskCompletionSource:<init>	()V
    //   142: astore_2
    //   143: aload_0
    //   144: getfield 26	com/google/firebase/iid/i:bfn	Ljava/util/Map;
    //   147: aload_1
    //   148: aload_2
    //   149: invokeinterface 132 3 0
    //   154: pop
    //   155: new 134	com/google/firebase/iid/k
    //   158: dup
    //   159: aload_0
    //   160: aload_3
    //   161: aload_2
    //   162: aload_1
    //   163: invokespecial 137	com/google/firebase/iid/k:<init>	(Lcom/google/firebase/iid/i;Lcom/google/firebase/iid/l;Lcom/google/android/gms/tasks/TaskCompletionSource;Landroid/util/Pair;)V
    //   166: astore_1
    //   167: ldc 83
    //   169: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: goto -82 -> 90
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	i
    //   0	180	1	paramString1	String
    //   0	180	2	paramString2	String
    //   0	180	3	paraml	l
    // Exception table:
    //   from	to	target	type
    //   2	31	175	finally
    //   35	76	175	finally
    //   76	90	175	finally
    //   94	135	175	finally
    //   135	172	175	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.firebase.iid.i
 * JD-Core Version:    0.7.0.1
 */