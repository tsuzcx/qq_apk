package com.google.android.gms.common.internal;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Asserts
{
  private Asserts()
  {
    AppMethodBeat.i(89569);
    AssertionError localAssertionError = new AssertionError("Uninstantiable");
    AppMethodBeat.o(89569);
    throw localAssertionError;
  }
  
  public static void checkMainThread(String paramString)
  {
    AppMethodBeat.i(89567);
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      new StringBuilder(String.valueOf(str1).length() + 57 + String.valueOf(str2).length()).append("checkMainThread: current thread ").append(str1).append(" IS NOT the main thread ").append(str2).append("!");
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(89567);
      throw paramString;
    }
    AppMethodBeat.o(89567);
  }
  
  public static void checkNotMainThread(String paramString)
  {
    AppMethodBeat.i(89568);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      new StringBuilder(String.valueOf(str1).length() + 56 + String.valueOf(str2).length()).append("checkNotMainThread: current thread ").append(str1).append(" IS the main thread ").append(str2).append("!");
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(89568);
      throw paramString;
    }
    AppMethodBeat.o(89568);
  }
  
  public static void checkNotNull(Object paramObject)
  {
    AppMethodBeat.i(89561);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("null reference");
      AppMethodBeat.o(89561);
      throw paramObject;
    }
    AppMethodBeat.o(89561);
  }
  
  public static void checkNotNull(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(89562);
    if (paramObject1 == null)
    {
      paramObject1 = new IllegalArgumentException(String.valueOf(paramObject2));
      AppMethodBeat.o(89562);
      throw paramObject1;
    }
    AppMethodBeat.o(89562);
  }
  
  public static void checkNull(Object paramObject)
  {
    AppMethodBeat.i(89560);
    if (paramObject != null)
    {
      paramObject = new IllegalArgumentException("non-null reference");
      AppMethodBeat.o(89560);
      throw paramObject;
    }
    AppMethodBeat.o(89560);
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(89563);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(89563);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(89563);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(89564);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(89564);
      throw paramObject;
    }
    AppMethodBeat.o(89564);
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89565);
    if (!paramBoolean)
    {
      paramString = new IllegalStateException(String.format(paramString, paramVarArgs));
      AppMethodBeat.o(89565);
      throw paramString;
    }
    AppMethodBeat.o(89565);
  }
  
  public static void fail(Object paramObject)
  {
    AppMethodBeat.i(89566);
    paramObject = new IllegalStateException(String.valueOf(paramObject));
    AppMethodBeat.o(89566);
    throw paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.Asserts
 * JD-Core Version:    0.7.0.1
 */