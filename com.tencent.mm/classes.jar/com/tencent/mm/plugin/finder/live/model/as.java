package com.tencent.mm.plugin.finder.live.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "", "name", "", "tag", "task", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "MSG_DISPATCH", "", "MSG_FINISH", "MSG_RUN", "TAG", "callback", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "finish", "", "getName", "()Ljava/lang/String;", "getTag", "workHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "finishTask", "", "isFinished", "removeTask", "tryRunTask", "delay", "", "(Ljava/lang/Long;)V", "plugin-finder_release"})
public final class as
{
  final int MSG_FINISH;
  final String TAG;
  private final MMHandler.Callback callback;
  volatile boolean eYG;
  final String name;
  private final String tag;
  final MMHandler workHandler;
  final int yiv;
  final int yiw;
  
  public as()
  {
    this(null, null, 7);
  }
  
  private as(String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(289723);
    this.name = paramString;
    this.tag = null;
    this.TAG = "MicroMsg.SingleTaskLooper";
    this.yiw = 1;
    this.MSG_FINISH = 2;
    this.eYG = true;
    this.callback = ((MMHandler.Callback)new a(this, paramRunnable));
    if (Util.isNullOrNil(this.tag)) {}
    for (paramString = new MMHandler(this.callback);; paramString = new MMHandler(this.tag, this.callback))
    {
      this.workHandler = paramString;
      AppMethodBeat.o(289723);
      return;
    }
  }
  
  public final void dzU()
  {
    AppMethodBeat.i(289721);
    Log.i(this.TAG, this.name + " finishTask isQuit:" + this.workHandler.isQuit());
    this.workHandler.sendEmptyMessage(this.MSG_FINISH);
    AppMethodBeat.o(289721);
  }
  
  public final void dzV()
  {
    AppMethodBeat.i(289722);
    Log.i(this.TAG, this.name + " removeTask");
    this.workHandler.removeCallbacksAndMessages(null);
    this.eYG = true;
    AppMethodBeat.o(289722);
  }
  
  public final void f(Long paramLong)
  {
    AppMethodBeat.i(289720);
    Log.i(this.TAG, this.name + " tryRunTask isQuit:" + this.workHandler.isQuit());
    this.workHandler.obtainMessage(this.yiw, paramLong).sendToTarget();
    AppMethodBeat.o(289720);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    a(as paramas, Runnable paramRunnable) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(290149);
      int i = paramMessage.what;
      if (i == this.yix.yiw) {
        if ((paramMessage.obj instanceof Long))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(290149);
            throw paramMessage;
          }
          long l = ((Long)paramMessage).longValue();
          Log.i(this.yix.TAG, this.yix.name + " MSG_DISPATCH finish:" + this.yix.eYG + " delay:" + l);
          if (this.yix.eYG)
          {
            this.yix.workHandler.sendEmptyMessageDelayed(this.yix.yiv, l);
            this.yix.eYG = false;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(290149);
        return true;
        if (i == this.yix.MSG_FINISH)
        {
          this.yix.eYG = true;
          Log.i(this.yix.TAG, this.yix.name + " MSG_FINISH finish:" + this.yix.eYG);
        }
        else if (i == this.yix.yiv)
        {
          Log.i(this.yix.TAG, this.yix.name + " MSG_RUN finish:" + this.yix.eYG);
          paramMessage = paramRunnable;
          if (paramMessage != null) {
            paramMessage.run();
          }
        }
        else
        {
          Log.i(this.yix.TAG, this.yix.name + " invalid msg:" + paramMessage.what);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.as
 * JD-Core Version:    0.7.0.1
 */