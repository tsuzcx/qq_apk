package com.tencent.mm.plugin.fav.ui.gallery;

import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.fav.ui.n.a;
import com.tencent.mm.sdk.platformtools.bk;

final class c$3
  extends RecyclerView.m
{
  private Runnable khx = new c.3.1(this);
  
  c$3(c paramc) {}
  
  private void gc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.khw.khi.removeCallbacks(this.khx);
      if (this.khw.khi.getVisibility() != 0)
      {
        this.khw.khi.clearAnimation();
        Animation localAnimation = AnimationUtils.loadAnimation(this.khw.bMV, n.a.fast_faded_in);
        this.khw.khi.setVisibility(0);
        this.khw.khi.startAnimation(localAnimation);
      }
      return;
    }
    this.khw.khi.removeCallbacks(this.khx);
    this.khw.khi.postDelayed(this.khx, 256L);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    Object localObject = (LinearLayoutManager)this.khw.khh.aRV();
    paramRecyclerView = (f)this.khw.khh.aRX();
    localObject = paramRecyclerView.rf(((LinearLayoutManager)localObject).gY());
    if (localObject == null) {
      return;
    }
    paramRecyclerView = paramRecyclerView.eL(((f.c)localObject).timeStamp);
    this.khw.khi.setText(bk.aM(paramRecyclerView, ""));
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    int i;
    if (1 == paramInt)
    {
      gc(true);
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.khw.dmY);
      c localc = this.khw;
      boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
      int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
      int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
      int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
      if (WXHardCoderJNI.hcMediaGalleryScrollThr)
      {
        i = Process.myTid();
        localc.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
      }
    }
    for (;;)
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        if ((((LinearLayoutManager)paramRecyclerView.getLayoutManager()).gY() == 0) && (!this.khw.khm)) {
          this.khw.khh.l(false, -1);
        }
        this.khw.khm = false;
        o.ON().bR(paramInt);
      }
      return;
      i = 0;
      break;
      if (paramInt == 0) {
        gc(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.3
 * JD-Core Version:    0.7.0.1
 */