package com.tencent.mm.plugin.finder.live.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "", "name", "", "tag", "task", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "MSG_DISPATCH", "", "MSG_FINISH", "MSG_RUN", "TAG", "callback", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "finish", "", "getName", "()Ljava/lang/String;", "getTag", "workHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "finishTask", "", "isFinished", "removeTask", "tryRunTask", "delay", "", "(Ljava/lang/Long;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
{
  private final int CIB;
  private final int CIC;
  private final int MSG_FINISH;
  private final String TAG;
  private final MMHandler.Callback callback;
  volatile boolean hcg;
  private final String name;
  private final String tag;
  private final MMHandler workHandler;
  
  public ax()
  {
    this(null, null, 7);
  }
  
  private ax(String paramString, Runnable paramRunnable)
  {
    AppMethodBeat.i(360052);
    this.name = paramString;
    this.tag = null;
    this.TAG = "MicroMsg.SingleTaskLooper";
    this.CIC = 1;
    this.MSG_FINISH = 2;
    this.hcg = true;
    this.callback = new ax..ExternalSyntheticLambda0(this, paramRunnable);
    if (Util.isNullOrNil(this.tag)) {}
    for (paramString = new MMHandler(this.callback);; paramString = new MMHandler(this.tag, this.callback))
    {
      this.workHandler = paramString;
      AppMethodBeat.o(360052);
      return;
    }
  }
  
  private static final boolean a(ax paramax, Runnable paramRunnable, Message paramMessage)
  {
    AppMethodBeat.i(360071);
    s.u(paramax, "this$0");
    s.u(paramMessage, "it");
    int i = paramMessage.what;
    if (i == paramax.CIC) {
      if ((paramMessage.obj instanceof Long))
      {
        paramRunnable = paramMessage.obj;
        if (paramRunnable == null)
        {
          paramax = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
          AppMethodBeat.o(360071);
          throw paramax;
        }
        long l = ((Long)paramRunnable).longValue();
        Log.i(paramax.TAG, paramax.name + " MSG_DISPATCH finish:" + paramax.hcg + " delay:" + l);
        if (paramax.hcg)
        {
          paramax.workHandler.sendEmptyMessageDelayed(paramax.CIB, l);
          paramax.hcg = false;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(360071);
      return true;
      if (i == paramax.MSG_FINISH)
      {
        paramax.hcg = true;
        Log.i(paramax.TAG, paramax.name + " MSG_FINISH finish:" + paramax.hcg);
      }
      else if (i == paramax.CIB)
      {
        Log.i(paramax.TAG, paramax.name + " MSG_RUN finish:" + paramax.hcg);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
      else
      {
        Log.i(paramax.TAG, paramax.name + " invalid msg:" + paramMessage.what);
      }
    }
  }
  
  public final void emA()
  {
    AppMethodBeat.i(360107);
    Log.i(this.TAG, this.name + " finishTask isQuit:" + this.workHandler.isQuit());
    this.workHandler.sendEmptyMessage(this.MSG_FINISH);
    AppMethodBeat.o(360107);
  }
  
  public final void emB()
  {
    AppMethodBeat.i(360115);
    Log.i(this.TAG, s.X(this.name, " removeTask"));
    this.workHandler.removeCallbacksAndMessages(null);
    this.hcg = true;
    AppMethodBeat.o(360115);
  }
  
  public final void f(Long paramLong)
  {
    AppMethodBeat.i(360098);
    Log.i(this.TAG, this.name + " tryRunTask isQuit:" + this.workHandler.isQuit());
    this.workHandler.obtainMessage(this.CIC, paramLong).sendToTarget();
    AppMethodBeat.o(360098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ax
 * JD-Core Version:    0.7.0.1
 */