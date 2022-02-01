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
    AppMethodBeat.i(4728);
    AssertionError localAssertionError = new AssertionError("Uninstantiable");
    AppMethodBeat.o(4728);
    throw localAssertionError;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(4727);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(4727);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(4727);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(4725);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(4725);
      throw paramObject;
    }
    AppMethodBeat.o(4725);
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4726);
    if (!paramBoolean)
    {
      paramString = new IllegalArgumentException(String.format(paramString, paramVarArgs));
      AppMethodBeat.o(4726);
      throw paramString;
    }
    AppMethodBeat.o(4726);
  }
  
  public static int checkElementIndex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4733);
    paramInt1 = checkElementIndex(paramInt1, paramInt2, "index");
    AppMethodBeat.o(4733);
    return paramInt1;
  }
  
  public static int checkElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4734);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      if (paramInt1 < 0) {}
      for (paramString = format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });; paramString = format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }))
      {
        paramString = new IndexOutOfBoundsException(paramString);
        AppMethodBeat.o(4734);
        throw paramString;
        if (paramInt2 < 0)
        {
          paramString = new IllegalArgumentException(26 + "negative size: " + paramInt2);
          AppMethodBeat.o(4734);
          throw paramString;
        }
      }
    }
    AppMethodBeat.o(4734);
    return paramInt1;
  }
  
  public static void checkHandlerThread(Handler paramHandler)
  {
    AppMethodBeat.i(4732);
    if (Looper.myLooper() != paramHandler.getLooper())
    {
      paramHandler = new IllegalStateException("Must be called on the handler thread");
      AppMethodBeat.o(4732);
      throw paramHandler;
    }
    AppMethodBeat.o(4732);
  }
  
  public static void checkMainThread(String paramString)
  {
    AppMethodBeat.i(4729);
    if (!ThreadUtils.isMainThread())
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(4729);
      throw paramString;
    }
    AppMethodBeat.o(4729);
  }
  
  public static String checkNotEmpty(String paramString)
  {
    AppMethodBeat.i(4714);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("Given String is empty or null");
      AppMethodBeat.o(4714);
      throw paramString;
    }
    AppMethodBeat.o(4714);
    return paramString;
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(4715);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(4715);
      throw paramString;
    }
    AppMethodBeat.o(4715);
    return paramString;
  }
  
  public static void checkNotMainThread()
  {
    AppMethodBeat.i(4730);
    checkNotMainThread("Must not be called on the main application thread");
    AppMethodBeat.o(4730);
  }
  
  public static void checkNotMainThread(String paramString)
  {
    AppMethodBeat.i(4731);
    if (ThreadUtils.isMainThread())
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(4731);
      throw paramString;
    }
    AppMethodBeat.o(4731);
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(4713);
    if (paramT == null)
    {
      paramT = new NullPointerException("null reference");
      AppMethodBeat.o(4713);
      throw paramT;
    }
    AppMethodBeat.o(4713);
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(4716);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(4716);
      throw paramT;
    }
    AppMethodBeat.o(4716);
    return paramT;
  }
  
  public static void checkNotNullIfPresent(String paramString, ContentValues paramContentValues)
  {
    AppMethodBeat.i(4721);
    if ((paramContentValues.containsKey(paramString)) && (paramContentValues.get(paramString) == null))
    {
      paramString = new IllegalArgumentException(String.valueOf(paramString).concat(" cannot be set to null"));
      AppMethodBeat.o(4721);
      throw paramString;
    }
    AppMethodBeat.o(4721);
  }
  
  public static int checkNotZero(int paramInt)
  {
    AppMethodBeat.i(4718);
    if (paramInt == 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Given Integer is zero");
      AppMethodBeat.o(4718);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(4718);
    return paramInt;
  }
  
  public static int checkNotZero(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(4717);
    if (paramInt == 0)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(4717);
      throw paramObject;
    }
    AppMethodBeat.o(4717);
    return paramInt;
  }
  
  public static long checkNotZero(long paramLong)
  {
    AppMethodBeat.i(4720);
    if (paramLong == 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Given Long is zero");
      AppMethodBeat.o(4720);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(4720);
    return paramLong;
  }
  
  public static long checkNotZero(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(4719);
    if (paramLong == 0L)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(4719);
      throw paramObject;
    }
    AppMethodBeat.o(4719);
    return paramLong;
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4735);
    paramInt1 = checkPositionIndex(paramInt1, paramInt2, "index");
    AppMethodBeat.o(4735);
    return paramInt1;
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4736);
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
    {
      paramString = new IndexOutOfBoundsException(zza(paramInt1, paramInt2, paramString));
      AppMethodBeat.o(4736);
      throw paramString;
    }
    AppMethodBeat.o(4736);
    return paramInt1;
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(4738);
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3))
    {
      Object localObject;
      if ((paramInt1 < 0) || (paramInt1 > paramInt3)) {
        localObject = zza(paramInt1, paramInt3, "start index");
      }
      for (;;)
      {
        localObject = new IndexOutOfBoundsException((String)localObject);
        AppMethodBeat.o(4738);
        throw ((Throwable)localObject);
        if ((paramInt2 < 0) || (paramInt2 > paramInt3)) {
          localObject = zza(paramInt2, paramInt3, "end index");
        } else {
          localObject = format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        }
      }
    }
    AppMethodBeat.o(4738);
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(4722);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(4722);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(4722);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(4723);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(4723);
      throw paramObject;
    }
    AppMethodBeat.o(4723);
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4724);
    if (!paramBoolean)
    {
      paramString = new IllegalStateException(String.format(paramString, paramVarArgs));
      AppMethodBeat.o(4724);
      throw paramString;
    }
    AppMethodBeat.o(4724);
  }
  
  public static String checkTag(String paramString)
  {
    AppMethodBeat.i(4739);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("Tag must not be empty or null");
      AppMethodBeat.o(4739);
      throw paramString;
    }
    if (paramString.length() > 23)
    {
      paramString = new IllegalArgumentException("Tag must not be greater than 23 chars.");
      AppMethodBeat.o(4739);
      throw paramString;
    }
    AppMethodBeat.o(4739);
    return paramString;
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(4740);
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
    AppMethodBeat.o(4740);
    return paramString;
  }
  
  private static String zza(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4737);
    if (paramInt1 < 0)
    {
      paramString = format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(4737);
      return paramString;
    }
    if (paramInt2 < 0)
    {
      paramString = new IllegalArgumentException(26 + "negative size: " + paramInt2);
      AppMethodBeat.o(4737);
      throw paramString;
    }
    paramString = format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(4737);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.Preconditions
 * JD-Core Version:    0.7.0.1
 */