package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ii;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderGamePostEvent;", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "getActivity", "()Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-finder_release"})
public final class n
  extends IListener<ii>
{
  private final WeakReference<Activity> Bzx;
  private final String TAG;
  
  public n(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(293272);
    this.Bzx = paramWeakReference;
    this.TAG = "Finder.FinderGameEventListener";
    AppMethodBeat.o(293272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n
 * JD-Core Version:    0.7.0.1
 */