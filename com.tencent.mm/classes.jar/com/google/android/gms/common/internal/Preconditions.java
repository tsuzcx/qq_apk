package com.google.android.gms.common.internal;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.ThreadUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Preconditions
{
  private Preconditions()
  {
    AppMethodBeat.i(89706);
    AssertionError localAssertionError = new AssertionError("Uninstantiable");
    AppMethodBeat.o(89706);
    throw localAssertionError;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(89705);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(89705);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(89705);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(89703);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(89703);
      throw paramObject;
    }
    AppMethodBeat.o(89703);
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89704);
    if (!paramBoolean)
    {
      paramString = new IllegalArgumentException(String.format(paramString, paramVarArgs));
      AppMethodBeat.o(89704);
      throw paramString;
    }
    AppMethodBeat.o(89704);
  }
  
  public static int checkElementIndex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89711);
    paramInt1 = checkElementIndex(paramInt1, paramInt2, "index");
    AppMethodBeat.o(89711);
    return paramInt1;
  }
  
  public static int checkElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(89712);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      if (paramInt1 < 0) {}
      for (paramString = format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });; paramString = format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }))
      {
        paramString = new IndexOutOfBoundsException(paramString);
        AppMethodBeat.o(89712);
        throw paramString;
        if (paramInt2 < 0)
        {
          paramString = new IllegalArgumentException(26 + "negative size: " + paramInt2);
          AppMethodBeat.o(89712);
          throw paramString;
        }
      }
    }
    AppMethodBeat.o(89712);
    return paramInt1;
  }
  
  public static void checkHandlerThread(Handler paramHandler)
  {
    AppMethodBeat.i(89710);
    if (Looper.myLooper() != paramHandler.getLooper())
    {
      paramHandler = new IllegalStateException("Must be called on the handler thread");
      AppMethodBeat.o(89710);
      throw paramHandler;
    }
    AppMethodBeat.o(89710);
  }
  
  public static void checkMainThread(String paramString)
  {
    AppMethodBeat.i(89707);
    if (!ThreadUtils.isMainThread())
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(89707);
      throw paramString;
    }
    AppMethodBeat.o(89707);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(89692);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("Given String is empty or null");
      AppMethodBeat.o(89692);
      throw paramString;
    }
    AppMethodBeat.o(89692);
    return paramString;
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(89693);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(89693);
      throw paramString;
    }
    AppMethodBeat.o(89693);
    return paramString;
  }
  
  public static void checkNotMainThread()
  {
    AppMethodBeat.i(89708);
    checkNotMainThread("Must not be called on the main application thread");
    AppMethodBeat.o(89708);
  }
  
  public static void checkNotMainThread(String paramString)
  {
    AppMethodBeat.i(89709);
    if (ThreadUtils.isMainThread())
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(89709);
      throw paramString;
    }
    AppMethodBeat.o(89709);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(89691);
    if (paramT == null)
    {
      paramT = new NullPointerException("null reference");
      AppMethodBeat.o(89691);
      throw paramT;
    }
    AppMethodBeat.o(89691);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(89694);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(89694);
      throw paramT;
    }
    AppMethodBeat.o(89694);
    return paramT;
  }
  
  public static void checkNotNullIfPresent(String paramString, ContentValues paramContentValues)
  {
    AppMethodBeat.i(89699);
    if ((paramContentValues.containsKey(paramString)) && (paramContentValues.get(paramString) == null))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramString).concat(" cannot be set to null"));
      AppMethodBeat.o(89699);
      throw paramString;
    }
    AppMethodBeat.o(89699);
  }
  
  public static int checkNotZero(int paramInt)
  {
    AppMethodBeat.i(89696);
    if (paramInt == 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Given Integer is zero");
      AppMethodBeat.o(89696);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(89696);
    return paramInt;
  }
  
  public static int checkNotZero(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(89695);
    if (paramInt == 0)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(89695);
      throw paramObject;
    }
    AppMethodBeat.o(89695);
    return paramInt;
  }
  
  public static long checkNotZero(long paramLong)
  {
    AppMethodBeat.i(89698);
    if (paramLong == 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Given Long is zero");
      AppMethodBeat.o(89698);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(89698);
    return paramLong;
  }
  
  public static long checkNotZero(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(89697);
    if (paramLong == 0L)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(89697);
      throw paramObject;
    }
    AppMethodBeat.o(89697);
    return paramLong;
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89713);
    paramInt1 = checkPositionIndex(paramInt1, paramInt2, "index");
    AppMethodBeat.o(89713);
    return paramInt1;
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(89714);
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
    {
      paramString = new IndexOutOfBoundsException(zza(paramInt1, paramInt2, paramString));
      AppMethodBeat.o(89714);
      throw paramString;
    }
    AppMethodBeat.o(89714);
    return paramInt1;
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89716);
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3))
    {
      Object localObject;
      if ((paramInt1 < 0) || (paramInt1 > paramInt3)) {
        localObject = zza(paramInt1, paramInt3, "start index");
      }
      for (;;)
      {
        localObject = new IndexOutOfBoundsException((String)localObject);
        AppMethodBeat.o(89716);
        throw ((Throwable)localObject);
        if ((paramInt2 < 0) || (paramInt2 > paramInt3)) {
          localObject = zza(paramInt2, paramInt3, "end index");
        } else {
          localObject = format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        }
      }
    }
    AppMethodBeat.o(89716);
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(89700);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(89700);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(89700);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(89701);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(89701);
      throw paramObject;
    }
    AppMethodBeat.o(89701);
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89702);
    if (!paramBoolean)
    {
      paramString = new IllegalStateException(String.format(paramString, paramVarArgs));
      AppMethodBeat.o(89702);
      throw paramString;
    }
    AppMethodBeat.o(89702);
  }
  
  public static String checkTag(String paramString)
  {
    AppMethodBeat.i(89717);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("Tag must not be empty or null");
      AppMethodBeat.o(89717);
      throw paramString;
    }
    if (paramString.length() > 23)
    {
      paramString = new IllegalArgumentException("Tag must not be greater than 23 chars.");
      AppMethodBeat.o(89717);
      throw paramString;
    }
    AppMethodBeat.o(89717);
    return paramString;
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(89718);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      int k = paramString.indexOf("%s", j);
      if (k == -1) {
        break;
      }
      localStringBuilder.append(paramString.substring(j, k));
      localStringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(paramString.substring(j));
    if (i < paramVarArgs.length)
    {
      localStringBuilder.append(" [");
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      localStringBuilder.append("]");
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(89718);
    return paramString;
  }
  
  private static String zza(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(89715);
    if (paramInt1 < 0)
    {
      paramString = format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(89715);
      return paramString;
    }
    if (paramInt2 < 0)
    {
      paramString = new IllegalArgumentException(26 + "negative size: " + paramInt2);
      AppMethodBeat.o(89715);
      throw paramString;
    }
    paramString = format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89715);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.Preconditions
 * JD-Core Version:    0.7.0.1
 */