package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class ListenerHolders
{
  private final Set<ListenerHolder<?>> zzlm;
  
  public ListenerHolders()
  {
    AppMethodBeat.i(11137);
    this.zzlm = Collections.newSetFromMap(new WeakHashMap());
    AppMethodBeat.o(11137);
  }
  
  @KeepForSdk
  public static <L> ListenerHolder<L> createListenerHolder(L paramL, Looper paramLooper, String paramString)
  {
    AppMethodBeat.i(11140);
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    paramL = new ListenerHolder(paramLooper, paramL, paramString);
    AppMethodBeat.o(11140);
    return paramL;
  }
  
  @KeepForSdk
  public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L paramL, String paramString)
  {
    AppMethodBeat.i(11141);
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    Preconditions.checkNotEmpty(paramString, "Listener type must not be empty");
    paramL = new ListenerHolder.ListenerKey(paramL, paramString);
    AppMethodBeat.o(11141);
    return paramL;
  }
  
  public final void release()
  {
    AppMethodBeat.i(11139);
    Iterator localIterator = this.zzlm.iterator();
    while (localIterator.hasNext()) {
      ((ListenerHolder)localIterator.next()).clear();
    }
    this.zzlm.clear();
    AppMethodBeat.o(11139);
  }
  
  public final <L> ListenerHolder<L> zza(L paramL, Looper paramLooper, String paramString)
  {
    AppMethodBeat.i(11138);
    paramL = createListenerHolder(paramL, paramLooper, paramString);
    this.zzlm.add(paramL);
    AppMethodBeat.o(11138);
    return paramL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ListenerHolders
 * JD-Core Version:    0.7.0.1
 */