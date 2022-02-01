package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.ui.component.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "Lcom/tencent/mm/ui/component/ApiUIC;", "addOnHeadsetStateChangeListener", "", "listener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "completedTo", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Lkotlin/ParameterName;", "name", "videoView", "make", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "isPreInflate", "", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "context", "Landroid/content/Context;", "removeOnHeadsetStateChangeListener", "resumeFocusVideo", "plugin-finder-base_release"})
public abstract interface au
  extends a
{
  public abstract void Q(b<? super s, Boolean> paramb);
  
  public abstract void a(ViewGroup paramViewGroup, ac paramac, b<? super s, x> paramb);
  
  public abstract void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, boolean paramBoolean);
  
  public abstract void a(HeadsetReceiver.b paramb);
  
  public abstract void b(HeadsetReceiver.b paramb);
  
  public abstract void gb(Context paramContext);
  
  public abstract void gc(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.au
 * JD-Core Version:    0.7.0.1
 */