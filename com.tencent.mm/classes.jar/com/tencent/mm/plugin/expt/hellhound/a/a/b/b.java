package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "timeout", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;J)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "lastestTimestamp", "listViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/AbsListView;", "mUiHandler", "Landroid/os/Handler;", "getTimeout", "()J", "sendOnScroll", "", "listView", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "Companion", "plugin-expt_release"})
public final class b
  implements f
{
  public static final a sCu;
  final e sBU;
  private long sCr;
  private WeakReference<AbsListView> sCs;
  private final Handler sCt;
  private final long timeout;
  
  static
  {
    AppMethodBeat.i(220801);
    sCu = new a((byte)0);
    AppMethodBeat.o(220801);
  }
  
  public b(e parame, long paramLong)
  {
    AppMethodBeat.i(220800);
    this.sBU = parame;
    this.timeout = paramLong;
    this.sCs = null;
    this.sCr = 0L;
    this.sCt = ((Handler)new b(this, Looper.getMainLooper()));
    AppMethodBeat.o(220800);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(220798);
    if (this.sCs != null)
    {
      localObject = this.sCs;
      if (localObject == null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = (AbsListView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.sCs = new WeakReference(paramAbsListView);
      }
      AppMethodBeat.o(220798);
      return;
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220799);
    long l = System.currentTimeMillis();
    if (l - this.sCr > this.timeout)
    {
      this.sCr = l;
      if (this.sCs != null)
      {
        localObject = this.sCs;
        if (localObject == null) {
          break label111;
        }
      }
    }
    label111:
    for (Object localObject = (AbsListView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject == null) {
        this.sCs = new WeakReference(paramAbsListView);
      }
      paramAbsListView = Message.obtain();
      paramAbsListView.what = 100;
      paramAbsListView.arg1 = paramInt1;
      paramAbsListView.arg2 = paramInt2;
      this.sCt.sendMessage(paramAbsListView);
      AppMethodBeat.o(220799);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "MSG_TIMEOUT", "", "plugin-expt_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling$mUiHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-expt_release"})
  public static final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(220797);
      p.h(paramMessage, "msg");
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      e locale;
      do
      {
        AppMethodBeat.o(220797);
        return;
        locale = this.sCv.sBU;
      } while (locale == null);
      Object localObject = b.a(this.sCv);
      if (localObject != null) {}
      for (localObject = (AbsListView)((WeakReference)localObject).get();; localObject = null)
      {
        locale.c((AbsListView)localObject, paramMessage.arg1, paramMessage.arg2);
        AppMethodBeat.o(220797);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */