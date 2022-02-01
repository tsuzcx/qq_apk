package com.tencent.mm.plugin.finder.live.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/SingleTaskLooper;", "", "name", "", "tag", "task", "Ljava/lang/Runnable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "MSG_DISPATCH", "", "MSG_FINISH", "MSG_RUN", "TAG", "callback", "Lcom/tencent/mm/sdk/platformtools/MMHandler$Callback;", "finish", "", "getName", "()Ljava/lang/String;", "getTag", "workHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "finishTask", "", "removeTask", "tryRunTask", "delay", "", "(Ljava/lang/Long;)V", "plugin-finder_release"})
public final class w
{
  final int MSG_FINISH;
  final String TAG;
  private final MMHandler.Callback callback;
  volatile boolean dgZ;
  final String name;
  private final String tag;
  final int ukk;
  final int ukl;
  final MMHandler workHandler;
  
  public w()
  {
    this(null, null, 7);
  }
  
  private w(String paramString, final Runnable paramRunnable)
  {
    AppMethodBeat.i(246288);
    this.name = paramString;
    this.tag = null;
    this.TAG = "MicroMsg.SingleTaskLooper";
    this.ukl = 1;
    this.MSG_FINISH = 2;
    this.dgZ = true;
    this.callback = ((MMHandler.Callback)new a(this, paramRunnable));
    if (Util.isNullOrNil(this.tag)) {}
    for (paramString = new MMHandler(this.callback);; paramString = new MMHandler(this.tag, this.callback))
    {
      this.workHandler = paramString;
      AppMethodBeat.o(246288);
      return;
    }
  }
  
  public final void dgD()
  {
    AppMethodBeat.i(246286);
    Log.i(this.TAG, this.name + " finishTask isQuit:" + this.workHandler.isQuit());
    if (!this.workHandler.isQuit()) {
      this.workHandler.sendEmptyMessage(this.MSG_FINISH);
    }
    AppMethodBeat.o(246286);
  }
  
  public final void dgE()
  {
    AppMethodBeat.i(246287);
    Log.i(this.TAG, this.name + " removeTask");
    this.workHandler.removeCallbacksAndMessages(null);
    this.workHandler.quit();
    this.dgZ = true;
    AppMethodBeat.o(246287);
  }
  
  public final void f(Long paramLong)
  {
    AppMethodBeat.i(246285);
    Log.i(this.TAG, this.name + " tryRunTask isQuit:" + this.workHandler.isQuit());
    if (!this.workHandler.isQuit()) {
      this.workHandler.obtainMessage(this.ukl, paramLong).sendToTarget();
    }
    AppMethodBeat.o(246285);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    a(w paramw, Runnable paramRunnable) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(246284);
      int i = paramMessage.what;
      if (i == this.ukm.ukl) {
        if ((paramMessage.obj instanceof Long))
        {
          paramMessage = paramMessage.obj;
          if (paramMessage == null)
          {
            paramMessage = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(246284);
            throw paramMessage;
          }
          long l = ((Long)paramMessage).longValue();
          Log.i(this.ukm.TAG, this.ukm.name + " MSG_DISPATCH finish:" + this.ukm.dgZ + " delay:" + l);
          if (this.ukm.dgZ)
          {
            this.ukm.workHandler.sendEmptyMessageDelayed(this.ukm.ukk, l);
            this.ukm.dgZ = false;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(246284);
        return true;
        if (i == this.ukm.MSG_FINISH)
        {
          this.ukm.dgZ = true;
          Log.i(this.ukm.TAG, this.ukm.name + " MSG_FINISH finish:" + this.ukm.dgZ);
        }
        else if (i == this.ukm.ukk)
        {
          Log.i(this.ukm.TAG, this.ukm.name + " MSG_RUN finish:" + this.ukm.dgZ);
          paramMessage = paramRunnable;
          if (paramMessage != null) {
            paramMessage.run();
          }
        }
        else
        {
          Log.i(this.ukm.TAG, this.ukm.name + " invalid msg:" + paramMessage.what);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.w
 * JD-Core Version:    0.7.0.1
 */