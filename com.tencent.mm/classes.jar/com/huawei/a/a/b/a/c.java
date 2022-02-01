package com.huawei.a.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.huawei.a.a.a.b.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends a
{
  private b chA;
  private boolean chB;
  private com.huawei.a.a.a.b chC;
  private IBinder chD;
  private IBinder.DeathRecipient chE;
  private ServiceConnection mConnection;
  private Context mContext;
  
  protected c(Context paramContext)
  {
    AppMethodBeat.i(213654);
    this.chA = null;
    this.chB = false;
    this.chD = null;
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(213649);
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceConnected");
        c.a(c.this, b.a.i(paramAnonymousIBinder));
        if (c.a(c.this) != null)
        {
          c.a(c.this, true);
          c.b(c.this).jdMethod_if(1000);
          c.a(c.this, c.c(c.this).getPackageName());
          c.a(c.this, paramAnonymousIBinder);
        }
        AppMethodBeat.o(213649);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(213650);
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceDisconnected");
        c.a(c.this, false);
        if (c.b(c.this) != null) {
          c.b(c.this).jdMethod_if(1001);
        }
        AppMethodBeat.o(213650);
      }
    };
    this.chE = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(213653);
        TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
        c.e(c.this).unlinkToDeath(c.d(c.this), 0);
        c.b(c.this).jdMethod_if(1003);
        c.f(c.this);
        AppMethodBeat.o(213653);
      }
    };
    this.chA = b.Kf();
    this.mContext = paramContext;
    AppMethodBeat.o(213654);
  }
  
  public final int a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(213662);
    if (parama == null)
    {
      AppMethodBeat.o(213662);
      return 1807;
    }
    try
    {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "parame.getParameName() = %s, parameValue = %d", new Object[] { parama.chJ, Integer.valueOf(paramInt) });
      if ((this.chC != null) && (this.chB))
      {
        paramInt = this.chC.t(parama.chJ, paramInt);
        AppMethodBeat.o(213662);
        return paramInt;
      }
    }
    catch (RemoteException parama)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", new Object[] { parama.getMessage() });
      AppMethodBeat.o(213662);
    }
    return -2;
  }
  
  public final int bV(boolean paramBoolean)
  {
    AppMethodBeat.i(213659);
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature, enable = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    try
    {
      if ((this.chC != null) && (this.chB))
      {
        int i = this.chC.bV(paramBoolean);
        AppMethodBeat.o(213659);
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(213659);
    }
    return -2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(213657);
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.chB) });
    if (this.chB)
    {
      this.chB = false;
      b.unbindService(this.mContext, this.mConnection);
    }
    AppMethodBeat.o(213657);
  }
  
  protected final void initialize(Context paramContext)
  {
    AppMethodBeat.i(213655);
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize");
    if (paramContext == null)
    {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, context is null");
      AppMethodBeat.o(213655);
      return;
    }
    if (!b.aq(paramContext))
    {
      this.chA.jdMethod_if(2);
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, not install AudioEngine");
      AppMethodBeat.o(213655);
      return;
    }
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "bindService");
    if ((this.chA != null) && (!this.chB)) {
      b.a(paramContext, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
    }
    AppMethodBeat.o(213655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.huawei.a.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */