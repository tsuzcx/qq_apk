package com.tencent.mm.media.g;

import android.graphics.Bitmap;
import d.g.a.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/mix/FrameSeeker;", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "destroy", "", "invoke", "pts", "seekFrame", "timeMs", "start", "plugin-mediaeditor_release"})
public abstract interface e
  extends b<Long, Bitmap>
{
  public abstract void destroy();
  
  public abstract Bitmap pr(long paramLong);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.g.e
 * JD-Core Version:    0.7.0.1
 */