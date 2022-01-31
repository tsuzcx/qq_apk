package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.IShakeCheckingManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;

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
    AppMethodBeat.i(144404);
    this.TAG = "KindaShakeCheckingManager";
    this.isStartShake = false;
    this.isInvokeCallback = false;
    this.delayNotifyMs = 3000;
    this.delayNofiyRunnable = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(144402);
        if ((!KindaShakeCheckingManager.this.isInvokeCallback) && (KindaShakeCheckingManager.this.delayNotifyCallback != null)) {
          KindaShakeCheckingManager.this.delayNotifyCallback.call();
        }
        AppMethodBeat.o(144402);
      }
    };
    AppMethodBeat.o(144404);
  }
  
  public void playShakeMatch(boolean paramBoolean)
  {
    AppMethodBeat.i(144408);
    if (paramBoolean)
    {
      ay.ax(KindaContext.get(), 2131303605);
      AppMethodBeat.o(144408);
      return;
    }
    ay.ax(KindaContext.get(), 2131303613);
    AppMethodBeat.o(144408);
  }
  
  public void playShakeSound()
  {
    AppMethodBeat.i(144407);
    ay.ax(KindaContext.get(), 2131303636);
    AppMethodBeat.o(144407);
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
    AppMethodBeat.i(144405);
    KindaContext.get();
    this.shakeSensor = new d();
    this.shakeSensor.a(new KindaShakeCheckingManager.2(this));
    this.lastShakeTime = bo.yB();
    al.ae(this.delayNofiyRunnable);
    al.p(this.delayNofiyRunnable, this.delayNotifyMs);
    AppMethodBeat.o(144405);
  }
  
  public void stopCheck()
  {
    AppMethodBeat.i(144406);
    if (this.shakeSensor != null)
    {
      this.shakeSensor.bjf();
      this.shakeSensor = null;
    }
    this.isInvokeCallback = false;
    this.isStartShake = false;
    al.ae(this.delayNofiyRunnable);
    AppMethodBeat.o(144406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaShakeCheckingManager
 * JD-Core Version:    0.7.0.1
 */