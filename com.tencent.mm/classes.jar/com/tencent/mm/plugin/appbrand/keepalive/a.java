package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public static final a mOf;
  ConcurrentHashMap<String, a> mOg;
  
  static
  {
    AppMethodBeat.i(47029);
    mOf = new a();
    AppMethodBeat.o(47029);
  }
  
  public a()
  {
    AppMethodBeat.i(47028);
    this.mOg = new ConcurrentHashMap();
    AppMethodBeat.o(47028);
  }
  
  static final class a
  {
    ServiceConnection mOh;
    
    private a()
    {
      AppMethodBeat.i(47027);
      this.mOh = new ServiceConnection()
      {
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
      };
      AppMethodBeat.o(47027);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keepalive.a
 * JD-Core Version:    0.7.0.1
 */