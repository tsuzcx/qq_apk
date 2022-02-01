package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.iw;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderGamePostEvent;", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "getActivity", "()Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGameEventListener
  extends IListener<iw>
{
  private final WeakReference<Activity> GgK;
  private final String TAG;
  
  public FinderGameEventListener(WeakReference<Activity> paramWeakReference)
  {
    super((q)f.hfK);
    AppMethodBeat.i(333190);
    this.GgK = paramWeakReference;
    this.TAG = "Finder.FinderGameEventListener";
    AppMethodBeat.o(333190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.FinderGameEventListener
 * JD-Core Version:    0.7.0.1
 */