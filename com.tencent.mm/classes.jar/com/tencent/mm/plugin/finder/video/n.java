package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import android.view.View;
import d.g.a.a;
import d.g.a.b;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public abstract interface n
{
  public abstract void a(a<y> parama1, a<y> parama2, b<? super Long, y> paramb);
  
  public abstract void destroy();
  
  public abstract Bitmap getBitmap();
  
  public abstract View getView();
  
  public abstract void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.n
 * JD-Core Version:    0.7.0.1
 */