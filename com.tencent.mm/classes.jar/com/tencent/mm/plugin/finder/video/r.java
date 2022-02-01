package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface r
{
  public abstract void a(a<ah> parama1, a<ah> parama2, b<? super Long, ah> paramb);
  
  public abstract void destroy();
  
  public abstract Bitmap getBitmap();
  
  public abstract View getView();
  
  public abstract void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.r
 * JD-Core Version:    0.7.0.1
 */