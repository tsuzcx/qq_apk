package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "timeout", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;J)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "lastestTimestamp", "listViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/AbsListView;", "mUiHandler", "Landroid/os/Handler;", "getTimeout", "()J", "sendOnScroll", "", "listView", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "Companion", "plugin-expt_release"})
public final class b
  implements f
{
  public static final b.a wio;
  private final Handler mUiHandler;
  private final long timeout;
  final e whP;
  private long wim;
  private WeakReference<AbsListView> win;
  
  static
  {
    AppMethodBeat.i(256163);
    wio = new b.a((byte)0);
    AppMethodBeat.o(256163);
  }
  
  public b(e parame, long paramLong)
  {
    AppMethodBeat.i(256161);
    this.whP = parame;
    this.timeout = paramLong;
    this.win = null;
    this.wim = 0L;
    this.mUiHandler = ((Handler)new b(this, Looper.getMainLooper()));
    AppMethodBeat.o(256161);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(256156);
    if (this.win != null)
    {
      localObject = this.win;
      if (localObject == null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = (AbsListView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.win = new WeakReference(paramAbsListView);
      }
      AppMethodBeat.o(256156);
      return;
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256159);
    long l = System.currentTimeMillis();
    if (l - this.wim > this.timeout)
    {
      this.wim = l;
      if (this.win != null)
      {
        localObject = this.win;
        if (localObject == null) {
          break label111;
        }
      }
    }
    label111:
    for (Object localObject = (AbsListView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.win = new WeakReference(paramAbsListView);
      }
      paramAbsListView = Message.obtain();
      paramAbsListView.what = 100;
      paramAbsListView.arg1 = paramInt1;
      paramAbsListView.arg2 = paramInt2;
      this.mUiHandler.sendMessage(paramAbsListView);
      AppMethodBeat.o(256159);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling$mUiHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-expt_release"})
  public static final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(257492);
      p.k(paramMessage, "msg");
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      e locale;
      do
      {
        AppMethodBeat.o(257492);
        return;
        locale = this.wip.whP;
      } while (locale == null);
      Object localObject = b.a(this.wip);
      if (localObject != null) {}
      for (localObject = (AbsListView)((WeakReference)localObject).get();; localObject = null)
      {
        locale.c((AbsListView)localObject, paramMessage.arg1, paramMessage.arg2);
        AppMethodBeat.o(257492);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */