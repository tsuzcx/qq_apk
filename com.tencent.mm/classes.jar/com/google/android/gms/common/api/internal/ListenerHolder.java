package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class ListenerHolder<L>
{
  private final zza zzlh;
  private volatile L zzli;
  private final ListenerKey<L> zzlj;
  
  @KeepForSdk
  ListenerHolder(Looper paramLooper, L paramL, String paramString)
  {
    AppMethodBeat.i(11134);
    this.zzlh = new zza(paramLooper);
    this.zzli = Preconditions.checkNotNull(paramL, "Listener must not be null");
    this.zzlj = new ListenerKey(paramL, Preconditions.checkNotEmpty(paramString));
    AppMethodBeat.o(11134);
  }
  
  @KeepForSdk
  public final void clear()
  {
    this.zzli = null;
  }
  
  @KeepForSdk
  public final ListenerKey<L> getListenerKey()
  {
    return this.zzlj;
  }
  
  @KeepForSdk
  public final boolean hasListener()
  {
    return this.zzli != null;
  }
  
  @KeepForSdk
  public final void notifyListener(Notifier<? super L> paramNotifier)
  {
    AppMethodBeat.i(11135);
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    paramNotifier = this.zzlh.obtainMessage(1, paramNotifier);
    this.zzlh.sendMessage(paramNotifier);
    AppMethodBeat.o(11135);
  }
  
  @KeepForSdk
  final void notifyListenerInternal(Notifier<? super L> paramNotifier)
  {
    AppMethodBeat.i(11136);
    Object localObject = this.zzli;
    if (localObject == null)
    {
      paramNotifier.onNotifyListenerFailed();
      AppMethodBeat.o(11136);
      return;
    }
    try
    {
      paramNotifier.notifyListener(localObject);
      AppMethodBeat.o(11136);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramNotifier.onNotifyListenerFailed();
      AppMethodBeat.o(11136);
      throw localRuntimeException;
    }
  }
  
  @KeepForSdk
  public static final class ListenerKey<L>
  {
    private final L zzli;
    private final String zzll;
    
    @KeepForSdk
    ListenerKey(L paramL, String paramString)
    {
      this.zzli = paramL;
      this.zzll = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(11131);
      if (this == paramObject)
      {
        AppMethodBeat.o(11131);
        return true;
      }
      if (!(paramObject instanceof ListenerKey))
      {
        AppMethodBeat.o(11131);
        return false;
      }
      paramObject = (ListenerKey)paramObject;
      if ((this.zzli == paramObject.zzli) && (this.zzll.equals(paramObject.zzll)))
      {
        AppMethodBeat.o(11131);
        return true;
      }
      AppMethodBeat.o(11131);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(11132);
      int i = System.identityHashCode(this.zzli);
      int j = this.zzll.hashCode();
      AppMethodBeat.o(11132);
      return i * 31 + j;
    }
  }
  
  @KeepForSdk
  public static abstract interface Notifier<L>
  {
    @KeepForSdk
    public abstract void notifyListener(L paramL);
    
    @KeepForSdk
    public abstract void onNotifyListenerFailed();
  }
  
  final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      AppMethodBeat.i(11133);
      if (paramMessage.what == 1) {}
      for (;;)
      {
        Preconditions.checkArgument(bool);
        ListenerHolder.this.notifyListenerInternal((ListenerHolder.Notifier)paramMessage.obj);
        AppMethodBeat.o(11133);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ListenerHolder
 * JD-Core Version:    0.7.0.1
 */