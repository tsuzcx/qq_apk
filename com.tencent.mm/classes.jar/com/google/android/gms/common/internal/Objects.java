package com.google.android.gms.common.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects
{
  private Objects()
  {
    AppMethodBeat.i(4712);
    AssertionError localAssertionError = new AssertionError("Uninstantiable");
    AppMethodBeat.o(4712);
    throw localAssertionError;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(4709);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(4709);
      return true;
    }
    AppMethodBeat.o(4709);
    return false;
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    AppMethodBeat.i(4710);
    int i = Arrays.hashCode(paramVarArgs);
    AppMethodBeat.o(4710);
    return i;
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    AppMethodBeat.i(4711);
    paramObject = new ToStringHelper(paramObject, null);
    AppMethodBeat.o(4711);
    return paramObject;
  }
  
  public static final class ToStringHelper
  {
    private final List<String> zzul;
    private final Object zzum;
    
    private ToStringHelper(Object paramObject)
    {
      AppMethodBeat.i(4705);
      this.zzum = Preconditions.checkNotNull(paramObject);
      this.zzul = new ArrayList();
      AppMethodBeat.o(4705);
    }
    
    public final ToStringHelper add(String paramString, Object paramObject)
    {
      AppMethodBeat.i(4706);
      List localList = this.zzul;
      paramString = (String)Preconditions.checkNotNull(paramString);
      paramObject = String.valueOf(paramObject);
      localList.add(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length() + paramString + "=" + paramObject);
      AppMethodBeat.o(4706);
      return this;
    }
    
    public final ToStringHelper addValue(Object paramObject)
    {
      AppMethodBeat.i(4707);
      this.zzul.add(String.valueOf(paramObject));
      AppMethodBeat.o(4707);
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(4708);
      Object localObject = new StringBuilder(100).append(this.zzum.getClass().getSimpleName()).append('{');
      int j = this.zzul.size();
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append((String)this.zzul.get(i));
        if (i < j - 1) {
          ((StringBuilder)localObject).append(", ");
        }
        i += 1;
      }
      localObject = '}';
      AppMethodBeat.o(4708);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.Objects
 * JD-Core Version:    0.7.0.1
 */