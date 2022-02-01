package com.huawei.a.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.huawei.a.a.a.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class d
{
  private static final List<Integer> chL;
  private b chA;
  private boolean chB;
  private IBinder chD;
  private IBinder.DeathRecipient chE;
  private com.huawei.a.a.a.a chM;
  private ServiceConnection mConnection;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(213631);
    chL = new ArrayList(0);
    AppMethodBeat.o(213631);
  }
  
  public d(Context paramContext, e parame)
  {
    AppMethodBeat.i(213602);
    this.mContext = null;
    this.chM = null;
    this.chB = false;
    this.chD = null;
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(213651);
        d.a(d.this, a.a.h(paramAnonymousIBinder));
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected");
        if (d.a(d.this) != null)
        {
          d.a(d.this, true);
          TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected, mIHwAudioEngine is not null");
          d.b(d.this).jdMethod_if(0);
          d.a(d.this, d.c(d.this).getPackageName(), "1.0.1");
          d.a(d.this, paramAnonymousIBinder);
        }
        AppMethodBeat.o(213651);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(213652);
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceDisconnected");
        d.a(d.this, null);
        d.a(d.this, false);
        d.b(d.this).jdMethod_if(4);
        AppMethodBeat.o(213652);
      }
    };
    this.chE = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(213589);
        d.e(d.this).unlinkToDeath(d.d(d.this), 0);
        d.b(d.this).jdMethod_if(6);
        TXCLog.e("HwAudioKit.HwAudioKit", "service binder died");
        d.f(d.this);
        AppMethodBeat.o(213589);
      }
    };
    this.chA = b.Kf();
    this.chA.chz = parame;
    this.mContext = paramContext;
    AppMethodBeat.o(213602);
  }
  
  public final boolean a(d.a parama)
  {
    AppMethodBeat.i(213609);
    if (parama == null)
    {
      AppMethodBeat.o(213609);
      return false;
    }
    TXCLog.i("HwAudioKit.HwAudioKit", "isFeatureSupported, type = %d", new Object[] { Integer.valueOf(parama.chP) });
    try
    {
      if ((this.chM != null) && (this.chB))
      {
        boolean bool = this.chM.ie(parama.chP);
        AppMethodBeat.o(213609);
        return bool;
      }
    }
    catch (RemoteException parama)
    {
      TXCLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { parama.getMessage() });
      AppMethodBeat.o(213609);
    }
    return false;
  }
  
  public final <T extends a> T b(d.a parama)
  {
    AppMethodBeat.i(213613);
    if ((this.chA != null) && (parama != null))
    {
      parama = b.a(parama.chP, this.mContext);
      AppMethodBeat.o(213613);
      return parama;
    }
    AppMethodBeat.o(213613);
    return null;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(213607);
    TXCLog.i("HwAudioKit.HwAudioKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.chB) });
    if (this.chB)
    {
      this.chB = false;
      b.unbindService(this.mContext, this.mConnection);
    }
    AppMethodBeat.o(213607);
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(213605);
    TXCLog.i("HwAudioKit.HwAudioKit", "initialize");
    if (this.mContext == null)
    {
      TXCLog.i("HwAudioKit.HwAudioKit", "mContext is null");
      this.chA.jdMethod_if(7);
      AppMethodBeat.o(213605);
      return;
    }
    if (!b.aq(this.mContext))
    {
      TXCLog.i("HwAudioKit.HwAudioKit", "not install AudioKitEngine");
      this.chA.jdMethod_if(2);
      AppMethodBeat.o(213605);
      return;
    }
    Context localContext = this.mContext;
    TXCLog.i("HwAudioKit.HwAudioKit", "bindService, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.chB) });
    if ((this.chA != null) && (!this.chB)) {
      b.a(localContext, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioEngineService");
    }
    AppMethodBeat.o(213605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.huawei.a.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */