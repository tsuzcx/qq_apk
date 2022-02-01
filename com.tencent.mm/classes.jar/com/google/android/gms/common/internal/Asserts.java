package com.google.android.gms.common.internal;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Asserts
{
  private Asserts()
  {
    AppMethodBeat.i(4591);
    AssertionError localAssertionError = new AssertionError("Uninstantiable");
    AppMethodBeat.o(4591);
    throw localAssertionError;
  }
  
  public static void checkMainThread(String paramString)
  {
    AppMethodBeat.i(4589);
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      new StringBuilder(String.valueOf(str1).length() + 57 + String.valueOf(str2).length()).append("checkMainThread: current thread ").append(str1).append(" IS NOT the main thread ").append(str2).append("!");
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(4589);
      throw paramString;
    }
    AppMethodBeat.o(4589);
  }
  
  public static void checkNotMainThread(String paramString)
  {
    AppMethodBeat.i(4590);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      new StringBuilder(String.valueOf(str1).length() + 56 + String.valueOf(str2).length()).append("checkNotMainThread: current thread ").append(str1).append(" IS the main thread ").append(str2).append("!");
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(4590);
      throw paramString;
    }
    AppMethodBeat.o(4590);
  }
  
  public static void checkNotNull(Object paramObject)
  {
    AppMethodBeat.i(4583);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("null reference");
      AppMethodBeat.o(4583);
      throw paramObject;
    }
    AppMethodBeat.o(4583);
  }
  
  public static void checkNotNull(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(4584);
    if (paramObject1 == null)
    {
      paramObject1 = new IllegalArgumentException(String.valueOf(paramObject2));
      AppMethodBeat.o(4584);
      throw paramObject1;
    }
    AppMethodBeat.o(4584);
  }
  
  public static void checkNull(Object paramObject)
  {
    AppMethodBeat.i(4582);
    if (paramObject != null)
    {
      paramObject = new IllegalArgumentException("non-null reference");
      AppMethodBeat.o(4582);
      throw paramObject;
    }
    AppMethodBeat.o(4582);
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(4585);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(4585);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(4585);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(4586);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(4586);
      throw paramObject;
    }
    AppMethodBeat.o(4586);
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4587);
    if (!paramBoolean)
    {
      paramString = new IllegalStateException(String.format(paramString, paramVarArgs));
      AppMethodBeat.o(4587);
      throw paramString;
    }
    AppMethodBeat.o(4587);
  }
  
  public static void fail(Object paramObject)
  {
    AppMethodBeat.i(4588);
    paramObject = new IllegalStateException(String.valueOf(paramObject));
    AppMethodBeat.o(4588);
    throw paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.Asserts
 * JD-Core Version:    0.7.0.1
 */