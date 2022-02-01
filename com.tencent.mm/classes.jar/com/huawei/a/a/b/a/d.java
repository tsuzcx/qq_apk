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
  private static final List<Integer> dXT;
  private b dXI;
  private boolean dXJ;
  private IBinder dXL;
  private IBinder.DeathRecipient dXM;
  private com.huawei.a.a.a.a dXU;
  private ServiceConnection mConnection;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(208317);
    dXT = new ArrayList(0);
    AppMethodBeat.o(208317);
  }
  
  public d(Context paramContext, e parame)
  {
    AppMethodBeat.i(208260);
    this.mContext = null;
    this.dXU = null;
    this.dXJ = false;
    this.dXL = null;
    this.mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(208268);
        d.a(d.this, a.a.i(paramAnonymousIBinder));
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected");
        if (d.a(d.this) != null)
        {
          d.a(d.this, true);
          TXCLog.i("HwAudioKit.HwAudioKit", "onServiceConnected, mIHwAudioEngine is not null");
          d.b(d.this).lK(0);
          d.a(d.this, d.c(d.this).getPackageName(), "1.0.1");
          d.a(d.this, paramAnonymousIBinder);
        }
        AppMethodBeat.o(208268);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(208275);
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceDisconnected");
        d.a(d.this, null);
        d.a(d.this, false);
        d.b(d.this).lK(4);
        AppMethodBeat.o(208275);
      }
    };
    this.dXM = new IBinder.DeathRecipient()
    {
      public final void binderDied()
      {
        AppMethodBeat.i(208262);
        d.e(d.this).unlinkToDeath(d.d(d.this), 0);
        d.b(d.this).lK(6);
        TXCLog.e("HwAudioKit.HwAudioKit", "service binder died");
        d.f(d.this);
        AppMethodBeat.o(208262);
      }
    };
    this.dXI = b.akg();
    this.dXI.dXH = parame;
    this.mContext = paramContext;
    AppMethodBeat.o(208260);
  }
  
  public final boolean a(d.a parama)
  {
    AppMethodBeat.i(208324);
    if (parama == null)
    {
      AppMethodBeat.o(208324);
      return false;
    }
    TXCLog.i("HwAudioKit.HwAudioKit", "isFeatureSupported, type = %d", new Object[] { Integer.valueOf(parama.dXX) });
    try
    {
      if ((this.dXU != null) && (this.dXJ))
      {
        boolean bool = this.dXU.lJ(parama.dXX);
        AppMethodBeat.o(208324);
        return bool;
      }
    }
    catch (RemoteException parama)
    {
      TXCLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", new Object[] { parama.getMessage() });
      AppMethodBeat.o(208324);
    }
    return false;
  }
  
  public final <T extends a> T b(d.a parama)
  {
    AppMethodBeat.i(208325);
    if ((this.dXI != null) && (parama != null))
    {
      parama = b.a(parama.dXX, this.mContext);
      AppMethodBeat.o(208325);
      return parama;
    }
    AppMethodBeat.o(208325);
    return null;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(208322);
    TXCLog.i("HwAudioKit.HwAudioKit", "destroy, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.dXJ) });
    if (this.dXJ)
    {
      this.dXJ = false;
      b.unbindService(this.mContext, this.mConnection);
    }
    AppMethodBeat.o(208322);
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(208321);
    TXCLog.i("HwAudioKit.HwAudioKit", "initialize");
    if (this.mContext == null)
    {
      TXCLog.i("HwAudioKit.HwAudioKit", "mContext is null");
      this.dXI.lK(7);
      AppMethodBeat.o(208321);
      return;
    }
    if (!b.bb(this.mContext))
    {
      TXCLog.i("HwAudioKit.HwAudioKit", "not install AudioKitEngine");
      this.dXI.lK(2);
      AppMethodBeat.o(208321);
      return;
    }
    Context localContext = this.mContext;
    TXCLog.i("HwAudioKit.HwAudioKit", "bindService, mIsServiceConnected = %b", new Object[] { Boolean.valueOf(this.dXJ) });
    if ((this.dXI != null) && (!this.dXJ)) {
      b.a(localContext, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioEngineService");
    }
    AppMethodBeat.o(208321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.huawei.a.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */