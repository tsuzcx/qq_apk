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
  private b dXI;
  private boolean dXJ;
  private com.huawei.a.a.a.b dXK;
  private IBinder dXL;
  private IBinder.DeathRecipient dXM;
  private ServiceConnection mConnection;
  private Context mContext;
  
  protected c(Context paramContext)
  {
    AppMethodBeat.i(208258);
    this.dXI = null;
    this.dXJ = false;
    this.dXL = null;
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(208252);
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceConnected");
        c.a(c.this, b.a.j(paramAnonymousIBinder));
        if (c.a(c.this) != null)
        {
          c.a(c.this, true);
          c.b(c.this).lK(1000);
          c.a(c.this, c.c(c.this).getPackageName());
          c.a(c.this, paramAnonymousIBinder);
        }
        AppMethodBeat.o(208252);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(208256);
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceDisconnected");
        c.a(c.this, false);
        if (c.b(c.this) != null) {
          c.b(c.this).lK(1001);
        }
        AppMethodBeat.o(208256);
      }
    };
    this.dXM = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(208251);
        TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
        c.e(c.this).unlinkToDeath(c.d(c.this), 0);
        c.b(c.this).lK(1003);
        c.f(c.this);
        AppMethodBeat.o(208251);
      }
    };
    this.dXI = b.akg();
    this.mContext = paramContext;
    AppMethodBeat.o(208258);
  }
  
  public final int a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(208319);
    if (parama == null)
    {
      AppMethodBeat.o(208319);
      return 1807;
    }
    try
    {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "parame.getParameName() = %s, parameValue = %d", new Object[] { parama.dXR, Integer.valueOf(paramInt) });
      if ((this.dXK != null) && (this.dXJ))
      {
        paramInt = this.dXK.A(parama.dXR, paramInt);
        AppMethodBeat.o(208319);
        return paramInt;
      }
    }
    catch (RemoteException parama)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", new Object[] { parama.getMessage() });
      AppMethodBeat.o(208319);
    }
    return -2;
  }
  
  public final int cA(boolean paramBoolean)
  {
    AppMethodBeat.i(208316);
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature, enable = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    try
    {
      if ((this.dXK != null) && (this.dXJ))
      {
        int i = this.dXK.cA(paramBoolean);
        AppMethodBeat.o(208316);
        return i;
      }
    }
    catch (RemoteException localRemoteException)
    {
      TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", new Object[] { localRemoteException.getMessage() });
      AppMethodBeat.o(208316);
    }
    return -2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(208313);
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.dXJ) });
    if (this.dXJ)
    {
      this.dXJ = false;
      b.unbindService(this.mContext, this.mConnection);
    }
    AppMethodBeat.o(208313);
  }
  
  protected final void initialize(Context paramContext)
  {
    AppMethodBeat.i(208310);
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize");
    if (paramContext == null)
    {
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, context is null");
      AppMethodBeat.o(208310);
      return;
    }
    if (!b.bb(paramContext))
    {
      this.dXI.lK(2);
      TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "initialize, not install AudioEngine");
      AppMethodBeat.o(208310);
      return;
    }
    TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "bindService");
    if ((this.dXI != null) && (!this.dXJ)) {
      b.a(paramContext, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
    }
    AppMethodBeat.o(208310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.huawei.a.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */