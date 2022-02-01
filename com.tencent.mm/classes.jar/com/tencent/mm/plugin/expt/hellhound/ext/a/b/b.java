package com.tencent.mm.plugin.expt.hellhound.ext.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "timeout", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;J)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "lastestTimestamp", "listViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/AbsListView;", "mUiHandler", "Landroid/os/Handler;", "getTimeout", "()J", "sendOnScroll", "", "listView", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements e
{
  public static final b.a zEp;
  private final Handler mUiHandler;
  private final long timeout;
  final d zDM;
  private long zEq;
  private WeakReference<AbsListView> zEr;
  
  static
  {
    AppMethodBeat.i(300143);
    zEp = new b.a((byte)0);
    AppMethodBeat.o(300143);
  }
  
  public b(d paramd, long paramLong)
  {
    AppMethodBeat.i(300135);
    this.zDM = paramd;
    this.timeout = paramLong;
    this.zEr = null;
    this.zEq = 0L;
    this.mUiHandler = ((Handler)new b(this, Looper.getMainLooper()));
    AppMethodBeat.o(300135);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(300147);
    if (this.zEr != null)
    {
      localObject = this.zEr;
      if (localObject != null) {
        break label45;
      }
    }
    label45:
    for (Object localObject = null;; localObject = (AbsListView)((WeakReference)localObject).get())
    {
      if (localObject == null) {
        this.zEr = new WeakReference(paramAbsListView);
      }
      AppMethodBeat.o(300147);
      return;
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(300151);
    long l = System.currentTimeMillis();
    if (l - this.zEq > this.timeout)
    {
      this.zEq = l;
      if (this.zEr != null)
      {
        localObject = this.zEr;
        if (localObject != null) {
          break label104;
        }
      }
    }
    label104:
    for (Object localObject = null;; localObject = (AbsListView)((WeakReference)localObject).get())
    {
      if (localObject == null) {
        this.zEr = new WeakReference(paramAbsListView);
      }
      paramAbsListView = Message.obtain();
      paramAbsListView.what = 100;
      paramAbsListView.arg1 = paramInt1;
      paramAbsListView.arg2 = paramInt2;
      this.mUiHandler.sendMessage(paramAbsListView);
      AppMethodBeat.o(300151);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellSampling$mUiHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends Handler
  {
    b(b paramb, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(300149);
      s.u(paramMessage, "msg");
      super.handleMessage(paramMessage);
      d locald;
      if (paramMessage.what == 100)
      {
        locald = this.zEs.zDM;
        if (locald != null)
        {
          localObject = b.a(this.zEs);
          if (localObject != null) {
            break label72;
          }
        }
      }
      label72:
      for (Object localObject = null;; localObject = (AbsListView)((WeakReference)localObject).get())
      {
        locald.c((AbsListView)localObject, paramMessage.arg1, paramMessage.arg2);
        AppMethodBeat.o(300149);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.b.b
 * JD-Core Version:    0.7.0.1
 */