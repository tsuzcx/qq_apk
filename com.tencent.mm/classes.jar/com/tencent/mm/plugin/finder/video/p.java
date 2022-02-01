package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public abstract interface p
{
  public abstract void a(a<x> parama1, a<x> parama2, b<? super Long, x> paramb);
  
  public abstract void destroy();
  
  public abstract Bitmap getBitmap();
  
  public abstract View getView();
  
  public abstract void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.p
 * JD-Core Version:    0.7.0.1
 */