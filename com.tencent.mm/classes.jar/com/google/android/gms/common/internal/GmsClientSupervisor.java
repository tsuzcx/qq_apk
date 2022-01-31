package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class GmsClientSupervisor
{
  public static final int DEFAULT_BIND_FLAGS = 129;
  private static final Object zztm = new Object();
  private static GmsClientSupervisor zztn;
  
  public static GmsClientSupervisor getInstance(Context paramContext)
  {
    synchronized (zztm)
    {
      if (zztn == null) {
        zztn = new zzh(paramContext.getApplicationContext());
      }
      return zztn;
    }
  }
  
  public boolean bindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return bindService(new ConnectionStatusConfig(paramComponentName, 129), paramServiceConnection, paramString);
  }
  
  protected abstract boolean bindService(ConnectionStatusConfig paramConnectionStatusConfig, ServiceConnection paramServiceConnection, String paramString);
  
  public boolean bindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return bindService(new ConnectionStatusConfig(paramString1, 129), paramServiceConnection, paramString2);
  }
  
  public boolean bindService(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection, String paramString3)
  {
    return bindService(new ConnectionStatusConfig(paramString1, paramString2, paramInt), paramServiceConnection, paramString3);
  }
  
  public boolean bindService(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return bindService(paramString1, paramString2, 129, paramServiceConnection, paramString3);
  }
  
  @VisibleForTesting
  public abstract void resetForTesting();
  
  public void unbindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    unbindService(new ConnectionStatusConfig(paramComponentName, 129), paramServiceConnection, paramString);
  }
  
  protected abstract void unbindService(ConnectionStatusConfig paramConnectionStatusConfig, ServiceConnection paramServiceConnection, String paramString);
  
  public void unbindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    unbindService(new ConnectionStatusConfig(paramString1, 129), paramServiceConnection, paramString2);
  }
  
  public void unbindService(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection, String paramString3)
  {
    unbindService(new ConnectionStatusConfig(paramString1, paramString2, paramInt), paramServiceConnection, paramString3);
  }
  
  public void unbindService(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    unbindService(paramString1, paramString2, 129, paramServiceConnection, paramString3);
  }
  
  protected static final class ConnectionStatusConfig
  {
    private final ComponentName mComponentName;
    private final String zzto;
    private final String zztp;
    private final int zztq;
    
    public ConnectionStatusConfig(ComponentName paramComponentName, int paramInt)
    {
      AppMethodBeat.i(89616);
      this.zzto = null;
      this.zztp = null;
      this.mComponentName = ((ComponentName)Preconditions.checkNotNull(paramComponentName));
      this.zztq = paramInt;
      AppMethodBeat.o(89616);
    }
    
    public ConnectionStatusConfig(String paramString, int paramInt)
    {
      AppMethodBeat.i(89614);
      this.zzto = Preconditions.checkNotEmpty(paramString);
      this.zztp = "com.google.android.gms";
      this.mComponentName = null;
      this.zztq = paramInt;
      AppMethodBeat.o(89614);
    }
    
    public ConnectionStatusConfig(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(89615);
      this.zzto = Preconditions.checkNotEmpty(paramString1);
      this.zztp = Preconditions.checkNotEmpty(paramString2);
      this.mComponentName = null;
      this.zztq = paramInt;
      AppMethodBeat.o(89615);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(89620);
      if (this == paramObject)
      {
        AppMethodBeat.o(89620);
        return true;
      }
      if (!(paramObject instanceof ConnectionStatusConfig))
      {
        AppMethodBeat.o(89620);
        return false;
      }
      paramObject = (ConnectionStatusConfig)paramObject;
      if ((Objects.equal(this.zzto, paramObject.zzto)) && (Objects.equal(this.zztp, paramObject.zztp)) && (Objects.equal(this.mComponentName, paramObject.mComponentName)) && (this.zztq == paramObject.zztq))
      {
        AppMethodBeat.o(89620);
        return true;
      }
      AppMethodBeat.o(89620);
      return false;
    }
    
    public final String getAction()
    {
      return this.zzto;
    }
    
    public final int getBindFlags()
    {
      return this.zztq;
    }
    
    public final ComponentName getComponentName()
    {
      return this.mComponentName;
    }
    
    public final String getPackage()
    {
      return this.zztp;
    }
    
    public final Intent getStartServiceIntent(Context paramContext)
    {
      AppMethodBeat.i(89618);
      if (this.zzto != null) {}
      for (paramContext = new Intent(this.zzto).setPackage(this.zztp);; paramContext = new Intent().setComponent(this.mComponentName))
      {
        AppMethodBeat.o(89618);
        return paramContext;
      }
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(89619);
      int i = Objects.hashCode(new Object[] { this.zzto, this.zztp, this.mComponentName, Integer.valueOf(this.zztq) });
      AppMethodBeat.o(89619);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(89617);
      if (this.zzto == null)
      {
        str = this.mComponentName.flattenToString();
        AppMethodBeat.o(89617);
        return str;
      }
      String str = this.zzto;
      AppMethodBeat.o(89617);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsClientSupervisor
 * JD-Core Version:    0.7.0.1
 */