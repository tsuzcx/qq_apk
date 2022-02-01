package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.IShakeCheckingManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.pluginsdk.j.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;

public class KindaShakeCheckingManager
  implements IShakeCheckingManager
{
  private static final int CONTINUE_SHAKE_INTERVAL = 80;
  private static final int FIRST_SHAKE_INTERVAL = 1200;
  private final String TAG;
  private Runnable delayNofiyRunnable;
  private VoidCallback delayNotifyCallback;
  private int delayNotifyMs;
  private boolean isInvokeCallback;
  private boolean isStartShake;
  private long lastShakeTime;
  private VoidCallback shakeCallBack;
  private d shakeSensor;
  
  public KindaShakeCheckingManager()
  {
    AppMethodBeat.i(18511);
    this.TAG = "KindaShakeCheckingManager";
    this.isStartShake = false;
    this.isInvokeCallback = false;
    this.delayNotifyMs = 3000;
    this.delayNofiyRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18509);
        if ((!KindaShakeCheckingManager.this.isInvokeCallback) && (KindaShakeCheckingManager.this.delayNotifyCallback != null)) {
          KindaShakeCheckingManager.this.delayNotifyCallback.call();
        }
        AppMethodBeat.o(18509);
      }
    };
    AppMethodBeat.o(18511);
  }
  
  public void playShakeMatch(boolean paramBoolean)
  {
    AppMethodBeat.i(18515);
    if (paramBoolean)
    {
      bd.az(KindaContext.get(), 2131763587);
      AppMethodBeat.o(18515);
      return;
    }
    bd.az(KindaContext.get(), 2131763595);
    AppMethodBeat.o(18515);
  }
  
  public void playShakeSound()
  {
    AppMethodBeat.i(18514);
    bd.az(KindaContext.get(), 2131763618);
    AppMethodBeat.o(18514);
  }
  
  public void setDelayNotifyCallBackImpl(VoidCallback paramVoidCallback, int paramInt)
  {
    this.delayNotifyCallback = paramVoidCallback;
    this.delayNotifyMs = paramInt;
  }
  
  public void setOnShakeCallBackImpl(VoidCallback paramVoidCallback)
  {
    this.shakeCallBack = paramVoidCallback;
  }
  
  public void startCheck()
  {
    AppMethodBeat.i(18512);
    KindaContext.get();
    this.shakeSensor = new d();
    this.shakeSensor.a(new d.a()
    {
      public void onRelease() {}
      
      public void onShake(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(18510);
        ad.i("KindaShakeCheckingManager", "onShake");
        long l = bt.aS(KindaShakeCheckingManager.this.lastShakeTime);
        if (!KindaShakeCheckingManager.this.isStartShake)
        {
          if (l < 1200L) {
            AppMethodBeat.o(18510);
          }
        }
        else if (l < 80L)
        {
          AppMethodBeat.o(18510);
          return;
        }
        KindaShakeCheckingManager.access$202(KindaShakeCheckingManager.this, bt.GC());
        KindaShakeCheckingManager.access$302(KindaShakeCheckingManager.this, true);
        if (!KindaShakeCheckingManager.this.isInvokeCallback)
        {
          KindaShakeCheckingManager.access$002(KindaShakeCheckingManager.this, true);
          if (KindaShakeCheckingManager.this.shakeCallBack != null) {
            KindaShakeCheckingManager.this.shakeCallBack.call();
          }
        }
        AppMethodBeat.o(18510);
      }
    });
    this.lastShakeTime = bt.GC();
    aq.az(this.delayNofiyRunnable);
    aq.n(this.delayNofiyRunnable, this.delayNotifyMs);
    AppMethodBeat.o(18512);
  }
  
  public void stopCheck()
  {
    AppMethodBeat.i(18513);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bQk();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    aq.az(this.delayNofiyRunnable);
    AppMethodBeat.o(18513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaShakeCheckingManager
 * JD-Core Version:    0.7.0.1
 */