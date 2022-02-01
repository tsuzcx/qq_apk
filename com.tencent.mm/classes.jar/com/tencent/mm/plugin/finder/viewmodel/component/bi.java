package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.ui.component.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderVideoRecycler;", "Lcom/tencent/mm/ui/component/ApiUIC;", "addOnHeadsetStateChangeListener", "", "listener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "getFocusView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "getOrCreate", "parent", "Landroid/view/ViewGroup;", "finderVideo", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "completedTo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "videoView", "make", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "isPreInflate", "", "markRecentFocusView", "pauseAllVideo", "filter", "pauseAndRecycle", "isForceRemove", "isTryKeep", "pauseFocusVideo", "releaseUnFocusView", "removeOnHeadsetStateChangeListener", "resumeFocusVideo", "setAttachVideoMute", "isMute", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bi
  extends c
{
  public abstract void a(ViewGroup paramViewGroup, x paramx, b<? super t, ah> paramb);
  
  public abstract void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, boolean paramBoolean);
  
  public abstract void a(t paramt);
  
  public abstract void a(HeadsetReceiver.b paramb);
  
  public abstract void aw(b<? super t, Boolean> paramb);
  
  public abstract void b(HeadsetReceiver.b paramb);
  
  public abstract void fpt();
  
  public abstract void fpu();
  
  public abstract void hw(Context paramContext);
  
  public abstract void hx(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bi
 * JD-Core Version:    0.7.0.1
 */