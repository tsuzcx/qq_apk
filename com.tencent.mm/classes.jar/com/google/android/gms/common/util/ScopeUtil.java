package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ScopeUtil
{
  public static Set<Scope> fromScopeString(Collection<String> paramCollection)
  {
    AppMethodBeat.i(90263);
    Preconditions.checkNotNull(paramCollection, "scopeStrings can't be null.");
    paramCollection = fromScopeString((String[])paramCollection.toArray(new String[paramCollection.size()]));
    AppMethodBeat.o(90263);
    return paramCollection;
  }
  
  public static Set<Scope> fromScopeString(String... paramVarArgs)
  {
    AppMethodBeat.i(90264);
    Preconditions.checkNotNull(paramVarArgs, "scopeStrings can't be null.");
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    int i = 0;
    int j = paramVarArgs.length;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str)) {
        localHashSet.add(new Scope(str));
      }
      i += 1;
    }
    AppMethodBeat.o(90264);
    return localHashSet;
  }
  
  public static String[] toScopeString(Set<Scope> paramSet)
  {
    AppMethodBeat.i(90266);
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    paramSet = toScopeString((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
    AppMethodBeat.o(90266);
    return paramSet;
  }
  
  public static String[] toScopeString(Scope[] paramArrayOfScope)
  {
    AppMethodBeat.i(90265);
    Preconditions.checkNotNull(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    int i = 0;
    while (i < paramArrayOfScope.length)
    {
      arrayOfString[i] = paramArrayOfScope[i].getScopeUri();
      i += 1;
    }
    AppMethodBeat.o(90265);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.ScopeUtil
 * JD-Core Version:    0.7.0.1
 */